<%--
  Created by IntelliJ IDEA.
  User: I56852
  Date: 09/10/2019
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Secteur en détail</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- FavIcon -->
    <link rel="icon" type="image/png" href="/img/mountain_favicon.png" />

    <!-- Fonts -->
    <link href="/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/css/animate.css" rel="stylesheet" />
    <!-- Squad theme CSS -->
    <link href="/css/style.css" rel="stylesheet"/>
    <link href="/color/default.css" rel="stylesheet"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.css">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css">

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
                <h1>Détail d'un secteur</h1>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/index"/>">Home</a></li>
                <li><a href="<c:url value="/index#search"/>">Chercher</a></li>
                <li><a href="<c:url value="/index#spots"/>">Spots</a></li>
                <sec:authorize access="hasAnyAuthority('USER', 'ADMIN')">
                    <li><a href="<c:url value="/espacePerso"/>">Mon espace perso</a></li>
                </sec:authorize>
                <c:if test="${pageContext.request.userPrincipal == null}">
                    <li><a href="" data-toggle="modal" data-target="#id-popup">Inscription / Connexion</a>
                        <div class="modal fade " id="id-popup" tabindex="-1" role="dialog" aria-labelledby="titrePopUp" aria-hidden="true" data-backdrop="false">

                            <div class="modal-dialog ">

                                <div class="modal-content">

                                    <!-- le titre de la popup -->
                                    <div class="modal-header">
                                        <h4 class="modal-title text-center" id="titrePopUp">Connexion ou Inscription aux Amis de l'Escalade
                                            <!-- lla croix de fermeture de la popup -->
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> </h4>
                                    </div>

                                    <!-- le contenu HTML de la popup -->
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <div class="row justify-content-md-center">
                                                <div class="col-lg-8 col-lg-offset-2">
                                                    <div class="avatar"><img src="/img/works/Logo_ADE.png"  alt="" /></div>
                                                    <div class="card-body border-info">
                                                        <form action="/login" method="post">
                                                            <div class="form-group">
                                                                <div class="col-lg-6 row center-block">
                                                                    <label for="username">Username</label>
                                                                    <input type="text" name="username" id="username" placeholder="Pseudo"/>
                                                                </div>
                                                                <div class="col-lg-6 row center-block">
                                                                    <label for="password">Password</label>
                                                                    <input type="password" name="password" id="password" placeholder="Mot de Passe">
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-lg-12">
                                                                    <p></p>
                                                                    <input type="submit" class="btn btn-primary pull-right"/>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <!-- le pied de page de la popup -->
                                                    <div class="modal-footer row">
                                                        <div class="col-lg-12 row">
                                                            <p></p>
                                                            <p class="text-center">Si tu n'as pas encore de compte chez nous, c'est par ici que ça se passe
                                                            </p>
                                                        </div>
                                                        <div class="col-lg-6 center-block">
                                                            <i class="glyphicon glyphicon-arrow-down"></i>
                                                        </div>
                                                        <div class="col-lg-8 row center-block">
                                                            <a href="<c:url value="/register"/>" type="submit" class="btn btn-warning">Inscription</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:if>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Section: DetailSector -->
<section id="search" class="home-section">
    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading text-center">
                            <h2>${sectorDetails.sectorName}</h2>
                            <i class="fa fa-2x fa-angle-down"></i>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">

            <div class="service-box team boxed-grey">
                <div class="service-desc">
                    <table class="table table-sm">
                        <thead>
                        <tr class="bg-primary">
                            <th class="text-center" scope="col">Nom de la voie</th>
                            <th class="text-center" scope="col">Longueur</th>
                            <th class="text-center" scope="col">Hauteur</th>
                            <th class="text-center" scope="col">Cotation</th>
                            <sec:authorize access="hasAnyAuthority('ADMIN','USER')">
                                <th class="text-center" scope="col">Edition</th>
                            </sec:authorize>
                            <sec:authorize access="hasAuthority('ADMIN')">
                                <th class="text-center" scope="col">Suppression</th>
                            </sec:authorize>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${scoringList}" var="score">
                            <tr>
                                <td class="text-center" scope="row">${score.road.roadName}</td>
                                <td class="text-center" scope="row">${score.lenght.distance} mètres</td>
                                <td class="text-center" scope="row">${score.lenght.height} mètres</td>
                                <td class="text-center" scope="row">${score.rating}</td>
                                <sec:authorize access="hasAnyAuthority('ADMIN','USER')">
                                    <td class="text-center" scope="row">
                                        <a type="button" class="btn btn-warning btn-xs" href="<c:url value="/spot/${spotId}/sector/${sectorId}/road/${score.road.id}/lenght/${score.lenght.id}/scoring/${score.id}/editRoad"></c:url> ">Editer Voie</a>
                                    </td>
                                </sec:authorize>
                                <sec:authorize access="hasAuthority('ADMIN')">
                                    <td class="text-center" scope="row">
                                        <a type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#confirmDelete${score.road.id}">Supprimer Voie </a>
                                        <!-- Modal -->
                                        <div class="modal fade" id="confirmDelete${score.lenght.road.id}" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteTitle" aria-hidden="true" data-backdrop="false">
                                            <div class="modal-dialog fa-align-center" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header alert-danger">
                                                        <h5 class="modal-title" id="exampleModalLongTitle">Attention</h5>
                                                    </div>
                                                    <div class="modal-body">
                                                        Etes-vous sûr de vouloir supprimer le voie ${score.road.roadName} ?
                                                    </div>
                                                    <div class="modal-footer">
                                                        <form action="/road/${score.road.id}/deleteRoad" method="post">
                                                            <button type="submit" name="roadId" id="roadId" class="btn btn-danger">Supprimer </button>
                                                        </form>
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Retour</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </sec:authorize>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                    <a type="button" class="btn btn-info pull-right" href="/spot/${spotId}/spotDetails">Retour vers le Spot</a>
                    <a type="button" class="btn btn-success pull-right" href="/index">Retour Page d'accueil</a>
                </div>
            </div>
        </div>
        <sec:authorize access="hasAnyAuthority('USER', 'ADMIN')">
            <div class="col-md-12">
                <div class="form-group">
                    <form action="/spot/${spotId}/sector/${sectorId}/saveCommentSector" method="post" class="col-lg-12">
                        <label for="texteComment">Un commentaire sur le secteur ${sectorDetails.sectorName} ?</label>
                        <textarea class="form-control" name="texteComment" id="texteComment" placeholder="Entrez votre commentaire"></textarea>
                        <input type="hidden" name="spotId" id="spotID" value="${sectorDetails.spot.id}"/>
                        <input type="hidden" name="sectorId" id="sectorID" value="${sectorDetails.id}"/>
                        <button type="submit" class="btn btn-success pull-right" id="btnContactUs">
                            Envoyer</button>
                    </form>
                </div>
            </div>
        </sec:authorize>
    </div>
