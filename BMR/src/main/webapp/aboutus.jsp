<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ page import="bean.userBean" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABOUT US</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aboutus.css">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/css/img/logo.png">
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
        <nav>
            <ul>
                <li><a class="link" href="main.jsp?id=<%= userBean.getUser_id() %>">TOP</a></li>
                <li><a class="link" href="account.jsp?id=<%= userBean.getUser_id()%>">ACCOUNT</a></li>
                <li><a class="link" href="aboutus.jsp?id=<%= userBean.getUser_id()%>">ABOUT US</a></li>
            </ul>
        </nav>
    </header>
    <!-- header End -->
    <div class="content">
        <h2>ホームページ紹介</h2>
        <p>BMR Calculatorへようこそ。このサイトBMR Calculatorは、正確でパーソナライズされた基礎代謝率の計算の信頼できるソースです。
            計算の公式ソースはウィキペディアを参考にしました 
            また、このサイトは利用者の個人情報を収集しませんが、
            リンクされたウェブサイトはそうではないかもしれません。 個人情報に対する管理責任は、各サイトの運営者にあります。 問題がある場合は、当該運営者にご相談ください
        </p>
        <div class="button-center">
            <a class="button" href="main.jsp?id=<%= userBean.getUser_id() %>">Back</a>
        </div>
    </div>
</body>
</html>