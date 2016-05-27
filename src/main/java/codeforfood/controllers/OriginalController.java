package codeforfood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OriginalController {

  @RequestMapping("/photo/original")
  public String photoOriginal(String name, Model model) {
    model.addAttribute("name", name);
    return "original";
  }
}
