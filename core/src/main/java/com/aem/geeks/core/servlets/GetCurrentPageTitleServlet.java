package com.aem.geeks.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = {"/bin/currentpage"}
)

public class GetCurrentPageTitleServlet extends SlingAllMethodsServlet {
	  private static final Logger LOG = LoggerFactory.getLogger(GeeksPathTypeServlet.class);
	private static final String path = "path";

	    @Override
	    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
	    	try {
	        final ResourceResolver resourceResolver = req.getResourceResolver();
	        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
	        //LOG.debug("Page path info {}",req.getPathInfo().toString());
	        
	        String currentPagePath = req.getParameter(path);
	        Page currentPage = pageManager.getPage(currentPagePath);
	        String currentPageTitle = currentPage.getTitle();
	        resp.setHeader("Content-Type", "text/html");
	     	resp.getWriter().print("<h1>Sling Servlet Called </h1>"); 
	     	resp.getWriter().print(currentPageTitle); 
	     	resp.getWriter().close();
	         LOG.info("\n Inside doGet :{} ", currentPageTitle);
	    	}
	    	catch(Exception e) {
	    		LOG.info("Exception Occurred :", e);
	    	}
	    }

}
