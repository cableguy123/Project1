<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="bean.userBean" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/main.css">
<title>BMR Calculator</title>
<link rel="icon" type="image/png" href="css/img/logo.png">
</head>
<body>
<div>
    <%
        userBean userBean = (userBean)session.getAttribute("userBean");
    %>
                    <header>
                        <div>
                            <a href="main.jsp?id=<%= userBean.getUser_id() %>">
                                <img src="css/img/logo2.png" alt="Website logo" width="50%">
                            </a>
                        </div>
                        <nav>
                            <ul>
                                <li><a class="link" href="main.jsp?id=<%= userBean.getUser_id() %>">TOP</a></li>
                                <li><a class="link" href="account.jsp?id=<%= userBean.getUser_id() %>">ACCOUNT</a></li>
                                <li><a class="link" href="aboutus.jsp?id=<%= userBean.getUser_id() %>">ABOUT US</a></li>
                            </ul>
                        </nav>
                    </header>

                    <section class="container">
                        <div class="left-half">
                            <article>
                                <h2>BMR</h2>
                                <p>
                                    BMR(Basal Metaboly
                                    Rate)は、基礎代謝率を表す略語であり、呼吸、血液循環、細胞成長、体温調節、発毛およびホルモン生成などの基本的な機能を遂行するために身体が必要とするエネルギー(カロリー)。
                                </p>
                                <em>BMR 基礎代謝量の推定式</em>
                                <br>
                                <em>男性 :</em>
                                <em>(0.0481 * W + 0.0234 * H - 0.0138 * A - 0.4235) * 1000 / 4.186</em><br>
                                <em>女性 :</em>
                                <em>(0.0481 * W + 0.0234 * H - 0.0138 * A - 0.9708) * 1000 / 4.186</em>
                                <br>
                                <em>W: 体重(kg),H :身長(cm),A :年齢 </em>
                                <!-- TDEE -->
                                <h2>TDEE(総消費カロリー量)</h2>
                                <p>TDEE(Total Daily Energy Expenditure)は、人が1日に使用する総エネルギー(カロリー)である </p>
                            </article>
                            <article>
                                <h2>年齢によるBMR計算はこちらをご覧ください</h2>
                                <p>
                                    <em>男性</em><br>
                                    <em>18〜29歳 :</em>
                                    <strong>(64.4 * W - 113.0 * H / 100 + 3000) / 4.186</strong><br>
                                    <em>30〜59歳 :</em>
                                    <strong>(47.2 * W + 66.9 * H / 100 - 3769) / 4.186</strong><br>
                                    <em>60歳以上 :</em>
                                    <strong>(36.8 * W + 4, 719.5 * H / 100 - 4481) / 4.186</strong>
                                </p>
                                <p>
                                    <em>女性</em><br>
                                    <em>18〜29歳 :</em>
                                    <strong>(55.6 * W + 1397.4 * H / 100 + 148) / 4.186</strong><br>
                                    <em>30〜59歳 :</em>
                                    <strong>(36.4 * W + 104.6 * H / 100 - 3619) / 4.186</strong><br>
                                    <em>60歳以上 :</em>
                                    <strong>(38.5 * W + 2, 665.2 * H / 100 - 1264) / 4.186</strong>
                                </p>
                            </article>
                        </div>

                        <div class="right-half">
                            <article>
                                <form method="post" action="fn/calculator">
                                    <div>
                                        <h3>Activity Level</h3>
                                        <input id="1" type="radio" name="activity_level" value="1" required>
                                        <label for="1">まったくない</label>
                                        <br>
                                        <input id="2" type="radio" name="activity_level" value="2" required>
                                        <label for="2">週1~2回</label>
                                        <br>
                                        <input id="3" type="radio" name="activity_level" value="3" required>
                                        <label for="3">週3~5回</label>
                                        <br>
                                        <input id="4" type="radio" name="activity_level" value="4" required>
                                        <label for="4">週6~7回</label>
                                        <br>
                                    </div>

                                    <div>
                                        <h3>カロリーデータ</h3>
                                        カロリー(kcal)<input class="input" type="number" name="calories" required max="5000"><br>
                                        <input class="button" type="submit" value="Calculate"><br>
                                        <input type="hidden" name="user_id" value="${userBean.getUser_id()}">
                                    </div>
                                </form>
                            </article>
                        </div>
                    </section>
                </div>



            </body>
            <script>
                
            </script>
            </html>