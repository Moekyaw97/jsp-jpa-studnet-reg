<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="resource/common.jsp"></jsp:include>
<title>Classes</title>
</head>
<body>

	<div class="container">
		<jsp:include page="resource/menu.jsp"></jsp:include>

		<div class="row mt-5">
			<div class="col-10">
				<h3>Classes</h3>
			</div>
			<div class="col-2">
				<c:url value="/class-add" var="add"></c:url>
				<a href="${add }" class="btn btn-success">Add new class</a>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<td>ID</td>
					<td>Class Name</td>
					<td>Start Date</td>
				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classes}" var="i">
					<tr>
						<td>${i.id }</td>
						<td>${i.name }</td>
						<td>${i.start_date }</td>
					
						<td><c:url var="action" value="/class-edit">
								<c:param name="classid">${i.id }</c:param>
							</c:url> <a href="${action }" class="btn btn-outline-success">Edit</a></td>
						<td><c:url var="action" value="/class-delete">
								<c:param name="classid">${i.id }</c:param>
							</c:url> <a href="${action }" class="btn btn-outline-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>



	</div>
</body>
</html>