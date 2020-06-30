
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="../../statics/css/layui.css">
<!-- 引入 Bootstrap -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- 包括所有已编译的插件 -->
<script src="../../statics/js/bootstrap.min.js"></script>
<script src="../../statics/layui.js"></script>
<html>
<head>
    <title>欢迎来到老人看护系统!</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <%@include file="header.jsp"%>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item"><a href="">侧边栏导航</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <iframe src="https://www.baidu.com/" frameborder="0" height="100%" width="100%"></iframe>
    </div>
    <div class="layui-footer">
        你好
    </div>
</div>
</body>
</html>
