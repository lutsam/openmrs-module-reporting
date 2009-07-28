/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.reporting.web.widget.handler;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.annotation.Handler;
import org.openmrs.module.reporting.web.widget.WidgetConfig;

/**
 * Base WidgetHandler class.
 */
@Handler(supports={Object.class})
public class WidgetHandler {
	
	protected static final Log log = LogFactory.getLog(WidgetHandler.class);
	
	/**
	 * This is the main method that should be overridden by subclasses to render the appropriate Widget
	 * @param tag
	 */
	public void handle(WidgetConfig config) throws IOException {
		String output = "Cannot handle type [" + config.getType() + "]. Please add a module to handle this type.";
		config.getPageContext().getOut().write(output);
	}
}