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

package eugene;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.LogManager;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import eugene.dom.SavableElement;
import eugene.output.ResultSet;
import eugene.parser.EugeneLexer;
import eugene.parser.EugeneParser;
import eugene.util.EugeneUtil;

public class EugeneExecutor {

	// nOutput indicates how the devices should be printed
	// nReturn == 0 -> no return (default)
	// nReturn == 1 -> Strings
	// nReturn == 2 -> Eugene Components
	public static Object execute(String sScript, int nReturn)
			throws RecognitionException {

		LogManager.getLogManager().reset();

		EugeneLexer lexer = new EugeneLexer(new ANTLRStringStream(sScript));
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		EugeneParser parser = new EugeneParser(tokens);
		parser.initSymbolTables();
		parser.prog();

		Object results = null;
		if (nReturn == 1 || nReturn == 2) {
			// return the components of the result set as strings
			ResultSet rs = parser.getResultSet();
			if (null != rs) {
				HashMap<String, SavableElement> hmComponents = rs.getResults();
				if (nReturn == 2) {
					results = new HashMap<String, SavableElement>();
					Iterator<String> it = hmComponents.keySet().iterator();
					while (it.hasNext()) {
						String sKey = it.next();
						((HashMap<String, SavableElement>) results).put(
								new String(sKey), hmComponents.get(sKey));
					}
				} else {
					results = new String[hmComponents.size()];
					Iterator<String> it = hmComponents.keySet().iterator();

					int i = 0;
					while (it.hasNext()) {
						SavableElement objElement = hmComponents.get(it.next());
						if (null != objElement) {
							((String[]) results)[i++] = objElement.toString();							
						}
					}
				}
			}
		}

		// clean up the symbol tables
		parser.cleanUpNoExit();

		return results;
	}

	// nReturn == 0 -> no return
	// nReturn == 1 -> return components as Strings
	// nReturn == 2 -> return components in a hash map
	public static Object execute(File fScript, int nReturn)
			throws RecognitionException, IOException {
		// read the file's content
		return EugeneExecutor.execute(EugeneUtil.readFile(fScript), nReturn);
	}
}
