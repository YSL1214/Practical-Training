<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../statics/css/layui.css">
<script src="../../statics/layui.js"></script>
<html>
<head>
    <title>系统管理员个人资料设置</title>
</head>
<body>
<%@include file="header.jsp"%>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>${sysUser.userName}的个人信息</legend>
</fieldset>

<form class="layui-form" action="/user/info_edit/${sysUser.id}" method="post" accept-charset="GBK">
<div class="layui-form-item">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input name="username" class="layui-input" type="text" id="username" placeholder="" autocomplete="off" lay-verify="title">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input name="password" class="layui-input" type="text" id="password" placeholder="" autocomplete="off" lay-verify="title">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">真实姓名</label>
        <div class="layui-input-block">
            <input name="realname" class="layui-input" type="text" id="realname" placeholder="" autocomplete="off" lay-verify="title">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input name="sex"  title="男" type="radio" checked="" value="男">
            <input name="sex"  title="女" type="radio" value="女">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">phone:</label>
        <div class="layui-input-inline">
            <input name="phone" class="layui-input" id="phone" type="tel" autocomplete="off" lay-verify="required|phone">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">mobile:</label>
        <div class="layui-input-inline">
            <input name="mobile" class="layui-input" type="tel" id="mobile" autocomplete="off" lay-verify="required|phone">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">email：</label>
        <div class="layui-input-inline">
            <input name="email" class="layui-input" type="text" id="email" autocomplete="off" lay-verify="email">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">描述</label>
        <div class="layui-input-block">
            <input name="desc" class="layui-input" type="text" id="desc" placeholder="" autocomplete="off" lay-verify="title">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</div>
</form>

</body>
<script>
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function(data){
            return true;
        });
    });
</script>
</html>
