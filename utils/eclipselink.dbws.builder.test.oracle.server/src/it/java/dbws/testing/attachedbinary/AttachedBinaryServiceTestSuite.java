/*
 * Copyright (c) 2011, 2024 Oracle and/or its affiliates. All rights reserved.
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
//     David McCann - Aug.02, 2012 - 2.4.1 - Initial implementation
package dbws.testing.attachedbinary;

import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.namespace.QName;
import jakarta.xml.soap.AttachmentPart;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPFactory;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.ws.Dispatch;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.soap.SOAPBinding;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dbws.testing.DBWSTestSuite;
import static dbws.testing.attachedbinary.AttachedBinaryBuilderTestSuite.CREATE_FUNCTION;
import static dbws.testing.attachedbinary.AttachedBinaryBuilderTestSuite.CREATE_TABLE;
import static dbws.testing.attachedbinary.AttachedBinaryBuilderTestSuite.POPULATE_TABLE;
import static dbws.testing.attachedbinary.AttachedBinaryBuilderTestSuite.DROP_FUNCTION;
import static dbws.testing.attachedbinary.AttachedBinaryBuilderTestSuite.DROP_TABLE;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests binary attachments.
 *
 */
public class AttachedBinaryServiceTestSuite extends DBWSTestSuite {
    public static final String FIND_ALL =
        "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
        "<env:Header />" +
            "<env:Body>" +
                "<findAll_AttachedbinaryType xmlns=\"urn:attachedbinaryService\" />" +
            "</env:Body>" +
        "</env:Envelope>";
    public static final String GET_BLOB_BY_ID =
        "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
        "<env:Header />" +
            "<env:Body>" +
                "<getBLOBById xmlns=\"urn:attachedbinaryService\">" +
                    "<PK>1</PK>" +
                "</getBLOBById>" +
            "</env:Body>" +
        "</env:Envelope>";

    @BeforeClass
    public static void setUp() {
        if (conn == null) {
            try {
                conn = buildConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ddlCreate) {
            runDdl(conn, CREATE_TABLE, ddlDebug);
            runDdl(conn, CREATE_FUNCTION, ddlDebug);
            try {
                Statement stmt = conn.createStatement();
                for (String s : POPULATE_TABLE) {
                    stmt.addBatch(s);
                }
                stmt.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public static void tearDown() {
        if (ddlDrop) {
            runDdl(conn, DROP_TABLE, ddlDebug);
            runDdl(conn, DROP_FUNCTION, ddlDebug);
        }
    }

    @Test
    public void testService() {
        try {
            QName qname = new QName("urn:attachedbinaryService", "attachedbinaryServicePort");
            Service service = Service.create(new QName("urn:attachedbinary", "attachedbinaryService"));
            service.addPort(qname, SOAPBinding.SOAP11HTTP_BINDING, "http://" + host + ":" + port + "/attachedbinary/attachedbinary");
            Dispatch<SOAPMessage> sourceDispatch = service.createDispatch(qname, SOAPMessage.class, Service.Mode.MESSAGE);

            // TEST FINDALL
            // we expect 3 attachments
            SOAPMessage request = createSOAPMessage(FIND_ALL);
            SOAPMessage result = sourceDispatch.invoke(request);

            assertEquals("findAll failed:  wrong number of attachments - expected [3] but was [" + result.countAttachments() + "]", 3, result.countAttachments());

            SOAPElement elt = SOAPFactory.newInstance().createElement("b");

            // verify cid:ref1
            elt.addTextNode("cid:ref1");
            AttachmentPart ap = result.getAttachment(elt);
            assertNotNull("getBlobById failed:  no attachment for [cid:ref1]", ap);

            byte[] rawBytes = ap.getRawContentBytes() ;
            assertEquals("getBlobById failed:  wrong number of bytes returned - expected [15] but was [" + rawBytes.length + "]", 15, rawBytes.length);
            for (byte value : rawBytes) {
                assertTrue("getBlobById failed:  wrong byte value returned - expected [1] but was [" + value + "]", value == 1);
            }
            elt.removeContents();

            // verify cid:ref2
            elt.addTextNode("cid:ref2");
            ap = result.getAttachment(elt);
            assertNotNull("getBlobById failed:  no attachment for [cid:ref2]", ap);

            rawBytes = ap.getRawContentBytes() ;
            assertEquals("getBlobById failed:  wrong number of bytes returned - expected [15] but was [" + rawBytes.length + "]", 15, rawBytes.length);
            for (byte b : rawBytes) {
                assertTrue("getBlobById failed:  wrong byte value returned - expected [2] but was [" + b + "]", b == 2);
            }
            elt.removeContents();

            // verify cid:ref3
            elt.addTextNode("cid:ref3");
            ap = result.getAttachment(elt);
            assertNotNull("getBlobById failed:  no attachment for [cid:ref3]", ap);

            rawBytes = ap.getRawContentBytes() ;
            assertEquals("getBlobById failed:  wrong number of bytes returned - expected [15] but was [" + rawBytes.length + "]", 15, rawBytes.length);
            for (byte aByte : rawBytes) {
                assertTrue("getBlobById failed:  wrong byte value returned - expected [3] but was [" + aByte + "]", aByte == 3);
            }
            elt.removeContents();

            // TEST STORED FUNCTION GETBLOBBYID
            // we expect one attachment
            request = createSOAPMessage(GET_BLOB_BY_ID);
            result = sourceDispatch.invoke(request);

            assertEquals("getBlobById failed:  wrong number of attachments - expected [1] but was [" + result.countAttachments() + "]", 1, result.countAttachments());

            elt.addTextNode("cid:ref1");
            ap = result.getAttachment(elt);
            assertNotNull("getBlobById failed:  no attachment for [cid:ref1]", ap);

            rawBytes = ap.getRawContentBytes() ;
            assertEquals("getBlobById failed:  wrong number of bytes returned - expected [15] but was [" + rawBytes.length + "]", 15, rawBytes.length);
            for (byte rawByte : rawBytes) {
                assertTrue("getBlobById failed:  wrong byte value returned - expected [1] but was [" + rawByte + "]", rawByte == 1);
            }
        } catch (Exception x) {
            fail("Service test failed: " + x.getMessage());
        }
    }
}
