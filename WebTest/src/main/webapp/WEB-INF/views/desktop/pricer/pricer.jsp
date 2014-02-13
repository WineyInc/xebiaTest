<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>

<script type="text/javascript">
	
</script>
<div class="row margin-top" id="main-content">

	<div class="col-md-5"></div>
	<div class="col-md-3 login-form" id="sidebar">
		<form:form method="post" action="pricer" commandName="pricerCommand">
			<spring:hasBindErrors name="pricerCommand">
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
					<spring:message code='label.legend.product.price' />
				</legend>
				<div class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<tag:dropDown name="pricerCommand.productName" mandatory="true">
					</tag:dropDown>

				</div>
				<div class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<tag:textInput name="pricerCommand.price" isPassword="false"
						placeholder="label.price" mandatory="true">
					</tag:textInput>
					<tag:textInput disabled="disabled" name="pricerCommand.idealPrice" isPassword="false"
						placeholder="label.blank" mandatory="true">
					</tag:textInput>
				</div>
				
				<p class="input-group-flat">
					<input type="submit"
						class="btn btn-block btn-lg btn-primary btn-flat"
						value="<spring:message code='label.submit'/>">
				</p>
			</fieldset>
		</form:form>

	</div>
	<div class="col-md-4"></div>
</div>



