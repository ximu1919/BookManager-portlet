package com.lynn.demo.book.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.lynn.demo.book.model.Books;

public class BooksFinderImpl extends BasePersistenceImpl<Books> implements BooksFinder{
	
	// ������find��ʼ����
	public List findBooks(long userId, String keywords, int start, int end) throws SystemException {   
	    List list = null;   
	    String sql = null;
	    
	    // hibernate HQL���﷨
	    sql = "SELECT book.bookId, book.bookSN, book.bookName FROM Books book where book.userId = ? and book.bookName like ?";   
	       
	    Session session = null;   
	    try {
	    	
	    	// ����BooksPersistenceImpl,hibernate��ѯ����
	        session = openSession();  
	        // HQL��ѯ
	        Query q = session.createQuery(sql);
	        // SQL��ѯ
	        //Query sqlQuery = session.createSQLQuery("SQL���");
	        q.setLong(0, 10434);   
	        q.setString(1, keywords);
	        
//	        q.setSerializable(arg0, arg1) // ���л�
	  
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

	public List findBooks(String keywords, int start, int end) throws SystemException {   
	    List list = null;   
	    String sql = null;
	    

	    sql = "SELECT book.bookId, book.bookSN, book.bookName FROM Books book where book.bookName like ?";   
	       
	    Session session = null;   
	    try {
	    	
	    	// ����BooksPersistenceImpl,hibernate��ѯ����
	        session = openSession();  
	        // HQL��ѯ
	        Query q = session.createQuery(sql);
	        q.setString(0, keywords);

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
