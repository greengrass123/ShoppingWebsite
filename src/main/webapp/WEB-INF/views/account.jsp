<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-3-13
  Time: 00:16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<html>
<link rel="stylesheet" href="../css/style.css">
<head>
    <title>Title</title>
    <jsp:include page="top.jsp" flush="true"></jsp:include>
</head>
<body>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <c:if test="${purchaseList!=null}">
        <table class="m-table m-table-row n-table g-b3">
            <colgroup><col class="img"/><col/><col class="time"/><col class="price"/></colgroup>
            <thead>
            <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>购买价格</th></tr>
            </thead>
            <tbody>
            <c:forEach items="${purchaseList}" var="purchase">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/commodity/detail?id=${purchase.commodityID}">
                        <c:if test="${commodityHashMap.get(purchase.commodityID).image_source==2}">
                            <img src="<%=path%>${commodityHashMap.get(purchase.commodityID).imgUrl}" width="100px" height="100px" alt="">
                        </c:if>
                        <c:if test="${commodityHashMap.get(purchase.commodityID).image_source==1}">
                            <img src="${commodityHashMap.get(purchase.commodityID).imgUrl}" width="100px" height="100px" alt="">
                        </c:if>

                    </a></td>
                    <td><h4><a style="color:black" href="${pageContext.request.contextPath}/commodity/detail?id=${purchase.commodityID}">${commodityHashMap.get(purchase.commodityID).title}</a></h4></td>
                    <td><span class="v-time">${purchase.buy_time}</span></td>
                    <td><span class="v-unit">¥</span><span class="value">${purchase.price}</span></td>
                </tr>
            </c:forEach>

            </tbody>
            <tfoot>
            <tr>
                <td colspan="3"><div class="total">总计：</div></td>
                <td><span class="v-unit">¥</span><span class="value">${total}</span></td>
            </tr>
            </tfoot>
        </table>
    </c:if>

</div>
</body>
</html>
