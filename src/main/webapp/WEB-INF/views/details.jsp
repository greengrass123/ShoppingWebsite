<%--
  Created by IntelliJ IDEA.
  User: yuanchuang
  Date: 2018-3-9
  Time: 16:28:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="top.jsp" flush="true" />
<div class="g-doc">
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="http://img3.redocn.com/tupian/20150430/mantenghuawenmodianshiliangbeijing_3924704.jpg" alt="" ></div>
        <div class="cnt">
            <h2>asdasd</h2>
            <p class="summary">dassadsadsda</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">100</span>
            </div>
            <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">7</span><span id="addNum" class="moreNum"><a>+</a></span></div>
            <div class="oprt f-cb">
                <a href="/edit?id=4" class="u-btn u-btn-primary">编 辑</a>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        asdsad
    </div>
</div>

</body>
</html>
