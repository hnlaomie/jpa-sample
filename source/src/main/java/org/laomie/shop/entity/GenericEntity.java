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
package org.laomie.shop.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author laomie
 */
@SuppressWarnings("serial")
public abstract class GenericEntity implements IEntity {

    @Override
    public boolean equals(Object object) {
        if ((object == null) || !this.getClass().equals(object.getClass())) {
            return false;
        }
        IEntity entity = (IEntity) object;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(getKeyObject(), entity.getKeyObject());
        return equalsBuilder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(getKeyObject());
        return hashCodeBuilder.toHashCode();
    }
}
