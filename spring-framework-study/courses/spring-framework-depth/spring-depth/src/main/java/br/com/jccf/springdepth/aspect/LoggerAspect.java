package br.com.jccf.springdepth.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {}

    @Before("executeLogging()")
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();

        if (null != args && args.length > 0) {
            message.append(" args=[ |");
            Arrays.asList(args).forEach(arg -> {
                message.append(arg).append(" | ");
            });
            message.append("]");
        }
        LOGGER.info(message.toString());
    }
}
