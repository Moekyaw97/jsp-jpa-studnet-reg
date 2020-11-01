<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="resource/common.jsp"></jsp:include>
<title></title>
</head>
<body>
	<div class="container">
		<jsp:include page="resource/menu.jsp"></jsp:include>
		<div class="row">
			<h4>${not empty course ? 'Edit Class' : 'Add New Class' }</h4>
		</div>
		<c:url var="save" value="/class-add"></c:url>
		<form action="${save }" class="form" method="post">

			<input type="hidden" name="classid" value="${classes.id }" />
			
			<div class="form-group">
				<label for="">Course Name</label> <select name="classid" id=""
					class="form-control">
					<c:forEach items="${courses }" var="c">
						<option value="${c.id }"
							${classes.course.id == c.id ? 'selected':'' }>${c.name }</option>
					</c:forEach>
				</select>
			</div>
			
			
			<div class="form-group">
				<label for="">Class Name</label> <input type="text"
					value="${classes.name }" name="classname" class="form-control"
					required="required" placeholder="Enter Class Name" />
			</div>

			<div class="form-group">
				<label for="">Start Date</label> <input type="date" required="required"
					value="${classes.start_date }" name="startdate" class="form-control" 
					/>
			</div>



			<button type="submit" class="btn btn-success">Save</button>
			<button type="reset" class="btn btn-danger">Clear</button>
		</form>
	</div>
</body>
</html>