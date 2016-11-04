<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
.errorClass{
	color:red;
}
</style>
</head>
<body>
<%-- 	<form method="post"> --%>
<%-- 		用  户 名：<input type="text" id="username" name="username" value="${user.username }"/><br/> --%>
<%-- 		密       码：<input type="text" id="password" name="password" value="${user.password }"/><br/> --%>
<%-- 		创建时间：<input type="text" id="createTime" name="createTime" value="${user.createTime }"/> --%>
<%-- 		<form:errors path="user.createTime" cssClass="errorClass"></form:errors> --%>
<!-- 		<br/> -->
<!-- 		<input type="submit" name="提交"> -->
<%-- 	</form> --%>
	
	
	----------------------------------------------------------------------------------<br/>
	<form:form commandName="user" method="post">
		用  户 名：<form:input path="username"/><br/>
		密       码：<form:input path="password"/><br/>
		创建时间：<form:input path="createTime"/>
		<form:errors path="createTime" cssClass="errorClass"></form:errors>
		<br/>
		<input type="submit" name="提交">
	</form:form>
	
	----------------------------------------------------------------------------------<br/>
	<spring:hasBindErrors name="user">
		${errors }<br/>
		全局错误:<br/>
		个数：${errors.globalErrorCount }<br/>
		
		<c:if test="${errors.globalErrorCount > 0}">
		    <c:forEach items="${errors.globalErrors}" var="error">
		    		code:${error.code}<br/>
		    		arguments:${error.arguments}<br/>
		    		defaultMessage:${error.defaultMessage}<br/>
		        
		    </c:forEach>
		  </c:if>
		
		
		---------------------------------------------------------------<br/>
		字段错误:<br/>
		个数：${errors.fieldErrorCount }<br/>
		
		 <c:if test="${errors.fieldErrorCount > 0}">
		    <c:forEach items="${errors.fieldErrors}" var="error">
		    		code:${error.code}<br/>
		    		arguments:${error.arguments}<br/>
		    		defaultMessage:${error.defaultMessage}<br/>
		        
		    </c:forEach>
		  </c:if>
		
	</spring:hasBindErrors>
	
</body>
</html>