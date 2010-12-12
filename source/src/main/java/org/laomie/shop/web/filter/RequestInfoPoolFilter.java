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
import org.laomie.shop.core.request.RequestInfo;
import org.laomie.shop.core.request.RequestManager;

/**
 *
 * @author laomie
 */
public class RequestInfoPoolFilter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        RequestInfo info = new RequestInfo();
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = ((HttpServletRequest) request);

            info.setSessionId(httpRequest.getSession().getId());
            info.setRemortAddress(httpRequest.getRemoteAddr());
            info.setRemortHost(httpRequest.getRemoteHost());
            info.setRequestURL(httpRequest.getRequestURL().toString());

        } else {
            info.setRemortAddress(request.getRemoteAddr());
            info.setRemortHost(request.getRemoteHost());
        }

        RequestManager.setRequestInfo(info);

        try {
            chain.doFilter(request, response);
        } finally {
            RequestManager.remove();
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}

