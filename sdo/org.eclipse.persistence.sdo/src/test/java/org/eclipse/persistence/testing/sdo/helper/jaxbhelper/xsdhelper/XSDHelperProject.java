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
//     bdoughan - Jan 27/2009 - 1.1 - Initial implementation
package org.eclipse.persistence.testing.sdo.helper.jaxbhelper.xsdhelper;

import org.eclipse.persistence.oxm.NamespaceResolver;
import org.eclipse.persistence.oxm.XMLDescriptor;
import org.eclipse.persistence.oxm.mappings.XMLCompositeObjectMapping;
import org.eclipse.persistence.oxm.mappings.XMLDirectMapping;
import org.eclipse.persistence.sessions.Project;
import org.eclipse.persistence.oxm.schema.XMLSchemaClassPathReference;
import org.eclipse.persistence.platform.xml.XMLSchemaReference;

public class XSDHelperProject extends Project {

    public XSDHelperProject() {
        super();
        this.addDescriptor(getRootDescriptor());
        this.addDescriptor(getChild1Descriptor());
        this.addDescriptor(getChild2Descriptor());
    }

    private XMLDescriptor getChild1Descriptor() {
        XMLDescriptor xmlDescriptor = new XMLDescriptor();
        xmlDescriptor.setJavaClass(Child1.class);
        xmlDescriptor.addPrimaryKeyFieldName("@id");

        NamespaceResolver namespaceResolver = new NamespaceResolver();
        namespaceResolver.put("tns", "urn:xsd");
        xmlDescriptor.setNamespaceResolver(namespaceResolver);

        XMLSchemaClassPathReference schemaReference = new XMLSchemaClassPathReference();
        schemaReference.setSchemaContext("/tns:child1");
        schemaReference.setType(XMLSchemaReference.COMPLEX_TYPE);
        xmlDescriptor.setSchemaReference(schemaReference);

        XMLDirectMapping idMapping = new XMLDirectMapping();
        idMapping.setAttributeName("id");
        idMapping.setXPath("@id");
        xmlDescriptor.addMapping(idMapping);

        return xmlDescriptor;
    }

    private XMLDescriptor getChild2Descriptor() {
        XMLDescriptor xmlDescriptor = new XMLDescriptor();
        xmlDescriptor.setJavaClass(Child2.class);
        xmlDescriptor.setDefaultRootElement("tns:child2");
        xmlDescriptor.addPrimaryKeyFieldName("@id");

        XMLSchemaClassPathReference schemaReference = new XMLSchemaClassPathReference();
        schemaReference.setSchemaContext("/tns:child2");
        schemaReference.setType(XMLSchemaReference.ELEMENT);
        xmlDescriptor.setSchemaReference(schemaReference);

        NamespaceResolver namespaceResolver = new NamespaceResolver();
        namespaceResolver.put("tns", "urn:xsd");
        xmlDescriptor.setNamespaceResolver(namespaceResolver);

        XMLDirectMapping idMapping = new XMLDirectMapping();
        idMapping.setAttributeName("id");
        idMapping.setXPath("@id");
        xmlDescriptor.addMapping(idMapping);

        return xmlDescriptor;
    }

    private XMLDescriptor getRootDescriptor() {
        XMLDescriptor xmlDescriptor = new XMLDescriptor();
        xmlDescriptor.setJavaClass(Root.class);

        XMLSchemaClassPathReference schemaReference = new XMLSchemaClassPathReference();
        schemaReference.setSchemaContext("/tns:root");
        schemaReference.setType(XMLSchemaReference.COMPLEX_TYPE);
        xmlDescriptor.setSchemaReference(schemaReference);

        NamespaceResolver namespaceResolver = new NamespaceResolver();
        namespaceResolver.put("tns", "urn:xsd");
        xmlDescriptor.setNamespaceResolver(namespaceResolver);

        XMLCompositeObjectMapping child1Mapping = new XMLCompositeObjectMapping();
        child1Mapping.setAttributeName("child1");
        child1Mapping.setXPath("tns:child1");
        xmlDescriptor.addMapping(child1Mapping);

        XMLCompositeObjectMapping child2Mapping = new XMLCompositeObjectMapping();
        child2Mapping.setAttributeName("child2");
        child2Mapping.setXPath("tns:child2");
        xmlDescriptor.addMapping(child2Mapping);

        return xmlDescriptor;
    }

}
