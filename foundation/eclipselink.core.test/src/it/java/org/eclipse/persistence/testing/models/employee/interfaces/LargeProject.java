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
package org.eclipse.persistence.testing.models.employee.interfaces;

import java.sql.Timestamp;

/**
 * <b>Purpose</b>: Larger scale projects within the Employee Demo
 * <p><b>Description</b>: LargeProject is a concrete subclass of Project. It is instantiated for Projects with type = 'L'. The additional
 * information (budget, &amp; milestoneVersion) are mapped from the LPROJECT table.
 */
public interface LargeProject extends Project {
    double getBudget();

    Timestamp getMilestoneVersion();

    void setBudget(double budget);

    void setMilestoneVersion(Timestamp milestoneVersion);
}
