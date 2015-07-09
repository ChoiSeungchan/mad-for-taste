package org.kosta.madfortaste.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class mostSearchedAop {
	private Logger log=LoggerFactory.getLogger(getClass());
	
	@Around("execution(public * org.kosta.madfortaste.common..*.*(..))")
	public Object mostSearched(ProceedingJoinPoint pp) throws Throwable{
		System.out.println("aop 적용대상");
		Object []obj=pp.getArgs();
		for(Object o : obj)
			log.info("입력받은 값: "+o);
		return pp.proceed();
	}
}
