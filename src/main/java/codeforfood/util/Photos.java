package codeforfood.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * A helper class that provide functionality of searching images with *.png extension in th specified directory
 * type by user
 */
public class Photos {

    private List<String> photos = new ArrayList<>();

    private static Photos ourInstance = new Photos();

    public static Photos getInstance() {
        return ourInstance;
    }

    private Photos() {
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void addPhoto(String photo){
        photos.add(photo);
    }

    public int getCountPhotos(){
        return photos.size();
    }

    public void clearPhotos(){
        photos = new ArrayList<>();
    }

    /**
     *
     * This method search images with *.png extension in th specified directory
     * type by user and all of its subdirectories
     */
    public void scanFolders(File scanfolder) {
        File[] files = scanfolder.listFiles();
        for(File file:files){
            if (file.isDirectory()){
                scanFolders(file);
            }else {
                String fileName = file.getName();
                if (fileName.toLowerCase().endsWith(".png")) {
                    String filePath = file.getPath();
                    String photo = encodeImage(filePath);
                    ourInstance.addPhoto(photo);
                }
            }
        }
    }

    /**
     *
     * This method encode binary data by treating it numerically and translating it into a base64 representation
     * @return a base64 photos representation
     */
    private String encodeImage(String path){
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
        } catch (FileNotFoundException e) {
            System.out.println("Image not found " + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return imageDataString;
    }

}
