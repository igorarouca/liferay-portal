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

package com.liferay.fragment.internal.renderer;

import com.liferay.fragment.contributor.FragmentCollectionContributorTracker;
import com.liferay.fragment.exception.FragmentEntryContentException;
import com.liferay.fragment.model.FragmentEntryLink;
import com.liferay.fragment.renderer.FragmentRenderer;
import com.liferay.fragment.renderer.FragmentRendererContext;
import com.liferay.fragment.renderer.FragmentRendererController;
import com.liferay.fragment.renderer.FragmentRendererTracker;
import com.liferay.fragment.renderer.constants.FragmentRendererConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.servlet.PipingServletResponse;

import java.io.IOException;

import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jorge Ferrer
 */
@Component(immediate = true, service = FragmentRendererController.class)
public class FragmentRendererControllerImpl
	implements FragmentRendererController {

	@Override
	public String getConfiguration(
		FragmentRendererContext fragmentRendererContext) {

		FragmentRenderer fragmentRenderer = _getFragmentRenderer(
			fragmentRendererContext.getFragmentEntryLink());

		try {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				fragmentRenderer.getConfiguration(fragmentRendererContext));

			return _translateConfigurationFields(
				jsonObject, fragmentRendererContext.getLocale());
		}
		catch (JSONException jsone) {
			_log.error(
				"Unable to parse fragment entry link configuration", jsone);
		}

		return StringPool.BLANK;
	}

	@Override
	public String render(
		FragmentRendererContext fragmentRendererContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();

		FragmentRenderer fragmentRenderer = _getFragmentRenderer(
			fragmentRendererContext.getFragmentEntryLink());

		try {
			fragmentRenderer.render(
				fragmentRendererContext, httpServletRequest,
				new PipingServletResponse(
					httpServletResponse, unsyncStringWriter));
		}
		catch (IOException ioe) {
			SessionErrors.add(
				httpServletRequest, "fragmentEntryInvalidContent");

			StringBundler sb = new StringBundler(3);

			sb.append("<div class=\"alert alert-danger m-2\">");

			String errorMessage = "an-unexpected-error-occurred";

			Throwable cause = ioe.getCause();

			if (cause instanceof FragmentEntryContentException) {
				FragmentEntryContentException fece =
					(FragmentEntryContentException)cause;

				errorMessage = fece.getLocalizedMessage();
			}

			ThemeDisplay themeDisplay =
				(ThemeDisplay)httpServletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			sb.append(LanguageUtil.get(themeDisplay.getLocale(), errorMessage));

			sb.append("</div>");

			return sb.toString();
		}

		return unsyncStringWriter.toString();
	}

	private FragmentRenderer _getFragmentRenderer(
		FragmentEntryLink fragmentEntryLink) {

		FragmentRenderer fragmentRenderer = null;

		if (Validator.isNotNull(fragmentEntryLink.getRendererKey())) {
			fragmentRenderer = _fragmentRendererTracker.getFragmentRenderer(
				fragmentEntryLink.getRendererKey());
		}

		if (fragmentRenderer == null) {
			fragmentRenderer = _fragmentRendererTracker.getFragmentRenderer(
				FragmentRendererConstants.FRAGMENT_ENTRY_FRAGMENT_RENDERER_KEY);
		}

		return fragmentRenderer;
	}

	private String _translateConfigurationFields(
		JSONObject jsonObject, Locale locale) {

		JSONArray fieldSetsJSONArray = jsonObject.getJSONArray("fieldSets");

		if (fieldSetsJSONArray == null) {
			return StringPool.BLANK;
		}

		ResourceBundleLoader resourceBundleLoader =
			new AggregateResourceBundleLoader(
				ResourceBundleLoaderUtil.getPortalResourceBundleLoader(),
				_fragmentCollectionContributorTracker.
					getResourceBundleLoader());

		ResourceBundle resourceBundle = resourceBundleLoader.loadResourceBundle(
			locale);

		Iterator<JSONObject> iterator = fieldSetsJSONArray.iterator();

		iterator.forEachRemaining(
			fieldSetJSONObject -> {
				String fieldSetLabel = fieldSetJSONObject.getString("label");

				fieldSetJSONObject.put(
					"label",
					LanguageUtil.get(
						resourceBundle, fieldSetLabel, fieldSetLabel));

				JSONArray fieldsJSONArray = fieldSetJSONObject.getJSONArray(
					"fields");

				Iterator<JSONObject> fieldsIterator =
					fieldsJSONArray.iterator();

				fieldsIterator.forEachRemaining(
					fieldJSONObject -> {
						String fieldLabel = fieldJSONObject.getString("label");

						fieldJSONObject.put(
							"label",
							LanguageUtil.get(
								resourceBundle, fieldLabel, fieldLabel));
					});
			});

		return jsonObject.toString();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		FragmentRendererControllerImpl.class);

	@Reference
	private FragmentCollectionContributorTracker
		_fragmentCollectionContributorTracker;

	@Reference
	private FragmentRendererTracker _fragmentRendererTracker;

}