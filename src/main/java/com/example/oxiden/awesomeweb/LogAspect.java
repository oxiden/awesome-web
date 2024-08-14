package com.example.oxiden.awesomeweb;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Before("execution(* com.example.oxiden.awesomeweb.contoller.StatusController.s*(..))")
	public void logStart(JoinPoint jp) {
		logger.info("処理開始:" + jp.getSignature());
	}

	@After("execution(* com.example.oxiden.awesomeweb.contoller.**.*(..))")
	public void logEnd(JoinPoint jp) {
		logger.info("処理終了:" + jp.getSignature());
	}

	@AfterReturning("bean(todoController)")
	public void cleanup() {
		logger.info("method completed normally.");
	}

	@AfterThrowing("bean(*Controller)")
	public void abend() {
		logger.error("method completed abnormally.");
	}
}
