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
  			<th><a href='<c:url value="/displayPendingTask"/>' class="btn btn-primary">Pending Task</a></th>
  			<th><a href='<c:url value="/displayUsersTask"/>' class="btn btn-primary">Display Task</a></th>
  			
  			<th><button type="button" name="back" onclick="history.back()" class="btn btn-primary">Go Back</button>
  			</tr>
  
		        
	
 <%@include file="/WEB-INF/view/template/footer.jsp" %>


</body>
</html>