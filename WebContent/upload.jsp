<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>파일 업로드</title>
</head>
<body>
	<form action="FileTransferer" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit" value="업로드">
	</form>
</body>
</html>