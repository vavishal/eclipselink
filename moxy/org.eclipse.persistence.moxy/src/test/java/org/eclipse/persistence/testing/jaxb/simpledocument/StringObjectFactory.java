/*
 * Copyright (c) 1998, 2024 Oracle and/or its affiliates. All rights reserved.
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
// mmacivor - April 25/2008 - 1.0M8 - Initial implementation
package org.eclipse.persistence.testing.jaxb.simpledocument;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.*;
import javax.xml.namespace.*;

@XmlRegistry
public class StringObjectFactory {

    @XmlElementDecl(namespace = "myns", name = "stringroot")
    public JAXBElement<String> createStringRoot() {
        return new JAXBElement(new QName("myns", "stringroot"), String.class, null);
    }
}
