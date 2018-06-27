<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactory"%>
<%@ page contentType="text/html; charset = UTF-8" %>
<%@ page import="com.lynn.demo.book.service.BooksLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%
	List booklist = BooksLocalServiceUtil.findBooks(10434, "%Liferay学习%");
	List booklist2 = BooksLocalServiceUtil.findBooks("%Liferay学习%");
	//System.out.println(booklist.size());
%>