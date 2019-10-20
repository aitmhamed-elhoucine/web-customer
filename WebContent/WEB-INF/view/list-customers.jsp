<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer list</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
       <div id="wrapper">
            <div id="header">
                <h2> CRM - Customer Relationship  Management </h2>
            </div>
       </div>
       
       <div id="container">
            <div id="content">
            
            <!-- put new button add Customer -->
            <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
     
            <!-- add search from  --> 
              <form:form action="search" method="POST">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
            
            
            <!--add out html table here -->
               <table>
                   <tr>
                      <th> First Name </th>
                      <th> Last Name </th>
                      <th> Email </th>
                      <th> Action </th>
                   </tr>
                   <!-- loop over and print our customers -->
                   <c:forEach var="tempCustomer" items="${customer}">
                   
                   <!-- construct an "Upadte" link with customer id -->
                   <c:url var="updateLink" value="/customer/showFormForUpdate"> 
                       <c:param name="customerId" value="${tempCustomer.id}"></c:param>
                   </c:url>
                   
                    <!-- construct an "Delete" link with customer id -->
                   <c:url var="deleteLink" value="/customer/delete"> 
                       <c:param name="customerId" value="${tempCustomer.id}"></c:param>
                   </c:url>
                   
                   <tr>
                       <td>${tempCustomer.firstName}</td>
                       <td>${tempCustomer.lastName}</td>
                       <td>${tempCustomer.email}</td>
                       <td><a href="${updateLink}">Update</a>|
                           <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this Customer'))) return false">Delete</a></td>
                    </tr>
                   </c:forEach>    
               </table>
            </div>
       </div>
</body>
</html>