package code4food.controllers;

import code4food.model.Photos;
import code4food.service.PhotoGalleryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class PhotoController {

//    @RequestMapping("/photo")
//    public String photo(Model model) {
//        return "photo";
//    }


    @RequestMapping(value="/photo", method=RequestMethod.GET)
    public String index(Model model) {
        Photos.getInstance().clearPhotos();
        return "index";
    }

//    Дописать добавление фотографий (Photo) в лист (Photos)
    @RequestMapping(value="/photo", method=RequestMethod.POST)
    public String photoSubmit(@RequestParam("pathName") String pathName, Model model) {
        StringBuilder error = new StringBuilder("");
        File destFolder = new File(pathName);
        File targetFolder;
//        try {
//            targetFolder = File.createTempFile("temp_gallery_folder","");
//            targetFolder.delete();
//            targetFolder.mkdir();
            new PhotoGalleryServiceImpl().scanFolders(destFolder);
//        } catch (IOException e) {
//            error = e.toString();
//        }
        error.append(Photos.getInstance().getCountPhotos());
        model.addAttribute("photos",Photos.getInstance().getPhotos());
        model.addAttribute("name",error);
        return "photo";
    }
}