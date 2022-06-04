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
@WebServlet(name = "AddServlet", urlPatterns = {"/add-shoes"})
public class AddShoesServlet extends HttpServlet {

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
            out.println("<title>Servlet AddServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");
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
        //Step 1: Push Category List to JSP
        CategoryDAO catedao = new CategoryDAO();
        List<Category> listcate = catedao.GetAllCategory();
        request.setAttribute("listcate", listcate);
        //Step 2: Push Color List to JSP
        ColorDAO colordao = new ColorDAO();
        List<Color> colorlist = colordao.GetAllColor();
        request.setAttribute("colorlist", colorlist);
        //Step 3: Forward to Add-Shoes
        request.getRequestDispatcher("add-shoes.jsp").forward(request, response);
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
        ShoesDAO daoshoes = new ShoesDAO();
        ColorDAO colordao = new ColorDAO();
        CategoryDAO catedao = new CategoryDAO();
        //Step 1: Get all infomation of shoes
        String name = request.getParameter("name");
        String price_raw = request.getParameter("price");
        String color_raw = request.getParameter("color");
        String quantity_raw = request.getParameter("quantity");
        String image = request.getParameter("image");
        String category_raw = request.getParameter("category");

        try {
            //Step 2: Parse String to number
            float price = Float.parseFloat(price_raw);
            int color = Integer.parseInt(color_raw);
            int category = Integer.parseInt(category_raw);
            int quantity = Integer.parseInt(quantity_raw);
            //Step 3: Generate a Shoes with infomation
            Category c = new Category(category, catedao.GetNameCategoryByID(category));
            Color cl = new Color(color, colordao.GetNameColorByID(color));
            Shoes s = new Shoes(1, name, price, cl, quantity, image, c);
            /* Test case
            System.out.println(s.getName());
            System.out.println(s.getPrice());
            System.out.println(color);
            System.out.println(s.getQuantity());
            System.out.println(s.getImage());
            System.out.println(category);
            System.out.println("======");
            System.out.println(color_raw);
            System.out.println(category_raw);
             */
            //Step 4: Add a new shoes
            daoshoes.AddShoes(s);
            //Step 5: Back to Admin
            response.sendRedirect("admin");
        } catch (NumberFormatException e) {
            System.out.println(e);
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
