<%@taglib prefix ="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/view/template/header.jsp"%>
 
    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
			 <h1> All Tasks</h1> 
			 <p class="lead">Checkout all awesome tasks available now</p>
			  <div> 
				<label class="profile-name h4.small" ><strong>Hi .. ${users.username}</strong></label>
			  </div>
			 <table class="table table-striped table-hover">
			 	<thead>
			 		<tr class="bg-success">
			 		<th>Task Name</th>
			 		<th>Task Description</th>
			 		<th>Priority</th>
			 		<th>Estimated Time</th>
			 		<th>Created By</th>
			 		<th></th>
			 		</tr>
			 	</thead>
			 	<c:forEach items="${tasks}" var="task">
			 		<tr>
			 		<th>${task.taskName}</th>
			 		<th>${task.taskDescription}</th>
			 		<th>${task.taskPriority}</th>
			 		<th>${task.taskEstimatedTime} HR</th>
			 		<th>${task.username} </th>
			 		<th><a href='<spring:url value="/assignTask/${task.taskId}"/>' class="btn btn-primary">Assign Task</a>
			 		
			 		</tr>
			 					 	
			 	</c:forEach>	
			 </table>
			</div>
		
<%@include file="/WEB-INF/view/template/footer.jsp"%>
		
     

    