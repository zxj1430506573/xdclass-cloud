package net.xdclass.service;

import net.xdclass.domain.Video;
import org.springframework.stereotype.Service;


public interface VideoService {
    Video findbyId(int videoId);
}
