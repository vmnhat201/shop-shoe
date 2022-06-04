package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <title>Admin Dashboard</title>\n");
      out.write("        <!-- plugins:css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendors/mdi/css/materialdesignicons.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendors/css/vendor.bundle.base.css\">\n");
      out.write("        <!-- endinject -->\n");
      out.write("        <!-- Plugin css for this page -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendors/jvectormap/jquery-jvectormap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendors/flag-icon-css/css/flag-icon.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendors/owl-carousel-2/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/vendors/owl-carousel-2/owl.theme.default.min.css\">\n");
      out.write("        <!-- End plugin css for this page -->\n");
      out.write("        <!-- inject:css -->\n");
      out.write("        <!-- endinject -->\n");
      out.write("        <!-- Layout styles -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("        <!-- End layout styles -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"assets/images/favicon.png\" />\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function doDelete(id){\n");
      out.write("                if(confirm(\"Are u sure to delete product with id=\"+id+\" ?\")){\n");
      out.write("                    window.location=\"delete?id=\"+id;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-scroller\">\n");
      out.write("            <!-- partial:partials/_sidebar.html -->\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin/module/header-admin.jsp", out, false);
      out.write("\n");
      out.write("                <!-- partial -->\n");
      out.write("                <div class=\"main-panel\">\n");
      out.write("                    <div class=\"content-wrapper\">\n");
      out.write("\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-4 grid-margin\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <h5>Total Product</h5>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-8 col-sm-12 col-xl-8 my-auto\">\n");
      out.write("                                                <div class=\"d-flex d-sm-block d-md-flex align-items-center\">\n");
      out.write("                                                    <h2 class=\"mb-0\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalproduct}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("                                                 \n");
      out.write("                                                </div>\n");
      out.write("                                              \n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-4 col-sm-12 col-xl-4 text-center text-xl-right\">\n");
      out.write("                                                <i class=\"icon-lg mdi mdi-codepen text-primary ml-auto\"></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-sm-4 grid-margin\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <h5>Total User</h5>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-8 col-sm-12 col-xl-8 my-auto\">\n");
      out.write("                                                <div class=\"d-flex d-sm-block d-md-flex align-items-center\">\n");
      out.write("                                                    <h2 class=\"mb-0\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalaccount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("                                                    \n");
      out.write("                                                </div>\n");
      out.write("                                                \n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-4 col-sm-12 col-xl-4 text-center text-xl-right\">\n");
      out.write("                                                <i class=\"icon-lg mdi mdi-wallet-travel text-danger ml-auto\"></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-sm-4 grid-margin\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <h5>Profit</h5>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-8 col-sm-12 col-xl-8 my-auto\">\n");
      out.write("                                                <div class=\"d-flex d-sm-block d-md-flex align-items-center\">\n");
      out.write("                                                    <h2 class=\"mb-0\">$ ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalprofit}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("                                                    \n");
      out.write("                                                </div>\n");
      out.write("                                                \n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-4 col-sm-12 col-xl-4 text-center text-xl-right\">\n");
      out.write("                                                <i class=\"icon-lg mdi mdi-monitor text-success ml-auto\"></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                    \n");
      out.write("                        \n");
      out.write("                    <div class=\"col-5 col-md-5 col-sm-5\">\n");
      out.write("                        <!-- CATEGORY CHART -->\n");
      out.write("                        <div class=\"box f-height\">\n");
      out.write("                            <div class=\"box-body\">\n");
      out.write("                                <div id=\"chart\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- END CATEGORY CHART -->\n");
      out.write("                    </div>\n");
      out.write("                        <div class=\"col-7 col-md-7 col-sm-7\">\n");
      out.write("                    <!-- CUSTOMERS CHART -->\n");
      out.write("                    <div class=\"box f-height\">\n");
      out.write("                        <div class=\"box-header\">\n");
      out.write("                            Profit Week Daily\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"box-body\">\n");
      out.write("                            <div id=\"customer-chart\"></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- END CUSTOMERS CHART -->\n");
      out.write("                </div>\n");
      out.write("                    \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row \">\n");
      out.write("                            <div class=\"col-12 grid-margin\">\n");
      out.write("                                <div class=\"card\">\n");
      out.write("                                    <div class=\"card-body\">\n");
      out.write("                                        <h4 class=\"card-title\">Manager Shoes List</h4>\n");
      out.write("                                        <div class=\"table-responsive\">\n");
      out.write("                                            <table class=\"table\">\n");
      out.write("                                                <thead>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <th>\n");
      out.write("                                                            <div class=\"form-check form-check-muted m-0\">\n");
      out.write("                                                                <label class=\"form-check-label\">\n");
      out.write("                                                                    <input type=\"checkbox\" class=\"form-check-input\">\n");
      out.write("                                                                </label>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </th>\n");
      out.write("                                                        <th> Shoes NO. </th>\n");
      out.write("                                                        <th> Shoes Name </th>\n");
      out.write("                                                        <th> Price </th>\n");
      out.write("                                                        <th> Color </th>\n");
      out.write("                                                        <th> Category </th>\n");
      out.write("                                                        <th> Quantity </th>\n");
      out.write("                                                        <th> Update </th>\n");
      out.write("                                                        <th> Delete </th>\n");
      out.write("                                                        <th> View </th>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </thead>\n");
      out.write("                                                <tbody>\n");
      out.write("                                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- content-wrapper ends -->\n");
      out.write("                    <!-- partial:partials/_footer.html -->\n");
      out.write("                    <footer class=\"footer\">\n");
      out.write("                        <div class=\"d-sm-flex justify-content-center justify-content-sm-between\">\n");
      out.write("                            <span class=\"text-muted d-block text-center text-sm-left d-sm-inline-block\">Copyright © bootstrapdash.com 2020</span>\n");
      out.write("                            <span class=\"float-none float-sm-right d-block mt-1 mt-sm-0 text-center\"> Free <a href=\"https://www.bootstrapdash.com/bootstrap-admin-template/\" target=\"_blank\">Bootstrap admin templates</a> from Bootstrapdash.com</span>\n");
      out.write("                        </div>\n");
      out.write("                    </footer>\n");
      out.write("                    <!-- partial -->\n");
      out.write("                </div>\n");
      out.write("                <!-- main-panel ends -->\n");
      out.write("            </div>\n");
      out.write("            <!-- page-body-wrapper ends -->\n");
      out.write("        </div>\n");
      out.write("        <!-- container-scroller -->\n");
      out.write("        <!-- plugins:js -->\n");
      out.write("        <script src=\"assets/vendors/js/vendor.bundle.base.js\"></script>\n");
      out.write("        <!-- endinject -->\n");
      out.write("        <!-- Plugin js for this page -->\n");
      out.write("        <script src=\"assets/vendors/chart.js/Chart.min.js\"></script>\n");
      out.write("        <script src=\"assets/vendors/progressbar.js/progressbar.min.js\"></script>\n");
      out.write("        <script src=\"assets/vendors/jvectormap/jquery-jvectormap.min.js\"></script>\n");
      out.write("        <script src=\"assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js\"></script>\n");
      out.write("        <script src=\"assets/vendors/owl-carousel-2/owl.carousel.min.js\"></script>\n");
      out.write("        <!-- End plugin js for this page -->\n");
      out.write("        <!-- inject:js -->\n");
      out.write("        <script src=\"assets/js/off-canvas.js\"></script>\n");
      out.write("        <script src=\"assets/js/hoverable-collapse.js\"></script>\n");
      out.write("        <script src=\"assets/js/misc.js\"></script>\n");
      out.write("        <script src=\"assets/js/settings.js\"></script>\n");
      out.write("        <script src=\"assets/js/todolist.js\"></script>\n");
      out.write("        <!-- endinject -->\n");
      out.write("        <!-- Custom js for this page -->\n");
      out.write("        <script src=\"assets/js/dashboard.js\"></script>\n");
      out.write("        <!-- End custom js for this page -->\n");
      out.write("        <!--Custom js for Chart -->\n");
      out.write("         <script src=\"https://cdn.jsdelivr.net/npm/apexcharts\"></script>\n");
      out.write("         <script>\n");
      out.write("          let cate = []\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("          let tt = []\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        var options = {\n");
      out.write("          series: tt,\n");
      out.write("          chart: {\n");
      out.write("          height: 390,\n");
      out.write("          type: 'radialBar',\n");
      out.write("        },\n");
      out.write("        plotOptions: {\n");
      out.write("          radialBar: {\n");
      out.write("            offsetY: 0,\n");
      out.write("            startAngle: 0,\n");
      out.write("            endAngle: 270,\n");
      out.write("            hollow: {\n");
      out.write("              margin: 5,\n");
      out.write("              size: '30%',\n");
      out.write("              background: 'transparent',\n");
      out.write("              image: undefined,\n");
      out.write("            },\n");
      out.write("            dataLabels: {\n");
      out.write("              name: {\n");
      out.write("                show: false,\n");
      out.write("              },\n");
      out.write("              value: {\n");
      out.write("                show: false,\n");
      out.write("              }\n");
      out.write("            }\n");
      out.write("          }\n");
      out.write("        },\n");
      out.write("        colors: ['#1ab7ea', '#0084ff', '#39539E', '#0077B5'],\n");
      out.write("        labels: cate,\n");
      out.write("        legend: {\n");
      out.write("          show: true,\n");
      out.write("          floating: true,\n");
      out.write("          fontSize: '16px',\n");
      out.write("          position: 'left',\n");
      out.write("          offsetX: 160,\n");
      out.write("          offsetY: 15,\n");
      out.write("          labels: {\n");
      out.write("            useSeriesColors: true,\n");
      out.write("          },\n");
      out.write("          markers: {\n");
      out.write("            size: 0\n");
      out.write("          },\n");
      out.write("          formatter: function(seriesName, opts) {\n");
      out.write("            return seriesName + \":  \" + opts.w.globals.series[opts.seriesIndex]\n");
      out.write("          },\n");
      out.write("          itemMargin: {\n");
      out.write("            vertical: 3\n");
      out.write("          }\n");
      out.write("        },\n");
      out.write("        responsive: [{\n");
      out.write("          breakpoint: 480,\n");
      out.write("          options: {\n");
      out.write("            legend: {\n");
      out.write("                show: false\n");
      out.write("            }\n");
      out.write("          }\n");
      out.write("        }]\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        var chart = new ApexCharts(document.querySelector(\"#chart\"), options);\n");
      out.write("        chart.render();\n");
      out.write("         </script>\n");
      out.write("         <script>\n");
      out.write("             let profit = []\n");
      out.write("            let num = []\n");
      out.write("            let date = []\n");
      out.write("            ");
      if (_jspx_meth_c_forEach_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("             let customer_options = {\n");
      out.write("    series: [{\n");
      out.write("        name: \"Profit\",\n");
      out.write("        data: profit\n");
      out.write("    },{\n");
      out.write("        name: \"Shoes\",\n");
      out.write("        data: num\n");
      out.write("    }],\n");
      out.write("    colors: ['#6ab04c', '#2980b9'],\n");
      out.write("    chart: {\n");
      out.write("        height: 350,\n");
      out.write("        type: 'line',\n");
      out.write("    },\n");
      out.write("    dataLabels: {\n");
      out.write("        enabled: false\n");
      out.write("    },\n");
      out.write("    stroke: {\n");
      out.write("        curve: 'smooth'\n");
      out.write("    },\n");
      out.write("    xaxis: {\n");
      out.write("        categories: date\n");
      out.write("    },\n");
      out.write("    legend: {\n");
      out.write("        position: 'top'\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("\n");
      out.write("let customer_chart = new ApexCharts(document.querySelector(\"#customer-chart\"), customer_options)\n");
      out.write("customer_chart.render()\n");
      out.write("         </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.shoeslist}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("shoes");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                    <tr>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <div class=\"form-check form-check-muted m-0\">\n");
          out.write("                                                                <label class=\"form-check-label\">\n");
          out.write("                                                                    <input type=\"checkbox\" class=\"form-check-input\">\n");
          out.write("                                                                </label>\n");
          out.write("                                                            </div>\n");
          out.write("                                                        </td>\n");
          out.write("                                                        \n");
          out.write("                                                        <td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shoes.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <img src=\"images/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shoes.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"image\" />\n");
          out.write("                                                            <span class=\"pl-2\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shoes.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td> $");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shoes.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" </td>\n");
          out.write("                                                        <td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shoes.color.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" </td>\n");
          out.write("                                                        <td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shoes.category.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" </td>\n");
          out.write("                                                        <td> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shoes.quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <div class=\"badge badge-outline-warning\"><a href=\"update-shoes?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shoes.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Update</a></div>\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <div class=\"badge badge-outline-danger\"><a href=\"#\" onclick=\"doDelete('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shoes.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("')\">Delete</td></div>\n");
          out.write("                                                        </td>\n");
          out.write("                                                        <td>\n");
          out.write("                                                            <div class=\"badge badge-outline-success\"><a href=\"shop-single?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${shoes.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">View</a></div>\n");
          out.write("                                                        </td>\n");
          out.write("\n");
          out.write("                                                    </tr>\n");
          out.write("                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.catelist}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("c");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        cate.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\") \n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.quantitycate}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("z");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        tt.push(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${z}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(")\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent(null);
    _jspx_th_c_forEach_3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.profitweek}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_3.setVar("p");
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                profit.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\")\n");
          out.write("                num.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.num}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\")\n");
          out.write("                date.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\")\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }
}
