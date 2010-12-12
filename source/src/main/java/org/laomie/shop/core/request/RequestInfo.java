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

package org.laomie.shop.core.request;

/**
 *
 * @author laomie
 */
public class RequestInfo {
    private String sessionId;

    private String remortHost;

    private String remortAddress;

    private String requestURL;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getRemortHost() {
        return remortHost;
    }

    public void setRemortHost(String remortHost) {
        this.remortHost = remortHost;
    }

    public String getRemortAddress() {
        return remortAddress;
    }

    public void setRemortAddress(String remortAddress) {
        this.remortAddress = remortAddress;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

}

