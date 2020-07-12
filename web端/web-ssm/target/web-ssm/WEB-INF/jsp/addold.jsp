<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../statics/css/layui.css">
<script src="../../statics/layui.js"></script>
<html>
<head>
    <title>发帖</title>
</head>
<body>
<%@include file="header.jsp"%>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>增加老人</legend>
</fieldset>

<form class="layui-form" action="/old/add" method="post">
<div class="layui-form-item">
    <div class="layui-form-item">
        <label class="layui-form-label">老人姓名</label>
        <div class="layui-input-block">
            <input name="username" class="layui-input" type="text" id="username" placeholder="" autocomplete="off" lay-verify="title">
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
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-inline">
            <input name="age" class="layui-input" id="age" type="text" autocomplete="off">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
            <input name="phone" class="layui-input" id="phone" type="tel" autocomplete="off" lay-verify="required|phone">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">健康状况</label>
        <div class="layui-input-block">
            <input name="health_state" class="layui-input" type="text" id="health_state" placeholder="" autocomplete="off" lay-verify="title">
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
