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

package org.laomie.shop.dao.context;

import org.laomie.shop.core.context.ApplicationContextFactory;
import org.laomie.shop.core.context.BasisApplicationContextFacroty;
import org.laomie.shop.core.context.GenericApplicationContextFactory;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author laomie
 */
public class DaoApplicationContextFactory extends GenericApplicationContextFactory {

    @Override
    protected String[] getConfigLocations() {
        return new String[] { "spring/applicationContext-dao.xml" };
    }

    @Override
    protected ApplicationContext getParent() {
        ApplicationContextFactory factory = new BasisApplicationContextFacroty();
        return factory.getApplicationContext();
    }

}
