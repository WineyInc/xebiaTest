<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ attribute name="name" description="" required="true"
	rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="selected" description="" required="false"
	rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="mandatory" description="" required="false"
	rtexprvalue="true" type="java.lang.Boolean"%>
<spring:bind path="${name}">
	<c:set var="fieldClass" value="form-control form-control-flat"></c:set>
	<c:if test="${status.error && (mandatory eq true)}">
		<c:set var="fieldClass" value="form-control form-control-flat-error"></c:set>
	</c:if>
	<f:dropdown  name="${status.expression}"
		className="${fieldClass}" value="${status.value}"
		selected="${selected}">
	</f:dropdown>
</spring:bind>