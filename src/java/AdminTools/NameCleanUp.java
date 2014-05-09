/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTools;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.*;
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Vyu
 */
public class NameCleanUp extends HttpServlet {

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
    public static String testInfo = "default";
    public static Player[] testSet;
    
    public static boolean isLetter (char c) {
        if (((c >= 65) && (c <= 90)) || ((c >= 97) && (c <= 122))) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static int isCorrectFormat (String name) {
        int itr = 0;
        int length = name.length();
        int errorCode = 0;
        // 1 does not begin with letter
        //first letter of name not capitalized
        // 2 non-first letter of name capitalized
        while (itr < length) {
            if (!isLetter(name.charAt(itr))) {
                errorCode = errorCode*10 + 1;   
                //does not begin with a letter
            }
            else if ((name.charAt(itr) >= 97) && (name.charAt(itr) <= 122)) {
                errorCode = errorCode*10 + 3;
            }
            itr++;
            
            while ((itr < length) && (name.charAt(itr) != ' '))  {
                
                if (isLetter(name.charAt(itr))) {
                    //if Uppercase
                    if ((name.charAt(itr) >= 65) && (name.charAt(itr) <= 90)) {
                        errorCode = errorCode*10 + 2;
                    }
                    else {
                        //nothing
                    }                    
                }
                else {
                    if (name.charAt(itr) == ' ') {
                        itr++;
                        break;                    
                    }
                    //nothing
                }
                itr++;
            }
        }
        return errorCode;
    }
    
    public static int NameCheck (String dbURL, String username, String password, int playerId) {
        Connection connection;
        ResultSet rs;
        Player[] playerSet = new Player[1];
        
        /*****************Pull First Last Name Data ***************************/
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            
            rs = statement.executeQuery("SELECT First_Name, Last_Name FROM player_details"
                    + " WHERE Player_Id=" + playerId);
            
            int itr = 0;
            while (rs.next()) {                
                playerSet[itr] = new Player();                
                playerSet[itr].setFirstName(rs.getString(1));
                playerSet[itr].setLastName(rs.getString(2));
            }
            
        } catch (SQLException e)
        {
            for(Throwable t : e)
                t.printStackTrace();
        }
        /*****************Report errors***************************/
        StringWriter sw = new StringWriter();
        
        for (Player p : playerSet) {
            int test1 = 0; 
            int test2 = 0;
            test1 = isCorrectFormat(p.getFirstName());
            test2 = isCorrectFormat(p.getLastName());
            testInfo = ("FirstName: " + test1 + " LastName: " + test2);
        }
        
        return 1;
    }
    
    public static String fixNameFormat (String name) {
        int itr = 0;
        int length = name.length();
        StringWriter sw = new StringWriter();
        char temp = ' ';
        
        while (itr < length) {
            //if lower case
            temp = name.charAt(itr);
            if ((name.charAt(itr) >= 97) && (name.charAt(itr) <= 122)) {                
                temp = Character.toUpperCase(temp);                
            }
            sw.write(temp);
            itr++;
            
            while (itr < length) {
                temp = name.charAt(itr);
                if (isLetter(name.charAt(itr))) {
                    //if Uppercase
                    if ((name.charAt(itr) >= 65) && (name.charAt(itr) <= 90)) {                        
                        temp = Character.toLowerCase(temp);;
                    }
                    else {
                        //nothing
                    }                    
                }
                else {
                    //if special character enter subroutine
                    if ((name.charAt(itr) == ' ') || (name.charAt(itr) == '-' )) {
                        //write character into buffer, inc
                        do {                        
                            sw.write(temp);
                            itr++;      
                            temp = name.charAt(itr);
                            //repeats until next character until end of name or next char not special
                            if ((itr == length) || 
                                    ((name.charAt(itr) != ' ') && (name.charAt(itr) != '-' ))) {
                                break;
                            }
                        } while (true);
                        break;
                    }
                    
                    //do nothing
                }
                sw.write(temp);
                itr++;
            }
        }
        return sw.toString();
    }
    
     public static int NameCleanId (String dbURL, String username, String password, int playerId) {
        Connection connection;
        ResultSet rs;
        Player[] playerSet = new Player[1];
        
        /*****************Pull First Last Name Data ***************************/
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            
            rs = statement.executeQuery("SELECT First_Name, Last_Name FROM player_details"
                    + " WHERE Player_Id=" + playerId);
            
            int itr = 0;
            while (rs.next()) {                
                playerSet[itr] = new Player();                
                playerSet[itr].setFirstName(rs.getString(1));
                playerSet[itr].setLastName(rs.getString(2));
            }
            
        } catch (SQLException e)
        {
            for(Throwable t : e)
                t.printStackTrace();
        }
        /*****************Make changes***************************/
        
        
        for (Player p : playerSet) {
            String test1 = ""; 
            String test2 = "";
            test1 = fixNameFormat(p.getFirstName());
            test2 = fixNameFormat(p.getLastName());
            testInfo = ("FirstName: " + test1 + " LastName: " + test2);
        }
        
        return 1;
    }
     
     public static int NameCleanAll (String dbURL, String username, String password) {
        Connection connection;
        ResultSet rs;
        int numPlayers = PlayerDataMethods.getNumPlayers(dbURL, username, password);
        Player[] playerSet = new Player[numPlayers];
        
        /*****************Pull First Last Name Data ***************************/
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            
            rs = statement.executeQuery("SELECT First_Name, Last_Name FROM player_details");
            
            int itr = 0;
            while (rs.next()) {                
                playerSet[itr] = new Player();                
                playerSet[itr].setFirstName(rs.getString(1));
                playerSet[itr].setLastName(rs.getString(2));
                itr++;
            }
            
            /*****************Make changes***************************/
            for (Player p : playerSet) {
                p.setFirstName(fixNameFormat(p.getFirstName()));
                p.setLastName(fixNameFormat(p.getLastName()));
            }
            testSet = playerSet;
            
        } catch (SQLException e)
        {
            for(Throwable t : e)
                t.printStackTrace();
        }

        return 1;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               String targetURL = "/ToolTestingPage.jsp";
        
        HttpSession session = request.getSession();
        Player[] PlayerList = (Player[]) session.getAttribute("playerSet");

        String dbURL = SelectionLists.databaseURL;
        String username = SelectionLists.user;
        String password = SelectionLists.password;
        //int testPlayerId = Integer.parseInt(request.getParameter("playerIdBox"));
        //resetting teams        
        //NameCleanId(dbURL, username, password, testPlayerId);
        NameCleanAll(dbURL, username, password);
        
        //request.setAttribute("DebugCode", testInfo);
        request.setAttribute("DebugCodeAll", testSet);
        
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
