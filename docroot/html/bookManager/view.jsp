<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.huqiwen.demo.book.model.Books"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="com.huqiwen.demo.book.service.BooksLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%
	List booklist = BooksLocalServiceUtil.findBooks(10434, "%Liferay学习%");
	
	System.out.println(JSONFactoryUtil.serialize(booklist));
	
	DynamicQuery query = DynamicQueryFactoryUtil.forClass(Books.class);
	query.add(PropertyFactoryUtil.forName("bookName").like("%ray%"));
	List<Books> books = BooksLocalServiceUtil.dynamicQuery(query);
	System.out.println(books);
	
%>
