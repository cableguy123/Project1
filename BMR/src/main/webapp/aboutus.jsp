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
                <img src="${pageContext.request.contextPath}/css/img/logo2.png" alt="Website logo" width="10%">
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
        <h2>概要</h2>
        <p>BMR CALCULATORへようこそ。正確で個別化された基礎代謝率(Basal Metabolic Rate)の計算に信頼できる情報源です。
        個々の方が健康なライフスタイルへの旅路で、日々のエネルギー消費について正確な洞察を提供することです。</p>
        <h2>約束</h2>
        <p>BMR CALCULATORでは、基礎代謝率を理解することが健康とフィットネスの目標を達成するための基本的なステップであると信じています。
        ユーザーフレンドリーなプラットフォームを提供し、ユーザーのユニークなプロファイルに合わせた信頼性のあるBMR計算を提供することに専念しています。</p>
        <h2>個人情報についてのご案内</h2>
        <p>個人情報は、BMR CALCULATORで収集されるデータの重要性を理解しております。収集されたデータは正確な基礎代謝率(Basal Metabolic Rate)の計算のためにのみ使用され、いかなる場合も他の目的で使用されることはありません。</p>
        <p>また、実際の計算に使用される公式は、主にウィキペディアなどの信頼性のあるソースを参照して作成されています。これにより、ユーザーは信頼性の高い結果を得ることができます。</p>
        <p>ただし、計算された結果によって生じるイベントや問題に関しては、弊社は責任を負いかねます。個人の健康状態に関する決定や行動については、専門家の助言を受けることが望ましいです。</p>
        <div class="button-center">
            <a class="button" href="main.jsp?id=<%= userBean.getUser_id() %>">BACK</a>
        </div>
    </div>
</body>
</html>