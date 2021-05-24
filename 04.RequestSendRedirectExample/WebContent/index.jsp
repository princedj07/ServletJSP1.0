<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Servlet Example</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
.paddingBtm {
	padding-bottom: 12px;
}
</style>
</head>
<body>
	<center>
		<h2>Servlet Send Redirect Example</h2>
		<form id="loginFormId" name="loginForm" method="post"
			action="loginServlet">
			<div id="usernameDiv" class="paddingBtm">
				<span id="user">Username: </span><input id="userInput" type="text"
					name="username" />
			</div>
			<div id="passwordDiv" class="paddingBtm">
				<span id="pass">Password: </span><input id="passInput"
					type="password" name="password" />
			</div>
			<div id="loginBtn">
				<input id="btn" type="submit" value="Login" />
			</div>
		</form>
	</center>
</body>
</html>