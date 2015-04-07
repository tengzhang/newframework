<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
<body>
<div style="width: 25%; margin-left: auto; margin-right: auto;">
    <form action="${website}user" method="post">
        <input type="hidden" value="put" name="_method"/>
        <input type="hidden" value="${user.id}" name="id" />
        用户名：<input type="text" name="name"/>
        密码: <input type="password" name="password"/>
        <input type="submit" value="添加"/>
        <input type="reset" value="重置"/>
    </form>
</div>
</body>
</html>