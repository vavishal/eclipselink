/*
 * Copyright (c) 2012, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     Oracle - initial API and implementation
//
package org.eclipse.persistence.jpa.jpql.parser;

/**
 * The query BNF for the CAST function.
 *
 * <div><b>BNF:</b> <code>cast ::= CAST(value AS type)</code></div>
 *
 * @version 2.4
 * @since 2.4
 * @author James Sutherland
 */
@SuppressWarnings("nls")
public final class CastExpressionBNF extends JPQLQueryBNF {

    /**
     * The unique identifier of this BNF rule.
     */
    public static final String ID = "cast_expression";

    /**
     * Creates a new <code>CastExpressionBNF</code>.
     */
    public CastExpressionBNF() {
        super(ID);
    }

    @Override
    protected void initialize() {
        super.initialize();

        registerExpressionFactory(CastExpressionFactory.ID);
    }
}
