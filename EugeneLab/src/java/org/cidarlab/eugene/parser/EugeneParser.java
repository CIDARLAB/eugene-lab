// $ANTLR 3.4 /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g 2013-10-23 13:35:06

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

package org.cidarlab.eugene.parser;

import org.cidarlab.eugene.constants.EugeneConstants;
import org.cidarlab.eugene.dom.*;
import org.cidarlab.eugene.dom.functions.*;
import org.cidarlab.eugene.dom.loops.*;
import org.cidarlab.eugene.dom.branches.*;
import org.cidarlab.eugene.dom.rules.*;
import org.cidarlab.eugene.dom.arrays.*;
import org.cidarlab.eugene.dom.characterization.*;
import org.cidarlab.eugene.dom.collection.*;
import org.cidarlab.eugene.dom.components.*;
import org.cidarlab.eugene.dom.components.types.*;
import org.cidarlab.eugene.factory.DeviceFactory;
//import org.cidarlab.eugene.rules.*;
import org.cidarlab.eugene.rules.RuleEngine;
import org.cidarlab.eugene.exception.*; 
import org.cidarlab.eugene.util.*;
import org.cidarlab.eugene.output.ResultSet;
import org.cidarlab.eugene.data.registry.*;
import org.cidarlab.eugene.interpreter.*;
import org.cidarlab.eugene.cache.*;
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
import org.cidarlab.eugene.data.sbol.*;
import org.cidarlab.eugene.data.sbol.mapping.*;

// for Genbank import
import org.cidarlab.eugene.data.genbank.*;

