/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vyu
 */
public class SetUser extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession();
            String user = (String)request.getParameter("user");
            session.setAttribute("user", user);
            session.setAttribute("selectCat", SelectionLists.categoriesList);
            session.setAttribute("teamList", SelectionLists.teamList);
            
                session.setAttribute("track1", "None");
                session.setAttribute("track2", "None");
                session.setAttribute("track3", "None");
                session.setAttribute("track4", "None");
                session.setAttribute("track5", "None");
                session.setAttribute("track6", "off");
                
                session.setAttribute("customRank1", "1");
                session.setAttribute("customRank2", "1");
                session.setAttribute("customRank3", "1");
                session.setAttribute("customRank4", "1");
                session.setAttribute("customRank5", "0");
                
                request.setAttribute("gender", "All");
            String targetURL = "/GetPlayerData";            
        
            RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(targetURL);
                dispatcher.forward(request, response); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
