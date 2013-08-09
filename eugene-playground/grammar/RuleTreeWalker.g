tree grammar RuleTreeWalker;

options {
tokenVocab = Eugene;
ASTLabelType = RuleTree;
}

@header {
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

package eugene.parser;

import eugene.rules.parser.*;
}


rule	:   	notExpression
    	;

// -> ^('NOT' $exprToken)
// -> $exprToken
notExpression
	:	('NOT' orExpression)
	|	orExpression
	;

// -> ^('OR' $leftToken $rightToken)	
// -> $leftToken
orExpression
	:	('OR' andExpression notExpression)    	
	|	andExpression
	;
	
// -> ^('AND' $leftToken $rightToken)
// -> $leftToken
andExpression	
	:	('AND' xorExpression notExpression) 
	|	xorExpression
	;

xorExpression
	:	('XOR' comparativeExpression notExpression) 
	|	comparativeExpression
	;	
	
// -> ^($opToken $exprToken1 $exprToken2)	
// -> ^($opToken $exprToken)
// -> $exprToken1
comparativeExpression
	:	^(operator addExpression addExpression)
	|	addExpression
	;

// -> ^('+' $leftToken $rightToken)
// -> $leftToken
addExpression
	:	('+' subtractExpression addExpression)
	|	subtractExpression
	;	
	
subtractExpression
	:	('-' multExpression addExpression)
	|	multExpression
	;
	
multExpression
	:	(('*'|'/') expressionValue addExpression)
	|	expressionValue
	;	
	
// -> ^('(' $exprToken)
// -> $accessToken
expressionValue
	:	('(' rule)
	|	(minToken=MINUS)? numToken=(INT|FLOAT)
	|	txtToken=STRING
	|	boolToken=('true'|'false')
	|	accessToken = objectAccess
	;    	

operator
	:	relationalOperator
	|	ruleOperator
	|	('instanceof' | 'INSTANCEOF')
	;

objectAccess
	:	idToken=ID (arrayAccess|propertyAccess)*
	;
			
arrayAccess
	:	('[' ID ']')
	;

propertyAccess
	:	('.' ID)
	;		
	
ruleOperator
	:	'BEFORE'
	|	'AFTER'
	|	'STARTSWITH'
	|	'ENDSWITH'
	|	'WITH'
	|	'NEXTTO'
	|	'LEFTTO'
	|	'CONTAINS'
	|	'MORETHAN'
	|	'THEN'
	;

relationalOperator
	:	('==' | 'EQUALS')
	|	('!=' | 'NOTEQUALS')
	|	'<'
	|	'<='
	|	'>'
	|	'>='
	;
