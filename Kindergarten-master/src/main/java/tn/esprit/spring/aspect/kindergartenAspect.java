package tn.esprit.spring.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
@Aspect

public class kindergartenAspect {
	@Before("execution(public String getName())")
	public void getNameAdvice(){
		System.out.println("Executing Advice on getName()");
	}
	
	@Before("execution(* tn.esprit.spring.service.*.get*())")
	public void getAllAdvice(){
		System.out.println("Service method getter called");
	}
}
