<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div class="row">
			<h4>${not empty student ? 'Edit Reg' : 'Add New Registration' }</h4>
		</div>
		<c:url var="save" value="/reg-add"></c:url>
		<form action="${save }" class="form" method="post">
			<input type="hidden" name="regid" value="${registrations.id }">
			<div class="form-group">
				<label>Student</label> <select name="stuid"
					class="form-control col-6">
					<c:forEach items="${student}" var="s">
						<option value="${s.id }"
							${registrations.student.id==s.id?'selected':'' }>${s.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Class</label> <select name="classid"
					class="form-control col-6">
					<c:forEach items="${classes}" var="i">
						<option value="${i.id }"
							${registrations.classes.id==i.id?'selected':'' }>${i.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Registration Date</label> <input type="date"
					value="${registrations.regDate}" name="regdate"
					class="form-control" required="required" /> 
				<label>PaidAmount</label> <input type="number" 
				    value="${registrations.paidAmt}"
					name="amt" class="form-control" required="required"
					placeholder="Enter  Paid Amount" />

			</div>
			<button type="submit" class="btn btn-success">Save</button>
			<button type="reset" class="btn btn-danger">Clear</button>

		</form>
	</div>
</body>
</html>