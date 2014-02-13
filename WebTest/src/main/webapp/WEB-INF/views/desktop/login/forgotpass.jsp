<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="row margin-top" id="main-content">
	<div class="col-md-7"></div>
	<div class="col-md-3 login-form" id="sidebar">
		<form:form method="post" action="forgotPass"
			commandName="forgotPasswordCommand">
			<spring:hasBindErrors name="forgotPasswordCommand">
				<div class="isa_error">
					<form:errors path="email" cssclass="error"></form:errors>
					<br>
				</div>
			</spring:hasBindErrors>
			<fieldset>
				<legend>
					<spring:message code='label.legend.retrieve.password' />
				</legend>
				<div class="input-group input-group-flat">
					<span class="input-group-addon "><i
						class="fa fa-envelope-o fa-fw"></i> </span>
					<spring:bind path="forgotPasswordCommand.email">
						<c:set var="fieldClass" value="form-control form-control-flat"></c:set>
						<c:if test="${status.error}">
							<c:set var="fieldClass"
								value="form-control form-control-flat-error"></c:set>
						</c:if>
						<input class="${fieldClass}" name="${status.expression}"
							placeholder="<spring:message code='label.email'/>"
							value="${status.value}" />
					</spring:bind>
				</div>
				<div class="row">
					<div class="col-md-6"></div>
					<div class="col-md-6 text-right">
						<input type="submit"
							class="btn btn-block btn-lg btn-success btn-flat"
							value="<spring:message code='label.submit'/>" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
	<div class="col-md-2"></div>
</div>
