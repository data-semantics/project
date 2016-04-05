<%@page contentType="text/html" import="java.util.*" %>
<%@ page import="com.bean.*" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
 <form method="get" action="TestJsp.jsp">
 <p>&nbsp;</p>



 <jsp:useBean id="obj" class="com.bean.TestBean" scope="session"/>
 
  <input type="text" value="${sessionScope.radioSelect}"/>

<c:if test="${sessionScope.radioSelect == 'Title'}">


 <div align="center">
 <table border="1" cellpadding="0" cellspacing="0" width="1150" bgcolor="#EEFFCA">
 <c:forEach var="item" items="${obj.titles}">
 <tr>
  <td>${item}
	</td>
 </tr>
 </c:forEach>
 
 </table>
 </div>
 </c:if>
 
 
 <c:if test="${sessionScope.radioSelect == 'Authorized Access Point'}">


 <div align="center">
 <table border="1" cellpadding="0" cellspacing="0" width="1150" bgcolor="#EEFFCA">
 <c:forEach var="item" items="${obj.accesPoints}">
 <tr>
  <td>${item}
	</td>
 </tr>
 </c:forEach>
 
 </table>
 </div>
 </c:if>
 
 
 </form>
 
 
 </html>