<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="resource/common.jsp"></jsp:include>
<title>Course</title>
</head>
<body>
	
	<div class="container">
		<jsp:include page="resource/menu.jsp"></jsp:include>

		<div class="row mt-5">
			<div class="col-10">
				<h3>All Courses</h3>
			</div>
			
			<div class="col-2">
			<c:url var="add" value="/course-add"></c:url>
			<a href="${add }" class="btn btn-success">Add new course</a></div>
		</div>
		<table class="table">
			<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Fees</td>
				<td>Duration</td>
				<td>Level</td>
			</tr>
			</thead>
			<tbody>
		<!-- 	item list -->
		<c:forEach items="${course }" var="c">
		<tr>
		<td>${c.id }</td>
		<td>${c.name }</td>
		<td>${c.fees }</td>
		<td>${c.duration }</td>
		<td>${c.level }</td>
		<td>
		<c:url var="edit" value="/course-edit">
		<c:param name="courseid">${c.id }</c:param>
		</c:url>
		<a href="${edit }" class="btn btn-outline-success">Edit</a>
		</td>
		<td>
		<c:url var="delete" value="/course-delete">
		<c:param name="courseid">${c.id }</c:param>
		</c:url>
		<a href="${delete }" class="btn btn-outline-danger">Delete</a>
		</td>
		</tr>
		</c:forEach>
			</tbody>
		</table>



	</div>

</body>
</html>