// Pigeon
import org.cidarlab.eugene.data.pigeon.Pigeon;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class EugeneParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "COMMENT", "DYNAMIC_NAME", "ESC_SEQ", "EXPONENT", "FLOAT", "HEX_DIGIT", "ID", "INCLUDE", "INT", "OCTAL_ESC", "STRING", "UNICODE_ESC", "WS", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'.add'", "'.addProperties'", "'.addProperty'", "'/'", "':'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'AFTER'", "'AND'", "'Assert'", "'BEFORE'", "'BINDS'", "'CONTAINS'", "'Collection'", "'DRIVES'", "'Device'", "'DeviceType'", "'ENDSWITH'", "'EQUALS'", "'EXACTLY'", "'EXISTS'", "'FORALL'", "'Genbank'", "'INDUCES'", "'INSTANCEOF'", "'Image'", "'LEFTTO'", "'MATCHES'", "'MORETHAN'", "'NEXTTO'", "'NOT'", "'NOTEQUALS'", "'NOTMORETHAN'", "'NOTWITH'", "'Note'", "'ON'", "'OR'", "'ORTHO'", "'Part'", "'PartType'", "'Property'", "'REPRESSES'", "'Registry'", "'Rule'", "'SBOL'", "'STARTSWITH'", "'THEN'", "'WITH'", "'XOR'", "'['", "']'", "'^^'", "'boolean'", "'depth'", "'do'", "'else'", "'export'", "'false'", "'flexible'", "'for'", "'function'", "'get'", "'if'", "'import'", "'instanceof'", "'instantiate'", "'isEmpty'", "'maxDepth'", "'num'", "'permute'", "'pigeon'", "'print'", "'println'", "'product'", "'remove'", "'return'", "'save'", "'size'", "'strict'", "'toSequence'", "'true'", "'txt'", "'while'", "'{'", "'||'", "'}'"
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
    public static final int T__115=115;
    public static final int T__116=116;
    public static final int T__117=117;
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
    private SBOLRegistryImporter registryImporter = null;
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
            //return e.getReturnValue();
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
     
            objFunction.clear();
        }
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

            if(this.evaluateCondition(ifBranch)) {
                this.executeBranch(ifBranch);                
            } else {
                // evaluate the else-if conditions and execute the corresponding statements
                ArrayList<ConditionalBranch> lstElseIfBranches = objIf.getElseIfBranches();
                boolean bExecuted = false;
                if(lstElseIfBranches!=null && !lstElseIfBranches.isEmpty()) {
                    for(int i=0; i<lstElseIfBranches.size() && !bExecuted; i++) {
                        ConditionalBranch elseIfBranch = lstElseIfBranches.get(i);
                        if(this.evaluateCondition(elseIfBranch)) {
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
        
    private boolean evaluateCondition(ConditionalBranch objBranch) 
            throws EugeneException {

        int oldPosition = this.input.index(); // save current location
        Token condToken = objBranch.getCondition();
        this.input.seek(condToken.getTokenIndex()); // seek to place to start execution

        ifCondition_return ret = null;
        try {
            ret = this.ifCondition(false);
        } catch(RecognitionException re) {
            throw new EugeneException(re.getMessage());
        }
    	
        this.input.seek(oldPosition);

        return ret.b;
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
    }

    public void cleanUpNoExit() {
        // clear the symbol tables
        SymbolTables.cleanUp();
    	    
        // clear the interpreter's data structures
        if(null != this.interp) {
            this.interp.cleanUp();
            this.interp = null;
        }
        
        if(null != registryImporter) {
            this.registryImporter = null;
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:515:1: prog : ( eugeneStatement )+ EOF ;
    public final EugeneParser.prog_return prog() throws RecognitionException {
        EugeneParser.prog_return retval = new EugeneParser.prog_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EOF2=null;
        EugeneParser.eugeneStatement_return eugeneStatement1 =null;


        Object EOF2_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:516:2: ( ( eugeneStatement )+ EOF )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:516:4: ( eugeneStatement )+ EOF
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:516:4: ( eugeneStatement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ID && LA1_0 <= INCLUDE)||LA1_0==32||LA1_0==41||LA1_0==45||(LA1_0 >= 47 && LA1_0 <= 48)||LA1_0==54||LA1_0==57||LA1_0==66||(LA1_0 >= 70 && LA1_0 <= 72)||(LA1_0 >= 74 && LA1_0 <= 76)||LA1_0==84||LA1_0==86||(LA1_0 >= 91 && LA1_0 <= 92)||LA1_0==94||(LA1_0 >= 100 && LA1_0 <= 105)||(LA1_0 >= 107 && LA1_0 <= 108)||(LA1_0 >= 113 && LA1_0 <= 114)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:516:4: eugeneStatement
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:519:1: eugeneStatement : ( statement[false] |functionToken= functionDeclaration );
    public final EugeneParser.eugeneStatement_return eugeneStatement() throws RecognitionException {
        EugeneParser.eugeneStatement_return retval = new EugeneParser.eugeneStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.functionDeclaration_return functionToken =null;

        EugeneParser.statement_return statement3 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:520:2: ( statement[false] |functionToken= functionDeclaration )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0 >= ID && LA2_0 <= INCLUDE)||LA2_0==32||LA2_0==41||LA2_0==45||(LA2_0 >= 47 && LA2_0 <= 48)||LA2_0==54||LA2_0==57||LA2_0==66||(LA2_0 >= 70 && LA2_0 <= 72)||(LA2_0 >= 74 && LA2_0 <= 76)||LA2_0==84||LA2_0==86||LA2_0==91||LA2_0==94||(LA2_0 >= 100 && LA2_0 <= 105)||(LA2_0 >= 107 && LA2_0 <= 108)||(LA2_0 >= 113 && LA2_0 <= 114)) ) {
                alt2=1;
            }
            else if ( (LA2_0==92) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:520:4: statement[false]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_statement_in_eugeneStatement70);
                    statement3=statement(false);

                    state._fsp--;

                    adaptor.addChild(root_0, statement3.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:521:4: functionToken= functionDeclaration
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:530:1: statement[boolean defer] returns [NamedElement objReturnValue] : ( INCLUDE ';' | dataExtraction[defer] ';' |declToken= declarationStatement[defer] ';' | computationalStatement[defer] ';' | printStatement[defer] ';' | ifStatement[defer] | assertStatement[defer] ';' | noteStatement[defer] ';' | wrappedStatement[defer] ';' | loopStatement[defer] |returnToken= returnStatement[defer] | saveStatement[defer] ';' );
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

        EugeneParser.dataExtraction_return dataExtraction6 =null;

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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:533:2: ( INCLUDE ';' | dataExtraction[defer] ';' |declToken= declarationStatement[defer] ';' | computationalStatement[defer] ';' | printStatement[defer] ';' | ifStatement[defer] | assertStatement[defer] ';' | noteStatement[defer] ';' | wrappedStatement[defer] ';' | loopStatement[defer] |returnToken= returnStatement[defer] | saveStatement[defer] ';' )
            int alt3=12;
            switch ( input.LA(1) ) {
            case INCLUDE:
                {
                alt3=1;
                }
                break;
            case 76:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==26) ) {
                    int LA3_16 = input.LA(3);

                    if ( (LA3_16==88) ) {
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
                                            int LA3_39 = input.LA(9);

                                            if ( (LA3_39==32) ) {
                                                alt3=2;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 3, 39, input);

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
                    else if ( (LA3_16==95) ) {
                        int LA3_22 = input.LA(4);

                        if ( (LA3_22==20) ) {
                            int LA3_26 = input.LA(5);

                            if ( (LA3_26==STRING) ) {
                                int LA3_30 = input.LA(6);

                                if ( (LA3_30==21) ) {
                                    int LA3_34 = input.LA(7);

                                    if ( (LA3_34==32) ) {
                                        alt3=2;
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
                            new NoViableAltException("", 3, 16, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;

                }
                }
                break;
            case 54:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==26) ) {
                    int LA3_17 = input.LA(3);

                    if ( (LA3_17==95) ) {
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
                                            int LA3_40 = input.LA(9);

                                            if ( (LA3_40==32) ) {
                                                alt3=2;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 3, 40, input);

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
                    else if ( (LA3_17==88) ) {
                        int LA3_24 = input.LA(4);

                        if ( (LA3_24==20) ) {
                            int LA3_28 = input.LA(5);

                            if ( (LA3_28==21) ) {
                                int LA3_32 = input.LA(6);

                                if ( (LA3_32==32) ) {
                                    alt3=2;
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
                            new NoViableAltException("", 3, 17, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;

                }
                }
                break;
            case 74:
            case 102:
                {
                alt3=2;
                }
                break;
            case 45:
            case 47:
            case 48:
            case 57:
            case 70:
            case 71:
            case 72:
            case 75:
            case 84:
            case 100:
            case 113:
                {
                alt3=3;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case 81:
                    {
                    int LA3_18 = input.LA(3);

                    if ( (LA3_18==82) ) {
                        alt3=3;
                    }
                    else if ( (LA3_18==FLOAT||LA3_18==ID||LA3_18==INT||LA3_18==STRING||LA3_18==18||LA3_18==20||LA3_18==25||(LA3_18 >= 33 && LA3_18 <= 34)||(LA3_18 >= 36 && LA3_18 <= 39)||(LA3_18 >= 42 && LA3_18 <= 44)||LA3_18==46||(LA3_18 >= 49 && LA3_18 <= 53)||LA3_18==55||(LA3_18 >= 58 && LA3_18 <= 65)||LA3_18==69||LA3_18==73||(LA3_18 >= 77 && LA3_18 <= 79)||LA3_18==81||LA3_18==89||LA3_18==112) ) {
                        alt3=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 18, input);

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
                    int LA3_20 = input.LA(3);

                    if ( (LA3_20==85||LA3_20==93||LA3_20==99||LA3_20==106||LA3_20==109||LA3_20==111) ) {
                        alt3=9;
                    }
                    else if ( (LA3_20==ID) ) {
                        alt3=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 20, input);

                        throw nvae;

                    }
                    }
                    break;
                case 43:
                case 46:
                case 55:
                case 59:
                case 69:
                case 73:
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
                        new NoViableAltException("", 3, 6, input);

                    throw nvae;

                }

                }
                break;
            case 32:
                {
                alt3=3;
                }
                break;
            case 103:
            case 104:
                {
                alt3=5;
                }
                break;
            case 94:
                {
                alt3=6;
                }
                break;
            case 41:
                {
                alt3=7;
                }
                break;
            case 66:
                {
                alt3=8;
                }
                break;
            case 101:
            case 105:
                {
                alt3=9;
                }
                break;
            case 86:
            case 91:
            case 114:
                {
                alt3=10;
                }
                break;
            case 107:
                {
                alt3=11;
                }
                break;
            case 108:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:533:4: INCLUDE ';'
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:534:4: dataExtraction[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_dataExtraction_in_statement124);
                    dataExtraction6=dataExtraction(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, dataExtraction6.getTree());

                    char_literal7=(Token)match(input,32,FOLLOW_32_in_statement127); 
                    char_literal7_tree = 
                    (Object)adaptor.create(char_literal7)
                    ;
                    adaptor.addChild(root_0, char_literal7_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:535:4: declToken= declarationStatement[defer] ';'
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:536:4: computationalStatement[defer] ';'
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:537:4: printStatement[defer] ';'
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:538:4: ifStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ifStatement_in_statement160);
                    ifStatement13=ifStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement13.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:539:4: assertStatement[defer] ';'
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:540:4: noteStatement[defer] ';'
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:541:4: wrappedStatement[defer] ';'
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:542:10: loopStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_loopStatement_in_statement200);
                    loopStatement20=loopStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, loopStatement20.getTree());

                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:543:4: returnToken= returnStatement[defer]
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:549:4: saveStatement[defer] ';'
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:552:1: computationalStatement[boolean defer] : ( functionCall[defer] |instToken= instantiationStatement[defer] |leftToken= objectAssignmentStatement[defer] );
    public final EugeneParser.computationalStatement_return computationalStatement(boolean defer) throws RecognitionException {
        EugeneParser.computationalStatement_return retval = new EugeneParser.computationalStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.instantiationStatement_return instToken =null;

        EugeneParser.objectAssignmentStatement_return leftToken =null;

        EugeneParser.functionCall_return functionCall23 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:553:2: ( functionCall[defer] |instToken= instantiationStatement[defer] |leftToken= objectAssignmentStatement[defer] )
            int alt4=3;
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
                case 81:
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
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:553:4: functionCall[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_functionCall_in_computationalStatement232);
                    functionCall23=functionCall(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, functionCall23.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:554:4: instToken= instantiationStatement[defer]
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:559:4: leftToken= objectAssignmentStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_objectAssignmentStatement_in_computationalStatement250);
                    leftToken=objectAssignmentStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, leftToken.getTree());


                    if(!defer) {
                        if(null != (leftToken!=null?leftToken.assignElement:null)) {
                            interp.assign(
                                (CommonTree)(leftToken!=null?((Object)leftToken.tree):null), 
                                (leftToken!=null?leftToken.assignElement:null));
                        }
                    }	
                    	

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("[computationalStatement] "+e);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:575:1: assignment[boolean defer] returns [NamedElement objElement] : ( '=' exprToken= expression[defer] | '=' funcToken= functionCall[defer] | '=' stmtToken= wrappedStatement[defer] | '+' '+' | '-' '-' );
    public final EugeneParser.assignment_return assignment(boolean defer) throws RecognitionException {
        EugeneParser.assignment_return retval = new EugeneParser.assignment_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal24=null;
        Token char_literal25=null;
        Token char_literal26=null;
        Token char_literal27=null;
        Token char_literal28=null;
        Token char_literal29=null;
        Token char_literal30=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.functionCall_return funcToken =null;

        EugeneParser.wrappedStatement_return stmtToken =null;


        Object char_literal24_tree=null;
        Object char_literal25_tree=null;
        Object char_literal26_tree=null;
        Object char_literal27_tree=null;
        Object char_literal28_tree=null;
        Object char_literal29_tree=null;
        Object char_literal30_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:576:2: ( '=' exprToken= expression[defer] | '=' funcToken= functionCall[defer] | '=' stmtToken= wrappedStatement[defer] | '+' '+' | '-' '-' )
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
                case 43:
                case 44:
                case 46:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 55:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 69:
                case 73:
                case 77:
                case 78:
                case 79:
                case 81:
                case 89:
                case 112:
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
                        case 93:
                            {
                            int LA5_9 = input.LA(5);

                            if ( (LA5_9==20) ) {
                                switch ( input.LA(6) ) {
                                case INT:
                                    {
                                    int LA5_15 = input.LA(7);

                                    if ( ((LA5_15 >= 18 && LA5_15 <= 19)||(LA5_15 >= 21 && LA5_15 <= 23)||LA5_15==25||LA5_15==30||(LA5_15 >= 33 && LA5_15 <= 34)||(LA5_15 >= 36 && LA5_15 <= 40)||(LA5_15 >= 42 && LA5_15 <= 44)||LA5_15==46||(LA5_15 >= 49 && LA5_15 <= 51)||(LA5_15 >= 55 && LA5_15 <= 56)||(LA5_15 >= 58 && LA5_15 <= 61)||(LA5_15 >= 63 && LA5_15 <= 65)||(LA5_15 >= 68 && LA5_15 <= 69)||LA5_15==73||(LA5_15 >= 77 && LA5_15 <= 80)||LA5_15==83||LA5_15==96||LA5_15==116) ) {
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

                                    if ( ((LA5_16 >= 18 && LA5_16 <= 19)||(LA5_16 >= 21 && LA5_16 <= 23)||(LA5_16 >= 25 && LA5_16 <= 26)||LA5_16==30||(LA5_16 >= 33 && LA5_16 <= 34)||(LA5_16 >= 36 && LA5_16 <= 40)||(LA5_16 >= 42 && LA5_16 <= 44)||LA5_16==46||(LA5_16 >= 49 && LA5_16 <= 51)||(LA5_16 >= 55 && LA5_16 <= 56)||(LA5_16 >= 58 && LA5_16 <= 61)||(LA5_16 >= 63 && LA5_16 <= 65)||(LA5_16 >= 68 && LA5_16 <= 69)||LA5_16==73||(LA5_16 >= 77 && LA5_16 <= 81)||LA5_16==83||LA5_16==96||LA5_16==116) ) {
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

                                    if ( ((LA5_17 >= 18 && LA5_17 <= 19)||(LA5_17 >= 21 && LA5_17 <= 23)||LA5_17==25||LA5_17==30||(LA5_17 >= 33 && LA5_17 <= 34)||(LA5_17 >= 36 && LA5_17 <= 40)||(LA5_17 >= 42 && LA5_17 <= 44)||LA5_17==46||(LA5_17 >= 49 && LA5_17 <= 51)||(LA5_17 >= 55 && LA5_17 <= 56)||(LA5_17 >= 58 && LA5_17 <= 61)||(LA5_17 >= 63 && LA5_17 <= 65)||(LA5_17 >= 68 && LA5_17 <= 69)||LA5_17==73||(LA5_17 >= 77 && LA5_17 <= 80)||LA5_17==83||LA5_17==96||LA5_17==116) ) {
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
                                case 43:
                                case 44:
                                case 46:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                case 55:
                                case 58:
                                case 59:
                                case 60:
                                case 61:
                                case 62:
                                case 63:
                                case 64:
                                case 65:
                                case 69:
                                case 73:
                                case 77:
                                case 78:
                                case 79:
                                case 81:
                                case 89:
                                case 112:
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
                        case 109:
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
                            else if ( ((LA5_10 >= 18 && LA5_10 <= 19)||(LA5_10 >= 21 && LA5_10 <= 26)||LA5_10==30||(LA5_10 >= 32 && LA5_10 <= 34)||(LA5_10 >= 36 && LA5_10 <= 40)||(LA5_10 >= 42 && LA5_10 <= 44)||LA5_10==46||(LA5_10 >= 49 && LA5_10 <= 51)||(LA5_10 >= 55 && LA5_10 <= 56)||(LA5_10 >= 58 && LA5_10 <= 61)||(LA5_10 >= 63 && LA5_10 <= 65)||(LA5_10 >= 68 && LA5_10 <= 69)||LA5_10==73||(LA5_10 >= 77 && LA5_10 <= 81)||LA5_10==83||LA5_10==96||LA5_10==116) ) {
                                alt5=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 10, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 85:
                        case 99:
                        case 106:
                            {
                            alt5=3;
                            }
                            break;
                        case 111:
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
                            else if ( ((LA5_11 >= 18 && LA5_11 <= 19)||(LA5_11 >= 21 && LA5_11 <= 26)||LA5_11==30||(LA5_11 >= 32 && LA5_11 <= 34)||(LA5_11 >= 36 && LA5_11 <= 40)||(LA5_11 >= 42 && LA5_11 <= 44)||LA5_11==46||(LA5_11 >= 49 && LA5_11 <= 51)||(LA5_11 >= 55 && LA5_11 <= 56)||(LA5_11 >= 58 && LA5_11 <= 61)||(LA5_11 >= 63 && LA5_11 <= 65)||(LA5_11 >= 68 && LA5_11 <= 69)||LA5_11==73||(LA5_11 >= 77 && LA5_11 <= 81)||LA5_11==83||LA5_11==96||LA5_11==116) ) {
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
                        case 97:
                        case 98:
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
                    case 43:
                    case 44:
                    case 46:
                    case 49:
                    case 50:
                    case 51:
                    case 55:
                    case 56:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 63:
                    case 64:
                    case 65:
                    case 68:
                    case 69:
                    case 73:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 83:
                    case 96:
                    case 116:
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
                case 54:
                case 76:
                case 101:
                case 105:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:576:4: '=' exprToken= expression[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal24=(Token)match(input,35,FOLLOW_35_in_assignment275); 
                    char_literal24_tree = 
                    (Object)adaptor.create(char_literal24)
                    ;
                    adaptor.addChild(root_0, char_literal24_tree);


                    pushFollow(FOLLOW_expression_in_assignment279);
                    exprToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken.getTree());


                    if(!defer) {
                        retval.objElement = (exprToken!=null?exprToken.objElement:null);
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:581:5: '=' funcToken= functionCall[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal25=(Token)match(input,35,FOLLOW_35_in_assignment288); 
                    char_literal25_tree = 
                    (Object)adaptor.create(char_literal25)
                    ;
                    adaptor.addChild(root_0, char_literal25_tree);


                    pushFollow(FOLLOW_functionCall_in_assignment292);
                    funcToken=functionCall(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, funcToken.getTree());


                    if(!defer) {
                        retval.objElement = (funcToken!=null?funcToken.objElement:null);
                    }	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:586:11: '=' stmtToken= wrappedStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal26=(Token)match(input,35,FOLLOW_35_in_assignment307); 
                    char_literal26_tree = 
                    (Object)adaptor.create(char_literal26)
                    ;
                    adaptor.addChild(root_0, char_literal26_tree);


                    pushFollow(FOLLOW_wrappedStatement_in_assignment311);
                    stmtToken=wrappedStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, stmtToken.getTree());


                    if(!defer) {
                        retval.objElement = (stmtToken!=null?stmtToken.objElement:null);
                    }        
                            

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:591:11: '+' '+'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal27=(Token)match(input,23,FOLLOW_23_in_assignment326); 
                    char_literal27_tree = 
                    (Object)adaptor.create(char_literal27)
                    ;
                    adaptor.addChild(root_0, char_literal27_tree);


                    char_literal28=(Token)match(input,23,FOLLOW_23_in_assignment328); 
                    char_literal28_tree = 
                    (Object)adaptor.create(char_literal28)
                    ;
                    adaptor.addChild(root_0, char_literal28_tree);



                    if(!defer) {
                        retval.objElement = null;
                    }        
                            

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:596:11: '-' '-'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal29=(Token)match(input,25,FOLLOW_25_in_assignment342); 
                    char_literal29_tree = 
                    (Object)adaptor.create(char_literal29)
                    ;
                    adaptor.addChild(root_0, char_literal29_tree);


                    char_literal30=(Token)match(input,25,FOLLOW_25_in_assignment344); 
                    char_literal30_tree = 
                    (Object)adaptor.create(char_literal30)
                    ;
                    adaptor.addChild(root_0, char_literal30_tree);



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


    public static class listOfFilenames_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfFilenames"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:635:1: listOfFilenames[boolean defer] : filenameToken= filename[defer] ( ',' listOfFilenames[defer] )? ;
    public final EugeneParser.listOfFilenames_return listOfFilenames(boolean defer) throws RecognitionException {
        EugeneParser.listOfFilenames_return retval = new EugeneParser.listOfFilenames_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal31=null;
        EugeneParser.filename_return filenameToken =null;

        EugeneParser.listOfFilenames_return listOfFilenames32 =null;


        Object char_literal31_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:636:2: (filenameToken= filename[defer] ( ',' listOfFilenames[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:636:4: filenameToken= filename[defer] ( ',' listOfFilenames[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_filename_in_listOfFilenames365);
            filenameToken=filename(defer);

            state._fsp--;

            adaptor.addChild(root_0, filenameToken.getTree());

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:636:34: ( ',' listOfFilenames[defer] )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:636:35: ',' listOfFilenames[defer]
                    {
                    char_literal31=(Token)match(input,24,FOLLOW_24_in_listOfFilenames369); 
                    char_literal31_tree = 
                    (Object)adaptor.create(char_literal31)
                    ;
                    adaptor.addChild(root_0, char_literal31_tree);


                    pushFollow(FOLLOW_listOfFilenames_in_listOfFilenames371);
                    listOfFilenames32=listOfFilenames(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, listOfFilenames32.getTree());

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:639:1: filename[boolean defer] returns [String sFilename] : (filenameToken+= (~ ( ',' | ';' | '(' ) ) )* ;
    public final EugeneParser.filename_return filename(boolean defer) throws RecognitionException {
        EugeneParser.filename_return retval = new EugeneParser.filename_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token filenameToken=null;
        List list_filenameToken=null;

        Object filenameToken_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:640:2: ( (filenameToken+= (~ ( ',' | ';' | '(' ) ) )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:640:4: (filenameToken+= (~ ( ',' | ';' | '(' ) ) )*
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:640:17: (filenameToken+= (~ ( ',' | ';' | '(' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= CHAR && LA7_0 <= 19)||(LA7_0 >= 21 && LA7_0 <= 23)||(LA7_0 >= 25 && LA7_0 <= 31)||(LA7_0 >= 33 && LA7_0 <= 117)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:640:17: filenameToken+= (~ ( ',' | ';' | '(' ) )
            	    {
            	    filenameToken=(Token)input.LT(1);

            	    if ( (input.LA(1) >= CHAR && input.LA(1) <= 19)||(input.LA(1) >= 21 && input.LA(1) <= 23)||(input.LA(1) >= 25 && input.LA(1) <= 31)||(input.LA(1) >= 33 && input.LA(1) <= 117) ) {
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:655:1: declarationStatement[boolean defer] : ( collectionDeclaration[defer] | variableDeclaration[defer] | propertyDeclaration[defer] | partTypeDeclaration[defer] | deviceDeclaration[defer] | arrayDeclaration[defer] | ruleDeclaration[defer] | imageDeclaration[defer] | deviceTypeDeclaration[defer] || relationDeclaration[defer] );
    public final EugeneParser.declarationStatement_return declarationStatement(boolean defer) throws RecognitionException {
        EugeneParser.declarationStatement_return retval = new EugeneParser.declarationStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.collectionDeclaration_return collectionDeclaration33 =null;

        EugeneParser.variableDeclaration_return variableDeclaration34 =null;

        EugeneParser.propertyDeclaration_return propertyDeclaration35 =null;

        EugeneParser.partTypeDeclaration_return partTypeDeclaration36 =null;

        EugeneParser.deviceDeclaration_return deviceDeclaration37 =null;

        EugeneParser.arrayDeclaration_return arrayDeclaration38 =null;

        EugeneParser.ruleDeclaration_return ruleDeclaration39 =null;

        EugeneParser.imageDeclaration_return imageDeclaration40 =null;

        EugeneParser.deviceTypeDeclaration_return deviceTypeDeclaration41 =null;

        EugeneParser.relationDeclaration_return relationDeclaration42 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:656:2: ( collectionDeclaration[defer] | variableDeclaration[defer] | propertyDeclaration[defer] | partTypeDeclaration[defer] | deviceDeclaration[defer] | arrayDeclaration[defer] | ruleDeclaration[defer] | imageDeclaration[defer] | deviceTypeDeclaration[defer] || relationDeclaration[defer] )
            int alt8=11;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt8=1;
                }
                break;
            case 84:
            case 100:
            case 113:
                {
                alt8=2;
                }
                break;
            case 72:
                {
                int LA8_3 = input.LA(2);

                if ( (LA8_3==81) ) {
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
            case 71:
                {
                int LA8_4 = input.LA(2);

                if ( (LA8_4==ID) ) {
                    alt8=4;
                }
                else if ( (LA8_4==81) ) {
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
                else if ( (LA8_5==81) ) {
                    alt8=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 5, input);

                    throw nvae;

                }
                }
                break;
            case 70:
                {
                int LA8_6 = input.LA(2);

                if ( (LA8_6==ID) ) {
                    alt8=4;
                }
                else if ( (LA8_6==81) ) {
                    alt8=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 6, input);

                    throw nvae;

                }
                }
                break;
            case 75:
                {
                int LA8_7 = input.LA(2);

                if ( (LA8_7==81) ) {
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

                if ( (LA8_8==81) ) {
                    alt8=6;
                }
                else if ( (LA8_8==43||LA8_8==46||LA8_8==55||LA8_8==59||LA8_8==69||LA8_8==73) ) {
                    alt8=11;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 8, input);

                    throw nvae;

                }
                }
                break;
            case 57:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:656:4: collectionDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_collectionDeclaration_in_declarationStatement427);
                    collectionDeclaration33=collectionDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, collectionDeclaration33.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:657:4: variableDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_variableDeclaration_in_declarationStatement433);
                    variableDeclaration34=variableDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, variableDeclaration34.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:658:4: propertyDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_propertyDeclaration_in_declarationStatement439);
                    propertyDeclaration35=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyDeclaration35.getTree());

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:659:4: partTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partTypeDeclaration_in_declarationStatement445);
                    partTypeDeclaration36=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeDeclaration36.getTree());

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:660:4: deviceDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDeclaration_in_declarationStatement451);
                    deviceDeclaration37=deviceDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceDeclaration37.getTree());

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:661:4: arrayDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_arrayDeclaration_in_declarationStatement457);
                    arrayDeclaration38=arrayDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDeclaration38.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:662:4: ruleDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ruleDeclaration_in_declarationStatement463);
                    ruleDeclaration39=ruleDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, ruleDeclaration39.getTree());

                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:663:4: imageDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_imageDeclaration_in_declarationStatement469);
                    imageDeclaration40=imageDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, imageDeclaration40.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:664:4: deviceTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceTypeDeclaration_in_declarationStatement475);
                    deviceTypeDeclaration41=deviceTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceTypeDeclaration41.getTree());

                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:665:3: 
                    {
                    root_0 = (Object)adaptor.nil();


                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:665:5: relationDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_relationDeclaration_in_declarationStatement482);
                    relationDeclaration42=relationDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, relationDeclaration42.getTree());

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
    // $ANTLR end "declarationStatement"


    public static class collectionDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "collectionDeclaration"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:669:1: collectionDeclaration[boolean defer] : 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )? ;
    public final EugeneParser.collectionDeclaration_return collectionDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.collectionDeclaration_return retval = new EugeneParser.collectionDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal43=null;
        EugeneParser.collectionDefinition_return defToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object nameToken_tree=null;
        Object string_literal43_tree=null;


        EugeneCollection objCollection = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:673:2: ( 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:673:4: 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal43=(Token)match(input,45,FOLLOW_45_in_collectionDeclaration505); 
            string_literal43_tree = 
            (Object)adaptor.create(string_literal43)
            ;
            adaptor.addChild(root_0, string_literal43_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_collectionDeclaration509); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);



            if(!defer) {
                objCollection = interp.createCollection(
                            (nameToken!=null?nameToken.getText():null), 
                            (java.util.Collection<NamedElement>)null);
            }             
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:680:3: (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )?
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
                    else if ( (LA9_2==FLOAT||LA9_2==ID||LA9_2==INT||LA9_2==STRING||LA9_2==18||LA9_2==20||LA9_2==25||(LA9_2 >= 33 && LA9_2 <= 34)||(LA9_2 >= 36 && LA9_2 <= 39)||(LA9_2 >= 42 && LA9_2 <= 44)||LA9_2==46||(LA9_2 >= 49 && LA9_2 <= 55)||(LA9_2 >= 58 && LA9_2 <= 65)||LA9_2==69||LA9_2==73||(LA9_2 >= 76 && LA9_2 <= 79)||LA9_2==81||LA9_2==89||LA9_2==101||LA9_2==105||LA9_2==112) ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:680:4: defToken= collectionDefinition[defer, objCollection]
                    {
                    pushFollow(FOLLOW_collectionDefinition_in_collectionDeclaration519);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:685:8: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_collectionDeclaration532);
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
        catch (EugeneException e) {

            System.err.println(
                "line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getCharPositionInLine():0)+
                " => "+e);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:701:1: collectionDefinition[boolean defer, EugeneCollection objCollection] returns [java.util.Set<CollectionElement> colElements] : ( '(' lstToken= listOfCollectionComponents[defer] ')' | '=' includeToken= INCLUDE );
    public final EugeneParser.collectionDefinition_return collectionDefinition(boolean defer, EugeneCollection objCollection) throws RecognitionException {
        EugeneParser.collectionDefinition_return retval = new EugeneParser.collectionDefinition_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token includeToken=null;
        Token char_literal44=null;
        Token char_literal45=null;
        Token char_literal46=null;
        EugeneParser.listOfCollectionComponents_return lstToken =null;


        Object includeToken_tree=null;
        Object char_literal44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;


        retval.colElements = new java.util.HashSet<CollectionElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:706:2: ( '(' lstToken= listOfCollectionComponents[defer] ')' | '=' includeToken= INCLUDE )
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:706:4: '(' lstToken= listOfCollectionComponents[defer] ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal44=(Token)match(input,20,FOLLOW_20_in_collectionDefinition580); 
                    char_literal44_tree = 
                    (Object)adaptor.create(char_literal44)
                    ;
                    adaptor.addChild(root_0, char_literal44_tree);



                    if(!defer) {
                        // we need to push the collection onto the stack
                        // because in the interpreter the collection elements 
                        // will be put into the symbol tables...
                        SymbolTables.push(objCollection);
                    }	
                    	

                    pushFollow(FOLLOW_listOfCollectionComponents_in_collectionDefinition587);
                    lstToken=listOfCollectionComponents(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());


                    if(!defer) {
                        retval.colElements.addAll((lstToken!=null?lstToken.lstElements:null));
                    }	
                    	

                    char_literal45=(Token)match(input,21,FOLLOW_21_in_collectionDefinition593); 
                    char_literal45_tree = 
                    (Object)adaptor.create(char_literal45)
                    ;
                    adaptor.addChild(root_0, char_literal45_tree);



                    if(!defer) {
                        if(null != SymbolTables.peek()) {
                            // pop the collection from the stack
                            SymbolTables.pop();
                        }
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:725:4: '=' includeToken= INCLUDE
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal46=(Token)match(input,35,FOLLOW_35_in_collectionDefinition600); 
                    char_literal46_tree = 
                    (Object)adaptor.create(char_literal46)
                    ;
                    adaptor.addChild(root_0, char_literal46_tree);


                    includeToken=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_collectionDefinition604); 
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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:738:1: listOfCollectionComponents[boolean defer] returns [Set<CollectionElement> lstElements] : componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )? ;
    public final EugeneParser.listOfCollectionComponents_return listOfCollectionComponents(boolean defer) throws RecognitionException {
        EugeneParser.listOfCollectionComponents_return retval = new EugeneParser.listOfCollectionComponents_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal47=null;
        EugeneParser.collectionElement_return componentToken =null;

        EugeneParser.listOfCollectionComponents_return lstToken =null;


        Object char_literal47_tree=null;


        retval.lstElements =new HashSet<CollectionElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:743:9: (componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:743:11: componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_collectionElement_in_listOfCollectionComponents650);
            componentToken=collectionElement(defer);

            state._fsp--;

            adaptor.addChild(root_0, componentToken.getTree());


            if(!defer) {
                retval.lstElements.add((componentToken!=null?componentToken.objElement:null));
            }        
                    

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:747:11: ( ',' lstToken= listOfCollectionComponents[defer] )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:747:12: ',' lstToken= listOfCollectionComponents[defer]
                    {
                    char_literal47=(Token)match(input,24,FOLLOW_24_in_listOfCollectionComponents656); 
                    char_literal47_tree = 
                    (Object)adaptor.create(char_literal47)
                    ;
                    adaptor.addChild(root_0, char_literal47_tree);


                    pushFollow(FOLLOW_listOfCollectionComponents_in_listOfCollectionComponents660);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:754:1: collectionElement[boolean defer] returns [CollectionElement objElement] : (propertyToken= propertyDeclaration[defer] |partTypeToken= partTypeDeclaration[defer] |deviceToken= deviceDeclaration[defer] |instToken= instantiationStatement[defer] |idToken= ID );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:755:2: (propertyToken= propertyDeclaration[defer] |partTypeToken= partTypeDeclaration[defer] |deviceToken= deviceDeclaration[defer] |instToken= instantiationStatement[defer] |idToken= ID )
            int alt12=5;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt12=1;
                }
                break;
            case 70:
            case 71:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:755:4: propertyToken= propertyDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_propertyDeclaration_in_collectionElement698);
                    propertyToken=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyToken.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:756:4: partTypeToken= partTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partTypeDeclaration_in_collectionElement706);
                    partTypeToken=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeToken.getTree());


                    if(!defer) {
                        retval.objElement = partTypeToken.objPartType;
                    }            
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:761:11: deviceToken= deviceDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDeclaration_in_collectionElement723);
                    deviceToken=deviceDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());


                    if(!defer) {
                        retval.objElement = (deviceToken!=null?deviceToken.objDevice:null);
                    }        
                            

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:766:4: instToken= instantiationStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_instantiationStatement_in_collectionElement733);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        retval.objElement = (instToken!=null?instToken.objComponent:null);
                    }
                            

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:771:11: idToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_collectionElement750); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:782:1: propertyDeclaration[boolean defer] returns [Property objProperty] : 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')' ;
    public final EugeneParser.propertyDeclaration_return propertyDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.propertyDeclaration_return retval = new EugeneParser.propertyDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal48=null;
        Token char_literal49=null;
        Token char_literal50=null;
        EugeneParser.dynamicNaming_return nameToken =null;

        EugeneParser.propertyType_return typeToken =null;


        Object string_literal48_tree=null;
        Object char_literal49_tree=null;
        Object char_literal50_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:784:2: ( 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:784:4: 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal48=(Token)match(input,72,FOLLOW_72_in_propertyDeclaration773); 
            string_literal48_tree = 
            (Object)adaptor.create(string_literal48)
            ;
            adaptor.addChild(root_0, string_literal48_tree);


            pushFollow(FOLLOW_dynamicNaming_in_propertyDeclaration777);
            nameToken=dynamicNaming(defer);

            state._fsp--;

            adaptor.addChild(root_0, nameToken.getTree());

            char_literal49=(Token)match(input,20,FOLLOW_20_in_propertyDeclaration780); 
            char_literal49_tree = 
            (Object)adaptor.create(char_literal49)
            ;
            adaptor.addChild(root_0, char_literal49_tree);


            pushFollow(FOLLOW_propertyType_in_propertyDeclaration784);
            typeToken=propertyType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            char_literal50=(Token)match(input,21,FOLLOW_21_in_propertyDeclaration786); 
            char_literal50_tree = 
            (Object)adaptor.create(char_literal50)
            ;
            adaptor.addChild(root_0, char_literal50_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:799:1: propertyType : ( 'txt' | 'txt' '[' ']' | 'num' | 'num' '[' ']' | 'boolean' );
    public final EugeneParser.propertyType_return propertyType() throws RecognitionException {
        EugeneParser.propertyType_return retval = new EugeneParser.propertyType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal51=null;
        Token string_literal52=null;
        Token char_literal53=null;
        Token char_literal54=null;
        Token string_literal55=null;
        Token string_literal56=null;
        Token char_literal57=null;
        Token char_literal58=null;
        Token string_literal59=null;

        Object string_literal51_tree=null;
        Object string_literal52_tree=null;
        Object char_literal53_tree=null;
        Object char_literal54_tree=null;
        Object string_literal55_tree=null;
        Object string_literal56_tree=null;
        Object char_literal57_tree=null;
        Object char_literal58_tree=null;
        Object string_literal59_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:800:2: ( 'txt' | 'txt' '[' ']' | 'num' | 'num' '[' ']' | 'boolean' )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 113:
                {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==81) ) {
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
            case 100:
                {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==81) ) {
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
            case 84:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:800:4: 'txt'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal51=(Token)match(input,113,FOLLOW_113_in_propertyType805); 
                    string_literal51_tree = 
                    (Object)adaptor.create(string_literal51)
                    ;
                    adaptor.addChild(root_0, string_literal51_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:801:4: 'txt' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal52=(Token)match(input,113,FOLLOW_113_in_propertyType810); 
                    string_literal52_tree = 
                    (Object)adaptor.create(string_literal52)
                    ;
                    adaptor.addChild(root_0, string_literal52_tree);


                    char_literal53=(Token)match(input,81,FOLLOW_81_in_propertyType812); 
                    char_literal53_tree = 
                    (Object)adaptor.create(char_literal53)
                    ;
                    adaptor.addChild(root_0, char_literal53_tree);


                    char_literal54=(Token)match(input,82,FOLLOW_82_in_propertyType814); 
                    char_literal54_tree = 
                    (Object)adaptor.create(char_literal54)
                    ;
                    adaptor.addChild(root_0, char_literal54_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:802:4: 'num'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal55=(Token)match(input,100,FOLLOW_100_in_propertyType819); 
                    string_literal55_tree = 
                    (Object)adaptor.create(string_literal55)
                    ;
                    adaptor.addChild(root_0, string_literal55_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:803:4: 'num' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal56=(Token)match(input,100,FOLLOW_100_in_propertyType824); 
                    string_literal56_tree = 
                    (Object)adaptor.create(string_literal56)
                    ;
                    adaptor.addChild(root_0, string_literal56_tree);


                    char_literal57=(Token)match(input,81,FOLLOW_81_in_propertyType826); 
                    char_literal57_tree = 
                    (Object)adaptor.create(char_literal57)
                    ;
                    adaptor.addChild(root_0, char_literal57_tree);


                    char_literal58=(Token)match(input,82,FOLLOW_82_in_propertyType828); 
                    char_literal58_tree = 
                    (Object)adaptor.create(char_literal58)
                    ;
                    adaptor.addChild(root_0, char_literal58_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:804:4: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal59=(Token)match(input,84,FOLLOW_84_in_propertyType833); 
                    string_literal59_tree = 
                    (Object)adaptor.create(string_literal59)
                    ;
                    adaptor.addChild(root_0, string_literal59_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:809:1: variableDeclaration[boolean defer] returns [List<Variable> lstVariables] : typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text] ;
    public final EugeneParser.variableDeclaration_return variableDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.variableDeclaration_return retval = new EugeneParser.variableDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.propertyType_return typeToken =null;

        EugeneParser.listOfVariables_return varToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:811:2: (typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:811:4: typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_propertyType_in_variableDeclaration857);
            typeToken=propertyType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            pushFollow(FOLLOW_listOfVariables_in_variableDeclaration861);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:818:1: listOfVariables[boolean defer, String sVariableType] returns [List<Variable> lstVariables] : idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )? ;
    public final EugeneParser.listOfVariables_return listOfVariables(boolean defer, String sVariableType) throws RecognitionException {
        EugeneParser.listOfVariables_return retval = new EugeneParser.listOfVariables_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal60=null;
        EugeneParser.assignment_return assignToken =null;

        EugeneParser.listOfVariables_return lstToken =null;


        Object idToken_tree=null;
        Object char_literal60_tree=null;


        retval.lstVariables = new ArrayList<Variable>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:823:2: (idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:823:4: idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )?
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfVariables889); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);



            if(!defer) {
                retval.lstVariables.add(
                    interp.createVariable((idToken!=null?idToken.getText():null), sVariableType));
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:828:9: (assignToken= assignment[defer] )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23||LA14_0==25||LA14_0==35) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:828:10: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_listOfVariables901);
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


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:833:14: ( ',' lstToken= listOfVariables[defer, sVariableType] )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:833:15: ',' lstToken= listOfVariables[defer, sVariableType]
                    {
                    char_literal60=(Token)match(input,24,FOLLOW_24_in_listOfVariables910); 
                    char_literal60_tree = 
                    (Object)adaptor.create(char_literal60)
                    ;
                    adaptor.addChild(root_0, char_literal60_tree);


                    pushFollow(FOLLOW_listOfVariables_in_listOfVariables914);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:849:1: partTypeDeclaration[boolean defer] returns [PartType objPartType] : ( ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? | ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer] );
    public final EugeneParser.partTypeDeclaration_return partTypeDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.partTypeDeclaration_return retval = new EugeneParser.partTypeDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token set61=null;
        Token char_literal62=null;
        Token char_literal63=null;
        Token set64=null;
        EugeneParser.listOfIDs_return lstToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object nameToken_tree=null;
        Object set61_tree=null;
        Object char_literal62_tree=null;
        Object char_literal63_tree=null;
        Object set64_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:850:2: ( ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? | ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer] )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0 >= 70 && LA18_0 <= 71)) ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:850:4: ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )?
                    {
                    root_0 = (Object)adaptor.nil();


                    set61=(Token)input.LT(1);

                    if ( (input.LA(1) >= 70 && input.LA(1) <= 71) ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set61)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_partTypeDeclaration956); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:850:38: ( '(' (lstToken= listOfIDs[defer] )? ')' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==20) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:850:39: '(' (lstToken= listOfIDs[defer] )? ')'
                            {
                            char_literal62=(Token)match(input,20,FOLLOW_20_in_partTypeDeclaration959); 
                            char_literal62_tree = 
                            (Object)adaptor.create(char_literal62)
                            ;
                            adaptor.addChild(root_0, char_literal62_tree);


                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:850:43: (lstToken= listOfIDs[defer] )?
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( (LA16_0==ID) ) {
                                alt16=1;
                            }
                            switch (alt16) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:850:44: lstToken= listOfIDs[defer]
                                    {
                                    pushFollow(FOLLOW_listOfIDs_in_partTypeDeclaration964);
                                    lstToken=listOfIDs(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, lstToken.getTree());

                                    }
                                    break;

                            }


                            char_literal63=(Token)match(input,21,FOLLOW_21_in_partTypeDeclaration969); 
                            char_literal63_tree = 
                            (Object)adaptor.create(char_literal63)
                            ;
                            adaptor.addChild(root_0, char_literal63_tree);


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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:857:11: ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    set64=(Token)input.LT(1);

                    if ( (input.LA(1) >= 70 && input.LA(1) <= 71) ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set64)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_partTypeDeclaration993); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    pushFollow(FOLLOW_assignment_in_partTypeDeclaration997);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:872:1: listOfIDs[boolean defer] returns [List<NamedElement> lstElements] : idToken= ID ( ',' lstToken= listOfIDs[defer] )? ;
    public final EugeneParser.listOfIDs_return listOfIDs(boolean defer) throws RecognitionException {
        EugeneParser.listOfIDs_return retval = new EugeneParser.listOfIDs_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal65=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object idToken_tree=null;
        Object char_literal65_tree=null;


        retval.lstElements =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:876:2: (idToken= ID ( ',' lstToken= listOfIDs[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:876:4: idToken= ID ( ',' lstToken= listOfIDs[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfIDs1031); 
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:886:5: ( ',' lstToken= listOfIDs[defer] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:886:6: ',' lstToken= listOfIDs[defer]
                    {
                    char_literal65=(Token)match(input,24,FOLLOW_24_in_listOfIDs1037); 
                    char_literal65_tree = 
                    (Object)adaptor.create(char_literal65)
                    ;
                    adaptor.addChild(root_0, char_literal65_tree);


                    pushFollow(FOLLOW_listOfIDs_in_listOfIDs1041);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:896:1: deviceDeclaration[boolean defer] returns [Device objDevice] : 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )? ;
    public final EugeneParser.deviceDeclaration_return deviceDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.deviceDeclaration_return retval = new EugeneParser.deviceDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal66=null;
        Token char_literal67=null;
        Token char_literal68=null;
        EugeneParser.deviceComponents_return compToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object nameToken_tree=null;
        Object string_literal66_tree=null;
        Object char_literal67_tree=null;
        Object char_literal68_tree=null;


        retval.objDevice = (Device)null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:901:2: ( 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:901:4: 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal66=(Token)match(input,47,FOLLOW_47_in_deviceDeclaration1072); 
            string_literal66_tree = 
            (Object)adaptor.create(string_literal66)
            ;
            adaptor.addChild(root_0, string_literal66_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_deviceDeclaration1076); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:902:3: ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )?
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:902:4: '(' (compToken= deviceComponents[defer] )? ')'
                    {
                    char_literal67=(Token)match(input,20,FOLLOW_20_in_deviceDeclaration1082); 
                    char_literal67_tree = 
                    (Object)adaptor.create(char_literal67)
                    ;
                    adaptor.addChild(root_0, char_literal67_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:902:8: (compToken= deviceComponents[defer] )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==FLOAT||LA20_0==ID||LA20_0==INT||LA20_0==STRING||LA20_0==20||LA20_0==23||LA20_0==25||LA20_0==47||(LA20_0 >= 70 && LA20_0 <= 72)||LA20_0==81||LA20_0==89||LA20_0==112) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:902:9: compToken= deviceComponents[defer]
                            {
                            pushFollow(FOLLOW_deviceComponents_in_deviceDeclaration1087);
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


                    char_literal68=(Token)match(input,21,FOLLOW_21_in_deviceDeclaration1095); 
                    char_literal68_tree = 
                    (Object)adaptor.create(char_literal68)
                    ;
                    adaptor.addChild(root_0, char_literal68_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:913:11: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_deviceDeclaration1109);
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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:932:1: deviceComponents[boolean defer] returns [ArrayList<NamedElement> lstElements, char[] directions] : (directionToken= ( '-' | '+' ) )? (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )? ;
    public final EugeneParser.deviceComponents_return deviceComponents(boolean defer) throws RecognitionException {
        EugeneParser.deviceComponents_return retval = new EugeneParser.deviceComponents_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token directionToken=null;
        Token char_literal69=null;
        EugeneParser.expressionValue_return objToken =null;

        EugeneParser.partTypeDeclaration_return partTypeToken =null;

        EugeneParser.instantiationStatement_return instToken =null;

        EugeneParser.propertyDeclaration_return propertyToken =null;

        EugeneParser.deviceDeclaration_return deviceToken =null;

        EugeneParser.deviceComponents_return compToken =null;


        Object directionToken_tree=null;
        Object char_literal69_tree=null;


        retval.lstElements = new ArrayList<NamedElement>();
        NamedElement objElement = null;
        retval.directions = new char[1];

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:942:2: ( (directionToken= ( '-' | '+' ) )? (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:942:4: (directionToken= ( '-' | '+' ) )? (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:942:4: (directionToken= ( '-' | '+' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==23||LA22_0==25) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:942:5: directionToken= ( '-' | '+' )
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


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:943:3: (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] )
            int alt23=5;
            switch ( input.LA(1) ) {
            case FLOAT:
            case INT:
            case STRING:
            case 20:
            case 25:
            case 81:
            case 89:
            case 112:
                {
                alt23=1;
                }
                break;
            case ID:
                {
                int LA23_2 = input.LA(2);

                if ( (LA23_2==21||LA23_2==24||LA23_2==26||LA23_2==81) ) {
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
            case 70:
            case 71:
                {
                alt23=2;
                }
                break;
            case 72:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:943:4: objToken= expressionValue[defer]
                    {
                    pushFollow(FOLLOW_expressionValue_in_deviceComponents1170);
                    objToken=expressionValue(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, objToken.getTree());


                    if(!defer) {	
                        objElement = (objToken!=null?objToken.objElement:null);
                    }
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:948:4: partTypeToken= partTypeDeclaration[defer]
                    {
                    pushFollow(FOLLOW_partTypeDeclaration_in_deviceComponents1181);
                    partTypeToken=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeToken.getTree());


                    if(!defer) {
                        objElement = (partTypeToken!=null?partTypeToken.objPartType:null);
                    }    
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:953:4: instToken= instantiationStatement[defer]
                    {
                    pushFollow(FOLLOW_instantiationStatement_in_deviceComponents1191);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        objElement = (instToken!=null?instToken.objComponent:null);
                    }    
                        	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:958:4: propertyToken= propertyDeclaration[defer]
                    {
                    pushFollow(FOLLOW_propertyDeclaration_in_deviceComponents1201);
                    propertyToken=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyToken.getTree());


                    if(!defer) {
                        objElement = (propertyToken!=null?propertyToken.objProperty:null);
                    }    
                        	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:963:4: deviceToken= deviceDeclaration[defer]
                    {
                    pushFollow(FOLLOW_deviceDeclaration_in_deviceComponents1211);
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:982:4: ( ',' compToken= deviceComponents[defer] )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==24) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:982:5: ',' compToken= deviceComponents[defer]
                    {
                    char_literal69=(Token)match(input,24,FOLLOW_24_in_deviceComponents1221); 
                    char_literal69_tree = 
                    (Object)adaptor.create(char_literal69)
                    ;
                    adaptor.addChild(root_0, char_literal69_tree);


                    pushFollow(FOLLOW_deviceComponents_in_deviceComponents1225);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:990:1: deviceTypeDeclaration[boolean defer] returns [DeviceType objDeviceType] : 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')' ;
    public final EugeneParser.deviceTypeDeclaration_return deviceTypeDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.deviceTypeDeclaration_return retval = new EugeneParser.deviceTypeDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token string_literal70=null;
        Token char_literal71=null;
        Token char_literal72=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object idToken_tree=null;
        Object string_literal70_tree=null;
        Object char_literal71_tree=null;
        Object char_literal72_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:992:2: ( 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:992:4: 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal70=(Token)match(input,48,FOLLOW_48_in_deviceTypeDeclaration1251); 
            string_literal70_tree = 
            (Object)adaptor.create(string_literal70)
            ;
            adaptor.addChild(root_0, string_literal70_tree);


            idToken=(Token)match(input,ID,FOLLOW_ID_in_deviceTypeDeclaration1255); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal71=(Token)match(input,20,FOLLOW_20_in_deviceTypeDeclaration1257); 
            char_literal71_tree = 
            (Object)adaptor.create(char_literal71)
            ;
            adaptor.addChild(root_0, char_literal71_tree);


            pushFollow(FOLLOW_listOfIDs_in_deviceTypeDeclaration1261);
            lstToken=listOfIDs(defer);

            state._fsp--;

            adaptor.addChild(root_0, lstToken.getTree());

            char_literal72=(Token)match(input,21,FOLLOW_21_in_deviceTypeDeclaration1264); 
            char_literal72_tree = 
            (Object)adaptor.create(char_literal72)
            ;
            adaptor.addChild(root_0, char_literal72_tree);



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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1008:1: arrayDeclaration[boolean defer] returns [NamedElement objArray] : typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1013:2: (typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1013:4: typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_arrayType_in_arrayDeclaration1299);
            typeToken=arrayType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            nameToken=(Token)match(input,ID,FOLLOW_ID_in_arrayDeclaration1303); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1013:37: (assignToken= assignment[defer] )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==23||LA25_0==25||LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1013:38: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_arrayDeclaration1308);
                    assignToken=assignment(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assignToken.getTree());

                    }
                    break;

            }



            if(!defer) {
                if(null!=assignToken) {
                    interp.assign((nameToken!=null?nameToken.getText():null), (assignToken!=null?assignToken.objElement:null));
                } else {
                    interp.createArray((typeToken!=null?input.toString(typeToken.start,typeToken.stop):null), (nameToken!=null?nameToken.getText():null));
                }
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1031:1: arrayType : ( 'Device' '[' ']' | 'PartType' '[' ']' | 'Part' '[' ']' | 'Property' '[' ']' | 'Rule' '[' ']' | ID '[' ']' );
    public final EugeneParser.arrayType_return arrayType() throws RecognitionException {
        EugeneParser.arrayType_return retval = new EugeneParser.arrayType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal73=null;
        Token char_literal74=null;
        Token char_literal75=null;
        Token string_literal76=null;
        Token char_literal77=null;
        Token char_literal78=null;
        Token string_literal79=null;
        Token char_literal80=null;
        Token char_literal81=null;
        Token string_literal82=null;
        Token char_literal83=null;
        Token char_literal84=null;
        Token string_literal85=null;
        Token char_literal86=null;
        Token char_literal87=null;
        Token ID88=null;
        Token char_literal89=null;
        Token char_literal90=null;

        Object string_literal73_tree=null;
        Object char_literal74_tree=null;
        Object char_literal75_tree=null;
        Object string_literal76_tree=null;
        Object char_literal77_tree=null;
        Object char_literal78_tree=null;
        Object string_literal79_tree=null;
        Object char_literal80_tree=null;
        Object char_literal81_tree=null;
        Object string_literal82_tree=null;
        Object char_literal83_tree=null;
        Object char_literal84_tree=null;
        Object string_literal85_tree=null;
        Object char_literal86_tree=null;
        Object char_literal87_tree=null;
        Object ID88_tree=null;
        Object char_literal89_tree=null;
        Object char_literal90_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1032:2: ( 'Device' '[' ']' | 'PartType' '[' ']' | 'Part' '[' ']' | 'Property' '[' ']' | 'Rule' '[' ']' | ID '[' ']' )
            int alt26=6;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt26=1;
                }
                break;
            case 71:
                {
                alt26=2;
                }
                break;
            case 70:
                {
                alt26=3;
                }
                break;
            case 72:
                {
                alt26=4;
                }
                break;
            case 75:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1032:4: 'Device' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal73=(Token)match(input,47,FOLLOW_47_in_arrayType1332); 
                    string_literal73_tree = 
                    (Object)adaptor.create(string_literal73)
                    ;
                    adaptor.addChild(root_0, string_literal73_tree);


                    char_literal74=(Token)match(input,81,FOLLOW_81_in_arrayType1334); 
                    char_literal74_tree = 
                    (Object)adaptor.create(char_literal74)
                    ;
                    adaptor.addChild(root_0, char_literal74_tree);


                    char_literal75=(Token)match(input,82,FOLLOW_82_in_arrayType1336); 
                    char_literal75_tree = 
                    (Object)adaptor.create(char_literal75)
                    ;
                    adaptor.addChild(root_0, char_literal75_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1033:4: 'PartType' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal76=(Token)match(input,71,FOLLOW_71_in_arrayType1341); 
                    string_literal76_tree = 
                    (Object)adaptor.create(string_literal76)
                    ;
                    adaptor.addChild(root_0, string_literal76_tree);


                    char_literal77=(Token)match(input,81,FOLLOW_81_in_arrayType1343); 
                    char_literal77_tree = 
                    (Object)adaptor.create(char_literal77)
                    ;
                    adaptor.addChild(root_0, char_literal77_tree);


                    char_literal78=(Token)match(input,82,FOLLOW_82_in_arrayType1345); 
                    char_literal78_tree = 
                    (Object)adaptor.create(char_literal78)
                    ;
                    adaptor.addChild(root_0, char_literal78_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1034:4: 'Part' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal79=(Token)match(input,70,FOLLOW_70_in_arrayType1350); 
                    string_literal79_tree = 
                    (Object)adaptor.create(string_literal79)
                    ;
                    adaptor.addChild(root_0, string_literal79_tree);


                    char_literal80=(Token)match(input,81,FOLLOW_81_in_arrayType1352); 
                    char_literal80_tree = 
                    (Object)adaptor.create(char_literal80)
                    ;
                    adaptor.addChild(root_0, char_literal80_tree);


                    char_literal81=(Token)match(input,82,FOLLOW_82_in_arrayType1354); 
                    char_literal81_tree = 
                    (Object)adaptor.create(char_literal81)
                    ;
                    adaptor.addChild(root_0, char_literal81_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1035:4: 'Property' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal82=(Token)match(input,72,FOLLOW_72_in_arrayType1359); 
                    string_literal82_tree = 
                    (Object)adaptor.create(string_literal82)
                    ;
                    adaptor.addChild(root_0, string_literal82_tree);


                    char_literal83=(Token)match(input,81,FOLLOW_81_in_arrayType1361); 
                    char_literal83_tree = 
                    (Object)adaptor.create(char_literal83)
                    ;
                    adaptor.addChild(root_0, char_literal83_tree);


                    char_literal84=(Token)match(input,82,FOLLOW_82_in_arrayType1363); 
                    char_literal84_tree = 
                    (Object)adaptor.create(char_literal84)
                    ;
                    adaptor.addChild(root_0, char_literal84_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1036:4: 'Rule' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal85=(Token)match(input,75,FOLLOW_75_in_arrayType1368); 
                    string_literal85_tree = 
                    (Object)adaptor.create(string_literal85)
                    ;
                    adaptor.addChild(root_0, string_literal85_tree);


                    char_literal86=(Token)match(input,81,FOLLOW_81_in_arrayType1370); 
                    char_literal86_tree = 
                    (Object)adaptor.create(char_literal86)
                    ;
                    adaptor.addChild(root_0, char_literal86_tree);


                    char_literal87=(Token)match(input,82,FOLLOW_82_in_arrayType1372); 
                    char_literal87_tree = 
                    (Object)adaptor.create(char_literal87)
                    ;
                    adaptor.addChild(root_0, char_literal87_tree);


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1037:4: ID '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    ID88=(Token)match(input,ID,FOLLOW_ID_in_arrayType1377); 
                    ID88_tree = 
                    (Object)adaptor.create(ID88)
                    ;
                    adaptor.addChild(root_0, ID88_tree);


                    char_literal89=(Token)match(input,81,FOLLOW_81_in_arrayType1379); 
                    char_literal89_tree = 
                    (Object)adaptor.create(char_literal89)
                    ;
                    adaptor.addChild(root_0, char_literal89_tree);


                    char_literal90=(Token)match(input,82,FOLLOW_82_in_arrayType1381); 
                    char_literal90_tree = 
                    (Object)adaptor.create(char_literal90)
                    ;
                    adaptor.addChild(root_0, char_literal90_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1042:1: ruleDeclaration[boolean defer] : 'Rule' ruleNameToken= ID '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')' ;
    public final EugeneParser.ruleDeclaration_return ruleDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.ruleDeclaration_return retval = new EugeneParser.ruleDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ruleNameToken=null;
        Token string_literal91=null;
        Token char_literal92=null;
        Token char_literal93=null;
        EugeneParser.onDevice_return deviceToken =null;

        EugeneParser.expression_return exprToken =null;


        Object ruleNameToken_tree=null;
        Object string_literal91_tree=null;
        Object char_literal92_tree=null;
        Object char_literal93_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1043:2: ( 'Rule' ruleNameToken= ID '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1043:4: 'Rule' ruleNameToken= ID '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal91=(Token)match(input,75,FOLLOW_75_in_ruleDeclaration1397); 
            string_literal91_tree = 
            (Object)adaptor.create(string_literal91)
            ;
            adaptor.addChild(root_0, string_literal91_tree);


            ruleNameToken=(Token)match(input,ID,FOLLOW_ID_in_ruleDeclaration1401); 
            ruleNameToken_tree = 
            (Object)adaptor.create(ruleNameToken)
            ;
            adaptor.addChild(root_0, ruleNameToken_tree);


            char_literal92=(Token)match(input,20,FOLLOW_20_in_ruleDeclaration1403); 
            char_literal92_tree = 
            (Object)adaptor.create(char_literal92)
            ;
            adaptor.addChild(root_0, char_literal92_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1044:5: (deviceToken= onDevice[defer] )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==67) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1044:6: deviceToken= onDevice[defer]
                    {
                    pushFollow(FOLLOW_onDevice_in_ruleDeclaration1413);
                    deviceToken=onDevice(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_ruleDeclaration1424);
            exprToken=expression(true);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {    
                interp.createRule((ruleNameToken!=null?ruleNameToken.getText():null), 
                        (deviceToken!=null?deviceToken.device:null), 
                        exprToken.start, 
                        (CommonTree)(exprToken!=null?((Object)exprToken.tree):null));    
            }
                    

            char_literal93=(Token)match(input,21,FOLLOW_21_in_ruleDeclaration1429); 
            char_literal93_tree = 
            (Object)adaptor.create(char_literal93)
            ;
            adaptor.addChild(root_0, char_literal93_tree);


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


    public static class onDevice_return extends ParserRuleReturnScope {
        public Device device;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "onDevice"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1061:1: onDevice[boolean defer] returns [Device device] : 'ON' deviceToken= ID ':' ;
    public final EugeneParser.onDevice_return onDevice(boolean defer) throws RecognitionException {
        EugeneParser.onDevice_return retval = new EugeneParser.onDevice_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token deviceToken=null;
        Token string_literal94=null;
        Token char_literal95=null;

        Object deviceToken_tree=null;
        Object string_literal94_tree=null;
        Object char_literal95_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1063:2: ( 'ON' deviceToken= ID ':' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1063:4: 'ON' deviceToken= ID ':'
            {
            root_0 = (Object)adaptor.nil();


            string_literal94=(Token)match(input,67,FOLLOW_67_in_onDevice1467); 
            string_literal94_tree = 
            (Object)adaptor.create(string_literal94)
            ;
            adaptor.addChild(root_0, string_literal94_tree);


            deviceToken=(Token)match(input,ID,FOLLOW_ID_in_onDevice1471); 
            deviceToken_tree = 
            (Object)adaptor.create(deviceToken)
            ;
            adaptor.addChild(root_0, deviceToken_tree);


            char_literal95=(Token)match(input,31,FOLLOW_31_in_onDevice1473); 
            char_literal95_tree = 
            (Object)adaptor.create(char_literal95)
            ;
            adaptor.addChild(root_0, char_literal95_tree);



            if(!defer) {
                NamedElement element = SymbolTables.get((deviceToken!=null?deviceToken.getText():null));
                if(null == element) {
                    throw new EugeneException("I don't know "+(deviceToken!=null?deviceToken.getText():null));
                }
                
                if(!(element instanceof Device)) {
                    throw new EugeneException((deviceToken!=null?deviceToken.getText():null)+" is not a Device!");
                }
                
                retval.device = (Device)element;
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+(deviceToken!=null?deviceToken.getLine():0)+":"+(deviceToken!=null?deviceToken.getCharPositionInLine():0)+" => "+
                    e.getMessage());
            e.printStackTrace();
            this.cleanUp(1);
                    
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "onDevice"


    public static class folExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "folExpression"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1085:1: folExpression[boolean defer] : ( ( 'FORALL' ^fToken= listOfIDs[defer] ) ( 'EXISTS' ^eToken= listOfIDs[defer] )? ':' | ( 'EXISTS' ^eToken= listOfIDs[defer] ) ':' );
    public final EugeneParser.folExpression_return folExpression(boolean defer) throws RecognitionException {
        EugeneParser.folExpression_return retval = new EugeneParser.folExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal96=null;
        Token string_literal97=null;
        Token char_literal98=null;
        Token string_literal99=null;
        Token char_literal100=null;
        EugeneParser.listOfIDs_return fToken =null;

        EugeneParser.listOfIDs_return eToken =null;


        Object string_literal96_tree=null;
        Object string_literal97_tree=null;
        Object char_literal98_tree=null;
        Object string_literal99_tree=null;
        Object char_literal100_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1086:2: ( ( 'FORALL' ^fToken= listOfIDs[defer] ) ( 'EXISTS' ^eToken= listOfIDs[defer] )? ':' | ( 'EXISTS' ^eToken= listOfIDs[defer] ) ':' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==53) ) {
                alt29=1;
            }
            else if ( (LA29_0==52) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1086:4: ( 'FORALL' ^fToken= listOfIDs[defer] ) ( 'EXISTS' ^eToken= listOfIDs[defer] )? ':'
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1086:4: ( 'FORALL' ^fToken= listOfIDs[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1086:5: 'FORALL' ^fToken= listOfIDs[defer]
                    {
                    string_literal96=(Token)match(input,53,FOLLOW_53_in_folExpression1517); 
                    string_literal96_tree = 
                    (Object)adaptor.create(string_literal96)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(string_literal96_tree, root_0);


                    pushFollow(FOLLOW_listOfIDs_in_folExpression1522);
                    fToken=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, fToken.getTree());

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1086:40: ( 'EXISTS' ^eToken= listOfIDs[defer] )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==52) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1086:41: 'EXISTS' ^eToken= listOfIDs[defer]
                            {
                            string_literal97=(Token)match(input,52,FOLLOW_52_in_folExpression1527); 
                            string_literal97_tree = 
                            (Object)adaptor.create(string_literal97)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(string_literal97_tree, root_0);


                            pushFollow(FOLLOW_listOfIDs_in_folExpression1532);
                            eToken=listOfIDs(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, eToken.getTree());

                            }
                            break;

                    }


                    char_literal98=(Token)match(input,31,FOLLOW_31_in_folExpression1537); 
                    char_literal98_tree = 
                    (Object)adaptor.create(char_literal98)
                    ;
                    adaptor.addChild(root_0, char_literal98_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1087:4: ( 'EXISTS' ^eToken= listOfIDs[defer] ) ':'
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1087:4: ( 'EXISTS' ^eToken= listOfIDs[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1087:5: 'EXISTS' ^eToken= listOfIDs[defer]
                    {
                    string_literal99=(Token)match(input,52,FOLLOW_52_in_folExpression1544); 
                    string_literal99_tree = 
                    (Object)adaptor.create(string_literal99)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(string_literal99_tree, root_0);


                    pushFollow(FOLLOW_listOfIDs_in_folExpression1549);
                    eToken=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, eToken.getTree());

                    }


                    char_literal100=(Token)match(input,31,FOLLOW_31_in_folExpression1553); 
                    char_literal100_tree = 
                    (Object)adaptor.create(char_literal100)
                    ;
                    adaptor.addChild(root_0, char_literal100_tree);


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


    public static class imageDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "imageDeclaration"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1106:1: imageDeclaration[boolean defer] : 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')' ;
    public final EugeneParser.imageDeclaration_return imageDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.imageDeclaration_return retval = new EugeneParser.imageDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token imageNameToken=null;
        Token imagePathToken=null;
        Token string_literal101=null;
        Token char_literal102=null;
        Token char_literal103=null;
        Token char_literal104=null;

        Object imageNameToken_tree=null;
        Object imagePathToken_tree=null;
        Object string_literal101_tree=null;
        Object char_literal102_tree=null;
        Object char_literal103_tree=null;
        Object char_literal104_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1107:2: ( 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1107:4: 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal101=(Token)match(input,57,FOLLOW_57_in_imageDeclaration1578); 
            string_literal101_tree = 
            (Object)adaptor.create(string_literal101)
            ;
            adaptor.addChild(root_0, string_literal101_tree);


            char_literal102=(Token)match(input,20,FOLLOW_20_in_imageDeclaration1580); 
            char_literal102_tree = 
            (Object)adaptor.create(char_literal102)
            ;
            adaptor.addChild(root_0, char_literal102_tree);


            imageNameToken=(Token)match(input,ID,FOLLOW_ID_in_imageDeclaration1584); 
            imageNameToken_tree = 
            (Object)adaptor.create(imageNameToken)
            ;
            adaptor.addChild(root_0, imageNameToken_tree);


            char_literal103=(Token)match(input,24,FOLLOW_24_in_imageDeclaration1586); 
            char_literal103_tree = 
            (Object)adaptor.create(char_literal103)
            ;
            adaptor.addChild(root_0, char_literal103_tree);


            imagePathToken=(Token)match(input,STRING,FOLLOW_STRING_in_imageDeclaration1590); 
            imagePathToken_tree = 
            (Object)adaptor.create(imagePathToken)
            ;
            adaptor.addChild(root_0, imagePathToken_tree);


            char_literal104=(Token)match(input,21,FOLLOW_21_in_imageDeclaration1592); 
            char_literal104_tree = 
            (Object)adaptor.create(char_literal104)
            ;
            adaptor.addChild(root_0, char_literal104_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1116:1: relationDeclaration[boolean defer] : lhsToken= ID relationToken= pairingType rhsToken= ID ;
    public final EugeneParser.relationDeclaration_return relationDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.relationDeclaration_return retval = new EugeneParser.relationDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token lhsToken=null;
        Token rhsToken=null;
        EugeneParser.pairingType_return relationToken =null;


        Object lhsToken_tree=null;
        Object rhsToken_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1117:2: (lhsToken= ID relationToken= pairingType rhsToken= ID )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1117:4: lhsToken= ID relationToken= pairingType rhsToken= ID
            {
            root_0 = (Object)adaptor.nil();


            lhsToken=(Token)match(input,ID,FOLLOW_ID_in_relationDeclaration1610); 
            lhsToken_tree = 
            (Object)adaptor.create(lhsToken)
            ;
            adaptor.addChild(root_0, lhsToken_tree);


            pushFollow(FOLLOW_pairingType_in_relationDeclaration1614);
            relationToken=pairingType();

            state._fsp--;

            adaptor.addChild(root_0, relationToken.getTree());

            rhsToken=(Token)match(input,ID,FOLLOW_ID_in_relationDeclaration1618); 
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
        catch (EugeneException e) {

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


    public static class pairingType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pairingType"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1130:1: pairingType : ( 'REPRESSES' | 'INDUCES' | 'DRIVES' | 'BINDS' | 'ORTHO' | 'MATCHES' );
    public final EugeneParser.pairingType_return pairingType() throws RecognitionException {
        EugeneParser.pairingType_return retval = new EugeneParser.pairingType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set105=null;

        Object set105_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1131:2: ( 'REPRESSES' | 'INDUCES' | 'DRIVES' | 'BINDS' | 'ORTHO' | 'MATCHES' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:
            {
            root_0 = (Object)adaptor.nil();


            set105=(Token)input.LT(1);

            if ( input.LA(1)==43||input.LA(1)==46||input.LA(1)==55||input.LA(1)==59||input.LA(1)==69||input.LA(1)==73 ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set105)
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
    // $ANTLR end "pairingType"


    public static class assertStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assertStatement"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1144:1: assertStatement[boolean defer] : assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' ;
    public final EugeneParser.assertStatement_return assertStatement(boolean defer) throws RecognitionException {
        EugeneParser.assertStatement_return retval = new EugeneParser.assertStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token assertToken=null;
        Token char_literal106=null;
        Token string_literal107=null;
        Token char_literal108=null;
        Token char_literal109=null;
        EugeneParser.expression_return deviceToken =null;

        EugeneParser.listOfIDs_return lstRules =null;


        Object assertToken_tree=null;
        Object char_literal106_tree=null;
        Object string_literal107_tree=null;
        Object char_literal108_tree=null;
        Object char_literal109_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1145:2: (assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1145:4: assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            assertToken=(Token)match(input,41,FOLLOW_41_in_assertStatement1683); 
            assertToken_tree = 
            (Object)adaptor.create(assertToken)
            ;
            adaptor.addChild(root_0, assertToken_tree);


            char_literal106=(Token)match(input,20,FOLLOW_20_in_assertStatement1685); 
            char_literal106_tree = 
            (Object)adaptor.create(char_literal106)
            ;
            adaptor.addChild(root_0, char_literal106_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1145:29: ( 'ON' deviceToken= expression[defer] ':' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==67) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1145:30: 'ON' deviceToken= expression[defer] ':'
                    {
                    string_literal107=(Token)match(input,67,FOLLOW_67_in_assertStatement1688); 
                    string_literal107_tree = 
                    (Object)adaptor.create(string_literal107)
                    ;
                    adaptor.addChild(root_0, string_literal107_tree);


                    pushFollow(FOLLOW_expression_in_assertStatement1692);
                    deviceToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    char_literal108=(Token)match(input,31,FOLLOW_31_in_assertStatement1695); 
                    char_literal108_tree = 
                    (Object)adaptor.create(char_literal108)
                    ;
                    adaptor.addChild(root_0, char_literal108_tree);


                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1145:79: (lstRules= listOfIDs[defer] )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1145:79: lstRules= listOfIDs[defer]
                    {
                    pushFollow(FOLLOW_listOfIDs_in_assertStatement1701);
                    lstRules=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstRules.getTree());

                    }
                    break;

            }


            char_literal109=(Token)match(input,21,FOLLOW_21_in_assertStatement1705); 
            char_literal109_tree = 
            (Object)adaptor.create(char_literal109)
            ;
            adaptor.addChild(root_0, char_literal109_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1166:1: noteStatement[boolean defer] : noteToken= 'Note' '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')' ;
    public final EugeneParser.noteStatement_return noteStatement(boolean defer) throws RecognitionException {
        EugeneParser.noteStatement_return retval = new EugeneParser.noteStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token noteToken=null;
        Token char_literal110=null;
        Token char_literal111=null;
        EugeneParser.onDevice_return deviceToken =null;

        EugeneParser.expression_return exprToken =null;


        Object noteToken_tree=null;
        Object char_literal110_tree=null;
        Object char_literal111_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1167:2: (noteToken= 'Note' '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1167:4: noteToken= 'Note' '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')'
            {
            root_0 = (Object)adaptor.nil();


            noteToken=(Token)match(input,66,FOLLOW_66_in_noteStatement1738); 
            noteToken_tree = 
            (Object)adaptor.create(noteToken)
            ;
            adaptor.addChild(root_0, noteToken_tree);


            char_literal110=(Token)match(input,20,FOLLOW_20_in_noteStatement1740); 
            char_literal110_tree = 
            (Object)adaptor.create(char_literal110)
            ;
            adaptor.addChild(root_0, char_literal110_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1168:4: (deviceToken= onDevice[defer] )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==67) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1168:5: deviceToken= onDevice[defer]
                    {
                    pushFollow(FOLLOW_onDevice_in_noteStatement1748);
                    deviceToken=onDevice(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_noteStatement1759);
            exprToken=expression(true);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {    
                Rule rule = interp.createRule("NOTE-RULE", 
                        (deviceToken!=null?deviceToken.device:null), 
                        exprToken.start, 
                        (CommonTree)(exprToken!=null?((Object)exprToken.tree):null));    
                if(!RuleEngine.evaluateIfRule(rule)) {
                    System.err.println("RULE VIOLATION! "+rule);
                }
            }
                    

            char_literal111=(Token)match(input,21,FOLLOW_21_in_noteStatement1764); 
            char_literal111_tree = 
            (Object)adaptor.create(char_literal111)
            ;
            adaptor.addChild(root_0, char_literal111_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1198:1: instantiationStatement[boolean defer] returns [Component objComponent] : typeToken= ID instanceToken= instanceDefinitionStatement[defer, objElement] ;
    public final EugeneParser.instantiationStatement_return instantiationStatement(boolean defer) throws RecognitionException {
        EugeneParser.instantiationStatement_return retval = new EugeneParser.instantiationStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token typeToken=null;
        EugeneParser.instanceDefinitionStatement_return instanceToken =null;


        Object typeToken_tree=null;


        NamedElement objElement = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1202:2: (typeToken= ID instanceToken= instanceDefinitionStatement[defer, objElement] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1202:4: typeToken= ID instanceToken= instanceDefinitionStatement[defer, objElement]
            {
            root_0 = (Object)adaptor.nil();


            typeToken=(Token)match(input,ID,FOLLOW_ID_in_instantiationStatement1801); 
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
            	

            pushFollow(FOLLOW_instanceDefinitionStatement_in_instantiationStatement1809);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1229:1: instanceDefinitionStatement[boolean defer, NamedElement objElement] returns [Component objComponent] : (partToken= partInstantiation[defer, objElement] |deviceToken= deviceInstantiation[defer, objElement] );
    public final EugeneParser.instanceDefinitionStatement_return instanceDefinitionStatement(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.instanceDefinitionStatement_return retval = new EugeneParser.instanceDefinitionStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.partInstantiation_return partToken =null;

        EugeneParser.deviceInstantiation_return deviceToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1231:2: (partToken= partInstantiation[defer, objElement] |deviceToken= deviceInstantiation[defer, objElement] )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==ID) ) {
                int LA33_1 = input.LA(2);

                if ( ((objElement instanceof PartType)) ) {
                    alt33=1;
                }
                else if ( (true) ) {
                    alt33=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA33_0==DYNAMIC_NAME) ) {
                alt33=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1231:4: partToken= partInstantiation[defer, objElement]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partInstantiation_in_instanceDefinitionStatement1833);
                    partToken=partInstantiation(defer, objElement);

                    state._fsp--;

                    adaptor.addChild(root_0, partToken.getTree());


                    if(!defer) {
                        retval.objComponent = (partToken!=null?partToken.objPart:null);
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1236:11: deviceToken= deviceInstantiation[defer, objElement]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceInstantiation_in_instanceDefinitionStatement1850);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1243:1: dynamicNaming[boolean defer] returns [String sName] : (nameToken= ID | DYNAMIC_NAME exprToken= expression[defer] DYNAMIC_NAME );
    public final EugeneParser.dynamicNaming_return dynamicNaming(boolean defer) throws RecognitionException {
        EugeneParser.dynamicNaming_return retval = new EugeneParser.dynamicNaming_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token DYNAMIC_NAME112=null;
        Token DYNAMIC_NAME113=null;
        EugeneParser.expression_return exprToken =null;


        Object nameToken_tree=null;
        Object DYNAMIC_NAME112_tree=null;
        Object DYNAMIC_NAME113_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1245:2: (nameToken= ID | DYNAMIC_NAME exprToken= expression[defer] DYNAMIC_NAME )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==ID) ) {
                alt34=1;
            }
            else if ( (LA34_0==DYNAMIC_NAME) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }
            switch (alt34) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1245:4: nameToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_dynamicNaming1874); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1250:4: DYNAMIC_NAME exprToken= expression[defer] DYNAMIC_NAME
                    {
                    root_0 = (Object)adaptor.nil();


                    DYNAMIC_NAME112=(Token)match(input,DYNAMIC_NAME,FOLLOW_DYNAMIC_NAME_in_dynamicNaming1881); 
                    DYNAMIC_NAME112_tree = 
                    (Object)adaptor.create(DYNAMIC_NAME112)
                    ;
                    adaptor.addChild(root_0, DYNAMIC_NAME112_tree);


                    pushFollow(FOLLOW_expression_in_dynamicNaming1885);
                    exprToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken.getTree());

                    DYNAMIC_NAME113=(Token)match(input,DYNAMIC_NAME,FOLLOW_DYNAMIC_NAME_in_dynamicNaming1888); 
                    DYNAMIC_NAME113_tree = 
                    (Object)adaptor.create(DYNAMIC_NAME113)
                    ;
                    adaptor.addChild(root_0, DYNAMIC_NAME113_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1269:1: partInstantiation[boolean defer, NamedElement objElement] returns [Part objPart] :{...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] ) ;
    public final EugeneParser.partInstantiation_return partInstantiation(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.partInstantiation_return retval = new EugeneParser.partInstantiation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal114=null;
        Token char_literal115=null;
        EugeneParser.dynamicNaming_return nameToken =null;

        EugeneParser.listOfDotValues_return dotToken =null;

        EugeneParser.listOfValues_return valueToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object char_literal114_tree=null;
        Object char_literal115_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1271:2: ({...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1271:4: {...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] )
            {
            root_0 = (Object)adaptor.nil();


            if ( !((objElement instanceof PartType)) ) {
                throw new FailedPredicateException(input, "partInstantiation", "objElement instanceof PartType");
            }

            pushFollow(FOLLOW_dynamicNaming_in_partInstantiation1918);
            nameToken=dynamicNaming(defer);

            state._fsp--;

            adaptor.addChild(root_0, nameToken.getTree());

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1272:34: ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0 >= 20 && LA37_0 <= 21)||LA37_0==24||LA37_0==32) ) {
                alt37=1;
            }
            else if ( (LA37_0==23||LA37_0==25||LA37_0==35) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1272:35: ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1272:35: ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==20) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1272:36: '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')'
                            {
                            char_literal114=(Token)match(input,20,FOLLOW_20_in_partInstantiation1923); 
                            char_literal114_tree = 
                            (Object)adaptor.create(char_literal114)
                            ;
                            adaptor.addChild(root_0, char_literal114_tree);


                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1272:40: (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )?
                            int alt35=3;
                            int LA35_0 = input.LA(1);

                            if ( (LA35_0==26) ) {
                                alt35=1;
                            }
                            else if ( (LA35_0==FLOAT||LA35_0==ID||LA35_0==INT||LA35_0==STRING||LA35_0==18||LA35_0==20||LA35_0==25||(LA35_0 >= 33 && LA35_0 <= 34)||(LA35_0 >= 36 && LA35_0 <= 39)||(LA35_0 >= 42 && LA35_0 <= 44)||LA35_0==46||(LA35_0 >= 49 && LA35_0 <= 53)||LA35_0==55||(LA35_0 >= 58 && LA35_0 <= 65)||LA35_0==69||LA35_0==73||(LA35_0 >= 77 && LA35_0 <= 79)||LA35_0==81||LA35_0==89||LA35_0==112) ) {
                                alt35=2;
                            }
                            switch (alt35) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1272:41: dotToken= listOfDotValues[defer]
                                    {
                                    pushFollow(FOLLOW_listOfDotValues_in_partInstantiation1928);
                                    dotToken=listOfDotValues(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, dotToken.getTree());

                                    }
                                    break;
                                case 2 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1272:75: valueToken= listOfValues[defer]
                                    {
                                    pushFollow(FOLLOW_listOfValues_in_partInstantiation1935);
                                    valueToken=listOfValues(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, valueToken.getTree());

                                    }
                                    break;

                            }


                            char_literal115=(Token)match(input,21,FOLLOW_21_in_partInstantiation1940); 
                            char_literal115_tree = 
                            (Object)adaptor.create(char_literal115)
                            ;
                            adaptor.addChild(root_0, char_literal115_tree);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1273:6: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_partInstantiation1952);
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
        catch (EugeneException exc) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1308:1: deviceInstantiation[boolean defer, NamedElement objElement] returns [DeviceInstance objDeviceInstance] : instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? ;
    public final EugeneParser.deviceInstantiation_return deviceInstantiation(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.deviceInstantiation_return retval = new EugeneParser.deviceInstantiation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token instToken=null;
        Token char_literal116=null;
        Token char_literal117=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object instToken_tree=null;
        Object char_literal116_tree=null;
        Object char_literal117_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1309:2: (instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1309:4: instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )?
            {
            root_0 = (Object)adaptor.nil();


            instToken=(Token)match(input,ID,FOLLOW_ID_in_deviceInstantiation1985); 
            instToken_tree = 
            (Object)adaptor.create(instToken)
            ;
            adaptor.addChild(root_0, instToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1309:17: ( '(' (lstToken= listOfIDs[defer] )? ')' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==20) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1309:18: '(' (lstToken= listOfIDs[defer] )? ')'
                    {
                    char_literal116=(Token)match(input,20,FOLLOW_20_in_deviceInstantiation1988); 
                    char_literal116_tree = 
                    (Object)adaptor.create(char_literal116)
                    ;
                    adaptor.addChild(root_0, char_literal116_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1309:22: (lstToken= listOfIDs[defer] )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==ID) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1309:23: lstToken= listOfIDs[defer]
                            {
                            pushFollow(FOLLOW_listOfIDs_in_deviceInstantiation1993);
                            lstToken=listOfIDs(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, lstToken.getTree());

                            }
                            break;

                    }


                    char_literal117=(Token)match(input,21,FOLLOW_21_in_deviceInstantiation1998); 
                    char_literal117_tree = 
                    (Object)adaptor.create(char_literal117)
                    ;
                    adaptor.addChild(root_0, char_literal117_tree);


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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1376:1: listOfDotValues[boolean defer] returns [List<PropertyValue> lstValues] : '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )? ;
    public final EugeneParser.listOfDotValues_return listOfDotValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfDotValues_return retval = new EugeneParser.listOfDotValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token char_literal118=null;
        Token char_literal119=null;
        Token char_literal120=null;
        Token char_literal121=null;
        EugeneParser.expression_return valueToken =null;

        EugeneParser.listOfDotValues_return dotValuesToken =null;


        Object nameToken_tree=null;
        Object char_literal118_tree=null;
        Object char_literal119_tree=null;
        Object char_literal120_tree=null;
        Object char_literal121_tree=null;


        retval.lstValues = new ArrayList<PropertyValue>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1381:2: ( '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1381:4: '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            char_literal118=(Token)match(input,26,FOLLOW_26_in_listOfDotValues2036); 
            char_literal118_tree = 
            (Object)adaptor.create(char_literal118)
            ;
            adaptor.addChild(root_0, char_literal118_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfDotValues2040); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            char_literal119=(Token)match(input,20,FOLLOW_20_in_listOfDotValues2042); 
            char_literal119_tree = 
            (Object)adaptor.create(char_literal119)
            ;
            adaptor.addChild(root_0, char_literal119_tree);


            pushFollow(FOLLOW_expression_in_listOfDotValues2046);
            valueToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, valueToken.getTree());

            char_literal120=(Token)match(input,21,FOLLOW_21_in_listOfDotValues2049); 
            char_literal120_tree = 
            (Object)adaptor.create(char_literal120)
            ;
            adaptor.addChild(root_0, char_literal120_tree);



            if(!defer) {
                retval.lstValues.add(
                    interp.createPropertyValue(
                            (nameToken!=null?nameToken.getText():null), (valueToken!=null?valueToken.objElement:null)));
            }
                    

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1387:12: ( ',' dotValuesToken= listOfDotValues[defer] )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==24) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1387:13: ',' dotValuesToken= listOfDotValues[defer]
                    {
                    char_literal121=(Token)match(input,24,FOLLOW_24_in_listOfDotValues2055); 
                    char_literal121_tree = 
                    (Object)adaptor.create(char_literal121)
                    ;
                    adaptor.addChild(root_0, char_literal121_tree);


                    pushFollow(FOLLOW_listOfDotValues_in_listOfDotValues2059);
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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1403:1: listOfValues[boolean defer] returns [List<NamedElement> lstValues] : exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )? ;
    public final EugeneParser.listOfValues_return listOfValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfValues_return retval = new EugeneParser.listOfValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal122=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfValues_return lstToken =null;


        Object char_literal122_tree=null;


        retval.lstValues = new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1408:2: (exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1408:4: exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfValues2100);
            exprToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {
                retval.lstValues.add((exprToken!=null?exprToken.objElement:null));
            }
                    

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1412:11: ( ',' lstToken= listOfValues[defer] )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==24) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1412:12: ',' lstToken= listOfValues[defer]
                    {
                    char_literal122=(Token)match(input,24,FOLLOW_24_in_listOfValues2106); 
                    char_literal122_tree = 
                    (Object)adaptor.create(char_literal122)
                    ;
                    adaptor.addChild(root_0, char_literal122_tree);


                    pushFollow(FOLLOW_listOfValues_in_listOfValues2110);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1423:1: listOfExpressions[boolean defer] returns [ArrayList<NamedElement> lstElements] : exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )? ;
    public final EugeneParser.listOfExpressions_return listOfExpressions(boolean defer) throws RecognitionException {
        EugeneParser.listOfExpressions_return retval = new EugeneParser.listOfExpressions_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal123=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfExpressions_return lstToken =null;


        Object char_literal123_tree=null;


        retval.lstElements = new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1427:2: (exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1427:4: exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfExpressions2142);
            exprToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {
                retval.lstElements.add((exprToken!=null?exprToken.objElement:null));
            }	
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1431:5: ( ',' lstToken= listOfExpressions[defer] )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==24) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1431:6: ',' lstToken= listOfExpressions[defer]
                    {
                    char_literal123=(Token)match(input,24,FOLLOW_24_in_listOfExpressions2149); 
                    char_literal123_tree = 
                    (Object)adaptor.create(char_literal123)
                    ;
                    adaptor.addChild(root_0, char_literal123_tree);


                    pushFollow(FOLLOW_listOfExpressions_in_listOfExpressions2153);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1440:1: expression[boolean defer] returns [NamedElement objElement] : notToken= notExpression[defer] ;
    public final EugeneParser.expression_return expression(boolean defer) throws RecognitionException {
        EugeneParser.expression_return retval = new EugeneParser.expression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.notExpression_return notToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1442:6: (notToken= notExpression[defer] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1442:11: notToken= notExpression[defer]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_notExpression_in_expression2187);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1449:1: notExpression[boolean defer] returns [NamedElement objElement] : (notToken= 'NOT' exprToken= orExpression[defer] -> ^( 'NOT' $exprToken) |exprToken= orExpression[defer] -> $exprToken);
    public final EugeneParser.notExpression_return notExpression(boolean defer) throws RecognitionException {
        EugeneParser.notExpression_return retval = new EugeneParser.notExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token notToken=null;
        EugeneParser.orExpression_return exprToken =null;


        Object notToken_tree=null;
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_orExpression=new RewriteRuleSubtreeStream(adaptor,"rule orExpression");

        boolean bNOT=false;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1454:2: (notToken= 'NOT' exprToken= orExpression[defer] -> ^( 'NOT' $exprToken) |exprToken= orExpression[defer] -> $exprToken)
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==62) ) {
                alt43=1;
            }
            else if ( (LA43_0==FLOAT||LA43_0==ID||LA43_0==INT||LA43_0==STRING||LA43_0==18||LA43_0==20||LA43_0==25||(LA43_0 >= 33 && LA43_0 <= 34)||(LA43_0 >= 36 && LA43_0 <= 39)||(LA43_0 >= 42 && LA43_0 <= 44)||LA43_0==46||(LA43_0 >= 49 && LA43_0 <= 53)||LA43_0==55||(LA43_0 >= 58 && LA43_0 <= 61)||(LA43_0 >= 63 && LA43_0 <= 65)||LA43_0==69||LA43_0==73||(LA43_0 >= 77 && LA43_0 <= 79)||LA43_0==81||LA43_0==89||LA43_0==112) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1454:4: notToken= 'NOT' exprToken= orExpression[defer]
                    {
                    notToken=(Token)match(input,62,FOLLOW_62_in_notExpression2224);  
                    stream_62.add(notToken);


                    pushFollow(FOLLOW_orExpression_in_notExpression2228);
                    exprToken=orExpression(defer);

                    state._fsp--;

                    stream_orExpression.add(exprToken.getTree());


                    if(!defer) {
                        retval.objElement = interp.not((exprToken!=null?exprToken.objElement:null));
                    }
                    	

                    // AST REWRITE
                    // elements: 62, exprToken
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1458:4: -> ^( 'NOT' $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:7: ^( 'NOT' $exprToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_62.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_exprToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1459:11: exprToken= orExpression[defer]
                    {
                    pushFollow(FOLLOW_orExpression_in_notExpression2254);
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
                    // 1463:11: -> $exprToken
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1466:1: orExpression[boolean defer] returns [NamedElement objElement] : (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )? ;
    public final EugeneParser.orExpression_return orExpression(boolean defer) throws RecognitionException {
        EugeneParser.orExpression_return retval = new EugeneParser.orExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal124=null;
        Token string_literal125=null;
        EugeneParser.andExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal124_tree=null;
        Object string_literal125_tree=null;
        RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleSubtreeStream stream_andExpression=new RewriteRuleSubtreeStream(adaptor,"rule andExpression");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1467:2: ( (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1467:4: (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1467:4: (leftToken= andExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1467:5: leftToken= andExpression[defer]
            {
            pushFollow(FOLLOW_andExpression_in_orExpression2282);
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
            // 1467:36: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1468:4: ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==68) ) {
                alt45=1;
            }
            else if ( (LA45_0==116) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1468:5: ( ( 'OR' | '||' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1468:5: ( ( 'OR' | '||' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1468:6: ( 'OR' | '||' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1468:6: ( 'OR' | '||' )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==68) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==116) ) {
                        alt44=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;

                    }
                    switch (alt44) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1468:7: 'OR'
                            {
                            string_literal124=(Token)match(input,68,FOLLOW_68_in_orExpression2298);  
                            stream_68.add(string_literal124);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1468:12: '||'
                            {
                            string_literal125=(Token)match(input,116,FOLLOW_116_in_orExpression2300);  
                            stream_116.add(string_literal125);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_orExpression2305);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: leftToken, rightToken, 68
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
                    // 1469:4: -> ^( 'OR' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1469:7: ^( 'OR' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_68.nextNode()
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

                e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1487:1: andExpression[boolean defer] returns [NamedElement objElement] : (leftToken= xorExpression[defer] -> $leftToken) ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )? ;
    public final EugeneParser.andExpression_return andExpression(boolean defer) throws RecognitionException {
        EugeneParser.andExpression_return retval = new EugeneParser.andExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal126=null;
        Token string_literal127=null;
        EugeneParser.xorExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal126_tree=null;
        Object string_literal127_tree=null;
        RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        RewriteRuleSubtreeStream stream_xorExpression=new RewriteRuleSubtreeStream(adaptor,"rule xorExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1488:2: ( (leftToken= xorExpression[defer] -> $leftToken) ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1488:4: (leftToken= xorExpression[defer] -> $leftToken) ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1488:4: (leftToken= xorExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1488:5: leftToken= xorExpression[defer]
            {
            pushFollow(FOLLOW_xorExpression_in_andExpression2354);
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
            // 1488:36: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1489:4: ( ( ( 'AND' | '&&' ) rightToken= notExpression[defer] ) -> ^( 'AND' $leftToken $rightToken) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==40) ) {
                alt47=1;
            }
            else if ( (LA47_0==19) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1489:5: ( ( 'AND' | '&&' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1489:5: ( ( 'AND' | '&&' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1489:6: ( 'AND' | '&&' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1489:6: ( 'AND' | '&&' )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==40) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==19) ) {
                        alt46=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;

                    }
                    switch (alt46) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1489:7: 'AND'
                            {
                            string_literal126=(Token)match(input,40,FOLLOW_40_in_andExpression2370);  
                            stream_40.add(string_literal126);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1489:13: '&&'
                            {
                            string_literal127=(Token)match(input,19,FOLLOW_19_in_andExpression2372);  
                            stream_19.add(string_literal127);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_andExpression2377);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: leftToken, 40, rightToken
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
                    // 1490:4: -> ^( 'AND' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1490:7: ^( 'AND' $leftToken $rightToken)
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

                e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1508:1: xorExpression[boolean defer] returns [NamedElement objElement] : (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )? ;
    public final EugeneParser.xorExpression_return xorExpression(boolean defer) throws RecognitionException {
        EugeneParser.xorExpression_return retval = new EugeneParser.xorExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal128=null;
        Token string_literal129=null;
        EugeneParser.comparativeExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal128_tree=null;
        Object string_literal129_tree=null;
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        RewriteRuleSubtreeStream stream_comparativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule comparativeExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1509:2: ( (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1509:4: (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1509:4: (leftToken= comparativeExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1509:5: leftToken= comparativeExpression[defer]
            {
            pushFollow(FOLLOW_comparativeExpression_in_xorExpression2427);
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
            // 1509:44: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1510:4: ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==80||LA49_0==83) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1510:5: ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1510:5: ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1510:6: ( 'XOR' | '^^' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1510:6: ( 'XOR' | '^^' )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==80) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==83) ) {
                        alt48=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;

                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1510:7: 'XOR'
                            {
                            string_literal128=(Token)match(input,80,FOLLOW_80_in_xorExpression2443);  
                            stream_80.add(string_literal128);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1510:13: '^^'
                            {
                            string_literal129=(Token)match(input,83,FOLLOW_83_in_xorExpression2445);  
                            stream_83.add(string_literal129);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_xorExpression2450);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: 80, leftToken, rightToken
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
                    // 1511:4: -> ^( 'XOR' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1511:7: ^( 'XOR' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_80.nextNode()
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

                e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1529:1: operator returns [String sOperator] : (relToken= relationalOperator |ruleToken= ruleOperator |pairToken= pairingType );
    public final EugeneParser.operator_return operator() throws RecognitionException {
        EugeneParser.operator_return retval = new EugeneParser.operator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.relationalOperator_return relToken =null;

        EugeneParser.ruleOperator_return ruleToken =null;

        EugeneParser.pairingType_return pairToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1530:2: (relToken= relationalOperator |ruleToken= ruleOperator |pairToken= pairingType )
            int alt50=3;
            switch ( input.LA(1) ) {
            case 18:
            case 33:
            case 34:
            case 36:
            case 37:
            case 38:
            case 50:
            case 63:
                {
                alt50=1;
                }
                break;
            case 39:
            case 42:
            case 44:
            case 49:
            case 51:
            case 58:
            case 60:
            case 61:
            case 64:
            case 65:
            case 77:
            case 78:
            case 79:
                {
                alt50=2;
                }
                break;
            case 43:
            case 46:
            case 55:
            case 59:
            case 69:
            case 73:
                {
                alt50=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1530:4: relToken= relationalOperator
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_relationalOperator_in_operator2496);
                    relToken=relationalOperator();

                    state._fsp--;

                    adaptor.addChild(root_0, relToken.getTree());


                    retval.sOperator = (relToken!=null?relToken.sOperator:null);
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1533:4: ruleToken= ruleOperator
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ruleOperator_in_operator2506);
                    ruleToken=ruleOperator();

                    state._fsp--;

                    adaptor.addChild(root_0, ruleToken.getTree());


                    retval.sOperator = (ruleToken!=null?ruleToken.sOperator:null);
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1536:4: pairToken= pairingType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_pairingType_in_operator2516);
                    pairToken=pairingType();

                    state._fsp--;

                    adaptor.addChild(root_0, pairToken.getTree());


                    retval.sOperator = (pairToken!=null?input.toString(pairToken.start,pairToken.stop):null);	
                    	

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1541:1: ruleOperator returns [String sOperator] : ( 'BEFORE' | 'AFTER' | 'STARTSWITH' | 'ENDSWITH' | 'NOTWITH' | 'WITH' | 'NEXTTO' | 'LEFTTO' | 'CONTAINS' | 'MORETHAN' | 'NOTMORETHAN' | 'THEN' | 'EXACTLY' );
    public final EugeneParser.ruleOperator_return ruleOperator() throws RecognitionException {
        EugeneParser.ruleOperator_return retval = new EugeneParser.ruleOperator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal130=null;
        Token string_literal131=null;
        Token string_literal132=null;
        Token string_literal133=null;
        Token string_literal134=null;
        Token string_literal135=null;
        Token string_literal136=null;
        Token string_literal137=null;
        Token string_literal138=null;
        Token string_literal139=null;
        Token string_literal140=null;
        Token string_literal141=null;
        Token string_literal142=null;

        Object string_literal130_tree=null;
        Object string_literal131_tree=null;
        Object string_literal132_tree=null;
        Object string_literal133_tree=null;
        Object string_literal134_tree=null;
        Object string_literal135_tree=null;
        Object string_literal136_tree=null;
        Object string_literal137_tree=null;
        Object string_literal138_tree=null;
        Object string_literal139_tree=null;
        Object string_literal140_tree=null;
        Object string_literal141_tree=null;
        Object string_literal142_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1542:2: ( 'BEFORE' | 'AFTER' | 'STARTSWITH' | 'ENDSWITH' | 'NOTWITH' | 'WITH' | 'NEXTTO' | 'LEFTTO' | 'CONTAINS' | 'MORETHAN' | 'NOTMORETHAN' | 'THEN' | 'EXACTLY' )
            int alt51=13;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt51=1;
                }
                break;
            case 39:
                {
                alt51=2;
                }
                break;
            case 77:
                {
                alt51=3;
                }
                break;
            case 49:
                {
                alt51=4;
                }
                break;
            case 65:
                {
                alt51=5;
                }
                break;
            case 79:
                {
                alt51=6;
                }
                break;
            case 61:
                {
                alt51=7;
                }
                break;
            case 58:
                {
                alt51=8;
                }
                break;
            case 44:
                {
                alt51=9;
                }
                break;
            case 60:
                {
                alt51=10;
                }
                break;
            case 64:
                {
                alt51=11;
                }
                break;
            case 78:
                {
                alt51=12;
                }
                break;
            case 51:
                {
                alt51=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1542:4: 'BEFORE'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal130=(Token)match(input,42,FOLLOW_42_in_ruleOperator2534); 
                    string_literal130_tree = 
                    (Object)adaptor.create(string_literal130)
                    ;
                    adaptor.addChild(root_0, string_literal130_tree);



                    retval.sOperator = EugeneConstants.BEFORE;


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1545:4: 'AFTER'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal131=(Token)match(input,39,FOLLOW_39_in_ruleOperator2541); 
                    string_literal131_tree = 
                    (Object)adaptor.create(string_literal131)
                    ;
                    adaptor.addChild(root_0, string_literal131_tree);



                    retval.sOperator = EugeneConstants.AFTER;


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1548:4: 'STARTSWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal132=(Token)match(input,77,FOLLOW_77_in_ruleOperator2548); 
                    string_literal132_tree = 
                    (Object)adaptor.create(string_literal132)
                    ;
                    adaptor.addChild(root_0, string_literal132_tree);



                    retval.sOperator = EugeneConstants.STARTSWITH;


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1551:4: 'ENDSWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal133=(Token)match(input,49,FOLLOW_49_in_ruleOperator2555); 
                    string_literal133_tree = 
                    (Object)adaptor.create(string_literal133)
                    ;
                    adaptor.addChild(root_0, string_literal133_tree);



                    retval.sOperator = EugeneConstants.ENDSWITH;


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1554:4: 'NOTWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal134=(Token)match(input,65,FOLLOW_65_in_ruleOperator2562); 
                    string_literal134_tree = 
                    (Object)adaptor.create(string_literal134)
                    ;
                    adaptor.addChild(root_0, string_literal134_tree);



                    retval.sOperator = EugeneConstants.NOTWITH;


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1557:4: 'WITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal135=(Token)match(input,79,FOLLOW_79_in_ruleOperator2569); 
                    string_literal135_tree = 
                    (Object)adaptor.create(string_literal135)
                    ;
                    adaptor.addChild(root_0, string_literal135_tree);



                    retval.sOperator = EugeneConstants.WITH;


                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1560:4: 'NEXTTO'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal136=(Token)match(input,61,FOLLOW_61_in_ruleOperator2576); 
                    string_literal136_tree = 
                    (Object)adaptor.create(string_literal136)
                    ;
                    adaptor.addChild(root_0, string_literal136_tree);



                    retval.sOperator = EugeneConstants.NEXTTO;


                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1563:4: 'LEFTTO'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal137=(Token)match(input,58,FOLLOW_58_in_ruleOperator2583); 
                    string_literal137_tree = 
                    (Object)adaptor.create(string_literal137)
                    ;
                    adaptor.addChild(root_0, string_literal137_tree);



                    retval.sOperator = EugeneConstants.LEFTTO;


                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1566:4: 'CONTAINS'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal138=(Token)match(input,44,FOLLOW_44_in_ruleOperator2590); 
                    string_literal138_tree = 
                    (Object)adaptor.create(string_literal138)
                    ;
                    adaptor.addChild(root_0, string_literal138_tree);



                    retval.sOperator = EugeneConstants.CONTAINS;


                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1569:4: 'MORETHAN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal139=(Token)match(input,60,FOLLOW_60_in_ruleOperator2597); 
                    string_literal139_tree = 
                    (Object)adaptor.create(string_literal139)
                    ;
                    adaptor.addChild(root_0, string_literal139_tree);



                    retval.sOperator = EugeneConstants.MORETHAN;


                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1572:4: 'NOTMORETHAN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal140=(Token)match(input,64,FOLLOW_64_in_ruleOperator2604); 
                    string_literal140_tree = 
                    (Object)adaptor.create(string_literal140)
                    ;
                    adaptor.addChild(root_0, string_literal140_tree);



                    retval.sOperator = EugeneConstants.NOTMORETHAN;


                    }
                    break;
                case 12 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1575:4: 'THEN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal141=(Token)match(input,78,FOLLOW_78_in_ruleOperator2611); 
                    string_literal141_tree = 
                    (Object)adaptor.create(string_literal141)
                    ;
                    adaptor.addChild(root_0, string_literal141_tree);



                    retval.sOperator = EugeneConstants.THEN;


                    }
                    break;
                case 13 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1578:4: 'EXACTLY'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal142=(Token)match(input,51,FOLLOW_51_in_ruleOperator2619); 
                    string_literal142_tree = 
                    (Object)adaptor.create(string_literal142)
                    ;
                    adaptor.addChild(root_0, string_literal142_tree);



                    retval.sOperator = EugeneConstants.EXACTLY;


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1583:1: relationalOperator returns [String sOperator] : ( ( '==' | 'EQUALS' ) | ( '!=' | 'NOTEQUALS' ) | '<' | '<=' | '>' | '>=' );
    public final EugeneParser.relationalOperator_return relationalOperator() throws RecognitionException {
        EugeneParser.relationalOperator_return retval = new EugeneParser.relationalOperator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set143=null;
        Token set144=null;
        Token char_literal145=null;
        Token string_literal146=null;
        Token char_literal147=null;
        Token string_literal148=null;

        Object set143_tree=null;
        Object set144_tree=null;
        Object char_literal145_tree=null;
        Object string_literal146_tree=null;
        Object char_literal147_tree=null;
        Object string_literal148_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1584:2: ( ( '==' | 'EQUALS' ) | ( '!=' | 'NOTEQUALS' ) | '<' | '<=' | '>' | '>=' )
            int alt52=6;
            switch ( input.LA(1) ) {
            case 36:
            case 50:
                {
                alt52=1;
                }
                break;
            case 18:
            case 63:
                {
                alt52=2;
                }
                break;
            case 33:
                {
                alt52=3;
                }
                break;
            case 34:
                {
                alt52=4;
                }
                break;
            case 37:
                {
                alt52=5;
                }
                break;
            case 38:
                {
                alt52=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }

            switch (alt52) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1584:4: ( '==' | 'EQUALS' )
                    {
                    root_0 = (Object)adaptor.nil();


                    set143=(Token)input.LT(1);

                    if ( input.LA(1)==36||input.LA(1)==50 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set143)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1587:4: ( '!=' | 'NOTEQUALS' )
                    {
                    root_0 = (Object)adaptor.nil();


                    set144=(Token)input.LT(1);

                    if ( input.LA(1)==18||input.LA(1)==63 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set144)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1590:4: '<'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal145=(Token)match(input,33,FOLLOW_33_in_relationalOperator2663); 
                    char_literal145_tree = 
                    (Object)adaptor.create(char_literal145)
                    ;
                    adaptor.addChild(root_0, char_literal145_tree);



                    retval.sOperator =EugeneConstants.LT;	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1593:4: '<='
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal146=(Token)match(input,34,FOLLOW_34_in_relationalOperator2671); 
                    string_literal146_tree = 
                    (Object)adaptor.create(string_literal146)
                    ;
                    adaptor.addChild(root_0, string_literal146_tree);



                    retval.sOperator =EugeneConstants.LEQ;	
                    	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1596:4: '>'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal147=(Token)match(input,37,FOLLOW_37_in_relationalOperator2678); 
                    char_literal147_tree = 
                    (Object)adaptor.create(char_literal147)
                    ;
                    adaptor.addChild(root_0, char_literal147_tree);



                    retval.sOperator =EugeneConstants.GT;	
                    	

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1599:4: '>='
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal148=(Token)match(input,38,FOLLOW_38_in_relationalOperator2686); 
                    string_literal148_tree = 
                    (Object)adaptor.create(string_literal148)
                    ;
                    adaptor.addChild(root_0, string_literal148_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1604:1: comparativeExpression[boolean defer] returns [NamedElement objElement] : ( (folToken= folExpression[defer] ) -> $folToken)? ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) ) ;
    public final EugeneParser.comparativeExpression_return comparativeExpression(boolean defer) throws RecognitionException {
        EugeneParser.comparativeExpression_return retval = new EugeneParser.comparativeExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal149=null;
        Token string_literal150=null;
        EugeneParser.folExpression_return folToken =null;

        EugeneParser.addExpression_return exprToken1 =null;

        EugeneParser.operator_return oToken =null;

        EugeneParser.comparativeExpression_return exprToken2 =null;

        EugeneParser.type_return typeToken =null;

        EugeneParser.operator_return opToken =null;

        EugeneParser.addExpression_return exprToken =null;


        Object string_literal149_tree=null;
        Object string_literal150_tree=null;
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleSubtreeStream stream_folExpression=new RewriteRuleSubtreeStream(adaptor,"rule folExpression");
        RewriteRuleSubtreeStream stream_addExpression=new RewriteRuleSubtreeStream(adaptor,"rule addExpression");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        RewriteRuleSubtreeStream stream_comparativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule comparativeExpression");
        RewriteRuleSubtreeStream stream_operator=new RewriteRuleSubtreeStream(adaptor,"rule operator");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1606:2: ( ( (folToken= folExpression[defer] ) -> $folToken)? ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1607:2: ( (folToken= folExpression[defer] ) -> $folToken)? ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) )
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1607:2: ( (folToken= folExpression[defer] ) -> $folToken)?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0 >= 52 && LA53_0 <= 53)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1607:3: (folToken= folExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1607:3: (folToken= folExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1607:4: folToken= folExpression[defer]
                    {
                    pushFollow(FOLLOW_folExpression_in_comparativeExpression2713);
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
                    // 1607:36: -> $folToken
                    {
                        adaptor.addChild(root_0, stream_folToken.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1609:2: ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==FLOAT||LA56_0==ID||LA56_0==INT||LA56_0==STRING||LA56_0==20||LA56_0==25||LA56_0==81||LA56_0==89||LA56_0==112) ) {
                alt56=1;
            }
            else if ( (LA56_0==18||(LA56_0 >= 33 && LA56_0 <= 34)||(LA56_0 >= 36 && LA56_0 <= 39)||(LA56_0 >= 42 && LA56_0 <= 44)||LA56_0==46||(LA56_0 >= 49 && LA56_0 <= 51)||LA56_0==55||(LA56_0 >= 58 && LA56_0 <= 61)||(LA56_0 >= 63 && LA56_0 <= 65)||LA56_0==69||LA56_0==73||(LA56_0 >= 77 && LA56_0 <= 79)) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }
            switch (alt56) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1610:2: (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1610:2: (exprToken1= addExpression[defer] -> $exprToken1)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1611:3: exprToken1= addExpression[defer]
                    {
                    pushFollow(FOLLOW_addExpression_in_comparativeExpression2738);
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
                    // 1615:3: -> $exprToken1
                    {
                        adaptor.addChild(root_0, stream_exprToken1.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1617:2: (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )?
                    int alt55=3;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==18||(LA55_0 >= 33 && LA55_0 <= 34)||(LA55_0 >= 36 && LA55_0 <= 39)||(LA55_0 >= 42 && LA55_0 <= 44)||LA55_0==46||(LA55_0 >= 49 && LA55_0 <= 51)||LA55_0==55||(LA55_0 >= 58 && LA55_0 <= 61)||(LA55_0 >= 63 && LA55_0 <= 65)||LA55_0==69||LA55_0==73||(LA55_0 >= 77 && LA55_0 <= 79)) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==56||LA55_0==96) ) {
                        alt55=2;
                    }
                    switch (alt55) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1617:4: oToken= operator exprToken2= comparativeExpression[defer]
                            {
                            pushFollow(FOLLOW_operator_in_comparativeExpression2758);
                            oToken=operator();

                            state._fsp--;

                            stream_operator.add(oToken.getTree());

                            pushFollow(FOLLOW_comparativeExpression_in_comparativeExpression2762);
                            exprToken2=comparativeExpression(defer);

                            state._fsp--;

                            stream_comparativeExpression.add(exprToken2.getTree());


                            if(!defer) {
                                retval.objElement = interp.compare((exprToken1!=null?exprToken1.objElement:null), (oToken!=null?input.toString(oToken.start,oToken.stop):null), (exprToken2!=null?exprToken2.objElement:null));
                            }


                            // AST REWRITE
                            // elements: exprToken1, oToken, exprToken2
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
                            // 1621:3: -> ^( $oToken $exprToken1 $exprToken2)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1621:6: ^( $oToken $exprToken1 $exprToken2)
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
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1622:5: ( 'INSTANCEOF' | 'instanceof' ) typeToken= type
                            {
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1622:5: ( 'INSTANCEOF' | 'instanceof' )
                            int alt54=2;
                            int LA54_0 = input.LA(1);

                            if ( (LA54_0==56) ) {
                                alt54=1;
                            }
                            else if ( (LA54_0==96) ) {
                                alt54=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 54, 0, input);

                                throw nvae;

                            }
                            switch (alt54) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1622:6: 'INSTANCEOF'
                                    {
                                    string_literal149=(Token)match(input,56,FOLLOW_56_in_comparativeExpression2785);  
                                    stream_56.add(string_literal149);


                                    }
                                    break;
                                case 2 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1622:19: 'instanceof'
                                    {
                                    string_literal150=(Token)match(input,96,FOLLOW_96_in_comparativeExpression2787);  
                                    stream_96.add(string_literal150);


                                    }
                                    break;

                            }


                            pushFollow(FOLLOW_type_in_comparativeExpression2792);
                            typeToken=type();

                            state._fsp--;

                            stream_type.add(typeToken.getTree());


                            if(!defer) {
                                retval.objElement = EugeneBuilder.buildVariable(
                                    String.valueOf(interp.isInstanceOf((exprToken1!=null?exprToken1.objElement:null), (typeToken!=null?input.toString(typeToken.start,typeToken.stop):null))));
                            }	


                            // AST REWRITE
                            // elements: typeToken, 56
                            // token labels: 
                            // rule labels: typeToken, retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_typeToken=new RewriteRuleSubtreeStream(adaptor,"rule typeToken",typeToken!=null?typeToken.tree:null);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 1627:3: -> ^( 'INSTANCEOF' $typeToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1627:6: ^( 'INSTANCEOF' $typeToken)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot(
                                stream_56.nextNode()
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1629:7: opToken= operator exprToken= addExpression[defer]
                    {
                    pushFollow(FOLLOW_operator_in_comparativeExpression2816);
                    opToken=operator();

                    state._fsp--;

                    stream_operator.add(opToken.getTree());

                    pushFollow(FOLLOW_addExpression_in_comparativeExpression2820);
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
                    // 1630:5: -> ^( $opToken $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1630:8: ^( $opToken $exprToken)
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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1640:1: addExpression[boolean defer] returns [NamedElement objElement] : (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )? ;
    public final EugeneParser.addExpression_return addExpression(boolean defer) throws RecognitionException {
        EugeneParser.addExpression_return retval = new EugeneParser.addExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token opToken=null;
        EugeneParser.subtractExpression_return leftToken =null;

        EugeneParser.addExpression_return rightToken =null;


        Object opToken_tree=null;
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleSubtreeStream stream_addExpression=new RewriteRuleSubtreeStream(adaptor,"rule addExpression");
        RewriteRuleSubtreeStream stream_subtractExpression=new RewriteRuleSubtreeStream(adaptor,"rule subtractExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1642:2: ( (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1642:4: (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1642:4: (leftToken= subtractExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1642:5: leftToken= subtractExpression[defer]
            {
            pushFollow(FOLLOW_subtractExpression_in_addExpression2869);
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
            // 1642:42: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1643:4: (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==23) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1643:5: opToken= '+' rightToken= addExpression[defer]
                    {
                    opToken=(Token)match(input,23,FOLLOW_23_in_addExpression2885);  
                    stream_23.add(opToken);


                    pushFollow(FOLLOW_addExpression_in_addExpression2889);
                    rightToken=addExpression(defer);

                    state._fsp--;

                    stream_addExpression.add(rightToken.getTree());

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
                    // 1644:5: -> ^( '+' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1644:8: ^( '+' $leftToken $rightToken)
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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1661:1: subtractExpression[boolean defer] returns [NamedElement objElement] : (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )? ;
    public final EugeneParser.subtractExpression_return subtractExpression(boolean defer) throws RecognitionException {
        EugeneParser.subtractExpression_return retval = new EugeneParser.subtractExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token opToken=null;
        EugeneParser.multiplicativeExpression_return leftToken =null;

        EugeneParser.subtractExpression_return rightToken =null;


        Object opToken_tree=null;
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
        RewriteRuleSubtreeStream stream_subtractExpression=new RewriteRuleSubtreeStream(adaptor,"rule subtractExpression");
        RewriteRuleSubtreeStream stream_multiplicativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule multiplicativeExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1663:2: ( (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1663:4: (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1663:4: (leftToken= multiplicativeExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1663:5: leftToken= multiplicativeExpression[defer]
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_subtractExpression2937);
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
            // 1663:47: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1664:4: (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==25) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1664:5: opToken= '-' rightToken= subtractExpression[defer]
                    {
                    opToken=(Token)match(input,25,FOLLOW_25_in_subtractExpression2952);  
                    stream_25.add(opToken);


                    pushFollow(FOLLOW_subtractExpression_in_subtractExpression2956);
                    rightToken=subtractExpression(defer);

                    state._fsp--;

                    stream_subtractExpression.add(rightToken.getTree());

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
                    // 1665:4: -> ^( '-' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1665:7: ^( '-' $leftToken $rightToken)
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1683:1: multiplicativeExpression[boolean defer] returns [NamedElement objElement] : (leftToken= expressionValue[defer] -> $leftToken) ( (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) ) | (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) ) )? ;
    public final EugeneParser.multiplicativeExpression_return multiplicativeExpression(boolean defer) throws RecognitionException {
        EugeneParser.multiplicativeExpression_return retval = new EugeneParser.multiplicativeExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token opToken=null;
        EugeneParser.expressionValue_return leftToken =null;

        EugeneParser.multiplicativeExpression_return rightToken =null;


        Object opToken_tree=null;
        RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleSubtreeStream stream_expressionValue=new RewriteRuleSubtreeStream(adaptor,"rule expressionValue");
        RewriteRuleSubtreeStream stream_multiplicativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule multiplicativeExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1685:6: ( (leftToken= expressionValue[defer] -> $leftToken) ( (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) ) | (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) ) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1685:11: (leftToken= expressionValue[defer] -> $leftToken) ( (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) ) | (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) ) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1685:11: (leftToken= expressionValue[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1685:12: leftToken= expressionValue[defer]
            {
            pushFollow(FOLLOW_expressionValue_in_multiplicativeExpression3007);
            leftToken=expressionValue(defer);

            state._fsp--;

            stream_expressionValue.add(leftToken.getTree());


            if(!defer) {
                retval.objElement = (leftToken!=null?leftToken.objElement:null);
            }    	
                	

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
            // 1689:8: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1690:6: ( (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) ) | (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) ) )?
            int alt59=3;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==22) ) {
                alt59=1;
            }
            else if ( (LA59_0==30) ) {
                alt59=2;
            }
            switch (alt59) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1691:8: (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1691:8: (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1691:9: opToken= '*' rightToken= multiplicativeExpression[defer]
                    {
                    opToken=(Token)match(input,22,FOLLOW_22_in_multiplicativeExpression3035);  
                    stream_22.add(opToken);


                    pushFollow(FOLLOW_multiplicativeExpression_in_multiplicativeExpression3039);
                    rightToken=multiplicativeExpression(defer);

                    state._fsp--;

                    stream_multiplicativeExpression.add(rightToken.getTree());


                    if(!defer) {
                        if(null==rightToken) {
                            retval.objElement =(leftToken!=null?leftToken.objElement:null);
                        } else {
                            retval.objElement =interp.multiply((leftToken!=null?leftToken.objElement:null),(rightToken!=null?rightToken.objElement:null));	
                        }
                    }
                    	

                    // AST REWRITE
                    // elements: 22, rightToken, leftToken
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
                    // 1699:4: -> ^( '*' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1699:7: ^( '*' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_22.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_leftToken.nextTree());

                        adaptor.addChild(root_1, stream_rightToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1700:5: (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1700:5: (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1700:6: opToken= '/' rightToken= multiplicativeExpression[defer]
                    {
                    opToken=(Token)match(input,30,FOLLOW_30_in_multiplicativeExpression3064);  
                    stream_30.add(opToken);


                    pushFollow(FOLLOW_multiplicativeExpression_in_multiplicativeExpression3068);
                    rightToken=multiplicativeExpression(defer);

                    state._fsp--;

                    stream_multiplicativeExpression.add(rightToken.getTree());


                    if(!defer) {
                        if(null==rightToken) {
                            retval.objElement =(leftToken!=null?leftToken.objElement:null);
                        } else {
                            retval.objElement =interp.divide((leftToken!=null?leftToken.objElement:null),(rightToken!=null?rightToken.objElement:null));	
                        }
                    }
                    	

                    // AST REWRITE
                    // elements: rightToken, leftToken, 30
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
                    // 1708:4: -> ^( '/' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1708:7: ^( '/' $leftToken $rightToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_30.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_leftToken.nextTree());

                        adaptor.addChild(root_1, stream_rightToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

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
    // $ANTLR end "multiplicativeExpression"


    public static class expressionValue_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressionValue"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1715:1: expressionValue[boolean defer] returns [NamedElement objElement] : ( (minToken= '-' )? numToken= ( INT | FLOAT ) |txtToken= STRING |boolToken= ( 'true' | 'false' ) | (accessToken= objectAccessStatement[defer] -> $accessToken) | '(' exprToken= expression[defer] ')' -> ^( '(' $exprToken) | '[' lstToken= listOfExpressions[defer] ']' -> ^( '[' $lstToken) );
    public final EugeneParser.expressionValue_return expressionValue(boolean defer) throws RecognitionException {
        EugeneParser.expressionValue_return retval = new EugeneParser.expressionValue_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token minToken=null;
        Token numToken=null;
        Token txtToken=null;
        Token boolToken=null;
        Token char_literal151=null;
        Token char_literal152=null;
        Token char_literal153=null;
        Token char_literal154=null;
        EugeneParser.objectAccessStatement_return accessToken =null;

        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfExpressions_return lstToken =null;


        Object minToken_tree=null;
        Object numToken_tree=null;
        Object txtToken_tree=null;
        Object boolToken_tree=null;
        Object char_literal151_tree=null;
        Object char_literal152_tree=null;
        Object char_literal153_tree=null;
        Object char_literal154_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_objectAccessStatement=new RewriteRuleSubtreeStream(adaptor,"rule objectAccessStatement");
        RewriteRuleSubtreeStream stream_listOfExpressions=new RewriteRuleSubtreeStream(adaptor,"rule listOfExpressions");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1716:2: ( (minToken= '-' )? numToken= ( INT | FLOAT ) |txtToken= STRING |boolToken= ( 'true' | 'false' ) | (accessToken= objectAccessStatement[defer] -> $accessToken) | '(' exprToken= expression[defer] ')' -> ^( '(' $exprToken) | '[' lstToken= listOfExpressions[defer] ']' -> ^( '[' $lstToken) )
            int alt61=6;
            switch ( input.LA(1) ) {
            case FLOAT:
            case INT:
            case 25:
                {
                alt61=1;
                }
                break;
            case STRING:
                {
                alt61=2;
                }
                break;
            case 89:
            case 112:
                {
                alt61=3;
                }
                break;
            case ID:
                {
                alt61=4;
                }
                break;
            case 20:
                {
                alt61=5;
                }
                break;
            case 81:
                {
                alt61=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }

            switch (alt61) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1716:4: (minToken= '-' )? numToken= ( INT | FLOAT )
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1716:4: (minToken= '-' )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==25) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1716:5: minToken= '-'
                            {
                            minToken=(Token)match(input,25,FOLLOW_25_in_expressionValue3112); 
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
                        Variable objValue=new Variable(EugeneConstants.NUM, EugeneConstants.NUM);
                        objValue.setNum(new Double((numToken!=null?numToken.getText():null)).doubleValue());
                        if(minToken!=null) {
                            objValue.setNum(objValue.getNum() * (-1));
                        }
                        retval.objElement =objValue;
                    }
                            

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1726:4: txtToken= STRING
                    {
                    root_0 = (Object)adaptor.nil();


                    txtToken=(Token)match(input,STRING,FOLLOW_STRING_in_expressionValue3132); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1733:4: boolToken= ( 'true' | 'false' )
                    {
                    root_0 = (Object)adaptor.nil();


                    boolToken=(Token)input.LT(1);

                    if ( input.LA(1)==89||input.LA(1)==112 ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1740:11: (accessToken= objectAccessStatement[defer] -> $accessToken)
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1740:11: (accessToken= objectAccessStatement[defer] -> $accessToken)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1740:12: accessToken= objectAccessStatement[defer]
                    {
                    pushFollow(FOLLOW_objectAccessStatement_in_expressionValue3166);
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
                    // 1744:4: -> $accessToken
                    {
                        adaptor.addChild(root_0, stream_accessToken.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1745:4: '(' exprToken= expression[defer] ')'
                    {
                    char_literal151=(Token)match(input,20,FOLLOW_20_in_expressionValue3180);  
                    stream_20.add(char_literal151);


                    pushFollow(FOLLOW_expression_in_expressionValue3184);
                    exprToken=expression(defer);

                    state._fsp--;

                    stream_expression.add(exprToken.getTree());

                    char_literal152=(Token)match(input,21,FOLLOW_21_in_expressionValue3187);  
                    stream_21.add(char_literal152);



                    if(!defer){
                        retval.objElement = (exprToken!=null?exprToken.objElement:null);
                    }
                            

                    // AST REWRITE
                    // elements: exprToken, 20
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1749:15: -> ^( '(' $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1749:18: ^( '(' $exprToken)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1750:4: '[' lstToken= listOfExpressions[defer] ']'
                    {
                    char_literal153=(Token)match(input,81,FOLLOW_81_in_expressionValue3211);  
                    stream_81.add(char_literal153);


                    pushFollow(FOLLOW_listOfExpressions_in_expressionValue3215);
                    lstToken=listOfExpressions(defer);

                    state._fsp--;

                    stream_listOfExpressions.add(lstToken.getTree());

                    char_literal154=(Token)match(input,82,FOLLOW_82_in_expressionValue3218);  
                    stream_82.add(char_literal154);



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
                    // elements: lstToken, 81
                    // token labels: 
                    // rule labels: retval, lstToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_lstToken=new RewriteRuleSubtreeStream(adaptor,"rule lstToken",lstToken!=null?lstToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1870:11: -> ^( '[' $lstToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1870:14: ^( '[' $lstToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_81.nextNode()
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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1879:1: objectAccessStatement[boolean defer] returns [NamedElement objElement] : (idToken= ID -> $idToken) (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1881:2: ( (idToken= ID -> $idToken) (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1881:4: (idToken= ID -> $idToken) (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1881:4: (idToken= ID -> $idToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1881:5: idToken= ID
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_objectAccessStatement3256);  
            stream_ID.add(idToken);



            if(!defer) {
                retval.objElement = interp.get((idToken!=null?idToken.getText():null));
                
                if(retval.objElement==null) {
                    throw new EugeneException( "I don't know anything about "+(idToken!=null?idToken.getText():null)+"!");
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
            // 1889:4: -> $idToken
            {
                adaptor.addChild(root_0, stream_idToken.nextNode());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1890:3: (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==26||LA62_0==81) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1890:4: accessToken= objectAccess[defer, $objElement]
                    {
                    pushFollow(FOLLOW_objectAccess_in_objectAccessStatement3272);
                    accessToken=objectAccess(defer, retval.objElement);

                    state._fsp--;

                    stream_objectAccess.add(accessToken.getTree());


                    if(!defer) {
                        retval.objElement = (accessToken!=null?accessToken.objReturnElement:null);
                    }	
                    	

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
                    // 1894:4: -> ^( $idToken $accessToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1894:7: ^( $idToken $accessToken)
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
        catch (EugeneException e) {

            System.err.println("line"+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+e.toString());
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
        public NamedElement objReturnElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "objectAccess"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1902:1: objectAccess[boolean defer, NamedElement objElement] returns [NamedElement objReturnElement] : ( (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )? | (dotToken= dotAccess[defer, $objElement] -> $dotToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )? );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1904:2: ( (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )? | (dotToken= dotAccess[defer, $objElement] -> $dotToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )? )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==81) ) {
                alt65=1;
            }
            else if ( (LA65_0==26) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }
            switch (alt65) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1904:4: (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1904:4: (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1904:5: arrayToken= arrayAccess[defer, $objElement]
                    {
                    pushFollow(FOLLOW_arrayAccess_in_objectAccess3313);
                    arrayToken=arrayAccess(defer, objElement);

                    state._fsp--;

                    stream_arrayAccess.add(arrayToken.getTree());


                    if(!defer) {
                        objElement = (arrayToken!=null?arrayToken.objReturnElement:null);
                    }	
                    	

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
                    // 1908:4: -> $arrayToken
                    {
                        adaptor.addChild(root_0, stream_arrayToken.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1909:4: (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==26||LA63_0==81) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1909:5: accessToken= access[defer, $objElement]
                            {
                            pushFollow(FOLLOW_access_in_objectAccess3331);
                            accessToken=access(defer, objElement);

                            state._fsp--;

                            stream_access.add(accessToken.getTree());


                            if(!defer) {
                                objElement = (accessToken!=null?accessToken.objReturnElement:null);
                            }				
                            	

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
                            // 1913:5: -> ^( $objectAccess $arrayToken $accessToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1913:8: ^( $objectAccess $arrayToken $accessToken)
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



                    if(!defer) {
                        retval.objReturnElement = objElement;
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1918:4: (dotToken= dotAccess[defer, $objElement] -> $dotToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1918:4: (dotToken= dotAccess[defer, $objElement] -> $dotToken)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1918:5: dotToken= dotAccess[defer, $objElement]
                    {
                    pushFollow(FOLLOW_dotAccess_in_objectAccess3361);
                    dotToken=dotAccess(defer, objElement);

                    state._fsp--;

                    stream_dotAccess.add(dotToken.getTree());


                    if(!defer) {
                        objElement = (dotToken!=null?dotToken.objReturnElement:null);
                    }	
                    	

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
                    // 1922:5: -> $dotToken
                    {
                        adaptor.addChild(root_0, stream_dotToken.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1923:4: (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==26||LA64_0==81) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1923:5: accessToken= access[defer, $objElement]
                            {
                            pushFollow(FOLLOW_access_in_objectAccess3381);
                            accessToken=access(defer, objElement);

                            state._fsp--;

                            stream_access.add(accessToken.getTree());


                            if(!defer) {
                                objElement = (accessToken!=null?accessToken.objReturnElement:null);
                            }				
                            	

                            // AST REWRITE
                            // elements: objectAccess, dotToken, accessToken
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
                            // 1927:4: -> ^( $objectAccess $dotToken $accessToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1927:7: ^( $objectAccess $dotToken $accessToken)
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



                    if(!defer) {
                        retval.objReturnElement = objElement;
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
        public NamedElement objReturnElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "access"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1934:1: access[boolean defer, NamedElement objElement] returns [NamedElement objReturnElement] : objectToken= objectAccess[defer, $objElement] ;
    public final EugeneParser.access_return access(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.access_return retval = new EugeneParser.access_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.objectAccess_return objectToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1936:2: (objectToken= objectAccess[defer, $objElement] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1936:4: objectToken= objectAccess[defer, $objElement]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_objectAccess_in_access3422);
            objectToken=objectAccess(defer, objElement);

            state._fsp--;

            adaptor.addChild(root_0, objectToken.getTree());


            if(!defer) {
                retval.objReturnElement = (objectToken!=null?objectToken.objReturnElement:null);
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
    // $ANTLR end "access"


    public static class arrayAccess_return extends ParserRuleReturnScope {
        public NamedElement objReturnElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arrayAccess"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1943:1: arrayAccess[boolean defer, NamedElement objElement] returns [NamedElement objReturnElement] : ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) ) ;
    public final EugeneParser.arrayAccess_return arrayAccess(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.arrayAccess_return retval = new EugeneParser.arrayAccess_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal155=null;
        Token char_literal156=null;
        EugeneParser.expression_return idxToken =null;


        Object char_literal155_tree=null;
        Object char_literal156_tree=null;
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1945:2: ( ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1945:4: ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) )
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1945:4: ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1945:5: '[' idxToken= expression[defer] ']'
            {
            char_literal155=(Token)match(input,81,FOLLOW_81_in_arrayAccess3446);  
            stream_81.add(char_literal155);


            pushFollow(FOLLOW_expression_in_arrayAccess3450);
            idxToken=expression(defer);

            state._fsp--;

            stream_expression.add(idxToken.getTree());

            char_literal156=(Token)match(input,82,FOLLOW_82_in_arrayAccess3453);  
            stream_82.add(char_literal156);



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
                
                retval.objReturnElement = interp.get(objElement, idx);    
            }	
            	

            // AST REWRITE
            // elements: idxToken, 81
            // token labels: 
            // rule labels: retval, idxToken
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_idxToken=new RewriteRuleSubtreeStream(adaptor,"rule idxToken",idxToken!=null?idxToken.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1977:4: -> ^( '[' $idxToken)
            {
                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1977:7: ^( '[' $idxToken)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_81.nextNode()
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
        catch (EugeneException e) {

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
        public NamedElement objReturnElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dotAccess"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1987:1: dotAccess[boolean defer, NamedElement objElement] returns [NamedElement objReturnElement] : ( ( '.' propertyToken= ID -> ^( '.' $propertyToken) ) | ( ( '.' 'size' ( '(' ')' )? ) -> ^( '.' 'size' ) ) | ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) ) | ( '.' seqToken= 'toSequence' ( '(' ')' )? -> ^( '.' 'toSequence' ) ) | ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' 'isEmpty' ) ) | ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) ) );
    public final EugeneParser.dotAccess_return dotAccess(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.dotAccess_return retval = new EugeneParser.dotAccess_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token propertyToken=null;
        Token getToken=null;
        Token seqToken=null;
        Token emptyToken=null;
        Token char_literal157=null;
        Token char_literal158=null;
        Token string_literal159=null;
        Token char_literal160=null;
        Token char_literal161=null;
        Token char_literal162=null;
        Token char_literal163=null;
        Token char_literal164=null;
        Token char_literal165=null;
        Token char_literal166=null;
        Token char_literal167=null;
        Token char_literal168=null;
        Token char_literal169=null;
        Token char_literal170=null;
        Token char_literal171=null;
        Token string_literal172=null;
        Token char_literal173=null;
        Token char_literal174=null;
        EugeneParser.expression_return exprToken =null;


        Object propertyToken_tree=null;
        Object getToken_tree=null;
        Object seqToken_tree=null;
        Object emptyToken_tree=null;
        Object char_literal157_tree=null;
        Object char_literal158_tree=null;
        Object string_literal159_tree=null;
        Object char_literal160_tree=null;
        Object char_literal161_tree=null;
        Object char_literal162_tree=null;
        Object char_literal163_tree=null;
        Object char_literal164_tree=null;
        Object char_literal165_tree=null;
        Object char_literal166_tree=null;
        Object char_literal167_tree=null;
        Object char_literal168_tree=null;
        Object char_literal169_tree=null;
        Object char_literal170_tree=null;
        Object char_literal171_tree=null;
        Object string_literal172_tree=null;
        Object char_literal173_tree=null;
        Object char_literal174_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1989:2: ( ( '.' propertyToken= ID -> ^( '.' $propertyToken) ) | ( ( '.' 'size' ( '(' ')' )? ) -> ^( '.' 'size' ) ) | ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) ) | ( '.' seqToken= 'toSequence' ( '(' ')' )? -> ^( '.' 'toSequence' ) ) | ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' 'isEmpty' ) ) | ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) ) )
            int alt70=6;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==26) ) {
                switch ( input.LA(2) ) {
                case ID:
                    {
                    alt70=1;
                    }
                    break;
                case 109:
                    {
                    alt70=2;
                    }
                    break;
                case 93:
                    {
                    alt70=3;
                    }
                    break;
                case 111:
                    {
                    alt70=4;
                    }
                    break;
                case 98:
                    {
                    alt70=5;
                    }
                    break;
                case 97:
                    {
                    alt70=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }
            switch (alt70) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1989:4: ( '.' propertyToken= ID -> ^( '.' $propertyToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1989:4: ( '.' propertyToken= ID -> ^( '.' $propertyToken) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1989:6: '.' propertyToken= ID
                    {
                    char_literal157=(Token)match(input,26,FOLLOW_26_in_dotAccess3491);  
                    stream_26.add(char_literal157);


                    propertyToken=(Token)match(input,ID,FOLLOW_ID_in_dotAccess3495);  
                    stream_ID.add(propertyToken);



                    if(!defer) {
                        retval.objReturnElement = interp.get(objElement, (propertyToken!=null?propertyToken.getText():null));
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
                    // 1993:4: -> ^( '.' $propertyToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1993:7: ^( '.' $propertyToken)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1994:4: ( ( '.' 'size' ( '(' ')' )? ) -> ^( '.' 'size' ) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1994:4: ( ( '.' 'size' ( '(' ')' )? ) -> ^( '.' 'size' ) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1994:5: ( '.' 'size' ( '(' ')' )? )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1994:5: ( '.' 'size' ( '(' ')' )? )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1994:6: '.' 'size' ( '(' ')' )?
                    {
                    char_literal158=(Token)match(input,26,FOLLOW_26_in_dotAccess3515);  
                    stream_26.add(char_literal158);


                    string_literal159=(Token)match(input,109,FOLLOW_109_in_dotAccess3517);  
                    stream_109.add(string_literal159);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1994:17: ( '(' ')' )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==20) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1994:18: '(' ')'
                            {
                            char_literal160=(Token)match(input,20,FOLLOW_20_in_dotAccess3520);  
                            stream_20.add(char_literal160);


                            char_literal161=(Token)match(input,21,FOLLOW_21_in_dotAccess3521);  
                            stream_21.add(char_literal161);


                            }
                            break;

                    }


                    }



                    if(!defer) {    
                        Variable objVariable = 
                            interp.createVariable((String)null, EugeneConstants.NUM);
                        objVariable.setNum(interp.sizeOf(objElement));   
                        retval.objReturnElement = objVariable; 
                    }	
                    	

                    // AST REWRITE
                    // elements: 109, 26
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 2001:4: -> ^( '.' 'size' )
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2001:7: ^( '.' 'size' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_109.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2002:4: ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2002:4: ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2002:5: '.' getToken= 'get' '(' exprToken= expression[defer] ')'
                    {
                    char_literal162=(Token)match(input,26,FOLLOW_26_in_dotAccess3541);  
                    stream_26.add(char_literal162);


                    getToken=(Token)match(input,93,FOLLOW_93_in_dotAccess3545);  
                    stream_93.add(getToken);


                    char_literal163=(Token)match(input,20,FOLLOW_20_in_dotAccess3547);  
                    stream_20.add(char_literal163);


                    pushFollow(FOLLOW_expression_in_dotAccess3551);
                    exprToken=expression(defer);

                    state._fsp--;

                    stream_expression.add(exprToken.getTree());

                    char_literal164=(Token)match(input,21,FOLLOW_21_in_dotAccess3554);  
                    stream_21.add(char_literal164);



                    if(!defer) {
                        retval.objReturnElement = interp.get(objElement, (exprToken!=null?exprToken.objElement:null));
                    }	
                    	

                    // AST REWRITE
                    // elements: 93, exprToken, 26
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 2006:4: -> ^( '.' 'get' $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2006:7: ^( '.' 'get' $exprToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_93.nextNode()
                        );

                        adaptor.addChild(root_1, stream_exprToken.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2007:4: ( '.' seqToken= 'toSequence' ( '(' ')' )? -> ^( '.' 'toSequence' ) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2007:4: ( '.' seqToken= 'toSequence' ( '(' ')' )? -> ^( '.' 'toSequence' ) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2007:5: '.' seqToken= 'toSequence' ( '(' ')' )?
                    {
                    char_literal165=(Token)match(input,26,FOLLOW_26_in_dotAccess3574);  
                    stream_26.add(char_literal165);


                    seqToken=(Token)match(input,111,FOLLOW_111_in_dotAccess3578);  
                    stream_111.add(seqToken);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2007:31: ( '(' ')' )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==20) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2007:32: '(' ')'
                            {
                            char_literal166=(Token)match(input,20,FOLLOW_20_in_dotAccess3581);  
                            stream_20.add(char_literal166);


                            char_literal167=(Token)match(input,21,FOLLOW_21_in_dotAccess3583);  
                            stream_21.add(char_literal167);


                            }
                            break;

                    }



                    if(!defer) {
                        Variable objVariable = new Variable("SEQUENCE",EugeneConstants.TXT);
                        objVariable.setTxt(interp.toSequence(objElement));
                        retval.objReturnElement = objVariable;
                    }
                    	

                    // AST REWRITE
                    // elements: 111, 26
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 2013:4: -> ^( '.' 'toSequence' )
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2013:7: ^( '.' 'toSequence' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_111.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2014:4: ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' 'isEmpty' ) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2014:4: ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' 'isEmpty' ) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2014:5: '.' emptyToken= 'isEmpty' ( '(' ')' )?
                    {
                    char_literal168=(Token)match(input,26,FOLLOW_26_in_dotAccess3602);  
                    stream_26.add(char_literal168);


                    emptyToken=(Token)match(input,98,FOLLOW_98_in_dotAccess3606);  
                    stream_98.add(emptyToken);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2014:30: ( '(' ')' )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==20) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2014:31: '(' ')'
                            {
                            char_literal169=(Token)match(input,20,FOLLOW_20_in_dotAccess3609);  
                            stream_20.add(char_literal169);


                            char_literal170=(Token)match(input,21,FOLLOW_21_in_dotAccess3611);  
                            stream_21.add(char_literal170);


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
                        retval.objReturnElement = objVariable;
                    }	
                    	

                    // AST REWRITE
                    // elements: 26, 98
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 2024:4: -> ^( '.' 'isEmpty' )
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2024:7: ^( '.' 'isEmpty' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_98.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2025:4: ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2025:4: ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2025:5: '.' 'instantiate' '(' (exprToken= expression[defer] )? ')'
                    {
                    char_literal171=(Token)match(input,26,FOLLOW_26_in_dotAccess3630);  
                    stream_26.add(char_literal171);


                    string_literal172=(Token)match(input,97,FOLLOW_97_in_dotAccess3632);  
                    stream_97.add(string_literal172);


                    char_literal173=(Token)match(input,20,FOLLOW_20_in_dotAccess3634);  
                    stream_20.add(char_literal173);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2025:27: (exprToken= expression[defer] )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==FLOAT||LA69_0==ID||LA69_0==INT||LA69_0==STRING||LA69_0==18||LA69_0==20||LA69_0==25||(LA69_0 >= 33 && LA69_0 <= 34)||(LA69_0 >= 36 && LA69_0 <= 39)||(LA69_0 >= 42 && LA69_0 <= 44)||LA69_0==46||(LA69_0 >= 49 && LA69_0 <= 53)||LA69_0==55||(LA69_0 >= 58 && LA69_0 <= 65)||LA69_0==69||LA69_0==73||(LA69_0 >= 77 && LA69_0 <= 79)||LA69_0==81||LA69_0==89||LA69_0==112) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2025:28: exprToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_dotAccess3639);
                            exprToken=expression(defer);

                            state._fsp--;

                            stream_expression.add(exprToken.getTree());

                            }
                            break;

                    }


                    char_literal174=(Token)match(input,21,FOLLOW_21_in_dotAccess3644);  
                    stream_21.add(char_literal174);



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
                    // elements: 97, 26, exprToken
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 2038:4: -> ^( '.' 'instantiate' ( $exprToken)? )
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2038:7: ^( '.' 'instantiate' ( $exprToken)? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_97.nextNode()
                        );

                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2038:28: ( $exprToken)?
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
        catch (EugeneException e) {

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


    public static class objectAssignmentStatement_return extends ParserRuleReturnScope {
        public NamedElement assignElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "objectAssignmentStatement"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2059:1: objectAssignmentStatement[boolean defer] returns [NamedElement assignElement] : ( (idToken= ID -> $idToken) ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )* ) rightToken= assignment[defer] ;
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
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");

        NamedElement objElement = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2064:2: ( ( (idToken= ID -> $idToken) ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )* ) rightToken= assignment[defer] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2064:4: ( (idToken= ID -> $idToken) ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )* ) rightToken= assignment[defer]
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2064:4: ( (idToken= ID -> $idToken) ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2064:5: (idToken= ID -> $idToken) ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )*
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2064:5: (idToken= ID -> $idToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2064:6: idToken= ID
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_objectAssignmentStatement3697);  
            stream_ID.add(idToken);


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
            // 2064:21: -> $idToken
            {
                adaptor.addChild(root_0, stream_idToken.nextNode());

            }


            retval.tree = root_0;

            }



            if(!defer) {
               objElement = interp.get((idToken!=null?idToken.getText():null)); 
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2069:2: ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )*
            loop71:
            do {
                int alt71=3;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==26) ) {
                    alt71=1;
                }
                else if ( (LA71_0==81) ) {
                    alt71=2;
                }


                switch (alt71) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2069:4: ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2069:4: ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2069:5: '.' subIdToken= ID
            	    {
            	    char_literal175=(Token)match(input,26,FOLLOW_26_in_objectAssignmentStatement3715);  
            	    stream_26.add(char_literal175);


            	    subIdToken=(Token)match(input,ID,FOLLOW_ID_in_objectAssignmentStatement3719);  
            	    stream_ID.add(subIdToken);



            	    if(!defer) {
            	        NamedElement objTempElement = interp.get(objElement, (subIdToken!=null?subIdToken.getText():null));
            	        if(objElement == null) {
            	            System.err.println("line "+(subIdToken!=null?subIdToken.getLine():0)+":"+(subIdToken!=null?subIdToken.getCharPositionInLine():0)+" => "+
            	                "The "+objElement.getName()+" element does not contain a "+(subIdToken!=null?subIdToken.getText():null)+" element!");
            	            this.cleanUp(1);
            	        } 
            	        objElement = objTempElement;
            	    }	
            	    	

            	    // AST REWRITE
            	    // elements: subIdToken, 26, objectAssignmentStatement
            	    // token labels: subIdToken
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_subIdToken=new RewriteRuleTokenStream(adaptor,"token subIdToken",subIdToken);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 2079:4: -> ^( '.' $objectAssignmentStatement $subIdToken)
            	    {
            	        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2079:7: ^( '.' $objectAssignmentStatement $subIdToken)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(
            	        stream_26.nextNode()
            	        , root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());

            	        adaptor.addChild(root_1, stream_subIdToken.nextNode());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }


            	    retval.tree = root_0;

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2080:5: ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2080:5: ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2080:6: '[' idxToken= expression[defer] ']'
            	    {
            	    char_literal176=(Token)match(input,81,FOLLOW_81_in_objectAssignmentStatement3741);  
            	    stream_81.add(char_literal176);



            	    if(!defer) {
            	        if(null==objElement) {
            	            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
            	                        "Invalid array access on "+(idToken!=null?idToken.getText():null));
            	            this.cleanUp(1);
            	        }
            	    }	
            	    	

            	    pushFollow(FOLLOW_expression_in_objectAssignmentStatement3747);
            	    idxToken=expression(defer);

            	    state._fsp--;

            	    stream_expression.add(idxToken.getTree());

            	    char_literal177=(Token)match(input,82,FOLLOW_82_in_objectAssignmentStatement3750);  
            	    stream_82.add(char_literal177);



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
            	    	

            	    // AST REWRITE
            	    // elements: objectAssignmentStatement, idxToken, 81
            	    // token labels: 
            	    // rule labels: retval, idxToken
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_idxToken=new RewriteRuleSubtreeStream(adaptor,"rule idxToken",idxToken!=null?idxToken.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 2104:4: -> ^( '[' $objectAssignmentStatement $idxToken)
            	    {
            	        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2104:7: ^( '[' $objectAssignmentStatement $idxToken)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(
            	        stream_81.nextNode()
            	        , root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());

            	        adaptor.addChild(root_1, stream_idxToken.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }


            	    retval.tree = root_0;

            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);


            }


            pushFollow(FOLLOW_assignment_in_objectAssignmentStatement3780);
            rightToken=assignment(defer);

            state._fsp--;

            stream_assignment.add(rightToken.getTree());


            if(!defer) {

                if("++".equals((rightToken!=null?input.toString(rightToken.start,rightToken.stop):null)) && objElement instanceof Variable) {
                    ((Variable)objElement).increase();
                } else if ("--".equals((rightToken!=null?input.toString(rightToken.start,rightToken.stop):null)) && objElement instanceof Variable) {
                    ((Variable)objElement).decrease();
                } else if (objElement == null) {
                    objElement = interp.clone((rightToken!=null?rightToken.objElement:null));
                    if(null == objElement) {
                        throw new EugeneException((idToken!=null?idToken.getText():null)+" has not been declared!");
                    }
                    objElement.setName((idToken!=null?idToken.getText():null));
                    SymbolTables.put(objElement);
                } else {

                    try {
                        interp.assign(objElement.getName(), (rightToken!=null?rightToken.objElement:null));
                        retval.assignElement = null;
                    } catch(EugeneException e) {
                        retval.assignElement = (rightToken!=null?rightToken.objElement:null);
                    }
                }
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2140:1: listOfStatements[boolean defer] returns [NamedElement objReturnValue] : (stmtToken= statement[defer] )+ ;
    public final EugeneParser.listOfStatements_return listOfStatements(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.listOfStatements_return retval = new EugeneParser.listOfStatements_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.statement_return stmtToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2142:2: ( (stmtToken= statement[defer] )+ )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2142:4: (stmtToken= statement[defer] )+
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2142:4: (stmtToken= statement[defer] )+
            int cnt72=0;
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( ((LA72_0 >= ID && LA72_0 <= INCLUDE)||LA72_0==32||LA72_0==41||LA72_0==45||(LA72_0 >= 47 && LA72_0 <= 48)||LA72_0==54||LA72_0==57||LA72_0==66||(LA72_0 >= 70 && LA72_0 <= 72)||(LA72_0 >= 74 && LA72_0 <= 76)||LA72_0==84||LA72_0==86||LA72_0==91||LA72_0==94||(LA72_0 >= 100 && LA72_0 <= 105)||(LA72_0 >= 107 && LA72_0 <= 108)||(LA72_0 >= 113 && LA72_0 <= 114)) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2142:5: stmtToken= statement[defer]
            	    {
            	    pushFollow(FOLLOW_statement_in_listOfStatements3815);
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
            	    if ( cnt72 >= 1 ) break loop72;
                        EarlyExitException eee =
                            new EarlyExitException(72, input);
                        throw eee;
                }
                cnt72++;
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2150:1: returnStatement[boolean defer] returns [NamedElement objReturnValue] : returnToken= 'return' (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )? ';' ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2154:2: (returnToken= 'return' (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )? ';' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2154:4: returnToken= 'return' (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )? ';'
            {
            root_0 = (Object)adaptor.nil();


            returnToken=(Token)match(input,107,FOLLOW_107_in_returnStatement3845); 
            returnToken_tree = 
            (Object)adaptor.create(returnToken)
            ;
            adaptor.addChild(root_0, returnToken_tree);



            if(!defer) {
            /*** TODO:
                StackElement se = SymbolTables.peek();
                if(null == se || !(se instanceof Function)) {
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
                ***/
            }	
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2179:2: (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )?
            int alt73=4;
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
                case 43:
                case 44:
                case 46:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 55:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 69:
                case 73:
                case 77:
                case 78:
                case 79:
                case 81:
                case 89:
                case 112:
                    {
                    alt73=1;
                    }
                    break;
                case ID:
                    {
                    switch ( input.LA(2) ) {
                        case 20:
                            {
                            alt73=2;
                            }
                            break;
                        case 26:
                            {
                            switch ( input.LA(3) ) {
                                case 93:
                                    {
                                    int LA73_7 = input.LA(4);

                                    if ( (LA73_7==20) ) {
                                        switch ( input.LA(5) ) {
                                            case INT:
                                                {
                                                int LA73_13 = input.LA(6);

                                                if ( ((LA73_13 >= 18 && LA73_13 <= 19)||(LA73_13 >= 21 && LA73_13 <= 23)||LA73_13==25||LA73_13==30||(LA73_13 >= 33 && LA73_13 <= 34)||(LA73_13 >= 36 && LA73_13 <= 40)||(LA73_13 >= 42 && LA73_13 <= 44)||LA73_13==46||(LA73_13 >= 49 && LA73_13 <= 51)||(LA73_13 >= 55 && LA73_13 <= 56)||(LA73_13 >= 58 && LA73_13 <= 61)||(LA73_13 >= 63 && LA73_13 <= 65)||(LA73_13 >= 68 && LA73_13 <= 69)||LA73_13==73||(LA73_13 >= 77 && LA73_13 <= 80)||LA73_13==83||LA73_13==96||LA73_13==116) ) {
                                                    alt73=1;
                                                }
                                                }
                                                break;
                                            case ID:
                                                {
                                                int LA73_14 = input.LA(6);

                                                if ( ((LA73_14 >= 18 && LA73_14 <= 19)||(LA73_14 >= 21 && LA73_14 <= 23)||(LA73_14 >= 25 && LA73_14 <= 26)||LA73_14==30||(LA73_14 >= 33 && LA73_14 <= 34)||(LA73_14 >= 36 && LA73_14 <= 40)||(LA73_14 >= 42 && LA73_14 <= 44)||LA73_14==46||(LA73_14 >= 49 && LA73_14 <= 51)||(LA73_14 >= 55 && LA73_14 <= 56)||(LA73_14 >= 58 && LA73_14 <= 61)||(LA73_14 >= 63 && LA73_14 <= 65)||(LA73_14 >= 68 && LA73_14 <= 69)||LA73_14==73||(LA73_14 >= 77 && LA73_14 <= 81)||LA73_14==83||LA73_14==96||LA73_14==116) ) {
                                                    alt73=1;
                                                }
                                                }
                                                break;
                                            case STRING:
                                                {
                                                int LA73_15 = input.LA(6);

                                                if ( ((LA73_15 >= 18 && LA73_15 <= 19)||(LA73_15 >= 21 && LA73_15 <= 23)||LA73_15==25||LA73_15==30||(LA73_15 >= 33 && LA73_15 <= 34)||(LA73_15 >= 36 && LA73_15 <= 40)||(LA73_15 >= 42 && LA73_15 <= 44)||LA73_15==46||(LA73_15 >= 49 && LA73_15 <= 51)||(LA73_15 >= 55 && LA73_15 <= 56)||(LA73_15 >= 58 && LA73_15 <= 61)||(LA73_15 >= 63 && LA73_15 <= 65)||(LA73_15 >= 68 && LA73_15 <= 69)||LA73_15==73||(LA73_15 >= 77 && LA73_15 <= 80)||LA73_15==83||LA73_15==96||LA73_15==116) ) {
                                                    alt73=1;
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
                                            case 43:
                                            case 44:
                                            case 46:
                                            case 49:
                                            case 50:
                                            case 51:
                                            case 52:
                                            case 53:
                                            case 55:
                                            case 58:
                                            case 59:
                                            case 60:
                                            case 61:
                                            case 62:
                                            case 63:
                                            case 64:
                                            case 65:
                                            case 69:
                                            case 73:
                                            case 77:
                                            case 78:
                                            case 79:
                                            case 81:
                                            case 89:
                                            case 112:
                                                {
                                                alt73=1;
                                                }
                                                break;
                                        }

                                    }
                                    }
                                    break;
                                case 109:
                                    {
                                    int LA73_8 = input.LA(4);

                                    if ( (LA73_8==20) ) {
                                        int LA73_11 = input.LA(5);

                                        if ( (LA73_11==21) ) {
                                            alt73=1;
                                        }
                                    }
                                    else if ( ((LA73_8 >= 18 && LA73_8 <= 19)||(LA73_8 >= 22 && LA73_8 <= 23)||(LA73_8 >= 25 && LA73_8 <= 26)||LA73_8==30||(LA73_8 >= 32 && LA73_8 <= 34)||(LA73_8 >= 36 && LA73_8 <= 40)||(LA73_8 >= 42 && LA73_8 <= 44)||LA73_8==46||(LA73_8 >= 49 && LA73_8 <= 51)||(LA73_8 >= 55 && LA73_8 <= 56)||(LA73_8 >= 58 && LA73_8 <= 61)||(LA73_8 >= 63 && LA73_8 <= 65)||(LA73_8 >= 68 && LA73_8 <= 69)||LA73_8==73||(LA73_8 >= 77 && LA73_8 <= 81)||LA73_8==83||LA73_8==96||LA73_8==116) ) {
                                        alt73=1;
                                    }
                                    }
                                    break;
                                case 85:
                                case 99:
                                case 106:
                                    {
                                    alt73=3;
                                    }
                                    break;
                                case 111:
                                    {
                                    int LA73_9 = input.LA(4);

                                    if ( (LA73_9==20) ) {
                                        int LA73_12 = input.LA(5);

                                        if ( (LA73_12==21) ) {
                                            alt73=1;
                                        }
                                    }
                                    else if ( ((LA73_9 >= 18 && LA73_9 <= 19)||(LA73_9 >= 22 && LA73_9 <= 23)||(LA73_9 >= 25 && LA73_9 <= 26)||LA73_9==30||(LA73_9 >= 32 && LA73_9 <= 34)||(LA73_9 >= 36 && LA73_9 <= 40)||(LA73_9 >= 42 && LA73_9 <= 44)||LA73_9==46||(LA73_9 >= 49 && LA73_9 <= 51)||(LA73_9 >= 55 && LA73_9 <= 56)||(LA73_9 >= 58 && LA73_9 <= 61)||(LA73_9 >= 63 && LA73_9 <= 65)||(LA73_9 >= 68 && LA73_9 <= 69)||LA73_9==73||(LA73_9 >= 77 && LA73_9 <= 81)||LA73_9==83||LA73_9==96||LA73_9==116) ) {
                                        alt73=1;
                                    }
                                    }
                                    break;
                                case ID:
                                case 97:
                                case 98:
                                    {
                                    alt73=1;
                                    }
                                    break;
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
                        case 43:
                        case 44:
                        case 46:
                        case 49:
                        case 50:
                        case 51:
                        case 55:
                        case 56:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 63:
                        case 64:
                        case 65:
                        case 68:
                        case 69:
                        case 73:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 83:
                        case 96:
                        case 116:
                            {
                            alt73=1;
                            }
                            break;
                        case 27:
                        case 28:
                        case 29:
                            {
                            alt73=3;
                            }
                            break;
                    }

                    }
                    break;
                case 54:
                case 76:
                case 101:
                case 105:
                    {
                    alt73=3;
                    }
                    break;
            }

            switch (alt73) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2179:4: exprToken= expression[defer]
                    {
                    pushFollow(FOLLOW_expression_in_returnStatement3855);
                    exprToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken.getTree());


                    if(!defer) {
                        retval.objReturnValue = (exprToken!=null?exprToken.objElement:null);
                    }
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2184:4: functionToken= functionCall[defer]
                    {
                    pushFollow(FOLLOW_functionCall_in_returnStatement3865);
                    functionToken=functionCall(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, functionToken.getTree());


                    if(!defer) {
                        retval.objReturnValue = (functionToken!=null?functionToken.objElement:null);
                    }
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2189:4: wrapperToken= wrappedStatement[defer]
                    {
                    pushFollow(FOLLOW_wrappedStatement_in_returnStatement3875);
                    wrapperToken=wrappedStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, wrapperToken.getTree());


                    if(!defer) {
                        retval.objReturnValue = (wrapperToken!=null?wrapperToken.objElement:null);
                    }	
                    	

                    }
                    break;

            }


            char_literal178=(Token)match(input,32,FOLLOW_32_in_returnStatement3882); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2199:1: saveStatement[boolean defer] : 'save' '(' listOfSaveObjects[defer] ')' ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2200:2: ( 'save' '(' listOfSaveObjects[defer] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2200:4: 'save' '(' listOfSaveObjects[defer] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal179=(Token)match(input,108,FOLLOW_108_in_saveStatement3899); 
            string_literal179_tree = 
            (Object)adaptor.create(string_literal179)
            ;
            adaptor.addChild(root_0, string_literal179_tree);


            char_literal180=(Token)match(input,20,FOLLOW_20_in_saveStatement3901); 
            char_literal180_tree = 
            (Object)adaptor.create(char_literal180)
            ;
            adaptor.addChild(root_0, char_literal180_tree);


            pushFollow(FOLLOW_listOfSaveObjects_in_saveStatement3903);
            listOfSaveObjects181=listOfSaveObjects(defer);

            state._fsp--;

            adaptor.addChild(root_0, listOfSaveObjects181.getTree());

            char_literal182=(Token)match(input,21,FOLLOW_21_in_saveStatement3906); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2203:1: listOfSaveObjects[boolean defer] : (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2204:2: ( (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2204:4: (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2204:4: (nameToken= ID ':' )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==ID) ) {
                int LA74_1 = input.LA(2);

                if ( (LA74_1==31) ) {
                    alt74=1;
                }
            }
            switch (alt74) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2204:5: nameToken= ID ':'
                    {
                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfSaveObjects3922); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    char_literal183=(Token)match(input,31,FOLLOW_31_in_listOfSaveObjects3924); 
                    char_literal183_tree = 
                    (Object)adaptor.create(char_literal183)
                    ;
                    adaptor.addChild(root_0, char_literal183_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_listOfSaveObjects3930);
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2212:4: ( ',' listOfSaveObjects[defer] )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==24) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2212:5: ',' listOfSaveObjects[defer]
                    {
                    char_literal184=(Token)match(input,24,FOLLOW_24_in_listOfSaveObjects3936); 
                    char_literal184_tree = 
                    (Object)adaptor.create(char_literal184)
                    ;
                    adaptor.addChild(root_0, char_literal184_tree);


                    pushFollow(FOLLOW_listOfSaveObjects_in_listOfSaveObjects3938);
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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2225:1: ifStatement[boolean defer] : 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2232:2: ( 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2232:4: 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal186=(Token)match(input,94,FOLLOW_94_in_ifStatement3978); 
            string_literal186_tree = 
            (Object)adaptor.create(string_literal186)
            ;
            adaptor.addChild(root_0, string_literal186_tree);


            char_literal187=(Token)match(input,20,FOLLOW_20_in_ifStatement3980); 
            char_literal187_tree = 
            (Object)adaptor.create(char_literal187)
            ;
            adaptor.addChild(root_0, char_literal187_tree);


            pushFollow(FOLLOW_ifCondition_in_ifStatement3984);
            ifConditionToken=ifCondition(true);

            state._fsp--;

            adaptor.addChild(root_0, ifConditionToken.getTree());

            char_literal188=(Token)match(input,21,FOLLOW_21_in_ifStatement3987); 
            char_literal188_tree = 
            (Object)adaptor.create(char_literal188)
            ;
            adaptor.addChild(root_0, char_literal188_tree);


            char_literal189=(Token)match(input,115,FOLLOW_115_in_ifStatement3989); 
            char_literal189_tree = 
            (Object)adaptor.create(char_literal189)
            ;
            adaptor.addChild(root_0, char_literal189_tree);


            pushFollow(FOLLOW_listOfStatements_in_ifStatement3993);
            thenStmtToken=listOfStatements(true);

            state._fsp--;

            adaptor.addChild(root_0, thenStmtToken.getTree());

            char_literal190=(Token)match(input,117,FOLLOW_117_in_ifStatement3996); 
            char_literal190_tree = 
            (Object)adaptor.create(char_literal190)
            ;
            adaptor.addChild(root_0, char_literal190_tree);



            if(!defer) {
               objIfBranch = new ConditionalBranch((ifConditionToken!=null?((Token)ifConditionToken.start):null), (thenStmtToken!=null?((Token)thenStmtToken.start):null)); 
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2237:17: ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==87) ) {
                    int LA76_1 = input.LA(2);

                    if ( (LA76_1==94) ) {
                        alt76=1;
                    }


                }


                switch (alt76) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2237:18: 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}'
            	    {
            	    string_literal191=(Token)match(input,87,FOLLOW_87_in_ifStatement4017); 
            	    string_literal191_tree = 
            	    (Object)adaptor.create(string_literal191)
            	    ;
            	    adaptor.addChild(root_0, string_literal191_tree);


            	    string_literal192=(Token)match(input,94,FOLLOW_94_in_ifStatement4019); 
            	    string_literal192_tree = 
            	    (Object)adaptor.create(string_literal192)
            	    ;
            	    adaptor.addChild(root_0, string_literal192_tree);


            	    char_literal193=(Token)match(input,20,FOLLOW_20_in_ifStatement4021); 
            	    char_literal193_tree = 
            	    (Object)adaptor.create(char_literal193)
            	    ;
            	    adaptor.addChild(root_0, char_literal193_tree);


            	    pushFollow(FOLLOW_ifCondition_in_ifStatement4025);
            	    elseIfToken=ifCondition(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, elseIfToken.getTree());

            	    char_literal194=(Token)match(input,21,FOLLOW_21_in_ifStatement4028); 
            	    char_literal194_tree = 
            	    (Object)adaptor.create(char_literal194)
            	    ;
            	    adaptor.addChild(root_0, char_literal194_tree);


            	    char_literal195=(Token)match(input,115,FOLLOW_115_in_ifStatement4030); 
            	    char_literal195_tree = 
            	    (Object)adaptor.create(char_literal195)
            	    ;
            	    adaptor.addChild(root_0, char_literal195_tree);


            	    pushFollow(FOLLOW_listOfStatements_in_ifStatement4034);
            	    elseIfStmtToken=listOfStatements(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, elseIfStmtToken.getTree());

            	    char_literal196=(Token)match(input,117,FOLLOW_117_in_ifStatement4037); 
            	    char_literal196_tree = 
            	    (Object)adaptor.create(char_literal196)
            	    ;
            	    adaptor.addChild(root_0, char_literal196_tree);



            	    if(!defer) {
            	        if(lstElseIfStatements == null) {
            	            lstElseIfStatements = new ArrayList<ConditionalBranch>();
            	        }
            	        ConditionalBranch objElseIfBranch = new ConditionalBranch((elseIfToken!=null?((Token)elseIfToken.start):null), (elseIfStmtToken!=null?((Token)elseIfStmtToken.start):null));
            	        lstElseIfStatements.add(objElseIfBranch);    
            	    }
            	            

            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2246:3: ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==87) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2246:4: 'else' '{' elseStmtToken= listOfStatements[true] '}'
                    {
                    string_literal197=(Token)match(input,87,FOLLOW_87_in_ifStatement4046); 
                    string_literal197_tree = 
                    (Object)adaptor.create(string_literal197)
                    ;
                    adaptor.addChild(root_0, string_literal197_tree);


                    char_literal198=(Token)match(input,115,FOLLOW_115_in_ifStatement4048); 
                    char_literal198_tree = 
                    (Object)adaptor.create(char_literal198)
                    ;
                    adaptor.addChild(root_0, char_literal198_tree);


                    pushFollow(FOLLOW_listOfStatements_in_ifStatement4052);
                    elseStmtToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, elseStmtToken.getTree());

                    char_literal199=(Token)match(input,117,FOLLOW_117_in_ifStatement4055); 
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

                this.executeIf(objIf);
            }
                    

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2269:1: ifCondition[boolean defer] returns [boolean b] : (deviceToken= onDevice[defer] )? exprToken= expression[defer] ;
    public final EugeneParser.ifCondition_return ifCondition(boolean defer) throws RecognitionException {
        EugeneParser.ifCondition_return retval = new EugeneParser.ifCondition_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.onDevice_return deviceToken =null;

        EugeneParser.expression_return exprToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2271:2: ( (deviceToken= onDevice[defer] )? exprToken= expression[defer] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2271:4: (deviceToken= onDevice[defer] )? exprToken= expression[defer]
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2271:4: (deviceToken= onDevice[defer] )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==67) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2271:5: deviceToken= onDevice[defer]
                    {
                    pushFollow(FOLLOW_onDevice_in_ifCondition4094);
                    deviceToken=onDevice(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_ifCondition4101);
            exprToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {
                if(null != deviceToken) {
                    Rule rule = interp.createRule("IF-RULE", (deviceToken!=null?deviceToken.device:null), exprToken.start, (CommonTree)(exprToken!=null?((Object)exprToken.tree):null));
                    if(null != rule) {
                        retval.b = RuleEngine.evaluateIfRule(rule);
                    }
                } else if((exprToken!=null?exprToken.objElement:null) instanceof Rule) {
                    if(null != deviceToken) {
                        Rule rule = interp.createRule("IF-RULE", (deviceToken!=null?deviceToken.device:null), exprToken.start, ((CommonTree)exprToken.tree));
                        retval.b = RuleEngine.evaluateIfRule(rule);
                    }  else {
                        retval.b = RuleEngine.evaluateIfRule((Rule)(exprToken!=null?exprToken.objElement:null));
                    }
                } else if((exprToken!=null?exprToken.objElement:null) instanceof Variable) {
                    retval.b = ((Variable)(exprToken!=null?exprToken.objElement:null)).getBoolean();
                } else {
                    throw new EugeneException("INVALID CONDITION!");
                }
            }
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

            System.err.println("line "+retval.start.getLine()+":"+retval.start.getCharPositionInLine()+" => "+e.getMessage());
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2312:1: loopStatement[boolean defer] : ( 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}' | 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}' | 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';' );
    public final EugeneParser.loopStatement_return loopStatement(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.loopStatement_return retval = new EugeneParser.loopStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal200=null;
        Token char_literal201=null;
        Token char_literal202=null;
        Token char_literal203=null;
        Token char_literal204=null;
        Token char_literal205=null;
        Token char_literal206=null;
        Token string_literal207=null;
        Token char_literal208=null;
        Token char_literal209=null;
        Token char_literal210=null;
        Token char_literal211=null;
        Token string_literal212=null;
        Token char_literal213=null;
        Token char_literal214=null;
        Token string_literal215=null;
        Token char_literal216=null;
        Token char_literal217=null;
        Token char_literal218=null;
        EugeneParser.forInit_return initToken =null;

        EugeneParser.expression_return condToken =null;

        EugeneParser.computationalStatement_return incToken =null;

        EugeneParser.listOfStatements_return forToken =null;

        EugeneParser.listOfStatements_return whileToken =null;


        Object string_literal200_tree=null;
        Object char_literal201_tree=null;
        Object char_literal202_tree=null;
        Object char_literal203_tree=null;
        Object char_literal204_tree=null;
        Object char_literal205_tree=null;
        Object char_literal206_tree=null;
        Object string_literal207_tree=null;
        Object char_literal208_tree=null;
        Object char_literal209_tree=null;
        Object char_literal210_tree=null;
        Object char_literal211_tree=null;
        Object string_literal212_tree=null;
        Object char_literal213_tree=null;
        Object char_literal214_tree=null;
        Object string_literal215_tree=null;
        Object char_literal216_tree=null;
        Object char_literal217_tree=null;
        Object char_literal218_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2314:6: ( 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}' | 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}' | 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';' )
            int alt79=3;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt79=1;
                }
                break;
            case 114:
                {
                alt79=2;
                }
                break;
            case 86:
                {
                alt79=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }

            switch (alt79) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2314:8: 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal200=(Token)match(input,91,FOLLOW_91_in_loopStatement4141); 
                    string_literal200_tree = 
                    (Object)adaptor.create(string_literal200)
                    ;
                    adaptor.addChild(root_0, string_literal200_tree);


                    char_literal201=(Token)match(input,20,FOLLOW_20_in_loopStatement4143); 
                    char_literal201_tree = 
                    (Object)adaptor.create(char_literal201)
                    ;
                    adaptor.addChild(root_0, char_literal201_tree);


                    pushFollow(FOLLOW_forInit_in_loopStatement4147);
                    initToken=forInit(true);

                    state._fsp--;

                    adaptor.addChild(root_0, initToken.getTree());

                    char_literal202=(Token)match(input,32,FOLLOW_32_in_loopStatement4150); 
                    char_literal202_tree = 
                    (Object)adaptor.create(char_literal202)
                    ;
                    adaptor.addChild(root_0, char_literal202_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement4161);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal203=(Token)match(input,32,FOLLOW_32_in_loopStatement4164); 
                    char_literal203_tree = 
                    (Object)adaptor.create(char_literal203)
                    ;
                    adaptor.addChild(root_0, char_literal203_tree);


                    pushFollow(FOLLOW_computationalStatement_in_loopStatement4175);
                    incToken=computationalStatement(true);

                    state._fsp--;

                    adaptor.addChild(root_0, incToken.getTree());

                    char_literal204=(Token)match(input,21,FOLLOW_21_in_loopStatement4178); 
                    char_literal204_tree = 
                    (Object)adaptor.create(char_literal204)
                    ;
                    adaptor.addChild(root_0, char_literal204_tree);


                    char_literal205=(Token)match(input,115,FOLLOW_115_in_loopStatement4180); 
                    char_literal205_tree = 
                    (Object)adaptor.create(char_literal205)
                    ;
                    adaptor.addChild(root_0, char_literal205_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement4192);
                    forToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, forToken.getTree());

                    char_literal206=(Token)match(input,117,FOLLOW_117_in_loopStatement4195); 
                    char_literal206_tree = 
                    (Object)adaptor.create(char_literal206)
                    ;
                    adaptor.addChild(root_0, char_literal206_tree);



                    if(!defer) {
                        forStat((initToken!=null?((Token)initToken.start):null), 
                            (condToken!=null?((Token)condToken.start):null), 
                            (incToken!=null?((Token)incToken.start):null), 
                            (forToken!=null?((Token)forToken.start):null));
                    }
                            

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2325:4: 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal207=(Token)match(input,114,FOLLOW_114_in_loopStatement4202); 
                    string_literal207_tree = 
                    (Object)adaptor.create(string_literal207)
                    ;
                    adaptor.addChild(root_0, string_literal207_tree);


                    char_literal208=(Token)match(input,20,FOLLOW_20_in_loopStatement4204); 
                    char_literal208_tree = 
                    (Object)adaptor.create(char_literal208)
                    ;
                    adaptor.addChild(root_0, char_literal208_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement4208);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal209=(Token)match(input,21,FOLLOW_21_in_loopStatement4211); 
                    char_literal209_tree = 
                    (Object)adaptor.create(char_literal209)
                    ;
                    adaptor.addChild(root_0, char_literal209_tree);


                    char_literal210=(Token)match(input,115,FOLLOW_115_in_loopStatement4213); 
                    char_literal210_tree = 
                    (Object)adaptor.create(char_literal210)
                    ;
                    adaptor.addChild(root_0, char_literal210_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement4217);
                    whileToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, whileToken.getTree());

                    char_literal211=(Token)match(input,117,FOLLOW_117_in_loopStatement4220); 
                    char_literal211_tree = 
                    (Object)adaptor.create(char_literal211)
                    ;
                    adaptor.addChild(root_0, char_literal211_tree);



                    if(!defer){
                        whileStat((condToken!=null?((Token)condToken.start):null), 
                            (whileToken!=null?((Token)whileToken.start):null));
                    }
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2331:4: 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal212=(Token)match(input,86,FOLLOW_86_in_loopStatement4227); 
                    string_literal212_tree = 
                    (Object)adaptor.create(string_literal212)
                    ;
                    adaptor.addChild(root_0, string_literal212_tree);


                    char_literal213=(Token)match(input,115,FOLLOW_115_in_loopStatement4229); 
                    char_literal213_tree = 
                    (Object)adaptor.create(char_literal213)
                    ;
                    adaptor.addChild(root_0, char_literal213_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement4233);
                    whileToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, whileToken.getTree());

                    char_literal214=(Token)match(input,117,FOLLOW_117_in_loopStatement4236); 
                    char_literal214_tree = 
                    (Object)adaptor.create(char_literal214)
                    ;
                    adaptor.addChild(root_0, char_literal214_tree);


                    string_literal215=(Token)match(input,114,FOLLOW_114_in_loopStatement4238); 
                    string_literal215_tree = 
                    (Object)adaptor.create(string_literal215)
                    ;
                    adaptor.addChild(root_0, string_literal215_tree);


                    char_literal216=(Token)match(input,20,FOLLOW_20_in_loopStatement4240); 
                    char_literal216_tree = 
                    (Object)adaptor.create(char_literal216)
                    ;
                    adaptor.addChild(root_0, char_literal216_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement4244);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal217=(Token)match(input,21,FOLLOW_21_in_loopStatement4247); 
                    char_literal217_tree = 
                    (Object)adaptor.create(char_literal217)
                    ;
                    adaptor.addChild(root_0, char_literal217_tree);


                    char_literal218=(Token)match(input,32,FOLLOW_32_in_loopStatement4248); 
                    char_literal218_tree = 
                    (Object)adaptor.create(char_literal218)
                    ;
                    adaptor.addChild(root_0, char_literal218_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2345:1: forInit[boolean defer] returns [ArrayList<NamedElement> lstElements] : (declToken= variableDeclaration[defer] |exprToken= listOfExpressions[defer] );
    public final EugeneParser.forInit_return forInit(boolean defer) throws RecognitionException {
        EugeneParser.forInit_return retval = new EugeneParser.forInit_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.variableDeclaration_return declToken =null;

        EugeneParser.listOfExpressions_return exprToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2346:2: (declToken= variableDeclaration[defer] |exprToken= listOfExpressions[defer] )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==84||LA80_0==100||LA80_0==113) ) {
                alt80=1;
            }
            else if ( (LA80_0==FLOAT||LA80_0==ID||LA80_0==INT||LA80_0==STRING||LA80_0==18||LA80_0==20||LA80_0==25||(LA80_0 >= 33 && LA80_0 <= 34)||(LA80_0 >= 36 && LA80_0 <= 39)||(LA80_0 >= 42 && LA80_0 <= 44)||LA80_0==46||(LA80_0 >= 49 && LA80_0 <= 53)||LA80_0==55||(LA80_0 >= 58 && LA80_0 <= 65)||LA80_0==69||LA80_0==73||(LA80_0 >= 77 && LA80_0 <= 79)||LA80_0==81||LA80_0==89||LA80_0==112) ) {
                alt80=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;

            }
            switch (alt80) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2346:4: declToken= variableDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_variableDeclaration_in_forInit4276);
                    declToken=variableDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, declToken.getTree());


                    if(!defer) {
                        retval.lstElements = new ArrayList<NamedElement>((declToken!=null?declToken.lstVariables:null));
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2351:4: exprToken= listOfExpressions[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_listOfExpressions_in_forInit4286);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2361:1: functionDeclaration returns [Function objFunction] : 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}' ;
    public final EugeneParser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        EugeneParser.functionDeclaration_return retval = new EugeneParser.functionDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal219=null;
        Token char_literal220=null;
        Token char_literal221=null;
        Token char_literal222=null;
        Token char_literal223=null;
        EugeneParser.type_return returnTypeToken =null;

        EugeneParser.listOfFunctionParamenters_return lstParametersToken =null;

        EugeneParser.listOfStatements_return lstStatementsToken =null;


        Object nameToken_tree=null;
        Object string_literal219_tree=null;
        Object char_literal220_tree=null;
        Object char_literal221_tree=null;
        Object char_literal222_tree=null;
        Object char_literal223_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2362:2: ( 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2362:4: 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}'
            {
            root_0 = (Object)adaptor.nil();


            string_literal219=(Token)match(input,92,FOLLOW_92_in_functionDeclaration4311); 
            string_literal219_tree = 
            (Object)adaptor.create(string_literal219)
            ;
            adaptor.addChild(root_0, string_literal219_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2362:15: (returnTypeToken= type )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==45||LA81_0==47||LA81_0==70||LA81_0==72||LA81_0==84||LA81_0==100||LA81_0==113) ) {
                alt81=1;
            }
            else if ( (LA81_0==ID) ) {
                int LA81_2 = input.LA(2);

                if ( (LA81_2==ID||LA81_2==81) ) {
                    alt81=1;
                }
            }
            switch (alt81) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2362:16: returnTypeToken= type
                    {
                    pushFollow(FOLLOW_type_in_functionDeclaration4316);
                    returnTypeToken=type();

                    state._fsp--;

                    adaptor.addChild(root_0, returnTypeToken.getTree());

                    }
                    break;

            }


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_functionDeclaration4322); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);



            if(null != interp.get((nameToken!=null?nameToken.getText():null))) {
                System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getText():null)+" => "+
                    "The "+(nameToken!=null?nameToken.getText():null)+" function has been declared already!");
                this.cleanUp(1);
            }
            	

            char_literal220=(Token)match(input,20,FOLLOW_20_in_functionDeclaration4326); 
            char_literal220_tree = 
            (Object)adaptor.create(char_literal220)
            ;
            adaptor.addChild(root_0, char_literal220_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2368:8: (lstParametersToken= listOfFunctionParamenters )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==ID||LA82_0==45||LA82_0==47||LA82_0==70||LA82_0==72||LA82_0==84||LA82_0==100||LA82_0==113) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2368:9: lstParametersToken= listOfFunctionParamenters
                    {
                    pushFollow(FOLLOW_listOfFunctionParamenters_in_functionDeclaration4331);
                    lstParametersToken=listOfFunctionParamenters();

                    state._fsp--;

                    adaptor.addChild(root_0, lstParametersToken.getTree());

                    }
                    break;

            }


            char_literal221=(Token)match(input,21,FOLLOW_21_in_functionDeclaration4335); 
            char_literal221_tree = 
            (Object)adaptor.create(char_literal221)
            ;
            adaptor.addChild(root_0, char_literal221_tree);


            char_literal222=(Token)match(input,115,FOLLOW_115_in_functionDeclaration4337); 
            char_literal222_tree = 
            (Object)adaptor.create(char_literal222)
            ;
            adaptor.addChild(root_0, char_literal222_tree);


            pushFollow(FOLLOW_listOfStatements_in_functionDeclaration4345);
            lstStatementsToken=listOfStatements(true);

            state._fsp--;

            adaptor.addChild(root_0, lstStatementsToken.getTree());

            char_literal223=(Token)match(input,117,FOLLOW_117_in_functionDeclaration4350); 
            char_literal223_tree = 
            (Object)adaptor.create(char_literal223)
            ;
            adaptor.addChild(root_0, char_literal223_tree);



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
        catch (EugeneReturnException ere) {

            	
            	
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2387:1: type returns [String sType] : ( 'Collection' | 'Device' '[' ']' | 'Device' | 'Part' '[' ']' | 'Part' |idToken= ID '[' ']' |idToken= ID | 'Property' '[' ']' | 'Property' | 'num' '[' ']' | 'num' | 'txt' '[' ']' | 'txt' | 'boolean' );
    public final EugeneParser.type_return type() throws RecognitionException {
        EugeneParser.type_return retval = new EugeneParser.type_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token string_literal224=null;
        Token string_literal225=null;
        Token char_literal226=null;
        Token char_literal227=null;
        Token string_literal228=null;
        Token string_literal229=null;
        Token char_literal230=null;
        Token char_literal231=null;
        Token string_literal232=null;
        Token char_literal233=null;
        Token char_literal234=null;
        Token string_literal235=null;
        Token char_literal236=null;
        Token char_literal237=null;
        Token string_literal238=null;
        Token string_literal239=null;
        Token char_literal240=null;
        Token char_literal241=null;
        Token string_literal242=null;
        Token string_literal243=null;
        Token char_literal244=null;
        Token char_literal245=null;
        Token string_literal246=null;
        Token string_literal247=null;

        Object idToken_tree=null;
        Object string_literal224_tree=null;
        Object string_literal225_tree=null;
        Object char_literal226_tree=null;
        Object char_literal227_tree=null;
        Object string_literal228_tree=null;
        Object string_literal229_tree=null;
        Object char_literal230_tree=null;
        Object char_literal231_tree=null;
        Object string_literal232_tree=null;
        Object char_literal233_tree=null;
        Object char_literal234_tree=null;
        Object string_literal235_tree=null;
        Object char_literal236_tree=null;
        Object char_literal237_tree=null;
        Object string_literal238_tree=null;
        Object string_literal239_tree=null;
        Object char_literal240_tree=null;
        Object char_literal241_tree=null;
        Object string_literal242_tree=null;
        Object string_literal243_tree=null;
        Object char_literal244_tree=null;
        Object char_literal245_tree=null;
        Object string_literal246_tree=null;
        Object string_literal247_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2388:2: ( 'Collection' | 'Device' '[' ']' | 'Device' | 'Part' '[' ']' | 'Part' |idToken= ID '[' ']' |idToken= ID | 'Property' '[' ']' | 'Property' | 'num' '[' ']' | 'num' | 'txt' '[' ']' | 'txt' | 'boolean' )
            int alt83=14;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt83=1;
                }
                break;
            case 47:
                {
                int LA83_2 = input.LA(2);

                if ( (LA83_2==81) ) {
                    alt83=2;
                }
                else if ( (LA83_2==DYNAMIC_NAME||LA83_2==ID||LA83_2==19||LA83_2==21||LA83_2==24||(LA83_2 >= 31 && LA83_2 <= 32)||LA83_2==40||LA83_2==68||LA83_2==80||(LA83_2 >= 82 && LA83_2 <= 83)||LA83_2==116) ) {
                    alt83=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 2, input);

                    throw nvae;

                }
                }
                break;
            case 70:
                {
                int LA83_3 = input.LA(2);

                if ( (LA83_3==81) ) {
                    alt83=4;
                }
                else if ( (LA83_3==DYNAMIC_NAME||LA83_3==ID||LA83_3==19||LA83_3==21||LA83_3==24||(LA83_3 >= 31 && LA83_3 <= 32)||LA83_3==40||LA83_3==68||LA83_3==80||(LA83_3 >= 82 && LA83_3 <= 83)||LA83_3==116) ) {
                    alt83=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 3, input);

                    throw nvae;

                }
                }
                break;
            case ID:
                {
                int LA83_4 = input.LA(2);

                if ( (LA83_4==81) ) {
                    alt83=6;
                }
                else if ( (LA83_4==DYNAMIC_NAME||LA83_4==ID||LA83_4==19||LA83_4==21||LA83_4==24||(LA83_4 >= 31 && LA83_4 <= 32)||LA83_4==40||LA83_4==68||LA83_4==80||(LA83_4 >= 82 && LA83_4 <= 83)||LA83_4==116) ) {
                    alt83=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 4, input);

                    throw nvae;

                }
                }
                break;
            case 72:
                {
                int LA83_5 = input.LA(2);

                if ( (LA83_5==81) ) {
                    alt83=8;
                }
                else if ( (LA83_5==DYNAMIC_NAME||LA83_5==ID||LA83_5==19||LA83_5==21||LA83_5==24||(LA83_5 >= 31 && LA83_5 <= 32)||LA83_5==40||LA83_5==68||LA83_5==80||(LA83_5 >= 82 && LA83_5 <= 83)||LA83_5==116) ) {
                    alt83=9;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 5, input);

                    throw nvae;

                }
                }
                break;
            case 100:
                {
                int LA83_6 = input.LA(2);

                if ( (LA83_6==81) ) {
                    alt83=10;
                }
                else if ( (LA83_6==DYNAMIC_NAME||LA83_6==ID||LA83_6==19||LA83_6==21||LA83_6==24||(LA83_6 >= 31 && LA83_6 <= 32)||LA83_6==40||LA83_6==68||LA83_6==80||(LA83_6 >= 82 && LA83_6 <= 83)||LA83_6==116) ) {
                    alt83=11;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 6, input);

                    throw nvae;

                }
                }
                break;
            case 113:
                {
                int LA83_7 = input.LA(2);

                if ( (LA83_7==81) ) {
                    alt83=12;
                }
                else if ( (LA83_7==DYNAMIC_NAME||LA83_7==ID||LA83_7==19||LA83_7==21||LA83_7==24||(LA83_7 >= 31 && LA83_7 <= 32)||LA83_7==40||LA83_7==68||LA83_7==80||(LA83_7 >= 82 && LA83_7 <= 83)||LA83_7==116) ) {
                    alt83=13;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 7, input);

                    throw nvae;

                }
                }
                break;
            case 84:
                {
                alt83=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;

            }

            switch (alt83) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2388:4: 'Collection'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal224=(Token)match(input,45,FOLLOW_45_in_type4373); 
                    string_literal224_tree = 
                    (Object)adaptor.create(string_literal224)
                    ;
                    adaptor.addChild(root_0, string_literal224_tree);



                    retval.sType =EugeneConstants.COLLECTION;	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2391:4: 'Device' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal225=(Token)match(input,47,FOLLOW_47_in_type4380); 
                    string_literal225_tree = 
                    (Object)adaptor.create(string_literal225)
                    ;
                    adaptor.addChild(root_0, string_literal225_tree);


                    char_literal226=(Token)match(input,81,FOLLOW_81_in_type4382); 
                    char_literal226_tree = 
                    (Object)adaptor.create(char_literal226)
                    ;
                    adaptor.addChild(root_0, char_literal226_tree);


                    char_literal227=(Token)match(input,82,FOLLOW_82_in_type4384); 
                    char_literal227_tree = 
                    (Object)adaptor.create(char_literal227)
                    ;
                    adaptor.addChild(root_0, char_literal227_tree);



                    retval.sType =EugeneConstants.DEVICEARRAY;	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2394:4: 'Device'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal228=(Token)match(input,47,FOLLOW_47_in_type4391); 
                    string_literal228_tree = 
                    (Object)adaptor.create(string_literal228)
                    ;
                    adaptor.addChild(root_0, string_literal228_tree);



                    retval.sType =EugeneConstants.DEVICE;	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2397:4: 'Part' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal229=(Token)match(input,70,FOLLOW_70_in_type4398); 
                    string_literal229_tree = 
                    (Object)adaptor.create(string_literal229)
                    ;
                    adaptor.addChild(root_0, string_literal229_tree);


                    char_literal230=(Token)match(input,81,FOLLOW_81_in_type4400); 
                    char_literal230_tree = 
                    (Object)adaptor.create(char_literal230)
                    ;
                    adaptor.addChild(root_0, char_literal230_tree);


                    char_literal231=(Token)match(input,82,FOLLOW_82_in_type4402); 
                    char_literal231_tree = 
                    (Object)adaptor.create(char_literal231)
                    ;
                    adaptor.addChild(root_0, char_literal231_tree);



                    retval.sType =EugeneConstants.PARTTYPEARRAY;	
                    	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2400:4: 'Part'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal232=(Token)match(input,70,FOLLOW_70_in_type4409); 
                    string_literal232_tree = 
                    (Object)adaptor.create(string_literal232)
                    ;
                    adaptor.addChild(root_0, string_literal232_tree);



                    retval.sType =EugeneConstants.PARTTYPE;	
                    	

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2403:4: idToken= ID '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_type4418); 
                    idToken_tree = 
                    (Object)adaptor.create(idToken)
                    ;
                    adaptor.addChild(root_0, idToken_tree);


                    char_literal233=(Token)match(input,81,FOLLOW_81_in_type4420); 
                    char_literal233_tree = 
                    (Object)adaptor.create(char_literal233)
                    ;
                    adaptor.addChild(root_0, char_literal233_tree);


                    char_literal234=(Token)match(input,82,FOLLOW_82_in_type4422); 
                    char_literal234_tree = 
                    (Object)adaptor.create(char_literal234)
                    ;
                    adaptor.addChild(root_0, char_literal234_tree);



                    retval.sType =EugeneConstants.PARTARRAY;	
                    	

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2406:4: idToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_type4431); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2416:4: 'Property' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal235=(Token)match(input,72,FOLLOW_72_in_type4438); 
                    string_literal235_tree = 
                    (Object)adaptor.create(string_literal235)
                    ;
                    adaptor.addChild(root_0, string_literal235_tree);


                    char_literal236=(Token)match(input,81,FOLLOW_81_in_type4440); 
                    char_literal236_tree = 
                    (Object)adaptor.create(char_literal236)
                    ;
                    adaptor.addChild(root_0, char_literal236_tree);


                    char_literal237=(Token)match(input,82,FOLLOW_82_in_type4442); 
                    char_literal237_tree = 
                    (Object)adaptor.create(char_literal237)
                    ;
                    adaptor.addChild(root_0, char_literal237_tree);



                    retval.sType =EugeneConstants.PROPERTYARRAY;	
                    	

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2419:4: 'Property'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal238=(Token)match(input,72,FOLLOW_72_in_type4449); 
                    string_literal238_tree = 
                    (Object)adaptor.create(string_literal238)
                    ;
                    adaptor.addChild(root_0, string_literal238_tree);



                    retval.sType =EugeneConstants.PROPERTY;	
                    	

                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2422:4: 'num' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal239=(Token)match(input,100,FOLLOW_100_in_type4456); 
                    string_literal239_tree = 
                    (Object)adaptor.create(string_literal239)
                    ;
                    adaptor.addChild(root_0, string_literal239_tree);


                    char_literal240=(Token)match(input,81,FOLLOW_81_in_type4458); 
                    char_literal240_tree = 
                    (Object)adaptor.create(char_literal240)
                    ;
                    adaptor.addChild(root_0, char_literal240_tree);


                    char_literal241=(Token)match(input,82,FOLLOW_82_in_type4460); 
                    char_literal241_tree = 
                    (Object)adaptor.create(char_literal241)
                    ;
                    adaptor.addChild(root_0, char_literal241_tree);



                    retval.sType =EugeneConstants.NUMLIST;	
                    	

                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2425:4: 'num'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal242=(Token)match(input,100,FOLLOW_100_in_type4467); 
                    string_literal242_tree = 
                    (Object)adaptor.create(string_literal242)
                    ;
                    adaptor.addChild(root_0, string_literal242_tree);



                    retval.sType =EugeneConstants.NUM;	
                    	

                    }
                    break;
                case 12 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2428:4: 'txt' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal243=(Token)match(input,113,FOLLOW_113_in_type4474); 
                    string_literal243_tree = 
                    (Object)adaptor.create(string_literal243)
                    ;
                    adaptor.addChild(root_0, string_literal243_tree);


                    char_literal244=(Token)match(input,81,FOLLOW_81_in_type4476); 
                    char_literal244_tree = 
                    (Object)adaptor.create(char_literal244)
                    ;
                    adaptor.addChild(root_0, char_literal244_tree);


                    char_literal245=(Token)match(input,82,FOLLOW_82_in_type4478); 
                    char_literal245_tree = 
                    (Object)adaptor.create(char_literal245)
                    ;
                    adaptor.addChild(root_0, char_literal245_tree);



                    retval.sType =EugeneConstants.TXTLIST;	
                    	

                    }
                    break;
                case 13 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2431:4: 'txt'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal246=(Token)match(input,113,FOLLOW_113_in_type4485); 
                    string_literal246_tree = 
                    (Object)adaptor.create(string_literal246)
                    ;
                    adaptor.addChild(root_0, string_literal246_tree);



                    retval.sType =EugeneConstants.TXT;	
                    	

                    }
                    break;
                case 14 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2434:4: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal247=(Token)match(input,84,FOLLOW_84_in_type4492); 
                    string_literal247_tree = 
                    (Object)adaptor.create(string_literal247)
                    ;
                    adaptor.addChild(root_0, string_literal247_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2439:1: listOfFunctionParamenters returns [ArrayList<NamedElement> lst] : paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )? ;
    public final EugeneParser.listOfFunctionParamenters_return listOfFunctionParamenters() throws RecognitionException {
        EugeneParser.listOfFunctionParamenters_return retval = new EugeneParser.listOfFunctionParamenters_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token paramNameToken=null;
        Token char_literal248=null;
        EugeneParser.type_return paramTypeToken =null;

        EugeneParser.listOfFunctionParamenters_return lstToken =null;


        Object paramNameToken_tree=null;
        Object char_literal248_tree=null;


        retval.lst =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2443:2: (paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2443:4: paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_type_in_listOfFunctionParamenters4516);
            paramTypeToken=type();

            state._fsp--;

            adaptor.addChild(root_0, paramTypeToken.getTree());

            paramNameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfFunctionParamenters4520); 
            paramNameToken_tree = 
            (Object)adaptor.create(paramNameToken)
            ;
            adaptor.addChild(root_0, paramNameToken_tree);


             
            NamedElement objParameter = this.createElement((paramTypeToken!=null?input.toString(paramTypeToken.start,paramTypeToken.stop):null),(paramNameToken!=null?paramNameToken.getText():null));
            if(objParameter!=null) {
                retval.lst.add(objParameter);
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2448:4: ( ',' lstToken= listOfFunctionParamenters )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==24) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2448:5: ',' lstToken= listOfFunctionParamenters
                    {
                    char_literal248=(Token)match(input,24,FOLLOW_24_in_listOfFunctionParamenters4525); 
                    char_literal248_tree = 
                    (Object)adaptor.create(char_literal248)
                    ;
                    adaptor.addChild(root_0, char_literal248_tree);


                    pushFollow(FOLLOW_listOfFunctionParamenters_in_listOfFunctionParamenters4529);
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
    // $ANTLR end "listOfFunctionParamenters"


    public static class functionCall_return extends ParserRuleReturnScope {
        public NamedElement objElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionCall"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2455:1: functionCall[boolean defer] returns [NamedElement objElement] : functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')' ;
    public final EugeneParser.functionCall_return functionCall(boolean defer) throws RecognitionException {
        EugeneParser.functionCall_return retval = new EugeneParser.functionCall_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token functionToken=null;
        Token char_literal249=null;
        Token char_literal250=null;
        EugeneParser.listOfParameterValues_return lstParametersToken =null;


        Object functionToken_tree=null;
        Object char_literal249_tree=null;
        Object char_literal250_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2456:2: (functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2456:4: functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            functionToken=(Token)match(input,ID,FOLLOW_ID_in_functionCall4554); 
            functionToken_tree = 
            (Object)adaptor.create(functionToken)
            ;
            adaptor.addChild(root_0, functionToken_tree);


            char_literal249=(Token)match(input,20,FOLLOW_20_in_functionCall4556); 
            char_literal249_tree = 
            (Object)adaptor.create(char_literal249)
            ;
            adaptor.addChild(root_0, char_literal249_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2456:25: (lstParametersToken= listOfParameterValues[defer] )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==FLOAT||LA85_0==ID||LA85_0==INT||LA85_0==STRING||LA85_0==18||LA85_0==20||LA85_0==25||(LA85_0 >= 33 && LA85_0 <= 34)||(LA85_0 >= 36 && LA85_0 <= 39)||(LA85_0 >= 42 && LA85_0 <= 44)||LA85_0==46||(LA85_0 >= 49 && LA85_0 <= 53)||LA85_0==55||(LA85_0 >= 58 && LA85_0 <= 65)||LA85_0==69||LA85_0==73||(LA85_0 >= 77 && LA85_0 <= 79)||LA85_0==81||LA85_0==89||LA85_0==112) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2456:26: lstParametersToken= listOfParameterValues[defer]
                    {
                    pushFollow(FOLLOW_listOfParameterValues_in_functionCall4561);
                    lstParametersToken=listOfParameterValues(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstParametersToken.getTree());

                    }
                    break;

            }


            char_literal250=(Token)match(input,21,FOLLOW_21_in_functionCall4566); 
            char_literal250_tree = 
            (Object)adaptor.create(char_literal250)
            ;
            adaptor.addChild(root_0, char_literal250_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2481:1: listOfParameterValues[boolean defer] returns [ArrayList<NamedElement> lstParameterValues] : exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )? ;
    public final EugeneParser.listOfParameterValues_return listOfParameterValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfParameterValues_return retval = new EugeneParser.listOfParameterValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal251=null;
        EugeneParser.expression_return exprToken1 =null;

        EugeneParser.listOfParameterValues_return exprToken2 =null;


        Object char_literal251_tree=null;


        retval.lstParameterValues =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2485:2: (exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2485:4: exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfParameterValues4598);
            exprToken1=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken1.getTree());


            if(!defer) {
                if(null!=exprToken1) {
                    retval.lstParameterValues.add((exprToken1!=null?exprToken1.objElement:null));
                }
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2491:5: ( ',' exprToken2= listOfParameterValues[defer] )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==24) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2491:6: ',' exprToken2= listOfParameterValues[defer]
                    {
                    char_literal251=(Token)match(input,24,FOLLOW_24_in_listOfParameterValues4605); 
                    char_literal251_tree = 
                    (Object)adaptor.create(char_literal251)
                    ;
                    adaptor.addChild(root_0, char_literal251_tree);


                    pushFollow(FOLLOW_listOfParameterValues_in_listOfParameterValues4609);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2501:1: wrappedStatement[boolean defer] returns [NamedElement objElement] : ( add[defer] |permuteToken= combinatorialFunction[defer] |getToken= get[defer] |sizeToken= size[defer] |removeToken= remove[defer] |seqToken= toSequence[defer] |sbolToken= sbolStatement[defer] |genbankToken= genbankStatement[defer] |deviceToken= deviceDepthStatements[defer] );
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

        EugeneParser.add_return add252 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2502:2: ( add[defer] |permuteToken= combinatorialFunction[defer] |getToken= get[defer] |sizeToken= size[defer] |removeToken= remove[defer] |seqToken= toSequence[defer] |sbolToken= sbolStatement[defer] |genbankToken= genbankStatement[defer] |deviceToken= deviceDepthStatements[defer] )
            int alt87=9;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA87_1 = input.LA(2);

                if ( (LA87_1==26) ) {
                    switch ( input.LA(3) ) {
                    case 93:
                        {
                        alt87=3;
                        }
                        break;
                    case 109:
                        {
                        alt87=4;
                        }
                        break;
                    case 106:
                        {
                        alt87=5;
                        }
                        break;
                    case 111:
                        {
                        alt87=6;
                        }
                        break;
                    case 85:
                    case 99:
                        {
                        alt87=9;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 87, 5, input);

                        throw nvae;

                    }

                }
                else if ( ((LA87_1 >= 27 && LA87_1 <= 29)) ) {
                    alt87=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 1, input);

                    throw nvae;

                }
                }
                break;
            case 101:
            case 105:
                {
                alt87=2;
                }
                break;
            case 76:
                {
                alt87=7;
                }
                break;
            case 54:
                {
                alt87=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;

            }

            switch (alt87) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2502:4: add[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_add_in_wrappedStatement4634);
                    add252=add(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, add252.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2503:10: permuteToken= combinatorialFunction[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_combinatorialFunction_in_wrappedStatement4649);
                    permuteToken=combinatorialFunction(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, permuteToken.getTree());


                    if(!defer) {
                        retval.objElement = (permuteToken!=null?permuteToken.objDeviceArray:null);
                    }


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2508:4: getToken= get[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_get_in_wrappedStatement4659);
                    getToken=get(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, getToken.getTree());


                    if(!defer) {
                        retval.objElement = (getToken!=null?getToken.objElement:null);
                    }	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2513:4: sizeToken= size[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_size_in_wrappedStatement4669);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2520:4: removeToken= remove[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_remove_in_wrappedStatement4679);
                    removeToken=remove(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, removeToken.getTree());

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2521:4: seqToken= toSequence[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_toSequence_in_wrappedStatement4688);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2528:4: sbolToken= sbolStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_sbolStatement_in_wrappedStatement4698);
                    sbolToken=sbolStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolToken.getTree());


                    if(!defer) {
                        retval.objElement = sbolToken.objElement;
                    }	
                    	

                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2533:4: genbankToken= genbankStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_genbankStatement_in_wrappedStatement4708);
                    genbankToken=genbankStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankToken.getTree());


                    if(!defer) {
                        retval.objElement = genbankToken.objElement;
                    }	
                    	

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2538:10: deviceToken= deviceDepthStatements[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDepthStatements_in_wrappedStatement4724);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2549:1: deviceDepthStatements[boolean defer] returns [NamedElement objElement] : deviceToken= ID '.' ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' ) ;
    public final EugeneParser.deviceDepthStatements_return deviceDepthStatements(boolean defer) throws RecognitionException {
        EugeneParser.deviceDepthStatements_return retval = new EugeneParser.deviceDepthStatements_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token deviceToken=null;
        Token char_literal253=null;
        Token string_literal254=null;
        Token char_literal255=null;
        Token char_literal256=null;
        Token string_literal257=null;
        Token char_literal258=null;
        Token char_literal259=null;
        EugeneParser.expression_return depthToken =null;


        Object deviceToken_tree=null;
        Object char_literal253_tree=null;
        Object string_literal254_tree=null;
        Object char_literal255_tree=null;
        Object char_literal256_tree=null;
        Object string_literal257_tree=null;
        Object char_literal258_tree=null;
        Object char_literal259_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2551:2: (deviceToken= ID '.' ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2551:4: deviceToken= ID '.' ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' )
            {
            root_0 = (Object)adaptor.nil();


            deviceToken=(Token)match(input,ID,FOLLOW_ID_in_deviceDepthStatements4755); 
            deviceToken_tree = 
            (Object)adaptor.create(deviceToken)
            ;
            adaptor.addChild(root_0, deviceToken_tree);


            char_literal253=(Token)match(input,26,FOLLOW_26_in_deviceDepthStatements4757); 
            char_literal253_tree = 
            (Object)adaptor.create(char_literal253)
            ;
            adaptor.addChild(root_0, char_literal253_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2552:4: ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==85) ) {
                alt88=1;
            }
            else if ( (LA88_0==99) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;

            }
            switch (alt88) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2552:5: 'depth' '(' depthToken= expression[defer] ')'
                    {
                    string_literal254=(Token)match(input,85,FOLLOW_85_in_deviceDepthStatements4764); 
                    string_literal254_tree = 
                    (Object)adaptor.create(string_literal254)
                    ;
                    adaptor.addChild(root_0, string_literal254_tree);


                    char_literal255=(Token)match(input,20,FOLLOW_20_in_deviceDepthStatements4766); 
                    char_literal255_tree = 
                    (Object)adaptor.create(char_literal255)
                    ;
                    adaptor.addChild(root_0, char_literal255_tree);


                    pushFollow(FOLLOW_expression_in_deviceDepthStatements4770);
                    depthToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, depthToken.getTree());

                    char_literal256=(Token)match(input,21,FOLLOW_21_in_deviceDepthStatements4773); 
                    char_literal256_tree = 
                    (Object)adaptor.create(char_literal256)
                    ;
                    adaptor.addChild(root_0, char_literal256_tree);



                    if(!defer) {
                        retval.objElement = interp.getDeviceDepth((deviceToken!=null?deviceToken.getText():null), (depthToken!=null?depthToken.objElement:null));    
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2557:5: 'maxDepth' '(' ')'
                    {
                    string_literal257=(Token)match(input,99,FOLLOW_99_in_deviceDepthStatements4781); 
                    string_literal257_tree = 
                    (Object)adaptor.create(string_literal257)
                    ;
                    adaptor.addChild(root_0, string_literal257_tree);


                    char_literal258=(Token)match(input,20,FOLLOW_20_in_deviceDepthStatements4783); 
                    char_literal258_tree = 
                    (Object)adaptor.create(char_literal258)
                    ;
                    adaptor.addChild(root_0, char_literal258_tree);


                    char_literal259=(Token)match(input,21,FOLLOW_21_in_deviceDepthStatements4785); 
                    char_literal259_tree = 
                    (Object)adaptor.create(char_literal259)
                    ;
                    adaptor.addChild(root_0, char_literal259_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2569:1: add[boolean defer] : componentToken= ID ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' ) ;
    public final EugeneParser.add_return add(boolean defer) throws RecognitionException {
        EugeneParser.add_return retval = new EugeneParser.add_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token componentToken=null;
        Token propertyToken=null;
        Token string_literal260=null;
        Token char_literal261=null;
        Token char_literal262=null;
        Token string_literal263=null;
        Token char_literal264=null;
        Token char_literal265=null;
        Token string_literal266=null;
        Token char_literal267=null;
        Token char_literal268=null;
        EugeneParser.listOfExpressions_return lstAdd =null;

        EugeneParser.listOfIDs_return lstToken =null;


        Object componentToken_tree=null;
        Object propertyToken_tree=null;
        Object string_literal260_tree=null;
        Object char_literal261_tree=null;
        Object char_literal262_tree=null;
        Object string_literal263_tree=null;
        Object char_literal264_tree=null;
        Object char_literal265_tree=null;
        Object string_literal266_tree=null;
        Object char_literal267_tree=null;
        Object char_literal268_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2570:2: (componentToken= ID ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2570:4: componentToken= ID ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' )
            {
            root_0 = (Object)adaptor.nil();


            componentToken=(Token)match(input,ID,FOLLOW_ID_in_add4809); 
            componentToken_tree = 
            (Object)adaptor.create(componentToken)
            ;
            adaptor.addChild(root_0, componentToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2570:22: ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' )
            int alt89=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt89=1;
                }
                break;
            case 29:
                {
                alt89=2;
                }
                break;
            case 28:
                {
                alt89=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;

            }

            switch (alt89) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2571:4: '.add' '(' lstAdd= listOfExpressions[defer] ')'
                    {
                    string_literal260=(Token)match(input,27,FOLLOW_27_in_add4816); 
                    string_literal260_tree = 
                    (Object)adaptor.create(string_literal260)
                    ;
                    adaptor.addChild(root_0, string_literal260_tree);


                    char_literal261=(Token)match(input,20,FOLLOW_20_in_add4818); 
                    char_literal261_tree = 
                    (Object)adaptor.create(char_literal261)
                    ;
                    adaptor.addChild(root_0, char_literal261_tree);


                    pushFollow(FOLLOW_listOfExpressions_in_add4822);
                    lstAdd=listOfExpressions(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstAdd.getTree());

                    char_literal262=(Token)match(input,21,FOLLOW_21_in_add4825); 
                    char_literal262_tree = 
                    (Object)adaptor.create(char_literal262)
                    ;
                    adaptor.addChild(root_0, char_literal262_tree);



                    if(!defer) {
                        NamedElement objElement = interp.get((componentToken!=null?componentToken.getText():null)); 
                        if(null==objElement) {
                            System.err.println("line "+(componentToken!=null?componentToken.getLine():0)+":"+(componentToken!=null?componentToken.getCharPositionInLine():0)+" => "+
                                "I don't know anything about "+(componentToken!=null?componentToken.getText():null));
                            this.cleanUp(1);
                        } else {
                            if(objElement instanceof Component) {
                                ArrayList<NamedElement> lstElements = (lstAdd!=null?lstAdd.lstElements:null);
                                for(NamedElement element : lstElements) {
                                    ((Component)objElement).add(element);
                                }
                            } else if(objElement instanceof ComponentArray) {
                                ArrayList<NamedElement> lstElements = (lstAdd!=null?lstAdd.lstElements:null);
                                for(NamedElement element : lstElements) {
                                    ((ComponentArray)objElement).add(element);
                                }
                            } else if (objElement instanceof EugeneCollection) {
                                EugeneCollection objCollection = (EugeneCollection)objElement;

                                ArrayList<NamedElement> lstElements = (lstAdd!=null?lstAdd.lstElements:null);
                                for(NamedElement element : lstElements) {
                                    if(element instanceof CollectionElement) {
                                        objCollection.add((CollectionElement)element);
                                    } else {
                                        throw new EugeneException(
                                                   element.getName()+" cannot be added to the "+
                                                   objCollection.getName()+" Collection!");
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2610:4: '.addProperty' '(' propertyToken= ID ')'
                    {
                    string_literal263=(Token)match(input,29,FOLLOW_29_in_add4833); 
                    string_literal263_tree = 
                    (Object)adaptor.create(string_literal263)
                    ;
                    adaptor.addChild(root_0, string_literal263_tree);


                    char_literal264=(Token)match(input,20,FOLLOW_20_in_add4835); 
                    char_literal264_tree = 
                    (Object)adaptor.create(char_literal264)
                    ;
                    adaptor.addChild(root_0, char_literal264_tree);


                    propertyToken=(Token)match(input,ID,FOLLOW_ID_in_add4839); 
                    propertyToken_tree = 
                    (Object)adaptor.create(propertyToken)
                    ;
                    adaptor.addChild(root_0, propertyToken_tree);


                    char_literal265=(Token)match(input,21,FOLLOW_21_in_add4841); 
                    char_literal265_tree = 
                    (Object)adaptor.create(char_literal265)
                    ;
                    adaptor.addChild(root_0, char_literal265_tree);



                    if(!defer) {
                        interp.addProperty((componentToken!=null?componentToken.getText():null), (propertyToken!=null?propertyToken.getText():null));    
                    }	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2615:4: '.addProperties' '(' lstToken= listOfIDs[defer] ')'
                    {
                    string_literal266=(Token)match(input,28,FOLLOW_28_in_add4848); 
                    string_literal266_tree = 
                    (Object)adaptor.create(string_literal266)
                    ;
                    adaptor.addChild(root_0, string_literal266_tree);


                    char_literal267=(Token)match(input,20,FOLLOW_20_in_add4850); 
                    char_literal267_tree = 
                    (Object)adaptor.create(char_literal267)
                    ;
                    adaptor.addChild(root_0, char_literal267_tree);


                    pushFollow(FOLLOW_listOfIDs_in_add4854);
                    lstToken=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());

                    char_literal268=(Token)match(input,21,FOLLOW_21_in_add4857); 
                    char_literal268_tree = 
                    (Object)adaptor.create(char_literal268)
                    ;
                    adaptor.addChild(root_0, char_literal268_tree);



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
        catch (EugeneException exc) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2628:1: toSequence[boolean defer] returns [String sequence] : idToken= ID '.' 'toSequence' '(' ')' ;
    public final EugeneParser.toSequence_return toSequence(boolean defer) throws RecognitionException {
        EugeneParser.toSequence_return retval = new EugeneParser.toSequence_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal269=null;
        Token string_literal270=null;
        Token char_literal271=null;
        Token char_literal272=null;

        Object idToken_tree=null;
        Object char_literal269_tree=null;
        Object string_literal270_tree=null;
        Object char_literal271_tree=null;
        Object char_literal272_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2629:2: (idToken= ID '.' 'toSequence' '(' ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2629:4: idToken= ID '.' 'toSequence' '(' ')'
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_toSequence4888); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal269=(Token)match(input,26,FOLLOW_26_in_toSequence4890); 
            char_literal269_tree = 
            (Object)adaptor.create(char_literal269)
            ;
            adaptor.addChild(root_0, char_literal269_tree);


            string_literal270=(Token)match(input,111,FOLLOW_111_in_toSequence4892); 
            string_literal270_tree = 
            (Object)adaptor.create(string_literal270)
            ;
            adaptor.addChild(root_0, string_literal270_tree);


            char_literal271=(Token)match(input,20,FOLLOW_20_in_toSequence4894); 
            char_literal271_tree = 
            (Object)adaptor.create(char_literal271)
            ;
            adaptor.addChild(root_0, char_literal271_tree);


            char_literal272=(Token)match(input,21,FOLLOW_21_in_toSequence4896); 
            char_literal272_tree = 
            (Object)adaptor.create(char_literal272)
            ;
            adaptor.addChild(root_0, char_literal272_tree);



            if(!defer) {
                NamedElement objElement = interp.get((idToken!=null?idToken.getText():null)); 
                if(null == objElement) {
                    throw new EugeneException("I don't know anything about "+(idToken!=null?idToken.getText():null));
                } else {
                    retval.sequence = interp.toSequence(objElement);
                }
            }	
            	

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException exc) {

            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+exc.toString());
            exc.printStackTrace();
            this.cleanUp(1);	
            	
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2646:1: get[boolean defer] returns [NamedElement objElement] : idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')' ;
    public final EugeneParser.get_return get(boolean defer) throws RecognitionException {
        EugeneParser.get_return retval = new EugeneParser.get_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token idxToken=null;
        Token varToken=null;
        Token strToken=null;
        Token char_literal273=null;
        Token string_literal274=null;
        Token char_literal275=null;
        Token char_literal276=null;

        Object idToken_tree=null;
        Object idxToken_tree=null;
        Object varToken_tree=null;
        Object strToken_tree=null;
        Object char_literal273_tree=null;
        Object string_literal274_tree=null;
        Object char_literal275_tree=null;
        Object char_literal276_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2647:2: (idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2647:4: idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')'
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_get4922); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal273=(Token)match(input,26,FOLLOW_26_in_get4924); 
            char_literal273_tree = 
            (Object)adaptor.create(char_literal273)
            ;
            adaptor.addChild(root_0, char_literal273_tree);


            string_literal274=(Token)match(input,93,FOLLOW_93_in_get4926); 
            string_literal274_tree = 
            (Object)adaptor.create(string_literal274)
            ;
            adaptor.addChild(root_0, string_literal274_tree);


            char_literal275=(Token)match(input,20,FOLLOW_20_in_get4928); 
            char_literal275_tree = 
            (Object)adaptor.create(char_literal275)
            ;
            adaptor.addChild(root_0, char_literal275_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2647:29: (idxToken= INT |varToken= ID |strToken= STRING )
            int alt90=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt90=1;
                }
                break;
            case ID:
                {
                alt90=2;
                }
                break;
            case STRING:
                {
                alt90=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;

            }

            switch (alt90) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2647:30: idxToken= INT
                    {
                    idxToken=(Token)match(input,INT,FOLLOW_INT_in_get4933); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2653:6: varToken= ID
                    {
                    varToken=(Token)match(input,ID,FOLLOW_ID_in_get4941); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2659:6: strToken= STRING
                    {
                    strToken=(Token)match(input,STRING,FOLLOW_STRING_in_get4949); 
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


            char_literal276=(Token)match(input,21,FOLLOW_21_in_get4954); 
            char_literal276_tree = 
            (Object)adaptor.create(char_literal276)
            ;
            adaptor.addChild(root_0, char_literal276_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2713:1: size[boolean defer] returns [double nSize] : idToken= ID '.' 'size' '(' ')' -> ^( '.' 'size' ) ;
    public final EugeneParser.size_return size(boolean defer) throws RecognitionException {
        EugeneParser.size_return retval = new EugeneParser.size_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal277=null;
        Token string_literal278=null;
        Token char_literal279=null;
        Token char_literal280=null;

        Object idToken_tree=null;
        Object char_literal277_tree=null;
        Object string_literal278_tree=null;
        Object char_literal279_tree=null;
        Object char_literal280_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2714:2: (idToken= ID '.' 'size' '(' ')' -> ^( '.' 'size' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2714:4: idToken= ID '.' 'size' '(' ')'
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_size4987);  
            stream_ID.add(idToken);


            char_literal277=(Token)match(input,26,FOLLOW_26_in_size4989);  
            stream_26.add(char_literal277);


            string_literal278=(Token)match(input,109,FOLLOW_109_in_size4991);  
            stream_109.add(string_literal278);


            char_literal279=(Token)match(input,20,FOLLOW_20_in_size4993);  
            stream_20.add(char_literal279);


            char_literal280=(Token)match(input,21,FOLLOW_21_in_size4995);  
            stream_21.add(char_literal280);



            if(!defer) {
                retval.nSize = interp.sizeOf((idToken!=null?idToken.getText():null));
            }	
            	

            // AST REWRITE
            // elements: 109, 26
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 2718:4: -> ^( '.' 'size' )
            {
                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2718:7: ^( '.' 'size' )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_26.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                stream_109.nextNode()
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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2727:1: remove[boolean defer] : idToken= ID '.' 'remove' '(' idxToken= expression[defer] ')' -> ^( '.' 'remove' ) ;
    public final EugeneParser.remove_return remove(boolean defer) throws RecognitionException {
        EugeneParser.remove_return retval = new EugeneParser.remove_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal281=null;
        Token string_literal282=null;
        Token char_literal283=null;
        Token char_literal284=null;
        EugeneParser.expression_return idxToken =null;


        Object idToken_tree=null;
        Object char_literal281_tree=null;
        Object string_literal282_tree=null;
        Object char_literal283_tree=null;
        Object char_literal284_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_106=new RewriteRuleTokenStream(adaptor,"token 106");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2728:2: (idToken= ID '.' 'remove' '(' idxToken= expression[defer] ')' -> ^( '.' 'remove' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2728:4: idToken= ID '.' 'remove' '(' idxToken= expression[defer] ')'
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_remove5025);  
            stream_ID.add(idToken);


            char_literal281=(Token)match(input,26,FOLLOW_26_in_remove5027);  
            stream_26.add(char_literal281);


            string_literal282=(Token)match(input,106,FOLLOW_106_in_remove5029);  
            stream_106.add(string_literal282);


            char_literal283=(Token)match(input,20,FOLLOW_20_in_remove5031);  
            stream_20.add(char_literal283);


            pushFollow(FOLLOW_expression_in_remove5035);
            idxToken=expression(defer);

            state._fsp--;

            stream_expression.add(idxToken.getTree());

            char_literal284=(Token)match(input,21,FOLLOW_21_in_remove5038);  
            stream_21.add(char_literal284);



            if(!defer) {
                interp.remove((idToken!=null?idToken.getText():null), (idxToken!=null?idxToken.objElement:null));
            }	
            	

            // AST REWRITE
            // elements: 26, 106
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 2732:4: -> ^( '.' 'remove' )
            {
                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2732:7: ^( '.' 'remove' )
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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2795:1: listOfRules[boolean defer] returns [ArrayList<Rule> lstRules] : idToken= ID ( ',' idToken= ID )* ;
    public final EugeneParser.listOfRules_return listOfRules(boolean defer) throws RecognitionException {
        EugeneParser.listOfRules_return retval = new EugeneParser.listOfRules_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal285=null;

        Object idToken_tree=null;
        Object char_literal285_tree=null;


        retval.lstRules = new ArrayList<Rule>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2800:2: (idToken= ID ( ',' idToken= ID )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2800:4: idToken= ID ( ',' idToken= ID )*
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfRules5084); 
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:4: ( ',' idToken= ID )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==24) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:5: ',' idToken= ID
            	    {
            	    char_literal285=(Token)match(input,24,FOLLOW_24_in_listOfRules5089); 
            	    char_literal285_tree = 
            	    (Object)adaptor.create(char_literal285)
            	    ;
            	    adaptor.addChild(root_0, char_literal285_tree);


            	    idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfRules5093); 
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
            	    break loop91;
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2836:1: combinatorialFunction[boolean defer] returns [DeviceArray objDeviceArray] : functionToken= ( 'permute' | 'product' ) '(' deviceToken= ID ( ',' rulesToken= ( 'strict' | 'flexible' ) )? ( ',' (capToken= expression[defer] )? )? ( ',' (depthToken= expression[defer] )? )? ')' ;
    public final EugeneParser.combinatorialFunction_return combinatorialFunction(boolean defer) throws RecognitionException {
        EugeneParser.combinatorialFunction_return retval = new EugeneParser.combinatorialFunction_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token functionToken=null;
        Token deviceToken=null;
        Token rulesToken=null;
        Token char_literal286=null;
        Token char_literal287=null;
        Token char_literal288=null;
        Token char_literal289=null;
        Token char_literal290=null;
        EugeneParser.expression_return capToken =null;

        EugeneParser.expression_return depthToken =null;


        Object functionToken_tree=null;
        Object deviceToken_tree=null;
        Object rulesToken_tree=null;
        Object char_literal286_tree=null;
        Object char_literal287_tree=null;
        Object char_literal288_tree=null;
        Object char_literal289_tree=null;
        Object char_literal290_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2837:6: (functionToken= ( 'permute' | 'product' ) '(' deviceToken= ID ( ',' rulesToken= ( 'strict' | 'flexible' ) )? ( ',' (capToken= expression[defer] )? )? ( ',' (depthToken= expression[defer] )? )? ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2837:11: functionToken= ( 'permute' | 'product' ) '(' deviceToken= ID ( ',' rulesToken= ( 'strict' | 'flexible' ) )? ( ',' (capToken= expression[defer] )? )? ( ',' (depthToken= expression[defer] )? )? ')'
            {
            root_0 = (Object)adaptor.nil();


            functionToken=(Token)input.LT(1);

            if ( input.LA(1)==101||input.LA(1)==105 ) {
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


            char_literal286=(Token)match(input,20,FOLLOW_20_in_combinatorialFunction5132); 
            char_literal286_tree = 
            (Object)adaptor.create(char_literal286)
            ;
            adaptor.addChild(root_0, char_literal286_tree);


            deviceToken=(Token)match(input,ID,FOLLOW_ID_in_combinatorialFunction5144); 
            deviceToken_tree = 
            (Object)adaptor.create(deviceToken)
            ;
            adaptor.addChild(root_0, deviceToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2839:8: ( ',' rulesToken= ( 'strict' | 'flexible' ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==24) ) {
                int LA92_1 = input.LA(2);

                if ( (LA92_1==90||LA92_1==110) ) {
                    alt92=1;
                }
            }
            switch (alt92) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2839:9: ',' rulesToken= ( 'strict' | 'flexible' )
                    {
                    char_literal287=(Token)match(input,24,FOLLOW_24_in_combinatorialFunction5170); 
                    char_literal287_tree = 
                    (Object)adaptor.create(char_literal287)
                    ;
                    adaptor.addChild(root_0, char_literal287_tree);


                    rulesToken=(Token)input.LT(1);

                    if ( input.LA(1)==90||input.LA(1)==110 ) {
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


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2840:8: ( ',' (capToken= expression[defer] )? )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==24) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2840:9: ',' (capToken= expression[defer] )?
                    {
                    char_literal288=(Token)match(input,24,FOLLOW_24_in_combinatorialFunction5199); 
                    char_literal288_tree = 
                    (Object)adaptor.create(char_literal288)
                    ;
                    adaptor.addChild(root_0, char_literal288_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2840:13: (capToken= expression[defer] )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==FLOAT||LA93_0==ID||LA93_0==INT||LA93_0==STRING||LA93_0==18||LA93_0==20||LA93_0==25||(LA93_0 >= 33 && LA93_0 <= 34)||(LA93_0 >= 36 && LA93_0 <= 39)||(LA93_0 >= 42 && LA93_0 <= 44)||LA93_0==46||(LA93_0 >= 49 && LA93_0 <= 53)||LA93_0==55||(LA93_0 >= 58 && LA93_0 <= 65)||LA93_0==69||LA93_0==73||(LA93_0 >= 77 && LA93_0 <= 79)||LA93_0==81||LA93_0==89||LA93_0==112) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2840:14: capToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_combinatorialFunction5204);
                            capToken=expression(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, capToken.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2841:8: ( ',' (depthToken= expression[defer] )? )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==24) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2841:9: ',' (depthToken= expression[defer] )?
                    {
                    char_literal289=(Token)match(input,24,FOLLOW_24_in_combinatorialFunction5221); 
                    char_literal289_tree = 
                    (Object)adaptor.create(char_literal289)
                    ;
                    adaptor.addChild(root_0, char_literal289_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2841:13: (depthToken= expression[defer] )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==FLOAT||LA95_0==ID||LA95_0==INT||LA95_0==STRING||LA95_0==18||LA95_0==20||LA95_0==25||(LA95_0 >= 33 && LA95_0 <= 34)||(LA95_0 >= 36 && LA95_0 <= 39)||(LA95_0 >= 42 && LA95_0 <= 44)||LA95_0==46||(LA95_0 >= 49 && LA95_0 <= 53)||LA95_0==55||(LA95_0 >= 58 && LA95_0 <= 65)||LA95_0==69||LA95_0==73||(LA95_0 >= 77 && LA95_0 <= 79)||LA95_0==81||LA95_0==89||LA95_0==112) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2841:14: depthToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_combinatorialFunction5226);
                            depthToken=expression(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, depthToken.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            char_literal290=(Token)match(input,21,FOLLOW_21_in_combinatorialFunction5233); 
            char_literal290_tree = 
            (Object)adaptor.create(char_literal290)
            ;
            adaptor.addChild(root_0, char_literal290_tree);


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
        catch (EugeneException e) {

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2859:1: getObject[NamedElement objElement] : ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )* ;
    public final EugeneParser.getObject_return getObject(NamedElement objElement) throws RecognitionException {
        EugeneParser.getObject_return retval = new EugeneParser.getObject_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token elementToken=null;
        Token char_literal291=null;
        Token char_literal292=null;
        Token char_literal293=null;
        EugeneParser.expression_return exprToken =null;


        Object elementToken_tree=null;
        Object char_literal291_tree=null;
        Object char_literal292_tree=null;
        Object char_literal293_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2860:2: ( ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2860:4: ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )*
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2860:4: ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )*
            loop97:
            do {
                int alt97=3;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==26) ) {
                    alt97=1;
                }
                else if ( (LA97_0==81) ) {
                    alt97=2;
                }


                switch (alt97) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2860:5: ( '.' elementToken= ID )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2860:5: ( '.' elementToken= ID )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2860:6: '.' elementToken= ID
            	    {
            	    char_literal291=(Token)match(input,26,FOLLOW_26_in_getObject5265); 
            	    char_literal291_tree = 
            	    (Object)adaptor.create(char_literal291)
            	    ;
            	    adaptor.addChild(root_0, char_literal291_tree);


            	    elementToken=(Token)match(input,ID,FOLLOW_ID_in_getObject5269); 
            	    elementToken_tree = 
            	    (Object)adaptor.create(elementToken)
            	    ;
            	    adaptor.addChild(root_0, elementToken_tree);


            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2860:29: ( '[' exprToken= expression[true] ']' )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2860:29: ( '[' exprToken= expression[true] ']' )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2860:30: '[' exprToken= expression[true] ']'
            	    {
            	    char_literal292=(Token)match(input,81,FOLLOW_81_in_getObject5275); 
            	    char_literal292_tree = 
            	    (Object)adaptor.create(char_literal292)
            	    ;
            	    adaptor.addChild(root_0, char_literal292_tree);


            	    pushFollow(FOLLOW_expression_in_getObject5279);
            	    exprToken=expression(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, exprToken.getTree());

            	    char_literal293=(Token)match(input,82,FOLLOW_82_in_getObject5282); 
            	    char_literal293_tree = 
            	    (Object)adaptor.create(char_literal293)
            	    ;
            	    adaptor.addChild(root_0, char_literal293_tree);


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
    // $ANTLR end "getObject"


    public static class printStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "printStatement"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2898:1: printStatement[boolean defer] : (| 'println' '(' ')' | 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' | 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' );
    public final EugeneParser.printStatement_return printStatement(boolean defer) throws RecognitionException {
        EugeneParser.printStatement_return retval = new EugeneParser.printStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal294=null;
        Token char_literal295=null;
        Token char_literal296=null;
        Token string_literal297=null;
        Token char_literal298=null;
        Token char_literal299=null;
        Token char_literal300=null;
        Token string_literal301=null;
        Token char_literal302=null;
        Token char_literal303=null;
        Token char_literal304=null;
        EugeneParser.whatToPrint_return printToken1 =null;

        EugeneParser.whatToPrint_return printToken2 =null;


        Object string_literal294_tree=null;
        Object char_literal295_tree=null;
        Object char_literal296_tree=null;
        Object string_literal297_tree=null;
        Object char_literal298_tree=null;
        Object char_literal299_tree=null;
        Object char_literal300_tree=null;
        Object string_literal301_tree=null;
        Object char_literal302_tree=null;
        Object char_literal303_tree=null;
        Object char_literal304_tree=null;


        System.err.flush();
        System.out.flush();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2906:2: (| 'println' '(' ')' | 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' | 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' )
            int alt100=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt100=1;
                }
                break;
            case 104:
                {
                int LA100_2 = input.LA(2);

                if ( (LA100_2==20) ) {
                    int LA100_4 = input.LA(3);

                    if ( (LA100_4==21) ) {
                        alt100=2;
                    }
                    else if ( (LA100_4==FLOAT||LA100_4==ID||LA100_4==INT||LA100_4==STRING||LA100_4==18||LA100_4==20||LA100_4==25||(LA100_4 >= 33 && LA100_4 <= 34)||(LA100_4 >= 36 && LA100_4 <= 39)||(LA100_4 >= 42 && LA100_4 <= 44)||LA100_4==46||(LA100_4 >= 49 && LA100_4 <= 55)||(LA100_4 >= 58 && LA100_4 <= 65)||LA100_4==69||LA100_4==73||(LA100_4 >= 76 && LA100_4 <= 79)||LA100_4==81||LA100_4==89||LA100_4==101||LA100_4==105||LA100_4==112) ) {
                        alt100=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 100, 4, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 100, 2, input);

                    throw nvae;

                }
                }
                break;
            case 103:
                {
                alt100=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;

            }

            switch (alt100) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2907:9: 
                    {
                    root_0 = (Object)adaptor.nil();


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2907:11: 'println' '(' ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal294=(Token)match(input,104,FOLLOW_104_in_printStatement5325); 
                    string_literal294_tree = 
                    (Object)adaptor.create(string_literal294)
                    ;
                    adaptor.addChild(root_0, string_literal294_tree);


                    char_literal295=(Token)match(input,20,FOLLOW_20_in_printStatement5327); 
                    char_literal295_tree = 
                    (Object)adaptor.create(char_literal295)
                    ;
                    adaptor.addChild(root_0, char_literal295_tree);


                    char_literal296=(Token)match(input,21,FOLLOW_21_in_printStatement5329); 
                    char_literal296_tree = 
                    (Object)adaptor.create(char_literal296)
                    ;
                    adaptor.addChild(root_0, char_literal296_tree);



                    if(!defer) {
                            System.out.println();
                    }
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2912:11: 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal297=(Token)match(input,103,FOLLOW_103_in_printStatement5343); 
                    string_literal297_tree = 
                    (Object)adaptor.create(string_literal297)
                    ;
                    adaptor.addChild(root_0, string_literal297_tree);


                    char_literal298=(Token)match(input,20,FOLLOW_20_in_printStatement5345); 
                    char_literal298_tree = 
                    (Object)adaptor.create(char_literal298)
                    ;
                    adaptor.addChild(root_0, char_literal298_tree);


                    pushFollow(FOLLOW_whatToPrint_in_printStatement5349);
                    printToken1=whatToPrint(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printToken1.getTree());


                    if(!defer) {        
                        System.out.print((printToken1!=null?printToken1.s:null));
                    }
                            

                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2916:11: ( ',' printToken2= whatToPrint[defer] )*
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==24) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2916:12: ',' printToken2= whatToPrint[defer]
                    	    {
                    	    char_literal299=(Token)match(input,24,FOLLOW_24_in_printStatement5355); 
                    	    char_literal299_tree = 
                    	    (Object)adaptor.create(char_literal299)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal299_tree);


                    	    pushFollow(FOLLOW_whatToPrint_in_printStatement5359);
                    	    printToken2=whatToPrint(defer);

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, printToken2.getTree());


                    	    if(!defer) {                
                    	        System.out.print((printToken2!=null?printToken2.s:null));
                    	    }	
                    	    	

                    	    }
                    	    break;

                    	default :
                    	    break loop98;
                        }
                    } while (true);


                    char_literal300=(Token)match(input,21,FOLLOW_21_in_printStatement5366); 
                    char_literal300_tree = 
                    (Object)adaptor.create(char_literal300)
                    ;
                    adaptor.addChild(root_0, char_literal300_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2921:11: 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal301=(Token)match(input,104,FOLLOW_104_in_printStatement5378); 
                    string_literal301_tree = 
                    (Object)adaptor.create(string_literal301)
                    ;
                    adaptor.addChild(root_0, string_literal301_tree);


                    char_literal302=(Token)match(input,20,FOLLOW_20_in_printStatement5380); 
                    char_literal302_tree = 
                    (Object)adaptor.create(char_literal302)
                    ;
                    adaptor.addChild(root_0, char_literal302_tree);


                    pushFollow(FOLLOW_whatToPrint_in_printStatement5384);
                    printToken1=whatToPrint(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printToken1.getTree());


                    if(!defer) {        
                        System.out.print((printToken1!=null?printToken1.s:null));
                    }
                            

                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2925:11: ( ',' printToken2= whatToPrint[defer] )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==24) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2925:12: ',' printToken2= whatToPrint[defer]
                    	    {
                    	    char_literal303=(Token)match(input,24,FOLLOW_24_in_printStatement5390); 
                    	    char_literal303_tree = 
                    	    (Object)adaptor.create(char_literal303)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal303_tree);


                    	    pushFollow(FOLLOW_whatToPrint_in_printStatement5394);
                    	    printToken2=whatToPrint(defer);

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, printToken2.getTree());


                    	    if(!defer) {                
                    	        System.out.print((printToken2!=null?printToken2.s:null));
                    	    }	
                    	    	

                    	    }
                    	    break;

                    	default :
                    	    break loop99;
                        }
                    } while (true);


                    char_literal304=(Token)match(input,21,FOLLOW_21_in_printStatement5401); 
                    char_literal304_tree = 
                    (Object)adaptor.create(char_literal304)
                    ;
                    adaptor.addChild(root_0, char_literal304_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2936:1: whatToPrint[boolean defer] returns [String s] : (valueToken= expression[defer] |wrapperToken= wrappedStatement[defer] );
    public final EugeneParser.whatToPrint_return whatToPrint(boolean defer) throws RecognitionException {
        EugeneParser.whatToPrint_return retval = new EugeneParser.whatToPrint_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.expression_return valueToken =null;

        EugeneParser.wrappedStatement_return wrapperToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2937:2: (valueToken= expression[defer] |wrapperToken= wrappedStatement[defer] )
            int alt101=2;
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
            case 43:
            case 44:
            case 46:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 55:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 69:
            case 73:
            case 77:
            case 78:
            case 79:
            case 81:
            case 89:
            case 112:
                {
                alt101=1;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    switch ( input.LA(3) ) {
                    case 93:
                        {
                        int LA101_5 = input.LA(4);

                        if ( (LA101_5==20) ) {
                            switch ( input.LA(5) ) {
                            case INT:
                                {
                                int LA101_11 = input.LA(6);

                                if ( ((LA101_11 >= 18 && LA101_11 <= 19)||(LA101_11 >= 21 && LA101_11 <= 23)||LA101_11==25||LA101_11==30||(LA101_11 >= 33 && LA101_11 <= 34)||(LA101_11 >= 36 && LA101_11 <= 40)||(LA101_11 >= 42 && LA101_11 <= 44)||LA101_11==46||(LA101_11 >= 49 && LA101_11 <= 51)||(LA101_11 >= 55 && LA101_11 <= 56)||(LA101_11 >= 58 && LA101_11 <= 61)||(LA101_11 >= 63 && LA101_11 <= 65)||(LA101_11 >= 68 && LA101_11 <= 69)||LA101_11==73||(LA101_11 >= 77 && LA101_11 <= 80)||LA101_11==83||LA101_11==96||LA101_11==116) ) {
                                    alt101=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 101, 11, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case ID:
                                {
                                int LA101_12 = input.LA(6);

                                if ( ((LA101_12 >= 18 && LA101_12 <= 19)||(LA101_12 >= 21 && LA101_12 <= 23)||(LA101_12 >= 25 && LA101_12 <= 26)||LA101_12==30||(LA101_12 >= 33 && LA101_12 <= 34)||(LA101_12 >= 36 && LA101_12 <= 40)||(LA101_12 >= 42 && LA101_12 <= 44)||LA101_12==46||(LA101_12 >= 49 && LA101_12 <= 51)||(LA101_12 >= 55 && LA101_12 <= 56)||(LA101_12 >= 58 && LA101_12 <= 61)||(LA101_12 >= 63 && LA101_12 <= 65)||(LA101_12 >= 68 && LA101_12 <= 69)||LA101_12==73||(LA101_12 >= 77 && LA101_12 <= 81)||LA101_12==83||LA101_12==96||LA101_12==116) ) {
                                    alt101=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 101, 12, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case STRING:
                                {
                                int LA101_13 = input.LA(6);

                                if ( ((LA101_13 >= 18 && LA101_13 <= 19)||(LA101_13 >= 21 && LA101_13 <= 23)||LA101_13==25||LA101_13==30||(LA101_13 >= 33 && LA101_13 <= 34)||(LA101_13 >= 36 && LA101_13 <= 40)||(LA101_13 >= 42 && LA101_13 <= 44)||LA101_13==46||(LA101_13 >= 49 && LA101_13 <= 51)||(LA101_13 >= 55 && LA101_13 <= 56)||(LA101_13 >= 58 && LA101_13 <= 61)||(LA101_13 >= 63 && LA101_13 <= 65)||(LA101_13 >= 68 && LA101_13 <= 69)||LA101_13==73||(LA101_13 >= 77 && LA101_13 <= 80)||LA101_13==83||LA101_13==96||LA101_13==116) ) {
                                    alt101=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 101, 13, input);

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
                            case 43:
                            case 44:
                            case 46:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 55:
                            case 58:
                            case 59:
                            case 60:
                            case 61:
                            case 62:
                            case 63:
                            case 64:
                            case 65:
                            case 69:
                            case 73:
                            case 77:
                            case 78:
                            case 79:
                            case 81:
                            case 89:
                            case 112:
                                {
                                alt101=1;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 101, 8, input);

                                throw nvae;

                            }

                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 101, 5, input);

                            throw nvae;

                        }
                        }
                        break;
                    case 109:
                        {
                        int LA101_6 = input.LA(4);

                        if ( (LA101_6==20) ) {
                            int LA101_9 = input.LA(5);

                            if ( (LA101_9==21) ) {
                                alt101=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 101, 9, input);

                                throw nvae;

                            }
                        }
                        else if ( ((LA101_6 >= 18 && LA101_6 <= 19)||(LA101_6 >= 21 && LA101_6 <= 26)||LA101_6==30||(LA101_6 >= 33 && LA101_6 <= 34)||(LA101_6 >= 36 && LA101_6 <= 40)||(LA101_6 >= 42 && LA101_6 <= 44)||LA101_6==46||(LA101_6 >= 49 && LA101_6 <= 51)||(LA101_6 >= 55 && LA101_6 <= 56)||(LA101_6 >= 58 && LA101_6 <= 61)||(LA101_6 >= 63 && LA101_6 <= 65)||(LA101_6 >= 68 && LA101_6 <= 69)||LA101_6==73||(LA101_6 >= 77 && LA101_6 <= 81)||LA101_6==83||LA101_6==96||LA101_6==116) ) {
                            alt101=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 101, 6, input);

                            throw nvae;

                        }
                        }
                        break;
                    case 85:
                    case 99:
                    case 106:
                        {
                        alt101=2;
                        }
                        break;
                    case 111:
                        {
                        int LA101_7 = input.LA(4);

                        if ( (LA101_7==20) ) {
                            int LA101_10 = input.LA(5);

                            if ( (LA101_10==21) ) {
                                alt101=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 101, 10, input);

                                throw nvae;

                            }
                        }
                        else if ( ((LA101_7 >= 18 && LA101_7 <= 19)||(LA101_7 >= 21 && LA101_7 <= 26)||LA101_7==30||(LA101_7 >= 33 && LA101_7 <= 34)||(LA101_7 >= 36 && LA101_7 <= 40)||(LA101_7 >= 42 && LA101_7 <= 44)||LA101_7==46||(LA101_7 >= 49 && LA101_7 <= 51)||(LA101_7 >= 55 && LA101_7 <= 56)||(LA101_7 >= 58 && LA101_7 <= 61)||(LA101_7 >= 63 && LA101_7 <= 65)||(LA101_7 >= 68 && LA101_7 <= 69)||LA101_7==73||(LA101_7 >= 77 && LA101_7 <= 81)||LA101_7==83||LA101_7==96||LA101_7==116) ) {
                            alt101=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 101, 7, input);

                            throw nvae;

                        }
                        }
                        break;
                    case ID:
                    case 97:
                    case 98:
                        {
                        alt101=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 101, 4, input);

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
                case 43:
                case 44:
                case 46:
                case 49:
                case 50:
                case 51:
                case 55:
                case 56:
                case 58:
                case 59:
                case 60:
                case 61:
                case 63:
                case 64:
                case 65:
                case 68:
                case 69:
                case 73:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 83:
                case 96:
                case 116:
                    {
                    alt101=1;
                    }
                    break;
                case 27:
                case 28:
                case 29:
                    {
                    alt101=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 2, input);

                    throw nvae;

                }

                }
                break;
            case 54:
            case 76:
            case 101:
            case 105:
                {
                alt101=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }

            switch (alt101) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2937:4: valueToken= expression[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_expression_in_whatToPrint5422);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2946:4: wrapperToken= wrappedStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_wrappedStatement_in_whatToPrint5432);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2957:1: dataExtraction[boolean defer] : ( sbolStatement[defer] | genbankStatement[defer] | pigeonStatement[defer] | registryStatement[defer] );
    public final EugeneParser.dataExtraction_return dataExtraction(boolean defer) throws RecognitionException {
        EugeneParser.dataExtraction_return retval = new EugeneParser.dataExtraction_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.sbolStatement_return sbolStatement305 =null;

        EugeneParser.genbankStatement_return genbankStatement306 =null;

        EugeneParser.pigeonStatement_return pigeonStatement307 =null;

        EugeneParser.registryStatement_return registryStatement308 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2958:2: ( sbolStatement[defer] | genbankStatement[defer] | pigeonStatement[defer] | registryStatement[defer] )
            int alt102=4;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt102=1;
                }
                break;
            case 54:
                {
                alt102=2;
                }
                break;
            case 102:
                {
                alt102=3;
                }
                break;
            case 74:
                {
                alt102=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }

            switch (alt102) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2958:4: sbolStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_sbolStatement_in_dataExtraction5450);
                    sbolStatement305=sbolStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolStatement305.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2959:4: genbankStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_genbankStatement_in_dataExtraction5456);
                    genbankStatement306=genbankStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankStatement306.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2960:4: pigeonStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_pigeonStatement_in_dataExtraction5462);
                    pigeonStatement307=pigeonStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, pigeonStatement307.getTree());

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2961:4: registryStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_registryStatement_in_dataExtraction5468);
                    registryStatement308=registryStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, registryStatement308.getTree());

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2965:1: sbolStatement[boolean defer] returns [NamedElement objElement] : 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] ) ;
    public final EugeneParser.sbolStatement_return sbolStatement(boolean defer) throws RecognitionException {
        EugeneParser.sbolStatement_return retval = new EugeneParser.sbolStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal309=null;
        Token char_literal310=null;
        EugeneParser.sbolImportStatement_return importToken =null;

        EugeneParser.sbolExportStatement_return sbolExportStatement311 =null;


        Object string_literal309_tree=null;
        Object char_literal310_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2966:2: ( 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2966:4: 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] )
            {
            root_0 = (Object)adaptor.nil();


            string_literal309=(Token)match(input,76,FOLLOW_76_in_sbolStatement5488); 
            string_literal309_tree = 
            (Object)adaptor.create(string_literal309)
            ;
            adaptor.addChild(root_0, string_literal309_tree);


            char_literal310=(Token)match(input,26,FOLLOW_26_in_sbolStatement5490); 
            char_literal310_tree = 
            (Object)adaptor.create(char_literal310)
            ;
            adaptor.addChild(root_0, char_literal310_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2966:15: ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==88) ) {
                alt103=1;
            }
            else if ( (LA103_0==95) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }
            switch (alt103) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2966:16: sbolExportStatement[defer]
                    {
                    pushFollow(FOLLOW_sbolExportStatement_in_sbolStatement5493);
                    sbolExportStatement311=sbolExportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolExportStatement311.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2966:45: importToken= sbolImportStatement[defer]
                    {
                    pushFollow(FOLLOW_sbolImportStatement_in_sbolStatement5500);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2973:1: sbolExportStatement[boolean defer] : 'export' '(' idToken= ID ',' filenameToken= STRING ')' ;
    public final EugeneParser.sbolExportStatement_return sbolExportStatement(boolean defer) throws RecognitionException {
        EugeneParser.sbolExportStatement_return retval = new EugeneParser.sbolExportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token filenameToken=null;
        Token string_literal312=null;
        Token char_literal313=null;
        Token char_literal314=null;
        Token char_literal315=null;

        Object idToken_tree=null;
        Object filenameToken_tree=null;
        Object string_literal312_tree=null;
        Object char_literal313_tree=null;
        Object char_literal314_tree=null;
        Object char_literal315_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2974:2: ( 'export' '(' idToken= ID ',' filenameToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2974:4: 'export' '(' idToken= ID ',' filenameToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal312=(Token)match(input,88,FOLLOW_88_in_sbolExportStatement5517); 
            string_literal312_tree = 
            (Object)adaptor.create(string_literal312)
            ;
            adaptor.addChild(root_0, string_literal312_tree);


            char_literal313=(Token)match(input,20,FOLLOW_20_in_sbolExportStatement5519); 
            char_literal313_tree = 
            (Object)adaptor.create(char_literal313)
            ;
            adaptor.addChild(root_0, char_literal313_tree);


            idToken=(Token)match(input,ID,FOLLOW_ID_in_sbolExportStatement5523); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal314=(Token)match(input,24,FOLLOW_24_in_sbolExportStatement5525); 
            char_literal314_tree = 
            (Object)adaptor.create(char_literal314)
            ;
            adaptor.addChild(root_0, char_literal314_tree);


            filenameToken=(Token)match(input,STRING,FOLLOW_STRING_in_sbolExportStatement5529); 
            filenameToken_tree = 
            (Object)adaptor.create(filenameToken)
            ;
            adaptor.addChild(root_0, filenameToken_tree);


            char_literal315=(Token)match(input,21,FOLLOW_21_in_sbolExportStatement5531); 
            char_literal315_tree = 
            (Object)adaptor.create(char_literal315)
            ;
            adaptor.addChild(root_0, char_literal315_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2988:1: sbolImportStatement[boolean defer] returns [NamedElement objElement] : 'import' '(' fileToken= STRING ')' ;
    public final EugeneParser.sbolImportStatement_return sbolImportStatement(boolean defer) throws RecognitionException {
        EugeneParser.sbolImportStatement_return retval = new EugeneParser.sbolImportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token fileToken=null;
        Token string_literal316=null;
        Token char_literal317=null;
        Token char_literal318=null;

        Object fileToken_tree=null;
        Object string_literal316_tree=null;
        Object char_literal317_tree=null;
        Object char_literal318_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2990:2: ( 'import' '(' fileToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2990:4: 'import' '(' fileToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal316=(Token)match(input,95,FOLLOW_95_in_sbolImportStatement5560); 
            string_literal316_tree = 
            (Object)adaptor.create(string_literal316)
            ;
            adaptor.addChild(root_0, string_literal316_tree);


            char_literal317=(Token)match(input,20,FOLLOW_20_in_sbolImportStatement5562); 
            char_literal317_tree = 
            (Object)adaptor.create(char_literal317)
            ;
            adaptor.addChild(root_0, char_literal317_tree);


            fileToken=(Token)match(input,STRING,FOLLOW_STRING_in_sbolImportStatement5566); 
            fileToken_tree = 
            (Object)adaptor.create(fileToken)
            ;
            adaptor.addChild(root_0, fileToken_tree);


            char_literal318=(Token)match(input,21,FOLLOW_21_in_sbolImportStatement5568); 
            char_literal318_tree = 
            (Object)adaptor.create(char_literal318)
            ;
            adaptor.addChild(root_0, char_literal318_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3002:1: genbankStatement[boolean defer] returns [NamedElement objElement] : 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] ) ;
    public final EugeneParser.genbankStatement_return genbankStatement(boolean defer) throws RecognitionException {
        EugeneParser.genbankStatement_return retval = new EugeneParser.genbankStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal319=null;
        Token char_literal320=null;
        EugeneParser.genbankImportStatement_return importToken =null;

        EugeneParser.genbankExportStatement_return genbankExportStatement321 =null;


        Object string_literal319_tree=null;
        Object char_literal320_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3003:2: ( 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3003:4: 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] )
            {
            root_0 = (Object)adaptor.nil();


            string_literal319=(Token)match(input,54,FOLLOW_54_in_genbankStatement5594); 
            string_literal319_tree = 
            (Object)adaptor.create(string_literal319)
            ;
            adaptor.addChild(root_0, string_literal319_tree);


            char_literal320=(Token)match(input,26,FOLLOW_26_in_genbankStatement5596); 
            char_literal320_tree = 
            (Object)adaptor.create(char_literal320)
            ;
            adaptor.addChild(root_0, char_literal320_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3003:18: (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==95) ) {
                alt104=1;
            }
            else if ( (LA104_0==88) ) {
                alt104=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;

            }
            switch (alt104) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3003:19: importToken= genbankImportStatement[defer]
                    {
                    pushFollow(FOLLOW_genbankImportStatement_in_genbankStatement5601);
                    importToken=genbankImportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, importToken.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3003:63: genbankExportStatement[defer]
                    {
                    pushFollow(FOLLOW_genbankExportStatement_in_genbankStatement5606);
                    genbankExportStatement321=genbankExportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankExportStatement321.getTree());

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3010:1: genbankExportStatement[boolean defer] returns [NamedElement objElement] : 'export' '(' ')' ;
    public final EugeneParser.genbankExportStatement_return genbankExportStatement(boolean defer) throws RecognitionException {
        EugeneParser.genbankExportStatement_return retval = new EugeneParser.genbankExportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal322=null;
        Token char_literal323=null;
        Token char_literal324=null;

        Object string_literal322_tree=null;
        Object char_literal323_tree=null;
        Object char_literal324_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3011:2: ( 'export' '(' ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3011:4: 'export' '(' ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal322=(Token)match(input,88,FOLLOW_88_in_genbankExportStatement5629); 
            string_literal322_tree = 
            (Object)adaptor.create(string_literal322)
            ;
            adaptor.addChild(root_0, string_literal322_tree);


            char_literal323=(Token)match(input,20,FOLLOW_20_in_genbankExportStatement5631); 
            char_literal323_tree = 
            (Object)adaptor.create(char_literal323)
            ;
            adaptor.addChild(root_0, char_literal323_tree);


            char_literal324=(Token)match(input,21,FOLLOW_21_in_genbankExportStatement5633); 
            char_literal324_tree = 
            (Object)adaptor.create(char_literal324)
            ;
            adaptor.addChild(root_0, char_literal324_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3014:1: genbankImportStatement[boolean defer] returns [NamedElement objElement] : 'import' '(' typeToken= ID ',' partToken= STRING ')' ;
    public final EugeneParser.genbankImportStatement_return genbankImportStatement(boolean defer) throws RecognitionException {
        EugeneParser.genbankImportStatement_return retval = new EugeneParser.genbankImportStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token typeToken=null;
        Token partToken=null;
        Token string_literal325=null;
        Token char_literal326=null;
        Token char_literal327=null;
        Token char_literal328=null;

        Object typeToken_tree=null;
        Object partToken_tree=null;
        Object string_literal325_tree=null;
        Object char_literal326_tree=null;
        Object char_literal327_tree=null;
        Object char_literal328_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3015:2: ( 'import' '(' typeToken= ID ',' partToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3015:4: 'import' '(' typeToken= ID ',' partToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal325=(Token)match(input,95,FOLLOW_95_in_genbankImportStatement5650); 
            string_literal325_tree = 
            (Object)adaptor.create(string_literal325)
            ;
            adaptor.addChild(root_0, string_literal325_tree);


            char_literal326=(Token)match(input,20,FOLLOW_20_in_genbankImportStatement5652); 
            char_literal326_tree = 
            (Object)adaptor.create(char_literal326)
            ;
            adaptor.addChild(root_0, char_literal326_tree);


            typeToken=(Token)match(input,ID,FOLLOW_ID_in_genbankImportStatement5656); 
            typeToken_tree = 
            (Object)adaptor.create(typeToken)
            ;
            adaptor.addChild(root_0, typeToken_tree);


            char_literal327=(Token)match(input,24,FOLLOW_24_in_genbankImportStatement5658); 
            char_literal327_tree = 
            (Object)adaptor.create(char_literal327)
            ;
            adaptor.addChild(root_0, char_literal327_tree);


            partToken=(Token)match(input,STRING,FOLLOW_STRING_in_genbankImportStatement5662); 
            partToken_tree = 
            (Object)adaptor.create(partToken)
            ;
            adaptor.addChild(root_0, partToken_tree);


            char_literal328=(Token)match(input,21,FOLLOW_21_in_genbankImportStatement5664); 
            char_literal328_tree = 
            (Object)adaptor.create(char_literal328)
            ;
            adaptor.addChild(root_0, char_literal328_tree);



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
    // $ANTLR end "genbankImportStatement"


    public static class pigeonStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pigeonStatement"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3040:1: pigeonStatement[boolean defer] : 'pigeon' '(' idToken= ID ')' ;
    public final EugeneParser.pigeonStatement_return pigeonStatement(boolean defer) throws RecognitionException {
        EugeneParser.pigeonStatement_return retval = new EugeneParser.pigeonStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token string_literal329=null;
        Token char_literal330=null;
        Token char_literal331=null;

        Object idToken_tree=null;
        Object string_literal329_tree=null;
        Object char_literal330_tree=null;
        Object char_literal331_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3041:2: ( 'pigeon' '(' idToken= ID ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3041:4: 'pigeon' '(' idToken= ID ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal329=(Token)match(input,102,FOLLOW_102_in_pigeonStatement5680); 
            string_literal329_tree = 
            (Object)adaptor.create(string_literal329)
            ;
            adaptor.addChild(root_0, string_literal329_tree);


            char_literal330=(Token)match(input,20,FOLLOW_20_in_pigeonStatement5682); 
            char_literal330_tree = 
            (Object)adaptor.create(char_literal330)
            ;
            adaptor.addChild(root_0, char_literal330_tree);


            idToken=(Token)match(input,ID,FOLLOW_ID_in_pigeonStatement5686); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal331=(Token)match(input,21,FOLLOW_21_in_pigeonStatement5688); 
            char_literal331_tree = 
            (Object)adaptor.create(char_literal331)
            ;
            adaptor.addChild(root_0, char_literal331_tree);



            if(!defer) {
                Pigeon.draw((idToken!=null?idToken.getText():null));    
            }		


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (EugeneException e) {

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
    // $ANTLR end "pigeonStatement"


    public static class registryStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "registryStatement"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3055:1: registryStatement[boolean defer] : 'Registry' '.' 'import' '(' nameToken= STRING ')' ;
    public final EugeneParser.registryStatement_return registryStatement(boolean defer) throws RecognitionException {
        EugeneParser.registryStatement_return retval = new EugeneParser.registryStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal332=null;
        Token char_literal333=null;
        Token string_literal334=null;
        Token char_literal335=null;
        Token char_literal336=null;

        Object nameToken_tree=null;
        Object string_literal332_tree=null;
        Object char_literal333_tree=null;
        Object string_literal334_tree=null;
        Object char_literal335_tree=null;
        Object char_literal336_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3056:2: ( 'Registry' '.' 'import' '(' nameToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3056:4: 'Registry' '.' 'import' '(' nameToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal332=(Token)match(input,74,FOLLOW_74_in_registryStatement5711); 
            string_literal332_tree = 
            (Object)adaptor.create(string_literal332)
            ;
            adaptor.addChild(root_0, string_literal332_tree);


            char_literal333=(Token)match(input,26,FOLLOW_26_in_registryStatement5713); 
            char_literal333_tree = 
            (Object)adaptor.create(char_literal333)
            ;
            adaptor.addChild(root_0, char_literal333_tree);


            string_literal334=(Token)match(input,95,FOLLOW_95_in_registryStatement5715); 
            string_literal334_tree = 
            (Object)adaptor.create(string_literal334)
            ;
            adaptor.addChild(root_0, string_literal334_tree);


            char_literal335=(Token)match(input,20,FOLLOW_20_in_registryStatement5717); 
            char_literal335_tree = 
            (Object)adaptor.create(char_literal335)
            ;
            adaptor.addChild(root_0, char_literal335_tree);


            nameToken=(Token)match(input,STRING,FOLLOW_STRING_in_registryStatement5721); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            char_literal336=(Token)match(input,21,FOLLOW_21_in_registryStatement5723); 
            char_literal336_tree = 
            (Object)adaptor.create(char_literal336)
            ;
            adaptor.addChild(root_0, char_literal336_tree);



            if(!defer) {

                String name = (nameToken!=null?nameToken.getText():null);
                if(null != name) {
                
                    // remove the double quotas
                    name = name.substring(1, name.length()-2);
                    
                    if(null == this.registryImporter) {
                        this.registryImporter = new SBOLRegistryImporter();
                    }
                    
                    List<Component> lst = this.registryImporter.importComponent((nameToken!=null?nameToken.getText():null));
                    if(null!=lst && !lst.isEmpty()) {
                        for(Component component : lst) {
                            SymbolTables.put(component);
                        }
                    } else {
                        System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getCharPositionInLine():0)+" => "+
                            "Cannot import "+name+"!");
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
    // $ANTLR end "registryStatement"

    // Delegated rules


 

    public static final BitSet FOLLOW_eugeneStatement_in_prog56 = new BitSet(new long[]{0x0241A20100001800L,0x00061BF058501DC4L});
    public static final BitSet FOLLOW_EOF_in_prog59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_eugeneStatement70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_eugeneStatement78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_statement117 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataExtraction_in_statement124 = new BitSet(new long[]{0x0000000100000000L});
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
    public static final BitSet FOLLOW_objectAssignmentStatement_in_computationalStatement250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_assignment275 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_assignment279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_assignment288 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_functionCall_in_assignment292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_assignment307 = new BitSet(new long[]{0x0040000000000800L,0x0000022000001000L});
    public static final BitSet FOLLOW_wrappedStatement_in_assignment311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_assignment326 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_assignment328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_assignment342 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_assignment344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filename_in_listOfFilenames365 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfFilenames369 = new BitSet(new long[]{0xFFFFFFFEFFEFFFF0L,0x003FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_listOfFilenames_in_listOfFilenames371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_filename393 = new BitSet(new long[]{0xFFFFFFFEFEEFFFF2L,0x003FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_collectionDeclaration_in_declarationStatement427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_declarationStatement433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_declarationStatement439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_declarationStatement445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_declarationStatement451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayDeclaration_in_declarationStatement457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_declarationStatement463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_imageDeclaration_in_declarationStatement469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceTypeDeclaration_in_declarationStatement475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationDeclaration_in_declarationStatement482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_collectionDeclaration505 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_collectionDeclaration509 = new BitSet(new long[]{0x0000000802900002L});
    public static final BitSet FOLLOW_collectionDefinition_in_collectionDeclaration519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_collectionDeclaration532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_collectionDefinition580 = new BitSet(new long[]{0x0000800000000800L,0x00000000000001C0L});
    public static final BitSet FOLLOW_listOfCollectionComponents_in_collectionDefinition587 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_collectionDefinition593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_collectionDefinition600 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_INCLUDE_in_collectionDefinition604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionElement_in_listOfCollectionComponents650 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfCollectionComponents656 = new BitSet(new long[]{0x0000800000000800L,0x00000000000001C0L});
    public static final BitSet FOLLOW_listOfCollectionComponents_in_listOfCollectionComponents660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_collectionElement698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_collectionElement706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_collectionElement723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_collectionElement733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_collectionElement750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_propertyDeclaration773 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_dynamicNaming_in_propertyDeclaration777 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_propertyDeclaration780 = new BitSet(new long[]{0x0000000000000000L,0x0002001000100000L});
    public static final BitSet FOLLOW_propertyType_in_propertyDeclaration784 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_propertyDeclaration786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_propertyType805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_propertyType810 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_propertyType812 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_propertyType814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_propertyType819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_propertyType824 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_propertyType826 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_propertyType828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_propertyType833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyType_in_variableDeclaration857 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfVariables_in_variableDeclaration861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfVariables889 = new BitSet(new long[]{0x0000000803800002L});
    public static final BitSet FOLLOW_assignment_in_listOfVariables901 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfVariables910 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfVariables_in_listOfVariables914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_partTypeDeclaration947 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_partTypeDeclaration956 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_partTypeDeclaration959 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_listOfIDs_in_partTypeDeclaration964 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_partTypeDeclaration969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_partTypeDeclaration985 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_partTypeDeclaration993 = new BitSet(new long[]{0x0000000802800000L});
    public static final BitSet FOLLOW_assignment_in_partTypeDeclaration997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfIDs1031 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfIDs1037 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_listOfIDs1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_deviceDeclaration1072 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_deviceDeclaration1076 = new BitSet(new long[]{0x0000000802900002L});
    public static final BitSet FOLLOW_20_in_deviceDeclaration1082 = new BitSet(new long[]{0x0000800002B0AA00L,0x00010000020201C0L});
    public static final BitSet FOLLOW_deviceComponents_in_deviceDeclaration1087 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceDeclaration1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_deviceDeclaration1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_deviceComponents1156 = new BitSet(new long[]{0x000080000210AA00L,0x00010000020201C0L});
    public static final BitSet FOLLOW_expressionValue_in_deviceComponents1170 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_deviceComponents1181 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_deviceComponents1191 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_deviceComponents1201 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_deviceComponents1211 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_deviceComponents1221 = new BitSet(new long[]{0x000080000290AA00L,0x00010000020201C0L});
    public static final BitSet FOLLOW_deviceComponents_in_deviceComponents1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_deviceTypeDeclaration1251 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_deviceTypeDeclaration1255 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceTypeDeclaration1257 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_deviceTypeDeclaration1261 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceTypeDeclaration1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayType_in_arrayDeclaration1299 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_arrayDeclaration1303 = new BitSet(new long[]{0x0000000802800002L});
    public static final BitSet FOLLOW_assignment_in_arrayDeclaration1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_arrayType1332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_arrayType1334 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_arrayType1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_arrayType1341 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_arrayType1343 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_arrayType1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_arrayType1350 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_arrayType1352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_arrayType1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_arrayType1359 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_arrayType1361 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_arrayType1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_arrayType1368 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_arrayType1370 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_arrayType1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayType1377 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_arrayType1379 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_arrayType1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleDeclaration1397 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_ruleDeclaration1401 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleDeclaration1403 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E22BL});
    public static final BitSet FOLLOW_onDevice_in_ruleDeclaration1413 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_ruleDeclaration1424 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclaration1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_onDevice1467 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_onDevice1471 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_onDevice1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_folExpression1517 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_folExpression1522 = new BitSet(new long[]{0x0010000080000000L});
    public static final BitSet FOLLOW_52_in_folExpression1527 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_folExpression1532 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_folExpression1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_folExpression1544 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_folExpression1549 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_folExpression1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_imageDeclaration1578 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_imageDeclaration1580 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_imageDeclaration1584 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_imageDeclaration1586 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_imageDeclaration1590 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_imageDeclaration1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_relationDeclaration1610 = new BitSet(new long[]{0x0880480000000000L,0x0000000000000220L});
    public static final BitSet FOLLOW_pairingType_in_relationDeclaration1614 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_relationDeclaration1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_assertStatement1683 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_assertStatement1685 = new BitSet(new long[]{0x0000000000200800L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_assertStatement1688 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_assertStatement1692 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_assertStatement1695 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_listOfIDs_in_assertStatement1701 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assertStatement1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_noteStatement1738 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_noteStatement1740 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E22BL});
    public static final BitSet FOLLOW_onDevice_in_noteStatement1748 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_noteStatement1759 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_noteStatement1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_instantiationStatement1801 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_instanceDefinitionStatement_in_instantiationStatement1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partInstantiation_in_instanceDefinitionStatement1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceInstantiation_in_instanceDefinitionStatement1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_dynamicNaming1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DYNAMIC_NAME_in_dynamicNaming1881 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_dynamicNaming1885 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_DYNAMIC_NAME_in_dynamicNaming1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dynamicNaming_in_partInstantiation1918 = new BitSet(new long[]{0x0000000802900002L});
    public static final BitSet FOLLOW_20_in_partInstantiation1923 = new BitSet(new long[]{0xFCBE5CF60634AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_listOfDotValues_in_partInstantiation1928 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_listOfValues_in_partInstantiation1935 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_partInstantiation1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_partInstantiation1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_deviceInstantiation1985 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_deviceInstantiation1988 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_listOfIDs_in_deviceInstantiation1993 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceInstantiation1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_listOfDotValues2036 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfDotValues2040 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_listOfDotValues2042 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_listOfDotValues2046 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_listOfDotValues2049 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfDotValues2055 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_listOfDotValues_in_listOfDotValues2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfValues2100 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfValues2106 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_listOfValues_in_listOfValues2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfExpressions2142 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfExpressions2149 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_listOfExpressions_in_listOfExpressions2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notExpression_in_expression2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_notExpression2224 = new BitSet(new long[]{0xBCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_orExpression_in_notExpression2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpression_in_notExpression2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpression_in_orExpression2282 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000010L});
    public static final BitSet FOLLOW_68_in_orExpression2298 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_116_in_orExpression2300 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_notExpression_in_orExpression2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xorExpression_in_andExpression2354 = new BitSet(new long[]{0x0000010000080002L});
    public static final BitSet FOLLOW_40_in_andExpression2370 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_19_in_andExpression2372 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_notExpression_in_andExpression2377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparativeExpression_in_xorExpression2427 = new BitSet(new long[]{0x0000000000000002L,0x0000000000090000L});
    public static final BitSet FOLLOW_80_in_xorExpression2443 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_83_in_xorExpression2445 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_notExpression_in_xorExpression2450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalOperator_in_operator2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_operator2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pairingType_in_operator2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOperator2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOperator2541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleOperator2548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOperator2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleOperator2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleOperator2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleOperator2576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleOperator2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOperator2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleOperator2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleOperator2604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleOperator2611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOperator2619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relationalOperator2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relationalOperator2650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_relationalOperator2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_relationalOperator2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_relationalOperator2678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_relationalOperator2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_folExpression_in_comparativeExpression2713 = new BitSet(new long[]{0xBC8E5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_addExpression_in_comparativeExpression2738 = new BitSet(new long[]{0xBD8E5CF600040002L,0x000000010000E223L});
    public static final BitSet FOLLOW_operator_in_comparativeExpression2758 = new BitSet(new long[]{0xBCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_comparativeExpression_in_comparativeExpression2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_comparativeExpression2785 = new BitSet(new long[]{0x0000A00000000800L,0x0002001000100140L});
    public static final BitSet FOLLOW_96_in_comparativeExpression2787 = new BitSet(new long[]{0x0000A00000000800L,0x0002001000100140L});
    public static final BitSet FOLLOW_type_in_comparativeExpression2792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_in_comparativeExpression2816 = new BitSet(new long[]{0x000000000210AA00L,0x0001000002020000L});
    public static final BitSet FOLLOW_addExpression_in_comparativeExpression2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subtractExpression_in_addExpression2869 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_addExpression2885 = new BitSet(new long[]{0x000000000210AA00L,0x0001000002020000L});
    public static final BitSet FOLLOW_addExpression_in_addExpression2889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_subtractExpression2937 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_subtractExpression2952 = new BitSet(new long[]{0x000000000210AA00L,0x0001000002020000L});
    public static final BitSet FOLLOW_subtractExpression_in_subtractExpression2956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionValue_in_multiplicativeExpression3007 = new BitSet(new long[]{0x0000000040400002L});
    public static final BitSet FOLLOW_22_in_multiplicativeExpression3035 = new BitSet(new long[]{0x000000000210AA00L,0x0001000002020000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_multiplicativeExpression3039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_multiplicativeExpression3064 = new BitSet(new long[]{0x000000000210AA00L,0x0001000002020000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_multiplicativeExpression3068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_expressionValue3112 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_set_in_expressionValue3118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_expressionValue3132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expressionValue3142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectAccessStatement_in_expressionValue3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_expressionValue3180 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_expressionValue3184 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_expressionValue3187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_expressionValue3211 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_listOfExpressions_in_expressionValue3215 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_expressionValue3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_objectAccessStatement3256 = new BitSet(new long[]{0x0000000004000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_objectAccess_in_objectAccessStatement3272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayAccess_in_objectAccess3313 = new BitSet(new long[]{0x0000000004000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_access_in_objectAccess3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotAccess_in_objectAccess3361 = new BitSet(new long[]{0x0000000004000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_access_in_objectAccess3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectAccess_in_access3422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_arrayAccess3446 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_arrayAccess3450 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_arrayAccess3453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3491 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_dotAccess3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3515 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_dotAccess3517 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_dotAccess3520 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3541 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_dotAccess3545 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_dotAccess3547 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_dotAccess3551 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3574 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_dotAccess3578 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_dotAccess3581 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3602 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_dotAccess3606 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_dotAccess3609 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3630 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_dotAccess3632 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_dotAccess3634 = new BitSet(new long[]{0xFCBE5CF60234AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_dotAccess3639 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_objectAssignmentStatement3697 = new BitSet(new long[]{0x0000000806800000L,0x0000000000020000L});
    public static final BitSet FOLLOW_26_in_objectAssignmentStatement3715 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_objectAssignmentStatement3719 = new BitSet(new long[]{0x0000000806800000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_objectAssignmentStatement3741 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_objectAssignmentStatement3747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_objectAssignmentStatement3750 = new BitSet(new long[]{0x0000000806800000L,0x0000000000020000L});
    public static final BitSet FOLLOW_assignment_in_objectAssignmentStatement3780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_listOfStatements3815 = new BitSet(new long[]{0x0241A20100001802L,0x00061BF048501DC4L});
    public static final BitSet FOLLOW_107_in_returnStatement3845 = new BitSet(new long[]{0xFCFE5CF70214AA00L,0x000102200202F223L});
    public static final BitSet FOLLOW_expression_in_returnStatement3855 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_functionCall_in_returnStatement3865 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_wrappedStatement_in_returnStatement3875 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_returnStatement3882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_saveStatement3899 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_saveStatement3901 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_listOfSaveObjects_in_saveStatement3903 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_saveStatement3906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfSaveObjects3922 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_listOfSaveObjects3924 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_listOfSaveObjects3930 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfSaveObjects3936 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_listOfSaveObjects_in_listOfSaveObjects3938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ifStatement3978 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ifStatement3980 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E22BL});
    public static final BitSet FOLLOW_ifCondition_in_ifStatement3984 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifStatement3987 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_ifStatement3989 = new BitSet(new long[]{0x0241A20100001800L,0x00061BF048501DC4L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement3993 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_ifStatement3996 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_ifStatement4017 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_ifStatement4019 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ifStatement4021 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E22BL});
    public static final BitSet FOLLOW_ifCondition_in_ifStatement4025 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifStatement4028 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_ifStatement4030 = new BitSet(new long[]{0x0241A20100001800L,0x00061BF048501DC4L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement4034 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_ifStatement4037 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_ifStatement4046 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_ifStatement4048 = new BitSet(new long[]{0x0241A20100001800L,0x00061BF048501DC4L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement4052 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_ifStatement4055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_onDevice_in_ifCondition4094 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_ifCondition4101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_loopStatement4141 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_loopStatement4143 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000300100212E223L});
    public static final BitSet FOLLOW_forInit_in_loopStatement4147 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_loopStatement4150 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_loopStatement4161 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_loopStatement4164 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_computationalStatement_in_loopStatement4175 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement4178 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_loopStatement4180 = new BitSet(new long[]{0x0241A20100001800L,0x00061BF048501DC4L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement4192 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_loopStatement4195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_loopStatement4202 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_loopStatement4204 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_loopStatement4208 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement4211 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_loopStatement4213 = new BitSet(new long[]{0x0241A20100001800L,0x00061BF048501DC4L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement4217 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_loopStatement4220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_loopStatement4227 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_loopStatement4229 = new BitSet(new long[]{0x0241A20100001800L,0x00061BF048501DC4L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement4233 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_loopStatement4236 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_loopStatement4238 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_loopStatement4240 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_loopStatement4244 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement4247 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_loopStatement4248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_forInit4276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listOfExpressions_in_forInit4286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_functionDeclaration4311 = new BitSet(new long[]{0x0000A00000000800L,0x0002001000100140L});
    public static final BitSet FOLLOW_type_in_functionDeclaration4316 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_functionDeclaration4322 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_functionDeclaration4326 = new BitSet(new long[]{0x0000A00000200800L,0x0002001000100140L});
    public static final BitSet FOLLOW_listOfFunctionParamenters_in_functionDeclaration4331 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionDeclaration4335 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_functionDeclaration4337 = new BitSet(new long[]{0x0241A20100001800L,0x00061BF048501DC4L});
    public static final BitSet FOLLOW_listOfStatements_in_functionDeclaration4345 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_functionDeclaration4350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_type4373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_type4380 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_type4382 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_type4384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_type4391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_type4398 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_type4400 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_type4402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_type4409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_type4418 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_type4420 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_type4422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_type4431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_type4438 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_type4440 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_type4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_type4449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_type4456 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_type4458 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_type4460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_type4467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_type4474 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_type4476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_type4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_type4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_type4492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_listOfFunctionParamenters4516 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfFunctionParamenters4520 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfFunctionParamenters4525 = new BitSet(new long[]{0x0000A00000000800L,0x0002001000100140L});
    public static final BitSet FOLLOW_listOfFunctionParamenters_in_listOfFunctionParamenters4529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_functionCall4554 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_functionCall4556 = new BitSet(new long[]{0xFCBE5CF60234AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_listOfParameterValues_in_functionCall4561 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionCall4566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfParameterValues4598 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfParameterValues4605 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_listOfParameterValues_in_listOfParameterValues4609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_in_wrappedStatement4634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_combinatorialFunction_in_wrappedStatement4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_get_in_wrappedStatement4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_size_in_wrappedStatement4669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remove_in_wrappedStatement4679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_toSequence_in_wrappedStatement4688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolStatement_in_wrappedStatement4698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankStatement_in_wrappedStatement4708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDepthStatements_in_wrappedStatement4724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_deviceDepthStatements4755 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_deviceDepthStatements4757 = new BitSet(new long[]{0x0000000000000000L,0x0000000800200000L});
    public static final BitSet FOLLOW_85_in_deviceDepthStatements4764 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceDepthStatements4766 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_deviceDepthStatements4770 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceDepthStatements4773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_deviceDepthStatements4781 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceDepthStatements4783 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceDepthStatements4785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_add4809 = new BitSet(new long[]{0x0000000038000000L});
    public static final BitSet FOLLOW_27_in_add4816 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_add4818 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_listOfExpressions_in_add4822 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_add4825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_add4833 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_add4835 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_add4839 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_add4841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_add4848 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_add4850 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_add4854 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_add4857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_toSequence4888 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_toSequence4890 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_toSequence4892 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_toSequence4894 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_toSequence4896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_get4922 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_get4924 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_get4926 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_get4928 = new BitSet(new long[]{0x000000000000A800L});
    public static final BitSet FOLLOW_INT_in_get4933 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_get4941 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_STRING_in_get4949 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_get4954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_size4987 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_size4989 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_size4991 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_size4993 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_size4995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_remove5025 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_remove5027 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_remove5029 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_remove5031 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_remove5035 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_remove5038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfRules5084 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfRules5089 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfRules5093 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_set_in_combinatorialFunction5126 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_combinatorialFunction5132 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_combinatorialFunction5144 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_combinatorialFunction5170 = new BitSet(new long[]{0x0000000000000000L,0x0000400004000000L});
    public static final BitSet FOLLOW_set_in_combinatorialFunction5174 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_combinatorialFunction5199 = new BitSet(new long[]{0xFCBE5CF60334AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_combinatorialFunction5204 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_combinatorialFunction5221 = new BitSet(new long[]{0xFCBE5CF60234AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_combinatorialFunction5226 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_combinatorialFunction5233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_getObject5265 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_getObject5269 = new BitSet(new long[]{0x0000000004000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_getObject5275 = new BitSet(new long[]{0xFCBE5CF60214AA00L,0x000100000202E223L});
    public static final BitSet FOLLOW_expression_in_getObject5279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_getObject5282 = new BitSet(new long[]{0x0000000004000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_104_in_printStatement5325 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_printStatement5327 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_printStatement5329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_printStatement5343 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_printStatement5345 = new BitSet(new long[]{0xFCFE5CF60214AA00L,0x000102200202F223L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5349 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_printStatement5355 = new BitSet(new long[]{0xFCFE5CF60214AA00L,0x000102200202F223L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5359 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_21_in_printStatement5366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_printStatement5378 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_printStatement5380 = new BitSet(new long[]{0xFCFE5CF60214AA00L,0x000102200202F223L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5384 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_printStatement5390 = new BitSet(new long[]{0xFCFE5CF60214AA00L,0x000102200202F223L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5394 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_21_in_printStatement5401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_whatToPrint5422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wrappedStatement_in_whatToPrint5432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolStatement_in_dataExtraction5450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankStatement_in_dataExtraction5456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pigeonStatement_in_dataExtraction5462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_registryStatement_in_dataExtraction5468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_sbolStatement5488 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sbolStatement5490 = new BitSet(new long[]{0x0000000000000000L,0x0000000081000000L});
    public static final BitSet FOLLOW_sbolExportStatement_in_sbolStatement5493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolImportStatement_in_sbolStatement5500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_sbolExportStatement5517 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_sbolExportStatement5519 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_sbolExportStatement5523 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_sbolExportStatement5525 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_sbolExportStatement5529 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_sbolExportStatement5531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_sbolImportStatement5560 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_sbolImportStatement5562 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_sbolImportStatement5566 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_sbolImportStatement5568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_genbankStatement5594 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_genbankStatement5596 = new BitSet(new long[]{0x0000000000000000L,0x0000000081000000L});
    public static final BitSet FOLLOW_genbankImportStatement_in_genbankStatement5601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankExportStatement_in_genbankStatement5606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_genbankExportStatement5629 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_genbankExportStatement5631 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_genbankExportStatement5633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_genbankImportStatement5650 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_genbankImportStatement5652 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_genbankImportStatement5656 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_genbankImportStatement5658 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_genbankImportStatement5662 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_genbankImportStatement5664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_pigeonStatement5680 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_pigeonStatement5682 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_pigeonStatement5686 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_pigeonStatement5688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_registryStatement5711 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_registryStatement5713 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_registryStatement5715 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_registryStatement5717 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_registryStatement5721 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_registryStatement5723 = new BitSet(new long[]{0x0000000000000002L});

}