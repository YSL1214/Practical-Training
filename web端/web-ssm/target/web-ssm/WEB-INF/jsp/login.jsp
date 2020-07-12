
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="../../statics/css/layui.css">
<script src="../../statics/layui.js"></script>

<html>
<head>
    <title>用户登录</title>
</head>
<body>
<%@include file="header.jsp"%>
<div style="width: 80%;height: 60%;margin: 0 auto;">
    <div style="width: 80%; height: 20%"></div>
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-md8">
            <img src="/userPic/denglu.jpg" alt="aa" style="width:100%;height: 70%">
        </div>
        <div class="layui-col-xs6 layui-col-md4">
            <div class="layui-card">
                <div class="layui-card-header">登陆</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="/loginSuccess" method="post">

                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名:</label>
                            <div class="layui-input-block">
                                <input type="text" name="username" id="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                            </div>
                            <div id="checkUN" class="layui-form-mid layui-word-aux"></div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码:</label>
                            <div class="layui-input-block">
                                <input type="password" name="password" id="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" id="submit" lay-submit lay-filter="formDemo">登录</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
<script>
    layui.use(['form','layer','jquery'], function(){
        var form = layui.form;
        var layer=layui.layer;
        var $=layui.$;
        form.on('submit(formDemo)', function(){
            var name = $('#username').val();
            var pwd=$('#password').val();
            var flag=0;
            $.ajax({
                url:"/checkLogin",
                type:"post",
                data:{"username":name,"password":pwd},
                dataType:"json",
                async:false,
                success:function(data){
                    flag=data;
                }
            });
            switch (flag) {
                case 0:
                    return true;
                case 1:
                    layer.msg("密码错误！");
                    return false;
                case 2:

                    layer.msg("用户名不存在！");
                    return false;
            }
        });
            });

        //判断用户名是否存在
        layui.use(['jquery', 'layer'], function(){
            var $ = layui.$ //重点处
                ,layer = layui.layer;
            $(document).ready(function(){
                check();
            });
            function check() {
                $('#username').blur(function () {
                    var name = $('#username').val();

                    $.ajax({
                        url:"/checkUser",
                        type:"post",
                        data:{"userName":name},
                        dataType:"json",
                        success:function(data){
                            if (data === true) {
                                document.getElementById("checkUN").innerHTML ="    <i class=\"layui-icon layui-icon-ok-circle\" style=\"font-size: 30px; color: #39ac47;\"></i>\n" ;

                            } else {
                                document.getElementById("checkUN").innerHTML = "用户名不存在";

                            }
                        }
                    });


                });
            }
            });
</script>
</html>
