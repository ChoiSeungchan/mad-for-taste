<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="col-md-6">
			<form action="fileUpload" enctype="multipart/form-data" method="post"
				role="form">
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label><input
						type="password" class="form-control" id="exampleInputPassword1" />
				</div>
				<div class="form-group">
					<label for="exampleInputFile">File input</label><input type="file"
						id="exampleInputFile" name="file[0]" />
					<p class="help-block"></p>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>