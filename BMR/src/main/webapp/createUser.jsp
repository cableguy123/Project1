<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.userBean"%> 
<%@ page import="db.dao.UserDataDAO"%> 
<!DOCTYPE html>
<html lang="jp">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>BMR Create User Pages</title>
      <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
      <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
      <script>
         function registerCheckFunction() {
         var email = $('#email').val();
         $.ajax({
         type: 'POST',
         url: './fn/check',
         data: {email : email},
         success: function(result) {
         console.log("result value = " + result);
         if(result == 1) {    
            $("#checkMessage").html('使用できません');
            $('#checkType').attr('class', 'modal-content panel-warning');
         }else {
            $("#checkMessage").html('使用できます');
            $('#checkType').attr('clsass', 'modal-content panel-success');  
         }
         $('#checkModal').modal("show");
         }
      });
      }
      </script>
  </head>
<body>
   <h2>
      BMR 登録ページ
      </h2>
     <div class="container">
           <div class="form-container sign-in-container">
              <form action="fn/register" method="post">
                 <div class="form-group">
                    <span id="color" class="p-position">登録するメールアドレス</span>
                    <input type="email" id="email" class="form-controls" placeholder="メールアドレス" name="email" required>
                    <button class="btn btn-primary" onclick="registerCheckFunction();" type="button">重複チェック</button>
                 </div>
                 <div class="form-group">
                    <span id="color" class="p-position">登録するパスワード</span>
                    <input type="password" class="form-controls" placeholder="パスワード" name="password" required>
                 </div>
                 <input id="login-button" type="submit" value="登録">
              </form>
           </div>
        </div>
        <script>
         $('messageModal').modal("show");
        </script>
        <div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
         <div class="vertical-alignment-helper">
            <div class="modal-dialog vertical-align-center">
               <div id="checkType" class="modal-content panel-info">
                  <div class="modal-header panel-heading">  
                     <h4 class="modal-title">
                        確認メッセージ
                     </h4>
                  </div>
                  <div class="modal-body" id="checkMessage">
                  </div>
                  <div class="modal-footer">
                     <button type="button" class="btn btn-primary" data-dismiss="modal">確認</button>
                  </div>
               </div>   
            </div>
         </div>   
      </div>
</body>
</html>