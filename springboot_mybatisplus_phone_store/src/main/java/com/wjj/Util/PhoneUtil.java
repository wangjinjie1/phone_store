package com.wjj.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneUtil {
    public static List<Map<String, String>> createTag(String tag){
        String[] tags = tag.split("&");
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < tags.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name",tags[i]);
            list.add(map);
        }
        return list;
    }
}
