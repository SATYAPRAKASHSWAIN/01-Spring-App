<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Report App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2 class="pb-3 pb-3">Report Application</h2>

		<form:form action="search" modelAttribute="search" method="POST">
			<table>
				<tr>
					<td>Plan Name:</td>
					<td><form:select path="planName">
							<form:option value="">-Select-</form:option>
							<form:options items="${names}"></form:options>
						</form:select></td>
					<td>Plan Status:</td>
					<td><form:select path="planStatus">
							<form:option value="">-Select-</form:option>
							<form:options items="${status}"></form:options>
						</form:select></td>

					<td>Gender:</td>
					<td><form:select path="gender">

							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="FeMale">FeMale</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="date"
							data-date-format="dd/MM/yyyy" /></td>


					<td>End Date:</td>
					<td><form:input path="endDate" type="date" id="date" /></td>

				</tr>
				<tr>
					<td><a href="/" class="btn btn-secondary">Reset</a></td>
						<td><input type="submit" value="Search"
						class="btn btn-primary" /></td>
				</tr>

			</table>
		</form:form>
		<hr />
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Holder Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>


				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.gender}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>

					</tr>
				</c:forEach>
				<tr>
					<c:if test="${empty plans }">
						<td colspan="8" style="text-align: center" />No Records Found</td>
					</c:if>
				</tr>
			</tbody>


		</table>
		<hr />
		Export : <a href="excel">Excel</a> <a href="pdf">PDF</a>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous">
		
	</script>

</body>
</html>