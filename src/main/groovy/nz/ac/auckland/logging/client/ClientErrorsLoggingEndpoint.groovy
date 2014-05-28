package nz.ac.auckland.logging.client

import groovy.transform.CompileStatic
import nz.ac.auckland.common.jsresource.ApplicationResource
import nz.ac.auckland.common.jsresource.ResourceScope
import nz.ac.auckland.common.stereotypes.UniversityComponent


import javax.annotation.PostConstruct
import javax.inject.Inject

/**
 * author: Irina Benediktovich - http://plus.google.com/+IrinaBenediktovich
 */
@CompileStatic
@UniversityComponent
class ClientErrorsLoggingEndpoint implements ApplicationResource {

	/**
	 * System property that contains web app context
	 */
	private static final String WEBAPP_CONTEXT = "webapp.context";

	@net.stickycode.stereotype.configured.Configured
	String meh = "meh.";


	/**
	 * @return the context path
	 */
	protected String getContextPath() {
		String path = System.getProperty(WEBAPP_CONTEXT);
		if (path == "/" || path == null) {
			return ""
		} else {
			if (path.endsWith('/'))
				path = path.substring(0, path.length()-1)
			return path;
		}
	}

	/**
	 * @return this is a global application resource
	 */
	@Override
	ResourceScope getResourceScope() {
		return ResourceScope.Global;
	}

	/**
	 * @return the map of endpoints
	 */
	@Override
	Map<String, Object> getResourceMap() {
		return ['logging': [url: getContextPath()+"/clientrerrorlogger/log"]]
	}
}
