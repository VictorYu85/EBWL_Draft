/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserTools;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.*;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Vyu
 */
@WebServlet(name = "SortPlayers", urlPatterns = {"/SortPlayers"})
public class SortPlayers_Tool extends HttpServlet {

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
    private Player[] PlayerList;
    private int nElems;
    private String cat1, cat2, cat3, cat4, cat5, cat6;
    
    public void quickSort() {
        recQuickSort(0,nElems-1);
    }
    
    public void recQuickSort(int left, int right) {
        if(right-left <=0) {
            return;        
        }
        else
        {
            int pivot = PlayerList[right].getStatSortValue();
            int partition = partitionIt(left, right, pivot);
            
            recQuickSort(left, partition-1);
            recQuickSort(partition+1, right);
        }
    }
    
    public int partitionIt(int left, int right, int pivot) {
        int leftPtr = left-1;
        int rightPtr = right;
        while(true)
        {
            while(PlayerList[++leftPtr].getStatSortValue() > pivot)
                ;
            while(rightPtr > 0 && PlayerList[--rightPtr].getStatSortValue() < pivot)
                ;
            
            if(leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);
        return leftPtr;
    }
    
    public void swap(int index1, int index2) 
    {
        Player temp = PlayerList[index1];
        PlayerList[index1] = PlayerList[index2];
        PlayerList[index2] = temp;
    }
    
    public void calcSortValue () {
        for (int i = 0; i < PlayerList.length; i++) {                    
            int SortValue = PlayerList[i].getStatSortValue();
            PlayerList[i].setStatSortValue(catModValue(cat1,i,SortValue));
            SortValue = PlayerList[i].getStatSortValue();
            PlayerList[i].setStatSortValue(catModValue(cat2,i,SortValue));
            SortValue = PlayerList[i].getStatSortValue();
            PlayerList[i].setStatSortValue(catModValue(cat3,i,SortValue));
            SortValue = PlayerList[i].getStatSortValue();
            PlayerList[i].setStatSortValue(catModValue(cat4,i,SortValue));
            SortValue = PlayerList[i].getStatSortValue();
            PlayerList[i].setStatSortValue(catModValue(cat5,i,SortValue));
        }
    }
    
    public int catModValue (String category, int itr, int SortValue) {
        int temp = SortValue;
        if (category.equals("None")) {
            //do nothing
        }
        else if (category.equals("Exp")) {
            temp = temp * 10;
            temp += PlayerList[itr].getStatExperience();
        }
        else if (category.equals("Disc")) {
            temp = temp * 10;
            temp += PlayerList[itr].getStatDiscSkills();
        }
        else if (category.equals("Def")) {
            temp = temp * 10;
            temp += PlayerList[itr].getStatDefense();
        }
        else if (category.equals("Ath")) {
            temp = temp * 10;
            temp += PlayerList[itr].getStatAthleticism();
        }
        else if (category.equals("Total")) {
            temp = temp * 100;
            temp += PlayerList[itr].getStatTotal();
        }
        else if (category.equals("Height")) {
            temp = temp * 10;
            temp += PlayerList[itr].getStatHeightFeet();
            temp = temp * 100;
            temp += PlayerList[itr].getStatHeightInches();
        }
        else if (category.equals("Custom")) {
            temp = temp * 1000000;
            temp += PlayerList[itr].getStatCustom();
        }
        else if (category.equals("ID")) {
            temp = temp * 1000;
            temp += (999-PlayerList[itr].getPlayerId());
        }
        return temp;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //pulls the list that is being looked at
        HttpSession session = request.getSession();
        PlayerList = (Player[]) session.getAttribute("playerSet");
        nElems = PlayerList.length;
        String user = (String)session.getAttribute("user");
        

            String test = (String)request.getAttribute("passedCustom");
            if (test == null) {
                test = "no";
            }
            if (test.equals("yes")) {
                cat1 = (String)session.getAttribute("track1");
                cat2 = (String)session.getAttribute("track2");
                cat3 = (String)session.getAttribute("track3");
                cat4 = (String)session.getAttribute("track4");
                cat5 = (String)session.getAttribute("track5");
                cat6 = (String)session.getAttribute("track6");
            }
            else {                
                if (user.equals("drafter")) {
                    cat1 = (String)request.getParameter("cat1");
                    cat2 = (String)request.getParameter("cat2");
                    cat3 = (String)request.getParameter("cat3");
                    cat4 = (String)request.getParameter("cat4");
                    cat5 = (String)request.getParameter("cat5");
                }
                else {
                    cat1 = cat2 = cat3 = cat4 = cat5 =  "None";
                }
                cat6 = (String)request.getParameter("cat6");
            }

        
        //reset Sort values to 0
        for (int i = 0; i < nElems; i++) {
            PlayerList[i].setStatSortValue(0);
        }
        //no Sort selected, default to playerId
        boolean noSortSelected = ((cat1.equals("None")) && (cat2.equals("None")) && (cat3.equals("None")) && 
                (cat4.equals("None")) && (cat5.equals("None")));
        
        if(noSortSelected) {
            cat1 = "ID";
        }
                
        //calculate Sort Number
        calcSortValue();
        
        //when no option is selected 
        if (noSortSelected) {
            cat1 = "None";
        }
        
        //Sort
        quickSort();
        
        session.setAttribute("track1", cat1);
        session.setAttribute("track2", cat2);
        session.setAttribute("track3", cat3);
        session.setAttribute("track4", cat4);
        session.setAttribute("track5", cat5);
        session.setAttribute("track6", cat6);
        
        session.setAttribute("playerSet", PlayerList);
        
        String gender = (String)request.getAttribute("gender");
        if (gender == null) {
            gender = (String)request.getParameter("gender");
        }
        request.setAttribute("gender", gender);
        
        String targetURL = "/DrafterPage.jsp";
        if (user.equals("admin")) {
            targetURL = "/AdminPage.jsp";
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
