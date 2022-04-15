package co.integrapps.services.application.port.out;

import org.springframework.web.multipart.MultipartFile;

public interface S3BucketStoragePort {
    String uploadFile(String keyName, MultipartFile file);
}
