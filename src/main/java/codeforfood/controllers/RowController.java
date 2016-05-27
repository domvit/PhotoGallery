package codeforfood.controllers;

import codeforfood.model.Photos;
import codeforfood.model.Styles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RowController {

  @RequestMapping("/photo/row/{string}")
  public String photoRow(@PathVariable String string, Model model) {
    Photos photos = Photos.getInstance();
    Styles styles = new Styles();
    styles.setRow(Integer.parseInt(string));
    StringBuilder message = new StringBuilder("");
    message.append(photos.getCountPhotos());
    model.addAttribute("style", styles);
    model.addAttribute("photos",photos.getPhotos());
    model.addAttribute("name",message);
    return "photo";
  }
}
