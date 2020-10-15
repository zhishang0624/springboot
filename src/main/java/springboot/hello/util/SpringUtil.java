package springboot.hello.util;

import org.springframework.context.ApplicationContext;

/**
 * spring工具类
 * @author Administrator
 *
 */
public class SpringUtil {
	private static ApplicationContext context;
	
	
	public  static synchronized ApplicationContext getContext() {
		return context;
	}
	
	public static void setContext(ApplicationContext ctx) {
		context = ctx;
	}
}
