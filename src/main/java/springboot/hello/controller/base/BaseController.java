package springboot.hello.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;
	
	
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
}
