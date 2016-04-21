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

package com.liferay.portal.kernel.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the ListType service. Represents a row in the &quot;ListType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.ListTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.ListTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ListType
 * @see com.liferay.portal.model.impl.ListTypeImpl
 * @see com.liferay.portal.model.impl.ListTypeModelImpl
 * @generated
 */
@ProviderType
public interface ListTypeModel extends BaseModel<ListType>, MVCCModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a list type model instance should use the {@link ListType} interface instead.
	 */

	/**
	 * Returns the primary key of this list type.
	 *
	 * @return the primary key of this list type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this list type.
	 *
	 * @param primaryKey the primary key of this list type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this list type.
	 *
	 * @return the mvcc version of this list type
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this list type.
	 *
	 * @param mvccVersion the mvcc version of this list type
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the list type ID of this list type.
	 *
	 * @return the list type ID of this list type
	 */
	public long getListTypeId();

	/**
	 * Sets the list type ID of this list type.
	 *
	 * @param listTypeId the list type ID of this list type
	 */
	public void setListTypeId(long listTypeId);

	/**
	 * Returns the name of this list type.
	 *
	 * @return the name of this list type
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this list type.
	 *
	 * @param name the name of this list type
	 */
	public void setName(String name);

	/**
	 * Returns the type of this list type.
	 *
	 * @return the type of this list type
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this list type.
	 *
	 * @param type the type of this list type
	 */
	public void setType(String type);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ListType listType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ListType> toCacheModel();

	@Override
	public ListType toEscapedModel();

	@Override
	public ListType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}