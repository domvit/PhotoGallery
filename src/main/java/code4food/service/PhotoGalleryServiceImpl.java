package code4food.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PhotoGalleryServiceImpl implements PhotoGalleryService {

  public void scanFolders(File scanfolder, File destinationFolder) {
    File[] files = scanfolder.listFiles();
    for(File file:files){
      if (file.isDirectory()){
        scanFolders(file, destinationFolder);
      }else {
        if (file.getName().toLowerCase().endsWith(".png")) {
          String filePath = file.getPath();
          System.out.println(filePath + "   " + destinationFolder.getPath()+"\\"+file.getName());
          try {
            Files.copy(file.toPath(), new File(destinationFolder.getPath() + "\\" + file.getName()).toPath());
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
