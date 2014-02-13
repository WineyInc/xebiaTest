<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp"%>

<script type="text/javascript">
	
</script>
<div class="row margin-top" id="main-content">
	<div class="col-md-3"></div>
	<div class="col-md-6 login-form" id="sidebar">
		<form:form method="post" action="products"
			commandName="productCommand">
			<spring:hasBindErrors name="productCommand">
				<div class="isa_error">
					<ul>
						<c:forEach items="${errors.allErrors}" var="error">
							<li>${error.field}${error.defaultMessage}</li>
						</c:forEach>
					</ul>
				</div>
			</spring:hasBindErrors>
			<fieldset>
				<div class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<tag:textInput name="productCommand.productName" isPassword="false"
						placeholder="label.product.name" mandatory="true">
					</tag:textInput>

				</div>
				<div class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<tag:textInput name="productCommand.description" isPassword="false"
						placeholder="label.descp" mandatory="true">
					</tag:textInput>
				</div>
				<div class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<tag:textInput name="productCommand.lowestPrice" isPassword="false"
						placeholder="label.lowPrice" mandatory="true">
					</tag:textInput>
				</div>
				<div class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<tag:textInput name="productCommand.avgPrice" isPassword="false"
						placeholder="label.avgPrice" mandatory="true">
					</tag:textInput>
				</div>
				<div class="input-group input-group-flat">
					<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
					<tag:textInput name="productCommand.highestPrice"
						isPassword="false" placeholder="label.highPrice" mandatory="true">
					</tag:textInput>
				</div>
				<p class="input-group-flat">
					<input type="submit" width="100"
						class="btn btn-block btn-lg btn-primary btn-flat"
						value="<spring:message code='label.submit'/>">
				</p>
			</fieldset>
		</form:form>
		<table border="1" >
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Lowest Price</th>
			<th>Avg Price</th>
			<th>Highest Price</th>
		</tr>
		<c:forEach items="${productList}" var="product"
			varStatus="count">
			
			<tr >
				<td >${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.description}</td>
				<td>${product.lowestPrice}</td>
				<td>${product.avgPrice}</td>
				<td>${product.highestPrice}</td>
			</tr>
		</c:forEach>
		
		</table>
	</div>
	<div class="col-md-3"></div>
</div>



