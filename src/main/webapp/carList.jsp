<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<p>
    Car List of ${person.name}
</p>
<table>
    <tr>
        <th>ID</th>
        <th>BRAND</th>
    </tr>
    <c:forEach items="${carList}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.brand}</td>
        </tr>
    </c:forEach>
</table>
<p><a href="carAdd.jsp?id=${person.id}">Add a Car</a></p>
</body>
</html>
