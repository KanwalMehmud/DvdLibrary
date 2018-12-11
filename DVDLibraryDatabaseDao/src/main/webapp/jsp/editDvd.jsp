<%-- 
    Document   : editDvd
    Created on : Nov 4, 2018, 9:22:49 PM
    Author     : Farhan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company Contacts</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Edit Dvd</h1>
            <hr/>
            <sf:form class="form-horizontal" role="form" modelAttribute="editDvd"
                     action="editDvd" method="POST">
                <div class="form-group">
                    <label for="title" class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="title"
                                  path="title" placeholder="enter title"/>
                        <sf:errors path="title" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="releaseDate" class="col-md-4 control-label">Release Date:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="releaseDate"
                                  path="releaseDate" placeholder="enter release date"/>
                        <sf:errors path="releaseDate" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="directorName" class="col-md-4 control-label">Director Name:</label>
                        <div class="col-md-8">
                        <sf:input type="directorName" class="form-control" id="directorName"
                                  path="directorName" placeholder="enter Directors Name"/>
                        <sf:errors path="directorName" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="studio" class="col-md-4 control-label">Studio:</label>
                        <div class="col-md-8">
                        <sf:input type="studio" class="form-control" id="studio"
                                  path="studio" placeholder="Enter Studio"/>
                        <sf:errors path="studio" cssclass="error"></sf:errors>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="userRating" class="col-md-4 control-label">Rating:</label>
                        <div class="col-md-8">
                        <sf:input type="userRating" class="form-control" id="userRating"
                                  path="userRating" placeholder="enter Rating"/>
                        <sf:errors path="userRating" cssclass="error"></sf:errors>
                        <sf:hidden path="dvdID"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Update Dvd"/>
                    </div>
                </div>
            </sf:form>                
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>