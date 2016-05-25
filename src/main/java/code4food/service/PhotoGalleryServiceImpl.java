package code4food.service;

import code4food.model.Photo;
import code4food.model.Photos;

import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;

public class PhotoGalleryServiceImpl implements PhotoGalleryService {

//  public void scanFolders(File scanfolder, File destinationFolder) {
//    File[] files = scanfolder.listFiles();
//    for(File file:files){
//      if (file.isDirectory()){
//        scanFolders(file, destinationFolder);
//      }else {
//        if (file.getName().toLowerCase().endsWith(".png")) {
//          String filePath = file.getPath();
////          System.out.println(filePath + "   " + destinationFolder.getPath()+"\\"+file.getName());
//          try {
//            Files.copy(file.toPath(), new File(destinationFolder.getPath() + "\\" + file.getName()).toPath());
//          } catch (IOException e) {
//            e.printStackTrace();
//          }
//        }
//      }
//    }
//  }

  public void scanFolders(File scanfolder) {
    File[] files = scanfolder.listFiles();
    for(File file:files){
      if (file.isDirectory()){
        scanFolders(file);
      }else {
        String fileName = file.getName();
        if (fileName.toLowerCase().endsWith(".png")) {
          String filePath = file.getPath();
          Photo photo = new Photo(filePath,fileName);
          Photos.getInstance().addPhoto(photo);
        }
      }
    }
  }
}

