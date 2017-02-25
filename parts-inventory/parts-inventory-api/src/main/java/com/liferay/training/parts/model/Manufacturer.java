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

package com.liferay.training.parts.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PermissionedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Manufacturer service. Represents a row in the &quot;Inventory_Manufacturer&quot; database table, with each column mapped to a property of this class.
 *
 * @author Samir
 * @see ManufacturerModel
 * @see com.liferay.training.parts.model.impl.ManufacturerImpl
 * @see com.liferay.training.parts.model.impl.ManufacturerModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.training.parts.model.impl.ManufacturerImpl")
@ProviderType
public interface Manufacturer extends ManufacturerModel, PermissionedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.training.parts.model.impl.ManufacturerImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Manufacturer, Long> MANUFACTURER_ID_ACCESSOR = new Accessor<Manufacturer, Long>() {
			@Override
			public Long get(Manufacturer manufacturer) {
				return manufacturer.getManufacturerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Manufacturer> getTypeClass() {
				return Manufacturer.class;
			}
		};
}