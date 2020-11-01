<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="resource/common.jsp"></jsp:include>
<title>Student</title>
</head>
<body>
	<div class="container">
		<jsp:include page="resource/menu.jsp"></jsp:include>

		<div class="row mt-5">
			<div class="col-10">
				<h3>All Students</h3>
			</div>

			<div class="col-2">
				<c:url var="add" value="/student-add"></c:url>
				<a href="${add }" class="btn btn-success">Add new student</a>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Email</td>
					<td>Phone</td>
					
				</tr>
			</thead>
			<tbody>
				<!-- 	item list -->
				<c:forEach items="${student }" var="s">
					<tr>
						<td>${s.id }</td>
						<td>${s.name }</td>
						<td>${s.email }</td>
						<td>${s.phone }</td>
					
						<td><c:url var="edit" value="/student-edit">
								<c:param name="studentid">${s.id }</c:param>
							</c:url> <a href="${edit }" class="btn btn-outline-success">Edit</a></td>
						<td><c:url var="delete" value="/student-delete">
								<c:param name="studentid">${s.id }</c:param>
							</c:url> <a href="${delete }" class="btn btn-outline-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</div>
</body>
</html>