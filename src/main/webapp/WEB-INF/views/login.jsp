<%--
  Created by IntelliJ IDEA.
  User: yuanchuang
  Date: 2018-3-4
  Time: 13:05:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/login.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/md5.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<head>
    <title>Title</title>
    <script>
        ctx="${pageContext.request.contextPath}";
    </script>

</head>
<body style="background: url('${pageContext.request.contextPath}/images/login_bg.jpg')  no-repeat center;">
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">

            <form method="post" class="form-horizontal" role="form"
                  action="${pageContext.request.contextPath}/user/loginJump" id="loginForm"
                  onsubmit="return loginFunc(this);">
                <p class="message">用户登录</p>
               <br><br>
                <div class="form-group">
                    <label for="userName" class=" control-label">用户名</label>
                    <input type="text" name="userName" id="userName" placeholder="请输入用户名"/>
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    <label for="beforePassword" class="control-label">密码</label>
                        <input type="password" name="beforePassword" id="beforePassword" placeholder="请输入密码"/>
                    <i class="fa fa-lock"></i>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-4">
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>


</html>
