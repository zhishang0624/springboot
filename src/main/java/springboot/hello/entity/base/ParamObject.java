package springboot.hello.entity.base;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import springboot.hello.util.AssertUtil;

/**
 * 请求参数对象
 * @author Administrator
 *
 */
public class  ParamObject  <T> implements Serializable{
	
	private HttpServletRequest req;
	
	private HttpServletResponse res;
	
	private HttpSession session;
	
	
	/**
	 * 参数map ,以K:V的数据结构存储
	 */
	private Map<String, Object> values;
	
	/**
	 * 通用类型实体
	 */
	private T entity;
	
	/**
	 * 需要调用的service名
	 */
	private String serviceName;
	
	/**
	 * 需要调用的方法名
	 */
	private String methodName;

	
	/**
	 * 用于缓存
	 */
	private String id;
	
	
	
	
	/**
	 * 向session设置返回消息
	 */
	public void setMsg(String msg) {
		if(this.session != null) {
			this.session.setAttribute("msg", msg);
		}
		
	}
	/**
	 * 根据KEY获取 参数的value
	 * @param valueKey
	 * @return
	 */
	public  Object  getValue(String valueKey) {
		return values.get(valueKey);
	}
	
	/****************************************************************************************************************
	 * setter and getter
	 * ****************************************************************************************************************
	 */
	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public HttpServletResponse getRes() {
		return res;
	}

	public void setRes(HttpServletResponse res) {
		this.res = res;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	
	
}
