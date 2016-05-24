package code4food.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class RowController {

  @RequestMapping("/photo/row/{string}")
  public String photoRow(@PathVariable String string, String name, Model model) {
    name = "Row  = "+string;
    model.addAttribute("name", name);
    return "photo";
  }
}
