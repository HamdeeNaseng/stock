package com.jsp.stock.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
// import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

// import com.jsp.infrademo.model.Image;
// import com.jsp.infrademo.repository.ImageRepository;
// import com.jsp.infrademo.util.ImageUtils;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ContextedRuntimeException;

import java.io.IOException;
// import java.util.List;
// import java.util.Optional;
// import java.util.zip.DataFormatException;
// import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("${upload.path}")
    private String uploadPath;


    public Resource getImageResource(String filename) throws IOException {
        Path imagePath = Paths.get(uploadPath, filename);
        return new UrlResource(imagePath.toUri());
    }

    public boolean uploadImageResource(MultipartFile imageFile, String filename) throws IOException {
   
        // Construct the path where the file will be saved
        Path imagePath = Paths.get(uploadPath, filename);
    
        // Save the file to the specified path
        Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
    
        // Create a UrlResource from the saved path
        // Resource imageResource = new UrlResource(imagePath.toUri());
    
        // You can now use the imageResource as needed, e.g., store it in a database or return it  
        return true;
    }
    
    // View a single image by name
    public Path getFilename(String filename) {
        return Paths.get(uploadPath).resolve(filename);
    }

    public boolean deleteImage(String filename) {
        Path imagePath = getFilename(filename);
        try {
            Files.deleteIfExists(imagePath);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean updateImage(MultipartFile imageFile, String filename) throws IOException {
        deleteImage(filename);
        return uploadImageResource(imageFile, filename);
    }
}