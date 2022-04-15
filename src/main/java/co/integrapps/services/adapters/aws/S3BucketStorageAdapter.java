package co.integrapps.services.adapters.aws;

import co.integrapps.services.application.port.out.S3BucketStoragePort;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class S3BucketStorageAdapter implements S3BucketStoragePort {

    private Logger LOGGER = LoggerFactory.getLogger(S3BucketStorageAdapter.class);

    private final AmazonS3 amazonS3Client;

    @Value("${application.bucket.name}")
    private String bucketName;

    @Override
    public String uploadFile(String keyName, MultipartFile file) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucketName, keyName, file.getInputStream(), metadata);
            return  keyName;
        } catch (IOException ioe) {
            LOGGER.error("IOException: " + ioe.getMessage());
        } catch (AmazonServiceException serviceException) {
            LOGGER.info("AmazonServiceException: "+ serviceException.getMessage());
            throw serviceException;
        } catch (AmazonClientException clientException) {
            LOGGER.info("AmazonClientException Message: " + clientException.getMessage());
            throw clientException;
        }
        return "File not uploaded: " + keyName;
    }
}
