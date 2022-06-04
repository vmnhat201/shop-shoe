<%-- 
    Document   : add-shoes
    Created on : Mar 10, 2022, 2:35:45 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Admin Dashboard</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <link rel="stylesheet" href="assets/vendors/jvectormap/jquery-jvectormap.css">
        <link rel="stylesheet" href="assets/vendors/flag-icon-css/css/flag-icon.min.css">
        <link rel="stylesheet" href="assets/vendors/owl-carousel-2/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/vendors/owl-carousel-2/owl.theme.default.min.css">
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel="stylesheet" href="assets/css/style.css">
        <!-- End layout styles -->
        <link rel="shortcut icon" href="assets/images/favicon.png" />
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Are u sure to delete product with id=" + id + " ?")) {
                    window.location = "delete?id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <div class="container-scroller">
            <!-- partial:partials/_sidebar.html -->
            <jsp:include page="admin/module/header-admin.jsp"></jsp:include>
            <!-- partial -->
            <div class="main-panel">
                <div class="content-wrapper">


                    <div class="row">
                        <div class="col-md-6 grid-margin stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Add Shoes</h4>
                                    <p class="card-description"> Basic form add a new shoes </p>
                                    <form action="add-shoes" method="post" class="forms-sample">

                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Shoes Name</label>
                                            <input name="name" type="text" class="form-control"  placeholder="Name">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Shoes Price</label>
                                            <input name="price" type="number" class="form-control"  placeholder="Price">
                                        </div>
                                        <div class="form-check">

                                            <input type="radio" class="form-check-input" name="color" id="optionsRadios1" value="${1}"> White &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" class="form-check-input" name="color" id="optionsRadios1" value="${2}"> Black  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" class="form-check-input" name="color" id="optionsRadios1" value="${3}"> Green &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" class="form-check-input" name="color" id="optionsRadios1" value="${4}"> Blue &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputConfirmPassword1">Quantity</label>
                                            <input name="quantity" type="number" class="form-control"  placeholder="ID">
                                        </div>
                                        <div class="form-group">
                                            <label for="formFileSm" class="form-label">IMAGE</label>
                                            <input class="form-control form-control-sm" id="formFileSm" name="image" type="file" />
                                        </div>

                                        <div class="form-check">

                                            <input type="radio" class="form-check-input" name="category" id="optionsRadios1" value="${1}"> Nike &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" class="form-check-input" name="category" id="optionsRadios1" value="${2}"> Adidas  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" class="form-check-input" name="category" id="optionsRadios1" value="${3}"> Vans &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" class="form-check-input" name="category" id="optionsRadios1" value="${4}"> Converse &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" class="form-check-input" name="category" id="optionsRadios1" value="${5}"> Gucci &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </div>
                                        <button type="submit" class="btn btn-primary mr-2">Add new</button>

                                        <button class="btn btn-dark"><a href="admin">Cancel</a></button>


                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- content-wrapper ends -->
                    <!-- partial:partials/_footer.html -->
                    <footer class="footer">
                        <div class="d-sm-flex justify-content-center justify-content-sm-between">
                            <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © bootstrapdash.com 2020</span>
                            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> Free <a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Bootstrap admin templates</a> from Bootstrapdash.com</span>
                        </div>
                    </footer>
                    <!-- partial -->
                </div>
                <!-- main-panel ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="assets/vendors/js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page -->
        <script src="assets/vendors/chart.js/Chart.min.js"></script>
        <script src="assets/vendors/progressbar.js/progressbar.min.js"></script>
        <script src="assets/vendors/jvectormap/jquery-jvectormap.min.js"></script>
        <script src="assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
        <script src="assets/vendors/owl-carousel-2/owl.carousel.min.js"></script>
        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="assets/js/off-canvas.js"></script>
        <script src="assets/js/hoverable-collapse.js"></script>
        <script src="assets/js/misc.js"></script>
        <script src="assets/js/settings.js"></script>
        <script src="assets/js/todolist.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page -->
        <script src="assets/js/dashboard.js"></script>
        <!-- End custom js for this page -->
    </body>
</html>
