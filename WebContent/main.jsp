<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.MainBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>メイン画面</title>
</head>
<body>
	ログインしました。

	社員名:<%=bean.getShainName() %><br>

	<form  method="POST" action="ShainListServlet">
	社員一覧を表示する<br>
	    <input type="submit" value="社員一覧表示">
	</form>

</body>
</html>