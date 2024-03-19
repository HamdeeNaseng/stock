package com.jsp.stock.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.stock.service.ImageService;



@Controller
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException {
        Resource imageResource = imageService.getImageResource(filename);

        if (imageResource.exists() && imageResource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG) // adjust the media type based on your image type
                    .body(imageResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/add")
    public String addImageView(Model model) {

        return "image-add";
    }

    @PostMapping("/add")
    public ResponseEntity<String> handleFileUpload(@RequestParam("image") MultipartFile file) {
        if(file.isEmpty() || file.getSize() == 0 || file.getOriginalFilename().isEmpty() || file.getOriginalFilename().equals("")) {
            return ResponseEntity.badRequest().body("File is empty");
        }
        try {
            UUID uuid = UUID.randomUUID();
            String filename = uuid.toString() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename());
            boolean result = imageService.uploadImageResource(file, filename);
            if (!result) {
                return ResponseEntity.badRequest().body("Error uploading file");
            }
            return ResponseEntity.ok("File uploaded successfully: " + filename);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading file: " + e.getMessage());
        }
    }

}