package com.aem.geeks.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        methods = {HttpConstants.METHOD_GET},
        resourceTypes = "/apps/aemgeeks/components/page"
        //selectors = {"getpage"},
        //extensions = {"html"}
)
public class GetPageTitle extends SlingSafeMethodsServlet{
	  private static final Logger LOG = LoggerFactory.getLogger(GetPageTitle.class);

	    @Override
	    protected void doGet(final SlingHttpServletRequest req,
	                         final SlingHttpServletResponse resp) throws ServletException, IOException {
	        final Resource resource = req.getResource();
	        //resp.getWriter().write("Page Title = " + resource.getValueMap().get(JcrConstants.JCR_TITLE));
	        try {
	        String pageTitle = resource.getValueMap().get(JcrConstants.JCR_TITLE).toString();
	        resp.setContentType("application/json");
	        JSONObject jsonObject = new JSONObject();
				jsonObject.put("pageTitle", pageTitle);
	        resp.getWriter().write(jsonObject.toString());
	    }
	    catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }

}
