package net.xdclass.service;

import net.xdclass.domain.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("xdclass-video-service")
public interface VideoService {
    @GetMapping(value = "/api/v1/video/find_by_id")
    Video findById(@RequestParam("videoId") int videoId);

    @PostMapping(value = "/api/v1/video/save")
    Video saveVideo(@RequestBody Video video);
}
