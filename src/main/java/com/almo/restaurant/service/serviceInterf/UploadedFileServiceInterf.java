package com.almo.restaurant.service.serviceInterf;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UploadedFileServiceInterf {
    Map<String, String> saveFile(MultipartFile file);
}
