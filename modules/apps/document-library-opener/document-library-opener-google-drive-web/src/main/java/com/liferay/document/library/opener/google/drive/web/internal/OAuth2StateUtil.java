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

package com.liferay.document.library.opener.google.drive.web.internal;

import com.liferay.document.library.opener.oauth.OAuth2State;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Alicia Garcia Garcia
 */
public class OAuth2StateUtil {

	public static void cleanUp(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();

		session.removeAttribute(_SESSION_ATTRIBUTE_NAME_GOOGLE_OAUTH2_STATE);
	}

	public static Optional<OAuth2State> getOAuth2StateOptional(
		HttpServletRequest httpServletRequest) {

		HttpSession session = httpServletRequest.getSession();

		return Optional.ofNullable(
			(OAuth2State)session.getAttribute(
				_SESSION_ATTRIBUTE_NAME_GOOGLE_OAUTH2_STATE));
	}

	public static boolean isValid(
		OAuth2State oAuth2State, HttpServletRequest httpServletRequest) {

		if (Validator.isNotNull(
				ParamUtil.getString(httpServletRequest, "error"))) {

			return false;
		}

		String state = ParamUtil.getString(httpServletRequest, "state");

		return oAuth2State.isValid(state);
	}

	public static void save(
		HttpServletRequest httpServletRequest, long userId, String successURL,
		String failureURL, String state) {

		HttpSession session = httpServletRequest.getSession();

		session.setAttribute(
			_SESSION_ATTRIBUTE_NAME_GOOGLE_OAUTH2_STATE,
			new OAuth2State(userId, successURL, failureURL, state));
	}

	private static final String _SESSION_ATTRIBUTE_NAME_GOOGLE_OAUTH2_STATE =
		"google-oauth2-state";

}