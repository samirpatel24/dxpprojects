/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.space.gradebook.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.training.space.gradebook.service.AssignmentServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link AssignmentServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.training.space.gradebook.model.AssignmentSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.training.space.gradebook.model.Assignment}, that is translated to a
 * {@link com.liferay.training.space.gradebook.model.AssignmentSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentServiceHttp
 * @see com.liferay.training.space.gradebook.model.AssignmentSoap
 * @see AssignmentServiceUtil
 * @generated
 */
@ProviderType
public class AssignmentServiceSoap {
	public static com.liferay.training.space.gradebook.model.AssignmentSoap getAssignment(
		long assignmentId) throws RemoteException {
		try {
			com.liferay.training.space.gradebook.model.Assignment returnValue = AssignmentServiceUtil.getAssignment(assignmentId);

			return com.liferay.training.space.gradebook.model.AssignmentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.training.space.gradebook.model.AssignmentSoap deleteAssignment(
		com.liferay.training.space.gradebook.model.AssignmentSoap assignment)
		throws RemoteException {
		try {
			com.liferay.training.space.gradebook.model.Assignment returnValue = AssignmentServiceUtil.deleteAssignment(com.liferay.training.space.gradebook.model.impl.AssignmentModelImpl.toModel(
						assignment));

			return com.liferay.training.space.gradebook.model.AssignmentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.training.space.gradebook.model.AssignmentSoap deleteAssignment(
		long assignmentId) throws RemoteException {
		try {
			com.liferay.training.space.gradebook.model.Assignment returnValue = AssignmentServiceUtil.deleteAssignment(assignmentId);

			return com.liferay.training.space.gradebook.model.AssignmentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.training.space.gradebook.model.AssignmentSoap addAssignment(
		com.liferay.training.space.gradebook.model.AssignmentSoap assignment,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.training.space.gradebook.model.Assignment returnValue = AssignmentServiceUtil.addAssignment(com.liferay.training.space.gradebook.model.impl.AssignmentModelImpl.toModel(
						assignment), serviceContext);

			return com.liferay.training.space.gradebook.model.AssignmentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.training.space.gradebook.model.AssignmentSoap updateAssignment(
		com.liferay.training.space.gradebook.model.AssignmentSoap assignment)
		throws RemoteException {
		try {
			com.liferay.training.space.gradebook.model.Assignment returnValue = AssignmentServiceUtil.updateAssignment(com.liferay.training.space.gradebook.model.impl.AssignmentModelImpl.toModel(
						assignment));

			return com.liferay.training.space.gradebook.model.AssignmentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.training.space.gradebook.model.AssignmentSoap[] getAssignmentsByGroupId(
		long groupId) throws RemoteException {
		try {
			java.util.List<com.liferay.training.space.gradebook.model.Assignment> returnValue =
				AssignmentServiceUtil.getAssignmentsByGroupId(groupId);

			return com.liferay.training.space.gradebook.model.AssignmentSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.training.space.gradebook.model.AssignmentSoap[] getAssignmentsByGroupId(
		long groupId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.training.space.gradebook.model.Assignment> returnValue =
				AssignmentServiceUtil.getAssignmentsByGroupId(groupId, start,
					end);

			return com.liferay.training.space.gradebook.model.AssignmentSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getAssignmentsCountByGroupId(long groupId)
		throws RemoteException {
		try {
			int returnValue = AssignmentServiceUtil.getAssignmentsCountByGroupId(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AssignmentServiceSoap.class);
}