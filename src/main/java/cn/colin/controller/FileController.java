package cn.colin.controller;

import cn.colin.common.Response;
import cn.colin.service.FileService;
import io.minio.ObjectWriteResponse;
import io.minio.StatObjectResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {
    @Resource
    private FileService fileService;

    @PostMapping("/uploadFile")
    public Response<ObjectWriteResponse> uploadFile(@RequestParam("bucketName") String bucketName,
                                                    @RequestParam("file") MultipartFile file) {
        return Response.success(fileService.uploadFile(bucketName, file));
    }

    @PostMapping("/uploadBigFile")
    public Response<ObjectWriteResponse> uploadBigFile(@RequestParam("bucketName") String bucketName,
                                                       @RequestParam("file") MultipartFile file) {
        return Response.success(fileService.uploadBigFile(bucketName, file));
    }

    @PostMapping("/getFileUrl")
    public Response<String> getFileUrl(@RequestParam("bucketName") String bucketName,
                                       @RequestParam("fileName") String fileName) {
        return Response.success(fileService.getFileUrl(bucketName, fileName));
    }

    @PostMapping("/statObject")
    public Response<StatObjectResponse> statObject(@RequestParam("bucketName") String bucketName,
                                                   @RequestParam("fileName") String fileName) {
        return Response.success(fileService.statObject(bucketName, fileName));
    }
}
