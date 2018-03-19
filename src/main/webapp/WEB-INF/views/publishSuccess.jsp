<%--
  Created by IntelliJ IDEA.
  User: yuanchuang
  Date: 2018-3-8
  Time: 23:17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../css/style.css">
<%
    String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<html>
<head>
    <title>发布成功</title>
    <jsp:include page="top.jsp" flush="true"></jsp:include>
</head>
<body>

<div class="g-doc">
    <div class="n-result">
        <h3>发布成功！</h3>
        <p><a style="color:black"  href="${pageContext.request.contextPath}/commodity/detail?id=${id}">[查看内容]</a><a style="color:black" href="<%=path%>">[返回首页]</a></p>
    </div>
</div>
</body>
</html>
