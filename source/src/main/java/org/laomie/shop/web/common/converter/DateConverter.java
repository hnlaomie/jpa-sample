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

package org.laomie.shop.web.common.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author laomie
 */
public class DateConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component,
            String value) throws ConverterException {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        if (component == null) {
            throw new NullPointerException("component is null");
        }
        if (value == null || value.length() == 0) {
            return null;
        }

        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            date = sdf.parse(value);
        } catch (ParseException e) {
            throw new ConverterException(new FacesMessage(value));
        }

        return date;
    }

    public String getAsString(FacesContext context, UIComponent component,
            Object value) throws ConverterException {
        if (value == null) {
            return "";
        }

        String outputPattern = "yyyy/MM/dd";

        Map<String, Object> map = component.getAttributes();
        if (map != null && (String) map.get("outputPattern") != null) {
            outputPattern = (String) map.get("outputPattern");
        }

        return new SimpleDateFormat(outputPattern).format(value);
    }

}
