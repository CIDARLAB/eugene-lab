// $ANTLR 3.4 /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g 2013-08-08 17:11:05

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
//import eugene.rules.*;
import org.cidarlab.eugene.rules.RuleEngine;
import eugene.exception.*; 
import eugene.util.*;
import eugene.output.ResultSet;
import eugene.data.registry.*;
import eugene.interpreter.*;
import eugene.cache.*;
import org.cidarlab.eugene.builder.EugeneBuilder;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.Set;
import java.util.Iterator;
import java.util.Random;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "COMMENT", "DYNAMIC_NAME", "ESC_SEQ", "EXPONENT", "FLOAT", "HEX_DIGIT", "ID", "INCLUDE", "INT", "OCTAL_ESC", "STRING", "UNICODE_ESC", "WS", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'.add'", "'.addProperties'", "'.addProperty'", "'/'", "':'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'AFTER'", "'AND'", "'Assert'", "'BEFORE'", "'BINDS'", "'CONTAINS'", "'Collection'", "'DRIVES'", "'Device'", "'DeviceType'", "'ENDSWITH'", "'EQUALS'", "'EXISTS'", "'FORALL'", "'Genbank'", "'INDUCES'", "'INSTANCEOF'", "'Image'", "'LEFTTO'", "'MORETHAN'", "'NEXTTO'", "'NOT'", "'NOTEQUALS'", "'NOTMORETHAN'", "'NOTWITH'", "'Note'", "'ON'", "'OR'", "'ORTHO'", "'Part'", "'PartType'", "'Property'", "'REPRESSES'", "'Rule'", "'SBOL'", "'STARTSWITH'", "'THEN'", "'WITH'", "'XOR'", "'['", "']'", "'^^'", "'boolean'", "'depth'", "'do'", "'else'", "'export'", "'false'", "'flexible'", "'for'", "'function'", "'get'", "'if'", "'import'", "'instanceof'", "'instantiate'", "'isEmpty'", "'maxDepth'", "'num'", "'permute'", "'print'", "'println'", "'product'", "'remove'", "'return'", "'save'", "'sequence'", "'size'", "'strict'", "'toSequence'", "'true'", "'txt'", "'while'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__18=18;
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
    public static final int T__100=100;
    public static final int T__101=101;
    public static final int T__102=102;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__110=110;
    public static final int T__111=111;
    public static final int T__112=112;
    public static final int T__113=113;
    public static final int T__114=114;
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
    public static final int OCTAL_ESC=14;
    public static final int STRING=15;
    public static final int UNICODE_ESC=16;
    public static final int WS=17;

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
    public String getGrammarFileName() { return "/Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g"; }



    //private RuleEngine ruleEngine = new RuleEngine();
    private RegistryImporter registryImporter = new RegistryImporter();
    private Runtime rt = Runtime.getRuntime();
    private Interp interp = new Interp();

    public ResultSet getResultSet() {
        if(null != interp) {
            return interp.getResultSet();
        }
        return null;
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
            } else if(objStackElement instanceof ConditionalBranch) {
                ((ConditionalBranch)objStackElement).clear();
            }
            objStackElement = SymbolTables.peek();
        }        

        Function objFunction = (Function)objStackElement;
        objFunction.clear();
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
            ((ConditionalBranch)objElement).clear();
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
            b = RuleEngine.evaluateIfRule((Rule)objElement);
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
        
        Runtime.getRuntime().halt(nExitCode);

        // and exit
        //System.exit(nExitCode);
    }

    public void cleanUpNoExit() {
        // clear the symbol tables
        SymbolTables.cleanUp();
    	    
        // clear the interpreter's data structures
        if(null != this.interp) {
            this.interp.cleanUp();
            this.interp = null;
        }
    }

    public NamedElement createElement(String sType, String sName) {
        if(EugeneConstants.DEVICE.equalsIgnoreCase(sType)) {
            return new Device(sName);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:531:1: prog : ( eugeneStatement )+ EOF ;
    public final EugeneParser.prog_return prog() throws RecognitionException {
        EugeneParser.prog_return retval = new EugeneParser.prog_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EOF2=null;
        EugeneParser.eugeneStatement_return eugeneStatement1 =null;


        Object EOF2_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:532:2: ( ( eugeneStatement )+ EOF )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:532:4: ( eugeneStatement )+ EOF
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:532:4: ( eugeneStatement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ID && LA1_0 <= INCLUDE)||LA1_0==32||LA1_0==41||LA1_0==45||(LA1_0 >= 47 && LA1_0 <= 48)||LA1_0==53||LA1_0==56||LA1_0==64||(LA1_0 >= 68 && LA1_0 <= 70)||(LA1_0 >= 72 && LA1_0 <= 73)||LA1_0==81||LA1_0==83||(LA1_0 >= 88 && LA1_0 <= 89)||(LA1_0 >= 91 && LA1_0 <= 92)||(LA1_0 >= 97 && LA1_0 <= 101)||(LA1_0 >= 103 && LA1_0 <= 104)||(LA1_0 >= 110 && LA1_0 <= 111)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:532:4: eugeneStatement
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:535:1: eugeneStatement : ( statement[false] |functionToken= functionDeclaration );
    public final EugeneParser.eugeneStatement_return eugeneStatement() throws RecognitionException {
        EugeneParser.eugeneStatement_return retval = new EugeneParser.eugeneStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.functionDeclaration_return functionToken =null;

        EugeneParser.statement_return statement3 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:536:2: ( statement[false] |functionToken= functionDeclaration )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0 >= ID && LA2_0 <= INCLUDE)||LA2_0==32||LA2_0==41||LA2_0==45||(LA2_0 >= 47 && LA2_0 <= 48)||LA2_0==53||LA2_0==56||LA2_0==64||(LA2_0 >= 68 && LA2_0 <= 70)||(LA2_0 >= 72 && LA2_0 <= 73)||LA2_0==81||LA2_0==83||LA2_0==88||(LA2_0 >= 91 && LA2_0 <= 92)||(LA2_0 >= 97 && LA2_0 <= 101)||(LA2_0 >= 103 && LA2_0 <= 104)||(LA2_0 >= 110 && LA2_0 <= 111)) ) {
                alt2=1;
            }
            else if ( (LA2_0==89) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:536:4: statement[false]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_statement_in_eugeneStatement70);
                    statement3=statement(false);

                    state._fsp--;

                    adaptor.addChild(root_0, statement3.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:537:4: functionToken= functionDeclaration
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:546:1: statement[boolean defer] returns [NamedElement objReturnValue] : ( INCLUDE ';' | importStatement[defer] ';' |declToken= declarationStatement[defer] ';' | computationalStatement[defer] ';' | printStatement[defer] ';' | ifStatement[defer] | assertStatement[defer] ';' | noteStatement[defer] ';' | wrappedStatement[defer] ';' | loopStatement[defer] |returnToken= returnStatement[defer] | saveStatement[defer] ';' );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:549:2: ( INCLUDE ';' | importStatement[defer] ';' |declToken= declarationStatement[defer] ';' | computationalStatement[defer] ';' | printStatement[defer] ';' | ifStatement[defer] | assertStatement[defer] ';' | noteStatement[defer] ';' | wrappedStatement[defer] ';' | loopStatement[defer] |returnToken= returnStatement[defer] | saveStatement[defer] ';' )
            int alt3=12;
            switch ( input.LA(1) ) {
            case INCLUDE:
                {
                alt3=1;
                }
                break;
            case 92:
                {
                alt3=2;
                }
                break;
            case 45:
            case 47:
            case 48:
            case 56:
            case 68:
            case 69:
            case 70:
            case 72:
            case 81:
            case 97:
            case 110:
                {
                alt3=3;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case 78:
                    {
                    int LA3_16 = input.LA(3);

                    if ( (LA3_16==79) ) {
                        alt3=3;
                    }
                    else if ( (LA3_16==FLOAT||LA3_16==ID||LA3_16==INT||LA3_16==STRING||LA3_16==18||LA3_16==20||LA3_16==25||(LA3_16 >= 33 && LA3_16 <= 34)||(LA3_16 >= 36 && LA3_16 <= 39)||LA3_16==42||LA3_16==44||(LA3_16 >= 49 && LA3_16 <= 52)||(LA3_16 >= 57 && LA3_16 <= 63)||(LA3_16 >= 74 && LA3_16 <= 76)||LA3_16==78||LA3_16==86||LA3_16==109) ) {
                        alt3=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 16, input);

                        throw nvae;

                    }
                    }
                    break;
                case DYNAMIC_NAME:
                case ID:
                case 20:
                case 23:
                case 25:
                case 35:
                    {
                    alt3=4;
                    }
                    break;
                case 26:
                    {
                    int LA3_18 = input.LA(3);

                    if ( (LA3_18==82||LA3_18==90||LA3_18==96||LA3_18==102||LA3_18==106||LA3_18==108) ) {
                        alt3=9;
                    }
                    else if ( (LA3_18==ID) ) {
                        alt3=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 18, input);

                        throw nvae;

                    }
                    }
                    break;
                case 43:
                case 46:
                case 54:
                case 67:
                case 71:
                    {
                    alt3=3;
                    }
                    break;
                case 27:
                case 28:
                case 29:
                    {
                    alt3=9;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 4, input);

                    throw nvae;

                }

                }
                break;
            case 32:
                {
                alt3=3;
                }
                break;
            case 73:
                {
                int LA3_6 = input.LA(2);

                if ( (LA3_6==26) ) {
                    int LA3_19 = input.LA(3);

                    if ( (LA3_19==85) ) {
                        int LA3_21 = input.LA(4);

                        if ( (LA3_21==20) ) {
                            int LA3_25 = input.LA(5);

                            if ( (LA3_25==ID) ) {
                                int LA3_29 = input.LA(6);

                                if ( (LA3_29==24) ) {
                                    int LA3_33 = input.LA(7);

                                    if ( (LA3_33==STRING) ) {
                                        int LA3_37 = input.LA(8);

                                        if ( (LA3_37==21) ) {
                                            int LA3_40 = input.LA(9);

                                            if ( (LA3_40==32) ) {
                                                int LA3_36 = input.LA(10);

                                                if ( (LA3_36==32) ) {
                                                    alt3=4;
                                                }
                                                else if ( (LA3_36==EOF||(LA3_36 >= ID && LA3_36 <= INCLUDE)||LA3_36==41||LA3_36==45||(LA3_36 >= 47 && LA3_36 <= 48)||LA3_36==53||LA3_36==56||LA3_36==64||(LA3_36 >= 68 && LA3_36 <= 70)||(LA3_36 >= 72 && LA3_36 <= 73)||LA3_36==81||LA3_36==83||(LA3_36 >= 88 && LA3_36 <= 89)||(LA3_36 >= 91 && LA3_36 <= 92)||(LA3_36 >= 97 && LA3_36 <= 101)||(LA3_36 >= 103 && LA3_36 <= 104)||(LA3_36 >= 110 && LA3_36 <= 111)||LA3_36==114) ) {
                                                    alt3=9;
                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 3, 36, input);

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
                    else if ( (LA3_19==92) ) {
                        int LA3_22 = input.LA(4);

                        if ( (LA3_22==20) ) {
                            int LA3_26 = input.LA(5);

                            if ( (LA3_26==STRING) ) {
                                int LA3_30 = input.LA(6);

                                if ( (LA3_30==21) ) {
                                    int LA3_34 = input.LA(7);

                                    if ( (LA3_34==32) ) {
                                        int LA3_36 = input.LA(8);

                                        if ( (LA3_36==32) ) {
                                            alt3=4;
                                        }
                                        else if ( (LA3_36==EOF||(LA3_36 >= ID && LA3_36 <= INCLUDE)||LA3_36==41||LA3_36==45||(LA3_36 >= 47 && LA3_36 <= 48)||LA3_36==53||LA3_36==56||LA3_36==64||(LA3_36 >= 68 && LA3_36 <= 70)||(LA3_36 >= 72 && LA3_36 <= 73)||LA3_36==81||LA3_36==83||(LA3_36 >= 88 && LA3_36 <= 89)||(LA3_36 >= 91 && LA3_36 <= 92)||(LA3_36 >= 97 && LA3_36 <= 101)||(LA3_36 >= 103 && LA3_36 <= 104)||(LA3_36 >= 110 && LA3_36 <= 111)||LA3_36==114) ) {
                                            alt3=9;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 3, 36, input);

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
            case 53:
                {
                int LA3_7 = input.LA(2);

                if ( (LA3_7==26) ) {
                    int LA3_20 = input.LA(3);

                    if ( (LA3_20==92) ) {
                        int LA3_23 = input.LA(4);

                        if ( (LA3_23==20) ) {
                            int LA3_27 = input.LA(5);

                            if ( (LA3_27==ID) ) {
                                int LA3_31 = input.LA(6);

                                if ( (LA3_31==24) ) {
                                    int LA3_35 = input.LA(7);

                                    if ( (LA3_35==STRING) ) {
                                        int LA3_38 = input.LA(8);

                                        if ( (LA3_38==21) ) {
                                            int LA3_41 = input.LA(9);

                                            if ( (LA3_41==32) ) {
                                                int LA3_36 = input.LA(10);

                                                if ( (LA3_36==32) ) {
                                                    alt3=4;
                                                }
                                                else if ( (LA3_36==EOF||(LA3_36 >= ID && LA3_36 <= INCLUDE)||LA3_36==41||LA3_36==45||(LA3_36 >= 47 && LA3_36 <= 48)||LA3_36==53||LA3_36==56||LA3_36==64||(LA3_36 >= 68 && LA3_36 <= 70)||(LA3_36 >= 72 && LA3_36 <= 73)||LA3_36==81||LA3_36==83||(LA3_36 >= 88 && LA3_36 <= 89)||(LA3_36 >= 91 && LA3_36 <= 92)||(LA3_36 >= 97 && LA3_36 <= 101)||(LA3_36 >= 103 && LA3_36 <= 104)||(LA3_36 >= 110 && LA3_36 <= 111)||LA3_36==114) ) {
                                                    alt3=9;
                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 3, 36, input);

                                                    throw nvae;

                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 3, 41, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 3, 38, input);

                                            throw nvae;

                                        }
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
                    else if ( (LA3_20==85) ) {
                        int LA3_24 = input.LA(4);

                        if ( (LA3_24==20) ) {
                            int LA3_28 = input.LA(5);

                            if ( (LA3_28==21) ) {
                                int LA3_32 = input.LA(6);

                                if ( (LA3_32==32) ) {
                                    int LA3_36 = input.LA(7);

                                    if ( (LA3_36==32) ) {
                                        alt3=4;
                                    }
                                    else if ( (LA3_36==EOF||(LA3_36 >= ID && LA3_36 <= INCLUDE)||LA3_36==41||LA3_36==45||(LA3_36 >= 47 && LA3_36 <= 48)||LA3_36==53||LA3_36==56||LA3_36==64||(LA3_36 >= 68 && LA3_36 <= 70)||(LA3_36 >= 72 && LA3_36 <= 73)||LA3_36==81||LA3_36==83||(LA3_36 >= 88 && LA3_36 <= 89)||(LA3_36 >= 91 && LA3_36 <= 92)||(LA3_36 >= 97 && LA3_36 <= 101)||(LA3_36 >= 103 && LA3_36 <= 104)||(LA3_36 >= 110 && LA3_36 <= 111)||LA3_36==114) ) {
                                        alt3=9;
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
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 7, input);

                    throw nvae;

                }
                }
                break;
            case 99:
            case 100:
                {
                alt3=5;
                }
                break;
            case 91:
                {
                alt3=6;
                }
                break;
            case 41:
                {
                alt3=7;
                }
                break;
            case 64:
                {
                alt3=8;
                }
                break;
            case 98:
            case 101:
                {
                alt3=9;
                }
                break;
            case 83:
            case 88:
            case 111:
                {
                alt3=10;
                }
                break;
            case 103:
                {
                alt3=11;
                }
                break;
            case 104:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:549:4: INCLUDE ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    INCLUDE4=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_statement117); 
                    INCLUDE4_tree = 
                    (Object)adaptor.create(INCLUDE4)
                    ;
                    adaptor.addChild(root_0, INCLUDE4_tree);


                    char_literal5=(Token)match(input,32,FOLLOW_32_in_statement119); 
                    char_literal5_tree = 
                    (Object)adaptor.create(char_literal5)
                    ;
                    adaptor.addChild(root_0, char_literal5_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:550:4: importStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_importStatement_in_statement124);
                    importStatement6=importStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, importStatement6.getTree());

                    char_literal7=(Token)match(input,32,FOLLOW_32_in_statement127); 
                    char_literal7_tree = 
                    (Object)adaptor.create(char_literal7)
                    ;
                    adaptor.addChild(root_0, char_literal7_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:551:4: declToken= declarationStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_declarationStatement_in_statement134);
                    declToken=declarationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, declToken.getTree());

                    char_literal8=(Token)match(input,32,FOLLOW_32_in_statement137); 
                    char_literal8_tree = 
                    (Object)adaptor.create(char_literal8)
                    ;
                    adaptor.addChild(root_0, char_literal8_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:552:4: computationalStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_computationalStatement_in_statement144);
                    computationalStatement9=computationalStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, computationalStatement9.getTree());

                    char_literal10=(Token)match(input,32,FOLLOW_32_in_statement147); 
                    char_literal10_tree = 
                    (Object)adaptor.create(char_literal10)
                    ;
                    adaptor.addChild(root_0, char_literal10_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:553:4: printStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_printStatement_in_statement152);
                    printStatement11=printStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printStatement11.getTree());

                    char_literal12=(Token)match(input,32,FOLLOW_32_in_statement155); 
                    char_literal12_tree = 
                    (Object)adaptor.create(char_literal12)
                    ;
                    adaptor.addChild(root_0, char_literal12_tree);


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:554:4: ifStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ifStatement_in_statement160);
                    ifStatement13=ifStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement13.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:555:4: assertStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_assertStatement_in_statement166);
                    assertStatement14=assertStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assertStatement14.getTree());

                    char_literal15=(Token)match(input,32,FOLLOW_32_in_statement169); 
                    char_literal15_tree = 
                    (Object)adaptor.create(char_literal15)
                    ;
                    adaptor.addChild(root_0, char_literal15_tree);


                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:556:4: noteStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_noteStatement_in_statement176);
                    noteStatement16=noteStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, noteStatement16.getTree());

                    char_literal17=(Token)match(input,32,FOLLOW_32_in_statement179); 
                    char_literal17_tree = 
                    (Object)adaptor.create(char_literal17)
                    ;
                    adaptor.addChild(root_0, char_literal17_tree);


                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:557:4: wrappedStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_wrappedStatement_in_statement186);
                    wrappedStatement18=wrappedStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, wrappedStatement18.getTree());

                    char_literal19=(Token)match(input,32,FOLLOW_32_in_statement189); 
                    char_literal19_tree = 
                    (Object)adaptor.create(char_literal19)
                    ;
                    adaptor.addChild(root_0, char_literal19_tree);


                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:558:10: loopStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_loopStatement_in_statement200);
                    loopStatement20=loopStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, loopStatement20.getTree());

                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:559:4: returnToken= returnStatement[defer]
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:565:4: saveStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_saveStatement_in_statement216);
                    saveStatement21=saveStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, saveStatement21.getTree());

                    char_literal22=(Token)match(input,32,FOLLOW_32_in_statement219); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:568:1: computationalStatement[boolean defer] : ( functionCall[defer] |instToken= instantiationStatement[defer] | dataExtraction[defer] ';' |leftToken= objectAssignmentStatement[defer] );
    public final EugeneParser.computationalStatement_return computationalStatement(boolean defer) throws RecognitionException {
        EugeneParser.computationalStatement_return retval = new EugeneParser.computationalStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal25=null;
        EugeneParser.instantiationStatement_return instToken =null;

        EugeneParser.objectAssignmentStatement_return leftToken =null;

        EugeneParser.functionCall_return functionCall23 =null;

        EugeneParser.dataExtraction_return dataExtraction24 =null;


        Object char_literal25_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:569:2: ( functionCall[defer] |instToken= instantiationStatement[defer] | dataExtraction[defer] ';' |leftToken= objectAssignmentStatement[defer] )
            int alt4=4;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ID) ) {
                switch ( input.LA(2) ) {
                case 20:
                    {
                    alt4=1;
                    }
                    break;
                case DYNAMIC_NAME:
                case ID:
                    {
                    alt4=2;
                    }
                    break;
                case 23:
                case 25:
                case 26:
                case 35:
                case 78:
                    {
                    alt4=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }

            }
            else if ( (LA4_0==53||LA4_0==73) ) {
                alt4=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:569:4: functionCall[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_functionCall_in_computationalStatement232);
                    functionCall23=functionCall(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, functionCall23.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:570:4: instToken= instantiationStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_instantiationStatement_in_computationalStatement240);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        SymbolTables.put((instToken!=null?instToken.objComponent:null));
                    }	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:575:4: dataExtraction[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_dataExtraction_in_computationalStatement248);
                    dataExtraction24=dataExtraction(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, dataExtraction24.getTree());

                    char_literal25=(Token)match(input,32,FOLLOW_32_in_computationalStatement251); 
                    char_literal25_tree = 
                    (Object)adaptor.create(char_literal25)
                    ;
                    adaptor.addChild(root_0, char_literal25_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:576:4: leftToken= objectAssignmentStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_objectAssignmentStatement_in_computationalStatement258);
                    leftToken=objectAssignmentStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, leftToken.getTree());


                    if(!defer) {
                        interp.assign((CommonTree)(leftToken!=null?((Object)leftToken.tree):null), (leftToken!=null?leftToken.assignElement:null));
                    }	
                    	

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:588:1: assignment[boolean defer] returns [NamedElement objElement] : ( '=' exprToken= expression[defer] | '=' funcToken= functionCall[defer] | '=' stmtToken= wrappedStatement[defer] | '+' '+' | '-' '-' );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:589:2: ( '=' exprToken= expression[defer] | '=' funcToken= functionCall[defer] | '=' stmtToken= wrappedStatement[defer] | '+' '+' | '-' '-' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 35:
                {
                switch ( input.LA(2) ) {
                case FLOAT:
                case INT:
                case STRING:
                case 18:
                case 20:
                case 25:
                case 33:
                case 34:
                case 36:
                case 37:
                case 38:
                case 39:
                case 42:
                case 44:
                case 49:
                case 50:
                case 51:
                case 52:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 74:
                case 75:
                case 76:
                case 78:
                case 86:
                case 109:
                    {
                    alt5=1;
                    }
                    break;
                case ID:
                    {
                    switch ( input.LA(3) ) {
                    case 20:
                        {
                        alt5=2;
                        }
                        break;
                    case 26:
                        {
                        switch ( input.LA(4) ) {
                        case 90:
                            {
                            int LA5_9 = input.LA(5);

                            if ( (LA5_9==20) ) {
                                switch ( input.LA(6) ) {
                                case INT:
                                    {
                                    int LA5_15 = input.LA(7);

                                    if ( ((LA5_15 >= 18 && LA5_15 <= 19)||(LA5_15 >= 21 && LA5_15 <= 23)||LA5_15==25||LA5_15==30||(LA5_15 >= 33 && LA5_15 <= 34)||(LA5_15 >= 36 && LA5_15 <= 40)||LA5_15==42||LA5_15==44||(LA5_15 >= 49 && LA5_15 <= 50)||LA5_15==55||(LA5_15 >= 57 && LA5_15 <= 59)||(LA5_15 >= 61 && LA5_15 <= 63)||LA5_15==66||(LA5_15 >= 74 && LA5_15 <= 77)||LA5_15==80||LA5_15==93||LA5_15==113) ) {
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

                                    if ( ((LA5_16 >= 18 && LA5_16 <= 19)||(LA5_16 >= 21 && LA5_16 <= 23)||(LA5_16 >= 25 && LA5_16 <= 26)||LA5_16==30||(LA5_16 >= 33 && LA5_16 <= 34)||(LA5_16 >= 36 && LA5_16 <= 40)||LA5_16==42||LA5_16==44||(LA5_16 >= 49 && LA5_16 <= 50)||LA5_16==55||(LA5_16 >= 57 && LA5_16 <= 59)||(LA5_16 >= 61 && LA5_16 <= 63)||LA5_16==66||(LA5_16 >= 74 && LA5_16 <= 78)||LA5_16==80||LA5_16==93||LA5_16==113) ) {
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

                                    if ( ((LA5_17 >= 18 && LA5_17 <= 19)||(LA5_17 >= 21 && LA5_17 <= 23)||LA5_17==25||LA5_17==30||(LA5_17 >= 33 && LA5_17 <= 34)||(LA5_17 >= 36 && LA5_17 <= 40)||LA5_17==42||LA5_17==44||(LA5_17 >= 49 && LA5_17 <= 50)||LA5_17==55||(LA5_17 >= 57 && LA5_17 <= 59)||(LA5_17 >= 61 && LA5_17 <= 63)||LA5_17==66||(LA5_17 >= 74 && LA5_17 <= 77)||LA5_17==80||LA5_17==93||LA5_17==113) ) {
                                        alt5=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 5, 17, input);

                                        throw nvae;

                                    }
                                    }
                                    break;
                                case FLOAT:
                                case 18:
                                case 20:
                                case 25:
                                case 33:
                                case 34:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                case 42:
                                case 44:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 57:
                                case 58:
                                case 59:
                                case 60:
                                case 61:
                                case 62:
                                case 63:
                                case 74:
                                case 75:
                                case 76:
                                case 78:
                                case 86:
                                case 109:
                                    {
                                    alt5=1;
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
                        case 106:
                            {
                            int LA5_10 = input.LA(5);

                            if ( (LA5_10==20) ) {
                                int LA5_13 = input.LA(6);

                                if ( (LA5_13==21) ) {
                                    alt5=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 13, input);

                                    throw nvae;

                                }
                            }
                            else if ( ((LA5_10 >= 18 && LA5_10 <= 19)||(LA5_10 >= 21 && LA5_10 <= 26)||LA5_10==30||(LA5_10 >= 32 && LA5_10 <= 34)||(LA5_10 >= 36 && LA5_10 <= 40)||LA5_10==42||LA5_10==44||(LA5_10 >= 49 && LA5_10 <= 50)||LA5_10==55||(LA5_10 >= 57 && LA5_10 <= 59)||(LA5_10 >= 61 && LA5_10 <= 63)||LA5_10==66||(LA5_10 >= 74 && LA5_10 <= 78)||LA5_10==80||LA5_10==93||LA5_10==113) ) {
                                alt5=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 10, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 82:
                        case 96:
                        case 102:
                            {
                            alt5=3;
                            }
                            break;
                        case 108:
                            {
                            int LA5_11 = input.LA(5);

                            if ( (LA5_11==20) ) {
                                int LA5_14 = input.LA(6);

                                if ( (LA5_14==21) ) {
                                    alt5=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 14, input);

                                    throw nvae;

                                }
                            }
                            else if ( ((LA5_11 >= 18 && LA5_11 <= 19)||(LA5_11 >= 21 && LA5_11 <= 26)||LA5_11==30||(LA5_11 >= 32 && LA5_11 <= 34)||(LA5_11 >= 36 && LA5_11 <= 40)||LA5_11==42||LA5_11==44||(LA5_11 >= 49 && LA5_11 <= 50)||LA5_11==55||(LA5_11 >= 57 && LA5_11 <= 59)||(LA5_11 >= 61 && LA5_11 <= 63)||LA5_11==66||(LA5_11 >= 74 && LA5_11 <= 78)||LA5_11==80||LA5_11==93||LA5_11==113) ) {
                                alt5=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 11, input);

                                throw nvae;

                            }
                            }
                            break;
                        case ID:
                        case 94:
                        case 95:
                        case 105:
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
                    case 18:
                    case 19:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 30:
                    case 32:
                    case 33:
                    case 34:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 42:
                    case 44:
                    case 49:
                    case 50:
                    case 55:
                    case 57:
                    case 58:
                    case 59:
                    case 61:
                    case 62:
                    case 63:
                    case 66:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 80:
                    case 93:
                    case 113:
                        {
                        alt5=1;
                        }
                        break;
                    case 27:
                    case 28:
                    case 29:
                        {
                        alt5=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 5, input);

                        throw nvae;

                    }

                    }
                    break;
                case 53:
                case 73:
                case 98:
                case 101:
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
            case 23:
                {
                alt5=4;
                }
                break;
            case 25:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:589:4: '=' exprToken= expression[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal26=(Token)match(input,35,FOLLOW_35_in_assignment283); 
                    char_literal26_tree = 
                    (Object)adaptor.create(char_literal26)
                    ;
                    adaptor.addChild(root_0, char_literal26_tree);


                    pushFollow(FOLLOW_expression_in_assignment287);
                    exprToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken.getTree());


                    if(!defer) {
                        retval.objElement = (exprToken!=null?exprToken.objElement:null);
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:594:5: '=' funcToken= functionCall[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal27=(Token)match(input,35,FOLLOW_35_in_assignment296); 
                    char_literal27_tree = 
                    (Object)adaptor.create(char_literal27)
                    ;
                    adaptor.addChild(root_0, char_literal27_tree);


                    pushFollow(FOLLOW_functionCall_in_assignment300);
                    funcToken=functionCall(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, funcToken.getTree());


                    if(!defer) {
                        retval.objElement = (funcToken!=null?funcToken.objElement:null);
                    }	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:599:11: '=' stmtToken= wrappedStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal28=(Token)match(input,35,FOLLOW_35_in_assignment315); 
                    char_literal28_tree = 
                    (Object)adaptor.create(char_literal28)
                    ;
                    adaptor.addChild(root_0, char_literal28_tree);


                    pushFollow(FOLLOW_wrappedStatement_in_assignment319);
                    stmtToken=wrappedStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, stmtToken.getTree());


                    if(!defer) {
                        retval.objElement = (stmtToken!=null?stmtToken.objElement:null);
                    }        
                            

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:604:11: '+' '+'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal29=(Token)match(input,23,FOLLOW_23_in_assignment334); 
                    char_literal29_tree = 
                    (Object)adaptor.create(char_literal29)
                    ;
                    adaptor.addChild(root_0, char_literal29_tree);


                    char_literal30=(Token)match(input,23,FOLLOW_23_in_assignment336); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:609:11: '-' '-'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal31=(Token)match(input,25,FOLLOW_25_in_assignment350); 
                    char_literal31_tree = 
                    (Object)adaptor.create(char_literal31)
                    ;
                    adaptor.addChild(root_0, char_literal31_tree);


                    char_literal32=(Token)match(input,25,FOLLOW_25_in_assignment352); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:616:1: importStatement[boolean defer] : importToken= 'import' lstToken= listOfIDs[defer] ;
    public final EugeneParser.importStatement_return importStatement(boolean defer) throws RecognitionException {
        EugeneParser.importStatement_return retval = new EugeneParser.importStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token importToken=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object importToken_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:617:2: (importToken= 'import' lstToken= listOfIDs[defer] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:617:4: importToken= 'import' lstToken= listOfIDs[defer]
            {
            root_0 = (Object)adaptor.nil();


            importToken=(Token)match(input,92,FOLLOW_92_in_importStatement370); 
            importToken_tree = 
            (Object)adaptor.create(importToken)
            ;
            adaptor.addChild(root_0, importToken_tree);


            pushFollow(FOLLOW_listOfIDs_in_importStatement374);
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:651:1: listOfFilenames[boolean defer] : filenameToken= filename[defer] ( ',' listOfFilenames[defer] )? ;
    public final EugeneParser.listOfFilenames_return listOfFilenames(boolean defer) throws RecognitionException {
        EugeneParser.listOfFilenames_return retval = new EugeneParser.listOfFilenames_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal33=null;
        EugeneParser.filename_return filenameToken =null;

        EugeneParser.listOfFilenames_return listOfFilenames34 =null;


        Object char_literal33_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:652:2: (filenameToken= filename[defer] ( ',' listOfFilenames[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:652:4: filenameToken= filename[defer] ( ',' listOfFilenames[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_filename_in_listOfFilenames399);
            filenameToken=filename(defer);

            state._fsp--;

            adaptor.addChild(root_0, filenameToken.getTree());

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:652:34: ( ',' listOfFilenames[defer] )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:652:35: ',' listOfFilenames[defer]
                    {
                    char_literal33=(Token)match(input,24,FOLLOW_24_in_listOfFilenames403); 
                    char_literal33_tree = 
                    (Object)adaptor.create(char_literal33)
                    ;
                    adaptor.addChild(root_0, char_literal33_tree);


                    pushFollow(FOLLOW_listOfFilenames_in_listOfFilenames405);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:655:1: filename[boolean defer] returns [String sFilename] : (filenameToken+= (~ ( ',' | ';' | '(' ) ) )* ;
    public final EugeneParser.filename_return filename(boolean defer) throws RecognitionException {
        EugeneParser.filename_return retval = new EugeneParser.filename_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token filenameToken=null;
        List list_filenameToken=null;

        Object filenameToken_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:656:2: ( (filenameToken+= (~ ( ',' | ';' | '(' ) ) )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:656:4: (filenameToken+= (~ ( ',' | ';' | '(' ) ) )*
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:656:17: (filenameToken+= (~ ( ',' | ';' | '(' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= CHAR && LA7_0 <= 19)||(LA7_0 >= 21 && LA7_0 <= 23)||(LA7_0 >= 25 && LA7_0 <= 31)||(LA7_0 >= 33 && LA7_0 <= 114)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:656:17: filenameToken+= (~ ( ',' | ';' | '(' ) )
            	    {
            	    filenameToken=(Token)input.LT(1);

            	    if ( (input.LA(1) >= CHAR && input.LA(1) <= 19)||(input.LA(1) >= 21 && input.LA(1) <= 23)||(input.LA(1) >= 25 && input.LA(1) <= 31)||(input.LA(1) >= 33 && input.LA(1) <= 114) ) {
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:671:1: declarationStatement[boolean defer] : ( collectionDeclaration[defer] | variableDeclaration[defer] | propertyDeclaration[defer] | partTypeDeclaration[defer] | deviceDeclaration[defer] | arrayDeclaration[defer] | ruleDeclaration[defer] | imageDeclaration[defer] | deviceTypeDeclaration[defer] || relationDeclaration[defer] );
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

        EugeneParser.relationDeclaration_return relationDeclaration44 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:672:2: ( collectionDeclaration[defer] | variableDeclaration[defer] | propertyDeclaration[defer] | partTypeDeclaration[defer] | deviceDeclaration[defer] | arrayDeclaration[defer] | ruleDeclaration[defer] | imageDeclaration[defer] | deviceTypeDeclaration[defer] || relationDeclaration[defer] )
            int alt8=11;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt8=1;
                }
                break;
            case 81:
            case 97:
            case 110:
                {
                alt8=2;
                }
                break;
            case 70:
                {
                int LA8_3 = input.LA(2);

                if ( (LA8_3==78) ) {
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
            case 69:
                {
                int LA8_4 = input.LA(2);

                if ( (LA8_4==ID) ) {
                    alt8=4;
                }
                else if ( (LA8_4==78) ) {
                    alt8=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 4, input);

                    throw nvae;

                }
                }
                break;
            case 47:
                {
                int LA8_5 = input.LA(2);

                if ( (LA8_5==ID) ) {
                    alt8=5;
                }
                else if ( (LA8_5==78) ) {
                    alt8=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 5, input);

                    throw nvae;

                }
                }
                break;
            case 68:
                {
                int LA8_6 = input.LA(2);

                if ( (LA8_6==ID) ) {
                    alt8=4;
                }
                else if ( (LA8_6==78) ) {
                    alt8=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 6, input);

                    throw nvae;

                }
                }
                break;
            case 72:
                {
                int LA8_7 = input.LA(2);

                if ( (LA8_7==78) ) {
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
                int LA8_8 = input.LA(2);

                if ( (LA8_8==78) ) {
                    alt8=6;
                }
                else if ( (LA8_8==43||LA8_8==46||LA8_8==54||LA8_8==67||LA8_8==71) ) {
                    alt8=11;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 8, input);

                    throw nvae;

                }
                }
                break;
            case 56:
                {
                alt8=8;
                }
                break;
            case 48:
                {
                alt8=9;
                }
                break;
            case 32:
                {
                alt8=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:672:4: collectionDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_collectionDeclaration_in_declarationStatement461);
                    collectionDeclaration35=collectionDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, collectionDeclaration35.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:673:4: variableDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_variableDeclaration_in_declarationStatement467);
                    variableDeclaration36=variableDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, variableDeclaration36.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:674:4: propertyDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_propertyDeclaration_in_declarationStatement473);
                    propertyDeclaration37=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyDeclaration37.getTree());

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:675:4: partTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partTypeDeclaration_in_declarationStatement479);
                    partTypeDeclaration38=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeDeclaration38.getTree());

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:676:4: deviceDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDeclaration_in_declarationStatement485);
                    deviceDeclaration39=deviceDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceDeclaration39.getTree());

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:677:4: arrayDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_arrayDeclaration_in_declarationStatement491);
                    arrayDeclaration40=arrayDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDeclaration40.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:678:4: ruleDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ruleDeclaration_in_declarationStatement497);
                    ruleDeclaration41=ruleDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, ruleDeclaration41.getTree());

                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:679:4: imageDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_imageDeclaration_in_declarationStatement503);
                    imageDeclaration42=imageDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, imageDeclaration42.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:680:4: deviceTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceTypeDeclaration_in_declarationStatement509);
                    deviceTypeDeclaration43=deviceTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceTypeDeclaration43.getTree());

                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:681:3: 
                    {
                    root_0 = (Object)adaptor.nil();


                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:681:5: relationDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_relationDeclaration_in_declarationStatement516);
                    relationDeclaration44=relationDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, relationDeclaration44.getTree());

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:691:1: collectionDeclaration[boolean defer] : 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )? ;
    public final EugeneParser.collectionDeclaration_return collectionDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.collectionDeclaration_return retval = new EugeneParser.collectionDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal45=null;
        EugeneParser.collectionDefinition_return defToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object nameToken_tree=null;
        Object string_literal45_tree=null;


        EugeneCollection objCollection = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:695:2: ( 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:695:4: 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal45=(Token)match(input,45,FOLLOW_45_in_collectionDeclaration545); 
            string_literal45_tree = 
            (Object)adaptor.create(string_literal45)
            ;
            adaptor.addChild(root_0, string_literal45_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_collectionDeclaration549); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);



            if(!defer) {
                objCollection = interp.createCollection(
                            (nameToken!=null?nameToken.getText():null), 
                            (java.util.Collection<NamedElement>)null);
            }             
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:702:3: (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )?
            int alt9=3;
            switch ( input.LA(1) ) {
                case 20:
                    {
                    alt9=1;
                    }
                    break;
                case 35:
                    {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2==INCLUDE) ) {
                        alt9=1;
                    }
                    else if ( (LA9_2==FLOAT||LA9_2==ID||LA9_2==INT||LA9_2==STRING||LA9_2==18||LA9_2==20||LA9_2==25||(LA9_2 >= 33 && LA9_2 <= 34)||(LA9_2 >= 36 && LA9_2 <= 39)||LA9_2==42||LA9_2==44||(LA9_2 >= 49 && LA9_2 <= 53)||(LA9_2 >= 57 && LA9_2 <= 63)||(LA9_2 >= 73 && LA9_2 <= 76)||LA9_2==78||LA9_2==86||LA9_2==98||LA9_2==101||LA9_2==109) ) {
                        alt9=2;
                    }
                    }
                    break;
                case 23:
                case 25:
                    {
                    alt9=2;
                    }
                    break;
            }

            switch (alt9) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:702:4: defToken= collectionDefinition[defer, objCollection]
                    {
                    pushFollow(FOLLOW_collectionDefinition_in_collectionDeclaration559);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:707:8: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_collectionDeclaration572);
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
            e.printStackTrace();    
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:722:1: collectionDefinition[boolean defer, EugeneCollection objCollection] returns [java.util.Set<CollectionElement> colElements] : ( '(' lstToken= listOfCollectionComponents[defer] ')' | '=' includeToken= INCLUDE );
    public final EugeneParser.collectionDefinition_return collectionDefinition(boolean defer, EugeneCollection objCollection) throws RecognitionException {
        EugeneParser.collectionDefinition_return retval = new EugeneParser.collectionDefinition_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token includeToken=null;
        Token char_literal46=null;
        Token char_literal47=null;
        Token char_literal48=null;
        EugeneParser.listOfCollectionComponents_return lstToken =null;


        Object includeToken_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal48_tree=null;


        retval.colElements = new java.util.HashSet<CollectionElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:727:2: ( '(' lstToken= listOfCollectionComponents[defer] ')' | '=' includeToken= INCLUDE )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            else if ( (LA10_0==35) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:727:4: '(' lstToken= listOfCollectionComponents[defer] ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal46=(Token)match(input,20,FOLLOW_20_in_collectionDefinition620); 
                    char_literal46_tree = 
                    (Object)adaptor.create(char_literal46)
                    ;
                    adaptor.addChild(root_0, char_literal46_tree);



                    if(!defer) {
                        // we need to push the collection onto the stack
                        // because in the interpreter the collection elements 
                        // will be put into the symbol tables...
                        SymbolTables.push(objCollection);
                    }	
                    	

                    pushFollow(FOLLOW_listOfCollectionComponents_in_collectionDefinition627);
                    lstToken=listOfCollectionComponents(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());


                    if(!defer) {
                        retval.colElements.addAll((lstToken!=null?lstToken.lstElements:null));
                    }	
                    	

                    char_literal47=(Token)match(input,21,FOLLOW_21_in_collectionDefinition633); 
                    char_literal47_tree = 
                    (Object)adaptor.create(char_literal47)
                    ;
                    adaptor.addChild(root_0, char_literal47_tree);



                    if(!defer) {
                        if(null != SymbolTables.peek()) {
                            // pop the collection from the stack
                            SymbolTables.pop();
                        }
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:746:4: '=' includeToken= INCLUDE
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal48=(Token)match(input,35,FOLLOW_35_in_collectionDefinition640); 
                    char_literal48_tree = 
                    (Object)adaptor.create(char_literal48)
                    ;
                    adaptor.addChild(root_0, char_literal48_tree);


                    includeToken=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_collectionDefinition644); 
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:759:1: listOfCollectionComponents[boolean defer] returns [Set<CollectionElement> lstElements] : componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )? ;
    public final EugeneParser.listOfCollectionComponents_return listOfCollectionComponents(boolean defer) throws RecognitionException {
        EugeneParser.listOfCollectionComponents_return retval = new EugeneParser.listOfCollectionComponents_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal49=null;
        EugeneParser.collectionElement_return componentToken =null;

        EugeneParser.listOfCollectionComponents_return lstToken =null;


        Object char_literal49_tree=null;


        retval.lstElements =new HashSet<CollectionElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:764:9: (componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:764:11: componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_collectionElement_in_listOfCollectionComponents690);
            componentToken=collectionElement(defer);

            state._fsp--;

            adaptor.addChild(root_0, componentToken.getTree());


            if(!defer) {
                retval.lstElements.add((componentToken!=null?componentToken.objElement:null));
            }        
                    

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:768:11: ( ',' lstToken= listOfCollectionComponents[defer] )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:768:12: ',' lstToken= listOfCollectionComponents[defer]
                    {
                    char_literal49=(Token)match(input,24,FOLLOW_24_in_listOfCollectionComponents696); 
                    char_literal49_tree = 
                    (Object)adaptor.create(char_literal49)
                    ;
                    adaptor.addChild(root_0, char_literal49_tree);


                    pushFollow(FOLLOW_listOfCollectionComponents_in_listOfCollectionComponents700);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:775:1: collectionElement[boolean defer] returns [CollectionElement objElement] : (propertyToken= propertyDeclaration[defer] |partTypeToken= partTypeDeclaration[defer] |deviceToken= deviceDeclaration[defer] |instToken= instantiationStatement[defer] |idToken= ID );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:776:2: (propertyToken= propertyDeclaration[defer] |partTypeToken= partTypeDeclaration[defer] |deviceToken= deviceDeclaration[defer] |instToken= instantiationStatement[defer] |idToken= ID )
            int alt12=5;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt12=1;
                }
                break;
            case 68:
            case 69:
                {
                alt12=2;
                }
                break;
            case 47:
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
                else if ( (LA12_4==21||LA12_4==24) ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:776:4: propertyToken= propertyDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_propertyDeclaration_in_collectionElement738);
                    propertyToken=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyToken.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:777:4: partTypeToken= partTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partTypeDeclaration_in_collectionElement746);
                    partTypeToken=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeToken.getTree());


                    if(!defer) {
                        retval.objElement = partTypeToken.objPartType;
                    }            
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:782:11: deviceToken= deviceDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDeclaration_in_collectionElement763);
                    deviceToken=deviceDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());


                    if(!defer) {
                        retval.objElement = (deviceToken!=null?deviceToken.objDevice:null);
                    }        
                            

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:787:4: instToken= instantiationStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_instantiationStatement_in_collectionElement773);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        retval.objElement = (instToken!=null?instToken.objComponent:null);
                    }
                            

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:792:11: idToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_collectionElement790); 
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
        public Property objProperty;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "propertyDeclaration"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:803:1: propertyDeclaration[boolean defer] returns [Property objProperty] : 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')' ;
    public final EugeneParser.propertyDeclaration_return propertyDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.propertyDeclaration_return retval = new EugeneParser.propertyDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal50=null;
        Token char_literal51=null;
        Token char_literal52=null;
        EugeneParser.dynamicNaming_return nameToken =null;

        EugeneParser.propertyType_return typeToken =null;


        Object string_literal50_tree=null;
        Object char_literal51_tree=null;
        Object char_literal52_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:805:2: ( 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:805:4: 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal50=(Token)match(input,70,FOLLOW_70_in_propertyDeclaration813); 
            string_literal50_tree = 
            (Object)adaptor.create(string_literal50)
            ;
            adaptor.addChild(root_0, string_literal50_tree);


            pushFollow(FOLLOW_dynamicNaming_in_propertyDeclaration817);
            nameToken=dynamicNaming(defer);

            state._fsp--;

            adaptor.addChild(root_0, nameToken.getTree());

            char_literal51=(Token)match(input,20,FOLLOW_20_in_propertyDeclaration820); 
            char_literal51_tree = 
            (Object)adaptor.create(char_literal51)
            ;
            adaptor.addChild(root_0, char_literal51_tree);


            pushFollow(FOLLOW_propertyType_in_propertyDeclaration824);
            typeToken=propertyType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            char_literal52=(Token)match(input,21,FOLLOW_21_in_propertyDeclaration826); 
            char_literal52_tree = 
            (Object)adaptor.create(char_literal52)
            ;
            adaptor.addChild(root_0, char_literal52_tree);



            if(!defer) {
                retval.objProperty = interp.createProperty(
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:820:1: propertyType : ( 'txt' | 'txt' '[' ']' | 'num' | 'num' '[' ']' | 'boolean' );
    public final EugeneParser.propertyType_return propertyType() throws RecognitionException {
        EugeneParser.propertyType_return retval = new EugeneParser.propertyType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal53=null;
        Token string_literal54=null;
        Token char_literal55=null;
        Token char_literal56=null;
        Token string_literal57=null;
        Token string_literal58=null;
        Token char_literal59=null;
        Token char_literal60=null;
        Token string_literal61=null;

        Object string_literal53_tree=null;
        Object string_literal54_tree=null;
        Object char_literal55_tree=null;
        Object char_literal56_tree=null;
        Object string_literal57_tree=null;
        Object string_literal58_tree=null;
        Object char_literal59_tree=null;
        Object char_literal60_tree=null;
        Object string_literal61_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:821:2: ( 'txt' | 'txt' '[' ']' | 'num' | 'num' '[' ']' | 'boolean' )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 110:
                {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==78) ) {
                    alt13=2;
                }
                else if ( (LA13_1==ID||LA13_1==21) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
                }
                break;
            case 97:
                {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==78) ) {
                    alt13=4;
                }
                else if ( (LA13_2==ID||LA13_2==21) ) {
                    alt13=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;

                }
                }
                break;
            case 81:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:821:4: 'txt'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal53=(Token)match(input,110,FOLLOW_110_in_propertyType845); 
                    string_literal53_tree = 
                    (Object)adaptor.create(string_literal53)
                    ;
                    adaptor.addChild(root_0, string_literal53_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:822:4: 'txt' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal54=(Token)match(input,110,FOLLOW_110_in_propertyType850); 
                    string_literal54_tree = 
                    (Object)adaptor.create(string_literal54)
                    ;
                    adaptor.addChild(root_0, string_literal54_tree);


                    char_literal55=(Token)match(input,78,FOLLOW_78_in_propertyType852); 
                    char_literal55_tree = 
                    (Object)adaptor.create(char_literal55)
                    ;
                    adaptor.addChild(root_0, char_literal55_tree);


                    char_literal56=(Token)match(input,79,FOLLOW_79_in_propertyType854); 
                    char_literal56_tree = 
                    (Object)adaptor.create(char_literal56)
                    ;
                    adaptor.addChild(root_0, char_literal56_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:823:4: 'num'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal57=(Token)match(input,97,FOLLOW_97_in_propertyType859); 
                    string_literal57_tree = 
                    (Object)adaptor.create(string_literal57)
                    ;
                    adaptor.addChild(root_0, string_literal57_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:824:4: 'num' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal58=(Token)match(input,97,FOLLOW_97_in_propertyType864); 
                    string_literal58_tree = 
                    (Object)adaptor.create(string_literal58)
                    ;
                    adaptor.addChild(root_0, string_literal58_tree);


                    char_literal59=(Token)match(input,78,FOLLOW_78_in_propertyType866); 
                    char_literal59_tree = 
                    (Object)adaptor.create(char_literal59)
                    ;
                    adaptor.addChild(root_0, char_literal59_tree);


                    char_literal60=(Token)match(input,79,FOLLOW_79_in_propertyType868); 
                    char_literal60_tree = 
                    (Object)adaptor.create(char_literal60)
                    ;
                    adaptor.addChild(root_0, char_literal60_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:825:4: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal61=(Token)match(input,81,FOLLOW_81_in_propertyType873); 
                    string_literal61_tree = 
                    (Object)adaptor.create(string_literal61)
                    ;
                    adaptor.addChild(root_0, string_literal61_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:830:1: variableDeclaration[boolean defer] returns [List<Variable> lstVariables] : typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text] ;
    public final EugeneParser.variableDeclaration_return variableDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.variableDeclaration_return retval = new EugeneParser.variableDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.propertyType_return typeToken =null;

        EugeneParser.listOfVariables_return varToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:832:2: (typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:832:4: typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_propertyType_in_variableDeclaration897);
            typeToken=propertyType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            pushFollow(FOLLOW_listOfVariables_in_variableDeclaration901);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:839:1: listOfVariables[boolean defer, String sVariableType] returns [List<Variable> lstVariables] : idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )? ;
    public final EugeneParser.listOfVariables_return listOfVariables(boolean defer, String sVariableType) throws RecognitionException {
        EugeneParser.listOfVariables_return retval = new EugeneParser.listOfVariables_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal62=null;
        EugeneParser.assignment_return assignToken =null;

        EugeneParser.listOfVariables_return lstToken =null;


        Object idToken_tree=null;
        Object char_literal62_tree=null;


        retval.lstVariables = new ArrayList<Variable>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:844:2: (idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:844:4: idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )?
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfVariables929); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);



            if(!defer) {
                retval.lstVariables.add(
                    interp.createVariable((idToken!=null?idToken.getText():null), sVariableType));
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:849:9: (assignToken= assignment[defer] )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23||LA14_0==25||LA14_0==35) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:849:10: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_listOfVariables941);
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


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:854:14: ( ',' lstToken= listOfVariables[defer, sVariableType] )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:854:15: ',' lstToken= listOfVariables[defer, sVariableType]
                    {
                    char_literal62=(Token)match(input,24,FOLLOW_24_in_listOfVariables950); 
                    char_literal62_tree = 
                    (Object)adaptor.create(char_literal62)
                    ;
                    adaptor.addChild(root_0, char_literal62_tree);


                    pushFollow(FOLLOW_listOfVariables_in_listOfVariables954);
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
            exc.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:870:1: partTypeDeclaration[boolean defer] returns [PartType objPartType] : ( ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? | ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer] );
    public final EugeneParser.partTypeDeclaration_return partTypeDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.partTypeDeclaration_return retval = new EugeneParser.partTypeDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token set63=null;
        Token char_literal64=null;
        Token char_literal65=null;
        Token set66=null;
        EugeneParser.listOfIDs_return lstToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object nameToken_tree=null;
        Object set63_tree=null;
        Object char_literal64_tree=null;
        Object char_literal65_tree=null;
        Object set66_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:871:2: ( ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? | ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer] )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0 >= 68 && LA18_0 <= 69)) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==ID) ) {
                    int LA18_2 = input.LA(3);

                    if ( ((LA18_2 >= 20 && LA18_2 <= 21)||LA18_2==24||LA18_2==32) ) {
                        alt18=1;
                    }
                    else if ( (LA18_2==23||LA18_2==25||LA18_2==35) ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:871:4: ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )?
                    {
                    root_0 = (Object)adaptor.nil();


                    set63=(Token)input.LT(1);

                    if ( (input.LA(1) >= 68 && input.LA(1) <= 69) ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set63)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_partTypeDeclaration996); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:871:38: ( '(' (lstToken= listOfIDs[defer] )? ')' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==20) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:871:39: '(' (lstToken= listOfIDs[defer] )? ')'
                            {
                            char_literal64=(Token)match(input,20,FOLLOW_20_in_partTypeDeclaration999); 
                            char_literal64_tree = 
                            (Object)adaptor.create(char_literal64)
                            ;
                            adaptor.addChild(root_0, char_literal64_tree);


                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:871:43: (lstToken= listOfIDs[defer] )?
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( (LA16_0==ID) ) {
                                alt16=1;
                            }
                            switch (alt16) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:871:44: lstToken= listOfIDs[defer]
                                    {
                                    pushFollow(FOLLOW_listOfIDs_in_partTypeDeclaration1004);
                                    lstToken=listOfIDs(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, lstToken.getTree());

                                    }
                                    break;

                            }


                            char_literal65=(Token)match(input,21,FOLLOW_21_in_partTypeDeclaration1009); 
                            char_literal65_tree = 
                            (Object)adaptor.create(char_literal65)
                            ;
                            adaptor.addChild(root_0, char_literal65_tree);


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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:878:11: ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    set66=(Token)input.LT(1);

                    if ( (input.LA(1) >= 68 && input.LA(1) <= 69) ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set66)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_partTypeDeclaration1033); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    pushFollow(FOLLOW_assignment_in_partTypeDeclaration1037);
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
            e.printStackTrace();
            this.cleanUp(1);	
                    
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partTypeDeclaration"


    public static class listOfIDs_return extends ParserRuleReturnScope {
        public List<NamedElement> lstElements;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfIDs"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:893:1: listOfIDs[boolean defer] returns [List<NamedElement> lstElements] : idToken= ID ( ',' lstToken= listOfIDs[defer] )? ;
    public final EugeneParser.listOfIDs_return listOfIDs(boolean defer) throws RecognitionException {
        EugeneParser.listOfIDs_return retval = new EugeneParser.listOfIDs_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal67=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object idToken_tree=null;
        Object char_literal67_tree=null;


        retval.lstElements =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:897:2: (idToken= ID ( ',' lstToken= listOfIDs[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:897:4: idToken= ID ( ',' lstToken= listOfIDs[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfIDs1071); 
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:907:5: ( ',' lstToken= listOfIDs[defer] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:907:6: ',' lstToken= listOfIDs[defer]
                    {
                    char_literal67=(Token)match(input,24,FOLLOW_24_in_listOfIDs1077); 
                    char_literal67_tree = 
                    (Object)adaptor.create(char_literal67)
                    ;
                    adaptor.addChild(root_0, char_literal67_tree);


                    pushFollow(FOLLOW_listOfIDs_in_listOfIDs1081);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:917:1: deviceDeclaration[boolean defer] returns [Device objDevice] : 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )? ;
    public final EugeneParser.deviceDeclaration_return deviceDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.deviceDeclaration_return retval = new EugeneParser.deviceDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal68=null;
        Token char_literal69=null;
        Token char_literal70=null;
        EugeneParser.deviceComponents_return compToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object nameToken_tree=null;
        Object string_literal68_tree=null;
        Object char_literal69_tree=null;
        Object char_literal70_tree=null;


        retval.objDevice = (Device)null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:922:2: ( 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:922:4: 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal68=(Token)match(input,47,FOLLOW_47_in_deviceDeclaration1112); 
            string_literal68_tree = 
            (Object)adaptor.create(string_literal68)
            ;
            adaptor.addChild(root_0, string_literal68_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_deviceDeclaration1116); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:923:3: ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )?
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==20) ) {
                alt21=1;
            }
            else if ( (LA21_0==23||LA21_0==25||LA21_0==35) ) {
                alt21=2;
            }
            switch (alt21) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:923:4: '(' (compToken= deviceComponents[defer] )? ')'
                    {
                    char_literal69=(Token)match(input,20,FOLLOW_20_in_deviceDeclaration1122); 
                    char_literal69_tree = 
                    (Object)adaptor.create(char_literal69)
                    ;
                    adaptor.addChild(root_0, char_literal69_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:923:8: (compToken= deviceComponents[defer] )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==FLOAT||LA20_0==ID||LA20_0==INT||LA20_0==STRING||LA20_0==20||LA20_0==23||LA20_0==25||LA20_0==47||(LA20_0 >= 68 && LA20_0 <= 70)||LA20_0==78||LA20_0==86||LA20_0==109) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:923:9: compToken= deviceComponents[defer]
                            {
                            pushFollow(FOLLOW_deviceComponents_in_deviceDeclaration1127);
                            compToken=deviceComponents(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, compToken.getTree());


                            if(!defer) {
                                // here we need to delete the first element of the directions array
                            //    char[] dirs = ArrayUtils.remove((compToken!=null?compToken.directions:null), 0);
                                
                                retval.objDevice = interp.createDevice(
                                    (nameToken!=null?nameToken.getText():null), 
                                    (compToken!=null?compToken.lstElements:null), 
                                    (compToken!=null?compToken.directions:null));
                            }	
                            	

                            }
                            break;

                    }


                    char_literal70=(Token)match(input,21,FOLLOW_21_in_deviceDeclaration1135); 
                    char_literal70_tree = 
                    (Object)adaptor.create(char_literal70)
                    ;
                    adaptor.addChild(root_0, char_literal70_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:934:11: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_deviceDeclaration1149);
                    assignToken=assignment(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assignToken.getTree());


                    if(!defer) {
                        retval.objDevice = interp.createDevice((nameToken!=null?nameToken.getText():null), (List<NamedElement>)null, (char[])null); 
                        interp.assign((nameToken!=null?nameToken.getText():null), (assignToken!=null?assignToken.objElement:null));
                    }    	
                        	

                    }
                    break;

            }



            if(!defer && null == retval.objDevice) {
                retval.objDevice = interp.createDevice((nameToken!=null?nameToken.getText():null), (List<NamedElement>)null, (char[])null);
            }     	
                	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getCharPositionInLine():0)+
                     " => "+e.getMessage());
            e.printStackTrace();
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
        public char[] directions;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "deviceComponents"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:953:1: deviceComponents[boolean defer] returns [ArrayList<NamedElement> lstElements, char[] directions] : (directionToken= ( '-' | '+' ) )? (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )? ;
    public final EugeneParser.deviceComponents_return deviceComponents(boolean defer) throws RecognitionException {
        EugeneParser.deviceComponents_return retval = new EugeneParser.deviceComponents_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token directionToken=null;
        Token char_literal71=null;
        EugeneParser.expressionValue_return objToken =null;

        EugeneParser.partTypeDeclaration_return partTypeToken =null;

        EugeneParser.instantiationStatement_return instToken =null;

        EugeneParser.propertyDeclaration_return propertyToken =null;

        EugeneParser.deviceDeclaration_return deviceToken =null;

        EugeneParser.deviceComponents_return compToken =null;


        Object directionToken_tree=null;
        Object char_literal71_tree=null;


        retval.lstElements = new ArrayList<NamedElement>();
        NamedElement objElement = null;
        retval.directions = new char[1];

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:963:2: ( (directionToken= ( '-' | '+' ) )? (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:963:4: (directionToken= ( '-' | '+' ) )? (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:963:4: (directionToken= ( '-' | '+' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==23||LA22_0==25) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:963:5: directionToken= ( '-' | '+' )
                    {
                    directionToken=(Token)input.LT(1);

                    if ( input.LA(1)==23||input.LA(1)==25 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(directionToken)
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


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:964:3: (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] )
            int alt23=5;
            switch ( input.LA(1) ) {
            case FLOAT:
            case INT:
            case STRING:
            case 20:
            case 25:
            case 78:
            case 86:
            case 109:
                {
                alt23=1;
                }
                break;
            case ID:
                {
                int LA23_2 = input.LA(2);

                if ( (LA23_2==21||LA23_2==24||LA23_2==26||LA23_2==78) ) {
                    alt23=1;
                }
                else if ( (LA23_2==DYNAMIC_NAME||LA23_2==ID) ) {
                    alt23=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 2, input);

                    throw nvae;

                }
                }
                break;
            case 68:
            case 69:
                {
                alt23=2;
                }
                break;
            case 70:
                {
                alt23=4;
                }
                break;
            case 47:
                {
                alt23=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:964:4: objToken= expressionValue[defer]
                    {
                    pushFollow(FOLLOW_expressionValue_in_deviceComponents1210);
                    objToken=expressionValue(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, objToken.getTree());


                    if(!defer) {	
                        objElement = (objToken!=null?objToken.objElement:null);
                    }
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:969:4: partTypeToken= partTypeDeclaration[defer]
                    {
                    pushFollow(FOLLOW_partTypeDeclaration_in_deviceComponents1221);
                    partTypeToken=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeToken.getTree());


                    if(!defer) {
                        objElement = (partTypeToken!=null?partTypeToken.objPartType:null);
                    }    
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:974:4: instToken= instantiationStatement[defer]
                    {
                    pushFollow(FOLLOW_instantiationStatement_in_deviceComponents1231);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        objElement = (instToken!=null?instToken.objComponent:null);
                    }    
                        	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:979:4: propertyToken= propertyDeclaration[defer]
                    {
                    pushFollow(FOLLOW_propertyDeclaration_in_deviceComponents1241);
                    propertyToken=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyToken.getTree());


                    if(!defer) {
                        objElement = (propertyToken!=null?propertyToken.objProperty:null);
                    }    
                        	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:984:4: deviceToken= deviceDeclaration[defer]
                    {
                    pushFollow(FOLLOW_deviceDeclaration_in_deviceComponents1251);
                    deviceToken=deviceDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());


                    if(!defer) {
                        objElement = (deviceToken!=null?deviceToken.objDevice:null);
                    }    
                    	

                    }
                    break;

            }



            if(!defer) {
                if(objElement instanceof Component) {    
                    if(directionToken != null) {
                        if("-".equals((directionToken!=null?directionToken.getText():null))) {
                            retval.directions = ArrayUtils.add(retval.directions, '-');
                        } else {
                            retval.directions = ArrayUtils.add(retval.directions, '+');
                        }
                    } else {
                        retval.directions = ArrayUtils.add(retval.directions, '+');
                    }
                }
                retval.lstElements.add(objElement);
            }	
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1003:4: ( ',' compToken= deviceComponents[defer] )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==24) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1003:5: ',' compToken= deviceComponents[defer]
                    {
                    char_literal71=(Token)match(input,24,FOLLOW_24_in_deviceComponents1261); 
                    char_literal71_tree = 
                    (Object)adaptor.create(char_literal71)
                    ;
                    adaptor.addChild(root_0, char_literal71_tree);


                    pushFollow(FOLLOW_deviceComponents_in_deviceComponents1265);
                    compToken=deviceComponents(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, compToken.getTree());


                    if(!defer) {
                        retval.lstElements.addAll((compToken!=null?compToken.lstElements:null));
                        retval.directions = ArrayUtils.addAll(retval.directions, (compToken!=null?compToken.directions:null));
                    }	
                    	

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


            retval.directions = ArrayUtils.remove(retval.directions, 0);

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1011:1: deviceTypeDeclaration[boolean defer] returns [DeviceType objDeviceType] : 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')' ;
    public final EugeneParser.deviceTypeDeclaration_return deviceTypeDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.deviceTypeDeclaration_return retval = new EugeneParser.deviceTypeDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token string_literal72=null;
        Token char_literal73=null;
        Token char_literal74=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object idToken_tree=null;
        Object string_literal72_tree=null;
        Object char_literal73_tree=null;
        Object char_literal74_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1013:2: ( 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1013:4: 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal72=(Token)match(input,48,FOLLOW_48_in_deviceTypeDeclaration1291); 
            string_literal72_tree = 
            (Object)adaptor.create(string_literal72)
            ;
            adaptor.addChild(root_0, string_literal72_tree);


            idToken=(Token)match(input,ID,FOLLOW_ID_in_deviceTypeDeclaration1295); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal73=(Token)match(input,20,FOLLOW_20_in_deviceTypeDeclaration1297); 
            char_literal73_tree = 
            (Object)adaptor.create(char_literal73)
            ;
            adaptor.addChild(root_0, char_literal73_tree);


            pushFollow(FOLLOW_listOfIDs_in_deviceTypeDeclaration1301);
            lstToken=listOfIDs(defer);

            state._fsp--;

            adaptor.addChild(root_0, lstToken.getTree());

            char_literal74=(Token)match(input,21,FOLLOW_21_in_deviceTypeDeclaration1304); 
            char_literal74_tree = 
            (Object)adaptor.create(char_literal74)
            ;
            adaptor.addChild(root_0, char_literal74_tree);



            if(!defer) {
                interp.createDeviceType(
                        (idToken!=null?idToken.getText():null), 
                        (lstToken!=null?lstToken.lstElements:null),
                        (char[])null);
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println((idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                e.getMessage());
            e.printStackTrace();
            	
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1029:1: arrayDeclaration[boolean defer] returns [NamedElement objArray] : typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1034:2: (typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1034:4: typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_arrayType_in_arrayDeclaration1339);
            typeToken=arrayType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            nameToken=(Token)match(input,ID,FOLLOW_ID_in_arrayDeclaration1343); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1034:37: (assignToken= assignment[defer] )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==23||LA25_0==25||LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1034:38: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_arrayDeclaration1348);
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1051:1: arrayType : ( 'Device' '[' ']' | 'PartType' '[' ']' | 'Part' '[' ']' | 'Property' '[' ']' | 'Rule' '[' ']' | ID '[' ']' );
    public final EugeneParser.arrayType_return arrayType() throws RecognitionException {
        EugeneParser.arrayType_return retval = new EugeneParser.arrayType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal75=null;
        Token char_literal76=null;
        Token char_literal77=null;
        Token string_literal78=null;
        Token char_literal79=null;
        Token char_literal80=null;
        Token string_literal81=null;
        Token char_literal82=null;
        Token char_literal83=null;
        Token string_literal84=null;
        Token char_literal85=null;
        Token char_literal86=null;
        Token string_literal87=null;
        Token char_literal88=null;
        Token char_literal89=null;
        Token ID90=null;
        Token char_literal91=null;
        Token char_literal92=null;

        Object string_literal75_tree=null;
        Object char_literal76_tree=null;
        Object char_literal77_tree=null;
        Object string_literal78_tree=null;
        Object char_literal79_tree=null;
        Object char_literal80_tree=null;
        Object string_literal81_tree=null;
        Object char_literal82_tree=null;
        Object char_literal83_tree=null;
        Object string_literal84_tree=null;
        Object char_literal85_tree=null;
        Object char_literal86_tree=null;
        Object string_literal87_tree=null;
        Object char_literal88_tree=null;
        Object char_literal89_tree=null;
        Object ID90_tree=null;
        Object char_literal91_tree=null;
        Object char_literal92_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1052:2: ( 'Device' '[' ']' | 'PartType' '[' ']' | 'Part' '[' ']' | 'Property' '[' ']' | 'Rule' '[' ']' | ID '[' ']' )
            int alt26=6;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt26=1;
                }
                break;
            case 69:
                {
                alt26=2;
                }
                break;
            case 68:
                {
                alt26=3;
                }
                break;
            case 70:
                {
                alt26=4;
                }
                break;
            case 72:
                {
                alt26=5;
                }
                break;
            case ID:
                {
                alt26=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1052:4: 'Device' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal75=(Token)match(input,47,FOLLOW_47_in_arrayType1372); 
                    string_literal75_tree = 
                    (Object)adaptor.create(string_literal75)
                    ;
                    adaptor.addChild(root_0, string_literal75_tree);


                    char_literal76=(Token)match(input,78,FOLLOW_78_in_arrayType1374); 
                    char_literal76_tree = 
                    (Object)adaptor.create(char_literal76)
                    ;
                    adaptor.addChild(root_0, char_literal76_tree);


                    char_literal77=(Token)match(input,79,FOLLOW_79_in_arrayType1376); 
                    char_literal77_tree = 
                    (Object)adaptor.create(char_literal77)
                    ;
                    adaptor.addChild(root_0, char_literal77_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1053:4: 'PartType' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal78=(Token)match(input,69,FOLLOW_69_in_arrayType1381); 
                    string_literal78_tree = 
                    (Object)adaptor.create(string_literal78)
                    ;
                    adaptor.addChild(root_0, string_literal78_tree);


                    char_literal79=(Token)match(input,78,FOLLOW_78_in_arrayType1383); 
                    char_literal79_tree = 
                    (Object)adaptor.create(char_literal79)
                    ;
                    adaptor.addChild(root_0, char_literal79_tree);


                    char_literal80=(Token)match(input,79,FOLLOW_79_in_arrayType1385); 
                    char_literal80_tree = 
                    (Object)adaptor.create(char_literal80)
                    ;
                    adaptor.addChild(root_0, char_literal80_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1054:4: 'Part' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal81=(Token)match(input,68,FOLLOW_68_in_arrayType1390); 
                    string_literal81_tree = 
                    (Object)adaptor.create(string_literal81)
                    ;
                    adaptor.addChild(root_0, string_literal81_tree);


                    char_literal82=(Token)match(input,78,FOLLOW_78_in_arrayType1392); 
                    char_literal82_tree = 
                    (Object)adaptor.create(char_literal82)
                    ;
                    adaptor.addChild(root_0, char_literal82_tree);


                    char_literal83=(Token)match(input,79,FOLLOW_79_in_arrayType1394); 
                    char_literal83_tree = 
                    (Object)adaptor.create(char_literal83)
                    ;
                    adaptor.addChild(root_0, char_literal83_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1055:4: 'Property' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal84=(Token)match(input,70,FOLLOW_70_in_arrayType1399); 
                    string_literal84_tree = 
                    (Object)adaptor.create(string_literal84)
                    ;
                    adaptor.addChild(root_0, string_literal84_tree);


                    char_literal85=(Token)match(input,78,FOLLOW_78_in_arrayType1401); 
                    char_literal85_tree = 
                    (Object)adaptor.create(char_literal85)
                    ;
                    adaptor.addChild(root_0, char_literal85_tree);


                    char_literal86=(Token)match(input,79,FOLLOW_79_in_arrayType1403); 
                    char_literal86_tree = 
                    (Object)adaptor.create(char_literal86)
                    ;
                    adaptor.addChild(root_0, char_literal86_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1056:4: 'Rule' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal87=(Token)match(input,72,FOLLOW_72_in_arrayType1408); 
                    string_literal87_tree = 
                    (Object)adaptor.create(string_literal87)
                    ;
                    adaptor.addChild(root_0, string_literal87_tree);


                    char_literal88=(Token)match(input,78,FOLLOW_78_in_arrayType1410); 
                    char_literal88_tree = 
                    (Object)adaptor.create(char_literal88)
                    ;
                    adaptor.addChild(root_0, char_literal88_tree);


                    char_literal89=(Token)match(input,79,FOLLOW_79_in_arrayType1412); 
                    char_literal89_tree = 
                    (Object)adaptor.create(char_literal89)
                    ;
                    adaptor.addChild(root_0, char_literal89_tree);


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1057:4: ID '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    ID90=(Token)match(input,ID,FOLLOW_ID_in_arrayType1417); 
                    ID90_tree = 
                    (Object)adaptor.create(ID90)
                    ;
                    adaptor.addChild(root_0, ID90_tree);


                    char_literal91=(Token)match(input,78,FOLLOW_78_in_arrayType1419); 
                    char_literal91_tree = 
                    (Object)adaptor.create(char_literal91)
                    ;
                    adaptor.addChild(root_0, char_literal91_tree);


                    char_literal92=(Token)match(input,79,FOLLOW_79_in_arrayType1421); 
                    char_literal92_tree = 
                    (Object)adaptor.create(char_literal92)
                    ;
                    adaptor.addChild(root_0, char_literal92_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1062:1: ruleDeclaration[boolean defer] : 'Rule' ruleNameToken= ID '(' ( 'ON' deviceToken= ID ':' )? exprToken= expression[true] ')' ;
    public final EugeneParser.ruleDeclaration_return ruleDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.ruleDeclaration_return retval = new EugeneParser.ruleDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ruleNameToken=null;
        Token deviceToken=null;
        Token string_literal93=null;
        Token char_literal94=null;
        Token string_literal95=null;
        Token char_literal96=null;
        Token char_literal97=null;
        EugeneParser.expression_return exprToken =null;


        Object ruleNameToken_tree=null;
        Object deviceToken_tree=null;
        Object string_literal93_tree=null;
        Object char_literal94_tree=null;
        Object string_literal95_tree=null;
        Object char_literal96_tree=null;
        Object char_literal97_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1063:2: ( 'Rule' ruleNameToken= ID '(' ( 'ON' deviceToken= ID ':' )? exprToken= expression[true] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1063:4: 'Rule' ruleNameToken= ID '(' ( 'ON' deviceToken= ID ':' )? exprToken= expression[true] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal93=(Token)match(input,72,FOLLOW_72_in_ruleDeclaration1437); 
            string_literal93_tree = 
            (Object)adaptor.create(string_literal93)
            ;
            adaptor.addChild(root_0, string_literal93_tree);


            ruleNameToken=(Token)match(input,ID,FOLLOW_ID_in_ruleDeclaration1441); 
            ruleNameToken_tree = 
            (Object)adaptor.create(ruleNameToken)
            ;
            adaptor.addChild(root_0, ruleNameToken_tree);


            char_literal94=(Token)match(input,20,FOLLOW_20_in_ruleDeclaration1443); 
            char_literal94_tree = 
            (Object)adaptor.create(char_literal94)
            ;
            adaptor.addChild(root_0, char_literal94_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1064:4: ( 'ON' deviceToken= ID ':' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==65) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1064:5: 'ON' deviceToken= ID ':'
                    {
                    string_literal95=(Token)match(input,65,FOLLOW_65_in_ruleDeclaration1450); 
                    string_literal95_tree = 
                    (Object)adaptor.create(string_literal95)
                    ;
                    adaptor.addChild(root_0, string_literal95_tree);


                    deviceToken=(Token)match(input,ID,FOLLOW_ID_in_ruleDeclaration1454); 
                    deviceToken_tree = 
                    (Object)adaptor.create(deviceToken)
                    ;
                    adaptor.addChild(root_0, deviceToken_tree);


                    char_literal96=(Token)match(input,31,FOLLOW_31_in_ruleDeclaration1456); 
                    char_literal96_tree = 
                    (Object)adaptor.create(char_literal96)
                    ;
                    adaptor.addChild(root_0, char_literal96_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_ruleDeclaration1467);
            exprToken=expression(true);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {    
                interp.createRule((ruleNameToken!=null?ruleNameToken.getText():null), 
                        (deviceToken!=null?deviceToken.getText():null), 
                        exprToken.start, 
                        (CommonTree)(exprToken!=null?((Object)exprToken.tree):null));    
            }
                    

            char_literal97=(Token)match(input,21,FOLLOW_21_in_ruleDeclaration1472); 
            char_literal97_tree = 
            (Object)adaptor.create(char_literal97)
            ;
            adaptor.addChild(root_0, char_literal97_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+(ruleNameToken!=null?ruleNameToken.getLine():0)+":"+(ruleNameToken!=null?ruleNameToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);
                    
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleDeclaration"


    public static class folExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "folExpression"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1081:1: folExpression[boolean defer] : ( ( 'FORALL' ^fToken= listOfIDs[defer] ) ( 'EXISTS' ^eToken= listOfIDs[defer] )? ':' | ( 'EXISTS' ^eToken= listOfIDs[defer] ) ':' );
    public final EugeneParser.folExpression_return folExpression(boolean defer) throws RecognitionException {
        EugeneParser.folExpression_return retval = new EugeneParser.folExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal98=null;
        Token string_literal99=null;
        Token char_literal100=null;
        Token string_literal101=null;
        Token char_literal102=null;
        EugeneParser.listOfIDs_return fToken =null;

        EugeneParser.listOfIDs_return eToken =null;


        Object string_literal98_tree=null;
        Object string_literal99_tree=null;
        Object char_literal100_tree=null;
        Object string_literal101_tree=null;
        Object char_literal102_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1082:2: ( ( 'FORALL' ^fToken= listOfIDs[defer] ) ( 'EXISTS' ^eToken= listOfIDs[defer] )? ':' | ( 'EXISTS' ^eToken= listOfIDs[defer] ) ':' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==52) ) {
                alt29=1;
            }
            else if ( (LA29_0==51) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1082:4: ( 'FORALL' ^fToken= listOfIDs[defer] ) ( 'EXISTS' ^eToken= listOfIDs[defer] )? ':'
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1082:4: ( 'FORALL' ^fToken= listOfIDs[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1082:5: 'FORALL' ^fToken= listOfIDs[defer]
                    {
                    string_literal98=(Token)match(input,52,FOLLOW_52_in_folExpression1521); 
                    string_literal98_tree = 
                    (Object)adaptor.create(string_literal98)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(string_literal98_tree, root_0);


                    pushFollow(FOLLOW_listOfIDs_in_folExpression1526);
                    fToken=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, fToken.getTree());

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1082:40: ( 'EXISTS' ^eToken= listOfIDs[defer] )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==51) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1082:41: 'EXISTS' ^eToken= listOfIDs[defer]
                            {
                            string_literal99=(Token)match(input,51,FOLLOW_51_in_folExpression1531); 
                            string_literal99_tree = 
                            (Object)adaptor.create(string_literal99)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(string_literal99_tree, root_0);


                            pushFollow(FOLLOW_listOfIDs_in_folExpression1536);
                            eToken=listOfIDs(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, eToken.getTree());

                            }
                            break;

                    }


                    char_literal100=(Token)match(input,31,FOLLOW_31_in_folExpression1541); 
                    char_literal100_tree = 
                    (Object)adaptor.create(char_literal100)
                    ;
                    adaptor.addChild(root_0, char_literal100_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1083:4: ( 'EXISTS' ^eToken= listOfIDs[defer] ) ':'
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1083:4: ( 'EXISTS' ^eToken= listOfIDs[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1083:5: 'EXISTS' ^eToken= listOfIDs[defer]
                    {
                    string_literal101=(Token)match(input,51,FOLLOW_51_in_folExpression1548); 
                    string_literal101_tree = 
                    (Object)adaptor.create(string_literal101)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(string_literal101_tree, root_0);


                    pushFollow(FOLLOW_listOfIDs_in_folExpression1553);
                    eToken=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, eToken.getTree());

                    }


                    char_literal102=(Token)match(input,31,FOLLOW_31_in_folExpression1557); 
                    char_literal102_tree = 
                    (Object)adaptor.create(char_literal102)
                    ;
                    adaptor.addChild(root_0, char_literal102_tree);


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
    // $ANTLR end "folExpression"


    public static class onDeviceRule_return extends ParserRuleReturnScope {
        public Rule objRule;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "onDeviceRule"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1086:1: onDeviceRule[boolean defer] returns [Rule objRule] : ( 'ON' deviceToken= ID ':' )? exprToken= expression[true] ;
    public final EugeneParser.onDeviceRule_return onDeviceRule(boolean defer) throws EugeneException, RecognitionException {
        EugeneParser.onDeviceRule_return retval = new EugeneParser.onDeviceRule_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token deviceToken=null;
        Token string_literal103=null;
        Token char_literal104=null;
        EugeneParser.expression_return exprToken =null;


        Object deviceToken_tree=null;
        Object string_literal103_tree=null;
        Object char_literal104_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1089:2: ( ( 'ON' deviceToken= ID ':' )? exprToken= expression[true] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1089:4: ( 'ON' deviceToken= ID ':' )? exprToken= expression[true]
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1089:4: ( 'ON' deviceToken= ID ':' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==65) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1089:5: 'ON' deviceToken= ID ':'
                    {
                    string_literal103=(Token)match(input,65,FOLLOW_65_in_onDeviceRule1598); 
                    string_literal103_tree = 
                    (Object)adaptor.create(string_literal103)
                    ;
                    adaptor.addChild(root_0, string_literal103_tree);


                    deviceToken=(Token)match(input,ID,FOLLOW_ID_in_onDeviceRule1602); 
                    deviceToken_tree = 
                    (Object)adaptor.create(deviceToken)
                    ;
                    adaptor.addChild(root_0, deviceToken_tree);


                    char_literal104=(Token)match(input,31,FOLLOW_31_in_onDeviceRule1604); 
                    char_literal104_tree = 
                    (Object)adaptor.create(char_literal104)
                    ;
                    adaptor.addChild(root_0, char_literal104_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_onDeviceRule1610);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1102:1: imageDeclaration[boolean defer] : 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')' ;
    public final EugeneParser.imageDeclaration_return imageDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.imageDeclaration_return retval = new EugeneParser.imageDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token imageNameToken=null;
        Token imagePathToken=null;
        Token string_literal105=null;
        Token char_literal106=null;
        Token char_literal107=null;
        Token char_literal108=null;

        Object imageNameToken_tree=null;
        Object imagePathToken_tree=null;
        Object string_literal105_tree=null;
        Object char_literal106_tree=null;
        Object char_literal107_tree=null;
        Object char_literal108_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1103:2: ( 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1103:4: 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal105=(Token)match(input,56,FOLLOW_56_in_imageDeclaration1633); 
            string_literal105_tree = 
            (Object)adaptor.create(string_literal105)
            ;
            adaptor.addChild(root_0, string_literal105_tree);


            char_literal106=(Token)match(input,20,FOLLOW_20_in_imageDeclaration1635); 
            char_literal106_tree = 
            (Object)adaptor.create(char_literal106)
            ;
            adaptor.addChild(root_0, char_literal106_tree);


            imageNameToken=(Token)match(input,ID,FOLLOW_ID_in_imageDeclaration1639); 
            imageNameToken_tree = 
            (Object)adaptor.create(imageNameToken)
            ;
            adaptor.addChild(root_0, imageNameToken_tree);


            char_literal107=(Token)match(input,24,FOLLOW_24_in_imageDeclaration1641); 
            char_literal107_tree = 
            (Object)adaptor.create(char_literal107)
            ;
            adaptor.addChild(root_0, char_literal107_tree);


            imagePathToken=(Token)match(input,STRING,FOLLOW_STRING_in_imageDeclaration1645); 
            imagePathToken_tree = 
            (Object)adaptor.create(imagePathToken)
            ;
            adaptor.addChild(root_0, imagePathToken_tree);


            char_literal108=(Token)match(input,21,FOLLOW_21_in_imageDeclaration1647); 
            char_literal108_tree = 
            (Object)adaptor.create(char_literal108)
            ;
            adaptor.addChild(root_0, char_literal108_tree);



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


    public static class relationDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relationDeclaration"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1112:1: relationDeclaration[boolean defer] : lhsToken= ID relationToken= relationtype rhsToken= ID ;
    public final EugeneParser.relationDeclaration_return relationDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.relationDeclaration_return retval = new EugeneParser.relationDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token lhsToken=null;
        Token rhsToken=null;
        EugeneParser.relationtype_return relationToken =null;


        Object lhsToken_tree=null;
        Object rhsToken_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1113:2: (lhsToken= ID relationToken= relationtype rhsToken= ID )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1113:4: lhsToken= ID relationToken= relationtype rhsToken= ID
            {
            root_0 = (Object)adaptor.nil();


            lhsToken=(Token)match(input,ID,FOLLOW_ID_in_relationDeclaration1665); 
            lhsToken_tree = 
            (Object)adaptor.create(lhsToken)
            ;
            adaptor.addChild(root_0, lhsToken_tree);


            pushFollow(FOLLOW_relationtype_in_relationDeclaration1669);
            relationToken=relationtype();

            state._fsp--;

            adaptor.addChild(root_0, relationToken.getTree());

            rhsToken=(Token)match(input,ID,FOLLOW_ID_in_relationDeclaration1673); 
            rhsToken_tree = 
            (Object)adaptor.create(rhsToken)
            ;
            adaptor.addChild(root_0, rhsToken_tree);



            if(!defer) {
                interp.createRelation((lhsToken!=null?lhsToken.getText():null), (relationToken!=null?input.toString(relationToken.start,relationToken.stop):null), (rhsToken!=null?rhsToken.getText():null));
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(lhsToken!=null?lhsToken.getLine():0)+":"+(lhsToken!=null?lhsToken.getCharPositionInLine():0)+" => "+e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);
            	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "relationDeclaration"


    public static class relationtype_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relationtype"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1126:1: relationtype : ( 'REPRESSES' | 'INDUCES' | 'DRIVES' | 'BINDS' | 'ORTHO' );
    public final EugeneParser.relationtype_return relationtype() throws RecognitionException {
        EugeneParser.relationtype_return retval = new EugeneParser.relationtype_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set109=null;

        Object set109_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1127:2: ( 'REPRESSES' | 'INDUCES' | 'DRIVES' | 'BINDS' | 'ORTHO' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:
            {
            root_0 = (Object)adaptor.nil();


            set109=(Token)input.LT(1);

            if ( input.LA(1)==43||input.LA(1)==46||input.LA(1)==54||input.LA(1)==67||input.LA(1)==71 ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set109)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "relationtype"


    public static class assertStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assertStatement"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1139:1: assertStatement[boolean defer] : assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' ;
    public final EugeneParser.assertStatement_return assertStatement(boolean defer) throws RecognitionException {
        EugeneParser.assertStatement_return retval = new EugeneParser.assertStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token assertToken=null;
        Token char_literal110=null;
        Token string_literal111=null;
        Token char_literal112=null;
        Token char_literal113=null;
        EugeneParser.expression_return deviceToken =null;

        EugeneParser.listOfIDs_return lstRules =null;


        Object assertToken_tree=null;
        Object char_literal110_tree=null;
        Object string_literal111_tree=null;
        Object char_literal112_tree=null;
        Object char_literal113_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1140:2: (assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1140:4: assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            assertToken=(Token)match(input,41,FOLLOW_41_in_assertStatement1733); 
            assertToken_tree = 
            (Object)adaptor.create(assertToken)
            ;
            adaptor.addChild(root_0, assertToken_tree);


            char_literal110=(Token)match(input,20,FOLLOW_20_in_assertStatement1735); 
            char_literal110_tree = 
            (Object)adaptor.create(char_literal110)
            ;
            adaptor.addChild(root_0, char_literal110_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1140:29: ( 'ON' deviceToken= expression[defer] ':' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==65) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1140:30: 'ON' deviceToken= expression[defer] ':'
                    {
                    string_literal111=(Token)match(input,65,FOLLOW_65_in_assertStatement1738); 
                    string_literal111_tree = 
                    (Object)adaptor.create(string_literal111)
                    ;
                    adaptor.addChild(root_0, string_literal111_tree);


                    pushFollow(FOLLOW_expression_in_assertStatement1742);
                    deviceToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    char_literal112=(Token)match(input,31,FOLLOW_31_in_assertStatement1745); 
                    char_literal112_tree = 
                    (Object)adaptor.create(char_literal112)
                    ;
                    adaptor.addChild(root_0, char_literal112_tree);


                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1140:79: (lstRules= listOfIDs[defer] )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1140:79: lstRules= listOfIDs[defer]
                    {
                    pushFollow(FOLLOW_listOfIDs_in_assertStatement1751);
                    lstRules=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstRules.getTree());

                    }
                    break;

            }


            char_literal113=(Token)match(input,21,FOLLOW_21_in_assertStatement1755); 
            char_literal113_tree = 
            (Object)adaptor.create(char_literal113)
            ;
            adaptor.addChild(root_0, char_literal113_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1161:1: noteStatement[boolean defer] : noteToken= 'Note' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' ;
    public final EugeneParser.noteStatement_return noteStatement(boolean defer) throws RecognitionException {
        EugeneParser.noteStatement_return retval = new EugeneParser.noteStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token noteToken=null;
        Token char_literal114=null;
        Token string_literal115=null;
        Token char_literal116=null;
        Token char_literal117=null;
        EugeneParser.expression_return deviceToken =null;

        EugeneParser.listOfIDs_return lstRules =null;


        Object noteToken_tree=null;
        Object char_literal114_tree=null;
        Object string_literal115_tree=null;
        Object char_literal116_tree=null;
        Object char_literal117_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1162:2: (noteToken= 'Note' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1162:4: noteToken= 'Note' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            noteToken=(Token)match(input,64,FOLLOW_64_in_noteStatement1788); 
            noteToken_tree = 
            (Object)adaptor.create(noteToken)
            ;
            adaptor.addChild(root_0, noteToken_tree);


            char_literal114=(Token)match(input,20,FOLLOW_20_in_noteStatement1790); 
            char_literal114_tree = 
            (Object)adaptor.create(char_literal114)
            ;
            adaptor.addChild(root_0, char_literal114_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1162:25: ( 'ON' deviceToken= expression[defer] ':' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==65) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1162:26: 'ON' deviceToken= expression[defer] ':'
                    {
                    string_literal115=(Token)match(input,65,FOLLOW_65_in_noteStatement1793); 
                    string_literal115_tree = 
                    (Object)adaptor.create(string_literal115)
                    ;
                    adaptor.addChild(root_0, string_literal115_tree);


                    pushFollow(FOLLOW_expression_in_noteStatement1797);
                    deviceToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    char_literal116=(Token)match(input,31,FOLLOW_31_in_noteStatement1800); 
                    char_literal116_tree = 
                    (Object)adaptor.create(char_literal116)
                    ;
                    adaptor.addChild(root_0, char_literal116_tree);


                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1162:75: (lstRules= listOfIDs[defer] )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==ID) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1162:75: lstRules= listOfIDs[defer]
                    {
                    pushFollow(FOLLOW_listOfIDs_in_noteStatement1806);
                    lstRules=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstRules.getTree());

                    }
                    break;

            }


            char_literal117=(Token)match(input,21,FOLLOW_21_in_noteStatement1810); 
            char_literal117_tree = 
            (Object)adaptor.create(char_literal117)
            ;
            adaptor.addChild(root_0, char_literal117_tree);


            	
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1188:1: instantiationStatement[boolean defer] returns [Component objComponent] : typeToken= ID instanceToken= instanceDefinitionStatement[defer, objElement] ;
    public final EugeneParser.instantiationStatement_return instantiationStatement(boolean defer) throws RecognitionException {
        EugeneParser.instantiationStatement_return retval = new EugeneParser.instantiationStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token typeToken=null;
        EugeneParser.instanceDefinitionStatement_return instanceToken =null;


        Object typeToken_tree=null;


        NamedElement objElement = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1192:2: (typeToken= ID instanceToken= instanceDefinitionStatement[defer, objElement] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1192:4: typeToken= ID instanceToken= instanceDefinitionStatement[defer, objElement]
            {
            root_0 = (Object)adaptor.nil();


            typeToken=(Token)match(input,ID,FOLLOW_ID_in_instantiationStatement1849); 
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
            	

            pushFollow(FOLLOW_instanceDefinitionStatement_in_instantiationStatement1857);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1219:1: instanceDefinitionStatement[boolean defer, NamedElement objElement] returns [Component objComponent] : (partToken= partInstantiation[defer, objElement] |deviceToken= deviceInstantiation[defer, objElement] );
    public final EugeneParser.instanceDefinitionStatement_return instanceDefinitionStatement(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.instanceDefinitionStatement_return retval = new EugeneParser.instanceDefinitionStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.partInstantiation_return partToken =null;

        EugeneParser.deviceInstantiation_return deviceToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1221:2: (partToken= partInstantiation[defer, objElement] |deviceToken= deviceInstantiation[defer, objElement] )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==ID) ) {
                int LA35_1 = input.LA(2);

                if ( ((objElement instanceof PartType)) ) {
                    alt35=1;
                }
                else if ( (true) ) {
                    alt35=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA35_0==DYNAMIC_NAME) ) {
                alt35=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1221:4: partToken= partInstantiation[defer, objElement]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partInstantiation_in_instanceDefinitionStatement1881);
                    partToken=partInstantiation(defer, objElement);

                    state._fsp--;

                    adaptor.addChild(root_0, partToken.getTree());


                    if(!defer) {
                        retval.objComponent = (partToken!=null?partToken.objPart:null);
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1226:11: deviceToken= deviceInstantiation[defer, objElement]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceInstantiation_in_instanceDefinitionStatement1898);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1233:1: dynamicNaming[boolean defer] returns [String sName] : (nameToken= ID | DYNAMIC_NAME exprToken= expression[defer] DYNAMIC_NAME );
    public final EugeneParser.dynamicNaming_return dynamicNaming(boolean defer) throws RecognitionException {
        EugeneParser.dynamicNaming_return retval = new EugeneParser.dynamicNaming_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token DYNAMIC_NAME118=null;
        Token DYNAMIC_NAME119=null;
        EugeneParser.expression_return exprToken =null;


        Object nameToken_tree=null;
        Object DYNAMIC_NAME118_tree=null;
        Object DYNAMIC_NAME119_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1235:2: (nameToken= ID | DYNAMIC_NAME exprToken= expression[defer] DYNAMIC_NAME )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==ID) ) {
                alt36=1;
            }
            else if ( (LA36_0==DYNAMIC_NAME) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1235:4: nameToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_dynamicNaming1922); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1240:4: DYNAMIC_NAME exprToken= expression[defer] DYNAMIC_NAME
                    {
                    root_0 = (Object)adaptor.nil();


                    DYNAMIC_NAME118=(Token)match(input,DYNAMIC_NAME,FOLLOW_DYNAMIC_NAME_in_dynamicNaming1929); 
                    DYNAMIC_NAME118_tree = 
                    (Object)adaptor.create(DYNAMIC_NAME118)
                    ;
                    adaptor.addChild(root_0, DYNAMIC_NAME118_tree);


                    pushFollow(FOLLOW_expression_in_dynamicNaming1933);
                    exprToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken.getTree());

                    DYNAMIC_NAME119=(Token)match(input,DYNAMIC_NAME,FOLLOW_DYNAMIC_NAME_in_dynamicNaming1936); 
                    DYNAMIC_NAME119_tree = 
                    (Object)adaptor.create(DYNAMIC_NAME119)
                    ;
                    adaptor.addChild(root_0, DYNAMIC_NAME119_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1259:1: partInstantiation[boolean defer, NamedElement objElement] returns [Part objPart] :{...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] ) ;
    public final EugeneParser.partInstantiation_return partInstantiation(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.partInstantiation_return retval = new EugeneParser.partInstantiation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal120=null;
        Token char_literal121=null;
        EugeneParser.dynamicNaming_return nameToken =null;

        EugeneParser.listOfDotValues_return dotToken =null;

        EugeneParser.listOfValues_return valueToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object char_literal120_tree=null;
        Object char_literal121_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1261:2: ({...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1261:4: {...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] )
            {
            root_0 = (Object)adaptor.nil();


            if ( !((objElement instanceof PartType)) ) {
                throw new FailedPredicateException(input, "partInstantiation", "objElement instanceof PartType");
            }

            pushFollow(FOLLOW_dynamicNaming_in_partInstantiation1966);
            nameToken=dynamicNaming(defer);

            state._fsp--;

            adaptor.addChild(root_0, nameToken.getTree());

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:34: ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0 >= 20 && LA39_0 <= 21)||LA39_0==24||LA39_0==32) ) {
                alt39=1;
            }
            else if ( (LA39_0==23||LA39_0==25||LA39_0==35) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:35: ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:35: ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==20) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:36: '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')'
                            {
                            char_literal120=(Token)match(input,20,FOLLOW_20_in_partInstantiation1971); 
                            char_literal120_tree = 
                            (Object)adaptor.create(char_literal120)
                            ;
                            adaptor.addChild(root_0, char_literal120_tree);


                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:40: (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )?
                            int alt37=3;
                            int LA37_0 = input.LA(1);

                            if ( (LA37_0==26) ) {
                                alt37=1;
                            }
                            else if ( (LA37_0==FLOAT||LA37_0==ID||LA37_0==INT||LA37_0==STRING||LA37_0==18||LA37_0==20||LA37_0==25||(LA37_0 >= 33 && LA37_0 <= 34)||(LA37_0 >= 36 && LA37_0 <= 39)||LA37_0==42||LA37_0==44||(LA37_0 >= 49 && LA37_0 <= 52)||(LA37_0 >= 57 && LA37_0 <= 63)||(LA37_0 >= 74 && LA37_0 <= 76)||LA37_0==78||LA37_0==86||LA37_0==109) ) {
                                alt37=2;
                            }
                            switch (alt37) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:41: dotToken= listOfDotValues[defer]
                                    {
                                    pushFollow(FOLLOW_listOfDotValues_in_partInstantiation1976);
                                    dotToken=listOfDotValues(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, dotToken.getTree());

                                    }
                                    break;
                                case 2 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:75: valueToken= listOfValues[defer]
                                    {
                                    pushFollow(FOLLOW_listOfValues_in_partInstantiation1983);
                                    valueToken=listOfValues(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, valueToken.getTree());

                                    }
                                    break;

                            }


                            char_literal121=(Token)match(input,21,FOLLOW_21_in_partInstantiation1988); 
                            char_literal121_tree = 
                            (Object)adaptor.create(char_literal121)
                            ;
                            adaptor.addChild(root_0, char_literal121_tree);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1263:6: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_partInstantiation2000);
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
            exc.printStackTrace();    
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1298:1: deviceInstantiation[boolean defer, NamedElement objElement] returns [DeviceInstance objDeviceInstance] : instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? ;
    public final EugeneParser.deviceInstantiation_return deviceInstantiation(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.deviceInstantiation_return retval = new EugeneParser.deviceInstantiation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token instToken=null;
        Token char_literal122=null;
        Token char_literal123=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object instToken_tree=null;
        Object char_literal122_tree=null;
        Object char_literal123_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:2: (instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:4: instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )?
            {
            root_0 = (Object)adaptor.nil();


            instToken=(Token)match(input,ID,FOLLOW_ID_in_deviceInstantiation2033); 
            instToken_tree = 
            (Object)adaptor.create(instToken)
            ;
            adaptor.addChild(root_0, instToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:17: ( '(' (lstToken= listOfIDs[defer] )? ')' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==20) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:18: '(' (lstToken= listOfIDs[defer] )? ')'
                    {
                    char_literal122=(Token)match(input,20,FOLLOW_20_in_deviceInstantiation2036); 
                    char_literal122_tree = 
                    (Object)adaptor.create(char_literal122)
                    ;
                    adaptor.addChild(root_0, char_literal122_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:22: (lstToken= listOfIDs[defer] )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==ID) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:23: lstToken= listOfIDs[defer]
                            {
                            pushFollow(FOLLOW_listOfIDs_in_deviceInstantiation2041);
                            lstToken=listOfIDs(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, lstToken.getTree());

                            }
                            break;

                    }


                    char_literal123=(Token)match(input,21,FOLLOW_21_in_deviceInstantiation2046); 
                    char_literal123_tree = 
                    (Object)adaptor.create(char_literal123)
                    ;
                    adaptor.addChild(root_0, char_literal123_tree);


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
                    List<NamedElement> lstElements = (lstToken!=null?lstToken.lstElements:null);
                
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1366:1: listOfDotValues[boolean defer] returns [List<PropertyValue> lstValues] : '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )? ;
    public final EugeneParser.listOfDotValues_return listOfDotValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfDotValues_return retval = new EugeneParser.listOfDotValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token char_literal124=null;
        Token char_literal125=null;
        Token char_literal126=null;
        Token char_literal127=null;
        EugeneParser.expression_return valueToken =null;

        EugeneParser.listOfDotValues_return dotValuesToken =null;


        Object nameToken_tree=null;
        Object char_literal124_tree=null;
        Object char_literal125_tree=null;
        Object char_literal126_tree=null;
        Object char_literal127_tree=null;


        retval.lstValues = new ArrayList<PropertyValue>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1371:2: ( '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1371:4: '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            char_literal124=(Token)match(input,26,FOLLOW_26_in_listOfDotValues2084); 
            char_literal124_tree = 
            (Object)adaptor.create(char_literal124)
            ;
            adaptor.addChild(root_0, char_literal124_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfDotValues2088); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            char_literal125=(Token)match(input,20,FOLLOW_20_in_listOfDotValues2090); 
            char_literal125_tree = 
            (Object)adaptor.create(char_literal125)
            ;
            adaptor.addChild(root_0, char_literal125_tree);


            pushFollow(FOLLOW_expression_in_listOfDotValues2094);
            valueToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, valueToken.getTree());

            char_literal126=(Token)match(input,21,FOLLOW_21_in_listOfDotValues2097); 
            char_literal126_tree = 
            (Object)adaptor.create(char_literal126)
            ;
            adaptor.addChild(root_0, char_literal126_tree);



            if(!defer) {
                retval.lstValues.add(
                    interp.createPropertyValue(
                            (nameToken!=null?nameToken.getText():null), (valueToken!=null?valueToken.objElement:null)));
            }
                    

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1377:12: ( ',' dotValuesToken= listOfDotValues[defer] )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==24) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1377:13: ',' dotValuesToken= listOfDotValues[defer]
                    {
                    char_literal127=(Token)match(input,24,FOLLOW_24_in_listOfDotValues2103); 
                    char_literal127_tree = 
                    (Object)adaptor.create(char_literal127)
                    ;
                    adaptor.addChild(root_0, char_literal127_tree);


                    pushFollow(FOLLOW_listOfDotValues_in_listOfDotValues2107);
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1393:1: listOfValues[boolean defer] returns [List<NamedElement> lstValues] : exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )? ;
    public final EugeneParser.listOfValues_return listOfValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfValues_return retval = new EugeneParser.listOfValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal128=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfValues_return lstToken =null;


        Object char_literal128_tree=null;


        retval.lstValues = new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1398:2: (exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1398:4: exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfValues2148);
            exprToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {
                retval.lstValues.add((exprToken!=null?exprToken.objElement:null));
            }
                    

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1402:11: ( ',' lstToken= listOfValues[defer] )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==24) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1402:12: ',' lstToken= listOfValues[defer]
                    {
                    char_literal128=(Token)match(input,24,FOLLOW_24_in_listOfValues2154); 
                    char_literal128_tree = 
                    (Object)adaptor.create(char_literal128)
                    ;
                    adaptor.addChild(root_0, char_literal128_tree);


                    pushFollow(FOLLOW_listOfValues_in_listOfValues2158);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1413:1: listOfExpressions[boolean defer] returns [ArrayList<NamedElement> lstElements] : exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )? ;
    public final EugeneParser.listOfExpressions_return listOfExpressions(boolean defer) throws RecognitionException {
        EugeneParser.listOfExpressions_return retval = new EugeneParser.listOfExpressions_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal129=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfExpressions_return lstToken =null;


        Object char_literal129_tree=null;


        retval.lstElements = new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1417:2: (exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1417:4: exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfExpressions2190);
            exprToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {
                retval.lstElements.add((exprToken!=null?exprToken.objElement:null));
            }	
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1421:5: ( ',' lstToken= listOfExpressions[defer] )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==24) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1421:6: ',' lstToken= listOfExpressions[defer]
                    {
                    char_literal129=(Token)match(input,24,FOLLOW_24_in_listOfExpressions2197); 
                    char_literal129_tree = 
                    (Object)adaptor.create(char_literal129)
                    ;
                    adaptor.addChild(root_0, char_literal129_tree);


                    pushFollow(FOLLOW_listOfExpressions_in_listOfExpressions2201);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1430:1: expression[boolean defer] returns [NamedElement objElement] : notToken= notExpression[defer] ;
    public final EugeneParser.expression_return expression(boolean defer) throws RecognitionException {
        EugeneParser.expression_return retval = new EugeneParser.expression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.notExpression_return notToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1432:6: (notToken= notExpression[defer] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1432:11: notToken= notExpression[defer]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_notExpression_in_expression2235);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1439:1: notExpression[boolean defer] returns [NamedElement objElement] : (notToken= 'NOT' exprToken= orExpression[defer] -> ^( 'NOT' $exprToken) |exprToken= orExpression[defer] -> $exprToken);
    public final EugeneParser.notExpression_return notExpression(boolean defer) throws RecognitionException {
        EugeneParser.notExpression_return retval = new EugeneParser.notExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token notToken=null;
        EugeneParser.orExpression_return exprToken =null;


        Object notToken_tree=null;
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleSubtreeStream stream_orExpression=new RewriteRuleSubtreeStream(adaptor,"rule orExpression");

        boolean bNOT=false;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1444:2: (notToken= 'NOT' exprToken= orExpression[defer] -> ^( 'NOT' $exprToken) |exprToken= orExpression[defer] -> $exprToken)
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==60) ) {
                alt45=1;
            }
            else if ( (LA45_0==FLOAT||LA45_0==ID||LA45_0==INT||LA45_0==STRING||LA45_0==18||LA45_0==20||LA45_0==25||(LA45_0 >= 33 && LA45_0 <= 34)||(LA45_0 >= 36 && LA45_0 <= 39)||LA45_0==42||LA45_0==44||(LA45_0 >= 49 && LA45_0 <= 52)||(LA45_0 >= 57 && LA45_0 <= 59)||(LA45_0 >= 61 && LA45_0 <= 63)||(LA45_0 >= 74 && LA45_0 <= 76)||LA45_0==78||LA45_0==86||LA45_0==109) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }
            switch (alt45) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1444:4: notToken= 'NOT' exprToken= orExpression[defer]
                    {
                    notToken=(Token)match(input,60,FOLLOW_60_in_notExpression2272);  
                    stream_60.add(notToken);


                    pushFollow(FOLLOW_orExpression_in_notExpression2276);
                    exprToken=orExpression(defer);

                    state._fsp--;

                    stream_orExpression.add(exprToken.getTree());


                    if(!defer) {
                        retval.objElement = interp.not((exprToken!=null?exprToken.objElement:null));
                    }
                    	

                    // AST REWRITE
                    // elements: 60, exprToken
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1448:4: -> ^( 'NOT' $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1448:7: ^( 'NOT' $exprToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_60.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_exprToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1449:11: exprToken= orExpression[defer]
                    {
                    pushFollow(FOLLOW_orExpression_in_notExpression2302);
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
                    // 1453:11: -> $exprToken
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1456:1: orExpression[boolean defer] returns [NamedElement objElement] : (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )? ;
    public final EugeneParser.orExpression_return orExpression(boolean defer) throws RecognitionException {
        EugeneParser.orExpression_return retval = new EugeneParser.orExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal130=null;
        Token string_literal131=null;
        EugeneParser.andExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal130_tree=null;
        Object string_literal131_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
        RewriteRuleSubtreeStream stream_andExpression=new RewriteRuleSubtreeStream(adaptor,"rule andExpression");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1457:2: ( (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1457:4: (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1457:4: (leftToken= andExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1457:5: leftToken= andExpression[defer]
            {
            pushFollow(FOLLOW_andExpression_in_orExpression2330);
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
            // 1457:36: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:4: ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==66) ) {
                alt47=1;
            }
            else if ( (LA47_0==113) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:5: ( ( 'OR' | '||' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:5: ( ( 'OR' | '||' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:6: ( 'OR' | '||' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:6: ( 'OR' | '||' )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==66) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==113) ) {
                        alt46=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;

                    }
                    switch (alt46) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:7: 'OR'
                            {
                            string_literal130=(Token)match(input,66,FOLLOW_66_in_orExpression2346);  
                            stream_66.add(string_literal130);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:12: '||'
                            {
                            string_literal131=(Token)match(input,113,FOLLOW_113_in_orExpression2348);  
                            stream_113.add(string_literal131);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_orExpression2353);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: leftToken, rightToken, 66
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
                    // 1459:4: -> ^( 'OR' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1459:7: ^( 'OR' $leftToken $rightToken)
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1477:1: andExpression[boolean defer] returns [NamedElement objElement] : (leftToken= xorExpression[defer] -> $leftToken) ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )? ;
    public final EugeneParser.andExpression_return andExpression(boolean defer) throws RecognitionException {
        EugeneParser.andExpression_return retval = new EugeneParser.andExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal132=null;
        Token string_literal133=null;
        EugeneParser.xorExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal132_tree=null;
        Object string_literal133_tree=null;
        RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        RewriteRuleSubtreeStream stream_xorExpression=new RewriteRuleSubtreeStream(adaptor,"rule xorExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1478:2: ( (leftToken= xorExpression[defer] -> $leftToken) ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1478:4: (leftToken= xorExpression[defer] -> $leftToken) ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1478:4: (leftToken= xorExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1478:5: leftToken= xorExpression[defer]
            {
            pushFollow(FOLLOW_xorExpression_in_andExpression2402);
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
            // 1478:36: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:4: ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==40) ) {
                alt49=1;
            }
            else if ( (LA49_0==19) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:5: ( ( 'AND' | '&&' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:5: ( ( 'AND' | '&&' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:6: ( 'AND' | '&&' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:6: ( 'AND' | '&&' )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==40) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==19) ) {
                        alt48=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;

                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:7: 'AND'
                            {
                            string_literal132=(Token)match(input,40,FOLLOW_40_in_andExpression2418);  
                            stream_40.add(string_literal132);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:13: '&&'
                            {
                            string_literal133=(Token)match(input,19,FOLLOW_19_in_andExpression2420);  
                            stream_19.add(string_literal133);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_andExpression2425);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: leftToken, rightToken, 40
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
                    // 1480:4: -> ^( 'AND' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1480:7: ^( 'AND' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_40.nextNode()
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1498:1: xorExpression[boolean defer] returns [NamedElement objElement] : (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )? ;
    public final EugeneParser.xorExpression_return xorExpression(boolean defer) throws RecognitionException {
        EugeneParser.xorExpression_return retval = new EugeneParser.xorExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal134=null;
        Token string_literal135=null;
        EugeneParser.comparativeExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal134_tree=null;
        Object string_literal135_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        RewriteRuleSubtreeStream stream_comparativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule comparativeExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1499:2: ( (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1499:4: (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1499:4: (leftToken= comparativeExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1499:5: leftToken= comparativeExpression[defer]
            {
            pushFollow(FOLLOW_comparativeExpression_in_xorExpression2475);
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
            // 1499:44: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:4: ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==77) ) {
                alt51=1;
            }
            else if ( (LA51_0==80) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:5: ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:5: ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:6: ( 'XOR' | '^^' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:6: ( 'XOR' | '^^' )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==77) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==80) ) {
                        alt50=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 50, 0, input);

                        throw nvae;

                    }
                    switch (alt50) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:7: 'XOR'
                            {
                            string_literal134=(Token)match(input,77,FOLLOW_77_in_xorExpression2491);  
                            stream_77.add(string_literal134);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:13: '^^'
                            {
                            string_literal135=(Token)match(input,80,FOLLOW_80_in_xorExpression2493);  
                            stream_80.add(string_literal135);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_xorExpression2498);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: rightToken, 77, leftToken
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
                    // 1501:4: -> ^( 'XOR' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1501:7: ^( 'XOR' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_77.nextNode()
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1519:1: operator returns [String sOperator] : (relToken= relationalOperator |ruleToken= ruleOperator );
    public final EugeneParser.operator_return operator() throws RecognitionException {
        EugeneParser.operator_return retval = new EugeneParser.operator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.relationalOperator_return relToken =null;

        EugeneParser.ruleOperator_return ruleToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1520:2: (relToken= relationalOperator |ruleToken= ruleOperator )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==18||(LA52_0 >= 33 && LA52_0 <= 34)||(LA52_0 >= 36 && LA52_0 <= 38)||LA52_0==50||LA52_0==61) ) {
                alt52=1;
            }
            else if ( (LA52_0==39||LA52_0==42||LA52_0==44||LA52_0==49||(LA52_0 >= 57 && LA52_0 <= 59)||(LA52_0 >= 62 && LA52_0 <= 63)||(LA52_0 >= 74 && LA52_0 <= 76)) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }
            switch (alt52) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1520:4: relToken= relationalOperator
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_relationalOperator_in_operator2544);
                    relToken=relationalOperator();

                    state._fsp--;

                    adaptor.addChild(root_0, relToken.getTree());


                    retval.sOperator = (relToken!=null?relToken.sOperator:null);
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1523:4: ruleToken= ruleOperator
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ruleOperator_in_operator2554);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1528:1: ruleOperator returns [String sOperator] : ( 'BEFORE' | 'AFTER' | 'STARTSWITH' | 'ENDSWITH' | 'NOTWITH' | 'WITH' | 'NEXTTO' | 'LEFTTO' | 'CONTAINS' | 'MORETHAN' | 'NOTMORETHAN' | 'THEN' );
    public final EugeneParser.ruleOperator_return ruleOperator() throws RecognitionException {
        EugeneParser.ruleOperator_return retval = new EugeneParser.ruleOperator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal136=null;
        Token string_literal137=null;
        Token string_literal138=null;
        Token string_literal139=null;
        Token string_literal140=null;
        Token string_literal141=null;
        Token string_literal142=null;
        Token string_literal143=null;
        Token string_literal144=null;
        Token string_literal145=null;
        Token string_literal146=null;
        Token string_literal147=null;

        Object string_literal136_tree=null;
        Object string_literal137_tree=null;
        Object string_literal138_tree=null;
        Object string_literal139_tree=null;
        Object string_literal140_tree=null;
        Object string_literal141_tree=null;
        Object string_literal142_tree=null;
        Object string_literal143_tree=null;
        Object string_literal144_tree=null;
        Object string_literal145_tree=null;
        Object string_literal146_tree=null;
        Object string_literal147_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1529:2: ( 'BEFORE' | 'AFTER' | 'STARTSWITH' | 'ENDSWITH' | 'NOTWITH' | 'WITH' | 'NEXTTO' | 'LEFTTO' | 'CONTAINS' | 'MORETHAN' | 'NOTMORETHAN' | 'THEN' )
            int alt53=12;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt53=1;
                }
                break;
            case 39:
                {
                alt53=2;
                }
                break;
            case 74:
                {
                alt53=3;
                }
                break;
            case 49:
                {
                alt53=4;
                }
                break;
            case 63:
                {
                alt53=5;
                }
                break;
            case 76:
                {
                alt53=6;
                }
                break;
            case 59:
                {
                alt53=7;
                }
                break;
            case 57:
                {
                alt53=8;
                }
                break;
            case 44:
                {
                alt53=9;
                }
                break;
            case 58:
                {
                alt53=10;
                }
                break;
            case 62:
                {
                alt53=11;
                }
                break;
            case 75:
                {
                alt53=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }

            switch (alt53) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1529:4: 'BEFORE'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal136=(Token)match(input,42,FOLLOW_42_in_ruleOperator2573); 
                    string_literal136_tree = 
                    (Object)adaptor.create(string_literal136)
                    ;
                    adaptor.addChild(root_0, string_literal136_tree);



                    retval.sOperator = EugeneConstants.BEFORE;


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1532:4: 'AFTER'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal137=(Token)match(input,39,FOLLOW_39_in_ruleOperator2580); 
                    string_literal137_tree = 
                    (Object)adaptor.create(string_literal137)
                    ;
                    adaptor.addChild(root_0, string_literal137_tree);



                    retval.sOperator = EugeneConstants.AFTER;


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1535:4: 'STARTSWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal138=(Token)match(input,74,FOLLOW_74_in_ruleOperator2587); 
                    string_literal138_tree = 
                    (Object)adaptor.create(string_literal138)
                    ;
                    adaptor.addChild(root_0, string_literal138_tree);



                    retval.sOperator = EugeneConstants.STARTSWITH;


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1538:4: 'ENDSWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal139=(Token)match(input,49,FOLLOW_49_in_ruleOperator2594); 
                    string_literal139_tree = 
                    (Object)adaptor.create(string_literal139)
                    ;
                    adaptor.addChild(root_0, string_literal139_tree);



                    retval.sOperator = EugeneConstants.ENDSWITH;


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1541:4: 'NOTWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal140=(Token)match(input,63,FOLLOW_63_in_ruleOperator2601); 
                    string_literal140_tree = 
                    (Object)adaptor.create(string_literal140)
                    ;
                    adaptor.addChild(root_0, string_literal140_tree);



                    retval.sOperator = EugeneConstants.NOTWITH;


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1544:4: 'WITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal141=(Token)match(input,76,FOLLOW_76_in_ruleOperator2608); 
                    string_literal141_tree = 
                    (Object)adaptor.create(string_literal141)
                    ;
                    adaptor.addChild(root_0, string_literal141_tree);



                    retval.sOperator = EugeneConstants.WITH;


                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1547:4: 'NEXTTO'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal142=(Token)match(input,59,FOLLOW_59_in_ruleOperator2615); 
                    string_literal142_tree = 
                    (Object)adaptor.create(string_literal142)
                    ;
                    adaptor.addChild(root_0, string_literal142_tree);



                    retval.sOperator = EugeneConstants.NEXTTO;


                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1550:4: 'LEFTTO'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal143=(Token)match(input,57,FOLLOW_57_in_ruleOperator2622); 
                    string_literal143_tree = 
                    (Object)adaptor.create(string_literal143)
                    ;
                    adaptor.addChild(root_0, string_literal143_tree);



                    retval.sOperator = EugeneConstants.LEFTTO;


                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1553:4: 'CONTAINS'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal144=(Token)match(input,44,FOLLOW_44_in_ruleOperator2629); 
                    string_literal144_tree = 
                    (Object)adaptor.create(string_literal144)
                    ;
                    adaptor.addChild(root_0, string_literal144_tree);



                    retval.sOperator = EugeneConstants.CONTAINS;


                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1556:4: 'MORETHAN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal145=(Token)match(input,58,FOLLOW_58_in_ruleOperator2636); 
                    string_literal145_tree = 
                    (Object)adaptor.create(string_literal145)
                    ;
                    adaptor.addChild(root_0, string_literal145_tree);



                    retval.sOperator = EugeneConstants.MORETHAN;


                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1559:4: 'NOTMORETHAN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal146=(Token)match(input,62,FOLLOW_62_in_ruleOperator2643); 
                    string_literal146_tree = 
                    (Object)adaptor.create(string_literal146)
                    ;
                    adaptor.addChild(root_0, string_literal146_tree);



                    retval.sOperator = EugeneConstants.NOTMORETHAN;


                    }
                    break;
                case 12 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1562:4: 'THEN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal147=(Token)match(input,75,FOLLOW_75_in_ruleOperator2650); 
                    string_literal147_tree = 
                    (Object)adaptor.create(string_literal147)
                    ;
                    adaptor.addChild(root_0, string_literal147_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1567:1: relationalOperator returns [String sOperator] : ( ( '==' | 'EQUALS' ) | ( '!=' | 'NOTEQUALS' ) | '<' | '<=' | '>' | '>=' );
    public final EugeneParser.relationalOperator_return relationalOperator() throws RecognitionException {
        EugeneParser.relationalOperator_return retval = new EugeneParser.relationalOperator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set148=null;
        Token set149=null;
        Token char_literal150=null;
        Token string_literal151=null;
        Token char_literal152=null;
        Token string_literal153=null;

        Object set148_tree=null;
        Object set149_tree=null;
        Object char_literal150_tree=null;
        Object string_literal151_tree=null;
        Object char_literal152_tree=null;
        Object string_literal153_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1568:2: ( ( '==' | 'EQUALS' ) | ( '!=' | 'NOTEQUALS' ) | '<' | '<=' | '>' | '>=' )
            int alt54=6;
            switch ( input.LA(1) ) {
            case 36:
            case 50:
                {
                alt54=1;
                }
                break;
            case 18:
            case 61:
                {
                alt54=2;
                }
                break;
            case 33:
                {
                alt54=3;
                }
                break;
            case 34:
                {
                alt54=4;
                }
                break;
            case 37:
                {
                alt54=5;
                }
                break;
            case 38:
                {
                alt54=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1568:4: ( '==' | 'EQUALS' )
                    {
                    root_0 = (Object)adaptor.nil();


                    set148=(Token)input.LT(1);

                    if ( input.LA(1)==36||input.LA(1)==50 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set148)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1571:4: ( '!=' | 'NOTEQUALS' )
                    {
                    root_0 = (Object)adaptor.nil();


                    set149=(Token)input.LT(1);

                    if ( input.LA(1)==18||input.LA(1)==61 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set149)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1574:4: '<'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal150=(Token)match(input,33,FOLLOW_33_in_relationalOperator2693); 
                    char_literal150_tree = 
                    (Object)adaptor.create(char_literal150)
                    ;
                    adaptor.addChild(root_0, char_literal150_tree);



                    retval.sOperator =EugeneConstants.LT;	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1577:4: '<='
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal151=(Token)match(input,34,FOLLOW_34_in_relationalOperator2701); 
                    string_literal151_tree = 
                    (Object)adaptor.create(string_literal151)
                    ;
                    adaptor.addChild(root_0, string_literal151_tree);



                    retval.sOperator =EugeneConstants.LEQ;	
                    	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1580:4: '>'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal152=(Token)match(input,37,FOLLOW_37_in_relationalOperator2708); 
                    char_literal152_tree = 
                    (Object)adaptor.create(char_literal152)
                    ;
                    adaptor.addChild(root_0, char_literal152_tree);



                    retval.sOperator =EugeneConstants.GT;	
                    	

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1583:4: '>='
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal153=(Token)match(input,38,FOLLOW_38_in_relationalOperator2716); 
                    string_literal153_tree = 
                    (Object)adaptor.create(string_literal153)
                    ;
                    adaptor.addChild(root_0, string_literal153_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1588:1: comparativeExpression[boolean defer] returns [NamedElement objElement] : ( (folToken= folExpression[defer] ) -> $folToken)? ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) ) ;
    public final EugeneParser.comparativeExpression_return comparativeExpression(boolean defer) throws RecognitionException {
        EugeneParser.comparativeExpression_return retval = new EugeneParser.comparativeExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal154=null;
        Token string_literal155=null;
        EugeneParser.folExpression_return folToken =null;

        EugeneParser.addExpression_return exprToken1 =null;

        EugeneParser.operator_return oToken =null;

        EugeneParser.comparativeExpression_return exprToken2 =null;

        EugeneParser.type_return typeToken =null;

        EugeneParser.operator_return opToken =null;

        EugeneParser.addExpression_return exprToken =null;


        Object string_literal154_tree=null;
        Object string_literal155_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleSubtreeStream stream_folExpression=new RewriteRuleSubtreeStream(adaptor,"rule folExpression");
        RewriteRuleSubtreeStream stream_addExpression=new RewriteRuleSubtreeStream(adaptor,"rule addExpression");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        RewriteRuleSubtreeStream stream_comparativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule comparativeExpression");
        RewriteRuleSubtreeStream stream_operator=new RewriteRuleSubtreeStream(adaptor,"rule operator");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1590:2: ( ( (folToken= folExpression[defer] ) -> $folToken)? ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1591:2: ( (folToken= folExpression[defer] ) -> $folToken)? ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) )
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1591:2: ( (folToken= folExpression[defer] ) -> $folToken)?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0 >= 51 && LA55_0 <= 52)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1591:3: (folToken= folExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1591:3: (folToken= folExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1591:4: folToken= folExpression[defer]
                    {
                    pushFollow(FOLLOW_folExpression_in_comparativeExpression2743);
                    folToken=folExpression(defer);

                    state._fsp--;

                    stream_folExpression.add(folToken.getTree());

                    }


                    // AST REWRITE
                    // elements: folToken
                    // token labels: 
                    // rule labels: retval, folToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_folToken=new RewriteRuleSubtreeStream(adaptor,"rule folToken",folToken!=null?folToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1591:36: -> $folToken
                    {
                        adaptor.addChild(root_0, stream_folToken.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1593:2: ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==FLOAT||LA58_0==ID||LA58_0==INT||LA58_0==STRING||LA58_0==20||LA58_0==25||LA58_0==78||LA58_0==86||LA58_0==109) ) {
                alt58=1;
            }
            else if ( (LA58_0==18||(LA58_0 >= 33 && LA58_0 <= 34)||(LA58_0 >= 36 && LA58_0 <= 39)||LA58_0==42||LA58_0==44||(LA58_0 >= 49 && LA58_0 <= 50)||(LA58_0 >= 57 && LA58_0 <= 59)||(LA58_0 >= 61 && LA58_0 <= 63)||(LA58_0 >= 74 && LA58_0 <= 76)) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }
            switch (alt58) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1594:2: (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1594:2: (exprToken1= addExpression[defer] -> $exprToken1)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1595:3: exprToken1= addExpression[defer]
                    {
                    pushFollow(FOLLOW_addExpression_in_comparativeExpression2768);
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
                    // 1599:3: -> $exprToken1
                    {
                        adaptor.addChild(root_0, stream_exprToken1.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1601:2: (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )?
                    int alt57=3;
                    switch ( input.LA(1) ) {
                        case 36:
                        case 50:
                            {
                            alt57=1;
                            }
                            break;
                        case 18:
                        case 61:
                            {
                            alt57=1;
                            }
                            break;
                        case 33:
                            {
                            alt57=1;
                            }
                            break;
                        case 34:
                            {
                            alt57=1;
                            }
                            break;
                        case 37:
                            {
                            alt57=1;
                            }
                            break;
                        case 38:
                            {
                            alt57=1;
                            }
                            break;
                        case 42:
                            {
                            alt57=1;
                            }
                            break;
                        case 39:
                            {
                            alt57=1;
                            }
                            break;
                        case 74:
                            {
                            alt57=1;
                            }
                            break;
                        case 49:
                            {
                            alt57=1;
                            }
                            break;
                        case 63:
                            {
                            alt57=1;
                            }
                            break;
                        case 76:
                            {
                            alt57=1;
                            }
                            break;
                        case 59:
                            {
                            alt57=1;
                            }
                            break;
                        case 57:
                            {
                            alt57=1;
                            }
                            break;
                        case 44:
                            {
                            alt57=1;
                            }
                            break;
                        case 58:
                            {
                            alt57=1;
                            }
                            break;
                        case 62:
                            {
                            alt57=1;
                            }
                            break;
                        case 75:
                            {
                            alt57=1;
                            }
                            break;
                        case 55:
                            {
                            alt57=2;
                            }
                            break;
                        case 93:
                            {
                            alt57=2;
                            }
                            break;
                    }

                    switch (alt57) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1601:4: oToken= operator exprToken2= comparativeExpression[defer]
                            {
                            pushFollow(FOLLOW_operator_in_comparativeExpression2788);
                            oToken=operator();

                            state._fsp--;

                            stream_operator.add(oToken.getTree());

                            pushFollow(FOLLOW_comparativeExpression_in_comparativeExpression2792);
                            exprToken2=comparativeExpression(defer);

                            state._fsp--;

                            stream_comparativeExpression.add(exprToken2.getTree());


                            if(!defer) {
                                retval.objElement = interp.compare((exprToken1!=null?exprToken1.objElement:null), (oToken!=null?input.toString(oToken.start,oToken.stop):null), (exprToken2!=null?exprToken2.objElement:null));
                            }


                            // AST REWRITE
                            // elements: oToken, exprToken2, exprToken1
                            // token labels: 
                            // rule labels: exprToken1, retval, exprToken2, oToken
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_exprToken1=new RewriteRuleSubtreeStream(adaptor,"rule exprToken1",exprToken1!=null?exprToken1.tree:null);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_exprToken2=new RewriteRuleSubtreeStream(adaptor,"rule exprToken2",exprToken2!=null?exprToken2.tree:null);
                            RewriteRuleSubtreeStream stream_oToken=new RewriteRuleSubtreeStream(adaptor,"rule oToken",oToken!=null?oToken.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 1605:3: -> ^( $oToken $exprToken1 $exprToken2)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1605:6: ^( $oToken $exprToken1 $exprToken2)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot(stream_oToken.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_exprToken1.nextTree());

                                adaptor.addChild(root_1, stream_exprToken2.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1606:5: ( 'INSTANCEOF' | 'instanceof' ) typeToken= type
                            {
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1606:5: ( 'INSTANCEOF' | 'instanceof' )
                            int alt56=2;
                            int LA56_0 = input.LA(1);

                            if ( (LA56_0==55) ) {
                                alt56=1;
                            }
                            else if ( (LA56_0==93) ) {
                                alt56=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 56, 0, input);

                                throw nvae;

                            }
                            switch (alt56) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1606:6: 'INSTANCEOF'
                                    {
                                    string_literal154=(Token)match(input,55,FOLLOW_55_in_comparativeExpression2815);  
                                    stream_55.add(string_literal154);


                                    }
                                    break;
                                case 2 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1606:19: 'instanceof'
                                    {
                                    string_literal155=(Token)match(input,93,FOLLOW_93_in_comparativeExpression2817);  
                                    stream_93.add(string_literal155);


                                    }
                                    break;

                            }


                            pushFollow(FOLLOW_type_in_comparativeExpression2822);
                            typeToken=type();

                            state._fsp--;

                            stream_type.add(typeToken.getTree());


                            if(!defer) {
                                retval.objElement = EugeneBuilder.buildVariable(
                                    String.valueOf(interp.isInstanceOf((exprToken1!=null?exprToken1.objElement:null), (typeToken!=null?input.toString(typeToken.start,typeToken.stop):null))));
                            }	


                            // AST REWRITE
                            // elements: 55, typeToken
                            // token labels: 
                            // rule labels: typeToken, retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_typeToken=new RewriteRuleSubtreeStream(adaptor,"rule typeToken",typeToken!=null?typeToken.tree:null);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 1611:3: -> ^( 'INSTANCEOF' $typeToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1611:6: ^( 'INSTANCEOF' $typeToken)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot(
                                stream_55.nextNode()
                                , root_1);

                                adaptor.addChild(root_1, stream_typeToken.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1613:7: opToken= operator exprToken= addExpression[defer]
                    {
                    pushFollow(FOLLOW_operator_in_comparativeExpression2846);
                    opToken=operator();

                    state._fsp--;

                    stream_operator.add(opToken.getTree());

                    pushFollow(FOLLOW_addExpression_in_comparativeExpression2850);
                    exprToken=addExpression(defer);

                    state._fsp--;

                    stream_addExpression.add(exprToken.getTree());

                    // AST REWRITE
                    // elements: exprToken, opToken
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
                    // 1614:5: -> ^( $opToken $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1614:8: ^( $opToken $exprToken)
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


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

                System.err.println("line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+" => "+
                    e.getMessage());
                e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1624:1: addExpression[boolean defer] returns [NamedElement objElement] : (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= comparativeExpression[defer] -> ^( '+' $leftToken $rightToken) )? ;
    public final EugeneParser.addExpression_return addExpression(boolean defer) throws RecognitionException {
        EugeneParser.addExpression_return retval = new EugeneParser.addExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token opToken=null;
        EugeneParser.subtractExpression_return leftToken =null;

        EugeneParser.comparativeExpression_return rightToken =null;


        Object opToken_tree=null;
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleSubtreeStream stream_subtractExpression=new RewriteRuleSubtreeStream(adaptor,"rule subtractExpression");
        RewriteRuleSubtreeStream stream_comparativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule comparativeExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1626:2: ( (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= comparativeExpression[defer] -> ^( '+' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1626:4: (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= comparativeExpression[defer] -> ^( '+' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1626:4: (leftToken= subtractExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1626:5: leftToken= subtractExpression[defer]
            {
            pushFollow(FOLLOW_subtractExpression_in_addExpression2899);
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
            // 1626:42: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1627:4: (opToken= '+' rightToken= comparativeExpression[defer] -> ^( '+' $leftToken $rightToken) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==23) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1627:5: opToken= '+' rightToken= comparativeExpression[defer]
                    {
                    opToken=(Token)match(input,23,FOLLOW_23_in_addExpression2915);  
                    stream_23.add(opToken);


                    pushFollow(FOLLOW_comparativeExpression_in_addExpression2919);
                    rightToken=comparativeExpression(defer);

                    state._fsp--;

                    stream_comparativeExpression.add(rightToken.getTree());

                    // AST REWRITE
                    // elements: 23, rightToken, leftToken
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
                    // 1628:5: -> ^( '+' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1628:8: ^( '+' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_23.nextNode()
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1645:1: subtractExpression[boolean defer] returns [NamedElement objElement] : (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= comparativeExpression[defer] -> ^( '-' $leftToken $rightToken) )? ;
    public final EugeneParser.subtractExpression_return subtractExpression(boolean defer) throws RecognitionException {
        EugeneParser.subtractExpression_return retval = new EugeneParser.subtractExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token opToken=null;
        EugeneParser.multiplicativeExpression_return leftToken =null;

        EugeneParser.comparativeExpression_return rightToken =null;


        Object opToken_tree=null;
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
        RewriteRuleSubtreeStream stream_comparativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule comparativeExpression");
        RewriteRuleSubtreeStream stream_multiplicativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule multiplicativeExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1646:2: ( (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= comparativeExpression[defer] -> ^( '-' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1646:4: (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= comparativeExpression[defer] -> ^( '-' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1646:4: (leftToken= multiplicativeExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1646:5: leftToken= multiplicativeExpression[defer]
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_subtractExpression2965);
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
            // 1646:47: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1647:4: (opToken= '-' rightToken= comparativeExpression[defer] -> ^( '-' $leftToken $rightToken) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==25) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1647:5: opToken= '-' rightToken= comparativeExpression[defer]
                    {
                    opToken=(Token)match(input,25,FOLLOW_25_in_subtractExpression2980);  
                    stream_25.add(opToken);


                    pushFollow(FOLLOW_comparativeExpression_in_subtractExpression2984);
                    rightToken=comparativeExpression(defer);

                    state._fsp--;

                    stream_comparativeExpression.add(rightToken.getTree());

                    // AST REWRITE
                    // elements: leftToken, 25, rightToken
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
                    // 1648:4: -> ^( '-' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1648:7: ^( '-' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_25.nextNode()
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1666:1: multiplicativeExpression[boolean defer] returns [NamedElement objElement] : (leftToken= expressionValue[defer] -> $leftToken) (opToken= ( '*' | '/' ) rightToken= expression[defer] -> ^( $opToken $leftToken $rightToken) )? ;
    public final EugeneParser.multiplicativeExpression_return multiplicativeExpression(boolean defer) throws RecognitionException {
        EugeneParser.multiplicativeExpression_return retval = new EugeneParser.multiplicativeExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token opToken=null;
        Token char_literal156=null;
        Token char_literal157=null;
        EugeneParser.expressionValue_return leftToken =null;

        EugeneParser.expression_return rightToken =null;


        Object opToken_tree=null;
        Object char_literal156_tree=null;
        Object char_literal157_tree=null;
        RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_expressionValue=new RewriteRuleSubtreeStream(adaptor,"rule expressionValue");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1667:6: ( (leftToken= expressionValue[defer] -> $leftToken) (opToken= ( '*' | '/' ) rightToken= expression[defer] -> ^( $opToken $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1667:11: (leftToken= expressionValue[defer] -> $leftToken) (opToken= ( '*' | '/' ) rightToken= expression[defer] -> ^( $opToken $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1667:11: (leftToken= expressionValue[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1667:12: leftToken= expressionValue[defer]
            {
            pushFollow(FOLLOW_expressionValue_in_multiplicativeExpression3033);
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
            // 1667:45: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1668:8: (opToken= ( '*' | '/' ) rightToken= expression[defer] -> ^( $opToken $leftToken $rightToken) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==22||LA62_0==30) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1668:9: opToken= ( '*' | '/' ) rightToken= expression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1668:17: ( '*' | '/' )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==22) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==30) ) {
                        alt61=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;

                    }
                    switch (alt61) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1668:18: '*'
                            {
                            char_literal156=(Token)match(input,22,FOLLOW_22_in_multiplicativeExpression3053);  
                            stream_22.add(char_literal156);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1668:22: '/'
                            {
                            char_literal157=(Token)match(input,30,FOLLOW_30_in_multiplicativeExpression3055);  
                            stream_30.add(char_literal157);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_expression_in_multiplicativeExpression3060);
                    rightToken=expression(defer);

                    state._fsp--;

                    stream_expression.add(rightToken.getTree());

                    // AST REWRITE
                    // elements: rightToken, opToken, leftToken
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
                    // 1669:16: -> ^( $opToken $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1669:19: ^( $opToken $leftToken $rightToken)
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1693:1: expressionValue[boolean defer] returns [NamedElement objElement] : ( (minToken= '-' )? numToken= ( INT | FLOAT ) |txtToken= STRING |boolToken= ( 'true' | 'false' ) | (accessToken= objectAccessStatement[defer] -> $accessToken) | '(' exprToken= expression[defer] ')' -> ^( '(' $exprToken) | '[' lstToken= listOfExpressions[defer] ']' -> ^( '[' $lstToken) );
    public final EugeneParser.expressionValue_return expressionValue(boolean defer) throws RecognitionException {
        EugeneParser.expressionValue_return retval = new EugeneParser.expressionValue_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token minToken=null;
        Token numToken=null;
        Token txtToken=null;
        Token boolToken=null;
        Token char_literal158=null;
        Token char_literal159=null;
        Token char_literal160=null;
        Token char_literal161=null;
        EugeneParser.objectAccessStatement_return accessToken =null;

        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfExpressions_return lstToken =null;


        Object minToken_tree=null;
        Object numToken_tree=null;
        Object txtToken_tree=null;
        Object boolToken_tree=null;
        Object char_literal158_tree=null;
        Object char_literal159_tree=null;
        Object char_literal160_tree=null;
        Object char_literal161_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_objectAccessStatement=new RewriteRuleSubtreeStream(adaptor,"rule objectAccessStatement");
        RewriteRuleSubtreeStream stream_listOfExpressions=new RewriteRuleSubtreeStream(adaptor,"rule listOfExpressions");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1694:2: ( (minToken= '-' )? numToken= ( INT | FLOAT ) |txtToken= STRING |boolToken= ( 'true' | 'false' ) | (accessToken= objectAccessStatement[defer] -> $accessToken) | '(' exprToken= expression[defer] ')' -> ^( '(' $exprToken) | '[' lstToken= listOfExpressions[defer] ']' -> ^( '[' $lstToken) )
            int alt64=6;
            switch ( input.LA(1) ) {
            case FLOAT:
            case INT:
            case 25:
                {
                alt64=1;
                }
                break;
            case STRING:
                {
                alt64=2;
                }
                break;
            case 86:
            case 109:
                {
                alt64=3;
                }
                break;
            case ID:
                {
                alt64=4;
                }
                break;
            case 20:
                {
                alt64=5;
                }
                break;
            case 78:
                {
                alt64=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }

            switch (alt64) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1694:4: (minToken= '-' )? numToken= ( INT | FLOAT )
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1694:4: (minToken= '-' )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==25) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1694:5: minToken= '-'
                            {
                            minToken=(Token)match(input,25,FOLLOW_25_in_expressionValue3115); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1704:4: txtToken= STRING
                    {
                    root_0 = (Object)adaptor.nil();


                    txtToken=(Token)match(input,STRING,FOLLOW_STRING_in_expressionValue3135); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1711:4: boolToken= ( 'true' | 'false' )
                    {
                    root_0 = (Object)adaptor.nil();


                    boolToken=(Token)input.LT(1);

                    if ( input.LA(1)==86||input.LA(1)==109 ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1718:11: (accessToken= objectAccessStatement[defer] -> $accessToken)
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1718:11: (accessToken= objectAccessStatement[defer] -> $accessToken)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1718:12: accessToken= objectAccessStatement[defer]
                    {
                    pushFollow(FOLLOW_objectAccessStatement_in_expressionValue3169);
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
                    // 1722:4: -> $accessToken
                    {
                        adaptor.addChild(root_0, stream_accessToken.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1723:4: '(' exprToken= expression[defer] ')'
                    {
                    char_literal158=(Token)match(input,20,FOLLOW_20_in_expressionValue3183);  
                    stream_20.add(char_literal158);


                    pushFollow(FOLLOW_expression_in_expressionValue3187);
                    exprToken=expression(defer);

                    state._fsp--;

                    stream_expression.add(exprToken.getTree());

                    char_literal159=(Token)match(input,21,FOLLOW_21_in_expressionValue3190);  
                    stream_21.add(char_literal159);



                    if(!defer){
                        retval.objElement = (exprToken!=null?exprToken.objElement:null);
                    }
                            

                    // AST REWRITE
                    // elements: 20, exprToken
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1727:15: -> ^( '(' $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1727:18: ^( '(' $exprToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_20.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_exprToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1728:4: '[' lstToken= listOfExpressions[defer] ']'
                    {
                    char_literal160=(Token)match(input,78,FOLLOW_78_in_expressionValue3214);  
                    stream_78.add(char_literal160);


                    pushFollow(FOLLOW_listOfExpressions_in_expressionValue3218);
                    lstToken=listOfExpressions(defer);

                    state._fsp--;

                    stream_listOfExpressions.add(lstToken.getTree());

                    char_literal161=(Token)match(input,79,FOLLOW_79_in_expressionValue3221);  
                    stream_79.add(char_literal161);



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
                    // elements: 78, lstToken
                    // token labels: 
                    // rule labels: retval, lstToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_lstToken=new RewriteRuleSubtreeStream(adaptor,"rule lstToken",lstToken!=null?lstToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1848:11: -> ^( '[' $lstToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1848:14: ^( '[' $lstToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_78.nextNode()
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1857:1: objectAccessStatement[boolean defer] returns [NamedElement objElement] : (idToken= ID -> $idToken) (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )? ;
    public final EugeneParser.objectAccessStatement_return objectAccessStatement(boolean defer) throws RecognitionException {
        EugeneParser.objectAccessStatement_return retval = new EugeneParser.objectAccessStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        EugeneParser.objectAccess_return accessToken =null;


        Object idToken_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_objectAccess=new RewriteRuleSubtreeStream(adaptor,"rule objectAccess");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1859:2: ( (idToken= ID -> $idToken) (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1859:4: (idToken= ID -> $idToken) (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1859:4: (idToken= ID -> $idToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1859:5: idToken= ID
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_objectAccessStatement3259);  
            stream_ID.add(idToken);



            if(!defer) {
                retval.objElement = interp.get((idToken!=null?idToken.getText():null));
                if(retval.objElement==null) {
                    System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                            "I don't know anything about "+(idToken!=null?idToken.getText():null)+"!");
                    this.cleanUp(1);	
                } 
            }
            	

            // AST REWRITE
            // elements: idToken
            // token labels: idToken
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_idToken=new RewriteRuleTokenStream(adaptor,"token idToken",idToken);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1868:4: -> $idToken
            {
                adaptor.addChild(root_0, stream_idToken.nextNode());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1869:2: (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==26||LA65_0==78) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1869:3: accessToken= objectAccess[defer, $objElement]
                    {
                    pushFollow(FOLLOW_objectAccess_in_objectAccessStatement3274);
                    accessToken=objectAccess(defer, retval.objElement);

                    state._fsp--;

                    stream_objectAccess.add(accessToken.getTree());

                    // AST REWRITE
                    // elements: accessToken, idToken
                    // token labels: idToken
                    // rule labels: retval, accessToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_idToken=new RewriteRuleTokenStream(adaptor,"token idToken",idToken);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_accessToken=new RewriteRuleSubtreeStream(adaptor,"rule accessToken",accessToken!=null?accessToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1869:48: -> ^( $idToken $accessToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1869:51: ^( $idToken $accessToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_idToken.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_accessToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println(
                "line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+
                " => "+e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "objectAccessStatement"


    public static class objectAccess_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "objectAccess"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1879:1: objectAccess[boolean defer, NamedElement objElement] : ( (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )? | (dotToken= dotAccess[defer, $objElement] -> $dotToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )? );
    public final EugeneParser.objectAccess_return objectAccess(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.objectAccess_return retval = new EugeneParser.objectAccess_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.arrayAccess_return arrayToken =null;

        EugeneParser.access_return accessToken =null;

        EugeneParser.dotAccess_return dotToken =null;


        RewriteRuleSubtreeStream stream_arrayAccess=new RewriteRuleSubtreeStream(adaptor,"rule arrayAccess");
        RewriteRuleSubtreeStream stream_dotAccess=new RewriteRuleSubtreeStream(adaptor,"rule dotAccess");
        RewriteRuleSubtreeStream stream_access=new RewriteRuleSubtreeStream(adaptor,"rule access");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1880:2: ( (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )? | (dotToken= dotAccess[defer, $objElement] -> $dotToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )? )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==78) ) {
                alt68=1;
            }
            else if ( (LA68_0==26) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }
            switch (alt68) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1880:4: (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1880:4: (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1880:5: arrayToken= arrayAccess[defer, $objElement]
                    {
                    pushFollow(FOLLOW_arrayAccess_in_objectAccess3308);
                    arrayToken=arrayAccess(defer, objElement);

                    state._fsp--;

                    stream_arrayAccess.add(arrayToken.getTree());

                    // AST REWRITE
                    // elements: arrayToken
                    // token labels: 
                    // rule labels: retval, arrayToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_arrayToken=new RewriteRuleSubtreeStream(adaptor,"rule arrayToken",arrayToken!=null?arrayToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1880:48: -> $arrayToken
                    {
                        adaptor.addChild(root_0, stream_arrayToken.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1881:4: (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==26||LA66_0==78) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1881:5: accessToken= access[defer, $objElement]
                            {
                            pushFollow(FOLLOW_access_in_objectAccess3324);
                            accessToken=access(defer, objElement);

                            state._fsp--;

                            stream_access.add(accessToken.getTree());

                            // AST REWRITE
                            // elements: objectAccess, arrayToken, accessToken
                            // token labels: 
                            // rule labels: retval, accessToken, arrayToken
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_accessToken=new RewriteRuleSubtreeStream(adaptor,"rule accessToken",accessToken!=null?accessToken.tree:null);
                            RewriteRuleSubtreeStream stream_arrayToken=new RewriteRuleSubtreeStream(adaptor,"rule arrayToken",arrayToken!=null?arrayToken.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 1881:44: -> ^( $objectAccess $arrayToken $accessToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1881:47: ^( $objectAccess $arrayToken $accessToken)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot(stream_retval.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_arrayToken.nextTree());

                                adaptor.addChild(root_1, stream_accessToken.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1882:4: (dotToken= dotAccess[defer, $objElement] -> $dotToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1882:4: (dotToken= dotAccess[defer, $objElement] -> $dotToken)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1882:5: dotToken= dotAccess[defer, $objElement]
                    {
                    pushFollow(FOLLOW_dotAccess_in_objectAccess3348);
                    dotToken=dotAccess(defer, objElement);

                    state._fsp--;

                    stream_dotAccess.add(dotToken.getTree());

                    // AST REWRITE
                    // elements: dotToken
                    // token labels: 
                    // rule labels: retval, dotToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_dotToken=new RewriteRuleSubtreeStream(adaptor,"rule dotToken",dotToken!=null?dotToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1882:45: -> $dotToken
                    {
                        adaptor.addChild(root_0, stream_dotToken.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1883:4: (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==26||LA67_0==78) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1883:5: accessToken= access[defer, $objElement]
                            {
                            pushFollow(FOLLOW_access_in_objectAccess3366);
                            accessToken=access(defer, objElement);

                            state._fsp--;

                            stream_access.add(accessToken.getTree());

                            // AST REWRITE
                            // elements: dotToken, objectAccess, accessToken
                            // token labels: 
                            // rule labels: retval, accessToken, dotToken
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_accessToken=new RewriteRuleSubtreeStream(adaptor,"rule accessToken",accessToken!=null?accessToken.tree:null);
                            RewriteRuleSubtreeStream stream_dotToken=new RewriteRuleSubtreeStream(adaptor,"rule dotToken",dotToken!=null?dotToken.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 1883:44: -> ^( $objectAccess $dotToken $accessToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1883:47: ^( $objectAccess $dotToken $accessToken)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot(stream_retval.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_dotToken.nextTree());

                                adaptor.addChild(root_1, stream_accessToken.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;

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
    // $ANTLR end "objectAccess"


    public static class access_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "access"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1886:1: access[boolean defer, NamedElement objElement] : objectToken= objectAccess[defer, $objElement] ;
    public final EugeneParser.access_return access(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.access_return retval = new EugeneParser.access_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.objectAccess_return objectToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1887:2: (objectToken= objectAccess[defer, $objElement] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1887:4: objectToken= objectAccess[defer, $objElement]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_objectAccess_in_access3398);
            objectToken=objectAccess(defer, objElement);

            state._fsp--;

            adaptor.addChild(root_0, objectToken.getTree());

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
    // $ANTLR end "access"


    public static class arrayAccess_return extends ParserRuleReturnScope {
        public NamedElement objEl;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arrayAccess"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1890:1: arrayAccess[boolean defer, NamedElement objElement] returns [NamedElement objEl] : ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) ) ;
    public final EugeneParser.arrayAccess_return arrayAccess(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.arrayAccess_return retval = new EugeneParser.arrayAccess_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal162=null;
        Token char_literal163=null;
        EugeneParser.expression_return idxToken =null;


        Object char_literal162_tree=null;
        Object char_literal163_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1892:2: ( ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1892:4: ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) )
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1892:4: ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1892:5: '[' idxToken= expression[defer] ']'
            {
            char_literal162=(Token)match(input,78,FOLLOW_78_in_arrayAccess3421);  
            stream_78.add(char_literal162);


            pushFollow(FOLLOW_expression_in_arrayAccess3425);
            idxToken=expression(defer);

            state._fsp--;

            stream_expression.add(idxToken.getTree());

            char_literal163=(Token)match(input,79,FOLLOW_79_in_arrayAccess3428);  
            stream_79.add(char_literal163);



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
            // elements: idxToken, 78
            // token labels: 
            // rule labels: retval, idxToken
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_idxToken=new RewriteRuleSubtreeStream(adaptor,"rule idxToken",idxToken!=null?idxToken.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1924:4: -> ^( '[' $idxToken)
            {
                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1924:7: ^( '[' $idxToken)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_78.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_idxToken.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println(
                    "line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+
                    " => "+e.toString());
            e.printStackTrace();
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arrayAccess"


    public static class dotAccess_return extends ParserRuleReturnScope {
        public NamedElement objValue;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dotAccess"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1934:1: dotAccess[boolean defer, NamedElement objElement] returns [NamedElement objValue] : ( ( '.' propertyToken= ID -> ^( '.' $propertyToken) ) | ( ( '.' sizeToken= ( 'size' ( '(' ')' )? ) -> ^( '.' $sizeToken) ) | ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) ) | ( '.' seqToken= ( 'sequence' | 'toSequence' ) ( '(' ')' )? ) -> ^( '.' $seqToken) ) | ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' $emptyToken) ) | ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) ) );
    public final EugeneParser.dotAccess_return dotAccess(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.dotAccess_return retval = new EugeneParser.dotAccess_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token propertyToken=null;
        Token sizeToken=null;
        Token getToken=null;
        Token seqToken=null;
        Token emptyToken=null;
        Token char_literal164=null;
        Token char_literal165=null;
        Token string_literal166=null;
        Token char_literal167=null;
        Token char_literal168=null;
        Token char_literal169=null;
        Token char_literal170=null;
        Token char_literal171=null;
        Token char_literal172=null;
        Token string_literal173=null;
        Token string_literal174=null;
        Token char_literal175=null;
        Token char_literal176=null;
        Token char_literal177=null;
        Token char_literal178=null;
        Token char_literal179=null;
        Token char_literal180=null;
        Token string_literal181=null;
        Token char_literal182=null;
        Token char_literal183=null;
        EugeneParser.expression_return exprToken =null;


        Object propertyToken_tree=null;
        Object sizeToken_tree=null;
        Object getToken_tree=null;
        Object seqToken_tree=null;
        Object emptyToken_tree=null;
        Object char_literal164_tree=null;
        Object char_literal165_tree=null;
        Object string_literal166_tree=null;
        Object char_literal167_tree=null;
        Object char_literal168_tree=null;
        Object char_literal169_tree=null;
        Object char_literal170_tree=null;
        Object char_literal171_tree=null;
        Object char_literal172_tree=null;
        Object string_literal173_tree=null;
        Object string_literal174_tree=null;
        Object char_literal175_tree=null;
        Object char_literal176_tree=null;
        Object char_literal177_tree=null;
        Object char_literal178_tree=null;
        Object char_literal179_tree=null;
        Object char_literal180_tree=null;
        Object string_literal181_tree=null;
        Object char_literal182_tree=null;
        Object char_literal183_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_106=new RewriteRuleTokenStream(adaptor,"token 106");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_105=new RewriteRuleTokenStream(adaptor,"token 105");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1936:2: ( ( '.' propertyToken= ID -> ^( '.' $propertyToken) ) | ( ( '.' sizeToken= ( 'size' ( '(' ')' )? ) -> ^( '.' $sizeToken) ) | ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) ) | ( '.' seqToken= ( 'sequence' | 'toSequence' ) ( '(' ')' )? ) -> ^( '.' $seqToken) ) | ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' $emptyToken) ) | ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) ) )
            int alt75=4;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==26) ) {
                switch ( input.LA(2) ) {
                case ID:
                    {
                    alt75=1;
                    }
                    break;
                case 90:
                case 105:
                case 106:
                case 108:
                    {
                    alt75=2;
                    }
                    break;
                case 95:
                    {
                    alt75=3;
                    }
                    break;
                case 94:
                    {
                    alt75=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }
            switch (alt75) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1936:4: ( '.' propertyToken= ID -> ^( '.' $propertyToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1936:4: ( '.' propertyToken= ID -> ^( '.' $propertyToken) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1936:6: '.' propertyToken= ID
                    {
                    char_literal164=(Token)match(input,26,FOLLOW_26_in_dotAccess3466);  
                    stream_26.add(char_literal164);


                    propertyToken=(Token)match(input,ID,FOLLOW_ID_in_dotAccess3470);  
                    stream_ID.add(propertyToken);



                    if(!defer) {
                    	retval.objValue = interp.get(objElement, (propertyToken!=null?propertyToken.getText():null));
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
                    // 1940:4: -> ^( '.' $propertyToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1940:7: ^( '.' $propertyToken)
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


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1941:4: ( ( '.' sizeToken= ( 'size' ( '(' ')' )? ) -> ^( '.' $sizeToken) ) | ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) ) | ( '.' seqToken= ( 'sequence' | 'toSequence' ) ( '(' ')' )? ) -> ^( '.' $seqToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1941:4: ( ( '.' sizeToken= ( 'size' ( '(' ')' )? ) -> ^( '.' $sizeToken) ) | ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) ) | ( '.' seqToken= ( 'sequence' | 'toSequence' ) ( '(' ')' )? ) -> ^( '.' $seqToken) )
                    int alt72=3;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==26) ) {
                        switch ( input.LA(2) ) {
                        case 106:
                            {
                            alt72=1;
                            }
                            break;
                        case 90:
                            {
                            alt72=2;
                            }
                            break;
                        case 105:
                        case 108:
                            {
                            alt72=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 72, 1, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 72, 0, input);

                        throw nvae;

                    }
                    switch (alt72) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1941:5: ( '.' sizeToken= ( 'size' ( '(' ')' )? ) -> ^( '.' $sizeToken) )
                            {
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1941:5: ( '.' sizeToken= ( 'size' ( '(' ')' )? ) -> ^( '.' $sizeToken) )
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1941:6: '.' sizeToken= ( 'size' ( '(' ')' )? )
                            {
                            char_literal165=(Token)match(input,26,FOLLOW_26_in_dotAccess3490);  
                            stream_26.add(char_literal165);


                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1941:20: ( 'size' ( '(' ')' )? )
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1941:21: 'size' ( '(' ')' )?
                            {
                            string_literal166=(Token)match(input,106,FOLLOW_106_in_dotAccess3495);  
                            stream_106.add(string_literal166);


                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1941:28: ( '(' ')' )?
                            int alt69=2;
                            int LA69_0 = input.LA(1);

                            if ( (LA69_0==20) ) {
                                alt69=1;
                            }
                            switch (alt69) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1941:29: '(' ')'
                                    {
                                    char_literal167=(Token)match(input,20,FOLLOW_20_in_dotAccess3498);  
                                    stream_20.add(char_literal167);


                                    char_literal168=(Token)match(input,21,FOLLOW_21_in_dotAccess3499);  
                                    stream_21.add(char_literal168);


                                    }
                                    break;

                            }


                            }



                            if(!defer) {    
                                Variable objVariable = interp.createVariable(
                                        (String)null, EugeneConstants.NUM);
                                objVariable.setNum(interp.sizeOf(objElement));   
                                retval.objValue = objVariable; 
                            }	
                            	

                            // AST REWRITE
                            // elements: 26, sizeToken
                            // token labels: sizeToken
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleTokenStream stream_sizeToken=new RewriteRuleTokenStream(adaptor,"token sizeToken",sizeToken);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 1948:4: -> ^( '.' $sizeToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1948:7: ^( '.' $sizeToken)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot(
                                stream_26.nextNode()
                                , root_1);

                                adaptor.addChild(root_1, stream_sizeToken.nextNode());

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1949:4: ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) )
                            {
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1949:4: ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) )
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1949:5: '.' getToken= 'get' '(' exprToken= expression[defer] ')'
                            {
                            char_literal169=(Token)match(input,26,FOLLOW_26_in_dotAccess3520);  
                            stream_26.add(char_literal169);


                            getToken=(Token)match(input,90,FOLLOW_90_in_dotAccess3524);  
                            stream_90.add(getToken);


                            char_literal170=(Token)match(input,20,FOLLOW_20_in_dotAccess3526);  
                            stream_20.add(char_literal170);


                            pushFollow(FOLLOW_expression_in_dotAccess3530);
                            exprToken=expression(defer);

                            state._fsp--;

                            stream_expression.add(exprToken.getTree());

                            char_literal171=(Token)match(input,21,FOLLOW_21_in_dotAccess3533);  
                            stream_21.add(char_literal171);



                            if(!defer) {
                                retval.objValue = interp.get(objElement, (exprToken!=null?exprToken.objElement:null));
                            }	
                            	

                            // AST REWRITE
                            // elements: 26, exprToken, 90
                            // token labels: 
                            // rule labels: retval, exprToken
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 1953:4: -> ^( '.' 'get' $exprToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1953:7: ^( '.' 'get' $exprToken)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot(
                                stream_26.nextNode()
                                , root_1);

                                adaptor.addChild(root_1, 
                                stream_90.nextNode()
                                );

                                adaptor.addChild(root_1, stream_exprToken.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }


                            }
                            break;
                        case 3 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1954:4: ( '.' seqToken= ( 'sequence' | 'toSequence' ) ( '(' ')' )? )
                            {
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1954:4: ( '.' seqToken= ( 'sequence' | 'toSequence' ) ( '(' ')' )? )
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1954:5: '.' seqToken= ( 'sequence' | 'toSequence' ) ( '(' ')' )?
                            {
                            char_literal172=(Token)match(input,26,FOLLOW_26_in_dotAccess3553);  
                            stream_26.add(char_literal172);


                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1954:18: ( 'sequence' | 'toSequence' )
                            int alt70=2;
                            int LA70_0 = input.LA(1);

                            if ( (LA70_0==105) ) {
                                alt70=1;
                            }
                            else if ( (LA70_0==108) ) {
                                alt70=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 70, 0, input);

                                throw nvae;

                            }
                            switch (alt70) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1954:19: 'sequence'
                                    {
                                    string_literal173=(Token)match(input,105,FOLLOW_105_in_dotAccess3558);  
                                    stream_105.add(string_literal173);


                                    }
                                    break;
                                case 2 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1954:30: 'toSequence'
                                    {
                                    string_literal174=(Token)match(input,108,FOLLOW_108_in_dotAccess3560);  
                                    stream_108.add(string_literal174);


                                    }
                                    break;

                            }


                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1954:44: ( '(' ')' )?
                            int alt71=2;
                            int LA71_0 = input.LA(1);

                            if ( (LA71_0==20) ) {
                                alt71=1;
                            }
                            switch (alt71) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1954:45: '(' ')'
                                    {
                                    char_literal175=(Token)match(input,20,FOLLOW_20_in_dotAccess3564);  
                                    stream_20.add(char_literal175);


                                    char_literal176=(Token)match(input,21,FOLLOW_21_in_dotAccess3566);  
                                    stream_21.add(char_literal176);


                                    }
                                    break;

                            }


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
                            	

                            // AST REWRITE
                            // elements: seqToken, 26
                            // token labels: seqToken
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleTokenStream stream_seqToken=new RewriteRuleTokenStream(adaptor,"token seqToken",seqToken);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 1972:4: -> ^( '.' $seqToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1972:7: ^( '.' $seqToken)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot(
                                stream_26.nextNode()
                                , root_1);

                                adaptor.addChild(root_1, stream_seqToken.nextNode());

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1973:4: ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' $emptyToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1973:4: ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' $emptyToken) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1973:5: '.' emptyToken= 'isEmpty' ( '(' ')' )?
                    {
                    char_literal177=(Token)match(input,26,FOLLOW_26_in_dotAccess3587);  
                    stream_26.add(char_literal177);


                    emptyToken=(Token)match(input,95,FOLLOW_95_in_dotAccess3591);  
                    stream_95.add(emptyToken);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1973:30: ( '(' ')' )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==20) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1973:31: '(' ')'
                            {
                            char_literal178=(Token)match(input,20,FOLLOW_20_in_dotAccess3594);  
                            stream_20.add(char_literal178);


                            char_literal179=(Token)match(input,21,FOLLOW_21_in_dotAccess3596);  
                            stream_21.add(char_literal179);


                            }
                            break;

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
                    	

                    // AST REWRITE
                    // elements: 26, emptyToken
                    // token labels: emptyToken
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_emptyToken=new RewriteRuleTokenStream(adaptor,"token emptyToken",emptyToken);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1983:4: -> ^( '.' $emptyToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1983:7: ^( '.' $emptyToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_emptyToken.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1984:4: ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1984:4: ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1984:5: '.' 'instantiate' '(' (exprToken= expression[defer] )? ')'
                    {
                    char_literal180=(Token)match(input,26,FOLLOW_26_in_dotAccess3616);  
                    stream_26.add(char_literal180);


                    string_literal181=(Token)match(input,94,FOLLOW_94_in_dotAccess3618);  
                    stream_94.add(string_literal181);


                    char_literal182=(Token)match(input,20,FOLLOW_20_in_dotAccess3620);  
                    stream_20.add(char_literal182);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1984:27: (exprToken= expression[defer] )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==FLOAT||LA74_0==ID||LA74_0==INT||LA74_0==STRING||LA74_0==18||LA74_0==20||LA74_0==25||(LA74_0 >= 33 && LA74_0 <= 34)||(LA74_0 >= 36 && LA74_0 <= 39)||LA74_0==42||LA74_0==44||(LA74_0 >= 49 && LA74_0 <= 52)||(LA74_0 >= 57 && LA74_0 <= 63)||(LA74_0 >= 74 && LA74_0 <= 76)||LA74_0==78||LA74_0==86||LA74_0==109) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1984:28: exprToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_dotAccess3625);
                            exprToken=expression(defer);

                            state._fsp--;

                            stream_expression.add(exprToken.getTree());

                            }
                            break;

                    }


                    char_literal183=(Token)match(input,21,FOLLOW_21_in_dotAccess3630);  
                    stream_21.add(char_literal183);



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
                    	

                    // AST REWRITE
                    // elements: exprToken, 94, 26
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1997:4: -> ^( '.' 'instantiate' ( $exprToken)? )
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1997:7: ^( '.' 'instantiate' ( $exprToken)? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_94.nextNode()
                        );

                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1997:28: ( $exprToken)?
                        if ( stream_exprToken.hasNext() ) {
                            adaptor.addChild(root_1, stream_exprToken.nextTree());

                        }
                        stream_exprToken.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(propertyToken!=null?propertyToken.getLine():0)+":"+(propertyToken!=null?propertyToken.getCharPositionInLine():0)+
                    " => "+e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dotAccess"


    public static class functionWrapper_return extends ParserRuleReturnScope {
        public NamedElement objValue;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionWrapper"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2006:1: functionWrapper[boolean defer, NamedElement objElement] returns [NamedElement objValue] :;
    public final EugeneParser.functionWrapper_return functionWrapper(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.functionWrapper_return retval = new EugeneParser.functionWrapper_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2007:2: ()
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2008:2: 
            {
            root_0 = (Object)adaptor.nil();


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+" => "+
                e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionWrapper"


    public static class objectAssignmentStatement_return extends ParserRuleReturnScope {
        public NamedElement assignElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "objectAssignmentStatement"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2016:1: objectAssignmentStatement[boolean defer] returns [NamedElement assignElement] : idToken= ID ( ( '.' subIdToken= ID ) | ( '[' idxToken= expression[defer] ']' ) )* rightToken= assignment[defer] ;
    public final EugeneParser.objectAssignmentStatement_return objectAssignmentStatement(boolean defer) throws RecognitionException {
        EugeneParser.objectAssignmentStatement_return retval = new EugeneParser.objectAssignmentStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token subIdToken=null;
        Token char_literal184=null;
        Token char_literal185=null;
        Token char_literal186=null;
        EugeneParser.expression_return idxToken =null;

        EugeneParser.assignment_return rightToken =null;


        Object idToken_tree=null;
        Object subIdToken_tree=null;
        Object char_literal184_tree=null;
        Object char_literal185_tree=null;
        Object char_literal186_tree=null;


        NamedElement objElement = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2021:2: (idToken= ID ( ( '.' subIdToken= ID ) | ( '[' idxToken= expression[defer] ']' ) )* rightToken= assignment[defer] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2021:4: idToken= ID ( ( '.' subIdToken= ID ) | ( '[' idxToken= expression[defer] ']' ) )* rightToken= assignment[defer]
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_objectAssignmentStatement3700); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);



            if(!defer) {
                objElement = interp.get((idToken!=null?idToken.getText():null));    
            }	
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2025:8: ( ( '.' subIdToken= ID ) | ( '[' idxToken= expression[defer] ']' ) )*
            loop76:
            do {
                int alt76=3;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==26) ) {
                    alt76=1;
                }
                else if ( (LA76_0==78) ) {
                    alt76=2;
                }


                switch (alt76) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2025:9: ( '.' subIdToken= ID )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2025:9: ( '.' subIdToken= ID )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2025:10: '.' subIdToken= ID
            	    {
            	    char_literal184=(Token)match(input,26,FOLLOW_26_in_objectAssignmentStatement3710); 
            	    char_literal184_tree = 
            	    (Object)adaptor.create(char_literal184)
            	    ;
            	    adaptor.addChild(root_0, char_literal184_tree);


            	    subIdToken=(Token)match(input,ID,FOLLOW_ID_in_objectAssignmentStatement3714); 
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
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2035:7: ( '[' idxToken= expression[defer] ']' )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2035:7: ( '[' idxToken= expression[defer] ']' )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2035:8: '[' idxToken= expression[defer] ']'
            	    {
            	    char_literal185=(Token)match(input,78,FOLLOW_78_in_objectAssignmentStatement3722); 
            	    char_literal185_tree = 
            	    (Object)adaptor.create(char_literal185)
            	    ;
            	    adaptor.addChild(root_0, char_literal185_tree);



            	    if(!defer) {
            	        if(null==objElement) {
            	            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
            	                        "I don't know anything about "+(idToken!=null?idToken.getText():null));
            	            this.cleanUp(1);
            	        }
            	    }	
            	    	

            	    pushFollow(FOLLOW_expression_in_objectAssignmentStatement3728);
            	    idxToken=expression(defer);

            	    state._fsp--;

            	    adaptor.addChild(root_0, idxToken.getTree());

            	    char_literal186=(Token)match(input,79,FOLLOW_79_in_objectAssignmentStatement3731); 
            	    char_literal186_tree = 
            	    (Object)adaptor.create(char_literal186)
            	    ;
            	    adaptor.addChild(root_0, char_literal186_tree);



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
            	    break loop76;
                }
            } while (true);


            pushFollow(FOLLOW_assignment_in_objectAssignmentStatement3740);
            rightToken=assignment(defer);

            state._fsp--;

            adaptor.addChild(root_0, rightToken.getTree());


            if(!defer) {
                retval.assignElement = (rightToken!=null?rightToken.objElement:null);
                
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2081:1: listOfStatements[boolean defer] returns [NamedElement objReturnValue] : (stmtToken= statement[defer] )+ ;
    public final EugeneParser.listOfStatements_return listOfStatements(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.listOfStatements_return retval = new EugeneParser.listOfStatements_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.statement_return stmtToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2083:2: ( (stmtToken= statement[defer] )+ )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2083:4: (stmtToken= statement[defer] )+
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2083:4: (stmtToken= statement[defer] )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( ((LA77_0 >= ID && LA77_0 <= INCLUDE)||LA77_0==32||LA77_0==41||LA77_0==45||(LA77_0 >= 47 && LA77_0 <= 48)||LA77_0==53||LA77_0==56||LA77_0==64||(LA77_0 >= 68 && LA77_0 <= 70)||(LA77_0 >= 72 && LA77_0 <= 73)||LA77_0==81||LA77_0==83||LA77_0==88||(LA77_0 >= 91 && LA77_0 <= 92)||(LA77_0 >= 97 && LA77_0 <= 101)||(LA77_0 >= 103 && LA77_0 <= 104)||(LA77_0 >= 110 && LA77_0 <= 111)) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2083:5: stmtToken= statement[defer]
            	    {
            	    pushFollow(FOLLOW_statement_in_listOfStatements3774);
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
            	    if ( cnt77 >= 1 ) break loop77;
                        EarlyExitException eee =
                            new EarlyExitException(77, input);
                        throw eee;
                }
                cnt77++;
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2091:1: returnStatement[boolean defer] returns [NamedElement objReturnValue] : returnToken= 'return' ( (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] ) )? ';' ;
    public final EugeneParser.returnStatement_return returnStatement(boolean defer) throws RecognitionException {
        EugeneParser.returnStatement_return retval = new EugeneParser.returnStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token returnToken=null;
        Token char_literal187=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.functionCall_return functionToken =null;

        EugeneParser.wrappedStatement_return wrapperToken =null;


        Object returnToken_tree=null;
        Object char_literal187_tree=null;


        NamedElement objReturn = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2095:2: (returnToken= 'return' ( (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] ) )? ';' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2095:4: returnToken= 'return' ( (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] ) )? ';'
            {
            root_0 = (Object)adaptor.nil();


            returnToken=(Token)match(input,103,FOLLOW_103_in_returnStatement3804); 
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2117:4: ( (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==FLOAT||LA79_0==ID||LA79_0==INT||LA79_0==STRING||LA79_0==18||LA79_0==20||LA79_0==25||(LA79_0 >= 33 && LA79_0 <= 34)||(LA79_0 >= 36 && LA79_0 <= 39)||LA79_0==42||LA79_0==44||(LA79_0 >= 49 && LA79_0 <= 53)||(LA79_0 >= 57 && LA79_0 <= 63)||(LA79_0 >= 73 && LA79_0 <= 76)||LA79_0==78||LA79_0==86||LA79_0==98||LA79_0==101||LA79_0==109) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2117:6: (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2117:6: (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )
                    int alt78=3;
                    switch ( input.LA(1) ) {
                    case FLOAT:
                    case INT:
                    case STRING:
                    case 18:
                    case 20:
                    case 25:
                    case 33:
                    case 34:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 42:
                    case 44:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 74:
                    case 75:
                    case 76:
                    case 78:
                    case 86:
                    case 109:
                        {
                        alt78=1;
                        }
                        break;
                    case ID:
                        {
                        switch ( input.LA(2) ) {
                        case 20:
                            {
                            alt78=2;
                            }
                            break;
                        case 26:
                            {
                            switch ( input.LA(3) ) {
                            case 90:
                                {
                                int LA78_6 = input.LA(4);

                                if ( (LA78_6==20) ) {
                                    switch ( input.LA(5) ) {
                                    case INT:
                                        {
                                        int LA78_12 = input.LA(6);

                                        if ( ((LA78_12 >= 18 && LA78_12 <= 19)||(LA78_12 >= 21 && LA78_12 <= 23)||LA78_12==25||LA78_12==30||(LA78_12 >= 33 && LA78_12 <= 34)||(LA78_12 >= 36 && LA78_12 <= 40)||LA78_12==42||LA78_12==44||(LA78_12 >= 49 && LA78_12 <= 50)||LA78_12==55||(LA78_12 >= 57 && LA78_12 <= 59)||(LA78_12 >= 61 && LA78_12 <= 63)||LA78_12==66||(LA78_12 >= 74 && LA78_12 <= 77)||LA78_12==80||LA78_12==93||LA78_12==113) ) {
                                            alt78=1;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 78, 12, input);

                                            throw nvae;

                                        }
                                        }
                                        break;
                                    case ID:
                                        {
                                        int LA78_13 = input.LA(6);

                                        if ( ((LA78_13 >= 18 && LA78_13 <= 19)||(LA78_13 >= 21 && LA78_13 <= 23)||(LA78_13 >= 25 && LA78_13 <= 26)||LA78_13==30||(LA78_13 >= 33 && LA78_13 <= 34)||(LA78_13 >= 36 && LA78_13 <= 40)||LA78_13==42||LA78_13==44||(LA78_13 >= 49 && LA78_13 <= 50)||LA78_13==55||(LA78_13 >= 57 && LA78_13 <= 59)||(LA78_13 >= 61 && LA78_13 <= 63)||LA78_13==66||(LA78_13 >= 74 && LA78_13 <= 78)||LA78_13==80||LA78_13==93||LA78_13==113) ) {
                                            alt78=1;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 78, 13, input);

                                            throw nvae;

                                        }
                                        }
                                        break;
                                    case STRING:
                                        {
                                        int LA78_14 = input.LA(6);

                                        if ( ((LA78_14 >= 18 && LA78_14 <= 19)||(LA78_14 >= 21 && LA78_14 <= 23)||LA78_14==25||LA78_14==30||(LA78_14 >= 33 && LA78_14 <= 34)||(LA78_14 >= 36 && LA78_14 <= 40)||LA78_14==42||LA78_14==44||(LA78_14 >= 49 && LA78_14 <= 50)||LA78_14==55||(LA78_14 >= 57 && LA78_14 <= 59)||(LA78_14 >= 61 && LA78_14 <= 63)||LA78_14==66||(LA78_14 >= 74 && LA78_14 <= 77)||LA78_14==80||LA78_14==93||LA78_14==113) ) {
                                            alt78=1;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 78, 14, input);

                                            throw nvae;

                                        }
                                        }
                                        break;
                                    case FLOAT:
                                    case 18:
                                    case 20:
                                    case 25:
                                    case 33:
                                    case 34:
                                    case 36:
                                    case 37:
                                    case 38:
                                    case 39:
                                    case 42:
                                    case 44:
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 57:
                                    case 58:
                                    case 59:
                                    case 60:
                                    case 61:
                                    case 62:
                                    case 63:
                                    case 74:
                                    case 75:
                                    case 76:
                                    case 78:
                                    case 86:
                                    case 109:
                                        {
                                        alt78=1;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 78, 9, input);

                                        throw nvae;

                                    }

                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 78, 6, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 106:
                                {
                                int LA78_7 = input.LA(4);

                                if ( (LA78_7==20) ) {
                                    int LA78_10 = input.LA(5);

                                    if ( (LA78_10==21) ) {
                                        alt78=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 78, 10, input);

                                        throw nvae;

                                    }
                                }
                                else if ( ((LA78_7 >= 18 && LA78_7 <= 19)||(LA78_7 >= 22 && LA78_7 <= 23)||(LA78_7 >= 25 && LA78_7 <= 26)||LA78_7==30||(LA78_7 >= 32 && LA78_7 <= 34)||(LA78_7 >= 36 && LA78_7 <= 40)||LA78_7==42||LA78_7==44||(LA78_7 >= 49 && LA78_7 <= 50)||LA78_7==55||(LA78_7 >= 57 && LA78_7 <= 59)||(LA78_7 >= 61 && LA78_7 <= 63)||LA78_7==66||(LA78_7 >= 74 && LA78_7 <= 78)||LA78_7==80||LA78_7==93||LA78_7==113) ) {
                                    alt78=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 78, 7, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 82:
                            case 96:
                            case 102:
                                {
                                alt78=3;
                                }
                                break;
                            case 108:
                                {
                                int LA78_8 = input.LA(4);

                                if ( (LA78_8==20) ) {
                                    int LA78_11 = input.LA(5);

                                    if ( (LA78_11==21) ) {
                                        alt78=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 78, 11, input);

                                        throw nvae;

                                    }
                                }
                                else if ( ((LA78_8 >= 18 && LA78_8 <= 19)||(LA78_8 >= 22 && LA78_8 <= 23)||(LA78_8 >= 25 && LA78_8 <= 26)||LA78_8==30||(LA78_8 >= 32 && LA78_8 <= 34)||(LA78_8 >= 36 && LA78_8 <= 40)||LA78_8==42||LA78_8==44||(LA78_8 >= 49 && LA78_8 <= 50)||LA78_8==55||(LA78_8 >= 57 && LA78_8 <= 59)||(LA78_8 >= 61 && LA78_8 <= 63)||LA78_8==66||(LA78_8 >= 74 && LA78_8 <= 78)||LA78_8==80||LA78_8==93||LA78_8==113) ) {
                                    alt78=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 78, 8, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case ID:
                            case 94:
                            case 95:
                            case 105:
                                {
                                alt78=1;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 78, 5, input);

                                throw nvae;

                            }

                            }
                            break;
                        case 18:
                        case 19:
                        case 22:
                        case 23:
                        case 25:
                        case 30:
                        case 32:
                        case 33:
                        case 34:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 42:
                        case 44:
                        case 49:
                        case 50:
                        case 55:
                        case 57:
                        case 58:
                        case 59:
                        case 61:
                        case 62:
                        case 63:
                        case 66:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 80:
                        case 93:
                        case 113:
                            {
                            alt78=1;
                            }
                            break;
                        case 27:
                        case 28:
                        case 29:
                            {
                            alt78=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 78, 2, input);

                            throw nvae;

                        }

                        }
                        break;
                    case 53:
                    case 73:
                    case 98:
                    case 101:
                        {
                        alt78=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 78, 0, input);

                        throw nvae;

                    }

                    switch (alt78) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2117:7: exprToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_returnStatement3813);
                            exprToken=expression(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, exprToken.getTree());


                            if(!defer) {
                                retval.objReturnValue = (exprToken!=null?exprToken.objElement:null);
                            }
                            	

                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2121:6: functionToken= functionCall[defer]
                            {
                            pushFollow(FOLLOW_functionCall_in_returnStatement3822);
                            functionToken=functionCall(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, functionToken.getTree());


                            if(!defer) {
                                retval.objReturnValue = (functionToken!=null?functionToken.objElement:null);
                            }
                            	

                            }
                            break;
                        case 3 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2125:6: wrapperToken= wrappedStatement[defer]
                            {
                            pushFollow(FOLLOW_wrappedStatement_in_returnStatement3831);
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


            char_literal187=(Token)match(input,32,FOLLOW_32_in_returnStatement3839); 
            char_literal187_tree = 
            (Object)adaptor.create(char_literal187)
            ;
            adaptor.addChild(root_0, char_literal187_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2135:1: saveStatement[boolean defer] : 'save' '(' listOfSaveObjects[defer] ')' ;
    public final EugeneParser.saveStatement_return saveStatement(boolean defer) throws RecognitionException {
        EugeneParser.saveStatement_return retval = new EugeneParser.saveStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal188=null;
        Token char_literal189=null;
        Token char_literal191=null;
        EugeneParser.listOfSaveObjects_return listOfSaveObjects190 =null;


        Object string_literal188_tree=null;
        Object char_literal189_tree=null;
        Object char_literal191_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2136:2: ( 'save' '(' listOfSaveObjects[defer] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2136:4: 'save' '(' listOfSaveObjects[defer] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal188=(Token)match(input,104,FOLLOW_104_in_saveStatement3856); 
            string_literal188_tree = 
            (Object)adaptor.create(string_literal188)
            ;
            adaptor.addChild(root_0, string_literal188_tree);


            char_literal189=(Token)match(input,20,FOLLOW_20_in_saveStatement3858); 
            char_literal189_tree = 
            (Object)adaptor.create(char_literal189)
            ;
            adaptor.addChild(root_0, char_literal189_tree);


            pushFollow(FOLLOW_listOfSaveObjects_in_saveStatement3860);
            listOfSaveObjects190=listOfSaveObjects(defer);

            state._fsp--;

            adaptor.addChild(root_0, listOfSaveObjects190.getTree());

            char_literal191=(Token)match(input,21,FOLLOW_21_in_saveStatement3863); 
            char_literal191_tree = 
            (Object)adaptor.create(char_literal191)
            ;
            adaptor.addChild(root_0, char_literal191_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2139:1: listOfSaveObjects[boolean defer] : (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )? ;
    public final EugeneParser.listOfSaveObjects_return listOfSaveObjects(boolean defer) throws RecognitionException {
        EugeneParser.listOfSaveObjects_return retval = new EugeneParser.listOfSaveObjects_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token char_literal192=null;
        Token char_literal193=null;
        EugeneParser.expression_return idToken =null;

        EugeneParser.listOfSaveObjects_return listOfSaveObjects194 =null;


        Object nameToken_tree=null;
        Object char_literal192_tree=null;
        Object char_literal193_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2140:2: ( (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2140:4: (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2140:4: (nameToken= ID ':' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==ID) ) {
                int LA80_1 = input.LA(2);

                if ( (LA80_1==31) ) {
                    alt80=1;
                }
            }
            switch (alt80) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2140:5: nameToken= ID ':'
                    {
                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfSaveObjects3879); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    char_literal192=(Token)match(input,31,FOLLOW_31_in_listOfSaveObjects3881); 
                    char_literal192_tree = 
                    (Object)adaptor.create(char_literal192)
                    ;
                    adaptor.addChild(root_0, char_literal192_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_listOfSaveObjects3887);
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2148:4: ( ',' listOfSaveObjects[defer] )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==24) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2148:5: ',' listOfSaveObjects[defer]
                    {
                    char_literal193=(Token)match(input,24,FOLLOW_24_in_listOfSaveObjects3893); 
                    char_literal193_tree = 
                    (Object)adaptor.create(char_literal193)
                    ;
                    adaptor.addChild(root_0, char_literal193_tree);


                    pushFollow(FOLLOW_listOfSaveObjects_in_listOfSaveObjects3895);
                    listOfSaveObjects194=listOfSaveObjects(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, listOfSaveObjects194.getTree());

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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2161:1: ifStatement[boolean defer] : 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )? ;
    public final EugeneParser.ifStatement_return ifStatement(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.ifStatement_return retval = new EugeneParser.ifStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal195=null;
        Token char_literal196=null;
        Token char_literal197=null;
        Token char_literal198=null;
        Token char_literal199=null;
        Token string_literal200=null;
        Token string_literal201=null;
        Token char_literal202=null;
        Token char_literal203=null;
        Token char_literal204=null;
        Token char_literal205=null;
        Token string_literal206=null;
        Token char_literal207=null;
        Token char_literal208=null;
        EugeneParser.ifCondition_return ifConditionToken =null;

        EugeneParser.listOfStatements_return thenStmtToken =null;

        EugeneParser.ifCondition_return elseIfToken =null;

        EugeneParser.listOfStatements_return elseIfStmtToken =null;

        EugeneParser.listOfStatements_return elseStmtToken =null;


        Object string_literal195_tree=null;
        Object char_literal196_tree=null;
        Object char_literal197_tree=null;
        Object char_literal198_tree=null;
        Object char_literal199_tree=null;
        Object string_literal200_tree=null;
        Object string_literal201_tree=null;
        Object char_literal202_tree=null;
        Object char_literal203_tree=null;
        Object char_literal204_tree=null;
        Object char_literal205_tree=null;
        Object string_literal206_tree=null;
        Object char_literal207_tree=null;
        Object char_literal208_tree=null;


        ConditionalBranch objIfBranch = null;
        ArrayList<ConditionalBranch> lstElseIfStatements = null;
        ConditionalBranch objElseBranch = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2168:2: ( 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2168:4: 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal195=(Token)match(input,91,FOLLOW_91_in_ifStatement3935); 
            string_literal195_tree = 
            (Object)adaptor.create(string_literal195)
            ;
            adaptor.addChild(root_0, string_literal195_tree);


            char_literal196=(Token)match(input,20,FOLLOW_20_in_ifStatement3937); 
            char_literal196_tree = 
            (Object)adaptor.create(char_literal196)
            ;
            adaptor.addChild(root_0, char_literal196_tree);


            pushFollow(FOLLOW_ifCondition_in_ifStatement3941);
            ifConditionToken=ifCondition(true);

            state._fsp--;

            adaptor.addChild(root_0, ifConditionToken.getTree());

            char_literal197=(Token)match(input,21,FOLLOW_21_in_ifStatement3944); 
            char_literal197_tree = 
            (Object)adaptor.create(char_literal197)
            ;
            adaptor.addChild(root_0, char_literal197_tree);


            char_literal198=(Token)match(input,112,FOLLOW_112_in_ifStatement3946); 
            char_literal198_tree = 
            (Object)adaptor.create(char_literal198)
            ;
            adaptor.addChild(root_0, char_literal198_tree);


            pushFollow(FOLLOW_listOfStatements_in_ifStatement3950);
            thenStmtToken=listOfStatements(true);

            state._fsp--;

            adaptor.addChild(root_0, thenStmtToken.getTree());

            char_literal199=(Token)match(input,114,FOLLOW_114_in_ifStatement3953); 
            char_literal199_tree = 
            (Object)adaptor.create(char_literal199)
            ;
            adaptor.addChild(root_0, char_literal199_tree);



            if(!defer) {
               objIfBranch = new ConditionalBranch((ifConditionToken!=null?((Token)ifConditionToken.start):null), (thenStmtToken!=null?((Token)thenStmtToken.start):null)); 
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2173:17: ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==84) ) {
                    int LA82_1 = input.LA(2);

                    if ( (LA82_1==91) ) {
                        alt82=1;
                    }


                }


                switch (alt82) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2173:18: 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}'
            	    {
            	    string_literal200=(Token)match(input,84,FOLLOW_84_in_ifStatement3974); 
            	    string_literal200_tree = 
            	    (Object)adaptor.create(string_literal200)
            	    ;
            	    adaptor.addChild(root_0, string_literal200_tree);


            	    string_literal201=(Token)match(input,91,FOLLOW_91_in_ifStatement3976); 
            	    string_literal201_tree = 
            	    (Object)adaptor.create(string_literal201)
            	    ;
            	    adaptor.addChild(root_0, string_literal201_tree);


            	    char_literal202=(Token)match(input,20,FOLLOW_20_in_ifStatement3978); 
            	    char_literal202_tree = 
            	    (Object)adaptor.create(char_literal202)
            	    ;
            	    adaptor.addChild(root_0, char_literal202_tree);


            	    pushFollow(FOLLOW_ifCondition_in_ifStatement3982);
            	    elseIfToken=ifCondition(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, elseIfToken.getTree());

            	    char_literal203=(Token)match(input,21,FOLLOW_21_in_ifStatement3985); 
            	    char_literal203_tree = 
            	    (Object)adaptor.create(char_literal203)
            	    ;
            	    adaptor.addChild(root_0, char_literal203_tree);


            	    char_literal204=(Token)match(input,112,FOLLOW_112_in_ifStatement3987); 
            	    char_literal204_tree = 
            	    (Object)adaptor.create(char_literal204)
            	    ;
            	    adaptor.addChild(root_0, char_literal204_tree);


            	    pushFollow(FOLLOW_listOfStatements_in_ifStatement3991);
            	    elseIfStmtToken=listOfStatements(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, elseIfStmtToken.getTree());

            	    char_literal205=(Token)match(input,114,FOLLOW_114_in_ifStatement3994); 
            	    char_literal205_tree = 
            	    (Object)adaptor.create(char_literal205)
            	    ;
            	    adaptor.addChild(root_0, char_literal205_tree);



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
            	    break loop82;
                }
            } while (true);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2182:3: ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==84) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2182:4: 'else' '{' elseStmtToken= listOfStatements[true] '}'
                    {
                    string_literal206=(Token)match(input,84,FOLLOW_84_in_ifStatement4003); 
                    string_literal206_tree = 
                    (Object)adaptor.create(string_literal206)
                    ;
                    adaptor.addChild(root_0, string_literal206_tree);


                    char_literal207=(Token)match(input,112,FOLLOW_112_in_ifStatement4005); 
                    char_literal207_tree = 
                    (Object)adaptor.create(char_literal207)
                    ;
                    adaptor.addChild(root_0, char_literal207_tree);


                    pushFollow(FOLLOW_listOfStatements_in_ifStatement4009);
                    elseStmtToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, elseStmtToken.getTree());

                    char_literal208=(Token)match(input,114,FOLLOW_114_in_ifStatement4012); 
                    char_literal208_tree = 
                    (Object)adaptor.create(char_literal208)
                    ;
                    adaptor.addChild(root_0, char_literal208_tree);



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

                    this.executeIf(objIf);
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+" => "+e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);	        
            	
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2205:1: ifCondition[boolean defer] returns [boolean b] : ( 'ON' deviceToken= ID ':' )? exprToken= expression[defer] ;
    public final EugeneParser.ifCondition_return ifCondition(boolean defer) throws RecognitionException {
        EugeneParser.ifCondition_return retval = new EugeneParser.ifCondition_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token deviceToken=null;
        Token string_literal209=null;
        Token char_literal210=null;
        EugeneParser.expression_return exprToken =null;


        Object deviceToken_tree=null;
        Object string_literal209_tree=null;
        Object char_literal210_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2206:2: ( ( 'ON' deviceToken= ID ':' )? exprToken= expression[defer] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2206:4: ( 'ON' deviceToken= ID ':' )? exprToken= expression[defer]
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2206:4: ( 'ON' deviceToken= ID ':' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==65) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2206:5: 'ON' deviceToken= ID ':'
                    {
                    string_literal209=(Token)match(input,65,FOLLOW_65_in_ifCondition4043); 
                    string_literal209_tree = 
                    (Object)adaptor.create(string_literal209)
                    ;
                    adaptor.addChild(root_0, string_literal209_tree);


                    deviceToken=(Token)match(input,ID,FOLLOW_ID_in_ifCondition4047); 
                    deviceToken_tree = 
                    (Object)adaptor.create(deviceToken)
                    ;
                    adaptor.addChild(root_0, deviceToken_tree);


                    char_literal210=(Token)match(input,31,FOLLOW_31_in_ifCondition4049); 
                    char_literal210_tree = 
                    (Object)adaptor.create(char_literal210)
                    ;
                    adaptor.addChild(root_0, char_literal210_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_ifCondition4055);
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2238:1: loopStatement[boolean defer] : ( 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}' | 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}' | 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';' );
    public final EugeneParser.loopStatement_return loopStatement(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.loopStatement_return retval = new EugeneParser.loopStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal211=null;
        Token char_literal212=null;
        Token char_literal213=null;
        Token char_literal214=null;
        Token char_literal215=null;
        Token char_literal216=null;
        Token char_literal217=null;
        Token string_literal218=null;
        Token char_literal219=null;
        Token char_literal220=null;
        Token char_literal221=null;
        Token char_literal222=null;
        Token string_literal223=null;
        Token char_literal224=null;
        Token char_literal225=null;
        Token string_literal226=null;
        Token char_literal227=null;
        Token char_literal228=null;
        Token char_literal229=null;
        EugeneParser.forInit_return initToken =null;

        EugeneParser.expression_return condToken =null;

        EugeneParser.computationalStatement_return incToken =null;

        EugeneParser.listOfStatements_return forToken =null;

        EugeneParser.listOfStatements_return whileToken =null;


        Object string_literal211_tree=null;
        Object char_literal212_tree=null;
        Object char_literal213_tree=null;
        Object char_literal214_tree=null;
        Object char_literal215_tree=null;
        Object char_literal216_tree=null;
        Object char_literal217_tree=null;
        Object string_literal218_tree=null;
        Object char_literal219_tree=null;
        Object char_literal220_tree=null;
        Object char_literal221_tree=null;
        Object char_literal222_tree=null;
        Object string_literal223_tree=null;
        Object char_literal224_tree=null;
        Object char_literal225_tree=null;
        Object string_literal226_tree=null;
        Object char_literal227_tree=null;
        Object char_literal228_tree=null;
        Object char_literal229_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2240:6: ( 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}' | 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}' | 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';' )
            int alt85=3;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt85=1;
                }
                break;
            case 111:
                {
                alt85=2;
                }
                break;
            case 83:
                {
                alt85=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;

            }

            switch (alt85) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2240:8: 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal211=(Token)match(input,88,FOLLOW_88_in_loopStatement4095); 
                    string_literal211_tree = 
                    (Object)adaptor.create(string_literal211)
                    ;
                    adaptor.addChild(root_0, string_literal211_tree);


                    char_literal212=(Token)match(input,20,FOLLOW_20_in_loopStatement4097); 
                    char_literal212_tree = 
                    (Object)adaptor.create(char_literal212)
                    ;
                    adaptor.addChild(root_0, char_literal212_tree);


                    pushFollow(FOLLOW_forInit_in_loopStatement4101);
                    initToken=forInit(true);

                    state._fsp--;

                    adaptor.addChild(root_0, initToken.getTree());

                    char_literal213=(Token)match(input,32,FOLLOW_32_in_loopStatement4104); 
                    char_literal213_tree = 
                    (Object)adaptor.create(char_literal213)
                    ;
                    adaptor.addChild(root_0, char_literal213_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement4115);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal214=(Token)match(input,32,FOLLOW_32_in_loopStatement4118); 
                    char_literal214_tree = 
                    (Object)adaptor.create(char_literal214)
                    ;
                    adaptor.addChild(root_0, char_literal214_tree);


                    pushFollow(FOLLOW_computationalStatement_in_loopStatement4129);
                    incToken=computationalStatement(true);

                    state._fsp--;

                    adaptor.addChild(root_0, incToken.getTree());

                    char_literal215=(Token)match(input,21,FOLLOW_21_in_loopStatement4132); 
                    char_literal215_tree = 
                    (Object)adaptor.create(char_literal215)
                    ;
                    adaptor.addChild(root_0, char_literal215_tree);


                    char_literal216=(Token)match(input,112,FOLLOW_112_in_loopStatement4134); 
                    char_literal216_tree = 
                    (Object)adaptor.create(char_literal216)
                    ;
                    adaptor.addChild(root_0, char_literal216_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement4146);
                    forToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, forToken.getTree());

                    char_literal217=(Token)match(input,114,FOLLOW_114_in_loopStatement4149); 
                    char_literal217_tree = 
                    (Object)adaptor.create(char_literal217)
                    ;
                    adaptor.addChild(root_0, char_literal217_tree);



                    if(!defer) {
                        forStat((initToken!=null?((Token)initToken.start):null), 
                            (condToken!=null?((Token)condToken.start):null), 
                            (incToken!=null?((Token)incToken.start):null), 
                            (forToken!=null?((Token)forToken.start):null));
                    }
                            

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2251:4: 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal218=(Token)match(input,111,FOLLOW_111_in_loopStatement4156); 
                    string_literal218_tree = 
                    (Object)adaptor.create(string_literal218)
                    ;
                    adaptor.addChild(root_0, string_literal218_tree);


                    char_literal219=(Token)match(input,20,FOLLOW_20_in_loopStatement4158); 
                    char_literal219_tree = 
                    (Object)adaptor.create(char_literal219)
                    ;
                    adaptor.addChild(root_0, char_literal219_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement4162);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal220=(Token)match(input,21,FOLLOW_21_in_loopStatement4165); 
                    char_literal220_tree = 
                    (Object)adaptor.create(char_literal220)
                    ;
                    adaptor.addChild(root_0, char_literal220_tree);


                    char_literal221=(Token)match(input,112,FOLLOW_112_in_loopStatement4167); 
                    char_literal221_tree = 
                    (Object)adaptor.create(char_literal221)
                    ;
                    adaptor.addChild(root_0, char_literal221_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement4171);
                    whileToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, whileToken.getTree());

                    char_literal222=(Token)match(input,114,FOLLOW_114_in_loopStatement4174); 
                    char_literal222_tree = 
                    (Object)adaptor.create(char_literal222)
                    ;
                    adaptor.addChild(root_0, char_literal222_tree);



                    if(!defer){
                        whileStat((condToken!=null?((Token)condToken.start):null), 
                            (whileToken!=null?((Token)whileToken.start):null));
                    }
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2257:4: 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal223=(Token)match(input,83,FOLLOW_83_in_loopStatement4181); 
                    string_literal223_tree = 
                    (Object)adaptor.create(string_literal223)
                    ;
                    adaptor.addChild(root_0, string_literal223_tree);


                    char_literal224=(Token)match(input,112,FOLLOW_112_in_loopStatement4183); 
                    char_literal224_tree = 
                    (Object)adaptor.create(char_literal224)
                    ;
                    adaptor.addChild(root_0, char_literal224_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement4187);
                    whileToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, whileToken.getTree());

                    char_literal225=(Token)match(input,114,FOLLOW_114_in_loopStatement4190); 
                    char_literal225_tree = 
                    (Object)adaptor.create(char_literal225)
                    ;
                    adaptor.addChild(root_0, char_literal225_tree);


                    string_literal226=(Token)match(input,111,FOLLOW_111_in_loopStatement4192); 
                    string_literal226_tree = 
                    (Object)adaptor.create(string_literal226)
                    ;
                    adaptor.addChild(root_0, string_literal226_tree);


                    char_literal227=(Token)match(input,20,FOLLOW_20_in_loopStatement4194); 
                    char_literal227_tree = 
                    (Object)adaptor.create(char_literal227)
                    ;
                    adaptor.addChild(root_0, char_literal227_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement4198);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal228=(Token)match(input,21,FOLLOW_21_in_loopStatement4201); 
                    char_literal228_tree = 
                    (Object)adaptor.create(char_literal228)
                    ;
                    adaptor.addChild(root_0, char_literal228_tree);


                    char_literal229=(Token)match(input,32,FOLLOW_32_in_loopStatement4202); 
                    char_literal229_tree = 
                    (Object)adaptor.create(char_literal229)
                    ;
                    adaptor.addChild(root_0, char_literal229_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2271:1: forInit[boolean defer] returns [ArrayList<NamedElement> lstElements] : (declToken= variableDeclaration[defer] |exprToken= listOfExpressions[defer] );
    public final EugeneParser.forInit_return forInit(boolean defer) throws RecognitionException {
        EugeneParser.forInit_return retval = new EugeneParser.forInit_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.variableDeclaration_return declToken =null;

        EugeneParser.listOfExpressions_return exprToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2272:2: (declToken= variableDeclaration[defer] |exprToken= listOfExpressions[defer] )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==81||LA86_0==97||LA86_0==110) ) {
                alt86=1;
            }
            else if ( (LA86_0==FLOAT||LA86_0==ID||LA86_0==INT||LA86_0==STRING||LA86_0==18||LA86_0==20||LA86_0==25||(LA86_0 >= 33 && LA86_0 <= 34)||(LA86_0 >= 36 && LA86_0 <= 39)||LA86_0==42||LA86_0==44||(LA86_0 >= 49 && LA86_0 <= 52)||(LA86_0 >= 57 && LA86_0 <= 63)||(LA86_0 >= 74 && LA86_0 <= 76)||LA86_0==78||LA86_0==86||LA86_0==109) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;

            }
            switch (alt86) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2272:4: declToken= variableDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_variableDeclaration_in_forInit4230);
                    declToken=variableDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, declToken.getTree());


                    if(!defer) {
                        retval.lstElements = new ArrayList<NamedElement>((declToken!=null?declToken.lstVariables:null));
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2277:4: exprToken= listOfExpressions[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_listOfExpressions_in_forInit4240);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2287:1: functionDeclaration returns [Function objFunction] : 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}' ;
    public final EugeneParser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        EugeneParser.functionDeclaration_return retval = new EugeneParser.functionDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal230=null;
        Token char_literal231=null;
        Token char_literal232=null;
        Token char_literal233=null;
        Token char_literal234=null;
        EugeneParser.type_return returnTypeToken =null;

        EugeneParser.listOfFunctionParamenters_return lstParametersToken =null;

        EugeneParser.listOfStatements_return lstStatementsToken =null;


        Object nameToken_tree=null;
        Object string_literal230_tree=null;
        Object char_literal231_tree=null;
        Object char_literal232_tree=null;
        Object char_literal233_tree=null;
        Object char_literal234_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2288:2: ( 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2288:4: 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}'
            {
            root_0 = (Object)adaptor.nil();


            string_literal230=(Token)match(input,89,FOLLOW_89_in_functionDeclaration4265); 
            string_literal230_tree = 
            (Object)adaptor.create(string_literal230)
            ;
            adaptor.addChild(root_0, string_literal230_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2288:15: (returnTypeToken= type )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==45||LA87_0==47||LA87_0==68||LA87_0==70||LA87_0==81||LA87_0==97||LA87_0==110) ) {
                alt87=1;
            }
            else if ( (LA87_0==ID) ) {
                int LA87_2 = input.LA(2);

                if ( (LA87_2==ID||LA87_2==78) ) {
                    alt87=1;
                }
            }
            switch (alt87) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2288:16: returnTypeToken= type
                    {
                    pushFollow(FOLLOW_type_in_functionDeclaration4270);
                    returnTypeToken=type();

                    state._fsp--;

                    adaptor.addChild(root_0, returnTypeToken.getTree());

                    }
                    break;

            }


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_functionDeclaration4276); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);



            if(null != interp.get((nameToken!=null?nameToken.getText():null))) {
                System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getText():null)+" => "+
                    "The "+(nameToken!=null?nameToken.getText():null)+" function has been declared already!");
                this.cleanUp(1);
            }
            	

            char_literal231=(Token)match(input,20,FOLLOW_20_in_functionDeclaration4280); 
            char_literal231_tree = 
            (Object)adaptor.create(char_literal231)
            ;
            adaptor.addChild(root_0, char_literal231_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2294:8: (lstParametersToken= listOfFunctionParamenters )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==ID||LA88_0==45||LA88_0==47||LA88_0==68||LA88_0==70||LA88_0==81||LA88_0==97||LA88_0==110) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2294:9: lstParametersToken= listOfFunctionParamenters
                    {
                    pushFollow(FOLLOW_listOfFunctionParamenters_in_functionDeclaration4285);
                    lstParametersToken=listOfFunctionParamenters();

                    state._fsp--;

                    adaptor.addChild(root_0, lstParametersToken.getTree());

                    }
                    break;

            }


            char_literal232=(Token)match(input,21,FOLLOW_21_in_functionDeclaration4289); 
            char_literal232_tree = 
            (Object)adaptor.create(char_literal232)
            ;
            adaptor.addChild(root_0, char_literal232_tree);


            char_literal233=(Token)match(input,112,FOLLOW_112_in_functionDeclaration4291); 
            char_literal233_tree = 
            (Object)adaptor.create(char_literal233)
            ;
            adaptor.addChild(root_0, char_literal233_tree);


            pushFollow(FOLLOW_listOfStatements_in_functionDeclaration4299);
            lstStatementsToken=listOfStatements(true);

            state._fsp--;

            adaptor.addChild(root_0, lstStatementsToken.getTree());

            char_literal234=(Token)match(input,114,FOLLOW_114_in_functionDeclaration4304); 
            char_literal234_tree = 
            (Object)adaptor.create(char_literal234)
            ;
            adaptor.addChild(root_0, char_literal234_tree);



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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2315:1: type returns [String sType] : ( 'Collection' | 'Device' '[' ']' | 'Device' | 'Part' '[' ']' | 'Part' |idToken= ID '[' ']' |idToken= ID | 'Property' '[' ']' | 'Property' | 'num' '[' ']' | 'num' | 'txt' '[' ']' | 'txt' | 'boolean' );
    public final EugeneParser.type_return type() throws RecognitionException {
        EugeneParser.type_return retval = new EugeneParser.type_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token string_literal235=null;
        Token string_literal236=null;
        Token char_literal237=null;
        Token char_literal238=null;
        Token string_literal239=null;
        Token string_literal240=null;
        Token char_literal241=null;
        Token char_literal242=null;
        Token string_literal243=null;
        Token char_literal244=null;
        Token char_literal245=null;
        Token string_literal246=null;
        Token char_literal247=null;
        Token char_literal248=null;
        Token string_literal249=null;
        Token string_literal250=null;
        Token char_literal251=null;
        Token char_literal252=null;
        Token string_literal253=null;
        Token string_literal254=null;
        Token char_literal255=null;
        Token char_literal256=null;
        Token string_literal257=null;
        Token string_literal258=null;

        Object idToken_tree=null;
        Object string_literal235_tree=null;
        Object string_literal236_tree=null;
        Object char_literal237_tree=null;
        Object char_literal238_tree=null;
        Object string_literal239_tree=null;
        Object string_literal240_tree=null;
        Object char_literal241_tree=null;
        Object char_literal242_tree=null;
        Object string_literal243_tree=null;
        Object char_literal244_tree=null;
        Object char_literal245_tree=null;
        Object string_literal246_tree=null;
        Object char_literal247_tree=null;
        Object char_literal248_tree=null;
        Object string_literal249_tree=null;
        Object string_literal250_tree=null;
        Object char_literal251_tree=null;
        Object char_literal252_tree=null;
        Object string_literal253_tree=null;
        Object string_literal254_tree=null;
        Object char_literal255_tree=null;
        Object char_literal256_tree=null;
        Object string_literal257_tree=null;
        Object string_literal258_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2316:2: ( 'Collection' | 'Device' '[' ']' | 'Device' | 'Part' '[' ']' | 'Part' |idToken= ID '[' ']' |idToken= ID | 'Property' '[' ']' | 'Property' | 'num' '[' ']' | 'num' | 'txt' '[' ']' | 'txt' | 'boolean' )
            int alt89=14;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt89=1;
                }
                break;
            case 47:
                {
                int LA89_2 = input.LA(2);

                if ( (LA89_2==78) ) {
                    alt89=2;
                }
                else if ( (LA89_2==EOF||LA89_2==DYNAMIC_NAME||LA89_2==ID||(LA89_2 >= 18 && LA89_2 <= 19)||LA89_2==21||(LA89_2 >= 23 && LA89_2 <= 25)||(LA89_2 >= 31 && LA89_2 <= 34)||(LA89_2 >= 36 && LA89_2 <= 40)||LA89_2==42||LA89_2==44||(LA89_2 >= 49 && LA89_2 <= 50)||LA89_2==55||(LA89_2 >= 57 && LA89_2 <= 59)||(LA89_2 >= 61 && LA89_2 <= 63)||LA89_2==66||(LA89_2 >= 74 && LA89_2 <= 77)||(LA89_2 >= 79 && LA89_2 <= 80)||LA89_2==93||LA89_2==113) ) {
                    alt89=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 2, input);

                    throw nvae;

                }
                }
                break;
            case 68:
                {
                int LA89_3 = input.LA(2);

                if ( (LA89_3==78) ) {
                    alt89=4;
                }
                else if ( (LA89_3==EOF||LA89_3==DYNAMIC_NAME||LA89_3==ID||(LA89_3 >= 18 && LA89_3 <= 19)||LA89_3==21||(LA89_3 >= 23 && LA89_3 <= 25)||(LA89_3 >= 31 && LA89_3 <= 34)||(LA89_3 >= 36 && LA89_3 <= 40)||LA89_3==42||LA89_3==44||(LA89_3 >= 49 && LA89_3 <= 50)||LA89_3==55||(LA89_3 >= 57 && LA89_3 <= 59)||(LA89_3 >= 61 && LA89_3 <= 63)||LA89_3==66||(LA89_3 >= 74 && LA89_3 <= 77)||(LA89_3 >= 79 && LA89_3 <= 80)||LA89_3==93||LA89_3==113) ) {
                    alt89=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 3, input);

                    throw nvae;

                }
                }
                break;
            case ID:
                {
                int LA89_4 = input.LA(2);

                if ( (LA89_4==78) ) {
                    alt89=6;
                }
                else if ( (LA89_4==EOF||LA89_4==DYNAMIC_NAME||LA89_4==ID||(LA89_4 >= 18 && LA89_4 <= 19)||LA89_4==21||(LA89_4 >= 23 && LA89_4 <= 25)||(LA89_4 >= 31 && LA89_4 <= 34)||(LA89_4 >= 36 && LA89_4 <= 40)||LA89_4==42||LA89_4==44||(LA89_4 >= 49 && LA89_4 <= 50)||LA89_4==55||(LA89_4 >= 57 && LA89_4 <= 59)||(LA89_4 >= 61 && LA89_4 <= 63)||LA89_4==66||(LA89_4 >= 74 && LA89_4 <= 77)||(LA89_4 >= 79 && LA89_4 <= 80)||LA89_4==93||LA89_4==113) ) {
                    alt89=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 4, input);

                    throw nvae;

                }
                }
                break;
            case 70:
                {
                int LA89_5 = input.LA(2);

                if ( (LA89_5==78) ) {
                    alt89=8;
                }
                else if ( (LA89_5==EOF||LA89_5==DYNAMIC_NAME||LA89_5==ID||(LA89_5 >= 18 && LA89_5 <= 19)||LA89_5==21||(LA89_5 >= 23 && LA89_5 <= 25)||(LA89_5 >= 31 && LA89_5 <= 34)||(LA89_5 >= 36 && LA89_5 <= 40)||LA89_5==42||LA89_5==44||(LA89_5 >= 49 && LA89_5 <= 50)||LA89_5==55||(LA89_5 >= 57 && LA89_5 <= 59)||(LA89_5 >= 61 && LA89_5 <= 63)||LA89_5==66||(LA89_5 >= 74 && LA89_5 <= 77)||(LA89_5 >= 79 && LA89_5 <= 80)||LA89_5==93||LA89_5==113) ) {
                    alt89=9;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 5, input);

                    throw nvae;

                }
                }
                break;
            case 97:
                {
                int LA89_6 = input.LA(2);

                if ( (LA89_6==78) ) {
                    alt89=10;
                }
                else if ( (LA89_6==EOF||LA89_6==DYNAMIC_NAME||LA89_6==ID||(LA89_6 >= 18 && LA89_6 <= 19)||LA89_6==21||(LA89_6 >= 23 && LA89_6 <= 25)||(LA89_6 >= 31 && LA89_6 <= 34)||(LA89_6 >= 36 && LA89_6 <= 40)||LA89_6==42||LA89_6==44||(LA89_6 >= 49 && LA89_6 <= 50)||LA89_6==55||(LA89_6 >= 57 && LA89_6 <= 59)||(LA89_6 >= 61 && LA89_6 <= 63)||LA89_6==66||(LA89_6 >= 74 && LA89_6 <= 77)||(LA89_6 >= 79 && LA89_6 <= 80)||LA89_6==93||LA89_6==113) ) {
                    alt89=11;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 6, input);

                    throw nvae;

                }
                }
                break;
            case 110:
                {
                int LA89_7 = input.LA(2);

                if ( (LA89_7==78) ) {
                    alt89=12;
                }
                else if ( (LA89_7==EOF||LA89_7==DYNAMIC_NAME||LA89_7==ID||(LA89_7 >= 18 && LA89_7 <= 19)||LA89_7==21||(LA89_7 >= 23 && LA89_7 <= 25)||(LA89_7 >= 31 && LA89_7 <= 34)||(LA89_7 >= 36 && LA89_7 <= 40)||LA89_7==42||LA89_7==44||(LA89_7 >= 49 && LA89_7 <= 50)||LA89_7==55||(LA89_7 >= 57 && LA89_7 <= 59)||(LA89_7 >= 61 && LA89_7 <= 63)||LA89_7==66||(LA89_7 >= 74 && LA89_7 <= 77)||(LA89_7 >= 79 && LA89_7 <= 80)||LA89_7==93||LA89_7==113) ) {
                    alt89=13;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 7, input);

                    throw nvae;

                }
                }
                break;
            case 81:
                {
                alt89=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;

            }

            switch (alt89) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2316:4: 'Collection'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal235=(Token)match(input,45,FOLLOW_45_in_type4327); 
                    string_literal235_tree = 
                    (Object)adaptor.create(string_literal235)
                    ;
                    adaptor.addChild(root_0, string_literal235_tree);



                    retval.sType =EugeneConstants.COLLECTION;	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2319:4: 'Device' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal236=(Token)match(input,47,FOLLOW_47_in_type4334); 
                    string_literal236_tree = 
                    (Object)adaptor.create(string_literal236)
                    ;
                    adaptor.addChild(root_0, string_literal236_tree);


                    char_literal237=(Token)match(input,78,FOLLOW_78_in_type4336); 
                    char_literal237_tree = 
                    (Object)adaptor.create(char_literal237)
                    ;
                    adaptor.addChild(root_0, char_literal237_tree);


                    char_literal238=(Token)match(input,79,FOLLOW_79_in_type4338); 
                    char_literal238_tree = 
                    (Object)adaptor.create(char_literal238)
                    ;
                    adaptor.addChild(root_0, char_literal238_tree);



                    retval.sType =EugeneConstants.DEVICEARRAY;	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2322:4: 'Device'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal239=(Token)match(input,47,FOLLOW_47_in_type4345); 
                    string_literal239_tree = 
                    (Object)adaptor.create(string_literal239)
                    ;
                    adaptor.addChild(root_0, string_literal239_tree);



                    retval.sType =EugeneConstants.DEVICE;	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2325:4: 'Part' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal240=(Token)match(input,68,FOLLOW_68_in_type4352); 
                    string_literal240_tree = 
                    (Object)adaptor.create(string_literal240)
                    ;
                    adaptor.addChild(root_0, string_literal240_tree);


                    char_literal241=(Token)match(input,78,FOLLOW_78_in_type4354); 
                    char_literal241_tree = 
                    (Object)adaptor.create(char_literal241)
                    ;
                    adaptor.addChild(root_0, char_literal241_tree);


                    char_literal242=(Token)match(input,79,FOLLOW_79_in_type4356); 
                    char_literal242_tree = 
                    (Object)adaptor.create(char_literal242)
                    ;
                    adaptor.addChild(root_0, char_literal242_tree);



                    retval.sType =EugeneConstants.PARTTYPEARRAY;	
                    	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2328:4: 'Part'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal243=(Token)match(input,68,FOLLOW_68_in_type4363); 
                    string_literal243_tree = 
                    (Object)adaptor.create(string_literal243)
                    ;
                    adaptor.addChild(root_0, string_literal243_tree);



                    retval.sType =EugeneConstants.PARTTYPE;	
                    	

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2331:4: idToken= ID '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_type4372); 
                    idToken_tree = 
                    (Object)adaptor.create(idToken)
                    ;
                    adaptor.addChild(root_0, idToken_tree);


                    char_literal244=(Token)match(input,78,FOLLOW_78_in_type4374); 
                    char_literal244_tree = 
                    (Object)adaptor.create(char_literal244)
                    ;
                    adaptor.addChild(root_0, char_literal244_tree);


                    char_literal245=(Token)match(input,79,FOLLOW_79_in_type4376); 
                    char_literal245_tree = 
                    (Object)adaptor.create(char_literal245)
                    ;
                    adaptor.addChild(root_0, char_literal245_tree);



                    retval.sType =EugeneConstants.PARTARRAY;	
                    	

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2334:4: idToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_type4385); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2344:4: 'Property' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal246=(Token)match(input,70,FOLLOW_70_in_type4392); 
                    string_literal246_tree = 
                    (Object)adaptor.create(string_literal246)
                    ;
                    adaptor.addChild(root_0, string_literal246_tree);


                    char_literal247=(Token)match(input,78,FOLLOW_78_in_type4394); 
                    char_literal247_tree = 
                    (Object)adaptor.create(char_literal247)
                    ;
                    adaptor.addChild(root_0, char_literal247_tree);


                    char_literal248=(Token)match(input,79,FOLLOW_79_in_type4396); 
                    char_literal248_tree = 
                    (Object)adaptor.create(char_literal248)
                    ;
                    adaptor.addChild(root_0, char_literal248_tree);



                    retval.sType =EugeneConstants.PROPERTYARRAY;	
                    	

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2347:4: 'Property'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal249=(Token)match(input,70,FOLLOW_70_in_type4403); 
                    string_literal249_tree = 
                    (Object)adaptor.create(string_literal249)
                    ;
                    adaptor.addChild(root_0, string_literal249_tree);



                    retval.sType =EugeneConstants.PROPERTY;	
                    	

                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2350:4: 'num' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal250=(Token)match(input,97,FOLLOW_97_in_type4410); 
                    string_literal250_tree = 
                    (Object)adaptor.create(string_literal250)
                    ;
                    adaptor.addChild(root_0, string_literal250_tree);


                    char_literal251=(Token)match(input,78,FOLLOW_78_in_type4412); 
                    char_literal251_tree = 
                    (Object)adaptor.create(char_literal251)
                    ;
                    adaptor.addChild(root_0, char_literal251_tree);


                    char_literal252=(Token)match(input,79,FOLLOW_79_in_type4414); 
                    char_literal252_tree = 
                    (Object)adaptor.create(char_literal252)
                    ;
                    adaptor.addChild(root_0, char_literal252_tree);



                    retval.sType =EugeneConstants.NUMLIST;	
                    	

                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2353:4: 'num'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal253=(Token)match(input,97,FOLLOW_97_in_type4421); 
                    string_literal253_tree = 
                    (Object)adaptor.create(string_literal253)
                    ;
                    adaptor.addChild(root_0, string_literal253_tree);



                    retval.sType =EugeneConstants.NUM;	
                    	

                    }
                    break;
                case 12 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2356:4: 'txt' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal254=(Token)match(input,110,FOLLOW_110_in_type4428); 
                    string_literal254_tree = 
                    (Object)adaptor.create(string_literal254)
                    ;
                    adaptor.addChild(root_0, string_literal254_tree);


                    char_literal255=(Token)match(input,78,FOLLOW_78_in_type4430); 
                    char_literal255_tree = 
                    (Object)adaptor.create(char_literal255)
                    ;
                    adaptor.addChild(root_0, char_literal255_tree);


                    char_literal256=(Token)match(input,79,FOLLOW_79_in_type4432); 
                    char_literal256_tree = 
                    (Object)adaptor.create(char_literal256)
                    ;
                    adaptor.addChild(root_0, char_literal256_tree);



                    retval.sType =EugeneConstants.TXTLIST;	
                    	

                    }
                    break;
                case 13 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2359:4: 'txt'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal257=(Token)match(input,110,FOLLOW_110_in_type4439); 
                    string_literal257_tree = 
                    (Object)adaptor.create(string_literal257)
                    ;
                    adaptor.addChild(root_0, string_literal257_tree);



                    retval.sType =EugeneConstants.TXT;	
                    	

                    }
                    break;
                case 14 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2362:4: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal258=(Token)match(input,81,FOLLOW_81_in_type4446); 
                    string_literal258_tree = 
                    (Object)adaptor.create(string_literal258)
                    ;
                    adaptor.addChild(root_0, string_literal258_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2367:1: listOfFunctionParamenters returns [ArrayList<NamedElement> lst] : paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )? ;
    public final EugeneParser.listOfFunctionParamenters_return listOfFunctionParamenters() throws RecognitionException {
        EugeneParser.listOfFunctionParamenters_return retval = new EugeneParser.listOfFunctionParamenters_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token paramNameToken=null;
        Token char_literal259=null;
        EugeneParser.type_return paramTypeToken =null;

        EugeneParser.listOfFunctionParamenters_return lstToken =null;


        Object paramNameToken_tree=null;
        Object char_literal259_tree=null;


        retval.lst =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2371:2: (paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2371:4: paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_type_in_listOfFunctionParamenters4470);
            paramTypeToken=type();

            state._fsp--;

            adaptor.addChild(root_0, paramTypeToken.getTree());

            paramNameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfFunctionParamenters4474); 
            paramNameToken_tree = 
            (Object)adaptor.create(paramNameToken)
            ;
            adaptor.addChild(root_0, paramNameToken_tree);


             
            NamedElement objParameter = this.createElement((paramTypeToken!=null?input.toString(paramTypeToken.start,paramTypeToken.stop):null),(paramNameToken!=null?paramNameToken.getText():null));
            if(objParameter!=null) {
                retval.lst.add(objParameter);
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2376:4: ( ',' lstToken= listOfFunctionParamenters )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==24) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2376:5: ',' lstToken= listOfFunctionParamenters
                    {
                    char_literal259=(Token)match(input,24,FOLLOW_24_in_listOfFunctionParamenters4479); 
                    char_literal259_tree = 
                    (Object)adaptor.create(char_literal259)
                    ;
                    adaptor.addChild(root_0, char_literal259_tree);


                    pushFollow(FOLLOW_listOfFunctionParamenters_in_listOfFunctionParamenters4483);
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2388:1: functionCall[boolean defer] returns [NamedElement objElement] : functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')' ;
    public final EugeneParser.functionCall_return functionCall(boolean defer) throws RecognitionException {
        EugeneParser.functionCall_return retval = new EugeneParser.functionCall_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token functionToken=null;
        Token char_literal260=null;
        Token char_literal261=null;
        EugeneParser.listOfParameterValues_return lstParametersToken =null;


        Object functionToken_tree=null;
        Object char_literal260_tree=null;
        Object char_literal261_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2389:2: (functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2389:4: functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            functionToken=(Token)match(input,ID,FOLLOW_ID_in_functionCall4514); 
            functionToken_tree = 
            (Object)adaptor.create(functionToken)
            ;
            adaptor.addChild(root_0, functionToken_tree);


            char_literal260=(Token)match(input,20,FOLLOW_20_in_functionCall4516); 
            char_literal260_tree = 
            (Object)adaptor.create(char_literal260)
            ;
            adaptor.addChild(root_0, char_literal260_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2389:25: (lstParametersToken= listOfParameterValues[defer] )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==FLOAT||LA91_0==ID||LA91_0==INT||LA91_0==STRING||LA91_0==18||LA91_0==20||LA91_0==25||(LA91_0 >= 33 && LA91_0 <= 34)||(LA91_0 >= 36 && LA91_0 <= 39)||LA91_0==42||LA91_0==44||(LA91_0 >= 49 && LA91_0 <= 52)||(LA91_0 >= 57 && LA91_0 <= 63)||(LA91_0 >= 74 && LA91_0 <= 76)||LA91_0==78||LA91_0==86||LA91_0==109) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2389:26: lstParametersToken= listOfParameterValues[defer]
                    {
                    pushFollow(FOLLOW_listOfParameterValues_in_functionCall4521);
                    lstParametersToken=listOfParameterValues(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstParametersToken.getTree());

                    }
                    break;

            }


            char_literal261=(Token)match(input,21,FOLLOW_21_in_functionCall4526); 
            char_literal261_tree = 
            (Object)adaptor.create(char_literal261)
            ;
            adaptor.addChild(root_0, char_literal261_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2414:1: listOfParameterValues[boolean defer] returns [ArrayList<NamedElement> lstParameterValues] : exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )? ;
    public final EugeneParser.listOfParameterValues_return listOfParameterValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfParameterValues_return retval = new EugeneParser.listOfParameterValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal262=null;
        EugeneParser.expression_return exprToken1 =null;

        EugeneParser.listOfParameterValues_return exprToken2 =null;


        Object char_literal262_tree=null;


        retval.lstParameterValues =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2418:2: (exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2418:4: exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfParameterValues4558);
            exprToken1=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken1.getTree());


            if(!defer) {
                if(null!=exprToken1) {
                    retval.lstParameterValues.add((exprToken1!=null?exprToken1.objElement:null));
                }
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2424:5: ( ',' exprToken2= listOfParameterValues[defer] )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==24) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2424:6: ',' exprToken2= listOfParameterValues[defer]
                    {
                    char_literal262=(Token)match(input,24,FOLLOW_24_in_listOfParameterValues4565); 
                    char_literal262_tree = 
                    (Object)adaptor.create(char_literal262)
                    ;
                    adaptor.addChild(root_0, char_literal262_tree);


                    pushFollow(FOLLOW_listOfParameterValues_in_listOfParameterValues4569);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2434:1: wrappedStatement[boolean defer] returns [NamedElement objElement] : ( add[defer] |permuteToken= combinatorialFunction[defer] |getToken= get[defer] |sizeToken= size[defer] |removeToken= remove[defer] |seqToken= toSequence[defer] |sbolToken= sbolStatement[defer] |genbankToken= genbankStatement[defer] |deviceToken= deviceDepthStatements[defer] );
    public final EugeneParser.wrappedStatement_return wrappedStatement(boolean defer) throws RecognitionException {
        EugeneParser.wrappedStatement_return retval = new EugeneParser.wrappedStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.combinatorialFunction_return permuteToken =null;

        EugeneParser.get_return getToken =null;

        EugeneParser.size_return sizeToken =null;

        EugeneParser.remove_return removeToken =null;

        EugeneParser.toSequence_return seqToken =null;

        EugeneParser.sbolStatement_return sbolToken =null;

        EugeneParser.genbankStatement_return genbankToken =null;

        EugeneParser.deviceDepthStatements_return deviceToken =null;

        EugeneParser.add_return add263 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2435:2: ( add[defer] |permuteToken= combinatorialFunction[defer] |getToken= get[defer] |sizeToken= size[defer] |removeToken= remove[defer] |seqToken= toSequence[defer] |sbolToken= sbolStatement[defer] |genbankToken= genbankStatement[defer] |deviceToken= deviceDepthStatements[defer] )
            int alt93=9;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA93_1 = input.LA(2);

                if ( (LA93_1==26) ) {
                    switch ( input.LA(3) ) {
                    case 90:
                        {
                        alt93=3;
                        }
                        break;
                    case 106:
                        {
                        alt93=4;
                        }
                        break;
                    case 102:
                        {
                        alt93=5;
                        }
                        break;
                    case 108:
                        {
                        alt93=6;
                        }
                        break;
                    case 82:
                    case 96:
                        {
                        alt93=9;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 93, 5, input);

                        throw nvae;

                    }

                }
                else if ( ((LA93_1 >= 27 && LA93_1 <= 29)) ) {
                    alt93=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 93, 1, input);

                    throw nvae;

                }
                }
                break;
            case 98:
            case 101:
                {
                alt93=2;
                }
                break;
            case 73:
                {
                alt93=7;
                }
                break;
            case 53:
                {
                alt93=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;

            }

            switch (alt93) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2435:4: add[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_add_in_wrappedStatement4594);
                    add263=add(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, add263.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2436:10: permuteToken= combinatorialFunction[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_combinatorialFunction_in_wrappedStatement4609);
                    permuteToken=combinatorialFunction(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, permuteToken.getTree());


                    if(!defer) {
                        retval.objElement = (permuteToken!=null?permuteToken.objDeviceArray:null);
                    }


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2441:4: getToken= get[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_get_in_wrappedStatement4619);
                    getToken=get(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, getToken.getTree());


                    if(!defer) {
                        retval.objElement = (getToken!=null?getToken.objElement:null);
                    }	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2446:4: sizeToken= size[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_size_in_wrappedStatement4629);
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
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2453:4: removeToken= remove[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_remove_in_wrappedStatement4639);
                    removeToken=remove(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, removeToken.getTree());

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2454:4: seqToken= toSequence[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_toSequence_in_wrappedStatement4648);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2461:4: sbolToken= sbolStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_sbolStatement_in_wrappedStatement4658);
                    sbolToken=sbolStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolToken.getTree());


                    if(!defer) {
                        retval.objElement = sbolToken.objElement;
                    }	
                    	

                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2466:4: genbankToken= genbankStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_genbankStatement_in_wrappedStatement4668);
                    genbankToken=genbankStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankToken.getTree());


                    if(!defer) {
                        retval.objElement = genbankToken.objElement;
                    }	
                    	

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2471:10: deviceToken= deviceDepthStatements[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDepthStatements_in_wrappedStatement4684);
                    deviceToken=deviceDepthStatements(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());


                    if(!defer) {
                        retval.objElement = deviceToken.objElement;
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


    public static class deviceDepthStatements_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "deviceDepthStatements"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2482:1: deviceDepthStatements[boolean defer] returns [NamedElement objElement] : deviceToken= ID '.' ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' ) ;
    public final EugeneParser.deviceDepthStatements_return deviceDepthStatements(boolean defer) throws RecognitionException {
        EugeneParser.deviceDepthStatements_return retval = new EugeneParser.deviceDepthStatements_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token deviceToken=null;
        Token char_literal264=null;
        Token string_literal265=null;
        Token char_literal266=null;
        Token char_literal267=null;
        Token string_literal268=null;
        Token char_literal269=null;
        Token char_literal270=null;
        EugeneParser.expression_return depthToken =null;


        Object deviceToken_tree=null;
        Object char_literal264_tree=null;
        Object string_literal265_tree=null;
        Object char_literal266_tree=null;
        Object char_literal267_tree=null;
        Object string_literal268_tree=null;
        Object char_literal269_tree=null;
        Object char_literal270_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2484:2: (deviceToken= ID '.' ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2484:4: deviceToken= ID '.' ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' )
            {
            root_0 = (Object)adaptor.nil();


            deviceToken=(Token)match(input,ID,FOLLOW_ID_in_deviceDepthStatements4715); 
            deviceToken_tree = 
            (Object)adaptor.create(deviceToken)
            ;
            adaptor.addChild(root_0, deviceToken_tree);


            char_literal264=(Token)match(input,26,FOLLOW_26_in_deviceDepthStatements4717); 
            char_literal264_tree = 
            (Object)adaptor.create(char_literal264)
            ;
            adaptor.addChild(root_0, char_literal264_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2485:4: ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==82) ) {
                alt94=1;
            }
            else if ( (LA94_0==96) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;

            }
            switch (alt94) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2485:5: 'depth' '(' depthToken= expression[defer] ')'
                    {
                    string_literal265=(Token)match(input,82,FOLLOW_82_in_deviceDepthStatements4724); 
                    string_literal265_tree = 
                    (Object)adaptor.create(string_literal265)
                    ;
                    adaptor.addChild(root_0, string_literal265_tree);


                    char_literal266=(Token)match(input,20,FOLLOW_20_in_deviceDepthStatements4726); 
                    char_literal266_tree = 
                    (Object)adaptor.create(char_literal266)
                    ;
                    adaptor.addChild(root_0, char_literal266_tree);


                    pushFollow(FOLLOW_expression_in_deviceDepthStatements4730);
                    depthToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, depthToken.getTree());

                    char_literal267=(Token)match(input,21,FOLLOW_21_in_deviceDepthStatements4733); 
                    char_literal267_tree = 
                    (Object)adaptor.create(char_literal267)
                    ;
                    adaptor.addChild(root_0, char_literal267_tree);



                    if(!defer) {
                        retval.objElement = interp.getDeviceDepth((deviceToken!=null?deviceToken.getText():null), (depthToken!=null?depthToken.objElement:null));    
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2490:5: 'maxDepth' '(' ')'
                    {
                    string_literal268=(Token)match(input,96,FOLLOW_96_in_deviceDepthStatements4741); 
                    string_literal268_tree = 
                    (Object)adaptor.create(string_literal268)
                    ;
                    adaptor.addChild(root_0, string_literal268_tree);


                    char_literal269=(Token)match(input,20,FOLLOW_20_in_deviceDepthStatements4743); 
                    char_literal269_tree = 
                    (Object)adaptor.create(char_literal269)
                    ;
                    adaptor.addChild(root_0, char_literal269_tree);


                    char_literal270=(Token)match(input,21,FOLLOW_21_in_deviceDepthStatements4745); 
                    char_literal270_tree = 
                    (Object)adaptor.create(char_literal270)
                    ;
                    adaptor.addChild(root_0, char_literal270_tree);



                    if(!defer) {
                        retval.objElement = interp.getDeviceMaxDepth((deviceToken!=null?deviceToken.getText():null));
                    }	
                    	

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+(deviceToken!=null?deviceToken.getLine():0)+":"+(deviceToken!=null?deviceToken.getCharPositionInLine():0)+" => "+
                            e.getMessage());
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "deviceDepthStatements"


    public static class add_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "add"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2502:1: add[boolean defer] : componentToken= ID ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' ) ;
    public final EugeneParser.add_return add(boolean defer) throws RecognitionException {
        EugeneParser.add_return retval = new EugeneParser.add_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token componentToken=null;
        Token propertyToken=null;
        Token string_literal271=null;
        Token char_literal272=null;
        Token char_literal273=null;
        Token string_literal274=null;
        Token char_literal275=null;
        Token char_literal276=null;
        Token string_literal277=null;
        Token char_literal278=null;
        Token char_literal279=null;
        EugeneParser.listOfExpressions_return lstAdd =null;

        EugeneParser.listOfIDs_return lstToken =null;


        Object componentToken_tree=null;
        Object propertyToken_tree=null;
        Object string_literal271_tree=null;
        Object char_literal272_tree=null;
        Object char_literal273_tree=null;
        Object string_literal274_tree=null;
        Object char_literal275_tree=null;
        Object char_literal276_tree=null;
        Object string_literal277_tree=null;
        Object char_literal278_tree=null;
        Object char_literal279_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2503:2: (componentToken= ID ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2503:4: componentToken= ID ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' )
            {
            root_0 = (Object)adaptor.nil();


            componentToken=(Token)match(input,ID,FOLLOW_ID_in_add4769); 
            componentToken_tree = 
            (Object)adaptor.create(componentToken)
            ;
            adaptor.addChild(root_0, componentToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2503:22: ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' )
            int alt95=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt95=1;
                }
                break;
            case 29:
                {
                alt95=2;
                }
                break;
            case 28:
                {
                alt95=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;

            }

            switch (alt95) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2504:4: '.add' '(' lstAdd= listOfExpressions[defer] ')'
                    {
                    string_literal271=(Token)match(input,27,FOLLOW_27_in_add4776); 
                    string_literal271_tree = 
                    (Object)adaptor.create(string_literal271)
                    ;
                    adaptor.addChild(root_0, string_literal271_tree);


                    char_literal272=(Token)match(input,20,FOLLOW_20_in_add4778); 
                    char_literal272_tree = 
                    (Object)adaptor.create(char_literal272)
                    ;
                    adaptor.addChild(root_0, char_literal272_tree);


                    pushFollow(FOLLOW_listOfExpressions_in_add4782);
                    lstAdd=listOfExpressions(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstAdd.getTree());

                    char_literal273=(Token)match(input,21,FOLLOW_21_in_add4785); 
                    char_literal273_tree = 
                    (Object)adaptor.create(char_literal273)
                    ;
                    adaptor.addChild(root_0, char_literal273_tree);



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
                            } else if (objElement instanceof EugeneCollection) {
                                EugeneCollection objCollection = (EugeneCollection)objElement;
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
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2563:4: '.addProperty' '(' propertyToken= ID ')'
                    {
                    string_literal274=(Token)match(input,29,FOLLOW_29_in_add4793); 
                    string_literal274_tree = 
                    (Object)adaptor.create(string_literal274)
                    ;
                    adaptor.addChild(root_0, string_literal274_tree);


                    char_literal275=(Token)match(input,20,FOLLOW_20_in_add4795); 
                    char_literal275_tree = 
                    (Object)adaptor.create(char_literal275)
                    ;
                    adaptor.addChild(root_0, char_literal275_tree);


                    propertyToken=(Token)match(input,ID,FOLLOW_ID_in_add4799); 
                    propertyToken_tree = 
                    (Object)adaptor.create(propertyToken)
                    ;
                    adaptor.addChild(root_0, propertyToken_tree);


                    char_literal276=(Token)match(input,21,FOLLOW_21_in_add4801); 
                    char_literal276_tree = 
                    (Object)adaptor.create(char_literal276)
                    ;
                    adaptor.addChild(root_0, char_literal276_tree);



                    if(!defer) {
                        interp.addProperty((componentToken!=null?componentToken.getText():null), (propertyToken!=null?propertyToken.getText():null));    
                    }	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2568:4: '.addProperties' '(' lstToken= listOfIDs[defer] ')'
                    {
                    string_literal277=(Token)match(input,28,FOLLOW_28_in_add4808); 
                    string_literal277_tree = 
                    (Object)adaptor.create(string_literal277)
                    ;
                    adaptor.addChild(root_0, string_literal277_tree);


                    char_literal278=(Token)match(input,20,FOLLOW_20_in_add4810); 
                    char_literal278_tree = 
                    (Object)adaptor.create(char_literal278)
                    ;
                    adaptor.addChild(root_0, char_literal278_tree);


                    pushFollow(FOLLOW_listOfIDs_in_add4814);
                    lstToken=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());

                    char_literal279=(Token)match(input,21,FOLLOW_21_in_add4817); 
                    char_literal279_tree = 
                    (Object)adaptor.create(char_literal279)
                    ;
                    adaptor.addChild(root_0, char_literal279_tree);



                    if(!defer) {
                        interp.addProperties((componentToken!=null?componentToken.getText():null), (lstToken!=null?lstToken.lstElements:null));    
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

            System.err.println("line "+(componentToken!=null?componentToken.getLine():0)+":"+(componentToken!=null?componentToken.getCharPositionInLine():0)+" => "+exc.toString());
            exc.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2581:1: toSequence[boolean defer] returns [String sequence] : idToken= ID '.' 'toSequence' '(' ')' ;
    public final EugeneParser.toSequence_return toSequence(boolean defer) throws RecognitionException {
        EugeneParser.toSequence_return retval = new EugeneParser.toSequence_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal280=null;
        Token string_literal281=null;
        Token char_literal282=null;
        Token char_literal283=null;

        Object idToken_tree=null;
        Object char_literal280_tree=null;
        Object string_literal281_tree=null;
        Object char_literal282_tree=null;
        Object char_literal283_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2582:2: (idToken= ID '.' 'toSequence' '(' ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2582:4: idToken= ID '.' 'toSequence' '(' ')'
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_toSequence4848); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal280=(Token)match(input,26,FOLLOW_26_in_toSequence4850); 
            char_literal280_tree = 
            (Object)adaptor.create(char_literal280)
            ;
            adaptor.addChild(root_0, char_literal280_tree);


            string_literal281=(Token)match(input,108,FOLLOW_108_in_toSequence4852); 
            string_literal281_tree = 
            (Object)adaptor.create(string_literal281)
            ;
            adaptor.addChild(root_0, string_literal281_tree);


            char_literal282=(Token)match(input,20,FOLLOW_20_in_toSequence4854); 
            char_literal282_tree = 
            (Object)adaptor.create(char_literal282)
            ;
            adaptor.addChild(root_0, char_literal282_tree);


            char_literal283=(Token)match(input,21,FOLLOW_21_in_toSequence4856); 
            char_literal283_tree = 
            (Object)adaptor.create(char_literal283)
            ;
            adaptor.addChild(root_0, char_literal283_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2601:1: get[boolean defer] returns [NamedElement objElement] : idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')' ;
    public final EugeneParser.get_return get(boolean defer) throws RecognitionException {
        EugeneParser.get_return retval = new EugeneParser.get_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token idxToken=null;
        Token varToken=null;
        Token strToken=null;
        Token char_literal284=null;
        Token string_literal285=null;
        Token char_literal286=null;
        Token char_literal287=null;

        Object idToken_tree=null;
        Object idxToken_tree=null;
        Object varToken_tree=null;
        Object strToken_tree=null;
        Object char_literal284_tree=null;
        Object string_literal285_tree=null;
        Object char_literal286_tree=null;
        Object char_literal287_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2602:2: (idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2602:4: idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')'
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_get4876); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal284=(Token)match(input,26,FOLLOW_26_in_get4878); 
            char_literal284_tree = 
            (Object)adaptor.create(char_literal284)
            ;
            adaptor.addChild(root_0, char_literal284_tree);


            string_literal285=(Token)match(input,90,FOLLOW_90_in_get4880); 
            string_literal285_tree = 
            (Object)adaptor.create(string_literal285)
            ;
            adaptor.addChild(root_0, string_literal285_tree);


            char_literal286=(Token)match(input,20,FOLLOW_20_in_get4882); 
            char_literal286_tree = 
            (Object)adaptor.create(char_literal286)
            ;
            adaptor.addChild(root_0, char_literal286_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2602:29: (idxToken= INT |varToken= ID |strToken= STRING )
            int alt96=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt96=1;
                }
                break;
            case ID:
                {
                alt96=2;
                }
                break;
            case STRING:
                {
                alt96=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;

            }

            switch (alt96) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2602:30: idxToken= INT
                    {
                    idxToken=(Token)match(input,INT,FOLLOW_INT_in_get4887); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2608:6: varToken= ID
                    {
                    varToken=(Token)match(input,ID,FOLLOW_ID_in_get4895); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2614:6: strToken= STRING
                    {
                    strToken=(Token)match(input,STRING,FOLLOW_STRING_in_get4903); 
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


            char_literal287=(Token)match(input,21,FOLLOW_21_in_get4908); 
            char_literal287_tree = 
            (Object)adaptor.create(char_literal287)
            ;
            adaptor.addChild(root_0, char_literal287_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2668:1: size[boolean defer] returns [double nSize] : idToken= ID '.' 'size' '(' ')' -> ^( '.' 'size' ) ;
    public final EugeneParser.size_return size(boolean defer) throws RecognitionException {
        EugeneParser.size_return retval = new EugeneParser.size_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal288=null;
        Token string_literal289=null;
        Token char_literal290=null;
        Token char_literal291=null;

        Object idToken_tree=null;
        Object char_literal288_tree=null;
        Object string_literal289_tree=null;
        Object char_literal290_tree=null;
        Object char_literal291_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_106=new RewriteRuleTokenStream(adaptor,"token 106");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2669:2: (idToken= ID '.' 'size' '(' ')' -> ^( '.' 'size' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2669:4: idToken= ID '.' 'size' '(' ')'
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_size4941);  
            stream_ID.add(idToken);


            char_literal288=(Token)match(input,26,FOLLOW_26_in_size4943);  
            stream_26.add(char_literal288);


            string_literal289=(Token)match(input,106,FOLLOW_106_in_size4945);  
            stream_106.add(string_literal289);


            char_literal290=(Token)match(input,20,FOLLOW_20_in_size4947);  
            stream_20.add(char_literal290);


            char_literal291=(Token)match(input,21,FOLLOW_21_in_size4949);  
            stream_21.add(char_literal291);



            if(!defer) {
                retval.nSize = interp.sizeOf((idToken!=null?idToken.getText():null));
            }	
            	

            // AST REWRITE
            // elements: 106, 26
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 2673:4: -> ^( '.' 'size' )
            {
                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2673:7: ^( '.' 'size' )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_26.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                stream_106.nextNode()
                );

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

            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);        	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "size"


    public static class remove_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "remove"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2682:1: remove[boolean defer] : idToken= ID '.' 'remove' '(' idxToken= expression[defer] ')' -> ^( '.' 'remove' ) ;
    public final EugeneParser.remove_return remove(boolean defer) throws RecognitionException {
        EugeneParser.remove_return retval = new EugeneParser.remove_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal292=null;
        Token string_literal293=null;
        Token char_literal294=null;
        Token char_literal295=null;
        EugeneParser.expression_return idxToken =null;


        Object idToken_tree=null;
        Object char_literal292_tree=null;
        Object string_literal293_tree=null;
        Object char_literal294_tree=null;
        Object char_literal295_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2683:2: (idToken= ID '.' 'remove' '(' idxToken= expression[defer] ')' -> ^( '.' 'remove' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2683:4: idToken= ID '.' 'remove' '(' idxToken= expression[defer] ')'
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_remove4979);  
            stream_ID.add(idToken);


            char_literal292=(Token)match(input,26,FOLLOW_26_in_remove4981);  
            stream_26.add(char_literal292);


            string_literal293=(Token)match(input,102,FOLLOW_102_in_remove4983);  
            stream_102.add(string_literal293);


            char_literal294=(Token)match(input,20,FOLLOW_20_in_remove4985);  
            stream_20.add(char_literal294);


            pushFollow(FOLLOW_expression_in_remove4989);
            idxToken=expression(defer);

            state._fsp--;

            stream_expression.add(idxToken.getTree());

            char_literal295=(Token)match(input,21,FOLLOW_21_in_remove4992);  
            stream_21.add(char_literal295);



            if(!defer) {
                interp.remove((idToken!=null?idToken.getText():null), (idxToken!=null?idxToken.objElement:null));
            }	
            	

            // AST REWRITE
            // elements: 102, 26
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 2687:4: -> ^( '.' 'remove' )
            {
                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2687:7: ^( '.' 'remove' )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_26.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                stream_102.nextNode()
                );

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

            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+ e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);        	
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "remove"


    public static class listOfRules_return extends ParserRuleReturnScope {
        public ArrayList<Rule> lstRules;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfRules"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2750:1: listOfRules[boolean defer] returns [ArrayList<Rule> lstRules] : idToken= ID ( ',' idToken= ID )* ;
    public final EugeneParser.listOfRules_return listOfRules(boolean defer) throws RecognitionException {
        EugeneParser.listOfRules_return retval = new EugeneParser.listOfRules_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal296=null;

        Object idToken_tree=null;
        Object char_literal296_tree=null;


        retval.lstRules = new ArrayList<Rule>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2755:2: (idToken= ID ( ',' idToken= ID )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2755:4: idToken= ID ( ',' idToken= ID )*
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfRules5038); 
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2770:4: ( ',' idToken= ID )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==24) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2770:5: ',' idToken= ID
            	    {
            	    char_literal296=(Token)match(input,24,FOLLOW_24_in_listOfRules5043); 
            	    char_literal296_tree = 
            	    (Object)adaptor.create(char_literal296)
            	    ;
            	    adaptor.addChild(root_0, char_literal296_tree);


            	    idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfRules5047); 
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
            	    break loop97;
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


    public static class combinatorialFunction_return extends ParserRuleReturnScope {
        public DeviceArray objDeviceArray;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "combinatorialFunction"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2791:1: combinatorialFunction[boolean defer] returns [DeviceArray objDeviceArray] : functionToken= ( 'permute' | 'product' ) '(' deviceToken= ID ( ',' rulesToken= ( 'strict' | 'flexible' ) )? ( ',' (capToken= expression[defer] )? )? ( ',' (depthToken= expression[defer] )? )? ')' ;
    public final EugeneParser.combinatorialFunction_return combinatorialFunction(boolean defer) throws RecognitionException {
        EugeneParser.combinatorialFunction_return retval = new EugeneParser.combinatorialFunction_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token functionToken=null;
        Token deviceToken=null;
        Token rulesToken=null;
        Token char_literal297=null;
        Token char_literal298=null;
        Token char_literal299=null;
        Token char_literal300=null;
        Token char_literal301=null;
        EugeneParser.expression_return capToken =null;

        EugeneParser.expression_return depthToken =null;


        Object functionToken_tree=null;
        Object deviceToken_tree=null;
        Object rulesToken_tree=null;
        Object char_literal297_tree=null;
        Object char_literal298_tree=null;
        Object char_literal299_tree=null;
        Object char_literal300_tree=null;
        Object char_literal301_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2792:6: (functionToken= ( 'permute' | 'product' ) '(' deviceToken= ID ( ',' rulesToken= ( 'strict' | 'flexible' ) )? ( ',' (capToken= expression[defer] )? )? ( ',' (depthToken= expression[defer] )? )? ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2792:11: functionToken= ( 'permute' | 'product' ) '(' deviceToken= ID ( ',' rulesToken= ( 'strict' | 'flexible' ) )? ( ',' (capToken= expression[defer] )? )? ( ',' (depthToken= expression[defer] )? )? ')'
            {
            root_0 = (Object)adaptor.nil();


            functionToken=(Token)input.LT(1);

            if ( input.LA(1)==98||input.LA(1)==101 ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(functionToken)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            char_literal297=(Token)match(input,20,FOLLOW_20_in_combinatorialFunction5086); 
            char_literal297_tree = 
            (Object)adaptor.create(char_literal297)
            ;
            adaptor.addChild(root_0, char_literal297_tree);


            deviceToken=(Token)match(input,ID,FOLLOW_ID_in_combinatorialFunction5098); 
            deviceToken_tree = 
            (Object)adaptor.create(deviceToken)
            ;
            adaptor.addChild(root_0, deviceToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2794:8: ( ',' rulesToken= ( 'strict' | 'flexible' ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==24) ) {
                int LA98_1 = input.LA(2);

                if ( (LA98_1==87||LA98_1==107) ) {
                    alt98=1;
                }
            }
            switch (alt98) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2794:9: ',' rulesToken= ( 'strict' | 'flexible' )
                    {
                    char_literal298=(Token)match(input,24,FOLLOW_24_in_combinatorialFunction5124); 
                    char_literal298_tree = 
                    (Object)adaptor.create(char_literal298)
                    ;
                    adaptor.addChild(root_0, char_literal298_tree);


                    rulesToken=(Token)input.LT(1);

                    if ( input.LA(1)==87||input.LA(1)==107 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(rulesToken)
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


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2795:8: ( ',' (capToken= expression[defer] )? )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==24) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2795:9: ',' (capToken= expression[defer] )?
                    {
                    char_literal299=(Token)match(input,24,FOLLOW_24_in_combinatorialFunction5153); 
                    char_literal299_tree = 
                    (Object)adaptor.create(char_literal299)
                    ;
                    adaptor.addChild(root_0, char_literal299_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2795:13: (capToken= expression[defer] )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==FLOAT||LA99_0==ID||LA99_0==INT||LA99_0==STRING||LA99_0==18||LA99_0==20||LA99_0==25||(LA99_0 >= 33 && LA99_0 <= 34)||(LA99_0 >= 36 && LA99_0 <= 39)||LA99_0==42||LA99_0==44||(LA99_0 >= 49 && LA99_0 <= 52)||(LA99_0 >= 57 && LA99_0 <= 63)||(LA99_0 >= 74 && LA99_0 <= 76)||LA99_0==78||LA99_0==86||LA99_0==109) ) {
                        alt99=1;
                    }
                    switch (alt99) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2795:14: capToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_combinatorialFunction5158);
                            capToken=expression(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, capToken.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2796:8: ( ',' (depthToken= expression[defer] )? )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==24) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2796:9: ',' (depthToken= expression[defer] )?
                    {
                    char_literal300=(Token)match(input,24,FOLLOW_24_in_combinatorialFunction5175); 
                    char_literal300_tree = 
                    (Object)adaptor.create(char_literal300)
                    ;
                    adaptor.addChild(root_0, char_literal300_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2796:13: (depthToken= expression[defer] )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( (LA101_0==FLOAT||LA101_0==ID||LA101_0==INT||LA101_0==STRING||LA101_0==18||LA101_0==20||LA101_0==25||(LA101_0 >= 33 && LA101_0 <= 34)||(LA101_0 >= 36 && LA101_0 <= 39)||LA101_0==42||LA101_0==44||(LA101_0 >= 49 && LA101_0 <= 52)||(LA101_0 >= 57 && LA101_0 <= 63)||(LA101_0 >= 74 && LA101_0 <= 76)||LA101_0==78||LA101_0==86||LA101_0==109) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2796:14: depthToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_combinatorialFunction5180);
                            depthToken=expression(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, depthToken.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            char_literal301=(Token)match(input,21,FOLLOW_21_in_combinatorialFunction5187); 
            char_literal301_tree = 
            (Object)adaptor.create(char_literal301)
            ;
            adaptor.addChild(root_0, char_literal301_tree);


                // depth            
            if(!defer) {
                retval.objDeviceArray = interp.generateDevices(
                        (functionToken!=null?functionToken.getText():null),
                        (deviceToken!=null?deviceToken.getText():null), 
                        (rulesToken!=null?rulesToken.getText():null),
                        (capToken!=null?capToken.objElement:null),
                        (depthToken!=null?depthToken.objElement:null));
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (Exception e) {

            System.err.println("line "+(functionToken!=null?functionToken.getLine():0)+":"+(functionToken!=null?functionToken.getCharPositionInLine():0)+" => "+ e.toString());
            e.printStackTrace();
            this.cleanUp(1);
                	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "combinatorialFunction"


    public static class getObject_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "getObject"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2814:1: getObject[NamedElement objElement] : ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )* ;
    public final EugeneParser.getObject_return getObject(NamedElement objElement) throws RecognitionException {
        EugeneParser.getObject_return retval = new EugeneParser.getObject_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token elementToken=null;
        Token char_literal302=null;
        Token char_literal303=null;
        Token char_literal304=null;
        EugeneParser.expression_return exprToken =null;


        Object elementToken_tree=null;
        Object char_literal302_tree=null;
        Object char_literal303_tree=null;
        Object char_literal304_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:2: ( ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:4: ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )*
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:4: ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )*
            loop103:
            do {
                int alt103=3;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==26) ) {
                    alt103=1;
                }
                else if ( (LA103_0==78) ) {
                    alt103=2;
                }


                switch (alt103) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:5: ( '.' elementToken= ID )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:5: ( '.' elementToken= ID )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:6: '.' elementToken= ID
            	    {
            	    char_literal302=(Token)match(input,26,FOLLOW_26_in_getObject5219); 
            	    char_literal302_tree = 
            	    (Object)adaptor.create(char_literal302)
            	    ;
            	    adaptor.addChild(root_0, char_literal302_tree);


            	    elementToken=(Token)match(input,ID,FOLLOW_ID_in_getObject5223); 
            	    elementToken_tree = 
            	    (Object)adaptor.create(elementToken)
            	    ;
            	    adaptor.addChild(root_0, elementToken_tree);


            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:29: ( '[' exprToken= expression[true] ']' )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:29: ( '[' exprToken= expression[true] ']' )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:30: '[' exprToken= expression[true] ']'
            	    {
            	    char_literal303=(Token)match(input,78,FOLLOW_78_in_getObject5229); 
            	    char_literal303_tree = 
            	    (Object)adaptor.create(char_literal303)
            	    ;
            	    adaptor.addChild(root_0, char_literal303_tree);


            	    pushFollow(FOLLOW_expression_in_getObject5233);
            	    exprToken=expression(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, exprToken.getTree());

            	    char_literal304=(Token)match(input,79,FOLLOW_79_in_getObject5236); 
            	    char_literal304_tree = 
            	    (Object)adaptor.create(char_literal304)
            	    ;
            	    adaptor.addChild(root_0, char_literal304_tree);


            	    }


            	    }
            	    break;

            	default :
            	    break loop103;
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2853:1: printStatement[boolean defer] : (| 'println' '(' ')' | 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' | 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' );
    public final EugeneParser.printStatement_return printStatement(boolean defer) throws RecognitionException {
        EugeneParser.printStatement_return retval = new EugeneParser.printStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal305=null;
        Token char_literal306=null;
        Token char_literal307=null;
        Token string_literal308=null;
        Token char_literal309=null;
        Token char_literal310=null;
        Token char_literal311=null;
        Token string_literal312=null;
        Token char_literal313=null;
        Token char_literal314=null;
        Token char_literal315=null;
        EugeneParser.whatToPrint_return printToken1 =null;

        EugeneParser.whatToPrint_return printToken2 =null;


        Object string_literal305_tree=null;
        Object char_literal306_tree=null;
        Object char_literal307_tree=null;
        Object string_literal308_tree=null;
        Object char_literal309_tree=null;
        Object char_literal310_tree=null;
        Object char_literal311_tree=null;
        Object string_literal312_tree=null;
        Object char_literal313_tree=null;
        Object char_literal314_tree=null;
        Object char_literal315_tree=null;


        System.err.flush();
        System.out.flush();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2861:2: (| 'println' '(' ')' | 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' | 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' )
            int alt106=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt106=1;
                }
                break;
            case 100:
                {
                int LA106_2 = input.LA(2);

                if ( (LA106_2==20) ) {
                    int LA106_4 = input.LA(3);

                    if ( (LA106_4==21) ) {
                        alt106=2;
                    }
                    else if ( (LA106_4==FLOAT||LA106_4==ID||LA106_4==INT||LA106_4==STRING||LA106_4==18||LA106_4==20||LA106_4==25||(LA106_4 >= 33 && LA106_4 <= 34)||(LA106_4 >= 36 && LA106_4 <= 39)||LA106_4==42||LA106_4==44||(LA106_4 >= 49 && LA106_4 <= 53)||(LA106_4 >= 57 && LA106_4 <= 63)||(LA106_4 >= 73 && LA106_4 <= 76)||LA106_4==78||LA106_4==86||LA106_4==98||LA106_4==101||LA106_4==109) ) {
                        alt106=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 106, 4, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 2, input);

                    throw nvae;

                }
                }
                break;
            case 99:
                {
                alt106=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;

            }

            switch (alt106) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2862:9: 
                    {
                    root_0 = (Object)adaptor.nil();


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2862:11: 'println' '(' ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal305=(Token)match(input,100,FOLLOW_100_in_printStatement5279); 
                    string_literal305_tree = 
                    (Object)adaptor.create(string_literal305)
                    ;
                    adaptor.addChild(root_0, string_literal305_tree);


                    char_literal306=(Token)match(input,20,FOLLOW_20_in_printStatement5281); 
                    char_literal306_tree = 
                    (Object)adaptor.create(char_literal306)
                    ;
                    adaptor.addChild(root_0, char_literal306_tree);


                    char_literal307=(Token)match(input,21,FOLLOW_21_in_printStatement5283); 
                    char_literal307_tree = 
                    (Object)adaptor.create(char_literal307)
                    ;
                    adaptor.addChild(root_0, char_literal307_tree);



                    if(!defer) {
                            System.out.println();
                    }
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2867:11: 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal308=(Token)match(input,99,FOLLOW_99_in_printStatement5297); 
                    string_literal308_tree = 
                    (Object)adaptor.create(string_literal308)
                    ;
                    adaptor.addChild(root_0, string_literal308_tree);


                    char_literal309=(Token)match(input,20,FOLLOW_20_in_printStatement5299); 
                    char_literal309_tree = 
                    (Object)adaptor.create(char_literal309)
                    ;
                    adaptor.addChild(root_0, char_literal309_tree);


                    pushFollow(FOLLOW_whatToPrint_in_printStatement5303);
                    printToken1=whatToPrint(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printToken1.getTree());


                    if(!defer) {        
                        System.out.print((printToken1!=null?printToken1.s:null));
                    }
                            

                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2871:11: ( ',' printToken2= whatToPrint[defer] )*
                    loop104:
                    do {
                        int alt104=2;
                        int LA104_0 = input.LA(1);

                        if ( (LA104_0==24) ) {
                            alt104=1;
                        }


                        switch (alt104) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2871:12: ',' printToken2= whatToPrint[defer]
                    	    {
                    	    char_literal310=(Token)match(input,24,FOLLOW_24_in_printStatement5309); 
                    	    char_literal310_tree = 
                    	    (Object)adaptor.create(char_literal310)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal310_tree);


                    	    pushFollow(FOLLOW_whatToPrint_in_printStatement5313);
                    	    printToken2=whatToPrint(defer);

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, printToken2.getTree());


                    	    if(!defer) {                
                    	        System.out.print((printToken2!=null?printToken2.s:null));
                    	    }	
                    	    	

                    	    }
                    	    break;

                    	default :
                    	    break loop104;
                        }
                    } while (true);


                    char_literal311=(Token)match(input,21,FOLLOW_21_in_printStatement5320); 
                    char_literal311_tree = 
                    (Object)adaptor.create(char_literal311)
                    ;
                    adaptor.addChild(root_0, char_literal311_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2876:11: 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal312=(Token)match(input,100,FOLLOW_100_in_printStatement5332); 
                    string_literal312_tree = 
                    (Object)adaptor.create(string_literal312)
                    ;
                    adaptor.addChild(root_0, string_literal312_tree);


                    char_literal313=(Token)match(input,20,FOLLOW_20_in_printStatement5334); 
                    char_literal313_tree = 
                    (Object)adaptor.create(char_literal313)
                    ;
                    adaptor.addChild(root_0, char_literal313_tree);


                    pushFollow(FOLLOW_whatToPrint_in_printStatement5338);
                    printToken1=whatToPrint(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printToken1.getTree());


                    if(!defer) {        
                        System.out.print((printToken1!=null?printToken1.s:null));
                    }
                            

                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2880:11: ( ',' printToken2= whatToPrint[defer] )*
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==24) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2880:12: ',' printToken2= whatToPrint[defer]
                    	    {
                    	    char_literal314=(Token)match(input,24,FOLLOW_24_in_printStatement5344); 
                    	    char_literal314_tree = 
                    	    (Object)adaptor.create(char_literal314)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal314_tree);


                    	    pushFollow(FOLLOW_whatToPrint_in_printStatement5348);
                    	    printToken2=whatToPrint(defer);

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, printToken2.getTree());


                    	    if(!defer) {                
                    	        System.out.print((printToken2!=null?printToken2.s:null));
                    	    }	
                    	    	

                    	    }
                    	    break;

                    	default :
                    	    break loop105;
                        }
                    } while (true);


                    char_literal315=(Token)match(input,21,FOLLOW_21_in_printStatement5355); 
                    char_literal315_tree = 
                    (Object)adaptor.create(char_literal315)
                    ;
                    adaptor.addChild(root_0, char_literal315_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2891:1: whatToPrint[boolean defer] returns [String s] : (valueToken= expression[defer] |wrapperToken= wrappedStatement[defer] );
    public final EugeneParser.whatToPrint_return whatToPrint(boolean defer) throws RecognitionException {
        EugeneParser.whatToPrint_return retval = new EugeneParser.whatToPrint_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.expression_return valueToken =null;

        EugeneParser.wrappedStatement_return wrapperToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2892:2: (valueToken= expression[defer] |wrapperToken= wrappedStatement[defer] )
            int alt107=2;
            switch ( input.LA(1) ) {
            case FLOAT:
            case INT:
            case STRING:
            case 18:
            case 20:
            case 25:
            case 33:
            case 34:
            case 36:
            case 37:
            case 38:
            case 39:
            case 42:
            case 44:
            case 49:
            case 50:
            case 51:
            case 52:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 74:
            case 75:
            case 76:
            case 78:
            case 86:
            case 109:
                {
                alt107=1;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    switch ( input.LA(3) ) {
                    case 90:
                        {
                        int LA107_5 = input.LA(4);

                        if ( (LA107_5==20) ) {
                            switch ( input.LA(5) ) {
                            case INT:
                                {
                                int LA107_11 = input.LA(6);

                                if ( ((LA107_11 >= 18 && LA107_11 <= 19)||(LA107_11 >= 21 && LA107_11 <= 23)||LA107_11==25||LA107_11==30||(LA107_11 >= 33 && LA107_11 <= 34)||(LA107_11 >= 36 && LA107_11 <= 40)||LA107_11==42||LA107_11==44||(LA107_11 >= 49 && LA107_11 <= 50)||LA107_11==55||(LA107_11 >= 57 && LA107_11 <= 59)||(LA107_11 >= 61 && LA107_11 <= 63)||LA107_11==66||(LA107_11 >= 74 && LA107_11 <= 77)||LA107_11==80||LA107_11==93||LA107_11==113) ) {
                                    alt107=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 107, 11, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case ID:
                                {
                                int LA107_12 = input.LA(6);

                                if ( ((LA107_12 >= 18 && LA107_12 <= 19)||(LA107_12 >= 21 && LA107_12 <= 23)||(LA107_12 >= 25 && LA107_12 <= 26)||LA107_12==30||(LA107_12 >= 33 && LA107_12 <= 34)||(LA107_12 >= 36 && LA107_12 <= 40)||LA107_12==42||LA107_12==44||(LA107_12 >= 49 && LA107_12 <= 50)||LA107_12==55||(LA107_12 >= 57 && LA107_12 <= 59)||(LA107_12 >= 61 && LA107_12 <= 63)||LA107_12==66||(LA107_12 >= 74 && LA107_12 <= 78)||LA107_12==80||LA107_12==93||LA107_12==113) ) {
                                    alt107=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 107, 12, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case STRING:
                                {
                                int LA107_13 = input.LA(6);

                                if ( ((LA107_13 >= 18 && LA107_13 <= 19)||(LA107_13 >= 21 && LA107_13 <= 23)||LA107_13==25||LA107_13==30||(LA107_13 >= 33 && LA107_13 <= 34)||(LA107_13 >= 36 && LA107_13 <= 40)||LA107_13==42||LA107_13==44||(LA107_13 >= 49 && LA107_13 <= 50)||LA107_13==55||(LA107_13 >= 57 && LA107_13 <= 59)||(LA107_13 >= 61 && LA107_13 <= 63)||LA107_13==66||(LA107_13 >= 74 && LA107_13 <= 77)||LA107_13==80||LA107_13==93||LA107_13==113) ) {
                                    alt107=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 107, 13, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case FLOAT:
                            case 18:
                            case 20:
                            case 25:
                            case 33:
                            case 34:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 42:
                            case 44:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 57:
                            case 58:
                            case 59:
                            case 60:
                            case 61:
                            case 62:
                            case 63:
                            case 74:
                            case 75:
                            case 76:
                            case 78:
                            case 86:
                            case 109:
                                {
                                alt107=1;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 107, 8, input);

                                throw nvae;

                            }

                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 107, 5, input);

                            throw nvae;

                        }
                        }
                        break;
                    case 106:
                        {
                        int LA107_6 = input.LA(4);

                        if ( (LA107_6==20) ) {
                            int LA107_9 = input.LA(5);

                            if ( (LA107_9==21) ) {
                                alt107=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 107, 9, input);

                                throw nvae;

                            }
                        }
                        else if ( ((LA107_6 >= 18 && LA107_6 <= 19)||(LA107_6 >= 21 && LA107_6 <= 26)||LA107_6==30||(LA107_6 >= 33 && LA107_6 <= 34)||(LA107_6 >= 36 && LA107_6 <= 40)||LA107_6==42||LA107_6==44||(LA107_6 >= 49 && LA107_6 <= 50)||LA107_6==55||(LA107_6 >= 57 && LA107_6 <= 59)||(LA107_6 >= 61 && LA107_6 <= 63)||LA107_6==66||(LA107_6 >= 74 && LA107_6 <= 78)||LA107_6==80||LA107_6==93||LA107_6==113) ) {
                            alt107=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 107, 6, input);

                            throw nvae;

                        }
                        }
                        break;
                    case 82:
                    case 96:
                    case 102:
                        {
                        alt107=2;
                        }
                        break;
                    case 108:
                        {
                        int LA107_7 = input.LA(4);

                        if ( (LA107_7==20) ) {
                            int LA107_10 = input.LA(5);

                            if ( (LA107_10==21) ) {
                                alt107=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 107, 10, input);

                                throw nvae;

                            }
                        }
                        else if ( ((LA107_7 >= 18 && LA107_7 <= 19)||(LA107_7 >= 21 && LA107_7 <= 26)||LA107_7==30||(LA107_7 >= 33 && LA107_7 <= 34)||(LA107_7 >= 36 && LA107_7 <= 40)||LA107_7==42||LA107_7==44||(LA107_7 >= 49 && LA107_7 <= 50)||LA107_7==55||(LA107_7 >= 57 && LA107_7 <= 59)||(LA107_7 >= 61 && LA107_7 <= 63)||LA107_7==66||(LA107_7 >= 74 && LA107_7 <= 78)||LA107_7==80||LA107_7==93||LA107_7==113) ) {
                            alt107=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 107, 7, input);

                            throw nvae;

                        }
                        }
                        break;
                    case ID:
                    case 94:
                    case 95:
                    case 105:
                        {
                        alt107=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 107, 4, input);

                        throw nvae;

                    }

                    }
                    break;
                case 18:
                case 19:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 30:
                case 33:
                case 34:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 42:
                case 44:
                case 49:
                case 50:
                case 55:
                case 57:
                case 58:
                case 59:
                case 61:
                case 62:
                case 63:
                case 66:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 80:
                case 93:
                case 113:
                    {
                    alt107=1;
                    }
                    break;
                case 27:
                case 28:
                case 29:
                    {
                    alt107=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 107, 2, input);

                    throw nvae;

                }

                }
                break;
            case 53:
            case 73:
            case 98:
            case 101:
                {
                alt107=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;

            }

            switch (alt107) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2892:4: valueToken= expression[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_expression_in_whatToPrint5376);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2901:4: wrapperToken= wrappedStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_wrappedStatement_in_whatToPrint5386);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2913:1: dataExtraction[boolean defer] : ( sbolStatement[defer] | genbankStatement[defer] );
    public final EugeneParser.dataExtraction_return dataExtraction(boolean defer) throws RecognitionException {
        EugeneParser.dataExtraction_return retval = new EugeneParser.dataExtraction_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.sbolStatement_return sbolStatement316 =null;

        EugeneParser.genbankStatement_return genbankStatement317 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2914:2: ( sbolStatement[defer] | genbankStatement[defer] )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==73) ) {
                alt108=1;
            }
            else if ( (LA108_0==53) ) {
                alt108=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;

            }
            switch (alt108) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2914:4: sbolStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_sbolStatement_in_dataExtraction5405);
                    sbolStatement316=sbolStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolStatement316.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2915:4: genbankStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_genbankStatement_in_dataExtraction5411);
                    genbankStatement317=genbankStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankStatement317.getTree());

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2919:1: sbolStatement[boolean defer] returns [NamedElement objElement] : 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] ) ;
    public final EugeneParser.sbolStatement_return sbolStatement(boolean defer) throws RecognitionException {
        EugeneParser.sbolStatement_return retval = new EugeneParser.sbolStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal318=null;
        Token char_literal319=null;
        EugeneParser.sbolImportStatement_return importToken =null;

        EugeneParser.sbolExportStatement_return sbolExportStatement320 =null;


        Object string_literal318_tree=null;
        Object char_literal319_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2920:2: ( 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2920:4: 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] )
            {
            root_0 = (Object)adaptor.nil();


            string_literal318=(Token)match(input,73,FOLLOW_73_in_sbolStatement5431); 
            string_literal318_tree = 
            (Object)adaptor.create(string_literal318)
            ;
            adaptor.addChild(root_0, string_literal318_tree);


            char_literal319=(Token)match(input,26,FOLLOW_26_in_sbolStatement5433); 
            char_literal319_tree = 
            (Object)adaptor.create(char_literal319)
            ;
            adaptor.addChild(root_0, char_literal319_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2920:15: ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==85) ) {
                alt109=1;
            }
            else if ( (LA109_0==92) ) {
                alt109=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }
            switch (alt109) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2920:16: sbolExportStatement[defer]
                    {
                    pushFollow(FOLLOW_sbolExportStatement_in_sbolStatement5436);
                    sbolExportStatement320=sbolExportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolExportStatement320.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2920:45: importToken= sbolImportStatement[defer]
                    {
                    pushFollow(FOLLOW_sbolImportStatement_in_sbolStatement5443);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2927:1: sbolExportStatement[boolean defer] : 'export' '(' idToken= ID ',' filenameToken= STRING ')' ;
    public final EugeneParser.sbolExportStatement_return sbolExportStatement(boolean defer) throws RecognitionException {
        EugeneParser.sbolExportStatement_return retval = new EugeneParser.sbolExportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token filenameToken=null;
        Token string_literal321=null;
        Token char_literal322=null;
        Token char_literal323=null;
        Token char_literal324=null;

        Object idToken_tree=null;
        Object filenameToken_tree=null;
        Object string_literal321_tree=null;
        Object char_literal322_tree=null;
        Object char_literal323_tree=null;
        Object char_literal324_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2928:2: ( 'export' '(' idToken= ID ',' filenameToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2928:4: 'export' '(' idToken= ID ',' filenameToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal321=(Token)match(input,85,FOLLOW_85_in_sbolExportStatement5460); 
            string_literal321_tree = 
            (Object)adaptor.create(string_literal321)
            ;
            adaptor.addChild(root_0, string_literal321_tree);


            char_literal322=(Token)match(input,20,FOLLOW_20_in_sbolExportStatement5462); 
            char_literal322_tree = 
            (Object)adaptor.create(char_literal322)
            ;
            adaptor.addChild(root_0, char_literal322_tree);


            idToken=(Token)match(input,ID,FOLLOW_ID_in_sbolExportStatement5466); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal323=(Token)match(input,24,FOLLOW_24_in_sbolExportStatement5468); 
            char_literal323_tree = 
            (Object)adaptor.create(char_literal323)
            ;
            adaptor.addChild(root_0, char_literal323_tree);


            filenameToken=(Token)match(input,STRING,FOLLOW_STRING_in_sbolExportStatement5472); 
            filenameToken_tree = 
            (Object)adaptor.create(filenameToken)
            ;
            adaptor.addChild(root_0, filenameToken_tree);


            char_literal324=(Token)match(input,21,FOLLOW_21_in_sbolExportStatement5474); 
            char_literal324_tree = 
            (Object)adaptor.create(char_literal324)
            ;
            adaptor.addChild(root_0, char_literal324_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2942:1: sbolImportStatement[boolean defer] returns [NamedElement objElement] : 'import' '(' fileToken= STRING ')' ;
    public final EugeneParser.sbolImportStatement_return sbolImportStatement(boolean defer) throws RecognitionException {
        EugeneParser.sbolImportStatement_return retval = new EugeneParser.sbolImportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token fileToken=null;
        Token string_literal325=null;
        Token char_literal326=null;
        Token char_literal327=null;

        Object fileToken_tree=null;
        Object string_literal325_tree=null;
        Object char_literal326_tree=null;
        Object char_literal327_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2944:2: ( 'import' '(' fileToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2944:4: 'import' '(' fileToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal325=(Token)match(input,92,FOLLOW_92_in_sbolImportStatement5503); 
            string_literal325_tree = 
            (Object)adaptor.create(string_literal325)
            ;
            adaptor.addChild(root_0, string_literal325_tree);


            char_literal326=(Token)match(input,20,FOLLOW_20_in_sbolImportStatement5505); 
            char_literal326_tree = 
            (Object)adaptor.create(char_literal326)
            ;
            adaptor.addChild(root_0, char_literal326_tree);


            fileToken=(Token)match(input,STRING,FOLLOW_STRING_in_sbolImportStatement5509); 
            fileToken_tree = 
            (Object)adaptor.create(fileToken)
            ;
            adaptor.addChild(root_0, fileToken_tree);


            char_literal327=(Token)match(input,21,FOLLOW_21_in_sbolImportStatement5511); 
            char_literal327_tree = 
            (Object)adaptor.create(char_literal327)
            ;
            adaptor.addChild(root_0, char_literal327_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2956:1: genbankStatement[boolean defer] returns [NamedElement objElement] : 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] ) ;
    public final EugeneParser.genbankStatement_return genbankStatement(boolean defer) throws RecognitionException {
        EugeneParser.genbankStatement_return retval = new EugeneParser.genbankStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal328=null;
        Token char_literal329=null;
        EugeneParser.genbankImportStatement_return importToken =null;

        EugeneParser.genbankExportStatement_return genbankExportStatement330 =null;


        Object string_literal328_tree=null;
        Object char_literal329_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2957:2: ( 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2957:4: 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] )
            {
            root_0 = (Object)adaptor.nil();


            string_literal328=(Token)match(input,53,FOLLOW_53_in_genbankStatement5537); 
            string_literal328_tree = 
            (Object)adaptor.create(string_literal328)
            ;
            adaptor.addChild(root_0, string_literal328_tree);


            char_literal329=(Token)match(input,26,FOLLOW_26_in_genbankStatement5539); 
            char_literal329_tree = 
            (Object)adaptor.create(char_literal329)
            ;
            adaptor.addChild(root_0, char_literal329_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2957:18: (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] )
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==92) ) {
                alt110=1;
            }
            else if ( (LA110_0==85) ) {
                alt110=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;

            }
            switch (alt110) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2957:19: importToken= genbankImportStatement[defer]
                    {
                    pushFollow(FOLLOW_genbankImportStatement_in_genbankStatement5544);
                    importToken=genbankImportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, importToken.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2957:63: genbankExportStatement[defer]
                    {
                    pushFollow(FOLLOW_genbankExportStatement_in_genbankStatement5549);
                    genbankExportStatement330=genbankExportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankExportStatement330.getTree());

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2964:1: genbankExportStatement[boolean defer] returns [NamedElement objElement] : 'export' '(' ')' ;
    public final EugeneParser.genbankExportStatement_return genbankExportStatement(boolean defer) throws RecognitionException {
        EugeneParser.genbankExportStatement_return retval = new EugeneParser.genbankExportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal331=null;
        Token char_literal332=null;
        Token char_literal333=null;

        Object string_literal331_tree=null;
        Object char_literal332_tree=null;
        Object char_literal333_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2965:2: ( 'export' '(' ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2965:4: 'export' '(' ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal331=(Token)match(input,85,FOLLOW_85_in_genbankExportStatement5572); 
            string_literal331_tree = 
            (Object)adaptor.create(string_literal331)
            ;
            adaptor.addChild(root_0, string_literal331_tree);


            char_literal332=(Token)match(input,20,FOLLOW_20_in_genbankExportStatement5574); 
            char_literal332_tree = 
            (Object)adaptor.create(char_literal332)
            ;
            adaptor.addChild(root_0, char_literal332_tree);


            char_literal333=(Token)match(input,21,FOLLOW_21_in_genbankExportStatement5576); 
            char_literal333_tree = 
            (Object)adaptor.create(char_literal333)
            ;
            adaptor.addChild(root_0, char_literal333_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2968:1: genbankImportStatement[boolean defer] returns [NamedElement objElement] : 'import' '(' typeToken= ID ',' partToken= STRING ')' ;
    public final EugeneParser.genbankImportStatement_return genbankImportStatement(boolean defer) throws RecognitionException {
        EugeneParser.genbankImportStatement_return retval = new EugeneParser.genbankImportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token typeToken=null;
        Token partToken=null;
        Token string_literal334=null;
        Token char_literal335=null;
        Token char_literal336=null;
        Token char_literal337=null;

        Object typeToken_tree=null;
        Object partToken_tree=null;
        Object string_literal334_tree=null;
        Object char_literal335_tree=null;
        Object char_literal336_tree=null;
        Object char_literal337_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2969:2: ( 'import' '(' typeToken= ID ',' partToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2969:4: 'import' '(' typeToken= ID ',' partToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal334=(Token)match(input,92,FOLLOW_92_in_genbankImportStatement5593); 
            string_literal334_tree = 
            (Object)adaptor.create(string_literal334)
            ;
            adaptor.addChild(root_0, string_literal334_tree);


            char_literal335=(Token)match(input,20,FOLLOW_20_in_genbankImportStatement5595); 
            char_literal335_tree = 
            (Object)adaptor.create(char_literal335)
            ;
            adaptor.addChild(root_0, char_literal335_tree);


            typeToken=(Token)match(input,ID,FOLLOW_ID_in_genbankImportStatement5599); 
            typeToken_tree = 
            (Object)adaptor.create(typeToken)
            ;
            adaptor.addChild(root_0, typeToken_tree);


            char_literal336=(Token)match(input,24,FOLLOW_24_in_genbankImportStatement5601); 
            char_literal336_tree = 
            (Object)adaptor.create(char_literal336)
            ;
            adaptor.addChild(root_0, char_literal336_tree);


            partToken=(Token)match(input,STRING,FOLLOW_STRING_in_genbankImportStatement5605); 
            partToken_tree = 
            (Object)adaptor.create(partToken)
            ;
            adaptor.addChild(root_0, partToken_tree);


            char_literal337=(Token)match(input,21,FOLLOW_21_in_genbankImportStatement5607); 
            char_literal337_tree = 
            (Object)adaptor.create(char_literal337)
            ;
            adaptor.addChild(root_0, char_literal337_tree);



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
            e.printStackTrace();
            this.cleanUp(1);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "genbankImportStatement"

    // Delegated rules


 

    public static final BitSet FOLLOW_eugeneStatement_in_prog56 = new BitSet(new long[]{0x0121A20100001800L,0x0000C1BE1B0A0371L});
    public static final BitSet FOLLOW_EOF_in_prog59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_eugeneStatement70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_eugeneStatement78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_statement117 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importStatement_in_statement124 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarationStatement_in_statement134 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computationalStatement_in_statement144 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_printStatement_in_statement152 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertStatement_in_statement166 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_noteStatement_in_statement176 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wrappedStatement_in_statement186 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loopStatement_in_statement200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statement208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saveStatement_in_statement216 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_computationalStatement232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_computationalStatement240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataExtraction_in_computationalStatement248 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_computationalStatement251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectAssignmentStatement_in_computationalStatement258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_assignment283 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_assignment287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_assignment296 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_functionCall_in_assignment300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_assignment315 = new BitSet(new long[]{0x0020000000000800L,0x0000002400000200L});
    public static final BitSet FOLLOW_wrappedStatement_in_assignment319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_assignment334 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_assignment336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_assignment350 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_assignment352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_importStatement370 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_importStatement374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filename_in_listOfFilenames399 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfFilenames403 = new BitSet(new long[]{0xFFFFFFFEFFEFFFF0L,0x0007FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_listOfFilenames_in_listOfFilenames405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_filename427 = new BitSet(new long[]{0xFFFFFFFEFEEFFFF2L,0x0007FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_collectionDeclaration_in_declarationStatement461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_declarationStatement467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_declarationStatement473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_declarationStatement479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_declarationStatement485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayDeclaration_in_declarationStatement491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_declarationStatement497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_imageDeclaration_in_declarationStatement503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceTypeDeclaration_in_declarationStatement509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationDeclaration_in_declarationStatement516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_collectionDeclaration545 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_collectionDeclaration549 = new BitSet(new long[]{0x0000000802900002L});
    public static final BitSet FOLLOW_collectionDefinition_in_collectionDeclaration559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_collectionDeclaration572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_collectionDefinition620 = new BitSet(new long[]{0x0000800000000800L,0x0000000000000070L});
    public static final BitSet FOLLOW_listOfCollectionComponents_in_collectionDefinition627 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_collectionDefinition633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_collectionDefinition640 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_INCLUDE_in_collectionDefinition644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionElement_in_listOfCollectionComponents690 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfCollectionComponents696 = new BitSet(new long[]{0x0000800000000800L,0x0000000000000070L});
    public static final BitSet FOLLOW_listOfCollectionComponents_in_listOfCollectionComponents700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_collectionElement738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_collectionElement746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_collectionElement763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_collectionElement773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_collectionElement790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_propertyDeclaration813 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_dynamicNaming_in_propertyDeclaration817 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_propertyDeclaration820 = new BitSet(new long[]{0x0000000000000000L,0x0000400200020000L});
    public static final BitSet FOLLOW_propertyType_in_propertyDeclaration824 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_propertyDeclaration826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_propertyType845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_propertyType850 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_propertyType852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_propertyType854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_propertyType859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_propertyType864 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_propertyType866 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_propertyType868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_propertyType873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyType_in_variableDeclaration897 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfVariables_in_variableDeclaration901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfVariables929 = new BitSet(new long[]{0x0000000803800002L});
    public static final BitSet FOLLOW_assignment_in_listOfVariables941 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfVariables950 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfVariables_in_listOfVariables954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_partTypeDeclaration987 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_partTypeDeclaration996 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_partTypeDeclaration999 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_listOfIDs_in_partTypeDeclaration1004 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_partTypeDeclaration1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_partTypeDeclaration1025 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_partTypeDeclaration1033 = new BitSet(new long[]{0x0000000802800000L});
    public static final BitSet FOLLOW_assignment_in_partTypeDeclaration1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfIDs1071 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfIDs1077 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_listOfIDs1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_deviceDeclaration1112 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_deviceDeclaration1116 = new BitSet(new long[]{0x0000000802900002L});
    public static final BitSet FOLLOW_20_in_deviceDeclaration1122 = new BitSet(new long[]{0x0000800002B0AA00L,0x0000200000404070L});
    public static final BitSet FOLLOW_deviceComponents_in_deviceDeclaration1127 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceDeclaration1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_deviceDeclaration1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_deviceComponents1196 = new BitSet(new long[]{0x000080000210AA00L,0x0000200000404070L});
    public static final BitSet FOLLOW_expressionValue_in_deviceComponents1210 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_deviceComponents1221 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_deviceComponents1231 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_deviceComponents1241 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_deviceComponents1251 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_deviceComponents1261 = new BitSet(new long[]{0x000080000290AA00L,0x0000200000404070L});
    public static final BitSet FOLLOW_deviceComponents_in_deviceComponents1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_deviceTypeDeclaration1291 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_deviceTypeDeclaration1295 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceTypeDeclaration1297 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_deviceTypeDeclaration1301 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceTypeDeclaration1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayType_in_arrayDeclaration1339 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_arrayDeclaration1343 = new BitSet(new long[]{0x0000000802800002L});
    public static final BitSet FOLLOW_assignment_in_arrayDeclaration1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_arrayType1372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_arrayType1374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_arrayType1381 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_arrayType1383 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_arrayType1390 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_arrayType1392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_arrayType1399 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_arrayType1401 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_arrayType1408 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_arrayType1410 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayType1417 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_arrayType1419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleDeclaration1437 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_ruleDeclaration1441 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleDeclaration1443 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C02L});
    public static final BitSet FOLLOW_65_in_ruleDeclaration1450 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_ruleDeclaration1454 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleDeclaration1456 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_ruleDeclaration1467 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclaration1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_folExpression1521 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_folExpression1526 = new BitSet(new long[]{0x0008000080000000L});
    public static final BitSet FOLLOW_51_in_folExpression1531 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_folExpression1536 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_folExpression1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_folExpression1548 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_folExpression1553 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_folExpression1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_onDeviceRule1598 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_onDeviceRule1602 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_onDeviceRule1604 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_onDeviceRule1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_imageDeclaration1633 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_imageDeclaration1635 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_imageDeclaration1639 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_imageDeclaration1641 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_imageDeclaration1645 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_imageDeclaration1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_relationDeclaration1665 = new BitSet(new long[]{0x0040480000000000L,0x0000000000000088L});
    public static final BitSet FOLLOW_relationtype_in_relationDeclaration1669 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_relationDeclaration1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_assertStatement1733 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_assertStatement1735 = new BitSet(new long[]{0x0000000000200800L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_assertStatement1738 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_assertStatement1742 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_assertStatement1745 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_listOfIDs_in_assertStatement1751 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assertStatement1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_noteStatement1788 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_noteStatement1790 = new BitSet(new long[]{0x0000000000200800L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_noteStatement1793 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_noteStatement1797 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_noteStatement1800 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_listOfIDs_in_noteStatement1806 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_noteStatement1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_instantiationStatement1849 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_instanceDefinitionStatement_in_instantiationStatement1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partInstantiation_in_instanceDefinitionStatement1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceInstantiation_in_instanceDefinitionStatement1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_dynamicNaming1922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DYNAMIC_NAME_in_dynamicNaming1929 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_dynamicNaming1933 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_DYNAMIC_NAME_in_dynamicNaming1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dynamicNaming_in_partInstantiation1966 = new BitSet(new long[]{0x0000000802900002L});
    public static final BitSet FOLLOW_20_in_partInstantiation1971 = new BitSet(new long[]{0xFE1E14F60634AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_listOfDotValues_in_partInstantiation1976 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_listOfValues_in_partInstantiation1983 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_partInstantiation1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_partInstantiation2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_deviceInstantiation2033 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_deviceInstantiation2036 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_listOfIDs_in_deviceInstantiation2041 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceInstantiation2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_listOfDotValues2084 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfDotValues2088 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_listOfDotValues2090 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_listOfDotValues2094 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_listOfDotValues2097 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfDotValues2103 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_listOfDotValues_in_listOfDotValues2107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfValues2148 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfValues2154 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_listOfValues_in_listOfValues2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfExpressions2190 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfExpressions2197 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_listOfExpressions_in_listOfExpressions2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notExpression_in_expression2235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_notExpression2272 = new BitSet(new long[]{0xEE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_orExpression_in_notExpression2276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpression_in_notExpression2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpression_in_orExpression2330 = new BitSet(new long[]{0x0000000000000002L,0x0002000000000004L});
    public static final BitSet FOLLOW_66_in_orExpression2346 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_113_in_orExpression2348 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_notExpression_in_orExpression2353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xorExpression_in_andExpression2402 = new BitSet(new long[]{0x0000010000080002L});
    public static final BitSet FOLLOW_40_in_andExpression2418 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_19_in_andExpression2420 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_notExpression_in_andExpression2425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparativeExpression_in_xorExpression2475 = new BitSet(new long[]{0x0000000000000002L,0x0000000000012000L});
    public static final BitSet FOLLOW_77_in_xorExpression2491 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_80_in_xorExpression2493 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_notExpression_in_xorExpression2498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalOperator_in_operator2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_operator2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOperator2573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOperator2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleOperator2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOperator2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleOperator2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleOperator2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleOperator2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleOperator2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOperator2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleOperator2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleOperator2643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleOperator2650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relationalOperator2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relationalOperator2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_relationalOperator2693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_relationalOperator2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_relationalOperator2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_relationalOperator2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_folExpression_in_comparativeExpression2743 = new BitSet(new long[]{0xEE0614F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_addExpression_in_comparativeExpression2768 = new BitSet(new long[]{0xEE8614F600040002L,0x0000000020001C00L});
    public static final BitSet FOLLOW_operator_in_comparativeExpression2788 = new BitSet(new long[]{0xEE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_comparativeExpression_in_comparativeExpression2792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_comparativeExpression2815 = new BitSet(new long[]{0x0000A00000000800L,0x0000400200020050L});
    public static final BitSet FOLLOW_93_in_comparativeExpression2817 = new BitSet(new long[]{0x0000A00000000800L,0x0000400200020050L});
    public static final BitSet FOLLOW_type_in_comparativeExpression2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_in_comparativeExpression2846 = new BitSet(new long[]{0x000000000210AA00L,0x0000200000404000L});
    public static final BitSet FOLLOW_addExpression_in_comparativeExpression2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subtractExpression_in_addExpression2899 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_addExpression2915 = new BitSet(new long[]{0xEE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_comparativeExpression_in_addExpression2919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_subtractExpression2965 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_subtractExpression2980 = new BitSet(new long[]{0xEE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_comparativeExpression_in_subtractExpression2984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionValue_in_multiplicativeExpression3033 = new BitSet(new long[]{0x0000000040400002L});
    public static final BitSet FOLLOW_22_in_multiplicativeExpression3053 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_30_in_multiplicativeExpression3055 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_multiplicativeExpression3060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_expressionValue3115 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_set_in_expressionValue3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_expressionValue3135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expressionValue3145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectAccessStatement_in_expressionValue3169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_expressionValue3183 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_expressionValue3187 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_expressionValue3190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_expressionValue3214 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_listOfExpressions_in_expressionValue3218 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_expressionValue3221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_objectAccessStatement3259 = new BitSet(new long[]{0x0000000004000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_objectAccess_in_objectAccessStatement3274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayAccess_in_objectAccess3308 = new BitSet(new long[]{0x0000000004000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_access_in_objectAccess3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotAccess_in_objectAccess3348 = new BitSet(new long[]{0x0000000004000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_access_in_objectAccess3366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectAccess_in_access3398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_arrayAccess3421 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_arrayAccess3425 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayAccess3428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3466 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_dotAccess3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3490 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_dotAccess3495 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_dotAccess3498 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3520 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_dotAccess3524 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_dotAccess3526 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_dotAccess3530 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3553 = new BitSet(new long[]{0x0000000000000000L,0x0000120000000000L});
    public static final BitSet FOLLOW_105_in_dotAccess3558 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_108_in_dotAccess3560 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_dotAccess3564 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3587 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_dotAccess3591 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_dotAccess3594 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3616 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_dotAccess3618 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_dotAccess3620 = new BitSet(new long[]{0xFE1E14F60234AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_dotAccess3625 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_objectAssignmentStatement3700 = new BitSet(new long[]{0x0000000806800000L,0x0000000000004000L});
    public static final BitSet FOLLOW_26_in_objectAssignmentStatement3710 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_objectAssignmentStatement3714 = new BitSet(new long[]{0x0000000806800000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_objectAssignmentStatement3722 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_objectAssignmentStatement3728 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_objectAssignmentStatement3731 = new BitSet(new long[]{0x0000000806800000L,0x0000000000004000L});
    public static final BitSet FOLLOW_assignment_in_objectAssignmentStatement3740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_listOfStatements3774 = new BitSet(new long[]{0x0121A20100001802L,0x0000C1BE190A0371L});
    public static final BitSet FOLLOW_103_in_returnStatement3804 = new BitSet(new long[]{0xFE3E14F70214AA00L,0x0000202400405E00L});
    public static final BitSet FOLLOW_expression_in_returnStatement3813 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_functionCall_in_returnStatement3822 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_wrappedStatement_in_returnStatement3831 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_returnStatement3839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_saveStatement3856 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_saveStatement3858 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_listOfSaveObjects_in_saveStatement3860 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_saveStatement3863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfSaveObjects3879 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_listOfSaveObjects3881 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_listOfSaveObjects3887 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfSaveObjects3893 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_listOfSaveObjects_in_listOfSaveObjects3895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ifStatement3935 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ifStatement3937 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C02L});
    public static final BitSet FOLLOW_ifCondition_in_ifStatement3941 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifStatement3944 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_ifStatement3946 = new BitSet(new long[]{0x0121A20100001800L,0x0000C1BE190A0371L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement3950 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_ifStatement3953 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ifStatement3974 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_ifStatement3976 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ifStatement3978 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C02L});
    public static final BitSet FOLLOW_ifCondition_in_ifStatement3982 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifStatement3985 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_ifStatement3987 = new BitSet(new long[]{0x0121A20100001800L,0x0000C1BE190A0371L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement3991 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_ifStatement3994 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_ifStatement4003 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_ifStatement4005 = new BitSet(new long[]{0x0121A20100001800L,0x0000C1BE190A0371L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement4009 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_ifStatement4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ifCondition4043 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_ifCondition4047 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ifCondition4049 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_ifCondition4055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_loopStatement4095 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_loopStatement4097 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000600200425C00L});
    public static final BitSet FOLLOW_forInit_in_loopStatement4101 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_loopStatement4104 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_loopStatement4115 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_loopStatement4118 = new BitSet(new long[]{0x0020000000000800L,0x0000000000000200L});
    public static final BitSet FOLLOW_computationalStatement_in_loopStatement4129 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement4132 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_loopStatement4134 = new BitSet(new long[]{0x0121A20100001800L,0x0000C1BE190A0371L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement4146 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_loopStatement4149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_loopStatement4156 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_loopStatement4158 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_loopStatement4162 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement4165 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_loopStatement4167 = new BitSet(new long[]{0x0121A20100001800L,0x0000C1BE190A0371L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement4171 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_loopStatement4174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_loopStatement4181 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_loopStatement4183 = new BitSet(new long[]{0x0121A20100001800L,0x0000C1BE190A0371L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement4187 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_loopStatement4190 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_loopStatement4192 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_loopStatement4194 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_loopStatement4198 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement4201 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_loopStatement4202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_forInit4230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listOfExpressions_in_forInit4240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_functionDeclaration4265 = new BitSet(new long[]{0x0000A00000000800L,0x0000400200020050L});
    public static final BitSet FOLLOW_type_in_functionDeclaration4270 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_functionDeclaration4276 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_functionDeclaration4280 = new BitSet(new long[]{0x0000A00000200800L,0x0000400200020050L});
    public static final BitSet FOLLOW_listOfFunctionParamenters_in_functionDeclaration4285 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionDeclaration4289 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_functionDeclaration4291 = new BitSet(new long[]{0x0121A20100001800L,0x0000C1BE190A0371L});
    public static final BitSet FOLLOW_listOfStatements_in_functionDeclaration4299 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_functionDeclaration4304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_type4327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_type4334 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_type4336 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_type4345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_type4352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_type4354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_type4363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_type4372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_type4374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_type4385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_type4392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_type4394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_type4403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_type4410 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_type4412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_type4421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_type4428 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_type4430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_type4439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_type4446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_listOfFunctionParamenters4470 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfFunctionParamenters4474 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfFunctionParamenters4479 = new BitSet(new long[]{0x0000A00000000800L,0x0000400200020050L});
    public static final BitSet FOLLOW_listOfFunctionParamenters_in_listOfFunctionParamenters4483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_functionCall4514 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_functionCall4516 = new BitSet(new long[]{0xFE1E14F60234AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_listOfParameterValues_in_functionCall4521 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionCall4526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfParameterValues4558 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfParameterValues4565 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_listOfParameterValues_in_listOfParameterValues4569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_in_wrappedStatement4594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_combinatorialFunction_in_wrappedStatement4609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_get_in_wrappedStatement4619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_size_in_wrappedStatement4629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remove_in_wrappedStatement4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_toSequence_in_wrappedStatement4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolStatement_in_wrappedStatement4658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankStatement_in_wrappedStatement4668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDepthStatements_in_wrappedStatement4684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_deviceDepthStatements4715 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_deviceDepthStatements4717 = new BitSet(new long[]{0x0000000000000000L,0x0000000100040000L});
    public static final BitSet FOLLOW_82_in_deviceDepthStatements4724 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceDepthStatements4726 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_deviceDepthStatements4730 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceDepthStatements4733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_deviceDepthStatements4741 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceDepthStatements4743 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceDepthStatements4745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_add4769 = new BitSet(new long[]{0x0000000038000000L});
    public static final BitSet FOLLOW_27_in_add4776 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_add4778 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_listOfExpressions_in_add4782 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_add4785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_add4793 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_add4795 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_add4799 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_add4801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_add4808 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_add4810 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_add4814 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_add4817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_toSequence4848 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_toSequence4850 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_toSequence4852 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_toSequence4854 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_toSequence4856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_get4876 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_get4878 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_get4880 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_get4882 = new BitSet(new long[]{0x000000000000A800L});
    public static final BitSet FOLLOW_INT_in_get4887 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_get4895 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_STRING_in_get4903 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_get4908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_size4941 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_size4943 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_size4945 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_size4947 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_size4949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_remove4979 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_remove4981 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_remove4983 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_remove4985 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_remove4989 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_remove4992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfRules5038 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfRules5043 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfRules5047 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_set_in_combinatorialFunction5080 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_combinatorialFunction5086 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_combinatorialFunction5098 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_combinatorialFunction5124 = new BitSet(new long[]{0x0000000000000000L,0x0000080000800000L});
    public static final BitSet FOLLOW_set_in_combinatorialFunction5128 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_combinatorialFunction5153 = new BitSet(new long[]{0xFE1E14F60334AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_combinatorialFunction5158 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_combinatorialFunction5175 = new BitSet(new long[]{0xFE1E14F60234AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_combinatorialFunction5180 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_combinatorialFunction5187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_getObject5219 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_getObject5223 = new BitSet(new long[]{0x0000000004000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_getObject5229 = new BitSet(new long[]{0xFE1E14F60214AA00L,0x0000200000405C00L});
    public static final BitSet FOLLOW_expression_in_getObject5233 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_getObject5236 = new BitSet(new long[]{0x0000000004000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_100_in_printStatement5279 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_printStatement5281 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_printStatement5283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_printStatement5297 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_printStatement5299 = new BitSet(new long[]{0xFE3E14F60214AA00L,0x0000202400405E00L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5303 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_printStatement5309 = new BitSet(new long[]{0xFE3E14F60214AA00L,0x0000202400405E00L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5313 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_21_in_printStatement5320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_printStatement5332 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_printStatement5334 = new BitSet(new long[]{0xFE3E14F60214AA00L,0x0000202400405E00L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5338 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_printStatement5344 = new BitSet(new long[]{0xFE3E14F60214AA00L,0x0000202400405E00L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5348 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_21_in_printStatement5355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_whatToPrint5376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wrappedStatement_in_whatToPrint5386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolStatement_in_dataExtraction5405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankStatement_in_dataExtraction5411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_sbolStatement5431 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sbolStatement5433 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
    public static final BitSet FOLLOW_sbolExportStatement_in_sbolStatement5436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolImportStatement_in_sbolStatement5443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_sbolExportStatement5460 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_sbolExportStatement5462 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_sbolExportStatement5466 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_sbolExportStatement5468 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_sbolExportStatement5472 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_sbolExportStatement5474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_sbolImportStatement5503 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_sbolImportStatement5505 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_sbolImportStatement5509 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_sbolImportStatement5511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_genbankStatement5537 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_genbankStatement5539 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
    public static final BitSet FOLLOW_genbankImportStatement_in_genbankStatement5544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankExportStatement_in_genbankStatement5549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_genbankExportStatement5572 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_genbankExportStatement5574 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_genbankExportStatement5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_genbankImportStatement5593 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_genbankImportStatement5595 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_genbankImportStatement5599 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_genbankImportStatement5601 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_genbankImportStatement5605 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_genbankImportStatement5607 = new BitSet(new long[]{0x0000000000000002L});

}