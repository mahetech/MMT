package com.sbfc.member.management.configuration;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sbfc.member.management.common.Common;
import com.sbfc.member.management.dao.IMemberDao;
import com.sbfc.member.management.model.GlobalConstant;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// TODO: to be replaced by appropriate service class
	@Autowired
	private IMemberDao memberDao;

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);

		servletContext.addListener(new ContextLoaderListener(rootContext));

		// AnnotationConfigWebApplicationContext dispatcherContext = new
		// AnnotationConfigWebApplicationContext();
		// dispatcherContext.register(WebMvcConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		if (memberDao != null) {

			List<GlobalConstant> constList = memberDao.retrieveAllConstants();
			Common.loadConstants(constList);
		} else {
			System.err.println("Could not load the global constants");
		}
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
