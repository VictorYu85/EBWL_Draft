/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Vyu
 */
public class TeamColor extends TagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    
    private String teamName;
        
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }    
        
    @Override
    public int doStartTag() throws JspException {
        
        try {
            JspWriter out = pageContext.getOut();
            
            if (teamName.equals("")) {
                out.print("<td>" + teamName + "</td>");
            }
            else if (teamName.equals("Frantic Frisbees")) {
                out.print("<td bgcolor=\"#FFA07A\">" + teamName + "</td>");
            }
            else if (teamName.equals("Disco Stus")) {
                out.print("<td bgcolor=\"#AFEEEE\">" + teamName + "</td>");
            }
            else if (teamName.equals("Floppy Discs")) {
                out.print("<td bgcolor=\"#FFEBCD\">" + teamName + "</td>");
            }
            else if (teamName.equals("Disc in a box")) {
                out.print("<td bgcolor=\"C0C0C0\">" + teamName + "</td>");
            }
            else {
                out.print("<td bgcolor=\"C0C0C0\">" + teamName + "</td>");
            }
            
            //</td>
            
            
            

        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }
}
