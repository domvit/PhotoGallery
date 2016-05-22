package photogallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

@Controller
public class PhotoController {

    @RequestMapping("/photo")
    public String photo(String name, Model model) {
        name = "PhotoGallery";
        model.addAttribute("name", name);
        File dir1 = new File("g:\\1");
        File dir2 = new File("g:\\2");
//        проверочка сканфолдера
        scanFolders(dir1,dir2);
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

    private void scanFolders(File scanfolder, File destinationFolder) {
        File[] files = scanfolder.listFiles();
        for(File file:files){
            if (file.isDirectory()){
                scanFolders(file, destinationFolder);
            }else {
                if (file.getName().toLowerCase().endsWith(".png")) {
                    String filePath = file.getPath();
                    System.out.println(filePath + "   " + destinationFolder.getPath()+"\\"+file.getName());
                    try {
                        Files.copy(file.toPath(),new File(destinationFolder.getPath()+"\\"+file.getName()).toPath());
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
            }
        }
    }

}