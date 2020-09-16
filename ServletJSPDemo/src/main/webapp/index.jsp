 <!DOCTYPE html>
<html>
<head>
<title>Inicio</title>
</head>
<body>
	<h1>Add User</h1>
	<form action="add-user" method="post">
		<input type="text" name="name" placeholder="Name"><br>
		<input type="text" name="lastName" placeholder="Last Name"><br>
		<input type="submit" value="Add"><br>
	</form>
	<h1>Add File</h1>
	<form action="add-file" method="post" enctype="multipart/form-data">
		<input type="file" name="file" multiple><br />
		<input type="submit" value="Add">
	</form>
</body>
</html> 