package code4food.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/photo")
public class PhotoController {

    @RequestMapping("/photo")
    public String photo(String name, Model model) {
        name = "PhotoGallery";
        model.addAttribute("name", name);
        //File dir1 = new File("g:\\1");
        //File dir2 = new File("g:\\2");
//        проверочка сканфолдера
        //scanFolders(dir1,dir2);
        return "photo";
    }
}