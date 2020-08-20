<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<spring:url var="css" value="resources/css" />
<spring:url var="js" value="resources/js" />
<spring:url var="images" value="resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>  


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>

   <!-- writing script for highlighting the about us and contatct us -->
    <script>
    window.menu = '${title}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
<div class="wrapper">

 <!-- Navigation comes here... -->
 <%@include file="./shared/navbar.jsp" %>
<br><br><br>
 
 <!-- page content comes here -->
 
 <div class="content">
 
 <!-- Opens only when user clicks home -->
 <c:if test="${userClickHome == true}">
    <%@include file="home.jsp" %>
</c:if>

 <!-- Opens only when user clicks about us -->
 <c:if test="${userClickAbout == true}">
    <%@include file="about.jsp" %>
</c:if>


<!-- Opens only when user clicks contact us -->
 <c:if test="${userClickContact == true}">
    <%@include file="contact.jsp" %>
</c:if>

<!-- Opens only when user clicks View product or category products -->
 <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}" >
    <%@include file="listproducts.jsp" %>
</c:if>


</div>

   <!-- Footer comes here -->
   <%@include file="./shared/footer.jsp"%>
    <!-- /.container -->

    <!-- JavaScript -->
    <script src="${js}/jquery-1.10.2.js"></script>
    <script src="${js}/bootstrap.js"></script>


     <!-- Self coded java script -->
     <script src="${js}/myapp.js"></script>

</div>

</body>

</html>
