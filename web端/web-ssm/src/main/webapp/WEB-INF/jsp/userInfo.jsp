<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../statics/css/layui.css">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 引入 Bootstrap -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- 包括所有已编译的插件 -->
<script src="../../statics/js/bootstrap.min.js"></script>
<script src="../../statics/layui.js"></script>
<style>
    .fly-panel {
        margin-bottom: 15px;
        border-radius: 2px;
        background-color: #fff;
        box-shadow: 0px 1px 2px 0px rgba(0,0,0,0.05);
    }
    .fly-panel-title {
        position: relative;
        height: 50px;
        line-height: 50px;
        padding: 0 15px;
        border-bottom: 1px dotted #E9E9E9;
        color: #333;
        border-radius: 2px 2px 0 0;
        font-size: 14px;
    }
    .fly-home-jie .jie-row, .fly-home-da .home-jieda {
        min-height: 500px;
        padding: 5px 20px;
    }
    .home-jieda li {
        margin-bottom: 20px;
        line-height: 24px;
    }
    .home-jieda li p {
        color: #999;
    }
    .home-jieda li a {
        padding: 0 5px;
        color: #4f99cf;
    }
    .home-dacontent {
        margin-top: 10px;
        padding: 10px 15px;
        background-color: #f2f2f5;
        border-radius: 5px;
        word-wrap: break-word;
    : ;
    }
    .jie-row li .jie-title {
        max-width: 70%;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }


</style>
<html>
<head>
    <title>${user.userName}的资料</title>
</head>
<body>
<%@include file="header.jsp"%>
<div style="
    position: relative;
    padding: 30px 0 30px;
    text-align: center;
    margin-bottom: 15px;
    border-radius: 2px;
    background-color: #fff;
    box-shadow: 0px 1px 2px 0px rgba(0,0,0,0.05);
">
        <img id="img" src="/userPic/pic.jpg" alt="aa" style="width: 120px;height: 120px;border-radius: 100%">
        <br/>
    <h1>${sysUser.userName}</h1>
    <c:if test="${sysUser.sex=='男'}">
        <i class="layui-icon">&#xe662;</i>
    </c:if>
    <c:if test="${sysUser.sex=='女'}">
        <i class="layui-icon">&#xe661;</i>
    </c:if>
    <br/>
    <span>邮箱: ${sysUser.email}</span>
    <br/>
    <br/>
    <span>电话:${sysUser.phone}</span>
    <p style="
    padding: 0 10px;
    color: #999;
    margin-top: 10px;">
    </p>
    <br/>
        <button type="button" class="layui-btn" id="up">
            <i class="layui-icon">&#xe67c;</i>更改头像
        </button>
    <br/>

    <br/><a href="/user/info_submit/${sysUser.id}">
    <button type="button" class="layui-btn" id="bianji">
        <i class="layui-icon"></i>个人信息编辑
    </button>
    </a>
    <br/>
</div>

<script>
    layui.use(['jquery','upload'], function(){
        var $ = layui.$;
        var upload = layui.upload;
        if (${!empty sysUser.logoimage}) {
            $("#img").attr("src"," ${sysUser.logoimage}");
        }

        //执行实例
        var uploadInst = upload.render({
            elem: '#up' //绑定元素
            ,url: '/upload/usericon/' //上传接口
            ,done: function(res){
                $("#img").attr("src",res.path);
            }
            ,error: function(){
                layer.msg("上传失败");
            }
            ,accept:'images'
            ,size:500
            ,number:1
            ,data: {
                id: '${sysUser.id}'
            }
        });
    });
</script>
</body>
</html>
