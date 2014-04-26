/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import java.io.Serializable;

/**
 *
 * Victor Yu CIS36A
 * {date}
 */
public class Player implements Serializable{
    private int playerId;
    private String firstName;
    private String lastName;
    private String team;
    private int statExperience;
    private int statDiscSkills;
    private int statDefense;
    private int statAthleticism;
    private double statTotal;
    private double statCustom;
    private double statHeight;
    private int statHeightFeet;
    private int statHeightInches;
    private String descPreviousTeams;
    private String descAddPlayerNotes;
    private String infoBaggage;
    private String gender;
    private int baggageId;
    //maybe change to double later?
    private int statSortValue;
    
    public Player() {
        playerId = 0;
        firstName = "";
        lastName = "";
        team = "";
        statExperience = 0;
        statDiscSkills = 0;
        statDefense = 0;
        statAthleticism = 0;
        statTotal = 0;
        statCustom = 0;                
        statHeight = 0;
        statHeightFeet = 0;
        statHeightInches = 0;
        descPreviousTeams = "";
        descAddPlayerNotes = "";
        infoBaggage = "";
        statSortValue = 0;
        gender = "";
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    
    public int getPlayerId() {
        return playerId;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setStatExperience(int statExperience) {
        this.statExperience = statExperience;
    }
    
    public int getStatExperience() {
        return statExperience;
    }
    
    public void setStatDiscSkills(int statDiscSkills) {
        this.statDiscSkills = statDiscSkills;
    }
    
    public int getStatDiscSkills() {
        return statDiscSkills;
    }
    
    public void setStatDefense(int statDefense) {
        this.statDefense = statDefense;
    }
    
    public int getStatDefense() {
        return statDefense;
    }
    
    public void setStatAthleticism(int statAthleticism) {
        this.statAthleticism = statAthleticism;
    }
    
    public int getStatAthleticism() {
        return statAthleticism;
    }
    
    public void setStatTotal(double statTotal) {
        this.statTotal = statTotal;
    }
    
    public double getStatTotal() {
        return statTotal;
    }
    
    public void setStatCustom(double statCustom) {
        this.statCustom = statCustom;
    }
    
    public double getStatCustom() {
        return statCustom;
    }
    
    public void setStatHeight(double statHeight) {
        this.statHeight = statHeight;
    }
    
    public double getStatHeight() {
        return statHeight;
    }
    
    public void setStatHeightFeet(int statHeightFeet) {
        this.statHeightFeet = statHeightFeet;
    }
    
    public int getStatHeightFeet() {
        return statHeightFeet;
    }
    
    public void setStatHeightInches(int statHeightInches) {
        this.statHeightInches = statHeightInches;
    }
    
    public int getStatHeightInches() {
        return statHeightInches;
    }
    
    public void setDescPreviousTeams(String descPreviousTeams) {
        this.descPreviousTeams = descPreviousTeams;
    }
    
    public String getDescPreviousTeams() {
        return descPreviousTeams;
    }
    
    public void setDescAddPlayerNotes(String descAddPlayerNotes) {
        this.descAddPlayerNotes = descAddPlayerNotes;
    }
    
    public String getDescAddPlayerNotes() {
        return descAddPlayerNotes;
    }
    
    public void setInfoBaggage(String infoBaggage) {
        this.infoBaggage = infoBaggage;
    }
    
    public String getInfoBaggage() {
        return infoBaggage;
    }
    
    public void setStatSortValue(int statSortValue) {
        this.statSortValue = statSortValue;
    }
            
    public int getStatSortValue() {
        return statSortValue;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setBaggageId(int baggageId) {
        this.baggageId = baggageId;
    }
            
    public int getBaggageId() {
        return baggageId;
    }
}
