package com.liferay.training.space.gradebook.portlet.command;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.space.gradebook.model.Assignment;
import com.liferay.training.space.gradebook.portlet.GradebookPortletKeys;
import com.liferay.training.space.gradebook.portlet.GradebookPortletUtil;
import com.liferay.training.space.gradebook.service.AssignmentLocalService;
import com.liferay.training.space.gradebook.service.AssignmentService;
import com.liferay.training.space.gradebook.validator.AssignmentValidator;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GradebookPortletKeys.PORTLET_NAME,
		"mvc.command.name=/gradebook/assignment/edit"
},
	service = MVCActionCommand.class)
public class EditAssignmentMVCActionCommand extends BaseMVCActionCommand {

		@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse) 
		throws Exception {

		long assignmentId = ParamUtil.getLong(actionRequest, "assignmentId");

		Assignment assignment = _assignmentLocalService.getAssignment(assignmentId);

		GradebookPortletUtil.assembleAssignment(actionRequest, assignment);

		List<String> errors = new ArrayList<>();
		
		if (AssignmentValidator.isAssignmentValid(assignment, errors)) {

			_assignmentLocalService.updateAssignment(assignment);

			SessionMessages.add(actionRequest, "assignment-updated");

			sendRedirect(actionRequest, actionResponse);
		} else {
			throw new Exception("Invalid form data");
		}
	}

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected AssignmentLocalService _assignmentLocalService;
}
