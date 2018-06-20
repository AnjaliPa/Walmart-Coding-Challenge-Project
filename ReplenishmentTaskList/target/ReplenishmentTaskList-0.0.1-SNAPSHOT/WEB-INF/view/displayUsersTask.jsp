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
			 		<th>Task Estimated Time</th>
			 		<th>Task Priority</th>
			 		<th>Created By</th>
			 	</tr>
			 	</thead>
			 	<c:forEach items="${Task}" var="task">
			 		<tr>
			 		<th>${task.taskName}</th>
			 		<th>${task.taskDescription}</th>
			 		<th>${task.taskPriority}</th>
			 		<th>${task.taskPriority}</th>
			 		<th>${task.username} </th>
			 	</tr>
			 					 	
			 	</c:forEach>
			 		
			 </table>
			 <button type="button" name="back" onclick="history.back()" class="btn btn-danger">Go Back</button>
			 
			</div>
		
<%@include file="/WEB-INF/view/template/footer.jsp"%>
		
     

    