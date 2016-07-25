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

package com.liferay.portal.spring.extender.internal.hibernate.configuration;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.internal.context.ModuleApplicationContext;
import com.liferay.portal.spring.hibernate.PortletHibernateConfiguration;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.sql.DataSource;
import java.util.Dictionary;

/**
 * @author Miguel Pastor
 */
public class ModuleHibernateConfiguration
	extends PortletHibernateConfiguration
	implements ApplicationContextAware,
		ApplicationListener<ContextRefreshedEvent> {

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
		}
	}

	public ModuleHibernateConfiguration() {
		this(null);
	}

	public ModuleHibernateConfiguration(ClassLoader classLoader) {
		_classLoader = classLoader;

		setMvccEnabled(false);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
		throws BeansException {

		_classLoader = applicationContext.getClassLoader();
	}

	@Override
	protected ClassLoader getConfigurationClassLoader() {
		return _classLoader;
	}

	@Override
	protected String[] getConfigurationResources() {
		return new String[] {"META-INF/module-hbm.xml"};
	}

	private ClassLoader _classLoader;

}