/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.spring.extender.internal.hibernate.session;

import com.liferay.portal.dao.orm.hibernate.PortletSessionFactoryImpl;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.internal.classloader.BundleResolverClassLoader;
import com.liferay.portal.spring.extender.internal.context.ModuleApplicationContext;
import com.liferay.portal.spring.extender.internal.hibernate.configuration.ModuleHibernateConfiguration;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Dictionary;
import java.util.Map;

/**
 * @author Miguel Pastor
 */
public class ModuleSessionFactory
	extends PortletSessionFactoryImpl
	implements
		ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(
		ContextRefreshedEvent contextRefreshedEvent) {

		ApplicationContext applicationContext =
			contextRefreshedEvent.getApplicationContext();

		ModuleApplicationContext moduleApplicationContext =
			(ModuleApplicationContext)applicationContext;

		BundleContext bundleContext =
			moduleApplicationContext.getBundleContext();

		Bundle bundle = bundleContext.getBundle();

		Dictionary<String, String> headers = bundle.getHeaders();

		String externalDataSourceName = headers.get(
			"Liferay-External-Data-Source-Name");

		if (Validator.isNull(externalDataSourceName)) {
			DataSource externalDataSource =
				(DataSource)applicationContext.getBean("dataSourceName");

			setDataSource(externalDataSource);

			Map<String, BasePersistenceImpl> beanPersistenceImpls =
				applicationContext.getBeansOfType(BasePersistenceImpl.class);


			for (String name : beanPersistenceImpls.keySet()) {
				BasePersistenceImpl<?> beanPersistenceImpl =
					beanPersistenceImpls.get(name);

				if (beanPersistenceImpl.getDataSource() == externalDataSource) {
					beanPersistenceImpl.setSessionFactory(this);
				}
			}
		}
	}

	@Override
	public ClassLoader getSessionFactoryClassLoader() {
		return _classLoader;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
		throws BeansException {

		ModuleApplicationContext moduleApplicationContext =
			(ModuleApplicationContext)applicationContext;

		BundleContext bundleContext =
			moduleApplicationContext.getBundleContext();

		_classLoader = new BundleResolverClassLoader(bundleContext.getBundle());

		setSessionFactoryClassLoader(_classLoader);
	}

	@Override
	protected SessionFactory createSessionFactory(DataSource dataSource) {
		ModuleHibernateConfiguration moduleHibernateConfiguration =
			new ModuleHibernateConfiguration(_classLoader);

		moduleHibernateConfiguration.setDataSource(dataSource);

		try {
			return moduleHibernateConfiguration.buildSessionFactory();
		}
		catch (Exception e) {
			return null;
		}
	}

	private ClassLoader _classLoader;

}