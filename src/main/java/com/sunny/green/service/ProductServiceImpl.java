package com.sunny.green.service;

import com.sunny.green.dao.AdminDao;
import com.sunny.green.vo.ProImgVo;
import com.sunny.green.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService{
    private final AdminDao adminDao;

    @Override
    @Transactional
    public void registerProduct(ProductVo productVo, MultipartFile imageFile) throws IOException {
        String fileName = imageFile.getOriginalFilename(); // 파일 이름 추출
        String uploadPath = "/home/ubuntu/greentopia2/img/product/"; // 업로드 디렉토리 경로
        String uuid = UUID.randomUUID().toString();
        String realPath = uploadPath + uuid + fileName;
        String saveFile = uuid + fileName;
        adminDao.insertPro(productVo);
        String str = String.valueOf(productVo);
        log.info(str);

        try (OutputStream os = new FileOutputStream(realPath)) {
            os.write(imageFile.getBytes());

            ProImgVo proImgVo = new ProImgVo();
            proImgVo.setPro_num(productVo.getPro_num());
            proImgVo.setPro_img_save_name(saveFile);
            proImgVo.setPro_img_path(realPath);
            adminDao.insertProImg(proImgVo);
        } catch (IOException e) {
            // 파일 저장 실패 시 예외 처리
            throw e;
        }
    }
}
