package ir.amirhosseinsalari.simplelogger.interceptor;

import ir.amirhosseinsalari.simplelogger.config.LoggableApi;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class ControllerLogAspect {

    private static final Logger LOGGER = Logger.getLogger(ControllerLogAspect.class);

    @Around("@annotation(loggableApi)")
    public Object logAroundController(ProceedingJoinPoint joinPoint,LoggableApi loggableApi) throws Throwable {
        HttpServletRequest request =  ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Object result = joinPoint.proceed();
        ResponseEntity response = ((ResponseEntity) result);
        LOGGER.info("Request for ===> " + request.getRequestURI());
        LOGGER.info("Response  is ===> " + response.toString());
        return result;
    }
}
