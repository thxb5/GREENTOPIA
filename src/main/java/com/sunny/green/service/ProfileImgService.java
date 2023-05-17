package com.sunny.green.service;

import com.sunny.green.vo.UserVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProfileImgService {
    public void uploadProfileImg(MultipartFile imageFile, UserVo userVo) throws IOException;
}
