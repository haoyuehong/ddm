package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.ddm.ddm.common.FastDFSClientWrapper;
import vip.ddm.ddm.result.Result;

import java.io.IOException;

@RestController
public class UploadController {

    @Autowired
    private FastDFSClientWrapper dfsClient;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Result upload(MultipartFile file) throws IOException {
        return Result.success("https://image.hz1202.com/"+dfsClient.uploadFile(file));
    }
}
