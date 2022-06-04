/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartController;

import DAO.ShoesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Shoes;

/**
 *
 * @author admin
 */
@WebServlet(name = "BuyShoesServlet", urlPatterns = {"/buy"})
public class BuyShoesServlet extends HttpServlet {

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
            out.println("<title>Servlet BuyShoesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuyShoesServlet at " + request.getContextPath() + "</h1>");
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
        //Step 1: Get ID of Shoes user want to buy
        int id = Integer.parseInt(request.getParameter("id"));
        //Step 2: Create a session to store users order
        HttpSession session = request.getSession();
        Map<Integer,Cart> carts = (Map<Integer,Cart>)session.getAttribute("carts");
        //if cart null create a new cart
        if(carts == null){
            carts = new LinkedHashMap<>();
        }
        //Exist Shoes in cart
        if(carts.containsKey(id)){ 
            int oldQuantity = carts.get(id).getQuantity();
            carts.get(id).setQuantity(oldQuantity+1);
        }
        //Not exist shoes in cart
        else{       
            Shoes shoes = new ShoesDAO().GetShoesById(id);
            carts.put(id, new Cart(shoes, 1));
        }
        //Step 3: Push carts to JSP
        session.setAttribute("carts", carts);
        //Step 4: Back to shop-single
        response.sendRedirect("shop-single?id="+id);
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
