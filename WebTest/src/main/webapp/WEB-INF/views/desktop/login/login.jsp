<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>

<script type="text/javascript">
	function onClickAdmin() {

		if (document.getElementById('passwordDiv').style.display == 'none') {
			document.getElementById('passwordDiv').style.display = 'table';
			document.getElementById('nameDiv').style.display = 'none';
			document.getElementById('userBtn').style.display = 'none';
		} else {
			var lform = document.getElementById('loginform');
			lform.elements["userType"].value = "admin";
			lform.submit();
		}

	}
	function onClickUser() {

		if (document.getElementById('nameDiv').style.display == 'none') {

			document.getElementById('nameDiv').style.display = 'table';
			document.getElementById('passwordDiv').style.display = 'none';
			document.getElementById('adminBtn').style.display = 'none';
		} else {
			var lform = document.getElementById('loginform');
			lform.elements["userType"].value = "user";
			lform.submit();
		}
	}
</script>
<div class="row margin-top" id="main-content">

	<div class="col-md-7"></div>
	<div class="col-md-3 login-form" id="sidebar">
		<form:form method="post" id="loginform" action="login"
			commandName="loginCommand">
			<spring:hasBindErrors name="loginCommand">
				<div class="isa_error">
					<ul>
						<c:forEach items="${errors.allErrors}" var="error">
							<li>${error.field}${error.defaultMessage}</li>
						</c:forEach>
					</ul>
				</div>
			</spring:hasBindErrors>
			<fieldset>
				<legend>
					<spring:message code='label.legend.login' />
				</legend>
				<div id="passwordDiv" style="display: none"
					class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<tag:textInput name="loginCommand.password" isPassword="true"
						mandatory="true" placeholder="label.password">
					</tag:textInput>
				</div>
				<div id="passwordDiv" style="display: none"
					class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<tag:textInput name="loginCommand.userType" isPassword="false"
						placeholder="label.blank" mandatory="false">
					</tag:textInput>
				</div>

				<div id="nameDiv" style="display: none"
					class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<tag:textInput name="loginCommand.userName" isPassword="false"
						mandatory="true" placeholder="label.name">
					</tag:textInput>
				</div>
				<p class="input-group-flat">
					<input type="button" id="adminBtn" name="admin" onclick="onClickAdmin()"
						class="btn btn-block btn-lg btn-primary btn-flat"
						value="<spring:message code='label.admin'/>"> 
						<input id="userBtn"
						type="button" onclick="onClickUser()"
						class="btn btn-block btn-lg btn-primary btn-flat"
						value="<spring:message code='label.user'/>">
				</p>
			</fieldset>
		</form:form>

	</div>
	<div class="col-md-2"></div>
</div>



