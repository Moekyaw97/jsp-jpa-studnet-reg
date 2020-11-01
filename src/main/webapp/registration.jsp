<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="resource/common.jsp"></jsp:include>
<title>Registration</title>
</head>
<body>
	
	<div class="container">
		<jsp:include page="resource/menu.jsp"></jsp:include>

		<div class="row mt-5">
			<div class="col-10">
				<h3>Registration</h3>
			</div>
			<div class="col-2">
				<c:url value="/reg-add" var="add"></c:url>
				<a href="${add }" class="btn btn-success">Add new registration</a>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<td>ID</td>
					<td>Reg Date</td>
					<td>Paid Amount</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${registrations }" var="r">
					<tr>
						<td>${r.id }</td>
						<td>${r.regDate }</td>
						<td>${r.paidAmt }</td>
						<td><c:url var="action" value="/reg-edit">
								<c:param name="regid">${r.id }</c:param>
							</c:url> <a href="${action }" class="btn btn-outline-success">Edit</a></td>
						<td><c:url var="action" value="/reg-delete">
								<c:param name="regid">${r.id }</c:param>
							</c:url> <a href="${action }" class="btn btn-outline-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</div>
</body>
</html>