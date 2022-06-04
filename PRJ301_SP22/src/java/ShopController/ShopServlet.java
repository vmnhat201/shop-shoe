/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShopController;

import DAO.CategoryDAO;
import DAO.ColorDAO;
import DAO.ShoesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Color;
import model.Shoes;


/**
 *
 * @author admin
 */
@WebServlet(name = "ShopServlet", urlPatterns = {"/shop"})
public class ShopServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShopServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get all category
        CategoryDAO catedao = new CategoryDAO();
        List<Category> catelist = catedao.GetAllCategory();
        request.setAttribute("catelist", catelist);
        
        //Get all color
        ColorDAO colordao =  new ColorDAO();
        List<Color> colorlist = colordao.GetAllColor();
        request.setAttribute("colorlist", colorlist);
        
        //Get all shoes
        ShoesDAO shoesdao = new ShoesDAO();
        List<Shoes> shoeslist1 = shoesdao.GetAllShoes();
        int numPs, numperPage, numpage, start, end, page;
        numPs = shoeslist1.size();
        numperPage = 9;
        numpage = numPs / numperPage + (numPs % numperPage == 0 ? 0 : 1);
        String tpage = request.getParameter("page");
        try {
            page = Integer.parseInt(tpage);
        } catch (NumberFormatException e) {
            page = 1;
        }
        start = (page - 1) * numperPage;
        if (page * numperPage > numPs) {
            end = numPs;
        } else {
            end = page * numperPage;
        }
        List<Shoes> shoeslist = shoesdao.getListByPage(shoeslist1, start, end);
        request.setAttribute("num", numpage);
        request.setAttribute("page", page);
        request.setAttribute("shoeslist", shoeslist);
        
        //Tab 
        //Get ID of TAB from jsp
        String cid_raw = request.getParameter("cid");
        if (cid_raw != null) {
            int cid = Integer.parseInt(cid_raw);
            List<Shoes> listtab = shoesdao.Tab(cid);
            int total_category = catedao.TotalCategory();   
            numPs = listtab.size();
            numperPage = 9;
            numpage = numPs / numperPage + (numPs % numperPage == 0 ? 0 : 1);
            tpage = request.getParameter("page");
            try {
                page = Integer.parseInt(tpage);
            } catch (NumberFormatException e) {
                page = 1;
            }
            start = (page - 1) * numperPage;
            if (page * numperPage > numPs) {
                end = numPs;
            } else {
                end = page * numperPage;
            }
            shoeslist = shoesdao.getListByPage(listtab, start, end);
            request.setAttribute("cid", cid);
            request.setAttribute("shoeslist", shoeslist);
            request.setAttribute("num", numpage);
            request.setAttribute("page", page);
        }
        
        //Color tab
        //Get ID from jsp
        String color_raw = request.getParameter("color");
        if (color_raw != null) {
            int clid = Integer.parseInt(color_raw);
            List<Shoes> listcolor = shoesdao.GetShoesByColor(clid);
            int total_category = catedao.TotalCategory();   
            numPs = listcolor.size();
            numperPage = 9;
            numpage = numPs / numperPage + (numPs % numperPage == 0 ? 0 : 1);
            tpage = request.getParameter("page");
            try {
                page = Integer.parseInt(tpage);
            } catch (NumberFormatException e) {
                page = 1;
            }
            start = (page - 1) * numperPage;
            if (page * numperPage > numPs) {
                end = numPs;
            } else {
                end = page * numperPage;
            }
            shoeslist = shoesdao.getListByPage(listcolor, start, end);
            request.setAttribute("clid", clid);
            request.setAttribute("shoeslist", shoeslist);
            request.setAttribute("num", numpage);
            request.setAttribute("page", page);
        }
        // Sort
        String sort_raw = request.getParameter("sort");
        if(sort_raw!=null){
            int sort = Integer.parseInt(sort_raw);
            List<Shoes> listsort = new ArrayList<>();
            if(sort==1){
                listsort = shoesdao.PriceAsc();
            }else if(sort == 2){
                listsort = shoesdao.PriceDesc();
            }else if(sort == 3){
                listsort = shoesdao.NameAsc();
            }else if(sort == 4){
                listsort = shoesdao.NameDesc();
            }
            numPs = listsort.size();
            numperPage = 9;
            numpage = numPs / numperPage + (numPs % numperPage == 0 ? 0 : 1);
            tpage = request.getParameter("page");
            try {
                page = Integer.parseInt(tpage);
            } catch (NumberFormatException e) {
                page = 1;
            }
            start = (page - 1) * numperPage;
            if (page * numperPage > numPs) {
                end = numPs;
            } else {
                end = page * numperPage;
            }
            shoeslist = shoesdao.getListByPage(listsort, start, end);
            request.setAttribute("sort", sort);
            request.setAttribute("shoeslist", shoeslist);
            request.setAttribute("num", numpage);
            request.setAttribute("page", page);
        }
        //Search
        String search = request.getParameter("search");
        if(search!=null){
            List<Shoes> listsearch = shoesdao.SearchShoesByName(search);
            numPs = listsearch.size();
            numperPage = 9;
            numpage = numPs / numperPage + (numPs % numperPage == 0 ? 0 : 1);
            tpage = request.getParameter("page");
            try {
                page = Integer.parseInt(tpage);
            } catch (NumberFormatException e) {
                page = 1;
            }
            start = (page - 1) * numperPage;
            if (page * numperPage > numPs) {
                end = numPs;
            } else {
                end = page * numperPage;
            }
            shoeslist = shoesdao.getListByPage(listsearch, start, end);
            request.setAttribute("shoeslist", shoeslist);
            request.setAttribute("num", numpage);
            request.setAttribute("page", page);
        }
         request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
