<%-- 
    Document   : dvd.jsp
    Created on : Nov 4, 2018, 11:07:12 AM
    Author     : Farhan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dvd Library</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>DVD Library Spring MVC Application from Archetype</h1>
            <hr/>
            <div class="row">
                <div class="navbar">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayDvdPage">Display Dvds</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayCreateDvdPage">Create Dvd</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displaySearchPage">Search</a></li>
                    </ul>    
                </div>

            </div>
        </div>
        <div class="col-md-6">
            <h2>My Dvds</h2>
            <table id="dvdTable" class="table table-hover">
                <tr>
                    <th width="20%">Title</th>
                    <th width="20%">Release Date</th>
                    <th width="20%">Director</th>
                    <th width="20%">Studio</th>
                    <th width="10%">Rating</th>
                    <th width="15%"></th>
                    <th width="15%"></th>
                </tr>

                <c:forEach var="currentDvd" items="${dvds}">
                    <tr>
                        <td>
                            <a href="displayContactDetails?contactId=${currentDvd.dvdID}">
                                <c:out value="${currentDvd.title}"/> 
                        </td>
                        <td>
                            <c:out value="${currentDvd.releaseDate}"/>
                        </td>
                        <td>
                            <c:out value="${currentDvd.directorName}"/>
                        </td>
                        <td>
                            <c:out value="${currentDvd.studio}"/>
                        </td>
                        <td>
                            <c:out value="${currentDvd.userRating}"/>
                        </td>
                        <td>
                            <a href="displayEditDvdForm?dvdId=${currentDvd.dvdID}">
                                Edit
                            </a>
                        </td>
                        <td>
                            <a href="deleteDvd?dvdId=${currentDvd.dvdID}">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>                    
        </div> <!-- End col div -->

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
