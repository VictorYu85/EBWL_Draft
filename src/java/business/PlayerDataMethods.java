/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

/**
 *
 * Victor Yu CIS36A
 * {date}
 */

import java.sql.*;
import business.Player;
import java.io.*;

public class PlayerDataMethods {
    public static int getNumPlayers(String dbURL, String username, String password) {

        Connection connection; 
        ResultSet playersRS1;
        int numItems = 242;
        
        StringWriter errors = new StringWriter();
        
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            playersRS1 = statement.executeQuery("SELECT COUNT(*) FROM player_details");
            playersRS1.next();

            numItems = playersRS1.getInt(1);                    
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            for(Throwable t : e){
                t.printStackTrace();
                e.printStackTrace(new PrintWriter(errors));
                SelectionLists.sqlError = errors.toString();
            }
        }              
        
        return numItems;
    }
    /*
    public static int getNumPlayers(String dbURL, String username, String password) {

        Connection connection; 
        ResultSet playersRS;
        int numItems = 0;
        
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();
            playersRS = statement.executeQuery("SELECT * FROM player_details");
            
            while (playersRS.next()) {
                
            }
            numItems = playersRS.getRow();            
            statement.close();
            connection.close();
        
        }
        catch(SQLException e)
        {
            for(Throwable t : e)
                t.printStackTrace();
        }              
        
        return numItems;
    }
    */
    
    public static Player[] getPlayerData(String dbURL, String username, String password, int numPlayers) {
        Connection connection; 
        ResultSet playersRS;
        Player[] playerSet = new Player[numPlayers];
        
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            Statement statement = connection.createStatement();            
            
            playersRS = statement.executeQuery("SELECT * FROM player_details");
            
            int itr = 0;
            while (playersRS.next()) {                
                playerSet[itr] = new Player();
                playerSet[itr].setPlayerId(playersRS.getInt(1));
                playerSet[itr].setFirstName(playersRS.getString(2));
                playerSet[itr].setLastName(playersRS.getString(3));
                playerSet[itr].setTeam(playersRS.getString(4));
                playerSet[itr].setStatExperience(playersRS.getInt(5));
                playerSet[itr].setStatDiscSkills(playersRS.getInt(6));
                playerSet[itr].setStatDefense(playersRS.getInt(7));
                playerSet[itr].setStatAthleticism(playersRS.getInt(8));                
                playerSet[itr].setDescPreviousTeams(playersRS.getString(9));
                playerSet[itr].setDescAddPlayerNotes(playersRS.getString(10));
                playerSet[itr].setInfoBaggage(playersRS.getString(11));
                playerSet[itr].setStatHeightFeet(playersRS.getInt(12));
                playerSet[itr].setStatHeightInches(playersRS.getInt(13));
                playerSet[itr].setGender(playersRS.getString(14));
                //playerSet[itr].setBaggageId have not implemented this yet
                //field calculations *dont need because I can just display height using feet and inches
//                Double height;
//                if(playerSet[itr].getStatHeightInches() >= 10) {
//                    height = playerSet[itr].getStatHeightFeet()+
//                             ((Double)playerSet[itr].getStatHeightInches())/100;
//                } 
//                else {
//                    height = playerSet[itr].getStatHeightFeet()+
//                             ((Double)playerSet[itr].getStatHeightInches())/10;
//                }
//                playerSet[itr].setStatHeight(height);
                                                
                playerSet[itr].setStatTotal(
                        playerSet[itr].getStatExperience()+
                        playerSet[itr].getStatDiscSkills()+
                        playerSet[itr].getStatDefense()+
                        playerSet[itr].getStatAthleticism()
                        );
                
                playerSet[itr].setStatSortValue(0);
                //playerSet[itr].setStatSortValue((int)playerSet[itr].getStatTotal());
                itr++;
            }
            statement.close();
            connection.close();
        }
        catch(SQLException e)
        {
            for(Throwable t : e)
                t.printStackTrace();
        }
                
        return playerSet; 
    }
    
    
}
