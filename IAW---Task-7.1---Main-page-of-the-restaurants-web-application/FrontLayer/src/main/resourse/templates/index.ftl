<!DOCTYPE html>
<html>
<head>
    <title>${title!""}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/cyborg/bootstrap.min.css>
    <link href=" https:
    //fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Estilo CSS -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="/">Restaurants</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Inici <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/rest/api/v1/restaurants">API REST</a>
            </li>
        </ul>
    </div>
    </div>
</nav>
<div class="jumbotron" role="main">
    <div class="row featurette">
        <div class="col-md-7">
            <h1 class="display-3"><#if name??>
                Els millors ${name!"yuhu"} de Mallorca
            </#if></h1>
            <hr class="my-4">
            <a class="btn btn-info" href="#" role="button"><span class="text-muted">Més informació</span></a>
        </div>
        <div class="col-md-5">
            <img src="http://lorempixel.com/500/150"/>
        </div>
    </div>
</div>
<#if list??>
<div class="row center mt-2">
    <#list list as item>
        <div class="col-md-3">
            <div class="media mt-5 ml-5">
                <img class="align-self-start mr-5 rounded-circle"
                     src="${item.imagen!""}"
                     alt="Random Image" width="120" height="120">
                <div class="media-body">
                    <h5 class="mt-0">Nom ${item.nom!""}</h5>
                    <p>Direcció: ${item.adresa!""}</p>
                    <p>URL: ${item.website!""}</p>
                    <p>Telèfon: ${item.telefono!""}</p>
                    <p>${item.tipus!""}</p>
                    <p>Nota: ${item.Mitjana!""}</p>
                </div>
            </div>
        </div>
    </#list>
</div>
</#if>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
        integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
        crossorigin="anonymous"></script>
</body>
</html>