package vn.iotstar.Services;

import vn.iotstar.Entity.Video;

import java.util.List;

public interface IVideoService {
    List<Video> findAll();
    Video findById(String id);
    Video findByVideoTitle(String videoTitle);

    boolean insert(Video video);
    boolean update(Video video);
    boolean delete(String videoid);
}
