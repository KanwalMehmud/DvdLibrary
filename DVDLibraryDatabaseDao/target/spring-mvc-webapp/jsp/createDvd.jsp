<%-- 
 <%-- 
    Document   : dvd.jsp
    Created on : Nov 4, 2018, 11:07:12 AM
    Author     : Farhan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        

        <title>Create DVD</title>
    </head>
    <body>
        <div class="container">
            <h1>Create DVD</h1>

            <form class="form-horizontal" 
                  role="form" method="POST" 
                  action="createDvd">
                <div class="form-group">
                    <label for="title" class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="title" placeholder="Enter Title" required/>
                    </div>
                </div>
                 <div class="form-group">
                    <label for="releaseDate" class="col-md-4 control-label">Release Date:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="releaseDate" placeholder="Enter Release Date"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="mpaaRating" class="col-md-4 control-label">MPAA Rating:</label>
                    <div class="col-md-8">
                        <select class="form-control" id="mpaaRating" name="mpaaRating">
                            <option>G</option>
                            <option>PG</option>
                            <option>G</option>
                            <option >R</option>
                            <option>NC-17</option>
                        </select>
                    </div>              
                </div>
                
                <div class="form-group">
                    <label for="directorName" class="col-md-4 control-label">Director:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="directorName" placeholder="Enter Director"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="studio" class="col-md-4 control-label">Studio:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="studio" placeholder="Enter Studio"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="userRating" class="col-md-4 control-label">Rating:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="userRating" placeholder="Enter Rating" required/>
                    </div>
                </div>
               
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Create Dvd"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            <input type="button" value="Cancel"/></a>
                    </div>
                </div>
            </form>
            <a href="index.jsp">home</a>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>