<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	errorPage="/WEB-INF/views/errorPage.jsp" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<meta charset="utf-8">
<link rel="stylesheet"
	href='<c:url value="/resources/styles/css/bootstrap.min.css"/>' type="text/css"
	media="screen" />
<link rel="stylesheet" href='<c:url value="/resources/styles/css/newsfeed.css" />'
	type="text/css" media="screen" />
<link rel="stylesheet" href='<c:url value="/resources/styles/css/flatui.css" />'
	type="text/css" media="screen" />
<link rel="stylesheet" href='<c:url value="/resources/styles/css/menu.css" />'
	type="text/css" media="screen" />
<link rel="stylesheet" href='<c:url value="/resources/styles/css/flex.css" />'
	type="text/css" media="screen" />
<link rel="stylesheet"
	href='<c:url value="/resources/styles/css/newsfeed-mobile.css" />' type="text/css"
	media="only screen and (max-device-width: 480px) " />
<link rel="stylesheet" href='<c:url value="/resources/styles/css/datepicker.css" />'
	type="text/css" media="screen" />
<link rel="stylesheet"
	href='<c:url value="/resources/styles/css/font-awesome.min.css" />' type="text/css"
	media="screen" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>

<body>
	<script src='<c:url value="/resources/styles/js/jquery.js" />'></script>

	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="innerheader" />
	<div class="row">

		<div class="col-md-2 nopadding nomargin">
			<tiles:insertAttribute name="menu" />
		</div>
		<div class="col-md-10 nopadding ">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
	<script src='<c:url value="/resources/styles/js/bootstrap.min.js" />'></script>
	<script src='<c:url value="/resources/styles/js/masonry.pkgd.js" />'></script>
	<script src='<c:url value="/resources/styles/js/jquery-ui.js" />'></script>
	<script src='<c:url value="/resources/styles/js/jquery-modal.js" />'></script>
	<script src='<c:url value="/resources/styles/js/bootstrap-datepicker.js" />'></script>
</body>
</html>