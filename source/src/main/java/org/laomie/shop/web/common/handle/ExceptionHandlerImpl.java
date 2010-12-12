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

package org.laomie.shop.web.common.handle;

import java.io.IOException;
import org.laomie.shop.web.common.util.PageTransitionUtils;

/**
 *
 * @author laomie
 */
public class ExceptionHandlerImpl implements ExceptionHandler {

    // ----------------------------------------------------- Instance Variables
    //private ShopExceptionFactory _exceptionFactory;

    //private ShopLog _log;

    public void handleException(Throwable root) throws IOException {
        Throwable t = getTarget(root, root);
        // TODO:
        //PageTransitionUtils.addMessage((ShopProcessException) t);
        PageTransitionUtils.addMessage((Exception) t);
        PageTransitionUtils.forwardMessageView();
        /*
        if (t instanceof ShopProcessException) {
            _log.error(ExceptionHandler.class, (ShopProcessException) t);
            PageTransitionUtils.addMessage((ShopProcessException) t);
            PageTransitionUtils.forwardMessageView();
        } else if (t instanceof ShopSystemException) {
            _log.error(ExceptionHandler.class, (ShopSystemException) t);
            PageTransitionUtils.addMessage((ShopSystemException) t);
            PageTransitionUtils.forwardMessageView();
        } else {
            try {
                _exceptionFactory.throwException(t, LogMessageId.LOG_0000,
                        DisplayMessageId.MSG_0000);
            } catch (ShopException e) {
                // ログ出力
                _log.error(ExceptionHandler.class, e);

                PageTransitionUtils.addMessage(e);
                PageTransitionUtils.forwardMessageView();
            }
        }
        */
    }

    private Throwable getTarget(Throwable root, Throwable t) {
        //if (t instanceof ShopException) {
        if (t instanceof Exception) {
            return t;
        } else if (t.getCause() != null) {
            return getTarget(root, t.getCause());
        } else {
            return root;
        }
    }

}
