<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../statics/css/layui.css">
<script src="../../statics/layui.js"></script>

<header class="layui-header">
    <ul class="layui-nav" >
        <c:if test="${empty user}">
        <li class="layui-nav-item layui-this layui-unselect" id="a"><a href="">老人看护系统</a></li>
        </c:if>
        <c:if test="${!empty user}">
            <li class="layui-nav-item layui-this layui-unselect" id="a"><a href="/">老人看护系统</a></li>
        </c:if>

        <c:if test="${empty user}">
            <li class="layui-nav-item" style="float: right"><a href="/user/register">注册</a></li>
            <li class="layui-nav-item" style="float: right"><a href="/user/login">
                <i class="layui-icon layui-icon-username"></i>登录</a></li>
        </c:if>
        <c:if test="${!empty user}">
            <li class="layui-nav-item" style="float: right">
                <a href=""><i class="layui-icon layui-icon-username">&nbsp;</i>${user.userName}</a>
            <dl class="layui-nav-child">
                <dd><a href="/user/detail/${user.id}">个人中心</a> </dd>
                <dd><a href="javascript:signout_confirm()">退出</a> </dd>
            </dl>
            </li>
        </c:if>
    </ul>
</header>


<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use(['element','jquery'], function(){
        var element = layui.element;
        var $=layui.$;
        $("#b").click(function(){
            $("#a").removeClass("layui-this ");
            $("#b").addClass("layui-this");

        });
    });
    function signout_confirm()
    {
        layui.use('layer', function(){
            var layer = layui.layer;

            layer.confirm('确定退出?', {icon: 3, title:'提示'}, function(index){
                window.location.href="/user/logout";
                layer.close(index);
            });
        });


    }
</script>
