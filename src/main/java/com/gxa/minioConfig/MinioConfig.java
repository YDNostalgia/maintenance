package com.gxa.minioConfig;

import io.minio.MinioClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MinioConfig {

    @Autowired
    private MinioPropConfig minioPropConfig;

    /**
     * 初始化 MinIO 客户端
     */
    @Bean
    public MinioClient minioClient() {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(minioPropConfig.getEndpoint())
                .credentials(minioPropConfig.getAccesskey(), minioPropConfig.getSecretKey())
                .build();
        return minioClient;
    }

}
