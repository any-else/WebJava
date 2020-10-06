/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Author;
import entity.book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teaser
 */
public class dataprocess {
    public Connection getConnection()
    {
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user="sa";
            String pass="123456";
            String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Demojava";
            try {
                conn=DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(dataprocess.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public boolean checklogin(String user, String pass)
    {
        boolean f=false;
        String sql="SELECT * FROM tblAccount WHERE tbluser=? AND tblpass=?";
        Connection conn=getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs=ps.executeQuery();
            f=rs.next();
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
    public boolean addBook(String id, String name, String auth ,float price,String des)
    {
        int f=0;
        String sql="INSERT INTO tblBook VALUES(?,?,?,?,?)";
        Connection conn=getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, auth);
            ps.setFloat(4, price);
            ps.setString(5, des);
            f=ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f>0;
    }
    public ArrayList<book> getData()
    {
        ArrayList<book> list=new ArrayList<book>();
        String sql="SELECT * FROM tblBook";
        try {
            Statement st=getConnection().createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                book b=new book();
                b.setId(rs.getString(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getFloat(4));
                b.setDes(rs.getString(5));
                list.add(b);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public boolean delBook(String id)
    {
        int f=0;
        String sql="DELETE FROM tblBook WHERE _id=?";
        Connection conn=getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, id);
            f=ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f>0;
    }
    public ArrayList<Author> getAuthor()
    {
        ArrayList<Author> list=new ArrayList<Author>();
        String sql="SELECT * FROM tblAuthor";
        try {
            Statement st=getConnection().createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                Author a=new Author();
                a.setId(rs.getString(1));
                a.setName(rs.getString(2));
                list.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public book getByID(String id)
    {
        book b=null;
        String sql="SELECT * FROM tblBook Where _id=?";
        try {
            PreparedStatement st=getConnection().prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                b=new book();
                b.setId(rs.getString(1));
                b.setName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getFloat(4));
                b.setDes(rs.getString(5));
                
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
      public boolean updateBook(String id, String name, String auth ,float price,String des)
    {
        int f=0;
        String sql="UPDATE tblBook SET _name=?,_auid=?,price=?,_des=? WHERE _id=?";
        Connection conn=getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, auth);
            ps.setFloat(3, price);
            ps.setString(4, des);
            ps.setString(5, id);
            f=ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataprocess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f>0;
    }
}
