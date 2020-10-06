/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dataprocess;

/**
 *
 * @author Teaser
 */
public class Bookcontroller extends HttpServlet {

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
       String action=request.getParameter("ac");
       if("add".equals(action))
       {
           String id=request.getParameter("txtID");
           String Name=request.getParameter("txtName");
           String auth=request.getParameter("slAuthor");
           String temp=request.getParameter("txtPrice");
           float price=Float.parseFloat(temp);
           String des=request.getParameter("taDes");
           dataprocess dt=new dataprocess();
           if(dt.addBook(id, Name, auth, price, des))
           {
               ArrayList<book> list=dt.getData();
               request.setAttribute("blist", list);
               RequestDispatcher rd=request.getRequestDispatcher("ViewbookEL.jsp");
               rd.forward(request, response);
            }
           else
           {
               response.sendRedirect("Error.jsp?code=1");
           }
       }
       if("view".equals(action))
       {
           dataprocess dt=new dataprocess();
           ArrayList<book> list=dt.getData();
           request.setAttribute("blist", list);
           RequestDispatcher rd=request.getRequestDispatcher("ViewbookEL.jsp");
           rd.forward(request, response);
       }
       if("del".equals(action))
       {
           String id=request.getParameter("id");
           dataprocess dt=new dataprocess();
           if(dt.delBook(id))
           {
               ArrayList<book> list=dt.getData();
               request.setAttribute("blist", list);
               RequestDispatcher rd=request.getRequestDispatcher("ViewbookEL.jsp");
               rd.forward(request, response);
            }
           else
           {
               response.sendRedirect("Error.jsp?code=1");
           }
       }
       if("edit".equals(action))
       {
           String id=request.getParameter("id");
           dataprocess dt=new dataprocess();
           book b=dt.getByID(id);
           request.setAttribute("bDetail", b);
           RequestDispatcher rd=request.getRequestDispatcher("EditbookEL.jsp");
           rd.forward(request, response);
       }
       if("update".equals(action))
       {
           String id=request.getParameter("txtID");
           String Name=request.getParameter("txtName");
           String auth=request.getParameter("slAuthor");
           String temp=request.getParameter("txtPrice");
           float price=Float.parseFloat(temp);
           String des=request.getParameter("taDes");
           dataprocess dt=new dataprocess();
           if(dt.updateBook(id, Name, auth, price, des))
           {
               ArrayList<book> list=dt.getData();
               request.setAttribute("blist", list);
               RequestDispatcher rd=request.getRequestDispatcher("ViewbookEL.jsp");
               rd.forward(request, response);
            }
           else
           {
               response.sendRedirect("Error.jsp?code=1");
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