</section>
<!-- /Section: DetailSector -->

<!-- Section: CommentsDetailSector -->
<sec:authorize access="hasAnyAuthority('USER', 'ADMIN')">
    <section id="comments" class="home-section">
        <div class="heading-about">
            <div class="container">
                <div class="row col-lg-12">
                    <h4>Les Commentaires</h4>
                    <c:forEach items="${commentSectors}" var="comment">
                        <div class="boxed-grey col-lg-12 container-fluid table-bordered">
                            <p>par ${comment.climbUser.username} le <fmt:formatDate value="${comment.date}" type="both"></fmt:formatDate></p>
                            <comment>${comment.texteComment}</comment>
                            <sec:authorize access="hasAnyAuthority('ADMIN') || ${climbUser.id} == ${comment.climbUser.id}">
                                <a type="button" class=" btn btn-warning pull-right btn-xs " data-toggle="modal" data-target="#confirmUpdate${comment.id}">Modifier</a>
                                <!-- Modal -->
                                <form action="/spot/${comment.sector.spot.id}/sector/${comment.sector.id}/updateCommentSector/${comment.id}" method="post" class="col-lg-12">
                                    <div class="modal fade" id="confirmUpdate${comment.id}" tabindex="-1" role="dialog" aria-labelledby="confirmUpdateTitle" aria-hidden="true" data-backdrop="false">
                                        <div class="modal-dialog fa-align-center" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header alert-warning">
                                                    <h5 class="modal-title text-center" id="exampleModalLongTitle">Modifier votre commentaire</h5>
                                                </div>
                                                <div class="modal-body">
                                                    <input name="texteComment" id="texteComment" class="form-control" type="text" value="${comment.texteComment}"/>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-warning">Modifier</button>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Retour</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <a type="button" class="btn btn-danger pull-right btn-xs" data-toggle="modal" data-target="#confirmDeleteComment${comment.id}">Supprimer </a>
                                <!-- Modal -->
                                <div class="modal fade" id="confirmDeleteComment${comment.id}" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteTitle" aria-hidden="true" data-backdrop="false">
                                    <div class="modal-dialog fa-align-center" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header alert-danger">
                                                <h5 class="modal-title text-center" id="exampleModalLongTitle">Attention</h5>
                                            </div>
                                            <div class="modal-body">
                                                <p>Etes-vous sûr de vouloir supprimer le commentaire " ${comment.texteComment}" ?</p>
                                            </div>
                                            <div class="modal-footer">
                                                <form action="/spot/${comment.sector.spot.id}/sector/${comment.sector.id}/deleteCommentSector/${comment.id}" method="post">
                                                    <button type="submit" name="commentId" id="commentId" class="btn btn-danger">Supprimer </button>
                                                </form>
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Retour</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </sec:authorize>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</sec:authorize>
<!-- /Section: CommentsDetailSector -->
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
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.easing.min.js"></script>
<script src="/js/jquery.scrollTo.js"></script>
<script src="/js/wow.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/js/custom.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="/chosen/chosen.jquery.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/anchor-js/4.2.0/anchor.min.js"></script>
<script type="text/javascript">
    $(function() {
        $(".chosen-select").chosen();
    });
</script>


</body>

</html>

