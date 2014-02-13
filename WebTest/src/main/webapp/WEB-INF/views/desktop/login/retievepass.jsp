<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="row margin-top" id="main-content">
	<div class="col-md-7"></div>
	<div class="col-md-3 login-form" id="sidebar">
		<form:form method="post" action="retrievePass"
			commandName="retrievePasswordCommand">
			<spring:hasBindErrors name="retrievePasswordCommand">
				<div class="isa_error">
					<form:errors path="password" cssclass="error"></form:errors>
					<br>
				</div>
			</spring:hasBindErrors>
			<spring:bind path="retrievePasswordCommand.email">
				<input type="hidden" name="${status.expression}" value="${status.value}" />
			</spring:bind>
			<spring:bind path="retrievePasswordCommand.uid">
				<input type="hidden" name="${status.expression}" value="${status.value}" />
			</spring:bind>
			
			<fieldset>
				<legend>
					<spring:message code='label.legend.retrieve.password' />
				</legend>
				<div class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<spring:bind path="retrievePasswordCommand.password">
						<c:set var="fieldClass" value="form-control form-control-flat"></c:set>
						<c:if test="${status.error}">
							<c:set var="fieldClass"
								value="form-control form-control-flat-error"></c:set>
						</c:if>
						<input type="password" class="${fieldClass}"
							name="${status.expression}"
							placeholder="<spring:message code='label.password'/>"
							value="${status.value}" />
					</spring:bind>
				</div>
				<div class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-lock fa-fw"></i></span>
					<spring:bind path="retrievePasswordCommand.confirmPassword">
						<c:set var="fieldClass" value="form-control form-control-flat"></c:set>
						<c:if test="${status.error}">
							<c:set var="fieldClass"
								value="form-control form-control-flat-error"></c:set>
						</c:if>
						<input type="password" class="${fieldClass}"
							name="${status.expression}"
							placeholder="<spring:message code='label.confirmPassword'/>"
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
</div>
