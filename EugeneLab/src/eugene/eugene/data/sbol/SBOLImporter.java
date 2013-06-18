/*
Copyright (c) 2012 Boston University.
All rights reserved.
Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.

IN NO EVENT SHALL BOSTON UNIVERSITY BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
BOSTON UNIVERSITY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

BOSTON UNIVERSITY SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND BOSTON UNIVERSITY HAS
NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS.
 */

package eugene.data.sbol;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.sbolstandard.core.SBOLDocument;
import org.sbolstandard.core.SBOLFactory;
import org.sbolstandard.core.SBOLRootObject;

import eugene.data.sbol.mapping.SBOL2Eugene;
import eugene.dom.NamedElement;
import eugene.exception.EugeneException;
import eugene.parser.SymbolTables;

/**
 * 
 * @author Ernst Oberortner
 */
public class SBOLImporter {

	public static NamedElement importSBOL(String sFileName)
			throws EugeneException {
		SBOLDocument newDocument;
		try {
			newDocument = SBOLFactory.read(new FileInputStream(sFileName));

			List<NamedElement> lstElements = new ArrayList<NamedElement>();
			if (null != newDocument && null != newDocument.getContents()
					&& !newDocument.getContents().isEmpty()) {
				// first, create the SBOL properties
				for (SBOLRootObject sbolObj : newDocument.getContents()) {
					NamedElement objElement = SBOL2Eugene.convert(sbolObj);
					if (null != objElement) {
						SymbolTables.put(objElement);
						lstElements.add(objElement);
					}
				}
			}
			return lstElements.get(0);
		} catch (Exception e) {
			throw new EugeneException(e.getMessage());
		}
	}
}
