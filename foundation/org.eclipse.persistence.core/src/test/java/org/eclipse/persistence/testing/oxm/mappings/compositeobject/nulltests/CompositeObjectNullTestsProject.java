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
package org.eclipse.persistence.testing.oxm.mappings.compositeobject.nulltests;

import org.eclipse.persistence.oxm.XMLDescriptor;
import org.eclipse.persistence.oxm.mappings.XMLCompositeObjectMapping;
import org.eclipse.persistence.oxm.mappings.XMLDirectMapping;
import org.eclipse.persistence.sessions.Project;
import org.eclipse.persistence.testing.oxm.mappings.compositeobject.EmailAddress;
import org.eclipse.persistence.testing.oxm.mappings.compositeobject.Employee;
import org.eclipse.persistence.testing.oxm.mappings.compositeobject.MailingAddress;

public class CompositeObjectNullTestsProject extends Project {

  public CompositeObjectNullTestsProject() {
    addDescriptor(getEmployeeDescriptor());
    addDescriptor(getEmailAddressDescriptor());
    addDescriptor(getMailingAddressDescriptor());
  }

  private XMLDescriptor getEmployeeDescriptor() {
    XMLDescriptor descriptor = new XMLDescriptor();
    descriptor.setJavaClass(Employee.class);
    descriptor.setDefaultRootElement("employee");

    XMLDirectMapping idMapping = new XMLDirectMapping();
    idMapping.setXPath("id/text()");
    idMapping.setAttributeName("id");
    descriptor.addMapping(idMapping);

    XMLCompositeObjectMapping emailMapping = new XMLCompositeObjectMapping();
    emailMapping.setAttributeName("emailAddress");
    emailMapping.setXPath("info/email-address");
    emailMapping.setGetMethodName("getEmailAddress");
    emailMapping.setSetMethodName("setEmailAddress");
    emailMapping.setReferenceClass(EmailAddress.class);
    descriptor.addMapping(emailMapping);

    XMLCompositeObjectMapping addressMapping = new XMLCompositeObjectMapping();
    addressMapping.setAttributeName("mailingAddress");
    addressMapping.setXPath("mailing-address");
    addressMapping.setGetMethodName("getMailingAddress");
    addressMapping.setSetMethodName("setMailingAddress");
    addressMapping.setReferenceClass(MailingAddress.class);
    descriptor.addMapping(addressMapping);

    return descriptor;
  }

  private XMLDescriptor getEmailAddressDescriptor() {
    XMLDescriptor descriptor = new XMLDescriptor();
    descriptor.setJavaClass(EmailAddress.class);

    XMLDirectMapping userIDMapping = new XMLDirectMapping();
    userIDMapping.setAttributeName("userID");
    userIDMapping.setXPath("user-id/text()");
    descriptor.addMapping(userIDMapping);

    XMLDirectMapping domainMapping = new XMLDirectMapping();
    domainMapping.setAttributeName("domain");
    domainMapping.setXPath("domain/text()");
    descriptor.addMapping(domainMapping);
    return descriptor;
  }

  private XMLDescriptor getMailingAddressDescriptor() {
    XMLDescriptor descriptor = new XMLDescriptor();
    descriptor.setJavaClass(MailingAddress.class);

    XMLDirectMapping streetMapping = new XMLDirectMapping();
    streetMapping.setAttributeName("street");
    streetMapping.setXPath("street/text()");
    descriptor.addMapping(streetMapping);

    XMLDirectMapping cityMapping = new XMLDirectMapping();
    cityMapping.setAttributeName("city");
    cityMapping.setXPath("city/text()");
    descriptor.addMapping(cityMapping);

    XMLDirectMapping provinceMapping = new XMLDirectMapping();
    provinceMapping.setAttributeName("province");
    provinceMapping.setXPath("province/text()");
    descriptor.addMapping(provinceMapping);

    XMLDirectMapping postalCodeMapping = new XMLDirectMapping();
    postalCodeMapping.setAttributeName("postalCode");
    postalCodeMapping.setXPath("postal-code/text()");
    descriptor.addMapping(postalCodeMapping);

    return descriptor;
  }

}
