package com.lon.aidemod.test;


import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "56921798";
    public static final String API_KEY = "hIuhnbRosYt67m7LMTKrqc4s";
    public static final String SECRET_KEY = "I3ZXrhCnrWuic8ORSgpWESslzqloFpBs";

    public static void main(String[] args) {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);


        // 调用接口
        String path = "C:/Users/LON/Desktop/test1.png";
        JSONObject res = client.advancedGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}
