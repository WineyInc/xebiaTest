<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<meta charset="utf-8">

<link rel="stylesheet"
	href='<c:url value="/resources/styles/css/bootstrap.min.css" />' type="text/css"
	media="screen" />
<link rel="stylesheet" href='<c:url value="/resources/styles/css/flatui.css" />'
	type="text/css" media="screen" />
<link rel="stylesheet" href='<c:url value="/resources/styles/css/newsfeed.css" />'
	type="text/css" media="screen" />
<link rel="stylesheet"
	href='<c:url value="/resources/styles/css/font-awesome.min.css" />' type="text/css" 
	media="screen" />
<link rel="stylesheet" href='<c:url value="/resources/styles/css/datepicker.css" />'
	type="text/css" media="screen" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>
<body>

	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />

	<script src='<c:url value="/resources/styles/js/jquery.js" />'></script>
	<script src='<c:url value="/resources/styles/js/bootstrap.min.js" />'></script>
	<script src='<c:url value="/resources/styles/js/bootstrap-datepicker.js" />'></script>
</body>
</html>