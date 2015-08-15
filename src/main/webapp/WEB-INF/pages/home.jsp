<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Task Manager Application</title>
</head>
<body>
<h1>Task Manager Application</h1>
<p>
${message}<br/>
<a href="${pageContext.request.contextPath}/task/add.html">Add new task</a><br/>
<a href="${pageContext.request.contextPath}/task/list.html">Show all tasks</a><br/>
<a href="${pageContext.request.contextPath}/task/list_incomplete.html">Show incomplete tasks</a><br/>
<a href="${pageContext.request.contextPath}/task/list_complete.html">Show complete tasks</a><br/>
</p>
</body>
</html>