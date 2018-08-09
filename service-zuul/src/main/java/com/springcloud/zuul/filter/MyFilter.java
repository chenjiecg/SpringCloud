package com.springcloud.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 
 * @author xiaoH
 * @date 2018年8月9日
 * @Description
 */
@Component
public class MyFilter extends ZuulFilter {
	
	private static final Logger log = LoggerFactory.getLogger(MyFilter.class);
	
	/**
	 * 过滤器的具体逻辑，可用很复杂，包括查SQL、nosql去判断该请求到底有没有权限访问
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if(accessToken == null) {
			log.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		log.info("ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		//可以写逻辑判断，是否要过滤，true-永远过滤
		return true;
	}

	@Override
	public int filterOrder() {//过滤顺序
		
		return 0;
	}

	@Override
	public String filterType() {
		/**
		 * 可以返回四种过滤类型
		 * pre:路由之前
		 * routing:路由之时
		 * post:路由之后
		 * error:发送错误调用
		 */
		return "pre";
	}

}
