<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<c:forEach items="${doctorList}" var="Doctor">  
  <tr> 
    <td>id : ${Doctor.id}</td> <br> 
    <td>name : ${Doctor.name}</td> <br> 
    <td>email : ${Doctor.email}</td> <br>
    <td>phone : ${Doctor.phone}</td> <br>
    <td>speciality : ${Doctor.speciality}</td> <br>
    </tr> 
    <br>
    <br>
</c:forEach> 



</body>
</html>