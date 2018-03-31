<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuanchuang
  Date: 2018-3-9
  Time: 16:28:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", -10);
%>
<html>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/details.js"></script>
<link rel="stylesheet" href="../css/style.css">
<head>
    <title>Title</title>
    <script>
        ctx="${pageContext.request.contextPath}";
    </script>
</head>
<body>
<jsp:include page="top.jsp" flush="true"/>
<div class="g-doc">
    <div class="n-show f-cb" id="showContent">
        <c:if test="${msg==null}">
            <div id="imgDiv" class="img">
                <c:if test="${commodity.image_source==2}">
                    <img src="<%=path%>${commodity.imgUrl}"
                    >
                </c:if>
                <c:if test="${commodity.image_source==1}">
                    <img src="${commodity.imgUrl}"
                    >
                </c:if>
            </div>
            <div class="cnt">
                <input type="hidden" id="commodityID" value="${commodity.id}"/>
                <input type="hidden" name="token" id="token" value="${sessionScope.token}"/>
                <h2>${commodity.title}</h2>
                <p class="summary">${commodity.summary}</p>
                <div class="price">
                    <span class="v-unit">¥</span><span class="v-value" id="price">${commodity.price}</span>
                </div>
                <div class="num">购买数量：<span id="plusNum" class="lessNum"><a style="color:black">-</a></span><span class="totalNum"
                                                                                              id="amount">${commodity.amount}</span><span
                        id="addNum" class="moreNum"><a style="color:black">+</a></span></div>
                <div class="oprt f-cb">
                    <c:if test="${sessionScope.user.type==2}">
                        <a href="${pageContext.request.contextPath}/commodity/edit?id=${commodity.id}"
                           class="u-btn u-btn-primary">编 辑</a>
                    </c:if>
                    <c:if test="${sessionScope.user.type==1}">
                        <c:if test="${bought==0}">
                            <input type="button" id="detailButton" value="购买" class="u-btn u-btn-primary"/>
                        </c:if>
                        <c:if test="${bought==1}">
                            <span class="u-btn u-btn-primary z-dis">已购买</span>
                            <span class="buyprice">${buyPrice}</span>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </c:if>
        <c:if test="${msg!=null}">
            ${msg }<br/>
        </c:if>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${commodity.text}
    </div>
</div>

</body>
</html>
