/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.AdminDAO;
import DAO.CategoryDAO;
import DAO.OrderDAO;
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
import model.Profit;
import model.Shoes;

/**
 *
 * @author admin
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath() + "</h1>");
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
        if (acc == null) {
            PrintWriter out = response.getWriter();
            out.println("Access denied");
        } else {
            //Step 2: Get all shoes and put it to admin dashboard.
            ShoesDAO shoesdao = new ShoesDAO();
            List<Shoes> shoeslist = shoesdao.GetAllShoes();
            request.setAttribute("shoeslist", shoeslist);
            //1. Push list cate gory to admin dashboard
            CategoryDAO catedao = new CategoryDAO();
            List<Category> catelist = catedao.GetAllCategory();
            request.setAttribute("catelist", catelist);
            //2. Total of each category
            List<Integer> quantitycate = new ArrayList<>();
            for (int i = 1; i <= catelist.size(); i++) {
                int n = catedao.QuantityCategory(i);
                quantitycate.add(n);
            }
            request.setAttribute("quantitycate", quantitycate);
            //3. Total Product
            int totalproduct = shoesdao.TotalShoes();
            request.setAttribute("totalproduct", totalproduct);
            //4. Total User
            AdminDAO admindao = new AdminDAO();
            int totalaccount = admindao.TotalAccount();
            request.setAttribute("totalaccount", totalaccount);
            //5. Total Order Profit
            OrderDAO orderdao = new OrderDAO();
            int totalprofit = orderdao.TotalOrderProfit();
            request.setAttribute("totalprofit", totalprofit);
            //6. Profit Daily Week
            
            List<Profit> profitweek = orderdao.GetProfitWeek();
            request.setAttribute("profitweek", profitweek);
            //Step 3: Forward to admin.jsp
            request.getRequestDispatcher("admin.jsp").forward(request, response);
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
