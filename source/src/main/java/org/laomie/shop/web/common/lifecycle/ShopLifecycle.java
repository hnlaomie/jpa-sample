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

package org.laomie.shop.web.common.lifecycle;

import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.Lifecycle;
import org.laomie.shop.web.common.handle.ExceptionHandler;
/**
 *
 * @author laomie
 */
public class ShopLifecycle extends Lifecycle {
    // ----------------------------------------------------- Instance Variables
    private Lifecycle _delegate;

    private ExceptionHandler exceptionHandler;

    // ----------------------------------------------------------- Constructors
    public ShopLifecycle(Lifecycle delegate) {
        this._delegate = delegate;
    }

    // --------------------------------------------------------- public Methods
    @Override
    public void addPhaseListener(PhaseListener listener) {
        _delegate.addPhaseListener(listener);
    }

    @Override
    public void execute(FacesContext context) throws FacesException {
        try {
            _delegate.execute(context);
        } catch (Throwable t) {
            try {
                handleException(t);
            } catch (IOException e) {
                throw new FacesException(e);
            }
        }
    }

    @Override
    public PhaseListener[] getPhaseListeners() {
        return _delegate.getPhaseListeners();
    }

    @Override
    public void removePhaseListener(PhaseListener listener) {
        _delegate.removePhaseListener(listener);
    }

    @Override
    public void render(FacesContext context) throws FacesException {
        _delegate.render(context);
    }

    // -------------------------------------------------------- private Methods
    private void handleException(Throwable t) throws IOException {
        if (exceptionHandler == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            /* TODO
            ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
            WebApplicationContext applicationContext = WebApplicationContextUtils
                    .getWebApplicationContext(servletContext);
            exceptionHandler = (ExceptionHandler) applicationContext.getBean(
                    "shopExceptionHandler", ExceptionHandler.class);
            */
            System.out.println("==========================exceptionHandler is null." + facesContext.toString());
        }
        //exceptionHandler.handleException(t);
    }
}
