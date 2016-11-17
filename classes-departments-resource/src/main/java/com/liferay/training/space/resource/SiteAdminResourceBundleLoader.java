package com.liferay.training.space.resource;

import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.CacheResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

@Component(
		immediate = true,
		property = {
			"bundle.symbolic.name=com.liferay.site.admin.web",
			"resource.bundle.base.name=content.Language",
			"servlet.context.name=site-admin-web"
		}
	)
public class SiteAdminResourceBundleLoader implements ResourceBundleLoader {

	@Override
	public ResourceBundle loadResourceBundle(String languageId) {
		return _resourceBundleLoader.loadResourceBundle(languageId);
	}

	@Reference(target = "(bundle.symbolic.name=com.liferay.site.admin.web)")
	public void setResourceBundleLoader(
		ResourceBundleLoader resourceBundleLoader) {

		_resourceBundleLoader = new AggregateResourceBundleLoader(
			new CacheResourceBundleLoader(
				new ClassResourceBundleLoader(
					"content.Language",
					SiteAdminResourceBundleLoader.class.getClassLoader())),
			resourceBundleLoader);
	}

	private AggregateResourceBundleLoader _resourceBundleLoader;

}