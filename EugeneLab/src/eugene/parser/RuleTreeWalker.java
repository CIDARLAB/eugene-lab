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

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({ "all", "warnings", "unchecked" })
public class RuleTreeWalker extends TreeParser {
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "CHAR", "COMMENT", "ESC_SEQ",
			"EXPONENT", "FLOAT", "HEX_DIGIT", "ID", "INCLUDE", "INT", "MINUS",
			"OCTAL_ESC", "STRING", "UNICODE_ESC", "WS", "'!='", "'&&'", "'('",
			"')'", "'*'", "'+'", "','", "'.'", "'.add'", "'/'", "':'", "';'",
			"'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'AFTER'", "'AND'",
			"'Assert'", "'BEFORE'", "'CONTAINS'", "'Collection'", "'Device'",
			"'DeviceType'", "'ENDSWITH'", "'EQUALS'", "'Genbank'",
			"'INSTANCEOF'", "'Image'", "'LEFTTO'", "'MORETHAN'", "'NEXTTO'",
			"'NOT'", "'NOTEQUALS'", "'Note'", "'ON'", "'OR'", "'Part'",
			"'PartType'", "'Property'", "'Rule'", "'SBOL'", "'STARTSWITH'",
			"'THEN'", "'WITH'", "'XOR'", "'['", "']'", "'^^'", "'boolean'",
			"'do'", "'else'", "'export'", "'false'", "'flexible'", "'for'",
			"'function'", "'get'", "'if'", "'import'", "'instanceof'",
			"'instantiate'", "'isEmpty'", "'num'", "'permute'", "'print'",
			"'println'", "'product'", "'return'", "'save'", "'size'",
			"'strict'", "'toSequence'", "'true'", "'txt'", "'while'", "'{'",
			"'||'", "'}'" };

	public static final int EOF = -1;
	public static final int T__18 = 18;
	public static final int T__19 = 19;
	public static final int T__20 = 20;
	public static final int T__21 = 21;
	public static final int T__22 = 22;
	public static final int T__23 = 23;
	public static final int T__24 = 24;
	public static final int T__25 = 25;
	public static final int T__26 = 26;
	public static final int T__27 = 27;
	public static final int T__28 = 28;
	public static final int T__29 = 29;
	public static final int T__30 = 30;
	public static final int T__31 = 31;
	public static final int T__32 = 32;
	public static final int T__33 = 33;
	public static final int T__34 = 34;
	public static final int T__35 = 35;
	public static final int T__36 = 36;
	public static final int T__37 = 37;
	public static final int T__38 = 38;
	public static final int T__39 = 39;
	public static final int T__40 = 40;
	public static final int T__41 = 41;
	public static final int T__42 = 42;
	public static final int T__43 = 43;
	public static final int T__44 = 44;
	public static final int T__45 = 45;
	public static final int T__46 = 46;
	public static final int T__47 = 47;
	public static final int T__48 = 48;
	public static final int T__49 = 49;
	public static final int T__50 = 50;
	public static final int T__51 = 51;
	public static final int T__52 = 52;
	public static final int T__53 = 53;
	public static final int T__54 = 54;
	public static final int T__55 = 55;
	public static final int T__56 = 56;
	public static final int T__57 = 57;
	public static final int T__58 = 58;
	public static final int T__59 = 59;
	public static final int T__60 = 60;
	public static final int T__61 = 61;
	public static final int T__62 = 62;
	public static final int T__63 = 63;
	public static final int T__64 = 64;
	public static final int T__65 = 65;
	public static final int T__66 = 66;
	public static final int T__67 = 67;
	public static final int T__68 = 68;
	public static final int T__69 = 69;
	public static final int T__70 = 70;
	public static final int T__71 = 71;
	public static final int T__72 = 72;
	public static final int T__73 = 73;
	public static final int T__74 = 74;
	public static final int T__75 = 75;
	public static final int T__76 = 76;
	public static final int T__77 = 77;
	public static final int T__78 = 78;
	public static final int T__79 = 79;
	public static final int T__80 = 80;
	public static final int T__81 = 81;
	public static final int T__82 = 82;
	public static final int T__83 = 83;
	public static final int T__84 = 84;
	public static final int T__85 = 85;
	public static final int T__86 = 86;
	public static final int T__87 = 87;
	public static final int T__88 = 88;
	public static final int T__89 = 89;
	public static final int T__90 = 90;
	public static final int T__91 = 91;
	public static final int T__92 = 92;
	public static final int T__93 = 93;
	public static final int T__94 = 94;
	public static final int T__95 = 95;
	public static final int T__96 = 96;
	public static final int T__97 = 97;
	public static final int T__98 = 98;
	public static final int CHAR = 4;
	public static final int COMMENT = 5;
	public static final int ESC_SEQ = 6;
	public static final int EXPONENT = 7;
	public static final int FLOAT = 8;
	public static final int HEX_DIGIT = 9;
	public static final int ID = 10;
	public static final int INCLUDE = 11;
	public static final int INT = 12;
	public static final int MINUS = 13;
	public static final int OCTAL_ESC = 14;
	public static final int STRING = 15;
	public static final int UNICODE_ESC = 16;
	public static final int WS = 17;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators

	public RuleTreeWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}

	public RuleTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	public String[] getTokenNames() {
		return RuleTreeWalker.tokenNames;
	}

	public String getGrammarFileName() {
		return "/Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g";
	}

	// $ANTLR start "rule"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:37:1:
	// rule : notExpression ;
	public final void rule() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:37:6:
			// ( notExpression )
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:37:11:
			// notExpression
			{
				pushFollow(FOLLOW_notExpression_in_rule41);
				notExpression();

				state._fsp--;

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "rule"

	// $ANTLR start "notExpression"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:42:1:
	// notExpression : ( ( 'NOT' orExpression ) | orExpression );
	public final void notExpression() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:43:2:
			// ( ( 'NOT' orExpression ) | orExpression )
			int alt1 = 2;
			int LA1_0 = input.LA(1);

			if ((LA1_0 == 52)) {
				alt1 = 1;
			} else if ((LA1_0 == FLOAT || LA1_0 == ID
					|| (LA1_0 >= INT && LA1_0 <= MINUS) || LA1_0 == STRING
					|| LA1_0 == 18 || LA1_0 == 20
					|| (LA1_0 >= 22 && LA1_0 <= 23) || LA1_0 == 27
					|| (LA1_0 >= 30 && LA1_0 <= 31)
					|| (LA1_0 >= 33 && LA1_0 <= 37)
					|| (LA1_0 >= 39 && LA1_0 <= 40)
					|| (LA1_0 >= 44 && LA1_0 <= 45) || LA1_0 == 47
					|| (LA1_0 >= 49 && LA1_0 <= 51) || LA1_0 == 53
					|| LA1_0 == 56 || (LA1_0 >= 62 && LA1_0 <= 65)
					|| LA1_0 == 73 || LA1_0 == 80 || LA1_0 == 93)) {
				alt1 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 1, 0,
						input);

				throw nvae;

			}
			switch (alt1) {
			case 1:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:43:4:
			// ( 'NOT' orExpression )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:43:4:
				// ( 'NOT' orExpression )
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:43:5:
				// 'NOT' orExpression
				{
					match(input, 52, FOLLOW_52_in_notExpression59);

					pushFollow(FOLLOW_orExpression_in_notExpression61);
					orExpression();

					state._fsp--;

				}

			}
				break;
			case 2:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:44:4:
			// orExpression
			{
				pushFollow(FOLLOW_orExpression_in_notExpression67);
				orExpression();

				state._fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "notExpression"

	// $ANTLR start "orExpression"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:49:1:
	// orExpression : ( ( 'OR' andExpression notExpression ) | andExpression );
	public final void orExpression() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:50:2:
			// ( ( 'OR' andExpression notExpression ) | andExpression )
			int alt2 = 2;
			int LA2_0 = input.LA(1);

			if ((LA2_0 == 56)) {
				alt2 = 1;
			} else if ((LA2_0 == FLOAT || LA2_0 == ID
					|| (LA2_0 >= INT && LA2_0 <= MINUS) || LA2_0 == STRING
					|| LA2_0 == 18 || LA2_0 == 20
					|| (LA2_0 >= 22 && LA2_0 <= 23) || LA2_0 == 27
					|| (LA2_0 >= 30 && LA2_0 <= 31)
					|| (LA2_0 >= 33 && LA2_0 <= 37)
					|| (LA2_0 >= 39 && LA2_0 <= 40)
					|| (LA2_0 >= 44 && LA2_0 <= 45) || LA2_0 == 47
					|| (LA2_0 >= 49 && LA2_0 <= 51) || LA2_0 == 53
					|| (LA2_0 >= 62 && LA2_0 <= 65) || LA2_0 == 73
					|| LA2_0 == 80 || LA2_0 == 93)) {
				alt2 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 2, 0,
						input);

				throw nvae;

			}
			switch (alt2) {
			case 1:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:50:4:
			// ( 'OR' andExpression notExpression )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:50:4:
				// ( 'OR' andExpression notExpression )
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:50:5:
				// 'OR' andExpression notExpression
				{
					match(input, 56, FOLLOW_56_in_orExpression81);

					pushFollow(FOLLOW_andExpression_in_orExpression83);
					andExpression();

					state._fsp--;

					pushFollow(FOLLOW_notExpression_in_orExpression85);
					notExpression();

					state._fsp--;

				}

			}
				break;
			case 2:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:51:4:
			// andExpression
			{
				pushFollow(FOLLOW_andExpression_in_orExpression96);
				andExpression();

				state._fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "orExpression"

	// $ANTLR start "andExpression"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:56:1:
	// andExpression : ( ( 'AND' xorExpression notExpression ) | xorExpression
	// );
	public final void andExpression() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:57:2:
			// ( ( 'AND' xorExpression notExpression ) | xorExpression )
			int alt3 = 2;
			int LA3_0 = input.LA(1);

			if ((LA3_0 == 37)) {
				alt3 = 1;
			} else if ((LA3_0 == FLOAT || LA3_0 == ID
					|| (LA3_0 >= INT && LA3_0 <= MINUS) || LA3_0 == STRING
					|| LA3_0 == 18 || LA3_0 == 20
					|| (LA3_0 >= 22 && LA3_0 <= 23) || LA3_0 == 27
					|| (LA3_0 >= 30 && LA3_0 <= 31)
					|| (LA3_0 >= 33 && LA3_0 <= 36)
					|| (LA3_0 >= 39 && LA3_0 <= 40)
					|| (LA3_0 >= 44 && LA3_0 <= 45) || LA3_0 == 47
					|| (LA3_0 >= 49 && LA3_0 <= 51) || LA3_0 == 53
					|| (LA3_0 >= 62 && LA3_0 <= 65) || LA3_0 == 73
					|| LA3_0 == 80 || LA3_0 == 93)) {
				alt3 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 3, 0,
						input);

				throw nvae;

			}
			switch (alt3) {
			case 1:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:57:4:
			// ( 'AND' xorExpression notExpression )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:57:4:
				// ( 'AND' xorExpression notExpression )
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:57:5:
				// 'AND' xorExpression notExpression
				{
					match(input, 37, FOLLOW_37_in_andExpression112);

					pushFollow(FOLLOW_xorExpression_in_andExpression114);
					xorExpression();

					state._fsp--;

					pushFollow(FOLLOW_notExpression_in_andExpression116);
					notExpression();

					state._fsp--;

				}

			}
				break;
			case 2:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:58:4:
			// xorExpression
			{
				pushFollow(FOLLOW_xorExpression_in_andExpression123);
				xorExpression();

				state._fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "andExpression"

	// $ANTLR start "xorExpression"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:61:1:
	// xorExpression : ( ( 'XOR' comparativeExpression notExpression ) |
	// comparativeExpression );
	public final void xorExpression() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:62:2:
			// ( ( 'XOR' comparativeExpression notExpression ) |
			// comparativeExpression )
			int alt4 = 2;
			int LA4_0 = input.LA(1);

			if ((LA4_0 == 65)) {
				alt4 = 1;
			} else if ((LA4_0 == FLOAT || LA4_0 == ID
					|| (LA4_0 >= INT && LA4_0 <= MINUS) || LA4_0 == STRING
					|| LA4_0 == 18 || LA4_0 == 20
					|| (LA4_0 >= 22 && LA4_0 <= 23) || LA4_0 == 27
					|| (LA4_0 >= 30 && LA4_0 <= 31)
					|| (LA4_0 >= 33 && LA4_0 <= 36)
					|| (LA4_0 >= 39 && LA4_0 <= 40)
					|| (LA4_0 >= 44 && LA4_0 <= 45) || LA4_0 == 47
					|| (LA4_0 >= 49 && LA4_0 <= 51) || LA4_0 == 53
					|| (LA4_0 >= 62 && LA4_0 <= 64) || LA4_0 == 73
					|| LA4_0 == 80 || LA4_0 == 93)) {
				alt4 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 4, 0,
						input);

				throw nvae;

			}
			switch (alt4) {
			case 1:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:62:4:
			// ( 'XOR' comparativeExpression notExpression )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:62:4:
				// ( 'XOR' comparativeExpression notExpression )
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:62:5:
				// 'XOR' comparativeExpression notExpression
				{
					match(input, 65, FOLLOW_65_in_xorExpression135);

					pushFollow(FOLLOW_comparativeExpression_in_xorExpression137);
					comparativeExpression();

					state._fsp--;

					pushFollow(FOLLOW_notExpression_in_xorExpression139);
					notExpression();

					state._fsp--;

				}

			}
				break;
			case 2:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:63:4:
			// comparativeExpression
			{
				pushFollow(FOLLOW_comparativeExpression_in_xorExpression146);
				comparativeExpression();

				state._fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "xorExpression"

	// $ANTLR start "comparativeExpression"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:69:1:
	// comparativeExpression : ( ^( operator addExpression addExpression ) |
	// addExpression );
	public final void comparativeExpression() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:70:2:
			// ( ^( operator addExpression addExpression ) | addExpression )
			int alt5 = 2;
			int LA5_0 = input.LA(1);

			if ((LA5_0 == 18 || (LA5_0 >= 30 && LA5_0 <= 31)
					|| (LA5_0 >= 33 && LA5_0 <= 36)
					|| (LA5_0 >= 39 && LA5_0 <= 40)
					|| (LA5_0 >= 44 && LA5_0 <= 45) || LA5_0 == 47
					|| (LA5_0 >= 49 && LA5_0 <= 51) || LA5_0 == 53
					|| (LA5_0 >= 62 && LA5_0 <= 64) || LA5_0 == 80)) {
				alt5 = 1;
			} else if ((LA5_0 == FLOAT || LA5_0 == ID
					|| (LA5_0 >= INT && LA5_0 <= MINUS) || LA5_0 == STRING
					|| LA5_0 == 20 || (LA5_0 >= 22 && LA5_0 <= 23)
					|| LA5_0 == 27 || LA5_0 == 73 || LA5_0 == 93)) {
				alt5 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 5, 0,
						input);

				throw nvae;

			}
			switch (alt5) {
			case 1:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:70:4:
			// ^( operator addExpression addExpression )
			{
				pushFollow(FOLLOW_operator_in_comparativeExpression163);
				operator();

				state._fsp--;

				match(input, Token.DOWN, null);
				pushFollow(FOLLOW_addExpression_in_comparativeExpression165);
				addExpression();

				state._fsp--;

				pushFollow(FOLLOW_addExpression_in_comparativeExpression167);
				addExpression();

				state._fsp--;

				match(input, Token.UP, null);

			}
				break;
			case 2:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:71:4:
			// addExpression
			{
				pushFollow(FOLLOW_addExpression_in_comparativeExpression173);
				addExpression();

				state._fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "comparativeExpression"

	// $ANTLR start "addExpression"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:76:1:
	// addExpression : ( ( '+' subtractExpression addExpression ) |
	// subtractExpression );
	public final void addExpression() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:77:2:
			// ( ( '+' subtractExpression addExpression ) | subtractExpression )
			int alt6 = 2;
			int LA6_0 = input.LA(1);

			if ((LA6_0 == 23)) {
				alt6 = 1;
			} else if ((LA6_0 == FLOAT || LA6_0 == ID
					|| (LA6_0 >= INT && LA6_0 <= MINUS) || LA6_0 == STRING
					|| LA6_0 == 20 || LA6_0 == 22 || LA6_0 == 27 || LA6_0 == 73 || LA6_0 == 93)) {
				alt6 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 6, 0,
						input);

				throw nvae;

			}
			switch (alt6) {
			case 1:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:77:4:
			// ( '+' subtractExpression addExpression )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:77:4:
				// ( '+' subtractExpression addExpression )
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:77:5:
				// '+' subtractExpression addExpression
				{
					match(input, 23, FOLLOW_23_in_addExpression187);

					pushFollow(FOLLOW_subtractExpression_in_addExpression189);
					subtractExpression();

					state._fsp--;

					pushFollow(FOLLOW_addExpression_in_addExpression191);
					addExpression();

					state._fsp--;

				}

			}
				break;
			case 2:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:78:4:
			// subtractExpression
			{
				pushFollow(FOLLOW_subtractExpression_in_addExpression197);
				subtractExpression();

				state._fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "addExpression"

	// $ANTLR start "subtractExpression"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:81:1:
	// subtractExpression : ( ( '-' multExpression addExpression ) |
	// multExpression );
	public final void subtractExpression() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:82:2:
			// ( ( '-' multExpression addExpression ) | multExpression )
			int alt7 = 2;
			int LA7_0 = input.LA(1);

			if ((LA7_0 == MINUS)) {
				int LA7_1 = input.LA(2);

				if ((LA7_1 == MINUS || LA7_1 == 20 || LA7_1 == 22 || LA7_1 == 27)) {
					alt7 = 1;
				} else if ((LA7_1 == FLOAT || LA7_1 == ID || LA7_1 == INT
						|| LA7_1 == STRING || LA7_1 == 73 || LA7_1 == 93)) {
					alt7 = 1;
				} else {
					NoViableAltException nvae = new NoViableAltException("", 7,
							1, input);

					throw nvae;

				}
			} else if ((LA7_0 == FLOAT || LA7_0 == ID || LA7_0 == INT
					|| LA7_0 == STRING || LA7_0 == 20 || LA7_0 == 22
					|| LA7_0 == 27 || LA7_0 == 73 || LA7_0 == 93)) {
				alt7 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 7, 0,
						input);

				throw nvae;

			}
			switch (alt7) {
			case 1:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:82:4:
			// ( '-' multExpression addExpression )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:82:4:
				// ( '-' multExpression addExpression )
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:82:5:
				// '-' multExpression addExpression
				{
					match(input, MINUS, FOLLOW_MINUS_in_subtractExpression211);

					pushFollow(FOLLOW_multExpression_in_subtractExpression213);
					multExpression();

					state._fsp--;

					pushFollow(FOLLOW_addExpression_in_subtractExpression215);
					addExpression();

					state._fsp--;

				}

			}
				break;
			case 2:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:83:4:
			// multExpression
			{
				pushFollow(FOLLOW_multExpression_in_subtractExpression221);
				multExpression();

				state._fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "subtractExpression"

	// $ANTLR start "multExpression"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:86:1:
	// multExpression : ( ( ( '*' | '/' ) expressionValue addExpression ) |
	// expressionValue );
	public final void multExpression() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:87:2:
			// ( ( ( '*' | '/' ) expressionValue addExpression ) |
			// expressionValue )
			int alt8 = 2;
			int LA8_0 = input.LA(1);

			if ((LA8_0 == 22 || LA8_0 == 27)) {
				alt8 = 1;
			} else if ((LA8_0 == FLOAT || LA8_0 == ID
					|| (LA8_0 >= INT && LA8_0 <= MINUS) || LA8_0 == STRING
					|| LA8_0 == 20 || LA8_0 == 73 || LA8_0 == 93)) {
				alt8 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 8, 0,
						input);

				throw nvae;

			}
			switch (alt8) {
			case 1:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:87:4:
			// ( ( '*' | '/' ) expressionValue addExpression )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:87:4:
				// ( ( '*' | '/' ) expressionValue addExpression )
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:87:5:
				// ( '*' | '/' ) expressionValue addExpression
				{
					if (input.LA(1) == 22 || input.LA(1) == 27) {
						input.consume();
						state.errorRecovery = false;
					} else {
						MismatchedSetException mse = new MismatchedSetException(
								null, input);
						throw mse;
					}

					pushFollow(FOLLOW_expressionValue_in_multExpression240);
					expressionValue();

					state._fsp--;

					pushFollow(FOLLOW_addExpression_in_multExpression242);
					addExpression();

					state._fsp--;

				}

			}
				break;
			case 2:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:88:4:
			// expressionValue
			{
				pushFollow(FOLLOW_expressionValue_in_multExpression248);
				expressionValue();

				state._fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "multExpression"

	// $ANTLR start "expressionValue"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:93:1:
	// expressionValue : ( ( '(' rule ) | (minToken= MINUS )? numToken= ( INT |
	// FLOAT ) |txtToken= STRING |boolToken= ( 'true' | 'false' ) |accessToken=
	// objectAccess );
	public final void expressionValue() throws RecognitionException {
		RuleTree minToken = null;
		RuleTree numToken = null;
		RuleTree txtToken = null;
		RuleTree boolToken = null;

		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:94:2:
			// ( ( '(' rule ) | (minToken= MINUS )? numToken= ( INT | FLOAT )
			// |txtToken= STRING |boolToken= ( 'true' | 'false' ) |accessToken=
			// objectAccess )
			int alt10 = 5;
			switch (input.LA(1)) {
			case 20: {
				alt10 = 1;
			}
				break;
			case FLOAT:
			case INT:
			case MINUS: {
				alt10 = 2;
			}
				break;
			case STRING: {
				alt10 = 3;
			}
				break;
			case 73:
			case 93: {
				alt10 = 4;
			}
				break;
			case ID: {
				alt10 = 5;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 10, 0,
						input);

				throw nvae;

			}

			switch (alt10) {
			case 1:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:94:4:
			// ( '(' rule )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:94:4:
				// ( '(' rule )
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:94:5:
				// '(' rule
				{
					match(input, 20, FOLLOW_20_in_expressionValue264);

					pushFollow(FOLLOW_rule_in_expressionValue266);
					rule();

					state._fsp--;

				}

			}
				break;
			case 2:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:95:4:
			// (minToken= MINUS )? numToken= ( INT | FLOAT )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:95:4:
				// (minToken= MINUS )?
				int alt9 = 2;
				int LA9_0 = input.LA(1);

				if ((LA9_0 == MINUS)) {
					alt9 = 1;
				}
				switch (alt9) {
				case 1:
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:95:5:
				// minToken= MINUS
				{
					minToken = (RuleTree) match(input, MINUS,
							FOLLOW_MINUS_in_expressionValue275);

				}
					break;

				}

				numToken = (RuleTree) input.LT(1);

				if (input.LA(1) == FLOAT || input.LA(1) == INT) {
					input.consume();
					state.errorRecovery = false;
				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					throw mse;
				}

			}
				break;
			case 3:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:96:4:
			// txtToken= STRING
			{
				txtToken = (RuleTree) match(input, STRING,
						FOLLOW_STRING_in_expressionValue292);

			}
				break;
			case 4:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:97:4:
			// boolToken= ( 'true' | 'false' )
			{
				boolToken = (RuleTree) input.LT(1);

				if (input.LA(1) == 73 || input.LA(1) == 93) {
					input.consume();
					state.errorRecovery = false;
				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					throw mse;
				}

			}
				break;
			case 5:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:98:4:
			// accessToken= objectAccess
			{
				pushFollow(FOLLOW_objectAccess_in_expressionValue312);
				objectAccess();

				state._fsp--;

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "expressionValue"

	// $ANTLR start "operator"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:101:1:
	// operator : ( relationalOperator | ruleOperator | ( 'instanceof' |
	// 'INSTANCEOF' ) );
	public final void operator() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:102:2:
			// ( relationalOperator | ruleOperator | ( 'instanceof' |
			// 'INSTANCEOF' ) )
			int alt11 = 3;
			switch (input.LA(1)) {
			case 18:
			case 30:
			case 31:
			case 33:
			case 34:
			case 35:
			case 45:
			case 53: {
				alt11 = 1;
			}
				break;
			case 36:
			case 39:
			case 40:
			case 44:
			case 49:
			case 50:
			case 51:
			case 62:
			case 63:
			case 64: {
				alt11 = 2;
			}
				break;
			case 47:
			case 80: {
				alt11 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 11, 0,
						input);

				throw nvae;

			}

			switch (alt11) {
			case 1:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:102:4:
			// relationalOperator
			{
				pushFollow(FOLLOW_relationalOperator_in_operator328);
				relationalOperator();

				state._fsp--;

			}
				break;
			case 2:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:103:4:
			// ruleOperator
			{
				pushFollow(FOLLOW_ruleOperator_in_operator333);
				ruleOperator();

				state._fsp--;

			}
				break;
			case 3:
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:104:4:
			// ( 'instanceof' | 'INSTANCEOF' )
			{
				if (input.LA(1) == 47 || input.LA(1) == 80) {
					input.consume();
					state.errorRecovery = false;
				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					throw mse;
				}

			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "operator"

	// $ANTLR start "objectAccess"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:107:1:
	// objectAccess : idToken= ID ( arrayAccess | propertyAccess )* ;
	public final void objectAccess() throws RecognitionException {
		RuleTree idToken = null;

		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:108:2:
			// (idToken= ID ( arrayAccess | propertyAccess )* )
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:108:4:
			// idToken= ID ( arrayAccess | propertyAccess )*
			{
				idToken = (RuleTree) match(input, ID,
						FOLLOW_ID_in_objectAccess357);

				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:108:15:
				// ( arrayAccess | propertyAccess )*
				loop12: do {
					int alt12 = 3;
					int LA12_0 = input.LA(1);

					if ((LA12_0 == 66)) {
						alt12 = 1;
					} else if ((LA12_0 == 25)) {
						alt12 = 2;
					}

					switch (alt12) {
					case 1:
					// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:108:16:
					// arrayAccess
					{
						pushFollow(FOLLOW_arrayAccess_in_objectAccess360);
						arrayAccess();

						state._fsp--;

					}
						break;
					case 2:
					// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:108:28:
					// propertyAccess
					{
						pushFollow(FOLLOW_propertyAccess_in_objectAccess362);
						propertyAccess();

						state._fsp--;

					}
						break;

					default:
						break loop12;
					}
				} while (true);

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "objectAccess"

	// $ANTLR start "arrayAccess"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:111:1:
	// arrayAccess : ( '[' ID ']' ) ;
	public final void arrayAccess() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:112:2:
			// ( ( '[' ID ']' ) )
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:112:4:
			// ( '[' ID ']' )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:112:4:
				// ( '[' ID ']' )
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:112:5:
				// '[' ID ']'
				{
					match(input, 66, FOLLOW_66_in_arrayAccess379);

					match(input, ID, FOLLOW_ID_in_arrayAccess381);

					match(input, 67, FOLLOW_67_in_arrayAccess383);

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "arrayAccess"

	// $ANTLR start "propertyAccess"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:115:1:
	// propertyAccess : ( '.' ID ) ;
	public final void propertyAccess() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:116:2:
			// ( ( '.' ID ) )
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:116:4:
			// ( '.' ID )
			{
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:116:4:
				// ( '.' ID )
				// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:116:5:
				// '.' ID
				{
					match(input, 25, FOLLOW_25_in_propertyAccess396);

					match(input, ID, FOLLOW_ID_in_propertyAccess398);

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "propertyAccess"

	// $ANTLR start "ruleOperator"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:119:1:
	// ruleOperator : ( 'BEFORE' | 'AFTER' | 'STARTSWITH' | 'ENDSWITH' | 'WITH'
	// | 'NEXTTO' | 'LEFTTO' | 'CONTAINS' | 'MORETHAN' | 'THEN' );
	public final void ruleOperator() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:120:2:
			// ( 'BEFORE' | 'AFTER' | 'STARTSWITH' | 'ENDSWITH' | 'WITH' |
			// 'NEXTTO' | 'LEFTTO' | 'CONTAINS' | 'MORETHAN' | 'THEN' )
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:
			{
				if (input.LA(1) == 36
						|| (input.LA(1) >= 39 && input.LA(1) <= 40)
						|| input.LA(1) == 44
						|| (input.LA(1) >= 49 && input.LA(1) <= 51)
						|| (input.LA(1) >= 62 && input.LA(1) <= 64)) {
					input.consume();
					state.errorRecovery = false;
				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					throw mse;
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "ruleOperator"

	// $ANTLR start "relationalOperator"
	// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:132:1:
	// relationalOperator : ( ( '==' | 'EQUALS' ) | ( '!=' | 'NOTEQUALS' ) | '<'
	// | '<=' | '>' | '>=' );
	public final void relationalOperator() throws RecognitionException {
		try {
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:133:2:
			// ( ( '==' | 'EQUALS' ) | ( '!=' | 'NOTEQUALS' ) | '<' | '<=' | '>'
			// | '>=' )
			// /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8/grammar/RuleTreeWalker.g:
			{
				if (input.LA(1) == 18
						|| (input.LA(1) >= 30 && input.LA(1) <= 31)
						|| (input.LA(1) >= 33 && input.LA(1) <= 35)
						|| input.LA(1) == 45 || input.LA(1) == 53) {
					input.consume();
					state.errorRecovery = false;
				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					throw mse;
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return;
	}

	// $ANTLR end "relationalOperator"

	// Delegated rules

	public static final BitSet FOLLOW_notExpression_in_rule41 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_52_in_notExpression59 = new BitSet(
			new long[] { 0xC12EB1BEC8D4B500L, 0x0000000020010203L });
	public static final BitSet FOLLOW_orExpression_in_notExpression61 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_orExpression_in_notExpression67 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_56_in_orExpression81 = new BitSet(
			new long[] { 0xC02EB1BEC8D4B500L, 0x0000000020010203L });
	public static final BitSet FOLLOW_andExpression_in_orExpression83 = new BitSet(
			new long[] { 0xC13EB1BEC8D4B500L, 0x0000000020010203L });
	public static final BitSet FOLLOW_notExpression_in_orExpression85 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_andExpression_in_orExpression96 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_37_in_andExpression112 = new BitSet(
			new long[] { 0xC02EB19EC8D4B500L, 0x0000000020010203L });
	public static final BitSet FOLLOW_xorExpression_in_andExpression114 = new BitSet(
			new long[] { 0xC13EB1BEC8D4B500L, 0x0000000020010203L });
	public static final BitSet FOLLOW_notExpression_in_andExpression116 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_xorExpression_in_andExpression123 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_65_in_xorExpression135 = new BitSet(
			new long[] { 0xC02EB19EC8D4B500L, 0x0000000020010201L });
	public static final BitSet FOLLOW_comparativeExpression_in_xorExpression137 = new BitSet(
			new long[] { 0xC13EB1BEC8D4B500L, 0x0000000020010203L });
	public static final BitSet FOLLOW_notExpression_in_xorExpression139 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_comparativeExpression_in_xorExpression146 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_operator_in_comparativeExpression163 = new BitSet(
			new long[] { 0x0000000000000004L });
	public static final BitSet FOLLOW_addExpression_in_comparativeExpression165 = new BitSet(
			new long[] { 0x0000000008D0B500L, 0x0000000020000200L });
	public static final BitSet FOLLOW_addExpression_in_comparativeExpression167 = new BitSet(
			new long[] { 0x0000000000000008L });
	public static final BitSet FOLLOW_addExpression_in_comparativeExpression173 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_23_in_addExpression187 = new BitSet(
			new long[] { 0x000000000850B500L, 0x0000000020000200L });
	public static final BitSet FOLLOW_subtractExpression_in_addExpression189 = new BitSet(
			new long[] { 0x0000000008D0B500L, 0x0000000020000200L });
	public static final BitSet FOLLOW_addExpression_in_addExpression191 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_subtractExpression_in_addExpression197 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_subtractExpression211 = new BitSet(
			new long[] { 0x000000000850B500L, 0x0000000020000200L });
	public static final BitSet FOLLOW_multExpression_in_subtractExpression213 = new BitSet(
			new long[] { 0x0000000008D0B500L, 0x0000000020000200L });
	public static final BitSet FOLLOW_addExpression_in_subtractExpression215 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_multExpression_in_subtractExpression221 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_set_in_multExpression234 = new BitSet(
			new long[] { 0x000000000010B500L, 0x0000000020000200L });
	public static final BitSet FOLLOW_expressionValue_in_multExpression240 = new BitSet(
			new long[] { 0x0000000008D0B500L, 0x0000000020000200L });
	public static final BitSet FOLLOW_addExpression_in_multExpression242 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expressionValue_in_multExpression248 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_20_in_expressionValue264 = new BitSet(
			new long[] { 0xC13EB1BEC8D4B500L, 0x0000000020010203L });
	public static final BitSet FOLLOW_rule_in_expressionValue266 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_expressionValue275 = new BitSet(
			new long[] { 0x0000000000001100L });
	public static final BitSet FOLLOW_set_in_expressionValue281 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_STRING_in_expressionValue292 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_set_in_expressionValue299 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_objectAccess_in_expressionValue312 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_relationalOperator_in_operator328 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ruleOperator_in_operator333 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_set_in_operator338 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ID_in_objectAccess357 = new BitSet(
			new long[] { 0x0000000002000002L, 0x0000000000000004L });
	public static final BitSet FOLLOW_arrayAccess_in_objectAccess360 = new BitSet(
			new long[] { 0x0000000002000002L, 0x0000000000000004L });
	public static final BitSet FOLLOW_propertyAccess_in_objectAccess362 = new BitSet(
			new long[] { 0x0000000002000002L, 0x0000000000000004L });
	public static final BitSet FOLLOW_66_in_arrayAccess379 = new BitSet(
			new long[] { 0x0000000000000400L });
	public static final BitSet FOLLOW_ID_in_arrayAccess381 = new BitSet(
			new long[] { 0x0000000000000000L, 0x0000000000000008L });
	public static final BitSet FOLLOW_67_in_arrayAccess383 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_25_in_propertyAccess396 = new BitSet(
			new long[] { 0x0000000000000400L });
	public static final BitSet FOLLOW_ID_in_propertyAccess398 = new BitSet(
			new long[] { 0x0000000000000002L });

}