
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="../../statics/css/layui.css">
<!-- 引入 Bootstrap -->
<!-- 包括所有已编译的插件 -->
<!-- 引入 Bootstrap -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- 包括所有已编译的插件 -->
<script src="../../statics/js/bootstrap.min.js"></script>
<script src="../../statics/layui.js"></script>
<script src="https://cdn.staticfile.org/jquery/2.2.4/jquery.min.js"></script>
<html>
<head>
    <title>欢迎来到老人看护系统!</title>
    <script>
        function showTime(tempDate)
        {
            var d = new Date(tempDate);
            var year = d.getFullYear();
            var month = d.getMonth();
            month++;
            var day = d.getDate();
            var hours = d.getHours();

            var minutes = d.getMinutes();
            var seconds = d.getSeconds();
            month = month<10 ? "0"+month:month;
            day = day<10 ? "0"+day:day;
            hours = hours<10 ? "0"+hours:hours;
            minutes = minutes<10 ? "0"+minutes:minutes;
            seconds = seconds<10 ? "0"+seconds:seconds;


            var time = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
            return time;
        }
        </script>
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

        <table class="layui-table" lay-data="{width: 1302, height:600,url:'/eventlistjson/', page:true, id:'eventt'}" lay-filter="demo">
            <thead>
            <tr>
                <th lay-data="{field:'id', width:100}">id</th>
                <th lay-data="{field:'event_type', width:80}">事件类型</th>
                <th lay-data="{field:'event_date', width:180,templet:'#createDateTpl'}">时间</th>
                <th lay-data="{field:'event_location', width:220}">地点</th>
                <th lay-data="{field:'event_desc', width:180}">事件描述</th>
                <th lay-data="{field:'oldid', width:80, }">老人ID</th>

                <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
            </tr>
            </thead>
        </table>
        <table class="layui-hide" id="LAY_table_user" lay-filter="demo"></table>
        <script type="text/html" id="createDateTpl">
            {{layui.util.toDateString(d.event_date, 'yyyy-MM-dd HH:mm:ss')}}
        </script>

        <script id="barDemo" type="text/html">
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">确认</a>
        </script>
        <script type="text/html" id="dateTpl">
            {{layui.util.toDateString(new Date(d.event_date).getTime(), "yyyy-MM-dd") }}
        </script>
        <script src="../../statics/layui.js" charset="utf-8"></script>
        <script>
            layui.use(['util','table'], function(){
                var table = layui.table;
                //监听工具条
                var util=layui.util;

                table.on('tool(demo)', function(obj){

                    if(obj.event === 'del'){
                        var data = obj.data;
                        layer.confirm('真的确认吗', function(index){
                            obj.del();
                            layer.close(index);
                            layer.open({
                                type: 2,
                                shadeClose: true, //点击遮罩区域是否关闭页面
                                shade: 0.8,  //遮罩透明度
                                area: ['200px', '100px'],
                                content: '/deleteevent/'+data.id
                            });
                        });

                    }
                });

                $('.demoTable .layui-btn').on('click', function(){
                    var type = $(this).data('type');
                    active[type] ? active[type].call(this) : '';
                });
            });
        </script>

        <!--table日期转换格式-->
        <script>
            function Format(datetime,fmt) {
                if (parseInt(datetime)==datetime) {
                    if (datetime.length==10) {
                        datetime=parseInt(datetime)*1000;
                    } else if(datetime.length==13) {
                        datetime=parseInt(datetime);
                    }
                }
                datetime=new Date(datetime);
                var o = {
                    "M+" : datetime.getMonth()+1,                 //月份
                    "d+" : datetime.getDate(),                    //日
                    "h+" : datetime.getHours(),                   //小时
                    "m+" : datetime.getMinutes(),                 //分
                    "s+" : datetime.getSeconds(),                 //秒
                    "q+" : Math.floor((datetime.getMonth()+3)/3), //季度
                    "S"  : datetime.getMilliseconds()             //毫秒
                };
                if(/(y+)/.test(fmt))
                    fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));
                for(var k in o)
                    if(new RegExp("("+ k +")").test(fmt))
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
                return fmt;
            }
        </script>
    </div>
    <div class="layui-footer">
        老人看护系统
    </div>
</div>
</body>
</html>
