package org.example.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAccess {
    public boolean saveUser(String username, String password){
        String sql = "INSERT INTO Users(username, password) VALUES(?, ?)";
        try (Connection conn = Koneksi.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean checkUser(String ussername, String password){
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try (Connection conn = Koneksi.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ussername);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean checkUserExist(String username){
        String sql = "SELECT * FROM Users WHERE username = ?";
        try (Connection conn = Koneksi.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
