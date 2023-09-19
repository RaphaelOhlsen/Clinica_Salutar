package dev.mocad.salutar.controller;

import dev.mocad.salutar.dto.PathToFile;
import dev.mocad.salutar.service.upload.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@CrossOrigin("*")
public class UploadController {

  @Autowired
  private IUploadService service;

  @PostMapping
  public ResponseEntity<?> uploadFile(@RequestParam(name = "arquivo") MultipartFile file) {
    String fileName = service.uploadFile(file);
   if(fileName != null) {
      return ResponseEntity.status(201).body(new PathToFile(fileName));
    }
    return ResponseEntity.badRequest().build();
  }
}
