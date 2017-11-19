<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

    <head>

      
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title></title>

        <!-- CSS -->
        <link href="<c:url value="/resources/css/loginStyle.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/form-elements.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        
    </head>

    <body background="<c:url value="/resources/img/backgrounds/1.jpg"/>">
        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            
                         
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        		<p>Entrer votre login et mot de passe pour se connecter:</p>
                        		</div>
                        		
                            </div>
                            <div class="form-bottom" id="login-box">
                            <c:if test="${not empty msg}">
                            <div class="msg">${msg}</div>
                            </c:if>
                            
			                    <form name="loginForm" role="form" action="<c:url value="/j_spring_security_check"/>"
			                     method="post" class="login-form">
			                     <c:if test="${not empty error}">
			                     <div class="error" style="color:#ff0000;">${error}</div>
			                     </c:if>
			                    	<div class="form-group">
			                    		<label class="sr-only" for="username">Login</label>
			                        	<input type="text" name="username" placeholder="Login..." class="form-username form-control" id="username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="password">Password</label>
			                        	<input type="password" name="password" placeholder="Mot de passe..." class="form-password form-control" id="password">
			                        </div>
			                        <input type="submit" class="btn btn-success" style="width:100%;height:50px;font-size:20px;" value="Connexion">
			                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
                        	
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery.backstretch.min.js"/>"></script>
        <script src="<c:url value="/resources/js/scripts.js"/>"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>