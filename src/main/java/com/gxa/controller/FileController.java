package com.gxa.controller;

import com.gxa.dto.FileUrlDto;
import com.gxa.service.MinioService;
import com.gxa.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@Api( tags = "文件上传下载")
public class FileController {

    @Autowired
    private MinioService minioService;

    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    @ResponseBody
    public Result<List<String>> upload(@RequestParam(name = "multipartFile") MultipartFile[] multipartFile) {
        Result<List<String>> r = Result.failed("上传失败");
        try {
            List<String> strings = minioService.addFile(multipartFile);
            r = Result.success(strings);
            return r;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @ApiOperation(value = "文件下载")
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam String fileName) {
        ResponseEntity<byte[]> responseEntity = null;
        try {
            responseEntity = minioService.updateFile(fileName);
            return responseEntity;
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseEntity;
    }

    @ApiOperation(value = "获取图片预览地址")
    @GetMapping("/getUrl")
    @ResponseBody
    public Result<FileUrlDto>  getFileUrl(@RequestParam String fileName) {
        Result<FileUrlDto> r = Result.failed("获取失败");
        try {
            FileUrlDto fileUrlDto = minioService.getFileUrl(fileName);
            r = Result.success(fileUrlDto);
            return r;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    /*@ApiOperation(value = "minio创建桶")
    @PostMapping("/existBucket")
    public void existBucket(@RequestParam String bucketName) {
        minioUtil.existBucket(bucketName);
    }*/
}
