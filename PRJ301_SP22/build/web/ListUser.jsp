<%-- 
    Document   : ListUser
    Created on : Mar 10, 2022, 12:03:33 AM
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
                    window.location = "delete-user?id=" + id;
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


                        <div class="row ">
                            <div class="col-12 grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Manager User List</h4>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>
                                                            <div class="form-check form-check-muted m-0">
                                                                <label class="form-check-label">
                                                                    <input type="checkbox" class="form-check-input">
                                                                </label>
                                                            </div>
                                                        </th>
                                                        <th> NO. </th>
                                                        <th> User Name </th>
                                                        <th> Email </th>
                                                        <th> Password </th>
                                                        <th> Phone </th>
                                                        <th> Address </th>
                                                        <th> Role </th>
                                                        <th> Update </th>
                                                        <th> Delete </th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${requestScope.listaccount}" var="acc">
                                                    <tr>
                                                        <td>
                                                            <div class="form-check form-check-muted m-0">
                                                                <label class="form-check-label">
                                                                    <input type="checkbox" class="form-check-input">
                                                                </label>
                                                            </div>
                                                        </td>

                                                        <td> ${acc.id} </td>
                                                        <td>
                                                            <img src="images/person_1.jpg" alt="image" />
                                                            <span class="pl-2">${acc.name}</span>
                                                        </td>
                                                        <td> ${acc.address} </td>
                                                        <td> ${acc.password} </td>
                                                        <td> ${acc.phone} </td>
                                                        <td> ${acc.email} </td>
                                                        <c:if test="${acc.role}">
                                                            <td> Admin </td>
                                                        </c:if>
                                                        <c:if test="${!acc.role}">
                                                            <td> User </td>
                                                        </c:if>
                                                             <td>
                                                            <div class="badge badge-outline-danger"><a href="profile?id=${acc.id}">EDIT</a></div>
                                                        </td>
                                                        <c:if test="${!acc.role}">
                                                            <td>
                                                                <div class="badge badge-outline-danger"><a href="#" onclick="doDelete('${acc.id}')">Delete</td></div>
                                                            </td>
                                                        </c:if>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- content-wrapper ends -->
                <!-- partial:partials/_footer.html -->
                <footer class="footer">
                    <div class="d-sm-flex justify-content-center justify-content-sm-between">
                        <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright ?? bootstrapdash.com 2020</span>
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
