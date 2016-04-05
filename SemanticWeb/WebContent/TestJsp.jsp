<%@page contentType="text/html" import="java.util.*" %> 
<%@page import="com.bean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
 <form method="post" action="TestJsp.jsp">
 <script type="text/javascript"> 
 function selected(dis){
	 var radio = dis.value;
  	if(radio=='Creators who mention Marguerite Derrida'){
  		
  		document.getElementById("second").style.display="block";
  		document.getElementById("triple").style.display="none";
  		document.getElementById("third").style.display="none";
  		document.getElementById("wildsearch").style.display="none";
  		
  	}
  	else if (radio=='Sample Annotation List') {
  		document.getElementById("second").style.display="none";
  		document.getElementById("triple").style.display="block";
  		document.getElementById("third").style.display="none";
  		document.getElementById("wildsearch").style.display="none";
      	}
  	else if (radio=='All English Annotations') {
  		document.getElementById("second").style.display="none";
  		document.getElementById("triple").style.display="none";
  		document.getElementById("third").style.display="block";
  		document.getElementById("wildsearch").style.display="none";
      	}
  	else{
  		document.getElementById("second").style.display="none";
  		document.getElementById("triple").style.display="none";
  		document.getElementById("third").style.display="none";
  		document.getElementById("wildsearch").style.display="none";
  	  	}
	   }


 function search(){
	 document.getElementById("second").style.display="none";
		document.getElementById("triple").style.display="none";
		document.getElementById("third").style.display="none";
		document.getElementById("wildsearch").style.display="block";
  
	   }
 

 </script>
 
 <p>&nbsp;</p>
 
 
 
 <jsp:useBean id="obj" class="com.bean.TestBean" scope="page"/>
 
 <div align="center">
 <table border="0" cellpadding="0" cellspacing="0" width="1150" bgcolor="cyan">
 <tr>
 <td width="100%"><font size="6" color="#008000">&nbsp;Manuscript Annotations in Jacques Derrida's Library</font></td>
 </tr>
 </table>
 </div>
 <div align="center">
 <table border="0" cellpadding="0" cellspacing="0" width="800" bgcolor="white">
 	<tr>
 	 <td colspan="2">Search Annotation</td>
 	</tr>
 	<tr>
 		<td>
 			<input type="text" name="Query" size="30"/>
 			<input type="button" name="Search" value="Go!" onclick="search()"/>
 		</td>

 	</tr>
 </table>
 </div>

 
 <div align="center">
 <table border="1" cellpadding="0" cellspacing="0" width="1150" bgcolor="#EEFFCA">
 <c:forEach var="item" items="${obj.items1}">
 <tr>
	<td>
	<input type="radio"" name="id" value="${item}" onclick="selected(this)">${item}
	</td>
 </tr>
 </c:forEach>

 </table>
 
 </div>
 
  <p>&nbsp;</p>
  
 <!-- First Sample Query -->  
 <div id="triple" style="width:1000px; display:none;">
 
  <div style="position:absolute; left:50; top:250;">
 <table border="0" cellpadding="0" cellspacing="0" width="400px" bgcolor="#EEFFCA">
 <tr>
 	<th><font size="3" color="red">Annotation</font></th>

 </tr>

 <c:forEach var="annouri" items="${obj.annoURI}">
 <tr>
  <td>${annouri}</td>
 </tr>
 </c:forEach>
  
 </table>
 </div>

 
 <div style="position:absolute; left:450; top:250;">
 <table border="0" cellpadding="0" cellspacing="0" width="300px" bgcolor="#EEFFCA">
 <tr>
 
 	<th align="center"><font size="3" color="red">Name</font></th>
 </tr>
  <c:forEach var="annoname" items="${obj.annoName}">
 <tr>
  <td>${annoname}</td>
 </tr>
 </c:forEach>
 
 </table>
 </div>
 
 <div style="position:absolute; left:750; top:250;">
 <table border="0" cellpadding="0" cellspacing="0" width="1200px" bgcolor="#EEFFCA">
 <tr>
 
 	<th align="left"><font size="3" color="red">Text</font></th>
 </tr>
  <c:forEach var="annotext" items="${obj.annoText}">
 <tr>
  <td>${annotext}</td>
 </tr>
 </c:forEach>
 
 </table>
 </div>
 </div>
 
 <!-- End of First Sample Query --> 
  
