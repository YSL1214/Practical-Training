
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
<img id="img" src="/userPic/pic.jpg" onerror=this.src="/userPic/pic.jpg" style="width: 400px; height: 400px" >

<br/>
<button type="button" class="layui-btn" id="up">
    <i class="layui-icon">&#xe67c;</i>更改头像
</button>
<br/>


<script>
    layui.use(['jquery','upload'], function(){
        var $ = layui.$;
        var upload = layui.upload;
        if (${!empty employee.imgset_dir}) {
            $("#img").attr("src"," ${employee.imgset_dir}");
        }
        //执行实例
        var uploadInst = upload.render({
            elem: '#up' //绑定元素
            ,url: '/upload/oldicon/' //上传接口
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
                id: '${employee.id}'
            }
        });
    });
</script>
</body>
</html>
