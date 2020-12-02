/****************************************************************************/
/*  File:       TreeBuilderHelper.java                                      */
/*  Author:     F. Georges - fgeorges.org                                   */
/*  Date:       2009-02-02                                                  */
/*  Tags:                                                                   */
/*      Copyright (c) 2009 Florent Georges (see end of file.)               */
/* ------------------------------------------------------------------------ */


package org.expath.tools.saxon.model;

import net.sf.saxon.expr.XPathContext;
import net.sf.saxon.om.NodeInfo;
import net.sf.saxon.s9api.BuildingStreamWriter;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import org.expath.tools.ToolsException;
import org.expath.tools.model.TreeBuilder;

import javax.xml.stream.XMLStreamException;

/**
 * Implementation of {@link TreeBuilder} for Saxon.
 *
 * @author Florent Georges
 */
public class SaxonTreeBuilder
        implements TreeBuilder
{
    public SaxonTreeBuilder(XPathContext ctxt, String prefix, String ns)
            throws ToolsException
    {
        myNs = ns;
        myPrefix = prefix;
        try {
            Processor processor = (Processor) ctxt.getConfiguration().getProcessor();
            DocumentBuilder builder = processor.newDocumentBuilder();
            writer = builder.newBuildingStreamWriter();
            writer.writeStartDocument();
            writer.writeNamespace(prefix, ns);
        } catch (SaxonApiException | XMLStreamException ex) {
            throw new ToolsException("Could not create Saxon builder", ex);
        }
    }

    /**
     * Provide the result in Saxon's object tools.
     *
     * @return the node info
     *
     * @throws ToolsException if the root cannot be obtained
     */
    public NodeInfo getCurrentRoot()
            throws ToolsException
    {
        try {
            writer.writeEndDocument();
            writer.close();
            return writer.getDocumentNode().getUnderlyingNode();
        } catch (XMLStreamException ex) {
            throw new ToolsException("Error closing the Saxon tree builder", ex);
        } catch (SaxonApiException ex) {
            throw new ToolsException("Error getting root node", ex);
        }
    }

    @Override
    public void startElem(String localname)
            throws ToolsException
    {
        try {
            writer.writeStartElement(myPrefix, localname, myNs);
        } catch (XMLStreamException ex) {
            throw new ToolsException("Error starting element on the Saxon tree builder", ex);
        }
    }

    @Override
    public void attribute(String localname, CharSequence value)
            throws ToolsException
    {
        try {
            writer.writeAttribute(localname, (String) value);
        } catch (XMLStreamException ex) {
            throw new ToolsException("Error creating attribute on the Saxon tree builder", ex);
        }
    }

    @Override
    public void startContent()
            throws ToolsException
    {}

    @Override
    public void endElem()
            throws ToolsException
    {
        try {
            writer.writeEndElement();
        } catch (XMLStreamException ex) {
            throw new ToolsException("Error ending element on the Saxon tree builder", ex);
        }
    }

    private final BuildingStreamWriter writer;
    /** The namespace used for the elements. */
    private final String myNs;
    /** The prefix used for the elements. */
    private final String myPrefix;
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
/*  The Initial Developer of the Original Code is Florent Georges.          */
/*                                                                          */
/*  Contributor(s): none.                                                   */
/* ------------------------------------------------------------------------ */
