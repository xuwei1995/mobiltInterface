package cn.wxic.mobileinternet.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UtilHelper {
    private static UtilHelper instance ;

    private UtilHelper(){

    }

    public static  UtilHelper getInstance(){
        if (instance == null) {
            synchronized (UtilHelper.class){
                if (instance == null) {
                    instance = new UtilHelper() ;
                }
            }
        }
        return instance ;
    }

    public Map<String,Object> success(Object info){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("status","success");
        map.put("info",info);
        return map;
    }
    public Map<String,Object> error(Object info){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("status","error");
        map.put("errorCause",info);
        return map;
    }
    //随机文件名
    public String generateFileName(String fileName, String index)
    {
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重命名图片
        fileName = index + System.currentTimeMillis() + "-" + getRandom(4) + suffixName;
        return   fileName;
    }
    public static String getRandom(int n){
        Random random = new Random();
        String result = "";
        for(int i = 0;i < n;i++){
            result+=random.nextInt(10);
        }
        return result;
    }
}
