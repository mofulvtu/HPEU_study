package com.lzg.springBootDemo.filter;


import com.lzg.springBootDemo.Thread.VariableContainer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by liuzg on 2017/8/11
 */
public class MyFilter implements Filter {

    private String name;
    private Integer age;

    private static ThreadLocal<VariableContainer> threadLocal = new ThreadLocal<>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("==================过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("this is MyFilter,url :"+request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("=============过滤器销毁");
    }

    /**
     * 获取当前线程中绑定的变量容器   外部可以往容器中设值
     */
    public static VariableContainer getThreadInstance(){
        VariableContainer container = threadLocal.get();
        if (container==null){
            container = new VariableContainer();
            threadLocal.set(container);
        }
        return  container;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "VariableContainer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
