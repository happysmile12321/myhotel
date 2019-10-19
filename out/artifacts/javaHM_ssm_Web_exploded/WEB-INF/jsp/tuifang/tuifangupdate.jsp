<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
<script language="javascript" type="text/javascript">

</script>

</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="images/tab_05.gif" align="center"> <span class="STYLE4">${title }</span></td>
        
        <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="80%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
         <form action="${url }?id=${bean.id }" method="post" onsubmit="return checkform()">
        <table width="99%" border="1" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" >
		 <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
             客户姓名：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
                <input  type="text" name="kehuname"  id='kehunameid'  size="30" value="${bean.kehuname }" />
            </div></td>
           
          </tr>
          <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
          身份证号码：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
            	 <input  type="text" name="idcard"  id='idcardid'  size="30"   value="${bean.idcard }" />
            </div></td>
           
          </tr>
  
          <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
            押金 (元)：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
           <input  type="text" name="yajin"  id='yajinid'  size="30" value="${bean.yajin }"  />
            </div></td>
           
          </tr>
          
            <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
            房间编号：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
           <input  type="text" name="fangjianhao"  id='fangjianhaoid'  size="30" value="${bean.kefang.fangjianhao }"  />
            </div></td>
           
          </tr>
          
            <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
            客房价格：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
           <input  type="text" name="jiage"  id='jiageid'  size="30" value="${bean.kefang.fenlei.jiage}"  />
            </div></td>
           
          </tr>
          
            <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
           入住时间：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
           <input  type="text" name="ruzhutime"  id='ruzhutimeid'  size="30" value="${fn:substring(bean.ruzhutime,0, 19) }"  />
            </div></td>
           
          </tr>
          
            <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
            退房时间：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
        <%--   <input  type="text" name="tuifangtime"  id='tuifangtimeid'  size="30" value="<%=jiudian.utils.Util.getTime() %>"  />--%>
            </div></td>
           
          </tr>
          
            <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
           入住天数：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
           <input  type="text" name="tianshu"  id='tianshuid'  size="30" value="${tianshu}" />
            </div></td>
           
          </tr>
          
            <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
           消费金额 (元)：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
           <input  type="text" name="xiaofei"  id='xiaofeiid'  size="30" value="${feiyong}" />
            </div></td>
           
          </tr>
          
           <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
           实付金额 (元)：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
           <input  type="text" name="shifu"  id='shufuid'  size="30" value="${feiyong-bean.yajin }"   />
            </div></td>
           
          </tr>
          <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
             备注：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
           <input  type="text" name="beizhu"  id='beizhuid'  size="30" value="${bean.beizhu }"   />
            </div></td>
           
          </tr>
          
          <tr>
            <td width="30%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">
            操作：
            </div>
            </td>
            <td width="70%" height="18" background="images/tab_14.gif" class="STYLE1">
            <div align="center" class="STYLE2 STYLE1">
         <input type="submit" value="确认退房" style="width: 60px" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  onclick="javascript:history.go(-1);" style="width: 60px" type="button" value="返回" />
            </div></td>
           
          </tr>
          
        </table>
        
        </td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  
</table>
</body>
</html>


