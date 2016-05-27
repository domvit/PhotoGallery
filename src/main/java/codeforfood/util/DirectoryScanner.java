package codeforfood.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DirectoryScanner {

  private final static Logger LOGGER = Logger.getLogger(DirectoryScanner.class);

  public static List<Path> getFiles(String directory) {
    File filesInTheDirectory = new File(directory);
    File[] files = filesInTheDirectory.listFiles();
    List<Path> foundPaths = new ArrayList<>();

    if (files != null) {
      for (File file : files) {
        boolean isSuitableExtension = file.getName().toLowerCase().endsWith(".png");
        boolean isFile = file.isFile();
        Path path = Paths.get(file.getPath());
        if (isFile && isSuitableExtension) {
          foundPaths.add(path);
        } else {
          getFiles(file.getPath());
        }
      }
    } else {
      LOGGER.info("");
    }
    return foundPaths;
  }

  /*private byte[] convertToByte(String path) {
    File file = new File(path);
    try {
      // Reading a Image file from file system
      FileInputStream inputStream = new FileInputStream(file);
      byte[] imageData = new byte[(int) file.length()];
      imageInFile.read(imageData);
  } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    private byte[] encode(String path) {
    File file = new File(path);
    try {
      // Reading a Image file from file system
      FileInputStream imageInFile = new FileInputStream(file);
      byte[] imageData = new byte[(int) file.length()];
      imageInFile.read(imageData);
      // Converting Image byte array into Base64 String
      imageDataString = Base64.encodeBase64String(imageData);
      imageInFile.close();
      System.out.println("Image " + path + "\\" + name + " Successfully Manipulated!");
    } catch (FileNotFoundException e) {
      System.out.println("Image not found " + e);
    } catch (IOException ioe) {
      System.out.println("Exception while reading the Image " + ioe);
    }
    return imageDataString;
  }*/
}