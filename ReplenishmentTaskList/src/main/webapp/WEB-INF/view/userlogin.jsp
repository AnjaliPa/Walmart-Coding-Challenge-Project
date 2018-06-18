<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="/WEB-INF/view/template/header.jsp" %>


 <div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>User Login Page</h1>
            <p class="lead">Fill the below information to Login:</p>
        </div>
        <div  style="color: red; font-size:large"  class="lead" ><h6>${errors}</h6></div>
         <form:form action="${pageContext.request.contextPath}/userlandingPage" method="post" commandName="users">
         
        <div class="form-group">
            <label for="username">User: </label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" />
        </div>
        
        <input type="submit" value="Submit" class="btn btn-default">
        
        </form:form>
  
 			
	    <%@include file="/WEB-INF/view/template/footer.jsp" %>


</body>
</html>