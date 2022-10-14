package com.gxa.controller;

import com.gxa.dto.StatuteTypeEditDto;
import com.gxa.dto.StatuteTypeQueryDto;
import com.gxa.entity.StatuteType;
import com.gxa.service.StatuteTypeService;
import com.gxa.utils.MinioUtil;
import com.gxa.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Api("文件上传下载")
public class FileController {

    @Autowired
    private MinioUtil minioUtil;

    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public List<String> addFile(@RequestParam(name = "multipartFile") MultipartFile[] multipartFile) {

        return minioUtil.upload(multipartFile);
    }

    @ApiOperation(value = "文件下载")
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam String fileName) {
        return minioUtil.download(fileName);
    }

    /*@ApiOperation(value = "minio创建桶")
    @PostMapping("/existBucket")
    public void existBucket(@RequestParam String bucketName) {
        minioUtil.existBucket(bucketName);
    }*/
}
