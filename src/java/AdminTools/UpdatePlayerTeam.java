/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTools;

import business.Player;
import business.SelectionLists;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.*;

/**
 *
 * @author Vyu
 */
public class UpdatePlayerTeam extends HttpServlet {

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
    
    public Player[] updateTeam(String dbURL, String username, String password,
            String teamName, String playerId, Player[] playerList) {
        
        //if option is to undraft player, fill with empty string
        if (teamName.equals("Undraft Player")) {
            teamName = "";
        }
        
        //determines if player exists in system and updates session playerList
        boolean idExists = false;
        for (int i = 0; i < playerList.length; i++) {
            if (playerList[i].getPlayerId() == Integer.parseInt(playerId)) {
                //updates temp list separately
                playerList[i].setTeam(teamName);
                idExists = true;
            }
        }        
        
        //update team name in SQL database
        if(idExists) {
            //Connection Code
            //Database loading code
            Connection connection;
            ResultSet playersRS;            
             
            try {
                connection = DriverManager.getConnection(dbURL, username, password);
                //Sql Statement Code
                PreparedStatement st = connection.prepareStatement(
                        "UPDATE player_details SET " +
                        "Team = ? "  +
                        "WHERE Player_Id = ? ");
       
                st.setString(1, teamName);
                st.setString(2, playerId);                 
                st.executeUpdate();
                st.close();                
                connection.close();
            }
            catch(SQLException e)
            {
                for(Throwable t : e)
                    t.printStackTrace();
            }
        }
        return playerList;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dbURL = SelectionLists.databaseURL;
        String username = SelectionLists.user;
        String password = SelectionLists.password;
                
        /*****************************************************************/
        //load current player list(will be sorted, if previously sorted)        
        HttpSession session = request.getSession();
        Player[] playerList = (Player[]) session.getAttribute("playerSet");        
        String teamName = request.getParameter("team");
        String playerId = request.getParameter("playerIdBox");
        
        //updates team in SQL database and playerList Session object separately
        playerList = updateTeam(dbURL, username, password, teamName, playerId, playerList);        
        
        /*****************************************************************/
        
        session.setAttribute("playerSet", playerList);
        request.setAttribute("gender", "All");
        
        String targetURL = "/AdminPage.jsp";
        
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
