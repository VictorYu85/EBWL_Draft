/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTools;


import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;

import java.util.ArrayList;
import business.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.PreparedStatement;

/**
 *
 * @author Vyu
 */
public class ImportCSVData extends HttpServlet {

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
    public static ArrayList<Player> getPlayersFromCSV(String path) {
        ArrayList<Player> players = null;
        
        players = new ArrayList<Player>();
        File file = new File(path);
        try {
            BufferedReader in = 
                    new BufferedReader(
                    new FileReader(file));
            int Count = 0;
            String line = in.readLine();
            while(line != null) {
                line = line + "| ";
                String[] t = line.split("\\|");                    
                String firstName = t[0];
                String lastName = t[1];
                String team = t[2];
                String baggage = t[3];
                String rating = t[4];
                String missingGames = t[5];
                String heightFeet = t[6];
                String heightInches = t[7];
                String experience = t[8];
                String discSkills = t[9];
                String defense = t[10];
                String athleticism = t[11];
                String sum = t[12];
                String previousTeams = t[13];
                String additionalPlayerNotes = t[14];

                Player p = new Player();

                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setStatExperience(Integer.parseInt(experience));
                p.setStatDiscSkills(Integer.parseInt(discSkills));
                p.setStatDefense(Integer.parseInt(defense));
                p.setStatAthleticism(Integer.parseInt(athleticism));
                p.setStatHeightFeet(Integer.parseInt(heightFeet));
                p.setStatHeightInches(Integer.parseInt(heightInches));
                p.setDescAddPlayerNotes(additionalPlayerNotes);
                p.setDescPreviousTeams(previousTeams);
                p.setInfoBaggage(baggage);

                players.add(p);

                line = in.readLine();  
                System.out.println(Count++);
            }
            
            in.close();
            return players;            
        }
        catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void addPlayerToDB(Player p, Connection connection) {                     
        try {               
            String query;

                query = "INSERT INTO player_details " +
                    "(First_Name, Last_Name, Team, Stat_Experience, Stat_Disc_Skills," +
                    " Stat_Defense, Stat_Athleticism, Desc_Previous_Teams," +
                    " Desc_Add_Player_Notes, Info_Baggage, Stat_Height_Feet, Stat_Height_Inches)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            /*
            query = "INSERT into player_details VALUES" + "{?,?,?,?,?,?,?,?,?,?,?,?}";

            */
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, p.getFirstName());
            st.setString(2, p.getLastName());
            st.setString(3, "");
            st.setInt(4, p.getStatExperience());
            st.setInt(5, p.getStatDiscSkills());
            st.setInt(6, p.getStatDefense());
            st.setInt(7, p.getStatAthleticism());
            st.setString(8, p.getDescPreviousTeams());
            st.setString(9, p.getDescAddPlayerNotes());
            st.setString(10, p.getInfoBaggage());
            st.setDouble(11, p.getStatHeightFeet());
            st.setDouble(12, p.getStatHeightInches());

            System.out.println(st.executeUpdate());
        }

        catch(SQLException e)
        {
            for(Throwable t : e)                    
            t.printStackTrace();
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dbURL = SelectionLists.databaseURL;
        String username = SelectionLists.user;
        String password = SelectionLists.password;
        String targetURL = "/index.jsp";
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            ServletContext sc = this.getServletContext();
            String path = sc.getRealPath("/WEB-INF/EBWL Draft Data(140)v2.csv");

            ArrayList<Player> newPlayers = getPlayersFromCSV(path);
            for (Player p : newPlayers) {
                addPlayerToDB(p, connection);
            }
            connection.close();
        }
        catch(SQLException e)
        {
            for(Throwable t : e)
                t.printStackTrace();
        }       
        
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
