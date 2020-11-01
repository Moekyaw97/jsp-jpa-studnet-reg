<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<ul class="navbar-nav mr-auto">
		<c:url value="/index.jsp" var="home"></c:url>
		<c:url value="/coursepage" var="course"></c:url>
		<c:url value="/classpage" var="classic"></c:url>
		<c:url value="/studentpage" var="student"></c:url>
		<c:url value="/regpage" var="reg"></c:url>
		
		
		
		
		<li class="nav-item active"><a class="nav-link" href="${home }">Home
		</a></li>
		<li class="nav-item active"><a class="nav-link" href="${course }">Course
		</a></li>
		<li class="nav-item active"><a class="nav-link"href="${classic }">Classes
		</a></li>
		<li class="nav-item active"><a class="nav-link" href="${student }">Student
		</a></li>	
		<li class="nav-item active"><a class="nav-link" href="${reg }">Registration
		</a></li>
	</ul>
</nav>
