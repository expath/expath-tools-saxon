/****************************************************************************/
/*  File:       SaxonSequenceTest.java                                      */
/*  Author:     A. Retter - adamretter.org.uk                               */
/*  Date:       2024-06-28                                                  */
/*  Tags:                                                                   */
/*      Copyright (c) 2024 Adam Retter (see end of file.)                   */
/* ------------------------------------------------------------------------ */


package org.expath.tools.saxon.model;

import net.sf.saxon.trans.XPathException;
import org.expath.tools.ToolsException;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.transform.OutputKeys;
import java.util.Properties;

import static javax.xml.XMLConstants.NULL_NS_URI;
import static org.junit.Assert.assertEquals;

public class SaxonSequenceTest {

  @Test
  public void setOutputKeyNullNs() throws XPathException, ToolsException {
    final SaxonSequence saxonSequence = new SaxonSequence(null, null);

    final Properties properties = new Properties();

    QName expected = new QName("xml");
    saxonSequence.setOutputKey(properties, OutputKeys.METHOD, expected);
    assertEquals(expected.getLocalPart(), properties.get(OutputKeys.METHOD));

    expected = new QName(NULL_NS_URI, "xml");
    saxonSequence.setOutputKey(properties, OutputKeys.METHOD, expected);
    assertEquals(expected.getLocalPart(), properties.get(OutputKeys.METHOD));

    expected = new QName(null, "xml");
    saxonSequence.setOutputKey(properties, OutputKeys.METHOD, expected);
    assertEquals(expected.getLocalPart(), properties.get(OutputKeys.METHOD));
  }

  @Test(expected = ToolsException.class)
  public void setOutputKeyNonNullNs() throws XPathException, ToolsException {
    final SaxonSequence saxonSequence = new SaxonSequence(null, null);

    final Properties properties = new Properties();

    final QName expected = new QName("urn:test:ns", "xml");
    saxonSequence.setOutputKey(properties, OutputKeys.METHOD, expected);
  }
}


/* ------------------------------------------------------------------------ */
/*  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS COMMENT.               */
/*                                                                          */
/*  The contents of this file are subject to the Mozilla Public License     */
/*  Version 1.0 (the "License"); you may not use this file except in        */
/*  compliance with the License. You may obtain a copy of the License at    */
/*  http://www.mozilla.org/MPL/.                                            */
/*                                                                          */
/*  Software distributed under the License is distributed on an "AS IS"     */
/*  basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.  See    */
/*  the License for the specific language governing rights and limitations  */
/*  under the License.                                                      */
/*                                                                          */
/*  The Original Code is: all this file.                                    */
/*                                                                          */
/*  The Initial Developer of the Original Code is Adam Retter.              */
/*                                                                          */
/*  Contributor(s): none.                                                   */
/* ------------------------------------------------------------------------ */