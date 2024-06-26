/*
 * Copyright (c) 2013, 2024 Oracle and/or its affiliates. All rights reserved.
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
//     Guy Pelletier - initial API and implementation
package org.eclipse.persistence.internal.jpa.config.queries;

import java.util.ArrayList;

import org.eclipse.persistence.internal.jpa.config.MetadataImpl;
import org.eclipse.persistence.internal.jpa.metadata.queries.NamedQueryMetadata;
import org.eclipse.persistence.jpa.config.QueryHint;

/**
 * JPA scripting API implementation.
 *
 * @author Guy Pelletier
 * @since EclipseLink 2.5.1
 */
@SuppressWarnings("unchecked")
public abstract class AbstractNamedQueryImpl<T extends NamedQueryMetadata, R> extends MetadataImpl<T> {

    public AbstractNamedQueryImpl(T t) {
        super(t);

        getMetadata().setHints(new ArrayList<>());
    }

    public QueryHint addQueryHint() {
        QueryHintImpl hint = new QueryHintImpl();
        getMetadata().getHints().add(hint.getMetadata());
        return hint;
    }

    public R setName(String name) {
        getMetadata().setName(name);
        return (R) this;
    }


}
