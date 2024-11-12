package vn.iotstar.DAO.impl;

import vn.iotstar.Configs.DBMySQLConnection;
import vn.iotstar.DAO.IVideoRepository;
import vn.iotstar.Entity.Video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoRepositoryImpl extends DBMySQLConnection implements IVideoRepository {

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    @Override
    public void delete(String videoid) {
        String sql = "delete from videos where VideoId = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, videoid);

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Video> findAll() {
        String sql = "select * from videos";
        List<Video> list = new ArrayList<Video>();
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while(rs.next()){
                Video cm = new Video();
                cm.setVideoId(rs.getString("VideoId"));
                cm.setTitle(rs.getString("Title"));
                cm.setPoster(rs.getString("Poster"));
                cm.setViews(rs.getInt("Views"));
                cm.setDescription(rs.getString("Description"));
                cm.setActive(rs.getBoolean("Active"));
                cm.setCategoryId(rs.getInt("CategoryId"));
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
    public Video findById(String id) {
        String sql = "select * from videos where VideoId = ?";
        Video cm = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                cm = new Video();
                cm.setVideoId(rs.getString("VideoId"));
                cm.setTitle(rs.getString("Title"));
                cm.setPoster(rs.getString("Poster"));
                cm.setViews(rs.getInt("Views"));
                cm.setDescription(rs.getString("Description"));
                cm.setActive(rs.getBoolean("Active"));
                cm.setCategoryId(rs.getInt("CategoryId"));
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
    public Video findByVideoTitle(String videoTitle) {
        String sql = "select * from videos where Title = ?";
        Video cm = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, videoTitle);
            rs = ps.executeQuery();
            while(rs.next()){
                cm = new Video();
                cm.setVideoId(rs.getString("VideoId"));
                cm.setTitle(rs.getString("Title"));
                cm.setPoster(rs.getString("Poster"));
                cm.setViews(rs.getInt("Views"));
                cm.setDescription(rs.getString("Description"));
                cm.setActive(rs.getBoolean("Active"));
                cm.setCategoryId(rs.getInt("CategoryId"));
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
    public void insert(Video video) {
        String sql = "insert into videos (Title, Poster, Views, Description, Active, CategoryId) values (?,?,?,?,?,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, video.getTitle());
            ps.setString(2, video.getPoster());
            ps.setInt(3, video.getViews());
            ps.setString(4, video.getDescription());
            ps.setBoolean(4, video.isActive());
            ps.setInt(5, video.getCategoryId());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Video video) {
        String sql = "update videos set Title = ?, Poster = ?, Views = ?, Description = ?, Active = ?, CategoryId = ? where VideoId = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, video.getTitle());
            ps.setString(2, video.getPoster());
            ps.setInt(3, video.getViews());
            ps.setString(4, video.getDescription());
            ps.setBoolean(4, video.isActive());
            ps.setInt(5, video.getCategoryId());
            ps.setString(6, video.getVideoId());

            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
