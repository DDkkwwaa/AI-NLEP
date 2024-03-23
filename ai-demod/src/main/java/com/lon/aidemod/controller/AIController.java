package com.lon.aidemod.controller;

import com.lon.aidemod.utils.AIUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class AIController {


    @RequestMapping(value = "/pic",method = RequestMethod.POST)
    public String PicToWords(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AIUtils.picToWords(file);
        System.out.println(res);
        return res;
    }
    @RequestMapping(value = "/img",method = RequestMethod.POST)
    public String imgRecognition(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AIUtils.imgRecognition(file);
        System.out.println(res);
        return res;
    }
    @RequestMapping(value = "/correction",method = RequestMethod.GET)
    public String correction1(@RequestParam("text") String text) {
        String res = AIUtils.correction(text);
        System.out.println(res);
        return res;
    }
    @RequestMapping(value = "/emo",method = RequestMethod.GET)
    public String emo(@RequestParam("text") String text) {
        String res = AIUtils.emo(text);
        System.out.println(res);
        return res;
    }


}
