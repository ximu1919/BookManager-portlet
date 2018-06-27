package com.huqiwen.demo.book.service.persistence;

import java.util.List;

import com.huqiwen.demo.book.model.Books;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class BooksFinderImpl extends BasePersistenceImpl<Books> implements BooksFinder {
	
	public List findBooks(long userId, String keywords, int start, int end) throws SystemException{   
	  
		List list = null;   
		//hibernate HQL 的语法
	    String sql  = "SELECT book.bookId, book.bookSN,book.bookName FROM Books book where book.userId=? and book.bookName like ?";   
	       
	    Session session = null;   
	    try {   
	        session = openSession();
	        //HQL是查询
	        Query q = session.createQuery(sql);   
	        //SQL是查询
	       // Query sqlQuery = session.createSQLQuery("");
	        q.setLong(0, userId);   
	        q.setString(1, keywords);
	        
	        //q.setSerializable(arg0, arg1);
	        
	        list = (List)QueryUtil.list(q, getDialect(),start, end, false);   
	    }   
	    catch (Exception e) {   
	        throw processException(e);   
	    }   
	    finally {   
	        closeSession(session);   
	    }   
	       return list;   
	} 

}
