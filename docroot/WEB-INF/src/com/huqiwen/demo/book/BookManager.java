package com.huqiwen.demo.book;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.huqiwen.demo.book.model.Books;
import com.huqiwen.demo.book.model.impl.BooksImpl;
import com.huqiwen.demo.book.service.BooksLocalServiceUtil;
import com.huqiwen.demo.book.service.persistence.BooksFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BookManager
 */
public class BookManager extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {


//			BooksLocalServiceUtil.addBooks(books);
			
//			BooksLocalServiceUtil.deleteBooks(books);
//			BooksLocalServiceUtil.getBookses(start, end);
//			BooksLocalServiceUtil.getBooksesCount();
			
		try {
			List<Books> books = BooksLocalServiceUtil.searchBooks(0,"研究");
			for (Books book:books) {
				System.out.println("dynamicQuery result:"+book.getBookName());
			}
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.doView(renderRequest, renderResponse);
	}
 
}
