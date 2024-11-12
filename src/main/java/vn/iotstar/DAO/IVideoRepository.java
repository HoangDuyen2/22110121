package vn.iotstar.DAO;

import vn.iotstar.Entity.Video;

import java.util.List;

public interface IVideoRepository {
    List<Video> findAll();
    Video findById(String id);
    Video findByVideoTitle(String videoName);

    void insert(Video video);
    void update(Video video);
    void delete(String videoid);
}
