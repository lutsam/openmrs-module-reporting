/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.reporting.data.encounter.definition;

import org.openmrs.OpenmrsMetadata;
import org.openmrs.module.reporting.common.Localized;
import org.openmrs.module.reporting.data.BaseDataDefinition;
import org.openmrs.module.reporting.definition.configuration.ConfigurationProperty;
import org.openmrs.module.reporting.definition.configuration.ConfigurationPropertyCachingStrategy;
import org.openmrs.module.reporting.evaluation.caching.Caching;

import java.util.List;

/**
 * Encounter Provider Column (for 1.9.x and above)
 */
@Caching(strategy=ConfigurationPropertyCachingStrategy.class)
@Localized("reporting.EncounterProviderDataDefinition")
public class EncounterProviderDataDefinition extends BaseDataDefinition implements EncounterDataDefinition {
	
	public static final long serialVersionUID = 1L;

    @ConfigurationProperty
    private OpenmrsMetadata encounterRole;

    @ConfigurationProperty
    private boolean singleProvider = true;

	public EncounterProviderDataDefinition() {
		super();
	}

	public EncounterProviderDataDefinition(String name) {
		super(name);
	}

    /**
     * @return encounterRole will be of type EncounterRole.class
     */
    public OpenmrsMetadata getEncounterRole() {
        return encounterRole;
    }

    /**
     * @param encounterRole must be of type EncounterRole.class
     */
    public void setEncounterRole(OpenmrsMetadata encounterRole) {
        this.encounterRole = encounterRole;
    }

    public boolean isSingleProvider() {
        return singleProvider;
    }

    public boolean getSingleProvider() {
        return singleProvider;
    }

    public void setSingleProvider(boolean singleProvider) {
        this.singleProvider = singleProvider;
    }

    @Override
    public Class<?> getDataType() {
        return singleProvider ? OpenmrsMetadata.class : List.class;
    }
}