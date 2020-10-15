package springboot.hello.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jni.Thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.hello.controller.base.BaseController;
import springboot.hello.entity.ZhangSan;
import springboot.hello.entity.base.ParamObject;
import springboot.hello.entity.base.ResObj;
import springboot.hello.service.ZhangSanService;
import springboot.hello.util.AssertUtil;
import springboot.hello.util.SpringUtil;



@RestController
//@Scope("prototype")
public class HelloController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
    private ApplicationContext applicationContext;



	@RequestMapping(value="/serviceCall",method = RequestMethod.GET)
	@ResponseBody
	public Object servicecall() {
		ParamObject po =  getParamObjectGet();
		if(po == null) {
			return ResObj.build("-1", "参数解析错误");
		}
		//动态调用方法
		Object res = invokeMethod(po);
		return res;
	}
	
	
	@RequestMapping("/serviceCtl")
	@ResponseBody
	public Object serviceCtl() {
		ParamObject po =  getParamObject();
		if(po == null) {
			return ResObj.build("-1", "参数解析错误");
		}
		//动态调用方法
		Object res = invokeMethod(po);
		return res;
	}
	
	/**
	 * 动态调用方法
	 * @param po
	 * @return
	 */
	private Object invokeMethod(ParamObject po) {
		//根据参数调用相应的方法
				Object service = applicationContext.getBean(po.getServiceName());
				if(service != null) {
					try {
						
						Method method = service.getClass().getDeclaredMethod(po.getMethodName(), po.getClass());
//						return method.invoke(service, po);
						ResObj res = ResObj.build("1", "调用成功",method.invoke(service, po));
						
						Object msg = session.getAttribute("msg");
						if(msg != null) {
							res.setMsg((String) msg);
						}
						return res;
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						String msgstr = "";
						Object msg = session.getAttribute("msg");
						if(msg != null) {
							msgstr = (String) msg;
						}
						log.error("-2method调用错误:" + msgstr,e);
						
						return ResObj.build("-2", "method调用错误:" + msgstr);
					}
				}else {
					log.error("-3", "service调用错误 未找到service");
					return ResObj.build("-3", "service解析错误");
				}
				
	}
	
	@RequestMapping("/hello")
	public <T> T hello(@RequestParam(value = "333")String name){//333是必须填参数
		System.out.println(this.getClass().getClassLoader());
		
		return (T) name;
	}
	
	public static void main(String[] args) {
		log.debug("ssss");
	}
}
