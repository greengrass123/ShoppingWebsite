<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuanchuang
  Date: 2018-3-8
  Time: 23:44:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="../css/top.css">
<head>
    <title>Title</title>
</head>
<body>

<div class="top">
    <div class="top_head">

    <c:if test="${sessionScope.user==null}">
        <div class="top_login">
            请<a href="${pageContext.request.contextPath}/user/login">[登录]</a>
        </div>

        <div class="top_index">
            <a href="${pageContext.request.contextPath}/">[首页]</a>
        </div>
    </c:if>
    <c:if test="${sessionScope.user!=null}">
        <c:choose>
            <c:when test="${sessionScope.user.type==1}">
                <div class="top_login">
                    买家你好,<span class="name">${sessionScope.user.userName}</span>
                    <a href="${pageContext.request.contextPath}/user/loginOut">[退出]</a>
                </div>
                <div class="top_index">
                    <a href="${pageContext.request.contextPath}/">[首页]</a>
                    <a href="${pageContext.request.contextPath}/purchase/account">[财务]</a>
                    <a href="${pageContext.request.contextPath}/purchase/shoppingCart">[购物车]</a>
                </div>
            </c:when>
            <c:when test="${sessionScope.user.type==2}">
                <div class="top_login">
                    卖家你好 <span class="name">${sessionScope.user.userName}</span>
                    <a href="${pageContext.request.contextPath}/user/loginOut">[退出]</a>
                </div>
                <div class="top_index">
                    <a href="${pageContext.request.contextPath}/">[首页]</a>
                    <a href="${pageContext.request.contextPath}/commodity/publish">[发布]</a>
                </div>
            </c:when>
        </c:choose>
    </c:if>
    </div>
</div>


</body>
</html>
