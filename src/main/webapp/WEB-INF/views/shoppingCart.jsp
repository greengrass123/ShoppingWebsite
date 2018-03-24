<%@ page import="com.netease.shopping.entity.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.alibaba.druid.support.json.JSONUtils" %>
<%@ page import="com.alibaba.druid.support.json.JSONWriter" %>
<%@ page import="com.alibaba.druid.support.json.JSONParser" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuanchuang
  Date: 2018-3-13
  Time: 15:41:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ShoppingCart> shoppingCartList = (List<ShoppingCart>) request.getAttribute("shoppingCartList");
    String shoppingCarts = JSONObject.toJSONString(shoppingCartList);


%>
<html>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/style.css">
<head>
    <title>购物车</title>
    <jsp:include page="top.jsp" flush="true"></jsp:include>
    <script>
        ctx="${pageContext.request.contextPath}";
    </script>
    <script>
        $(function () {
            $("#shoppingCartButton").click(function () {
//                var scCheckbox=$(".SCCheckbox");
                <!--可以选择支付的商品，不用全部支付-->
//                var commodityIds=new Array();
//                for ( var i = 0; i < scCheckbox.length; i++) {
//                    alert(scCheckbox[i].value);
//                    commodityIds.push($.trim(scCheckbox[i].value));
//                }
                var shoppingCartList = JSON.stringify(<%=shoppingCarts%>);
                if(shoppingCartList=="[]"){
                    alert("购物车为空");
                    return;
                }

                $.ajax({
                    type: "post",
                    contentType: "application/json",
                    url: "${pageContext.request.contextPath}/purchase/settlement",
                    data: shoppingCartList,
                    success: function (data) {
                        alert(data);
                    },
                    error: function (data) {
                        console.log(data);

                    }
                });
            });
        });
    </script>
</head>
<body>
</div>
<div class="g-doc" id="settleAccount">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已添加到购物车的内容</h2>
    </div>
    <c:if test="${shoppingCartList!=null}">
        <table class="table" class="m-table m-table-row n-table g-b3">
            <thead>
            <tr>
                <th>标题</th>
                <th>价格</th>
                <th>数量</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${shoppingCartList}" var="shoppingCart">
                <tr>
                    <td>${commodityHashMap.get(shoppingCart.commodityID).title}</td>
                    <td>${shoppingCart.price}</td>
                    <td>${shoppingCart.amount}</td>
                        <%--<td><input type="hidden" class="SCCheckbox" value="${shoppingCart.commodityID}"> </td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div id="act-btn">
            <button class="u-btn u-btn-primary" id="back" onclick="javascript:history.go(-1);">退出</button>
            <button class="u-btn u-btn-primary" id="shoppingCartButton" value="购买">购买</button>
        </div>
    </c:if>

</div>


</body>
</html>