<!-- Second Query -->  
 <div id="second" style="width:1000px; display:none;">
 
  <div style="position:absolute; left:50; top:250;">
 <table border="0" cellpadding="0" cellspacing="0" width="400px" bgcolor="#EEFFCA">
 <tr>
 	<th><font size="3" color="red">Annotation</font></th>

 </tr>

 <c:forEach var="annoName" items="${obj.creatorAnno}">
 <tr>
  <td>${annoName}</td>
 </tr>
 </c:forEach>
  
 </table>
 </div>

 
 <div style="position:absolute; left:450; top:250;">
 <table border="0" cellpadding="0" cellspacing="0" width="300px" bgcolor="#EEFFCA">
 <tr>
 
 	<th align="center"><font size="3" color="red">Name</font></th>
 </tr>
  <c:forEach var="creator" items="${obj.creatorName}">
 <tr>
  <td>${creator}</td>
 </tr>
 </c:forEach>
 
 </table>
 </div>
 </div>
 <!-- End of Second Query --> 
 
 <!-- Third Query -->  
 <div id="third" style="width:1000px; display:none;">
 
  <div style="position:absolute; left:50; top:250;">
 <table border="0" cellpadding="0" cellspacing="0" width="400px" bgcolor="#EEFFCA">
 <tr>
 	<th><font size="3" color="red">Body</font></th>

 </tr>

 <c:forEach var="annoName" items="${obj.annoBody}">
 <tr>
  <td>${annoName}</td>
 </tr>
 </c:forEach>
  
 </table>
 </div>

 
 <div style="position:absolute; left:450; top:250;">
 <table border="0" cellpadding="0" cellspacing="0" width="1200px" bgcolor="#EEFFCA">
 <tr>
 
 	<th align="center"><font size="3" color="red">Text</font></th>
 </tr>
  <c:forEach var="creator" items="${obj.annoBodyText}">
 <tr>
  <td>${creator}</td>
 </tr>
 </c:forEach>
 
 </table>
 </div>
 </div>
 <!-- End of Third Query --> 

<!-- WildCard Search Query -->  
 <div id="wildsearch" style="width:1000px; display:none;">
 
  <div style="position:absolute; left:50; top:250;">
 <table border="0" cellpadding="0" cellspacing="0" width="400px" bgcolor="#EEFFCA">
 <tr>
 	<th><font size="3" color="red">Subject</font></th>

 </tr>

 <c:forEach var="subject" items="${obj.searchSub}">
 <tr>
  <td>${subject}</td>
 </tr>
 </c:forEach>
  
 </table>
 </div>

 
 <div style="position:absolute; left:450; top:250;">
 <table border="0" cellpadding="0" cellspacing="0" width="300px" bgcolor="#EEFFCA">
 <tr>
 
 	<th align="center"><font size="3" color="red">Property</font></th>
 </tr>
  <c:forEach var="prop" items="${obj.searchProp}">
 <tr>
  <td>${prop}</td>
 </tr>
 </c:forEach>
 
 </table>
 </div>
 
 <div style="position:absolute; left:750; top:250;">
 <table border="0" cellpadding="0" cellspacing="0" width="1200px" bgcolor="#EEFFCA">
 <tr>
 
 	<th align="left"><font size="3" color="red">Object</font></th>
 </tr>
  <c:forEach var="object" items="${obj.searchObj}">
 <tr>
  <td>${object}</td>
 </tr>
 </c:forEach>
 
 </table>
 </div>
 </div>
 
 <!-- End of WildCard Search Query --> 

 
 </form></html>