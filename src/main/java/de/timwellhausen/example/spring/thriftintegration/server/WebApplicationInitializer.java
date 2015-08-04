package de.timwellhausen.example.spring.thriftintegration.server;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.thrift.server.TServlet;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // Setup Spring
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringConfiguration.class);
        rootContext.refresh();
        servletContext.addListener(new ContextLoaderListener(rootContext));
        LoggerFactory.getLogger(WebApplicationInitializer.class).info("Spring setup done.");

        // Register Thrift servlet as endpoint
        TServlet thriftServlet = rootContext.getBean("thriftServlet", TServlet.class);
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("apiServlet", thriftServlet);
        servletRegistration.setLoadOnStartup(2);
        servletRegistration.addMapping("/api");
        LoggerFactory.getLogger(WebApplicationInitializer.class).info("Registered Thrift servlet.");
    }
}
