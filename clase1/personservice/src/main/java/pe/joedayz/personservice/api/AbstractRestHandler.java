package pe.joedayz.personservice.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import pe.joedayz.personservice.domain.RESTAPIErrorInfo;
import pe.joedayz.personservice.exception.HTTP400Exception;
import pe.joedayz.personservice.exception.HTTP404Exception;

import javax.servlet.http.HttpServletResponse;


/**
 * This class is used as a super class to be extended by all REST API
 * "controllers".
 */
public abstract class AbstractRestHandler implements ApplicationEventPublisherAware {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    protected ApplicationEventPublisher eventPublisher;
    protected static final String DEFAULT_PAGE_SIZE = "100";
    protected static final String DEFAULT_PAGE_NUM = "0";

    @Autowired
    CounterService counterService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HTTP400Exception.class)
    public @ResponseBody RESTAPIErrorInfo handleDataStoreException(HTTP400Exception ex, WebRequest request,
                                                                   HttpServletResponse response) {
        log.info("Converting Data Store exception to RestResponse : " + ex.getMessage());
        counterService.increment("pe.joedayz.personservice.http.400.count");
        return new RESTAPIErrorInfo(ex, "You messed up.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HTTP404Exception.class)
    public @ResponseBody RESTAPIErrorInfo handleResourceNotFoundException(HTTP404Exception ex, WebRequest request,
                                                                          HttpServletResponse response) {
        log.info("ResourceNotFoundException handler:" + ex.getMessage());
        counterService.increment("pe.joedayz.personservice.http.404.count");
        return new RESTAPIErrorInfo(ex, "Sorry I couldn't find it.");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public static <T> T checkResourceFound(final T resource) {
        if (resource == null) {
            throw new HTTP404Exception("resource not found");
        }
        return resource;
    }

}
