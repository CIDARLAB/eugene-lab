// $ANTLR 3.4 /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g 2013-06-17 10:17:46

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class EugeneLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__99=99;
    public static final int CHAR=4;
    public static final int COMMENT=5;
    public static final int DYNAMIC_NAME=6;
    public static final int ESC_SEQ=7;
    public static final int EXPONENT=8;
    public static final int FLOAT=9;
    public static final int HEX_DIGIT=10;
    public static final int ID=11;
    public static final int INCLUDE=12;
    public static final int INT=13;
    public static final int MINUS=14;
    public static final int OCTAL_ESC=15;
    public static final int STRING=16;
    public static final int UNICODE_ESC=17;
    public static final int WS=18;

    class SaveStruct {
        public CharStream input;
        public int marker;
        SaveStruct(CharStream input) {
            this.input = input;
            this.marker = input.mark();
        }
    }
     
    Stack<SaveStruct> includes = new Stack<SaveStruct>();
     
    // We should override this method for handling EOF of included file
    public Token nextToken(){
        Token token = super.nextToken();
     
        if(token.getType() == Token.EOF && !includes.empty()){
            // We've got EOF and have non empty stack
            SaveStruct ss = includes.pop();
            setCharStream(ss.input);
            input.rewind(ss.marker);

            //this should be used instead of super [like below] to handle exits from nested includes
            //it matters, when the 'include' token is the last in previous stream (using super, lexer 'crashes' returning EOF token)
            token = this.nextToken();
        }
     
        // Skip first token after switching on another input.
        // You need to use this rather than super as there may be nested include files
        if(((CommonToken)token).getStartIndex() < 0) {
            token = this.nextToken();
        }
        
        return token;
    }

    public void includeFile(String name) {
        try {
            // save current lexer's state
            SaveStruct ss = new SaveStruct(input);
            includes.push(ss);
     
            // switch on new input stream
            setCharStream(new ANTLRFileStream(name));
            reset();
        } catch (Exception fnf) {
            fnf.printStackTrace();
        }
    }


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public EugeneLexer() {} 
    public EugeneLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public EugeneLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g"; }

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:83:7: ( '!=' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:83:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:84:7: ( '&&' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:84:9: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:85:7: ( '(' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:85:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:86:7: ( ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:86:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:87:7: ( '*' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:87:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:88:7: ( '+' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:88:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:89:7: ( ',' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:89:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:90:7: ( '.' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:90:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:91:7: ( '.add' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:91:9: '.add'
            {
            match(".add"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:92:7: ( '/' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:92:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:93:7: ( ':' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:93:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:94:7: ( ';' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:94:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:95:7: ( '<' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:95:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:96:7: ( '<=' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:96:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:97:7: ( '=' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:97:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:98:7: ( '==' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:98:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:99:7: ( '>' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:99:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:100:7: ( '>=' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:100:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:101:7: ( 'AFTER' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:101:9: 'AFTER'
            {
            match("AFTER"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:102:7: ( 'AND' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:102:9: 'AND'
            {
            match("AND"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:103:7: ( 'Assert' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:103:9: 'Assert'
            {
            match("Assert"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:104:7: ( 'BEFORE' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:104:9: 'BEFORE'
            {
            match("BEFORE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:105:7: ( 'CONTAINS' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:105:9: 'CONTAINS'
            {
            match("CONTAINS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:106:7: ( 'Collection' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:106:9: 'Collection'
            {
            match("Collection"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:107:7: ( 'Device' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:107:9: 'Device'
            {
            match("Device"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:108:7: ( 'DeviceType' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:108:9: 'DeviceType'
            {
            match("DeviceType"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:109:7: ( 'ENDSWITH' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:109:9: 'ENDSWITH'
            {
            match("ENDSWITH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:110:7: ( 'EQUALS' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:110:9: 'EQUALS'
            {
            match("EQUALS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:111:7: ( 'Genbank' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:111:9: 'Genbank'
            {
            match("Genbank"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:112:7: ( 'INSTANCEOF' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:112:9: 'INSTANCEOF'
            {
            match("INSTANCEOF"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:113:7: ( 'Image' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:113:9: 'Image'
            {
            match("Image"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:114:7: ( 'LEFTTO' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:114:9: 'LEFTTO'
            {
            match("LEFTTO"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:115:7: ( 'MORETHAN' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:115:9: 'MORETHAN'
            {
            match("MORETHAN"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:116:7: ( 'NEXTTO' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:116:9: 'NEXTTO'
            {
            match("NEXTTO"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:117:7: ( 'NOT' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:117:9: 'NOT'
            {
            match("NOT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:118:7: ( 'NOTEQUALS' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:118:9: 'NOTEQUALS'
            {
            match("NOTEQUALS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:119:7: ( 'Note' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:119:9: 'Note'
            {
            match("Note"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:120:7: ( 'ON' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:120:9: 'ON'
            {
            match("ON"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:121:7: ( 'OR' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:121:9: 'OR'
            {
            match("OR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:122:7: ( 'Part' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:122:9: 'Part'
            {
            match("Part"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:123:7: ( 'PartType' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:123:9: 'PartType'
            {
            match("PartType"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:124:7: ( 'Property' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:124:9: 'Property'
            {
            match("Property"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:125:7: ( 'Rule' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:125:9: 'Rule'
            {
            match("Rule"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:126:7: ( 'SBOL' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:126:9: 'SBOL'
            {
            match("SBOL"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:127:7: ( 'STARTSWITH' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:127:9: 'STARTSWITH'
            {
            match("STARTSWITH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:128:7: ( 'THEN' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:128:9: 'THEN'
            {
            match("THEN"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:129:7: ( 'WITH' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:129:9: 'WITH'
            {
            match("WITH"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:130:7: ( 'XOR' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:130:9: 'XOR'
            {
            match("XOR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:131:7: ( '[' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:131:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:132:7: ( ']' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:132:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:133:7: ( '^^' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:133:9: '^^'
            {
            match("^^"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:134:7: ( 'boolean' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:134:9: 'boolean'
            {
            match("boolean"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:135:7: ( 'do' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:135:9: 'do'
            {
            match("do"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:136:7: ( 'else' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:136:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:137:7: ( 'export' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:137:9: 'export'
            {
            match("export"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:138:7: ( 'false' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:138:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:139:7: ( 'flexible' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:139:9: 'flexible'
            {
            match("flexible"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:140:7: ( 'for' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:140:9: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:141:7: ( 'function' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:141:9: 'function'
            {
            match("function"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:142:7: ( 'get' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:142:9: 'get'
            {
            match("get"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:143:7: ( 'if' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:143:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:144:7: ( 'import' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:144:9: 'import'
            {
            match("import"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:145:7: ( 'instanceof' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:145:9: 'instanceof'
            {
            match("instanceof"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:146:7: ( 'instantiate' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:146:9: 'instantiate'
            {
            match("instantiate"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:147:7: ( 'isEmpty' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:147:9: 'isEmpty'
            {
            match("isEmpty"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:148:7: ( 'num' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:148:9: 'num'
            {
            match("num"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:149:7: ( 'permute' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:149:9: 'permute'
            {
            match("permute"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:150:7: ( 'print' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:150:9: 'print'
            {
            match("print"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:151:7: ( 'println' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:151:9: 'println'
            {
            match("println"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:152:7: ( 'product' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:152:9: 'product'
            {
            match("product"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:153:7: ( 'return' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:153:9: 'return'
            {
            match("return"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:154:7: ( 'save' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:154:9: 'save'
            {
            match("save"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:155:7: ( 'size' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:155:9: 'size'
            {
            match("size"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:156:7: ( 'strict' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:156:9: 'strict'
            {
            match("strict"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:157:7: ( 'toSequence' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:157:9: 'toSequence'
            {
            match("toSequence"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:158:7: ( 'true' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:158:9: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:159:7: ( 'txt' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:159:9: 'txt'
            {
            match("txt"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:160:7: ( 'while' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:160:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:161:7: ( '{' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:161:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:162:7: ( '||' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:162:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:163:7: ( '}' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:163:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "INCLUDE"
    public final void mINCLUDE() throws RecognitionException {
        try {
            int _type = INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken f=null;

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2892:9: ( 'include' ( WS )+ f= STRING )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2892:11: 'include' ( WS )+ f= STRING
            {
            match("include"); 



            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2892:21: ( WS )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2892:22: WS
            	    {
            	    mWS(); 


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            int fStart694 = getCharIndex();
            int fStartLine694 = getLine();
            int fStartCharPos694 = getCharPositionInLine();
            mSTRING(); 
            f = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, fStart694, getCharIndex()-1);
            f.setLine(fStartLine694);
            f.setCharPositionInLine(fStartCharPos694);



            String name = f.getText();
            name = name.substring(1,name.length()-1);
            includeFile(name);
            	

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INCLUDE"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2899:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2899:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2899:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2902:5: ( ( '0' .. '9' )+ )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2902:7: ( '0' .. '9' )+
            {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2902:7: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2905:7: ( '-' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2905:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2909:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2909:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2909:9: ( '0' .. '9' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    match('.'); 

                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2909:25: ( '0' .. '9' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2909:37: ( EXPONENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='E'||LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2909:37: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2910:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 

                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2910:13: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2910:25: ( EXPONENT )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='E'||LA8_0=='e') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2910:25: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2911:9: ( '0' .. '9' )+ EXPONENT
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2911:9: ( '0' .. '9' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    mEXPONENT(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2915:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='/') ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1=='/') ) {
                    alt14=1;
                }
                else if ( (LA14_1=='*') ) {
                    alt14=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2915:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2915:14: (~ ( '\\n' | '\\r' ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0 >= '\u0000' && LA11_0 <= '\t')||(LA11_0 >= '\u000B' && LA11_0 <= '\f')||(LA11_0 >= '\u000E' && LA11_0 <= '\uFFFF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2915:28: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2915:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2916:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2916:14: ( options {greedy=false; } : . )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='*') ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1=='/') ) {
                                alt13=2;
                            }
                            else if ( ((LA13_1 >= '\u0000' && LA13_1 <= '.')||(LA13_1 >= '0' && LA13_1 <= '\uFFFF')) ) {
                                alt13=1;
                            }


                        }
                        else if ( ((LA13_0 >= '\u0000' && LA13_0 <= ')')||(LA13_0 >= '+' && LA13_0 <= '\uFFFF')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2916:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2919:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2919:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "DYNAMIC_NAME"
    public final void mDYNAMIC_NAME() throws RecognitionException {
        try {
            int _type = DYNAMIC_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2927:2: ( '*' '*' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2927:4: '*' '*'
            {
            match('*'); 

            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DYNAMIC_NAME"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2932:5: ( '\"' ( ESC_SEQ |~ ( '\"' ) )* '\"' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2932:8: '\"' ( ESC_SEQ |~ ( '\"' ) )* '\"'
            {
            match('\"'); 

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2932:12: ( ESC_SEQ |~ ( '\"' ) )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\\') ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2=='\"') ) {
                        int LA15_4 = input.LA(3);

                        if ( ((LA15_4 >= '\u0000' && LA15_4 <= '\uFFFF')) ) {
                            alt15=1;
                        }

                        else {
                            alt15=2;
                        }


                    }
                    else if ( (LA15_2=='u') ) {
                        int LA15_5 = input.LA(3);

                        if ( ((LA15_5 >= '0' && LA15_5 <= '9')||(LA15_5 >= 'A' && LA15_5 <= 'F')||(LA15_5 >= 'a' && LA15_5 <= 'f')) ) {
                            int LA15_10 = input.LA(4);

                            if ( ((LA15_10 >= '0' && LA15_10 <= '9')||(LA15_10 >= 'A' && LA15_10 <= 'F')||(LA15_10 >= 'a' && LA15_10 <= 'f')) ) {
                                int LA15_11 = input.LA(5);

                                if ( ((LA15_11 >= '0' && LA15_11 <= '9')||(LA15_11 >= 'A' && LA15_11 <= 'F')||(LA15_11 >= 'a' && LA15_11 <= 'f')) ) {
                                    int LA15_12 = input.LA(6);

                                    if ( ((LA15_12 >= '0' && LA15_12 <= '9')||(LA15_12 >= 'A' && LA15_12 <= 'F')||(LA15_12 >= 'a' && LA15_12 <= 'f')) ) {
                                        alt15=1;
                                    }
                                    else if ( ((LA15_12 >= '\u0000' && LA15_12 <= '/')||(LA15_12 >= ':' && LA15_12 <= '@')||(LA15_12 >= 'G' && LA15_12 <= '`')||(LA15_12 >= 'g' && LA15_12 <= '\uFFFF')) ) {
                                        alt15=2;
                                    }


                                }
                                else if ( ((LA15_11 >= '\u0000' && LA15_11 <= '/')||(LA15_11 >= ':' && LA15_11 <= '@')||(LA15_11 >= 'G' && LA15_11 <= '`')||(LA15_11 >= 'g' && LA15_11 <= '\uFFFF')) ) {
                                    alt15=2;
                                }


                            }
                            else if ( ((LA15_10 >= '\u0000' && LA15_10 <= '/')||(LA15_10 >= ':' && LA15_10 <= '@')||(LA15_10 >= 'G' && LA15_10 <= '`')||(LA15_10 >= 'g' && LA15_10 <= '\uFFFF')) ) {
                                alt15=2;
                            }


                        }
                        else if ( ((LA15_5 >= '\u0000' && LA15_5 <= '/')||(LA15_5 >= ':' && LA15_5 <= '@')||(LA15_5 >= 'G' && LA15_5 <= '`')||(LA15_5 >= 'g' && LA15_5 <= '\uFFFF')) ) {
                            alt15=2;
                        }


                    }
                    else if ( ((LA15_2 >= '0' && LA15_2 <= '3')) ) {
                        alt15=1;
                    }
                    else if ( ((LA15_2 >= '4' && LA15_2 <= '7')) ) {
                        alt15=1;
                    }
                    else if ( (LA15_2=='\\') ) {
                        alt15=1;
                    }
                    else if ( (LA15_2=='\''||LA15_2=='b'||LA15_2=='f'||LA15_2=='n'||LA15_2=='r'||LA15_2=='t') ) {
                        alt15=1;
                    }
                    else if ( ((LA15_2 >= '\u0000' && LA15_2 <= '!')||(LA15_2 >= '#' && LA15_2 <= '&')||(LA15_2 >= '(' && LA15_2 <= '/')||(LA15_2 >= '8' && LA15_2 <= '[')||(LA15_2 >= ']' && LA15_2 <= 'a')||(LA15_2 >= 'c' && LA15_2 <= 'e')||(LA15_2 >= 'g' && LA15_2 <= 'm')||(LA15_2 >= 'o' && LA15_2 <= 'q')||LA15_2=='s'||(LA15_2 >= 'v' && LA15_2 <= '\uFFFF')) ) {
                        alt15=2;
                    }


                }
                else if ( ((LA15_0 >= '\u0000' && LA15_0 <= '!')||(LA15_0 >= '#' && LA15_0 <= '[')||(LA15_0 >= ']' && LA15_0 <= '\uFFFF')) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2932:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2932:24: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2935:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2935:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2935:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\\') ) {
                alt16=1;
            }
            else if ( ((LA16_0 >= '\u0000' && LA16_0 <= '&')||(LA16_0 >= '(' && LA16_0 <= '[')||(LA16_0 >= ']' && LA16_0 <= '\uFFFF')) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2935:15: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2935:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2940:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2940:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2940:22: ( '+' | '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='+'||LA17_0=='-') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2940:33: ( '0' .. '9' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '0' && LA18_0 <= '9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2943:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2948:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt19=1;
                    }
                    break;
                case 'u':
                    {
                    alt19=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt19=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2948:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2949:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2950:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2955:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\\') ) {
                int LA20_1 = input.LA(2);

                if ( ((LA20_1 >= '0' && LA20_1 <= '3')) ) {
                    int LA20_2 = input.LA(3);

                    if ( ((LA20_2 >= '0' && LA20_2 <= '7')) ) {
                        int LA20_4 = input.LA(4);

                        if ( ((LA20_4 >= '0' && LA20_4 <= '7')) ) {
                            alt20=1;
                        }
                        else {
                            alt20=2;
                        }
                    }
                    else {
                        alt20=3;
                    }
                }
                else if ( ((LA20_1 >= '4' && LA20_1 <= '7')) ) {
                    int LA20_3 = input.LA(3);

                    if ( ((LA20_3 >= '0' && LA20_3 <= '7')) ) {
                        alt20=2;
                    }
                    else {
                        alt20=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2955:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2956:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2957:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2962:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2962:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | INCLUDE | ID | INT | MINUS | FLOAT | COMMENT | WS | DYNAMIC_NAME | STRING | CHAR )
        int alt21=91;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:10: T__19
                {
                mT__19(); 


                }
                break;
            case 2 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:16: T__20
                {
                mT__20(); 


                }
                break;
            case 3 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:22: T__21
                {
                mT__21(); 


                }
                break;
            case 4 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:28: T__22
                {
                mT__22(); 


                }
                break;
            case 5 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:34: T__23
                {
                mT__23(); 


                }
                break;
            case 6 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:40: T__24
                {
                mT__24(); 


                }
                break;
            case 7 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:46: T__25
                {
                mT__25(); 


                }
                break;
            case 8 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:52: T__26
                {
                mT__26(); 


                }
                break;
            case 9 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:58: T__27
                {
                mT__27(); 


                }
                break;
            case 10 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:64: T__28
                {
                mT__28(); 


                }
                break;
            case 11 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:70: T__29
                {
                mT__29(); 


                }
                break;
            case 12 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:76: T__30
                {
                mT__30(); 


                }
                break;
            case 13 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:82: T__31
                {
                mT__31(); 


                }
                break;
            case 14 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:88: T__32
                {
                mT__32(); 


                }
                break;
            case 15 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:94: T__33
                {
                mT__33(); 


                }
                break;
            case 16 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:100: T__34
                {
                mT__34(); 


                }
                break;
            case 17 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:106: T__35
                {
                mT__35(); 


                }
                break;
            case 18 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:112: T__36
                {
                mT__36(); 


                }
                break;
            case 19 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:118: T__37
                {
                mT__37(); 


                }
                break;
            case 20 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:124: T__38
                {
                mT__38(); 


                }
                break;
            case 21 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:130: T__39
                {
                mT__39(); 


                }
                break;
            case 22 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:136: T__40
                {
                mT__40(); 


                }
                break;
            case 23 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:142: T__41
                {
                mT__41(); 


                }
                break;
            case 24 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:148: T__42
                {
                mT__42(); 


                }
                break;
            case 25 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:154: T__43
                {
                mT__43(); 


                }
                break;
            case 26 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:160: T__44
                {
                mT__44(); 


                }
                break;
            case 27 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:166: T__45
                {
                mT__45(); 


                }
                break;
            case 28 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:172: T__46
                {
                mT__46(); 


                }
                break;
            case 29 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:178: T__47
                {
                mT__47(); 


                }
                break;
            case 30 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:184: T__48
                {
                mT__48(); 


                }
                break;
            case 31 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:190: T__49
                {
                mT__49(); 


                }
                break;
            case 32 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:196: T__50
                {
                mT__50(); 


                }
                break;
            case 33 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:202: T__51
                {
                mT__51(); 


                }
                break;
            case 34 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:208: T__52
                {
                mT__52(); 


                }
                break;
            case 35 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:214: T__53
                {
                mT__53(); 


                }
                break;
            case 36 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:220: T__54
                {
                mT__54(); 


                }
                break;
            case 37 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:226: T__55
                {
                mT__55(); 


                }
                break;
            case 38 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:232: T__56
                {
                mT__56(); 


                }
                break;
            case 39 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:238: T__57
                {
                mT__57(); 


                }
                break;
            case 40 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:244: T__58
                {
                mT__58(); 


                }
                break;
            case 41 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:250: T__59
                {
                mT__59(); 


                }
                break;
            case 42 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:256: T__60
                {
                mT__60(); 


                }
                break;
            case 43 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:262: T__61
                {
                mT__61(); 


                }
                break;
            case 44 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:268: T__62
                {
                mT__62(); 


                }
                break;
            case 45 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:274: T__63
                {
                mT__63(); 


                }
                break;
            case 46 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:280: T__64
                {
                mT__64(); 


                }
                break;
            case 47 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:286: T__65
                {
                mT__65(); 


                }
                break;
            case 48 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:292: T__66
                {
                mT__66(); 


                }
                break;
            case 49 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:298: T__67
                {
                mT__67(); 


                }
                break;
            case 50 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:304: T__68
                {
                mT__68(); 


                }
                break;
            case 51 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:310: T__69
                {
                mT__69(); 


                }
                break;
            case 52 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:316: T__70
                {
                mT__70(); 


                }
                break;
            case 53 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:322: T__71
                {
                mT__71(); 


                }
                break;
            case 54 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:328: T__72
                {
                mT__72(); 


                }
                break;
            case 55 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:334: T__73
                {
                mT__73(); 


                }
                break;
            case 56 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:340: T__74
                {
                mT__74(); 


                }
                break;
            case 57 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:346: T__75
                {
                mT__75(); 


                }
                break;
            case 58 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:352: T__76
                {
                mT__76(); 


                }
                break;
            case 59 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:358: T__77
                {
                mT__77(); 


                }
                break;
            case 60 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:364: T__78
                {
                mT__78(); 


                }
                break;
            case 61 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:370: T__79
                {
                mT__79(); 


                }
                break;
            case 62 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:376: T__80
                {
                mT__80(); 


                }
                break;
            case 63 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:382: T__81
                {
                mT__81(); 


                }
                break;
            case 64 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:388: T__82
                {
                mT__82(); 


                }
                break;
            case 65 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:394: T__83
                {
                mT__83(); 


                }
                break;
            case 66 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:400: T__84
                {
                mT__84(); 


                }
                break;
            case 67 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:406: T__85
                {
                mT__85(); 


                }
                break;
            case 68 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:412: T__86
                {
                mT__86(); 


                }
                break;
            case 69 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:418: T__87
                {
                mT__87(); 


                }
                break;
            case 70 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:424: T__88
                {
                mT__88(); 


                }
                break;
            case 71 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:430: T__89
                {
                mT__89(); 


                }
                break;
            case 72 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:436: T__90
                {
                mT__90(); 


                }
                break;
            case 73 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:442: T__91
                {
                mT__91(); 


                }
                break;
            case 74 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:448: T__92
                {
                mT__92(); 


                }
                break;
            case 75 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:454: T__93
                {
                mT__93(); 


                }
                break;
            case 76 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:460: T__94
                {
                mT__94(); 


                }
                break;
            case 77 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:466: T__95
                {
                mT__95(); 


                }
                break;
            case 78 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:472: T__96
                {
                mT__96(); 


                }
                break;
            case 79 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:478: T__97
                {
                mT__97(); 


                }
                break;
            case 80 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:484: T__98
                {
                mT__98(); 


                }
                break;
            case 81 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:490: T__99
                {
                mT__99(); 


                }
                break;
            case 82 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:496: INCLUDE
                {
                mINCLUDE(); 


                }
                break;
            case 83 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:504: ID
                {
                mID(); 


                }
                break;
            case 84 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:507: INT
                {
                mINT(); 


                }
                break;
            case 85 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:511: MINUS
                {
                mMINUS(); 


                }
                break;
            case 86 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:517: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 87 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:523: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 88 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:531: WS
                {
                mWS(); 


                }
                break;
            case 89 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:534: DYNAMIC_NAME
                {
                mDYNAMIC_NAME(); 


                }
                break;
            case 90 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:547: STRING
                {
                mSTRING(); 


                }
                break;
            case 91 :
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1:554: CHAR
                {
                mCHAR(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA10_eotS =
        "\5\uffff";
    static final String DFA10_eofS =
        "\5\uffff";
    static final String DFA10_minS =
        "\2\56\3\uffff";
    static final String DFA10_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA10_specialS =
        "\5\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "2908:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA21_eotS =
        "\5\uffff\1\71\2\uffff\1\73\1\76\2\uffff\1\100\1\102\1\104\21\62"+
        "\3\uffff\14\62\4\uffff\1\170\21\uffff\21\62\1\u008a\1\u008b\11\62"+
        "\1\u0095\7\62\1\u009d\16\62\1\uffff\1\62\1\u00af\15\62\1\u00be\1"+
        "\62\2\uffff\7\62\1\u00c7\1\62\1\uffff\4\62\1\u00cd\1\62\1\u00cf"+
        "\1\uffff\4\62\1\u00d4\11\62\1\u00de\2\62\1\uffff\16\62\1\uffff\1"+
        "\u00ef\1\u00f1\1\62\1\u00f3\1\u00f4\1\62\1\u00f6\1\u00f7\1\uffff"+
        "\1\62\1\u00f9\3\62\1\uffff\1\62\1\uffff\4\62\1\uffff\4\62\1\u0106"+
        "\1\u0107\2\62\1\u010a\1\uffff\1\62\1\u010c\11\62\1\u0116\4\62\1"+
        "\uffff\1\62\1\uffff\1\62\2\uffff\1\62\2\uffff\1\62\1\uffff\1\62"+
        "\1\u0120\7\62\1\u0129\2\62\2\uffff\2\62\1\uffff\1\u012e\1\uffff"+
        "\1\u012f\1\u0130\2\62\1\u0134\1\62\1\u0136\2\62\1\uffff\1\u0139"+
        "\1\62\1\u013b\5\62\1\u0141\1\uffff\2\62\1\u0144\5\62\1\uffff\1\62"+
        "\1\u014c\1\u014d\1\62\3\uffff\3\62\1\uffff\1\62\1\uffff\1\u0153"+
        "\1\62\1\uffff\1\62\1\uffff\4\62\1\u015a\1\uffff\2\62\1\uffff\3\62"+
        "\1\u0160\1\u0161\1\u0162\1\u0163\2\uffff\1\62\1\u0165\2\62\1\u0168"+
        "\1\uffff\1\62\1\u016a\1\62\1\u016c\1\u016d\1\62\1\uffff\1\u016f"+
        "\1\u0170\2\62\5\uffff\1\62\1\uffff\2\62\1\uffff\1\62\1\uffff\1\u0177"+
        "\2\uffff\1\62\2\uffff\3\62\1\u017c\1\u017d\1\u017e\1\uffff\1\u017f"+
        "\1\u0180\1\62\1\u0182\5\uffff\1\u0183\2\uffff";
    static final String DFA21_eofS =
        "\u0184\uffff";
    static final String DFA21_minS =
        "\1\11\4\uffff\1\52\2\uffff\1\60\1\52\2\uffff\3\75\1\106\1\105\1"+
        "\117\1\145\1\116\1\145\1\116\1\105\1\117\1\105\1\116\1\141\1\165"+
        "\1\102\1\110\1\111\1\117\3\uffff\2\157\1\154\1\141\1\145\1\146\1"+
        "\165\2\145\1\141\1\157\1\150\4\uffff\1\56\21\uffff\1\124\1\104\1"+
        "\163\1\106\1\116\1\154\1\166\1\104\1\125\1\156\1\123\1\141\1\106"+
        "\1\122\1\130\1\124\1\164\2\60\1\162\1\157\1\154\1\117\1\101\1\105"+
        "\1\124\1\122\1\157\1\60\1\163\1\160\1\154\1\145\1\162\1\156\1\164"+
        "\1\60\1\160\1\143\1\105\1\155\1\162\1\151\1\164\1\166\1\172\1\162"+
        "\1\123\1\165\1\164\1\151\1\uffff\1\105\1\60\1\145\1\117\1\124\1"+
        "\154\1\151\1\123\1\101\1\142\1\124\1\147\1\124\1\105\1\124\1\60"+
        "\1\145\2\uffff\1\164\1\160\1\145\1\114\1\122\1\116\1\110\1\60\1"+
        "\154\1\uffff\1\145\1\157\1\163\1\170\1\60\1\143\1\60\1\uffff\1\157"+
        "\1\164\1\154\1\155\1\60\1\155\1\156\1\144\1\165\2\145\1\151\2\145"+
        "\1\60\1\154\1\122\1\uffff\1\162\1\122\1\101\1\145\1\143\1\127\1"+
        "\114\1\141\1\101\1\145\3\124\1\121\1\uffff\2\60\1\145\2\60\1\124"+
        "\2\60\1\uffff\1\145\1\60\1\162\1\145\1\151\1\uffff\1\164\1\uffff"+
        "\1\162\1\141\1\165\1\160\1\uffff\1\165\1\164\1\165\1\162\2\60\1"+
        "\143\1\161\1\60\1\uffff\1\145\1\60\1\164\1\105\1\111\1\143\1\145"+
        "\1\111\1\123\1\156\1\116\1\60\1\117\1\110\1\117\1\125\1\uffff\1"+
        "\171\1\uffff\1\162\2\uffff\1\123\2\uffff\1\141\1\uffff\1\164\1\60"+
        "\1\142\1\151\1\164\1\156\1\144\2\164\1\60\1\143\1\156\2\uffff\1"+
        "\164\1\165\1\uffff\1\60\1\uffff\2\60\1\116\1\164\1\60\1\124\1\60"+
        "\1\153\1\103\1\uffff\1\60\1\101\1\60\1\101\1\160\1\164\1\127\1\156"+
        "\1\60\1\uffff\1\154\1\157\1\60\1\143\1\145\1\171\1\145\1\156\1\uffff"+
        "\1\164\2\60\1\145\3\uffff\1\123\1\151\1\171\1\uffff\1\110\1\uffff"+
        "\1\60\1\105\1\uffff\1\116\1\uffff\1\114\1\145\1\171\1\111\1\60\1"+
        "\uffff\1\145\1\156\1\uffff\1\145\1\151\1\11\4\60\2\uffff\1\156\1"+
        "\60\1\157\1\160\1\60\1\uffff\1\117\1\60\1\123\2\60\1\124\1\uffff"+
        "\2\60\1\157\1\141\5\uffff\1\143\1\uffff\1\156\1\145\1\uffff\1\106"+
        "\1\uffff\1\60\2\uffff\1\110\2\uffff\1\146\1\164\1\145\3\60\1\uffff"+
        "\2\60\1\145\1\60\5\uffff\1\60\2\uffff";
    static final String DFA21_maxS =
        "\1\175\4\uffff\1\52\2\uffff\1\141\1\57\2\uffff\3\75\1\163\1\105"+
        "\1\157\1\145\1\121\1\145\1\155\1\105\1\117\1\157\1\122\1\162\1\165"+
        "\1\124\1\110\1\111\1\117\3\uffff\2\157\1\170\1\165\1\145\1\163\1"+
        "\165\1\162\1\145\1\164\1\170\1\150\4\uffff\1\145\21\uffff\1\124"+
        "\1\104\1\163\1\106\1\116\1\154\1\166\1\104\1\125\1\156\1\123\1\141"+
        "\1\106\1\122\1\130\1\124\1\164\2\172\1\162\1\157\1\154\1\117\1\101"+
        "\1\105\1\124\1\122\1\157\1\172\1\163\1\160\1\154\1\145\1\162\1\156"+
        "\1\164\1\172\1\160\1\163\1\105\1\155\1\162\1\157\1\164\1\166\1\172"+
        "\1\162\1\123\1\165\1\164\1\151\1\uffff\1\105\1\172\1\145\1\117\1"+
        "\124\1\154\1\151\1\123\1\101\1\142\1\124\1\147\1\124\1\105\1\124"+
        "\1\172\1\145\2\uffff\1\164\1\160\1\145\1\114\1\122\1\116\1\110\1"+
        "\172\1\154\1\uffff\1\145\1\157\1\163\1\170\1\172\1\143\1\172\1\uffff"+
        "\1\157\1\164\1\154\1\155\1\172\1\155\1\156\1\144\1\165\2\145\1\151"+
        "\2\145\1\172\1\154\1\122\1\uffff\1\162\1\122\1\101\1\145\1\143\1"+
        "\127\1\114\1\141\1\101\1\145\3\124\1\121\1\uffff\2\172\1\145\2\172"+
        "\1\124\2\172\1\uffff\1\145\1\172\1\162\1\145\1\151\1\uffff\1\164"+
        "\1\uffff\1\162\1\141\1\165\1\160\1\uffff\1\165\1\164\1\165\1\162"+
        "\2\172\1\143\1\161\1\172\1\uffff\1\145\1\172\1\164\1\105\1\111\1"+
        "\143\1\145\1\111\1\123\1\156\1\116\1\172\1\117\1\110\1\117\1\125"+
        "\1\uffff\1\171\1\uffff\1\162\2\uffff\1\123\2\uffff\1\141\1\uffff"+
        "\1\164\1\172\1\142\1\151\1\164\1\156\1\144\2\164\1\172\1\143\1\156"+
        "\2\uffff\1\164\1\165\1\uffff\1\172\1\uffff\2\172\1\116\1\164\1\172"+
        "\1\124\1\172\1\153\1\103\1\uffff\1\172\1\101\1\172\1\101\1\160\1"+
        "\164\1\127\1\156\1\172\1\uffff\1\154\1\157\1\172\1\164\1\145\1\171"+
        "\1\145\1\156\1\uffff\1\164\2\172\1\145\3\uffff\1\123\1\151\1\171"+
        "\1\uffff\1\110\1\uffff\1\172\1\105\1\uffff\1\116\1\uffff\1\114\1"+
        "\145\1\171\1\111\1\172\1\uffff\1\145\1\156\1\uffff\1\145\1\151\1"+
        "\40\4\172\2\uffff\1\156\1\172\1\157\1\160\1\172\1\uffff\1\117\1"+
        "\172\1\123\2\172\1\124\1\uffff\2\172\1\157\1\141\5\uffff\1\143\1"+
        "\uffff\1\156\1\145\1\uffff\1\106\1\uffff\1\172\2\uffff\1\110\2\uffff"+
        "\1\146\1\164\1\145\3\172\1\uffff\2\172\1\145\1\172\5\uffff\1\172"+
        "\2\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\2\uffff\1\13\1\14\24\uffff"+
        "\1\61\1\62\1\63\14\uffff\1\117\1\120\1\121\1\123\1\uffff\1\125\1"+
        "\130\1\132\1\133\1\131\1\5\1\11\1\10\1\126\1\127\1\12\1\16\1\15"+
        "\1\20\1\17\1\22\1\21\63\uffff\1\124\21\uffff\1\46\1\47\11\uffff"+
        "\1\65\7\uffff\1\75\21\uffff\1\24\16\uffff\1\43\10\uffff\1\60\5\uffff"+
        "\1\72\1\uffff\1\74\4\uffff\1\102\11\uffff\1\115\20\uffff\1\45\1"+
        "\uffff\1\50\1\uffff\1\53\1\54\1\uffff\1\56\1\57\1\uffff\1\66\14"+
        "\uffff\1\110\1\111\2\uffff\1\114\1\uffff\1\23\11\uffff\1\37\11\uffff"+
        "\1\70\10\uffff\1\104\4\uffff\1\116\1\25\1\26\3\uffff\1\31\1\uffff"+
        "\1\34\2\uffff\1\40\1\uffff\1\42\5\uffff\1\67\2\uffff\1\76\7\uffff"+
        "\1\107\1\112\5\uffff\1\35\6\uffff\1\64\4\uffff\1\122\1\101\1\103"+
        "\1\105\1\106\1\uffff\1\27\2\uffff\1\33\1\uffff\1\41\1\uffff\1\51"+
        "\1\52\1\uffff\1\71\1\73\6\uffff\1\44\4\uffff\1\30\1\32\1\36\1\55"+
        "\1\77\1\uffff\1\113\1\100";
    static final String DFA21_specialS =
        "\u0184\uffff}>";
    static final String[] DFA21_transitionS = {
            "\2\65\2\uffff\1\65\22\uffff\1\65\1\1\1\66\3\uffff\1\2\1\67\1"+
            "\3\1\4\1\5\1\6\1\7\1\64\1\10\1\11\12\63\1\12\1\13\1\14\1\15"+
            "\1\16\2\uffff\1\17\1\20\1\21\1\22\1\23\1\62\1\24\1\62\1\25\2"+
            "\62\1\26\1\27\1\30\1\31\1\32\1\62\1\33\1\34\1\35\2\62\1\36\1"+
            "\37\2\62\1\40\1\uffff\1\41\1\42\1\62\1\uffff\1\62\1\43\1\62"+
            "\1\44\1\45\1\46\1\47\1\62\1\50\4\62\1\51\1\62\1\52\1\62\1\53"+
            "\1\54\1\55\2\62\1\56\3\62\1\57\1\60\1\61",
            "",
            "",
            "",
            "",
            "\1\70",
            "",
            "",
            "\12\74\47\uffff\1\72",
            "\1\75\4\uffff\1\75",
            "",
            "",
            "\1\77",
            "\1\101",
            "\1\103",
            "\1\105\7\uffff\1\106\44\uffff\1\107",
            "\1\110",
            "\1\111\37\uffff\1\112",
            "\1\113",
            "\1\114\2\uffff\1\115",
            "\1\116",
            "\1\117\36\uffff\1\120",
            "\1\121",
            "\1\122",
            "\1\123\11\uffff\1\124\37\uffff\1\125",
            "\1\126\3\uffff\1\127",
            "\1\130\20\uffff\1\131",
            "\1\132",
            "\1\133\21\uffff\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "",
            "",
            "\1\140",
            "\1\141",
            "\1\142\13\uffff\1\143",
            "\1\144\12\uffff\1\145\2\uffff\1\146\5\uffff\1\147",
            "\1\150",
            "\1\151\6\uffff\1\152\1\153\4\uffff\1\154",
            "\1\155",
            "\1\156\14\uffff\1\157",
            "\1\160",
            "\1\161\7\uffff\1\162\12\uffff\1\163",
            "\1\164\2\uffff\1\165\5\uffff\1\166",
            "\1\167",
            "",
            "",
            "",
            "",
            "\1\74\1\uffff\12\63\13\uffff\1\74\37\uffff\1\74",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u009e",
            "\1\u00a0\17\uffff\1\u009f",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4\5\uffff\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "",
            "\1\u00ae",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\12\62\7\uffff\4\62\1\u00bd\25\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00bf",
            "",
            "",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00c8",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00ce",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00df",
            "\1\u00e0",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\23\62\1\u00f0\6\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00f2",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00f5",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u00f8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "",
            "\1\u00fd",
            "",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0108",
            "\1\u0109",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u010b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "",
            "\1\u011b",
            "",
            "\1\u011c",
            "",
            "",
            "\1\u011d",
            "",
            "",
            "\1\u011e",
            "",
            "\1\u011f",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\u0128\16"+
            "\62",
            "\1\u012a",
            "\1\u012b",
            "",
            "",
            "\1\u012c",
            "\1\u012d",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0131",
            "\1\u0132",
            "\12\62\7\uffff\23\62\1\u0133\6\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0135",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0137",
            "\1\u0138",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u013a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0142",
            "\1\u0143",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0145\20\uffff\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "",
            "\1\u014b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u014e",
            "",
            "",
            "",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "",
            "\1\u0152",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0154",
            "",
            "\1\u0155",
            "",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u015b",
            "\1\u015c",
            "",
            "\1\u015d",
            "\1\u015e",
            "\2\u015f\2\uffff\1\u015f\22\uffff\1\u015f",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\u0164",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0166",
            "\1\u0167",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0169",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u016b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u016e",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0171",
            "\1\u0172",
            "",
            "",
            "",
            "",
            "",
            "\1\u0173",
            "",
            "\1\u0174",
            "\1\u0175",
            "",
            "\1\u0176",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\u0178",
            "",
            "",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0181",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | INCLUDE | ID | INT | MINUS | FLOAT | COMMENT | WS | DYNAMIC_NAME | STRING | CHAR );";
        }
    }
 

}