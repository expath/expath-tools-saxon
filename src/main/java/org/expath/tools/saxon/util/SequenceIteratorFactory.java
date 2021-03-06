/****************************************************************************/
/*  File:       SequenceIteratorFactory.java                                */
/*  Author:     Adam Retter                                                 */
/*  Date:       2020-10-24                                                  */
/*  Tags:                                                                   */
/*      Copyright (c) 2020 Adam Retter     (see end of file.)               */
/* ------------------------------------------------------------------------ */
package org.expath.tools.saxon.util;

import net.sf.saxon.om.SequenceIterator;
import net.sf.saxon.trans.XPathException;

public interface SequenceIteratorFactory {
    SequenceIterator newIterator() throws XPathException;
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
