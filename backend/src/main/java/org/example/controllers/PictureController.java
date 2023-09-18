package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.services.PictureService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.Constants.PICTURES_MAIN_PATH;

@RestController
@RequestMapping(PICTURES_MAIN_PATH)
@RequiredArgsConstructor
public class PictureController {
    private final PictureService pictureService;
    @GetMapping("/{picture_name}")
    public ResponseEntity<byte[]> loadPicture(@PathVariable("picture_name") String pictureName) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .contentType(MediaType.IMAGE_PNG)
                .body(pictureService.loadPicture(pictureName));
    }
}
