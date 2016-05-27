package codeforfood.service;

import codeforfood.util.DirectoryScanner;
import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static codeforfood.util.DirectoryScanner.getFiles;

public class PhotoGalleryService {

  private final static Logger LOGGER = Logger.getLogger(DirectoryScanner.class);

  public void saveUploadedPhotos(String path){
    List<Path> files = getFiles(path);
    if (files.isEmpty()) {
      LOGGER.info("Photos have not been find.");
    }
    List<byte[]> photos = new ArrayList<>();
    byte[] bytes = new byte[4096];

    for (Path file: files) {
      try {
        InputStream stream = new BufferedInputStream(Files.newInputStream(file), 4096);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while(stream.available() > 0) {
          int read = stream.read(bytes);
          byteArrayOutputStream.write(bytes, 0, read);
        }
        photos.add(byteArrayOutputStream.toByteArray());

      } catch (Exception e) {
        LOGGER.info("");
      }
    }
  }
}
