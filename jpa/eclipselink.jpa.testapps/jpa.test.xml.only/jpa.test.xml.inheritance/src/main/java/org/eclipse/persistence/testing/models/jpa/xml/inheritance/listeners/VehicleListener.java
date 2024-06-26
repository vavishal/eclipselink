/*
 * Copyright (c) 1998, 2022 Oracle and/or its affiliates. All rights reserved.
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


package org.eclipse.persistence.testing.models.jpa.xml.inheritance.listeners;

import org.eclipse.persistence.testing.models.jpa.xml.inheritance.Vehicle;

import java.util.EventListener;

/**
 * A listener for the Vehicle entity.
 * <p>
 * It implements the following annotations:
 * - PostLoad
 * <p>
 * It overrides the following annotations:
 * - None
 * <p>
 * It inherits the following annotations:
 * - None
 */
public class VehicleListener implements EventListener {
    public static int POST_LOAD_COUNT = 0;

    public void postLoad(Vehicle vehicle) {
        POST_LOAD_COUNT++;
    }
}
