package org.home.task.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.home.task.bean.LoginManagedBean;

public class Authentication implements Filter {
	private FilterConfig customedFilterConfig;

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {

		if (((HttpServletRequest) req).getSession().getAttribute(LoginManagedBean.AUTH_KEY) == null) {
			((HttpServletResponse) resp).sendRedirect("restricted.xhtml");
		} else {

			chain.doFilter(req, resp);
		}
	}

	public void init(FilterConfig customedFilterConfig) throws ServletException {
		this.customedFilterConfig = customedFilterConfig;
	}

	public void destroy() {
		customedFilterConfig = null;
	}
}