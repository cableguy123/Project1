<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ page import="bean.userBean" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>アカウント</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/account.css">
    <link rel="icon" href="${pageContext.request.contextPath}/css/logo.png">
  </head>
  <body>
    <%
      userBean userBean = (userBean) session.getAttribute("userBean"); 
    %>
      <header>
        <div>
          <a href="main.jsp?id=<%= userBean.getUser_id() %>">
            <img src="${pageContext.request.contextPath}/css/img/logo.png" alt="Website logo" width="10%">
          </a>
        </div>
        <!-- logo -->
        <nav>
          <ul>
            <li><a class="link" href="main.jsp?id=<%= userBean.getUser_id() %>">TOP</a></li>
            <li><a class="link" href="account.jsp?id=<%= userBean.getUser_id()%>">ACCOUNT</a></li>
            <li><a class="link" href="aboutus.jsp?id=<%= userBean.getUser_id()%>">ABOUT US</a></li>
        </ul>
        </nav>
      </header>
      <!-- TOP -->
      <div class="content">
        <h2>パスワード変更</h2>
        <form method="post" action="fn/password">
          <div class="form-group">
            <span id="color" class="p-position">現在パスワード</span>
            <span id="miss" class="none mis">パスワードが無効です</span>
            <input type="password" class="form-control" placeholder="パスワード" name="password" required>
          </div>  
          <div class="form-group">
            <span id="color" class="p-position">新しいパスワード</span>
            <input type="password" class="form-control" placeholder="新しいパスワード" name="new_password" required>
          </div>
          <div class="form-group">
            <span id="colors" class="p-position">新しいパスワード確認</span>
            <span id="misss" class="none mis">パスワードが一致しません</span>
            <input type="password" class="form-control" placeholder="新しいパスワード確認" name="new_change_password" required>
          </div>
          <input id="change-button" type="submit" value="変更">
          <input type="hidden" name="user_id" value="${userBean.getUser_id()}">
        </form>
      </div>
      <!-- password Change -->

      <script>
        const searchForms = new URLSearchParams(location.search);
        if (searchForms.has('miss')) {
          document.getElementById('miss').classList.remove('none');
		      document.getElementById('misss').classList.remove('none');
		      document.getElementById('color').classList.add('mis');
		      document.getElementById('colors').classList.add('mis');
        }
      </script>
  </body>
</html>
