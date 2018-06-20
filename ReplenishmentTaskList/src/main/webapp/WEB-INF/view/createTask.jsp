<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="/WEB-INF/view/template/header.jsp" %>


 <div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Create Task Page</h1>
            <p class="lead">Fill the below information to create Task:</p>
        </div>
         <form:form action="${pageContext.request.contextPath}/createTaskProcess" method="post" commandName="task">
         <div> 
			<label class="profile-name h4.small" ><strong>Hi .. ${users.username}</strong></label>
		</div>
         <div class="form-group">
            <label for="name">Task Name</label>
            <input type='text' name='taskName' id="name" class="form-Control" style="width:100%"/>
        </div>

            
 		<div class="form-group">
            <label for="description">Task Description</label>
            <textarea name="taskDescription" id="description" class="form-Control" style="width:100%"></textarea>
        </div>
      
        

       

        <div class="form-group">
            <label for="priority">Priority</label>
            <input type='text' name="taskPriority" id="priority" class="form-Control" style="width:100%"/>
        </div>
        
        <div class="form-group">
            <label for="estimatedtime">Estimated Time</label>
            <input type='text' name="taskEstimatedTime" id="estimatedtime" class="form-Control" style="width:100%"/>
        </div>
 		<div class="form-group">
            <input type="hidden" name="username" id="name" class="form-Control" style="width:100%" value="${users.username}"/>
         </div> 
       
      
        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
         <button type="button" name="back" onclick="history.back()" class="btn btn-default">Cancel</button>
       </form:form>


        <%@include file="/WEB-INF/view/template/footer.jsp" %>
