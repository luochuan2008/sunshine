package red.lixiang.tools.base;

import red.lixiang.tools.base.annotation.EnhanceTool;
import red.lixiang.tools.jdk.StringTools;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 只提供一些方法
 *
 * @author lixiang
 * @date 2020/3/16
 **/
public interface CommonModel {

    /**
     * 对当前实体类的处理
     * @return
     */
    default public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            EnhanceTool enhanceTool = field.getAnnotation(EnhanceTool.class);
            if(enhanceTool !=null && enhanceTool.skipToMap()){
                continue;
            }
            Object obj;
            try {
                obj = field.get(this);
                String keyName =(enhanceTool!=null && StringTools.isNotBlank(enhanceTool.mapKey()))?
                        enhanceTool.mapKey():mapKey(field.getName());

                if(obj == null){
                    continue;
                }
                if(obj.getClass()==String.class){
                    map.put(keyName, String.valueOf(obj));
                }else {
                    map.put(keyName, obj);
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 对key需不需要特殊处理
     * @param s
     * @return
     */
    default String mapKey(String s){
        return s;
    }
}
