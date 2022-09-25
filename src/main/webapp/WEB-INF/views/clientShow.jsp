<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/26/2022
  Time: 1:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>



<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">clientID</th>
        <th scope="col">name</th>
        <th scope="col">country</th>
        <th scope="col">bookingDate</th>
        <th scope="col">phoneNumber</th>
        <th scope="col">address</th>
        <th scope="col">buildingNo</th>
        <th scope="col">fileNo</th>
        <th scope="col">flatSize</th>
        <th scope="col">contactMessenger</th>
        <th scope="col">contactWhatsApp</th>
        <th scope="col">status</th>
        <th scope="col">Update</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dto" items="${responseClientDto}">
        <tr>
            <td>${dto.id}</td>
            <td>${dto.clientID}</td>
            <td>${dto.name}</td>
            <td>${dto.country}</td>
            <td>${dto.bookingDate}</td>
            <td>${dto.phoneNumber}</td>
            <td>${dto.address}</td>
            <td>${dto.buildingNo}</td>
            <td>${dto.fileNo}</td>
            <td>${dto.flatSize}</td>
            <td>${dto.contactMessenger}</td>
            <td>${dto.contactWhatsApp}</td>
            <td><a href="/client/active/${dto.clientID}">${dto.status}</a></td>
            <td>
                <a href="/${dto.clientID}">Edit</a>
            </td>
            <td>
                <a href="/${dto.clientID}">Delete</a>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>

</body>
</html>
