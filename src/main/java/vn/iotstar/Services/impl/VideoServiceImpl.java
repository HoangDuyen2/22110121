package vn.iotstar.Services.impl;

import vn.iotstar.DAO.IVideoRepository;
import vn.iotstar.DAO.impl.VideoRepositoryImpl;
import vn.iotstar.Entity.Video;
import vn.iotstar.Services.IVideoService;

import java.util.List;

public class VideoServiceImpl implements IVideoService {

    IVideoRepository videoRepository = new VideoRepositoryImpl();

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Video findById(String id) {
        return videoRepository.findById(id);
    }

    @Override
    public Video findByVideoTitle(String videoTitle) {
        return videoRepository.findByVideoTitle(videoTitle);
    }

    @Override
    public boolean insert(Video video) {
        if (videoRepository.findByVideoTitle(video.getTitle()) != null) {
            videoRepository.insert(video);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Video video) {
        if (videoRepository.findById(video.getVideoId()) != null) {
            videoRepository.update(video);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String videoid) {
        if (videoRepository.findById(videoid) != null) {
            videoRepository.delete(videoid);
            return true;
        }
        return false;
    }
}
