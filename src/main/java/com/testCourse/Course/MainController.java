package com.testCourse.Course;

import java.util.Map;

import com.testCourse.Course.models.CarModel;
import com.testCourse.Course.services.CarBDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MainController {

    @Autowired
    CarBDService carBDService;

    @GetMapping("/count/{word}")
    public String countVocalConsonant(@PathVariable String word) {

        int countVocals = 0;
        int countConsonants = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
                    || word.charAt(i) == 'u') {
                countVocals++;
            } else {
                countConsonants++;
            }
        }

        return "The word inserted has " + countVocals + " VOCALS " + countConsonants + " CONSONANTS";

    }

    @GetMapping("/")
    public String salute(){
        return "Greetings"+
                "<br>"+
                "Here are the instructions to use this Web Application"+
                "<br>"+
                "/count/{word} -> Counts consonants and vocals, {word} is a parameter to type"+
                "<br>"+
                "/listCars -> Show a list of the cars inserted"+
                "<br>"+
                "/{text} -> Encrypts a message, {text} is a parameter to type"
                +"<br>"+
                "/translate/{phrase} -> Translate in English a {phrase} inserted in Spanish"
                +"<br>"+
                "/CarFormulary -> Will lead you to a formulary for insert data into the database"
        ;
    }
    @GetMapping("/listCars")
    public String cars() {
        return carBDService.getAllCars().toString();
    }

    @PostMapping("/insertCar")
    public String insertCar(@RequestParam Map<String, String> body) {
        System.out.println(body.get("name"));
        CarModel car = new CarModel();
        car.setBrand(body.get("name"));
        car.setModel(body.get("model"));
        car.setHP(Integer.parseInt(body.get("horsepower")));
        carBDService.saveCar(car);
        return "Data Saved";
    }

    @GetMapping("/{text}")
    public String encryptText(@PathVariable String text) {
        String encryptedMessage = "";

        for (int i = 0; i < text.length(); i++) {

            int number = text.charAt(i);

            if (number == 'a') {
                number = 33;
            }

            else if (number == 'z') {
                number = 47;
            }

            else {
                number = (char) number + 33 + 1;
            }

            encryptedMessage += (char) number;
        }

        return encryptedMessage;
    }

}