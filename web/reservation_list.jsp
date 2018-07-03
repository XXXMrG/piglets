<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bean.users.user_list" %>
<%@ page import="bean.users" %>
<%@ page import="bean.Reservation" %><%--
  Created by IntelliJ IDEA.
  User: xxxmrg
  Date: 2018/6/30
  Time: 下午3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>资讯列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 资讯管理 <span class="c-gray en">&gt;</span> 资讯列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">

    <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a class="btn btn-primary radius" data-title="添加预约" data-href="reservation_add.jsp" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加预约</a></span> </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="" value=""></th>
                <th width="80">预约ID</th>
                <th width="80">客户姓名</th>
                <th width="80">来源</th>
                <th>预约时间</th>
                <th width="75">餐桌编号</th>
                <th width="60">预约状态</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="reservation" scope="request" class="bean.ReservationList"></jsp:useBean>

            <%
                reservation.setList();
                ArrayList list = reservation.getList();
                Iterator <Reservation> it  = list.iterator();
                while(it.hasNext()){
                    Reservation res = it.next();
                    String iswalkin = "预约客户";
                    if (res.isR_isWalkin()){
                        iswalkin = "零散客户";
                    }
            %>
            <tr class="text-c">
                <td><input type="checkbox" value="" name=""></td>
                <td><%= res.getR_id() %></td>
                <td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_show('查看','/ReservationController', <%= res.getR_id() %>)" title="查看"><%= res.getR_name()%></u></td>
                <td><%= iswalkin %></td>
                <td><%= res.getR_date() %></td>
                <td><%=res.getT_id() %></td>
                <% if (res.isR_isOver() == 0) { %>
                    <td class="td-status"><span class="label label-danger radius">未到达</span></td>
                    <td class="f-14 td-manage">
                        <a style="text-decoration:none" onClick="article_over(this, <%= res.getR_id() %>, '确认', '/ReservationController' , '400', '610')" href="javascript:;" title="到达">到达</a>
                        <a style="text-decoration:none" class="ml-5" onClick="article_edit('修改预约','/ReservationController',<%= res.getR_id()%>, '450', '610')" href="javascript:;" title="修改"><i class="Hui-iconfont">&#xe6df;</i></a>
                        <a style="text-decoration:none" class="ml-5" onClick="article_del(this, <%= res.getR_id() %>)" href="javascript:;" title="删除预约"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
                <% } %>
                <% if (res.isR_isOver() == 1) { %>
                    <td class="td-status"><span class="label label-success radius">进行中</span></td>
                <td class="f-14 td-manage">
                    <a style="text-decoration:none" onClick="article_end(this, <%= res.getR_id() %>, '确认', '/ReservationController', '400', '610')" href="javascript:;" title="到达">完成</a>
                    <a style="text-decoration:none" class="ml-5" onClick="article_edit('修改预约','/ReservationController',<%= res.getR_id()%>, '450', '610')" href="javascript:;" title="修改"><i class="Hui-iconfont">&#xe6df;</i></a>
                    <a style="text-decoration:none" class="ml-5" onClick="article_del(this, <%= res.getR_id() %>)" href="javascript:;" title="删除预约"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
                <% } %>
                <% if (res.isR_isOver() == 2) { %>
                    <td class="td-status"><span class="label label-defaunt radius">已完成</span></td>
                <td class="f-14 td-manage">
                    <a style="text-decoration:none" class="ml-5" onClick="article_edit('修改预约','/ReservationController',<%= res.getR_id()%>, '450', '610')" href="javascript:;" title="修改"><i class="Hui-iconfont">&#xe6df;</i></a>
                    <a style="text-decoration:none" class="ml-5" onClick="article_del(this, <%= res.getR_id() %>)" href="javascript:;" title="删除预约"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
                <% } %>

            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $('.table-sort').dataTable({
        "aaSorting": [[ 4, "desc" ]],//默认第几个排序
        //"bStateSave": true,//状态保存
        //"pading":false,
    });

    /*预约-添加*/
    function article_add(title,url,w,h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*预约-查看*/
    function article_show(title,url,id, w, h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url + "?id=" + id + "&flag=" + 1,
        });
        layer.full(index);
    }

    /*资讯-修改*/
    function article_edit(title, url,id, w, h){
        url = url + '?id=' + id + '&flag=' + 2,
        layer_show(title, url, w, h);
    }

    /*预约-删除*/
    function article_del(obj,id){
        layer.confirm('确认要删除预约吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '/R_deleteController?id=' + id,
                success: function(data){
                    $(obj).parents("tr").remove();
                    layer.msg('已删除预约!',{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }

    function article_end(obj,id,title, url, w, h) {
        url = url + '?id=' + id + '&flag=' + 4;
        layer_show(title, url, w, h);
    }

    /*记录到达*/
    function article_over(obj,id,title, url, w, h){

        url = url + '?id=' + id + '&flag=' + 3;
        layer_show(title, url, w, h);


        // layer.confirm('确认要下架吗？',function(index){
        //     $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
        //     $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
        //     $(obj).remove();
        //     layer.msg('已下架!',{icon: 5,time:1000});
        // });
    }

    /*资讯-发布*/
    function article_start(obj,id){
        layer.confirm('确认要发布吗？',function(index){
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
            $(obj).remove();
            layer.msg('已发布!',{icon: 6,time:1000});
        });
    }
    /*资讯-申请上线*/
    function article_shenqing(obj,id){
        $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
        $(obj).parents("tr").find(".td-manage").html("");
        layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
    }

</script>
</body>
</html>
