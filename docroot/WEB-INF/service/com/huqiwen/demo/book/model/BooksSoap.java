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

package com.huqiwen.demo.book.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author huqiwen
 * @generated
 */
public class BooksSoap implements Serializable {
	public static BooksSoap toSoapModel(Books model) {
		BooksSoap soapModel = new BooksSoap();

		soapModel.setBookId(model.getBookId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBookName(model.getBookName());
		soapModel.setPrice(model.getPrice());
		soapModel.setBookSN(model.getBookSN());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static BooksSoap[] toSoapModels(Books[] models) {
		BooksSoap[] soapModels = new BooksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BooksSoap[][] toSoapModels(Books[][] models) {
		BooksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BooksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BooksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BooksSoap[] toSoapModels(List<Books> models) {
		List<BooksSoap> soapModels = new ArrayList<BooksSoap>(models.size());

		for (Books model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BooksSoap[soapModels.size()]);
	}

	public BooksSoap() {
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long pk) {
		setBookId(pk);
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getBookName() {
		return _bookName;
	}

	public void setBookName(String bookName) {
		_bookName = bookName;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public String getBookSN() {
		return _bookSN;
	}

	public void setBookSN(String bookSN) {
		_bookSN = bookSN;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private long _bookId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _bookName;
	private double _price;
	private String _bookSN;
	private String _content;
}