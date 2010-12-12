/**
 * Copyright (c) 2010 laomie <laomie@msn.com>
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * # Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * # Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 */

package org.laomie.shop.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author laomie
 */
public class SessionCheckFilter implements Filter {

    private final String PRE_SERVLET_CONTEXT = "PRE_SERVLET_CONTEXT";

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        if (request instanceof HttpServletRequest) {

            HttpSession session = ((HttpServletRequest) request).getSession();
            Object pre = session.getAttribute(PRE_SERVLET_CONTEXT);

            if (pre == null || !session.getServletContext().equals(pre)) {
                //コメント
                //session.setAttribute(PRE_SERVLET_CONTEXT, session.getServletContext());

                ((HttpServletResponse) response).sendRedirect("/demo-shop/jsp/sessionTimeout.jsp");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }
}

