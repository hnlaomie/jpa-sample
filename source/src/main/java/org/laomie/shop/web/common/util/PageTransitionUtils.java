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

package org.laomie.shop.web.common.util;

import java.io.IOException;
import java.text.DecimalFormat;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author laomie
 */
public class PageTransitionUtils {

    // ------------------------------------------------------- Static Variables

    public static final String MESSAGE_VIEW_ID = "/jsp/message.jsp";

    public static final String MESSAGE_ID_SEVERITY = "severity";

    public static final String MESSAGE_ID_IDENTIFIER = "identifier";

    public static final String MESSAGE_ID_MESSAGE = "message";

    // --------------------------------------------------------- Static Methods

    public static void forwardMessageView() throws IOException {
        forward(MESSAGE_VIEW_ID);
    }

    public static void forward(String viewId) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().dispatch(viewId);
        context.responseComplete();
    }

    public static void addMessage(Exception e) {

        //String iconUrl = (e instanceof ShopSystemException) ? "/image/error.gif"
        String iconUrl = (e instanceof Exception) ? "/image/error.gif"
                : "/image/warning.gif";

        //String msSeverity = (e instanceof ShopSystemException) ? "Error!"
        String msSeverity = (e instanceof IOException) ? "Error!"
                : "Warning!";

        DecimalFormat decimalFormat = new DecimalFormat("00000000");
        //String msIdentifier = decimalFormat.format(e.getIdentifier().getId());
        String msIdentifier = "msIdentifier";

        //String message = e.getDisplayMessage().getText();
        String message = "message";
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context
                .getExternalContext().getRequest();
        request.setAttribute("ExceptionIconUrl", iconUrl);
        request.setAttribute("ExceptionSeverity", msSeverity);
        request.setAttribute("ExceptionIdentifier", msIdentifier);
        request.setAttribute("ExceptionMessage", message);
    }

}
