package vn.iotstar.DAO.impl;

import vn.iotstar.Configs.DBMySQLConnection;
import vn.iotstar.DAO.IUserRepository;
import vn.iotstar.Entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl extends DBMySQLConnection implements IUserRepository {

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    @Override
    public List<Users> findAll() {
        String sql = "select * from users";
        List<Users> list = new ArrayList<Users>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while(rs.next()){
                Users cm = new Users();
                cm.setUsername(rs.getString("Username"));
                cm.setPassword(rs.getString("Password"));
                cm.setPhone(rs.getString("Phone"));
                cm.setFullname(rs.getString("Fullname"));
                cm.setEmail(rs.getString("Email"));
                cm.setAdmin(rs.getBoolean("Admin"));
                cm.setActive(rs.getBoolean("Active"));
                cm.setImages(rs.getString("Images"));
                list.add(cm);
            }
            rs.close();
            ps.close();
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Users findByUsername(String username) {
        String sql = "select * from users where Username = ?";
        Users cm = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            rs = ps.executeQuery();
            while(rs.next()){
                cm = new Users();
                cm.setUsername(rs.getString("Username"));
                cm.setPassword(rs.getString("Password"));
                cm.setPhone(rs.getString("Phone"));
                cm.setFullname(rs.getString("Fullname"));
                cm.setEmail(rs.getString("Email"));
                cm.setAdmin(rs.getBoolean("Admin"));
                cm.setActive(rs.getBoolean("Active"));
                cm.setImages(rs.getString("Images"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cm;
    }

    @Override
    public Users login(String username, String password) {
        String sql = "select * from users where Username = ? and Password = ?";
        Users cm = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
                cm = new Users();
                cm.setUsername(rs.getString("Username"));
                cm.setPassword(rs.getString("Password"));
                cm.setPhone(rs.getString("Phone"));
                cm.setFullname(rs.getString("Fullname"));
                cm.setEmail(rs.getString("Email"));
                cm.setAdmin(rs.getBoolean("Admin"));
                cm.setActive(rs.getBoolean("Active"));
                cm.setImages(rs.getString("Images"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cm;
    }

    @Override
    public void insert(Users users) {
        String sql = "insert into users (Username, Password, Phone, Fullname, Email, Admin, Active, Images) values (?,?,?,?,?,?,?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, users.getUsername());
            ps.setString(2, users.getPassword());
            ps.setString(3, users.getPhone());
            ps.setString(4, users.getFullname());
            ps.setString(5, users.getEmail());
            ps.setBoolean(6, users.isAdmin());
            ps.setBoolean(7, users.isActive());
            ps.setString(8, users.getImages());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Users users) {
        String sql = "update users set Password = ?, Phone = ?, Fullname = ?, Email = ?, Images = ? where Username = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, users.getPassword());
            ps.setString(2, users.getPhone());
            ps.setString(3, users.getFullname());
            ps.setString(4, users.getEmail());
            ps.setString(5, users.getImages());
            ps.setString(6, users.getUsername());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String username) {
        String sql = "delete from users where Username = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
