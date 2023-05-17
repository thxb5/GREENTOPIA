package com.sunny.green.service;

import com.sunny.green.vo.ProductVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    public void registerProduct(ProductVo productVo, MultipartFile imageFile) throws IOException;
}
