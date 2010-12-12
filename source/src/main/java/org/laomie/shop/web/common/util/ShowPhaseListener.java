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

import javax.faces.component.UIViewRoot;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class ShowPhaseListener implements PhaseListener {

    public void beforePhase(PhaseEvent event) {
        String phaseName = event.getPhaseId().toString();
        printLog(event, "Before ");
    }

    public void afterPhase(PhaseEvent event) {
        String phaseName = event.getPhaseId().toString();
        printLog(event, "After ");
    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    protected void printLog(PhaseEvent event, String msg) {
        UIViewRoot view = event.getFacesContext().getViewRoot();
        String viewID = "no view";
        if (view != null)
            viewID = view.getViewId();
        System.out.println(msg + event.getPhaseId() + " " + viewID);
    }

}
