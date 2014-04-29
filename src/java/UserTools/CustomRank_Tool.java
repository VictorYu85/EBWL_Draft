/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserTools;

import business.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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
public class CustomRank_Tool extends HttpServlet {

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

        DecimalFormat df = new DecimalFormat( "####0.00" );

        //load current player list(will be sorted, if previously sorted)        
        HttpSession session = request.getSession();
        Player[] playerList = (Player[]) session.getAttribute("playerSet");  
        String user = (String)session.getAttribute("user");
        
        /*************************************************************/
        String customExp;
        String customDSk;
        String customDef;
        String customAth;
        String customHt;
        
        if (request.getParameter("refresh") != null) {
            customExp = (String)session.getAttribute("customRank1");
            customDSk = (String)session.getAttribute("customRank2");
            customDef = (String)session.getAttribute("customRank3");
            customAth = (String)session.getAttribute("customRank4");
            customHt = (String)session.getAttribute("customRank5");
        } 
        else {
            customExp = (String)request.getParameter("Experience");
            customDSk = (String)request.getParameter("DiscSkills");
            customDef = (String)request.getParameter("Defense");
            customAth = (String)request.getParameter("Athleticism");
            customHt = (String)request.getParameter("Height");
        }
        
        Double wE = Double.parseDouble(customExp);
        Double wDS = Double.parseDouble(customDSk);
        Double wD = Double.parseDouble(customDef);
        Double wA = Double.parseDouble(customAth);
        Double wH = Double.parseDouble(customHt);              
        
        for (Player p : playerList) {
            Double customScore = (wE*p.getStatExperience() + wDS*p.getStatDiscSkills() +
                    wD*p.getStatDefense() + wA*p.getStatAthleticism() + 
                    wH*p.getStatHeightFeet() + wH*p.getStatHeightInches()/12);
            Double customScoreF = new Double(df.format(customScore)).doubleValue();
            p.setStatCustom(customScoreF);
        }
        
        /***********************************************/
       
        String option = "yes";
        //tracks sorts Settings
        request.setAttribute("passedCustom", option);

        //tracks custom Rank Settings
        session.setAttribute("customRank1", customExp);
        session.setAttribute("customRank2", customDSk);
        session.setAttribute("customRank3", customDef);
        session.setAttribute("customRank4", customAth);
        session.setAttribute("customRank5", customHt);

        session.setAttribute("playerSet", playerList);
        
        String gender = (String)request.getAttribute("gender");
        if (gender == null) {
            gender = (String)request.getParameter("gender");
        }
        request.setAttribute("gender", gender);
        
        String targetURL = "/SortPlayers";
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
