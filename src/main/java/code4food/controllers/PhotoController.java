package code4food.controllers;

import code4food.model.Photos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class PhotoController {

    @RequestMapping(value="/photo", method=RequestMethod.GET)
    public String index(Model model) {
        Photos.getInstance().clearPhotos();
        return "index";
    }

//    Дописать добавление фотографий (Photo) в лист (Photos)
    @RequestMapping(value="/photo", method=RequestMethod.POST)
    public String photoSubmit(@RequestParam("pathName") String pathName, Model model) {
        Photos photos = Photos.getInstance();
        StringBuilder message = new StringBuilder("");
        File destFolder = new File(pathName);
        photos.scanFolders(destFolder);
        message.append(photos.getCountPhotos());
        model.addAttribute("photos",photos.getPhotos());
        model.addAttribute("name",message);
        return "photo";
    }
}