<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuanchuang
  Date: 2018-3-5
  Time: 16:35:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
%>
<html>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<head>
    <script>
        ctx="${pageContext.request.contextPath}";
    </script>
    <title>Title</title>
    <jsp:include page="top.jsp" flush="true"></jsp:include>
</head>
<body>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li class="z-sel"><a href="${pageContext.request.contextPath}/commodity/findAllCommodity">所有内容</a></li>
                <c:if test="${sessionScope.user!=null}">
                    <c:if test="${sessionScope.user.type==2}">
                        <li class="z-sel"><a href="${pageContext.request.contextPath}/commodity/findNoSellCommodity">未购买的内容</a>
                        </li>
                    </c:if>
                </c:if>
            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
            <c:if test="${commodityList!=null}">
                <c:forEach var="commodity" items="${commodityList}">
                    <li>
                        <a class="link"
                           href="${pageContext.request.contextPath}/commodity/detail?id=${commodity.id}">
                            <div class="img">
                                <c:if test="${commodity.image_source==2}">
                                    <img src="<%=path%>${commodity.imgUrl}"
                                    >
                                </c:if>
                               <c:if test="${commodity.image_source==1}">
                                   <img src="${commodity.imgUrl}"
                                   >
                               </c:if>
                            </div>
                            <h3>${commodity.title}</h3>
                            <div class="price"><span class="v-unit">¥</span><span
                                    class="v-value">${commodity.price}</span>
                            </div>
                            <c:if test="${sessionScope.user!=null}">
                                <c:if test="${commodity.amount>0}">
                                    <span class="had"><b>已售出${commodity.amount}</b></span>
                                </c:if>
                            </c:if>

                            <c:if test="${sessionScope.user.type==2}">
                                <c:if test="${commodity.amount==0}">
                                    <span class="u-btn u-btn-normal u-btn-xs del " data-del="${commodity.id}">删除</span>
                                </c:if>
                            </c:if>
                        </a>
                        <input type="hidden" value="${commodity.id}"/>
                    </li>
                </c:forEach>
            </c:if>
            <c:if test="${noSellCommodityList!=null}">
                <c:forEach var="commodity" items="${noSellCommodityList}">
                    <li>
                        <input type="hidden" value="${commodity.id}"/>
                        <a class="link"
                           href="${pageContext.request.contextPath}/commodity/detail?id=${commodity.id}">
                            <div class="img">
                                <c:if test="${commodity.image_source==2}">
                                    <img src="<%=path%>${commodity.imgUrl}"
                                    >
                                </c:if>
                                <c:if test="${commodity.image_source==1}">
                                    <img src="${commodity.imgUrl}"
                                    >
                                </c:if>
                            </div>
                            <h3>${commodity.title}</h3>
                            <div class="price"><span class="v-unit">¥</span><span
                                    class="v-value">${commodity.price}</span>
                            </div>
                            <c:if test="${commodity.amount==0}">
                                <span class="u-btn u-btn-normal u-btn-xs del" data-del="${commodity.id}">删除</span>
                            </c:if>
                        </a>
                        <input type="hidden" value="${commodity.id}"/>
                    </li>
                </c:forEach>
            </c:if>


        </ul>
    </div>

</div>
</body>
</html>
