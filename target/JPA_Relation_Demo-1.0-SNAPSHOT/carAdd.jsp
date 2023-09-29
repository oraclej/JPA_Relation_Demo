<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="cadd" method="post">
  <input type="hidden" name="pid" value="${param.id}">
  <input type="number" name="id" placeholder="ID"><br>
  <input type="text" name="brand" placeholder="Brand"><br>
  <input type="submit" value="Save">
</form>

</body>
</html>