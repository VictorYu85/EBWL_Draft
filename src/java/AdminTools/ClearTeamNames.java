/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTools;

import business.Player;
import business.PlayerDataMethods;
import business.SelectionLists;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vyu
 */
@WebServlet(name = "clearTeams", urlPatterns = {"/clearTeams"})
public class ClearTeamNames extends HttpServlet {

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
    public static Player[] clearTeams(String dbURL, String username, String password, int listSize, Player[] playerList) {                
        for ( int i = 0; i < listSize; i++) {
            playerList[i].setTeam("");
        }
        
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            //Sql Statement Code
            String query;
            query = "UPDATE player_details SET " +
                    "Team = '' ";                        
            PreparedStatement statement = connection.prepareStatement(query);                
            System.out.println(statement.executeUpdate());
            statement.close();
            connection.close();          
        }
        catch(SQLException e)
        {
            for(Throwable t : e)
                t.printStackTrace();
        }
        return playerList;        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String targetURL = "/AdminPage.jsp";
        HttpSession session = request.getSession();
        Player[] PlayerList = (Player[]) session.getAttribute("playerSet");

        String dbURL = SelectionLists.databaseURL;
        String username = SelectionLists.user;
        String password = SelectionLists.password;
        
        //resetting teams        
        PlayerList = clearTeams(dbURL, username, password, PlayerList.length, PlayerList);
        
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
