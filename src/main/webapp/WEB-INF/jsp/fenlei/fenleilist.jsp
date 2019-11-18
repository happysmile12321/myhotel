<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--向外部索要资源--%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>${title}</title><link href="<%=basePath%>assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>assets/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath %>js/demo.js"></script><style type="text/css">
    <!--
    body {
        margin-left: 0px;
        margin-top: 0px;
        margin-right: 0px;
        margin-bottom: 0px;
    }
    .STYLE1 {font-size: 12px}
    .STYLE4 {
        font-size: 12px;
        color: #1F4A65;
        font-weight: bold;
    }

    a:link {
        font-size: 12px;
        color: #06482a;
        text-decoration: none;

    }
    a:visited {
        font-size: 12px;
        color: #06482a;
        text-decoration: none;
    }
    a:hover {
        font-size: 12px;
        color: #FF0000;
        text-decoration: underline;
    }
    a:active {
        font-size: 12px;
        color: #FF0000;
        text-decoration: none;
    }

    -->
</style>
    <%--从内部向外部索要资源--%>
    <script type="text/javascript" src="${path}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#fangjianid").hide();
            $("#fangjianid2").hide();
            /*利用ajax异步刷新请求后台数据*/
            $.ajax({
                url:"http://localhost:8080/javaHM_ssm/ma/ajax_selectRoomType.action",
                type:"post",
                dataType:"json",
                data:{"":""},
                success:function (data) {
                    // alert(data.leixing)
                    $("#roomType").prepend("<option value='0'>请选择</option>");
                    $.each(data,function (index,res) {
                        var roomType = data[index].leixing;
                        var roomId = data[index].id;
                        $("#roomType").append("<option value=" + roomId +">"+roomType+"</option>");
                    })

                },
                error:function () {
                    alert("错误！")
                }
            });

            $("#roomType").on('change',function () {
                var checkValue=$("#roomType").val();  //获取Select选择的Value
                $.ajax({
                    url:"http://localhost:8080/javaHM_ssm/ma/KefangFenleiManage.action",
                    type:"post",
                    dataType:"json",
                    data:{"id":checkValue},
                    success:function (data) {
                        //alert(data.jiage);
                        //alert(data.leixing);
                        //将获取的类型和价格显示到页面上
                        $("#fangjianleixing").text(data.leixing);
                        $("#fangjiajiage").text(data.jiage);
                        //将房间的id号赋值给删除的form表单
                        $("#fangjianid").val(data.id);
                        $("#fangjianid2").val(data.id);
                    },
                    error:function () {
                        alert("错误！")
                    }
                });
            });
        });
    </script>
</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
                <td width="1101" background="images/tab_05.gif" align="center">
                    <span class="STYLE4">${title }</span>
                </td>

                <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td>
            <form action="${url }" method="post">
                &nbsp;&nbsp;&nbsp;<a href="<%=basePath%>${url2}"><span style="font-weight: bold;font-size: 22px;">添加新客房分类</span></a><br/><br/>
                &nbsp;&nbsp;&nbsp;
                房间类型：<select name="leixing" id="roomType">
                <%--<option value="" selected >全部</option>--%>
            </select>
                <input type="submit" value="查询" />
            </form>

            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="9" background="images/tab_12.gif">&nbsp;</td>
                    <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" >
                        <tr>

                            <td  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center"  class="STYLE2 STYLE1">房间类型</div></td>
                            <td  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center"  class="STYLE2 STYLE1">房价 （元/天）</div></td>
                            <td width="20%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">操作</div></td>
                        </tr>

                            <tr>
                                <td  height="18" bgcolor="#FFFFFF"><div align="center" id="fangjianleixing" class="STYLE2 STYLE1"></div></td>
                                <td  height="18" bgcolor="#FFFFFF"><div align="center" id="fangjiajiage" class="STYLE2 STYLE1"></div></td>
                                <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
                                    <form action="<%=basePath%>/ma/jumpToUpdateRoomType.action" method="post">
                                        <input align="center" id="fangjianid2"  name="id" class="STYLE2 STYLE1"></input>
                                        <input type="submit" value="修改"/>
                                    </form>

                                    <form action="<%=basePath%>/ma/deleteRoomType.action" method="post">
                                        <input align="center" id="fangjianid"  name="id" class="STYLE2 STYLE1"></input>
                                        <input type="submit" value="删除" onclick=" return confirm('确定要删除吗?'); "/>
                                    </form>
                                </div></td>
                            </tr>
                        <tr>

                            <td height="18" bgcolor="#FFFFFF" class="STYLE2" colspan="3">
                                <div align="center" class="STYLE2 STYLE1">
                                    ${pagerinfo }
                                </div></td>


                        </tr>


                    </table></td>
                    <td width="9" background="images/tab_16.gif">&nbsp;</td>
                </tr>
            </table></td>
    </tr>

</table>

</body>
</html>

