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

package com.lynn.demo.book.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.lynn.demo.book.model.Books;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Books in entity cache.
 *
 * @author 10295
 * @see Books
 * @generated
 */
public class BooksCacheModel implements CacheModel<Books>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", bookName=");
		sb.append(bookName);
		sb.append(", price=");
		sb.append(price);
		sb.append(", bookSN=");
		sb.append(bookSN);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Books toEntityModel() {
		BooksImpl booksImpl = new BooksImpl();

		booksImpl.setBookId(bookId);
		booksImpl.setGroupId(groupId);
		booksImpl.setCompanyId(companyId);
		booksImpl.setUserId(userId);

		if (userName == null) {
			booksImpl.setUserName(StringPool.BLANK);
		}
		else {
			booksImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			booksImpl.setCreateDate(null);
		}
		else {
			booksImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			booksImpl.setModifiedDate(null);
		}
		else {
			booksImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (bookName == null) {
			booksImpl.setBookName(StringPool.BLANK);
		}
		else {
			booksImpl.setBookName(bookName);
		}

		booksImpl.setPrice(price);

		if (bookSN == null) {
			booksImpl.setBookSN(StringPool.BLANK);
		}
		else {
			booksImpl.setBookSN(bookSN);
		}

		if (content == null) {
			booksImpl.setContent(StringPool.BLANK);
		}
		else {
			booksImpl.setContent(content);
		}

		booksImpl.resetOriginalValues();

		return booksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		bookName = objectInput.readUTF();
		price = objectInput.readDouble();
		bookSN = objectInput.readUTF();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bookId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (bookName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookName);
		}

		objectOutput.writeDouble(price);

		if (bookSN == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bookSN);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public long bookId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String bookName;
	public double price;
	public String bookSN;
	public String content;
}