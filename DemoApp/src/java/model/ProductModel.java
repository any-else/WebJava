/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Admin;
import entity.Teacher;
import entity.Topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.registry.infomodel.User;
import static model.ConectionFactory.getConnection;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Admin
 */
public class ProductModel {

    public boolean addTeacher(String id, String name, String categogy, String dob, String email, String address, String phone, String image) {
        int result = 0;
        String sql = "INSERT INTO tblTeacher VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement prst = getConnection().prepareStatement(sql);
            prst.setString(1, id);
            prst.setString(2, name);
            prst.setString(3, categogy);
            prst.setString(4, dob);
            prst.setString(5, email);
            prst.setString(6, address);
            prst.setString(7, phone);
            prst.setString(8, image);
            result = prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    

    public ArrayList<Teacher> getData() {
        ArrayList<Teacher> list = new ArrayList<Teacher>();
        String sql = "SELECT * FROM tblTeacher";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Teacher t = new Teacher();
                t.setId(rs.getString(1));
                t.setName(rs.getString(2));
                t.setCategogy(rs.getString(3));
                t.setDob(rs.getString(4));
                t.setEmail(rs.getString(5));
                t.setAddress(rs.getString(6));
                t.setPhone(rs.getString(7));
                t.setImage(rs.getString(8));

                list.add(t);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Teacher getDataById(String id) {
        ArrayList<Teacher> list = new ArrayList<Teacher>();
        String sql = "SELECT * FROM tblTeacher WHERE _TeacherID=? ";
        Teacher p = null;
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Teacher();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setCategogy(rs.getString(3));
                p.setDob(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setAddress(rs.getString(6));
                p.setPhone(rs.getString(7));
                p.setImage(rs.getString(8));
//                list.add(p);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public boolean deleteTeacherInTopic(String id) {
        int result = 0;
        String sql = "DELETE FROM tblTeacherInTopic WHERE _idTeacher =?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    public boolean deleteTeacher(String id) {
        int result = 0;
        boolean b = deleteTeacherInTopic(id);
   
        if(b==true){
            String sql = "DELETE FROM tblTeacher WHERE _TeacherID = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            
                result = ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result > 0;
    }

    public boolean editTeacher(String id, String name, String categogy, String topic, String dob, String email, String address, String phone, String image) {

        int result = 0;
        String sql = "UPDATE tblTeacher SET _fullname=?, _categogy=?, _dob=?, _email=?, _address=?, _phone=?, _image=? WHERE _TeacherID=?";
        try {

            PreparedStatement prst = getConnection().prepareStatement(sql);

            prst.setString(1, name);
            prst.setString(2, categogy);
            prst.setString(3, dob);
            prst.setString(4, email);
            prst.setString(5, address);
            prst.setString(6, phone);
            prst.setString(7, image);
            prst.setString(8, id);
            result = prst.executeUpdate();

            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    public int count(String txtSearch) {
        try {
            String sql = "SELECT COUNT (*) FROM tblProduct WHERE _id LIKE ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public static void main(String[] args) {
        ProductModel pm = new ProductModel();
//        int count = pm.count("P");
        System.out.println(pm.deleteTeacher("P0000"));
    }

    public ArrayList<Teacher> SearchByName(String txtSearch) {
        Connection conn = getConnection();//lấy về kết nối

        ArrayList<Teacher> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblTeacher WHERE _fullname LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Teacher t = new Teacher();
                t.setId(rs.getString(1));
                t.setName(rs.getString(2));
                t.setCategogy(rs.getString(3));
                t.setDob(rs.getString(4));
                t.setEmail(rs.getString(5));
                t.setAddress(rs.getString(6));
                t.setPhone(rs.getString(7));
                t.setImage(rs.getString(8));

                list.add(t);
            }
            conn.close();
            ps.close();
        } catch (Exception e) {
            Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Topic> getTopic() {
        ArrayList<Topic> list = new ArrayList<Topic>();
        String sql = "SELECT * FROM tblTopic";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Topic t = new Topic();
                t.setId(rs.getString(1));
                t.setName(rs.getString(2));

                list.add(t);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Admin checkLogin(String user, String pass) {

        Admin admin = null;
        String sql = "SELECT * FROM tblAdmin WHERE _user=? and _pass=?";
//        Connection conn = getConnection();//lấy về kết nối  
        try {
            PreparedStatement ps = ConectionFactory.getConnection().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                admin = new Admin();
                admin.setUser(rs.getString(1));
                admin.setPass(rs.getString(2));
            }
            rs.close();
            ps.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return admin;
    }

    public boolean addTinT(String id, String[] topic) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = "INSERT INTO tblTeacherInTopic VALUES(?,?)";
        Connection connection = ConectionFactory.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement st = connection.prepareStatement(sql);
            for(String v : topic){
                st.setString(1, id);
                st.setString(2, v);
                
                st.addBatch();
            }
            int [] r=st.executeBatch();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            
            try {
                connection.rollback();
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
   
}
