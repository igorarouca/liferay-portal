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

package com.liferay.headless.delivery.resource.v1_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.headless.delivery.client.dto.v1_0.WikiPage;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.service.WikiNodeLocalServiceUtil;

import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * @author Javier Gamarra
 */
@RunWith(Arquillian.class)
public class WikiPageResourceTest extends BaseWikiPageResourceTestCase {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setScopeGroupId(testGroup.getGroupId());

		_wikiNode = WikiNodeLocalServiceUtil.addNode(
			UserLocalServiceUtil.getDefaultUserId(testGroup.getCompanyId()),
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			serviceContext);
	}

	@Override
	protected WikiPage randomWikiPage() throws Exception {
		WikiPage wikiPage = super.randomWikiPage();

		wikiPage.setEncodingFormat("html");

		return wikiPage;
	}

	@Override
	protected WikiPage testDeleteWikiPage_addWikiPage() throws Exception {
		return _addWikiPage();
	}

	@Override
	protected Long testGetWikiNodeWikiPagesPage_getWikiNodeId() {
		return _wikiNode.getNodeId();
	}

	@Override
	protected WikiPage testGetWikiPage_addWikiPage() throws Exception {
		return _addWikiPage();
	}

	@Override
	protected WikiPage testPutWikiPage_addWikiPage() throws Exception {
		return _addWikiPage();
	}

	private WikiPage _addWikiPage() throws Exception {
		return wikiPageResource.postWikiNodeWikiPage(
			testGetWikiNodeWikiPagesPage_getWikiNodeId(), randomWikiPage());
	}

	@DeleteAfterTestRun
	private WikiNode _wikiNode;

}