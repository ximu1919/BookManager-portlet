package com.lynn.demo.book;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.hsqldb.lib.CountdownInputStream;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.lynn.demo.book.model.Books;
import com.lynn.demo.book.model.impl.BooksImpl;
import com.lynn.demo.book.service.BooksLocalServiceUtil;

/**
 * Portlet implementation class BookManager
 */
public class BookManager extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
//		BooksLocalServiceUtil.addBook(companyId, groupId, userId, booksn, bookName, content)
		
//		Books books = new BooksImpl(); //也可以用
//		
//		try {
//			Books books = BooksLocalServiceUtil.createBooks(CounterLocalServiceUtil.increment());
//			books.setCompanyId(PortalUtil.getCompanyId(renderRequest));
//			books.setGroupId(PortalUtil.getScopeGroupId(renderRequest));
//			books.setUserId(PortalUtil.getUserId(renderRequest));
//			books.setBookName(PortalUtil.getUser(renderRequest).getFullName());
//			books.setBookName("Liferay学习");
//			books.setCreateDate(new Date());
//			books.setBookSN("233333333");
//			
////			BooksLocalServiceUtil.addBooks(books);
////			
////			BooksLocalServiceUtil.deleteBooks(books);
////			BooksLocalServiceUtil.getBookses(start, end);
////			BooksLocalServiceUtil.getBooksesCount();
//			
//			BooksLocalServiceUtil.updateBooks(books);
//			
//		} catch (SystemException | PortalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			List<Books> books = BooksLocalServiceUtil.searchBooks(0, "研究");
			for (Books book : books) {
				System.out.println("result:" + book.getBookName());
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		super.doView(renderRequest, renderResponse);
	}
 

}
