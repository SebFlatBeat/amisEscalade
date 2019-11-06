<%--
  Created by IntelliJ IDEA.
  User: I56852
  Date: 07/10/2019
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Inscription</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- FavIcon -->
    <link rel="icon" type="image/png" href="img/mountain_favicon.png" />

    <!-- Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/animate.css" rel="stylesheet" />
    <!-- Squad theme CSS -->
    <link href="css/style.css" rel="stylesheet"/>
    <link href="color/default.css" rel="stylesheet"/>

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
<!-- Preloader -->
<div id="preloader">
    <div id="load"></div>
</div>

<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}index">
                <h1>Les Amis de l'Escalade</h1>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}index">Home</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Section: register -->
<section id="intro" class="intro text-center text-dark">
        <div class="container boxed-grey col-lg-4 col-lg-offset-4">
            <div class="row">
                <h2>Inscription</h2>
                <form action="/register" method="POST">
                    <div class="form row">
                        <div class="form-group col-md-6">
                            <label>UserName</label>
                            <input class="input-group center-block text-info" type="text" id="userName" name="userName" placeholder="Votre pseudo"/>
                            <span class="has-error">${climbUserForm.userName}</span>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Email</label>
                            <input class="input-group center-block text-info" type="text" id="email" name="email" placeholder="Votre adresse mail"/>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Password</label>
                            <input class="input-group center-block text-info" type="password" id="password" name="password" placeholder="Votre mot de passe"/>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Confirm</label>
                            <input class="input-group center-block text-info" type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirmer votre mot de passe"/>
                        </div>

                        <div class="form-group col-md-12">
                            <input class="input-group center-block btn btn-primary" type="submit" value="Submit" href="/registerSuccessful"/>
                        </div>
                            <div class="form-group col-md-12">
                            <a class="btn btn-danger" href="<c:url value="/index"/>">Cancel</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
</section>
<!-- /Section: register -->

<footer>
    <div class="container">
                <p>&copy;SquadFREE. All rights reserved.</p>
                <div class="credits">
                    <!--
                      All the links in the footer should remain intact.
                      You can delete the links only if you purchased the pro version.
                      Licensing information: https://bootstrapmade.com/license/
                      Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Squadfree
                    -->
                    Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                </div>
            </div>
</footer>

<!-- Core JavaScript Files -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.min.js"></script>
<script src="js/jquery.scrollTo.js"></script>
<script src="js/wow.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/custom.js"></script>
<script src="contactform/contactform.js"></script>


</body>

</html>
