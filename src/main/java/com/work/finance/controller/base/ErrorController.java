package com.work.finance.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

	private static final String ERROR_PATH = "/error";  
	
	@RequestMapping(value=ERROR_PATH)  
    public String handleError(){  
        return "index";
    } 
    
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
