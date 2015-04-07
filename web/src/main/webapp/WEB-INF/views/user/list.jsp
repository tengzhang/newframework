<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <style>
        table {
            border-collapse: collapse;
            border-spacing: 0;
        }
        th, td {
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
    <div style="width: 30%; margin-left: auto; margin-right: auto;">
        <p style="margin: 0"><a href="${website}user/new">添加</a></p>
        <table>
            <thead>
                <th>编号</th>
                <th>用户名</th>
                <th>密码</th>
                <th>操作</th>
            </thead>
            <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.password}</td>
                        <td>
                            <a href="${website}/user/update/${user.id}">修改</a>
                            <a href="${website}/user/delete/${user.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>