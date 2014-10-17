<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>Add new User</title>
</head>
<body>
<form action="select">
  <input type="hidden" name="form_test" value="form works!" />
  
  <h2>Login</h2>
  <input type="text" name="loginName" placeholder="Name" />
  <input type="password" name="loginPasswd" placeholder="Password" /> 
  <input type="submit" value="Login" />
  <br>
  <h2>Add new User</h2>
  <input type="text" name="name" placeholder="Name" />
  <input type="number" name="tel" placeholder="Phone Number" />
  <input type="password" name="passwd" placeholder="Password" /> 
  <input type="submit" value="Add User!" />
</form>
</body>
</html>