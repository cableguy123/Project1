<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %> 
<%@ page import="bean.userBean" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BMR Input Data Pages</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/datainput.css">
</head>
<body>
   <%
      userBean userBean = (userBean) session.getAttribute("userBean");
   %>
    <div class="sidenav">
        <div class="login-main-text">
            <img src="${pageContext.request.contextPath}/css/img/data.jpg" class="sidenav data">
        </div>
     </div>
     <div class="main">
        <div class="col-md-6 col-sm-12">
           <div class="login-form">
               <form action="fn/input" method="post">
                  <div class="form-group">
                     性別 
                     <input id="1" class="radio" type="radio" name="gender" value="Male" required>
                     <label for="1">
                        男
                     </label>
                     <input id="2" class="radio" type="radio" name="gender" value="Female" required>
                     <label for="2">
                        女
                     </label>
                    </div> 
                    <div class="form-group">
                     <span id="color" class="p-position">年齢</span> 
                     <input class="form-control" type="number" name="age" id="age" placeholder="18~100歳" min="18" max="100" required>
                  </div>
                  <div class="form-group">
                     <span id="color" class="p-position">身長</span>
                     <input class="form-control" type="number" name="height" placeholder="100~200cm" min="100" max="200" step="0.1" required>
                  </div>
                  <div class="form-group">
                     <span id="color" class="p-position">体重</span>
                     <input class="form-control" type="number" name="weight" placeholder="30~120kg" min="30" max="120" step="0.1" required>
                  </div>
                 </div>
                 <input type="hidden" name="user_id" value="${userBean.getUser_id()}">
                 <button type="submit" class="btn btn-secondary">提出</button>
                 <button type="reset" class="btn btn-secondary">リセット</button>
              </form>
           </div>
        </div>
     </div>
     
</body>
</html>