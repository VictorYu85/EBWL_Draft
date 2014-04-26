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
public class SelectionLists {

    //Create the Selection Categories (Maybe move to its own servlet later?
//    public static String[] categoriesList = {"None", "Experience", "Disc Skills", "Defense",
//        "Athleticism", "Total", "Height", "Custom Weighting", "Player ID"};

     public static String[] categoriesList = {"None", "Exp", "Disc", "Def",
        "Ath", "Total", "Height", "Custom", "ID"};

    //Create Team List
    public static String[] teamList = {"Frantic Frisbees", "Disco Stus", 
        "Floppy Discs","Disc in a box","Undraft Player"};
    
    public static String HomeDatabaseURL ="jdbc:mysql://localhost:3306/ebwl_players";
    public static String DailyRazorURL ="jdbc:mysql://localhost:3306/ssveyuco_players1";

    public static String HomeUser = "root";
    public static String LiveUser = "ssveyuco_admin";
            
    public static String HomePassword = "sesame";
    public static String LivePassword = "sesame123";
    
//    public static String databaseURL = DailyRazorURL;
//    public static String user = LiveUser;
//    public static String password = LivePassword;
    
    public static String databaseURL = HomeDatabaseURL;
    public static String user = HomeUser;
    public static String password = HomePassword;
    
}
