
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="../../statics/css/layui.css">
<!-- 引入 Bootstrap -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- 包括所有已编译的插件 -->
<script src="../../statics/js/bootstrap.min.js"></script>
<script src="../../statics/layui.js"></script>
<script src="https://cdn.staticfile.org/jquery/2.2.4/jquery.min.js"></script>
<!-- 引入 echarts.js -->
<script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
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
        <div id="main" style="width: 800px;height:450px;"></div>
        <script type="text/javascript">
            $(document).ready(function(){
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));
                //数据加载完之前先显示一段简单的loading动画
                myChart.showLoading();
                var names=[];    //横坐标数组（实际用来盛放X轴坐标值）
                var values=[];    //纵坐标数组（实际用来盛放Y坐标值）
                $.ajax({
                    type : "post",
                    async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                    url : "/volunteerechart",    //请求发送到dataActiont处
                    data : {},
                    dataType : "json",        //返回数据形式为json
                    success : function(result) {
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
                        if (result) {
                            for(var i=0;i<result.length;i++){
                                names.push(result[i].divage);
                                values.push(result[i].num);
                            }
                            myChart.hideLoading();    //隐藏加载动画
                            myChart.setOption({
                                //加载数据图表
                                title:{
                                    text: '志愿者年龄统计图'
                                },

                                legend: {
                                    data:['志愿者年龄']
                                },
                                xAxis: {
                                    data: names,
                                    axisLabel:{
                                        interval: 0
                                    }

                                },
                                yAxis: {
                                    type: 'value'
                                },
                                series: [{
                                    // 根据名字对应到相应的系列
                                    name: '志愿者年龄',
                                    type: 'bar',
                                    data: values
                                }]
                            });
                        }
                    },
                    error : function(errorMsg) {
                        //请求失败时执行该函数
                        alert("图表请求数据失败!"+errorMsg[0].length);
                        myChart.hideLoading();
                    }
                });//end ajax
            });
        </script>
    </div>

    <div class="layui-footer">
        老人看护系统
    </div>
</div>
</body>
</html>
