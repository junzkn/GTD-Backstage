package com.jun.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtils {
    public static String toJson (Object data){
        return JSONObject.toJSONString(data,SerializerFeature.WriteMapNullValue);
    }
}
