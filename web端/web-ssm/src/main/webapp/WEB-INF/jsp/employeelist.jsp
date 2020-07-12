
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

        <table class="layui-table" lay-data="{width: 1302, height:600,url:'/employeelistjson/', page:true, id:'oldTable'}" lay-filter="demo">
            <thead>
            <tr>
                <th lay-data="{field:'userName', width:100}">员工姓名</th>
                <th lay-data="{field:'gender', width:80}">性别</th>
                <th lay-data="{field:'age', width:80}">年龄</th>
                <th lay-data="{field:'phone', width:220}">电话</th>
                <th lay-data="{field:'description', width:180, }">描述</th>
                <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
            </tr>
            </thead>
        </table>

        <script id="barDemo" type="text/html">
            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail" >查看</a>
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
        <script src="../../statics/layui.js" charset="utf-8"></script>
        <script>
            layui.use('table', function(){
                var table = layui.table;
                //监听工具条
                table.on('tool(demo)', function(obj){
                    if(obj.event === 'detail'){
                        var data = obj.data;
                        // layer.msg('ID：'+ data.id + ' 的查看操作');
                        layer.open({
                            type: 2,
                            closeBtn: 0, //关闭按钮是否显示 1显示0不显示
                            title: '老人头像' , //页面标题
                            shadeClose: true, //点击遮罩区域是否关闭页面
                            shade: 0.8,  //遮罩透明度
                            area: ['450px', '500px'],  //弹出层页面比例
                            content:'/employee/'+data.id
                        });
                    } else if(obj.event === 'del'){
                        var data = obj.data;
                        layer.confirm('真的删除行么', function(index){
                            obj.del();
                            layer.close(index);
                            layer.open({
                                type: 2,
                                shadeClose: true, //点击遮罩区域是否关闭页面
                                shade: 0.8,  //遮罩透明度
                                area: ['200px', '100px'],
                                content: '/deleteemployee/'+data.id
                            });
                        });
                    } else if(obj.event === 'edit'){
                        var data = obj.data;
                        layer.open({
                            type: 2,
                            shadeClose: true, //点击遮罩区域是否关闭页面
                            shade: 0.8,  //遮罩   透明度
                            area: ['900px', '500px'],
                            content: '/editemployee/'+data.id
                        });
                    }
                });

                $('.demoTable .layui-btn').on('click', function(){
                    var type = $(this).data('type');
                    active[type] ? active[type].call(this) : '';
                });
            });
        </script>
    </div>
    <div class="layui-footer">
        老人看护系统
    </div>
</div>
</body>
</html>
