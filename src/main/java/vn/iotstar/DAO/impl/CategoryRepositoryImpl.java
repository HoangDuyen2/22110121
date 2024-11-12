package vn.iotstar.DAO.impl;

import vn.iotstar.Configs.DBMySQLConnection;
import vn.iotstar.DAO.ICategoryRepository;
import vn.iotstar.Entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl extends DBMySQLConnection implements ICategoryRepository {

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    @Override
    public List<Category> findAll() {
        String sql = "select * from category";
        List<Category> list = new ArrayList<Category>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while(rs.next()){
                Category cm = new Category();
                cm.setCategoryId(rs.getInt("CategoryId"));
                cm.setCategoryname(rs.getString("Categoryname"));
                cm.setCategorycode(rs.getString("Categorycode"));
                cm.setImages(rs.getString("Images"));
                cm.setStatus(rs.getBoolean("Status"));
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
    public Category findById(int id) {
        String sql = "select * from category where CategoryId = ?";
        Category cm = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                cm = new Category();
                cm.setCategoryId(rs.getInt("CategoryId"));
                cm.setCategoryname(rs.getString("Categoryname"));
                cm.setCategorycode(rs.getString("Categorycode"));
                cm.setImages(rs.getString("Images"));
                cm.setStatus(rs.getBoolean("Status"));
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
    public Category findByCategoryName(String categoryName) {
        String sql = "select * from category where Categoryname = ?";
        Category cm = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, categoryName);
            rs = ps.executeQuery();
            while(rs.next()){
                cm = new Category();
                cm.setCategoryId(rs.getInt("CategoryId"));
                cm.setCategoryname(rs.getString("Categoryname"));
                cm.setCategorycode(rs.getString("Categorycode"));
                cm.setImages(rs.getString("Images"));
                cm.setStatus(rs.getBoolean("Status"));
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
    public void insert(Category category) {
        String sql = "insert into category (Categoryname, Categorycode, Images, Status) values (?,?,?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getCategorycode());
            ps.setString(3, category.getImages());
            ps.setBoolean(4, category.isStatus());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        String sql = "update category set Categoryname = ?, Categorycode = ?, Images = ?, Status = ? where CategoryId = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getCategorycode());
            ps.setString(3, category.getImages());
            ps.setBoolean(4, category.isStatus());
            ps.setInt(5, category.getCategoryId());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int categoryid) {
        String sql = "delete from category where CategoryId = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, categoryid);

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
