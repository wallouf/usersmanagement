<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery-ui.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery-ui.theme.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/usersmanagement.generic.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.example.i18n.text" />
<!DOCTYPE html>
	<html lang="${language}">
	  <head>
	    <meta charset="utf-8">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	    <title>Users management</title>
	
	    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	  </head>
	
	  <body>
	    <c:import url="/WEB-INF/view/navbar.jsp" />
	    
		
		<div class="container-fluid">
			<div class="row">
			    <div class="col-xs-12 col-sm-12	">
				<div class="full-bloc-light">
				  <h3>List of data saved.</h3>
				</div>
					<div>
				        <c:choose>
				            <%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
				            <c:when test="${ empty sessionScope.usersList }">
				                <p class="erreur">No users saved. Please, upload a file first.</p>
				            </c:when>
				            <%-- Sinon, affichage du tableau. --%>
				            <c:otherwise>
							List of Users :
							
							<table class="table table-striped">
							  <thead>
							  	<tr>
							  		<th>#</th>
							  		<th>Name</th>
							  		<th>Email</th>
							  		<th>Groups</th>
							  	</tr>
							  </thead>
							  <tbody>
               					<c:forEach items="${ sessionScope.usersList }" var="usersTemp">
               						<c:if test="${!empty usersTemp }">
									  	<tr>
									  		<td class="vert-align"><c:out value="${usersTemp.id }" /></td>
									  		<td class="vert-align"><c:out value="${usersTemp.name }" /></td>
									  		<td class="vert-align"><c:out value="${usersTemp.email }" /></td>
									  		<td class="vert-align">
									  			<c:if test="${!empty usersTemp.groups }">
										  		<c:forEach items="${ usersTemp.groups }" var="groupsItem">
											  		<c:if test="${!empty groupsItem }">
											  			<c:out value="${groupsItem.name }" />, 
		               								</c:if>
	               								</c:forEach>
               									</c:if>
               								</td>
									  	</tr>
               						</c:if>
                				</c:forEach>
							  </tbody>
							</table>
				            </c:otherwise>
				        </c:choose>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="container-fluid">
			<div class="row">
			    <div class="col-xs-12 col-sm-12	">
					<div>
				        <c:choose>
				            <%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
				            <c:when test="${ empty sessionScope.groupsList }">
				                <p class="erreur">No groups saved. Please, upload a file first.</p>
				            </c:when>
				            <%-- Sinon, affichage du tableau. --%>
				            <c:otherwise>
							List of Groups :
							
							<table class="table table-striped">
							  <thead>
							  	<tr>
							  		<th>#</th>
							  		<th>Email</th>
							  		<th>Groups</th>
							  	</tr>
							  </thead>
							  <tbody>
               					<c:forEach items="${ sessionScope.groupsList }" var="groupsTemp">
               						<c:if test="${!empty groupsTemp }">
									  	<tr>
									  		<td class="vert-align"><c:out value="${groupsTemp.id }" /></td>
									  		<td class="vert-align"><c:out value="${groupsTemp.email }" /></td>
									  		<td class="vert-align">
									  			<c:if test="${!empty groupsTemp.groups }">
										  		<c:forEach items="${ groupsTemp.groups }" var="groupsItem">
											  		<c:if test="${!empty groupsItem }">
											  			<c:out value="${groupsItem.name }" />, 
		               								</c:if>
	               								</c:forEach>
               									</c:if>
               								</td>
									  	</tr>
               						</c:if>
                				</c:forEach>
							  </tbody>
							</table>
				            </c:otherwise>
				        </c:choose>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
		   	<div class="row">
		    	<div class="col-xs-12 col-sm-12	">
					<hr>
					<footer>
					  <p>&copy; Wallouf 2014</p>
					</footer>
				</div>
		    </div>
		</div>
	</body>
</html>