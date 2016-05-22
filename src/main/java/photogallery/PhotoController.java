package photogallery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by HiMan on 22.05.2016.
 */
@Controller
public class PhotoController {

    @RequestMapping("/photo")
    public String photo(String name, Model model) {
        name = "PhotoGallery";
        model.addAttribute("name", name);
        return "photo";
    }

    @RequestMapping("/photo/original")
    public String photoOriginal(String name, Model model) {
        model.addAttribute("name", name);
        return "photo";
    }

    @RequestMapping("/photo/row/{string}")
    public String photoRow(@PathVariable String string,String name, Model model) {
        name = "Row  = "+string;
        model.addAttribute("name", name);
        return "photo";
    }
}