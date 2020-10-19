/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CourseModel;
import model.ProductModel;

/**
 *
 * @author Admin
 */
public class CourseController extends HttpServlet {

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
        String action = request.getParameter("action");

        if ("getData".equals(action)) {
            CourseModel cm = new CourseModel();
            RequestDispatcher rd = request.getRequestDispatcher("all-class.jsp");
            request.setAttribute("cList", cm.getData());
            rd.forward(request, response);
        }
        if ("add".equals(action)) {
            String id = request.getParameter("txtID");
            String name = request.getParameter("txtName");
            String categogy = request.getParameter("txtCategory");
            String topic = request.getParameter("txtTopic");
            String dob = request.getParameter("txtDob");
            String email = request.getParameter("txtEmail");
            String address = request.getParameter("txtAddress");
            String phone = request.getParameter("txtPhone");
            String image = request.getParameter("txtImage");

            ProductModel pm = new ProductModel();
            if (pm.addTeacher(id, name, categogy, dob, email, address, phone, image)) {
                RequestDispatcher rd = request.getRequestDispatcher("all-teacher.jsp");
                request.setAttribute("pList", pm.getData());
                rd.forward(request, response);
            } else {
                response.sendRedirect("Error.jsp");
            }
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
        processRequest(request, response);
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
