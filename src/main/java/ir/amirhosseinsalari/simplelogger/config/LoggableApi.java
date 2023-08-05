package ir.amirhosseinsalari.simplelogger.config;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggableApi {
}
