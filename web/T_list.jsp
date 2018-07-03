<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bean.users.user_list" %>
<%@ page import="bean.users" %>
<%@ page import="bean.Reservation" %>
<%@ page import="bean.Table" %>
<%@ page import="java.lang.ref.SoftReference" %>
<%--
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
    <title>餐桌列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 资讯管理 <span class="c-gray en">&gt;</span> 资讯列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">

    <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a class="btn btn-primary radius" data-title="添加资讯" data-href="walkin_add.jsp" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加Walkin</a></span> </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="" value=""></th>
                <th width="80">餐桌编号</th>
                <th width="80">可容纳人数</th>
                <th width="80">已有预约</th>
                <th width="60">餐桌状态</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="tables" class="bean.TableList" scope="request"/>

            <%
                request.setCharacterEncoding("utf-8");
                String sql = null;
                String date = request.getParameter("R_date");
                String R_name = request.getParameter("c_name");
                String R_tel = request.getParameter("c_tel");
                String R_sum = request.getParameter("c_sum");
                String R_time_start = request.getParameter("r_start_time");
                String R_time_end = request.getParameter("r_end_time");

                //保存数据到session

                session.setAttribute("date", date);
                session.setAttribute("R_name", R_name);
                session.setAttribute("R_tel", R_tel);
                session.setAttribute("R_sum", R_sum);
                session.setAttribute("R_time_start", R_time_start);
                session.setAttribute("R_time_end", R_time_end);
                //上面的参数作为新建预约传进来的参数
                /**
                 *  String date = "2018-07-04";
                 *  String date_start = "2018-07-04 18:00:00";
                 *  String date_end = "2018-07-04 19:00:00";
                 *  String number = "8";
                 */

                if (date == null || R_time_start == null || R_time_end == null || R_sum == null)
                    sql = "select * from `tables`";
                else {
                    String sql1 = "SELECT T_id FROM reservation WHERE reservation.R_date = '" + date + "' and ";
                    String sql2 = "reservation.R_time_start > '" + R_time_start + "'OR reservation.R_time_end < '"
                            + R_time_end + "')";
                    sql = "SELECT distinct * FROM `tables`T WHERE T.places >= " + R_sum + " and T.table_id not IN ("
                            +sql1 + sql2 ;
                    System.out.println(sql);
                }
                tables.setList(sql);
                ArrayList tablelist = tables.getList();
                java.util.Iterator iter = tablelist.iterator();
                while (iter.hasNext()) {
                    Table table = (Table) iter.next();
            %>

            <tr class="text-c">
                <td><input type="checkbox" value="" name=""></td>
                <td class="text-l">
                    <u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','table_reservation.jsp?table_id=<%= table.getTable_id()%>')" title="查看"><%= table.getTable_id()%></u>
                </td>
                <td><%= table.getPlaces()%></td>
                <td><%= table.getNumber()%></td>
                <% if (table.getRun() == 0) { %>
                <td class="td-status"><span class="label label-success radius">未占用</span></td>
                <% } %>
                <% if (table.getRun() == 1){%>
                <td class="td-status"><span class="label label-danger radius">已占用</span></td>
                <% } %>
                <td class="f-14 td-manage">
                    <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
                </td>
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
        "aaSorting": [[ 1, "asc" ]],//默认第几个排序
        //"bStateSave": true,//状态保存
        "pading":false,
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            //{"orderable":false,"aTargets":[0,8]}// 不参与排序的列
        ]
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
            content: url + "?id=" + id,
            width: w,
            hight: h,
        });
        layer.full(index);
    }

    /*资讯-修改*/
    function article_select(obj, URL){
        //url: url + '?id=' + id,
        layer.confirm('确认要选择该餐桌吗？',function(index){
            $.ajax({
                type: 'POST',
                url: URL,
                success: function(data){
                    layer.msg('新建预约完成!',{icon:1,time:1000});
                    window.setTimeout("window.location='OkReservation.jsp'",2000);
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }

    /*查看*/
    function article_edit(title, url, obj, id){
        layer_show(title, url);
    }

    /*预约-删除*/
    function article_del(obj,id){
        layer.confirm('确认要删除该餐桌吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '/R_deleteController?id=' + id,
                success: function(data){
                    $(obj).parents("tr").remove();
                    layer.msg('已删除该餐桌!',{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }

    /*资讯-审核*/
    function article_shenhe(obj,id){
        layer.confirm('审核文章？', {
                btn: ['通过','不通过','取消'],
                shade: false,
                closeBtn: 0
            },
            function(){
                $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
                $(obj).remove();
                layer.msg('已发布', {icon:6,time:1000});
            },
            function(){
                $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
                $(obj).remove();
                layer.msg('未通过', {icon:5,time:1000});
            });
    }
    /*资讯-下架*/
    function article_stop(obj,id,title, url, w, h){
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
