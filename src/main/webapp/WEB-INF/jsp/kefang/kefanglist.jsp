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
.STYLE7 {font-size: 12}

-->
</style>
  <%--从内部向外部索要资源--%>
  <script type="text/javascript" src="${path}/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
    $(function(){
      /*利用ajax异步刷新请求后台数据*/
      $.ajax({
        url:"http://localhost:8080/javaHM_ssm/ma/ajax_kefangfeilei.action",
        type:"post",
        dataType:"json",
        data:{"":""},
        success:function (data) {
          // alert(data.leixing)
          $("#select1").prepend("<option value= '0'>请选择</option>");
          $("#select2").prepend("<option value= '0'>请选择</option>");


          $.each(data,function (index,res) {
            //获得分类，客房对象
            var fenlei = data[index].fenlei;
            var kefang = data[index].kefang;
            //获取table

                    var kefangid = kefang.id;
                    var fenleiid = fenlei.id;
                    var kefang_fangjianhao = kefang.fangjianhao;
                    var fenlei_leixing = fenlei.leixing;
            $("#select1").append("<option value=" + kefang_fangjianhao +">"+kefang_fangjianhao+"</option>");
            $("#select2").append("<option value=" + fenlei_leixing +">"+fenlei_leixing+"</option>");

          });

        },
        error:function () {
          alert("错误！")
        }
      });
      //点击button事件
      $("#mybtn").click(function(){
        var Option1Value=$("#select1").val();  //获取Select选择的Value
        var Option2Value=$("#select2").val();  //获取Select选择的Value
        $.ajax({
          url:"http://localhost:8080/javaHM_ssm/ma/ajax2_kefangfeilei.action",
          type:"post",
          data:{"kefang_fangjianhao":Option1Value,"fenlei_leixing":Option2Value},
          success:function (data) {
            var table = $("#mytr");
            $.each(data,function (index,res) {

              //获得分类，客房对象
              var fenlei = data[index].fenlei;
              var kefang = data[index].kefang;
              var fenlei_jiage = fenlei.jiage;
              var kefang_fangjianhao = kefang.fangjianhao;
              var fenlei_leixing = fenlei.leixing;
              var kefang_status = kefang.fangjianstatus;

              $("#myleixing").html(fenlei_leixing);
              $("#myjiage").html(fenlei_jiage);
              $("#myfangjianhao").html(kefang_fangjianhao);
              $("#myfangjianzhuangtai").html(kefang_status);


            });
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
    <form action="<%=basePath%>${url }" method="post">
    &nbsp;&nbsp;&nbsp;<a href="<%=basePath%>${url2 }add"><span style="font-weight: bold;font-size: 22px;">添加新客房信息</span></a><br/><br/>
    &nbsp;&nbsp;&nbsp;
    房间编号：
            <select id="select1" name="fangjianhao"  style="width:150">
            </select>
    房间类型：<select id="select2" name="leixing"  style="width:150">
   			</select>
    <input id="mybtn" type="button" value="查询" />
    </form>
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" >
          <tr >
           
            <td  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">客房类型</div></td>
            <td  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">客房价格</div></td>
            <td  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">房间编号</div></td>
            <td height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">房间状态</div></td>
            <td width="20%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">操作</div></td>
          </tr>

            <tr id="mytr">

              <td  height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1" id="myleixing"></div></td>
              <td  height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1" id="myjiage"></div></td>
              <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1" id="myfangjianhao"></div></td>
              <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1" id="myfangjianzhuangtai"></div></td>
              <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
                <a href="update?id=$">修改</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="delete?id=" onclick=" return confirm('确定要删除吗?'); ">删除</a>
              </div></td>

            </tr>

          <tr>
           
            <td height="18" bgcolor="#FFFFFF" class="STYLE2" colspan="7">
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


