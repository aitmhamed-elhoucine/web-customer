<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> Save Customer </title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
    <style>
		.error {color:red}
	</style>
</head>
<body>
		<div id="wrapper">
            <div id="header">
                <h2> CRM - Customer Relationship  Management </h2>
            </div>
       </div>
       
       <div id="container">
		    <h3>Save Customer</h3>
		    <form:form action="saveCustomer" modelAttribute="customer" method="POST">
		         <table>
		         
		              <tbody>
		                   <tr>
		                       <td><label>First Name: </label></td>
		                       <td><form:input path="firstName"/></td>
		                   </tr>
		              </tbody>
		              
		              <tbody>
		                   <tr>
		                       <td><label>Last Name: </label></td>
		                       <td>
		                          <form:input path="lastName"/>
		                          <form:errors path="lastName" cssClass="error" />
		                       </td>
		                   </tr>
		              </tbody>
		              
		              <tbody>
		                   <tr>
		                       <td><label>Email: </label></td>
		                       <td><form:input path="email"/></td>
		                   </tr>
		              </tbody>
		              
		              <tbody>
		                   <tr>
		                       <td><input type="submit" value="Save" class="save"/></td>
		                   </tr>
		              </tbody>
		              
		         </table>
		    </form:form>
		    <p>
		      <a href="${pageContext.request.contextPath}/customer/listCustomers">Back to List</a>
		    </p>  
      </div>	
</body>
</html>