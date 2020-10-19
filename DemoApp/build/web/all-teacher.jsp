<%-- 
    Document   : ViewProduct
    Created on : Oct 10, 2020, 9:15:36 AM
    Author     : Admin
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="entity.Teacher"%>
<%@include file="checkSession.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Teacher</title>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>AKKHOR | Add Teacher</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
        <!-- Normalize CSS -->
        <link rel="stylesheet" href="css/normalize.css">
        <!-- Main CSS -->
        <link rel="stylesheet" href="css/main.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/all.min.css">
        <!-- Flaticon CSS -->
        <link rel="stylesheet" href="fonts/flaticon.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="css/animate.min.css">
        <!-- Select 2 CSS -->
        <link rel="stylesheet" href="css/select2.min.css">
        <!-- Date Picker CSS -->
        <link rel="stylesheet" href="css/datepicker.min.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="style.css">
        <!-- Modernize js -->
        <script src="js/modernizr-3.6.0.min.js"></script>
    </head>
    <body>


        <c:choose>
            <c:when test="${empty requestScope['pList']}">
                <jsp:forward page="ProductControl?action=getData"></jsp:forward>
            </c:when>
            <c:otherwise>
                <jsp:include page="header.jsp"></jsp:include>
                    <div class="dashboard-content-one">
                        <div class="breadcrumbs-area">
                            <h3>Teacher</h3>
                            <ul>
                                <li>
                                    <a href="home.jsp">Home</a>
                                </li>
                                <li>All Teachers</li>
                            </ul>
                        </div>
                        <!-- Breadcubs Area End Here -->
                        <!-- Teacher Table Area Start Here -->
                        <div class="card height-auto">
                            <div class="card-body">
                                <div class="heading-layout1">
                                    <div class="item-title">
                                        <h3>All Teachers Data</h3>
                                    </div>
                                    <div class="dropdown">
                                        <a class="dropdown-toggle" href="#" role="button" 
                                           data-toggle="dropdown" aria-expanded="false">...</a>

                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="#"><i class="fas fa-times text-orange-red"></i>Close</a>
                                            <a class="dropdown-item" href="#"><i class="fas fa-cogs text-dark-pastel-green"></i>Edit</a>
                                            <a class="dropdown-item" href="#"><i class="fas fa-redo-alt text-orange-peel"></i>Refresh</a>
                                        </div>
                                    </div>
                                </div>
                                <form class="mg-b-20" action="ProductControl?action=search" method="POST">
                                    <div class="row gutters-8">
                                        <div class="col-3-xxxl col-xl-3 col-lg-3 col-12 form-group">
                                            <input type="text" placeholder="Search by ID ..."  class="form-control">
                                        </div>
                                        <div class="col-4-xxxl col-xl-4 col-lg-3 col-12 form-group">
                                            <input type="text" placeholder="Search by Name ..." name="txtSearch" class="form-control">
                                        </div>
                                        <div class="col-4-xxxl col-xl-3 col-lg-3 col-12 form-group">
                                            <input type="text" placeholder="Search by Phone ..."  class="form-control">
                                        </div>
                                        <div class="col-1-xxxl col-xl-2 col-lg-3 col-12 form-group">
                                            <button type="submit" class="fw-btn-fill btn-gradient-yellow">SEARCH</button>
                                        </div>
                                    </div>
                                </form>


                                <table border="1" align="center" width="60%" class="mt-5">
                                    <div class="table-responsive">
                                        <table class="table display data-table text-nowrap">
                                            <thead>
                                                <tr>
                                                    <th> 
                                                        <div class="form-check">
                                                            <input type="checkbox" class="form-check-input checkAll">
                                                            <label class="form-check-label">ID</label>
                                                        </div>
                                                    </th>
                                                    <th>Image</th>
                                                    <th>Name</th>
                                                    <th>Category</th>
                                                    <th>DOB</th>
                                                    <th>Address</th>
                                                    <th>Phone</th>
                                                    <th>E-mail</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>


                                        <c:forEach var="p" items="${requestScope['pList']}">
                                            <tr>
                                                <td>
                                                    <div class="form-check">
                                                        <input type="checkbox" class="form-check-input">
                                                        <label class="form-check-label">${p.id}</label>
                                                    </div>
                                                </td>
                                                <td class="text-center"><img src="img/figure/student2.png" alt="student"></td>
                                                <td>${p.name}</td>
                                                <td>${p.categogy}</td>
                                                <td>${p.dob}</td>
                                                <td>${p.address}</td>
                                                <td>${p.phone}</td>
                                                <td>${p.email}</td>


                                                <td>

                                                    <a href="ProductControl?action=edit&id=${p.id}"/><i class="fas fa-pencil-alt"></i></a>
                                                    <a href="ProductControl?action=delete&id=${p.id}" /><i class="fas fa-trash-alt"></i></a>
                                                </td>
                                            </tr>

                                        </c:forEach>
                                    </table>
                                </div>
                        </div>
                        <!-- jquery-->
                        <script src="js/jquery-3.3.1.min.js"></script>
                        <!-- Plugins js -->
                        <script src="js/plugins.js"></script>
                        <!-- Popper js -->
                        <script src="js/popper.min.js"></script>
                        <!-- Bootstrap js -->
                        <script src="js/bootstrap.min.js"></script>
                        <!-- Select 2 Js -->
                        <script src="js/select2.min.js"></script>
                        <!-- Date Picker Js -->
                        <script src="js/datepicker.min.js"></script>
                        <!-- Smoothscroll Js -->
                        <script src="js/jquery.smoothscroll.min.html"></script>
                        <!-- Scroll Up Js -->
                        <script src="js/jquery.scrollUp.min.js"></script>
                        <!-- Custom Js -->
                        <script src="js/main.js"></script> 
                    </c:otherwise>
                </c:choose> 
        </body>
    </html>
