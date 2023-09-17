package aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import space.jbpark.utility.MyUtil;

@Aspect
public class LoggingAspect {
	private Logger logger = MyUtil.getLogger(LoggingAspect.class.getName());
	
	@AfterReturning(value = "@annotation(ToLog)",
			returning = "returnValue")
	public void log(Object returnValue) throws Throwable {
		logger.info("반환된 값: " + returnValue);
	}
}
