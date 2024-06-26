/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.internal.security;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;

public class PrivilegedGetDeclaredField implements PrivilegedExceptionAction<Field> {

    private final Class<?> javaClass;
    private final String fieldName;
    private final boolean shouldSetAccessible;

    public PrivilegedGetDeclaredField(Class<?> javaClass, String fieldName, boolean shouldSetAccessible) {
        this.javaClass = javaClass;
        this.fieldName = fieldName;
        this.shouldSetAccessible = shouldSetAccessible;
    }

    @Override
    public Field run() throws NoSuchFieldException {
        return PrivilegedAccessHelper.getDeclaredField(javaClass, fieldName, shouldSetAccessible);
    }

}
