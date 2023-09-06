package org.example.services;

import org.example.exceptions.ApiRequestException;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
    /**
     * @return saved picture path
     */
    public String savePicture(MultipartFile file) throws ApiRequestException;
    public byte[] loadPicture(String imageName) throws ApiRequestException;
}
