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

import eugene.constants.EugeneConstants;
import eugene.dom.*;
import eugene.dom.functions.*;
import eugene.dom.loops.*;
import eugene.dom.branches.*;
import eugene.dom.rules.*;
import eugene.dom.arrays.*;
import eugene.dom.characterization.*;
import eugene.dom.collection.*;
import eugene.dom.components.*;
import eugene.dom.components.types.*;
import eugene.factory.DeviceFactory;
import eugene.rules.*;
import eugene.exception.*; 
import eugene.util.*;
import eugene.output.ResultSet;
import eugene.interpreter.*;
import eugene.rules.parser.*;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.Set;
import java.util.Iterator;
import java.util.Random;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import eugene.data.registry.importer.RegistryImporter;
// SBOL
import eugene.data.sbol.*;
import eugene.data.sbol.mapping.*;

// for Genbank import
import eugene.data.genbank.*;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class EugeneParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "COMMENT", "DYNAMIC_NAME", "ESC_SEQ", "EXPONENT", "FLOAT", "HEX_DIGIT", "ID", "INCLUDE", "INT", "MINUS", "OCTAL_ESC", "STRING", "UNICODE_ESC", "WS", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'.'", "'.add'", "'/'", "':'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'AFTER'", "'AND'", "'Assert'", "'BEFORE'", "'CONTAINS'", "'Collection'", "'Device'", "'DeviceType'", "'ENDSWITH'", "'EQUALS'", "'Genbank'", "'INSTANCEOF'", "'Image'", "'LEFTTO'", "'MORETHAN'", "'NEXTTO'", "'NOT'", "'NOTEQUALS'", "'Note'", "'ON'", "'OR'", "'Part'", "'PartType'", "'Property'", "'Rule'", "'SBOL'", "'STARTSWITH'", "'THEN'", "'WITH'", "'XOR'", "'['", "']'", "'^^'", "'boolean'", "'do'", "'else'", "'export'", "'false'", "'flexible'", "'for'", "'function'", "'get'", "'if'", "'import'", "'instanceof'", "'instantiate'", "'isEmpty'", "'num'", "'permute'", "'print'", "'println'", "'product'", "'return'", "'save'", "'size'", "'strict'", "'toSequence'", "'true'", "'txt'", "'while'", "'{'", "'||'", "'}'"
    };

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

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public EugeneParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public EugeneParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return EugeneParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g"; }



    private RuleEngine ruleEngine = new RuleEngine();
    private RegistryImporter registryImporter = new RegistryImporter();
    private Runtime rt = Runtime.getRuntime();
    private Interp interp = new Interp();

    public ResultSet getResultSet() {
        return interp.getResultSet();
    }

    public Object exec(String rule, int tokenIndex) 
            throws EugeneReturnException {
        Object rv = null;
        int oldPosition = this.input.index(); // save current location
        this.input.seek(tokenIndex); // seek to place to start execution
        try { // which rule are we executing?
            if(rule.equals("ifCondition")) { 
                rv = this.expression(false).objElement; 
            } else if("onDeviceRule".equals(rule)) {
                rv = null;
                //rv = this.onDeviceRule(false).objRule;            
            } else if (rule.equals("listOfStatements")) {
                this.listOfStatements(false);
            } else if (rule.equals("PropertyValueDeclaration")){
                variableDeclaration_return ret=this.variableDeclaration(false);
            } else if(rule.equals("expression")) {
                return this.expression(false);
            } else if(rule.equals("computationalStatement")) {
                return this.computationalStatement(false);
            } else {
                System.err.println("Error: cannot execute rule " + rule + ".");
                //this.cleanUp(1);
            }
        } catch (EugeneReturnException e) {
            throw new EugeneReturnException(e.getReturnValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally { 
            // restore location
            this.input.seek(oldPosition); 
        }
        return rv;
    }

    public NamedElement callFunction(Function objFunction, ArrayList<NamedElement> lstParameterValues) 
        throws EugeneException {        

        // save current location
        int oldPosition = this.input.index(); 

        objFunction.setOldPosition(oldPosition);
        
        // compare the parameter values with the function's parameters
        if(!objFunction.checkParameters(lstParameterValues)) {
            throw new EugeneException(
                "Invalid parameter values to call the function "+objFunction.getName());
        }
        
        objFunction.initSymbolTables(lstParameterValues);
            
        // push the function onto the function stack
        SymbolTables.push(objFunction);        
            
        // execute the function's statements
        NamedElement objReturnValue = null;
        Token objToken = objFunction.getStatements();
        if(objToken!=null && objReturnValue==null) {
            this.input.seek(objToken.getTokenIndex());
        
            try {
                this.listOfStatements(false);       
            } catch(EugeneReturnException ere) {
                objReturnValue = ere.getReturnValue();
            } catch(RecognitionException re) {
                throw new EugeneException(re.getMessage());
            }        
        }

        try {
            this.cleanUpFunction(objReturnValue); 
        } catch(Exception e ){
            throw new EugeneException(e.getMessage());
        }

        this.input.seek(oldPosition);
        
        return objReturnValue;
    }

    public void cleanUpFunction(NamedElement objReturnValue) 
            throws EugeneException {

        String sFunctionName = SymbolTables.getCurrentFunctionName();        
        NamedElement objElement = SymbolTables.get(sFunctionName);
                
        if(null != objElement && objElement instanceof Function) {
        	Function objFunction = (Function)objElement;
            NamedElement objReturn = objFunction.getReturn();
            if(objReturnValue!=null && objReturn!=null) { 
            
                /** COMPARE THE RETURN VALUES **/       
                if(objReturn instanceof Variable && objReturnValue instanceof Variable) {
                    String sReturnType = ((Variable)objReturn).getType();
                    String sReturnValueType = ((Variable)objReturnValue).getType();
                    if(!sReturnType.equals(sReturnValueType)) {
                        throw new EugeneException("The return value of function "+objFunction.getName()+" is not of type "+sReturnType+"!");
                    }
                } else if(objReturnValue instanceof PartType && objReturn instanceof PartType) {
                    if(!objReturnValue.getName().equals(objReturn.getName())) {
                        throw new EugeneException("The return value of function "+objFunction.getName()+" is not of type "+objReturn.getName()+"!");
                    }
                } else if(objReturn instanceof PartType && objReturnValue instanceof Part) {
                    if(!((PartType)objReturn).getName().equals(((Part)objReturnValue).getPartType().getName())) {
                        throw new EugeneException("The return value of function "+objFunction.getName()+" is not of type "+objReturn.getName()+"!");
                    }
                } else if(!objReturn.getClass().equals(objReturnValue.getClass())) {
                    throw new EugeneException("The return value of function "+objFunction.getName()+" is not of type "+this.getObjectType(objReturn)+"!");
                }  
            }
            
            if(objReturn!=null && objReturnValue==null) {
                System.err.println(
                    "WARNING! The Function "+objFunction.getName()+
                    " should return a value of type "+this.getObjectType(objReturn)+"!");
                System.err.flush();
            }
        }
        
        StackElement objStackElement = SymbolTables.peek();
        while(!(objStackElement instanceof Function)) {
            objStackElement = SymbolTables.pop();
            if(objStackElement instanceof ForLoop) {
                ((ForLoop)objStackElement).clear();
                objStackElement = null;
            }        
            objStackElement = SymbolTables.peek();
        }        

        Function objFunction = (Function)objStackElement;
        SymbolTables.clear(SymbolTables.peek().toString());
        SymbolTables.pop();
    }

    public void whileStat(Token condStart, Token whileStart) 
            throws EugeneReturnException {
        expression_return ret=(expression_return)exec("expression", condStart.getTokenIndex());
        Variable exprValue = (Variable)ret.objElement;
        boolean b = exprValue.getBoolean();
        while ( b ) { // if true, execute statements, and re-evalute condition
            exec("listOfStatements", whileStart.getTokenIndex());

            ret=(expression_return)exec("expression", condStart.getTokenIndex());
            exprValue = (Variable)ret.objElement;
            b = exprValue.getBoolean();
        }
    }

    public void forStat(Token initStart, Token condStart, Token incStart, Token forStart) 
            throws EugeneException, EugeneReturnException {

        int oldPosition = this.input.index(); // save current location

        ArrayList<NamedElement> lstInitVariables = execForInit(initStart.getTokenIndex());
        ForLoop objFor = new ForLoop();
        objFor.setInitVariables(lstInitVariables);
    	        
        SymbolTables.push(objFor);

        expression_return ret=(expression_return)exec("expression", condStart.getTokenIndex());
        Variable exprValue = (Variable)ret.objElement;
        boolean b = exprValue.getBoolean();
        
        int i = 0;
        while (b) {
            // execution of the loop body
            try {
    	    exec("listOfStatements", forStart.getTokenIndex());
            } catch(EugeneReturnException e) {
                throw new EugeneReturnException(e.getReturnValue());
            }
            
            // incrementation
            exec("computationalStatement", incStart.getTokenIndex());
            
            // evaluation of the loop condition
            ret=(expression_return)exec("expression", condStart.getTokenIndex());
            exprValue = (Variable)ret.objElement;
            b = exprValue.getBoolean();

            // after each loop iteration, clear the loop's symbol tables
            if(b) {        
                StackElement objStackElement = SymbolTables.peek();
                if(objStackElement != null && objStackElement instanceof ForLoop) {  // this should always be true
                    ((ForLoop)objStackElement).clear(); // clear the loop's symbol tables
                    objStackElement = null;
                }
            }
        }
        
        StackElement objStackElement = SymbolTables.peek();
        if(objStackElement != null && objStackElement instanceof ForLoop) {  // this should always be true
            ((ForLoop)objStackElement).clear(); // clear the loop's symbol tables
            SymbolTables.pop();
            
            // now, also clear the loops init variables
            ((ForLoop)objStackElement).finalCleanUp();
            objStackElement = null;
        }

        this.input.seek(oldPosition);
    }

    public ArrayList<NamedElement> execForInit(int tokenIndex) {
        ArrayList<NamedElement> lstElements = new ArrayList<NamedElement>();
        int oldPosition = this.input.index(); // save current location
        this.input.seek(tokenIndex); // seek to place to start execution
        try { // which rule are we executing?
            forInit_return rv = this.forInit(false); 
            lstElements = rv.lstElements;
        } catch (Exception e) {
            e.printStackTrace();
            //this.cleanUp(1);
        }
        finally { 
            // restore location
            this.input.seek(oldPosition); 
        }
        return lstElements;
    }

    private void executeIf(IfStatement objIf) 
        throws EugeneException, EugeneReturnException {
        ConditionalBranch ifBranch = objIf.getIfBranch();
        boolean b;
        
        // evaluate if the statements of the IF branch should get executed
        if(this.evaluateCondition(ifBranch.getCondition())) {
            this.executeBranch(ifBranch);                
        } else {
            // evaluate the else-if conditions and execute the corresponding statements
            ArrayList<ConditionalBranch> lstElseIfBranches = objIf.getElseIfBranches();
            boolean bExecuted = false;
            if(lstElseIfBranches!=null && !lstElseIfBranches.isEmpty()) {
                for(int i=0; i<lstElseIfBranches.size() && !bExecuted; i++) {
                    ConditionalBranch elseIfBranch = lstElseIfBranches.get(i);
                    if(this.evaluateCondition(elseIfBranch.getCondition())) {
                        this.executeBranch(elseIfBranch);                        
                        bExecuted = true;
                    }
                }
            } 
                
            // if no branch got executed, execute the statements of the else branch
            if(!bExecuted) {
                ConditionalBranch elseBranch = objIf.getElseBranch();
                if(elseBranch!=null) {
                    this.executeBranch(elseBranch);
                }
            }
        }
    }

    private void executeBranch(ConditionalBranch objBranch) 
            throws EugeneReturnException {
        SymbolTables.push(objBranch);
        
        this.exec("listOfStatements", objBranch.getStatements().getTokenIndex());

        StackElement objElement = SymbolTables.peek();
        if(objElement!=null && objElement instanceof ConditionalBranch) {  
            SymbolTables.clear(objElement.toString());
            SymbolTables.pop();
        }
    }
        
    private boolean evaluateCondition(Token condToken) 
            throws EugeneException {
        int oldPosition = this.input.index(); // save current location
        this.input.seek(condToken.getTokenIndex()); // seek to place to start execution

        boolean b=false;
        expression_return ret = null;
        try {
            ret = this.expression(false);
        } catch(RecognitionException re) {
            throw new EugeneException(re.getMessage());
        }

        NamedElement objElement = ret.objElement;
        if(objElement!=null && objElement instanceof Variable) {
            b = ((Variable)objElement).getBoolean();
        } else if (objElement instanceof Rule) {
            b = ruleEngine.evaluateIfRule((Rule)objElement);
        } else {
            throw new EugeneException("line "+condToken.getLine()+":"+condToken.getCharPositionInLine()+" => "+
                "I cannot evaluate the conditional statement "+condToken.getText());
        }
        this.input.seek(oldPosition); 
        return b;
    }

    public boolean existsRule(String sRuleName) {
        NamedElement objElement=SymbolTables.get(sRuleName);
        if(null!=objElement && objElement instanceof Rule) {
            return true;
        }
        return false;
    }

    public String getObjectType(NamedElement objElement) {
        if(null == objElement) {
            return null;
        } else if(objElement instanceof Device) {
            return EugeneConstants.DEVICE;
        } else if(objElement instanceof PartType) {
            return ((PartType)objElement).getName();
        } else if(objElement instanceof Part) {
            return ((Part)objElement).getPartType().getName();
        } else if(objElement instanceof Variable) {
            return ((Variable)objElement).getType();
        }
        return objElement.getClass().toString();
    }

    public void initSymbolTables() {
        SymbolTables.init();
    }

    public void cleanUp(int nExitCode) {
        this.cleanUpNoExit();
        
        // and exit
        System.exit(nExitCode);
    }

    public void cleanUpNoExit() {
        // clear the symbol tables
        SymbolTables.cleanUp();
    	
        // clear the rule engine
        if(null!=ruleEngine) {
            //ruleEngine.cleanUp();
            ruleEngine = null;
        }
        
        // clear the interpreter's data structures
        if(null != this.interp) {
            this.interp.cleanUp();
            this.interp = null;
        }
    }

    public NamedElement createElement(String sType, String sName) {
        if(EugeneConstants.DEVICE.equalsIgnoreCase(sType)) {
            return Device.newInstance(sName);
        } else if(EugeneConstants.PART.equalsIgnoreCase(sType)) {
            return new PartType(sName);
        } else if(EugeneConstants.TXT.equalsIgnoreCase(sType) || 
                  EugeneConstants.TXTLIST.equalsIgnoreCase(sType) ||
                  EugeneConstants.NUM.equalsIgnoreCase(sType) ||
                  EugeneConstants.NUMLIST.equalsIgnoreCase(sType) ||
                  EugeneConstants.BOOLEAN.equalsIgnoreCase(sType)) {
            return new Variable(sName,sType);
        } else if(EugeneConstants.DEVICEARRAY.equalsIgnoreCase(sType)) {
            return new DeviceArray(sName);
        } else if(EugeneConstants.PARTARRAY.equalsIgnoreCase(sType)) {
            return new PartArray(sName);
        } else if(EugeneConstants.PROPERTYARRAY.equalsIgnoreCase(sType)) {
            return new PropertyArray(sName);
        } else if(EugeneConstants.RULEARRAY.equalsIgnoreCase(sType)) {
            return new RuleArray(sName);
        } else {
            return SymbolTables.get(sType);
        }
    }


    public static class prog_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "prog"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:529:1: prog : ( eugeneStatement )+ EOF ;
    public final EugeneParser.prog_return prog() throws RecognitionException {
        EugeneParser.prog_return retval = new EugeneParser.prog_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EOF2=null;
        EugeneParser.eugeneStatement_return eugeneStatement1 =null;


        Object EOF2_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:530:2: ( ( eugeneStatement )+ EOF )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:530:4: ( eugeneStatement )+ EOF
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:530:4: ( eugeneStatement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ID && LA1_0 <= INCLUDE)||LA1_0==30||LA1_0==39||(LA1_0 >= 42 && LA1_0 <= 44)||LA1_0==47||LA1_0==49||LA1_0==55||(LA1_0 >= 58 && LA1_0 <= 62)||(LA1_0 >= 70 && LA1_0 <= 71)||(LA1_0 >= 76 && LA1_0 <= 77)||(LA1_0 >= 79 && LA1_0 <= 80)||(LA1_0 >= 84 && LA1_0 <= 90)||(LA1_0 >= 95 && LA1_0 <= 96)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:530:4: eugeneStatement
            	    {
            	    pushFollow(FOLLOW_eugeneStatement_in_prog56);
            	    eugeneStatement1=eugeneStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, eugeneStatement1.getTree());

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


            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_prog59); 
            EOF2_tree = 
            (Object)adaptor.create(EOF2)
            ;
            adaptor.addChild(root_0, EOF2_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prog"


    public static class eugeneStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eugeneStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:533:1: eugeneStatement : ( statement[false] |functionToken= functionDeclaration );
    public final EugeneParser.eugeneStatement_return eugeneStatement() throws RecognitionException {
        EugeneParser.eugeneStatement_return retval = new EugeneParser.eugeneStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.functionDeclaration_return functionToken =null;

        EugeneParser.statement_return statement3 =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:534:2: ( statement[false] |functionToken= functionDeclaration )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0 >= ID && LA2_0 <= INCLUDE)||LA2_0==30||LA2_0==39||(LA2_0 >= 42 && LA2_0 <= 44)||LA2_0==47||LA2_0==49||LA2_0==55||(LA2_0 >= 58 && LA2_0 <= 62)||(LA2_0 >= 70 && LA2_0 <= 71)||LA2_0==76||(LA2_0 >= 79 && LA2_0 <= 80)||(LA2_0 >= 84 && LA2_0 <= 90)||(LA2_0 >= 95 && LA2_0 <= 96)) ) {
                alt2=1;
            }
            else if ( (LA2_0==77) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:534:4: statement[false]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_statement_in_eugeneStatement70);
                    statement3=statement(false);

                    state._fsp--;

                    adaptor.addChild(root_0, statement3.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:535:4: functionToken= functionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_functionDeclaration_in_eugeneStatement78);
                    functionToken=functionDeclaration();

                    state._fsp--;

                    adaptor.addChild(root_0, functionToken.getTree());


                    SymbolTables.put((functionToken!=null?functionToken.objFunction:null));
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println(e.toString());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "eugeneStatement"


    public static class statement_return extends ParserRuleReturnScope {
        public NamedElement objReturnValue;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:544:1: statement[boolean defer] returns [NamedElement objReturnValue] : ( INCLUDE ';' | importStatement[defer] ';' |declToken= declarationStatement[defer] ';' | computationalStatement[defer] ';' | printStatement[defer] ';' | ifStatement[defer] | assertStatement[defer] ';' | noteStatement[defer] ';' | wrappedStatement[defer] ';' | loopStatement[defer] |returnToken= returnStatement[defer] | saveStatement[defer] ';' );
    public final EugeneParser.statement_return statement(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.statement_return retval = new EugeneParser.statement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token INCLUDE4=null;
        Token char_literal5=null;
        Token char_literal7=null;
        Token char_literal8=null;
        Token char_literal10=null;
        Token char_literal12=null;
        Token char_literal15=null;
        Token char_literal17=null;
        Token char_literal19=null;
        Token char_literal22=null;
        EugeneParser.declarationStatement_return declToken =null;

        EugeneParser.returnStatement_return returnToken =null;

        EugeneParser.importStatement_return importStatement6 =null;

        EugeneParser.computationalStatement_return computationalStatement9 =null;

        EugeneParser.printStatement_return printStatement11 =null;

        EugeneParser.ifStatement_return ifStatement13 =null;

        EugeneParser.assertStatement_return assertStatement14 =null;

        EugeneParser.noteStatement_return noteStatement16 =null;

        EugeneParser.wrappedStatement_return wrappedStatement18 =null;

        EugeneParser.loopStatement_return loopStatement20 =null;

        EugeneParser.saveStatement_return saveStatement21 =null;


        Object INCLUDE4_tree=null;
        Object char_literal5_tree=null;
        Object char_literal7_tree=null;
        Object char_literal8_tree=null;
        Object char_literal10_tree=null;
        Object char_literal12_tree=null;
        Object char_literal15_tree=null;
        Object char_literal17_tree=null;
        Object char_literal19_tree=null;
        Object char_literal22_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:547:2: ( INCLUDE ';' | importStatement[defer] ';' |declToken= declarationStatement[defer] ';' | computationalStatement[defer] ';' | printStatement[defer] ';' | ifStatement[defer] | assertStatement[defer] ';' | noteStatement[defer] ';' | wrappedStatement[defer] ';' | loopStatement[defer] |returnToken= returnStatement[defer] | saveStatement[defer] ';' )
            int alt3=12;
            switch ( input.LA(1) ) {
            case INCLUDE:
                {
                alt3=1;
                }
                break;
            case 80:
                {
                alt3=2;
                }
                break;
            case 42:
            case 43:
            case 44:
            case 49:
            case 58:
            case 59:
            case 60:
            case 61:
            case 70:
            case 84:
            case 95:
                {
                alt3=3;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case 67:
                    {
                    int LA3_15 = input.LA(3);

                    if ( (LA3_15==68) ) {
                        alt3=3;
                    }
                    else if ( (LA3_15==FLOAT||LA3_15==ID||(LA3_15 >= INT && LA3_15 <= MINUS)||LA3_15==STRING||LA3_15==19||LA3_15==21||(LA3_15 >= 31 && LA3_15 <= 32)||(LA3_15 >= 34 && LA3_15 <= 37)||(LA3_15 >= 40 && LA3_15 <= 41)||(LA3_15 >= 45 && LA3_15 <= 46)||(LA3_15 >= 50 && LA3_15 <= 54)||(LA3_15 >= 63 && LA3_15 <= 65)||LA3_15==67||LA3_15==74||LA3_15==94) ) {
                        alt3=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 15, input);

                        throw nvae;

                    }
                    }
                    break;
                case DYNAMIC_NAME:
                case ID:
                case MINUS:
                case 21:
                case 24:
                case 33:
                    {
                    alt3=4;
                    }
                    break;
                case 27:
                    {
                    alt3=9;
                    }
                    break;
                case 26:
                    {
                    int LA3_17 = input.LA(3);

                    if ( (LA3_17==78||LA3_17==91||LA3_17==93) ) {
                        alt3=9;
                    }
                    else if ( (LA3_17==ID) ) {
                        alt3=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 17, input);

                        throw nvae;

                    }
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 4, input);

                    throw nvae;

                }

                }
                break;
            case 62:
                {
                int LA3_5 = input.LA(2);

                if ( (LA3_5==26) ) {
                    int LA3_18 = input.LA(3);

                    if ( (LA3_18==73) ) {
                        int LA3_20 = input.LA(4);

                        if ( (LA3_20==21) ) {
                            int LA3_24 = input.LA(5);

                            if ( (LA3_24==ID) ) {
                                int LA3_28 = input.LA(6);

                                if ( (LA3_28==25) ) {
                                    int LA3_32 = input.LA(7);

                                    if ( (LA3_32==STRING) ) {
                                        int LA3_36 = input.LA(8);

                                        if ( (LA3_36==22) ) {
                                            int LA3_39 = input.LA(9);

                                            if ( (LA3_39==30) ) {
                                                int LA3_35 = input.LA(10);

                                                if ( (LA3_35==30) ) {
                                                    alt3=4;
                                                }
                                                else if ( (LA3_35==EOF||(LA3_35 >= ID && LA3_35 <= INCLUDE)||LA3_35==39||(LA3_35 >= 42 && LA3_35 <= 44)||LA3_35==47||LA3_35==49||LA3_35==55||(LA3_35 >= 58 && LA3_35 <= 62)||(LA3_35 >= 70 && LA3_35 <= 71)||(LA3_35 >= 76 && LA3_35 <= 77)||(LA3_35 >= 79 && LA3_35 <= 80)||(LA3_35 >= 84 && LA3_35 <= 90)||(LA3_35 >= 95 && LA3_35 <= 96)||LA3_35==99) ) {
                                                    alt3=9;
                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 3, 35, input);

                                                    throw nvae;

                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 3, 39, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 3, 36, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 3, 32, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 3, 28, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 24, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 20, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA3_18==80) ) {
                        int LA3_21 = input.LA(4);

                        if ( (LA3_21==21) ) {
                            int LA3_25 = input.LA(5);

                            if ( (LA3_25==STRING) ) {
                                int LA3_29 = input.LA(6);

                                if ( (LA3_29==22) ) {
                                    int LA3_33 = input.LA(7);

                                    if ( (LA3_33==30) ) {
                                        int LA3_35 = input.LA(8);

                                        if ( (LA3_35==30) ) {
                                            alt3=4;
                                        }
                                        else if ( (LA3_35==EOF||(LA3_35 >= ID && LA3_35 <= INCLUDE)||LA3_35==39||(LA3_35 >= 42 && LA3_35 <= 44)||LA3_35==47||LA3_35==49||LA3_35==55||(LA3_35 >= 58 && LA3_35 <= 62)||(LA3_35 >= 70 && LA3_35 <= 71)||(LA3_35 >= 76 && LA3_35 <= 77)||(LA3_35 >= 79 && LA3_35 <= 80)||(LA3_35 >= 84 && LA3_35 <= 90)||(LA3_35 >= 95 && LA3_35 <= 96)||LA3_35==99) ) {
                                            alt3=9;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 3, 35, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 3, 33, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 3, 29, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 25, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 21, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 18, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 5, input);

                    throw nvae;

                }
                }
                break;
            case 47:
                {
                int LA3_6 = input.LA(2);

                if ( (LA3_6==26) ) {
                    int LA3_19 = input.LA(3);

                    if ( (LA3_19==80) ) {
                        int LA3_22 = input.LA(4);

                        if ( (LA3_22==21) ) {
                            int LA3_26 = input.LA(5);

                            if ( (LA3_26==ID) ) {
                                int LA3_30 = input.LA(6);

                                if ( (LA3_30==25) ) {
                                    int LA3_34 = input.LA(7);

                                    if ( (LA3_34==STRING) ) {
                                        int LA3_37 = input.LA(8);

                                        if ( (LA3_37==22) ) {
                                            int LA3_40 = input.LA(9);

                                            if ( (LA3_40==30) ) {
                                                int LA3_35 = input.LA(10);

                                                if ( (LA3_35==30) ) {
                                                    alt3=4;
                                                }
                                                else if ( (LA3_35==EOF||(LA3_35 >= ID && LA3_35 <= INCLUDE)||LA3_35==39||(LA3_35 >= 42 && LA3_35 <= 44)||LA3_35==47||LA3_35==49||LA3_35==55||(LA3_35 >= 58 && LA3_35 <= 62)||(LA3_35 >= 70 && LA3_35 <= 71)||(LA3_35 >= 76 && LA3_35 <= 77)||(LA3_35 >= 79 && LA3_35 <= 80)||(LA3_35 >= 84 && LA3_35 <= 90)||(LA3_35 >= 95 && LA3_35 <= 96)||LA3_35==99) ) {
                                                    alt3=9;
                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 3, 35, input);

                                                    throw nvae;

                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 3, 40, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 3, 37, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 3, 34, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 3, 30, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 26, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 22, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA3_19==73) ) {
                        int LA3_23 = input.LA(4);

                        if ( (LA3_23==21) ) {
                            int LA3_27 = input.LA(5);

                            if ( (LA3_27==22) ) {
                                int LA3_31 = input.LA(6);

                                if ( (LA3_31==30) ) {
                                    int LA3_35 = input.LA(7);

                                    if ( (LA3_35==30) ) {
                                        alt3=4;
                                    }
                                    else if ( (LA3_35==EOF||(LA3_35 >= ID && LA3_35 <= INCLUDE)||LA3_35==39||(LA3_35 >= 42 && LA3_35 <= 44)||LA3_35==47||LA3_35==49||LA3_35==55||(LA3_35 >= 58 && LA3_35 <= 62)||(LA3_35 >= 70 && LA3_35 <= 71)||(LA3_35 >= 76 && LA3_35 <= 77)||(LA3_35 >= 79 && LA3_35 <= 80)||(LA3_35 >= 84 && LA3_35 <= 90)||(LA3_35 >= 95 && LA3_35 <= 96)||LA3_35==99) ) {
                                        alt3=9;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 3, 35, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 3, 31, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 27, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 23, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 19, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 6, input);

                    throw nvae;

                }
                }
                break;
            case 30:
            case 86:
            case 87:
                {
                alt3=5;
                }
                break;
            case 79:
                {
                alt3=6;
                }
                break;
            case 39:
                {
                alt3=7;
                }
                break;
            case 55:
                {
                alt3=8;
                }
                break;
            case 85:
            case 88:
                {
                alt3=9;
                }
                break;
            case 71:
            case 76:
            case 96:
                {
                alt3=10;
                }
                break;
            case 89:
                {
                alt3=11;
                }
                break;
            case 90:
                {
                alt3=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:547:4: INCLUDE ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    INCLUDE4=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_statement117); 
                    INCLUDE4_tree = 
                    (Object)adaptor.create(INCLUDE4)
                    ;
                    adaptor.addChild(root_0, INCLUDE4_tree);


                    char_literal5=(Token)match(input,30,FOLLOW_30_in_statement119); 
                    char_literal5_tree = 
                    (Object)adaptor.create(char_literal5)
                    ;
                    adaptor.addChild(root_0, char_literal5_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:548:4: importStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_importStatement_in_statement124);
                    importStatement6=importStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, importStatement6.getTree());

                    char_literal7=(Token)match(input,30,FOLLOW_30_in_statement127); 
                    char_literal7_tree = 
                    (Object)adaptor.create(char_literal7)
                    ;
                    adaptor.addChild(root_0, char_literal7_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:549:4: declToken= declarationStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_declarationStatement_in_statement134);
                    declToken=declarationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, declToken.getTree());

                    char_literal8=(Token)match(input,30,FOLLOW_30_in_statement137); 
                    char_literal8_tree = 
                    (Object)adaptor.create(char_literal8)
                    ;
                    adaptor.addChild(root_0, char_literal8_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:550:4: computationalStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_computationalStatement_in_statement144);
                    computationalStatement9=computationalStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, computationalStatement9.getTree());

                    char_literal10=(Token)match(input,30,FOLLOW_30_in_statement147); 
                    char_literal10_tree = 
                    (Object)adaptor.create(char_literal10)
                    ;
                    adaptor.addChild(root_0, char_literal10_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:551:4: printStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_printStatement_in_statement152);
                    printStatement11=printStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printStatement11.getTree());

                    char_literal12=(Token)match(input,30,FOLLOW_30_in_statement155); 
                    char_literal12_tree = 
                    (Object)adaptor.create(char_literal12)
                    ;
                    adaptor.addChild(root_0, char_literal12_tree);


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:552:4: ifStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ifStatement_in_statement160);
                    ifStatement13=ifStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement13.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:553:4: assertStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_assertStatement_in_statement166);
                    assertStatement14=assertStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assertStatement14.getTree());

                    char_literal15=(Token)match(input,30,FOLLOW_30_in_statement169); 
                    char_literal15_tree = 
                    (Object)adaptor.create(char_literal15)
                    ;
                    adaptor.addChild(root_0, char_literal15_tree);


                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:554:4: noteStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_noteStatement_in_statement176);
                    noteStatement16=noteStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, noteStatement16.getTree());

                    char_literal17=(Token)match(input,30,FOLLOW_30_in_statement179); 
                    char_literal17_tree = 
                    (Object)adaptor.create(char_literal17)
                    ;
                    adaptor.addChild(root_0, char_literal17_tree);


                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:555:4: wrappedStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_wrappedStatement_in_statement186);
                    wrappedStatement18=wrappedStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, wrappedStatement18.getTree());

                    char_literal19=(Token)match(input,30,FOLLOW_30_in_statement189); 
                    char_literal19_tree = 
                    (Object)adaptor.create(char_literal19)
                    ;
                    adaptor.addChild(root_0, char_literal19_tree);


                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:556:10: loopStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_loopStatement_in_statement200);
                    loopStatement20=loopStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, loopStatement20.getTree());

                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:557:4: returnToken= returnStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_returnStatement_in_statement208);
                    returnToken=returnStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, returnToken.getTree());


                    if(!defer) {
                        retval.objReturnValue = (returnToken!=null?returnToken.objReturnValue:null);
                        throw new EugeneReturnException(retval.objReturnValue);
                    }	
                    	

                    }
                    break;
                case 12 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:563:4: saveStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_saveStatement_in_statement216);
                    saveStatement21=saveStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, saveStatement21.getTree());

                    char_literal22=(Token)match(input,30,FOLLOW_30_in_statement219); 
                    char_literal22_tree = 
                    (Object)adaptor.create(char_literal22)
                    ;
                    adaptor.addChild(root_0, char_literal22_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class computationalStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "computationalStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:566:1: computationalStatement[boolean defer] : ( functionCall[defer] |leftToken= objectAssignmentStatement[defer] |instToken= instantiationStatement[defer] | dataExtraction[defer] ';' );
    public final EugeneParser.computationalStatement_return computationalStatement(boolean defer) throws RecognitionException {
        EugeneParser.computationalStatement_return retval = new EugeneParser.computationalStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal25=null;
        EugeneParser.objectAssignmentStatement_return leftToken =null;

        EugeneParser.instantiationStatement_return instToken =null;

        EugeneParser.functionCall_return functionCall23 =null;

        EugeneParser.dataExtraction_return dataExtraction24 =null;


        Object char_literal25_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:567:2: ( functionCall[defer] |leftToken= objectAssignmentStatement[defer] |instToken= instantiationStatement[defer] | dataExtraction[defer] ';' )
            int alt4=4;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ID) ) {
                switch ( input.LA(2) ) {
                case 21:
                    {
                    alt4=1;
                    }
                    break;
                case MINUS:
                case 24:
                case 26:
                case 33:
                case 67:
                    {
                    alt4=2;
                    }
                    break;
                case DYNAMIC_NAME:
                case ID:
                    {
                    alt4=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }

            }
            else if ( (LA4_0==47||LA4_0==62) ) {
                alt4=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:567:4: functionCall[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_functionCall_in_computationalStatement232);
                    functionCall23=functionCall(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, functionCall23.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:568:4: leftToken= objectAssignmentStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_objectAssignmentStatement_in_computationalStatement240);
                    leftToken=objectAssignmentStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, leftToken.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:569:4: instToken= instantiationStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_instantiationStatement_in_computationalStatement249);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        SymbolTables.put((instToken!=null?instToken.objComponent:null));
                    }	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:574:4: dataExtraction[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_dataExtraction_in_computationalStatement257);
                    dataExtraction24=dataExtraction(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, dataExtraction24.getTree());

                    char_literal25=(Token)match(input,30,FOLLOW_30_in_computationalStatement260); 
                    char_literal25_tree = 
                    (Object)adaptor.create(char_literal25)
                    ;
                    adaptor.addChild(root_0, char_literal25_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("[computationalStatement] "+e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "computationalStatement"


    public static class assignment_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignment"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:582:1: assignment[boolean defer] returns [NamedElement objElement] : ( '=' exprToken= expression[defer] | '=' funcToken= functionCall[defer] | '=' stmtToken= wrappedStatement[defer] | '+' '+' | '-' '-' );
    public final EugeneParser.assignment_return assignment(boolean defer) throws RecognitionException {
        EugeneParser.assignment_return retval = new EugeneParser.assignment_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal26=null;
        Token char_literal27=null;
        Token char_literal28=null;
        Token char_literal29=null;
        Token char_literal30=null;
        Token char_literal31=null;
        Token char_literal32=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.functionCall_return funcToken =null;

        EugeneParser.wrappedStatement_return stmtToken =null;


        Object char_literal26_tree=null;
        Object char_literal27_tree=null;
        Object char_literal28_tree=null;
        Object char_literal29_tree=null;
        Object char_literal30_tree=null;
        Object char_literal31_tree=null;
        Object char_literal32_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:583:2: ( '=' exprToken= expression[defer] | '=' funcToken= functionCall[defer] | '=' stmtToken= wrappedStatement[defer] | '+' '+' | '-' '-' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 33:
                {
                switch ( input.LA(2) ) {
                case FLOAT:
                case INT:
                case MINUS:
                case STRING:
                case 19:
                case 21:
                case 31:
                case 32:
                case 34:
                case 35:
                case 36:
                case 37:
                case 40:
                case 41:
                case 45:
                case 46:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 63:
                case 64:
                case 65:
                case 67:
                case 74:
                case 94:
                    {
                    alt5=1;
                    }
                    break;
                case ID:
                    {
                    switch ( input.LA(3) ) {
                    case 21:
                        {
                        alt5=2;
                        }
                        break;
                    case 27:
                        {
                        alt5=3;
                        }
                        break;
                    case 26:
                        {
                        switch ( input.LA(4) ) {
                        case 78:
                            {
                            int LA5_9 = input.LA(5);

                            if ( (LA5_9==21) ) {
                                switch ( input.LA(6) ) {
                                case INT:
                                    {
                                    int LA5_15 = input.LA(7);

                                    if ( (LA5_15==22) ) {
                                        alt5=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 5, 15, input);

                                        throw nvae;

                                    }
                                    }
                                    break;
                                case ID:
                                    {
                                    int LA5_16 = input.LA(7);

                                    if ( (LA5_16==22) ) {
                                        alt5=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 5, 16, input);

                                        throw nvae;

                                    }
                                    }
                                    break;
                                case STRING:
                                    {
                                    int LA5_17 = input.LA(7);

                                    if ( (LA5_17==22) ) {
                                        alt5=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 5, 17, input);

                                        throw nvae;

                                    }
                                    }
                                    break;
                                default:
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 12, input);

                                    throw nvae;

                                }

                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 9, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 91:
                            {
                            int LA5_10 = input.LA(5);

                            if ( (LA5_10==21) ) {
                                int LA5_13 = input.LA(6);

                                if ( (LA5_13==22) ) {
                                    alt5=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 13, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 10, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 93:
                            {
                            int LA5_11 = input.LA(5);

                            if ( (LA5_11==21) ) {
                                int LA5_14 = input.LA(6);

                                if ( (LA5_14==22) ) {
                                    alt5=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 14, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 11, input);

                                throw nvae;

                            }
                            }
                            break;
                        case ID:
                        case 82:
                        case 83:
                            {
                            alt5=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 8, input);

                            throw nvae;

                        }

                        }
                        break;
                    case MINUS:
                    case 19:
                    case 20:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 28:
                    case 30:
                    case 31:
                    case 32:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 40:
                    case 41:
                    case 45:
                    case 46:
                    case 48:
                    case 50:
                    case 51:
                    case 52:
                    case 54:
                    case 57:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 69:
                    case 80:
                    case 81:
                    case 98:
                        {
                        alt5=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 5, input);

                        throw nvae;

                    }

                    }
                    break;
                case 47:
                case 62:
                case 85:
                case 88:
                    {
                    alt5=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;

                }

                }
                break;
            case 24:
                {
                alt5=4;
                }
                break;
            case MINUS:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:583:4: '=' exprToken= expression[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal26=(Token)match(input,33,FOLLOW_33_in_assignment282); 
                    char_literal26_tree = 
                    (Object)adaptor.create(char_literal26)
                    ;
                    adaptor.addChild(root_0, char_literal26_tree);


                    pushFollow(FOLLOW_expression_in_assignment286);
                    exprToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken.getTree());


                    if(!defer) {
                        retval.objElement = (exprToken!=null?exprToken.objElement:null);
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:588:5: '=' funcToken= functionCall[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal27=(Token)match(input,33,FOLLOW_33_in_assignment295); 
                    char_literal27_tree = 
                    (Object)adaptor.create(char_literal27)
                    ;
                    adaptor.addChild(root_0, char_literal27_tree);


                    pushFollow(FOLLOW_functionCall_in_assignment299);
                    funcToken=functionCall(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, funcToken.getTree());


                    if(!defer) {
                        retval.objElement = (funcToken!=null?funcToken.objElement:null);
                    }	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:593:11: '=' stmtToken= wrappedStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal28=(Token)match(input,33,FOLLOW_33_in_assignment314); 
                    char_literal28_tree = 
                    (Object)adaptor.create(char_literal28)
                    ;
                    adaptor.addChild(root_0, char_literal28_tree);


                    pushFollow(FOLLOW_wrappedStatement_in_assignment318);
                    stmtToken=wrappedStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, stmtToken.getTree());


                    if(!defer) {
                        retval.objElement = (stmtToken!=null?stmtToken.objElement:null);
                    }        
                            

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:598:11: '+' '+'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal29=(Token)match(input,24,FOLLOW_24_in_assignment333); 
                    char_literal29_tree = 
                    (Object)adaptor.create(char_literal29)
                    ;
                    adaptor.addChild(root_0, char_literal29_tree);


                    char_literal30=(Token)match(input,24,FOLLOW_24_in_assignment335); 
                    char_literal30_tree = 
                    (Object)adaptor.create(char_literal30)
                    ;
                    adaptor.addChild(root_0, char_literal30_tree);



                    if(!defer) {
                        retval.objElement = null;
                    }        
                            

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:603:11: '-' '-'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal31=(Token)match(input,MINUS,FOLLOW_MINUS_in_assignment349); 
                    char_literal31_tree = 
                    (Object)adaptor.create(char_literal31)
                    ;
                    adaptor.addChild(root_0, char_literal31_tree);


                    char_literal32=(Token)match(input,MINUS,FOLLOW_MINUS_in_assignment351); 
                    char_literal32_tree = 
                    (Object)adaptor.create(char_literal32)
                    ;
                    adaptor.addChild(root_0, char_literal32_tree);



                    if(!defer) {
                        retval.objElement = null;
                    }        
                            

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignment"


    public static class importStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "importStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:610:1: importStatement[boolean defer] : importToken= 'import' lstToken= listOfIDs[defer] ;
    public final EugeneParser.importStatement_return importStatement(boolean defer) throws RecognitionException {
        EugeneParser.importStatement_return retval = new EugeneParser.importStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token importToken=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object importToken_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:611:2: (importToken= 'import' lstToken= listOfIDs[defer] )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:611:4: importToken= 'import' lstToken= listOfIDs[defer]
            {
            root_0 = (Object)adaptor.nil();


            importToken=(Token)match(input,80,FOLLOW_80_in_importStatement369); 
            importToken_tree = 
            (Object)adaptor.create(importToken)
            ;
            adaptor.addChild(root_0, importToken_tree);


            pushFollow(FOLLOW_listOfIDs_in_importStatement373);
            lstToken=listOfIDs(defer);

            state._fsp--;

            adaptor.addChild(root_0, lstToken.getTree());


            if(!defer) {
                Iterator<NamedElement> it=(lstToken!=null?lstToken.lstElements:null).iterator();
                while(it.hasNext()) {
                    NamedElement objElement = it.next();
                    if(null==SymbolTables.get(objElement.getName())) {
                        try {
                            RegistryPart objPart = registryImporter.importPart(objElement.getName());
                            if(null!=objPart) {
                                SymbolTables.put(objPart);
                            } else {
                                System.err.println("line "+(importToken!=null?importToken.getLine():0)+" => "+
                                    "Cannot import "+objElement.getName()+"!");
                                this.cleanUp(1);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.err.println("line "+(importToken!=null?importToken.getLine():0)+" => "+
                              "An element named "+objElement.getName()+" exists already!");
                        this.cleanUp(1);
                    }
                }                    
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println(e.getMessage());
            this.cleanUp(1);	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "importStatement"


    public static class listOfFilenames_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfFilenames"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:644:1: listOfFilenames[boolean defer] : filenameToken= filename[defer] ( ',' listOfFilenames[defer] )? ;
    public final EugeneParser.listOfFilenames_return listOfFilenames(boolean defer) throws RecognitionException {
        EugeneParser.listOfFilenames_return retval = new EugeneParser.listOfFilenames_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal33=null;
        EugeneParser.filename_return filenameToken =null;

        EugeneParser.listOfFilenames_return listOfFilenames34 =null;


        Object char_literal33_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:645:2: (filenameToken= filename[defer] ( ',' listOfFilenames[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:645:4: filenameToken= filename[defer] ( ',' listOfFilenames[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_filename_in_listOfFilenames398);
            filenameToken=filename(defer);

            state._fsp--;

            adaptor.addChild(root_0, filenameToken.getTree());

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:645:34: ( ',' listOfFilenames[defer] )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:645:35: ',' listOfFilenames[defer]
                    {
                    char_literal33=(Token)match(input,25,FOLLOW_25_in_listOfFilenames402); 
                    char_literal33_tree = 
                    (Object)adaptor.create(char_literal33)
                    ;
                    adaptor.addChild(root_0, char_literal33_tree);


                    pushFollow(FOLLOW_listOfFilenames_in_listOfFilenames404);
                    listOfFilenames34=listOfFilenames(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, listOfFilenames34.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfFilenames"


    public static class filename_return extends ParserRuleReturnScope {
        public String sFilename;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:648:1: filename[boolean defer] returns [String sFilename] : (filenameToken+= (~ ( ',' | ';' | '(' ) ) )* ;
    public final EugeneParser.filename_return filename(boolean defer) throws RecognitionException {
        EugeneParser.filename_return retval = new EugeneParser.filename_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token filenameToken=null;
        List list_filenameToken=null;

        Object filenameToken_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:649:2: ( (filenameToken+= (~ ( ',' | ';' | '(' ) ) )* )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:649:4: (filenameToken+= (~ ( ',' | ';' | '(' ) ) )*
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:649:17: (filenameToken+= (~ ( ',' | ';' | '(' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= CHAR && LA7_0 <= 20)||(LA7_0 >= 22 && LA7_0 <= 24)||(LA7_0 >= 26 && LA7_0 <= 29)||(LA7_0 >= 31 && LA7_0 <= 99)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:649:17: filenameToken+= (~ ( ',' | ';' | '(' ) )
            	    {
            	    filenameToken=(Token)input.LT(1);

            	    if ( (input.LA(1) >= CHAR && input.LA(1) <= 20)||(input.LA(1) >= 22 && input.LA(1) <= 24)||(input.LA(1) >= 26 && input.LA(1) <= 29)||(input.LA(1) >= 31 && input.LA(1) <= 99) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, 
            	        (Object)adaptor.create(filenameToken)
            	        );
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    if (list_filenameToken==null) list_filenameToken=new ArrayList();
            	    list_filenameToken.add(filenameToken);


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);



            if(!defer) {	
                StringBuilder sb=new StringBuilder();
                Iterator<CommonToken> it=list_filenameToken.iterator();
                while(it.hasNext()) {
                    sb.append(it.next().getText());
                }
                retval.sFilename =sb.toString();    
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filename"


    public static class declarationStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "declarationStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:664:1: declarationStatement[boolean defer] : ( collectionDeclaration[defer] | variableDeclaration[defer] | propertyDeclaration[defer] | partTypeDeclaration[defer] | deviceDeclaration[defer] | arrayDeclaration[defer] | ruleDeclaration[defer] | imageDeclaration[defer] | deviceTypeDeclaration[defer] );
    public final EugeneParser.declarationStatement_return declarationStatement(boolean defer) throws RecognitionException {
        EugeneParser.declarationStatement_return retval = new EugeneParser.declarationStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.collectionDeclaration_return collectionDeclaration35 =null;

        EugeneParser.variableDeclaration_return variableDeclaration36 =null;

        EugeneParser.propertyDeclaration_return propertyDeclaration37 =null;

        EugeneParser.partTypeDeclaration_return partTypeDeclaration38 =null;

        EugeneParser.deviceDeclaration_return deviceDeclaration39 =null;

        EugeneParser.arrayDeclaration_return arrayDeclaration40 =null;

        EugeneParser.ruleDeclaration_return ruleDeclaration41 =null;

        EugeneParser.imageDeclaration_return imageDeclaration42 =null;

        EugeneParser.deviceTypeDeclaration_return deviceTypeDeclaration43 =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:665:2: ( collectionDeclaration[defer] | variableDeclaration[defer] | propertyDeclaration[defer] | partTypeDeclaration[defer] | deviceDeclaration[defer] | arrayDeclaration[defer] | ruleDeclaration[defer] | imageDeclaration[defer] | deviceTypeDeclaration[defer] )
            int alt8=9;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt8=1;
                }
                break;
            case 70:
            case 84:
            case 95:
                {
                alt8=2;
                }
                break;
            case 60:
                {
                int LA8_3 = input.LA(2);

                if ( (LA8_3==67) ) {
                    alt8=6;
                }
                else if ( (LA8_3==DYNAMIC_NAME||LA8_3==ID) ) {
                    alt8=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 3, input);

                    throw nvae;

                }
                }
                break;
            case 59:
                {
                int LA8_4 = input.LA(2);

                if ( (LA8_4==ID) ) {
                    alt8=4;
                }
                else if ( (LA8_4==67) ) {
                    alt8=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 4, input);

                    throw nvae;

                }
                }
                break;
            case 43:
                {
                int LA8_5 = input.LA(2);

                if ( (LA8_5==ID) ) {
                    alt8=5;
                }
                else if ( (LA8_5==67) ) {
                    alt8=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 5, input);

                    throw nvae;

                }
                }
                break;
            case 58:
                {
                int LA8_6 = input.LA(2);

                if ( (LA8_6==ID) ) {
                    alt8=4;
                }
                else if ( (LA8_6==67) ) {
                    alt8=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 6, input);

                    throw nvae;

                }
                }
                break;
            case 61:
                {
                int LA8_7 = input.LA(2);

                if ( (LA8_7==67) ) {
                    alt8=6;
                }
                else if ( (LA8_7==ID) ) {
                    alt8=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 7, input);

                    throw nvae;

                }
                }
                break;
            case ID:
                {
                alt8=6;
                }
                break;
            case 49:
                {
                alt8=8;
                }
                break;
            case 44:
                {
                alt8=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:665:4: collectionDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_collectionDeclaration_in_declarationStatement460);
                    collectionDeclaration35=collectionDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, collectionDeclaration35.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:666:4: variableDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_variableDeclaration_in_declarationStatement466);
                    variableDeclaration36=variableDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, variableDeclaration36.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:667:4: propertyDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_propertyDeclaration_in_declarationStatement472);
                    propertyDeclaration37=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyDeclaration37.getTree());

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:668:4: partTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partTypeDeclaration_in_declarationStatement478);
                    partTypeDeclaration38=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeDeclaration38.getTree());

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:669:4: deviceDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDeclaration_in_declarationStatement484);
                    deviceDeclaration39=deviceDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceDeclaration39.getTree());

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:670:4: arrayDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_arrayDeclaration_in_declarationStatement490);
                    arrayDeclaration40=arrayDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDeclaration40.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:671:4: ruleDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ruleDeclaration_in_declarationStatement496);
                    ruleDeclaration41=ruleDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, ruleDeclaration41.getTree());

                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:672:4: imageDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_imageDeclaration_in_declarationStatement502);
                    imageDeclaration42=imageDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, imageDeclaration42.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:673:4: deviceTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceTypeDeclaration_in_declarationStatement508);
                    deviceTypeDeclaration43=deviceTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceTypeDeclaration43.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+retval.start.getLine()+""+retval.start.getCharPositionInLine()+
                    " => "+e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declarationStatement"


    public static class collectionDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "collectionDeclaration"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:683:1: collectionDeclaration[boolean defer] : 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )? ;
    public final EugeneParser.collectionDeclaration_return collectionDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.collectionDeclaration_return retval = new EugeneParser.collectionDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal44=null;
        EugeneParser.collectionDefinition_return defToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object nameToken_tree=null;
        Object string_literal44_tree=null;


        eugene.dom.collection.Collection objCollection = 
            (eugene.dom.collection.Collection)null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:688:2: ( 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:688:4: 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal44=(Token)match(input,42,FOLLOW_42_in_collectionDeclaration537); 
            string_literal44_tree = 
            (Object)adaptor.create(string_literal44)
            ;
            adaptor.addChild(root_0, string_literal44_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_collectionDeclaration541); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);



            if(!defer) {
                objCollection = interp.createCollection(
                            (nameToken!=null?nameToken.getText():null), 
                            (java.util.Collection<NamedElement>)null);
            }             
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:695:3: (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )?
            int alt9=3;
            switch ( input.LA(1) ) {
                case 21:
                    {
                    alt9=1;
                    }
                    break;
                case 33:
                    {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2==INCLUDE) ) {
                        alt9=1;
                    }
                    else if ( (LA9_2==FLOAT||LA9_2==ID||(LA9_2 >= INT && LA9_2 <= MINUS)||LA9_2==STRING||LA9_2==19||LA9_2==21||(LA9_2 >= 31 && LA9_2 <= 32)||(LA9_2 >= 34 && LA9_2 <= 37)||(LA9_2 >= 40 && LA9_2 <= 41)||(LA9_2 >= 45 && LA9_2 <= 47)||(LA9_2 >= 50 && LA9_2 <= 54)||(LA9_2 >= 62 && LA9_2 <= 65)||LA9_2==67||LA9_2==74||LA9_2==85||LA9_2==88||LA9_2==94) ) {
                        alt9=2;
                    }
                    }
                    break;
                case MINUS:
                case 24:
                    {
                    alt9=2;
                    }
                    break;
            }

            switch (alt9) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:695:4: defToken= collectionDefinition[defer, objCollection]
                    {
                    pushFollow(FOLLOW_collectionDefinition_in_collectionDeclaration551);
                    defToken=collectionDefinition(defer, objCollection);

                    state._fsp--;

                    adaptor.addChild(root_0, defToken.getTree());


                    if(!defer) {
                        objCollection.setElements( 
                                    (defToken!=null?defToken.colElements:null));
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:700:8: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_collectionDeclaration564);
                    assignToken=assignment(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assignToken.getTree());


                    if(!defer) {
                        interp.assign(
                                    (nameToken!=null?nameToken.getText():null), 
                                    (assignToken!=null?assignToken.objElement:null));
                    }             
                    	

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getCharPositionInLine():0)+" => "+
                e.toString());
            this.cleanUp(1);
                    
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "collectionDeclaration"


    public static class collectionDefinition_return extends ParserRuleReturnScope {
        public java.util.Set<CollectionElement> colElements;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "collectionDefinition"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:714:1: collectionDefinition[boolean defer, eugene.dom.collection.Collection objCollection] returns [java.util.Set<CollectionElement> colElements] : ( '(' lstToken= listOfCollectionComponents[defer] ')' | '=' includeToken= INCLUDE );
    public final EugeneParser.collectionDefinition_return collectionDefinition(boolean defer, eugene.dom.collection.Collection objCollection) throws RecognitionException {
        EugeneParser.collectionDefinition_return retval = new EugeneParser.collectionDefinition_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token includeToken=null;
        Token char_literal45=null;
        Token char_literal46=null;
        Token char_literal47=null;
        EugeneParser.listOfCollectionComponents_return lstToken =null;


        Object includeToken_tree=null;
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;


        retval.colElements = new java.util.HashSet<CollectionElement>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:719:2: ( '(' lstToken= listOfCollectionComponents[defer] ')' | '=' includeToken= INCLUDE )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            else if ( (LA10_0==33) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:719:4: '(' lstToken= listOfCollectionComponents[defer] ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal45=(Token)match(input,21,FOLLOW_21_in_collectionDefinition612); 
                    char_literal45_tree = 
                    (Object)adaptor.create(char_literal45)
                    ;
                    adaptor.addChild(root_0, char_literal45_tree);



                    if(!defer) {
                        // we need to push the collection onto the stack
                        // because in the interpreter the collection elements 
                        // will be put into the symbol tables...
                        SymbolTables.push(objCollection);
                    }	
                    	

                    pushFollow(FOLLOW_listOfCollectionComponents_in_collectionDefinition619);
                    lstToken=listOfCollectionComponents(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());


                    if(!defer) {
                        retval.colElements.addAll((lstToken!=null?lstToken.lstElements:null));
                    }	
                    	

                    char_literal46=(Token)match(input,22,FOLLOW_22_in_collectionDefinition625); 
                    char_literal46_tree = 
                    (Object)adaptor.create(char_literal46)
                    ;
                    adaptor.addChild(root_0, char_literal46_tree);



                    if(!defer) {
                        if(null != SymbolTables.peek()) {
                            // pop the collection from the stack
                            SymbolTables.pop();
                        }
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:738:4: '=' includeToken= INCLUDE
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal47=(Token)match(input,33,FOLLOW_33_in_collectionDefinition632); 
                    char_literal47_tree = 
                    (Object)adaptor.create(char_literal47)
                    ;
                    adaptor.addChild(root_0, char_literal47_tree);


                    includeToken=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_collectionDefinition636); 
                    includeToken_tree = 
                    (Object)adaptor.create(includeToken)
                    ;
                    adaptor.addChild(root_0, includeToken_tree);



                    if(!defer) {
                        throw new EugeneException("such an assignment is not supported yet!");
                    }	
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+" => "+
                e.toString());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "collectionDefinition"


    public static class listOfCollectionComponents_return extends ParserRuleReturnScope {
        public Set<CollectionElement> lstElements;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfCollectionComponents"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:750:1: listOfCollectionComponents[boolean defer] returns [Set<CollectionElement> lstElements] : componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )? ;
    public final EugeneParser.listOfCollectionComponents_return listOfCollectionComponents(boolean defer) throws RecognitionException {
        EugeneParser.listOfCollectionComponents_return retval = new EugeneParser.listOfCollectionComponents_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal48=null;
        EugeneParser.collectionElement_return componentToken =null;

        EugeneParser.listOfCollectionComponents_return lstToken =null;


        Object char_literal48_tree=null;


        retval.lstElements =new HashSet<CollectionElement>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:755:9: (componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:755:11: componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_collectionElement_in_listOfCollectionComponents682);
            componentToken=collectionElement(defer);

            state._fsp--;

            adaptor.addChild(root_0, componentToken.getTree());


            if(!defer) {
                retval.lstElements.add((componentToken!=null?componentToken.objElement:null));
            }        
                    

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:759:11: ( ',' lstToken= listOfCollectionComponents[defer] )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:759:12: ',' lstToken= listOfCollectionComponents[defer]
                    {
                    char_literal48=(Token)match(input,25,FOLLOW_25_in_listOfCollectionComponents688); 
                    char_literal48_tree = 
                    (Object)adaptor.create(char_literal48)
                    ;
                    adaptor.addChild(root_0, char_literal48_tree);


                    pushFollow(FOLLOW_listOfCollectionComponents_in_listOfCollectionComponents692);
                    lstToken=listOfCollectionComponents(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());


                    if(!defer) {
                        retval.lstElements.addAll((lstToken!=null?lstToken.lstElements:null));
                    }        
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfCollectionComponents"


    public static class collectionElement_return extends ParserRuleReturnScope {
        public CollectionElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "collectionElement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:766:1: collectionElement[boolean defer] returns [CollectionElement objElement] : (propertyToken= propertyDeclaration[defer] |partTypeToken= partTypeDeclaration[defer] |deviceToken= deviceDeclaration[defer] |instToken= instantiationStatement[defer] |idToken= ID );
    public final EugeneParser.collectionElement_return collectionElement(boolean defer) throws RecognitionException {
        EugeneParser.collectionElement_return retval = new EugeneParser.collectionElement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        EugeneParser.propertyDeclaration_return propertyToken =null;

        EugeneParser.partTypeDeclaration_return partTypeToken =null;

        EugeneParser.deviceDeclaration_return deviceToken =null;

        EugeneParser.instantiationStatement_return instToken =null;


        Object idToken_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:767:2: (propertyToken= propertyDeclaration[defer] |partTypeToken= partTypeDeclaration[defer] |deviceToken= deviceDeclaration[defer] |instToken= instantiationStatement[defer] |idToken= ID )
            int alt12=5;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt12=1;
                }
                break;
            case 58:
            case 59:
                {
                alt12=2;
                }
                break;
            case 43:
                {
                alt12=3;
                }
                break;
            case ID:
                {
                int LA12_4 = input.LA(2);

                if ( (LA12_4==DYNAMIC_NAME||LA12_4==ID) ) {
                    alt12=4;
                }
                else if ( (LA12_4==22||LA12_4==25) ) {
                    alt12=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:767:4: propertyToken= propertyDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_propertyDeclaration_in_collectionElement730);
                    propertyToken=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyToken.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:768:4: partTypeToken= partTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partTypeDeclaration_in_collectionElement738);
                    partTypeToken=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeToken.getTree());


                    if(!defer) {
                        retval.objElement = partTypeToken.objPartType;
                    }            
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:773:11: deviceToken= deviceDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDeclaration_in_collectionElement755);
                    deviceToken=deviceDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());


                    if(!defer) {
                        retval.objElement = (deviceToken!=null?deviceToken.objDevice:null);
                    }        
                            

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:778:4: instToken= instantiationStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_instantiationStatement_in_collectionElement765);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        retval.objElement = (instToken!=null?instToken.objComponent:null);
                    }
                            

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:783:11: idToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_collectionElement782); 
                    idToken_tree = 
                    (Object)adaptor.create(idToken)
                    ;
                    adaptor.addChild(root_0, idToken_tree);



                    if(!defer) {
                        NamedElement objEl = interp.get((idToken!=null?idToken.getText():null));
                        if(null!=objEl && objEl instanceof CollectionElement) {
                            retval.objElement = (CollectionElement)objEl;
                        }
                    }        
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "collectionElement"


    public static class propertyDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "propertyDeclaration"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:794:1: propertyDeclaration[boolean defer] : 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')' ;
    public final EugeneParser.propertyDeclaration_return propertyDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.propertyDeclaration_return retval = new EugeneParser.propertyDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal49=null;
        Token char_literal50=null;
        Token char_literal51=null;
        EugeneParser.dynamicNaming_return nameToken =null;

        EugeneParser.propertyType_return typeToken =null;


        Object string_literal49_tree=null;
        Object char_literal50_tree=null;
        Object char_literal51_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:795:2: ( 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:795:4: 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal49=(Token)match(input,60,FOLLOW_60_in_propertyDeclaration800); 
            string_literal49_tree = 
            (Object)adaptor.create(string_literal49)
            ;
            adaptor.addChild(root_0, string_literal49_tree);


            pushFollow(FOLLOW_dynamicNaming_in_propertyDeclaration804);
            nameToken=dynamicNaming(defer);

            state._fsp--;

            adaptor.addChild(root_0, nameToken.getTree());

            char_literal50=(Token)match(input,21,FOLLOW_21_in_propertyDeclaration807); 
            char_literal50_tree = 
            (Object)adaptor.create(char_literal50)
            ;
            adaptor.addChild(root_0, char_literal50_tree);


            pushFollow(FOLLOW_propertyType_in_propertyDeclaration811);
            typeToken=propertyType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            char_literal51=(Token)match(input,22,FOLLOW_22_in_propertyDeclaration813); 
            char_literal51_tree = 
            (Object)adaptor.create(char_literal51)
            ;
            adaptor.addChild(root_0, char_literal51_tree);



            if(!defer) {
                interp.createProperty(
                    (nameToken!=null?nameToken.sName:null), 
                    (typeToken!=null?input.toString(typeToken.start,typeToken.stop):null));
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+nameToken.start.getLine()+":"+nameToken.start.getCharPositionInLine()+" => "+        
                e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "propertyDeclaration"


    public static class propertyType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "propertyType"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:809:1: propertyType : ( 'txt' | 'txt' '[' ']' | 'num' | 'num' '[' ']' | 'boolean' );
    public final EugeneParser.propertyType_return propertyType() throws RecognitionException {
        EugeneParser.propertyType_return retval = new EugeneParser.propertyType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal52=null;
        Token string_literal53=null;
        Token char_literal54=null;
        Token char_literal55=null;
        Token string_literal56=null;
        Token string_literal57=null;
        Token char_literal58=null;
        Token char_literal59=null;
        Token string_literal60=null;

        Object string_literal52_tree=null;
        Object string_literal53_tree=null;
        Object char_literal54_tree=null;
        Object char_literal55_tree=null;
        Object string_literal56_tree=null;
        Object string_literal57_tree=null;
        Object char_literal58_tree=null;
        Object char_literal59_tree=null;
        Object string_literal60_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:810:2: ( 'txt' | 'txt' '[' ']' | 'num' | 'num' '[' ']' | 'boolean' )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 95:
                {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==67) ) {
                    alt13=2;
                }
                else if ( (LA13_1==ID||LA13_1==22) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
                }
                break;
            case 84:
                {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==67) ) {
                    alt13=4;
                }
                else if ( (LA13_2==ID||LA13_2==22) ) {
                    alt13=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;

                }
                }
                break;
            case 70:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }

            switch (alt13) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:810:4: 'txt'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal52=(Token)match(input,95,FOLLOW_95_in_propertyType832); 
                    string_literal52_tree = 
                    (Object)adaptor.create(string_literal52)
                    ;
                    adaptor.addChild(root_0, string_literal52_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:811:4: 'txt' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal53=(Token)match(input,95,FOLLOW_95_in_propertyType837); 
                    string_literal53_tree = 
                    (Object)adaptor.create(string_literal53)
                    ;
                    adaptor.addChild(root_0, string_literal53_tree);


                    char_literal54=(Token)match(input,67,FOLLOW_67_in_propertyType839); 
                    char_literal54_tree = 
                    (Object)adaptor.create(char_literal54)
                    ;
                    adaptor.addChild(root_0, char_literal54_tree);


                    char_literal55=(Token)match(input,68,FOLLOW_68_in_propertyType841); 
                    char_literal55_tree = 
                    (Object)adaptor.create(char_literal55)
                    ;
                    adaptor.addChild(root_0, char_literal55_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:812:4: 'num'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal56=(Token)match(input,84,FOLLOW_84_in_propertyType846); 
                    string_literal56_tree = 
                    (Object)adaptor.create(string_literal56)
                    ;
                    adaptor.addChild(root_0, string_literal56_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:813:4: 'num' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal57=(Token)match(input,84,FOLLOW_84_in_propertyType851); 
                    string_literal57_tree = 
                    (Object)adaptor.create(string_literal57)
                    ;
                    adaptor.addChild(root_0, string_literal57_tree);


                    char_literal58=(Token)match(input,67,FOLLOW_67_in_propertyType853); 
                    char_literal58_tree = 
                    (Object)adaptor.create(char_literal58)
                    ;
                    adaptor.addChild(root_0, char_literal58_tree);


                    char_literal59=(Token)match(input,68,FOLLOW_68_in_propertyType855); 
                    char_literal59_tree = 
                    (Object)adaptor.create(char_literal59)
                    ;
                    adaptor.addChild(root_0, char_literal59_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:814:4: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal60=(Token)match(input,70,FOLLOW_70_in_propertyType860); 
                    string_literal60_tree = 
                    (Object)adaptor.create(string_literal60)
                    ;
                    adaptor.addChild(root_0, string_literal60_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "propertyType"


    public static class variableDeclaration_return extends ParserRuleReturnScope {
        public List<Variable> lstVariables;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variableDeclaration"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:819:1: variableDeclaration[boolean defer] returns [List<Variable> lstVariables] : typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text] ;
    public final EugeneParser.variableDeclaration_return variableDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.variableDeclaration_return retval = new EugeneParser.variableDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.propertyType_return typeToken =null;

        EugeneParser.listOfVariables_return varToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:821:2: (typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text] )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:821:4: typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_propertyType_in_variableDeclaration884);
            typeToken=propertyType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            pushFollow(FOLLOW_listOfVariables_in_variableDeclaration888);
            varToken=listOfVariables(defer, (typeToken!=null?input.toString(typeToken.start,typeToken.stop):null));

            state._fsp--;

            adaptor.addChild(root_0, varToken.getTree());


            if(!defer) {
                retval.lstVariables = (varToken!=null?varToken.lstVariables:null);
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "variableDeclaration"


    public static class listOfVariables_return extends ParserRuleReturnScope {
        public List<Variable> lstVariables;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfVariables"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:828:1: listOfVariables[boolean defer, String sVariableType] returns [List<Variable> lstVariables] : idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )? ;
    public final EugeneParser.listOfVariables_return listOfVariables(boolean defer, String sVariableType) throws RecognitionException {
        EugeneParser.listOfVariables_return retval = new EugeneParser.listOfVariables_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal61=null;
        EugeneParser.assignment_return assignToken =null;

        EugeneParser.listOfVariables_return lstToken =null;


        Object idToken_tree=null;
        Object char_literal61_tree=null;


        retval.lstVariables = new ArrayList<Variable>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:833:2: (idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:833:4: idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )?
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfVariables916); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);



            if(!defer) {
                retval.lstVariables.add(
                    interp.createVariable((idToken!=null?idToken.getText():null), sVariableType));
            }
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:838:9: (assignToken= assignment[defer] )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==MINUS||LA14_0==24||LA14_0==33) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:838:10: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_listOfVariables928);
                    assignToken=assignment(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assignToken.getTree());


                    if(!defer) {
                        interp.assign((idToken!=null?idToken.getText():null), 
                            (assignToken!=null?assignToken.objElement:null));
                    }
                            

                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:843:14: ( ',' lstToken= listOfVariables[defer, sVariableType] )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:843:15: ',' lstToken= listOfVariables[defer, sVariableType]
                    {
                    char_literal61=(Token)match(input,25,FOLLOW_25_in_listOfVariables937); 
                    char_literal61_tree = 
                    (Object)adaptor.create(char_literal61)
                    ;
                    adaptor.addChild(root_0, char_literal61_tree);


                    pushFollow(FOLLOW_listOfVariables_in_listOfVariables941);
                    lstToken=listOfVariables(defer, sVariableType);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());


                    if(defer) {
                        retval.lstVariables.addAll((lstToken!=null?lstToken.lstVariables:null));
                    }        
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception exc) {

            if(!defer) {	
            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                 exc.getMessage());
            this.cleanUp(1);
            }    
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfVariables"


    public static class partTypeDeclaration_return extends ParserRuleReturnScope {
        public PartType objPartType;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partTypeDeclaration"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:858:1: partTypeDeclaration[boolean defer] returns [PartType objPartType] : ( ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? | ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer] );
    public final EugeneParser.partTypeDeclaration_return partTypeDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.partTypeDeclaration_return retval = new EugeneParser.partTypeDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token set62=null;
        Token char_literal63=null;
        Token char_literal64=null;
        Token set65=null;
        EugeneParser.listOfIDs_return lstToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object nameToken_tree=null;
        Object set62_tree=null;
        Object char_literal63_tree=null;
        Object char_literal64_tree=null;
        Object set65_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:859:2: ( ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? | ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer] )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0 >= 58 && LA18_0 <= 59)) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==ID) ) {
                    int LA18_2 = input.LA(3);

                    if ( ((LA18_2 >= 21 && LA18_2 <= 22)||LA18_2==25||LA18_2==30) ) {
                        alt18=1;
                    }
                    else if ( (LA18_2==MINUS||LA18_2==24||LA18_2==33) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }
            switch (alt18) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:859:4: ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )?
                    {
                    root_0 = (Object)adaptor.nil();


                    set62=(Token)input.LT(1);

                    if ( (input.LA(1) >= 58 && input.LA(1) <= 59) ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set62)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_partTypeDeclaration983); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:859:38: ( '(' (lstToken= listOfIDs[defer] )? ')' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==21) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:859:39: '(' (lstToken= listOfIDs[defer] )? ')'
                            {
                            char_literal63=(Token)match(input,21,FOLLOW_21_in_partTypeDeclaration986); 
                            char_literal63_tree = 
                            (Object)adaptor.create(char_literal63)
                            ;
                            adaptor.addChild(root_0, char_literal63_tree);


                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:859:43: (lstToken= listOfIDs[defer] )?
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( (LA16_0==ID) ) {
                                alt16=1;
                            }
                            switch (alt16) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:859:44: lstToken= listOfIDs[defer]
                                    {
                                    pushFollow(FOLLOW_listOfIDs_in_partTypeDeclaration991);
                                    lstToken=listOfIDs(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, lstToken.getTree());

                                    }
                                    break;

                            }


                            char_literal64=(Token)match(input,22,FOLLOW_22_in_partTypeDeclaration996); 
                            char_literal64_tree = 
                            (Object)adaptor.create(char_literal64)
                            ;
                            adaptor.addChild(root_0, char_literal64_tree);


                            }
                            break;

                    }



                    if(!defer) {
                        interp.createPartType(
                                (nameToken!=null?nameToken.getText():null), 
                                (lstToken!=null?lstToken.lstElements:null));
                    }
                            

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:866:11: ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    set65=(Token)input.LT(1);

                    if ( (input.LA(1) >= 58 && input.LA(1) <= 59) ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set65)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_partTypeDeclaration1020); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    pushFollow(FOLLOW_assignment_in_partTypeDeclaration1024);
                    assignToken=assignment(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assignToken.getTree());


                    if(!defer) {
                        interp.assign(
                                (nameToken!=null?nameToken.getText():null), 
                                (assignToken!=null?assignToken.objElement:null));
                    }        
                            

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            this.cleanUp(1);	
                    
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partTypeDeclaration"


    public static class listOfIDs_return extends ParserRuleReturnScope {
        public ArrayList<NamedElement> lstElements;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfIDs"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:880:1: listOfIDs[boolean defer] returns [ArrayList<NamedElement> lstElements] : idToken= ID ( ',' lstToken= listOfIDs[defer] )? ;
    public final EugeneParser.listOfIDs_return listOfIDs(boolean defer) throws RecognitionException {
        EugeneParser.listOfIDs_return retval = new EugeneParser.listOfIDs_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal66=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object idToken_tree=null;
        Object char_literal66_tree=null;


        retval.lstElements =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:884:2: (idToken= ID ( ',' lstToken= listOfIDs[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:884:4: idToken= ID ( ',' lstToken= listOfIDs[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfIDs1058); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


             
            if(!defer) {
                NamedElement objElement = interp.get((idToken!=null?idToken.getText():null));
                if(null==objElement) {
                    System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+
                        " => I don't know anything about "+(idToken!=null?idToken.getText():null)+"!");
                    this.cleanUp(1);
                }
                retval.lstElements.add(objElement);
            }	
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:894:4: ( ',' lstToken= listOfIDs[defer] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:894:5: ',' lstToken= listOfIDs[defer]
                    {
                    char_literal66=(Token)match(input,25,FOLLOW_25_in_listOfIDs1063); 
                    char_literal66_tree = 
                    (Object)adaptor.create(char_literal66)
                    ;
                    adaptor.addChild(root_0, char_literal66_tree);


                    pushFollow(FOLLOW_listOfIDs_in_listOfIDs1067);
                    lstToken=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());

                    }
                    break;

            }



            if(!defer){
                if(null!=lstToken) {
                    retval.lstElements.addAll((lstToken!=null?lstToken.lstElements:null));
                }
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfIDs"


    public static class deviceDeclaration_return extends ParserRuleReturnScope {
        public Device objDevice;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "deviceDeclaration"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:904:1: deviceDeclaration[boolean defer] returns [Device objDevice] : 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )? ;
    public final EugeneParser.deviceDeclaration_return deviceDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.deviceDeclaration_return retval = new EugeneParser.deviceDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal67=null;
        Token char_literal68=null;
        Token char_literal69=null;
        EugeneParser.deviceComponents_return compToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object nameToken_tree=null;
        Object string_literal67_tree=null;
        Object char_literal68_tree=null;
        Object char_literal69_tree=null;


        retval.objDevice = (Device)null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:909:2: ( 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:909:4: 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal67=(Token)match(input,43,FOLLOW_43_in_deviceDeclaration1098); 
            string_literal67_tree = 
            (Object)adaptor.create(string_literal67)
            ;
            adaptor.addChild(root_0, string_literal67_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_deviceDeclaration1102); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:909:26: ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )?
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==21) ) {
                alt21=1;
            }
            else if ( (LA21_0==MINUS||LA21_0==24||LA21_0==33) ) {
                alt21=2;
            }
            switch (alt21) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:909:28: '(' (compToken= deviceComponents[defer] )? ')'
                    {
                    char_literal68=(Token)match(input,21,FOLLOW_21_in_deviceDeclaration1106); 
                    char_literal68_tree = 
                    (Object)adaptor.create(char_literal68)
                    ;
                    adaptor.addChild(root_0, char_literal68_tree);


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:909:32: (compToken= deviceComponents[defer] )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==FLOAT||LA20_0==ID||(LA20_0 >= INT && LA20_0 <= MINUS)||LA20_0==STRING||LA20_0==21||LA20_0==43||(LA20_0 >= 58 && LA20_0 <= 59)||LA20_0==67||LA20_0==74||LA20_0==94) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:909:33: compToken= deviceComponents[defer]
                            {
                            pushFollow(FOLLOW_deviceComponents_in_deviceDeclaration1111);
                            compToken=deviceComponents(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, compToken.getTree());


                            if(!defer) {
                                retval.objDevice = interp.createDevice((nameToken!=null?nameToken.getText():null), (compToken!=null?compToken.lstElements:null));
                            }    	    	    	
                            	

                            }
                            break;

                    }


                    char_literal69=(Token)match(input,22,FOLLOW_22_in_deviceDeclaration1118); 
                    char_literal69_tree = 
                    (Object)adaptor.create(char_literal69)
                    ;
                    adaptor.addChild(root_0, char_literal69_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:914:10: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_deviceDeclaration1131);
                    assignToken=assignment(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assignToken.getTree());


                    if(!defer) {
                        retval.objDevice = interp.createDevice((nameToken!=null?nameToken.getText():null), (List<NamedElement>)null); 
                        interp.assign((nameToken!=null?nameToken.getText():null), (assignToken!=null?assignToken.objElement:null));
                    }    	
                        	

                    }
                    break;

            }



            if(!defer && null == retval.objDevice) {
                retval.objDevice = interp.createDevice((nameToken!=null?nameToken.getText():null), (List<NamedElement>)null);
            }     	
                	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getCharPositionInLine():0)+
                     " => "+e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "deviceDeclaration"


    public static class deviceComponents_return extends ParserRuleReturnScope {
        public ArrayList<NamedElement> lstElements;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "deviceComponents"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:932:1: deviceComponents[boolean defer] returns [ArrayList<NamedElement> lstElements] : (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )? ;
    public final EugeneParser.deviceComponents_return deviceComponents(boolean defer) throws RecognitionException {
        EugeneParser.deviceComponents_return retval = new EugeneParser.deviceComponents_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal70=null;
        EugeneParser.expressionValue_return objToken =null;

        EugeneParser.partTypeDeclaration_return partTypeToken =null;

        EugeneParser.instantiationStatement_return instToken =null;

        EugeneParser.deviceDeclaration_return deviceToken =null;

        EugeneParser.deviceComponents_return compToken =null;


        Object char_literal70_tree=null;


        retval.lstElements = new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:937:2: ( (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:937:4: (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:937:4: (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |deviceToken= deviceDeclaration[defer] )
            int alt22=4;
            switch ( input.LA(1) ) {
            case FLOAT:
            case INT:
            case MINUS:
            case STRING:
            case 21:
            case 67:
            case 74:
            case 94:
                {
                alt22=1;
                }
                break;
            case ID:
                {
                int LA22_2 = input.LA(2);

                if ( (LA22_2==22||(LA22_2 >= 25 && LA22_2 <= 26)||LA22_2==67||LA22_2==80) ) {
                    alt22=1;
                }
                else if ( (LA22_2==DYNAMIC_NAME||LA22_2==ID) ) {
                    alt22=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;

                }
                }
                break;
            case 58:
            case 59:
                {
                alt22=2;
                }
                break;
            case 43:
                {
                alt22=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:937:5: objToken= expressionValue[defer]
                    {
                    pushFollow(FOLLOW_expressionValue_in_deviceComponents1173);
                    objToken=expressionValue(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, objToken.getTree());


                    if(!defer) {	
                        retval.lstElements.add((objToken!=null?objToken.objElement:null));
                    }
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:942:4: partTypeToken= partTypeDeclaration[defer]
                    {
                    pushFollow(FOLLOW_partTypeDeclaration_in_deviceComponents1184);
                    partTypeToken=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeToken.getTree());


                    if(!defer) {
                        retval.lstElements.add((partTypeToken!=null?partTypeToken.objPartType:null));
                    }    
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:947:4: instToken= instantiationStatement[defer]
                    {
                    pushFollow(FOLLOW_instantiationStatement_in_deviceComponents1194);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        retval.lstElements.add((instToken!=null?instToken.objComponent:null));
                    }    
                        	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:952:4: deviceToken= deviceDeclaration[defer]
                    {
                    pushFollow(FOLLOW_deviceDeclaration_in_deviceComponents1204);
                    deviceToken=deviceDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());


                    if(!defer) {
                        retval.lstElements.add((deviceToken!=null?deviceToken.objDevice:null));
                    }    
                    	

                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:956:5: ( ',' compToken= deviceComponents[defer] )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==25) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:956:6: ',' compToken= deviceComponents[defer]
                    {
                    char_literal70=(Token)match(input,25,FOLLOW_25_in_deviceComponents1212); 
                    char_literal70_tree = 
                    (Object)adaptor.create(char_literal70)
                    ;
                    adaptor.addChild(root_0, char_literal70_tree);


                    pushFollow(FOLLOW_deviceComponents_in_deviceComponents1216);
                    compToken=deviceComponents(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, compToken.getTree());


                    if(!defer) {
                        retval.lstElements.addAll((compToken!=null?compToken.lstElements:null));
                    }	
                    	

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "deviceComponents"


    public static class deviceTypeDeclaration_return extends ParserRuleReturnScope {
        public DeviceType objDeviceType;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "deviceTypeDeclaration"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:963:1: deviceTypeDeclaration[boolean defer] returns [DeviceType objDeviceType] : 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')' ;
    public final EugeneParser.deviceTypeDeclaration_return deviceTypeDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.deviceTypeDeclaration_return retval = new EugeneParser.deviceTypeDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token string_literal71=null;
        Token char_literal72=null;
        Token char_literal73=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object idToken_tree=null;
        Object string_literal71_tree=null;
        Object char_literal72_tree=null;
        Object char_literal73_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:965:2: ( 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:965:4: 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal71=(Token)match(input,44,FOLLOW_44_in_deviceTypeDeclaration1242); 
            string_literal71_tree = 
            (Object)adaptor.create(string_literal71)
            ;
            adaptor.addChild(root_0, string_literal71_tree);


            idToken=(Token)match(input,ID,FOLLOW_ID_in_deviceTypeDeclaration1246); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal72=(Token)match(input,21,FOLLOW_21_in_deviceTypeDeclaration1248); 
            char_literal72_tree = 
            (Object)adaptor.create(char_literal72)
            ;
            adaptor.addChild(root_0, char_literal72_tree);


            pushFollow(FOLLOW_listOfIDs_in_deviceTypeDeclaration1252);
            lstToken=listOfIDs(defer);

            state._fsp--;

            adaptor.addChild(root_0, lstToken.getTree());

            char_literal73=(Token)match(input,22,FOLLOW_22_in_deviceTypeDeclaration1255); 
            char_literal73_tree = 
            (Object)adaptor.create(char_literal73)
            ;
            adaptor.addChild(root_0, char_literal73_tree);



            if(!defer) {
                interp.createDeviceType(
                        (idToken!=null?idToken.getText():null), 
                        (lstToken!=null?lstToken.lstElements:null));
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println((idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                e.getMessage());
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "deviceTypeDeclaration"


    public static class arrayDeclaration_return extends ParserRuleReturnScope {
        public NamedElement objArray;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arrayDeclaration"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:979:1: arrayDeclaration[boolean defer] returns [NamedElement objArray] : typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )? ;
    public final EugeneParser.arrayDeclaration_return arrayDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.arrayDeclaration_return retval = new EugeneParser.arrayDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        EugeneParser.arrayType_return typeToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object nameToken_tree=null;


        retval.objArray = null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:984:2: (typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:984:4: typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_arrayType_in_arrayDeclaration1290);
            typeToken=arrayType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            nameToken=(Token)match(input,ID,FOLLOW_ID_in_arrayDeclaration1294); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);



            if(!defer) {
                if(null != interp.get((nameToken!=null?nameToken.getText():null))) {
                    System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getCharPositionInLine():0)+" => "+
                        "There exists already an element named "+(nameToken!=null?nameToken.getText():null)+"!");
                    this.cleanUp(1);
                }
            }	
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:992:3: (assignToken= assignment[defer] )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==MINUS||LA24_0==24||LA24_0==33) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:992:4: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_arrayDeclaration1300);
                    assignToken=assignment(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assignToken.getTree());

                    }
                    break;

            }



            if(!defer) {
                interp.createArray((typeToken!=null?input.toString(typeToken.start,typeToken.stop):null), (nameToken!=null?nameToken.getText():null));
                if(null!=assignToken) {
                    interp.assign((nameToken!=null?nameToken.getText():null), (assignToken!=null?assignToken.objElement:null));
                }
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getCharPositionInLine():0)+" => "+
                e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arrayDeclaration"


    public static class arrayType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arrayType"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1008:1: arrayType : ( 'Device' '[' ']' | 'PartType' '[' ']' | 'Part' '[' ']' | 'Property' '[' ']' | 'Rule' '[' ']' | ID '[' ']' );
    public final EugeneParser.arrayType_return arrayType() throws RecognitionException {
        EugeneParser.arrayType_return retval = new EugeneParser.arrayType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal74=null;
        Token char_literal75=null;
        Token char_literal76=null;
        Token string_literal77=null;
        Token char_literal78=null;
        Token char_literal79=null;
        Token string_literal80=null;
        Token char_literal81=null;
        Token char_literal82=null;
        Token string_literal83=null;
        Token char_literal84=null;
        Token char_literal85=null;
        Token string_literal86=null;
        Token char_literal87=null;
        Token char_literal88=null;
        Token ID89=null;
        Token char_literal90=null;
        Token char_literal91=null;

        Object string_literal74_tree=null;
        Object char_literal75_tree=null;
        Object char_literal76_tree=null;
        Object string_literal77_tree=null;
        Object char_literal78_tree=null;
        Object char_literal79_tree=null;
        Object string_literal80_tree=null;
        Object char_literal81_tree=null;
        Object char_literal82_tree=null;
        Object string_literal83_tree=null;
        Object char_literal84_tree=null;
        Object char_literal85_tree=null;
        Object string_literal86_tree=null;
        Object char_literal87_tree=null;
        Object char_literal88_tree=null;
        Object ID89_tree=null;
        Object char_literal90_tree=null;
        Object char_literal91_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1009:2: ( 'Device' '[' ']' | 'PartType' '[' ']' | 'Part' '[' ']' | 'Property' '[' ']' | 'Rule' '[' ']' | ID '[' ']' )
            int alt25=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt25=1;
                }
                break;
            case 59:
                {
                alt25=2;
                }
                break;
            case 58:
                {
                alt25=3;
                }
                break;
            case 60:
                {
                alt25=4;
                }
                break;
            case 61:
                {
                alt25=5;
                }
                break;
            case ID:
                {
                alt25=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1009:4: 'Device' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal74=(Token)match(input,43,FOLLOW_43_in_arrayType1324); 
                    string_literal74_tree = 
                    (Object)adaptor.create(string_literal74)
                    ;
                    adaptor.addChild(root_0, string_literal74_tree);


                    char_literal75=(Token)match(input,67,FOLLOW_67_in_arrayType1326); 
                    char_literal75_tree = 
                    (Object)adaptor.create(char_literal75)
                    ;
                    adaptor.addChild(root_0, char_literal75_tree);


                    char_literal76=(Token)match(input,68,FOLLOW_68_in_arrayType1328); 
                    char_literal76_tree = 
                    (Object)adaptor.create(char_literal76)
                    ;
                    adaptor.addChild(root_0, char_literal76_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1010:4: 'PartType' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal77=(Token)match(input,59,FOLLOW_59_in_arrayType1333); 
                    string_literal77_tree = 
                    (Object)adaptor.create(string_literal77)
                    ;
                    adaptor.addChild(root_0, string_literal77_tree);


                    char_literal78=(Token)match(input,67,FOLLOW_67_in_arrayType1335); 
                    char_literal78_tree = 
                    (Object)adaptor.create(char_literal78)
                    ;
                    adaptor.addChild(root_0, char_literal78_tree);


                    char_literal79=(Token)match(input,68,FOLLOW_68_in_arrayType1337); 
                    char_literal79_tree = 
                    (Object)adaptor.create(char_literal79)
                    ;
                    adaptor.addChild(root_0, char_literal79_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1011:4: 'Part' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal80=(Token)match(input,58,FOLLOW_58_in_arrayType1342); 
                    string_literal80_tree = 
                    (Object)adaptor.create(string_literal80)
                    ;
                    adaptor.addChild(root_0, string_literal80_tree);


                    char_literal81=(Token)match(input,67,FOLLOW_67_in_arrayType1344); 
                    char_literal81_tree = 
                    (Object)adaptor.create(char_literal81)
                    ;
                    adaptor.addChild(root_0, char_literal81_tree);


                    char_literal82=(Token)match(input,68,FOLLOW_68_in_arrayType1346); 
                    char_literal82_tree = 
                    (Object)adaptor.create(char_literal82)
                    ;
                    adaptor.addChild(root_0, char_literal82_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1012:4: 'Property' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal83=(Token)match(input,60,FOLLOW_60_in_arrayType1351); 
                    string_literal83_tree = 
                    (Object)adaptor.create(string_literal83)
                    ;
                    adaptor.addChild(root_0, string_literal83_tree);


                    char_literal84=(Token)match(input,67,FOLLOW_67_in_arrayType1353); 
                    char_literal84_tree = 
                    (Object)adaptor.create(char_literal84)
                    ;
                    adaptor.addChild(root_0, char_literal84_tree);


                    char_literal85=(Token)match(input,68,FOLLOW_68_in_arrayType1355); 
                    char_literal85_tree = 
                    (Object)adaptor.create(char_literal85)
                    ;
                    adaptor.addChild(root_0, char_literal85_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1013:4: 'Rule' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal86=(Token)match(input,61,FOLLOW_61_in_arrayType1360); 
                    string_literal86_tree = 
                    (Object)adaptor.create(string_literal86)
                    ;
                    adaptor.addChild(root_0, string_literal86_tree);


                    char_literal87=(Token)match(input,67,FOLLOW_67_in_arrayType1362); 
                    char_literal87_tree = 
                    (Object)adaptor.create(char_literal87)
                    ;
                    adaptor.addChild(root_0, char_literal87_tree);


                    char_literal88=(Token)match(input,68,FOLLOW_68_in_arrayType1364); 
                    char_literal88_tree = 
                    (Object)adaptor.create(char_literal88)
                    ;
                    adaptor.addChild(root_0, char_literal88_tree);


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1014:4: ID '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    ID89=(Token)match(input,ID,FOLLOW_ID_in_arrayType1369); 
                    ID89_tree = 
                    (Object)adaptor.create(ID89)
                    ;
                    adaptor.addChild(root_0, ID89_tree);


                    char_literal90=(Token)match(input,67,FOLLOW_67_in_arrayType1371); 
                    char_literal90_tree = 
                    (Object)adaptor.create(char_literal90)
                    ;
                    adaptor.addChild(root_0, char_literal90_tree);


                    char_literal91=(Token)match(input,68,FOLLOW_68_in_arrayType1373); 
                    char_literal91_tree = 
                    (Object)adaptor.create(char_literal91)
                    ;
                    adaptor.addChild(root_0, char_literal91_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arrayType"


    public static class ruleDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ruleDeclaration"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1019:1: ruleDeclaration[boolean defer] : 'Rule' ruleNameToken= ID '(' ( 'ON' deviceToken= ID ':' )? exprToken= expression[true] ')' ;
    public final EugeneParser.ruleDeclaration_return ruleDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.ruleDeclaration_return retval = new EugeneParser.ruleDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ruleNameToken=null;
        Token deviceToken=null;
        Token string_literal92=null;
        Token char_literal93=null;
        Token string_literal94=null;
        Token char_literal95=null;
        Token char_literal96=null;
        EugeneParser.expression_return exprToken =null;


        Object ruleNameToken_tree=null;
        Object deviceToken_tree=null;
        Object string_literal92_tree=null;
        Object char_literal93_tree=null;
        Object string_literal94_tree=null;
        Object char_literal95_tree=null;
        Object char_literal96_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1020:2: ( 'Rule' ruleNameToken= ID '(' ( 'ON' deviceToken= ID ':' )? exprToken= expression[true] ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1020:4: 'Rule' ruleNameToken= ID '(' ( 'ON' deviceToken= ID ':' )? exprToken= expression[true] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal92=(Token)match(input,61,FOLLOW_61_in_ruleDeclaration1389); 
            string_literal92_tree = 
            (Object)adaptor.create(string_literal92)
            ;
            adaptor.addChild(root_0, string_literal92_tree);


            ruleNameToken=(Token)match(input,ID,FOLLOW_ID_in_ruleDeclaration1393); 
            ruleNameToken_tree = 
            (Object)adaptor.create(ruleNameToken)
            ;
            adaptor.addChild(root_0, ruleNameToken_tree);


            char_literal93=(Token)match(input,21,FOLLOW_21_in_ruleDeclaration1395); 
            char_literal93_tree = 
            (Object)adaptor.create(char_literal93)
            ;
            adaptor.addChild(root_0, char_literal93_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1020:32: ( 'ON' deviceToken= ID ':' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==56) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1020:33: 'ON' deviceToken= ID ':'
                    {
                    string_literal94=(Token)match(input,56,FOLLOW_56_in_ruleDeclaration1398); 
                    string_literal94_tree = 
                    (Object)adaptor.create(string_literal94)
                    ;
                    adaptor.addChild(root_0, string_literal94_tree);


                    deviceToken=(Token)match(input,ID,FOLLOW_ID_in_ruleDeclaration1402); 
                    deviceToken_tree = 
                    (Object)adaptor.create(deviceToken)
                    ;
                    adaptor.addChild(root_0, deviceToken_tree);


                    char_literal95=(Token)match(input,29,FOLLOW_29_in_ruleDeclaration1404); 
                    char_literal95_tree = 
                    (Object)adaptor.create(char_literal95)
                    ;
                    adaptor.addChild(root_0, char_literal95_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_ruleDeclaration1410);
            exprToken=expression(true);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {    
                interp.createRule((ruleNameToken!=null?ruleNameToken.getText():null), 
                        (deviceToken!=null?deviceToken.getText():null), 
                        exprToken.start, 
                        (CommonTree)(exprToken!=null?((Object)exprToken.tree):null));    
            }
                    

            char_literal96=(Token)match(input,22,FOLLOW_22_in_ruleDeclaration1415); 
            char_literal96_tree = 
            (Object)adaptor.create(char_literal96)
            ;
            adaptor.addChild(root_0, char_literal96_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+(ruleNameToken!=null?ruleNameToken.getLine():0)+":"+(ruleNameToken!=null?ruleNameToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            this.cleanUp(1);
                    
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleDeclaration"


    public static class onDeviceRule_return extends ParserRuleReturnScope {
        public Rule objRule;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "onDeviceRule"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1036:1: onDeviceRule[boolean defer] returns [Rule objRule] : ( 'ON' deviceToken= ID ':' )? exprToken= expression[true] ;
    public final EugeneParser.onDeviceRule_return onDeviceRule(boolean defer) throws EugeneException, RecognitionException {
        EugeneParser.onDeviceRule_return retval = new EugeneParser.onDeviceRule_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token deviceToken=null;
        Token string_literal97=null;
        Token char_literal98=null;
        EugeneParser.expression_return exprToken =null;


        Object deviceToken_tree=null;
        Object string_literal97_tree=null;
        Object char_literal98_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1039:2: ( ( 'ON' deviceToken= ID ':' )? exprToken= expression[true] )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1039:4: ( 'ON' deviceToken= ID ':' )? exprToken= expression[true]
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1039:4: ( 'ON' deviceToken= ID ':' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==56) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1039:5: 'ON' deviceToken= ID ':'
                    {
                    string_literal97=(Token)match(input,56,FOLLOW_56_in_onDeviceRule1468); 
                    string_literal97_tree = 
                    (Object)adaptor.create(string_literal97)
                    ;
                    adaptor.addChild(root_0, string_literal97_tree);


                    deviceToken=(Token)match(input,ID,FOLLOW_ID_in_onDeviceRule1472); 
                    deviceToken_tree = 
                    (Object)adaptor.create(deviceToken)
                    ;
                    adaptor.addChild(root_0, deviceToken_tree);


                    char_literal98=(Token)match(input,29,FOLLOW_29_in_onDeviceRule1474); 
                    char_literal98_tree = 
                    (Object)adaptor.create(char_literal98)
                    ;
                    adaptor.addChild(root_0, char_literal98_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_onDeviceRule1480);
            exprToken=expression(true);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {
                retval.objRule = interp.createRule(
                        null, 
                        (deviceToken!=null?deviceToken.getText():null), 
                        exprToken.start, 
                        (CommonTree)(exprToken!=null?((Object)exprToken.tree):null));    
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "onDeviceRule"


    public static class imageDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "imageDeclaration"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1052:1: imageDeclaration[boolean defer] : 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')' ;
    public final EugeneParser.imageDeclaration_return imageDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.imageDeclaration_return retval = new EugeneParser.imageDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token imageNameToken=null;
        Token imagePathToken=null;
        Token string_literal99=null;
        Token char_literal100=null;
        Token char_literal101=null;
        Token char_literal102=null;

        Object imageNameToken_tree=null;
        Object imagePathToken_tree=null;
        Object string_literal99_tree=null;
        Object char_literal100_tree=null;
        Object char_literal101_tree=null;
        Object char_literal102_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1053:2: ( 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1053:4: 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal99=(Token)match(input,49,FOLLOW_49_in_imageDeclaration1503); 
            string_literal99_tree = 
            (Object)adaptor.create(string_literal99)
            ;
            adaptor.addChild(root_0, string_literal99_tree);


            char_literal100=(Token)match(input,21,FOLLOW_21_in_imageDeclaration1505); 
            char_literal100_tree = 
            (Object)adaptor.create(char_literal100)
            ;
            adaptor.addChild(root_0, char_literal100_tree);


            imageNameToken=(Token)match(input,ID,FOLLOW_ID_in_imageDeclaration1509); 
            imageNameToken_tree = 
            (Object)adaptor.create(imageNameToken)
            ;
            adaptor.addChild(root_0, imageNameToken_tree);


            char_literal101=(Token)match(input,25,FOLLOW_25_in_imageDeclaration1511); 
            char_literal101_tree = 
            (Object)adaptor.create(char_literal101)
            ;
            adaptor.addChild(root_0, char_literal101_tree);


            imagePathToken=(Token)match(input,STRING,FOLLOW_STRING_in_imageDeclaration1515); 
            imagePathToken_tree = 
            (Object)adaptor.create(imagePathToken)
            ;
            adaptor.addChild(root_0, imagePathToken_tree);


            char_literal102=(Token)match(input,22,FOLLOW_22_in_imageDeclaration1517); 
            char_literal102_tree = 
            (Object)adaptor.create(char_literal102)
            ;
            adaptor.addChild(root_0, char_literal102_tree);



            if(!defer) {
                System.out.println("TODO: IMAGE!");
                System.out.flush();
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "imageDeclaration"


    public static class assertStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assertStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1066:1: assertStatement[boolean defer] : assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' ;
    public final EugeneParser.assertStatement_return assertStatement(boolean defer) throws RecognitionException {
        EugeneParser.assertStatement_return retval = new EugeneParser.assertStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token assertToken=null;
        Token char_literal103=null;
        Token string_literal104=null;
        Token char_literal105=null;
        Token char_literal106=null;
        EugeneParser.expression_return deviceToken =null;

        EugeneParser.listOfIDs_return lstRules =null;


        Object assertToken_tree=null;
        Object char_literal103_tree=null;
        Object string_literal104_tree=null;
        Object char_literal105_tree=null;
        Object char_literal106_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1067:2: (assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1067:4: assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            assertToken=(Token)match(input,39,FOLLOW_39_in_assertStatement1538); 
            assertToken_tree = 
            (Object)adaptor.create(assertToken)
            ;
            adaptor.addChild(root_0, assertToken_tree);


            char_literal103=(Token)match(input,21,FOLLOW_21_in_assertStatement1540); 
            char_literal103_tree = 
            (Object)adaptor.create(char_literal103)
            ;
            adaptor.addChild(root_0, char_literal103_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1067:29: ( 'ON' deviceToken= expression[defer] ':' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==56) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1067:30: 'ON' deviceToken= expression[defer] ':'
                    {
                    string_literal104=(Token)match(input,56,FOLLOW_56_in_assertStatement1543); 
                    string_literal104_tree = 
                    (Object)adaptor.create(string_literal104)
                    ;
                    adaptor.addChild(root_0, string_literal104_tree);


                    pushFollow(FOLLOW_expression_in_assertStatement1547);
                    deviceToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    char_literal105=(Token)match(input,29,FOLLOW_29_in_assertStatement1550); 
                    char_literal105_tree = 
                    (Object)adaptor.create(char_literal105)
                    ;
                    adaptor.addChild(root_0, char_literal105_tree);


                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1067:79: (lstRules= listOfIDs[defer] )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1067:79: lstRules= listOfIDs[defer]
                    {
                    pushFollow(FOLLOW_listOfIDs_in_assertStatement1556);
                    lstRules=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstRules.getTree());

                    }
                    break;

            }


            char_literal106=(Token)match(input,22,FOLLOW_22_in_assertStatement1560); 
            char_literal106_tree = 
            (Object)adaptor.create(char_literal106)
            ;
            adaptor.addChild(root_0, char_literal106_tree);



            if(!defer) {
                interp.evaluateRules(
                    (deviceToken!=null?deviceToken.objElement:null), 
                    (lstRules!=null?lstRules.lstElements:null), 
                    true);
            }	
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+(assertToken!=null?assertToken.getLine():0)+":"+(assertToken!=null?assertToken.getCharPositionInLine():0)+" => "+
                e.getMessage());
            this.cleanUp(1);	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assertStatement"


    public static class noteStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "noteStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1088:1: noteStatement[boolean defer] : noteToken= 'Note' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' ;
    public final EugeneParser.noteStatement_return noteStatement(boolean defer) throws RecognitionException {
        EugeneParser.noteStatement_return retval = new EugeneParser.noteStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token noteToken=null;
        Token char_literal107=null;
        Token string_literal108=null;
        Token char_literal109=null;
        Token char_literal110=null;
        EugeneParser.expression_return deviceToken =null;

        EugeneParser.listOfIDs_return lstRules =null;


        Object noteToken_tree=null;
        Object char_literal107_tree=null;
        Object string_literal108_tree=null;
        Object char_literal109_tree=null;
        Object char_literal110_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1089:2: (noteToken= 'Note' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1089:4: noteToken= 'Note' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            noteToken=(Token)match(input,55,FOLLOW_55_in_noteStatement1593); 
            noteToken_tree = 
            (Object)adaptor.create(noteToken)
            ;
            adaptor.addChild(root_0, noteToken_tree);


            char_literal107=(Token)match(input,21,FOLLOW_21_in_noteStatement1595); 
            char_literal107_tree = 
            (Object)adaptor.create(char_literal107)
            ;
            adaptor.addChild(root_0, char_literal107_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1089:25: ( 'ON' deviceToken= expression[defer] ':' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==56) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1089:26: 'ON' deviceToken= expression[defer] ':'
                    {
                    string_literal108=(Token)match(input,56,FOLLOW_56_in_noteStatement1598); 
                    string_literal108_tree = 
                    (Object)adaptor.create(string_literal108)
                    ;
                    adaptor.addChild(root_0, string_literal108_tree);


                    pushFollow(FOLLOW_expression_in_noteStatement1602);
                    deviceToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    char_literal109=(Token)match(input,29,FOLLOW_29_in_noteStatement1605); 
                    char_literal109_tree = 
                    (Object)adaptor.create(char_literal109)
                    ;
                    adaptor.addChild(root_0, char_literal109_tree);


                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1089:75: (lstRules= listOfIDs[defer] )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1089:75: lstRules= listOfIDs[defer]
                    {
                    pushFollow(FOLLOW_listOfIDs_in_noteStatement1611);
                    lstRules=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstRules.getTree());

                    }
                    break;

            }


            char_literal110=(Token)match(input,22,FOLLOW_22_in_noteStatement1615); 
            char_literal110_tree = 
            (Object)adaptor.create(char_literal110)
            ;
            adaptor.addChild(root_0, char_literal110_tree);


            	
            if(!defer) {    
                interp.evaluateRules(
                    (deviceToken!=null?deviceToken.objElement:null), 
                    (lstRules!=null?lstRules.lstElements:null), 
                    false);
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+(noteToken!=null?noteToken.getLine():0)+":"+(noteToken!=null?noteToken.getCharPositionInLine():0)+" => "+
                e.getMessage());
            this.cleanUp(1);	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "noteStatement"


    public static class instantiationStatement_return extends ParserRuleReturnScope {
        public Component objComponent;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instantiationStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1115:1: instantiationStatement[boolean defer] returns [Component objComponent] : typeToken= ID instanceToken= instanceDefinitionStatement[defer, objElement] ;
    public final EugeneParser.instantiationStatement_return instantiationStatement(boolean defer) throws RecognitionException {
        EugeneParser.instantiationStatement_return retval = new EugeneParser.instantiationStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token typeToken=null;
        EugeneParser.instanceDefinitionStatement_return instanceToken =null;


        Object typeToken_tree=null;


        NamedElement objElement = null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1119:2: (typeToken= ID instanceToken= instanceDefinitionStatement[defer, objElement] )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1119:4: typeToken= ID instanceToken= instanceDefinitionStatement[defer, objElement]
            {
            root_0 = (Object)adaptor.nil();


            typeToken=(Token)match(input,ID,FOLLOW_ID_in_instantiationStatement1654); 
            typeToken_tree = 
            (Object)adaptor.create(typeToken)
            ;
            adaptor.addChild(root_0, typeToken_tree);



            objElement = interp.get((typeToken!=null?typeToken.getText():null));
            if(!defer) {
                if(null==objElement) {
                    System.err.println("line "+(typeToken!=null?typeToken.getLine():0)+":"+(typeToken!=null?typeToken.getCharPositionInLine():0)+
                        " => I don't know anything about "+(typeToken!=null?typeToken.getText():null)+"!");
                    this.cleanUp(1);
                }                  
                if(!(objElement instanceof Device) && !(objElement instanceof PartType)) {
                    System.err.println("line "+(typeToken!=null?typeToken.getLine():0)+":"+(typeToken!=null?typeToken.getCharPositionInLine():0)+
                        " => The "+(typeToken!=null?typeToken.getText():null)+" element is neither a Device nor a Part Type!");
                    this.cleanUp(1);
                }                  
                if(objElement instanceof Device && !((Device)objElement).isAbstract()) {
                    System.err.println("line "+(typeToken!=null?typeToken.getLine():0)+":"+(typeToken!=null?typeToken.getCharPositionInLine():0)+
                        " => The "+(typeToken!=null?typeToken.getText():null)+" Device is not an abstract Device!");
                    this.cleanUp(1);
                }
            }	
            	

            pushFollow(FOLLOW_instanceDefinitionStatement_in_instantiationStatement1662);
            instanceToken=instanceDefinitionStatement(defer, objElement);

            state._fsp--;

            adaptor.addChild(root_0, instanceToken.getTree());


            if(!defer) {
                retval.objComponent = (instanceToken!=null?instanceToken.objComponent:null);
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instantiationStatement"


    public static class instanceDefinitionStatement_return extends ParserRuleReturnScope {
        public Component objComponent;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instanceDefinitionStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1146:1: instanceDefinitionStatement[boolean defer, NamedElement objElement] returns [Component objComponent] : (partToken= partInstantiation[defer, objElement] |deviceToken= deviceInstantiation[defer, objElement] );
    public final EugeneParser.instanceDefinitionStatement_return instanceDefinitionStatement(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.instanceDefinitionStatement_return retval = new EugeneParser.instanceDefinitionStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.partInstantiation_return partToken =null;

        EugeneParser.deviceInstantiation_return deviceToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1148:2: (partToken= partInstantiation[defer, objElement] |deviceToken= deviceInstantiation[defer, objElement] )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==ID) ) {
                int LA32_1 = input.LA(2);

                if ( ((objElement instanceof PartType)) ) {
                    alt32=1;
                }
                else if ( (true) ) {
                    alt32=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA32_0==DYNAMIC_NAME) ) {
                alt32=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }
            switch (alt32) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1148:4: partToken= partInstantiation[defer, objElement]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partInstantiation_in_instanceDefinitionStatement1686);
                    partToken=partInstantiation(defer, objElement);

                    state._fsp--;

                    adaptor.addChild(root_0, partToken.getTree());


                    if(!defer) {
                        retval.objComponent = (partToken!=null?partToken.objPart:null);
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1153:11: deviceToken= deviceInstantiation[defer, objElement]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceInstantiation_in_instanceDefinitionStatement1703);
                    deviceToken=deviceInstantiation(defer, objElement);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());


                    if(!defer) {
                        retval.objComponent = (deviceToken!=null?deviceToken.objDeviceInstance:null);
                    }	
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instanceDefinitionStatement"


    public static class dynamicNaming_return extends ParserRuleReturnScope {
        public String sName;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dynamicNaming"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1160:1: dynamicNaming[boolean defer] returns [String sName] : (nameToken= ID | DYNAMIC_NAME exprToken= expression[defer] DYNAMIC_NAME );
    public final EugeneParser.dynamicNaming_return dynamicNaming(boolean defer) throws RecognitionException {
        EugeneParser.dynamicNaming_return retval = new EugeneParser.dynamicNaming_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token DYNAMIC_NAME111=null;
        Token DYNAMIC_NAME112=null;
        EugeneParser.expression_return exprToken =null;


        Object nameToken_tree=null;
        Object DYNAMIC_NAME111_tree=null;
        Object DYNAMIC_NAME112_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1162:2: (nameToken= ID | DYNAMIC_NAME exprToken= expression[defer] DYNAMIC_NAME )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==ID) ) {
                alt33=1;
            }
            else if ( (LA33_0==DYNAMIC_NAME) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1162:4: nameToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_dynamicNaming1727); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);



                    if(!defer) {
                        retval.sName = (nameToken!=null?nameToken.getText():null);
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1167:4: DYNAMIC_NAME exprToken= expression[defer] DYNAMIC_NAME
                    {
                    root_0 = (Object)adaptor.nil();


                    DYNAMIC_NAME111=(Token)match(input,DYNAMIC_NAME,FOLLOW_DYNAMIC_NAME_in_dynamicNaming1734); 
                    DYNAMIC_NAME111_tree = 
                    (Object)adaptor.create(DYNAMIC_NAME111)
                    ;
                    adaptor.addChild(root_0, DYNAMIC_NAME111_tree);


                    pushFollow(FOLLOW_expression_in_dynamicNaming1738);
                    exprToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken.getTree());

                    DYNAMIC_NAME112=(Token)match(input,DYNAMIC_NAME,FOLLOW_DYNAMIC_NAME_in_dynamicNaming1741); 
                    DYNAMIC_NAME112_tree = 
                    (Object)adaptor.create(DYNAMIC_NAME112)
                    ;
                    adaptor.addChild(root_0, DYNAMIC_NAME112_tree);



                    if(!defer) {
                        NamedElement objElement = (exprToken!=null?exprToken.objElement:null);

                        if(null != objElement && 
                            objElement instanceof Variable && 
                            EugeneConstants.TXT.equals(((Variable)objElement).getType())) {
                            
                            retval.sName = ((Variable)objElement).getValue();
                            
                        } else {
                            System.err.println("line "+exprToken.start.getLine()+":"+exprToken.start.getCharPositionInLine()+" => "+
                                "Invalid Name!");
                            this.cleanUp(1);
                        }
                    }	
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dynamicNaming"


    public static class partInstantiation_return extends ParserRuleReturnScope {
        public Part objPart;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partInstantiation"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1186:1: partInstantiation[boolean defer, NamedElement objElement] returns [Part objPart] :{...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] ) ;
    public final EugeneParser.partInstantiation_return partInstantiation(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.partInstantiation_return retval = new EugeneParser.partInstantiation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal113=null;
        Token char_literal114=null;
        EugeneParser.dynamicNaming_return nameToken =null;

        EugeneParser.listOfDotValues_return dotToken =null;

        EugeneParser.listOfValues_return valueToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object char_literal113_tree=null;
        Object char_literal114_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1188:2: ({...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] ) )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1188:4: {...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] )
            {
            root_0 = (Object)adaptor.nil();


            if ( !((objElement instanceof PartType)) ) {
                throw new FailedPredicateException(input, "partInstantiation", "objElement instanceof PartType");
            }

            pushFollow(FOLLOW_dynamicNaming_in_partInstantiation1771);
            nameToken=dynamicNaming(defer);

            state._fsp--;

            adaptor.addChild(root_0, nameToken.getTree());

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1189:34: ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0 >= 21 && LA36_0 <= 22)||LA36_0==25||LA36_0==30) ) {
                alt36=1;
            }
            else if ( (LA36_0==MINUS||LA36_0==24||LA36_0==33) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1189:35: ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )?
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1189:35: ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==21) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1189:36: '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')'
                            {
                            char_literal113=(Token)match(input,21,FOLLOW_21_in_partInstantiation1776); 
                            char_literal113_tree = 
                            (Object)adaptor.create(char_literal113)
                            ;
                            adaptor.addChild(root_0, char_literal113_tree);


                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1189:40: (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )?
                            int alt34=3;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==26) ) {
                                alt34=1;
                            }
                            else if ( (LA34_0==FLOAT||LA34_0==ID||(LA34_0 >= INT && LA34_0 <= MINUS)||LA34_0==STRING||LA34_0==19||LA34_0==21||(LA34_0 >= 31 && LA34_0 <= 32)||(LA34_0 >= 34 && LA34_0 <= 37)||(LA34_0 >= 40 && LA34_0 <= 41)||(LA34_0 >= 45 && LA34_0 <= 46)||(LA34_0 >= 50 && LA34_0 <= 54)||(LA34_0 >= 63 && LA34_0 <= 65)||LA34_0==67||LA34_0==74||LA34_0==94) ) {
                                alt34=2;
                            }
                            switch (alt34) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1189:41: dotToken= listOfDotValues[defer]
                                    {
                                    pushFollow(FOLLOW_listOfDotValues_in_partInstantiation1781);
                                    dotToken=listOfDotValues(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, dotToken.getTree());

                                    }
                                    break;
                                case 2 :
                                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1189:75: valueToken= listOfValues[defer]
                                    {
                                    pushFollow(FOLLOW_listOfValues_in_partInstantiation1788);
                                    valueToken=listOfValues(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, valueToken.getTree());

                                    }
                                    break;

                            }


                            char_literal114=(Token)match(input,22,FOLLOW_22_in_partInstantiation1793); 
                            char_literal114_tree = 
                            (Object)adaptor.create(char_literal114)
                            ;
                            adaptor.addChild(root_0, char_literal114_tree);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1190:6: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_partInstantiation1805);
                    assignToken=assignment(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assignToken.getTree());

                    }
                    break;

            }



            if(!defer) {
                if(null!=dotToken) {
                    interp.createPart(
                        (PartType)objElement, 
                        (nameToken!=null?nameToken.sName:null), 
                        (dotToken!=null?dotToken.lstValues:null));
                } else if(null!=valueToken) {
                    interp.createPart(
                        (PartType)objElement, 
                        (nameToken!=null?nameToken.sName:null), 
                        (valueToken!=null?valueToken.lstValues:null));
                } else {
                    interp.createPart(
                        (PartType)objElement,
                        (nameToken!=null?nameToken.sName:null),
                        null);
                }
                
                if(null!=assignToken) {
                    interp.assign(
                        (nameToken!=null?nameToken.sName:null), 
                        (assignToken!=null?assignToken.objElement:null));
                }
            }	        
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception exc) {

            System.err.println("line "+nameToken.start.getLine()+":"+nameToken.start.getCharPositionInLine()+" => "+
                "Invalid Part declaration!");
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partInstantiation"


    public static class deviceInstantiation_return extends ParserRuleReturnScope {
        public DeviceInstance objDeviceInstance;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "deviceInstantiation"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1224:1: deviceInstantiation[boolean defer, NamedElement objElement] returns [DeviceInstance objDeviceInstance] : instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? ;
    public final EugeneParser.deviceInstantiation_return deviceInstantiation(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.deviceInstantiation_return retval = new EugeneParser.deviceInstantiation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token instToken=null;
        Token char_literal115=null;
        Token char_literal116=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object instToken_tree=null;
        Object char_literal115_tree=null;
        Object char_literal116_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1225:2: (instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1225:4: instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )?
            {
            root_0 = (Object)adaptor.nil();


            instToken=(Token)match(input,ID,FOLLOW_ID_in_deviceInstantiation1838); 
            instToken_tree = 
            (Object)adaptor.create(instToken)
            ;
            adaptor.addChild(root_0, instToken_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1225:17: ( '(' (lstToken= listOfIDs[defer] )? ')' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==21) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1225:18: '(' (lstToken= listOfIDs[defer] )? ')'
                    {
                    char_literal115=(Token)match(input,21,FOLLOW_21_in_deviceInstantiation1841); 
                    char_literal115_tree = 
                    (Object)adaptor.create(char_literal115)
                    ;
                    adaptor.addChild(root_0, char_literal115_tree);


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1225:22: (lstToken= listOfIDs[defer] )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==ID) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1225:23: lstToken= listOfIDs[defer]
                            {
                            pushFollow(FOLLOW_listOfIDs_in_deviceInstantiation1846);
                            lstToken=listOfIDs(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, lstToken.getTree());

                            }
                            break;

                    }


                    char_literal116=(Token)match(input,22,FOLLOW_22_in_deviceInstantiation1851); 
                    char_literal116_tree = 
                    (Object)adaptor.create(char_literal116)
                    ;
                    adaptor.addChild(root_0, char_literal116_tree);


                    }
                    break;

            }



            if(!defer) {	    
                
                if(null!=interp.get((instToken!=null?instToken.getText():null))) {
                    System.err.println("line "+(instToken!=null?instToken.getLine():0)+":"+(instToken!=null?instToken.getCharPositionInLine():0)+" => "+
                        (instToken!=null?instToken.getText():null)+" is declared already!");
                    this.cleanUp(1);
                }
                if(!((Device)objElement).isAbstract()) {
                    System.err.println("line "+(instToken!=null?instToken.getLine():0)+":"+(instToken!=null?instToken.getCharPositionInLine():0)+" => "+
                        "The "+objElement.getName()+" device is not abstract and hence cannot be instantiated!");
                    this.cleanUp(1);
                }    
                Device objAbstractDevice = (Device)objElement;
                
                ArrayList<Component> lstComponents = null;
                if(lstToken != null) {
                    // now, check if the list of IDs consists of just parts and/or devices that contain just parts
                    ArrayList<NamedElement> lstElements = (lstToken!=null?lstToken.lstElements:null);
                
                    if(objAbstractDevice.getComponents()==null || lstElements.size()>objAbstractDevice.getComponents().size()) {
                        System.err.println("line "+(instToken!=null?instToken.getLine():0)+":"+(instToken!=null?instToken.getCharPositionInLine():0)+" => "+
                            "The number of the "+(instToken!=null?instToken.getText():null)+" device's elements is greater than the number of the "+
                            objAbstractDevice.getName()+" abstract device's components!");
                        this.cleanUp(1);
                    }
                
                    lstComponents = new ArrayList<Component>();
                    for(int i=0; i<lstElements.size(); i++) {
                        NamedElement objAssignElement = lstElements.get(i);
                        if(!(objAssignElement instanceof Part)) {
                            System.err.println("line "+(instToken!=null?instToken.getLine():0)+":"+(instToken!=null?instToken.getCharPositionInLine():0)+" => "+
                                "The "+objAssignElement.getName()+" component is not a part, and hence, the "+(instToken!=null?instToken.getText():null)+
                                " device cannot instantiate the abstract "+objAbstractDevice.getName()+" device!");
                            this.cleanUp(1);
                        } 
                    
                        // now, let's check if the part is an instance of the abstract device's part type
                        Part objPart = (Part)objAssignElement;
                    
                        NamedElement objAbstractDeviceElement = objAbstractDevice.get(i);
                        if(objAbstractDeviceElement instanceof PartType && 
                          !objPart.getPartType().getName().equals(objAbstractDeviceElement.getName())) {
                            System.err.println("line "+(instToken!=null?instToken.getLine():0)+":"+(instToken!=null?instToken.getCharPositionInLine():0)+" => "+
                                "The "+objPart.getName()+" part at index "+i+" is not an instance of the "+objAbstractDeviceElement.getName()+" part type!");
                            this.cleanUp(1);
                        }
                    
                        lstComponents.add(objPart);
                    }
                }
                
                retval.objDeviceInstance = DeviceInstance.newInstance((instToken!=null?instToken.getText():null), objAbstractDevice);
                retval.objDeviceInstance.setComponents(lstComponents);
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(instToken!=null?instToken.getLine():0)+":"+(instToken!=null?instToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            this.cleanUp(1);    
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "deviceInstantiation"


    public static class listOfDotValues_return extends ParserRuleReturnScope {
        public List<PropertyValue> lstValues;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfDotValues"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1291:1: listOfDotValues[boolean defer] returns [List<PropertyValue> lstValues] : '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )? ;
    public final EugeneParser.listOfDotValues_return listOfDotValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfDotValues_return retval = new EugeneParser.listOfDotValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token char_literal117=null;
        Token char_literal118=null;
        Token char_literal119=null;
        Token char_literal120=null;
        EugeneParser.expression_return valueToken =null;

        EugeneParser.listOfDotValues_return dotValuesToken =null;


        Object nameToken_tree=null;
        Object char_literal117_tree=null;
        Object char_literal118_tree=null;
        Object char_literal119_tree=null;
        Object char_literal120_tree=null;


        retval.lstValues = new ArrayList<PropertyValue>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1296:2: ( '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1296:4: '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            char_literal117=(Token)match(input,26,FOLLOW_26_in_listOfDotValues1889); 
            char_literal117_tree = 
            (Object)adaptor.create(char_literal117)
            ;
            adaptor.addChild(root_0, char_literal117_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfDotValues1893); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            char_literal118=(Token)match(input,21,FOLLOW_21_in_listOfDotValues1895); 
            char_literal118_tree = 
            (Object)adaptor.create(char_literal118)
            ;
            adaptor.addChild(root_0, char_literal118_tree);


            pushFollow(FOLLOW_expression_in_listOfDotValues1899);
            valueToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, valueToken.getTree());

            char_literal119=(Token)match(input,22,FOLLOW_22_in_listOfDotValues1902); 
            char_literal119_tree = 
            (Object)adaptor.create(char_literal119)
            ;
            adaptor.addChild(root_0, char_literal119_tree);



            if(!defer) {
                retval.lstValues.add(
                    interp.createPropertyValue(
                            (nameToken!=null?nameToken.getText():null), (valueToken!=null?valueToken.objElement:null)));
            }
                    

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1302:12: ( ',' dotValuesToken= listOfDotValues[defer] )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==25) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1302:13: ',' dotValuesToken= listOfDotValues[defer]
                    {
                    char_literal120=(Token)match(input,25,FOLLOW_25_in_listOfDotValues1908); 
                    char_literal120_tree = 
                    (Object)adaptor.create(char_literal120)
                    ;
                    adaptor.addChild(root_0, char_literal120_tree);


                    pushFollow(FOLLOW_listOfDotValues_in_listOfDotValues1912);
                    dotValuesToken=listOfDotValues(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, dotValuesToken.getTree());


                    if(!defer) {
                        retval.lstValues.addAll((dotValuesToken!=null?dotValuesToken.lstValues:null));
                    }        
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getCharPositionInLine():0)+" => "+
                 e.getMessage());
            this.cleanUp(1);     
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfDotValues"


    public static class listOfValues_return extends ParserRuleReturnScope {
        public List<NamedElement> lstValues;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfValues"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1317:1: listOfValues[boolean defer] returns [List<NamedElement> lstValues] : exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )? ;
    public final EugeneParser.listOfValues_return listOfValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfValues_return retval = new EugeneParser.listOfValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal121=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfValues_return lstToken =null;


        Object char_literal121_tree=null;


        retval.lstValues = new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1322:2: (exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1322:4: exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfValues1953);
            exprToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {
                retval.lstValues.add((exprToken!=null?exprToken.objElement:null));
            }
                    

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1326:11: ( ',' lstToken= listOfValues[defer] )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==25) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1326:12: ',' lstToken= listOfValues[defer]
                    {
                    char_literal121=(Token)match(input,25,FOLLOW_25_in_listOfValues1959); 
                    char_literal121_tree = 
                    (Object)adaptor.create(char_literal121)
                    ;
                    adaptor.addChild(root_0, char_literal121_tree);


                    pushFollow(FOLLOW_listOfValues_in_listOfValues1963);
                    lstToken=listOfValues(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());


                    if(!defer) {
                        retval.lstValues.addAll((lstToken!=null?lstToken.lstValues:null));
                    }        
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfValues"


    public static class listOfExpressions_return extends ParserRuleReturnScope {
        public ArrayList<NamedElement> lstElements;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfExpressions"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1337:1: listOfExpressions[boolean defer] returns [ArrayList<NamedElement> lstElements] : exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )? ;
    public final EugeneParser.listOfExpressions_return listOfExpressions(boolean defer) throws RecognitionException {
        EugeneParser.listOfExpressions_return retval = new EugeneParser.listOfExpressions_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal122=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfExpressions_return lstToken =null;


        Object char_literal122_tree=null;


        retval.lstElements = new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1341:2: (exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1341:4: exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfExpressions1995);
            exprToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {
                retval.lstElements.add((exprToken!=null?exprToken.objElement:null));
            }	
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1345:5: ( ',' lstToken= listOfExpressions[defer] )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==25) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1345:6: ',' lstToken= listOfExpressions[defer]
                    {
                    char_literal122=(Token)match(input,25,FOLLOW_25_in_listOfExpressions2002); 
                    char_literal122_tree = 
                    (Object)adaptor.create(char_literal122)
                    ;
                    adaptor.addChild(root_0, char_literal122_tree);


                    pushFollow(FOLLOW_listOfExpressions_in_listOfExpressions2006);
                    lstToken=listOfExpressions(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());

                    }
                    break;

            }



            if(!defer) {
                if(lstToken!=null) {
                    retval.lstElements.addAll((lstToken!=null?lstToken.lstElements:null));
                }
            }		


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfExpressions"


    public static class expression_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1354:1: expression[boolean defer] returns [NamedElement objElement] : notToken= notExpression[defer] ;
    public final EugeneParser.expression_return expression(boolean defer) throws RecognitionException {
        EugeneParser.expression_return retval = new EugeneParser.expression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.notExpression_return notToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1356:6: (notToken= notExpression[defer] )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1356:11: notToken= notExpression[defer]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_notExpression_in_expression2040);
            notToken=notExpression(defer);

            state._fsp--;

            adaptor.addChild(root_0, notToken.getTree());


            if(!defer) {
                retval.objElement =(notToken!=null?notToken.objElement:null);    
            }    
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class notExpression_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "notExpression"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1363:1: notExpression[boolean defer] returns [NamedElement objElement] : (notToken= 'NOT' exprToken= orExpression[defer] -> ^( 'NOT' $exprToken) |exprToken= orExpression[defer] -> $exprToken);
    public final EugeneParser.notExpression_return notExpression(boolean defer) throws RecognitionException {
        EugeneParser.notExpression_return retval = new EugeneParser.notExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token notToken=null;
        EugeneParser.orExpression_return exprToken =null;


        Object notToken_tree=null;
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_orExpression=new RewriteRuleSubtreeStream(adaptor,"rule orExpression");

        boolean bNOT=false;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1368:2: (notToken= 'NOT' exprToken= orExpression[defer] -> ^( 'NOT' $exprToken) |exprToken= orExpression[defer] -> $exprToken)
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==53) ) {
                alt42=1;
            }
            else if ( (LA42_0==FLOAT||LA42_0==ID||(LA42_0 >= INT && LA42_0 <= MINUS)||LA42_0==STRING||LA42_0==19||LA42_0==21||(LA42_0 >= 31 && LA42_0 <= 32)||(LA42_0 >= 34 && LA42_0 <= 37)||(LA42_0 >= 40 && LA42_0 <= 41)||(LA42_0 >= 45 && LA42_0 <= 46)||(LA42_0 >= 50 && LA42_0 <= 52)||LA42_0==54||(LA42_0 >= 63 && LA42_0 <= 65)||LA42_0==67||LA42_0==74||LA42_0==94) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1368:4: notToken= 'NOT' exprToken= orExpression[defer]
                    {
                    notToken=(Token)match(input,53,FOLLOW_53_in_notExpression2077);  
                    stream_53.add(notToken);


                    pushFollow(FOLLOW_orExpression_in_notExpression2081);
                    exprToken=orExpression(defer);

                    state._fsp--;

                    stream_orExpression.add(exprToken.getTree());


                    if(!defer) {
                        retval.objElement = interp.not((exprToken!=null?exprToken.objElement:null));
                    }
                    	

                    // AST REWRITE
                    // elements: 53, exprToken
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1372:4: -> ^( 'NOT' $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1372:7: ^( 'NOT' $exprToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_53.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_exprToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1373:11: exprToken= orExpression[defer]
                    {
                    pushFollow(FOLLOW_orExpression_in_notExpression2107);
                    exprToken=orExpression(defer);

                    state._fsp--;

                    stream_orExpression.add(exprToken.getTree());


                    if(!defer) {
                        retval.objElement = (exprToken!=null?exprToken.objElement:null);
                    }        
                            

                    // AST REWRITE
                    // elements: exprToken
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1377:11: -> $exprToken
                    {
                        adaptor.addChild(root_0, stream_exprToken.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "notExpression"


    public static class orExpression_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "orExpression"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1380:1: orExpression[boolean defer] returns [NamedElement objElement] : (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )? ;
    public final EugeneParser.orExpression_return orExpression(boolean defer) throws RecognitionException {
        EugeneParser.orExpression_return retval = new EugeneParser.orExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal123=null;
        Token string_literal124=null;
        EugeneParser.andExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal123_tree=null;
        Object string_literal124_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleSubtreeStream stream_andExpression=new RewriteRuleSubtreeStream(adaptor,"rule andExpression");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1381:2: ( (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1381:4: (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1381:4: (leftToken= andExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1381:5: leftToken= andExpression[defer]
            {
            pushFollow(FOLLOW_andExpression_in_orExpression2135);
            leftToken=andExpression(defer);

            state._fsp--;

            stream_andExpression.add(leftToken.getTree());

            // AST REWRITE
            // elements: leftToken
            // token labels: 
            // rule labels: retval, leftToken
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1381:36: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1382:4: ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==57) ) {
                alt44=1;
            }
            else if ( (LA44_0==98) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1382:5: ( ( 'OR' | '||' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1382:5: ( ( 'OR' | '||' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1382:6: ( 'OR' | '||' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1382:6: ( 'OR' | '||' )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==57) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==98) ) {
                        alt43=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                        throw nvae;

                    }
                    switch (alt43) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1382:7: 'OR'
                            {
                            string_literal123=(Token)match(input,57,FOLLOW_57_in_orExpression2151);  
                            stream_57.add(string_literal123);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1382:12: '||'
                            {
                            string_literal124=(Token)match(input,98,FOLLOW_98_in_orExpression2153);  
                            stream_98.add(string_literal124);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_orExpression2158);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: leftToken, 57, rightToken
                    // token labels: 
                    // rule labels: retval, leftToken, rightToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);
                    RewriteRuleSubtreeStream stream_rightToken=new RewriteRuleSubtreeStream(adaptor,"rule rightToken",rightToken!=null?rightToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1383:4: -> ^( 'OR' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1383:7: ^( 'OR' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_57.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_leftToken.nextTree());

                        adaptor.addChild(root_1, stream_rightToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }



            if(!defer) {
                if(null==rightToken) {
                    retval.objElement =(leftToken!=null?leftToken.objElement:null);
                } else {
                    Variable objVariable = new Variable("OR",EugeneConstants.BOOLEAN);
                    objVariable.setBoolean(
                        interp.or((leftToken!=null?leftToken.objElement:null),(rightToken!=null?rightToken.objElement:null)));
                    retval.objElement = objVariable;
                }
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

                System.err.println(e.toString());
                this.cleanUp(1);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "orExpression"


    public static class andExpression_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "andExpression"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1401:1: andExpression[boolean defer] returns [NamedElement objElement] : (leftToken= xorExpression[defer] -> $leftToken) ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )? ;
    public final EugeneParser.andExpression_return andExpression(boolean defer) throws RecognitionException {
        EugeneParser.andExpression_return retval = new EugeneParser.andExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal125=null;
        Token string_literal126=null;
        EugeneParser.xorExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal125_tree=null;
        Object string_literal126_tree=null;
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        RewriteRuleSubtreeStream stream_xorExpression=new RewriteRuleSubtreeStream(adaptor,"rule xorExpression");
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1402:2: ( (leftToken= xorExpression[defer] -> $leftToken) ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1402:4: (leftToken= xorExpression[defer] -> $leftToken) ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1402:4: (leftToken= xorExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1402:5: leftToken= xorExpression[defer]
            {
            pushFollow(FOLLOW_xorExpression_in_andExpression2207);
            leftToken=xorExpression(defer);

            state._fsp--;

            stream_xorExpression.add(leftToken.getTree());

            // AST REWRITE
            // elements: leftToken
            // token labels: 
            // rule labels: retval, leftToken
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1402:36: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1403:4: ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==38) ) {
                alt46=1;
            }
            else if ( (LA46_0==20) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1403:5: ( ( 'AND' | '&&' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1403:5: ( ( 'AND' | '&&' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1403:6: ( 'AND' | '&&' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1403:6: ( 'AND' | '&&' )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==38) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==20) ) {
                        alt45=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;

                    }
                    switch (alt45) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1403:7: 'AND'
                            {
                            string_literal125=(Token)match(input,38,FOLLOW_38_in_andExpression2223);  
                            stream_38.add(string_literal125);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1403:13: '&&'
                            {
                            string_literal126=(Token)match(input,20,FOLLOW_20_in_andExpression2225);  
                            stream_20.add(string_literal126);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_andExpression2230);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: 38, rightToken, leftToken
                    // token labels: 
                    // rule labels: retval, leftToken, rightToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);
                    RewriteRuleSubtreeStream stream_rightToken=new RewriteRuleSubtreeStream(adaptor,"rule rightToken",rightToken!=null?rightToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1404:4: -> ^( 'AND' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1404:7: ^( 'AND' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_38.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_leftToken.nextTree());

                        adaptor.addChild(root_1, stream_rightToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }



            if(!defer) {
                if(null==rightToken) {
                    retval.objElement =(leftToken!=null?leftToken.objElement:null);
                } else {
                    Variable objVariable = new Variable("AND",EugeneConstants.BOOLEAN);
                    objVariable.setBoolean(
                        interp.and((leftToken!=null?leftToken.objElement:null),(rightToken!=null?rightToken.objElement:null)));
                    retval.objElement = objVariable;
                }
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

                System.err.println(e.toString());
                this.cleanUp(1);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "andExpression"


    public static class xorExpression_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "xorExpression"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1422:1: xorExpression[boolean defer] returns [NamedElement objElement] : (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )? ;
    public final EugeneParser.xorExpression_return xorExpression(boolean defer) throws RecognitionException {
        EugeneParser.xorExpression_return retval = new EugeneParser.xorExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal127=null;
        Token string_literal128=null;
        EugeneParser.comparativeExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal127_tree=null;
        Object string_literal128_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        RewriteRuleSubtreeStream stream_comparativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule comparativeExpression");
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1423:2: ( (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1423:4: (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1423:4: (leftToken= comparativeExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1423:5: leftToken= comparativeExpression[defer]
            {
            pushFollow(FOLLOW_comparativeExpression_in_xorExpression2280);
            leftToken=comparativeExpression(defer);

            state._fsp--;

            stream_comparativeExpression.add(leftToken.getTree());

            // AST REWRITE
            // elements: leftToken
            // token labels: 
            // rule labels: retval, leftToken
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1423:44: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1424:4: ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==66||LA48_0==69) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1424:5: ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1424:5: ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1424:6: ( 'XOR' | '^^' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1424:6: ( 'XOR' | '^^' )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==66) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==69) ) {
                        alt47=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;

                    }
                    switch (alt47) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1424:7: 'XOR'
                            {
                            string_literal127=(Token)match(input,66,FOLLOW_66_in_xorExpression2296);  
                            stream_66.add(string_literal127);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1424:13: '^^'
                            {
                            string_literal128=(Token)match(input,69,FOLLOW_69_in_xorExpression2298);  
                            stream_69.add(string_literal128);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_xorExpression2303);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: rightToken, leftToken, 66
                    // token labels: 
                    // rule labels: retval, leftToken, rightToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);
                    RewriteRuleSubtreeStream stream_rightToken=new RewriteRuleSubtreeStream(adaptor,"rule rightToken",rightToken!=null?rightToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1425:4: -> ^( 'XOR' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1425:7: ^( 'XOR' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_66.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_leftToken.nextTree());

                        adaptor.addChild(root_1, stream_rightToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }



            if(!defer) {
                if(null==rightToken) {
                    retval.objElement =(leftToken!=null?leftToken.objElement:null);
                } else {
                    Variable objVariable = new Variable("XOR",EugeneConstants.BOOLEAN);
                    objVariable.setBoolean(
                        interp.xor((leftToken!=null?leftToken.objElement:null),(rightToken!=null?rightToken.objElement:null)));
                    retval.objElement = objVariable;
                }
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

                System.err.println(e.toString());
                this.cleanUp(1);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "xorExpression"


    public static class operator_return extends ParserRuleReturnScope {
        public String sOperator;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "operator"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1443:1: operator returns [String sOperator] : (relToken= relationalOperator |ruleToken= ruleOperator );
    public final EugeneParser.operator_return operator() throws RecognitionException {
        EugeneParser.operator_return retval = new EugeneParser.operator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.relationalOperator_return relToken =null;

        EugeneParser.ruleOperator_return ruleToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1444:2: (relToken= relationalOperator |ruleToken= ruleOperator )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==19||(LA49_0 >= 31 && LA49_0 <= 32)||(LA49_0 >= 34 && LA49_0 <= 36)||LA49_0==46||LA49_0==54) ) {
                alt49=1;
            }
            else if ( (LA49_0==37||(LA49_0 >= 40 && LA49_0 <= 41)||LA49_0==45||(LA49_0 >= 50 && LA49_0 <= 52)||(LA49_0 >= 63 && LA49_0 <= 65)) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }
            switch (alt49) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1444:4: relToken= relationalOperator
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_relationalOperator_in_operator2349);
                    relToken=relationalOperator();

                    state._fsp--;

                    adaptor.addChild(root_0, relToken.getTree());


                    retval.sOperator = (relToken!=null?relToken.sOperator:null);
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1447:4: ruleToken= ruleOperator
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ruleOperator_in_operator2359);
                    ruleToken=ruleOperator();

                    state._fsp--;

                    adaptor.addChild(root_0, ruleToken.getTree());


                    retval.sOperator = (ruleToken!=null?ruleToken.sOperator:null);
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "operator"


    public static class ruleOperator_return extends ParserRuleReturnScope {
        public String sOperator;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ruleOperator"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1452:1: ruleOperator returns [String sOperator] : ( 'BEFORE' | 'AFTER' | 'STARTSWITH' | 'ENDSWITH' | 'WITH' | 'NEXTTO' | 'LEFTTO' | 'CONTAINS' | 'MORETHAN' | 'THEN' );
    public final EugeneParser.ruleOperator_return ruleOperator() throws RecognitionException {
        EugeneParser.ruleOperator_return retval = new EugeneParser.ruleOperator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal129=null;
        Token string_literal130=null;
        Token string_literal131=null;
        Token string_literal132=null;
        Token string_literal133=null;
        Token string_literal134=null;
        Token string_literal135=null;
        Token string_literal136=null;
        Token string_literal137=null;
        Token string_literal138=null;

        Object string_literal129_tree=null;
        Object string_literal130_tree=null;
        Object string_literal131_tree=null;
        Object string_literal132_tree=null;
        Object string_literal133_tree=null;
        Object string_literal134_tree=null;
        Object string_literal135_tree=null;
        Object string_literal136_tree=null;
        Object string_literal137_tree=null;
        Object string_literal138_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1453:2: ( 'BEFORE' | 'AFTER' | 'STARTSWITH' | 'ENDSWITH' | 'WITH' | 'NEXTTO' | 'LEFTTO' | 'CONTAINS' | 'MORETHAN' | 'THEN' )
            int alt50=10;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt50=1;
                }
                break;
            case 37:
                {
                alt50=2;
                }
                break;
            case 63:
                {
                alt50=3;
                }
                break;
            case 45:
                {
                alt50=4;
                }
                break;
            case 65:
                {
                alt50=5;
                }
                break;
            case 52:
                {
                alt50=6;
                }
                break;
            case 50:
                {
                alt50=7;
                }
                break;
            case 41:
                {
                alt50=8;
                }
                break;
            case 51:
                {
                alt50=9;
                }
                break;
            case 64:
                {
                alt50=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1453:4: 'BEFORE'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal129=(Token)match(input,40,FOLLOW_40_in_ruleOperator2378); 
                    string_literal129_tree = 
                    (Object)adaptor.create(string_literal129)
                    ;
                    adaptor.addChild(root_0, string_literal129_tree);



                    retval.sOperator = EugeneConstants.BEFORE;


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1456:4: 'AFTER'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal130=(Token)match(input,37,FOLLOW_37_in_ruleOperator2385); 
                    string_literal130_tree = 
                    (Object)adaptor.create(string_literal130)
                    ;
                    adaptor.addChild(root_0, string_literal130_tree);



                    retval.sOperator = EugeneConstants.AFTER;


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1459:4: 'STARTSWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal131=(Token)match(input,63,FOLLOW_63_in_ruleOperator2392); 
                    string_literal131_tree = 
                    (Object)adaptor.create(string_literal131)
                    ;
                    adaptor.addChild(root_0, string_literal131_tree);



                    retval.sOperator = EugeneConstants.STARTSWITH;


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1462:4: 'ENDSWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal132=(Token)match(input,45,FOLLOW_45_in_ruleOperator2399); 
                    string_literal132_tree = 
                    (Object)adaptor.create(string_literal132)
                    ;
                    adaptor.addChild(root_0, string_literal132_tree);



                    retval.sOperator = EugeneConstants.ENDSWITH;


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1465:4: 'WITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal133=(Token)match(input,65,FOLLOW_65_in_ruleOperator2406); 
                    string_literal133_tree = 
                    (Object)adaptor.create(string_literal133)
                    ;
                    adaptor.addChild(root_0, string_literal133_tree);



                    retval.sOperator = EugeneConstants.WITH;


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1468:4: 'NEXTTO'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal134=(Token)match(input,52,FOLLOW_52_in_ruleOperator2413); 
                    string_literal134_tree = 
                    (Object)adaptor.create(string_literal134)
                    ;
                    adaptor.addChild(root_0, string_literal134_tree);



                    retval.sOperator = EugeneConstants.NEXTTO;


                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1471:4: 'LEFTTO'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal135=(Token)match(input,50,FOLLOW_50_in_ruleOperator2420); 
                    string_literal135_tree = 
                    (Object)adaptor.create(string_literal135)
                    ;
                    adaptor.addChild(root_0, string_literal135_tree);



                    retval.sOperator = EugeneConstants.LEFTTO;


                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1474:4: 'CONTAINS'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal136=(Token)match(input,41,FOLLOW_41_in_ruleOperator2427); 
                    string_literal136_tree = 
                    (Object)adaptor.create(string_literal136)
                    ;
                    adaptor.addChild(root_0, string_literal136_tree);



                    retval.sOperator = EugeneConstants.CONTAINS;


                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1477:4: 'MORETHAN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal137=(Token)match(input,51,FOLLOW_51_in_ruleOperator2434); 
                    string_literal137_tree = 
                    (Object)adaptor.create(string_literal137)
                    ;
                    adaptor.addChild(root_0, string_literal137_tree);



                    retval.sOperator = EugeneConstants.MORETHAN;


                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1480:4: 'THEN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal138=(Token)match(input,64,FOLLOW_64_in_ruleOperator2441); 
                    string_literal138_tree = 
                    (Object)adaptor.create(string_literal138)
                    ;
                    adaptor.addChild(root_0, string_literal138_tree);



                    retval.sOperator = EugeneConstants.THEN;


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleOperator"


    public static class relationalOperator_return extends ParserRuleReturnScope {
        public String sOperator;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relationalOperator"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1485:1: relationalOperator returns [String sOperator] : ( ( '==' | 'EQUALS' ) | ( '!=' | 'NOTEQUALS' ) | '<' | '<=' | '>' | '>=' );
    public final EugeneParser.relationalOperator_return relationalOperator() throws RecognitionException {
        EugeneParser.relationalOperator_return retval = new EugeneParser.relationalOperator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set139=null;
        Token set140=null;
        Token char_literal141=null;
        Token string_literal142=null;
        Token char_literal143=null;
        Token string_literal144=null;

        Object set139_tree=null;
        Object set140_tree=null;
        Object char_literal141_tree=null;
        Object string_literal142_tree=null;
        Object char_literal143_tree=null;
        Object string_literal144_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1486:2: ( ( '==' | 'EQUALS' ) | ( '!=' | 'NOTEQUALS' ) | '<' | '<=' | '>' | '>=' )
            int alt51=6;
            switch ( input.LA(1) ) {
            case 34:
            case 46:
                {
                alt51=1;
                }
                break;
            case 19:
            case 54:
                {
                alt51=2;
                }
                break;
            case 31:
                {
                alt51=3;
                }
                break;
            case 32:
                {
                alt51=4;
                }
                break;
            case 35:
                {
                alt51=5;
                }
                break;
            case 36:
                {
                alt51=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1486:4: ( '==' | 'EQUALS' )
                    {
                    root_0 = (Object)adaptor.nil();


                    set139=(Token)input.LT(1);

                    if ( input.LA(1)==34||input.LA(1)==46 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set139)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }



                    retval.sOperator =EugeneConstants.EQUALS;	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1489:4: ( '!=' | 'NOTEQUALS' )
                    {
                    root_0 = (Object)adaptor.nil();


                    set140=(Token)input.LT(1);

                    if ( input.LA(1)==19||input.LA(1)==54 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set140)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }



                    retval.sOperator =EugeneConstants.NOTEQUALS;	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1492:4: '<'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal141=(Token)match(input,31,FOLLOW_31_in_relationalOperator2484); 
                    char_literal141_tree = 
                    (Object)adaptor.create(char_literal141)
                    ;
                    adaptor.addChild(root_0, char_literal141_tree);



                    retval.sOperator =EugeneConstants.LT;	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1495:4: '<='
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal142=(Token)match(input,32,FOLLOW_32_in_relationalOperator2492); 
                    string_literal142_tree = 
                    (Object)adaptor.create(string_literal142)
                    ;
                    adaptor.addChild(root_0, string_literal142_tree);



                    retval.sOperator =EugeneConstants.LEQ;	
                    	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1498:4: '>'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal143=(Token)match(input,35,FOLLOW_35_in_relationalOperator2499); 
                    char_literal143_tree = 
                    (Object)adaptor.create(char_literal143)
                    ;
                    adaptor.addChild(root_0, char_literal143_tree);



                    retval.sOperator =EugeneConstants.GT;	
                    	

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1501:4: '>='
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal144=(Token)match(input,36,FOLLOW_36_in_relationalOperator2507); 
                    string_literal144_tree = 
                    (Object)adaptor.create(string_literal144)
                    ;
                    adaptor.addChild(root_0, string_literal144_tree);



                    retval.sOperator =EugeneConstants.GEQ;	
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "relationalOperator"


    public static class comparativeExpression_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comparativeExpression"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1507:1: comparativeExpression[boolean defer] returns [NamedElement objElement] : ( (exprToken1= addExpression[defer] -> $exprToken1) (opToken= operator (exprToken2= comparativeExpression[defer] -> ^( $opToken $exprToken1 $exprToken2) ) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) );
    public final EugeneParser.comparativeExpression_return comparativeExpression(boolean defer) throws RecognitionException {
        EugeneParser.comparativeExpression_return retval = new EugeneParser.comparativeExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal145=null;
        Token string_literal146=null;
        EugeneParser.addExpression_return exprToken1 =null;

        EugeneParser.operator_return opToken =null;

        EugeneParser.comparativeExpression_return exprToken2 =null;

        EugeneParser.type_return typeToken =null;

        EugeneParser.addExpression_return exprToken =null;


        Object string_literal145_tree=null;
        Object string_literal146_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_addExpression=new RewriteRuleSubtreeStream(adaptor,"rule addExpression");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        RewriteRuleSubtreeStream stream_comparativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule comparativeExpression");
        RewriteRuleSubtreeStream stream_operator=new RewriteRuleSubtreeStream(adaptor,"rule operator");
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1509:2: ( (exprToken1= addExpression[defer] -> $exprToken1) (opToken= operator (exprToken2= comparativeExpression[defer] -> ^( $opToken $exprToken1 $exprToken2) ) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==FLOAT||LA54_0==ID||(LA54_0 >= INT && LA54_0 <= MINUS)||LA54_0==STRING||LA54_0==21||LA54_0==67||LA54_0==74||LA54_0==94) ) {
                alt54=1;
            }
            else if ( (LA54_0==19||(LA54_0 >= 31 && LA54_0 <= 32)||(LA54_0 >= 34 && LA54_0 <= 37)||(LA54_0 >= 40 && LA54_0 <= 41)||(LA54_0 >= 45 && LA54_0 <= 46)||(LA54_0 >= 50 && LA54_0 <= 52)||LA54_0==54||(LA54_0 >= 63 && LA54_0 <= 65)) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }
            switch (alt54) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1509:6: (exprToken1= addExpression[defer] -> $exprToken1) (opToken= operator (exprToken2= comparativeExpression[defer] -> ^( $opToken $exprToken1 $exprToken2) ) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type )?
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1509:6: (exprToken1= addExpression[defer] -> $exprToken1)
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1509:7: exprToken1= addExpression[defer]
                    {
                    pushFollow(FOLLOW_addExpression_in_comparativeExpression2533);
                    exprToken1=addExpression(defer);

                    state._fsp--;

                    stream_addExpression.add(exprToken1.getTree());


                    if(!defer) {
                        retval.objElement =(exprToken1!=null?exprToken1.objElement:null);
                    }	
                    	

                    // AST REWRITE
                    // elements: exprToken1
                    // token labels: 
                    // rule labels: exprToken1, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_exprToken1=new RewriteRuleSubtreeStream(adaptor,"rule exprToken1",exprToken1!=null?exprToken1.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1513:4: -> $exprToken1
                    {
                        adaptor.addChild(root_0, stream_exprToken1.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1514:3: (opToken= operator (exprToken2= comparativeExpression[defer] -> ^( $opToken $exprToken1 $exprToken2) ) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type )?
                    int alt53=3;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==19||(LA53_0 >= 31 && LA53_0 <= 32)||(LA53_0 >= 34 && LA53_0 <= 37)||(LA53_0 >= 40 && LA53_0 <= 41)||(LA53_0 >= 45 && LA53_0 <= 46)||(LA53_0 >= 50 && LA53_0 <= 52)||LA53_0==54||(LA53_0 >= 63 && LA53_0 <= 65)) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==48||LA53_0==81) ) {
                        alt53=2;
                    }
                    switch (alt53) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1514:4: opToken= operator (exprToken2= comparativeExpression[defer] -> ^( $opToken $exprToken1 $exprToken2) )
                            {
                            pushFollow(FOLLOW_operator_in_comparativeExpression2550);
                            opToken=operator();

                            state._fsp--;

                            stream_operator.add(opToken.getTree());

                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1514:21: (exprToken2= comparativeExpression[defer] -> ^( $opToken $exprToken1 $exprToken2) )
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1514:22: exprToken2= comparativeExpression[defer]
                            {
                            pushFollow(FOLLOW_comparativeExpression_in_comparativeExpression2555);
                            exprToken2=comparativeExpression(defer);

                            state._fsp--;

                            stream_comparativeExpression.add(exprToken2.getTree());


                            if(!defer) {
                                retval.objElement = interp.compare((exprToken1!=null?exprToken1.objElement:null), (opToken!=null?input.toString(opToken.start,opToken.stop):null), (exprToken2!=null?exprToken2.objElement:null));
                            }		
                            	

                            // AST REWRITE
                            // elements: opToken, exprToken2, exprToken1
                            // token labels: 
                            // rule labels: exprToken1, retval, exprToken2, opToken
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_exprToken1=new RewriteRuleSubtreeStream(adaptor,"rule exprToken1",exprToken1!=null?exprToken1.tree:null);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_exprToken2=new RewriteRuleSubtreeStream(adaptor,"rule exprToken2",exprToken2!=null?exprToken2.tree:null);
                            RewriteRuleSubtreeStream stream_opToken=new RewriteRuleSubtreeStream(adaptor,"rule opToken",opToken!=null?opToken.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 1518:4: -> ^( $opToken $exprToken1 $exprToken2)
                            {
                                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1518:7: ^( $opToken $exprToken1 $exprToken2)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot(stream_opToken.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_exprToken1.nextTree());

                                adaptor.addChild(root_1, stream_exprToken2.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1519:4: ( 'INSTANCEOF' | 'instanceof' ) typeToken= type
                            {
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1519:4: ( 'INSTANCEOF' | 'instanceof' )
                            int alt52=2;
                            int LA52_0 = input.LA(1);

                            if ( (LA52_0==48) ) {
                                alt52=1;
                            }
                            else if ( (LA52_0==81) ) {
                                alt52=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 52, 0, input);

                                throw nvae;

                            }
                            switch (alt52) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1519:5: 'INSTANCEOF'
                                    {
                                    string_literal145=(Token)match(input,48,FOLLOW_48_in_comparativeExpression2578);  
                                    stream_48.add(string_literal145);


                                    }
                                    break;
                                case 2 :
                                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1519:18: 'instanceof'
                                    {
                                    string_literal146=(Token)match(input,81,FOLLOW_81_in_comparativeExpression2580);  
                                    stream_81.add(string_literal146);


                                    }
                                    break;

                            }


                            pushFollow(FOLLOW_type_in_comparativeExpression2585);
                            typeToken=type();

                            state._fsp--;

                            stream_type.add(typeToken.getTree());


                            if(!defer) {
                                retval.objElement = EugeneBuilder.buildVariable(
                                    String.valueOf(interp.isInstanceOf((exprToken1!=null?exprToken1.objElement:null), (typeToken!=null?input.toString(typeToken.start,typeToken.stop):null))));
                            }	
                            	

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1525:4: opToken= operator exprToken= addExpression[defer]
                    {
                    pushFollow(FOLLOW_operator_in_comparativeExpression2601);
                    opToken=operator();

                    state._fsp--;

                    stream_operator.add(opToken.getTree());

                    pushFollow(FOLLOW_addExpression_in_comparativeExpression2605);
                    exprToken=addExpression(defer);

                    state._fsp--;

                    stream_addExpression.add(exprToken.getTree());

                    // AST REWRITE
                    // elements: opToken, exprToken
                    // token labels: 
                    // rule labels: retval, opToken, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_opToken=new RewriteRuleSubtreeStream(adaptor,"rule opToken",opToken!=null?opToken.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1526:4: -> ^( $opToken $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1526:7: ^( $opToken $exprToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_opToken.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_exprToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+" => "+
                    e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comparativeExpression"


    public static class addExpression_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "addExpression"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1534:1: addExpression[boolean defer] returns [NamedElement objElement] : (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )? ;
    public final EugeneParser.addExpression_return addExpression(boolean defer) throws RecognitionException {
        EugeneParser.addExpression_return retval = new EugeneParser.addExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token opToken=null;
        EugeneParser.subtractExpression_return leftToken =null;

        EugeneParser.addExpression_return rightToken =null;


        Object opToken_tree=null;
        RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");
        RewriteRuleSubtreeStream stream_addExpression=new RewriteRuleSubtreeStream(adaptor,"rule addExpression");
        RewriteRuleSubtreeStream stream_subtractExpression=new RewriteRuleSubtreeStream(adaptor,"rule subtractExpression");
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1536:2: ( (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1536:4: (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1536:4: (leftToken= subtractExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1536:5: leftToken= subtractExpression[defer]
            {
            pushFollow(FOLLOW_subtractExpression_in_addExpression2651);
            leftToken=subtractExpression(defer);

            state._fsp--;

            stream_subtractExpression.add(leftToken.getTree());

            // AST REWRITE
            // elements: leftToken
            // token labels: 
            // rule labels: retval, leftToken
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1536:42: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1537:4: (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==24) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1537:5: opToken= '+' rightToken= addExpression[defer]
                    {
                    opToken=(Token)match(input,24,FOLLOW_24_in_addExpression2667);  
                    stream_24.add(opToken);


                    pushFollow(FOLLOW_addExpression_in_addExpression2671);
                    rightToken=addExpression(defer);

                    state._fsp--;

                    stream_addExpression.add(rightToken.getTree());

                    // AST REWRITE
                    // elements: leftToken, 24, rightToken
                    // token labels: 
                    // rule labels: retval, leftToken, rightToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);
                    RewriteRuleSubtreeStream stream_rightToken=new RewriteRuleSubtreeStream(adaptor,"rule rightToken",rightToken!=null?rightToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1538:5: -> ^( '+' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1538:8: ^( '+' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_24.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_leftToken.nextTree());

                        adaptor.addChild(root_1, stream_rightToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }



            if(!defer) {
                if(null==rightToken) {
                    retval.objElement =(leftToken!=null?leftToken.objElement:null);
                } else {
                    retval.objElement = interp.add((leftToken!=null?leftToken.objElement:null), (rightToken!=null?rightToken.objElement:null));
                }
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+
                        " => "+e.toString());
            this.cleanUp(1);            
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "addExpression"


    public static class subtractExpression_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "subtractExpression"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1554:1: subtractExpression[boolean defer] returns [NamedElement objElement] : (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )? ;
    public final EugeneParser.subtractExpression_return subtractExpression(boolean defer) throws RecognitionException {
        EugeneParser.subtractExpression_return retval = new EugeneParser.subtractExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token opToken=null;
        EugeneParser.multiplicativeExpression_return leftToken =null;

        EugeneParser.subtractExpression_return rightToken =null;


        Object opToken_tree=null;
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_subtractExpression=new RewriteRuleSubtreeStream(adaptor,"rule subtractExpression");
        RewriteRuleSubtreeStream stream_multiplicativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule multiplicativeExpression");
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1555:2: ( (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1555:4: (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1555:4: (leftToken= multiplicativeExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1555:5: leftToken= multiplicativeExpression[defer]
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_subtractExpression2717);
            leftToken=multiplicativeExpression(defer);

            state._fsp--;

            stream_multiplicativeExpression.add(leftToken.getTree());

            // AST REWRITE
            // elements: leftToken
            // token labels: 
            // rule labels: retval, leftToken
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1555:47: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1556:4: (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==MINUS) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1556:5: opToken= '-' rightToken= subtractExpression[defer]
                    {
                    opToken=(Token)match(input,MINUS,FOLLOW_MINUS_in_subtractExpression2732);  
                    stream_MINUS.add(opToken);


                    pushFollow(FOLLOW_subtractExpression_in_subtractExpression2736);
                    rightToken=subtractExpression(defer);

                    state._fsp--;

                    stream_subtractExpression.add(rightToken.getTree());

                    // AST REWRITE
                    // elements: rightToken, leftToken, MINUS
                    // token labels: 
                    // rule labels: retval, leftToken, rightToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);
                    RewriteRuleSubtreeStream stream_rightToken=new RewriteRuleSubtreeStream(adaptor,"rule rightToken",rightToken!=null?rightToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1557:4: -> ^( '-' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1557:7: ^( '-' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_MINUS.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_leftToken.nextTree());

                        adaptor.addChild(root_1, stream_rightToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }



            if(!defer) {
                if(null==rightToken) {
                    retval.objElement =(leftToken!=null?leftToken.objElement:null);
                } else {
                    retval.objElement =interp.subtract((leftToken!=null?leftToken.objElement:null),(rightToken!=null?rightToken.objElement:null));

                    if(retval.objElement==null) {
                        System.err.println("line "+(opToken!=null?opToken.getLine():0)+":"+(opToken!=null?opToken.getCharPositionInLine():0)+" => "+
                            "I cannot apply the - operator!");
                        this.cleanUp(1);
                    }
                }
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "subtractExpression"


    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "multiplicativeExpression"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1575:1: multiplicativeExpression[boolean defer] returns [NamedElement objElement] : (leftToken= expressionValue[defer] -> $leftToken) (opToken= ( '*' | '/' ) rightToken= addExpression[defer] -> ^( $opToken $leftToken $rightToken) )? ;
    public final EugeneParser.multiplicativeExpression_return multiplicativeExpression(boolean defer) throws RecognitionException {
        EugeneParser.multiplicativeExpression_return retval = new EugeneParser.multiplicativeExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token opToken=null;
        Token char_literal147=null;
        Token char_literal148=null;
        EugeneParser.expressionValue_return leftToken =null;

        EugeneParser.addExpression_return rightToken =null;


        Object opToken_tree=null;
        Object char_literal147_tree=null;
        Object char_literal148_tree=null;
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleTokenStream stream_28=new RewriteRuleTokenStream(adaptor,"token 28");
        RewriteRuleSubtreeStream stream_expressionValue=new RewriteRuleSubtreeStream(adaptor,"rule expressionValue");
        RewriteRuleSubtreeStream stream_addExpression=new RewriteRuleSubtreeStream(adaptor,"rule addExpression");
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1576:6: ( (leftToken= expressionValue[defer] -> $leftToken) (opToken= ( '*' | '/' ) rightToken= addExpression[defer] -> ^( $opToken $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1576:11: (leftToken= expressionValue[defer] -> $leftToken) (opToken= ( '*' | '/' ) rightToken= addExpression[defer] -> ^( $opToken $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1576:11: (leftToken= expressionValue[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1576:12: leftToken= expressionValue[defer]
            {
            pushFollow(FOLLOW_expressionValue_in_multiplicativeExpression2785);
            leftToken=expressionValue(defer);

            state._fsp--;

            stream_expressionValue.add(leftToken.getTree());

            // AST REWRITE
            // elements: leftToken
            // token labels: 
            // rule labels: retval, leftToken
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1576:45: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1577:8: (opToken= ( '*' | '/' ) rightToken= addExpression[defer] -> ^( $opToken $leftToken $rightToken) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==23||LA58_0==28) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1577:9: opToken= ( '*' | '/' ) rightToken= addExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1577:17: ( '*' | '/' )
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==23) ) {
                        alt57=1;
                    }
                    else if ( (LA57_0==28) ) {
                        alt57=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 57, 0, input);

                        throw nvae;

                    }
                    switch (alt57) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1577:18: '*'
                            {
                            char_literal147=(Token)match(input,23,FOLLOW_23_in_multiplicativeExpression2805);  
                            stream_23.add(char_literal147);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1577:22: '/'
                            {
                            char_literal148=(Token)match(input,28,FOLLOW_28_in_multiplicativeExpression2807);  
                            stream_28.add(char_literal148);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_addExpression_in_multiplicativeExpression2812);
                    rightToken=addExpression(defer);

                    state._fsp--;

                    stream_addExpression.add(rightToken.getTree());

                    // AST REWRITE
                    // elements: opToken, rightToken, leftToken
                    // token labels: opToken
                    // rule labels: retval, leftToken, rightToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_opToken=new RewriteRuleTokenStream(adaptor,"token opToken",opToken);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_leftToken=new RewriteRuleSubtreeStream(adaptor,"rule leftToken",leftToken!=null?leftToken.tree:null);
                    RewriteRuleSubtreeStream stream_rightToken=new RewriteRuleSubtreeStream(adaptor,"rule rightToken",rightToken!=null?rightToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1578:9: -> ^( $opToken $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1578:12: ^( $opToken $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_opToken.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_leftToken.nextTree());

                        adaptor.addChild(root_1, stream_rightToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }



            if(!defer){
                if(null==rightToken) {
                    retval.objElement =(leftToken!=null?leftToken.objElement:null);
                } else {
                    if(EugeneConstants.MULTIPLY.equals((opToken!=null?opToken.getText():null))) {
                        retval.objElement =interp.multiply((leftToken!=null?leftToken.objElement:null),(rightToken!=null?rightToken.objElement:null));
                    } else if(EugeneConstants.DIVIDE.equals((opToken!=null?opToken.getText():null))) {
                        retval.objElement =interp.divide((leftToken!=null?leftToken.objElement:null),(rightToken!=null?rightToken.objElement:null));
            	}
            	
                    if(null==retval.objElement) {
                        System.err.println("line "+(opToken!=null?opToken.getLine():0)+":"+(opToken!=null?opToken.getCharPositionInLine():0)+" => "+
                            "I cannot apply the "+(opToken!=null?opToken.getText():null)+" operator!");
                        this.cleanUp(1);
                    }
                }
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "multiplicativeExpression"


    public static class expressionValue_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressionValue"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1602:1: expressionValue[boolean defer] returns [NamedElement objElement] : ( (minToken= MINUS )? numToken= ( INT | FLOAT ) |txtToken= STRING |boolToken= ( 'true' | 'false' ) | (accessToken= objectAccessStatement[defer] -> $accessToken) | '(' exprToken= expression[defer] ')' -> ^( '(' $exprToken) | '[' lstToken= listOfExpressions[defer] ']' -> ^( '[' $lstToken) );
    public final EugeneParser.expressionValue_return expressionValue(boolean defer) throws RecognitionException {
        EugeneParser.expressionValue_return retval = new EugeneParser.expressionValue_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token minToken=null;
        Token numToken=null;
        Token txtToken=null;
        Token boolToken=null;
        Token char_literal149=null;
        Token char_literal150=null;
        Token char_literal151=null;
        Token char_literal152=null;
        EugeneParser.objectAccessStatement_return accessToken =null;

        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfExpressions_return lstToken =null;


        Object minToken_tree=null;
        Object numToken_tree=null;
        Object txtToken_tree=null;
        Object boolToken_tree=null;
        Object char_literal149_tree=null;
        Object char_literal150_tree=null;
        Object char_literal151_tree=null;
        Object char_literal152_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_objectAccessStatement=new RewriteRuleSubtreeStream(adaptor,"rule objectAccessStatement");
        RewriteRuleSubtreeStream stream_listOfExpressions=new RewriteRuleSubtreeStream(adaptor,"rule listOfExpressions");
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1603:2: ( (minToken= MINUS )? numToken= ( INT | FLOAT ) |txtToken= STRING |boolToken= ( 'true' | 'false' ) | (accessToken= objectAccessStatement[defer] -> $accessToken) | '(' exprToken= expression[defer] ')' -> ^( '(' $exprToken) | '[' lstToken= listOfExpressions[defer] ']' -> ^( '[' $lstToken) )
            int alt60=6;
            switch ( input.LA(1) ) {
            case FLOAT:
            case INT:
            case MINUS:
                {
                alt60=1;
                }
                break;
            case STRING:
                {
                alt60=2;
                }
                break;
            case 74:
            case 94:
                {
                alt60=3;
                }
                break;
            case ID:
                {
                alt60=4;
                }
                break;
            case 21:
                {
                alt60=5;
                }
                break;
            case 67:
                {
                alt60=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }

            switch (alt60) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1603:4: (minToken= MINUS )? numToken= ( INT | FLOAT )
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1603:4: (minToken= MINUS )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==MINUS) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1603:5: minToken= MINUS
                            {
                            minToken=(Token)match(input,MINUS,FOLLOW_MINUS_in_expressionValue2860); 
                            minToken_tree = 
                            (Object)adaptor.create(minToken)
                            ;
                            adaptor.addChild(root_0, minToken_tree);


                            }
                            break;

                    }


                    numToken=(Token)input.LT(1);

                    if ( input.LA(1)==FLOAT||input.LA(1)==INT ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(numToken)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }



                    if(!defer) {
                        Variable objValue=new Variable(EugeneConstants.NUM,EugeneConstants.NUM);
                        objValue.setNum(new Double((numToken!=null?numToken.getText():null)).doubleValue());
                        if(minToken!=null) {
                            objValue.setNum(objValue.getNum() * (-1));
                        }
                        retval.objElement =objValue;
                    }
                            

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1613:4: txtToken= STRING
                    {
                    root_0 = (Object)adaptor.nil();


                    txtToken=(Token)match(input,STRING,FOLLOW_STRING_in_expressionValue2880); 
                    txtToken_tree = 
                    (Object)adaptor.create(txtToken)
                    ;
                    adaptor.addChild(root_0, txtToken_tree);



                    if(!defer) {
                        Variable objValue=new Variable(EugeneConstants.TXT,EugeneConstants.TXT);
                        objValue.setTxt((txtToken!=null?txtToken.getText():null));
                        retval.objElement =objValue;
                    }
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1620:4: boolToken= ( 'true' | 'false' )
                    {
                    root_0 = (Object)adaptor.nil();


                    boolToken=(Token)input.LT(1);

                    if ( input.LA(1)==74||input.LA(1)==94 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(boolToken)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }



                    if(!defer) {
                        Variable objValue=new Variable(EugeneConstants.BOOLEAN,EugeneConstants.BOOLEAN);
                        objValue.setBoolean(new Boolean((boolToken!=null?boolToken.getText():null)).booleanValue());
                        retval.objElement =objValue;
                    }
                            

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1627:11: (accessToken= objectAccessStatement[defer] -> $accessToken)
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1627:11: (accessToken= objectAccessStatement[defer] -> $accessToken)
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1627:12: accessToken= objectAccessStatement[defer]
                    {
                    pushFollow(FOLLOW_objectAccessStatement_in_expressionValue2914);
                    accessToken=objectAccessStatement(defer);

                    state._fsp--;

                    stream_objectAccessStatement.add(accessToken.getTree());


                    if(!defer) {
                        retval.objElement = (accessToken!=null?accessToken.objElement:null);
                    }        
                    	

                    // AST REWRITE
                    // elements: accessToken
                    // token labels: 
                    // rule labels: retval, accessToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_accessToken=new RewriteRuleSubtreeStream(adaptor,"rule accessToken",accessToken!=null?accessToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1631:4: -> $accessToken
                    {
                        adaptor.addChild(root_0, stream_accessToken.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1632:4: '(' exprToken= expression[defer] ')'
                    {
                    char_literal149=(Token)match(input,21,FOLLOW_21_in_expressionValue2928);  
                    stream_21.add(char_literal149);


                    pushFollow(FOLLOW_expression_in_expressionValue2932);
                    exprToken=expression(defer);

                    state._fsp--;

                    stream_expression.add(exprToken.getTree());

                    char_literal150=(Token)match(input,22,FOLLOW_22_in_expressionValue2935);  
                    stream_22.add(char_literal150);



                    if(!defer){
                        retval.objElement = (exprToken!=null?exprToken.objElement:null);
                    }
                            

                    // AST REWRITE
                    // elements: 21, exprToken
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1636:15: -> ^( '(' $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1636:18: ^( '(' $exprToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_21.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_exprToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1637:4: '[' lstToken= listOfExpressions[defer] ']'
                    {
                    char_literal151=(Token)match(input,67,FOLLOW_67_in_expressionValue2959);  
                    stream_67.add(char_literal151);


                    pushFollow(FOLLOW_listOfExpressions_in_expressionValue2963);
                    lstToken=listOfExpressions(defer);

                    state._fsp--;

                    stream_listOfExpressions.add(lstToken.getTree());

                    char_literal152=(Token)match(input,68,FOLLOW_68_in_expressionValue2966);  
                    stream_68.add(char_literal152);



                    if(!defer) {
                        ArrayList<NamedElement> lstElements = (lstToken!=null?lstToken.lstElements:null);
                        NamedElement objFirstElement = null;
                        if(null != lstElements && !lstElements.isEmpty()) {
                            // get the type of the first element
                            objFirstElement = lstElements.get(0);
                            
                            if(objFirstElement instanceof Variable) {
                                Variable objVariable = (Variable)objFirstElement;
                                String sType = objVariable.getType();
                                ArrayList<Double> lstNumList=null;
                                ArrayList<String> lstTxtList=null;
                                
                                if(EugeneConstants.NUM.equals(sType)) {
                                    lstNumList = new ArrayList<Double>();
                                    lstNumList.add(objVariable.getNum());
                                } else if(EugeneConstants.TXT.equals(sType)) {
                                    lstTxtList = new ArrayList<String>();
                                    lstTxtList.add(objVariable.getTxt());
                                }
                                
                                for(int i=1;i<lstElements.size();i++) {
                                    NamedElement objElement = lstElements.get(i);
                                    if(objElement!=null && objElement instanceof Variable) {
                                        objVariable = (Variable)objElement;
                                        if(sType.equals(objVariable.getType())) {
                                            if(EugeneConstants.NUM.equals(sType)) {
                                                lstNumList.add(objVariable.getNum());
                                            } else if(EugeneConstants.TXT.equals(sType)) {
                                                lstTxtList.add(objVariable.getTxt());
                                            }
                                        } else {
                                            System.err.println("The "+i+"-th element is not of type "+sType);
                                            this.cleanUp(1);
                                        }
                                    }     
                                }   

                                if(EugeneConstants.NUM.equals(sType)) {
                                    objVariable = new Variable(EugeneConstants.VARIABLE,EugeneConstants.NUMLIST);
                                    objVariable.setNumList(lstNumList);
                                } else if(EugeneConstants.TXT.equals(sType)) {
                                    objVariable = new Variable(EugeneConstants.VARIABLE,EugeneConstants.TXTLIST);
                                    objVariable.setTxtList(lstTxtList);
                                }
                                retval.objElement = objVariable;
                            } else if(objFirstElement instanceof Device) {
                                DeviceArray objDeviceArray = new DeviceArray(EugeneConstants.DEVICEARRAY);
                                Device objDevice = (Device)objFirstElement;
                                objDeviceArray.add(objDevice);
                                for(int i=1;i<lstElements.size();i++) {
                                    NamedElement objElement = lstElements.get(i);
                                    if(objElement!=null && objElement instanceof Device) {
                                        objDeviceArray.add((Device)objElement);
                                    } else {
                                        System.err.println("The "+i+"-th element is not a Device!");
                                        this.cleanUp(1);
                                    }
                                }   
                                retval.objElement = objDeviceArray;
                            } else if(objFirstElement instanceof PartType) {
                                PartTypeArray objPartTypeArray = new PartTypeArray(EugeneConstants.PARTTYPEARRAY);
                                PartType objPartType = (PartType)objFirstElement;
                                objPartTypeArray.add(objPartType);
                                for(int i=1;i<lstElements.size();i++) {
                                    NamedElement objElement = lstElements.get(i);
                                    if(objElement!=null && objElement instanceof PartType) {
                                        objPartTypeArray.add((PartType)objElement);
                                    } else {
                                        System.err.println("The "+i+"-th element is not a Part Type!");
                                        this.cleanUp(1);
                                    }
                                }   
                                retval.objElement = objPartTypeArray;
                            } else if(objFirstElement instanceof Part) {
                                PartArray objPartArray = new PartArray(EugeneConstants.PARTARRAY);
                                Part objPart = (Part)objFirstElement;
                                objPartArray.add(objPart);
                                for(int i=1;i<lstElements.size();i++) {
                                    NamedElement objElement = lstElements.get(i);
                                    if(objElement!=null && objElement instanceof Part) {
                                        objPartArray.add((Part)objElement);
                                    } else {
                                        System.err.println("The "+i+"-th element is not a Part!");
                                        this.cleanUp(1);
                                    }
                                }   
                                retval.objElement = objPartArray;
                            } else if(objFirstElement instanceof Property) {
                                PropertyArray objPropertyArray = new PropertyArray(EugeneConstants.PROPERTYARRAY);
                                Property objProperty = (Property)objFirstElement;
                                objPropertyArray.add(objProperty);
                                for(int i=1;i<lstElements.size();i++) {
                                    NamedElement objElement = lstElements.get(i);
                                    if(objElement!=null && objElement instanceof Property) {
                                        objPropertyArray.add((Property)objElement);
                                    } else {
                                        System.err.println("The "+i+"-th element is not a Property!");
                                        this.cleanUp(1);
                                    }
                                }   
                                retval.objElement = objPropertyArray;
                            } else if(objFirstElement instanceof Rule) {
                                RuleArray objRuleArray = new RuleArray(EugeneConstants.RULEARRAY);
                                Iterator<NamedElement> it = lstElements.iterator();
                                while(it.hasNext()) {
                                    NamedElement objElement = it.next();
                                    if(objElement instanceof Rule) {
                                        objRuleArray.add((Rule)objElement);
                                    } else {
                                        System.err.println("line "+(lstToken!=null?((Token)lstToken.start):null).getLine()+":"+(lstToken!=null?((Token)lstToken.start):null).getCharPositionInLine()+" => "+
                                            "The "+objElement.getName()+" element is not a Rule!");
                                        this.cleanUp(1);
                                    }
                                }
                                retval.objElement = objRuleArray;
                            }
                        }
                    } 
                            

                    // AST REWRITE
                    // elements: lstToken, 67
                    // token labels: 
                    // rule labels: retval, lstToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_lstToken=new RewriteRuleSubtreeStream(adaptor,"rule lstToken",lstToken!=null?lstToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1757:11: -> ^( '[' $lstToken)
                    {
                        // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1757:14: ^( '[' $lstToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_67.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_lstToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println(retval.start.getLine()+":"+retval.start.getCharPositionInLine()+
                " => "+e.toString());
            this.cleanUp(1);	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expressionValue"


    public static class objectAccessStatement_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "objectAccessStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1765:1: objectAccessStatement[boolean defer] returns [NamedElement objElement] : idToken= ID ( (arrayToken= arrayAccess[defer, $objElement] ) | (propertyToken= propertyAccess[defer, $objElement] ) )* (funcToken= functionWrapper[defer,$objElement] )? -> ^( $idToken ( arrayAccess )* ( propertyAccess )* ) ;
    public final EugeneParser.objectAccessStatement_return objectAccessStatement(boolean defer) throws RecognitionException {
        EugeneParser.objectAccessStatement_return retval = new EugeneParser.objectAccessStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        EugeneParser.arrayAccess_return arrayToken =null;

        EugeneParser.propertyAccess_return propertyToken =null;

        EugeneParser.functionWrapper_return funcToken =null;


        Object idToken_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_arrayAccess=new RewriteRuleSubtreeStream(adaptor,"rule arrayAccess");
        RewriteRuleSubtreeStream stream_functionWrapper=new RewriteRuleSubtreeStream(adaptor,"rule functionWrapper");
        RewriteRuleSubtreeStream stream_propertyAccess=new RewriteRuleSubtreeStream(adaptor,"rule propertyAccess");

        NamedElement objTopElement = null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1769:2: (idToken= ID ( (arrayToken= arrayAccess[defer, $objElement] ) | (propertyToken= propertyAccess[defer, $objElement] ) )* (funcToken= functionWrapper[defer,$objElement] )? -> ^( $idToken ( arrayAccess )* ( propertyAccess )* ) )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1769:4: idToken= ID ( (arrayToken= arrayAccess[defer, $objElement] ) | (propertyToken= propertyAccess[defer, $objElement] ) )* (funcToken= functionWrapper[defer,$objElement] )?
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_objectAccessStatement3006);  
            stream_ID.add(idToken);



            if(!defer) {
                NamedElement objEl = interp.get((idToken!=null?idToken.getText():null));
                if(objEl==null) {
                    System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                            "I don't know anything about "+(idToken!=null?idToken.getText():null)+"!");
                    this.cleanUp(1);	
                } 

                retval.objElement = objEl;
            }
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1780:5: ( (arrayToken= arrayAccess[defer, $objElement] ) | (propertyToken= propertyAccess[defer, $objElement] ) )*
            loop61:
            do {
                int alt61=3;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==26) ) {
                    int LA61_1 = input.LA(2);

                    if ( (LA61_1==ID) ) {
                        alt61=2;
                    }


                }
                else if ( (LA61_0==67) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1780:6: (arrayToken= arrayAccess[defer, $objElement] )
            	    {
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1780:6: (arrayToken= arrayAccess[defer, $objElement] )
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1780:7: arrayToken= arrayAccess[defer, $objElement]
            	    {
            	    pushFollow(FOLLOW_arrayAccess_in_objectAccessStatement3016);
            	    arrayToken=arrayAccess(defer, retval.objElement);

            	    state._fsp--;

            	    stream_arrayAccess.add(arrayToken.getTree());


            	    if(!defer) {
            	        retval.objElement = (arrayToken!=null?arrayToken.objEl:null);
            	    }	
            	    	

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1785:6: (propertyToken= propertyAccess[defer, $objElement] )
            	    {
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1785:6: (propertyToken= propertyAccess[defer, $objElement] )
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1785:7: propertyToken= propertyAccess[defer, $objElement]
            	    {
            	    pushFollow(FOLLOW_propertyAccess_in_objectAccessStatement3030);
            	    propertyToken=propertyAccess(defer, retval.objElement);

            	    state._fsp--;

            	    stream_propertyAccess.add(propertyToken.getTree());


            	    if(!defer) {
            	        retval.objElement = (propertyToken!=null?propertyToken.objEl:null);
            	    }	
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1790:2: (funcToken= functionWrapper[defer,$objElement] )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==26||LA62_0==80) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1790:3: funcToken= functionWrapper[defer,$objElement]
                    {
                    pushFollow(FOLLOW_functionWrapper_in_objectAccessStatement3042);
                    funcToken=functionWrapper(defer, retval.objElement);

                    state._fsp--;

                    stream_functionWrapper.add(funcToken.getTree());


                    if(!defer) {
                        retval.objElement = (funcToken!=null?funcToken.objValue:null);
                    }	
                    	

                    }
                    break;

            }


            // AST REWRITE
            // elements: arrayAccess, idToken, propertyAccess
            // token labels: idToken
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_idToken=new RewriteRuleTokenStream(adaptor,"token idToken",idToken);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1795:3: -> ^( $idToken ( arrayAccess )* ( propertyAccess )* )
            {
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1795:6: ^( $idToken ( arrayAccess )* ( propertyAccess )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_idToken.nextNode(), root_1);

                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1795:17: ( arrayAccess )*
                while ( stream_arrayAccess.hasNext() ) {
                    adaptor.addChild(root_1, stream_arrayAccess.nextTree());

                }
                stream_arrayAccess.reset();

                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1795:30: ( propertyAccess )*
                while ( stream_propertyAccess.hasNext() ) {
                    adaptor.addChild(root_1, stream_propertyAccess.nextTree());

                }
                stream_propertyAccess.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println(
                "line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+
                " => "+e.getMessage());
            this.cleanUp(1);	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "objectAccessStatement"


    public static class arrayAccess_return extends ParserRuleReturnScope {
        public NamedElement objEl;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arrayAccess"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1804:1: arrayAccess[boolean defer, NamedElement objElement] returns [NamedElement objEl] : '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) ;
    public final EugeneParser.arrayAccess_return arrayAccess(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.arrayAccess_return retval = new EugeneParser.arrayAccess_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal153=null;
        Token char_literal154=null;
        EugeneParser.expression_return idxToken =null;


        Object char_literal153_tree=null;
        Object char_literal154_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1805:2: ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1805:4: '[' idxToken= expression[defer] ']'
            {
            char_literal153=(Token)match(input,67,FOLLOW_67_in_arrayAccess3085);  
            stream_67.add(char_literal153);


            pushFollow(FOLLOW_expression_in_arrayAccess3089);
            idxToken=expression(defer);

            state._fsp--;

            stream_expression.add(idxToken.getTree());

            char_literal154=(Token)match(input,68,FOLLOW_68_in_arrayAccess3092);  
            stream_68.add(char_literal154);



            if(!defer) {
                
                int nLine = idxToken.start.getLine();
                int nPos = idxToken.start.getCharPositionInLine();
                
                int idx = -1;
                NamedElement objIdxElement = (idxToken!=null?idxToken.objElement:null);
                
                if(objIdxElement!=null && objIdxElement instanceof Variable) {
                    Variable objIdxVariable = (Variable)objIdxElement;
                    if(EugeneConstants.NUM.equals(objIdxVariable.getType())) {
                        if(objIdxVariable.getNum() != (int)objIdxVariable.getNum()) {
                            System.err.println("line "+nLine+":"+nPos+" => "+
                                "The value of "+(idxToken!=null?input.toString(idxToken.start,idxToken.stop):null)+
                                " ("+objIdxVariable.getNum()+") is an invalid index!");
                            this.cleanUp(1);
                        } else {
                            idx = (int)objIdxVariable.getNum();
                        }
                    } else {
                        System.err.println("line "+nLine+":"+nPos+" => "+
                            (idxToken!=null?input.toString(idxToken.start,idxToken.stop):null)+" has an invalid type for an index!");
                        this.cleanUp(1);
                    }
                } else {
                    System.err.println("Invalid array index!");
                    this.cleanUp(1);
                }
                
                retval.objEl = interp.get(objElement, idx);    
            }	
            	

            // AST REWRITE
            // elements: idxToken, 67
            // token labels: 
            // rule labels: retval, idxToken
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_idxToken=new RewriteRuleSubtreeStream(adaptor,"rule idxToken",idxToken!=null?idxToken.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1837:4: -> ^( '[' $idxToken)
            {
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1837:7: ^( '[' $idxToken)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_67.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_idxToken.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println(
                    "line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+
                    " => "+e.toString());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arrayAccess"


    public static class propertyAccess_return extends ParserRuleReturnScope {
        public NamedElement objEl;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "propertyAccess"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1846:1: propertyAccess[boolean defer, NamedElement objElement] returns [NamedElement objEl] : '.' propertyToken= ID -> ^( '.' $propertyToken) ;
    public final EugeneParser.propertyAccess_return propertyAccess(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.propertyAccess_return retval = new EugeneParser.propertyAccess_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token propertyToken=null;
        Token char_literal155=null;

        Object propertyToken_tree=null;
        Object char_literal155_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1848:2: ( '.' propertyToken= ID -> ^( '.' $propertyToken) )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1848:4: '.' propertyToken= ID
            {
            char_literal155=(Token)match(input,26,FOLLOW_26_in_propertyAccess3126);  
            stream_26.add(char_literal155);


            propertyToken=(Token)match(input,ID,FOLLOW_ID_in_propertyAccess3130);  
            stream_ID.add(propertyToken);



            if(!defer) {
                retval.objEl = interp.get(objElement, (propertyToken!=null?propertyToken.getText():null));
            }	
            	

            // AST REWRITE
            // elements: propertyToken, 26
            // token labels: propertyToken
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_propertyToken=new RewriteRuleTokenStream(adaptor,"token propertyToken",propertyToken);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1852:4: -> ^( '.' $propertyToken)
            {
                // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1852:7: ^( '.' $propertyToken)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_26.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_propertyToken.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(propertyToken!=null?propertyToken.getLine():0)+":"+(propertyToken!=null?propertyToken.getCharPositionInLine():0)+
                    " => "+e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "propertyAccess"


    public static class functionWrapper_return extends ParserRuleReturnScope {
        public NamedElement objValue;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionWrapper"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1860:1: functionWrapper[boolean defer, NamedElement objElement] returns [NamedElement objValue] : (sizeToken= ( '.' 'size' '(' ')' ) |getToken= '.' 'get' '(' (numIdx= INT |idToken= ID |nameToken= STRING ) ')' |seqToken= ( '.' 'toSequence' '(' ')' ) |emptyToken= ( '.' 'isEmpty' '(' ')' ) |sbolToken= sbolImportStatement[defer] |genbankToken= genbankImportStatement[defer] | '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' );
    public final EugeneParser.functionWrapper_return functionWrapper(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.functionWrapper_return retval = new EugeneParser.functionWrapper_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token sizeToken=null;
        Token getToken=null;
        Token numIdx=null;
        Token idToken=null;
        Token nameToken=null;
        Token seqToken=null;
        Token emptyToken=null;
        Token char_literal156=null;
        Token string_literal157=null;
        Token char_literal158=null;
        Token char_literal159=null;
        Token string_literal160=null;
        Token char_literal161=null;
        Token char_literal162=null;
        Token char_literal163=null;
        Token string_literal164=null;
        Token char_literal165=null;
        Token char_literal166=null;
        Token char_literal167=null;
        Token string_literal168=null;
        Token char_literal169=null;
        Token char_literal170=null;
        Token char_literal171=null;
        Token string_literal172=null;
        Token char_literal173=null;
        Token char_literal174=null;
        EugeneParser.sbolImportStatement_return sbolToken =null;

        EugeneParser.genbankImportStatement_return genbankToken =null;

        EugeneParser.expression_return exprToken =null;


        Object sizeToken_tree=null;
        Object getToken_tree=null;
        Object numIdx_tree=null;
        Object idToken_tree=null;
        Object nameToken_tree=null;
        Object seqToken_tree=null;
        Object emptyToken_tree=null;
        Object char_literal156_tree=null;
        Object string_literal157_tree=null;
        Object char_literal158_tree=null;
        Object char_literal159_tree=null;
        Object string_literal160_tree=null;
        Object char_literal161_tree=null;
        Object char_literal162_tree=null;
        Object char_literal163_tree=null;
        Object string_literal164_tree=null;
        Object char_literal165_tree=null;
        Object char_literal166_tree=null;
        Object char_literal167_tree=null;
        Object string_literal168_tree=null;
        Object char_literal169_tree=null;
        Object char_literal170_tree=null;
        Object char_literal171_tree=null;
        Object string_literal172_tree=null;
        Object char_literal173_tree=null;
        Object char_literal174_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1861:2: (sizeToken= ( '.' 'size' '(' ')' ) |getToken= '.' 'get' '(' (numIdx= INT |idToken= ID |nameToken= STRING ) ')' |seqToken= ( '.' 'toSequence' '(' ')' ) |emptyToken= ( '.' 'isEmpty' '(' ')' ) |sbolToken= sbolImportStatement[defer] |genbankToken= genbankImportStatement[defer] | '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' )
            int alt65=7;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==26) ) {
                switch ( input.LA(2) ) {
                case 91:
                    {
                    alt65=1;
                    }
                    break;
                case 78:
                    {
                    alt65=2;
                    }
                    break;
                case 93:
                    {
                    alt65=3;
                    }
                    break;
                case 83:
                    {
                    alt65=4;
                    }
                    break;
                case 82:
                    {
                    alt65=7;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;

                }

            }
            else if ( (LA65_0==80) ) {
                int LA65_2 = input.LA(2);

                if ( (LA65_2==21) ) {
                    int LA65_8 = input.LA(3);

                    if ( (LA65_8==STRING) ) {
                        alt65=5;
                    }
                    else if ( (LA65_8==ID) ) {
                        alt65=6;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 65, 8, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }
            switch (alt65) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1861:4: sizeToken= ( '.' 'size' '(' ')' )
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1861:14: ( '.' 'size' '(' ')' )
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1861:15: '.' 'size' '(' ')'
                    {
                    char_literal156=(Token)match(input,26,FOLLOW_26_in_functionWrapper3168); 
                    char_literal156_tree = 
                    (Object)adaptor.create(char_literal156)
                    ;
                    adaptor.addChild(root_0, char_literal156_tree);


                    string_literal157=(Token)match(input,91,FOLLOW_91_in_functionWrapper3170); 
                    string_literal157_tree = 
                    (Object)adaptor.create(string_literal157)
                    ;
                    adaptor.addChild(root_0, string_literal157_tree);


                    char_literal158=(Token)match(input,21,FOLLOW_21_in_functionWrapper3172); 
                    char_literal158_tree = 
                    (Object)adaptor.create(char_literal158)
                    ;
                    adaptor.addChild(root_0, char_literal158_tree);


                    char_literal159=(Token)match(input,22,FOLLOW_22_in_functionWrapper3174); 
                    char_literal159_tree = 
                    (Object)adaptor.create(char_literal159)
                    ;
                    adaptor.addChild(root_0, char_literal159_tree);


                    }



                    if(!defer) {    
                        Variable objVariable = interp.createVariable(
                                (String)null, EugeneConstants.NUM);
                        objVariable.setNum(interp.sizeOf(objElement.getName()));   
                        retval.objValue = objVariable; 
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1869:4: getToken= '.' 'get' '(' (numIdx= INT |idToken= ID |nameToken= STRING ) ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    getToken=(Token)match(input,26,FOLLOW_26_in_functionWrapper3184); 
                    getToken_tree = 
                    (Object)adaptor.create(getToken)
                    ;
                    adaptor.addChild(root_0, getToken_tree);


                    string_literal160=(Token)match(input,78,FOLLOW_78_in_functionWrapper3186); 
                    string_literal160_tree = 
                    (Object)adaptor.create(string_literal160)
                    ;
                    adaptor.addChild(root_0, string_literal160_tree);


                    char_literal161=(Token)match(input,21,FOLLOW_21_in_functionWrapper3188); 
                    char_literal161_tree = 
                    (Object)adaptor.create(char_literal161)
                    ;
                    adaptor.addChild(root_0, char_literal161_tree);


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1869:27: (numIdx= INT |idToken= ID |nameToken= STRING )
                    int alt63=3;
                    switch ( input.LA(1) ) {
                    case INT:
                        {
                        alt63=1;
                        }
                        break;
                    case ID:
                        {
                        alt63=2;
                        }
                        break;
                    case STRING:
                        {
                        alt63=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 0, input);

                        throw nvae;

                    }

                    switch (alt63) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1869:28: numIdx= INT
                            {
                            numIdx=(Token)match(input,INT,FOLLOW_INT_in_functionWrapper3193); 
                            numIdx_tree = 
                            (Object)adaptor.create(numIdx)
                            ;
                            adaptor.addChild(root_0, numIdx_tree);



                            if(!defer) {
                                retval.objValue = interp.get(objElement, Double.parseDouble((numIdx!=null?numIdx.getText():null)));
                            }
                            	

                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1873:6: idToken= ID
                            {
                            idToken=(Token)match(input,ID,FOLLOW_ID_in_functionWrapper3201); 
                            idToken_tree = 
                            (Object)adaptor.create(idToken)
                            ;
                            adaptor.addChild(root_0, idToken_tree);



                            if(!defer) {
                                retval.objValue = interp.get(objElement, (idToken!=null?idToken.getText():null));
                            }
                                    

                            }
                            break;
                        case 3 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1877:13: nameToken= STRING
                            {
                            nameToken=(Token)match(input,STRING,FOLLOW_STRING_in_functionWrapper3210); 
                            nameToken_tree = 
                            (Object)adaptor.create(nameToken)
                            ;
                            adaptor.addChild(root_0, nameToken_tree);



                            if(!defer) {
                                retval.objValue = interp.get(objElement, (nameToken!=null?nameToken.getText():null).substring(1, (nameToken!=null?nameToken.getText():null).length()-1));
                            }
                                    

                            }
                            break;

                    }


                    char_literal162=(Token)match(input,22,FOLLOW_22_in_functionWrapper3215); 
                    char_literal162_tree = 
                    (Object)adaptor.create(char_literal162)
                    ;
                    adaptor.addChild(root_0, char_literal162_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1882:4: seqToken= ( '.' 'toSequence' '(' ')' )
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1882:13: ( '.' 'toSequence' '(' ')' )
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1882:14: '.' 'toSequence' '(' ')'
                    {
                    char_literal163=(Token)match(input,26,FOLLOW_26_in_functionWrapper3223); 
                    char_literal163_tree = 
                    (Object)adaptor.create(char_literal163)
                    ;
                    adaptor.addChild(root_0, char_literal163_tree);


                    string_literal164=(Token)match(input,93,FOLLOW_93_in_functionWrapper3225); 
                    string_literal164_tree = 
                    (Object)adaptor.create(string_literal164)
                    ;
                    adaptor.addChild(root_0, string_literal164_tree);


                    char_literal165=(Token)match(input,21,FOLLOW_21_in_functionWrapper3227); 
                    char_literal165_tree = 
                    (Object)adaptor.create(char_literal165)
                    ;
                    adaptor.addChild(root_0, char_literal165_tree);


                    char_literal166=(Token)match(input,22,FOLLOW_22_in_functionWrapper3229); 
                    char_literal166_tree = 
                    (Object)adaptor.create(char_literal166)
                    ;
                    adaptor.addChild(root_0, char_literal166_tree);


                    }



                    if(!defer) {
                        if(objElement!=null && objElement instanceof Component) {
                            Variable objVariable = new Variable("SEQUENCE",EugeneConstants.TXT);
                            try {
                                objVariable.setTxt(((Component)objElement).toSequence());
                                retval.objValue = objVariable;
                            } catch(EugeneException e) {
                                System.err.println("line "+(seqToken!=null?seqToken.getLine():0)+":"+(seqToken!=null?seqToken.getCharPositionInLine():0)+" => "+
                                    "Cannot get the DNA sequence of "+objElement.getName());
                                this.cleanUp(1);
                            }
                        } else {
                            System.err.println("line "+(seqToken!=null?seqToken.getLine():0)+":"+(seqToken!=null?seqToken.getCharPositionInLine():0)+" => "+
                                "The "+objElement.getName()+" element is not a genetic component!");
                            this.cleanUp(1);
                        }
                    }
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1901:4: emptyToken= ( '.' 'isEmpty' '(' ')' )
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1901:15: ( '.' 'isEmpty' '(' ')' )
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1901:16: '.' 'isEmpty' '(' ')'
                    {
                    char_literal167=(Token)match(input,26,FOLLOW_26_in_functionWrapper3240); 
                    char_literal167_tree = 
                    (Object)adaptor.create(char_literal167)
                    ;
                    adaptor.addChild(root_0, char_literal167_tree);


                    string_literal168=(Token)match(input,83,FOLLOW_83_in_functionWrapper3242); 
                    string_literal168_tree = 
                    (Object)adaptor.create(string_literal168)
                    ;
                    adaptor.addChild(root_0, string_literal168_tree);


                    char_literal169=(Token)match(input,21,FOLLOW_21_in_functionWrapper3244); 
                    char_literal169_tree = 
                    (Object)adaptor.create(char_literal169)
                    ;
                    adaptor.addChild(root_0, char_literal169_tree);


                    char_literal170=(Token)match(input,22,FOLLOW_22_in_functionWrapper3246); 
                    char_literal170_tree = 
                    (Object)adaptor.create(char_literal170)
                    ;
                    adaptor.addChild(root_0, char_literal170_tree);


                    }



                    if(!defer) {
                        Variable objVariable = new Variable(objElement.getName()+"_empty",EugeneConstants.BOOLEAN);
                        if(objElement instanceof ComponentArray) {
                            objVariable.setBoolean(((ComponentArray)objElement).size()==0);
                        } else if (objElement instanceof Component) {
                            objVariable.setBoolean(((Component)objElement).size()==0);
                        }
                        retval.objValue = objVariable;
                    }	
                    	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1912:4: sbolToken= sbolImportStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_sbolImportStatement_in_functionWrapper3256);
                    sbolToken=sbolImportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolToken.getTree());


                    if(!defer) {	
                        System.out.println(sbolToken.objElement);
                        //retval.objValue = sbolToken.objElement;
                    }	
                    	

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1918:4: genbankToken= genbankImportStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_genbankImportStatement_in_functionWrapper3266);
                    genbankToken=genbankImportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankToken.getTree());


                    if(!defer) {
                        retval.objValue = genbankToken.objElement;
                    }	
                    	

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1923:4: '.' 'instantiate' '(' (exprToken= expression[defer] )? ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal171=(Token)match(input,26,FOLLOW_26_in_functionWrapper3274); 
                    char_literal171_tree = 
                    (Object)adaptor.create(char_literal171)
                    ;
                    adaptor.addChild(root_0, char_literal171_tree);


                    string_literal172=(Token)match(input,82,FOLLOW_82_in_functionWrapper3276); 
                    string_literal172_tree = 
                    (Object)adaptor.create(string_literal172)
                    ;
                    adaptor.addChild(root_0, string_literal172_tree);


                    char_literal173=(Token)match(input,21,FOLLOW_21_in_functionWrapper3278); 
                    char_literal173_tree = 
                    (Object)adaptor.create(char_literal173)
                    ;
                    adaptor.addChild(root_0, char_literal173_tree);


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1923:26: (exprToken= expression[defer] )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==FLOAT||LA64_0==ID||(LA64_0 >= INT && LA64_0 <= MINUS)||LA64_0==STRING||LA64_0==19||LA64_0==21||(LA64_0 >= 31 && LA64_0 <= 32)||(LA64_0 >= 34 && LA64_0 <= 37)||(LA64_0 >= 40 && LA64_0 <= 41)||(LA64_0 >= 45 && LA64_0 <= 46)||(LA64_0 >= 50 && LA64_0 <= 54)||(LA64_0 >= 63 && LA64_0 <= 65)||LA64_0==67||LA64_0==74||LA64_0==94) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1923:27: exprToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_functionWrapper3283);
                            exprToken=expression(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, exprToken.getTree());

                            }
                            break;

                    }


                    char_literal174=(Token)match(input,22,FOLLOW_22_in_functionWrapper3288); 
                    char_literal174_tree = 
                    (Object)adaptor.create(char_literal174)
                    ;
                    adaptor.addChild(root_0, char_literal174_tree);



                    if(!defer) {
                        if(objElement == null) {
                            System.err.println("Invalid usage of the instantiate() function!");
                            this.cleanUp(1);
                        }

                        Rule objRule = null;
                        if(null!=exprToken && (exprToken!=null?exprToken.objElement:null) instanceof Rule) {
                            objRule = (Rule)(exprToken!=null?exprToken.objElement:null);
                            //System.out.println("[instantiate] -> "+objRule.toStringTree());
                        }    
                    }	
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+" => "+
                e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionWrapper"


    public static class objectAssignmentStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "objectAssignmentStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1944:1: objectAssignmentStatement[boolean defer] : idToken= ID ( ( '.' subIdToken= ID ) | ( '[' idxToken= expression[defer] ']' ) )* rightToken= assignment[defer] ;
    public final EugeneParser.objectAssignmentStatement_return objectAssignmentStatement(boolean defer) throws RecognitionException {
        EugeneParser.objectAssignmentStatement_return retval = new EugeneParser.objectAssignmentStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token subIdToken=null;
        Token char_literal175=null;
        Token char_literal176=null;
        Token char_literal177=null;
        EugeneParser.expression_return idxToken =null;

        EugeneParser.assignment_return rightToken =null;


        Object idToken_tree=null;
        Object subIdToken_tree=null;
        Object char_literal175_tree=null;
        Object char_literal176_tree=null;
        Object char_literal177_tree=null;


        NamedElement objElement = null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1948:2: (idToken= ID ( ( '.' subIdToken= ID ) | ( '[' idxToken= expression[defer] ']' ) )* rightToken= assignment[defer] )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1948:4: idToken= ID ( ( '.' subIdToken= ID ) | ( '[' idxToken= expression[defer] ']' ) )* rightToken= assignment[defer]
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_objectAssignmentStatement3317); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);



            if(!defer) {
                objElement = interp.get((idToken!=null?idToken.getText():null));
                //objElement = SymbolTables.get((idToken!=null?idToken.getText():null));
            }	
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1953:8: ( ( '.' subIdToken= ID ) | ( '[' idxToken= expression[defer] ']' ) )*
            loop66:
            do {
                int alt66=3;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==26) ) {
                    alt66=1;
                }
                else if ( (LA66_0==67) ) {
                    alt66=2;
                }


                switch (alt66) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1953:9: ( '.' subIdToken= ID )
            	    {
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1953:9: ( '.' subIdToken= ID )
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1953:10: '.' subIdToken= ID
            	    {
            	    char_literal175=(Token)match(input,26,FOLLOW_26_in_objectAssignmentStatement3327); 
            	    char_literal175_tree = 
            	    (Object)adaptor.create(char_literal175)
            	    ;
            	    adaptor.addChild(root_0, char_literal175_tree);


            	    subIdToken=(Token)match(input,ID,FOLLOW_ID_in_objectAssignmentStatement3331); 
            	    subIdToken_tree = 
            	    (Object)adaptor.create(subIdToken)
            	    ;
            	    adaptor.addChild(root_0, subIdToken_tree);



            	    if(!defer) {
            	        NamedElement objTempElement = interp.get(objElement, (subIdToken!=null?subIdToken.getText():null));
            	        if(objElement == null) {
            	            System.err.println("line "+(subIdToken!=null?subIdToken.getLine():0)+":"+(subIdToken!=null?subIdToken.getCharPositionInLine():0)+" => "+
            	                "The "+objElement.getName()+" element does not contain a "+(subIdToken!=null?subIdToken.getText():null)+" element!");
            	            this.cleanUp(1);
            	        } 
            	        objElement = objTempElement;
            	    }	
            	    	

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1963:7: ( '[' idxToken= expression[defer] ']' )
            	    {
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1963:7: ( '[' idxToken= expression[defer] ']' )
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:1963:8: '[' idxToken= expression[defer] ']'
            	    {
            	    char_literal176=(Token)match(input,67,FOLLOW_67_in_objectAssignmentStatement3339); 
            	    char_literal176_tree = 
            	    (Object)adaptor.create(char_literal176)
            	    ;
            	    adaptor.addChild(root_0, char_literal176_tree);



            	    if(!defer) {
            	        if(null==objElement) {
            	            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
            	                        "I don't know anything about "+(idToken!=null?idToken.getText():null));
            	            this.cleanUp(1);
            	        }
            	    }	
            	    	

            	    pushFollow(FOLLOW_expression_in_objectAssignmentStatement3345);
            	    idxToken=expression(defer);

            	    state._fsp--;

            	    adaptor.addChild(root_0, idxToken.getTree());

            	    char_literal177=(Token)match(input,68,FOLLOW_68_in_objectAssignmentStatement3348); 
            	    char_literal177_tree = 
            	    (Object)adaptor.create(char_literal177)
            	    ;
            	    adaptor.addChild(root_0, char_literal177_tree);



            	    if(!defer) {
            	        NamedElement objIdxElement = (idxToken!=null?idxToken.objElement:null);
            	        if(null!=objIdxElement) {
            	            double idx = -1;
            	            if(!(objIdxElement instanceof Variable) ||
            	               !EugeneConstants.NUM.equals(((Variable)objIdxElement).getType())) {
            	                System.err.println("line "+idxToken.start.getLine()+":"+idxToken.start.getCharPositionInLine()+" => "+
            	                    (idxToken!=null?input.toString(idxToken.start,idxToken.stop):null)+" is an invalid array index!");
            	                this.cleanUp(1);
            	            }
            	                	            
            	            objElement = objElement.get(
            	                    (int)((Variable)objIdxElement).getNum());
            	        }    
            	    }	
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            pushFollow(FOLLOW_assignment_in_objectAssignmentStatement3357);
            rightToken=assignment(defer);

            state._fsp--;

            adaptor.addChild(root_0, rightToken.getTree());


            if(!defer) {
                if("++".equals((rightToken!=null?input.toString(rightToken.start,rightToken.stop):null)) && objElement instanceof Variable) {
                    ((Variable)objElement).increase();
                } else if ("--".equals((rightToken!=null?input.toString(rightToken.start,rightToken.stop):null)) && objElement instanceof Variable) {
                    ((Variable)objElement).decrease();
                } else if (objElement!=null) {
                    interp.assign(objElement.getName(), (rightToken!=null?rightToken.objElement:null));
                } else {
                    interp.assign((idToken!=null?idToken.getText():null), (rightToken!=null?rightToken.objElement:null));
                }
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "objectAssignmentStatement"


    public static class listOfStatements_return extends ParserRuleReturnScope {
        public NamedElement objReturnValue;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfStatements"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2006:1: listOfStatements[boolean defer] returns [NamedElement objReturnValue] : (stmtToken= statement[defer] )+ ;
    public final EugeneParser.listOfStatements_return listOfStatements(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.listOfStatements_return retval = new EugeneParser.listOfStatements_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.statement_return stmtToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2008:2: ( (stmtToken= statement[defer] )+ )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2008:4: (stmtToken= statement[defer] )+
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2008:4: (stmtToken= statement[defer] )+
            int cnt67=0;
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( ((LA67_0 >= ID && LA67_0 <= INCLUDE)||LA67_0==30||LA67_0==39||(LA67_0 >= 42 && LA67_0 <= 44)||LA67_0==47||LA67_0==49||LA67_0==55||(LA67_0 >= 58 && LA67_0 <= 62)||(LA67_0 >= 70 && LA67_0 <= 71)||LA67_0==76||(LA67_0 >= 79 && LA67_0 <= 80)||(LA67_0 >= 84 && LA67_0 <= 90)||(LA67_0 >= 95 && LA67_0 <= 96)) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2008:5: stmtToken= statement[defer]
            	    {
            	    pushFollow(FOLLOW_statement_in_listOfStatements3391);
            	    stmtToken=statement(defer);

            	    state._fsp--;

            	    adaptor.addChild(root_0, stmtToken.getTree());


            	    if(!defer) {
            	        //retval.objReturnValue = (stmtToken!=null?stmtToken.objReturnValue:null);
            	        retval.objReturnValue = (NamedElement)null;
            	    }	
            	    	

            	    }
            	    break;

            	default :
            	    if ( cnt67 >= 1 ) break loop67;
                        EarlyExitException eee =
                            new EarlyExitException(67, input);
                        throw eee;
                }
                cnt67++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfStatements"


    public static class returnStatement_return extends ParserRuleReturnScope {
        public NamedElement objReturnValue;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "returnStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2016:1: returnStatement[boolean defer] returns [NamedElement objReturnValue] : returnToken= 'return' ( (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] ) )? ';' ;
    public final EugeneParser.returnStatement_return returnStatement(boolean defer) throws RecognitionException {
        EugeneParser.returnStatement_return retval = new EugeneParser.returnStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token returnToken=null;
        Token char_literal178=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.functionCall_return functionToken =null;

        EugeneParser.wrappedStatement_return wrapperToken =null;


        Object returnToken_tree=null;
        Object char_literal178_tree=null;


        NamedElement objReturn = null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2020:2: (returnToken= 'return' ( (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] ) )? ';' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2020:4: returnToken= 'return' ( (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] ) )? ';'
            {
            root_0 = (Object)adaptor.nil();


            returnToken=(Token)match(input,89,FOLLOW_89_in_returnStatement3421); 
            returnToken_tree = 
            (Object)adaptor.create(returnToken)
            ;
            adaptor.addChild(root_0, returnToken_tree);



            if(!defer) {
                String sFunctionName = SymbolTables.getCurrentFunctionName();
                if(sFunctionName==null) {
                    System.err.println("line "+(returnToken!=null?returnToken.getLine():0)+":"+(returnToken!=null?returnToken.getCharPositionInLine():0)+
                            " => A 'return' statement is not allowed here!");
                    this.cleanUp(1);
                }
                
                NamedElement objElement = interp.get(sFunctionName);
                if(null!=objElement && objElement instanceof Function) {
                    Function objFunction = (Function)objElement;
                
                    // get the function's return type
                    objReturn = objFunction.getReturn();
                    if(null==objReturn) {
                        System.err.println("line "+(returnToken!=null?returnToken.getLine():0)+":"+(returnToken!=null?returnToken.getCharPositionInLine():0)+" => "+
                                "The Function "+objFunction.getName()+" cannot return anything because there's no return type specified!");
                        this.cleanUp(1);        
                    }
                }
            }	
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2042:4: ( (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==FLOAT||LA69_0==ID||(LA69_0 >= INT && LA69_0 <= MINUS)||LA69_0==STRING||LA69_0==19||LA69_0==21||(LA69_0 >= 31 && LA69_0 <= 32)||(LA69_0 >= 34 && LA69_0 <= 37)||(LA69_0 >= 40 && LA69_0 <= 41)||(LA69_0 >= 45 && LA69_0 <= 47)||(LA69_0 >= 50 && LA69_0 <= 54)||(LA69_0 >= 62 && LA69_0 <= 65)||LA69_0==67||LA69_0==74||LA69_0==85||LA69_0==88||LA69_0==94) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2042:6: (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2042:6: (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )
                    int alt68=3;
                    switch ( input.LA(1) ) {
                    case FLOAT:
                    case INT:
                    case MINUS:
                    case STRING:
                    case 19:
                    case 21:
                    case 31:
                    case 32:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 40:
                    case 41:
                    case 45:
                    case 46:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 63:
                    case 64:
                    case 65:
                    case 67:
                    case 74:
                    case 94:
                        {
                        alt68=1;
                        }
                        break;
                    case ID:
                        {
                        switch ( input.LA(2) ) {
                        case 21:
                            {
                            alt68=2;
                            }
                            break;
                        case 27:
                            {
                            alt68=3;
                            }
                            break;
                        case 26:
                            {
                            switch ( input.LA(3) ) {
                            case 78:
                                {
                                int LA68_6 = input.LA(4);

                                if ( (LA68_6==21) ) {
                                    switch ( input.LA(5) ) {
                                    case INT:
                                        {
                                        int LA68_12 = input.LA(6);

                                        if ( (LA68_12==22) ) {
                                            alt68=1;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 68, 12, input);

                                            throw nvae;

                                        }
                                        }
                                        break;
                                    case ID:
                                        {
                                        int LA68_13 = input.LA(6);

                                        if ( (LA68_13==22) ) {
                                            alt68=1;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 68, 13, input);

                                            throw nvae;

                                        }
                                        }
                                        break;
                                    case STRING:
                                        {
                                        int LA68_14 = input.LA(6);

                                        if ( (LA68_14==22) ) {
                                            alt68=1;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 68, 14, input);

                                            throw nvae;

                                        }
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 68, 9, input);

                                        throw nvae;

                                    }

                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 68, 6, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 91:
                                {
                                int LA68_7 = input.LA(4);

                                if ( (LA68_7==21) ) {
                                    int LA68_10 = input.LA(5);

                                    if ( (LA68_10==22) ) {
                                        alt68=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 68, 10, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 68, 7, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 93:
                                {
                                int LA68_8 = input.LA(4);

                                if ( (LA68_8==21) ) {
                                    int LA68_11 = input.LA(5);

                                    if ( (LA68_11==22) ) {
                                        alt68=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 68, 11, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 68, 8, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case ID:
                            case 82:
                            case 83:
                                {
                                alt68=1;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 68, 5, input);

                                throw nvae;

                            }

                            }
                            break;
                        case MINUS:
                        case 19:
                        case 20:
                        case 23:
                        case 24:
                        case 28:
                        case 30:
                        case 31:
                        case 32:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 40:
                        case 41:
                        case 45:
                        case 46:
                        case 48:
                        case 50:
                        case 51:
                        case 52:
                        case 54:
                        case 57:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 69:
                        case 80:
                        case 81:
                        case 98:
                            {
                            alt68=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 68, 2, input);

                            throw nvae;

                        }

                        }
                        break;
                    case 47:
                    case 62:
                    case 85:
                    case 88:
                        {
                        alt68=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 0, input);

                        throw nvae;

                    }

                    switch (alt68) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2042:7: exprToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_returnStatement3430);
                            exprToken=expression(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, exprToken.getTree());


                            if(!defer) {
                                retval.objReturnValue = (exprToken!=null?exprToken.objElement:null);
                            }
                            	

                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2046:6: functionToken= functionCall[defer]
                            {
                            pushFollow(FOLLOW_functionCall_in_returnStatement3439);
                            functionToken=functionCall(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, functionToken.getTree());


                            if(!defer) {
                                retval.objReturnValue = (functionToken!=null?functionToken.objElement:null);
                            }
                            	

                            }
                            break;
                        case 3 :
                            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2050:6: wrapperToken= wrappedStatement[defer]
                            {
                            pushFollow(FOLLOW_wrappedStatement_in_returnStatement3448);
                            wrapperToken=wrappedStatement(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, wrapperToken.getTree());


                            if(!defer) {
                                retval.objReturnValue = (wrapperToken!=null?wrapperToken.objElement:null);
                            }	
                            	

                            }
                            break;

                    }


                    }
                    break;

            }


            char_literal178=(Token)match(input,30,FOLLOW_30_in_returnStatement3456); 
            char_literal178_tree = 
            (Object)adaptor.create(char_literal178)
            ;
            adaptor.addChild(root_0, char_literal178_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "returnStatement"


    public static class saveStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "saveStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2060:1: saveStatement[boolean defer] : 'save' '(' listOfSaveObjects[defer] ')' ;
    public final EugeneParser.saveStatement_return saveStatement(boolean defer) throws RecognitionException {
        EugeneParser.saveStatement_return retval = new EugeneParser.saveStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal179=null;
        Token char_literal180=null;
        Token char_literal182=null;
        EugeneParser.listOfSaveObjects_return listOfSaveObjects181 =null;


        Object string_literal179_tree=null;
        Object char_literal180_tree=null;
        Object char_literal182_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2061:2: ( 'save' '(' listOfSaveObjects[defer] ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2061:4: 'save' '(' listOfSaveObjects[defer] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal179=(Token)match(input,90,FOLLOW_90_in_saveStatement3473); 
            string_literal179_tree = 
            (Object)adaptor.create(string_literal179)
            ;
            adaptor.addChild(root_0, string_literal179_tree);


            char_literal180=(Token)match(input,21,FOLLOW_21_in_saveStatement3475); 
            char_literal180_tree = 
            (Object)adaptor.create(char_literal180)
            ;
            adaptor.addChild(root_0, char_literal180_tree);


            pushFollow(FOLLOW_listOfSaveObjects_in_saveStatement3477);
            listOfSaveObjects181=listOfSaveObjects(defer);

            state._fsp--;

            adaptor.addChild(root_0, listOfSaveObjects181.getTree());

            char_literal182=(Token)match(input,22,FOLLOW_22_in_saveStatement3480); 
            char_literal182_tree = 
            (Object)adaptor.create(char_literal182)
            ;
            adaptor.addChild(root_0, char_literal182_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "saveStatement"


    public static class listOfSaveObjects_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfSaveObjects"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2064:1: listOfSaveObjects[boolean defer] : (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )? ;
    public final EugeneParser.listOfSaveObjects_return listOfSaveObjects(boolean defer) throws RecognitionException {
        EugeneParser.listOfSaveObjects_return retval = new EugeneParser.listOfSaveObjects_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token char_literal183=null;
        Token char_literal184=null;
        EugeneParser.expression_return idToken =null;

        EugeneParser.listOfSaveObjects_return listOfSaveObjects185 =null;


        Object nameToken_tree=null;
        Object char_literal183_tree=null;
        Object char_literal184_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2065:2: ( (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2065:4: (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2065:4: (nameToken= ID ':' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==ID) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==29) ) {
                    alt70=1;
                }
            }
            switch (alt70) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2065:5: nameToken= ID ':'
                    {
                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfSaveObjects3496); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    char_literal183=(Token)match(input,29,FOLLOW_29_in_listOfSaveObjects3498); 
                    char_literal183_tree = 
                    (Object)adaptor.create(char_literal183)
                    ;
                    adaptor.addChild(root_0, char_literal183_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_listOfSaveObjects3504);
            idToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, idToken.getTree());


            if(!defer) {
                String sName = (String)null;
                if(null != nameToken) {
                    sName = (nameToken!=null?nameToken.getText():null);
                }
                interp.save(sName, (idToken!=null?idToken.objElement:null));
            }
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2073:4: ( ',' listOfSaveObjects[defer] )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==25) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2073:5: ',' listOfSaveObjects[defer]
                    {
                    char_literal184=(Token)match(input,25,FOLLOW_25_in_listOfSaveObjects3510); 
                    char_literal184_tree = 
                    (Object)adaptor.create(char_literal184)
                    ;
                    adaptor.addChild(root_0, char_literal184_tree);


                    pushFollow(FOLLOW_listOfSaveObjects_in_listOfSaveObjects3512);
                    listOfSaveObjects185=listOfSaveObjects(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, listOfSaveObjects185.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+idToken.start.getLine()+":"+idToken.start.getCharPositionInLine()+" => "+
                e.getMessage());
            this.cleanUp(1);	        
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfSaveObjects"


    public static class ifStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2085:1: ifStatement[boolean defer] : 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )? ;
    public final EugeneParser.ifStatement_return ifStatement(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.ifStatement_return retval = new EugeneParser.ifStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal186=null;
        Token char_literal187=null;
        Token char_literal188=null;
        Token char_literal189=null;
        Token char_literal190=null;
        Token string_literal191=null;
        Token string_literal192=null;
        Token char_literal193=null;
        Token char_literal194=null;
        Token char_literal195=null;
        Token char_literal196=null;
        Token string_literal197=null;
        Token char_literal198=null;
        Token char_literal199=null;
        EugeneParser.ifCondition_return ifConditionToken =null;

        EugeneParser.listOfStatements_return thenStmtToken =null;

        EugeneParser.ifCondition_return elseIfToken =null;

        EugeneParser.listOfStatements_return elseIfStmtToken =null;

        EugeneParser.listOfStatements_return elseStmtToken =null;


        Object string_literal186_tree=null;
        Object char_literal187_tree=null;
        Object char_literal188_tree=null;
        Object char_literal189_tree=null;
        Object char_literal190_tree=null;
        Object string_literal191_tree=null;
        Object string_literal192_tree=null;
        Object char_literal193_tree=null;
        Object char_literal194_tree=null;
        Object char_literal195_tree=null;
        Object char_literal196_tree=null;
        Object string_literal197_tree=null;
        Object char_literal198_tree=null;
        Object char_literal199_tree=null;


        ConditionalBranch objIfBranch = null;
        ArrayList<ConditionalBranch> lstElseIfStatements = null;
        ConditionalBranch objElseBranch = null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2092:2: ( 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2092:4: 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal186=(Token)match(input,79,FOLLOW_79_in_ifStatement3552); 
            string_literal186_tree = 
            (Object)adaptor.create(string_literal186)
            ;
            adaptor.addChild(root_0, string_literal186_tree);


            char_literal187=(Token)match(input,21,FOLLOW_21_in_ifStatement3554); 
            char_literal187_tree = 
            (Object)adaptor.create(char_literal187)
            ;
            adaptor.addChild(root_0, char_literal187_tree);


            pushFollow(FOLLOW_ifCondition_in_ifStatement3558);
            ifConditionToken=ifCondition(true);

            state._fsp--;

            adaptor.addChild(root_0, ifConditionToken.getTree());

            char_literal188=(Token)match(input,22,FOLLOW_22_in_ifStatement3561); 
            char_literal188_tree = 
            (Object)adaptor.create(char_literal188)
            ;
            adaptor.addChild(root_0, char_literal188_tree);


            char_literal189=(Token)match(input,97,FOLLOW_97_in_ifStatement3563); 
            char_literal189_tree = 
            (Object)adaptor.create(char_literal189)
            ;
            adaptor.addChild(root_0, char_literal189_tree);


            pushFollow(FOLLOW_listOfStatements_in_ifStatement3567);
            thenStmtToken=listOfStatements(true);

            state._fsp--;

            adaptor.addChild(root_0, thenStmtToken.getTree());

            char_literal190=(Token)match(input,99,FOLLOW_99_in_ifStatement3570); 
            char_literal190_tree = 
            (Object)adaptor.create(char_literal190)
            ;
            adaptor.addChild(root_0, char_literal190_tree);



            if(!defer) {
               objIfBranch = new ConditionalBranch((ifConditionToken!=null?((Token)ifConditionToken.start):null), (thenStmtToken!=null?((Token)thenStmtToken.start):null)); 
            }
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2097:17: ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==72) ) {
                    int LA72_1 = input.LA(2);

                    if ( (LA72_1==79) ) {
                        alt72=1;
                    }


                }


                switch (alt72) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2097:18: 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}'
            	    {
            	    string_literal191=(Token)match(input,72,FOLLOW_72_in_ifStatement3591); 
            	    string_literal191_tree = 
            	    (Object)adaptor.create(string_literal191)
            	    ;
            	    adaptor.addChild(root_0, string_literal191_tree);


            	    string_literal192=(Token)match(input,79,FOLLOW_79_in_ifStatement3593); 
            	    string_literal192_tree = 
            	    (Object)adaptor.create(string_literal192)
            	    ;
            	    adaptor.addChild(root_0, string_literal192_tree);


            	    char_literal193=(Token)match(input,21,FOLLOW_21_in_ifStatement3595); 
            	    char_literal193_tree = 
            	    (Object)adaptor.create(char_literal193)
            	    ;
            	    adaptor.addChild(root_0, char_literal193_tree);


            	    pushFollow(FOLLOW_ifCondition_in_ifStatement3599);
            	    elseIfToken=ifCondition(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, elseIfToken.getTree());

            	    char_literal194=(Token)match(input,22,FOLLOW_22_in_ifStatement3602); 
            	    char_literal194_tree = 
            	    (Object)adaptor.create(char_literal194)
            	    ;
            	    adaptor.addChild(root_0, char_literal194_tree);


            	    char_literal195=(Token)match(input,97,FOLLOW_97_in_ifStatement3604); 
            	    char_literal195_tree = 
            	    (Object)adaptor.create(char_literal195)
            	    ;
            	    adaptor.addChild(root_0, char_literal195_tree);


            	    pushFollow(FOLLOW_listOfStatements_in_ifStatement3608);
            	    elseIfStmtToken=listOfStatements(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, elseIfStmtToken.getTree());

            	    char_literal196=(Token)match(input,99,FOLLOW_99_in_ifStatement3611); 
            	    char_literal196_tree = 
            	    (Object)adaptor.create(char_literal196)
            	    ;
            	    adaptor.addChild(root_0, char_literal196_tree);



            	    if(!defer) {
            	        if(lstElseIfStatements == null) {
            	            lstElseIfStatements = new ArrayList<ConditionalBranch>();
            	        }
            	        ConditionalBranch objElseIfBranch = new ConditionalBranch((elseIfToken!=null?((Token)elseIfToken.start):null),(elseIfStmtToken!=null?((Token)elseIfStmtToken.start):null));
            	        lstElseIfStatements.add(objElseIfBranch);    
            	    }
            	            

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2106:3: ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==72) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2106:4: 'else' '{' elseStmtToken= listOfStatements[true] '}'
                    {
                    string_literal197=(Token)match(input,72,FOLLOW_72_in_ifStatement3620); 
                    string_literal197_tree = 
                    (Object)adaptor.create(string_literal197)
                    ;
                    adaptor.addChild(root_0, string_literal197_tree);


                    char_literal198=(Token)match(input,97,FOLLOW_97_in_ifStatement3622); 
                    char_literal198_tree = 
                    (Object)adaptor.create(char_literal198)
                    ;
                    adaptor.addChild(root_0, char_literal198_tree);


                    pushFollow(FOLLOW_listOfStatements_in_ifStatement3626);
                    elseStmtToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, elseStmtToken.getTree());

                    char_literal199=(Token)match(input,99,FOLLOW_99_in_ifStatement3629); 
                    char_literal199_tree = 
                    (Object)adaptor.create(char_literal199)
                    ;
                    adaptor.addChild(root_0, char_literal199_tree);



                    if(!defer) {
                        objElseBranch = new ConditionalBranch(null, (elseStmtToken!=null?((Token)elseStmtToken.start):null));
                    }
                            

                    }
                    break;

            }



            if(!defer) {
                // new version:
                IfStatement objIf = new IfStatement(
                    objIfBranch, 
                    lstElseIfStatements, 
                    objElseBranch);

                try {
                    this.executeIf(objIf);
                } catch(Exception e) {                	
                }
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ifStatement"


    public static class ifCondition_return extends ParserRuleReturnScope {
        public boolean b;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifCondition"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2128:1: ifCondition[boolean defer] returns [boolean b] : ( 'ON' deviceToken= ID ':' )? exprToken= expression[defer] ;
    public final EugeneParser.ifCondition_return ifCondition(boolean defer) throws RecognitionException {
        EugeneParser.ifCondition_return retval = new EugeneParser.ifCondition_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token deviceToken=null;
        Token string_literal200=null;
        Token char_literal201=null;
        EugeneParser.expression_return exprToken =null;


        Object deviceToken_tree=null;
        Object string_literal200_tree=null;
        Object char_literal201_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2129:2: ( ( 'ON' deviceToken= ID ':' )? exprToken= expression[defer] )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2129:4: ( 'ON' deviceToken= ID ':' )? exprToken= expression[defer]
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2129:4: ( 'ON' deviceToken= ID ':' )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==56) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2129:5: 'ON' deviceToken= ID ':'
                    {
                    string_literal200=(Token)match(input,56,FOLLOW_56_in_ifCondition3655); 
                    string_literal200_tree = 
                    (Object)adaptor.create(string_literal200)
                    ;
                    adaptor.addChild(root_0, string_literal200_tree);


                    deviceToken=(Token)match(input,ID,FOLLOW_ID_in_ifCondition3659); 
                    deviceToken_tree = 
                    (Object)adaptor.create(deviceToken)
                    ;
                    adaptor.addChild(root_0, deviceToken_tree);


                    char_literal201=(Token)match(input,29,FOLLOW_29_in_ifCondition3661); 
                    char_literal201_tree = 
                    (Object)adaptor.create(char_literal201)
                    ;
                    adaptor.addChild(root_0, char_literal201_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_ifCondition3667);
            exprToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {	    
                if(null!=(exprToken!=null?exprToken.objElement:null)) {	
                    if((exprToken!=null?exprToken.objElement:null) instanceof Rule) {
                        retval.b = RuleEngine.evaluateIfRule((Rule)(exprToken!=null?exprToken.objElement:null));
                    } else if((exprToken!=null?exprToken.objElement:null) instanceof Variable) {
                        retval.b = ((Variable)(exprToken!=null?exprToken.objElement:null)).getBoolean();
                    }
                }
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+" => "+
                e.getMessage());
            this.cleanUp(1);	        
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ifCondition"


    public static class loopStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "loopStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2160:1: loopStatement[boolean defer] : ( 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}' | 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}' | 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';' );
    public final EugeneParser.loopStatement_return loopStatement(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.loopStatement_return retval = new EugeneParser.loopStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal202=null;
        Token char_literal203=null;
        Token char_literal204=null;
        Token char_literal205=null;
        Token char_literal206=null;
        Token char_literal207=null;
        Token char_literal208=null;
        Token string_literal209=null;
        Token char_literal210=null;
        Token char_literal211=null;
        Token char_literal212=null;
        Token char_literal213=null;
        Token string_literal214=null;
        Token char_literal215=null;
        Token char_literal216=null;
        Token string_literal217=null;
        Token char_literal218=null;
        Token char_literal219=null;
        Token char_literal220=null;
        EugeneParser.forInit_return initToken =null;

        EugeneParser.expression_return condToken =null;

        EugeneParser.computationalStatement_return incToken =null;

        EugeneParser.listOfStatements_return forToken =null;

        EugeneParser.listOfStatements_return whileToken =null;


        Object string_literal202_tree=null;
        Object char_literal203_tree=null;
        Object char_literal204_tree=null;
        Object char_literal205_tree=null;
        Object char_literal206_tree=null;
        Object char_literal207_tree=null;
        Object char_literal208_tree=null;
        Object string_literal209_tree=null;
        Object char_literal210_tree=null;
        Object char_literal211_tree=null;
        Object char_literal212_tree=null;
        Object char_literal213_tree=null;
        Object string_literal214_tree=null;
        Object char_literal215_tree=null;
        Object char_literal216_tree=null;
        Object string_literal217_tree=null;
        Object char_literal218_tree=null;
        Object char_literal219_tree=null;
        Object char_literal220_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2162:6: ( 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}' | 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}' | 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';' )
            int alt75=3;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt75=1;
                }
                break;
            case 96:
                {
                alt75=2;
                }
                break;
            case 71:
                {
                alt75=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }

            switch (alt75) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2162:8: 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal202=(Token)match(input,76,FOLLOW_76_in_loopStatement3707); 
                    string_literal202_tree = 
                    (Object)adaptor.create(string_literal202)
                    ;
                    adaptor.addChild(root_0, string_literal202_tree);


                    char_literal203=(Token)match(input,21,FOLLOW_21_in_loopStatement3709); 
                    char_literal203_tree = 
                    (Object)adaptor.create(char_literal203)
                    ;
                    adaptor.addChild(root_0, char_literal203_tree);


                    pushFollow(FOLLOW_forInit_in_loopStatement3713);
                    initToken=forInit(true);

                    state._fsp--;

                    adaptor.addChild(root_0, initToken.getTree());

                    char_literal204=(Token)match(input,30,FOLLOW_30_in_loopStatement3716); 
                    char_literal204_tree = 
                    (Object)adaptor.create(char_literal204)
                    ;
                    adaptor.addChild(root_0, char_literal204_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement3727);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal205=(Token)match(input,30,FOLLOW_30_in_loopStatement3730); 
                    char_literal205_tree = 
                    (Object)adaptor.create(char_literal205)
                    ;
                    adaptor.addChild(root_0, char_literal205_tree);


                    pushFollow(FOLLOW_computationalStatement_in_loopStatement3741);
                    incToken=computationalStatement(true);

                    state._fsp--;

                    adaptor.addChild(root_0, incToken.getTree());

                    char_literal206=(Token)match(input,22,FOLLOW_22_in_loopStatement3744); 
                    char_literal206_tree = 
                    (Object)adaptor.create(char_literal206)
                    ;
                    adaptor.addChild(root_0, char_literal206_tree);


                    char_literal207=(Token)match(input,97,FOLLOW_97_in_loopStatement3746); 
                    char_literal207_tree = 
                    (Object)adaptor.create(char_literal207)
                    ;
                    adaptor.addChild(root_0, char_literal207_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement3758);
                    forToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, forToken.getTree());

                    char_literal208=(Token)match(input,99,FOLLOW_99_in_loopStatement3761); 
                    char_literal208_tree = 
                    (Object)adaptor.create(char_literal208)
                    ;
                    adaptor.addChild(root_0, char_literal208_tree);



                    if(!defer) {
                        forStat((initToken!=null?((Token)initToken.start):null), 
                            (condToken!=null?((Token)condToken.start):null), 
                            (incToken!=null?((Token)incToken.start):null), 
                            (forToken!=null?((Token)forToken.start):null));
                    }
                            

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2173:4: 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal209=(Token)match(input,96,FOLLOW_96_in_loopStatement3768); 
                    string_literal209_tree = 
                    (Object)adaptor.create(string_literal209)
                    ;
                    adaptor.addChild(root_0, string_literal209_tree);


                    char_literal210=(Token)match(input,21,FOLLOW_21_in_loopStatement3770); 
                    char_literal210_tree = 
                    (Object)adaptor.create(char_literal210)
                    ;
                    adaptor.addChild(root_0, char_literal210_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement3774);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal211=(Token)match(input,22,FOLLOW_22_in_loopStatement3777); 
                    char_literal211_tree = 
                    (Object)adaptor.create(char_literal211)
                    ;
                    adaptor.addChild(root_0, char_literal211_tree);


                    char_literal212=(Token)match(input,97,FOLLOW_97_in_loopStatement3779); 
                    char_literal212_tree = 
                    (Object)adaptor.create(char_literal212)
                    ;
                    adaptor.addChild(root_0, char_literal212_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement3783);
                    whileToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, whileToken.getTree());

                    char_literal213=(Token)match(input,99,FOLLOW_99_in_loopStatement3786); 
                    char_literal213_tree = 
                    (Object)adaptor.create(char_literal213)
                    ;
                    adaptor.addChild(root_0, char_literal213_tree);



                    if(!defer){
                        whileStat((condToken!=null?((Token)condToken.start):null), 
                            (whileToken!=null?((Token)whileToken.start):null));
                    }
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2179:4: 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal214=(Token)match(input,71,FOLLOW_71_in_loopStatement3793); 
                    string_literal214_tree = 
                    (Object)adaptor.create(string_literal214)
                    ;
                    adaptor.addChild(root_0, string_literal214_tree);


                    char_literal215=(Token)match(input,97,FOLLOW_97_in_loopStatement3795); 
                    char_literal215_tree = 
                    (Object)adaptor.create(char_literal215)
                    ;
                    adaptor.addChild(root_0, char_literal215_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement3799);
                    whileToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, whileToken.getTree());

                    char_literal216=(Token)match(input,99,FOLLOW_99_in_loopStatement3802); 
                    char_literal216_tree = 
                    (Object)adaptor.create(char_literal216)
                    ;
                    adaptor.addChild(root_0, char_literal216_tree);


                    string_literal217=(Token)match(input,96,FOLLOW_96_in_loopStatement3804); 
                    string_literal217_tree = 
                    (Object)adaptor.create(string_literal217)
                    ;
                    adaptor.addChild(root_0, string_literal217_tree);


                    char_literal218=(Token)match(input,21,FOLLOW_21_in_loopStatement3806); 
                    char_literal218_tree = 
                    (Object)adaptor.create(char_literal218)
                    ;
                    adaptor.addChild(root_0, char_literal218_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement3810);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal219=(Token)match(input,22,FOLLOW_22_in_loopStatement3813); 
                    char_literal219_tree = 
                    (Object)adaptor.create(char_literal219)
                    ;
                    adaptor.addChild(root_0, char_literal219_tree);


                    char_literal220=(Token)match(input,30,FOLLOW_30_in_loopStatement3814); 
                    char_literal220_tree = 
                    (Object)adaptor.create(char_literal220)
                    ;
                    adaptor.addChild(root_0, char_literal220_tree);



                    if(!defer){
                       whileStat((condToken!=null?((Token)condToken.start):null), 
                           (whileToken!=null?((Token)whileToken.start):null));
                    }
                            

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("[loopStatement] "+e.toString());
            e.printStackTrace();
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "loopStatement"


    public static class forInit_return extends ParserRuleReturnScope {
        public ArrayList<NamedElement> lstElements;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "forInit"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2193:1: forInit[boolean defer] returns [ArrayList<NamedElement> lstElements] : (declToken= variableDeclaration[defer] |exprToken= listOfExpressions[defer] );
    public final EugeneParser.forInit_return forInit(boolean defer) throws RecognitionException {
        EugeneParser.forInit_return retval = new EugeneParser.forInit_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.variableDeclaration_return declToken =null;

        EugeneParser.listOfExpressions_return exprToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2194:2: (declToken= variableDeclaration[defer] |exprToken= listOfExpressions[defer] )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==70||LA76_0==84||LA76_0==95) ) {
                alt76=1;
            }
            else if ( (LA76_0==FLOAT||LA76_0==ID||(LA76_0 >= INT && LA76_0 <= MINUS)||LA76_0==STRING||LA76_0==19||LA76_0==21||(LA76_0 >= 31 && LA76_0 <= 32)||(LA76_0 >= 34 && LA76_0 <= 37)||(LA76_0 >= 40 && LA76_0 <= 41)||(LA76_0 >= 45 && LA76_0 <= 46)||(LA76_0 >= 50 && LA76_0 <= 54)||(LA76_0 >= 63 && LA76_0 <= 65)||LA76_0==67||LA76_0==74||LA76_0==94) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;

            }
            switch (alt76) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2194:4: declToken= variableDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_variableDeclaration_in_forInit3842);
                    declToken=variableDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, declToken.getTree());


                    if(!defer) {
                        retval.lstElements = new ArrayList<NamedElement>((declToken!=null?declToken.lstVariables:null));
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2199:4: exprToken= listOfExpressions[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_listOfExpressions_in_forInit3852);
                    exprToken=listOfExpressions(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken.getTree());


                    if(!defer) {
                        retval.lstElements = (exprToken!=null?exprToken.lstElements:null);
                    }	
                            

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "forInit"


    public static class functionDeclaration_return extends ParserRuleReturnScope {
        public Function objFunction;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionDeclaration"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2209:1: functionDeclaration returns [Function objFunction] : 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}' ;
    public final EugeneParser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        EugeneParser.functionDeclaration_return retval = new EugeneParser.functionDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal221=null;
        Token char_literal222=null;
        Token char_literal223=null;
        Token char_literal224=null;
        Token char_literal225=null;
        EugeneParser.type_return returnTypeToken =null;

        EugeneParser.listOfFunctionParamenters_return lstParametersToken =null;

        EugeneParser.listOfStatements_return lstStatementsToken =null;


        Object nameToken_tree=null;
        Object string_literal221_tree=null;
        Object char_literal222_tree=null;
        Object char_literal223_tree=null;
        Object char_literal224_tree=null;
        Object char_literal225_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2210:2: ( 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2210:4: 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}'
            {
            root_0 = (Object)adaptor.nil();


            string_literal221=(Token)match(input,77,FOLLOW_77_in_functionDeclaration3877); 
            string_literal221_tree = 
            (Object)adaptor.create(string_literal221)
            ;
            adaptor.addChild(root_0, string_literal221_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2210:15: (returnTypeToken= type )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0 >= 42 && LA77_0 <= 43)||LA77_0==58||LA77_0==60||LA77_0==70||LA77_0==84||LA77_0==95) ) {
                alt77=1;
            }
            else if ( (LA77_0==ID) ) {
                int LA77_2 = input.LA(2);

                if ( (LA77_2==ID||LA77_2==67) ) {
                    alt77=1;
                }
            }
            switch (alt77) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2210:16: returnTypeToken= type
                    {
                    pushFollow(FOLLOW_type_in_functionDeclaration3882);
                    returnTypeToken=type();

                    state._fsp--;

                    adaptor.addChild(root_0, returnTypeToken.getTree());

                    }
                    break;

            }


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_functionDeclaration3888); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);



            if(null != interp.get((nameToken!=null?nameToken.getText():null))) {
                System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getText():null)+" => "+
                    "The "+(nameToken!=null?nameToken.getText():null)+" function has been declared already!");
                this.cleanUp(1);
            }
            	

            char_literal222=(Token)match(input,21,FOLLOW_21_in_functionDeclaration3892); 
            char_literal222_tree = 
            (Object)adaptor.create(char_literal222)
            ;
            adaptor.addChild(root_0, char_literal222_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2216:8: (lstParametersToken= listOfFunctionParamenters )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==ID||(LA78_0 >= 42 && LA78_0 <= 43)||LA78_0==58||LA78_0==60||LA78_0==70||LA78_0==84||LA78_0==95) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2216:9: lstParametersToken= listOfFunctionParamenters
                    {
                    pushFollow(FOLLOW_listOfFunctionParamenters_in_functionDeclaration3897);
                    lstParametersToken=listOfFunctionParamenters();

                    state._fsp--;

                    adaptor.addChild(root_0, lstParametersToken.getTree());

                    }
                    break;

            }


            char_literal223=(Token)match(input,22,FOLLOW_22_in_functionDeclaration3901); 
            char_literal223_tree = 
            (Object)adaptor.create(char_literal223)
            ;
            adaptor.addChild(root_0, char_literal223_tree);


            char_literal224=(Token)match(input,97,FOLLOW_97_in_functionDeclaration3903); 
            char_literal224_tree = 
            (Object)adaptor.create(char_literal224)
            ;
            adaptor.addChild(root_0, char_literal224_tree);


            pushFollow(FOLLOW_listOfStatements_in_functionDeclaration3911);
            lstStatementsToken=listOfStatements(true);

            state._fsp--;

            adaptor.addChild(root_0, lstStatementsToken.getTree());

            char_literal225=(Token)match(input,99,FOLLOW_99_in_functionDeclaration3916); 
            char_literal225_tree = 
            (Object)adaptor.create(char_literal225)
            ;
            adaptor.addChild(root_0, char_literal225_tree);



            retval.objFunction = new Function((nameToken!=null?nameToken.getText():null));
            if(null != returnTypeToken) {
                NamedElement objElement = this.createElement(
                        (returnTypeToken!=null?returnTypeToken.sType:null), (nameToken!=null?nameToken.getText():null)+"-RETURN-TYPE");
                retval.objFunction.setReturn(objElement);
            }

            retval.objFunction.setParameters((lstParametersToken!=null?lstParametersToken.lst:null));	
            retval.objFunction.setStatements((lstStatementsToken!=null?((Token)lstStatementsToken.start):null));

            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getCharPositionInLine():0)+" => "+e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionDeclaration"


    public static class type_return extends ParserRuleReturnScope {
        public String sType;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2236:1: type returns [String sType] : ( 'Collection' | 'Device' '[' ']' | 'Device' | 'Part' '[' ']' | 'Part' |idToken= ID '[' ']' |idToken= ID | 'Property' '[' ']' | 'Property' | 'num' '[' ']' | 'num' | 'txt' '[' ']' | 'txt' | 'boolean' );
    public final EugeneParser.type_return type() throws RecognitionException {
        EugeneParser.type_return retval = new EugeneParser.type_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token string_literal226=null;
        Token string_literal227=null;
        Token char_literal228=null;
        Token char_literal229=null;
        Token string_literal230=null;
        Token string_literal231=null;
        Token char_literal232=null;
        Token char_literal233=null;
        Token string_literal234=null;
        Token char_literal235=null;
        Token char_literal236=null;
        Token string_literal237=null;
        Token char_literal238=null;
        Token char_literal239=null;
        Token string_literal240=null;
        Token string_literal241=null;
        Token char_literal242=null;
        Token char_literal243=null;
        Token string_literal244=null;
        Token string_literal245=null;
        Token char_literal246=null;
        Token char_literal247=null;
        Token string_literal248=null;
        Token string_literal249=null;

        Object idToken_tree=null;
        Object string_literal226_tree=null;
        Object string_literal227_tree=null;
        Object char_literal228_tree=null;
        Object char_literal229_tree=null;
        Object string_literal230_tree=null;
        Object string_literal231_tree=null;
        Object char_literal232_tree=null;
        Object char_literal233_tree=null;
        Object string_literal234_tree=null;
        Object char_literal235_tree=null;
        Object char_literal236_tree=null;
        Object string_literal237_tree=null;
        Object char_literal238_tree=null;
        Object char_literal239_tree=null;
        Object string_literal240_tree=null;
        Object string_literal241_tree=null;
        Object char_literal242_tree=null;
        Object char_literal243_tree=null;
        Object string_literal244_tree=null;
        Object string_literal245_tree=null;
        Object char_literal246_tree=null;
        Object char_literal247_tree=null;
        Object string_literal248_tree=null;
        Object string_literal249_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2237:2: ( 'Collection' | 'Device' '[' ']' | 'Device' | 'Part' '[' ']' | 'Part' |idToken= ID '[' ']' |idToken= ID | 'Property' '[' ']' | 'Property' | 'num' '[' ']' | 'num' | 'txt' '[' ']' | 'txt' | 'boolean' )
            int alt79=14;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt79=1;
                }
                break;
            case 43:
                {
                int LA79_2 = input.LA(2);

                if ( (LA79_2==67) ) {
                    alt79=2;
                }
                else if ( (LA79_2==EOF||LA79_2==DYNAMIC_NAME||LA79_2==ID||LA79_2==20||LA79_2==22||LA79_2==25||(LA79_2 >= 29 && LA79_2 <= 30)||LA79_2==38||LA79_2==57||LA79_2==66||(LA79_2 >= 68 && LA79_2 <= 69)||LA79_2==98) ) {
                    alt79=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 2, input);

                    throw nvae;

                }
                }
                break;
            case 58:
                {
                int LA79_3 = input.LA(2);

                if ( (LA79_3==67) ) {
                    alt79=4;
                }
                else if ( (LA79_3==EOF||LA79_3==DYNAMIC_NAME||LA79_3==ID||LA79_3==20||LA79_3==22||LA79_3==25||(LA79_3 >= 29 && LA79_3 <= 30)||LA79_3==38||LA79_3==57||LA79_3==66||(LA79_3 >= 68 && LA79_3 <= 69)||LA79_3==98) ) {
                    alt79=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 3, input);

                    throw nvae;

                }
                }
                break;
            case ID:
                {
                int LA79_4 = input.LA(2);

                if ( (LA79_4==67) ) {
                    alt79=6;
                }
                else if ( (LA79_4==EOF||LA79_4==DYNAMIC_NAME||LA79_4==ID||LA79_4==20||LA79_4==22||LA79_4==25||(LA79_4 >= 29 && LA79_4 <= 30)||LA79_4==38||LA79_4==57||LA79_4==66||(LA79_4 >= 68 && LA79_4 <= 69)||LA79_4==98) ) {
                    alt79=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 4, input);

                    throw nvae;

                }
                }
                break;
            case 60:
                {
                int LA79_5 = input.LA(2);

                if ( (LA79_5==67) ) {
                    alt79=8;
                }
                else if ( (LA79_5==EOF||LA79_5==DYNAMIC_NAME||LA79_5==ID||LA79_5==20||LA79_5==22||LA79_5==25||(LA79_5 >= 29 && LA79_5 <= 30)||LA79_5==38||LA79_5==57||LA79_5==66||(LA79_5 >= 68 && LA79_5 <= 69)||LA79_5==98) ) {
                    alt79=9;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 5, input);

                    throw nvae;

                }
                }
                break;
            case 84:
                {
                int LA79_6 = input.LA(2);

                if ( (LA79_6==67) ) {
                    alt79=10;
                }
                else if ( (LA79_6==EOF||LA79_6==DYNAMIC_NAME||LA79_6==ID||LA79_6==20||LA79_6==22||LA79_6==25||(LA79_6 >= 29 && LA79_6 <= 30)||LA79_6==38||LA79_6==57||LA79_6==66||(LA79_6 >= 68 && LA79_6 <= 69)||LA79_6==98) ) {
                    alt79=11;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 6, input);

                    throw nvae;

                }
                }
                break;
            case 95:
                {
                int LA79_7 = input.LA(2);

                if ( (LA79_7==67) ) {
                    alt79=12;
                }
                else if ( (LA79_7==EOF||LA79_7==DYNAMIC_NAME||LA79_7==ID||LA79_7==20||LA79_7==22||LA79_7==25||(LA79_7 >= 29 && LA79_7 <= 30)||LA79_7==38||LA79_7==57||LA79_7==66||(LA79_7 >= 68 && LA79_7 <= 69)||LA79_7==98) ) {
                    alt79=13;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 7, input);

                    throw nvae;

                }
                }
                break;
            case 70:
                {
                alt79=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }

            switch (alt79) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2237:4: 'Collection'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal226=(Token)match(input,42,FOLLOW_42_in_type3939); 
                    string_literal226_tree = 
                    (Object)adaptor.create(string_literal226)
                    ;
                    adaptor.addChild(root_0, string_literal226_tree);



                    retval.sType =EugeneConstants.COLLECTION;	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2240:4: 'Device' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal227=(Token)match(input,43,FOLLOW_43_in_type3946); 
                    string_literal227_tree = 
                    (Object)adaptor.create(string_literal227)
                    ;
                    adaptor.addChild(root_0, string_literal227_tree);


                    char_literal228=(Token)match(input,67,FOLLOW_67_in_type3948); 
                    char_literal228_tree = 
                    (Object)adaptor.create(char_literal228)
                    ;
                    adaptor.addChild(root_0, char_literal228_tree);


                    char_literal229=(Token)match(input,68,FOLLOW_68_in_type3950); 
                    char_literal229_tree = 
                    (Object)adaptor.create(char_literal229)
                    ;
                    adaptor.addChild(root_0, char_literal229_tree);



                    retval.sType =EugeneConstants.DEVICEARRAY;	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2243:4: 'Device'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal230=(Token)match(input,43,FOLLOW_43_in_type3957); 
                    string_literal230_tree = 
                    (Object)adaptor.create(string_literal230)
                    ;
                    adaptor.addChild(root_0, string_literal230_tree);



                    retval.sType =EugeneConstants.DEVICE;	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2246:4: 'Part' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal231=(Token)match(input,58,FOLLOW_58_in_type3964); 
                    string_literal231_tree = 
                    (Object)adaptor.create(string_literal231)
                    ;
                    adaptor.addChild(root_0, string_literal231_tree);


                    char_literal232=(Token)match(input,67,FOLLOW_67_in_type3966); 
                    char_literal232_tree = 
                    (Object)adaptor.create(char_literal232)
                    ;
                    adaptor.addChild(root_0, char_literal232_tree);


                    char_literal233=(Token)match(input,68,FOLLOW_68_in_type3968); 
                    char_literal233_tree = 
                    (Object)adaptor.create(char_literal233)
                    ;
                    adaptor.addChild(root_0, char_literal233_tree);



                    retval.sType =EugeneConstants.PARTTYPEARRAY;	
                    	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2249:4: 'Part'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal234=(Token)match(input,58,FOLLOW_58_in_type3975); 
                    string_literal234_tree = 
                    (Object)adaptor.create(string_literal234)
                    ;
                    adaptor.addChild(root_0, string_literal234_tree);



                    retval.sType =EugeneConstants.PARTTYPE;	
                    	

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2252:4: idToken= ID '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_type3984); 
                    idToken_tree = 
                    (Object)adaptor.create(idToken)
                    ;
                    adaptor.addChild(root_0, idToken_tree);


                    char_literal235=(Token)match(input,67,FOLLOW_67_in_type3986); 
                    char_literal235_tree = 
                    (Object)adaptor.create(char_literal235)
                    ;
                    adaptor.addChild(root_0, char_literal235_tree);


                    char_literal236=(Token)match(input,68,FOLLOW_68_in_type3988); 
                    char_literal236_tree = 
                    (Object)adaptor.create(char_literal236)
                    ;
                    adaptor.addChild(root_0, char_literal236_tree);



                    retval.sType =EugeneConstants.PARTARRAY;	
                    	

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2255:4: idToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_type3997); 
                    idToken_tree = 
                    (Object)adaptor.create(idToken)
                    ;
                    adaptor.addChild(root_0, idToken_tree);



                    NamedElement objElement=interp.get((idToken!=null?idToken.getText():null));
                    if(objElement!=null && objElement instanceof Component) {
                        retval.sType =((Component)objElement).getName();
                    } else {
                        System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                            (idToken!=null?idToken.getText():null)+" is an invalid return type!");
                        this.cleanUp(1);
                    }
                    	

                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2265:4: 'Property' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal237=(Token)match(input,60,FOLLOW_60_in_type4004); 
                    string_literal237_tree = 
                    (Object)adaptor.create(string_literal237)
                    ;
                    adaptor.addChild(root_0, string_literal237_tree);


                    char_literal238=(Token)match(input,67,FOLLOW_67_in_type4006); 
                    char_literal238_tree = 
                    (Object)adaptor.create(char_literal238)
                    ;
                    adaptor.addChild(root_0, char_literal238_tree);


                    char_literal239=(Token)match(input,68,FOLLOW_68_in_type4008); 
                    char_literal239_tree = 
                    (Object)adaptor.create(char_literal239)
                    ;
                    adaptor.addChild(root_0, char_literal239_tree);



                    retval.sType =EugeneConstants.PROPERTYARRAY;	
                    	

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2268:4: 'Property'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal240=(Token)match(input,60,FOLLOW_60_in_type4015); 
                    string_literal240_tree = 
                    (Object)adaptor.create(string_literal240)
                    ;
                    adaptor.addChild(root_0, string_literal240_tree);



                    retval.sType =EugeneConstants.PROPERTY;	
                    	

                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2271:4: 'num' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal241=(Token)match(input,84,FOLLOW_84_in_type4022); 
                    string_literal241_tree = 
                    (Object)adaptor.create(string_literal241)
                    ;
                    adaptor.addChild(root_0, string_literal241_tree);


                    char_literal242=(Token)match(input,67,FOLLOW_67_in_type4024); 
                    char_literal242_tree = 
                    (Object)adaptor.create(char_literal242)
                    ;
                    adaptor.addChild(root_0, char_literal242_tree);


                    char_literal243=(Token)match(input,68,FOLLOW_68_in_type4026); 
                    char_literal243_tree = 
                    (Object)adaptor.create(char_literal243)
                    ;
                    adaptor.addChild(root_0, char_literal243_tree);



                    retval.sType =EugeneConstants.NUMLIST;	
                    	

                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2274:4: 'num'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal244=(Token)match(input,84,FOLLOW_84_in_type4033); 
                    string_literal244_tree = 
                    (Object)adaptor.create(string_literal244)
                    ;
                    adaptor.addChild(root_0, string_literal244_tree);



                    retval.sType =EugeneConstants.NUM;	
                    	

                    }
                    break;
                case 12 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2277:4: 'txt' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal245=(Token)match(input,95,FOLLOW_95_in_type4040); 
                    string_literal245_tree = 
                    (Object)adaptor.create(string_literal245)
                    ;
                    adaptor.addChild(root_0, string_literal245_tree);


                    char_literal246=(Token)match(input,67,FOLLOW_67_in_type4042); 
                    char_literal246_tree = 
                    (Object)adaptor.create(char_literal246)
                    ;
                    adaptor.addChild(root_0, char_literal246_tree);


                    char_literal247=(Token)match(input,68,FOLLOW_68_in_type4044); 
                    char_literal247_tree = 
                    (Object)adaptor.create(char_literal247)
                    ;
                    adaptor.addChild(root_0, char_literal247_tree);



                    retval.sType =EugeneConstants.TXTLIST;	
                    	

                    }
                    break;
                case 13 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2280:4: 'txt'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal248=(Token)match(input,95,FOLLOW_95_in_type4051); 
                    string_literal248_tree = 
                    (Object)adaptor.create(string_literal248)
                    ;
                    adaptor.addChild(root_0, string_literal248_tree);



                    retval.sType =EugeneConstants.TXT;	
                    	

                    }
                    break;
                case 14 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2283:4: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal249=(Token)match(input,70,FOLLOW_70_in_type4058); 
                    string_literal249_tree = 
                    (Object)adaptor.create(string_literal249)
                    ;
                    adaptor.addChild(root_0, string_literal249_tree);



                    retval.sType =EugeneConstants.BOOLEAN;	
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class listOfFunctionParamenters_return extends ParserRuleReturnScope {
        public ArrayList<NamedElement> lst;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfFunctionParamenters"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2288:1: listOfFunctionParamenters returns [ArrayList<NamedElement> lst] : paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )? ;
    public final EugeneParser.listOfFunctionParamenters_return listOfFunctionParamenters() throws RecognitionException {
        EugeneParser.listOfFunctionParamenters_return retval = new EugeneParser.listOfFunctionParamenters_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token paramNameToken=null;
        Token char_literal250=null;
        EugeneParser.type_return paramTypeToken =null;

        EugeneParser.listOfFunctionParamenters_return lstToken =null;


        Object paramNameToken_tree=null;
        Object char_literal250_tree=null;


        retval.lst =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2292:2: (paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2292:4: paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_type_in_listOfFunctionParamenters4082);
            paramTypeToken=type();

            state._fsp--;

            adaptor.addChild(root_0, paramTypeToken.getTree());

            paramNameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfFunctionParamenters4086); 
            paramNameToken_tree = 
            (Object)adaptor.create(paramNameToken)
            ;
            adaptor.addChild(root_0, paramNameToken_tree);


             
            NamedElement objParameter = this.createElement((paramTypeToken!=null?input.toString(paramTypeToken.start,paramTypeToken.stop):null),(paramNameToken!=null?paramNameToken.getText():null));
            if(objParameter!=null) {
                retval.lst.add(objParameter);
            }
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2297:4: ( ',' lstToken= listOfFunctionParamenters )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==25) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2297:5: ',' lstToken= listOfFunctionParamenters
                    {
                    char_literal250=(Token)match(input,25,FOLLOW_25_in_listOfFunctionParamenters4091); 
                    char_literal250_tree = 
                    (Object)adaptor.create(char_literal250)
                    ;
                    adaptor.addChild(root_0, char_literal250_tree);


                    pushFollow(FOLLOW_listOfFunctionParamenters_in_listOfFunctionParamenters4095);
                    lstToken=listOfFunctionParamenters();

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());


                    if(null!=lstToken) {
                        retval.lst.addAll((lstToken!=null?lstToken.lst:null));
                    }
                    	

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(paramNameToken!=null?paramNameToken.getLine():0)+":"+(paramNameToken!=null?paramNameToken.getCharPositionInLine():0)+" => "+e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfFunctionParamenters"


    public static class functionCall_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionCall"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2308:1: functionCall[boolean defer] returns [NamedElement objElement] : functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')' ;
    public final EugeneParser.functionCall_return functionCall(boolean defer) throws RecognitionException {
        EugeneParser.functionCall_return retval = new EugeneParser.functionCall_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token functionToken=null;
        Token char_literal251=null;
        Token char_literal252=null;
        EugeneParser.listOfParameterValues_return lstParametersToken =null;


        Object functionToken_tree=null;
        Object char_literal251_tree=null;
        Object char_literal252_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2309:2: (functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2309:4: functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            functionToken=(Token)match(input,ID,FOLLOW_ID_in_functionCall4126); 
            functionToken_tree = 
            (Object)adaptor.create(functionToken)
            ;
            adaptor.addChild(root_0, functionToken_tree);


            char_literal251=(Token)match(input,21,FOLLOW_21_in_functionCall4128); 
            char_literal251_tree = 
            (Object)adaptor.create(char_literal251)
            ;
            adaptor.addChild(root_0, char_literal251_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2309:25: (lstParametersToken= listOfParameterValues[defer] )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==FLOAT||LA81_0==ID||(LA81_0 >= INT && LA81_0 <= MINUS)||LA81_0==STRING||LA81_0==19||LA81_0==21||(LA81_0 >= 31 && LA81_0 <= 32)||(LA81_0 >= 34 && LA81_0 <= 37)||(LA81_0 >= 40 && LA81_0 <= 41)||(LA81_0 >= 45 && LA81_0 <= 46)||(LA81_0 >= 50 && LA81_0 <= 54)||(LA81_0 >= 63 && LA81_0 <= 65)||LA81_0==67||LA81_0==74||LA81_0==94) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2309:26: lstParametersToken= listOfParameterValues[defer]
                    {
                    pushFollow(FOLLOW_listOfParameterValues_in_functionCall4133);
                    lstParametersToken=listOfParameterValues(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstParametersToken.getTree());

                    }
                    break;

            }


            char_literal252=(Token)match(input,22,FOLLOW_22_in_functionCall4138); 
            char_literal252_tree = 
            (Object)adaptor.create(char_literal252)
            ;
            adaptor.addChild(root_0, char_literal252_tree);



            if(!defer) {
                // check if function is declared
                NamedElement objElement = interp.get((functionToken!=null?functionToken.getText():null));
                if(null==objElement) {
                    System.err.println("line "+(functionToken!=null?functionToken.getLine():0)+":"+(functionToken!=null?functionToken.getCharPositionInLine():0)+
                         " => I don't know anything about the function "+(functionToken!=null?functionToken.getText():null)+"!");
                    this.cleanUp(1);
                } else if(!(objElement instanceof Function)) {
                    System.err.println("line "+(functionToken!=null?functionToken.getLine():0)+":"+(functionToken!=null?functionToken.getCharPositionInLine():0)+
                         " => The "+(functionToken!=null?functionToken.getText():null)+" element is not a function!");
                    this.cleanUp(1);
                }
                
                retval.objElement = this.callFunction(
                        (Function)objElement,
                        (lstParametersToken!=null?lstParametersToken.lstParameterValues:null));
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+(functionToken!=null?functionToken.getLine():0)+":"+(functionToken!=null?functionToken.getCharPositionInLine():0)+" => "+e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionCall"


    public static class listOfParameterValues_return extends ParserRuleReturnScope {
        public ArrayList<NamedElement> lstParameterValues;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfParameterValues"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2334:1: listOfParameterValues[boolean defer] returns [ArrayList<NamedElement> lstParameterValues] : exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )? ;
    public final EugeneParser.listOfParameterValues_return listOfParameterValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfParameterValues_return retval = new EugeneParser.listOfParameterValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal253=null;
        EugeneParser.expression_return exprToken1 =null;

        EugeneParser.listOfParameterValues_return exprToken2 =null;


        Object char_literal253_tree=null;


        retval.lstParameterValues =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2338:2: (exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2338:4: exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfParameterValues4170);
            exprToken1=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken1.getTree());


            if(!defer) {
                if(null!=exprToken1) {
                    retval.lstParameterValues.add((exprToken1!=null?exprToken1.objElement:null));
                }
            }
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2344:5: ( ',' exprToken2= listOfParameterValues[defer] )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==25) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2344:6: ',' exprToken2= listOfParameterValues[defer]
                    {
                    char_literal253=(Token)match(input,25,FOLLOW_25_in_listOfParameterValues4177); 
                    char_literal253_tree = 
                    (Object)adaptor.create(char_literal253)
                    ;
                    adaptor.addChild(root_0, char_literal253_tree);


                    pushFollow(FOLLOW_listOfParameterValues_in_listOfParameterValues4181);
                    exprToken2=listOfParameterValues(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken2.getTree());


                    if(!defer) {
                        retval.lstParameterValues.addAll((exprToken2!=null?exprToken2.lstParameterValues:null));
                    }
                    	

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfParameterValues"


    public static class wrappedStatement_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "wrappedStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2354:1: wrappedStatement[boolean defer] returns [NamedElement objElement] : ( add[defer] |permuteToken= permuteStatement[defer] |productToken= productStatement[defer] |getToken= get[defer] |sizeToken= size[defer] |seqToken= toSequence[defer] |sbolToken= sbolStatement[defer] |genbankToken= genbankStatement[defer] );
    public final EugeneParser.wrappedStatement_return wrappedStatement(boolean defer) throws RecognitionException {
        EugeneParser.wrappedStatement_return retval = new EugeneParser.wrappedStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.permuteStatement_return permuteToken =null;

        EugeneParser.productStatement_return productToken =null;

        EugeneParser.get_return getToken =null;

        EugeneParser.size_return sizeToken =null;

        EugeneParser.toSequence_return seqToken =null;

        EugeneParser.sbolStatement_return sbolToken =null;

        EugeneParser.genbankStatement_return genbankToken =null;

        EugeneParser.add_return add254 =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2355:2: ( add[defer] |permuteToken= permuteStatement[defer] |productToken= productStatement[defer] |getToken= get[defer] |sizeToken= size[defer] |seqToken= toSequence[defer] |sbolToken= sbolStatement[defer] |genbankToken= genbankStatement[defer] )
            int alt83=8;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==27) ) {
                    alt83=1;
                }
                else if ( (LA83_1==26) ) {
                    switch ( input.LA(3) ) {
                    case 78:
                        {
                        alt83=4;
                        }
                        break;
                    case 91:
                        {
                        alt83=5;
                        }
                        break;
                    case 93:
                        {
                        alt83=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 7, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 1, input);

                    throw nvae;

                }
                }
                break;
            case 85:
                {
                alt83=2;
                }
                break;
            case 88:
                {
                alt83=3;
                }
                break;
            case 62:
                {
                alt83=7;
                }
                break;
            case 47:
                {
                alt83=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;

            }

            switch (alt83) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2355:4: add[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_add_in_wrappedStatement4206);
                    add254=add(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, add254.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2356:10: permuteToken= permuteStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_permuteStatement_in_wrappedStatement4221);
                    permuteToken=permuteStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, permuteToken.getTree());


                    if(!defer) {
                        retval.objElement = (permuteToken!=null?permuteToken.objDeviceArray:null);
                    }


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2361:10: productToken= productStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_productStatement_in_wrappedStatement4237);
                    productToken=productStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, productToken.getTree());


                    if(!defer) {
                        retval.objElement = (productToken!=null?productToken.objDeviceArray:null);
                    }


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2366:4: getToken= get[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_get_in_wrappedStatement4247);
                    getToken=get(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, getToken.getTree());


                    if(!defer) {
                        retval.objElement = (getToken!=null?getToken.objElement:null);
                    }	
                    	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2371:4: sizeToken= size[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_size_in_wrappedStatement4257);
                    sizeToken=size(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sizeToken.getTree());


                    if(!defer) {
                        Variable objVariable = interp.createVariable(null, EugeneConstants.NUM);
                        objVariable.setNum((sizeToken!=null?sizeToken.nSize:0.0));
                        retval.objElement = objVariable;
                    }	
                    	

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2378:4: seqToken= toSequence[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_toSequence_in_wrappedStatement4267);
                    seqToken=toSequence(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, seqToken.getTree());


                    if(!defer) {
                        Variable objVariable = new Variable("SEQUENCE",EugeneConstants.TXT);
                        objVariable.setTxt((seqToken!=null?seqToken.sequence:null));
                        retval.objElement = objVariable;
                    }
                    	

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2385:4: sbolToken= sbolStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_sbolStatement_in_wrappedStatement4277);
                    sbolToken=sbolStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolToken.getTree());


                    if(!defer) {
                        retval.objElement = sbolToken.objElement;
                    }	
                    	

                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2390:4: genbankToken= genbankStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_genbankStatement_in_wrappedStatement4287);
                    genbankToken=genbankStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankToken.getTree());


                    if(!defer) {
                        retval.objElement = genbankToken.objElement;
                    }	
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            e.printStackTrace();
            this.cleanUp(1);	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "wrappedStatement"


    public static class add_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "add"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2401:1: add[boolean defer] : componentToken= ID '.add' '(' lstAdd= listOfExpressions[defer] ')' ;
    public final EugeneParser.add_return add(boolean defer) throws RecognitionException {
        EugeneParser.add_return retval = new EugeneParser.add_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token componentToken=null;
        Token string_literal255=null;
        Token char_literal256=null;
        Token char_literal257=null;
        EugeneParser.listOfExpressions_return lstAdd =null;


        Object componentToken_tree=null;
        Object string_literal255_tree=null;
        Object char_literal256_tree=null;
        Object char_literal257_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2402:2: (componentToken= ID '.add' '(' lstAdd= listOfExpressions[defer] ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2402:4: componentToken= ID '.add' '(' lstAdd= listOfExpressions[defer] ')'
            {
            root_0 = (Object)adaptor.nil();


            componentToken=(Token)match(input,ID,FOLLOW_ID_in_add4311); 
            componentToken_tree = 
            (Object)adaptor.create(componentToken)
            ;
            adaptor.addChild(root_0, componentToken_tree);


            string_literal255=(Token)match(input,27,FOLLOW_27_in_add4313); 
            string_literal255_tree = 
            (Object)adaptor.create(string_literal255)
            ;
            adaptor.addChild(root_0, string_literal255_tree);


            char_literal256=(Token)match(input,21,FOLLOW_21_in_add4315); 
            char_literal256_tree = 
            (Object)adaptor.create(char_literal256)
            ;
            adaptor.addChild(root_0, char_literal256_tree);


            pushFollow(FOLLOW_listOfExpressions_in_add4319);
            lstAdd=listOfExpressions(defer);

            state._fsp--;

            adaptor.addChild(root_0, lstAdd.getTree());

            char_literal257=(Token)match(input,22,FOLLOW_22_in_add4322); 
            char_literal257_tree = 
            (Object)adaptor.create(char_literal257)
            ;
            adaptor.addChild(root_0, char_literal257_tree);



            if(!defer) {
                NamedElement objElement = interp.get((componentToken!=null?componentToken.getText():null)); 
                if(null==objElement) {
                    System.err.println("line "+(componentToken!=null?componentToken.getLine():0)+":"+(componentToken!=null?componentToken.getCharPositionInLine():0)+" => "+
                        "I don't know anything about "+(componentToken!=null?componentToken.getText():null));
                    this.cleanUp(1);
                } else {
                    if(objElement instanceof Component) {
                        Component objComponent = (Component)objElement;
                        
                        ArrayList<NamedElement> lstElements = (lstAdd!=null?lstAdd.lstElements:null);
                        for(int i=0; i<lstElements.size(); i++) {
                            NamedElement objAddElement = lstElements.get(i);
                            if(objAddElement instanceof Component) {
                                objComponent.add((Component)objAddElement);
                            } else {
                                System.err.println("line "+(componentToken!=null?componentToken.getLine():0)+":"+(componentToken!=null?componentToken.getCharPositionInLine():0)+" => "+
                                    objAddElement+" cannot be added to a Component!");
                                this.cleanUp(1);
                            }
                        }
                    } else if (objElement instanceof ComponentArray) {
                        ComponentArray objComponentArray = (ComponentArray)objElement;

                        ArrayList<NamedElement> lstElements = (lstAdd!=null?lstAdd.lstElements:null);
                        for(int i=0; i<lstElements.size(); i++) {
                            NamedElement objAddElement = lstElements.get(i);
                            if(objAddElement instanceof Component) {
                                objComponentArray.add((Component)objAddElement);
                            } else {
                                System.err.println("line "+(componentToken!=null?componentToken.getLine():0)+":"+(componentToken!=null?componentToken.getCharPositionInLine():0)+" => "+
                                    objAddElement+" cannot be added to the "+(componentToken!=null?componentToken.getText():null)+" array!");
                                this.cleanUp(1);
                            }
                        }
                    } else if (objElement instanceof Collection) {
                        Collection objCollection = (Collection)objElement;
                        if(null != (lstAdd!=null?lstAdd.lstElements:null)) {
                            Iterator<NamedElement> it = ((lstAdd!=null?lstAdd.lstElements:null)).iterator();
                            while(it.hasNext()) {
                                NamedElement objAddElement = it.next();
                                if(objAddElement instanceof CollectionElement) {
                                    objCollection.add((CollectionElement)objAddElement);
                                } else {
                                    System.err.println("line "+(componentToken!=null?componentToken.getLine():0)+":"+(componentToken!=null?componentToken.getCharPositionInLine():0)+" => "+
                                        objAddElement+" cannot be added to the "+(componentToken!=null?componentToken.getText():null)+" collection!");
                                    this.cleanUp(1);
                                }
                            }
                        }
                    } else {
                        System.err.println("line "+(componentToken!=null?componentToken.getLine():0)+":"+(componentToken!=null?componentToken.getCharPositionInLine():0)+" => "+
                            (componentToken!=null?componentToken.getText():null)+" does not have an ADD function!");
                        this.cleanUp(1);
                    }
                }
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (InvalidEugeneAssignmentException exc) {

            System.err.println("line "+(componentToken!=null?componentToken.getLine():0)+":"+(componentToken!=null?componentToken.getCharPositionInLine():0)+
                " => "+exc.toString());
            this.cleanUp(1);	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "add"


    public static class toSequence_return extends ParserRuleReturnScope {
        public String sequence;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "toSequence"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2468:1: toSequence[boolean defer] returns [String sequence] : idToken= ID '.' 'toSequence' '(' ')' ;
    public final EugeneParser.toSequence_return toSequence(boolean defer) throws RecognitionException {
        EugeneParser.toSequence_return retval = new EugeneParser.toSequence_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal258=null;
        Token string_literal259=null;
        Token char_literal260=null;
        Token char_literal261=null;

        Object idToken_tree=null;
        Object char_literal258_tree=null;
        Object string_literal259_tree=null;
        Object char_literal260_tree=null;
        Object char_literal261_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2469:2: (idToken= ID '.' 'toSequence' '(' ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2469:4: idToken= ID '.' 'toSequence' '(' ')'
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_toSequence4351); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal258=(Token)match(input,26,FOLLOW_26_in_toSequence4353); 
            char_literal258_tree = 
            (Object)adaptor.create(char_literal258)
            ;
            adaptor.addChild(root_0, char_literal258_tree);


            string_literal259=(Token)match(input,93,FOLLOW_93_in_toSequence4355); 
            string_literal259_tree = 
            (Object)adaptor.create(string_literal259)
            ;
            adaptor.addChild(root_0, string_literal259_tree);


            char_literal260=(Token)match(input,21,FOLLOW_21_in_toSequence4357); 
            char_literal260_tree = 
            (Object)adaptor.create(char_literal260)
            ;
            adaptor.addChild(root_0, char_literal260_tree);


            char_literal261=(Token)match(input,22,FOLLOW_22_in_toSequence4359); 
            char_literal261_tree = 
            (Object)adaptor.create(char_literal261)
            ;
            adaptor.addChild(root_0, char_literal261_tree);



            if(!defer) {
                NamedElement objElement = interp.get((idToken!=null?idToken.getText():null));
                if(null==objElement && objElement instanceof Component && !(objElement instanceof Property)) {
                    System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                        "The component "+(idToken!=null?idToken.getText():null)+" is not defined!");
                    this.cleanUp(1);
                }

                try {    
                    retval.sequence = ((Component)objElement).toSequence();
                } catch (EugeneException ex) {
                    Logger.getLogger(EugeneParser.class.getName()).log(Level.SEVERE, null, ex);
                    this.cleanUp(1);
                }
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "toSequence"


    public static class get_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "get"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2488:1: get[boolean defer] returns [NamedElement objElement] : idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')' ;
    public final EugeneParser.get_return get(boolean defer) throws RecognitionException {
        EugeneParser.get_return retval = new EugeneParser.get_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token idxToken=null;
        Token varToken=null;
        Token strToken=null;
        Token char_literal262=null;
        Token string_literal263=null;
        Token char_literal264=null;
        Token char_literal265=null;

        Object idToken_tree=null;
        Object idxToken_tree=null;
        Object varToken_tree=null;
        Object strToken_tree=null;
        Object char_literal262_tree=null;
        Object string_literal263_tree=null;
        Object char_literal264_tree=null;
        Object char_literal265_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2489:2: (idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2489:4: idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')'
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_get4379); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal262=(Token)match(input,26,FOLLOW_26_in_get4381); 
            char_literal262_tree = 
            (Object)adaptor.create(char_literal262)
            ;
            adaptor.addChild(root_0, char_literal262_tree);


            string_literal263=(Token)match(input,78,FOLLOW_78_in_get4383); 
            string_literal263_tree = 
            (Object)adaptor.create(string_literal263)
            ;
            adaptor.addChild(root_0, string_literal263_tree);


            char_literal264=(Token)match(input,21,FOLLOW_21_in_get4385); 
            char_literal264_tree = 
            (Object)adaptor.create(char_literal264)
            ;
            adaptor.addChild(root_0, char_literal264_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2489:29: (idxToken= INT |varToken= ID |strToken= STRING )
            int alt84=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt84=1;
                }
                break;
            case ID:
                {
                alt84=2;
                }
                break;
            case STRING:
                {
                alt84=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;

            }

            switch (alt84) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2489:30: idxToken= INT
                    {
                    idxToken=(Token)match(input,INT,FOLLOW_INT_in_get4390); 
                    idxToken_tree = 
                    (Object)adaptor.create(idxToken)
                    ;
                    adaptor.addChild(root_0, idxToken_tree);



                    if(!defer) {
                        retval.objElement = interp.get(
                                (idToken!=null?idToken.getText():null), 
                                Double.parseDouble((idxToken!=null?idxToken.getText():null)));
                    }
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2495:6: varToken= ID
                    {
                    varToken=(Token)match(input,ID,FOLLOW_ID_in_get4398); 
                    varToken_tree = 
                    (Object)adaptor.create(varToken)
                    ;
                    adaptor.addChild(root_0, varToken_tree);



                    if(!defer) {
                        retval.objElement = interp.get(
                                (idToken!=null?idToken.getText():null), 
                                (varToken!=null?varToken.getText():null));
                    }
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2501:6: strToken= STRING
                    {
                    strToken=(Token)match(input,STRING,FOLLOW_STRING_in_get4406); 
                    strToken_tree = 
                    (Object)adaptor.create(strToken)
                    ;
                    adaptor.addChild(root_0, strToken_tree);



                    if(!defer) {
                        retval.objElement = interp.get(
                                (idToken!=null?idToken.getText():null), 
                                (strToken!=null?strToken.getText():null).substring(1,(strToken!=null?strToken.getText():null).length()-1));
                    }
                    	

                    }
                    break;

            }


            char_literal265=(Token)match(input,22,FOLLOW_22_in_get4411); 
            char_literal265_tree = 
            (Object)adaptor.create(char_literal265)
            ;
            adaptor.addChild(root_0, char_literal265_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            this.cleanUp(1);        	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "get"


    public static class size_return extends ParserRuleReturnScope {
        public double nSize;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "size"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2554:1: size[boolean defer] returns [double nSize] : idToken= ID '.' 'size' '(' ')' ;
    public final EugeneParser.size_return size(boolean defer) throws RecognitionException {
        EugeneParser.size_return retval = new EugeneParser.size_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal266=null;
        Token string_literal267=null;
        Token char_literal268=null;
        Token char_literal269=null;

        Object idToken_tree=null;
        Object char_literal266_tree=null;
        Object string_literal267_tree=null;
        Object char_literal268_tree=null;
        Object char_literal269_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2555:2: (idToken= ID '.' 'size' '(' ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2555:4: idToken= ID '.' 'size' '(' ')'
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_size4444); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal266=(Token)match(input,26,FOLLOW_26_in_size4446); 
            char_literal266_tree = 
            (Object)adaptor.create(char_literal266)
            ;
            adaptor.addChild(root_0, char_literal266_tree);


            string_literal267=(Token)match(input,91,FOLLOW_91_in_size4448); 
            string_literal267_tree = 
            (Object)adaptor.create(string_literal267)
            ;
            adaptor.addChild(root_0, string_literal267_tree);


            char_literal268=(Token)match(input,21,FOLLOW_21_in_size4450); 
            char_literal268_tree = 
            (Object)adaptor.create(char_literal268)
            ;
            adaptor.addChild(root_0, char_literal268_tree);


            char_literal269=(Token)match(input,22,FOLLOW_22_in_size4452); 
            char_literal269_tree = 
            (Object)adaptor.create(char_literal269)
            ;
            adaptor.addChild(root_0, char_literal269_tree);



            if(!defer) {
                retval.nSize = interp.sizeOf((idToken!=null?idToken.getText():null));
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            this.cleanUp(1);        	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "size"


    public static class listOfRules_return extends ParserRuleReturnScope {
        public ArrayList<Rule> lstRules;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfRules"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2622:1: listOfRules[boolean defer] returns [ArrayList<Rule> lstRules] : idToken= ID ( ',' idToken= ID )* ;
    public final EugeneParser.listOfRules_return listOfRules(boolean defer) throws RecognitionException {
        EugeneParser.listOfRules_return retval = new EugeneParser.listOfRules_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal270=null;

        Object idToken_tree=null;
        Object char_literal270_tree=null;


        retval.lstRules = new ArrayList<Rule>();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2627:2: (idToken= ID ( ',' idToken= ID )* )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2627:4: idToken= ID ( ',' idToken= ID )*
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfRules4490); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);



            if(!defer) {    
                NamedElement objElement = interp.get((idToken!=null?idToken.getText():null));
                if(objElement==null) {
                    System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                        "I don't know anything about " + (idToken!=null?idToken.getText():null) + "!");
                    this.cleanUp(1);
                }
                if(!(objElement instanceof Rule)) {
                    System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                        "The "+(idToken!=null?idToken.getText():null)+" component is not a Eugene rule!");
                    this.cleanUp(1);
                }
                retval.lstRules.add((Rule)objElement);
            }	
            	

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2642:4: ( ',' idToken= ID )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==25) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2642:5: ',' idToken= ID
            	    {
            	    char_literal270=(Token)match(input,25,FOLLOW_25_in_listOfRules4495); 
            	    char_literal270_tree = 
            	    (Object)adaptor.create(char_literal270)
            	    ;
            	    adaptor.addChild(root_0, char_literal270_tree);


            	    idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfRules4499); 
            	    idToken_tree = 
            	    (Object)adaptor.create(idToken)
            	    ;
            	    adaptor.addChild(root_0, idToken_tree);



            	    if(!defer) {
            	        NamedElement objElement = interp.get((idToken!=null?idToken.getText():null));
            	        if(objElement==null) {
            	            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
            	                "I don't know anything about " + (idToken!=null?idToken.getText():null) + "!");
            	            this.cleanUp(1);
            	        }
            	        if(!(objElement instanceof Rule)) {
            	            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
            	                "The "+(idToken!=null?idToken.getText():null)+" component is not a Eugene rule!");
            	            this.cleanUp(1);
            	        }
            	        retval.lstRules.add((Rule)objElement);
            	    }	
            	    	

            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listOfRules"


    public static class permuteStatement_return extends ParserRuleReturnScope {
        public DeviceArray objDeviceArray;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "permuteStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2663:1: permuteStatement[boolean defer] returns [DeviceArray objDeviceArray] : permToken= 'permute' '(' deviceToken= expressionValue[defer] ( ',' valueToken= expressionValue[defer] )? ( ',' degreeToken= ( 'strict' | 'flexible' ) )? ')' ;
    public final EugeneParser.permuteStatement_return permuteStatement(boolean defer) throws RecognitionException {
        EugeneParser.permuteStatement_return retval = new EugeneParser.permuteStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token permToken=null;
        Token degreeToken=null;
        Token char_literal271=null;
        Token char_literal272=null;
        Token char_literal273=null;
        Token char_literal274=null;
        EugeneParser.expressionValue_return deviceToken =null;

        EugeneParser.expressionValue_return valueToken =null;


        Object permToken_tree=null;
        Object degreeToken_tree=null;
        Object char_literal271_tree=null;
        Object char_literal272_tree=null;
        Object char_literal273_tree=null;
        Object char_literal274_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2664:6: (permToken= 'permute' '(' deviceToken= expressionValue[defer] ( ',' valueToken= expressionValue[defer] )? ( ',' degreeToken= ( 'strict' | 'flexible' ) )? ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2664:11: permToken= 'permute' '(' deviceToken= expressionValue[defer] ( ',' valueToken= expressionValue[defer] )? ( ',' degreeToken= ( 'strict' | 'flexible' ) )? ')'
            {
            root_0 = (Object)adaptor.nil();


            permToken=(Token)match(input,85,FOLLOW_85_in_permuteStatement4532); 
            permToken_tree = 
            (Object)adaptor.create(permToken)
            ;
            adaptor.addChild(root_0, permToken_tree);


            char_literal271=(Token)match(input,21,FOLLOW_21_in_permuteStatement4534); 
            char_literal271_tree = 
            (Object)adaptor.create(char_literal271)
            ;
            adaptor.addChild(root_0, char_literal271_tree);


            pushFollow(FOLLOW_expressionValue_in_permuteStatement4546);
            deviceToken=expressionValue(defer);

            state._fsp--;

            adaptor.addChild(root_0, deviceToken.getTree());

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2666:8: ( ',' valueToken= expressionValue[defer] )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==25) ) {
                int LA86_1 = input.LA(2);

                if ( (LA86_1==FLOAT||LA86_1==ID||(LA86_1 >= INT && LA86_1 <= MINUS)||LA86_1==STRING||LA86_1==21||LA86_1==67||LA86_1==74||LA86_1==94) ) {
                    alt86=1;
                }
            }
            switch (alt86) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2666:9: ',' valueToken= expressionValue[defer]
                    {
                    char_literal272=(Token)match(input,25,FOLLOW_25_in_permuteStatement4558); 
                    char_literal272_tree = 
                    (Object)adaptor.create(char_literal272)
                    ;
                    adaptor.addChild(root_0, char_literal272_tree);


                    pushFollow(FOLLOW_expressionValue_in_permuteStatement4562);
                    valueToken=expressionValue(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, valueToken.getTree());

                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2667:8: ( ',' degreeToken= ( 'strict' | 'flexible' ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==25) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2667:9: ',' degreeToken= ( 'strict' | 'flexible' )
                    {
                    char_literal273=(Token)match(input,25,FOLLOW_25_in_permuteStatement4576); 
                    char_literal273_tree = 
                    (Object)adaptor.create(char_literal273)
                    ;
                    adaptor.addChild(root_0, char_literal273_tree);


                    degreeToken=(Token)input.LT(1);

                    if ( input.LA(1)==75||input.LA(1)==92 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(degreeToken)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            char_literal274=(Token)match(input,22,FOLLOW_22_in_permuteStatement4588); 
            char_literal274_tree = 
            (Object)adaptor.create(char_literal274)
            ;
            adaptor.addChild(root_0, char_literal274_tree);



            if(!defer) {
                retval.objDeviceArray = interp.generateDevices(
                        EugeneConstants.PERMUTE,
                        (deviceToken!=null?deviceToken.objElement:null), 
                        (valueToken!=null?valueToken.objElement:null), 
                        (degreeToken!=null?degreeToken.getText():null));
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(permToken!=null?permToken.getLine():0)+":"+(permToken!=null?permToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            this.cleanUp(1);
                	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "permuteStatement"


    public static class productStatement_return extends ParserRuleReturnScope {
        public DeviceArray objDeviceArray;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "productStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2684:1: productStatement[boolean defer] returns [DeviceArray objDeviceArray] : productToken= 'product' '(' deviceToken= expressionValue[defer] ( ',' valueToken= expressionValue[defer] )? ( ',' (degreeToken= ( 'strict' | 'flexible' ) ) )? ')' ;
    public final EugeneParser.productStatement_return productStatement(boolean defer) throws RecognitionException {
        EugeneParser.productStatement_return retval = new EugeneParser.productStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token productToken=null;
        Token degreeToken=null;
        Token char_literal275=null;
        Token char_literal276=null;
        Token char_literal277=null;
        Token char_literal278=null;
        EugeneParser.expressionValue_return deviceToken =null;

        EugeneParser.expressionValue_return valueToken =null;


        Object productToken_tree=null;
        Object degreeToken_tree=null;
        Object char_literal275_tree=null;
        Object char_literal276_tree=null;
        Object char_literal277_tree=null;
        Object char_literal278_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2685:6: (productToken= 'product' '(' deviceToken= expressionValue[defer] ( ',' valueToken= expressionValue[defer] )? ( ',' (degreeToken= ( 'strict' | 'flexible' ) ) )? ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2685:11: productToken= 'product' '(' deviceToken= expressionValue[defer] ( ',' valueToken= expressionValue[defer] )? ( ',' (degreeToken= ( 'strict' | 'flexible' ) ) )? ')'
            {
            root_0 = (Object)adaptor.nil();


            productToken=(Token)match(input,88,FOLLOW_88_in_productStatement4631); 
            productToken_tree = 
            (Object)adaptor.create(productToken)
            ;
            adaptor.addChild(root_0, productToken_tree);


            char_literal275=(Token)match(input,21,FOLLOW_21_in_productStatement4633); 
            char_literal275_tree = 
            (Object)adaptor.create(char_literal275)
            ;
            adaptor.addChild(root_0, char_literal275_tree);


            pushFollow(FOLLOW_expressionValue_in_productStatement4637);
            deviceToken=expressionValue(defer);

            state._fsp--;

            adaptor.addChild(root_0, deviceToken.getTree());

            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2686:18: ( ',' valueToken= expressionValue[defer] )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==25) ) {
                int LA88_1 = input.LA(2);

                if ( (LA88_1==FLOAT||LA88_1==ID||(LA88_1 >= INT && LA88_1 <= MINUS)||LA88_1==STRING||LA88_1==21||LA88_1==67||LA88_1==74||LA88_1==94) ) {
                    alt88=1;
                }
            }
            switch (alt88) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2686:19: ',' valueToken= expressionValue[defer]
                    {
                    char_literal276=(Token)match(input,25,FOLLOW_25_in_productStatement4677); 
                    char_literal276_tree = 
                    (Object)adaptor.create(char_literal276)
                    ;
                    adaptor.addChild(root_0, char_literal276_tree);


                    pushFollow(FOLLOW_expressionValue_in_productStatement4681);
                    valueToken=expressionValue(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, valueToken.getTree());

                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2687:18: ( ',' (degreeToken= ( 'strict' | 'flexible' ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==25) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2687:19: ',' (degreeToken= ( 'strict' | 'flexible' ) )
                    {
                    char_literal277=(Token)match(input,25,FOLLOW_25_in_productStatement4705); 
                    char_literal277_tree = 
                    (Object)adaptor.create(char_literal277)
                    ;
                    adaptor.addChild(root_0, char_literal277_tree);


                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2687:23: (degreeToken= ( 'strict' | 'flexible' ) )
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2687:24: degreeToken= ( 'strict' | 'flexible' )
                    {
                    degreeToken=(Token)input.LT(1);

                    if ( input.LA(1)==75||input.LA(1)==92 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(degreeToken)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }


                    }
                    break;

            }


            char_literal278=(Token)match(input,22,FOLLOW_22_in_productStatement4719); 
            char_literal278_tree = 
            (Object)adaptor.create(char_literal278)
            ;
            adaptor.addChild(root_0, char_literal278_tree);



            if(!defer) {
                retval.objDeviceArray = interp.generateDevices(
                        EugeneConstants.PRODUCT,
                        (deviceToken!=null?deviceToken.objElement:null), 
                        (valueToken!=null?valueToken.objElement:null), 
                        (degreeToken!=null?degreeToken.getText():null));
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(productToken!=null?productToken.getLine():0)+":"+(productToken!=null?productToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            this.cleanUp(1);
                	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "productStatement"


    public static class getObject_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "getObject"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2703:1: getObject[NamedElement objElement] : ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )* ;
    public final EugeneParser.getObject_return getObject(NamedElement objElement) throws RecognitionException {
        EugeneParser.getObject_return retval = new EugeneParser.getObject_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token elementToken=null;
        Token char_literal279=null;
        Token char_literal280=null;
        Token char_literal281=null;
        EugeneParser.expression_return exprToken =null;


        Object elementToken_tree=null;
        Object char_literal279_tree=null;
        Object char_literal280_tree=null;
        Object char_literal281_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2704:2: ( ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )* )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2704:4: ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )*
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2704:4: ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )*
            loop90:
            do {
                int alt90=3;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==26) ) {
                    alt90=1;
                }
                else if ( (LA90_0==67) ) {
                    alt90=2;
                }


                switch (alt90) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2704:5: ( '.' elementToken= ID )
            	    {
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2704:5: ( '.' elementToken= ID )
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2704:6: '.' elementToken= ID
            	    {
            	    char_literal279=(Token)match(input,26,FOLLOW_26_in_getObject4749); 
            	    char_literal279_tree = 
            	    (Object)adaptor.create(char_literal279)
            	    ;
            	    adaptor.addChild(root_0, char_literal279_tree);


            	    elementToken=(Token)match(input,ID,FOLLOW_ID_in_getObject4753); 
            	    elementToken_tree = 
            	    (Object)adaptor.create(elementToken)
            	    ;
            	    adaptor.addChild(root_0, elementToken_tree);


            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2704:29: ( '[' exprToken= expression[true] ']' )
            	    {
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2704:29: ( '[' exprToken= expression[true] ']' )
            	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2704:30: '[' exprToken= expression[true] ']'
            	    {
            	    char_literal280=(Token)match(input,67,FOLLOW_67_in_getObject4759); 
            	    char_literal280_tree = 
            	    (Object)adaptor.create(char_literal280)
            	    ;
            	    adaptor.addChild(root_0, char_literal280_tree);


            	    pushFollow(FOLLOW_expression_in_getObject4763);
            	    exprToken=expression(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, exprToken.getTree());

            	    char_literal281=(Token)match(input,68,FOLLOW_68_in_getObject4766); 
            	    char_literal281_tree = 
            	    (Object)adaptor.create(char_literal281)
            	    ;
            	    adaptor.addChild(root_0, char_literal281_tree);


            	    }


            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "getObject"


    public static class printStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "printStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2742:1: printStatement[boolean defer] : (| 'println' '(' ')' | 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' | 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' );
    public final EugeneParser.printStatement_return printStatement(boolean defer) throws RecognitionException {
        EugeneParser.printStatement_return retval = new EugeneParser.printStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal282=null;
        Token char_literal283=null;
        Token char_literal284=null;
        Token string_literal285=null;
        Token char_literal286=null;
        Token char_literal287=null;
        Token char_literal288=null;
        Token string_literal289=null;
        Token char_literal290=null;
        Token char_literal291=null;
        Token char_literal292=null;
        EugeneParser.whatToPrint_return printToken1 =null;

        EugeneParser.whatToPrint_return printToken2 =null;


        Object string_literal282_tree=null;
        Object char_literal283_tree=null;
        Object char_literal284_tree=null;
        Object string_literal285_tree=null;
        Object char_literal286_tree=null;
        Object char_literal287_tree=null;
        Object char_literal288_tree=null;
        Object string_literal289_tree=null;
        Object char_literal290_tree=null;
        Object char_literal291_tree=null;
        Object char_literal292_tree=null;


        System.err.flush();
        System.out.flush();

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2750:2: (| 'println' '(' ')' | 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' | 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' )
            int alt93=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt93=1;
                }
                break;
            case 87:
                {
                int LA93_2 = input.LA(2);

                if ( (LA93_2==21) ) {
                    int LA93_4 = input.LA(3);

                    if ( (LA93_4==22) ) {
                        alt93=2;
                    }
                    else if ( (LA93_4==FLOAT||LA93_4==ID||(LA93_4 >= INT && LA93_4 <= MINUS)||LA93_4==STRING||LA93_4==19||LA93_4==21||(LA93_4 >= 31 && LA93_4 <= 32)||(LA93_4 >= 34 && LA93_4 <= 37)||(LA93_4 >= 40 && LA93_4 <= 41)||(LA93_4 >= 45 && LA93_4 <= 47)||(LA93_4 >= 50 && LA93_4 <= 54)||(LA93_4 >= 62 && LA93_4 <= 65)||LA93_4==67||LA93_4==74||LA93_4==85||LA93_4==88||LA93_4==94) ) {
                        alt93=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 93, 4, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 93, 2, input);

                    throw nvae;

                }
                }
                break;
            case 86:
                {
                alt93=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;

            }

            switch (alt93) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2751:9: 
                    {
                    root_0 = (Object)adaptor.nil();


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2751:11: 'println' '(' ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal282=(Token)match(input,87,FOLLOW_87_in_printStatement4809); 
                    string_literal282_tree = 
                    (Object)adaptor.create(string_literal282)
                    ;
                    adaptor.addChild(root_0, string_literal282_tree);


                    char_literal283=(Token)match(input,21,FOLLOW_21_in_printStatement4811); 
                    char_literal283_tree = 
                    (Object)adaptor.create(char_literal283)
                    ;
                    adaptor.addChild(root_0, char_literal283_tree);


                    char_literal284=(Token)match(input,22,FOLLOW_22_in_printStatement4813); 
                    char_literal284_tree = 
                    (Object)adaptor.create(char_literal284)
                    ;
                    adaptor.addChild(root_0, char_literal284_tree);



                    if(!defer) {
                            System.out.println();
                    }
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2756:11: 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal285=(Token)match(input,86,FOLLOW_86_in_printStatement4827); 
                    string_literal285_tree = 
                    (Object)adaptor.create(string_literal285)
                    ;
                    adaptor.addChild(root_0, string_literal285_tree);


                    char_literal286=(Token)match(input,21,FOLLOW_21_in_printStatement4829); 
                    char_literal286_tree = 
                    (Object)adaptor.create(char_literal286)
                    ;
                    adaptor.addChild(root_0, char_literal286_tree);


                    pushFollow(FOLLOW_whatToPrint_in_printStatement4833);
                    printToken1=whatToPrint(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printToken1.getTree());


                    if(!defer) {        
                        System.out.print((printToken1!=null?printToken1.s:null));
                    }
                            

                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2760:11: ( ',' printToken2= whatToPrint[defer] )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==25) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2760:12: ',' printToken2= whatToPrint[defer]
                    	    {
                    	    char_literal287=(Token)match(input,25,FOLLOW_25_in_printStatement4839); 
                    	    char_literal287_tree = 
                    	    (Object)adaptor.create(char_literal287)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal287_tree);


                    	    pushFollow(FOLLOW_whatToPrint_in_printStatement4843);
                    	    printToken2=whatToPrint(defer);

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, printToken2.getTree());


                    	    if(!defer) {                
                    	        System.out.print((printToken2!=null?printToken2.s:null));
                    	    }	
                    	    	

                    	    }
                    	    break;

                    	default :
                    	    break loop91;
                        }
                    } while (true);


                    char_literal288=(Token)match(input,22,FOLLOW_22_in_printStatement4850); 
                    char_literal288_tree = 
                    (Object)adaptor.create(char_literal288)
                    ;
                    adaptor.addChild(root_0, char_literal288_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2765:11: 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal289=(Token)match(input,87,FOLLOW_87_in_printStatement4862); 
                    string_literal289_tree = 
                    (Object)adaptor.create(string_literal289)
                    ;
                    adaptor.addChild(root_0, string_literal289_tree);


                    char_literal290=(Token)match(input,21,FOLLOW_21_in_printStatement4864); 
                    char_literal290_tree = 
                    (Object)adaptor.create(char_literal290)
                    ;
                    adaptor.addChild(root_0, char_literal290_tree);


                    pushFollow(FOLLOW_whatToPrint_in_printStatement4868);
                    printToken1=whatToPrint(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printToken1.getTree());


                    if(!defer) {        
                        System.out.print((printToken1!=null?printToken1.s:null));
                    }
                            

                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2769:11: ( ',' printToken2= whatToPrint[defer] )*
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==25) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2769:12: ',' printToken2= whatToPrint[defer]
                    	    {
                    	    char_literal291=(Token)match(input,25,FOLLOW_25_in_printStatement4874); 
                    	    char_literal291_tree = 
                    	    (Object)adaptor.create(char_literal291)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal291_tree);


                    	    pushFollow(FOLLOW_whatToPrint_in_printStatement4878);
                    	    printToken2=whatToPrint(defer);

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, printToken2.getTree());


                    	    if(!defer) {                
                    	        System.out.print((printToken2!=null?printToken2.s:null));
                    	    }	
                    	    	

                    	    }
                    	    break;

                    	default :
                    	    break loop92;
                        }
                    } while (true);


                    char_literal292=(Token)match(input,22,FOLLOW_22_in_printStatement4885); 
                    char_literal292_tree = 
                    (Object)adaptor.create(char_literal292)
                    ;
                    adaptor.addChild(root_0, char_literal292_tree);



                    if(!defer) {        
                        System.out.println();
                    }
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


            System.out.flush();

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "printStatement"


    public static class whatToPrint_return extends ParserRuleReturnScope {
        public String s;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "whatToPrint"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2780:1: whatToPrint[boolean defer] returns [String s] : (valueToken= expression[defer] |wrapperToken= wrappedStatement[defer] );
    public final EugeneParser.whatToPrint_return whatToPrint(boolean defer) throws RecognitionException {
        EugeneParser.whatToPrint_return retval = new EugeneParser.whatToPrint_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.expression_return valueToken =null;

        EugeneParser.wrappedStatement_return wrapperToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2781:2: (valueToken= expression[defer] |wrapperToken= wrappedStatement[defer] )
            int alt94=2;
            switch ( input.LA(1) ) {
            case FLOAT:
            case INT:
            case MINUS:
            case STRING:
            case 19:
            case 21:
            case 31:
            case 32:
            case 34:
            case 35:
            case 36:
            case 37:
            case 40:
            case 41:
            case 45:
            case 46:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 63:
            case 64:
            case 65:
            case 67:
            case 74:
            case 94:
                {
                alt94=1;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case 27:
                    {
                    alt94=2;
                    }
                    break;
                case 26:
                    {
                    switch ( input.LA(3) ) {
                    case 78:
                        {
                        int LA94_5 = input.LA(4);

                        if ( (LA94_5==21) ) {
                            switch ( input.LA(5) ) {
                            case INT:
                                {
                                int LA94_11 = input.LA(6);

                                if ( (LA94_11==22) ) {
                                    alt94=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 94, 11, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case ID:
                                {
                                int LA94_12 = input.LA(6);

                                if ( (LA94_12==22) ) {
                                    alt94=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 94, 12, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case STRING:
                                {
                                int LA94_13 = input.LA(6);

                                if ( (LA94_13==22) ) {
                                    alt94=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 94, 13, input);

                                    throw nvae;

                                }
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 94, 8, input);

                                throw nvae;

                            }

                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 94, 5, input);

                            throw nvae;

                        }
                        }
                        break;
                    case 91:
                        {
                        int LA94_6 = input.LA(4);

                        if ( (LA94_6==21) ) {
                            int LA94_9 = input.LA(5);

                            if ( (LA94_9==22) ) {
                                alt94=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 94, 9, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 94, 6, input);

                            throw nvae;

                        }
                        }
                        break;
                    case 93:
                        {
                        int LA94_7 = input.LA(4);

                        if ( (LA94_7==21) ) {
                            int LA94_10 = input.LA(5);

                            if ( (LA94_10==22) ) {
                                alt94=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 94, 10, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 94, 7, input);

                            throw nvae;

                        }
                        }
                        break;
                    case ID:
                    case 82:
                    case 83:
                        {
                        alt94=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 94, 4, input);

                        throw nvae;

                    }

                    }
                    break;
                case MINUS:
                case 19:
                case 20:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 31:
                case 32:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 40:
                case 41:
                case 45:
                case 46:
                case 48:
                case 50:
                case 51:
                case 52:
                case 54:
                case 57:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 69:
                case 80:
                case 81:
                case 98:
                    {
                    alt94=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 94, 2, input);

                    throw nvae;

                }

                }
                break;
            case 47:
            case 62:
            case 85:
            case 88:
                {
                alt94=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;

            }

            switch (alt94) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2781:4: valueToken= expression[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_expression_in_whatToPrint4906);
                    valueToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, valueToken.getTree());


                    if(!defer) {
                        if((valueToken!=null?valueToken.objElement:null)!=null) {
                            retval.s = (valueToken!=null?valueToken.objElement:null).toString();
                        } else {
                            retval.s = new String();
                        }
                    }
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2790:4: wrapperToken= wrappedStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_wrappedStatement_in_whatToPrint4916);
                    wrapperToken=wrappedStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, wrapperToken.getTree());


                    if(!defer) {
                        NamedElement objElement = (wrapperToken!=null?wrapperToken.objElement:null);
                        if(objElement!=null) {
                            retval.s = objElement.toString();
                        }
                    }	
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "whatToPrint"


    public static class dataExtraction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dataExtraction"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2802:1: dataExtraction[boolean defer] : ( sbolStatement[defer] | genbankStatement[defer] );
    public final EugeneParser.dataExtraction_return dataExtraction(boolean defer) throws RecognitionException {
        EugeneParser.dataExtraction_return retval = new EugeneParser.dataExtraction_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.sbolStatement_return sbolStatement293 =null;

        EugeneParser.genbankStatement_return genbankStatement294 =null;



        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2803:2: ( sbolStatement[defer] | genbankStatement[defer] )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==62) ) {
                alt95=1;
            }
            else if ( (LA95_0==47) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;

            }
            switch (alt95) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2803:4: sbolStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_sbolStatement_in_dataExtraction4935);
                    sbolStatement293=sbolStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolStatement293.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2804:4: genbankStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_genbankStatement_in_dataExtraction4941);
                    genbankStatement294=genbankStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankStatement294.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dataExtraction"


    public static class sbolStatement_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sbolStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2808:1: sbolStatement[boolean defer] returns [NamedElement objElement] : 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] ) ;
    public final EugeneParser.sbolStatement_return sbolStatement(boolean defer) throws RecognitionException {
        EugeneParser.sbolStatement_return retval = new EugeneParser.sbolStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal295=null;
        Token char_literal296=null;
        EugeneParser.sbolImportStatement_return importToken =null;

        EugeneParser.sbolExportStatement_return sbolExportStatement297 =null;


        Object string_literal295_tree=null;
        Object char_literal296_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2809:2: ( 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] ) )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2809:4: 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] )
            {
            root_0 = (Object)adaptor.nil();


            string_literal295=(Token)match(input,62,FOLLOW_62_in_sbolStatement4961); 
            string_literal295_tree = 
            (Object)adaptor.create(string_literal295)
            ;
            adaptor.addChild(root_0, string_literal295_tree);


            char_literal296=(Token)match(input,26,FOLLOW_26_in_sbolStatement4963); 
            char_literal296_tree = 
            (Object)adaptor.create(char_literal296)
            ;
            adaptor.addChild(root_0, char_literal296_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2809:15: ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==73) ) {
                alt96=1;
            }
            else if ( (LA96_0==80) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;

            }
            switch (alt96) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2809:16: sbolExportStatement[defer]
                    {
                    pushFollow(FOLLOW_sbolExportStatement_in_sbolStatement4966);
                    sbolExportStatement297=sbolExportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolExportStatement297.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2809:45: importToken= sbolImportStatement[defer]
                    {
                    pushFollow(FOLLOW_sbolImportStatement_in_sbolStatement4973);
                    importToken=sbolImportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, importToken.getTree());

                    }
                    break;

            }



            if(!defer && importToken!=null) {
                retval.objElement = (importToken!=null?importToken.objElement:null);
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sbolStatement"


    public static class sbolExportStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sbolExportStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2816:1: sbolExportStatement[boolean defer] : 'export' '(' idToken= ID ',' filenameToken= STRING ')' ;
    public final EugeneParser.sbolExportStatement_return sbolExportStatement(boolean defer) throws RecognitionException {
        EugeneParser.sbolExportStatement_return retval = new EugeneParser.sbolExportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token filenameToken=null;
        Token string_literal298=null;
        Token char_literal299=null;
        Token char_literal300=null;
        Token char_literal301=null;

        Object idToken_tree=null;
        Object filenameToken_tree=null;
        Object string_literal298_tree=null;
        Object char_literal299_tree=null;
        Object char_literal300_tree=null;
        Object char_literal301_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2817:2: ( 'export' '(' idToken= ID ',' filenameToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2817:4: 'export' '(' idToken= ID ',' filenameToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal298=(Token)match(input,73,FOLLOW_73_in_sbolExportStatement4990); 
            string_literal298_tree = 
            (Object)adaptor.create(string_literal298)
            ;
            adaptor.addChild(root_0, string_literal298_tree);


            char_literal299=(Token)match(input,21,FOLLOW_21_in_sbolExportStatement4992); 
            char_literal299_tree = 
            (Object)adaptor.create(char_literal299)
            ;
            adaptor.addChild(root_0, char_literal299_tree);


            idToken=(Token)match(input,ID,FOLLOW_ID_in_sbolExportStatement4996); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal300=(Token)match(input,25,FOLLOW_25_in_sbolExportStatement4998); 
            char_literal300_tree = 
            (Object)adaptor.create(char_literal300)
            ;
            adaptor.addChild(root_0, char_literal300_tree);


            filenameToken=(Token)match(input,STRING,FOLLOW_STRING_in_sbolExportStatement5002); 
            filenameToken_tree = 
            (Object)adaptor.create(filenameToken)
            ;
            adaptor.addChild(root_0, filenameToken_tree);


            char_literal301=(Token)match(input,22,FOLLOW_22_in_sbolExportStatement5004); 
            char_literal301_tree = 
            (Object)adaptor.create(char_literal301)
            ;
            adaptor.addChild(root_0, char_literal301_tree);



            if(!defer) {
                interp.exportToSBOL(
                        (idToken!=null?idToken.getText():null), 
                        (filenameToken!=null?filenameToken.getText():null).substring(1, (filenameToken!=null?filenameToken.getText():null).length()-1));
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+
                " => "+e.getMessage());	
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sbolExportStatement"


    public static class sbolImportStatement_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sbolImportStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2831:1: sbolImportStatement[boolean defer] returns [NamedElement objElement] : 'import' '(' fileToken= STRING ')' ;
    public final EugeneParser.sbolImportStatement_return sbolImportStatement(boolean defer) throws RecognitionException {
        EugeneParser.sbolImportStatement_return retval = new EugeneParser.sbolImportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token fileToken=null;
        Token string_literal302=null;
        Token char_literal303=null;
        Token char_literal304=null;

        Object fileToken_tree=null;
        Object string_literal302_tree=null;
        Object char_literal303_tree=null;
        Object char_literal304_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2833:2: ( 'import' '(' fileToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2833:4: 'import' '(' fileToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal302=(Token)match(input,80,FOLLOW_80_in_sbolImportStatement5033); 
            string_literal302_tree = 
            (Object)adaptor.create(string_literal302)
            ;
            adaptor.addChild(root_0, string_literal302_tree);


            char_literal303=(Token)match(input,21,FOLLOW_21_in_sbolImportStatement5035); 
            char_literal303_tree = 
            (Object)adaptor.create(char_literal303)
            ;
            adaptor.addChild(root_0, char_literal303_tree);


            fileToken=(Token)match(input,STRING,FOLLOW_STRING_in_sbolImportStatement5039); 
            fileToken_tree = 
            (Object)adaptor.create(fileToken)
            ;
            adaptor.addChild(root_0, fileToken_tree);


            char_literal304=(Token)match(input,22,FOLLOW_22_in_sbolImportStatement5041); 
            char_literal304_tree = 
            (Object)adaptor.create(char_literal304)
            ;
            adaptor.addChild(root_0, char_literal304_tree);



            if(!defer) {
                retval.objElement = interp.importSBOL((fileToken!=null?fileToken.getText():null));
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+(fileToken!=null?fileToken.getLine():0)+":"+(fileToken!=null?fileToken.getCharPositionInLine():0)+
                " => "+e.getMessage());	
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sbolImportStatement"


    public static class genbankStatement_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "genbankStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2845:1: genbankStatement[boolean defer] returns [NamedElement objElement] : 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] ) ;
    public final EugeneParser.genbankStatement_return genbankStatement(boolean defer) throws RecognitionException {
        EugeneParser.genbankStatement_return retval = new EugeneParser.genbankStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal305=null;
        Token char_literal306=null;
        EugeneParser.genbankImportStatement_return importToken =null;

        EugeneParser.genbankExportStatement_return genbankExportStatement307 =null;


        Object string_literal305_tree=null;
        Object char_literal306_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2846:2: ( 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] ) )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2846:4: 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] )
            {
            root_0 = (Object)adaptor.nil();


            string_literal305=(Token)match(input,47,FOLLOW_47_in_genbankStatement5067); 
            string_literal305_tree = 
            (Object)adaptor.create(string_literal305)
            ;
            adaptor.addChild(root_0, string_literal305_tree);


            char_literal306=(Token)match(input,26,FOLLOW_26_in_genbankStatement5069); 
            char_literal306_tree = 
            (Object)adaptor.create(char_literal306)
            ;
            adaptor.addChild(root_0, char_literal306_tree);


            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2846:18: (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==80) ) {
                alt97=1;
            }
            else if ( (LA97_0==73) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;

            }
            switch (alt97) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2846:19: importToken= genbankImportStatement[defer]
                    {
                    pushFollow(FOLLOW_genbankImportStatement_in_genbankStatement5074);
                    importToken=genbankImportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, importToken.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2846:63: genbankExportStatement[defer]
                    {
                    pushFollow(FOLLOW_genbankExportStatement_in_genbankStatement5079);
                    genbankExportStatement307=genbankExportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankExportStatement307.getTree());

                    }
                    break;

            }



            if(!defer && importToken!=null) {
                retval.objElement = (importToken!=null?importToken.objElement:null);
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "genbankStatement"


    public static class genbankExportStatement_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "genbankExportStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2853:1: genbankExportStatement[boolean defer] returns [NamedElement objElement] : 'export' '(' ')' ;
    public final EugeneParser.genbankExportStatement_return genbankExportStatement(boolean defer) throws RecognitionException {
        EugeneParser.genbankExportStatement_return retval = new EugeneParser.genbankExportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal308=null;
        Token char_literal309=null;
        Token char_literal310=null;

        Object string_literal308_tree=null;
        Object char_literal309_tree=null;
        Object char_literal310_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2854:2: ( 'export' '(' ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2854:4: 'export' '(' ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal308=(Token)match(input,73,FOLLOW_73_in_genbankExportStatement5102); 
            string_literal308_tree = 
            (Object)adaptor.create(string_literal308)
            ;
            adaptor.addChild(root_0, string_literal308_tree);


            char_literal309=(Token)match(input,21,FOLLOW_21_in_genbankExportStatement5104); 
            char_literal309_tree = 
            (Object)adaptor.create(char_literal309)
            ;
            adaptor.addChild(root_0, char_literal309_tree);


            char_literal310=(Token)match(input,22,FOLLOW_22_in_genbankExportStatement5106); 
            char_literal310_tree = 
            (Object)adaptor.create(char_literal310)
            ;
            adaptor.addChild(root_0, char_literal310_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "genbankExportStatement"


    public static class genbankImportStatement_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "genbankImportStatement"
    // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2857:1: genbankImportStatement[boolean defer] returns [NamedElement objElement] : 'import' '(' typeToken= ID ',' partToken= STRING ')' ;
    public final EugeneParser.genbankImportStatement_return genbankImportStatement(boolean defer) throws RecognitionException {
        EugeneParser.genbankImportStatement_return retval = new EugeneParser.genbankImportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token typeToken=null;
        Token partToken=null;
        Token string_literal311=null;
        Token char_literal312=null;
        Token char_literal313=null;
        Token char_literal314=null;

        Object typeToken_tree=null;
        Object partToken_tree=null;
        Object string_literal311_tree=null;
        Object char_literal312_tree=null;
        Object char_literal313_tree=null;
        Object char_literal314_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2858:2: ( 'import' '(' typeToken= ID ',' partToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/coding/workspace/eugene-v1.8.1/grammar/Eugene.g:2858:4: 'import' '(' typeToken= ID ',' partToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal311=(Token)match(input,80,FOLLOW_80_in_genbankImportStatement5123); 
            string_literal311_tree = 
            (Object)adaptor.create(string_literal311)
            ;
            adaptor.addChild(root_0, string_literal311_tree);


            char_literal312=(Token)match(input,21,FOLLOW_21_in_genbankImportStatement5125); 
            char_literal312_tree = 
            (Object)adaptor.create(char_literal312)
            ;
            adaptor.addChild(root_0, char_literal312_tree);


            typeToken=(Token)match(input,ID,FOLLOW_ID_in_genbankImportStatement5129); 
            typeToken_tree = 
            (Object)adaptor.create(typeToken)
            ;
            adaptor.addChild(root_0, typeToken_tree);


            char_literal313=(Token)match(input,25,FOLLOW_25_in_genbankImportStatement5131); 
            char_literal313_tree = 
            (Object)adaptor.create(char_literal313)
            ;
            adaptor.addChild(root_0, char_literal313_tree);


            partToken=(Token)match(input,STRING,FOLLOW_STRING_in_genbankImportStatement5135); 
            partToken_tree = 
            (Object)adaptor.create(partToken)
            ;
            adaptor.addChild(root_0, partToken_tree);


            char_literal314=(Token)match(input,22,FOLLOW_22_in_genbankImportStatement5137); 
            char_literal314_tree = 
            (Object)adaptor.create(char_literal314)
            ;
            adaptor.addChild(root_0, char_literal314_tree);



            if(!defer) {    
                // check if the part type exists
                NamedElement objElement = interp.get((typeToken!=null?typeToken.getText():null));
                if(objElement==null) {
                    System.err.println("line "+(typeToken!=null?typeToken.getLine():0)+":"+(typeToken!=null?typeToken.getCharPositionInLine():0)+" => "+
                        "I don't know the part type "+(typeToken!=null?typeToken.getText():null));
                    this.cleanUp(1);
                } else if(!(objElement instanceof PartType)) {
                    System.err.println("line "+(typeToken!=null?typeToken.getLine():0)+":"+(typeToken!=null?typeToken.getCharPositionInLine():0)+" => "+
                        "The element "+(typeToken!=null?typeToken.getText():null)+" is not a part type!");
                    this.cleanUp(1);
                } 
                
                try {
                    retval.objElement = GenbankImporter.importPart((PartType)objElement, (partToken!=null?partToken.getText():null));
                } catch(Exception e ){
                    System.err.println("line "+(typeToken!=null?typeToken.getLine():0)+":"+(typeToken!=null?typeToken.getCharPositionInLine():0)+" => "+
                        "Somehting went wrong while importing part "+(partToken!=null?partToken.getText():null)+"!");
                    retval.objElement = null;
                }
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(partToken!=null?partToken.getLine():0)+":"+(partToken!=null?partToken.getCharPositionInLine():0)+" => "+
                "I cannot import the "+(partToken!=null?partToken.getText():null)+" part!");
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "genbankImportStatement"

    // Delegated rules


 

    public static final BitSet FOLLOW_eugeneStatement_in_prog56 = new BitSet(new long[]{0x7C829C8040001800L,0x0000000187F1B0C0L});
    public static final BitSet FOLLOW_EOF_in_prog59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_eugeneStatement70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_eugeneStatement78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_statement117 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importStatement_in_statement124 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarationStatement_in_statement134 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computationalStatement_in_statement144 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_printStatement_in_statement152 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertStatement_in_statement166 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_noteStatement_in_statement176 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wrappedStatement_in_statement186 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loopStatement_in_statement200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statement208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saveStatement_in_statement216 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_statement219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_computationalStatement232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectAssignmentStatement_in_computationalStatement240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_computationalStatement249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataExtraction_in_computationalStatement257 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_computationalStatement260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_assignment282 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_assignment286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_assignment295 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_functionCall_in_assignment299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_assignment314 = new BitSet(new long[]{0x4000800000000800L,0x0000000001200000L});
    public static final BitSet FOLLOW_wrappedStatement_in_assignment318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_assignment333 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_assignment335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_assignment349 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_MINUS_in_assignment351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_importStatement369 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_importStatement373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filename_in_listOfFilenames398 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfFilenames402 = new BitSet(new long[]{0xFFFFFFFFBFDFFFF0L,0x0000000FFFFFFFFFL});
    public static final BitSet FOLLOW_listOfFilenames_in_listOfFilenames404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_filename426 = new BitSet(new long[]{0xFFFFFFFFBDDFFFF2L,0x0000000FFFFFFFFFL});
    public static final BitSet FOLLOW_collectionDeclaration_in_declarationStatement460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_declarationStatement466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_declarationStatement472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_declarationStatement478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_declarationStatement484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayDeclaration_in_declarationStatement490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_declarationStatement496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_imageDeclaration_in_declarationStatement502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceTypeDeclaration_in_declarationStatement508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_collectionDeclaration537 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_collectionDeclaration541 = new BitSet(new long[]{0x0000000201204002L});
    public static final BitSet FOLLOW_collectionDefinition_in_collectionDeclaration551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_collectionDeclaration564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_collectionDefinition612 = new BitSet(new long[]{0x1C00080000000800L});
    public static final BitSet FOLLOW_listOfCollectionComponents_in_collectionDefinition619 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_collectionDefinition625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_collectionDefinition632 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_INCLUDE_in_collectionDefinition636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionElement_in_listOfCollectionComponents682 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfCollectionComponents688 = new BitSet(new long[]{0x1C00080000000800L});
    public static final BitSet FOLLOW_listOfCollectionComponents_in_listOfCollectionComponents692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_collectionElement730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_collectionElement738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_collectionElement755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_collectionElement765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_collectionElement782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_propertyDeclaration800 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_dynamicNaming_in_propertyDeclaration804 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_propertyDeclaration807 = new BitSet(new long[]{0x0000000000000000L,0x0000000080100040L});
    public static final BitSet FOLLOW_propertyType_in_propertyDeclaration811 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_propertyDeclaration813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_propertyType832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_propertyType837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_propertyType839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_propertyType841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_propertyType846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_propertyType851 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_propertyType853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_propertyType855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_propertyType860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyType_in_variableDeclaration884 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfVariables_in_variableDeclaration888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfVariables916 = new BitSet(new long[]{0x0000000203004002L});
    public static final BitSet FOLLOW_assignment_in_listOfVariables928 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfVariables937 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfVariables_in_listOfVariables941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_partTypeDeclaration974 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_partTypeDeclaration983 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_partTypeDeclaration986 = new BitSet(new long[]{0x0000000000400800L});
    public static final BitSet FOLLOW_listOfIDs_in_partTypeDeclaration991 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_partTypeDeclaration996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_partTypeDeclaration1012 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_partTypeDeclaration1020 = new BitSet(new long[]{0x0000000201004000L});
    public static final BitSet FOLLOW_assignment_in_partTypeDeclaration1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfIDs1058 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfIDs1063 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_listOfIDs1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_deviceDeclaration1098 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_deviceDeclaration1102 = new BitSet(new long[]{0x0000000201204002L});
    public static final BitSet FOLLOW_21_in_deviceDeclaration1106 = new BitSet(new long[]{0x0C00080000616A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_deviceComponents_in_deviceDeclaration1111 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_deviceDeclaration1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_deviceDeclaration1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionValue_in_deviceComponents1173 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_deviceComponents1184 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_deviceComponents1194 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_deviceComponents1204 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_deviceComponents1212 = new BitSet(new long[]{0x0C00080000216A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_deviceComponents_in_deviceComponents1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_deviceTypeDeclaration1242 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_deviceTypeDeclaration1246 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceTypeDeclaration1248 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_deviceTypeDeclaration1252 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_deviceTypeDeclaration1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayType_in_arrayDeclaration1290 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_arrayDeclaration1294 = new BitSet(new long[]{0x0000000201004002L});
    public static final BitSet FOLLOW_assignment_in_arrayDeclaration1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_arrayType1324 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_arrayType1326 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_arrayType1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_arrayType1333 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_arrayType1335 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_arrayType1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_arrayType1342 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_arrayType1344 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_arrayType1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_arrayType1351 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_arrayType1353 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_arrayType1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_arrayType1360 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_arrayType1362 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_arrayType1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayType1369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_arrayType1371 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_arrayType1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleDeclaration1389 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_ruleDeclaration1393 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclaration1395 = new BitSet(new long[]{0x817C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_56_in_ruleDeclaration1398 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_ruleDeclaration1402 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclaration1404 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_ruleDeclaration1410 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleDeclaration1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_onDeviceRule1468 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_onDeviceRule1472 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_onDeviceRule1474 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_onDeviceRule1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_imageDeclaration1503 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_imageDeclaration1505 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_imageDeclaration1509 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_imageDeclaration1511 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_imageDeclaration1515 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_imageDeclaration1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_assertStatement1538 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assertStatement1540 = new BitSet(new long[]{0x0100000000400800L});
    public static final BitSet FOLLOW_56_in_assertStatement1543 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_assertStatement1547 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_assertStatement1550 = new BitSet(new long[]{0x0000000000400800L});
    public static final BitSet FOLLOW_listOfIDs_in_assertStatement1556 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_assertStatement1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_noteStatement1593 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_noteStatement1595 = new BitSet(new long[]{0x0100000000400800L});
    public static final BitSet FOLLOW_56_in_noteStatement1598 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_noteStatement1602 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_noteStatement1605 = new BitSet(new long[]{0x0000000000400800L});
    public static final BitSet FOLLOW_listOfIDs_in_noteStatement1611 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_noteStatement1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_instantiationStatement1654 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_instanceDefinitionStatement_in_instantiationStatement1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partInstantiation_in_instanceDefinitionStatement1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceInstantiation_in_instanceDefinitionStatement1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_dynamicNaming1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DYNAMIC_NAME_in_dynamicNaming1734 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_dynamicNaming1738 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_DYNAMIC_NAME_in_dynamicNaming1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dynamicNaming_in_partInstantiation1771 = new BitSet(new long[]{0x0000000201204002L});
    public static final BitSet FOLLOW_21_in_partInstantiation1776 = new BitSet(new long[]{0x807C633D84696A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_listOfDotValues_in_partInstantiation1781 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_listOfValues_in_partInstantiation1788 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_partInstantiation1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_partInstantiation1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_deviceInstantiation1838 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_deviceInstantiation1841 = new BitSet(new long[]{0x0000000000400800L});
    public static final BitSet FOLLOW_listOfIDs_in_deviceInstantiation1846 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_deviceInstantiation1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_listOfDotValues1889 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfDotValues1893 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_listOfDotValues1895 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_listOfDotValues1899 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_listOfDotValues1902 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfDotValues1908 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_listOfDotValues_in_listOfDotValues1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfValues1953 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfValues1959 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_listOfValues_in_listOfValues1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfExpressions1995 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfExpressions2002 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_listOfExpressions_in_listOfExpressions2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notExpression_in_expression2040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_notExpression2077 = new BitSet(new long[]{0x805C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_orExpression_in_notExpression2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpression_in_notExpression2107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpression_in_orExpression2135 = new BitSet(new long[]{0x0200000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_57_in_orExpression2151 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_98_in_orExpression2153 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_notExpression_in_orExpression2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xorExpression_in_andExpression2207 = new BitSet(new long[]{0x0000004000100002L});
    public static final BitSet FOLLOW_38_in_andExpression2223 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_20_in_andExpression2225 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_notExpression_in_andExpression2230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparativeExpression_in_xorExpression2280 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000024L});
    public static final BitSet FOLLOW_66_in_xorExpression2296 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_69_in_xorExpression2298 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_notExpression_in_xorExpression2303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalOperator_in_operator2349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_operator2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOperator2378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOperator2385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleOperator2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleOperator2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleOperator2406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleOperator2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOperator2420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOperator2427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOperator2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleOperator2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relationalOperator2458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relationalOperator2471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_relationalOperator2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_relationalOperator2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_relationalOperator2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_relationalOperator2507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addExpression_in_comparativeExpression2533 = new BitSet(new long[]{0x805D633D80080002L,0x0000000000020003L});
    public static final BitSet FOLLOW_operator_in_comparativeExpression2550 = new BitSet(new long[]{0x805C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_comparativeExpression_in_comparativeExpression2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_comparativeExpression2578 = new BitSet(new long[]{0x14000C0000000800L,0x0000000080100040L});
    public static final BitSet FOLLOW_81_in_comparativeExpression2580 = new BitSet(new long[]{0x14000C0000000800L,0x0000000080100040L});
    public static final BitSet FOLLOW_type_in_comparativeExpression2585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_in_comparativeExpression2601 = new BitSet(new long[]{0x0000000000216A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_addExpression_in_comparativeExpression2605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subtractExpression_in_addExpression2651 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_addExpression2667 = new BitSet(new long[]{0x0000000000216A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_addExpression_in_addExpression2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_subtractExpression2717 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_MINUS_in_subtractExpression2732 = new BitSet(new long[]{0x0000000000216A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_subtractExpression_in_subtractExpression2736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionValue_in_multiplicativeExpression2785 = new BitSet(new long[]{0x0000000010800002L});
    public static final BitSet FOLLOW_23_in_multiplicativeExpression2805 = new BitSet(new long[]{0x0000000000216A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_28_in_multiplicativeExpression2807 = new BitSet(new long[]{0x0000000000216A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_addExpression_in_multiplicativeExpression2812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_expressionValue2860 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_set_in_expressionValue2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_expressionValue2880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expressionValue2890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectAccessStatement_in_expressionValue2914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_expressionValue2928 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_expressionValue2932 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_expressionValue2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_expressionValue2959 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_listOfExpressions_in_expressionValue2963 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_expressionValue2966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_objectAccessStatement3006 = new BitSet(new long[]{0x0000000004000002L,0x0000000000010008L});
    public static final BitSet FOLLOW_arrayAccess_in_objectAccessStatement3016 = new BitSet(new long[]{0x0000000004000002L,0x0000000000010008L});
    public static final BitSet FOLLOW_propertyAccess_in_objectAccessStatement3030 = new BitSet(new long[]{0x0000000004000002L,0x0000000000010008L});
    public static final BitSet FOLLOW_functionWrapper_in_objectAccessStatement3042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_arrayAccess3085 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_arrayAccess3089 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_arrayAccess3092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_propertyAccess3126 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_propertyAccess3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_functionWrapper3168 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_functionWrapper3170 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionWrapper3172 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_functionWrapper3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_functionWrapper3184 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_functionWrapper3186 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionWrapper3188 = new BitSet(new long[]{0x0000000000012800L});
    public static final BitSet FOLLOW_INT_in_functionWrapper3193 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_functionWrapper3201 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_STRING_in_functionWrapper3210 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_functionWrapper3215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_functionWrapper3223 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_functionWrapper3225 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionWrapper3227 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_functionWrapper3229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_functionWrapper3240 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_functionWrapper3242 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionWrapper3244 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_functionWrapper3246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolImportStatement_in_functionWrapper3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankImportStatement_in_functionWrapper3266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_functionWrapper3274 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_functionWrapper3276 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionWrapper3278 = new BitSet(new long[]{0x807C633D80696A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_functionWrapper3283 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_functionWrapper3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_objectAssignmentStatement3317 = new BitSet(new long[]{0x0000000205004000L,0x0000000000000008L});
    public static final BitSet FOLLOW_26_in_objectAssignmentStatement3327 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_objectAssignmentStatement3331 = new BitSet(new long[]{0x0000000205004000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_objectAssignmentStatement3339 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_objectAssignmentStatement3345 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_objectAssignmentStatement3348 = new BitSet(new long[]{0x0000000205004000L,0x0000000000000008L});
    public static final BitSet FOLLOW_assignment_in_objectAssignmentStatement3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_listOfStatements3391 = new BitSet(new long[]{0x7C829C8040001802L,0x0000000187F190C0L});
    public static final BitSet FOLLOW_89_in_returnStatement3421 = new BitSet(new long[]{0xC07CE33DC0296A00L,0x000000004120040BL});
    public static final BitSet FOLLOW_expression_in_returnStatement3430 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_functionCall_in_returnStatement3439 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_wrappedStatement_in_returnStatement3448 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_returnStatement3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_saveStatement3473 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_saveStatement3475 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_listOfSaveObjects_in_saveStatement3477 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_saveStatement3480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfSaveObjects3496 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_listOfSaveObjects3498 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_listOfSaveObjects3504 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfSaveObjects3510 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_listOfSaveObjects_in_listOfSaveObjects3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ifStatement3552 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifStatement3554 = new BitSet(new long[]{0x817C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_ifCondition_in_ifStatement3558 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ifStatement3561 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_ifStatement3563 = new BitSet(new long[]{0x7C829C8040001800L,0x0000000187F190C0L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement3567 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_ifStatement3570 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ifStatement3591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ifStatement3593 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifStatement3595 = new BitSet(new long[]{0x817C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_ifCondition_in_ifStatement3599 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ifStatement3602 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_ifStatement3604 = new BitSet(new long[]{0x7C829C8040001800L,0x0000000187F190C0L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement3608 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_ifStatement3611 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ifStatement3620 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_ifStatement3622 = new BitSet(new long[]{0x7C829C8040001800L,0x0000000187F190C0L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement3626 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_ifStatement3629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ifCondition3655 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_ifCondition3659 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ifCondition3661 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_ifCondition3667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_loopStatement3707 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement3709 = new BitSet(new long[]{0x807C633D80296A00L,0x00000000C010044BL});
    public static final BitSet FOLLOW_forInit_in_loopStatement3713 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_loopStatement3716 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_loopStatement3727 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_loopStatement3730 = new BitSet(new long[]{0x4000800000000800L});
    public static final BitSet FOLLOW_computationalStatement_in_loopStatement3741 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_loopStatement3744 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_loopStatement3746 = new BitSet(new long[]{0x7C829C8040001800L,0x0000000187F190C0L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement3758 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_loopStatement3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_loopStatement3768 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement3770 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_loopStatement3774 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_loopStatement3777 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_loopStatement3779 = new BitSet(new long[]{0x7C829C8040001800L,0x0000000187F190C0L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement3783 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_loopStatement3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_loopStatement3793 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_loopStatement3795 = new BitSet(new long[]{0x7C829C8040001800L,0x0000000187F190C0L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement3799 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_loopStatement3802 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_loopStatement3804 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement3806 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_loopStatement3810 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_loopStatement3813 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_loopStatement3814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_forInit3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listOfExpressions_in_forInit3852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_functionDeclaration3877 = new BitSet(new long[]{0x14000C0000000800L,0x0000000080100040L});
    public static final BitSet FOLLOW_type_in_functionDeclaration3882 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_functionDeclaration3888 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionDeclaration3892 = new BitSet(new long[]{0x14000C0000400800L,0x0000000080100040L});
    public static final BitSet FOLLOW_listOfFunctionParamenters_in_functionDeclaration3897 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_functionDeclaration3901 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_functionDeclaration3903 = new BitSet(new long[]{0x7C829C8040001800L,0x0000000187F190C0L});
    public static final BitSet FOLLOW_listOfStatements_in_functionDeclaration3911 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_functionDeclaration3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_type3939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_type3946 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_type3948 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_type3950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_type3957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_type3964 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_type3966 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_type3968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_type3975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_type3984 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_type3986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_type3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_type3997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_type4004 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_type4006 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_type4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_type4015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_type4022 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_type4024 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_type4026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_type4033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_type4040 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_type4042 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_type4044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_type4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_type4058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_listOfFunctionParamenters4082 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfFunctionParamenters4086 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfFunctionParamenters4091 = new BitSet(new long[]{0x14000C0000000800L,0x0000000080100040L});
    public static final BitSet FOLLOW_listOfFunctionParamenters_in_listOfFunctionParamenters4095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_functionCall4126 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionCall4128 = new BitSet(new long[]{0x807C633D80696A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_listOfParameterValues_in_functionCall4133 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_functionCall4138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfParameterValues4170 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfParameterValues4177 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_listOfParameterValues_in_listOfParameterValues4181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_in_wrappedStatement4206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_permuteStatement_in_wrappedStatement4221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_productStatement_in_wrappedStatement4237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_get_in_wrappedStatement4247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_size_in_wrappedStatement4257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_toSequence_in_wrappedStatement4267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolStatement_in_wrappedStatement4277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankStatement_in_wrappedStatement4287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_add4311 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_add4313 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_add4315 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_listOfExpressions_in_add4319 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_add4322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_toSequence4351 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_toSequence4353 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_toSequence4355 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_toSequence4357 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_toSequence4359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_get4379 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_get4381 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_get4383 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_get4385 = new BitSet(new long[]{0x0000000000012800L});
    public static final BitSet FOLLOW_INT_in_get4390 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_get4398 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_STRING_in_get4406 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_get4411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_size4444 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_size4446 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_size4448 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_size4450 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_size4452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfRules4490 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_listOfRules4495 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfRules4499 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_85_in_permuteStatement4532 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_permuteStatement4534 = new BitSet(new long[]{0x0000000000216A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_expressionValue_in_permuteStatement4546 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_25_in_permuteStatement4558 = new BitSet(new long[]{0x0000000000216A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_expressionValue_in_permuteStatement4562 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_25_in_permuteStatement4576 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000800L});
    public static final BitSet FOLLOW_set_in_permuteStatement4580 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_permuteStatement4588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_productStatement4631 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_productStatement4633 = new BitSet(new long[]{0x0000000000216A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_expressionValue_in_productStatement4637 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_25_in_productStatement4677 = new BitSet(new long[]{0x0000000000216A00L,0x0000000040000408L});
    public static final BitSet FOLLOW_expressionValue_in_productStatement4681 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_25_in_productStatement4705 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000800L});
    public static final BitSet FOLLOW_set_in_productStatement4710 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_productStatement4719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_getObject4749 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_getObject4753 = new BitSet(new long[]{0x0000000004000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_getObject4759 = new BitSet(new long[]{0x807C633D80296A00L,0x000000004000040BL});
    public static final BitSet FOLLOW_expression_in_getObject4763 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_getObject4766 = new BitSet(new long[]{0x0000000004000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_87_in_printStatement4809 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_printStatement4811 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_printStatement4813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_printStatement4827 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_printStatement4829 = new BitSet(new long[]{0xC07CE33D80296A00L,0x000000004120040BL});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement4833 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_25_in_printStatement4839 = new BitSet(new long[]{0xC07CE33D80296A00L,0x000000004120040BL});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement4843 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_22_in_printStatement4850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_printStatement4862 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_printStatement4864 = new BitSet(new long[]{0xC07CE33D80296A00L,0x000000004120040BL});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement4868 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_25_in_printStatement4874 = new BitSet(new long[]{0xC07CE33D80296A00L,0x000000004120040BL});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement4878 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_22_in_printStatement4885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_whatToPrint4906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wrappedStatement_in_whatToPrint4916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolStatement_in_dataExtraction4935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankStatement_in_dataExtraction4941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_sbolStatement4961 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sbolStatement4963 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010200L});
    public static final BitSet FOLLOW_sbolExportStatement_in_sbolStatement4966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolImportStatement_in_sbolStatement4973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_sbolExportStatement4990 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_sbolExportStatement4992 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_sbolExportStatement4996 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_sbolExportStatement4998 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_sbolExportStatement5002 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_sbolExportStatement5004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_sbolImportStatement5033 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_sbolImportStatement5035 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_sbolImportStatement5039 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_sbolImportStatement5041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_genbankStatement5067 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_genbankStatement5069 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010200L});
    public static final BitSet FOLLOW_genbankImportStatement_in_genbankStatement5074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankExportStatement_in_genbankStatement5079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_genbankExportStatement5102 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_genbankExportStatement5104 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_genbankExportStatement5106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_genbankImportStatement5123 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_genbankImportStatement5125 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_genbankImportStatement5129 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_genbankImportStatement5131 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_genbankImportStatement5135 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_genbankImportStatement5137 = new BitSet(new long[]{0x0000000000000002L});

}