package code4food.controllers;

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
    private static final String DISPLAY = "display";
    private static final String NO_DISPLAY = "nodisplay";

//     добавить в метод проверку на наличие загруженной галлереи и в
//     соответствии с результатом выставлять дисплей/нодисплей

    @RequestMapping(value="/photo", method=RequestMethod.GET)
    public String photo(Model model) {
        model.addAttribute("displayActionForm", DISPLAY);
        model.addAttribute("displayPhoto", NO_DISPLAY);
        return "photo";
    }

//    Дописать добавление фотографий (Photo) в лист (Photos)
    @RequestMapping(value="/photo", method=RequestMethod.POST)
    public String photoSubmit(@RequestParam("pathName") String pathName, Model model) {
        String error = "";
        File destFolder = new File(pathName);
        File targetFolder;
        try {
            targetFolder = File.createTempFile("temp_gallery_folder","");
            targetFolder.delete();
            targetFolder.mkdir();
            new PhotoGalleryServiceImpl().scanFolders(destFolder,targetFolder);
        } catch (IOException e) {
            error = e.toString();
        }
        model.addAttribute("name",error);
        model.addAttribute("displayActionForm", NO_DISPLAY);
        model.addAttribute("displayPhoto", DISPLAY);
        return "photo";
    }
}