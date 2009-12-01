/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.RegionSoap;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="RegionModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the Region table in the
 * database.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       RegionImpl
 * @see       com.liferay.portal.model.Region
 * @see       com.liferay.portal.model.RegionModel
 * @generated
 */
public class RegionModelImpl extends BaseModelImpl<Region> {
	public static final String TABLE_NAME = "Region";
	public static final Object[][] TABLE_COLUMNS = {
			{ "regionId", new Integer(Types.BIGINT) },
			{ "countryId", new Integer(Types.BIGINT) },
			{ "regionCode", new Integer(Types.VARCHAR) },
			{ "name", new Integer(Types.VARCHAR) },
			{ "active_", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table Region (regionId LONG not null primary key,countryId LONG,regionCode VARCHAR(75) null,name VARCHAR(75) null,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Region";
	public static final String ORDER_BY_JPQL = " ORDER BY region.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Region.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.Region"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.Region"),
			true);

	public static Region toModel(RegionSoap soapModel) {
		Region model = new RegionImpl();

		model.setRegionId(soapModel.getRegionId());
		model.setCountryId(soapModel.getCountryId());
		model.setRegionCode(soapModel.getRegionCode());
		model.setName(soapModel.getName());
		model.setActive(soapModel.getActive());

		return model;
	}

	public static List<Region> toModels(RegionSoap[] soapModels) {
		List<Region> models = new ArrayList<Region>(soapModels.length);

		for (RegionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.Region"));

	public RegionModelImpl() {
	}

	public long getPrimaryKey() {
		return _regionId;
	}

	public void setPrimaryKey(long pk) {
		setRegionId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_regionId);
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public String getRegionCode() {
		return GetterUtil.getString(_regionCode);
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Region toEscapedModel() {
		if (isEscapedModel()) {
			return (Region)this;
		}
		else {
			Region model = new RegionImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setRegionId(getRegionId());
			model.setCountryId(getCountryId());
			model.setRegionCode(HtmlUtil.escape(getRegionCode()));
			model.setName(HtmlUtil.escape(getName()));
			model.setActive(getActive());

			model = (Region)Proxy.newProxyInstance(Region.class.getClassLoader(),
					new Class[] { Region.class }, new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(Region.class.getName(),
					getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		RegionImpl clone = new RegionImpl();

		clone.setRegionId(getRegionId());
		clone.setCountryId(getCountryId());
		clone.setRegionCode(getRegionCode());
		clone.setName(getName());
		clone.setActive(getActive());

		return clone;
	}

	public int compareTo(Region region) {
		int value = 0;

		value = getName().compareTo(region.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Region region = null;

		try {
			region = (Region)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = region.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{regionId=");
		sb.append(getRegionId());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.Region");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _regionId;
	private long _countryId;
	private String _regionCode;
	private String _name;
	private boolean _active;
	private transient ExpandoBridge _expandoBridge;
}