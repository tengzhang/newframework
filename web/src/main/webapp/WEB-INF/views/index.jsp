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
        <h1>欢迎你，${user.userName}</h1>
        <a href="${website}grade/list">年级列表</a>
        <a href="${website}user/list">用户列表</a>
    </div>
</body>
</html>