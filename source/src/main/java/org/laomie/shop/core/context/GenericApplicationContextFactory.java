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

package org.laomie.shop.core.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author laomie
 */
public abstract class GenericApplicationContextFactory implements ApplicationContextFactory {
    private ApplicationContext context;

    public final ApplicationContext getApplicationContext() {
        synchronized (this) {
            if (context == null) {
                context = new ClassPathXmlApplicationContext(getConfigLocations(), getParent());
            }
        }
        return context;
    }

    protected abstract String[] getConfigLocations();

    protected abstract ApplicationContext getParent();
}
