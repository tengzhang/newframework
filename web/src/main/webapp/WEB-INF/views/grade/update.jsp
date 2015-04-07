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
    <form action="${website}grade" method="post">
        <input type="hidden" name="_method" value="put" />
        <input type="hidden" name="id" value="${grade.id}" />
        名称： <input type="text" name="name" value="${grade.name}" /> <br/>
        <input type="submit" value="保存"/>
        <input type="reset" value="重置"/>
    </form>
</div>
</body>
</html>