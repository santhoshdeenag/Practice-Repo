package com.aem.geeks.core.models.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.geeks.core.models.StateDropdown;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = StateDropdown.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class StateDropdownImpl implements StateDropdown {
    private static final Logger LOG = LoggerFactory.getLogger(StateDropdownImpl.class);

    @Inject
    Resource componentResource;

    @ValueMapValue
    private List<String> states;

	@Override
	public List<String> getStates() {
		 if(states!=null){
	            return new ArrayList<String>(states);
	        }else{
	            return Collections.emptyList();
	        }
	}

}
