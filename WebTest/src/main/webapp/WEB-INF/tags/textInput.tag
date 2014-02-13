<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ attribute name="name" description="" required="true"
	rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="placeholder" description="" required="true"
	rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="maxlength" description="" required="false"
	rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="mandatory" description="" required="false"
	rtexprvalue="true" type="java.lang.Boolean"%>
<%@ attribute name="isPassword" description="" required="false"
	rtexprvalue="true" type="java.lang.Boolean"%>
<%@ attribute name="disabled" description="" required="false"
	rtexprvalue="true" type="java.lang.String"%>

<spring:bind path="${name}">

	<c:set var="fieldClass" value="form-control form-control-flat"></c:set>
	<c:if test="${status.error && (mandatory eq true)}">
		<c:set var="fieldClass" value="form-control form-control-flat-error"></c:set>
	</c:if>

	<c:set var="inputType" value="text"></c:set>
	<c:if test="${isPassword eq true}">
		<c:set var="inputType" value="password"></c:set>
	</c:if>
	<c:if test="${empty disabled }">
		<input class="${fieldClass}" name="${status.expression}"
			type="${inputType}" maxlength="${maxlength}"
			placeholder="<spring:message code='${placeholder}' />"
			value="${status.value}" />
	</c:if>
	<c:if test="${!empty disabled}">
		<input class="${fieldClass}" name="${status.expression}"
			type="${inputType}" maxlength="${maxlength}" disabled="disabled"
			placeholder="<spring:message code='${placeholder}' />"
			value="${status.value}" />
	</c:if>
</spring:bind>

