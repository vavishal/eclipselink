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
//    Denise Smith - August 2013
package org.eclipse.persistence.testing.jaxb.inheritance.typeElem;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(namespace="theNamespace")
@XmlRootElement(namespace="theNamespace")
public class Parent {
    public String foo;

    public boolean equals(Object compareObject){
        if(compareObject instanceof Parent){
            if(foo == null){
                return ((Parent)compareObject).foo == null;
            }
            return foo.equals(((Parent)compareObject).foo);
        }
        return false;
    }
}
