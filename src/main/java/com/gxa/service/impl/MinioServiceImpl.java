package com.gxa.service.impl;


import com.gxa.dto.FileUrlDto;
import com.gxa.service.MinioService;
import com.gxa.utils.MinioUtil;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Service
public class MinioServiceImpl implements MinioService {

    @Autowired
    private MinioUtil minioUtil;

    @Override
    public List<String> addFile(MultipartFile[] multipartFile) {
        return minioUtil.upload(multipartFile);
    }

    @Override
    public ResponseEntity<byte[]> updateFile(String fileName) {
        return minioUtil.download(fileName);
    }

    @Override
    public FileUrlDto getFileUrl(String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        FileUrlDto fileUrlDto = new FileUrlDto();
        String fileUrl = minioUtil.getFileUrl(fileName);
        fileUrlDto.setFileName(fileName);
        fileUrlDto.setFileUrl(fileUrl);
        return  fileUrlDto;
    }
}
