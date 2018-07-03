package com.work.finance.controller.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.work.finance.entity.User;
import com.work.finance.service.UserService;
import com.work.finance.util.Result;
import com.work.finance.util.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;

@ControllerAdvice
public class BaseController {
	private static final Logger l = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	private UserService userService;
	public User getUser(String workNo) {
		return userService.selectByWorkNo(workNo);
	}
	/**
	 * 登录异常
	 * @param request
	 * @param response
	 * @return
	 */
    public String authenticationException(HttpServletRequest request, HttpServletResponse response) {
		boolean isAjaxRequest = isAjaxRequest(request);
    	l.error("没有登录异常,是否ajax请求:{}",isAjaxRequest);
    	if(isAjaxRequest){
    		Result<String> result = new Result<String>();
    		result.setStatus(ResultStatus.NO_LOGIN);
    		try {
    			response.setCharacterEncoding("UTF-8");
    			PrintWriter pw = response.getWriter();
        		pw.write(new ObjectMapper().writeValueAsString(result));
        		pw.flush();
        		pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
    		return null;
    	}
    	return "login";
    }
	
	/**
     * 权限异常
     */
    public String authorizationException(HttpServletRequest req, HttpServletResponse response) {
    	
    	boolean isAjaxRequest = isAjaxRequest(req);
    	l.error("没有权限异常,是否ajax请求:{}",isAjaxRequest);
    	if(isAjaxRequest){
    		Result<String> result = new Result<String>();
    		result.setStatus(ResultStatus.NO_PERMISSION);
    		try {
    			response.setCharacterEncoding("UTF-8");
    			PrintWriter pw = response.getWriter();
        		pw.write(new ObjectMapper().writeValueAsString(result));
        		pw.flush();
        		pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
    		return null;
    	}
    	
    	return "error/403";
    }
    
    @ExceptionHandler(ServletException.class)
    public String servletException(HttpServletRequest request, HttpServletResponse response) {
    	l.error("找不到页面");
    	return "error/404";
    }
    
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result<String> bindException(final BindException e){
    	l.error("参数错误异常:{}",e.getMessage());
    	Result<String> result = new Result<String>();
    	result.setStatus(ResultStatus.PARAMS_ERROR);
    	return result;
    }

	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public Result<String> sqlException(final Exception e){
		e.printStackTrace();
		l.error("系统异常:{}",e.getMessage());
		Result<String> result = new Result<String>();
		result.setStatus(ResultStatus.FAIL);
		result.setContent("database error!");
		return result;
	}

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> defaultException(final Exception e){
    	e.printStackTrace();
    	l.error("系统异常:{}",e.getMessage());
    	Result<String> result = new Result<String>();
    	result.setStatus(ResultStatus.FAIL);
		if(e.getMessage().contains("where")||e.getMessage().contains("select")){
			result.setContent("data base exe error!");
		}else {
			result.setContent(e.getMessage());
		}
    	return result;
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {  
        String requestedWith = request.getHeader("x-requested-with");  
        if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {  
            return true;  
        } else {  
            return false;  
        }  
    }
    
}
