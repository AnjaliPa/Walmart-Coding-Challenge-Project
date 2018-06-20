<%@taglib prefix ="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/view/template/header.jsp"%>
 
    <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
			 <h1> Status Action Matrix</h1> 
			 <p class="lead">Please fill Status Action Matrix</p>
			  <div> 
				<label class="profile-name h4.small" ><strong>Hi .. ${users.username}</strong></label>
			  </div>
			 
			 <table class="table table-striped table-hover">
			 	<thead>
			 		<tr class="bg-success">
			 		<th>Task ID</th>
			 		<th>Initial Status</th>
			 		<th>Next Status</th>
			 		<th>Action</th>
			 		<th>Error Status</th>
			 		<th></th>
			 	
			 		</tr>
			 	</thead>
			 		<form:form method="POST" action="${pageContext.request.contextPath}/saveStatusMatrix/${task.taskId}" commandName="statusMatrix">
			 		<tr>
			 		<th><input type='text' name="taskId"    value="${task.taskId}" readonly /></th>
			 		<th><input type='text' name="initialStatus" id="initialstatus"   value="Pending" readonly/></th>
			 		<th><input type='text' name="nextStatus" id="nextstaus"   value="Started" readonly/></th>
			 		<th><input type='text' name="taskAction" id="action"/></th>
			 		<th><input type='text' name="taskErrorStatus" id="errorstatus"   /></th>
			 		<th> <input type="submit" value="submit" class="btn btn-default"></th>
			 		</tr>
			 	 </form:form>
			 	 <form:form method="POST" action="${pageContext.request.contextPath}/saveStatusMatrix/${task.taskId}" commandName="statusMatrix">
			 	 
			 		<tr>
			 		<th><input type='text' name="taskId"   value="${task.taskId}" readonly /></th>
			 		<th><input type='text' name="initialStatus" id="initialstatus"   value="Started" readonly/></th>
			 		<th><input type='text' name="nextStatus" id="nextstaus"   value="In Progress" readonly/></th>
			 		<th><input type='text' name="taskAction" id="action"/></th>
			 		<th><input type='text' name="taskErrorStatus" id="errorstatus"   /></th>
			 		<th> <input type="submit" value="submit" class="btn btn-default"></th>
			 		</tr>
			 		</form:form>
			 		<form:form method="POST" action="${pageContext.request.contextPath}/saveStatusMatrix/${task.taskId}" commandName="statusMatrix">
			 		<tr>
			 		<th><input type='text' name="taskId"    value="${task.taskId}" readonly /></th>
			 		<th><input type='text' name="initialStatus" id="initialstatus"   value="In Progress" readonly/></th>
			 		<th><input type='text' name="nextStatus" id="nextstaus"   value="Finished" readonly/></th>
			 		<th><input type='text' name="taskAction" id="action"/></th>
			 		<th><input type='text' name="taskErrorStatus" id="errorstatus"   /></th>
			 		<th> <input type="submit" value="submit" class="btn btn-default"></th>
			 		</tr>
			 </form:form>
			 		
			 </table>
			
			 <button type="button" name="back" onclick="history.back()" class="btn btn-danger">Go Back</button>
			 
			</div>
		
<%@include file="/WEB-INF/view/template/footer.jsp"%>
		
     

    