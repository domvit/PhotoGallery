package codeforfood.controllers;

import codeforfood.util.Photos;
import codeforfood.util.Styles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlackBackgroundController {

    /**
     *
     * @param model in Spring MVC
     * @return view with black background
     */
    @RequestMapping(value="photo/blackbackground")
    public String photoSubmit(Model model) {
        Photos photos = Photos.getInstance();
        Styles styles = new Styles();
        styles.setBackgroundColor("black");
        StringBuilder message = new StringBuilder("");
        message.append(photos.getCountPhotos());
        model.addAttribute("style", styles);
        model.addAttribute("photos",photos.getPhotos());
        model.addAttribute("name",message);
        return "photo";
    }
}
