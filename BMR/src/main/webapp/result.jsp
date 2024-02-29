<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTf-8" %> 
<%@ page import="bean.userBean" %>
<%@ page import="bean.resultsBean" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result | BMR Calculator</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/result.css">
</head>
<body>
<div>
    <%
        userBean userBean = (userBean) session.getAttribute("userBean");
        ArrayList<resultsBean> resultList = (ArrayList<resultsBean>) session.getAttribute("resultsList");
    %>
    <header>
        <!-- Logo.png -->
        <div>
            <a href="main.jsp?id=<%= userBean.getUser_id() %>">
                <img src="${pageContext.request.contextPath}/css/img/logo2.png" alt="Website logo" width="10%">
            </a>
        </div>
        <!-- link -->
        <nav>
            <ul>
                <li><a class="link" href="main.jsp?id=<%= userBean.getUser_id() %>">TOP</a></li>
                <li><a class="link" href="account.jsp?id=<%= userBean.getUser_id()%>">ACCOUNT</a></li>
                <li><a class="link" href="aboutus.jsp?id=<%= userBean.getUser_id()%>">ABOUT US</a></li>
            </ul>
        </nav>
    </header>

    <div class="content">
        <h2>あなたの情報</h2>
        <br>
        <table>
            <tr>
                <th>日付</th>
                <th>総カロリー</th>
                <th>BMR</th>
                <th>TDEE</th>
                <th>結果</th>
            </tr>           
         
            <c:forEach var="resultBean" items="${resultsList}">
                <tr>
                    <th>${resultBean.getMeal_date()}</th>
                    <th>${resultBean.getMeal_calories()}</th>
                    <th>${resultBean.getBmr()}</th>
                    <th>${resultBean.getTdee()}</th>
                    <th>${resultBean.getResult()}</th>
                </tr>   
            </c:forEach>
        
        </table>
        <a class="button" href="main.jsp?id=<%= userBean.getUser_id() %>">BACK</a>
    </div>
</div>
</body>
</html>