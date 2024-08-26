package org.springbootdemo.Railway.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {


    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());

        if(file.isEmpty())
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
        if(!file.getContentType().equals("image/jpeg"))
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg allowed");

       return ResponseEntity.ok("working");

       // if show error 413 request entity size is too long then always check the size which you define in properties file
    }
}
