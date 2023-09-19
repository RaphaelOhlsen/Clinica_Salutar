package dev.mocad.salutar.service.upload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class UploadServiceImpl implements IUploadService {

  @Override
  public String uploadFile(MultipartFile file) {
   try {
     System.out.println("DEBUG - Realizando Upload do arquivo: " + file.getOriginalFilename());
     String pastaDestino = "/home/raphael/Documentos/Developer/java/projetos/salutar/codigo/src/main/resources/static/images/";
     String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
     String newFileName = UUID.randomUUID().toString() + extension;
     Path path = Paths.get(pastaDestino + newFileName);
     Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
     return newFileName;
   } catch (IOException ex) {
     ex.printStackTrace();
   }
    return null;
  }
}
