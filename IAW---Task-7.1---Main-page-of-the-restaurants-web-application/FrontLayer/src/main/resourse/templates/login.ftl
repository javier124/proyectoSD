<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title> Login </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
          integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="/">Restaurants</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
    </div>
</nav>

<div class="login-page">
    <div class="form">
        <form action="/login" method="post" class="login-form">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <h6 class="color">Usuari</h6>
            <input type="text" placeholder="username" name="usuari"/>
            <h6 class="color"> Password</h6>
            <input type="password" placeholder="password" name="password"/>
            <button>login</button>
        </form>
    </div>
</div>
<#-- esto es lo que se mostrara si da un error -->
<#if error.isPresent()>
<p>El user o Password son incorrecto ,si se a olvidado el usuario o password consulte con un correo </p>
</#if>
</body>
</html>