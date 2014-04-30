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

import java.io.Serializable;

public class sqlErrorTest implements Serializable {
    public static String testSql = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    
    public sqlErrorTest() {

    }
    public void setTestSql(String testSql) {
        this.testSql = testSql;
    }
    
    public String getTestSql() {
        return testSql;
    }
}
