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

package org.laomie.shop.service.context;

import org.laomie.shop.core.context.ApplicationContextFactory;
import org.laomie.shop.core.context.GenericApplicationContextFactory;
import org.laomie.shop.dao.context.DaoApplicationContextFactory;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author laomie
 */
public class ServiceApplicationContextFactory extends GenericApplicationContextFactory {

    @Override
    protected String[] getConfigLocations() {
        return new String[] { "spring/applicationContext-service.xml" };
    }

    @Override
    protected ApplicationContext getParent() {
        ApplicationContextFactory factory = new DaoApplicationContextFactory();
        return factory.getApplicationContext();
    }

}
