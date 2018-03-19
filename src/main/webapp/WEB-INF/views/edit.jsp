<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-3-9
  Time: 16:50:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
%>
<html>
<script type="text/javascript">
    ctx ="<%=path%>";//定义图片访问路径前缀
</script>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="../js/publish.js"></script>
<link rel="stylesheet" href="../css/style.css">
<head>
    <jsp:include page="top.jsp" flush="true"></jsp:include>

    <title>Title</title>
</head>
<body>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>内容编辑</h2>
    </div>
    <div class="n-public">
        <form class="m-form m-form-ht" id="form" method="post"
              action="${pageContext.request.contextPath}/commodity/upadteCommodity" enctype="multipart/form-data"
              autocomplete="off">
            <div class="fmitem">
                <label class="fmlab">标题：</label>
                <div class="fmipt">
                    <input class="u-ipt ipt" id="title" name="title" value="${commodity.title}" autofocus
                           placeholder="2-80字符"/>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">摘要：</label>
                <div class="fmipt">
                    <input class="u-ipt ipt" name="summary" id="summary" value="${commodity.summary}"
                           placeholder="2-140字符"/>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">图片：</label>
                <div class="fmipt">
                    <input type="radio" name="image" value="1">图片地址
                    <input type="radio" name="image" value="2">本地上传
                </div>

            </div>
            <div class="fmitem">
                <label class="fmlab"></label>
                <input type="text" placeholder="图片地址" name="imgPath"
                       <c:if test="${commodity.image_source==1}">value="${commodity.imgUrl}" </c:if> id="urlImage">
                <div class="fmipt" id="fileUpload">
                    <input class="u-ipt ipt" name="imgUrl" type="file" placeholder="选择文件" id="imgUrl"/>
                    <button class="u-btn u-btn-primary" id="upload">上传</button>
                    <input type="hidden" name="imgPath" id="imgPath"
                           <c:if test="${commodity.image_source==2}">value="${commodity.imgUrl}" </c:if> />
                </div>
            </div>

            <div class="fmitem">
                <label class="fmlab">正文：</label>
                <div class="fmipt">
                    <textarea class="u-ipt" name="text" rows="10" id="text"
                              placeholder="2-1000个字符">${commodity.text}</textarea>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">价格：</label>
                <div class="fmipt">
                    <input class="u-ipt price" name="price" id="price" value="${commodity.price}"/>元
                </div>
            </div>
            <input type="hidden" name="id" value="${commodity.id}">
            <div class="fmitem fmitem-nolab fmitem-btn">
                <div class="fmipt">
                    <button type="submit" class="u-btn u-btn-primary u-btn-lg">发 布</button>
                </div>
            </div>

        </form>
        <span class="imgpre edit_image_span" > <img
        <c:choose>
                <c:when test="${commodity.image_source==1}">src="${commodity.imgUrl}" </c:when>
            <c:when test="${commodity.image_source==2}">src="<%=path%>${commodity.imgUrl}"
        </c:when>
        </c:choose> id="publishImg"></span>
    </div>
</div>

</body>
</html>
