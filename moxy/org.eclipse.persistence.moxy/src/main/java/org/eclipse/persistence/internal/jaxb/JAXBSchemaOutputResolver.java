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
// dmccann - May 25/2009 - 2.0 - Initial implementation
package org.eclipse.persistence.internal.jaxb;

import java.io.IOException;

import jakarta.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;

import org.eclipse.persistence.internal.oxm.schema.SchemaModelOutputResolver;

/**
 * Implementation of a SchemaModelOutputResolver that wraps a
 * jakarta.xml.bind.SchemaOutputResolver instance.
 *
 */
public class JAXBSchemaOutputResolver implements SchemaModelOutputResolver {
    SchemaOutputResolver outputResolver;

    /**
     * This constructor sets the underlying SchemaOutputResolver to be used
     * during createOutput operation.
     *
     */
    public JAXBSchemaOutputResolver(SchemaOutputResolver outputResolver) {
        this.outputResolver = outputResolver;
    }

    /**
     * Determines the location where a given schema file (of the given namespace URI)
     * will be generated, and return it as a Result object.
     *
     * @return schema file as a Result object
     */
    @Override
    public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
        return outputResolver.createOutput(namespaceURI, suggestedFileName);
    }
}
