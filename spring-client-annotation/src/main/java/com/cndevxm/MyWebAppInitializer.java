package com.cndevxm;

import com.cndevxm.web.RootConfig;
import com.cndevxm.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * web初始化器
 */
@SuppressWarnings("rawtypes")
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * application的配置
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{
				RootConfig.class
		};
	}

	/**
	 * webApplication的配置
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	/**
	 * DispatcherServlet映射路径
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
