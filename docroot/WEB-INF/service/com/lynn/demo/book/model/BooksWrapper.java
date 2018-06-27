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

package com.lynn.demo.book.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Books}.
 * </p>
 *
 * @author 10295
 * @see Books
 * @generated
 */
public class BooksWrapper implements Books, ModelWrapper<Books> {
	public BooksWrapper(Books books) {
		_books = books;
	}

	@Override
	public Class<?> getModelClass() {
		return Books.class;
	}

	@Override
	public String getModelClassName() {
		return Books.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("bookName", getBookName());
		attributes.put("price", getPrice());
		attributes.put("bookSN", getBookSN());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String bookName = (String)attributes.get("bookName");

		if (bookName != null) {
			setBookName(bookName);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String bookSN = (String)attributes.get("bookSN");

		if (bookSN != null) {
			setBookSN(bookSN);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	/**
	* Returns the primary key of this books.
	*
	* @return the primary key of this books
	*/
	@Override
	public long getPrimaryKey() {
		return _books.getPrimaryKey();
	}

	/**
	* Sets the primary key of this books.
	*
	* @param primaryKey the primary key of this books
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_books.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the book ID of this books.
	*
	* @return the book ID of this books
	*/
	@Override
	public long getBookId() {
		return _books.getBookId();
	}

	/**
	* Sets the book ID of this books.
	*
	* @param bookId the book ID of this books
	*/
	@Override
	public void setBookId(long bookId) {
		_books.setBookId(bookId);
	}

	/**
	* Returns the group ID of this books.
	*
	* @return the group ID of this books
	*/
	@Override
	public long getGroupId() {
		return _books.getGroupId();
	}

	/**
	* Sets the group ID of this books.
	*
	* @param groupId the group ID of this books
	*/
	@Override
	public void setGroupId(long groupId) {
		_books.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this books.
	*
	* @return the company ID of this books
	*/
	@Override
	public long getCompanyId() {
		return _books.getCompanyId();
	}

	/**
	* Sets the company ID of this books.
	*
	* @param companyId the company ID of this books
	*/
	@Override
	public void setCompanyId(long companyId) {
		_books.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this books.
	*
	* @return the user ID of this books
	*/
	@Override
	public long getUserId() {
		return _books.getUserId();
	}

	/**
	* Sets the user ID of this books.
	*
	* @param userId the user ID of this books
	*/
	@Override
	public void setUserId(long userId) {
		_books.setUserId(userId);
	}

	/**
	* Returns the user uuid of this books.
	*
	* @return the user uuid of this books
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _books.getUserUuid();
	}

	/**
	* Sets the user uuid of this books.
	*
	* @param userUuid the user uuid of this books
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_books.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this books.
	*
	* @return the user name of this books
	*/
	@Override
	public java.lang.String getUserName() {
		return _books.getUserName();
	}

	/**
	* Sets the user name of this books.
	*
	* @param userName the user name of this books
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_books.setUserName(userName);
	}

	/**
	* Returns the create date of this books.
	*
	* @return the create date of this books
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _books.getCreateDate();
	}

	/**
	* Sets the create date of this books.
	*
	* @param createDate the create date of this books
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_books.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this books.
	*
	* @return the modified date of this books
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _books.getModifiedDate();
	}

	/**
	* Sets the modified date of this books.
	*
	* @param modifiedDate the modified date of this books
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_books.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the book name of this books.
	*
	* @return the book name of this books
	*/
	@Override
	public java.lang.String getBookName() {
		return _books.getBookName();
	}

	/**
	* Sets the book name of this books.
	*
	* @param bookName the book name of this books
	*/
	@Override
	public void setBookName(java.lang.String bookName) {
		_books.setBookName(bookName);
	}

	/**
	* Returns the price of this books.
	*
	* @return the price of this books
	*/
	@Override
	public double getPrice() {
		return _books.getPrice();
	}

	/**
	* Sets the price of this books.
	*
	* @param price the price of this books
	*/
	@Override
	public void setPrice(double price) {
		_books.setPrice(price);
	}

	/**
	* Returns the book s n of this books.
	*
	* @return the book s n of this books
	*/
	@Override
	public java.lang.String getBookSN() {
		return _books.getBookSN();
	}

	/**
	* Sets the book s n of this books.
	*
	* @param bookSN the book s n of this books
	*/
	@Override
	public void setBookSN(java.lang.String bookSN) {
		_books.setBookSN(bookSN);
	}

	/**
	* Returns the content of this books.
	*
	* @return the content of this books
	*/
	@Override
	public java.lang.String getContent() {
		return _books.getContent();
	}

	/**
	* Sets the content of this books.
	*
	* @param content the content of this books
	*/
	@Override
	public void setContent(java.lang.String content) {
		_books.setContent(content);
	}

	@Override
	public boolean isNew() {
		return _books.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_books.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _books.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_books.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _books.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _books.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_books.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _books.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_books.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_books.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_books.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BooksWrapper((Books)_books.clone());
	}

	@Override
	public int compareTo(com.lynn.demo.book.model.Books books) {
		return _books.compareTo(books);
	}

	@Override
	public int hashCode() {
		return _books.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lynn.demo.book.model.Books> toCacheModel() {
		return _books.toCacheModel();
	}

	@Override
	public com.lynn.demo.book.model.Books toEscapedModel() {
		return new BooksWrapper(_books.toEscapedModel());
	}

	@Override
	public com.lynn.demo.book.model.Books toUnescapedModel() {
		return new BooksWrapper(_books.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _books.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _books.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_books.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BooksWrapper)) {
			return false;
		}

		BooksWrapper booksWrapper = (BooksWrapper)obj;

		if (Validator.equals(_books, booksWrapper._books)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Books getWrappedBooks() {
		return _books;
	}

	@Override
	public Books getWrappedModel() {
		return _books;
	}

	@Override
	public void resetOriginalValues() {
		_books.resetOriginalValues();
	}

	private Books _books;
}