/*
 * Copyright (c) 1998, 2023 Oracle and/or its affiliates. All rights reserved.
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
package org.eclipse.persistence.testing.oxm.mappings.typeddirect;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TypedDirectMappingTestSuite extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite("Typed Direct Mappings Suite");
        suite.addTestSuite(TypedDirectMappingTestCases.class);
        suite.addTestSuite(TypedDirectErrorTestCases.class);

        return suite;
    }

}
