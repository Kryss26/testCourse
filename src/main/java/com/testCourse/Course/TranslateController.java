package com.testCourse.Course;

import com.testCourse.Course.services.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TranslateController {

    @Autowired
    TranslateService translateService;

    @RequestMapping("/translate/{phrase}")
    public String translate(@PathVariable String phrase, Model model) {
        String translatedText = translateService.getTraduction(phrase);
        model.addAttribute("phrase", phrase);
        model.addAttribute("translatedText", translatedText);
        return "traduction";
    }

}
