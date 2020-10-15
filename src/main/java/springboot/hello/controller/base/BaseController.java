package springboot.hello.controller.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import springboot.hello.entity.base.ParamObject;
import springboot.hello.util.AssertUtil;

public class BaseController {
	
	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;
	
	private static Logger log = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * 把request  response  session 注入controller
	 * @param request
	 * @param response
	 */
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){

		this.request = request;

		this.response = response;

		this.session = request.getSession();

	}
	
	/**
	 * 获得参数对象
	 */
	protected ParamObject getParamObject() {
		ParamObject po = null;
		String inputStr = getInputStr();
		if(!AssertUtil.isNull(inputStr)) {
			return po;
		}
		System.out.println(inputStr);
		//封装param到paramObject
		po = parseParams(inputStr);
		
		po.setReq(this.request);
		po.setRes(this.response);
		po.setSession(this.session);
		this.session.removeAttribute("msg");
		
		return po;
	}
	
	/**
	 * get方式
	 * @return
	 */
	protected ParamObject getParamObjectGet() {
		ParamObject po = null;
		//获取所有的param
		Enumeration<String> parameterNames = request.getParameterNames();
		

		
		if(!AssertUtil.isNull(get("serivceName"))  || !AssertUtil.isNull(get("methodName"))) {
			return po;
		}
	    po = new ParamObject();
	    po.setServiceName(get("serivceName"));
	    po.setMethodName(get("methodName"));
	    
	    //添加更多的参数
		//设置valuemap
		Map<String, Object> paramMap = new HashMap<String, Object>();
		while(parameterNames.hasMoreElements()) {
		String nextElement = parameterNames.nextElement();
		if( !nextElement.equals("serivceName")  && !nextElement.equals("methodName") ) {
			paramMap.put(nextElement, get(nextElement));
		}
		}
		po.setValues(paramMap);
		
		
		return po;
	}
	
	/**
	 * 解析json到paramobj
	 * @param <T>
	 * @param inputStr
	 */
	private <T> ParamObject parseParams(String inputStr) {
		try {
			JSONObject json = new JSONObject(inputStr);
			if(!json.has("serviceName") ||  !json.has("methodName")) {
				return null;
			}
			
			ParamObject param = new ParamObject<T>();
			param.setServiceName(json.getString("serviceName"));
			param.setMethodName(json.getString("methodName"));
			
			JSONObject params =  json.getJSONObject("params");
			//设置valuemap
			Map<String, Object> paramMap = new HashMap<String, Object>();
			Iterator ite = params.keys();
			ite.forEachRemaining(obj  ->{
				try {
					//设置id 用于缓存
					if(obj.equals("id")) {
						param.setId( params.getString((String) obj));
					}
					paramMap.put((String) obj, params.getString((String) obj));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			});
			param.setValues(paramMap);
			
//			ZhangSan zs = BeanUtil.buildEntity(ZhangSan.class, param.getValues());
		
			return param;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	private String getInputStr() {
		StringBuilder sb=null;
		try {
			InputStream in = request.getInputStream();
			InputStreamReader ir = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(ir);
		     sb = new StringBuilder();
			String str = null;
			while((str = br.readLine()) != null) {
				sb.append(str);
			}
//			System.out.println(sb.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("获取参数失败");
			log.error("-2", "method调用错误"+ e.getStackTrace());
			e.printStackTrace();
		}
		return sb == null ? null : sb.toString();
	}
	
	
	
	public static void main(String[] args) throws JSONException, InstantiationException, IllegalAccessException {
		
		String str = "{serviceName:\"sfdas\",methodName:\"Flintstone\" ,params:{	id:1,	name : \"张三\",	age : 15,	salary : 2000.8 , bir : \"2020-10-01\"	}	}";
		JSONObject json = new JSONObject(str);

		System.out.println(json.getJSONObject("params"));
		long start =System.currentTimeMillis();
    	
		JSONObject params =  json.getJSONObject("params");
//		ZhangSan zs = JsonUtil.parseJson(params.toString()  , ZhangSan.class);
		
//		ZhangSan zs = BeanUtil.buildEntity(ZhangSan.class, params);
		long end =System.currentTimeMillis();
		System.out.println(params);
		
		System.out.println(end  - start);
	}
	
	private String get(String key) {
		return this.request.getParameter(key);
	}
} 
