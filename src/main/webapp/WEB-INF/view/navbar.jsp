<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
	  <div class="navbar-header">
	    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	      <span class="sr-only">Toggle navigation</span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="<c:url value="/" />">Users management!</a>
	 </div>
	 <div id="navbar" class="collapse navbar-collapse">
	   <ul class="nav navbar-nav navbar-right">
	     <li><a href="<c:url value="/" />"><span class="glyphicon glyphicon-home"></span> Home</a></li>
	     <li><a href="<c:url value="/list" />"><span class="glyphicon glyphicon-align-left"></span> Display</a></li>
	     <li><a href="<c:url value="/upload" />"><span class="glyphicon glyphicon-upload"></span> Upload</a></li>
	   </ul>
	 </div><!-- /.nav-collapse -->
	</div><!-- /.container -->
</nav><!-- /.navbar -->