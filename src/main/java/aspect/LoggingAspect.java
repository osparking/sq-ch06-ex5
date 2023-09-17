package aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import space.jbpark.utility.MyUtil;

@Aspect
public class LoggingAspect {
	private Logger logger = MyUtil.getLogger(LoggingAspect.class.getName());
	
	private String getMethodSpec(ProceedingJoinPoint joinPoint) {
		var sb = new StringBuilder("차단된 메소드 명세 - ");
		sb.append(System.lineSeparator());
		sb.append("\t메소드명: ");
		sb.append(joinPoint.getSignature().getName());
		sb.append(System.lineSeparator());
		sb.append("\t인자목록: ");
		sb.append(Arrays.asList(joinPoint.getArgs()));
		return sb.toString();
	}
	
	@Around("execution (* services.*.*(..))")
	public void log(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info(getMethodSpec(joinPoint));
		joinPoint.proceed();
	}
}
