package zj.test.base;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lzj
 * @date 2018/4/27
 */
public abstract class TestBaseRoot {


    protected void printJSONString(Object o) {
        System.err.println(JSON.toJSONString(o));
    }

    protected void printCollection(Collection<Object> col) {
        for (Object o : col) {
            System.err.println(ToStringBuilder.reflectionToString(o));
        }
    }

    protected void printMap(Map<Object, Object> map) {
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.err.println(ToStringBuilder.reflectionToString(entry));
        }
    }

    //反射调用setter设置为 name + index
    protected void reflectSetter(Class<?> clazz, Object target, int index) {
        try {
            Method[] methods = clazz.getDeclaredMethods();
            Class type;
            Object value;
            String methodName;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Method method : methods) {
                methodName = method.getName();
                if (methodName.startsWith("set")) {
                    type = method.getParameterTypes()[0];
                    //处理两种日期格式
                    if (type == Date.class) {
                        value = new Date();
                    } else if (type == Timestamp.class) {
                        value = new Timestamp(new Date().getTime());
                    } else if (type == String.class) {
                        //id取纯数字
                        if (methodName.contains("id") || methodName.contains("Id") || methodName.contains("No") || methodName.contains("Sn") || methodName.contains("Code") || methodName.contains("Status")) {
                            value = index + 1 + "" + index;
                        } else if (method.getName().contains("Time") || method.getName().contains("Date")) {
                            //时间取时间字符串
                            value = sdf.format(new Date());
                        } else {
                            value = methodName.substring(3) + index;
                        }
                    } else if (type == Boolean.class) {
                        value = true;
                    } else if (type.isPrimitive()) {
                        value = index;
                    } else {
                        value = null;
                    }
                    method.invoke(target, value);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    //构造随机List
    protected <E> List<E> reflectList(Class<E> clazz, int size) {
        List<E> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            try {
                E p = clazz.newInstance();
                this.reflectSetter(clazz, p, i);
                list.add(p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
