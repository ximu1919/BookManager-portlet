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

package com.lynn.demo.book.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BooksLocalService}.
 *
 * @author 10295
 * @see BooksLocalService
 * @generated
 */
public class BooksLocalServiceWrapper implements BooksLocalService,
	ServiceWrapper<BooksLocalService> {
	public BooksLocalServiceWrapper(BooksLocalService booksLocalService) {
		_booksLocalService = booksLocalService;
	}

	/**
	* Adds the books to the database. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @return the books that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lynn.demo.book.model.Books addBooks(
		com.lynn.demo.book.model.Books books)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.addBooks(books);
	}

	/**
	* Creates a new books with the primary key. Does not add the books to the database.
	*
	* @param bookId the primary key for the new books
	* @return the new books
	*/
	@Override
	public com.lynn.demo.book.model.Books createBooks(long bookId) {
		return _booksLocalService.createBooks(bookId);
	}

	/**
	* Deletes the books with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the books
	* @return the books that was removed
	* @throws PortalException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lynn.demo.book.model.Books deleteBooks(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.deleteBooks(bookId);
	}

	/**
	* Deletes the books from the database. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @return the books that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lynn.demo.book.model.Books deleteBooks(
		com.lynn.demo.book.model.Books books)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.deleteBooks(books);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _booksLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lynn.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lynn.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.lynn.demo.book.model.Books fetchBooks(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.fetchBooks(bookId);
	}

	/**
	* Returns the books with the primary key.
	*
	* @param bookId the primary key of the books
	* @return the books
	* @throws PortalException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lynn.demo.book.model.Books getBooks(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.getBooks(bookId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bookses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lynn.demo.book.model.impl.BooksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of bookses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.lynn.demo.book.model.Books> getBookses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.getBookses(start, end);
	}

	/**
	* Returns the number of bookses.
	*
	* @return the number of bookses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBooksesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.getBooksesCount();
	}

	/**
	* Updates the books in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @return the books that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lynn.demo.book.model.Books updateBooks(
		com.lynn.demo.book.model.Books books)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.updateBooks(books);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _booksLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_booksLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _booksLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.lynn.demo.book.model.Books addBook(long companyId, long groupId,
		long userId, java.lang.String booksn, java.lang.String bookName,
		java.lang.String content) {
		return _booksLocalService.addBook(companyId, groupId, userId, booksn,
			bookName, content);
	}

	@Override
	public java.util.List<com.lynn.demo.book.model.Books> searchBooks(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.searchBooks(companyId, groupId);
	}

	@Override
	public java.util.List<com.lynn.demo.book.model.Books> searchBooks(
		long groupId, java.lang.String keyWord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _booksLocalService.searchBooks(groupId, keyWord);
	}

	@Override
	public com.sun.javafx.collections.MappingChange.Map<java.lang.String, java.lang.String> getGroupByPrice(
		double price) {
		return _booksLocalService.getGroupByPrice(price);
	}

	@Override
	public java.util.List findBooks(long userId, java.lang.String keywords) {
		return _booksLocalService.findBooks(userId, keywords);
	}

	@Override
	public java.util.List findBooks(java.lang.String keywords) {
		return _booksLocalService.findBooks(keywords);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BooksLocalService getWrappedBooksLocalService() {
		return _booksLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBooksLocalService(BooksLocalService booksLocalService) {
		_booksLocalService = booksLocalService;
	}

	@Override
	public BooksLocalService getWrappedService() {
		return _booksLocalService;
	}

	@Override
	public void setWrappedService(BooksLocalService booksLocalService) {
		_booksLocalService = booksLocalService;
	}

	private BooksLocalService _booksLocalService;
}