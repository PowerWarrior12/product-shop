package org.example.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.exceptions.ApiRequestException;
import org.example.repositories.PictureRepository;
import org.example.services.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.example.Constants.PICTURES_MAIN_PATH;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    @Value("${hostname}")
    private String hostname;
    @Override
    public String savePicture(MultipartFile file) {
        try {
            String pictureName = pictureRepository.savePicture(file);
            return String.format("%s%s/%s", hostname, PICTURES_MAIN_PATH, pictureName);
        } catch (IOException exception) {
            throw new ApiRequestException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public byte[] loadPicture(String imageName) {
        try {
            return pictureRepository.loadPicture(imageName);
        } catch (IOException exception) {
            throw new ApiRequestException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
