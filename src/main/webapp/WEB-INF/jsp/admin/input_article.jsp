<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>录入文章</title>
<%-- 静态包含头部文件 --%>
<%@include file="../common/head.jsp" %>

<%-- 公共body样式 --%>
<link rel="stylesheet" rev="stylesheet" href="css/common/body.css" type="text/css" />
<%-- 公共右侧固定栏 --%>
<link rel="stylesheet" rev="stylesheet" href="css/ibooker.right.fixed.css" type="text/css" />
<style type="text/css">
/* 顶部 */
#top,#top_one,#top_two,#bottom {
	float: left;
	width: 100%;
	background-color: white;
}

#top,#bottom {
	min-height: 100px;
}
/* 中间区 */
#content {
	float: left;
	width: 74%;
	margin: 40px 13%;
	background-color: #40aff2;
	min-height: 500px;
}
</style>
</head>

<body>
	<%-- 顶部 --%>
	<div id="top">
		<div id="top_one">
		
		</div>
		<div id="top_two">
		
		</div>
	</div>
	
	<%-- 内容区 --%>
	<div id="content">
		<div id="content_left">
		
		</div>
		<div id="content_right">
		
		</div>
	</div>
	
	<%-- 底部 --%>
	<div id="bottom">
	
	</div>
	
	<%-- 右侧固定栏 --%>
	<div id="right_fixed">
		<a class="right_fixed_feedback"></a>
		<a class="right_fixed_cproblems"></a>
		<a class="right_fixed_appdownload"><img id="img_appdownload" src="images/web/app_download_qrcode.png"></a>
		<a class="right_fixed_weixin"><img id="img_weixin" src="images/web/img_weixin_public.jpg"></a>
		<a id="btn_backup" class="right_fixed_backup" href="javascript:;"></a>
	</div>
</body>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<%-- 返回顶部 --%>
<script type="text/javascript" src="js/ibooker-backup-1.0.js"></script>
</html>
