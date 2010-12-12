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

import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import org.apache.myfaces.lifecycle.LifecycleFactoryImpl;

/**
 *
 * @author laomie
 */
public class ShopLifecycleFactory extends LifecycleFactoryImpl {
    public static final String SHOP_LIFECYCLE = "ShopLifecycle";

    public ShopLifecycleFactory() {
        Lifecycle lifecycle = getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
        addLifecycle(SHOP_LIFECYCLE, new ShopLifecycle(lifecycle));
    }
}
