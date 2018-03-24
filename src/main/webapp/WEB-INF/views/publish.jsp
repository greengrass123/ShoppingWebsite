
<%--
  Created by IntelliJ IDEA.
  User: yuanchuang
  Date: 2018-3-8
  Time: 20:08:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
%>
<script type="text/javascript">
    ctx ="<%=path%>";//定义图片访问路径前缀

</script>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="../js/publish.js"></script>
<link rel="stylesheet" href="../css/style.css">
<html>

<head>
    <title>发布</title>
    <jsp:include page="top.jsp" flush="true"></jsp:include>
</head>
<body>

<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>内容发布</h2>
    </div>

    <div class="n-public">
        <form class="m-form m-form-ht" id="form" method="post"
              action="${pageContext.request.contextPath}/commodity/addCommodity" enctype="multipart/form-data"
              autocomplete="off"  onsubmit="return checkdata(this);">
            <div class="fmitem">
                <label class="fmlab">标题：</label>
                <div class="fmipt">
                    <input class="u-ipt ipt" name="title" id="title" autofocus placeholder="2-80字符"/>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">摘要：</label>
                <div class="fmipt">
                    <input class="u-ipt ipt" name="summary" id="summary" placeholder="2-140字符"/>
                </div>
            </div>

            <div class="fmitem">
                <label class="fmlab">图片：</label>
                <div class="fmipt">
                    <input type="radio" name="image" value="1">图片地址
                    <input type="radio" name="image" value="2">本地上传
                </div>

            </div>
            <div  class="fmitem">
                <label class="fmlab"></label>
                <input type="text" placeholder="图片地址" name="imgPath" id="urlImage">
                <div class="fmipt" id="fileUpload" >
                    <input class="u-ipt ipt" name="imgUrl" type="file" placeholder="选择文件" id="imgUrl"/>
                    <button class="u-btn u-btn-primary" id="upload">上传</button>
                    <input type="hidden" name="imgPath" id="imgPath"/>
                </div>
            </div>

            <div class="fmitem">
                <label class="fmlab">正文：</label>
                <div class="fmipt">
                    <textarea class="u-ipt" name="text" rows="10" id="text" placeholder="2-1000个字符"></textarea>
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">价格：</label>
                <div class="fmipt">
                    <input class="u-ipt price" name="price" id="price"/>元
                </div>
            </div>
            <div class="fmitem fmitem-nolab fmitem-btn">
                <div class="fmipt">
                    <button type="submit" class="u-btn u-btn-primary u-btn-lg">发 布</button>
                </div>
            </div>
        </form>
        <span class="imgpre"> <img src="${pageContext.request.contextPath}/" id="publishImg" ></span>

    </div>
</div>
</body>


</html>
