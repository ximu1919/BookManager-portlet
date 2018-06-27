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

import com.huqiwen.demo.book.model.Books;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the books service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author huqiwen
 * @see BooksPersistenceImpl
 * @see BooksUtil
 * @generated
 */
public interface BooksPersistence extends BasePersistence<Books> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BooksUtil} to access the books persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bookses where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.huqiwen.demo.book.model.Books> findByc_g(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookses where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.huqiwen.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.huqiwen.demo.book.model.Books> findByc_g(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookses where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.huqiwen.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.huqiwen.demo.book.model.Books> findByc_g(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first books in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws com.huqiwen.demo.book.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huqiwen.demo.book.model.Books findByc_g_First(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.huqiwen.demo.book.NoSuchBooksException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first books in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huqiwen.demo.book.model.Books fetchByc_g_First(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last books in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws com.huqiwen.demo.book.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huqiwen.demo.book.model.Books findByc_g_Last(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.huqiwen.demo.book.NoSuchBooksException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last books in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huqiwen.demo.book.model.Books fetchByc_g_Last(long groupId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bookses before and after the current books in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws com.huqiwen.demo.book.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huqiwen.demo.book.model.Books[] findByc_g_PrevAndNext(
		long bookId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.huqiwen.demo.book.NoSuchBooksException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookses where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByc_g(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public int countByc_g(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the books in the entity cache if it is enabled.
	*
	* @param books the books
	*/
	public void cacheResult(com.huqiwen.demo.book.model.Books books);

	/**
	* Caches the bookses in the entity cache if it is enabled.
	*
	* @param bookses the bookses
	*/
	public void cacheResult(
		java.util.List<com.huqiwen.demo.book.model.Books> bookses);

	/**
	* Creates a new books with the primary key. Does not add the books to the database.
	*
	* @param bookId the primary key for the new books
	* @return the new books
	*/
	public com.huqiwen.demo.book.model.Books create(long bookId);

	/**
	* Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the books
	* @return the books that was removed
	* @throws com.huqiwen.demo.book.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huqiwen.demo.book.model.Books remove(long bookId)
		throws com.huqiwen.demo.book.NoSuchBooksException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.huqiwen.demo.book.model.Books updateImpl(
		com.huqiwen.demo.book.model.Books books)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the books with the primary key or throws a {@link com.huqiwen.demo.book.NoSuchBooksException} if it could not be found.
	*
	* @param bookId the primary key of the books
	* @return the books
	* @throws com.huqiwen.demo.book.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huqiwen.demo.book.model.Books findByPrimaryKey(long bookId)
		throws com.huqiwen.demo.book.NoSuchBooksException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the books with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookId the primary key of the books
	* @return the books, or <code>null</code> if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huqiwen.demo.book.model.Books fetchByPrimaryKey(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bookses.
	*
	* @return the bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.huqiwen.demo.book.model.Books> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.huqiwen.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.huqiwen.demo.book.model.Books> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.huqiwen.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.huqiwen.demo.book.model.Books> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses.
	*
	* @return the number of bookses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}