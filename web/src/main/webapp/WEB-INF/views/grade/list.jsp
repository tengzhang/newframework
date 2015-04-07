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
    <div style="width: 25%; margin-left: auto; margin-right: auto;">
        <p style="margin: 0;"><a href="${website}grade/new">添加</a></p>
        <table frame="box">
            <thead>
                <th>编号</th>
                <th>名称</th>
                <th>操作</th>
            </thead>
            <tbody>
                <c:forEach var="grade" items="${gradeList}">
                    <tr>
                        <td>${grade.id}</td>
                        <td>${grade.name}</td>
                        <td>
                            <a href="${website}grade/update/${grade.id}">修改</a> |
                            <a href="${website}grade/delete/${grade.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>