package com.lon.aidemod.utils;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AIUtils {
    public static final String APP_ID = "56778375";
    public static final String API_KEY = "fCXWVHaNDDcLaJ8myqSXCcZi";
    public static final String SECRET_KEY = "BessmqHpOs7Hbe73R0J4saxtNJd1txrt";
    public static final String APP_ID_img = "56921798";
    public static final String API_KEY_img = "hIuhnbRosYt67m7LMTKrqc4s";
    public static final String SECRET_KEY_img = "I3ZXrhCnrWuic8ORSgpWESslzqloFpBs";

    public static final String APP_ID_NLP = "57373313";
    public static final String API_KEY_NLP = "TWwGTDtXNJQJg8R08YBlU6TT";
    public static final String SECRET_KEY_NLP = "DJ7e68yMCuHWYPi0qj5DiqkLp1xlLxbZ";
    public static String picToWords(MultipartFile file) throws IOException {
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
//        String path = "C:/Users/LON/Desktop/test.png";
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray wordsResult = res.getJSONArray("words_result");

        String result = "";
        for (int i = 0; i < wordsResult.length(); i++) {
            JSONObject jsonObject = wordsResult.getJSONObject(i);
            Object words = jsonObject.get("words");
            String s = (String) words;
            result += s + "";
        }
//        System.out.println(res.toString(2));

        return result;
    }

    public static String imgRecognition(MultipartFile file) throws IOException{
        AipImageClassify client = new AipImageClassify(APP_ID_img, API_KEY_img, SECRET_KEY_img);


        // 调用接口
        JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());

        System.out.println(res.toString(2));
        return res.toString();
    }

    public static String correction(String text){
        AipNlp client = new AipNlp(APP_ID_NLP, API_KEY_NLP, SECRET_KEY_NLP);

        // 传入可选参数调用接口
        HashMap<String, Object> options11 = new HashMap<String, Object>();

        // 文本纠错
        JSONObject res11 = client.ecnet(text, options11);
        return res11.toString(2);
    }
    public static String emo(String text){
        AipNlp client = new AipNlp(APP_ID_NLP, API_KEY_NLP, SECRET_KEY_NLP);


        // 传入可选参数调用接口
        HashMap<String, Object> options12 = new HashMap<String, Object>();
        options12.put("scene", "talk");

        // 对话情绪识别接口
        JSONObject res12 = client.emotion(text, options12);

        return res12.toString(2);
    }
}
