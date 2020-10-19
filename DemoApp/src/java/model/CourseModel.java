/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.ConectionFactory.getConnection;

/**
 *
 * @author Admin
 */
public class CourseModel {
    public ArrayList<Course> getData() {
        ArrayList<Course> list = new ArrayList<Course>();
        String sql = "SELECT * FROM tblCourse";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Course c = new Course();
                c.setIdCourse(rs.getString(1));
                c.setNameCourse(rs.getString(2));
                c.setTimeStart(rs.getString(3));
                c.setTimeEnd(rs.getString(4));
                c.setIdTopic(rs.getString(5));
                c.setIdCategory(rs.getString(6));
                c.setIdTeacher(rs.getString(7));
                
                list.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
