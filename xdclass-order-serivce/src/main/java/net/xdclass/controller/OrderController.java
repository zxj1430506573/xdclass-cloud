package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.domain.VideoOrder;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/video_order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private  VideoService videoService;

    @GetMapping("/{videoId}")
    public Object save(@PathVariable int videoId){
//        Video video = restTemplate.getForObject("http://localhost:9000/api/v1/video/"+ videoId, Video.class);

//        List<ServiceInstance> instances = discoveryClient.getInstances("xdclass-video-service");
//        ServiceInstance serviceInstance = instances.get(0);
//        Video video = restTemplate.getForObject("http://"+ serviceInstance.getHost()+":"+serviceInstance.getPort()+"/api/v1/video/"+ videoId, Video.class);
//        ribbom 测试  find_by_id?videoId=40
//        Video video = restTemplate.getForObject("http://xdclass-video-service/api/v1/video/"+ videoId, Video.class);

//      openfeign ceshi
        Video video = videoService.findById(videoId);
        videoService.saveVideo(video);
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setCreateTime(new Date());
        videoOrder.setVideoImg(video.getCoverImg());
        videoOrder.setServiceInfo(video.getServiceInfo());
        videoOrder.setVideoTitle(video.getTitle());

        return videoOrder;
    }
}
