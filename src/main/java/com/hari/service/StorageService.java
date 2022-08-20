package com.hari.service;

import com.hari.entity.ImageData;
import com.hari.repository.StorageRepository;
import com.hari.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Optional;
import java.util.UUID;

@Service
public class StorageService {

    @Autowired
    StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = storageRepository.save(ImageData.builder()
                        .id(UUID.randomUUID())
                .name(file.getOriginalFilename()).type(file.getContentType())
                .imageData(ByteBuffer.wrap(ImageUtils.compressImage(file.getBytes()))).build());

        if(imageData!=null){
            return "file uploaded successfully "+ file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = storageRepository.findByName(fileName);
        ByteBuffer bb = dbImageData.get().getImageData();
        byte[] data = new byte[bb.remaining()];
        bb.get(data);
        byte[] images=ImageUtils.decompressImage(data);
        return images;
    }
}
