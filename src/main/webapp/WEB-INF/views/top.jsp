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
<head>
    <title>Title</title>
</head>
<body>
<div class="user">
    <c:if test="${sessionScope.user!=null}">
        <c:choose>
            <c:when test="${sessionScope.user.type==1}">
                买家你好 <span class="name">${sessionScope.user.userName}</span>
                <a href="${pageContext.request.contextPath}/user/loginOut">[财务]</a>
                <a href="${pageContext.request.contextPath}/user/loginOut">[购物车]</a>
            </c:when>
            <c:when test="${sessionScope.user.type==2}">
                卖家你好 <span class="name">${sessionScope.user.userName}</span>
                <a href="${pageContext.request.contextPath}/seller/publish">[发布]</a>
            </c:when>

        </c:choose>
    </c:if>
    <a href="${pageContext.request.contextPath}/user/loginOut">[首页]</a>
   <span class="name">${sessionScope.user.userName}</span>！<a href="${pageContext.request.contextPath}/user/loginOut">[退出]</a>
<c:if test="${sessionScope.user==null}">
    请<a href="${pageContext.request.contextPath}/user/loginJump">[登录]</a>
</c:if>

</div>
</body>
</html>
