<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%--分页样式--%>
<link rel="stylesheet" rev="stylesheet" href="css/common/pagination.css" type="text/css" />
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
	width: 76%;
	margin: 40px 12%;
	min-height: 500px;
}

#content #sort {
	float: left;
	width: 100%;
}

#content #sort ul {
	float: left;
	margin: 5px 15px 30px 15px;
}

#content #sort ul li {
	float: left;
	margin: 0 15px;
}

#content #sort ul li a {
	font-size: 14px;
	color: #777;
	cursor: pointer;
}

#content #sort ul li a:HOVER {
	color: #FE7517;
}

#content #sort #active a {
	color: #FE7517;
}
/* 中间左侧 */
#content_left {
	float: left;
	width: 74%;
	font-size: 14px;
	min-height: 500px;
}

#article_list {
	float: left;
	width: 100%;
}

#article_list ul li {
	float: left;
	width: 31.5%;
	margin: 0 1.83% 1.83% 0;
	padding: 0;
	cursor: pointer;
	background-color: white;
	-moz-box-shadow: 0 0 12px #DEDEDE;
	-webkit-box-shadow: 0 0 12px #DEDEDE;
	box-shadow: 0 0 12px #DEDEDE;
}

#article_list ul li:HOVER h4 {
	color: #FE7517;
}

#article_list ul li img {
	float: left;
	width: 100%;
	height: auto;
	max-height: 202px;
	margin-bottom: 10px;
	border: none;
}

#article_list ul li h4 {
	width: 90%;
	font-weight: normal;
	margin: 0 5%;
	overflow: hidden; /*内容超出后隐藏*/
	text-overflow: ellipsis; /* 超出内容显示为省略号*/
	white-space: nowrap; /*文本不进行换行*/
}

#article_list ul li p {
	font-size: 13px;
	color: #777;
	margin: 10px 5%;
	position: relative;
	line-height: 1.4em;
	/* 3 times the line-height to show 3 lines */
	height: 4.2em;
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 3;
	-webkit-box-orient: vertical;
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

/* 分页 */
#article_page {
	width: 100%;
	float: left;
}

#News-Pagination {
	float: left;
	width: 100%;
	margin: 30px auto;
	text-align: center;
}

/* 中间右侧 */
#content_right {
	float: right;
	width: 25%;
	background-color: white;
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
		<%-- 导航 --%>
		<div id="sort">
			<ul>
				<li id="active"><a>全部</a></li>
				<li><a>Web前端</a></li>
				<li><a>JavaEE</a></li>
				<li><a>Android</a></li>
				<li><a>iOS</a></li>
				<li><a>数据库</a></li>
				<li><a>服务器</a></li>
			</ul>
		</div>
		<%-- 文章列表 --%>
		<div id="content_left">
			<div id="article_list">
				<ul>
					<c:choose>
						<c:when test="${articleDataPager == null}">
							<div id="resultMsg">获取数据失败</div>
						</c:when>
						<c:when test="${articleDataPager.resultCode != 0}">
							<div id="resultMsg">${articleDataPager.resultMsg}</div>
						</c:when>
						<c:otherwise>
							<c:forEach var="articleData" items="${articleDataPager.dataList}">
								<li onclick="checkArticleDetail(${articleData.article.aId})">
									<img class="lazy" src="" art="${articleData.articleType.atName}" data-original="${articleData.article.aCoverPath}" width="100%">
									<noscript>
										<img art="${articleData.articleType.atName}" src="${articleData.article.aCoverPath}" width="100%">
									</noscript>
									<h4>${articleData.article.aTitle}</h4>
									<p>${articleData.article.aAbstract}</p>
								</li>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			
			<%-- 分页 --%>
			<div id="article_page">
				<div id="News-Pagination"></div>
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
<%-- 图片懒加载 --%>
<script type="text/javascript" src="js/jquery.lazyload.js"></script>
<%-- 分页引入 --%>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript">
$(function() {
	<%--图片懒加载--%>
	$("img.lazy").lazyload({
		threshold : 100,
		effect : "fadeIn",
		failure_limit : 10,
		skip_invisible : true
	});
	<%--分页插件--%>
	$("#News-Pagination").pagination(${articleDataPager.totalRecord}, {
		items_per_page : ${articleDataPager.pageSize},// 每页显示多少条记录
		current_page : ${articleDataPager.currentPage} - 1,// 当前页数
		num_display_entries : 5,// 分页显示条目数
		next_text : "下一页",
		prev_text : "上一页",
		num_edge_entries : 0,// 连接分页主体，显示的条目数
		load_first_page : false,
		callback : handlePaginationClick
	});

});

<%--分页插件回调函数--%>
function handlePaginationClick(new_page_index, pagination_container) {
	var url = "<%=basePath%>web/article/list/" + (new_page_index + 1);
	window.location.href = url;
	return false;
};

<%--查看文章详情--%>
function checkArticleDetail(aId) {
	var url = "<%=basePath%>web/article/"+aId+"/detail";
	window.open(url);
};
</script>
</html>
