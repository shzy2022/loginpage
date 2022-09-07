<%--
  Created by IntelliJ IDEA.
  User: HYL
  Date: 2022/9/2
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />--%>
    <title>用户登录</title>
</head>
<body>
<div style="text-align: center" align="center">
    <form action="login" method="post" id="loginForm">
        <span>姓名:</span><input type="text" name="name" id="name" value="${model.object.name}"><br/>
        <span>密码:</span><input type="password" name="pwd" id="pwd" value="${model.object.password}"><br/>
        <span id="msg" style="font-size: 12px;color:red"> ${model.msg} </span><br/>
        <button type="button" id="loginBtn">登录</button>
        <button type="button">注册</button>
    </form>


</div>

</body>
<%--引入js--%>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $("#loginBtn").click(function(){
        //获取姓名密码
        const name = $("#name").val();
        const pwd = $("#pwd").val();
        if (isEmpty(name)){
            $("#msg").html("用户名不可为空");
            return;
        }
        if (isEmpty(pwd)){
            $("#msg").html("密码不可为空");
            return;
        }
        $("#loginForm").submit();
    });

    /**
     * 判断字符串是否为空
     * @param str
     * @returns {boolean}
     */
    function isEmpty(str){
        if(str==null || str.trim() == ""){
            return true;
        }
        return false;
    }

</script>
</html>
