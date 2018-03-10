<%--
  Created by IntelliJ IDEA.
  User: yuanchuang
  Date: 2018-3-4
  Time: 13:05:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/md5.js" ></script>
<head>
    <title>Title</title>
    <script>
        function loginFunc(){
            var userName = $("#userName").val();
            var beforePassword = $("#beforePassword").val();
            if(!isNull(userName)&&!isNull(beforePassword)){
                beforePassword=$.md5(beforePassword);
                $("#password").val(beforePassword);
               return true;
            }else{
                alert("请重新输入");
                return false;
            }
        }
        function isNull( str ){
            if ( str == "" ) return true;
            var regu = "^[ ]+$";
            var re = new RegExp(regu);
            return re.test(str);
        }
    </script>
</head>
<body>
<div align=""></div>
<form method="post" action="${pageContext.request.contextPath}/user/Login" id="loginForm" onsubmit="return loginFunc(this);">
    用户名:<input type="text" name="userName" id="userName" placeholder="用户名"/><br/>
    用户密码:<input type="password" name="beforePassword" id="beforePassword" placeholder="密码"/><br/>
    <input type="hidden" name="password" id="password"/><br/>
    <c:if test="${msg!=null }">
        ${msg }<br />
    </c:if>
    <input type="submit" id="submit" value="用户登录"/>
</form>
</body>


</html>
