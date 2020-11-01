<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="resource/common.jsp"></jsp:include>
<title>course-add</title>
</head>
<body>

	<div class="container">
		<jsp:include page="resource/menu.jsp"></jsp:include>
		<div class="row">
		
		
			<h4>${not empty course ? 'Edit Course' : 'Add New Course' }</h4>
		</div>
		<c:url var="save" value="/course-add"></c:url>
		<form action="${save }" class="form" method="post">
			<input type="hidden" name="courseid" value="${course.id }" />
			<div class="form-group">
				<label for="">Course Name</label> <input type="text"
					value="${course.name }" name="coursename" class="form-control"
					required="required" placeholder="Enter Course Name" />
			</div>

			<div class="form-group">
				<label for="">Fees</label> <input type="text"
					value="${course.fees }" name="fees" class="form-control"
					placeholder="Enter Course Fees" />
			</div>

			<div class="form-group">
				<label for="">Duration</label> <input type="text"
					value="${course.duration }" name="duration" class="form-control"
					placeholder="Enter Course duration" />
			</div>


			<div class="form-group">
				<label>Level</label> <select name="level" class="form-control">
					<option value="Basic" ${"Basic"==course.level?'selected':'' }>Basic</option>
					<option value="Intermediate"
						${"Intermediate"==course.level?'selected':'' }>Intermediate</option>
					<option value="Advance" ${"Advance"==course.level?'selected':'' }>Advance</option>
				</select>
			</div>

			<button type="submit" class="btn btn-success">Save</button>
			<button type="reset" class="btn btn-danger">Clear</button>
		</form>
	</div>
</body>
</html>