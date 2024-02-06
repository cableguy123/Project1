<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="jp">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BMR Create User Pages</title>
    <script type="text/javascript" src="javascript/loginValidate.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="sidenav">
        <div class="login-main-text">
           <h2>In To App<br>Register Page</h2>
           <p>Register from here to access.</p>
        </div>
     </div>
     <div class="main">
        <div class="col-md-6 col-sm-12">
           <div class="login-form">
              <form action="fn/register" method="post">
                 <div class="form-group">
                    <label>登録するメールアドレス</label>
                    <input type="text" class="form-control" placeholder="メールアドレス" name="email">
                 </div>
                 <div class="form-group">
                    <label>登録するパスワード</label>
                    <input type="password" class="form-control" placeholder="パスワード" name="password">
                 </div>
                 <button type="submit" class="btn btn-secondary">Register</button>
              </form>
           </div>
        </div>
     </div>
</body>
</html>