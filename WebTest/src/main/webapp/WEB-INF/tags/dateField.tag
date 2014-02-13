<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ attribute name="name" description="" required="true"
	rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="placeholder" description="" required="true"
	rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="maxlength" description="" required="false"
	rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="mandatory" description="" required="false"
	rtexprvalue="true" type="java.lang.Boolean"%>
<script>
	$(document).ready(function() {
		$('.datepicker').datepicker({
			format : 'mm-dd-yyyy'
		});
	});
</script>
<spring:bind path="${name}">
	<c:set var="fieldClass"
		value="form-control form-control-flat datepicker"></c:set>
	<c:if test="${status.error && (mandatory eq true)}">
		<c:set var="fieldClass" value="form-control form-control-flat-error datepicker"></c:set>
	</c:if>
	<input class="${fieldClass}" name="${status.expression}" type="date"
		maxlength="${maxlength}"
		placeholder="<spring:message code='${placeholder}' />"
		value="${status.value}" />
</spring:bind>


