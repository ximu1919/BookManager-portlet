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

package com.lynn.demo.book.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.lynn.demo.book.model.Books;
import com.lynn.demo.book.service.BooksLocalServiceUtil;

/**
 * @author 10295
 * @generated
 */
public abstract class BooksActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public BooksActionableDynamicQuery() throws SystemException {
		setBaseLocalService(BooksLocalServiceUtil.getService());
		setClass(Books.class);

		setClassLoader(com.lynn.demo.book.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("bookId");
	}
}