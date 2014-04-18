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
        String customExp = (String)request.getParameter("Experience");
        String customDSk = (String)request.getParameter("Disc Skills");
        String customDef = (String)request.getParameter("Defense");
        String customAth = (String)request.getParameter("Athleticism");
        String customHt = (String)request.getParameter("Height");
        
        Double weightExperience = Double.parseDouble(customExp);
        Double weightDiscSkills = Double.parseDouble(customDSk);
        Double weightDefense = Double.parseDouble(customDef);
        Double weightAthleticism = Double.parseDouble(customAth);
        Double weightHeight = Double.parseDouble(customHt);
        
        Double weightTotal = weightExperience + weightDiscSkills + weightDefense + weightAthleticism + weightHeight;
        
        //flat weighting
        Double wE = weightExperience;
        Double wDS = weightDiscSkills;
        Double wD = weightDefense;
        Double wA = weightAthleticism;
        Double wH = weightHeight;
        
        //percentage weighting
//        Double wE = weightExperience /weightTotal;
//        Double wDS = weightDiscSkills/weightTotal;
//        Double wD = weightDefense/weightTotal;
//        Double wA = weightAthleticism/weightTotal;
        
        for (Player p : playerList) {
            Double customScore = (wE*p.getStatExperience() + wDS*p.getStatDiscSkills() +
                    wD*p.getStatDefense() + wA*p.getStatAthleticism() + 
                    wH*p.getStatHeightFeet() + wH*p.getStatHeightInches()/12);
            Double customScoreF = new Double(df.format(customScore)).doubleValue();
            p.setStatCustom(customScoreF);
        }
        
        /***********************************************/
        //Saves Sort Settings
        String cat1 = (String)request.getParameter("cat1");
        String cat2 = (String)request.getParameter("cat2");
        String cat3 = (String)request.getParameter("cat3");
        String cat4 = (String)request.getParameter("cat4");
        String cat5 = (String)request.getParameter("cat5");
        String cat6 = (String)request.getParameter("cat6");
        
        //tracks custom Rank Settings
        session.setAttribute("customRank1", customExp);
        session.setAttribute("customRank2", customDSk);
        session.setAttribute("customRank3", customDef);
        session.setAttribute("customRank4", customAth);
        session.setAttribute("customRank5", customHt);
        //tracks sorts Settings
        request.setAttribute("track1", cat1);
        request.setAttribute("track2", cat2);
        request.setAttribute("track3", cat3);
        request.setAttribute("track4", cat4);
        request.setAttribute("track5", cat5);
        request.setAttribute("track6", cat6);
        
        session.setAttribute("playerSet", playerList);
        
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
