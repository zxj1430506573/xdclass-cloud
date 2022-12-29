package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/find_by_id")
    public Object findById(int videoId, HttpServletRequest request){

        Video video = videoService.findbyId(videoId);
        video.setServiceInfo(request.getServerName()+":"+request.getServerPort());
        return video;
    }

    @PostMapping("save")
    public Object save(@RequestBody Video video){
        System.out.println(video.getTitle());
        return  video;
    }
}
