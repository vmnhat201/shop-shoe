/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

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
import javax.servlet.http.HttpSession;
import model.Account;
import model.Category;
import model.Color;
import model.Shoes;

/**
 *
 * @author admin
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/update-shoes"})
public class UpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
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
        //Step 1: Get session admin and check.
        HttpSession session = request.getSession(true);
        Account acc = (Account) session.getAttribute("admin");
        if (acc == null){
            PrintWriter out = response.getWriter();
            out.println("Access denied");
        }else{
        //Step 1: Get ID of Shoes want to UPDATE
        String id_raw = request.getParameter("id");
        int id = Integer.parseInt(id_raw);
        ShoesDAO shoesdao = new ShoesDAO();
        //Step 2: Get Shoes by ID
        Shoes shoes = shoesdao.GetShoesById(id);
        List<Shoes> listshoes = new ArrayList<>();
        listshoes.add(shoes);
        CategoryDAO catedao = new CategoryDAO();
        List<Category> listcate = catedao.GetAllCategory();
        //Step 3: Push Shoes to JSP
        request.setAttribute("listcate", listcate);
        request.setAttribute("list", listshoes);
        //Step 4: Forward to update-shoes.jsp
        request.getRequestDispatcher("update-shoes.jsp").forward(request, response);
        }
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
        ColorDAO colordao = new ColorDAO();
        CategoryDAO catedao = new CategoryDAO();
        //Step 1: Get all infomation of Shoes from JSP
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String price_raw = request.getParameter("price");
        String color_raw = request.getParameter("color");
        String IMAGE = request.getParameter("image");
        String quantity_raw = request.getParameter("quantity");
        String category_raw = request.getParameter("category");
        
        //Step 2: Parse String to number
        try {
            int id = Integer.parseInt(id_raw);
            float price = Float.parseFloat(price_raw);
            int color_id = Integer.parseInt(color_raw);
            int quantity = Integer.parseInt(quantity_raw);
            int categoryid = Integer.parseInt(category_raw);
            //Step 3: Generatte a shoes with infomation
            Color colorr = new Color(color_id, colordao.GetNameColorByID(color_id));
            Category cate = new Category(categoryid, catedao.GetNameCategoryByID(categoryid));
            Shoes shoes = new Shoes(id, name, price, colorr, quantity, IMAGE, cate);
            ShoesDAO shoesdao = new ShoesDAO();
            //Step 4: Update Shoes
            shoesdao.update(shoes);
            //Step 5: Back to Admin
            response.sendRedirect("admin");
        } catch (NumberFormatException e) {
        }

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
