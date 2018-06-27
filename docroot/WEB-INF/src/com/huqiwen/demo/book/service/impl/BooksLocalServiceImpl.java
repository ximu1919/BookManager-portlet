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

package com.huqiwen.demo.book.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.huqiwen.demo.book.model.Books;
import com.huqiwen.demo.book.service.BooksLocalServiceUtil;
import com.huqiwen.demo.book.service.base.BooksLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the books local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.huqiwen.demo.book.service.BooksLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author huqiwen
 * @see com.huqiwen.demo.book.service.base.BooksLocalServiceBaseImpl
 * @see com.huqiwen.demo.book.service.BooksLocalServiceUtil
 */
public class BooksLocalServiceImpl extends BooksLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.huqiwen.demo.book.service.BooksLocalServiceUtil} to access the books local service.
	 */
	
	public Books addBook(long companyId,long groupId,long userId,String booksn,String bookName,String content){
		try {
			Books books = booksLocalService.createBooks(CounterLocalServiceUtil.increment());
			books.setCompanyId(companyId);
			books.setUserId(userId);
			books.setGroupId(groupId);
			books.setUserName(userLocalService.getUser(userId).getFullName());
			books.setBookName(bookName);
			books.setBookSN(booksn);
			books.setContent(content);
			books.setCreateDate(new Date());
			books.setModifiedDate(new Date());		
			return booksLocalService.updateBooks(books);
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		} catch (PortalException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Books> searchBooks(long companyId,long groupId) throws SystemException{
		return booksPersistence.findByc_g(groupId, companyId);
	}
	
	public List<Books> searchBooks(long groupId,String keyWord) throws SystemException{
		
		//在JSP，portlet控制类，或者其他里面
//		DynamicQuery query2 = DynamicQueryFactoryUtil.forClass(Books.class);
		//只能在booksLocalServiceImpl
		// select * from books;
		DynamicQuery query = this.dynamicQuery();
		
		query.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		
		if (Validator.isNotNull(keyWord)) {
			//select * form books where bookName like "%keyword%"
			query.add(PropertyFactoryUtil.forName("bookName").like("%"+keyWord+"%"));
		}
		
		query.addOrder(OrderFactoryUtil.asc("bookName"));
		
		// select * from books where bookName like "keyword" and groupId = groupid order by bookname;
		return dynamicQuery(query);
		
	}
	
	public Map<String, String> getGroupByPrice(double price){
		//select count(*),price,userId from xxx group by price,userId
		
		DynamicQuery query = this.dynamicQuery();   
		ProjectionList list = ProjectionFactoryUtil.projectionList();   
		list.add(ProjectionFactoryUtil.rowCount());   
		list.add(ProjectionFactoryUtil.groupProperty("price"));   
		list.add(ProjectionFactoryUtil.groupProperty("userId"));   
		query.setProjection(list);
		try {
			Map object = (Map)dynamicQuery(query);
			System.out.println(object);
			
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List findBooks(long userId,String keywords){
		try {
			return booksFinder.findBooks(userId, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}
}