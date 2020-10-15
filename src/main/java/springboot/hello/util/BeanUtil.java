package springboot.hello.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import springboot.hello.entity.ZhangSan;
import springboot.hello.entity.base.ParamObject;


/**
 * 操作bean的工具类
 * @author Administrator
 *
 */
public class BeanUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static<T> T  buildEntity(Class<T> type , String json) throws Exception {
		return buildEntity(type , new JSONObject(json) );
	}
	
	/**
	 * 根据json匹配bean生成实例
	 * @param <T>
	 * @param type bean类型
	 * @param json json字符串
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static<T> T  buildEntity(Class<T> type , JSONObject json) throws Exception {
		T t = type.newInstance();
		Field[] fs =  type.getDeclaredFields();
		for(Field f : fs) {
			if(json.has(f.getName())) {
				try {
					setValue(t , f , json.getString(f.getName()));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return t;
	}
	
	public static<T> T  buildEntity(Class<T> type , Map map) throws InstantiationException, IllegalAccessException {
		T t = type.newInstance();
		Field[] fs =  type.getDeclaredFields();
		for(Field f : fs) {
			if(map.containsKey(f.getName())) {
				try {
					setValue(t , f , (String) map.get(f.getName()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return t;
	}
	/**
	 * 反射赋值
	 * @param o
	 * @param f
	 * @param value
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws ParseException 
	 */
	private static void setValue(Object o,Field f, String value) throws IllegalArgumentException, IllegalAccessException, ParseException {
		if(!AssertUtil.isNull(value)) {
			return;
		}
		f.setAccessible(true);
		Class c = f.getType();
			
			if(c.equals(BigDecimal.class)) {
				f.set(o, new BigDecimal(value));
			}else if(c.equals(String.class)) {
				f.set(o, value);
			}else if(c.equals(Date.class)) {
				f.set(o, sdf.parse(value));
			}
			
	}
	
	public static void main(String[] args) {
	}

	
	/**
	 * 实例化paramobj内部的bean
	 * @param <T>
	 * @param class1
	 * @param paramObject
	 * @throws ParseException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T> void buildEntity(Class<T> class1, ParamObject<T> paramObject) throws IllegalArgumentException, IllegalAccessException, ParseException, InstantiationException   {
			T newInstance = class1.newInstance();
			
			Field[] declaredFields = newInstance.getClass().getDeclaredFields();
			
			Map paramMap = paramObject.getValues();
			for (int i = 0; i < declaredFields.length; i++) {
				Field field = declaredFields[i];
				String val = (String) paramMap.get(field.getName());
				if(paramMap.containsKey(field.getName())) {
					setValue(newInstance , field  , val);
				}
				
			}
			
			
			
			paramObject.setEntity(newInstance);
	}

	
	

}
