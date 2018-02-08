package sample.data.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 转换工具类
 */
public class ConvertUtil {

    public static <T> List<T> listToList(List<? extends Object> list, Class<T> clazz) {
        List<T> voList = new ArrayList();
        if (CollectionUtils.isEmpty(list)) {
            return voList;
        } else {
            Iterator i$ = list.iterator();

            while (i$.hasNext()) {
                Object dto = i$.next();
                T vo = objectToObject(dto, clazz);
                if (null != vo) {
                    voList.add(vo);
                }
            }

            return voList;
        }
    }

    public static <T> T objectToObject(Object dto, Class<T> clazz) {
        try {
            Class<?> classType = Class.forName(clazz.getName());
            Object vo = classType.newInstance();
            return (T) conversion(dto, vo);
        } catch (ClassNotFoundException var4) {
            var4.printStackTrace();
        } catch (InstantiationException var5) {
            var5.printStackTrace();
        } catch (IllegalAccessException var6) {
            var6.printStackTrace();
        }

        return null;
    }

    public static Object conversion(Object from, Object to) {
        if (null == from) {
            return null;
        } else {
            try {
                BeanUtils.copyProperties(from, to);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return to;
        }
    }
}
