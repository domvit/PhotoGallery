package code4food.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HiMan on 25.05.2016.
 */
public class Photos {

    private List<Photo> photos = new ArrayList<>();
    private static Photos ourInstance = new Photos();

    public static Photos getInstance() {
        return ourInstance;
    }

    private Photos() {
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void addPhoto(Photo photo){
        photos.add(photo);
    }

    public int getCountPhotos(){
        return photos.size();
    }

    public void clearPhotos(){
        photos = new ArrayList<>();
    }

}
