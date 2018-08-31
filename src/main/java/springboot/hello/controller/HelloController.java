package springboot.hello.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jni.Thread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.hello.controller.base.BaseController;



@RestController
public class HelloController extends BaseController{
	
	static Object target;

	@RequestMapping("/")
	public String index() {
		System.out.println(request);
		System.out.println(response);
		System.out.println(session);
		if(target == null) {
			target = this;
		}else {
			System.out.println("是同一个对象吗？" + target.equals(this));
			System.out.println("是同一个对象吗？" + (target == this));
			
		}
		return "hello spring boot";
	}
	@RequestMapping("/aa")
	public Object aa(String aaa) {
		System.out.println(aaa);
		Map<String, Object> map = new HashMap<>();
		map.put("sssss", 213331231);
		return map;
	}
	
	@RequestMapping("/hello")
	public <T> T hello(@RequestParam(value = "333")String name){
		System.out.println(this.getClass().getClassLoader());
		
		return (T) name;
	}
}
