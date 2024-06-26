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
//     rbarkhouse - 2009-04-14 - 2.0 - Initial implementation

package org.eclipse.persistence.testing.oxm.mappings.compositeobject.keepaselement;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.oxm.XMLDescriptor;
import org.eclipse.persistence.oxm.mappings.UnmarshalKeepAsElementPolicy;
import org.eclipse.persistence.oxm.mappings.XMLCompositeObjectMapping;
import org.eclipse.persistence.sessions.Project;

public class CompositeObjectKeepUnknownAsElementProject extends Project {

    public CompositeObjectKeepUnknownAsElementProject() {
        this.addDescriptor(buildDocDescriptor());
        this.addDescriptor(buildElemDescriptor());
    }

    public ClassDescriptor buildDocDescriptor() {
        XMLDescriptor descriptor = new XMLDescriptor();
        descriptor.setJavaClass(Doc.class);
        descriptor.setDefaultRootElement("doc");

        XMLCompositeObjectMapping elemMapping = new XMLCompositeObjectMapping();
        elemMapping.setAttributeName("elem");
        elemMapping.setGetMethodName("getElem");
        elemMapping.setSetMethodName("setElem");
        elemMapping.setXPath("elem");
        elemMapping.setReferenceClass(Elem.class);

        XMLCompositeObjectMapping elem1Mapping = new XMLCompositeObjectMapping();
        elem1Mapping.setAttributeName("elem1");
        elem1Mapping.setGetMethodName("getElem1");
        elem1Mapping.setSetMethodName("setElem1");
        elem1Mapping.setXPath("elem1");
        elem1Mapping.setReferenceClass(null);
        elem1Mapping.setReferenceClassName(null);
        elem1Mapping.setKeepAsElementPolicy(UnmarshalKeepAsElementPolicy.KEEP_UNKNOWN_AS_ELEMENT);

        descriptor.addMapping(elemMapping);
        descriptor.addMapping(elem1Mapping);

        return descriptor;
    }

    public ClassDescriptor buildElemDescriptor() {
        XMLDescriptor descriptor = new XMLDescriptor();
        descriptor.setJavaClass(Elem.class);

        XMLCompositeObjectMapping elemMapping = new XMLCompositeObjectMapping();
        elemMapping.setAttributeName("elem");
        elemMapping.setGetMethodName("getElem");
        elemMapping.setSetMethodName("setElem");
        elemMapping.setXPath("elem");
        elemMapping.setReferenceClass(null);
        elemMapping.setReferenceClassName(null);
        elemMapping.setKeepAsElementPolicy(UnmarshalKeepAsElementPolicy.KEEP_UNKNOWN_AS_ELEMENT);

        XMLCompositeObjectMapping elem1Mapping = new XMLCompositeObjectMapping();
        elem1Mapping.setAttributeName("elem1");
        elem1Mapping.setGetMethodName("getElem1");
        elem1Mapping.setSetMethodName("setElem1");
        elem1Mapping.setXPath("elem1");
        elem1Mapping.setReferenceClass(null);
        elem1Mapping.setReferenceClassName(null);
        elem1Mapping.setKeepAsElementPolicy(UnmarshalKeepAsElementPolicy.KEEP_UNKNOWN_AS_ELEMENT);

        descriptor.addMapping(elemMapping);
        descriptor.addMapping(elem1Mapping);

        return descriptor;
    }

}
