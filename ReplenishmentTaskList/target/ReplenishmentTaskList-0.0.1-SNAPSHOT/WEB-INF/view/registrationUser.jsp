<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="/WEB-INF/view/template/header.jsp" %>


 <div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Registration User Page</h1>
            <p class="lead">Fill the below information to Registration:</p>
        </div>
        <div  style="color: red; font-size:large"  class="lead" ><h6>${errors}</h6></div>
         <form:form action="${pageContext.request.contextPath}/userRegistrationPage" method="post" commandName="users">
         
        <div class="form-group">
            <label for="username">User: </label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required/>
        </div>
        
         <div class="form-group">
           
            <input type="hidden" id="enabled" name="enabled" class="form-control" value="TRUE"/>
        </div>
        <div>
            <label for = "role">Role</label></td>
            <select name="role" id="role">
             <option value="admin">admin</option>
             <option value="user">user</option>
           
            </select>
          
          </div>
        <br><br><br>
        <input type="submit" value="Submit" class="btn btn-default">
        <button type="button" name="back" onclick="history.back()">Cancel</button>
        </form:form>
  
 			
	    <%@include file="/WEB-INF/view/template/footer.jsp" %>


</body>
</html>