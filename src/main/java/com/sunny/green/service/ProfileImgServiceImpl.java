package com.sunny.green.service;

import com.sunny.green.dao.ProfileImgDao;
import com.sunny.green.vo.ProfileImgVo;
import com.sunny.green.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileImgServiceImpl implements ProfileImgService{
    private final ProfileImgDao profileImgDao;
    @Override
    @Transactional
    public void uploadProfileImg(MultipartFile imageFile, UserVo userVo) throws IOException {
        String fileName = imageFile.getOriginalFilename(); // 파일 이름 추출
        String uploadPath = "/home/ubuntu/greentopia2/img/profile/"; // 업로드 디렉토리 경로
        String uuid = UUID.randomUUID().toString();
        String realPath = uploadPath + uuid + fileName;
        String saveFile = uuid + fileName;

        try (OutputStream os = new FileOutputStream(realPath)) {
            os.write(imageFile.getBytes());

            ProfileImgVo profileImgVo = new ProfileImgVo();
            profileImgVo.setUser_id(userVo.getUser_id());
            profileImgVo.setImg_save_name(saveFile);
            profileImgVo.setImg_path(realPath);
            profileImgDao.insProfileImg(profileImgVo);
        } catch (IOException e) {
            // 파일 저장 실패 시 예외 처리
            e.printStackTrace();
            throw e;

        }
    }
}
