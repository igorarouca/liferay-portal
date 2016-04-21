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

package com.liferay.message.boards.kernel.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ContainerModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.trash.TrashHandler;

import com.liferay.trash.kernel.model.TrashEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MBCategory service. Represents a row in the &quot;MBCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.messageboards.model.impl.MBCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.messageboards.model.impl.MBCategoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBCategory
 * @see com.liferay.portlet.messageboards.model.impl.MBCategoryImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBCategoryModelImpl
 * @generated
 */
@ProviderType
public interface MBCategoryModel extends BaseModel<MBCategory>, ContainerModel,
	ShardedModel, StagedGroupedModel, TrashedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a message boards category model instance should use the {@link MBCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this message boards category.
	 *
	 * @return the primary key of this message boards category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this message boards category.
	 *
	 * @param primaryKey the primary key of this message boards category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this message boards category.
	 *
	 * @return the uuid of this message boards category
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this message boards category.
	 *
	 * @param uuid the uuid of this message boards category
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the category ID of this message boards category.
	 *
	 * @return the category ID of this message boards category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this message boards category.
	 *
	 * @param categoryId the category ID of this message boards category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the group ID of this message boards category.
	 *
	 * @return the group ID of this message boards category
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this message boards category.
	 *
	 * @param groupId the group ID of this message boards category
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this message boards category.
	 *
	 * @return the company ID of this message boards category
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this message boards category.
	 *
	 * @param companyId the company ID of this message boards category
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this message boards category.
	 *
	 * @return the user ID of this message boards category
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this message boards category.
	 *
	 * @param userId the user ID of this message boards category
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this message boards category.
	 *
	 * @return the user uuid of this message boards category
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this message boards category.
	 *
	 * @param userUuid the user uuid of this message boards category
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this message boards category.
	 *
	 * @return the user name of this message boards category
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this message boards category.
	 *
	 * @param userName the user name of this message boards category
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this message boards category.
	 *
	 * @return the create date of this message boards category
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this message boards category.
	 *
	 * @param createDate the create date of this message boards category
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this message boards category.
	 *
	 * @return the modified date of this message boards category
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this message boards category.
	 *
	 * @param modifiedDate the modified date of this message boards category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the parent category ID of this message boards category.
	 *
	 * @return the parent category ID of this message boards category
	 */
	public long getParentCategoryId();

	/**
	 * Sets the parent category ID of this message boards category.
	 *
	 * @param parentCategoryId the parent category ID of this message boards category
	 */
	public void setParentCategoryId(long parentCategoryId);

	/**
	 * Returns the name of this message boards category.
	 *
	 * @return the name of this message boards category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this message boards category.
	 *
	 * @param name the name of this message boards category
	 */
	public void setName(String name);

	/**
	 * Returns the description of this message boards category.
	 *
	 * @return the description of this message boards category
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this message boards category.
	 *
	 * @param description the description of this message boards category
	 */
	public void setDescription(String description);

	/**
	 * Returns the display style of this message boards category.
	 *
	 * @return the display style of this message boards category
	 */
	@AutoEscape
	public String getDisplayStyle();

	/**
	 * Sets the display style of this message boards category.
	 *
	 * @param displayStyle the display style of this message boards category
	 */
	public void setDisplayStyle(String displayStyle);

	/**
	 * Returns the thread count of this message boards category.
	 *
	 * @return the thread count of this message boards category
	 */
	public int getThreadCount();

	/**
	 * Sets the thread count of this message boards category.
	 *
	 * @param threadCount the thread count of this message boards category
	 */
	public void setThreadCount(int threadCount);

	/**
	 * Returns the message count of this message boards category.
	 *
	 * @return the message count of this message boards category
	 */
	public int getMessageCount();

	/**
	 * Sets the message count of this message boards category.
	 *
	 * @param messageCount the message count of this message boards category
	 */
	public void setMessageCount(int messageCount);

	/**
	 * Returns the last post date of this message boards category.
	 *
	 * @return the last post date of this message boards category
	 */
	public Date getLastPostDate();

	/**
	 * Sets the last post date of this message boards category.
	 *
	 * @param lastPostDate the last post date of this message boards category
	 */
	public void setLastPostDate(Date lastPostDate);

	/**
	 * Returns the last publish date of this message boards category.
	 *
	 * @return the last publish date of this message boards category
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this message boards category.
	 *
	 * @param lastPublishDate the last publish date of this message boards category
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this message boards category.
	 *
	 * @return the status of this message boards category
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this message boards category.
	 *
	 * @param status the status of this message boards category
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this message boards category.
	 *
	 * @return the status by user ID of this message boards category
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this message boards category.
	 *
	 * @param statusByUserId the status by user ID of this message boards category
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this message boards category.
	 *
	 * @return the status by user uuid of this message boards category
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this message boards category.
	 *
	 * @param statusByUserUuid the status by user uuid of this message boards category
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this message boards category.
	 *
	 * @return the status by user name of this message boards category
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this message boards category.
	 *
	 * @param statusByUserName the status by user name of this message boards category
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this message boards category.
	 *
	 * @return the status date of this message boards category
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this message boards category.
	 *
	 * @param statusDate the status date of this message boards category
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the trash entry created when this message boards category was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this message boards category.
	 *
	 * @return the trash entry created when this message boards category was moved to the Recycle Bin
	 */
	@Override
	public TrashEntry getTrashEntry() throws PortalException;

	/**
	 * Returns the class primary key of the trash entry for this message boards category.
	 *
	 * @return the class primary key of the trash entry for this message boards category
	 */
	@Override
	public long getTrashEntryClassPK();

	/**
	 * Returns the trash handler for this message boards category.
	 *
	 * @return the trash handler for this message boards category
	 */
	@Override
	public TrashHandler getTrashHandler();

	/**
	 * Returns <code>true</code> if this message boards category is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this message boards category is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash();

	/**
	 * Returns <code>true</code> if the parent of this message boards category is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this message boards category is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer();

	@Override
	public boolean isInTrashExplicitly();

	@Override
	public boolean isInTrashImplicitly();

	/**
	 * Returns <code>true</code> if this message boards category is approved.
	 *
	 * @return <code>true</code> if this message boards category is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this message boards category is denied.
	 *
	 * @return <code>true</code> if this message boards category is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this message boards category is a draft.
	 *
	 * @return <code>true</code> if this message boards category is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this message boards category is expired.
	 *
	 * @return <code>true</code> if this message boards category is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this message boards category is inactive.
	 *
	 * @return <code>true</code> if this message boards category is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this message boards category is incomplete.
	 *
	 * @return <code>true</code> if this message boards category is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this message boards category is pending.
	 *
	 * @return <code>true</code> if this message boards category is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this message boards category is scheduled.
	 *
	 * @return <code>true</code> if this message boards category is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	/**
	 * Returns the container model ID of this message boards category.
	 *
	 * @return the container model ID of this message boards category
	 */
	@Override
	public long getContainerModelId();

	/**
	 * Sets the container model ID of this message boards category.
	 *
	 * @param containerModelId the container model ID of this message boards category
	 */
	@Override
	public void setContainerModelId(long containerModelId);

	/**
	 * Returns the container name of this message boards category.
	 *
	 * @return the container name of this message boards category
	 */
	@Override
	public String getContainerModelName();

	/**
	 * Returns the parent container model ID of this message boards category.
	 *
	 * @return the parent container model ID of this message boards category
	 */
	@Override
	public long getParentContainerModelId();

	/**
	 * Sets the parent container model ID of this message boards category.
	 *
	 * @param parentContainerModelId the parent container model ID of this message boards category
	 */
	@Override
	public void setParentContainerModelId(long parentContainerModelId);

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
	public int compareTo(MBCategory mbCategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<MBCategory> toCacheModel();

	@Override
	public MBCategory toEscapedModel();

	@Override
	public MBCategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}