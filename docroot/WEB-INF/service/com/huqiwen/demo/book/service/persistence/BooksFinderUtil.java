/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.huqiwen.demo.book.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author huqiwen
 */
public class BooksFinderUtil {
	public static java.util.List findBooks(long userId,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findBooks(userId, keywords, start, end);
	}

	public static BooksFinder getFinder() {
		if (_finder == null) {
			_finder = (BooksFinder)PortletBeanLocatorUtil.locate(com.huqiwen.demo.book.service.ClpSerializer.getServletContextName(),
					BooksFinder.class.getName());

			ReferenceRegistry.registerReference(BooksFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(BooksFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BooksFinderUtil.class, "_finder");
	}

	private static BooksFinder _finder;
}