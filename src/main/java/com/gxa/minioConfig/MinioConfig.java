package com.gxa.minioConfig;

import io.minio.MinioClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class MinioConfig {
    /**
     * 连接url
     */
    @Value("${minio.endpoint}")
    private String endpoint;
    /**
     * 用户名
     */
    @Value("${minio.accesskey}")
    private String accesskey;
    /**
     * 密码
     */
    @Value("${minio.secretKey}")
    private String secretKey;
    /**
     * 文件桶的名称
     */
    @Value("${minio.bucketName}")
    private String bucketName;

    @Bean
    public MinioClient getMinioClient(){
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accesskey, secretKey)
                .build();
    }
}

