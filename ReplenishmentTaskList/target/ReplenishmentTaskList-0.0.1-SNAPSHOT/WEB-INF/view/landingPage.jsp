<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/view/template/header.jsp" %>

 <div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Landing Page</h1>
            <p class="lead">Please go through with below task</p>
        </div>
        <div > 
			<label class="profile-name h4.small" ><strong>Hi .. ${users.username}</strong></label>
		</div>
  			<tr>
  			<th><a href='<c:url value="/displayCreateTaskForm"/>' class="btn btn-primary">Create Task</a></th>
  			<th><a href='<c:url value="/displayTask"/>' class="btn btn-primary">Display task</a></th>
  			<th><a href='<c:url value="/displayCreateTaskForm"/>' class="btn btn-primary">Change Task</a></th>
  			<th><a href='<c:url value="/displayPendingTask"/>' class="btn btn-primary">Assign Task</a></th>
  			<th><a href='<c:url value="/displayCreateTaskForm"/>' class="btn btn-primary">SAS</a></th>
  			
  			</tr>
  
		        
	
 <%@include file="/WEB-INF/view/template/footer.jsp" %>


</body>
</html>