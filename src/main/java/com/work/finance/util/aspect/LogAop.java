package com.work.finance.util.aspect;

import com.work.finance.entity.Log;
import com.work.finance.mapper.LogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;

/**
 * 日志记录aop
 * @author Jat
 *
 */
@Aspect
@Order(-1)
@Configuration
public class LogAop {
	
	@Autowired
	private LogMapper logMapper;
	
	@Pointcut("@annotation(com.work.finance.util.aspect.ServiceLog)")
	public void serviceLog(){}
	
	
	@AfterReturning(pointcut="serviceLog()",returning="result")
	public void serviceLogs(JoinPoint joinPoint,Object result) throws Throwable{
        String des = getMethodDes(joinPoint);
        Log log = new Log();
        log.setType(des);
        log.setClassName(joinPoint.getSignature().getDeclaringTypeName());
        log.setMethodName(joinPoint.getSignature().getName());
        StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < joinPoint.getArgs().length; i++){
			sb.append("params"+i+":");
			sb.append(joinPoint.getArgs()[i]);
		}
		log.setParams(sb.toString());
		log.setResult(result.toString());
//		log.setCreatorId(user.getId());
		this.logMapper.insert(log);
	}
	
	@SuppressWarnings("rawtypes")
	public String getMethodDes(JoinPoint joinPoint) throws ClassNotFoundException{
		String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(ServiceLog.class).des();    
                     break;    
                }    
            }    
        } 
        return description;
	}
	
}
