package org.example.repositories;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PictureRepository {
    /**
     * @return saved picture name
     */
    public String savePicture(MultipartFile file) throws IOException;
    public byte[] loadPicture(String imageName) throws IOException;
}
