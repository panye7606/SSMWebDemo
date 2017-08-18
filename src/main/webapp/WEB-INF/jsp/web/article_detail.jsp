<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

<title>爱书客</title>
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
	margin: 0 13% 40px 13%;
	min-height: 500px;
}
/* 广告 */
#content .adv {
	float: left;
	width: 100%;
	background-color: white;
	height: 150px;
	margin: 10px 0;
}

/* 中间左侧 */
#content_left {
	float: left;
	width: 58%;
	font-size: 15px;
	min-height: 500px;
	background-color: white;
	padding: 4% 6%;
}
/* 文章信息 */
#article_info {
	float: left;
	width: 100%;
	text-align: center;
}

#article_info h2 {
	margin-bottom: 20px;
	font-weight: normal;
}

#article_info nobr {
	font-size: 13px;
	color: #bbb;
}

#article_info nobr font,#article_info nobr a,#article_info nobr span {
	margin: 0 10px;
}

#article_info p {
	margin: 28px 0;
}

#article_info nobr a {
	font-size: 14px;
	color: #40aff2;
	cursor: pointer;
}

#article_info nobr span {
	font-size: 14px;
	color: black;
}

#content_left hr {
	float: left;
	margin: 50px 0 60px 0;
	padding: 0;
	border-bottom: 1px dashed #CCC;
	border-top: none;
	border-left: none;
	border-right: none;
	border-width: 1px;
	width: 100%
}
/* 作者信息 */
#author_info {
	float: left;
	width: 86%;
	padding: 6% 7%;
	font-size: 13px;
	border: 1px dashed #DEDEDE;
	border-radius: 5px;
}

#author_info p {
	margin-bottom: 12px;
	padding: 0;
}

#author_info p font {
	color: #777;
}

#author_info_top {
	float: left;
	width: 100%;
}

#author_info_top p {
	margin-left: 110px;
}

#author_info_top_desc {
	float: left;
	width: 100%;
	height: 70px;
	line-height: 70px;
	vertical-align: middle;
}

#author_info_top_desc img,#author_info_top_desc span {
	float: left;
}

#author_info_top_desc img {
	margin: 0 20px;
}

#author_info_top_desc span {
	font-size: 16px;
}

#author_info_top_desc span font {
	font-size: 12px;
	padding: 1px 7px;
	color: #FE7517;
	border: 1px solid #FE7517;
	margin-left: 20px;
}

#author_info_top_desc a {
	float: right;
	color: #40aff2;
	cursor: pointer;
	margin: 0 10px;
}

#author_info_top_desc a:HOVER {
	text-decoration: underline;
}

#author_info_bottom {
	float: left;
	width: 100%;
	margin-top: 25px;
}

#author_info_bottom #basic_info_title {
	float: left;
	width: 110px;
	text-align: center;
	font-size: 16px;
	cursor: pointer;
}

#author_info_bottom #basic_info_desc {
	float: left;
}
/* 中间右侧 */
#content_right {
	float: right;
	width: 28%;
	background-color: white;
	min-height: 500px;
}

/* 列表错误信息 */
#resultMsg {
	float: left;
	width: 100%;
	text-align: center;
	padding: 20px 0;
	color: #40aff2;
	font-size: 15px;
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
		<div class="adv">
		</div>
		
		<%-- 中间左侧 --%>
		<div id="content_left">
			<%-- 文章信息 --%>
			<div id="article_info">
				<c:choose>
					<c:when test="${articleUserDataResult == null || articleUserDataResult.data == null}">
						<div id="resultMsg">获取数据失败</div>
					</c:when>
					<c:when test="${articleUserDataResult.resultCode != 0}">
						<div id="resultMsg">${articleUserDataResult.resultMsg}</div>
					</c:when>
					<c:otherwise>
						<h2>${articleUserDataResult.data.article.aTitle}</h2>
						<nobr>
							<font>${articleUserDataResult.data.articleStyle.asName}-${articleUserDataResult.data.articleType.atName}</font>/
							<font>${articleUserDataResult.data.user.uRealname}</font>/
							<font>${articleUserDataResult.data.article.aFormatPubtime}</font>/
							<font>${articleUserDataResult.data.article.aBrowsenum}次浏览</font>
						</nobr>
						<p>${articleUserDataResult.data.article.aAbstract}</p>
						<c:if test="${fn:length(articleUserDataResult.data.article.articleAddrs) > 0}">
							<nobr>
								<span>原文地址</span>
								<c:forEach var="articleAddr" items="${articleUserDataResult.data.article.articleAddrs}">
									/<a href="${articleAddr.aaPath}" target="_self">${articleAddr.aaOrganization}</a>
								</c:forEach>
							</nobr>
						</c:if>
					</c:otherwise>
				</c:choose>
				<hr>
				<h2>作者信息</h2>
			</div>
			
			<%-- 作者信息 --%>
			<div id="author_info">
				<c:choose>
					<c:when test="${articleUserDataResult == null || articleUserDataResult.data == null}">
						<div id="resultMsg">获取数据失败</div>
					</c:when>
					<c:when test="${articleUserDataResult.resultCode != 0}">
						<div id="resultMsg">${articleUserDataResult.resultMsg}</div>
					</c:when>
					<c:otherwise>
						<div id="author_info_top">
							<div id="author_info_top_desc">
								<img alt="${articleUserDataResult.data.user.uRealname}" src="${articleUserDataResult.data.user.uPic}" height="70" width="70">
								<span>${articleUserDataResult.data.user.uRealname}<font>${articleUserDataResult.data.user.uFormatRealnameIdentifyState}</font></span>
								<a href="javascript:;">留言</a>
								<a href="javascript:;">关注</a>
							</div>
							<p><font>注册天数：&nbsp;&nbsp;</font>${articleUserDataResult.data.user.uRegDays}</p>
							<p><font>简介：&nbsp;&nbsp;</font>${articleUserDataResult.data.user.uIntroduce}</p>
						</div>
						<div id="author_info_bottom">
							<div id="basic_info_title">
								<font>基本信息+</font>
							</div>
							<div id="basic_info_desc">
								<p><font>性别：&nbsp;&nbsp;</font>${articleUserDataResult.data.user.uSex}</p>
								<p><font>身高：&nbsp;&nbsp;</font>${articleUserDataResult.data.user.uHeight}CM</p>
								<p><font>体重：&nbsp;&nbsp;</font>${articleUserDataResult.data.user.uWeight}KG</p>
								<p><font>出生日期：&nbsp;&nbsp;</font>${articleUserDataResult.data.user.uBirthday}</p>
								<p><font>现居住地：&nbsp;&nbsp;</font>${articleUserDataResult.data.user.uDomicile}</p>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<%-- 中间右侧 --%>
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
