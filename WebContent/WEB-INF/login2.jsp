<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login2</title>
</head>
<body>
	<form action="/jmaster/AppServlet2" method="post">
		ユーザー名:<input type="text" name="name" /><br/>
		パスワード:<input type="text" name="pw" /><br/>
		<input type="hidden" name="action" value="login" />
		<input type="submit" value="ログイン" />
	</form>

</body>
</html>