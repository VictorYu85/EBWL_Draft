/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserTools;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

import business.*;
import business.SelectionLists;
import java.io.*;


/**
 *
 * 
 * @author Vyu
 */
@WebServlet(name = "GetPlayerData", urlPatterns = {"/GetPlayerData"})
public class GetPlayerData_Tool extends HttpServlet {

    
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

        String dbURL = SelectionLists.databaseURL;
        String username = SelectionLists.user;
        String password = SelectionLists.password;
        
        /*****************************************************************/
        
        
        /*****************************************************************/
        //calls methods from PlayerDataMethods to determine size of playerSet
        //then gets player data from database
        
       
        int numPlayers = PlayerDataMethods.getNumPlayers(dbURL, username, password);
        Player[] playerSet = PlayerDataMethods.getPlayerData(dbURL, username, password, numPlayers);
       
        HttpSession session = request.getSession();
        session.setAttribute("numPlayers", numPlayers);
        session.setAttribute("playerSet", playerSet);
        
        //Determines whether data will be displayed to a drafter or to an admin
        String user = (String)session.getAttribute("user");                
        String targetURL;                
        
        targetURL = "/DrafterPage.jsp";        
        if (user.equals("admin")) {
            targetURL = "/AdminPage.jsp";
        }   
                       
        String refresh = (String)request.getParameter("refresh");
        if (refresh != null) {
            targetURL = "/CustomRank";
        }
        
        String gender = (String)request.getAttribute("gender");
        if (gender == null) {
            gender = (String)request.getParameter("gender");
        }
        request.setAttribute("gender", gender);
        request.setAttribute("testPlayers", numPlayers);
        
        //*****************test *****************/
        request.setAttribute("sqlError", "BBBBBBBBBBBBB");
        //*****************test ************  sqlErrorTest.testSql  *****/
        
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
