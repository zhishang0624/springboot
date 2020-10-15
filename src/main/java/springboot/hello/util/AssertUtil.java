package springboot.hello.util;

/**
 * 断言类
 * @author Administrator
 *
 */
public class AssertUtil {
	
	/**
	 * 判断字符串不为空
	 * @param obj
	 * @return
	 */
	public static boolean isNull(String obj) {
		
		if(obj == null || "".equals(obj)) {
			return false;
		}
		
		return true;
	}
}
