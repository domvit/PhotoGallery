package code4food.model;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.*;

public class Photo {
  private String name;
  private String path;
  private String image;

  public Photo(String path, String name) {
    this.name = name;
    this.path = path;
    this.image = encodeImage();
  }

  public String getName() {
    return name;
  }

  public String getPath() {
    return path;
  }

  public String getData() {
    return image;
  }

  private String encodeImage(){
    System.out.println(path);
    File file = new File(path);
    String imageDataString = null;
    try {
      // Reading a Image file from file system
      FileInputStream imageInFile = new FileInputStream(file);
      byte imageData[] = new byte[(int) file.length()];
      imageInFile.read(imageData);
      // Converting Image byte array into Base64 String
      imageDataString = Base64.encodeBase64String(imageData);
      imageInFile.close();
      System.out.println("Image "+path + "\\" + name+" Successfully Manipulated!");
    } catch (FileNotFoundException e) {
      System.out.println("Image not found " + e);
    } catch (IOException ioe) {
      System.out.println("Exception while reading the Image " + ioe);
    }
    return imageDataString;
  }
}
