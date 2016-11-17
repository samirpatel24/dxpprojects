package com.liferay.training.space.gradebook.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.space.gradebook.service.AssignmentLocalService;
import com.liferay.training.space.gradebook.service.permission.AssignmentPermission;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=gradebook-web Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GradebookPortlet extends MVCPortlet {
		@Override
	public void doView(
		RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		boolean hasAddAssignmentPermission =
				AssignmentPermission.containsTopLevel(
					themeDisplay.getPermissionChecker(), groupId,
					"ADD_ASSIGNMENT");
		
		renderRequest.setAttribute(
			"Assignments",
			_assignmentLocalService.getAssignmentsByGroupId(
			themeDisplay.getScopeGroupId()));
		renderRequest.setAttribute(
			"AssignmentsCount",
			_assignmentLocalService.getAssignmentsCountByGroupId(
			themeDisplay.getScopeGroupId()));
		renderRequest.setAttribute(
				"hasAddAssignmentPermission", hasAddAssignmentPermission);

		super.doView(renderRequest, renderResponse);
	}

	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	protected AssignmentLocalService _assignmentLocalService;
}