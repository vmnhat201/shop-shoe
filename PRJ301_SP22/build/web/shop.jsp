<%-- 
    Document   : shop
    Created on : Mar 7, 2022, 9:52:08 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">


        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/style.css">
        
    </head>
    <body>

        <div class="site-wrap">
            <jsp:include page="module/header.jsp" flush="true"/> 

            <div class="bg-light py-3">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 mb-0"><a href="index">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Shop</strong></div>
                    </div>
                </div>
            </div>

            <div class="site-section">
                <div class="container">

                    <div class="row mb-5">
                        <div class="col-md-9 order-2">

                            <div class="row">
                                <div class="col-md-12 mb-5">
                                    <div class="float-md-left mb-4"><h2 class="text-black h5">Shop All</h2></div>
                                    <div class="d-flex">
                                        <div class="dropdown mr-1 ml-md-auto">
                                            
                                        </div>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" id="dropdownMenuReference" data-toggle="dropdown">Reference</button>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuReference">
                                                <a class="dropdown-item" href="#">Relevance</a>
                                                <div class="dropdown-divider"></div>
                                                <a class="dropdown-item" href="shop?sort=${1}">Price, low to high</a>
                                                <a class="dropdown-item" href="shop?sort=${2}">Price, high to low</a>
                                                <div class="dropdown-divider"></div>
                                                
                                                <a class="dropdown-item" href="shop?sort=${3}">Name, A to Z</a>
                                                <a class="dropdown-item" href="shop?sort=${4}">Name, Z to A</a>
                                                                                     </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-5">
                                <c:forEach items="${requestScope.shoeslist}" var="shoes">
                                    <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
                                        <div class="block-4 text-center border">
                                            <figure class="block-4-image">
                                                <a href="shop-single?id=${shoes.id}"><img src="images/${shoes.image}" alt="Image placeholder" class="img-fluid"></a>
                                            </figure>
                                            <div class="block-4-text p-4">
                                                <h3><a href="shop-single?id=${shoes.id}">${shoes.name}</a></h3>
                                                <p class="mb-0">Avaiable now</p>
                                                <p class="text-primary font-weight-bold">$${shoes.price}</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>


                            </div>
                            <div class="row" data-aos="fade-up">
                                <div class="col-md-12 text-center">
                                    <div class="site-block-27">
                                        <ul>
                                              <c:if test="${page>1}">
                                            <li><a href="shop?page=${page-1}">&lt;</a></li>
                                              </c:if>
                                              <c:forEach begin="1" end="${requestScope.num}" var="n">
                                              <li class="${n==page?"active":""}" ><span><a href="shop?page=${n}">${n}</a></span></li>
                                              </c:forEach>
                                           
                                            <c:if test="${page<num}">
                                            <li><a href="shop?page=${page+1}">&gt;</a></li>
                                              </c:if>
                                            
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-3 order-1 mb-5 mb-md-0">
                            <div class="border p-4 rounded mb-4">
                                <h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
                                <ul class="list-unstyled mb-0">
                                    <c:forEach items="${requestScope.catelist}" var="cate">
                                        <li class="mb-1"><a href="shop?cid=${cate.id}" class="d-flex"><span>${cate.name}</span> <span class="text-black ml-auto">(2,223)</span></a></li>
                                                </c:forEach>
                                </ul>
                            </div>

                            <div class="border p-4 rounded mb-4">
                                <div class="mb-4">
                                    <h3 class="mb-3 h6 text-uppercase text-black d-block">Filter by Price</h3>
                                    <div id="slider-range" class="border-primary"></div>
                                    <input type="text" name="text" id="amount" class="form-control border-0 pl-0 bg-white" disabled="" />
                                </div>

                                <div class="mb-4">
                                    <h3 class="mb-3 h6 text-uppercase text-black d-block">Size</h3>
                                    <c:forEach items="${requestScope.sizelist}" var="sizelist">
                                        <label for="s_sm" class="d-flex">
                                            <input type="checkbox" id="s_sm" class="mr-2 mt-1"> <span class="text-black">${sizelist.name}</span>
                                        </label>
                                    </c:forEach>
                                </div>

                                <div class="mb-4">
                                    <h3 class="mb-3 h6 text-uppercase text-black d-block">Color</h3>
                                    <c:forEach items="${requestScope.colorlist}" var="cl">
                                        <a href="shop?color=${cl.id}" class="d-flex color-item align-items-center" >
                                        <span class="bg-danger color d-inline-block rounded-circle mr-2"></span> <span class="text-black">-> ${cl.name}</span>
                                    </a>
                                    </c:forEach>
                                    
                                   
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="site-section site-blocks-2">
                                <div class="row justify-content-center text-center mb-5">
                                    <div class="col-md-7 site-section-heading pt-4">
                                        <h2>Categories</h2>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6 col-md-6 col-lg-4 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="">
                                        <a class="block-2-item" href="#">
                                            <figure class="image">
                                                <img src="images/women.jpg" alt="" class="img-fluid">
                                            </figure>
                                            <div class="text">
                                                <span class="text-uppercase">Collections</span>
                                                <h3>White</h3>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="100">
                                        <a class="block-2-item" href="#">
                                            <figure class="image">
                                                <img src="images/children.jpg" alt="" class="img-fluid">
                                            </figure>
                                            <div class="text">
                                                <span class="text-uppercase">Collections</span>
                                                <h3>Black</h3>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="200">
                                        <a class="block-2-item" href="#">
                                            <figure class="image">
                                                <img src="images/men.jpg" alt="" class="img-fluid">
                                            </figure>
                                            <div class="text">
                                                <span class="text-uppercase">Collections</span>
                                                <h3>Others</h3>
                                            </div>
                                        </a>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <footer class="site-footer border-top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 mb-5 mb-lg-0">
                            <div class="row">
                                <div class="col-md-12">
                                    <h3 class="footer-heading mb-4">Navigations</h3>
                                </div>
                                <div class="col-md-6 col-lg-4">
                                    <ul class="list-unstyled">
                                        <li><a href="#">Sell online</a></li>
                                        <li><a href="#">Features</a></li>
                                        <li><a href="#">Shopping cart</a></li>
                                        <li><a href="#">Store builder</a></li>
                                    </ul>
                                </div>
                                <div class="col-md-6 col-lg-4">
                                    <ul class="list-unstyled">
                                        <li><a href="#">Mobile commerce</a></li>
                                        <li><a href="#">Dropshipping</a></li>
                                        <li><a href="#">Website development</a></li>
                                    </ul>
                                </div>
                                <div class="col-md-6 col-lg-4">
                                    <ul class="list-unstyled">
                                        <li><a href="#">Point of sale</a></li>
                                        <li><a href="#">Hardware</a></li>
                                        <li><a href="#">Software</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">
                            <h3 class="footer-heading mb-4">Promo</h3>
                            <a href="#" class="block-6">
                                <img src="images/hero_1.jpg" alt="Image placeholder" class="img-fluid rounded mb-4">
                                <h3 class="font-weight-light  mb-0">Finding Your Perfect Shoes</h3>
                                <p>Promo from  nuary 15 &mdash; 25, 2019</p>
                            </a>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="block-5 mb-5">
                                <h3 class="footer-heading mb-4">Contact Info</h3>
                                <ul class="list-unstyled">
                                    <li class="address">203 Fake St. Mountain View, San Francisco, California, USA</li>
                                    <li class="phone"><a href="tel://23923929210">+2 392 3929 210</a></li>
                                    <li class="email">emailaddress@domain.com</li>
                                </ul>
                            </div>

                            <div class="block-7">
                                <form action="#" method="post">
                                    <label for="email_subscribe" class="footer-heading">Subscribe</label>
                                    <div class="form-group">
                                        <input type="text" class="form-control py-4" id="email_subscribe" placeholder="Email">
                                        <input type="submit" class="btn btn-sm btn-primary" value="Send">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="row pt-5 mt-5 text-center">
                        <div class="col-md-12">
                            <p>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" class="text-primary">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </p>
                        </div>

                    </div>
                </div>
            </footer>
        </div>

        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>
