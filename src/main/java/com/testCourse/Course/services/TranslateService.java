package com.testCourse.Course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

class ResponseData {
    public String translatedText;
}

class Traduction {
    public ResponseData responseData;
}

@Service
public class TranslateService {

    @Autowired
    RestTemplate restTemplate;

    public String getTraduction(String phrase) {
        String url = "https://api.mymemory.translated.net/get?q=" + phrase + "&langpair=es|en";
        Traduction json = restTemplate.getForObject(url, Traduction.class);
        return json.responseData.translatedText;

    }
}
