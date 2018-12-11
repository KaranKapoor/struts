package org.superbiz.struts;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean struts2FilterDispatcher() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.addInitParameter("actionPackages", "com.lq");
        filterRegistrationBean.setOrder(0);

        Filter filter = new org.apache.struts2.dispatcher.FilterDispatcher();
        filterRegistrationBean.setFilter(filter);

        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean strutsCleanupFilterDispatcher() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setOrder(1);

        Filter filter = new org.apache.struts2.dispatcher.ActionContextCleanUp();
        filterRegistrationBean.setFilter(filter);

        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean sitemeshFilterDispatcher() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setOrder(2);

        Filter filter = new com.opensymphony.module.sitemesh.filter.PageFilter();
        filterRegistrationBean.setFilter(filter);

        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
