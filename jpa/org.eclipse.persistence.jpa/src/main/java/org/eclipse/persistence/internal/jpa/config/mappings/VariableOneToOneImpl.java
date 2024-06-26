/*
 * Copyright (c) 2013, 2024 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Guy Pelletier - initial API and implementation
package org.eclipse.persistence.internal.jpa.config.mappings;

import java.util.ArrayList;

import org.eclipse.persistence.internal.jpa.config.columns.DiscriminatorClassImpl;
import org.eclipse.persistence.internal.jpa.config.columns.DiscriminatorColumnImpl;
import org.eclipse.persistence.internal.jpa.metadata.accessors.mappings.VariableOneToOneAccessor;
import org.eclipse.persistence.jpa.config.DiscriminatorClass;
import org.eclipse.persistence.jpa.config.DiscriminatorColumn;
import org.eclipse.persistence.jpa.config.VariableOneToOne;

/**
 * JPA scripting API implementation.
 *
 * @author Guy Pelletier
 * @since EclipseLink 2.5.1
 */
public class VariableOneToOneImpl extends AbstractObjectMappingImpl<VariableOneToOneAccessor, VariableOneToOne> implements VariableOneToOne {

    public VariableOneToOneImpl() {
        super(new VariableOneToOneAccessor());

        getMetadata().setDiscriminatorClasses(new ArrayList<>());
    }

    @Override
    public DiscriminatorClass addDiscriminatorClass() {
        DiscriminatorClassImpl discriminatorClass = new DiscriminatorClassImpl();
        getMetadata().getDiscriminatorClasses().add(discriminatorClass.getMetadata());
        return discriminatorClass;
    }

    @Override
    public DiscriminatorColumn setDiscriminatorColumn() {
        DiscriminatorColumnImpl column = new DiscriminatorColumnImpl();
        getMetadata().setDiscriminatorColumn(column.getMetadata());
        return column;
    }

    @Override
    public VariableOneToOne setTargetInterface(String targetInterface) {
        getMetadata().setTargetEntityName(targetInterface);
        return this;
    }

}
