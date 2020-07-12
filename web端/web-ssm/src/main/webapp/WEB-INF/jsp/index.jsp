
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
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;">系统设置模块</a>
                    <dl class="layui-nav-child">

                    </dl>
                </li>
                <li class="layui-nav-item "><a href="javascript:;">老年人信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/addold">增加老人</a></dd>
                        <dd><a href="/old">老人信息</a></dd>
                        <dd><a href="/oldchart">老人信息统计分析</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;">工作人员信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/addemployee">增加工作人员</a></dd>
                        <dd><a href="/employee">工作人员信息</a></dd>
                        <dd><a href="/employeechart">工作人员信息统计分析</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item"><a href="javascript:;">义工信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/addvolunteer">增加义工</a></dd>
                        <dd><a href="/volunteer">义工信息</a></dd>
                        <dd><a href="/volunteerchart">义工信息统计分析</a></dd>
                    </dl></li>
                <li class="layui-nav-item"><a href="javascript:;">数据管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/event1">实时数据</a></dd>
                        <dd><a href="/event">事件列表</a></dd>
                    </dl></li>

                <li class="layui-nav-item"><a href="javascript:;">摄像头管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/camera1">摄像头1</a></dd>
                        <dd><a href="/camera2">摄像头2</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
    <c:if test="${!empty user}">
        <img id="img" src="/userPic/index.jpg" alt="aa" style="width:100%;height: 100%">
    </c:if>
    <c:if test="${empty user}">
        您无权访问
    </c:if>
    </div>
    <div class="layui-footer">
        老人看护系统
    </div>
</div>
</body>
</html>
