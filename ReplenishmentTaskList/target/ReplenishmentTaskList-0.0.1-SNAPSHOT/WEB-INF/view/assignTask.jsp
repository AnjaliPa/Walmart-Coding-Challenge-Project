<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="/WEB-INF/view/template/header.jsp"%>
  
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Assign Task Detail</h1>

            <p class="lead">Here is the detail information for the Task is gonna assigned!</p>
        </div>

        <div class="container">
           
           <form:form action="${pageContext.request.contextPath}/taskAssignProcess" method="post" commandName="taskassign">
            <div> 
			 <label class="profile-name h4.small" ><strong>Hi .. ${users.username}</strong></label>
		    </div>
 			<div class="row">
                <div class="col-md-5">
           <div class="form-group">
            <label for="id">TaskId</label>
            <input type='text' name="taskId" id="id" class="form-Control" style="width:100%" value="${task.taskId}" readonly/>
          </div>  
             
           <div class="form-group">
            <label for="name">TaskName</label>
            <input type='text' name="taskName" id="name" class="form-Control" style="width:100%" value="${task.taskName}" readonly/>
          </div>  
          
          <div class="form-group">
            <label for="priority">Priority</label>
            <input type='text' name="taskPriority" id="priority" class="form-Control" style="width:100%" value="${task.taskPriority}" readonly/>
          </div>  
          
          <div class="form-group">
            <label for="description">Task Description</label>
            <input type='text' name="taskDescription" id="priority" class="form-Control" style="width:100%" value="${task.taskDescription}" readonly/>
          </div> 
                  
          <div class="form-group">
            <label for="status">Status</label>
            <input type='text' name="taskStatus" id="status" class="form-Control" style="width:100%" value="pending" readonly/>
          </div>
          <div class="form-group">
            <label for="feedback">Feedback</label>
            <input type='text' name="taskFeedback" id="feedback" class="form-Control" style="width:100%" />
          </div>
          <div class="form-group">
            <label for="notes">Notes</label>
            <input type='text' name="taskNotes" id="notes" class="form-Control" style="width:100%" />
          </div>
          
          <div>
            <label for = "assignTo">AssignTo</label></td>
            <select name="taskAssignTo" id="assignTo">
                        <option value="">Select</option>
            
            <c:forEach var="item" items="${taskAssignList}">
            <option value="${item}">${item}</option>
            </c:forEach>
            </select>
          
          </div>
          <div class="form-group">
           
            <input type="hidden" name="username" id="name" class="form-Control" style="width:100%" value="${users.username}"/>
          </div> 
          
           <br><br>
        <input type="submit" value="submit" class="btn btn-default">
		 <button type="button" name="back" onclick="history.back()" class="btn btn-default">Cancel</button>
       </form:form>
       </div>
     </div>
   </div>
   
<%@include file="/WEB-INF/view/template/footer.jsp"%>
		
     

    