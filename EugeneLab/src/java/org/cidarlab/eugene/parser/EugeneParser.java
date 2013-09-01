// $ANTLR 3.4 /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g 2013-08-21 15:00:03

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
//import eugene.rules.*;
import org.cidarlab.eugene.rules.RuleEngine;
import org.cidarlab.eugene.output.ResultSet;
import org.cidarlab.eugene.builder.EugeneBuilder;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

// SBOL
import org.cidarlab.eugene.data.pigeon.Pigeon;



import org.antlr.runtime.*;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;
import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.controlflow.functions.Function;
import org.cidarlab.eugene.data.registry.RegistryImporter;
import org.cidarlab.eugene.exception.EugeneReturnException;
import org.cidarlab.eugene.interpreter.Interp;
import org.cidarlab.eugene.dom.*;
import org.cidarlab.eugene.dom.rules.*;
import org.cidarlab.eugene.dom.arrays.*;
import org.cidarlab.eugene.dom.collection.*;
import org.cidarlab.eugene.dom.components.*;
import org.cidarlab.eugene.dom.components.types.*;
import org.cidarlab.eugene.exception.EugeneException;
import org.cidarlab.eugene.controlflow.branches.*;
import org.cidarlab.eugene.controlflow.loops.*;
import org.cidarlab.eugene.controlflow.functions.*;
import org.cidarlab.eugene.data.genbank.GenbankImporter;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class EugeneParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "COMMENT", "DYNAMIC_NAME", "ESC_SEQ", "EXPONENT", "FLOAT", "HEX_DIGIT", "ID", "INCLUDE", "INT", "OCTAL_ESC", "STRING", "UNICODE_ESC", "WS", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'.add'", "'.addProperties'", "'.addProperty'", "'/'", "':'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'AFTER'", "'AND'", "'Assert'", "'BEFORE'", "'BINDS'", "'CONTAINS'", "'Collection'", "'DRIVES'", "'Device'", "'DeviceType'", "'ENDSWITH'", "'EQUALS'", "'EXISTS'", "'FORALL'", "'Genbank'", "'INDUCES'", "'INSTANCEOF'", "'Image'", "'LEFTTO'", "'MATCHES'", "'MORETHAN'", "'NEXTTO'", "'NOT'", "'NOTEQUALS'", "'NOTMORETHAN'", "'NOTWITH'", "'Note'", "'ON'", "'OR'", "'ORTHO'", "'Part'", "'PartType'", "'Property'", "'REPRESSES'", "'Rule'", "'SBOL'", "'STARTSWITH'", "'THEN'", "'WITH'", "'XOR'", "'['", "']'", "'^^'", "'boolean'", "'depth'", "'do'", "'else'", "'export'", "'false'", "'flexible'", "'for'", "'function'", "'get'", "'if'", "'import'", "'instanceof'", "'instantiate'", "'isEmpty'", "'maxDepth'", "'num'", "'permute'", "'pigeon'", "'print'", "'println'", "'product'", "'remove'", "'return'", "'save'", "'size'", "'strict'", "'toSequence'", "'true'", "'txt'", "'while'", "'{'", "'||'", "'}'"
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:511:1: prog : ( eugeneStatement )+ EOF ;
    public final EugeneParser.prog_return prog() throws RecognitionException {
        EugeneParser.prog_return retval = new EugeneParser.prog_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EOF2=null;
        EugeneParser.eugeneStatement_return eugeneStatement1 =null;


        Object EOF2_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:512:2: ( ( eugeneStatement )+ EOF )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:512:4: ( eugeneStatement )+ EOF
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:512:4: ( eugeneStatement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ID && LA1_0 <= INCLUDE)||LA1_0==32||LA1_0==41||LA1_0==45||(LA1_0 >= 47 && LA1_0 <= 48)||LA1_0==53||LA1_0==56||LA1_0==65||(LA1_0 >= 69 && LA1_0 <= 71)||(LA1_0 >= 73 && LA1_0 <= 74)||LA1_0==82||LA1_0==84||(LA1_0 >= 89 && LA1_0 <= 90)||(LA1_0 >= 92 && LA1_0 <= 93)||(LA1_0 >= 98 && LA1_0 <= 103)||(LA1_0 >= 105 && LA1_0 <= 106)||(LA1_0 >= 111 && LA1_0 <= 112)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:512:4: eugeneStatement
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:515:1: eugeneStatement : ( statement[false] |functionToken= functionDeclaration );
    public final EugeneParser.eugeneStatement_return eugeneStatement() throws RecognitionException {
        EugeneParser.eugeneStatement_return retval = new EugeneParser.eugeneStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.functionDeclaration_return functionToken =null;

        EugeneParser.statement_return statement3 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:516:2: ( statement[false] |functionToken= functionDeclaration )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0 >= ID && LA2_0 <= INCLUDE)||LA2_0==32||LA2_0==41||LA2_0==45||(LA2_0 >= 47 && LA2_0 <= 48)||LA2_0==53||LA2_0==56||LA2_0==65||(LA2_0 >= 69 && LA2_0 <= 71)||(LA2_0 >= 73 && LA2_0 <= 74)||LA2_0==82||LA2_0==84||LA2_0==89||(LA2_0 >= 92 && LA2_0 <= 93)||(LA2_0 >= 98 && LA2_0 <= 103)||(LA2_0 >= 105 && LA2_0 <= 106)||(LA2_0 >= 111 && LA2_0 <= 112)) ) {
                alt2=1;
            }
            else if ( (LA2_0==90) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:516:4: statement[false]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_statement_in_eugeneStatement70);
                    statement3=statement(false);

                    state._fsp--;

                    adaptor.addChild(root_0, statement3.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:517:4: functionToken= functionDeclaration
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
            e.printStackTrace();
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:526:1: statement[boolean defer] returns [NamedElement objReturnValue] : ( INCLUDE ';' | importStatement[defer] ';' | dataExtraction[defer] ';' |declToken= declarationStatement[defer] ';' | computationalStatement[defer] ';' | printStatement[defer] ';' | ifStatement[defer] | assertStatement[defer] ';' | noteStatement[defer] ';' | wrappedStatement[defer] ';' | loopStatement[defer] |returnToken= returnStatement[defer] | saveStatement[defer] ';' );
    public final EugeneParser.statement_return statement(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.statement_return retval = new EugeneParser.statement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token INCLUDE4=null;
        Token char_literal5=null;
        Token char_literal7=null;
        Token char_literal9=null;
        Token char_literal10=null;
        Token char_literal12=null;
        Token char_literal14=null;
        Token char_literal17=null;
        Token char_literal19=null;
        Token char_literal21=null;
        Token char_literal24=null;
        EugeneParser.declarationStatement_return declToken =null;

        EugeneParser.returnStatement_return returnToken =null;

        EugeneParser.importStatement_return importStatement6 =null;

        EugeneParser.dataExtraction_return dataExtraction8 =null;

        EugeneParser.computationalStatement_return computationalStatement11 =null;

        EugeneParser.printStatement_return printStatement13 =null;

        EugeneParser.ifStatement_return ifStatement15 =null;

        EugeneParser.assertStatement_return assertStatement16 =null;

        EugeneParser.noteStatement_return noteStatement18 =null;

        EugeneParser.wrappedStatement_return wrappedStatement20 =null;

        EugeneParser.loopStatement_return loopStatement22 =null;

        EugeneParser.saveStatement_return saveStatement23 =null;


        Object INCLUDE4_tree=null;
        Object char_literal5_tree=null;
        Object char_literal7_tree=null;
        Object char_literal9_tree=null;
        Object char_literal10_tree=null;
        Object char_literal12_tree=null;
        Object char_literal14_tree=null;
        Object char_literal17_tree=null;
        Object char_literal19_tree=null;
        Object char_literal21_tree=null;
        Object char_literal24_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:529:2: ( INCLUDE ';' | importStatement[defer] ';' | dataExtraction[defer] ';' |declToken= declarationStatement[defer] ';' | computationalStatement[defer] ';' | printStatement[defer] ';' | ifStatement[defer] | assertStatement[defer] ';' | noteStatement[defer] ';' | wrappedStatement[defer] ';' | loopStatement[defer] |returnToken= returnStatement[defer] | saveStatement[defer] ';' )
            int alt3=13;
            switch ( input.LA(1) ) {
            case INCLUDE:
                {
                alt3=1;
                }
                break;
            case 93:
                {
                alt3=2;
                }
                break;
            case 74:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==26) ) {
                    int LA3_17 = input.LA(3);

                    if ( (LA3_17==86) ) {
                        int LA3_22 = input.LA(4);

                        if ( (LA3_22==20) ) {
                            int LA3_26 = input.LA(5);

                            if ( (LA3_26==ID) ) {
                                int LA3_30 = input.LA(6);

                                if ( (LA3_30==24) ) {
                                    int LA3_34 = input.LA(7);

                                    if ( (LA3_34==STRING) ) {
                                        int LA3_38 = input.LA(8);

                                        if ( (LA3_38==21) ) {
                                            int LA3_40 = input.LA(9);

                                            if ( (LA3_40==32) ) {
                                                alt3=3;
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
                    else if ( (LA3_17==93) ) {
                        int LA3_23 = input.LA(4);

                        if ( (LA3_23==20) ) {
                            int LA3_27 = input.LA(5);

                            if ( (LA3_27==STRING) ) {
                                int LA3_31 = input.LA(6);

                                if ( (LA3_31==21) ) {
                                    int LA3_35 = input.LA(7);

                                    if ( (LA3_35==32) ) {
                                        alt3=3;
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
            case 53:
                {
                int LA3_4 = input.LA(2);

                if ( (LA3_4==26) ) {
                    int LA3_18 = input.LA(3);

                    if ( (LA3_18==93) ) {
                        int LA3_24 = input.LA(4);

                        if ( (LA3_24==20) ) {
                            int LA3_28 = input.LA(5);

                            if ( (LA3_28==ID) ) {
                                int LA3_32 = input.LA(6);

                                if ( (LA3_32==24) ) {
                                    int LA3_36 = input.LA(7);

                                    if ( (LA3_36==STRING) ) {
                                        int LA3_39 = input.LA(8);

                                        if ( (LA3_39==21) ) {
                                            int LA3_41 = input.LA(9);

                                            if ( (LA3_41==32) ) {
                                                alt3=3;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 3, 41, input);

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
                    else if ( (LA3_18==86) ) {
                        int LA3_25 = input.LA(4);

                        if ( (LA3_25==20) ) {
                            int LA3_29 = input.LA(5);

                            if ( (LA3_29==21) ) {
                                int LA3_33 = input.LA(6);

                                if ( (LA3_33==32) ) {
                                    alt3=3;
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
                            new NoViableAltException("", 3, 18, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 4, input);

                    throw nvae;

                }
                }
                break;
            case 100:
                {
                alt3=3;
                }
                break;
            case 45:
            case 47:
            case 48:
            case 56:
            case 69:
            case 70:
            case 71:
            case 73:
            case 82:
            case 98:
            case 111:
                {
                alt3=4;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case 79:
                    {
                    int LA3_19 = input.LA(3);

                    if ( (LA3_19==80) ) {
                        alt3=4;
                    }
                    else if ( (LA3_19==FLOAT||LA3_19==ID||LA3_19==INT||LA3_19==STRING||LA3_19==18||LA3_19==20||LA3_19==25||(LA3_19 >= 33 && LA3_19 <= 34)||(LA3_19 >= 36 && LA3_19 <= 39)||(LA3_19 >= 42 && LA3_19 <= 44)||LA3_19==46||(LA3_19 >= 49 && LA3_19 <= 52)||LA3_19==54||(LA3_19 >= 57 && LA3_19 <= 64)||LA3_19==68||LA3_19==72||(LA3_19 >= 75 && LA3_19 <= 77)||LA3_19==79||LA3_19==87||LA3_19==110) ) {
                        alt3=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 19, input);

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
                    alt3=5;
                    }
                    break;
                case 26:
                    {
                    int LA3_21 = input.LA(3);

                    if ( (LA3_21==83||LA3_21==91||LA3_21==97||LA3_21==104||LA3_21==107||LA3_21==109) ) {
                        alt3=10;
                    }
                    else if ( (LA3_21==ID) ) {
                        alt3=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 21, input);

                        throw nvae;

                    }
                    }
                    break;
                case 43:
                case 46:
                case 54:
                case 58:
                case 68:
                case 72:
                    {
                    alt3=4;
                    }
                    break;
                case 27:
                case 28:
                case 29:
                    {
                    alt3=10;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 7, input);

                    throw nvae;

                }

                }
                break;
            case 32:
                {
                alt3=4;
                }
                break;
            case 101:
            case 102:
                {
                alt3=6;
                }
                break;
            case 92:
                {
                alt3=7;
                }
                break;
            case 41:
                {
                alt3=8;
                }
                break;
            case 65:
                {
                alt3=9;
                }
                break;
            case 99:
            case 103:
                {
                alt3=10;
                }
                break;
            case 84:
            case 89:
            case 112:
                {
                alt3=11;
                }
                break;
            case 105:
                {
                alt3=12;
                }
                break;
            case 106:
                {
                alt3=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:529:4: INCLUDE ';'
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:530:4: importStatement[defer] ';'
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:531:4: dataExtraction[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_dataExtraction_in_statement132);
                    dataExtraction8=dataExtraction(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, dataExtraction8.getTree());

                    char_literal9=(Token)match(input,32,FOLLOW_32_in_statement135); 
                    char_literal9_tree = 
                    (Object)adaptor.create(char_literal9)
                    ;
                    adaptor.addChild(root_0, char_literal9_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:532:4: declToken= declarationStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_declarationStatement_in_statement142);
                    declToken=declarationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, declToken.getTree());

                    char_literal10=(Token)match(input,32,FOLLOW_32_in_statement145); 
                    char_literal10_tree = 
                    (Object)adaptor.create(char_literal10)
                    ;
                    adaptor.addChild(root_0, char_literal10_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:533:4: computationalStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_computationalStatement_in_statement152);
                    computationalStatement11=computationalStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, computationalStatement11.getTree());

                    char_literal12=(Token)match(input,32,FOLLOW_32_in_statement155); 
                    char_literal12_tree = 
                    (Object)adaptor.create(char_literal12)
                    ;
                    adaptor.addChild(root_0, char_literal12_tree);


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:534:4: printStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_printStatement_in_statement160);
                    printStatement13=printStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printStatement13.getTree());

                    char_literal14=(Token)match(input,32,FOLLOW_32_in_statement163); 
                    char_literal14_tree = 
                    (Object)adaptor.create(char_literal14)
                    ;
                    adaptor.addChild(root_0, char_literal14_tree);


                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:535:4: ifStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ifStatement_in_statement168);
                    ifStatement15=ifStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement15.getTree());

                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:536:4: assertStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_assertStatement_in_statement174);
                    assertStatement16=assertStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, assertStatement16.getTree());

                    char_literal17=(Token)match(input,32,FOLLOW_32_in_statement177); 
                    char_literal17_tree = 
                    (Object)adaptor.create(char_literal17)
                    ;
                    adaptor.addChild(root_0, char_literal17_tree);


                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:537:4: noteStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_noteStatement_in_statement184);
                    noteStatement18=noteStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, noteStatement18.getTree());

                    char_literal19=(Token)match(input,32,FOLLOW_32_in_statement187); 
                    char_literal19_tree = 
                    (Object)adaptor.create(char_literal19)
                    ;
                    adaptor.addChild(root_0, char_literal19_tree);


                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:538:4: wrappedStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_wrappedStatement_in_statement194);
                    wrappedStatement20=wrappedStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, wrappedStatement20.getTree());

                    char_literal21=(Token)match(input,32,FOLLOW_32_in_statement197); 
                    char_literal21_tree = 
                    (Object)adaptor.create(char_literal21)
                    ;
                    adaptor.addChild(root_0, char_literal21_tree);


                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:539:10: loopStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_loopStatement_in_statement208);
                    loopStatement22=loopStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, loopStatement22.getTree());

                    }
                    break;
                case 12 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:540:4: returnToken= returnStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_returnStatement_in_statement216);
                    returnToken=returnStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, returnToken.getTree());


                    if(!defer) {
                        retval.objReturnValue = (returnToken!=null?returnToken.objReturnValue:null);
                        throw new EugeneReturnException(retval.objReturnValue);
                    }	
                    	

                    }
                    break;
                case 13 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:546:4: saveStatement[defer] ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_saveStatement_in_statement224);
                    saveStatement23=saveStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, saveStatement23.getTree());

                    char_literal24=(Token)match(input,32,FOLLOW_32_in_statement227); 
                    char_literal24_tree = 
                    (Object)adaptor.create(char_literal24)
                    ;
                    adaptor.addChild(root_0, char_literal24_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:549:1: computationalStatement[boolean defer] : ( functionCall[defer] |instToken= instantiationStatement[defer] |leftToken= objectAssignmentStatement[defer] );
    public final EugeneParser.computationalStatement_return computationalStatement(boolean defer) throws RecognitionException {
        EugeneParser.computationalStatement_return retval = new EugeneParser.computationalStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.instantiationStatement_return instToken =null;

        EugeneParser.objectAssignmentStatement_return leftToken =null;

        EugeneParser.functionCall_return functionCall25 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:550:2: ( functionCall[defer] |instToken= instantiationStatement[defer] |leftToken= objectAssignmentStatement[defer] )
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
                case 79:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:550:4: functionCall[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_functionCall_in_computationalStatement240);
                    functionCall25=functionCall(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, functionCall25.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:551:4: instToken= instantiationStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_instantiationStatement_in_computationalStatement248);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        SymbolTables.put((instToken!=null?instToken.objComponent:null));
                    }	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:556:4: leftToken= objectAssignmentStatement[defer]
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:568:1: assignment[boolean defer] returns [NamedElement objElement] : ( '=' exprToken= expression[defer] | '=' funcToken= functionCall[defer] | '=' stmtToken= wrappedStatement[defer] | '+' '+' | '-' '-' );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:569:2: ( '=' exprToken= expression[defer] | '=' funcToken= functionCall[defer] | '=' stmtToken= wrappedStatement[defer] | '+' '+' | '-' '-' )
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
                case 54:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 68:
                case 72:
                case 75:
                case 76:
                case 77:
                case 79:
                case 87:
                case 110:
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
                        case 91:
                            {
                            int LA5_9 = input.LA(5);

                            if ( (LA5_9==20) ) {
                                switch ( input.LA(6) ) {
                                case INT:
                                    {
                                    int LA5_15 = input.LA(7);

                                    if ( ((LA5_15 >= 18 && LA5_15 <= 19)||(LA5_15 >= 21 && LA5_15 <= 23)||LA5_15==25||LA5_15==30||(LA5_15 >= 33 && LA5_15 <= 34)||(LA5_15 >= 36 && LA5_15 <= 40)||(LA5_15 >= 42 && LA5_15 <= 44)||LA5_15==46||(LA5_15 >= 49 && LA5_15 <= 50)||(LA5_15 >= 54 && LA5_15 <= 55)||(LA5_15 >= 57 && LA5_15 <= 60)||(LA5_15 >= 62 && LA5_15 <= 64)||(LA5_15 >= 67 && LA5_15 <= 68)||LA5_15==72||(LA5_15 >= 75 && LA5_15 <= 78)||LA5_15==81||LA5_15==94||LA5_15==114) ) {
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

                                    if ( ((LA5_16 >= 18 && LA5_16 <= 19)||(LA5_16 >= 21 && LA5_16 <= 23)||(LA5_16 >= 25 && LA5_16 <= 26)||LA5_16==30||(LA5_16 >= 33 && LA5_16 <= 34)||(LA5_16 >= 36 && LA5_16 <= 40)||(LA5_16 >= 42 && LA5_16 <= 44)||LA5_16==46||(LA5_16 >= 49 && LA5_16 <= 50)||(LA5_16 >= 54 && LA5_16 <= 55)||(LA5_16 >= 57 && LA5_16 <= 60)||(LA5_16 >= 62 && LA5_16 <= 64)||(LA5_16 >= 67 && LA5_16 <= 68)||LA5_16==72||(LA5_16 >= 75 && LA5_16 <= 79)||LA5_16==81||LA5_16==94||LA5_16==114) ) {
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

                                    if ( ((LA5_17 >= 18 && LA5_17 <= 19)||(LA5_17 >= 21 && LA5_17 <= 23)||LA5_17==25||LA5_17==30||(LA5_17 >= 33 && LA5_17 <= 34)||(LA5_17 >= 36 && LA5_17 <= 40)||(LA5_17 >= 42 && LA5_17 <= 44)||LA5_17==46||(LA5_17 >= 49 && LA5_17 <= 50)||(LA5_17 >= 54 && LA5_17 <= 55)||(LA5_17 >= 57 && LA5_17 <= 60)||(LA5_17 >= 62 && LA5_17 <= 64)||(LA5_17 >= 67 && LA5_17 <= 68)||LA5_17==72||(LA5_17 >= 75 && LA5_17 <= 78)||LA5_17==81||LA5_17==94||LA5_17==114) ) {
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
                                case 54:
                                case 57:
                                case 58:
                                case 59:
                                case 60:
                                case 61:
                                case 62:
                                case 63:
                                case 64:
                                case 68:
                                case 72:
                                case 75:
                                case 76:
                                case 77:
                                case 79:
                                case 87:
                                case 110:
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
                        case 107:
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
                            else if ( ((LA5_10 >= 18 && LA5_10 <= 19)||(LA5_10 >= 21 && LA5_10 <= 26)||LA5_10==30||(LA5_10 >= 32 && LA5_10 <= 34)||(LA5_10 >= 36 && LA5_10 <= 40)||(LA5_10 >= 42 && LA5_10 <= 44)||LA5_10==46||(LA5_10 >= 49 && LA5_10 <= 50)||(LA5_10 >= 54 && LA5_10 <= 55)||(LA5_10 >= 57 && LA5_10 <= 60)||(LA5_10 >= 62 && LA5_10 <= 64)||(LA5_10 >= 67 && LA5_10 <= 68)||LA5_10==72||(LA5_10 >= 75 && LA5_10 <= 79)||LA5_10==81||LA5_10==94||LA5_10==114) ) {
                                alt5=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 10, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 83:
                        case 97:
                        case 104:
                            {
                            alt5=3;
                            }
                            break;
                        case 109:
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
                            else if ( ((LA5_11 >= 18 && LA5_11 <= 19)||(LA5_11 >= 21 && LA5_11 <= 26)||LA5_11==30||(LA5_11 >= 32 && LA5_11 <= 34)||(LA5_11 >= 36 && LA5_11 <= 40)||(LA5_11 >= 42 && LA5_11 <= 44)||LA5_11==46||(LA5_11 >= 49 && LA5_11 <= 50)||(LA5_11 >= 54 && LA5_11 <= 55)||(LA5_11 >= 57 && LA5_11 <= 60)||(LA5_11 >= 62 && LA5_11 <= 64)||(LA5_11 >= 67 && LA5_11 <= 68)||LA5_11==72||(LA5_11 >= 75 && LA5_11 <= 79)||LA5_11==81||LA5_11==94||LA5_11==114) ) {
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
                        case 95:
                        case 96:
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
                    case 54:
                    case 55:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 62:
                    case 63:
                    case 64:
                    case 67:
                    case 68:
                    case 72:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 81:
                    case 94:
                    case 114:
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
                case 74:
                case 99:
                case 103:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:569:4: '=' exprToken= expression[defer]
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:574:5: '=' funcToken= functionCall[defer]
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:579:11: '=' stmtToken= wrappedStatement[defer]
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:584:11: '+' '+'
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:589:11: '-' '-'
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:596:1: importStatement[boolean defer] : importToken= 'import' lstToken= listOfIDs[defer] ;
    public final EugeneParser.importStatement_return importStatement(boolean defer) throws RecognitionException {
        EugeneParser.importStatement_return retval = new EugeneParser.importStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token importToken=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object importToken_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:597:2: (importToken= 'import' lstToken= listOfIDs[defer] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:597:4: importToken= 'import' lstToken= listOfIDs[defer]
            {
            root_0 = (Object)adaptor.nil();


            importToken=(Token)match(input,93,FOLLOW_93_in_importStatement370); 
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
    // $ANTLR end "importStatement"


    public static class listOfFilenames_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listOfFilenames"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:626:1: listOfFilenames[boolean defer] : filenameToken= filename[defer] ( ',' listOfFilenames[defer] )? ;
    public final EugeneParser.listOfFilenames_return listOfFilenames(boolean defer) throws RecognitionException {
        EugeneParser.listOfFilenames_return retval = new EugeneParser.listOfFilenames_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal33=null;
        EugeneParser.filename_return filenameToken =null;

        EugeneParser.listOfFilenames_return listOfFilenames34 =null;


        Object char_literal33_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:627:2: (filenameToken= filename[defer] ( ',' listOfFilenames[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:627:4: filenameToken= filename[defer] ( ',' listOfFilenames[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_filename_in_listOfFilenames393);
            filenameToken=filename(defer);

            state._fsp--;

            adaptor.addChild(root_0, filenameToken.getTree());

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:627:34: ( ',' listOfFilenames[defer] )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:627:35: ',' listOfFilenames[defer]
                    {
                    char_literal33=(Token)match(input,24,FOLLOW_24_in_listOfFilenames397); 
                    char_literal33_tree = 
                    (Object)adaptor.create(char_literal33)
                    ;
                    adaptor.addChild(root_0, char_literal33_tree);


                    pushFollow(FOLLOW_listOfFilenames_in_listOfFilenames399);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:630:1: filename[boolean defer] returns [String sFilename] : (filenameToken+= (~ ( ',' | ';' | '(' ) ) )* ;
    public final EugeneParser.filename_return filename(boolean defer) throws RecognitionException {
        EugeneParser.filename_return retval = new EugeneParser.filename_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token filenameToken=null;
        List list_filenameToken=null;

        Object filenameToken_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:631:2: ( (filenameToken+= (~ ( ',' | ';' | '(' ) ) )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:631:4: (filenameToken+= (~ ( ',' | ';' | '(' ) ) )*
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:631:17: (filenameToken+= (~ ( ',' | ';' | '(' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= CHAR && LA7_0 <= 19)||(LA7_0 >= 21 && LA7_0 <= 23)||(LA7_0 >= 25 && LA7_0 <= 31)||(LA7_0 >= 33 && LA7_0 <= 115)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:631:17: filenameToken+= (~ ( ',' | ';' | '(' ) )
            	    {
            	    filenameToken=(Token)input.LT(1);

            	    if ( (input.LA(1) >= CHAR && input.LA(1) <= 19)||(input.LA(1) >= 21 && input.LA(1) <= 23)||(input.LA(1) >= 25 && input.LA(1) <= 31)||(input.LA(1) >= 33 && input.LA(1) <= 115) ) {
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:646:1: declarationStatement[boolean defer] : ( collectionDeclaration[defer] | variableDeclaration[defer] | propertyDeclaration[defer] | partTypeDeclaration[defer] | deviceDeclaration[defer] | arrayDeclaration[defer] | ruleDeclaration[defer] | imageDeclaration[defer] | deviceTypeDeclaration[defer] || relationDeclaration[defer] );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:647:2: ( collectionDeclaration[defer] | variableDeclaration[defer] | propertyDeclaration[defer] | partTypeDeclaration[defer] | deviceDeclaration[defer] | arrayDeclaration[defer] | ruleDeclaration[defer] | imageDeclaration[defer] | deviceTypeDeclaration[defer] || relationDeclaration[defer] )
            int alt8=11;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt8=1;
                }
                break;
            case 82:
            case 98:
            case 111:
                {
                alt8=2;
                }
                break;
            case 71:
                {
                int LA8_3 = input.LA(2);

                if ( (LA8_3==79) ) {
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
            case 70:
                {
                int LA8_4 = input.LA(2);

                if ( (LA8_4==ID) ) {
                    alt8=4;
                }
                else if ( (LA8_4==79) ) {
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
                else if ( (LA8_5==79) ) {
                    alt8=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 5, input);

                    throw nvae;

                }
                }
                break;
            case 69:
                {
                int LA8_6 = input.LA(2);

                if ( (LA8_6==ID) ) {
                    alt8=4;
                }
                else if ( (LA8_6==79) ) {
                    alt8=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 6, input);

                    throw nvae;

                }
                }
                break;
            case 73:
                {
                int LA8_7 = input.LA(2);

                if ( (LA8_7==79) ) {
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

                if ( (LA8_8==79) ) {
                    alt8=6;
                }
                else if ( (LA8_8==43||LA8_8==46||LA8_8==54||LA8_8==58||LA8_8==68||LA8_8==72) ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:647:4: collectionDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_collectionDeclaration_in_declarationStatement455);
                    collectionDeclaration35=collectionDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, collectionDeclaration35.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:648:4: variableDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_variableDeclaration_in_declarationStatement461);
                    variableDeclaration36=variableDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, variableDeclaration36.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:649:4: propertyDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_propertyDeclaration_in_declarationStatement467);
                    propertyDeclaration37=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyDeclaration37.getTree());

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:650:4: partTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partTypeDeclaration_in_declarationStatement473);
                    partTypeDeclaration38=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeDeclaration38.getTree());

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:651:4: deviceDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDeclaration_in_declarationStatement479);
                    deviceDeclaration39=deviceDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceDeclaration39.getTree());

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:652:4: arrayDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_arrayDeclaration_in_declarationStatement485);
                    arrayDeclaration40=arrayDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, arrayDeclaration40.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:653:4: ruleDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ruleDeclaration_in_declarationStatement491);
                    ruleDeclaration41=ruleDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, ruleDeclaration41.getTree());

                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:654:4: imageDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_imageDeclaration_in_declarationStatement497);
                    imageDeclaration42=imageDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, imageDeclaration42.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:655:4: deviceTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceTypeDeclaration_in_declarationStatement503);
                    deviceTypeDeclaration43=deviceTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceTypeDeclaration43.getTree());

                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:656:3: 
                    {
                    root_0 = (Object)adaptor.nil();


                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:656:5: relationDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_relationDeclaration_in_declarationStatement510);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:660:1: collectionDeclaration[boolean defer] : 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:664:2: ( 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:664:4: 'Collection' nameToken= ID (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal45=(Token)match(input,45,FOLLOW_45_in_collectionDeclaration533); 
            string_literal45_tree = 
            (Object)adaptor.create(string_literal45)
            ;
            adaptor.addChild(root_0, string_literal45_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_collectionDeclaration537); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);



            if(!defer) {
                objCollection = interp.createCollection(
                            (nameToken!=null?nameToken.getText():null), 
                            (java.util.Collection<NamedElement>)null);
            }             
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:671:3: (defToken= collectionDefinition[defer, objCollection] |assignToken= assignment[defer] )?
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
                    else if ( (LA9_2==FLOAT||LA9_2==ID||LA9_2==INT||LA9_2==STRING||LA9_2==18||LA9_2==20||LA9_2==25||(LA9_2 >= 33 && LA9_2 <= 34)||(LA9_2 >= 36 && LA9_2 <= 39)||(LA9_2 >= 42 && LA9_2 <= 44)||LA9_2==46||(LA9_2 >= 49 && LA9_2 <= 54)||(LA9_2 >= 57 && LA9_2 <= 64)||LA9_2==68||LA9_2==72||(LA9_2 >= 74 && LA9_2 <= 77)||LA9_2==79||LA9_2==87||LA9_2==99||LA9_2==103||LA9_2==110) ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:671:4: defToken= collectionDefinition[defer, objCollection]
                    {
                    pushFollow(FOLLOW_collectionDefinition_in_collectionDeclaration547);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:676:8: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_collectionDeclaration560);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:692:1: collectionDefinition[boolean defer, EugeneCollection objCollection] returns [java.util.Set<CollectionElement> colElements] : ( '(' lstToken= listOfCollectionComponents[defer] ')' | '=' includeToken= INCLUDE );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:697:2: ( '(' lstToken= listOfCollectionComponents[defer] ')' | '=' includeToken= INCLUDE )
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:697:4: '(' lstToken= listOfCollectionComponents[defer] ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal46=(Token)match(input,20,FOLLOW_20_in_collectionDefinition608); 
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
                    	

                    pushFollow(FOLLOW_listOfCollectionComponents_in_collectionDefinition615);
                    lstToken=listOfCollectionComponents(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());


                    if(!defer) {
                        retval.colElements.addAll((lstToken!=null?lstToken.lstElements:null));
                    }	
                    	

                    char_literal47=(Token)match(input,21,FOLLOW_21_in_collectionDefinition621); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:716:4: '=' includeToken= INCLUDE
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal48=(Token)match(input,35,FOLLOW_35_in_collectionDefinition628); 
                    char_literal48_tree = 
                    (Object)adaptor.create(char_literal48)
                    ;
                    adaptor.addChild(root_0, char_literal48_tree);


                    includeToken=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_collectionDefinition632); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:729:1: listOfCollectionComponents[boolean defer] returns [Set<CollectionElement> lstElements] : componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:734:9: (componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:734:11: componentToken= collectionElement[defer] ( ',' lstToken= listOfCollectionComponents[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_collectionElement_in_listOfCollectionComponents678);
            componentToken=collectionElement(defer);

            state._fsp--;

            adaptor.addChild(root_0, componentToken.getTree());


            if(!defer) {
                retval.lstElements.add((componentToken!=null?componentToken.objElement:null));
            }        
                    

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:738:11: ( ',' lstToken= listOfCollectionComponents[defer] )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:738:12: ',' lstToken= listOfCollectionComponents[defer]
                    {
                    char_literal49=(Token)match(input,24,FOLLOW_24_in_listOfCollectionComponents684); 
                    char_literal49_tree = 
                    (Object)adaptor.create(char_literal49)
                    ;
                    adaptor.addChild(root_0, char_literal49_tree);


                    pushFollow(FOLLOW_listOfCollectionComponents_in_listOfCollectionComponents688);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:745:1: collectionElement[boolean defer] returns [CollectionElement objElement] : (propertyToken= propertyDeclaration[defer] |partTypeToken= partTypeDeclaration[defer] |deviceToken= deviceDeclaration[defer] |instToken= instantiationStatement[defer] |idToken= ID );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:746:2: (propertyToken= propertyDeclaration[defer] |partTypeToken= partTypeDeclaration[defer] |deviceToken= deviceDeclaration[defer] |instToken= instantiationStatement[defer] |idToken= ID )
            int alt12=5;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt12=1;
                }
                break;
            case 69:
            case 70:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:746:4: propertyToken= propertyDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_propertyDeclaration_in_collectionElement726);
                    propertyToken=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyToken.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:747:4: partTypeToken= partTypeDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partTypeDeclaration_in_collectionElement734);
                    partTypeToken=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeToken.getTree());


                    if(!defer) {
                        retval.objElement = partTypeToken.objPartType;
                    }            
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:752:11: deviceToken= deviceDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDeclaration_in_collectionElement751);
                    deviceToken=deviceDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());


                    if(!defer) {
                        retval.objElement = (deviceToken!=null?deviceToken.objDevice:null);
                    }        
                            

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:757:4: instToken= instantiationStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_instantiationStatement_in_collectionElement761);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        retval.objElement = (instToken!=null?instToken.objComponent:null);
                    }
                            

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:762:11: idToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_collectionElement778); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:773:1: propertyDeclaration[boolean defer] returns [Property objProperty] : 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')' ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:775:2: ( 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:775:4: 'Property' nameToken= dynamicNaming[defer] '(' typeToken= propertyType ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal50=(Token)match(input,71,FOLLOW_71_in_propertyDeclaration801); 
            string_literal50_tree = 
            (Object)adaptor.create(string_literal50)
            ;
            adaptor.addChild(root_0, string_literal50_tree);


            pushFollow(FOLLOW_dynamicNaming_in_propertyDeclaration805);
            nameToken=dynamicNaming(defer);

            state._fsp--;

            adaptor.addChild(root_0, nameToken.getTree());

            char_literal51=(Token)match(input,20,FOLLOW_20_in_propertyDeclaration808); 
            char_literal51_tree = 
            (Object)adaptor.create(char_literal51)
            ;
            adaptor.addChild(root_0, char_literal51_tree);


            pushFollow(FOLLOW_propertyType_in_propertyDeclaration812);
            typeToken=propertyType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            char_literal52=(Token)match(input,21,FOLLOW_21_in_propertyDeclaration814); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:790:1: propertyType : ( 'txt' | 'txt' '[' ']' | 'num' | 'num' '[' ']' | 'boolean' );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:791:2: ( 'txt' | 'txt' '[' ']' | 'num' | 'num' '[' ']' | 'boolean' )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 111:
                {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==79) ) {
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
            case 98:
                {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==79) ) {
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
            case 82:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:791:4: 'txt'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal53=(Token)match(input,111,FOLLOW_111_in_propertyType833); 
                    string_literal53_tree = 
                    (Object)adaptor.create(string_literal53)
                    ;
                    adaptor.addChild(root_0, string_literal53_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:792:4: 'txt' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal54=(Token)match(input,111,FOLLOW_111_in_propertyType838); 
                    string_literal54_tree = 
                    (Object)adaptor.create(string_literal54)
                    ;
                    adaptor.addChild(root_0, string_literal54_tree);


                    char_literal55=(Token)match(input,79,FOLLOW_79_in_propertyType840); 
                    char_literal55_tree = 
                    (Object)adaptor.create(char_literal55)
                    ;
                    adaptor.addChild(root_0, char_literal55_tree);


                    char_literal56=(Token)match(input,80,FOLLOW_80_in_propertyType842); 
                    char_literal56_tree = 
                    (Object)adaptor.create(char_literal56)
                    ;
                    adaptor.addChild(root_0, char_literal56_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:793:4: 'num'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal57=(Token)match(input,98,FOLLOW_98_in_propertyType847); 
                    string_literal57_tree = 
                    (Object)adaptor.create(string_literal57)
                    ;
                    adaptor.addChild(root_0, string_literal57_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:794:4: 'num' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal58=(Token)match(input,98,FOLLOW_98_in_propertyType852); 
                    string_literal58_tree = 
                    (Object)adaptor.create(string_literal58)
                    ;
                    adaptor.addChild(root_0, string_literal58_tree);


                    char_literal59=(Token)match(input,79,FOLLOW_79_in_propertyType854); 
                    char_literal59_tree = 
                    (Object)adaptor.create(char_literal59)
                    ;
                    adaptor.addChild(root_0, char_literal59_tree);


                    char_literal60=(Token)match(input,80,FOLLOW_80_in_propertyType856); 
                    char_literal60_tree = 
                    (Object)adaptor.create(char_literal60)
                    ;
                    adaptor.addChild(root_0, char_literal60_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:795:4: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal61=(Token)match(input,82,FOLLOW_82_in_propertyType861); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:800:1: variableDeclaration[boolean defer] returns [List<Variable> lstVariables] : typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text] ;
    public final EugeneParser.variableDeclaration_return variableDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.variableDeclaration_return retval = new EugeneParser.variableDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.propertyType_return typeToken =null;

        EugeneParser.listOfVariables_return varToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:802:2: (typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:802:4: typeToken= propertyType varToken= listOfVariables[defer, $typeToken.text]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_propertyType_in_variableDeclaration885);
            typeToken=propertyType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            pushFollow(FOLLOW_listOfVariables_in_variableDeclaration889);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:809:1: listOfVariables[boolean defer, String sVariableType] returns [List<Variable> lstVariables] : idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:814:2: (idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:814:4: idToken= ID (assignToken= assignment[defer] )? ( ',' lstToken= listOfVariables[defer, sVariableType] )?
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfVariables917); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);



            if(!defer) {
                retval.lstVariables.add(
                    interp.createVariable((idToken!=null?idToken.getText():null), sVariableType));
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:819:9: (assignToken= assignment[defer] )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23||LA14_0==25||LA14_0==35) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:819:10: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_listOfVariables929);
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


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:824:14: ( ',' lstToken= listOfVariables[defer, sVariableType] )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:824:15: ',' lstToken= listOfVariables[defer, sVariableType]
                    {
                    char_literal62=(Token)match(input,24,FOLLOW_24_in_listOfVariables938); 
                    char_literal62_tree = 
                    (Object)adaptor.create(char_literal62)
                    ;
                    adaptor.addChild(root_0, char_literal62_tree);


                    pushFollow(FOLLOW_listOfVariables_in_listOfVariables942);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:840:1: partTypeDeclaration[boolean defer] returns [PartType objPartType] : ( ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? | ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer] );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:841:2: ( ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? | ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer] )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0 >= 69 && LA18_0 <= 70)) ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:841:4: ( 'Part' | 'PartType' ) nameToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )?
                    {
                    root_0 = (Object)adaptor.nil();


                    set63=(Token)input.LT(1);

                    if ( (input.LA(1) >= 69 && input.LA(1) <= 70) ) {
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


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_partTypeDeclaration984); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:841:38: ( '(' (lstToken= listOfIDs[defer] )? ')' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==20) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:841:39: '(' (lstToken= listOfIDs[defer] )? ')'
                            {
                            char_literal64=(Token)match(input,20,FOLLOW_20_in_partTypeDeclaration987); 
                            char_literal64_tree = 
                            (Object)adaptor.create(char_literal64)
                            ;
                            adaptor.addChild(root_0, char_literal64_tree);


                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:841:43: (lstToken= listOfIDs[defer] )?
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( (LA16_0==ID) ) {
                                alt16=1;
                            }
                            switch (alt16) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:841:44: lstToken= listOfIDs[defer]
                                    {
                                    pushFollow(FOLLOW_listOfIDs_in_partTypeDeclaration992);
                                    lstToken=listOfIDs(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, lstToken.getTree());

                                    }
                                    break;

                            }


                            char_literal65=(Token)match(input,21,FOLLOW_21_in_partTypeDeclaration997); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:848:11: ( 'Part' | 'PartType' ) nameToken= ID assignToken= assignment[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    set66=(Token)input.LT(1);

                    if ( (input.LA(1) >= 69 && input.LA(1) <= 70) ) {
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


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_partTypeDeclaration1021); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    pushFollow(FOLLOW_assignment_in_partTypeDeclaration1025);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:863:1: listOfIDs[boolean defer] returns [List<NamedElement> lstElements] : idToken= ID ( ',' lstToken= listOfIDs[defer] )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:867:2: (idToken= ID ( ',' lstToken= listOfIDs[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:867:4: idToken= ID ( ',' lstToken= listOfIDs[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfIDs1059); 
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:877:5: ( ',' lstToken= listOfIDs[defer] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:877:6: ',' lstToken= listOfIDs[defer]
                    {
                    char_literal67=(Token)match(input,24,FOLLOW_24_in_listOfIDs1065); 
                    char_literal67_tree = 
                    (Object)adaptor.create(char_literal67)
                    ;
                    adaptor.addChild(root_0, char_literal67_tree);


                    pushFollow(FOLLOW_listOfIDs_in_listOfIDs1069);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:887:1: deviceDeclaration[boolean defer] returns [Device objDevice] : 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:892:2: ( 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:892:4: 'Device' nameToken= ID ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal68=(Token)match(input,47,FOLLOW_47_in_deviceDeclaration1100); 
            string_literal68_tree = 
            (Object)adaptor.create(string_literal68)
            ;
            adaptor.addChild(root_0, string_literal68_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_deviceDeclaration1104); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:893:3: ( '(' (compToken= deviceComponents[defer] )? ')' |assignToken= assignment[defer] )?
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:893:4: '(' (compToken= deviceComponents[defer] )? ')'
                    {
                    char_literal69=(Token)match(input,20,FOLLOW_20_in_deviceDeclaration1110); 
                    char_literal69_tree = 
                    (Object)adaptor.create(char_literal69)
                    ;
                    adaptor.addChild(root_0, char_literal69_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:893:8: (compToken= deviceComponents[defer] )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==FLOAT||LA20_0==ID||LA20_0==INT||LA20_0==STRING||LA20_0==20||LA20_0==23||LA20_0==25||LA20_0==47||(LA20_0 >= 69 && LA20_0 <= 71)||LA20_0==79||LA20_0==87||LA20_0==110) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:893:9: compToken= deviceComponents[defer]
                            {
                            pushFollow(FOLLOW_deviceComponents_in_deviceDeclaration1115);
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


                    char_literal70=(Token)match(input,21,FOLLOW_21_in_deviceDeclaration1123); 
                    char_literal70_tree = 
                    (Object)adaptor.create(char_literal70)
                    ;
                    adaptor.addChild(root_0, char_literal70_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:904:11: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_deviceDeclaration1137);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:923:1: deviceComponents[boolean defer] returns [ArrayList<NamedElement> lstElements, char[] directions] : (directionToken= ( '-' | '+' ) )? (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:933:2: ( (directionToken= ( '-' | '+' ) )? (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:933:4: (directionToken= ( '-' | '+' ) )? (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] ) ( ',' compToken= deviceComponents[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:933:4: (directionToken= ( '-' | '+' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==23||LA22_0==25) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:933:5: directionToken= ( '-' | '+' )
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


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:934:3: (objToken= expressionValue[defer] |partTypeToken= partTypeDeclaration[defer] |instToken= instantiationStatement[defer] |propertyToken= propertyDeclaration[defer] |deviceToken= deviceDeclaration[defer] )
            int alt23=5;
            switch ( input.LA(1) ) {
            case FLOAT:
            case INT:
            case STRING:
            case 20:
            case 25:
            case 79:
            case 87:
            case 110:
                {
                alt23=1;
                }
                break;
            case ID:
                {
                int LA23_2 = input.LA(2);

                if ( (LA23_2==21||LA23_2==24||LA23_2==26||LA23_2==79) ) {
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
            case 69:
            case 70:
                {
                alt23=2;
                }
                break;
            case 71:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:934:4: objToken= expressionValue[defer]
                    {
                    pushFollow(FOLLOW_expressionValue_in_deviceComponents1198);
                    objToken=expressionValue(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, objToken.getTree());


                    if(!defer) {	
                        objElement = (objToken!=null?objToken.objElement:null);
                    }
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:939:4: partTypeToken= partTypeDeclaration[defer]
                    {
                    pushFollow(FOLLOW_partTypeDeclaration_in_deviceComponents1209);
                    partTypeToken=partTypeDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, partTypeToken.getTree());


                    if(!defer) {
                        objElement = (partTypeToken!=null?partTypeToken.objPartType:null);
                    }    
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:944:4: instToken= instantiationStatement[defer]
                    {
                    pushFollow(FOLLOW_instantiationStatement_in_deviceComponents1219);
                    instToken=instantiationStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, instToken.getTree());


                    if(!defer) {
                        objElement = (instToken!=null?instToken.objComponent:null);
                    }    
                        	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:949:4: propertyToken= propertyDeclaration[defer]
                    {
                    pushFollow(FOLLOW_propertyDeclaration_in_deviceComponents1229);
                    propertyToken=propertyDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, propertyToken.getTree());


                    if(!defer) {
                        objElement = (propertyToken!=null?propertyToken.objProperty:null);
                    }    
                        	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:954:4: deviceToken= deviceDeclaration[defer]
                    {
                    pushFollow(FOLLOW_deviceDeclaration_in_deviceComponents1239);
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:973:4: ( ',' compToken= deviceComponents[defer] )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==24) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:973:5: ',' compToken= deviceComponents[defer]
                    {
                    char_literal71=(Token)match(input,24,FOLLOW_24_in_deviceComponents1249); 
                    char_literal71_tree = 
                    (Object)adaptor.create(char_literal71)
                    ;
                    adaptor.addChild(root_0, char_literal71_tree);


                    pushFollow(FOLLOW_deviceComponents_in_deviceComponents1253);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:981:1: deviceTypeDeclaration[boolean defer] returns [DeviceType objDeviceType] : 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')' ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:983:2: ( 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:983:4: 'DeviceType' idToken= ID '(' lstToken= listOfIDs[defer] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal72=(Token)match(input,48,FOLLOW_48_in_deviceTypeDeclaration1279); 
            string_literal72_tree = 
            (Object)adaptor.create(string_literal72)
            ;
            adaptor.addChild(root_0, string_literal72_tree);


            idToken=(Token)match(input,ID,FOLLOW_ID_in_deviceTypeDeclaration1283); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal73=(Token)match(input,20,FOLLOW_20_in_deviceTypeDeclaration1285); 
            char_literal73_tree = 
            (Object)adaptor.create(char_literal73)
            ;
            adaptor.addChild(root_0, char_literal73_tree);


            pushFollow(FOLLOW_listOfIDs_in_deviceTypeDeclaration1289);
            lstToken=listOfIDs(defer);

            state._fsp--;

            adaptor.addChild(root_0, lstToken.getTree());

            char_literal74=(Token)match(input,21,FOLLOW_21_in_deviceTypeDeclaration1292); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:999:1: arrayDeclaration[boolean defer] returns [NamedElement objArray] : typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1004:2: (typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1004:4: typeToken= arrayType nameToken= ID (assignToken= assignment[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_arrayType_in_arrayDeclaration1327);
            typeToken=arrayType();

            state._fsp--;

            adaptor.addChild(root_0, typeToken.getTree());

            nameToken=(Token)match(input,ID,FOLLOW_ID_in_arrayDeclaration1331); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1004:37: (assignToken= assignment[defer] )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==23||LA25_0==25||LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1004:38: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_arrayDeclaration1336);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1021:1: arrayType : ( 'Device' '[' ']' | 'PartType' '[' ']' | 'Part' '[' ']' | 'Property' '[' ']' | 'Rule' '[' ']' | ID '[' ']' );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1022:2: ( 'Device' '[' ']' | 'PartType' '[' ']' | 'Part' '[' ']' | 'Property' '[' ']' | 'Rule' '[' ']' | ID '[' ']' )
            int alt26=6;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt26=1;
                }
                break;
            case 70:
                {
                alt26=2;
                }
                break;
            case 69:
                {
                alt26=3;
                }
                break;
            case 71:
                {
                alt26=4;
                }
                break;
            case 73:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1022:4: 'Device' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal75=(Token)match(input,47,FOLLOW_47_in_arrayType1360); 
                    string_literal75_tree = 
                    (Object)adaptor.create(string_literal75)
                    ;
                    adaptor.addChild(root_0, string_literal75_tree);


                    char_literal76=(Token)match(input,79,FOLLOW_79_in_arrayType1362); 
                    char_literal76_tree = 
                    (Object)adaptor.create(char_literal76)
                    ;
                    adaptor.addChild(root_0, char_literal76_tree);


                    char_literal77=(Token)match(input,80,FOLLOW_80_in_arrayType1364); 
                    char_literal77_tree = 
                    (Object)adaptor.create(char_literal77)
                    ;
                    adaptor.addChild(root_0, char_literal77_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1023:4: 'PartType' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal78=(Token)match(input,70,FOLLOW_70_in_arrayType1369); 
                    string_literal78_tree = 
                    (Object)adaptor.create(string_literal78)
                    ;
                    adaptor.addChild(root_0, string_literal78_tree);


                    char_literal79=(Token)match(input,79,FOLLOW_79_in_arrayType1371); 
                    char_literal79_tree = 
                    (Object)adaptor.create(char_literal79)
                    ;
                    adaptor.addChild(root_0, char_literal79_tree);


                    char_literal80=(Token)match(input,80,FOLLOW_80_in_arrayType1373); 
                    char_literal80_tree = 
                    (Object)adaptor.create(char_literal80)
                    ;
                    adaptor.addChild(root_0, char_literal80_tree);


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1024:4: 'Part' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal81=(Token)match(input,69,FOLLOW_69_in_arrayType1378); 
                    string_literal81_tree = 
                    (Object)adaptor.create(string_literal81)
                    ;
                    adaptor.addChild(root_0, string_literal81_tree);


                    char_literal82=(Token)match(input,79,FOLLOW_79_in_arrayType1380); 
                    char_literal82_tree = 
                    (Object)adaptor.create(char_literal82)
                    ;
                    adaptor.addChild(root_0, char_literal82_tree);


                    char_literal83=(Token)match(input,80,FOLLOW_80_in_arrayType1382); 
                    char_literal83_tree = 
                    (Object)adaptor.create(char_literal83)
                    ;
                    adaptor.addChild(root_0, char_literal83_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1025:4: 'Property' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal84=(Token)match(input,71,FOLLOW_71_in_arrayType1387); 
                    string_literal84_tree = 
                    (Object)adaptor.create(string_literal84)
                    ;
                    adaptor.addChild(root_0, string_literal84_tree);


                    char_literal85=(Token)match(input,79,FOLLOW_79_in_arrayType1389); 
                    char_literal85_tree = 
                    (Object)adaptor.create(char_literal85)
                    ;
                    adaptor.addChild(root_0, char_literal85_tree);


                    char_literal86=(Token)match(input,80,FOLLOW_80_in_arrayType1391); 
                    char_literal86_tree = 
                    (Object)adaptor.create(char_literal86)
                    ;
                    adaptor.addChild(root_0, char_literal86_tree);


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1026:4: 'Rule' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal87=(Token)match(input,73,FOLLOW_73_in_arrayType1396); 
                    string_literal87_tree = 
                    (Object)adaptor.create(string_literal87)
                    ;
                    adaptor.addChild(root_0, string_literal87_tree);


                    char_literal88=(Token)match(input,79,FOLLOW_79_in_arrayType1398); 
                    char_literal88_tree = 
                    (Object)adaptor.create(char_literal88)
                    ;
                    adaptor.addChild(root_0, char_literal88_tree);


                    char_literal89=(Token)match(input,80,FOLLOW_80_in_arrayType1400); 
                    char_literal89_tree = 
                    (Object)adaptor.create(char_literal89)
                    ;
                    adaptor.addChild(root_0, char_literal89_tree);


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1027:4: ID '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    ID90=(Token)match(input,ID,FOLLOW_ID_in_arrayType1405); 
                    ID90_tree = 
                    (Object)adaptor.create(ID90)
                    ;
                    adaptor.addChild(root_0, ID90_tree);


                    char_literal91=(Token)match(input,79,FOLLOW_79_in_arrayType1407); 
                    char_literal91_tree = 
                    (Object)adaptor.create(char_literal91)
                    ;
                    adaptor.addChild(root_0, char_literal91_tree);


                    char_literal92=(Token)match(input,80,FOLLOW_80_in_arrayType1409); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1032:1: ruleDeclaration[boolean defer] : 'Rule' ruleNameToken= ID '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')' ;
    public final EugeneParser.ruleDeclaration_return ruleDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.ruleDeclaration_return retval = new EugeneParser.ruleDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ruleNameToken=null;
        Token string_literal93=null;
        Token char_literal94=null;
        Token char_literal95=null;
        EugeneParser.onDevice_return deviceToken =null;

        EugeneParser.expression_return exprToken =null;


        Object ruleNameToken_tree=null;
        Object string_literal93_tree=null;
        Object char_literal94_tree=null;
        Object char_literal95_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1033:2: ( 'Rule' ruleNameToken= ID '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1033:4: 'Rule' ruleNameToken= ID '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal93=(Token)match(input,73,FOLLOW_73_in_ruleDeclaration1425); 
            string_literal93_tree = 
            (Object)adaptor.create(string_literal93)
            ;
            adaptor.addChild(root_0, string_literal93_tree);


            ruleNameToken=(Token)match(input,ID,FOLLOW_ID_in_ruleDeclaration1429); 
            ruleNameToken_tree = 
            (Object)adaptor.create(ruleNameToken)
            ;
            adaptor.addChild(root_0, ruleNameToken_tree);


            char_literal94=(Token)match(input,20,FOLLOW_20_in_ruleDeclaration1431); 
            char_literal94_tree = 
            (Object)adaptor.create(char_literal94)
            ;
            adaptor.addChild(root_0, char_literal94_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1034:5: (deviceToken= onDevice[defer] )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==66) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1034:6: deviceToken= onDevice[defer]
                    {
                    pushFollow(FOLLOW_onDevice_in_ruleDeclaration1441);
                    deviceToken=onDevice(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_ruleDeclaration1452);
            exprToken=expression(true);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {    
                interp.createRule((ruleNameToken!=null?ruleNameToken.getText():null), 
                        (deviceToken!=null?deviceToken.device:null), 
                        exprToken.start, 
                        (CommonTree)(exprToken!=null?((Object)exprToken.tree):null));    
            }
                    

            char_literal95=(Token)match(input,21,FOLLOW_21_in_ruleDeclaration1457); 
            char_literal95_tree = 
            (Object)adaptor.create(char_literal95)
            ;
            adaptor.addChild(root_0, char_literal95_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1051:1: onDevice[boolean defer] returns [Device device] : 'ON' deviceToken= ID ':' ;
    public final EugeneParser.onDevice_return onDevice(boolean defer) throws RecognitionException {
        EugeneParser.onDevice_return retval = new EugeneParser.onDevice_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token deviceToken=null;
        Token string_literal96=null;
        Token char_literal97=null;

        Object deviceToken_tree=null;
        Object string_literal96_tree=null;
        Object char_literal97_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1053:2: ( 'ON' deviceToken= ID ':' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1053:4: 'ON' deviceToken= ID ':'
            {
            root_0 = (Object)adaptor.nil();


            string_literal96=(Token)match(input,66,FOLLOW_66_in_onDevice1495); 
            string_literal96_tree = 
            (Object)adaptor.create(string_literal96)
            ;
            adaptor.addChild(root_0, string_literal96_tree);


            deviceToken=(Token)match(input,ID,FOLLOW_ID_in_onDevice1499); 
            deviceToken_tree = 
            (Object)adaptor.create(deviceToken)
            ;
            adaptor.addChild(root_0, deviceToken_tree);


            char_literal97=(Token)match(input,31,FOLLOW_31_in_onDevice1501); 
            char_literal97_tree = 
            (Object)adaptor.create(char_literal97)
            ;
            adaptor.addChild(root_0, char_literal97_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1075:1: folExpression[boolean defer] : ( ( 'FORALL' ^fToken= listOfIDs[defer] ) ( 'EXISTS' ^eToken= listOfIDs[defer] )? ':' | ( 'EXISTS' ^eToken= listOfIDs[defer] ) ':' );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1076:2: ( ( 'FORALL' ^fToken= listOfIDs[defer] ) ( 'EXISTS' ^eToken= listOfIDs[defer] )? ':' | ( 'EXISTS' ^eToken= listOfIDs[defer] ) ':' )
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1076:4: ( 'FORALL' ^fToken= listOfIDs[defer] ) ( 'EXISTS' ^eToken= listOfIDs[defer] )? ':'
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1076:4: ( 'FORALL' ^fToken= listOfIDs[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1076:5: 'FORALL' ^fToken= listOfIDs[defer]
                    {
                    string_literal98=(Token)match(input,52,FOLLOW_52_in_folExpression1545); 
                    string_literal98_tree = 
                    (Object)adaptor.create(string_literal98)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(string_literal98_tree, root_0);


                    pushFollow(FOLLOW_listOfIDs_in_folExpression1550);
                    fToken=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, fToken.getTree());

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1076:40: ( 'EXISTS' ^eToken= listOfIDs[defer] )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==51) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1076:41: 'EXISTS' ^eToken= listOfIDs[defer]
                            {
                            string_literal99=(Token)match(input,51,FOLLOW_51_in_folExpression1555); 
                            string_literal99_tree = 
                            (Object)adaptor.create(string_literal99)
                            ;
                            root_0 = (Object)adaptor.becomeRoot(string_literal99_tree, root_0);


                            pushFollow(FOLLOW_listOfIDs_in_folExpression1560);
                            eToken=listOfIDs(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, eToken.getTree());

                            }
                            break;

                    }


                    char_literal100=(Token)match(input,31,FOLLOW_31_in_folExpression1565); 
                    char_literal100_tree = 
                    (Object)adaptor.create(char_literal100)
                    ;
                    adaptor.addChild(root_0, char_literal100_tree);


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1077:4: ( 'EXISTS' ^eToken= listOfIDs[defer] ) ':'
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1077:4: ( 'EXISTS' ^eToken= listOfIDs[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1077:5: 'EXISTS' ^eToken= listOfIDs[defer]
                    {
                    string_literal101=(Token)match(input,51,FOLLOW_51_in_folExpression1572); 
                    string_literal101_tree = 
                    (Object)adaptor.create(string_literal101)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(string_literal101_tree, root_0);


                    pushFollow(FOLLOW_listOfIDs_in_folExpression1577);
                    eToken=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, eToken.getTree());

                    }


                    char_literal102=(Token)match(input,31,FOLLOW_31_in_folExpression1581); 
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


    public static class imageDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "imageDeclaration"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1096:1: imageDeclaration[boolean defer] : 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')' ;
    public final EugeneParser.imageDeclaration_return imageDeclaration(boolean defer) throws RecognitionException {
        EugeneParser.imageDeclaration_return retval = new EugeneParser.imageDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token imageNameToken=null;
        Token imagePathToken=null;
        Token string_literal103=null;
        Token char_literal104=null;
        Token char_literal105=null;
        Token char_literal106=null;

        Object imageNameToken_tree=null;
        Object imagePathToken_tree=null;
        Object string_literal103_tree=null;
        Object char_literal104_tree=null;
        Object char_literal105_tree=null;
        Object char_literal106_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1097:2: ( 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1097:4: 'Image' '(' imageNameToken= ID ',' imagePathToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal103=(Token)match(input,56,FOLLOW_56_in_imageDeclaration1606); 
            string_literal103_tree = 
            (Object)adaptor.create(string_literal103)
            ;
            adaptor.addChild(root_0, string_literal103_tree);


            char_literal104=(Token)match(input,20,FOLLOW_20_in_imageDeclaration1608); 
            char_literal104_tree = 
            (Object)adaptor.create(char_literal104)
            ;
            adaptor.addChild(root_0, char_literal104_tree);


            imageNameToken=(Token)match(input,ID,FOLLOW_ID_in_imageDeclaration1612); 
            imageNameToken_tree = 
            (Object)adaptor.create(imageNameToken)
            ;
            adaptor.addChild(root_0, imageNameToken_tree);


            char_literal105=(Token)match(input,24,FOLLOW_24_in_imageDeclaration1614); 
            char_literal105_tree = 
            (Object)adaptor.create(char_literal105)
            ;
            adaptor.addChild(root_0, char_literal105_tree);


            imagePathToken=(Token)match(input,STRING,FOLLOW_STRING_in_imageDeclaration1618); 
            imagePathToken_tree = 
            (Object)adaptor.create(imagePathToken)
            ;
            adaptor.addChild(root_0, imagePathToken_tree);


            char_literal106=(Token)match(input,21,FOLLOW_21_in_imageDeclaration1620); 
            char_literal106_tree = 
            (Object)adaptor.create(char_literal106)
            ;
            adaptor.addChild(root_0, char_literal106_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1106:1: relationDeclaration[boolean defer] : lhsToken= ID relationToken= pairingType rhsToken= ID ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1107:2: (lhsToken= ID relationToken= pairingType rhsToken= ID )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1107:4: lhsToken= ID relationToken= pairingType rhsToken= ID
            {
            root_0 = (Object)adaptor.nil();


            lhsToken=(Token)match(input,ID,FOLLOW_ID_in_relationDeclaration1638); 
            lhsToken_tree = 
            (Object)adaptor.create(lhsToken)
            ;
            adaptor.addChild(root_0, lhsToken_tree);


            pushFollow(FOLLOW_pairingType_in_relationDeclaration1642);
            relationToken=pairingType();

            state._fsp--;

            adaptor.addChild(root_0, relationToken.getTree());

            rhsToken=(Token)match(input,ID,FOLLOW_ID_in_relationDeclaration1646); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1120:1: pairingType : ( 'REPRESSES' | 'INDUCES' | 'DRIVES' | 'BINDS' | 'ORTHO' | 'MATCHES' );
    public final EugeneParser.pairingType_return pairingType() throws RecognitionException {
        EugeneParser.pairingType_return retval = new EugeneParser.pairingType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set107=null;

        Object set107_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1121:2: ( 'REPRESSES' | 'INDUCES' | 'DRIVES' | 'BINDS' | 'ORTHO' | 'MATCHES' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:
            {
            root_0 = (Object)adaptor.nil();


            set107=(Token)input.LT(1);

            if ( input.LA(1)==43||input.LA(1)==46||input.LA(1)==54||input.LA(1)==58||input.LA(1)==68||input.LA(1)==72 ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set107)
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1134:1: assertStatement[boolean defer] : assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' ;
    public final EugeneParser.assertStatement_return assertStatement(boolean defer) throws RecognitionException {
        EugeneParser.assertStatement_return retval = new EugeneParser.assertStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token assertToken=null;
        Token char_literal108=null;
        Token string_literal109=null;
        Token char_literal110=null;
        Token char_literal111=null;
        EugeneParser.expression_return deviceToken =null;

        EugeneParser.listOfIDs_return lstRules =null;


        Object assertToken_tree=null;
        Object char_literal108_tree=null;
        Object string_literal109_tree=null;
        Object char_literal110_tree=null;
        Object char_literal111_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1135:2: (assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1135:4: assertToken= 'Assert' '(' ( 'ON' deviceToken= expression[defer] ':' )? (lstRules= listOfIDs[defer] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            assertToken=(Token)match(input,41,FOLLOW_41_in_assertStatement1711); 
            assertToken_tree = 
            (Object)adaptor.create(assertToken)
            ;
            adaptor.addChild(root_0, assertToken_tree);


            char_literal108=(Token)match(input,20,FOLLOW_20_in_assertStatement1713); 
            char_literal108_tree = 
            (Object)adaptor.create(char_literal108)
            ;
            adaptor.addChild(root_0, char_literal108_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1135:29: ( 'ON' deviceToken= expression[defer] ':' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==66) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1135:30: 'ON' deviceToken= expression[defer] ':'
                    {
                    string_literal109=(Token)match(input,66,FOLLOW_66_in_assertStatement1716); 
                    string_literal109_tree = 
                    (Object)adaptor.create(string_literal109)
                    ;
                    adaptor.addChild(root_0, string_literal109_tree);


                    pushFollow(FOLLOW_expression_in_assertStatement1720);
                    deviceToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    char_literal110=(Token)match(input,31,FOLLOW_31_in_assertStatement1723); 
                    char_literal110_tree = 
                    (Object)adaptor.create(char_literal110)
                    ;
                    adaptor.addChild(root_0, char_literal110_tree);


                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1135:79: (lstRules= listOfIDs[defer] )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1135:79: lstRules= listOfIDs[defer]
                    {
                    pushFollow(FOLLOW_listOfIDs_in_assertStatement1729);
                    lstRules=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstRules.getTree());

                    }
                    break;

            }


            char_literal111=(Token)match(input,21,FOLLOW_21_in_assertStatement1733); 
            char_literal111_tree = 
            (Object)adaptor.create(char_literal111)
            ;
            adaptor.addChild(root_0, char_literal111_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1156:1: noteStatement[boolean defer] : noteToken= 'Note' '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')' ;
    public final EugeneParser.noteStatement_return noteStatement(boolean defer) throws RecognitionException {
        EugeneParser.noteStatement_return retval = new EugeneParser.noteStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token noteToken=null;
        Token char_literal112=null;
        Token char_literal113=null;
        EugeneParser.onDevice_return deviceToken =null;

        EugeneParser.expression_return exprToken =null;


        Object noteToken_tree=null;
        Object char_literal112_tree=null;
        Object char_literal113_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1157:2: (noteToken= 'Note' '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1157:4: noteToken= 'Note' '(' (deviceToken= onDevice[defer] )? exprToken= expression[true] ')'
            {
            root_0 = (Object)adaptor.nil();


            noteToken=(Token)match(input,65,FOLLOW_65_in_noteStatement1766); 
            noteToken_tree = 
            (Object)adaptor.create(noteToken)
            ;
            adaptor.addChild(root_0, noteToken_tree);


            char_literal112=(Token)match(input,20,FOLLOW_20_in_noteStatement1768); 
            char_literal112_tree = 
            (Object)adaptor.create(char_literal112)
            ;
            adaptor.addChild(root_0, char_literal112_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1158:4: (deviceToken= onDevice[defer] )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==66) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1158:5: deviceToken= onDevice[defer]
                    {
                    pushFollow(FOLLOW_onDevice_in_noteStatement1776);
                    deviceToken=onDevice(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_noteStatement1787);
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
                    

            char_literal113=(Token)match(input,21,FOLLOW_21_in_noteStatement1792); 
            char_literal113_tree = 
            (Object)adaptor.create(char_literal113)
            ;
            adaptor.addChild(root_0, char_literal113_tree);


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


            typeToken=(Token)match(input,ID,FOLLOW_ID_in_instantiationStatement1829); 
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
            	

            pushFollow(FOLLOW_instanceDefinitionStatement_in_instantiationStatement1837);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1221:4: partToken= partInstantiation[defer, objElement]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_partInstantiation_in_instanceDefinitionStatement1861);
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


                    pushFollow(FOLLOW_deviceInstantiation_in_instanceDefinitionStatement1878);
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
        Token DYNAMIC_NAME114=null;
        Token DYNAMIC_NAME115=null;
        EugeneParser.expression_return exprToken =null;


        Object nameToken_tree=null;
        Object DYNAMIC_NAME114_tree=null;
        Object DYNAMIC_NAME115_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1235:2: (nameToken= ID | DYNAMIC_NAME exprToken= expression[defer] DYNAMIC_NAME )
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1235:4: nameToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_dynamicNaming1902); 
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


                    DYNAMIC_NAME114=(Token)match(input,DYNAMIC_NAME,FOLLOW_DYNAMIC_NAME_in_dynamicNaming1909); 
                    DYNAMIC_NAME114_tree = 
                    (Object)adaptor.create(DYNAMIC_NAME114)
                    ;
                    adaptor.addChild(root_0, DYNAMIC_NAME114_tree);


                    pushFollow(FOLLOW_expression_in_dynamicNaming1913);
                    exprToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken.getTree());

                    DYNAMIC_NAME115=(Token)match(input,DYNAMIC_NAME,FOLLOW_DYNAMIC_NAME_in_dynamicNaming1916); 
                    DYNAMIC_NAME115_tree = 
                    (Object)adaptor.create(DYNAMIC_NAME115)
                    ;
                    adaptor.addChild(root_0, DYNAMIC_NAME115_tree);



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

        Token char_literal116=null;
        Token char_literal117=null;
        EugeneParser.dynamicNaming_return nameToken =null;

        EugeneParser.listOfDotValues_return dotToken =null;

        EugeneParser.listOfValues_return valueToken =null;

        EugeneParser.assignment_return assignToken =null;


        Object char_literal116_tree=null;
        Object char_literal117_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1261:2: ({...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1261:4: {...}?nameToken= dynamicNaming[defer] ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] )
            {
            root_0 = (Object)adaptor.nil();


            if ( !((objElement instanceof PartType)) ) {
                throw new FailedPredicateException(input, "partInstantiation", "objElement instanceof PartType");
            }

            pushFollow(FOLLOW_dynamicNaming_in_partInstantiation1946);
            nameToken=dynamicNaming(defer);

            state._fsp--;

            adaptor.addChild(root_0, nameToken.getTree());

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:34: ( ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )? |assignToken= assignment[defer] )
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:35: ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:35: ( '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')' )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==20) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:36: '(' (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )? ')'
                            {
                            char_literal116=(Token)match(input,20,FOLLOW_20_in_partInstantiation1951); 
                            char_literal116_tree = 
                            (Object)adaptor.create(char_literal116)
                            ;
                            adaptor.addChild(root_0, char_literal116_tree);


                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:40: (dotToken= listOfDotValues[defer] |valueToken= listOfValues[defer] )?
                            int alt35=3;
                            int LA35_0 = input.LA(1);

                            if ( (LA35_0==26) ) {
                                alt35=1;
                            }
                            else if ( (LA35_0==FLOAT||LA35_0==ID||LA35_0==INT||LA35_0==STRING||LA35_0==18||LA35_0==20||LA35_0==25||(LA35_0 >= 33 && LA35_0 <= 34)||(LA35_0 >= 36 && LA35_0 <= 39)||(LA35_0 >= 42 && LA35_0 <= 44)||LA35_0==46||(LA35_0 >= 49 && LA35_0 <= 52)||LA35_0==54||(LA35_0 >= 57 && LA35_0 <= 64)||LA35_0==68||LA35_0==72||(LA35_0 >= 75 && LA35_0 <= 77)||LA35_0==79||LA35_0==87||LA35_0==110) ) {
                                alt35=2;
                            }
                            switch (alt35) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:41: dotToken= listOfDotValues[defer]
                                    {
                                    pushFollow(FOLLOW_listOfDotValues_in_partInstantiation1956);
                                    dotToken=listOfDotValues(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, dotToken.getTree());

                                    }
                                    break;
                                case 2 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1262:75: valueToken= listOfValues[defer]
                                    {
                                    pushFollow(FOLLOW_listOfValues_in_partInstantiation1963);
                                    valueToken=listOfValues(defer);

                                    state._fsp--;

                                    adaptor.addChild(root_0, valueToken.getTree());

                                    }
                                    break;

                            }


                            char_literal117=(Token)match(input,21,FOLLOW_21_in_partInstantiation1968); 
                            char_literal117_tree = 
                            (Object)adaptor.create(char_literal117)
                            ;
                            adaptor.addChild(root_0, char_literal117_tree);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1263:6: assignToken= assignment[defer]
                    {
                    pushFollow(FOLLOW_assignment_in_partInstantiation1980);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1298:1: deviceInstantiation[boolean defer, NamedElement objElement] returns [DeviceInstance objDeviceInstance] : instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? ;
    public final EugeneParser.deviceInstantiation_return deviceInstantiation(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.deviceInstantiation_return retval = new EugeneParser.deviceInstantiation_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token instToken=null;
        Token char_literal118=null;
        Token char_literal119=null;
        EugeneParser.listOfIDs_return lstToken =null;


        Object instToken_tree=null;
        Object char_literal118_tree=null;
        Object char_literal119_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:2: (instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:4: instToken= ID ( '(' (lstToken= listOfIDs[defer] )? ')' )?
            {
            root_0 = (Object)adaptor.nil();


            instToken=(Token)match(input,ID,FOLLOW_ID_in_deviceInstantiation2013); 
            instToken_tree = 
            (Object)adaptor.create(instToken)
            ;
            adaptor.addChild(root_0, instToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:17: ( '(' (lstToken= listOfIDs[defer] )? ')' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==20) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:18: '(' (lstToken= listOfIDs[defer] )? ')'
                    {
                    char_literal118=(Token)match(input,20,FOLLOW_20_in_deviceInstantiation2016); 
                    char_literal118_tree = 
                    (Object)adaptor.create(char_literal118)
                    ;
                    adaptor.addChild(root_0, char_literal118_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:22: (lstToken= listOfIDs[defer] )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==ID) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1299:23: lstToken= listOfIDs[defer]
                            {
                            pushFollow(FOLLOW_listOfIDs_in_deviceInstantiation2021);
                            lstToken=listOfIDs(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, lstToken.getTree());

                            }
                            break;

                    }


                    char_literal119=(Token)match(input,21,FOLLOW_21_in_deviceInstantiation2026); 
                    char_literal119_tree = 
                    (Object)adaptor.create(char_literal119)
                    ;
                    adaptor.addChild(root_0, char_literal119_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1366:1: listOfDotValues[boolean defer] returns [List<PropertyValue> lstValues] : '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )? ;
    public final EugeneParser.listOfDotValues_return listOfDotValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfDotValues_return retval = new EugeneParser.listOfDotValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token char_literal120=null;
        Token char_literal121=null;
        Token char_literal122=null;
        Token char_literal123=null;
        EugeneParser.expression_return valueToken =null;

        EugeneParser.listOfDotValues_return dotValuesToken =null;


        Object nameToken_tree=null;
        Object char_literal120_tree=null;
        Object char_literal121_tree=null;
        Object char_literal122_tree=null;
        Object char_literal123_tree=null;


        retval.lstValues = new ArrayList<PropertyValue>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1371:2: ( '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1371:4: '.' nameToken= ID '(' valueToken= expression[defer] ')' ( ',' dotValuesToken= listOfDotValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            char_literal120=(Token)match(input,26,FOLLOW_26_in_listOfDotValues2064); 
            char_literal120_tree = 
            (Object)adaptor.create(char_literal120)
            ;
            adaptor.addChild(root_0, char_literal120_tree);


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfDotValues2068); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);


            char_literal121=(Token)match(input,20,FOLLOW_20_in_listOfDotValues2070); 
            char_literal121_tree = 
            (Object)adaptor.create(char_literal121)
            ;
            adaptor.addChild(root_0, char_literal121_tree);


            pushFollow(FOLLOW_expression_in_listOfDotValues2074);
            valueToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, valueToken.getTree());

            char_literal122=(Token)match(input,21,FOLLOW_21_in_listOfDotValues2077); 
            char_literal122_tree = 
            (Object)adaptor.create(char_literal122)
            ;
            adaptor.addChild(root_0, char_literal122_tree);



            if(!defer) {
                retval.lstValues.add(
                    interp.createPropertyValue(
                            (nameToken!=null?nameToken.getText():null), (valueToken!=null?valueToken.objElement:null)));
            }
                    

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1377:12: ( ',' dotValuesToken= listOfDotValues[defer] )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==24) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1377:13: ',' dotValuesToken= listOfDotValues[defer]
                    {
                    char_literal123=(Token)match(input,24,FOLLOW_24_in_listOfDotValues2083); 
                    char_literal123_tree = 
                    (Object)adaptor.create(char_literal123)
                    ;
                    adaptor.addChild(root_0, char_literal123_tree);


                    pushFollow(FOLLOW_listOfDotValues_in_listOfDotValues2087);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1393:1: listOfValues[boolean defer] returns [List<NamedElement> lstValues] : exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )? ;
    public final EugeneParser.listOfValues_return listOfValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfValues_return retval = new EugeneParser.listOfValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal124=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfValues_return lstToken =null;


        Object char_literal124_tree=null;


        retval.lstValues = new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1398:2: (exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1398:4: exprToken= expression[defer] ( ',' lstToken= listOfValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfValues2128);
            exprToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {
                retval.lstValues.add((exprToken!=null?exprToken.objElement:null));
            }
                    

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1402:11: ( ',' lstToken= listOfValues[defer] )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==24) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1402:12: ',' lstToken= listOfValues[defer]
                    {
                    char_literal124=(Token)match(input,24,FOLLOW_24_in_listOfValues2134); 
                    char_literal124_tree = 
                    (Object)adaptor.create(char_literal124)
                    ;
                    adaptor.addChild(root_0, char_literal124_tree);


                    pushFollow(FOLLOW_listOfValues_in_listOfValues2138);
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

        Token char_literal125=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfExpressions_return lstToken =null;


        Object char_literal125_tree=null;


        retval.lstElements = new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1417:2: (exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1417:4: exprToken= expression[defer] ( ',' lstToken= listOfExpressions[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfExpressions2170);
            exprToken=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken.getTree());


            if(!defer) {
                retval.lstElements.add((exprToken!=null?exprToken.objElement:null));
            }	
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1421:5: ( ',' lstToken= listOfExpressions[defer] )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==24) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1421:6: ',' lstToken= listOfExpressions[defer]
                    {
                    char_literal125=(Token)match(input,24,FOLLOW_24_in_listOfExpressions2177); 
                    char_literal125_tree = 
                    (Object)adaptor.create(char_literal125)
                    ;
                    adaptor.addChild(root_0, char_literal125_tree);


                    pushFollow(FOLLOW_listOfExpressions_in_listOfExpressions2181);
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


            pushFollow(FOLLOW_notExpression_in_expression2215);
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
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleSubtreeStream stream_orExpression=new RewriteRuleSubtreeStream(adaptor,"rule orExpression");

        boolean bNOT=false;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1444:2: (notToken= 'NOT' exprToken= orExpression[defer] -> ^( 'NOT' $exprToken) |exprToken= orExpression[defer] -> $exprToken)
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==61) ) {
                alt43=1;
            }
            else if ( (LA43_0==FLOAT||LA43_0==ID||LA43_0==INT||LA43_0==STRING||LA43_0==18||LA43_0==20||LA43_0==25||(LA43_0 >= 33 && LA43_0 <= 34)||(LA43_0 >= 36 && LA43_0 <= 39)||(LA43_0 >= 42 && LA43_0 <= 44)||LA43_0==46||(LA43_0 >= 49 && LA43_0 <= 52)||LA43_0==54||(LA43_0 >= 57 && LA43_0 <= 60)||(LA43_0 >= 62 && LA43_0 <= 64)||LA43_0==68||LA43_0==72||(LA43_0 >= 75 && LA43_0 <= 77)||LA43_0==79||LA43_0==87||LA43_0==110) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1444:4: notToken= 'NOT' exprToken= orExpression[defer]
                    {
                    notToken=(Token)match(input,61,FOLLOW_61_in_notExpression2252);  
                    stream_61.add(notToken);


                    pushFollow(FOLLOW_orExpression_in_notExpression2256);
                    exprToken=orExpression(defer);

                    state._fsp--;

                    stream_orExpression.add(exprToken.getTree());


                    if(!defer) {
                        retval.objElement = interp.not((exprToken!=null?exprToken.objElement:null));
                    }
                    	

                    // AST REWRITE
                    // elements: 61, exprToken
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
                        stream_61.nextNode()
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
                    pushFollow(FOLLOW_orExpression_in_notExpression2282);
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

        Token string_literal126=null;
        Token string_literal127=null;
        EugeneParser.andExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal126_tree=null;
        Object string_literal127_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_114=new RewriteRuleTokenStream(adaptor,"token 114");
        RewriteRuleSubtreeStream stream_andExpression=new RewriteRuleSubtreeStream(adaptor,"rule andExpression");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1457:2: ( (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1457:4: (leftToken= andExpression[defer] -> $leftToken) ( ( ( 'OR' | '||' ) rightToken= notExpression[defer] ) -> ^( 'OR' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1457:4: (leftToken= andExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1457:5: leftToken= andExpression[defer]
            {
            pushFollow(FOLLOW_andExpression_in_orExpression2310);
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
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==67) ) {
                alt45=1;
            }
            else if ( (LA45_0==114) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:5: ( ( 'OR' | '||' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:5: ( ( 'OR' | '||' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:6: ( 'OR' | '||' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:6: ( 'OR' | '||' )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==67) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==114) ) {
                        alt44=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;

                    }
                    switch (alt44) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:7: 'OR'
                            {
                            string_literal126=(Token)match(input,67,FOLLOW_67_in_orExpression2326);  
                            stream_67.add(string_literal126);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1458:12: '||'
                            {
                            string_literal127=(Token)match(input,114,FOLLOW_114_in_orExpression2328);  
                            stream_114.add(string_literal127);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_orExpression2333);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: leftToken, 67, rightToken
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
                        stream_67.nextNode()
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

        Token string_literal128=null;
        Token string_literal129=null;
        EugeneParser.xorExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal128_tree=null;
        Object string_literal129_tree=null;
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
            pushFollow(FOLLOW_xorExpression_in_andExpression2382);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:5: ( ( 'AND' | '&&' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:5: ( ( 'AND' | '&&' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:6: ( 'AND' | '&&' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:6: ( 'AND' | '&&' )
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
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:7: 'AND'
                            {
                            string_literal128=(Token)match(input,40,FOLLOW_40_in_andExpression2398);  
                            stream_40.add(string_literal128);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1479:13: '&&'
                            {
                            string_literal129=(Token)match(input,19,FOLLOW_19_in_andExpression2400);  
                            stream_19.add(string_literal129);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_andExpression2405);
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

        Token string_literal130=null;
        Token string_literal131=null;
        EugeneParser.comparativeExpression_return leftToken =null;

        EugeneParser.notExpression_return rightToken =null;


        Object string_literal130_tree=null;
        Object string_literal131_tree=null;
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleSubtreeStream stream_notExpression=new RewriteRuleSubtreeStream(adaptor,"rule notExpression");
        RewriteRuleSubtreeStream stream_comparativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule comparativeExpression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1499:2: ( (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1499:4: (leftToken= comparativeExpression[defer] -> $leftToken) ( ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] ) -> ^( 'XOR' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1499:4: (leftToken= comparativeExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1499:5: leftToken= comparativeExpression[defer]
            {
            pushFollow(FOLLOW_comparativeExpression_in_xorExpression2455);
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
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==78||LA49_0==81) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:5: ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:5: ( ( 'XOR' | '^^' ) rightToken= notExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:6: ( 'XOR' | '^^' ) rightToken= notExpression[defer]
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:6: ( 'XOR' | '^^' )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==78) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==81) ) {
                        alt48=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;

                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:7: 'XOR'
                            {
                            string_literal130=(Token)match(input,78,FOLLOW_78_in_xorExpression2471);  
                            stream_78.add(string_literal130);


                            }
                            break;
                        case 2 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1500:13: '^^'
                            {
                            string_literal131=(Token)match(input,81,FOLLOW_81_in_xorExpression2473);  
                            stream_81.add(string_literal131);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_notExpression_in_xorExpression2478);
                    rightToken=notExpression(defer);

                    state._fsp--;

                    stream_notExpression.add(rightToken.getTree());

                    }


                    // AST REWRITE
                    // elements: leftToken, rightToken, 78
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
                        stream_78.nextNode()
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1519:1: operator returns [String sOperator] : (relToken= relationalOperator |ruleToken= ruleOperator |pairToken= pairingType );
    public final EugeneParser.operator_return operator() throws RecognitionException {
        EugeneParser.operator_return retval = new EugeneParser.operator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.relationalOperator_return relToken =null;

        EugeneParser.ruleOperator_return ruleToken =null;

        EugeneParser.pairingType_return pairToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1520:2: (relToken= relationalOperator |ruleToken= ruleOperator |pairToken= pairingType )
            int alt50=3;
            switch ( input.LA(1) ) {
            case 18:
            case 33:
            case 34:
            case 36:
            case 37:
            case 38:
            case 50:
            case 62:
                {
                alt50=1;
                }
                break;
            case 39:
            case 42:
            case 44:
            case 49:
            case 57:
            case 59:
            case 60:
            case 63:
            case 64:
            case 75:
            case 76:
            case 77:
                {
                alt50=2;
                }
                break;
            case 43:
            case 46:
            case 54:
            case 58:
            case 68:
            case 72:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1520:4: relToken= relationalOperator
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_relationalOperator_in_operator2524);
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


                    pushFollow(FOLLOW_ruleOperator_in_operator2534);
                    ruleToken=ruleOperator();

                    state._fsp--;

                    adaptor.addChild(root_0, ruleToken.getTree());


                    retval.sOperator = (ruleToken!=null?ruleToken.sOperator:null);
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1526:4: pairToken= pairingType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_pairingType_in_operator2544);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1531:1: ruleOperator returns [String sOperator] : ( 'BEFORE' | 'AFTER' | 'STARTSWITH' | 'ENDSWITH' | 'NOTWITH' | 'WITH' | 'NEXTTO' | 'LEFTTO' | 'CONTAINS' | 'MORETHAN' | 'NOTMORETHAN' | 'THEN' );
    public final EugeneParser.ruleOperator_return ruleOperator() throws RecognitionException {
        EugeneParser.ruleOperator_return retval = new EugeneParser.ruleOperator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

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
        Token string_literal143=null;

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
        Object string_literal143_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1532:2: ( 'BEFORE' | 'AFTER' | 'STARTSWITH' | 'ENDSWITH' | 'NOTWITH' | 'WITH' | 'NEXTTO' | 'LEFTTO' | 'CONTAINS' | 'MORETHAN' | 'NOTMORETHAN' | 'THEN' )
            int alt51=12;
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
            case 75:
                {
                alt51=3;
                }
                break;
            case 49:
                {
                alt51=4;
                }
                break;
            case 64:
                {
                alt51=5;
                }
                break;
            case 77:
                {
                alt51=6;
                }
                break;
            case 60:
                {
                alt51=7;
                }
                break;
            case 57:
                {
                alt51=8;
                }
                break;
            case 44:
                {
                alt51=9;
                }
                break;
            case 59:
                {
                alt51=10;
                }
                break;
            case 63:
                {
                alt51=11;
                }
                break;
            case 76:
                {
                alt51=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1532:4: 'BEFORE'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal132=(Token)match(input,42,FOLLOW_42_in_ruleOperator2562); 
                    string_literal132_tree = 
                    (Object)adaptor.create(string_literal132)
                    ;
                    adaptor.addChild(root_0, string_literal132_tree);



                    retval.sOperator = EugeneConstants.BEFORE;


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1535:4: 'AFTER'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal133=(Token)match(input,39,FOLLOW_39_in_ruleOperator2569); 
                    string_literal133_tree = 
                    (Object)adaptor.create(string_literal133)
                    ;
                    adaptor.addChild(root_0, string_literal133_tree);



                    retval.sOperator = EugeneConstants.AFTER;


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1538:4: 'STARTSWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal134=(Token)match(input,75,FOLLOW_75_in_ruleOperator2576); 
                    string_literal134_tree = 
                    (Object)adaptor.create(string_literal134)
                    ;
                    adaptor.addChild(root_0, string_literal134_tree);



                    retval.sOperator = EugeneConstants.STARTSWITH;


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1541:4: 'ENDSWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal135=(Token)match(input,49,FOLLOW_49_in_ruleOperator2583); 
                    string_literal135_tree = 
                    (Object)adaptor.create(string_literal135)
                    ;
                    adaptor.addChild(root_0, string_literal135_tree);



                    retval.sOperator = EugeneConstants.ENDSWITH;


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1544:4: 'NOTWITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal136=(Token)match(input,64,FOLLOW_64_in_ruleOperator2590); 
                    string_literal136_tree = 
                    (Object)adaptor.create(string_literal136)
                    ;
                    adaptor.addChild(root_0, string_literal136_tree);



                    retval.sOperator = EugeneConstants.NOTWITH;


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1547:4: 'WITH'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal137=(Token)match(input,77,FOLLOW_77_in_ruleOperator2597); 
                    string_literal137_tree = 
                    (Object)adaptor.create(string_literal137)
                    ;
                    adaptor.addChild(root_0, string_literal137_tree);



                    retval.sOperator = EugeneConstants.WITH;


                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1550:4: 'NEXTTO'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal138=(Token)match(input,60,FOLLOW_60_in_ruleOperator2604); 
                    string_literal138_tree = 
                    (Object)adaptor.create(string_literal138)
                    ;
                    adaptor.addChild(root_0, string_literal138_tree);



                    retval.sOperator = EugeneConstants.NEXTTO;


                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1553:4: 'LEFTTO'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal139=(Token)match(input,57,FOLLOW_57_in_ruleOperator2611); 
                    string_literal139_tree = 
                    (Object)adaptor.create(string_literal139)
                    ;
                    adaptor.addChild(root_0, string_literal139_tree);



                    retval.sOperator = EugeneConstants.LEFTTO;


                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1556:4: 'CONTAINS'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal140=(Token)match(input,44,FOLLOW_44_in_ruleOperator2618); 
                    string_literal140_tree = 
                    (Object)adaptor.create(string_literal140)
                    ;
                    adaptor.addChild(root_0, string_literal140_tree);



                    retval.sOperator = EugeneConstants.CONTAINS;


                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1559:4: 'MORETHAN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal141=(Token)match(input,59,FOLLOW_59_in_ruleOperator2625); 
                    string_literal141_tree = 
                    (Object)adaptor.create(string_literal141)
                    ;
                    adaptor.addChild(root_0, string_literal141_tree);



                    retval.sOperator = EugeneConstants.MORETHAN;


                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1562:4: 'NOTMORETHAN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal142=(Token)match(input,63,FOLLOW_63_in_ruleOperator2632); 
                    string_literal142_tree = 
                    (Object)adaptor.create(string_literal142)
                    ;
                    adaptor.addChild(root_0, string_literal142_tree);



                    retval.sOperator = EugeneConstants.NOTMORETHAN;


                    }
                    break;
                case 12 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1565:4: 'THEN'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal143=(Token)match(input,76,FOLLOW_76_in_ruleOperator2639); 
                    string_literal143_tree = 
                    (Object)adaptor.create(string_literal143)
                    ;
                    adaptor.addChild(root_0, string_literal143_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1570:1: relationalOperator returns [String sOperator] : ( ( '==' | 'EQUALS' ) | ( '!=' | 'NOTEQUALS' ) | '<' | '<=' | '>' | '>=' );
    public final EugeneParser.relationalOperator_return relationalOperator() throws RecognitionException {
        EugeneParser.relationalOperator_return retval = new EugeneParser.relationalOperator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set144=null;
        Token set145=null;
        Token char_literal146=null;
        Token string_literal147=null;
        Token char_literal148=null;
        Token string_literal149=null;

        Object set144_tree=null;
        Object set145_tree=null;
        Object char_literal146_tree=null;
        Object string_literal147_tree=null;
        Object char_literal148_tree=null;
        Object string_literal149_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1571:2: ( ( '==' | 'EQUALS' ) | ( '!=' | 'NOTEQUALS' ) | '<' | '<=' | '>' | '>=' )
            int alt52=6;
            switch ( input.LA(1) ) {
            case 36:
            case 50:
                {
                alt52=1;
                }
                break;
            case 18:
            case 62:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1571:4: ( '==' | 'EQUALS' )
                    {
                    root_0 = (Object)adaptor.nil();


                    set144=(Token)input.LT(1);

                    if ( input.LA(1)==36||input.LA(1)==50 ) {
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



                    retval.sOperator =EugeneConstants.EQUALS;	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1574:4: ( '!=' | 'NOTEQUALS' )
                    {
                    root_0 = (Object)adaptor.nil();


                    set145=(Token)input.LT(1);

                    if ( input.LA(1)==18||input.LA(1)==62 ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (Object)adaptor.create(set145)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1577:4: '<'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal146=(Token)match(input,33,FOLLOW_33_in_relationalOperator2683); 
                    char_literal146_tree = 
                    (Object)adaptor.create(char_literal146)
                    ;
                    adaptor.addChild(root_0, char_literal146_tree);



                    retval.sOperator =EugeneConstants.LT;	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1580:4: '<='
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal147=(Token)match(input,34,FOLLOW_34_in_relationalOperator2691); 
                    string_literal147_tree = 
                    (Object)adaptor.create(string_literal147)
                    ;
                    adaptor.addChild(root_0, string_literal147_tree);



                    retval.sOperator =EugeneConstants.LEQ;	
                    	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1583:4: '>'
                    {
                    root_0 = (Object)adaptor.nil();


                    char_literal148=(Token)match(input,37,FOLLOW_37_in_relationalOperator2698); 
                    char_literal148_tree = 
                    (Object)adaptor.create(char_literal148)
                    ;
                    adaptor.addChild(root_0, char_literal148_tree);



                    retval.sOperator =EugeneConstants.GT;	
                    	

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1586:4: '>='
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal149=(Token)match(input,38,FOLLOW_38_in_relationalOperator2706); 
                    string_literal149_tree = 
                    (Object)adaptor.create(string_literal149)
                    ;
                    adaptor.addChild(root_0, string_literal149_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1591:1: comparativeExpression[boolean defer] returns [NamedElement objElement] : ( (folToken= folExpression[defer] ) -> $folToken)? ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) ) ;
    public final EugeneParser.comparativeExpression_return comparativeExpression(boolean defer) throws RecognitionException {
        EugeneParser.comparativeExpression_return retval = new EugeneParser.comparativeExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal150=null;
        Token string_literal151=null;
        EugeneParser.folExpression_return folToken =null;

        EugeneParser.addExpression_return exprToken1 =null;

        EugeneParser.operator_return oToken =null;

        EugeneParser.comparativeExpression_return exprToken2 =null;

        EugeneParser.type_return typeToken =null;

        EugeneParser.operator_return opToken =null;

        EugeneParser.addExpression_return exprToken =null;


        Object string_literal150_tree=null;
        Object string_literal151_tree=null;
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleSubtreeStream stream_folExpression=new RewriteRuleSubtreeStream(adaptor,"rule folExpression");
        RewriteRuleSubtreeStream stream_addExpression=new RewriteRuleSubtreeStream(adaptor,"rule addExpression");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        RewriteRuleSubtreeStream stream_comparativeExpression=new RewriteRuleSubtreeStream(adaptor,"rule comparativeExpression");
        RewriteRuleSubtreeStream stream_operator=new RewriteRuleSubtreeStream(adaptor,"rule operator");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1593:2: ( ( (folToken= folExpression[defer] ) -> $folToken)? ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1594:2: ( (folToken= folExpression[defer] ) -> $folToken)? ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) )
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1594:2: ( (folToken= folExpression[defer] ) -> $folToken)?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0 >= 51 && LA53_0 <= 52)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1594:3: (folToken= folExpression[defer] )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1594:3: (folToken= folExpression[defer] )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1594:4: folToken= folExpression[defer]
                    {
                    pushFollow(FOLLOW_folExpression_in_comparativeExpression2733);
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
                    // 1594:36: -> $folToken
                    {
                        adaptor.addChild(root_0, stream_folToken.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1596:2: ( (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )? |opToken= operator exprToken= addExpression[defer] -> ^( $opToken $exprToken) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==FLOAT||LA56_0==ID||LA56_0==INT||LA56_0==STRING||LA56_0==20||LA56_0==25||LA56_0==79||LA56_0==87||LA56_0==110) ) {
                alt56=1;
            }
            else if ( (LA56_0==18||(LA56_0 >= 33 && LA56_0 <= 34)||(LA56_0 >= 36 && LA56_0 <= 39)||(LA56_0 >= 42 && LA56_0 <= 44)||LA56_0==46||(LA56_0 >= 49 && LA56_0 <= 50)||LA56_0==54||(LA56_0 >= 57 && LA56_0 <= 60)||(LA56_0 >= 62 && LA56_0 <= 64)||LA56_0==68||LA56_0==72||(LA56_0 >= 75 && LA56_0 <= 77)) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }
            switch (alt56) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1597:2: (exprToken1= addExpression[defer] -> $exprToken1) (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1597:2: (exprToken1= addExpression[defer] -> $exprToken1)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1598:3: exprToken1= addExpression[defer]
                    {
                    pushFollow(FOLLOW_addExpression_in_comparativeExpression2758);
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
                    // 1602:3: -> $exprToken1
                    {
                        adaptor.addChild(root_0, stream_exprToken1.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1604:2: (oToken= operator exprToken2= comparativeExpression[defer] -> ^( $oToken $exprToken1 $exprToken2) | ( 'INSTANCEOF' | 'instanceof' ) typeToken= type -> ^( 'INSTANCEOF' $typeToken) )?
                    int alt55=3;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==18||(LA55_0 >= 33 && LA55_0 <= 34)||(LA55_0 >= 36 && LA55_0 <= 39)||(LA55_0 >= 42 && LA55_0 <= 44)||LA55_0==46||(LA55_0 >= 49 && LA55_0 <= 50)||LA55_0==54||(LA55_0 >= 57 && LA55_0 <= 60)||(LA55_0 >= 62 && LA55_0 <= 64)||LA55_0==68||LA55_0==72||(LA55_0 >= 75 && LA55_0 <= 77)) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==55||LA55_0==94) ) {
                        alt55=2;
                    }
                    switch (alt55) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1604:4: oToken= operator exprToken2= comparativeExpression[defer]
                            {
                            pushFollow(FOLLOW_operator_in_comparativeExpression2778);
                            oToken=operator();

                            state._fsp--;

                            stream_operator.add(oToken.getTree());

                            pushFollow(FOLLOW_comparativeExpression_in_comparativeExpression2782);
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
                            // 1608:3: -> ^( $oToken $exprToken1 $exprToken2)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1608:6: ^( $oToken $exprToken1 $exprToken2)
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
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1609:5: ( 'INSTANCEOF' | 'instanceof' ) typeToken= type
                            {
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1609:5: ( 'INSTANCEOF' | 'instanceof' )
                            int alt54=2;
                            int LA54_0 = input.LA(1);

                            if ( (LA54_0==55) ) {
                                alt54=1;
                            }
                            else if ( (LA54_0==94) ) {
                                alt54=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 54, 0, input);

                                throw nvae;

                            }
                            switch (alt54) {
                                case 1 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1609:6: 'INSTANCEOF'
                                    {
                                    string_literal150=(Token)match(input,55,FOLLOW_55_in_comparativeExpression2805);  
                                    stream_55.add(string_literal150);


                                    }
                                    break;
                                case 2 :
                                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1609:19: 'instanceof'
                                    {
                                    string_literal151=(Token)match(input,94,FOLLOW_94_in_comparativeExpression2807);  
                                    stream_94.add(string_literal151);


                                    }
                                    break;

                            }


                            pushFollow(FOLLOW_type_in_comparativeExpression2812);
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
                            // 1614:3: -> ^( 'INSTANCEOF' $typeToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1614:6: ^( 'INSTANCEOF' $typeToken)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1616:7: opToken= operator exprToken= addExpression[defer]
                    {
                    pushFollow(FOLLOW_operator_in_comparativeExpression2836);
                    opToken=operator();

                    state._fsp--;

                    stream_operator.add(opToken.getTree());

                    pushFollow(FOLLOW_addExpression_in_comparativeExpression2840);
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
                    // 1617:5: -> ^( $opToken $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1617:8: ^( $opToken $exprToken)
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1627:1: addExpression[boolean defer] returns [NamedElement objElement] : (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1629:2: ( (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1629:4: (leftToken= subtractExpression[defer] -> $leftToken) (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1629:4: (leftToken= subtractExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1629:5: leftToken= subtractExpression[defer]
            {
            pushFollow(FOLLOW_subtractExpression_in_addExpression2889);
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
            // 1629:42: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1630:4: (opToken= '+' rightToken= addExpression[defer] -> ^( '+' $leftToken $rightToken) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==23) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1630:5: opToken= '+' rightToken= addExpression[defer]
                    {
                    opToken=(Token)match(input,23,FOLLOW_23_in_addExpression2905);  
                    stream_23.add(opToken);


                    pushFollow(FOLLOW_addExpression_in_addExpression2909);
                    rightToken=addExpression(defer);

                    state._fsp--;

                    stream_addExpression.add(rightToken.getTree());

                    // AST REWRITE
                    // elements: leftToken, rightToken, 23
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
                    // 1631:5: -> ^( '+' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1631:8: ^( '+' $leftToken $rightToken)
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1648:1: subtractExpression[boolean defer] returns [NamedElement objElement] : (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1650:2: ( (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1650:4: (leftToken= multiplicativeExpression[defer] -> $leftToken) (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1650:4: (leftToken= multiplicativeExpression[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1650:5: leftToken= multiplicativeExpression[defer]
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_subtractExpression2957);
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
            // 1650:47: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1651:4: (opToken= '-' rightToken= subtractExpression[defer] -> ^( '-' $leftToken $rightToken) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==25) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1651:5: opToken= '-' rightToken= subtractExpression[defer]
                    {
                    opToken=(Token)match(input,25,FOLLOW_25_in_subtractExpression2972);  
                    stream_25.add(opToken);


                    pushFollow(FOLLOW_subtractExpression_in_subtractExpression2976);
                    rightToken=subtractExpression(defer);

                    state._fsp--;

                    stream_subtractExpression.add(rightToken.getTree());

                    // AST REWRITE
                    // elements: rightToken, leftToken, 25
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
                    // 1652:4: -> ^( '-' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1652:7: ^( '-' $leftToken $rightToken)
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1670:1: multiplicativeExpression[boolean defer] returns [NamedElement objElement] : (leftToken= expressionValue[defer] -> $leftToken) ( (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) ) | (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) ) )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1672:6: ( (leftToken= expressionValue[defer] -> $leftToken) ( (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) ) | (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) ) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1672:11: (leftToken= expressionValue[defer] -> $leftToken) ( (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) ) | (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) ) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1672:11: (leftToken= expressionValue[defer] -> $leftToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1672:12: leftToken= expressionValue[defer]
            {
            pushFollow(FOLLOW_expressionValue_in_multiplicativeExpression3027);
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
            // 1676:8: -> $leftToken
            {
                adaptor.addChild(root_0, stream_leftToken.nextTree());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1677:6: ( (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) ) | (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) ) )?
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1678:8: (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1678:8: (opToken= '*' rightToken= multiplicativeExpression[defer] -> ^( '*' $leftToken $rightToken) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1678:9: opToken= '*' rightToken= multiplicativeExpression[defer]
                    {
                    opToken=(Token)match(input,22,FOLLOW_22_in_multiplicativeExpression3055);  
                    stream_22.add(opToken);


                    pushFollow(FOLLOW_multiplicativeExpression_in_multiplicativeExpression3059);
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
                    // elements: leftToken, rightToken, 22
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
                    // 1686:4: -> ^( '*' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1686:7: ^( '*' $leftToken $rightToken)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1687:5: (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1687:5: (opToken= '/' rightToken= multiplicativeExpression[defer] -> ^( '/' $leftToken $rightToken) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1687:6: opToken= '/' rightToken= multiplicativeExpression[defer]
                    {
                    opToken=(Token)match(input,30,FOLLOW_30_in_multiplicativeExpression3084);  
                    stream_30.add(opToken);


                    pushFollow(FOLLOW_multiplicativeExpression_in_multiplicativeExpression3088);
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
                    // elements: leftToken, 30, rightToken
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
                    // 1695:4: -> ^( '/' $leftToken $rightToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1695:7: ^( '/' $leftToken $rightToken)
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1702:1: expressionValue[boolean defer] returns [NamedElement objElement] : ( (minToken= '-' )? numToken= ( INT | FLOAT ) |txtToken= STRING |boolToken= ( 'true' | 'false' ) | (accessToken= objectAccessStatement[defer] -> $accessToken) | '(' exprToken= expression[defer] ')' -> ^( '(' $exprToken) | '[' lstToken= listOfExpressions[defer] ']' -> ^( '[' $lstToken) );
    public final EugeneParser.expressionValue_return expressionValue(boolean defer) throws RecognitionException {
        EugeneParser.expressionValue_return retval = new EugeneParser.expressionValue_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token minToken=null;
        Token numToken=null;
        Token txtToken=null;
        Token boolToken=null;
        Token char_literal152=null;
        Token char_literal153=null;
        Token char_literal154=null;
        Token char_literal155=null;
        EugeneParser.objectAccessStatement_return accessToken =null;

        EugeneParser.expression_return exprToken =null;

        EugeneParser.listOfExpressions_return lstToken =null;


        Object minToken_tree=null;
        Object numToken_tree=null;
        Object txtToken_tree=null;
        Object boolToken_tree=null;
        Object char_literal152_tree=null;
        Object char_literal153_tree=null;
        Object char_literal154_tree=null;
        Object char_literal155_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_objectAccessStatement=new RewriteRuleSubtreeStream(adaptor,"rule objectAccessStatement");
        RewriteRuleSubtreeStream stream_listOfExpressions=new RewriteRuleSubtreeStream(adaptor,"rule listOfExpressions");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1703:2: ( (minToken= '-' )? numToken= ( INT | FLOAT ) |txtToken= STRING |boolToken= ( 'true' | 'false' ) | (accessToken= objectAccessStatement[defer] -> $accessToken) | '(' exprToken= expression[defer] ')' -> ^( '(' $exprToken) | '[' lstToken= listOfExpressions[defer] ']' -> ^( '[' $lstToken) )
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
            case 87:
            case 110:
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
            case 79:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1703:4: (minToken= '-' )? numToken= ( INT | FLOAT )
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1703:4: (minToken= '-' )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==25) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1703:5: minToken= '-'
                            {
                            minToken=(Token)match(input,25,FOLLOW_25_in_expressionValue3132); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1713:4: txtToken= STRING
                    {
                    root_0 = (Object)adaptor.nil();


                    txtToken=(Token)match(input,STRING,FOLLOW_STRING_in_expressionValue3152); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1720:4: boolToken= ( 'true' | 'false' )
                    {
                    root_0 = (Object)adaptor.nil();


                    boolToken=(Token)input.LT(1);

                    if ( input.LA(1)==87||input.LA(1)==110 ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1727:11: (accessToken= objectAccessStatement[defer] -> $accessToken)
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1727:11: (accessToken= objectAccessStatement[defer] -> $accessToken)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1727:12: accessToken= objectAccessStatement[defer]
                    {
                    pushFollow(FOLLOW_objectAccessStatement_in_expressionValue3186);
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
                    // 1731:4: -> $accessToken
                    {
                        adaptor.addChild(root_0, stream_accessToken.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1732:4: '(' exprToken= expression[defer] ')'
                    {
                    char_literal152=(Token)match(input,20,FOLLOW_20_in_expressionValue3200);  
                    stream_20.add(char_literal152);


                    pushFollow(FOLLOW_expression_in_expressionValue3204);
                    exprToken=expression(defer);

                    state._fsp--;

                    stream_expression.add(exprToken.getTree());

                    char_literal153=(Token)match(input,21,FOLLOW_21_in_expressionValue3207);  
                    stream_21.add(char_literal153);



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
                    // 1736:15: -> ^( '(' $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1736:18: ^( '(' $exprToken)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1737:4: '[' lstToken= listOfExpressions[defer] ']'
                    {
                    char_literal154=(Token)match(input,79,FOLLOW_79_in_expressionValue3231);  
                    stream_79.add(char_literal154);


                    pushFollow(FOLLOW_listOfExpressions_in_expressionValue3235);
                    lstToken=listOfExpressions(defer);

                    state._fsp--;

                    stream_listOfExpressions.add(lstToken.getTree());

                    char_literal155=(Token)match(input,80,FOLLOW_80_in_expressionValue3238);  
                    stream_80.add(char_literal155);



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
                    // elements: 79, lstToken
                    // token labels: 
                    // rule labels: retval, lstToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_lstToken=new RewriteRuleSubtreeStream(adaptor,"rule lstToken",lstToken!=null?lstToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1857:11: -> ^( '[' $lstToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1857:14: ^( '[' $lstToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_79.nextNode()
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1866:1: objectAccessStatement[boolean defer] returns [NamedElement objElement] : (idToken= ID -> $idToken) (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )? ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1868:2: ( (idToken= ID -> $idToken) (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1868:4: (idToken= ID -> $idToken) (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )?
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1868:4: (idToken= ID -> $idToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1868:5: idToken= ID
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_objectAccessStatement3276);  
            stream_ID.add(idToken);



            if(!defer) {
                retval.objElement = interp.get((idToken!=null?idToken.getText():null));

            /***
                if(retval.objElement==null) {
                    System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
                            "I don't know anything about "+(idToken!=null?idToken.getText():null)+"!");
                    this.cleanUp(1);	
                } 
             ***/
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
            // 1880:4: -> $idToken
            {
                adaptor.addChild(root_0, stream_idToken.nextNode());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1881:3: (accessToken= objectAccess[defer, $objElement] -> ^( $idToken $accessToken) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==26||LA62_0==79) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1881:4: accessToken= objectAccess[defer, $objElement]
                    {
                    pushFollow(FOLLOW_objectAccess_in_objectAccessStatement3292);
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
                    // 1885:4: -> ^( $idToken $accessToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1885:7: ^( $idToken $accessToken)
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
    // $ANTLR end "objectAccessStatement"


    public static class objectAccess_return extends ParserRuleReturnScope {
        public NamedElement objReturnElement;
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "objectAccess"
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1888:1: objectAccess[boolean defer, NamedElement objElement] returns [NamedElement objReturnElement] : ( (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )? | (dotToken= dotAccess[defer, $objElement] -> $dotToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )? );
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1890:2: ( (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )? | (dotToken= dotAccess[defer, $objElement] -> $dotToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )? )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==79) ) {
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1890:4: (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1890:4: (arrayToken= arrayAccess[defer, $objElement] -> $arrayToken)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1890:5: arrayToken= arrayAccess[defer, $objElement]
                    {
                    pushFollow(FOLLOW_arrayAccess_in_objectAccess3327);
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
                    // 1894:4: -> $arrayToken
                    {
                        adaptor.addChild(root_0, stream_arrayToken.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1895:4: (accessToken= access[defer, $objElement] -> ^( $objectAccess $arrayToken $accessToken) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==26||LA63_0==79) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1895:5: accessToken= access[defer, $objElement]
                            {
                            pushFollow(FOLLOW_access_in_objectAccess3345);
                            accessToken=access(defer, objElement);

                            state._fsp--;

                            stream_access.add(accessToken.getTree());


                            if(!defer) {
                                objElement = (accessToken!=null?accessToken.objReturnElement:null);
                            }				
                            	

                            // AST REWRITE
                            // elements: arrayToken, accessToken, objectAccess
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
                            // 1899:5: -> ^( $objectAccess $arrayToken $accessToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1899:8: ^( $objectAccess $arrayToken $accessToken)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1904:4: (dotToken= dotAccess[defer, $objElement] -> $dotToken) (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )?
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1904:4: (dotToken= dotAccess[defer, $objElement] -> $dotToken)
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1904:5: dotToken= dotAccess[defer, $objElement]
                    {
                    pushFollow(FOLLOW_dotAccess_in_objectAccess3375);
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
                    // 1908:5: -> $dotToken
                    {
                        adaptor.addChild(root_0, stream_dotToken.nextTree());

                    }


                    retval.tree = root_0;

                    }


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1909:4: (accessToken= access[defer, $objElement] -> ^( $objectAccess $dotToken $accessToken) )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==26||LA64_0==79) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1909:5: accessToken= access[defer, $objElement]
                            {
                            pushFollow(FOLLOW_access_in_objectAccess3395);
                            accessToken=access(defer, objElement);

                            state._fsp--;

                            stream_access.add(accessToken.getTree());


                            if(!defer) {
                                objElement = (accessToken!=null?accessToken.objReturnElement:null);
                            }				
                            	

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
                            // 1913:4: -> ^( $objectAccess $dotToken $accessToken)
                            {
                                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1913:7: ^( $objectAccess $dotToken $accessToken)
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1920:1: access[boolean defer, NamedElement objElement] returns [NamedElement objReturnElement] : objectToken= objectAccess[defer, $objElement] ;
    public final EugeneParser.access_return access(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.access_return retval = new EugeneParser.access_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.objectAccess_return objectToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1922:2: (objectToken= objectAccess[defer, $objElement] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1922:4: objectToken= objectAccess[defer, $objElement]
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_objectAccess_in_access3436);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1929:1: arrayAccess[boolean defer, NamedElement objElement] returns [NamedElement objReturnElement] : ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) ) ;
    public final EugeneParser.arrayAccess_return arrayAccess(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.arrayAccess_return retval = new EugeneParser.arrayAccess_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal156=null;
        Token char_literal157=null;
        EugeneParser.expression_return idxToken =null;


        Object char_literal156_tree=null;
        Object char_literal157_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1931:2: ( ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1931:4: ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) )
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1931:4: ( '[' idxToken= expression[defer] ']' -> ^( '[' $idxToken) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1931:5: '[' idxToken= expression[defer] ']'
            {
            char_literal156=(Token)match(input,79,FOLLOW_79_in_arrayAccess3460);  
            stream_79.add(char_literal156);


            pushFollow(FOLLOW_expression_in_arrayAccess3464);
            idxToken=expression(defer);

            state._fsp--;

            stream_expression.add(idxToken.getTree());

            char_literal157=(Token)match(input,80,FOLLOW_80_in_arrayAccess3467);  
            stream_80.add(char_literal157);



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
            // elements: 79, idxToken
            // token labels: 
            // rule labels: retval, idxToken
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_idxToken=new RewriteRuleSubtreeStream(adaptor,"rule idxToken",idxToken!=null?idxToken.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1963:4: -> ^( '[' $idxToken)
            {
                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1963:7: ^( '[' $idxToken)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_79.nextNode()
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1973:1: dotAccess[boolean defer, NamedElement objElement] returns [NamedElement objReturnElement] : ( ( '.' propertyToken= ID -> ^( '.' $propertyToken) ) | ( ( '.' 'size' ( '(' ')' )? ) -> ^( '.' 'size' ) ) | ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) ) | ( '.' seqToken= 'toSequence' ( '(' ')' )? -> ^( '.' 'toSequence' ) ) | ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' 'isEmpty' ) ) | ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) ) );
    public final EugeneParser.dotAccess_return dotAccess(boolean defer, NamedElement objElement) throws RecognitionException {
        EugeneParser.dotAccess_return retval = new EugeneParser.dotAccess_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token propertyToken=null;
        Token getToken=null;
        Token seqToken=null;
        Token emptyToken=null;
        Token char_literal158=null;
        Token char_literal159=null;
        Token string_literal160=null;
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
        Token char_literal172=null;
        Token string_literal173=null;
        Token char_literal174=null;
        Token char_literal175=null;
        EugeneParser.expression_return exprToken =null;


        Object propertyToken_tree=null;
        Object getToken_tree=null;
        Object seqToken_tree=null;
        Object emptyToken_tree=null;
        Object char_literal158_tree=null;
        Object char_literal159_tree=null;
        Object string_literal160_tree=null;
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
        Object char_literal172_tree=null;
        Object string_literal173_tree=null;
        Object char_literal174_tree=null;
        Object char_literal175_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleTokenStream stream_107=new RewriteRuleTokenStream(adaptor,"token 107");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1975:2: ( ( '.' propertyToken= ID -> ^( '.' $propertyToken) ) | ( ( '.' 'size' ( '(' ')' )? ) -> ^( '.' 'size' ) ) | ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) ) | ( '.' seqToken= 'toSequence' ( '(' ')' )? -> ^( '.' 'toSequence' ) ) | ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' 'isEmpty' ) ) | ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) ) )
            int alt70=6;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==26) ) {
                switch ( input.LA(2) ) {
                case ID:
                    {
                    alt70=1;
                    }
                    break;
                case 107:
                    {
                    alt70=2;
                    }
                    break;
                case 91:
                    {
                    alt70=3;
                    }
                    break;
                case 109:
                    {
                    alt70=4;
                    }
                    break;
                case 96:
                    {
                    alt70=5;
                    }
                    break;
                case 95:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1975:4: ( '.' propertyToken= ID -> ^( '.' $propertyToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1975:4: ( '.' propertyToken= ID -> ^( '.' $propertyToken) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1975:6: '.' propertyToken= ID
                    {
                    char_literal158=(Token)match(input,26,FOLLOW_26_in_dotAccess3505);  
                    stream_26.add(char_literal158);


                    propertyToken=(Token)match(input,ID,FOLLOW_ID_in_dotAccess3509);  
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
                    // 1979:4: -> ^( '.' $propertyToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1979:7: ^( '.' $propertyToken)
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1980:4: ( ( '.' 'size' ( '(' ')' )? ) -> ^( '.' 'size' ) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1980:4: ( ( '.' 'size' ( '(' ')' )? ) -> ^( '.' 'size' ) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1980:5: ( '.' 'size' ( '(' ')' )? )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1980:5: ( '.' 'size' ( '(' ')' )? )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1980:6: '.' 'size' ( '(' ')' )?
                    {
                    char_literal159=(Token)match(input,26,FOLLOW_26_in_dotAccess3529);  
                    stream_26.add(char_literal159);


                    string_literal160=(Token)match(input,107,FOLLOW_107_in_dotAccess3531);  
                    stream_107.add(string_literal160);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1980:17: ( '(' ')' )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==20) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1980:18: '(' ')'
                            {
                            char_literal161=(Token)match(input,20,FOLLOW_20_in_dotAccess3534);  
                            stream_20.add(char_literal161);


                            char_literal162=(Token)match(input,21,FOLLOW_21_in_dotAccess3535);  
                            stream_21.add(char_literal162);


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
                    // elements: 107, 26
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1987:4: -> ^( '.' 'size' )
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1987:7: ^( '.' 'size' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_107.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1988:4: ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1988:4: ( '.' getToken= 'get' '(' exprToken= expression[defer] ')' -> ^( '.' 'get' $exprToken) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1988:5: '.' getToken= 'get' '(' exprToken= expression[defer] ')'
                    {
                    char_literal163=(Token)match(input,26,FOLLOW_26_in_dotAccess3555);  
                    stream_26.add(char_literal163);


                    getToken=(Token)match(input,91,FOLLOW_91_in_dotAccess3559);  
                    stream_91.add(getToken);


                    char_literal164=(Token)match(input,20,FOLLOW_20_in_dotAccess3561);  
                    stream_20.add(char_literal164);


                    pushFollow(FOLLOW_expression_in_dotAccess3565);
                    exprToken=expression(defer);

                    state._fsp--;

                    stream_expression.add(exprToken.getTree());

                    char_literal165=(Token)match(input,21,FOLLOW_21_in_dotAccess3568);  
                    stream_21.add(char_literal165);



                    if(!defer) {
                        retval.objReturnElement = interp.get(objElement, (exprToken!=null?exprToken.objElement:null));
                    }	
                    	

                    // AST REWRITE
                    // elements: 26, exprToken, 91
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1992:4: -> ^( '.' 'get' $exprToken)
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1992:7: ^( '.' 'get' $exprToken)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_91.nextNode()
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1993:4: ( '.' seqToken= 'toSequence' ( '(' ')' )? -> ^( '.' 'toSequence' ) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1993:4: ( '.' seqToken= 'toSequence' ( '(' ')' )? -> ^( '.' 'toSequence' ) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1993:5: '.' seqToken= 'toSequence' ( '(' ')' )?
                    {
                    char_literal166=(Token)match(input,26,FOLLOW_26_in_dotAccess3588);  
                    stream_26.add(char_literal166);


                    seqToken=(Token)match(input,109,FOLLOW_109_in_dotAccess3592);  
                    stream_109.add(seqToken);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1993:31: ( '(' ')' )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==20) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1993:32: '(' ')'
                            {
                            char_literal167=(Token)match(input,20,FOLLOW_20_in_dotAccess3595);  
                            stream_20.add(char_literal167);


                            char_literal168=(Token)match(input,21,FOLLOW_21_in_dotAccess3597);  
                            stream_21.add(char_literal168);


                            }
                            break;

                    }



                    if(!defer) {
                        Variable objVariable = new Variable("SEQUENCE",EugeneConstants.TXT);
                        objVariable.setTxt(interp.toSequence(objElement));
                        retval.objReturnElement = objVariable;
                    }
                    	

                    // AST REWRITE
                    // elements: 26, 109
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1999:4: -> ^( '.' 'toSequence' )
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:1999:7: ^( '.' 'toSequence' )
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
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2000:4: ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' 'isEmpty' ) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2000:4: ( '.' emptyToken= 'isEmpty' ( '(' ')' )? -> ^( '.' 'isEmpty' ) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2000:5: '.' emptyToken= 'isEmpty' ( '(' ')' )?
                    {
                    char_literal169=(Token)match(input,26,FOLLOW_26_in_dotAccess3616);  
                    stream_26.add(char_literal169);


                    emptyToken=(Token)match(input,96,FOLLOW_96_in_dotAccess3620);  
                    stream_96.add(emptyToken);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2000:30: ( '(' ')' )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==20) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2000:31: '(' ')'
                            {
                            char_literal170=(Token)match(input,20,FOLLOW_20_in_dotAccess3623);  
                            stream_20.add(char_literal170);


                            char_literal171=(Token)match(input,21,FOLLOW_21_in_dotAccess3625);  
                            stream_21.add(char_literal171);


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
                    // elements: 96, 26
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 2010:4: -> ^( '.' 'isEmpty' )
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2010:7: ^( '.' 'isEmpty' )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_96.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2011:4: ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) )
                    {
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2011:4: ( '.' 'instantiate' '(' (exprToken= expression[defer] )? ')' -> ^( '.' 'instantiate' ( $exprToken)? ) )
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2011:5: '.' 'instantiate' '(' (exprToken= expression[defer] )? ')'
                    {
                    char_literal172=(Token)match(input,26,FOLLOW_26_in_dotAccess3644);  
                    stream_26.add(char_literal172);


                    string_literal173=(Token)match(input,95,FOLLOW_95_in_dotAccess3646);  
                    stream_95.add(string_literal173);


                    char_literal174=(Token)match(input,20,FOLLOW_20_in_dotAccess3648);  
                    stream_20.add(char_literal174);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2011:27: (exprToken= expression[defer] )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==FLOAT||LA69_0==ID||LA69_0==INT||LA69_0==STRING||LA69_0==18||LA69_0==20||LA69_0==25||(LA69_0 >= 33 && LA69_0 <= 34)||(LA69_0 >= 36 && LA69_0 <= 39)||(LA69_0 >= 42 && LA69_0 <= 44)||LA69_0==46||(LA69_0 >= 49 && LA69_0 <= 52)||LA69_0==54||(LA69_0 >= 57 && LA69_0 <= 64)||LA69_0==68||LA69_0==72||(LA69_0 >= 75 && LA69_0 <= 77)||LA69_0==79||LA69_0==87||LA69_0==110) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2011:28: exprToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_dotAccess3653);
                            exprToken=expression(defer);

                            state._fsp--;

                            stream_expression.add(exprToken.getTree());

                            }
                            break;

                    }


                    char_literal175=(Token)match(input,21,FOLLOW_21_in_dotAccess3658);  
                    stream_21.add(char_literal175);



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
                    // elements: 95, exprToken, 26
                    // token labels: 
                    // rule labels: retval, exprToken
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exprToken=new RewriteRuleSubtreeStream(adaptor,"rule exprToken",exprToken!=null?exprToken.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 2024:4: -> ^( '.' 'instantiate' ( $exprToken)? )
                    {
                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2024:7: ^( '.' 'instantiate' ( $exprToken)? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        stream_26.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_95.nextNode()
                        );

                        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2024:28: ( $exprToken)?
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2045:1: objectAssignmentStatement[boolean defer] returns [NamedElement assignElement] : ( (idToken= ID -> $idToken) ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )* ) rightToken= assignment[defer] ;
    public final EugeneParser.objectAssignmentStatement_return objectAssignmentStatement(boolean defer) throws RecognitionException {
        EugeneParser.objectAssignmentStatement_return retval = new EugeneParser.objectAssignmentStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token subIdToken=null;
        Token char_literal176=null;
        Token char_literal177=null;
        Token char_literal178=null;
        EugeneParser.expression_return idxToken =null;

        EugeneParser.assignment_return rightToken =null;


        Object idToken_tree=null;
        Object subIdToken_tree=null;
        Object char_literal176_tree=null;
        Object char_literal177_tree=null;
        Object char_literal178_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");

        NamedElement objElement = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2050:2: ( ( (idToken= ID -> $idToken) ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )* ) rightToken= assignment[defer] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2050:4: ( (idToken= ID -> $idToken) ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )* ) rightToken= assignment[defer]
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2050:4: ( (idToken= ID -> $idToken) ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2050:5: (idToken= ID -> $idToken) ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )*
            {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2050:5: (idToken= ID -> $idToken)
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2050:6: idToken= ID
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_objectAssignmentStatement3712);  
            stream_ID.add(idToken);



            if(!defer) {
                objElement = interp.get((idToken!=null?idToken.getText():null));    
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
            // 2054:8: -> $idToken
            {
                adaptor.addChild(root_0, stream_idToken.nextNode());

            }


            retval.tree = root_0;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2055:2: ( ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) ) | ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) ) )*
            loop71:
            do {
                int alt71=3;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==26) ) {
                    alt71=1;
                }
                else if ( (LA71_0==79) ) {
                    alt71=2;
                }


                switch (alt71) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2055:4: ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2055:4: ( '.' subIdToken= ID -> ^( '.' $objectAssignmentStatement $subIdToken) )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2055:5: '.' subIdToken= ID
            	    {
            	    char_literal176=(Token)match(input,26,FOLLOW_26_in_objectAssignmentStatement3730);  
            	    stream_26.add(char_literal176);


            	    subIdToken=(Token)match(input,ID,FOLLOW_ID_in_objectAssignmentStatement3734);  
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
            	    // elements: 26, subIdToken, objectAssignmentStatement
            	    // token labels: subIdToken
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_subIdToken=new RewriteRuleTokenStream(adaptor,"token subIdToken",subIdToken);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 2065:4: -> ^( '.' $objectAssignmentStatement $subIdToken)
            	    {
            	        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2065:7: ^( '.' $objectAssignmentStatement $subIdToken)
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
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2066:5: ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2066:5: ( '[' idxToken= expression[defer] ']' -> ^( '[' $objectAssignmentStatement $idxToken) )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2066:6: '[' idxToken= expression[defer] ']'
            	    {
            	    char_literal177=(Token)match(input,79,FOLLOW_79_in_objectAssignmentStatement3756);  
            	    stream_79.add(char_literal177);



            	    if(!defer) {
            	        if(null==objElement) {
            	            System.err.println("line "+(idToken!=null?idToken.getLine():0)+":"+(idToken!=null?idToken.getCharPositionInLine():0)+" => "+
            	                        "Invalid array access on "+(idToken!=null?idToken.getText():null));
            	            this.cleanUp(1);
            	        }
            	    }	
            	    	

            	    pushFollow(FOLLOW_expression_in_objectAssignmentStatement3762);
            	    idxToken=expression(defer);

            	    state._fsp--;

            	    stream_expression.add(idxToken.getTree());

            	    char_literal178=(Token)match(input,80,FOLLOW_80_in_objectAssignmentStatement3765);  
            	    stream_80.add(char_literal178);



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
            	    // elements: idxToken, objectAssignmentStatement, 79
            	    // token labels: 
            	    // rule labels: retval, idxToken
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_idxToken=new RewriteRuleSubtreeStream(adaptor,"rule idxToken",idxToken!=null?idxToken.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 2090:4: -> ^( '[' $objectAssignmentStatement $idxToken)
            	    {
            	        // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2090:7: ^( '[' $objectAssignmentStatement $idxToken)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(
            	        stream_79.nextNode()
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


            pushFollow(FOLLOW_assignment_in_objectAssignmentStatement3795);
            rightToken=assignment(defer);

            state._fsp--;

            stream_assignment.add(rightToken.getTree());


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2115:1: listOfStatements[boolean defer] returns [NamedElement objReturnValue] : (stmtToken= statement[defer] )+ ;
    public final EugeneParser.listOfStatements_return listOfStatements(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.listOfStatements_return retval = new EugeneParser.listOfStatements_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.statement_return stmtToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2117:2: ( (stmtToken= statement[defer] )+ )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2117:4: (stmtToken= statement[defer] )+
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2117:4: (stmtToken= statement[defer] )+
            int cnt72=0;
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( ((LA72_0 >= ID && LA72_0 <= INCLUDE)||LA72_0==32||LA72_0==41||LA72_0==45||(LA72_0 >= 47 && LA72_0 <= 48)||LA72_0==53||LA72_0==56||LA72_0==65||(LA72_0 >= 69 && LA72_0 <= 71)||(LA72_0 >= 73 && LA72_0 <= 74)||LA72_0==82||LA72_0==84||LA72_0==89||(LA72_0 >= 92 && LA72_0 <= 93)||(LA72_0 >= 98 && LA72_0 <= 103)||(LA72_0 >= 105 && LA72_0 <= 106)||(LA72_0 >= 111 && LA72_0 <= 112)) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2117:5: stmtToken= statement[defer]
            	    {
            	    pushFollow(FOLLOW_statement_in_listOfStatements3829);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2125:1: returnStatement[boolean defer] returns [NamedElement objReturnValue] : returnToken= 'return' (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )? ';' ;
    public final EugeneParser.returnStatement_return returnStatement(boolean defer) throws RecognitionException {
        EugeneParser.returnStatement_return retval = new EugeneParser.returnStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token returnToken=null;
        Token char_literal179=null;
        EugeneParser.expression_return exprToken =null;

        EugeneParser.functionCall_return functionToken =null;

        EugeneParser.wrappedStatement_return wrapperToken =null;


        Object returnToken_tree=null;
        Object char_literal179_tree=null;


        NamedElement objReturn = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2129:2: (returnToken= 'return' (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )? ';' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2129:4: returnToken= 'return' (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )? ';'
            {
            root_0 = (Object)adaptor.nil();


            returnToken=(Token)match(input,105,FOLLOW_105_in_returnStatement3859); 
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2154:2: (exprToken= expression[defer] |functionToken= functionCall[defer] |wrapperToken= wrappedStatement[defer] )?
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
                case 54:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 68:
                case 72:
                case 75:
                case 76:
                case 77:
                case 79:
                case 87:
                case 110:
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
                                case 91:
                                    {
                                    int LA73_7 = input.LA(4);

                                    if ( (LA73_7==20) ) {
                                        switch ( input.LA(5) ) {
                                            case INT:
                                                {
                                                int LA73_13 = input.LA(6);

                                                if ( ((LA73_13 >= 18 && LA73_13 <= 19)||(LA73_13 >= 21 && LA73_13 <= 23)||LA73_13==25||LA73_13==30||(LA73_13 >= 33 && LA73_13 <= 34)||(LA73_13 >= 36 && LA73_13 <= 40)||(LA73_13 >= 42 && LA73_13 <= 44)||LA73_13==46||(LA73_13 >= 49 && LA73_13 <= 50)||(LA73_13 >= 54 && LA73_13 <= 55)||(LA73_13 >= 57 && LA73_13 <= 60)||(LA73_13 >= 62 && LA73_13 <= 64)||(LA73_13 >= 67 && LA73_13 <= 68)||LA73_13==72||(LA73_13 >= 75 && LA73_13 <= 78)||LA73_13==81||LA73_13==94||LA73_13==114) ) {
                                                    alt73=1;
                                                }
                                                }
                                                break;
                                            case ID:
                                                {
                                                int LA73_14 = input.LA(6);

                                                if ( ((LA73_14 >= 18 && LA73_14 <= 19)||(LA73_14 >= 21 && LA73_14 <= 23)||(LA73_14 >= 25 && LA73_14 <= 26)||LA73_14==30||(LA73_14 >= 33 && LA73_14 <= 34)||(LA73_14 >= 36 && LA73_14 <= 40)||(LA73_14 >= 42 && LA73_14 <= 44)||LA73_14==46||(LA73_14 >= 49 && LA73_14 <= 50)||(LA73_14 >= 54 && LA73_14 <= 55)||(LA73_14 >= 57 && LA73_14 <= 60)||(LA73_14 >= 62 && LA73_14 <= 64)||(LA73_14 >= 67 && LA73_14 <= 68)||LA73_14==72||(LA73_14 >= 75 && LA73_14 <= 79)||LA73_14==81||LA73_14==94||LA73_14==114) ) {
                                                    alt73=1;
                                                }
                                                }
                                                break;
                                            case STRING:
                                                {
                                                int LA73_15 = input.LA(6);

                                                if ( ((LA73_15 >= 18 && LA73_15 <= 19)||(LA73_15 >= 21 && LA73_15 <= 23)||LA73_15==25||LA73_15==30||(LA73_15 >= 33 && LA73_15 <= 34)||(LA73_15 >= 36 && LA73_15 <= 40)||(LA73_15 >= 42 && LA73_15 <= 44)||LA73_15==46||(LA73_15 >= 49 && LA73_15 <= 50)||(LA73_15 >= 54 && LA73_15 <= 55)||(LA73_15 >= 57 && LA73_15 <= 60)||(LA73_15 >= 62 && LA73_15 <= 64)||(LA73_15 >= 67 && LA73_15 <= 68)||LA73_15==72||(LA73_15 >= 75 && LA73_15 <= 78)||LA73_15==81||LA73_15==94||LA73_15==114) ) {
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
                                            case 54:
                                            case 57:
                                            case 58:
                                            case 59:
                                            case 60:
                                            case 61:
                                            case 62:
                                            case 63:
                                            case 64:
                                            case 68:
                                            case 72:
                                            case 75:
                                            case 76:
                                            case 77:
                                            case 79:
                                            case 87:
                                            case 110:
                                                {
                                                alt73=1;
                                                }
                                                break;
                                        }

                                    }
                                    }
                                    break;
                                case 107:
                                    {
                                    int LA73_8 = input.LA(4);

                                    if ( (LA73_8==20) ) {
                                        int LA73_11 = input.LA(5);

                                        if ( (LA73_11==21) ) {
                                            alt73=1;
                                        }
                                    }
                                    else if ( ((LA73_8 >= 18 && LA73_8 <= 19)||(LA73_8 >= 22 && LA73_8 <= 23)||(LA73_8 >= 25 && LA73_8 <= 26)||LA73_8==30||(LA73_8 >= 32 && LA73_8 <= 34)||(LA73_8 >= 36 && LA73_8 <= 40)||(LA73_8 >= 42 && LA73_8 <= 44)||LA73_8==46||(LA73_8 >= 49 && LA73_8 <= 50)||(LA73_8 >= 54 && LA73_8 <= 55)||(LA73_8 >= 57 && LA73_8 <= 60)||(LA73_8 >= 62 && LA73_8 <= 64)||(LA73_8 >= 67 && LA73_8 <= 68)||LA73_8==72||(LA73_8 >= 75 && LA73_8 <= 79)||LA73_8==81||LA73_8==94||LA73_8==114) ) {
                                        alt73=1;
                                    }
                                    }
                                    break;
                                case 83:
                                case 97:
                                case 104:
                                    {
                                    alt73=3;
                                    }
                                    break;
                                case 109:
                                    {
                                    int LA73_9 = input.LA(4);

                                    if ( (LA73_9==20) ) {
                                        int LA73_12 = input.LA(5);

                                        if ( (LA73_12==21) ) {
                                            alt73=1;
                                        }
                                    }
                                    else if ( ((LA73_9 >= 18 && LA73_9 <= 19)||(LA73_9 >= 22 && LA73_9 <= 23)||(LA73_9 >= 25 && LA73_9 <= 26)||LA73_9==30||(LA73_9 >= 32 && LA73_9 <= 34)||(LA73_9 >= 36 && LA73_9 <= 40)||(LA73_9 >= 42 && LA73_9 <= 44)||LA73_9==46||(LA73_9 >= 49 && LA73_9 <= 50)||(LA73_9 >= 54 && LA73_9 <= 55)||(LA73_9 >= 57 && LA73_9 <= 60)||(LA73_9 >= 62 && LA73_9 <= 64)||(LA73_9 >= 67 && LA73_9 <= 68)||LA73_9==72||(LA73_9 >= 75 && LA73_9 <= 79)||LA73_9==81||LA73_9==94||LA73_9==114) ) {
                                        alt73=1;
                                    }
                                    }
                                    break;
                                case ID:
                                case 95:
                                case 96:
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
                        case 54:
                        case 55:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 62:
                        case 63:
                        case 64:
                        case 67:
                        case 68:
                        case 72:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 81:
                        case 94:
                        case 114:
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
                case 53:
                case 74:
                case 99:
                case 103:
                    {
                    alt73=3;
                    }
                    break;
            }

            switch (alt73) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2154:4: exprToken= expression[defer]
                    {
                    pushFollow(FOLLOW_expression_in_returnStatement3869);
                    exprToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, exprToken.getTree());


                    if(!defer) {
                        retval.objReturnValue = (exprToken!=null?exprToken.objElement:null);
                    }
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2159:4: functionToken= functionCall[defer]
                    {
                    pushFollow(FOLLOW_functionCall_in_returnStatement3879);
                    functionToken=functionCall(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, functionToken.getTree());


                    if(!defer) {
                        retval.objReturnValue = (functionToken!=null?functionToken.objElement:null);
                    }
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2164:4: wrapperToken= wrappedStatement[defer]
                    {
                    pushFollow(FOLLOW_wrappedStatement_in_returnStatement3889);
                    wrapperToken=wrappedStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, wrapperToken.getTree());


                    if(!defer) {
                        retval.objReturnValue = (wrapperToken!=null?wrapperToken.objElement:null);
                    }	
                    	

                    }
                    break;

            }


            char_literal179=(Token)match(input,32,FOLLOW_32_in_returnStatement3896); 
            char_literal179_tree = 
            (Object)adaptor.create(char_literal179)
            ;
            adaptor.addChild(root_0, char_literal179_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2174:1: saveStatement[boolean defer] : 'save' '(' listOfSaveObjects[defer] ')' ;
    public final EugeneParser.saveStatement_return saveStatement(boolean defer) throws RecognitionException {
        EugeneParser.saveStatement_return retval = new EugeneParser.saveStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal180=null;
        Token char_literal181=null;
        Token char_literal183=null;
        EugeneParser.listOfSaveObjects_return listOfSaveObjects182 =null;


        Object string_literal180_tree=null;
        Object char_literal181_tree=null;
        Object char_literal183_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2175:2: ( 'save' '(' listOfSaveObjects[defer] ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2175:4: 'save' '(' listOfSaveObjects[defer] ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal180=(Token)match(input,106,FOLLOW_106_in_saveStatement3913); 
            string_literal180_tree = 
            (Object)adaptor.create(string_literal180)
            ;
            adaptor.addChild(root_0, string_literal180_tree);


            char_literal181=(Token)match(input,20,FOLLOW_20_in_saveStatement3915); 
            char_literal181_tree = 
            (Object)adaptor.create(char_literal181)
            ;
            adaptor.addChild(root_0, char_literal181_tree);


            pushFollow(FOLLOW_listOfSaveObjects_in_saveStatement3917);
            listOfSaveObjects182=listOfSaveObjects(defer);

            state._fsp--;

            adaptor.addChild(root_0, listOfSaveObjects182.getTree());

            char_literal183=(Token)match(input,21,FOLLOW_21_in_saveStatement3920); 
            char_literal183_tree = 
            (Object)adaptor.create(char_literal183)
            ;
            adaptor.addChild(root_0, char_literal183_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2178:1: listOfSaveObjects[boolean defer] : (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )? ;
    public final EugeneParser.listOfSaveObjects_return listOfSaveObjects(boolean defer) throws RecognitionException {
        EugeneParser.listOfSaveObjects_return retval = new EugeneParser.listOfSaveObjects_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token char_literal184=null;
        Token char_literal185=null;
        EugeneParser.expression_return idToken =null;

        EugeneParser.listOfSaveObjects_return listOfSaveObjects186 =null;


        Object nameToken_tree=null;
        Object char_literal184_tree=null;
        Object char_literal185_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2179:2: ( (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2179:4: (nameToken= ID ':' )? idToken= expression[defer] ( ',' listOfSaveObjects[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2179:4: (nameToken= ID ':' )?
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2179:5: nameToken= ID ':'
                    {
                    nameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfSaveObjects3936); 
                    nameToken_tree = 
                    (Object)adaptor.create(nameToken)
                    ;
                    adaptor.addChild(root_0, nameToken_tree);


                    char_literal184=(Token)match(input,31,FOLLOW_31_in_listOfSaveObjects3938); 
                    char_literal184_tree = 
                    (Object)adaptor.create(char_literal184)
                    ;
                    adaptor.addChild(root_0, char_literal184_tree);


                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_listOfSaveObjects3944);
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2187:4: ( ',' listOfSaveObjects[defer] )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==24) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2187:5: ',' listOfSaveObjects[defer]
                    {
                    char_literal185=(Token)match(input,24,FOLLOW_24_in_listOfSaveObjects3950); 
                    char_literal185_tree = 
                    (Object)adaptor.create(char_literal185)
                    ;
                    adaptor.addChild(root_0, char_literal185_tree);


                    pushFollow(FOLLOW_listOfSaveObjects_in_listOfSaveObjects3952);
                    listOfSaveObjects186=listOfSaveObjects(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, listOfSaveObjects186.getTree());

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2200:1: ifStatement[boolean defer] : 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )? ;
    public final EugeneParser.ifStatement_return ifStatement(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.ifStatement_return retval = new EugeneParser.ifStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal187=null;
        Token char_literal188=null;
        Token char_literal189=null;
        Token char_literal190=null;
        Token char_literal191=null;
        Token string_literal192=null;
        Token string_literal193=null;
        Token char_literal194=null;
        Token char_literal195=null;
        Token char_literal196=null;
        Token char_literal197=null;
        Token string_literal198=null;
        Token char_literal199=null;
        Token char_literal200=null;
        EugeneParser.ifCondition_return ifConditionToken =null;

        EugeneParser.listOfStatements_return thenStmtToken =null;

        EugeneParser.ifCondition_return elseIfToken =null;

        EugeneParser.listOfStatements_return elseIfStmtToken =null;

        EugeneParser.listOfStatements_return elseStmtToken =null;


        Object string_literal187_tree=null;
        Object char_literal188_tree=null;
        Object char_literal189_tree=null;
        Object char_literal190_tree=null;
        Object char_literal191_tree=null;
        Object string_literal192_tree=null;
        Object string_literal193_tree=null;
        Object char_literal194_tree=null;
        Object char_literal195_tree=null;
        Object char_literal196_tree=null;
        Object char_literal197_tree=null;
        Object string_literal198_tree=null;
        Object char_literal199_tree=null;
        Object char_literal200_tree=null;


        ConditionalBranch objIfBranch = null;
        ArrayList<ConditionalBranch> lstElseIfStatements = null;
        ConditionalBranch objElseBranch = null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2207:2: ( 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2207:4: 'if' '(' ifConditionToken= ifCondition[true] ')' '{' thenStmtToken= listOfStatements[true] '}' ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )* ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )?
            {
            root_0 = (Object)adaptor.nil();


            string_literal187=(Token)match(input,92,FOLLOW_92_in_ifStatement3992); 
            string_literal187_tree = 
            (Object)adaptor.create(string_literal187)
            ;
            adaptor.addChild(root_0, string_literal187_tree);


            char_literal188=(Token)match(input,20,FOLLOW_20_in_ifStatement3994); 
            char_literal188_tree = 
            (Object)adaptor.create(char_literal188)
            ;
            adaptor.addChild(root_0, char_literal188_tree);


            pushFollow(FOLLOW_ifCondition_in_ifStatement3998);
            ifConditionToken=ifCondition(true);

            state._fsp--;

            adaptor.addChild(root_0, ifConditionToken.getTree());

            char_literal189=(Token)match(input,21,FOLLOW_21_in_ifStatement4001); 
            char_literal189_tree = 
            (Object)adaptor.create(char_literal189)
            ;
            adaptor.addChild(root_0, char_literal189_tree);


            char_literal190=(Token)match(input,113,FOLLOW_113_in_ifStatement4003); 
            char_literal190_tree = 
            (Object)adaptor.create(char_literal190)
            ;
            adaptor.addChild(root_0, char_literal190_tree);


            pushFollow(FOLLOW_listOfStatements_in_ifStatement4007);
            thenStmtToken=listOfStatements(true);

            state._fsp--;

            adaptor.addChild(root_0, thenStmtToken.getTree());

            char_literal191=(Token)match(input,115,FOLLOW_115_in_ifStatement4010); 
            char_literal191_tree = 
            (Object)adaptor.create(char_literal191)
            ;
            adaptor.addChild(root_0, char_literal191_tree);



            if(!defer) {
               objIfBranch = new ConditionalBranch((ifConditionToken!=null?((Token)ifConditionToken.start):null), (thenStmtToken!=null?((Token)thenStmtToken.start):null)); 
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2212:17: ( 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}' )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==85) ) {
                    int LA76_1 = input.LA(2);

                    if ( (LA76_1==92) ) {
                        alt76=1;
                    }


                }


                switch (alt76) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2212:18: 'else' 'if' '(' elseIfToken= ifCondition[true] ')' '{' elseIfStmtToken= listOfStatements[true] '}'
            	    {
            	    string_literal192=(Token)match(input,85,FOLLOW_85_in_ifStatement4031); 
            	    string_literal192_tree = 
            	    (Object)adaptor.create(string_literal192)
            	    ;
            	    adaptor.addChild(root_0, string_literal192_tree);


            	    string_literal193=(Token)match(input,92,FOLLOW_92_in_ifStatement4033); 
            	    string_literal193_tree = 
            	    (Object)adaptor.create(string_literal193)
            	    ;
            	    adaptor.addChild(root_0, string_literal193_tree);


            	    char_literal194=(Token)match(input,20,FOLLOW_20_in_ifStatement4035); 
            	    char_literal194_tree = 
            	    (Object)adaptor.create(char_literal194)
            	    ;
            	    adaptor.addChild(root_0, char_literal194_tree);


            	    pushFollow(FOLLOW_ifCondition_in_ifStatement4039);
            	    elseIfToken=ifCondition(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, elseIfToken.getTree());

            	    char_literal195=(Token)match(input,21,FOLLOW_21_in_ifStatement4042); 
            	    char_literal195_tree = 
            	    (Object)adaptor.create(char_literal195)
            	    ;
            	    adaptor.addChild(root_0, char_literal195_tree);


            	    char_literal196=(Token)match(input,113,FOLLOW_113_in_ifStatement4044); 
            	    char_literal196_tree = 
            	    (Object)adaptor.create(char_literal196)
            	    ;
            	    adaptor.addChild(root_0, char_literal196_tree);


            	    pushFollow(FOLLOW_listOfStatements_in_ifStatement4048);
            	    elseIfStmtToken=listOfStatements(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, elseIfStmtToken.getTree());

            	    char_literal197=(Token)match(input,115,FOLLOW_115_in_ifStatement4051); 
            	    char_literal197_tree = 
            	    (Object)adaptor.create(char_literal197)
            	    ;
            	    adaptor.addChild(root_0, char_literal197_tree);



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


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2221:3: ( 'else' '{' elseStmtToken= listOfStatements[true] '}' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==85) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2221:4: 'else' '{' elseStmtToken= listOfStatements[true] '}'
                    {
                    string_literal198=(Token)match(input,85,FOLLOW_85_in_ifStatement4060); 
                    string_literal198_tree = 
                    (Object)adaptor.create(string_literal198)
                    ;
                    adaptor.addChild(root_0, string_literal198_tree);


                    char_literal199=(Token)match(input,113,FOLLOW_113_in_ifStatement4062); 
                    char_literal199_tree = 
                    (Object)adaptor.create(char_literal199)
                    ;
                    adaptor.addChild(root_0, char_literal199_tree);


                    pushFollow(FOLLOW_listOfStatements_in_ifStatement4066);
                    elseStmtToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, elseStmtToken.getTree());

                    char_literal200=(Token)match(input,115,FOLLOW_115_in_ifStatement4069); 
                    char_literal200_tree = 
                    (Object)adaptor.create(char_literal200)
                    ;
                    adaptor.addChild(root_0, char_literal200_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2244:1: ifCondition[boolean defer] returns [boolean b] : (deviceToken= onDevice[defer] )? exprToken= expression[defer] ;
    public final EugeneParser.ifCondition_return ifCondition(boolean defer) throws RecognitionException {
        EugeneParser.ifCondition_return retval = new EugeneParser.ifCondition_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.onDevice_return deviceToken =null;

        EugeneParser.expression_return exprToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2246:2: ( (deviceToken= onDevice[defer] )? exprToken= expression[defer] )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2246:4: (deviceToken= onDevice[defer] )? exprToken= expression[defer]
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2246:4: (deviceToken= onDevice[defer] )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==66) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2246:5: deviceToken= onDevice[defer]
                    {
                    pushFollow(FOLLOW_onDevice_in_ifCondition4108);
                    deviceToken=onDevice(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, deviceToken.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_expression_in_ifCondition4115);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2287:1: loopStatement[boolean defer] : ( 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}' | 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}' | 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';' );
    public final EugeneParser.loopStatement_return loopStatement(boolean defer) throws RecognitionException, EugeneReturnException {
        EugeneParser.loopStatement_return retval = new EugeneParser.loopStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal201=null;
        Token char_literal202=null;
        Token char_literal203=null;
        Token char_literal204=null;
        Token char_literal205=null;
        Token char_literal206=null;
        Token char_literal207=null;
        Token string_literal208=null;
        Token char_literal209=null;
        Token char_literal210=null;
        Token char_literal211=null;
        Token char_literal212=null;
        Token string_literal213=null;
        Token char_literal214=null;
        Token char_literal215=null;
        Token string_literal216=null;
        Token char_literal217=null;
        Token char_literal218=null;
        Token char_literal219=null;
        EugeneParser.forInit_return initToken =null;

        EugeneParser.expression_return condToken =null;

        EugeneParser.computationalStatement_return incToken =null;

        EugeneParser.listOfStatements_return forToken =null;

        EugeneParser.listOfStatements_return whileToken =null;


        Object string_literal201_tree=null;
        Object char_literal202_tree=null;
        Object char_literal203_tree=null;
        Object char_literal204_tree=null;
        Object char_literal205_tree=null;
        Object char_literal206_tree=null;
        Object char_literal207_tree=null;
        Object string_literal208_tree=null;
        Object char_literal209_tree=null;
        Object char_literal210_tree=null;
        Object char_literal211_tree=null;
        Object char_literal212_tree=null;
        Object string_literal213_tree=null;
        Object char_literal214_tree=null;
        Object char_literal215_tree=null;
        Object string_literal216_tree=null;
        Object char_literal217_tree=null;
        Object char_literal218_tree=null;
        Object char_literal219_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2289:6: ( 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}' | 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}' | 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';' )
            int alt79=3;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt79=1;
                }
                break;
            case 112:
                {
                alt79=2;
                }
                break;
            case 84:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2289:8: 'for' '(' initToken= forInit[true] ';' condToken= expression[true] ';' incToken= computationalStatement[true] ')' '{' forToken= listOfStatements[true] '}'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal201=(Token)match(input,89,FOLLOW_89_in_loopStatement4155); 
                    string_literal201_tree = 
                    (Object)adaptor.create(string_literal201)
                    ;
                    adaptor.addChild(root_0, string_literal201_tree);


                    char_literal202=(Token)match(input,20,FOLLOW_20_in_loopStatement4157); 
                    char_literal202_tree = 
                    (Object)adaptor.create(char_literal202)
                    ;
                    adaptor.addChild(root_0, char_literal202_tree);


                    pushFollow(FOLLOW_forInit_in_loopStatement4161);
                    initToken=forInit(true);

                    state._fsp--;

                    adaptor.addChild(root_0, initToken.getTree());

                    char_literal203=(Token)match(input,32,FOLLOW_32_in_loopStatement4164); 
                    char_literal203_tree = 
                    (Object)adaptor.create(char_literal203)
                    ;
                    adaptor.addChild(root_0, char_literal203_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement4175);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal204=(Token)match(input,32,FOLLOW_32_in_loopStatement4178); 
                    char_literal204_tree = 
                    (Object)adaptor.create(char_literal204)
                    ;
                    adaptor.addChild(root_0, char_literal204_tree);


                    pushFollow(FOLLOW_computationalStatement_in_loopStatement4189);
                    incToken=computationalStatement(true);

                    state._fsp--;

                    adaptor.addChild(root_0, incToken.getTree());

                    char_literal205=(Token)match(input,21,FOLLOW_21_in_loopStatement4192); 
                    char_literal205_tree = 
                    (Object)adaptor.create(char_literal205)
                    ;
                    adaptor.addChild(root_0, char_literal205_tree);


                    char_literal206=(Token)match(input,113,FOLLOW_113_in_loopStatement4194); 
                    char_literal206_tree = 
                    (Object)adaptor.create(char_literal206)
                    ;
                    adaptor.addChild(root_0, char_literal206_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement4206);
                    forToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, forToken.getTree());

                    char_literal207=(Token)match(input,115,FOLLOW_115_in_loopStatement4209); 
                    char_literal207_tree = 
                    (Object)adaptor.create(char_literal207)
                    ;
                    adaptor.addChild(root_0, char_literal207_tree);



                    if(!defer) {
                        forStat((initToken!=null?((Token)initToken.start):null), 
                            (condToken!=null?((Token)condToken.start):null), 
                            (incToken!=null?((Token)incToken.start):null), 
                            (forToken!=null?((Token)forToken.start):null));
                    }
                            

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2300:4: 'while' '(' condToken= expression[true] ')' '{' whileToken= listOfStatements[true] '}'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal208=(Token)match(input,112,FOLLOW_112_in_loopStatement4216); 
                    string_literal208_tree = 
                    (Object)adaptor.create(string_literal208)
                    ;
                    adaptor.addChild(root_0, string_literal208_tree);


                    char_literal209=(Token)match(input,20,FOLLOW_20_in_loopStatement4218); 
                    char_literal209_tree = 
                    (Object)adaptor.create(char_literal209)
                    ;
                    adaptor.addChild(root_0, char_literal209_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement4222);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal210=(Token)match(input,21,FOLLOW_21_in_loopStatement4225); 
                    char_literal210_tree = 
                    (Object)adaptor.create(char_literal210)
                    ;
                    adaptor.addChild(root_0, char_literal210_tree);


                    char_literal211=(Token)match(input,113,FOLLOW_113_in_loopStatement4227); 
                    char_literal211_tree = 
                    (Object)adaptor.create(char_literal211)
                    ;
                    adaptor.addChild(root_0, char_literal211_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement4231);
                    whileToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, whileToken.getTree());

                    char_literal212=(Token)match(input,115,FOLLOW_115_in_loopStatement4234); 
                    char_literal212_tree = 
                    (Object)adaptor.create(char_literal212)
                    ;
                    adaptor.addChild(root_0, char_literal212_tree);



                    if(!defer){
                        whileStat((condToken!=null?((Token)condToken.start):null), 
                            (whileToken!=null?((Token)whileToken.start):null));
                    }
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2306:4: 'do' '{' whileToken= listOfStatements[true] '}' 'while' '(' condToken= expression[true] ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal213=(Token)match(input,84,FOLLOW_84_in_loopStatement4241); 
                    string_literal213_tree = 
                    (Object)adaptor.create(string_literal213)
                    ;
                    adaptor.addChild(root_0, string_literal213_tree);


                    char_literal214=(Token)match(input,113,FOLLOW_113_in_loopStatement4243); 
                    char_literal214_tree = 
                    (Object)adaptor.create(char_literal214)
                    ;
                    adaptor.addChild(root_0, char_literal214_tree);


                    pushFollow(FOLLOW_listOfStatements_in_loopStatement4247);
                    whileToken=listOfStatements(true);

                    state._fsp--;

                    adaptor.addChild(root_0, whileToken.getTree());

                    char_literal215=(Token)match(input,115,FOLLOW_115_in_loopStatement4250); 
                    char_literal215_tree = 
                    (Object)adaptor.create(char_literal215)
                    ;
                    adaptor.addChild(root_0, char_literal215_tree);


                    string_literal216=(Token)match(input,112,FOLLOW_112_in_loopStatement4252); 
                    string_literal216_tree = 
                    (Object)adaptor.create(string_literal216)
                    ;
                    adaptor.addChild(root_0, string_literal216_tree);


                    char_literal217=(Token)match(input,20,FOLLOW_20_in_loopStatement4254); 
                    char_literal217_tree = 
                    (Object)adaptor.create(char_literal217)
                    ;
                    adaptor.addChild(root_0, char_literal217_tree);


                    pushFollow(FOLLOW_expression_in_loopStatement4258);
                    condToken=expression(true);

                    state._fsp--;

                    adaptor.addChild(root_0, condToken.getTree());

                    char_literal218=(Token)match(input,21,FOLLOW_21_in_loopStatement4261); 
                    char_literal218_tree = 
                    (Object)adaptor.create(char_literal218)
                    ;
                    adaptor.addChild(root_0, char_literal218_tree);


                    char_literal219=(Token)match(input,32,FOLLOW_32_in_loopStatement4262); 
                    char_literal219_tree = 
                    (Object)adaptor.create(char_literal219)
                    ;
                    adaptor.addChild(root_0, char_literal219_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2320:1: forInit[boolean defer] returns [ArrayList<NamedElement> lstElements] : (declToken= variableDeclaration[defer] |exprToken= listOfExpressions[defer] );
    public final EugeneParser.forInit_return forInit(boolean defer) throws RecognitionException {
        EugeneParser.forInit_return retval = new EugeneParser.forInit_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.variableDeclaration_return declToken =null;

        EugeneParser.listOfExpressions_return exprToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2321:2: (declToken= variableDeclaration[defer] |exprToken= listOfExpressions[defer] )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==82||LA80_0==98||LA80_0==111) ) {
                alt80=1;
            }
            else if ( (LA80_0==FLOAT||LA80_0==ID||LA80_0==INT||LA80_0==STRING||LA80_0==18||LA80_0==20||LA80_0==25||(LA80_0 >= 33 && LA80_0 <= 34)||(LA80_0 >= 36 && LA80_0 <= 39)||(LA80_0 >= 42 && LA80_0 <= 44)||LA80_0==46||(LA80_0 >= 49 && LA80_0 <= 52)||LA80_0==54||(LA80_0 >= 57 && LA80_0 <= 64)||LA80_0==68||LA80_0==72||(LA80_0 >= 75 && LA80_0 <= 77)||LA80_0==79||LA80_0==87||LA80_0==110) ) {
                alt80=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;

            }
            switch (alt80) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2321:4: declToken= variableDeclaration[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_variableDeclaration_in_forInit4290);
                    declToken=variableDeclaration(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, declToken.getTree());


                    if(!defer) {
                        retval.lstElements = new ArrayList<NamedElement>((declToken!=null?declToken.lstVariables:null));
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2326:4: exprToken= listOfExpressions[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_listOfExpressions_in_forInit4300);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2336:1: functionDeclaration returns [Function objFunction] : 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}' ;
    public final EugeneParser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        EugeneParser.functionDeclaration_return retval = new EugeneParser.functionDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token nameToken=null;
        Token string_literal220=null;
        Token char_literal221=null;
        Token char_literal222=null;
        Token char_literal223=null;
        Token char_literal224=null;
        EugeneParser.type_return returnTypeToken =null;

        EugeneParser.listOfFunctionParamenters_return lstParametersToken =null;

        EugeneParser.listOfStatements_return lstStatementsToken =null;


        Object nameToken_tree=null;
        Object string_literal220_tree=null;
        Object char_literal221_tree=null;
        Object char_literal222_tree=null;
        Object char_literal223_tree=null;
        Object char_literal224_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2337:2: ( 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2337:4: 'function' (returnTypeToken= type )? nameToken= ID '(' (lstParametersToken= listOfFunctionParamenters )? ')' '{' lstStatementsToken= listOfStatements[true] '}'
            {
            root_0 = (Object)adaptor.nil();


            string_literal220=(Token)match(input,90,FOLLOW_90_in_functionDeclaration4325); 
            string_literal220_tree = 
            (Object)adaptor.create(string_literal220)
            ;
            adaptor.addChild(root_0, string_literal220_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2337:15: (returnTypeToken= type )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==45||LA81_0==47||LA81_0==69||LA81_0==71||LA81_0==82||LA81_0==98||LA81_0==111) ) {
                alt81=1;
            }
            else if ( (LA81_0==ID) ) {
                int LA81_2 = input.LA(2);

                if ( (LA81_2==ID||LA81_2==79) ) {
                    alt81=1;
                }
            }
            switch (alt81) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2337:16: returnTypeToken= type
                    {
                    pushFollow(FOLLOW_type_in_functionDeclaration4330);
                    returnTypeToken=type();

                    state._fsp--;

                    adaptor.addChild(root_0, returnTypeToken.getTree());

                    }
                    break;

            }


            nameToken=(Token)match(input,ID,FOLLOW_ID_in_functionDeclaration4336); 
            nameToken_tree = 
            (Object)adaptor.create(nameToken)
            ;
            adaptor.addChild(root_0, nameToken_tree);



            if(null != interp.get((nameToken!=null?nameToken.getText():null))) {
                System.err.println("line "+(nameToken!=null?nameToken.getLine():0)+":"+(nameToken!=null?nameToken.getText():null)+" => "+
                    "The "+(nameToken!=null?nameToken.getText():null)+" function has been declared already!");
                this.cleanUp(1);
            }
            	

            char_literal221=(Token)match(input,20,FOLLOW_20_in_functionDeclaration4340); 
            char_literal221_tree = 
            (Object)adaptor.create(char_literal221)
            ;
            adaptor.addChild(root_0, char_literal221_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2343:8: (lstParametersToken= listOfFunctionParamenters )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==ID||LA82_0==45||LA82_0==47||LA82_0==69||LA82_0==71||LA82_0==82||LA82_0==98||LA82_0==111) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2343:9: lstParametersToken= listOfFunctionParamenters
                    {
                    pushFollow(FOLLOW_listOfFunctionParamenters_in_functionDeclaration4345);
                    lstParametersToken=listOfFunctionParamenters();

                    state._fsp--;

                    adaptor.addChild(root_0, lstParametersToken.getTree());

                    }
                    break;

            }


            char_literal222=(Token)match(input,21,FOLLOW_21_in_functionDeclaration4349); 
            char_literal222_tree = 
            (Object)adaptor.create(char_literal222)
            ;
            adaptor.addChild(root_0, char_literal222_tree);


            char_literal223=(Token)match(input,113,FOLLOW_113_in_functionDeclaration4351); 
            char_literal223_tree = 
            (Object)adaptor.create(char_literal223)
            ;
            adaptor.addChild(root_0, char_literal223_tree);


            pushFollow(FOLLOW_listOfStatements_in_functionDeclaration4359);
            lstStatementsToken=listOfStatements(true);

            state._fsp--;

            adaptor.addChild(root_0, lstStatementsToken.getTree());

            char_literal224=(Token)match(input,115,FOLLOW_115_in_functionDeclaration4364); 
            char_literal224_tree = 
            (Object)adaptor.create(char_literal224)
            ;
            adaptor.addChild(root_0, char_literal224_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2362:1: type returns [String sType] : ( 'Collection' | 'Device' '[' ']' | 'Device' | 'Part' '[' ']' | 'Part' |idToken= ID '[' ']' |idToken= ID | 'Property' '[' ']' | 'Property' | 'num' '[' ']' | 'num' | 'txt' '[' ']' | 'txt' | 'boolean' );
    public final EugeneParser.type_return type() throws RecognitionException {
        EugeneParser.type_return retval = new EugeneParser.type_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token string_literal225=null;
        Token string_literal226=null;
        Token char_literal227=null;
        Token char_literal228=null;
        Token string_literal229=null;
        Token string_literal230=null;
        Token char_literal231=null;
        Token char_literal232=null;
        Token string_literal233=null;
        Token char_literal234=null;
        Token char_literal235=null;
        Token string_literal236=null;
        Token char_literal237=null;
        Token char_literal238=null;
        Token string_literal239=null;
        Token string_literal240=null;
        Token char_literal241=null;
        Token char_literal242=null;
        Token string_literal243=null;
        Token string_literal244=null;
        Token char_literal245=null;
        Token char_literal246=null;
        Token string_literal247=null;
        Token string_literal248=null;

        Object idToken_tree=null;
        Object string_literal225_tree=null;
        Object string_literal226_tree=null;
        Object char_literal227_tree=null;
        Object char_literal228_tree=null;
        Object string_literal229_tree=null;
        Object string_literal230_tree=null;
        Object char_literal231_tree=null;
        Object char_literal232_tree=null;
        Object string_literal233_tree=null;
        Object char_literal234_tree=null;
        Object char_literal235_tree=null;
        Object string_literal236_tree=null;
        Object char_literal237_tree=null;
        Object char_literal238_tree=null;
        Object string_literal239_tree=null;
        Object string_literal240_tree=null;
        Object char_literal241_tree=null;
        Object char_literal242_tree=null;
        Object string_literal243_tree=null;
        Object string_literal244_tree=null;
        Object char_literal245_tree=null;
        Object char_literal246_tree=null;
        Object string_literal247_tree=null;
        Object string_literal248_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2363:2: ( 'Collection' | 'Device' '[' ']' | 'Device' | 'Part' '[' ']' | 'Part' |idToken= ID '[' ']' |idToken= ID | 'Property' '[' ']' | 'Property' | 'num' '[' ']' | 'num' | 'txt' '[' ']' | 'txt' | 'boolean' )
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

                if ( (LA83_2==79) ) {
                    alt83=2;
                }
                else if ( (LA83_2==DYNAMIC_NAME||LA83_2==ID||LA83_2==19||LA83_2==21||LA83_2==24||(LA83_2 >= 31 && LA83_2 <= 32)||LA83_2==40||LA83_2==67||LA83_2==78||(LA83_2 >= 80 && LA83_2 <= 81)||LA83_2==114) ) {
                    alt83=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 2, input);

                    throw nvae;

                }
                }
                break;
            case 69:
                {
                int LA83_3 = input.LA(2);

                if ( (LA83_3==79) ) {
                    alt83=4;
                }
                else if ( (LA83_3==DYNAMIC_NAME||LA83_3==ID||LA83_3==19||LA83_3==21||LA83_3==24||(LA83_3 >= 31 && LA83_3 <= 32)||LA83_3==40||LA83_3==67||LA83_3==78||(LA83_3 >= 80 && LA83_3 <= 81)||LA83_3==114) ) {
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

                if ( (LA83_4==79) ) {
                    alt83=6;
                }
                else if ( (LA83_4==DYNAMIC_NAME||LA83_4==ID||LA83_4==19||LA83_4==21||LA83_4==24||(LA83_4 >= 31 && LA83_4 <= 32)||LA83_4==40||LA83_4==67||LA83_4==78||(LA83_4 >= 80 && LA83_4 <= 81)||LA83_4==114) ) {
                    alt83=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 4, input);

                    throw nvae;

                }
                }
                break;
            case 71:
                {
                int LA83_5 = input.LA(2);

                if ( (LA83_5==79) ) {
                    alt83=8;
                }
                else if ( (LA83_5==DYNAMIC_NAME||LA83_5==ID||LA83_5==19||LA83_5==21||LA83_5==24||(LA83_5 >= 31 && LA83_5 <= 32)||LA83_5==40||LA83_5==67||LA83_5==78||(LA83_5 >= 80 && LA83_5 <= 81)||LA83_5==114) ) {
                    alt83=9;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 5, input);

                    throw nvae;

                }
                }
                break;
            case 98:
                {
                int LA83_6 = input.LA(2);

                if ( (LA83_6==79) ) {
                    alt83=10;
                }
                else if ( (LA83_6==DYNAMIC_NAME||LA83_6==ID||LA83_6==19||LA83_6==21||LA83_6==24||(LA83_6 >= 31 && LA83_6 <= 32)||LA83_6==40||LA83_6==67||LA83_6==78||(LA83_6 >= 80 && LA83_6 <= 81)||LA83_6==114) ) {
                    alt83=11;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 6, input);

                    throw nvae;

                }
                }
                break;
            case 111:
                {
                int LA83_7 = input.LA(2);

                if ( (LA83_7==79) ) {
                    alt83=12;
                }
                else if ( (LA83_7==DYNAMIC_NAME||LA83_7==ID||LA83_7==19||LA83_7==21||LA83_7==24||(LA83_7 >= 31 && LA83_7 <= 32)||LA83_7==40||LA83_7==67||LA83_7==78||(LA83_7 >= 80 && LA83_7 <= 81)||LA83_7==114) ) {
                    alt83=13;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 7, input);

                    throw nvae;

                }
                }
                break;
            case 82:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2363:4: 'Collection'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal225=(Token)match(input,45,FOLLOW_45_in_type4387); 
                    string_literal225_tree = 
                    (Object)adaptor.create(string_literal225)
                    ;
                    adaptor.addChild(root_0, string_literal225_tree);



                    retval.sType =EugeneConstants.COLLECTION;	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2366:4: 'Device' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal226=(Token)match(input,47,FOLLOW_47_in_type4394); 
                    string_literal226_tree = 
                    (Object)adaptor.create(string_literal226)
                    ;
                    adaptor.addChild(root_0, string_literal226_tree);


                    char_literal227=(Token)match(input,79,FOLLOW_79_in_type4396); 
                    char_literal227_tree = 
                    (Object)adaptor.create(char_literal227)
                    ;
                    adaptor.addChild(root_0, char_literal227_tree);


                    char_literal228=(Token)match(input,80,FOLLOW_80_in_type4398); 
                    char_literal228_tree = 
                    (Object)adaptor.create(char_literal228)
                    ;
                    adaptor.addChild(root_0, char_literal228_tree);



                    retval.sType =EugeneConstants.DEVICEARRAY;	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2369:4: 'Device'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal229=(Token)match(input,47,FOLLOW_47_in_type4405); 
                    string_literal229_tree = 
                    (Object)adaptor.create(string_literal229)
                    ;
                    adaptor.addChild(root_0, string_literal229_tree);



                    retval.sType =EugeneConstants.DEVICE;	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2372:4: 'Part' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal230=(Token)match(input,69,FOLLOW_69_in_type4412); 
                    string_literal230_tree = 
                    (Object)adaptor.create(string_literal230)
                    ;
                    adaptor.addChild(root_0, string_literal230_tree);


                    char_literal231=(Token)match(input,79,FOLLOW_79_in_type4414); 
                    char_literal231_tree = 
                    (Object)adaptor.create(char_literal231)
                    ;
                    adaptor.addChild(root_0, char_literal231_tree);


                    char_literal232=(Token)match(input,80,FOLLOW_80_in_type4416); 
                    char_literal232_tree = 
                    (Object)adaptor.create(char_literal232)
                    ;
                    adaptor.addChild(root_0, char_literal232_tree);



                    retval.sType =EugeneConstants.PARTTYPEARRAY;	
                    	

                    }
                    break;
                case 5 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2375:4: 'Part'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal233=(Token)match(input,69,FOLLOW_69_in_type4423); 
                    string_literal233_tree = 
                    (Object)adaptor.create(string_literal233)
                    ;
                    adaptor.addChild(root_0, string_literal233_tree);



                    retval.sType =EugeneConstants.PARTTYPE;	
                    	

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2378:4: idToken= ID '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_type4432); 
                    idToken_tree = 
                    (Object)adaptor.create(idToken)
                    ;
                    adaptor.addChild(root_0, idToken_tree);


                    char_literal234=(Token)match(input,79,FOLLOW_79_in_type4434); 
                    char_literal234_tree = 
                    (Object)adaptor.create(char_literal234)
                    ;
                    adaptor.addChild(root_0, char_literal234_tree);


                    char_literal235=(Token)match(input,80,FOLLOW_80_in_type4436); 
                    char_literal235_tree = 
                    (Object)adaptor.create(char_literal235)
                    ;
                    adaptor.addChild(root_0, char_literal235_tree);



                    retval.sType =EugeneConstants.PARTARRAY;	
                    	

                    }
                    break;
                case 7 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2381:4: idToken= ID
                    {
                    root_0 = (Object)adaptor.nil();


                    idToken=(Token)match(input,ID,FOLLOW_ID_in_type4445); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2391:4: 'Property' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal236=(Token)match(input,71,FOLLOW_71_in_type4452); 
                    string_literal236_tree = 
                    (Object)adaptor.create(string_literal236)
                    ;
                    adaptor.addChild(root_0, string_literal236_tree);


                    char_literal237=(Token)match(input,79,FOLLOW_79_in_type4454); 
                    char_literal237_tree = 
                    (Object)adaptor.create(char_literal237)
                    ;
                    adaptor.addChild(root_0, char_literal237_tree);


                    char_literal238=(Token)match(input,80,FOLLOW_80_in_type4456); 
                    char_literal238_tree = 
                    (Object)adaptor.create(char_literal238)
                    ;
                    adaptor.addChild(root_0, char_literal238_tree);



                    retval.sType =EugeneConstants.PROPERTYARRAY;	
                    	

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2394:4: 'Property'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal239=(Token)match(input,71,FOLLOW_71_in_type4463); 
                    string_literal239_tree = 
                    (Object)adaptor.create(string_literal239)
                    ;
                    adaptor.addChild(root_0, string_literal239_tree);



                    retval.sType =EugeneConstants.PROPERTY;	
                    	

                    }
                    break;
                case 10 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2397:4: 'num' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal240=(Token)match(input,98,FOLLOW_98_in_type4470); 
                    string_literal240_tree = 
                    (Object)adaptor.create(string_literal240)
                    ;
                    adaptor.addChild(root_0, string_literal240_tree);


                    char_literal241=(Token)match(input,79,FOLLOW_79_in_type4472); 
                    char_literal241_tree = 
                    (Object)adaptor.create(char_literal241)
                    ;
                    adaptor.addChild(root_0, char_literal241_tree);


                    char_literal242=(Token)match(input,80,FOLLOW_80_in_type4474); 
                    char_literal242_tree = 
                    (Object)adaptor.create(char_literal242)
                    ;
                    adaptor.addChild(root_0, char_literal242_tree);



                    retval.sType =EugeneConstants.NUMLIST;	
                    	

                    }
                    break;
                case 11 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2400:4: 'num'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal243=(Token)match(input,98,FOLLOW_98_in_type4481); 
                    string_literal243_tree = 
                    (Object)adaptor.create(string_literal243)
                    ;
                    adaptor.addChild(root_0, string_literal243_tree);



                    retval.sType =EugeneConstants.NUM;	
                    	

                    }
                    break;
                case 12 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2403:4: 'txt' '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal244=(Token)match(input,111,FOLLOW_111_in_type4488); 
                    string_literal244_tree = 
                    (Object)adaptor.create(string_literal244)
                    ;
                    adaptor.addChild(root_0, string_literal244_tree);


                    char_literal245=(Token)match(input,79,FOLLOW_79_in_type4490); 
                    char_literal245_tree = 
                    (Object)adaptor.create(char_literal245)
                    ;
                    adaptor.addChild(root_0, char_literal245_tree);


                    char_literal246=(Token)match(input,80,FOLLOW_80_in_type4492); 
                    char_literal246_tree = 
                    (Object)adaptor.create(char_literal246)
                    ;
                    adaptor.addChild(root_0, char_literal246_tree);



                    retval.sType =EugeneConstants.TXTLIST;	
                    	

                    }
                    break;
                case 13 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2406:4: 'txt'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal247=(Token)match(input,111,FOLLOW_111_in_type4499); 
                    string_literal247_tree = 
                    (Object)adaptor.create(string_literal247)
                    ;
                    adaptor.addChild(root_0, string_literal247_tree);



                    retval.sType =EugeneConstants.TXT;	
                    	

                    }
                    break;
                case 14 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2409:4: 'boolean'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal248=(Token)match(input,82,FOLLOW_82_in_type4506); 
                    string_literal248_tree = 
                    (Object)adaptor.create(string_literal248)
                    ;
                    adaptor.addChild(root_0, string_literal248_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2414:1: listOfFunctionParamenters returns [ArrayList<NamedElement> lst] : paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )? ;
    public final EugeneParser.listOfFunctionParamenters_return listOfFunctionParamenters() throws RecognitionException {
        EugeneParser.listOfFunctionParamenters_return retval = new EugeneParser.listOfFunctionParamenters_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token paramNameToken=null;
        Token char_literal249=null;
        EugeneParser.type_return paramTypeToken =null;

        EugeneParser.listOfFunctionParamenters_return lstToken =null;


        Object paramNameToken_tree=null;
        Object char_literal249_tree=null;


        retval.lst =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2418:2: (paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2418:4: paramTypeToken= type paramNameToken= ID ( ',' lstToken= listOfFunctionParamenters )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_type_in_listOfFunctionParamenters4530);
            paramTypeToken=type();

            state._fsp--;

            adaptor.addChild(root_0, paramTypeToken.getTree());

            paramNameToken=(Token)match(input,ID,FOLLOW_ID_in_listOfFunctionParamenters4534); 
            paramNameToken_tree = 
            (Object)adaptor.create(paramNameToken)
            ;
            adaptor.addChild(root_0, paramNameToken_tree);


             
            NamedElement objParameter = this.createElement((paramTypeToken!=null?input.toString(paramTypeToken.start,paramTypeToken.stop):null),(paramNameToken!=null?paramNameToken.getText():null));
            if(objParameter!=null) {
                retval.lst.add(objParameter);
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2423:4: ( ',' lstToken= listOfFunctionParamenters )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==24) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2423:5: ',' lstToken= listOfFunctionParamenters
                    {
                    char_literal249=(Token)match(input,24,FOLLOW_24_in_listOfFunctionParamenters4539); 
                    char_literal249_tree = 
                    (Object)adaptor.create(char_literal249)
                    ;
                    adaptor.addChild(root_0, char_literal249_tree);


                    pushFollow(FOLLOW_listOfFunctionParamenters_in_listOfFunctionParamenters4543);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2430:1: functionCall[boolean defer] returns [NamedElement objElement] : functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')' ;
    public final EugeneParser.functionCall_return functionCall(boolean defer) throws RecognitionException {
        EugeneParser.functionCall_return retval = new EugeneParser.functionCall_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token functionToken=null;
        Token char_literal250=null;
        Token char_literal251=null;
        EugeneParser.listOfParameterValues_return lstParametersToken =null;


        Object functionToken_tree=null;
        Object char_literal250_tree=null;
        Object char_literal251_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2431:2: (functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2431:4: functionToken= ID '(' (lstParametersToken= listOfParameterValues[defer] )? ')'
            {
            root_0 = (Object)adaptor.nil();


            functionToken=(Token)match(input,ID,FOLLOW_ID_in_functionCall4568); 
            functionToken_tree = 
            (Object)adaptor.create(functionToken)
            ;
            adaptor.addChild(root_0, functionToken_tree);


            char_literal250=(Token)match(input,20,FOLLOW_20_in_functionCall4570); 
            char_literal250_tree = 
            (Object)adaptor.create(char_literal250)
            ;
            adaptor.addChild(root_0, char_literal250_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2431:25: (lstParametersToken= listOfParameterValues[defer] )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==FLOAT||LA85_0==ID||LA85_0==INT||LA85_0==STRING||LA85_0==18||LA85_0==20||LA85_0==25||(LA85_0 >= 33 && LA85_0 <= 34)||(LA85_0 >= 36 && LA85_0 <= 39)||(LA85_0 >= 42 && LA85_0 <= 44)||LA85_0==46||(LA85_0 >= 49 && LA85_0 <= 52)||LA85_0==54||(LA85_0 >= 57 && LA85_0 <= 64)||LA85_0==68||LA85_0==72||(LA85_0 >= 75 && LA85_0 <= 77)||LA85_0==79||LA85_0==87||LA85_0==110) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2431:26: lstParametersToken= listOfParameterValues[defer]
                    {
                    pushFollow(FOLLOW_listOfParameterValues_in_functionCall4575);
                    lstParametersToken=listOfParameterValues(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstParametersToken.getTree());

                    }
                    break;

            }


            char_literal251=(Token)match(input,21,FOLLOW_21_in_functionCall4580); 
            char_literal251_tree = 
            (Object)adaptor.create(char_literal251)
            ;
            adaptor.addChild(root_0, char_literal251_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2456:1: listOfParameterValues[boolean defer] returns [ArrayList<NamedElement> lstParameterValues] : exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )? ;
    public final EugeneParser.listOfParameterValues_return listOfParameterValues(boolean defer) throws RecognitionException {
        EugeneParser.listOfParameterValues_return retval = new EugeneParser.listOfParameterValues_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal252=null;
        EugeneParser.expression_return exprToken1 =null;

        EugeneParser.listOfParameterValues_return exprToken2 =null;


        Object char_literal252_tree=null;


        retval.lstParameterValues =new ArrayList<NamedElement>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2460:2: (exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )? )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2460:4: exprToken1= expression[defer] ( ',' exprToken2= listOfParameterValues[defer] )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_listOfParameterValues4612);
            exprToken1=expression(defer);

            state._fsp--;

            adaptor.addChild(root_0, exprToken1.getTree());


            if(!defer) {
                if(null!=exprToken1) {
                    retval.lstParameterValues.add((exprToken1!=null?exprToken1.objElement:null));
                }
            }
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2466:5: ( ',' exprToken2= listOfParameterValues[defer] )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==24) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2466:6: ',' exprToken2= listOfParameterValues[defer]
                    {
                    char_literal252=(Token)match(input,24,FOLLOW_24_in_listOfParameterValues4619); 
                    char_literal252_tree = 
                    (Object)adaptor.create(char_literal252)
                    ;
                    adaptor.addChild(root_0, char_literal252_tree);


                    pushFollow(FOLLOW_listOfParameterValues_in_listOfParameterValues4623);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2476:1: wrappedStatement[boolean defer] returns [NamedElement objElement] : ( add[defer] |permuteToken= combinatorialFunction[defer] |getToken= get[defer] |sizeToken= size[defer] |removeToken= remove[defer] |seqToken= toSequence[defer] |sbolToken= sbolStatement[defer] |genbankToken= genbankStatement[defer] |deviceToken= deviceDepthStatements[defer] );
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

        EugeneParser.add_return add253 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2477:2: ( add[defer] |permuteToken= combinatorialFunction[defer] |getToken= get[defer] |sizeToken= size[defer] |removeToken= remove[defer] |seqToken= toSequence[defer] |sbolToken= sbolStatement[defer] |genbankToken= genbankStatement[defer] |deviceToken= deviceDepthStatements[defer] )
            int alt87=9;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA87_1 = input.LA(2);

                if ( (LA87_1==26) ) {
                    switch ( input.LA(3) ) {
                    case 91:
                        {
                        alt87=3;
                        }
                        break;
                    case 107:
                        {
                        alt87=4;
                        }
                        break;
                    case 104:
                        {
                        alt87=5;
                        }
                        break;
                    case 109:
                        {
                        alt87=6;
                        }
                        break;
                    case 83:
                    case 97:
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
            case 99:
            case 103:
                {
                alt87=2;
                }
                break;
            case 74:
                {
                alt87=7;
                }
                break;
            case 53:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2477:4: add[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_add_in_wrappedStatement4648);
                    add253=add(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, add253.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2478:10: permuteToken= combinatorialFunction[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_combinatorialFunction_in_wrappedStatement4663);
                    permuteToken=combinatorialFunction(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, permuteToken.getTree());


                    if(!defer) {
                        retval.objElement = (permuteToken!=null?permuteToken.objDeviceArray:null);
                    }


                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2483:4: getToken= get[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_get_in_wrappedStatement4673);
                    getToken=get(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, getToken.getTree());


                    if(!defer) {
                        retval.objElement = (getToken!=null?getToken.objElement:null);
                    }	
                    	

                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2488:4: sizeToken= size[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_size_in_wrappedStatement4683);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2495:4: removeToken= remove[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_remove_in_wrappedStatement4693);
                    removeToken=remove(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, removeToken.getTree());

                    }
                    break;
                case 6 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2496:4: seqToken= toSequence[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_toSequence_in_wrappedStatement4702);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2503:4: sbolToken= sbolStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_sbolStatement_in_wrappedStatement4712);
                    sbolToken=sbolStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolToken.getTree());


                    if(!defer) {
                        retval.objElement = sbolToken.objElement;
                    }	
                    	

                    }
                    break;
                case 8 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2508:4: genbankToken= genbankStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_genbankStatement_in_wrappedStatement4722);
                    genbankToken=genbankStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankToken.getTree());


                    if(!defer) {
                        retval.objElement = genbankToken.objElement;
                    }	
                    	

                    }
                    break;
                case 9 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2513:10: deviceToken= deviceDepthStatements[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_deviceDepthStatements_in_wrappedStatement4738);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2524:1: deviceDepthStatements[boolean defer] returns [NamedElement objElement] : deviceToken= ID '.' ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' ) ;
    public final EugeneParser.deviceDepthStatements_return deviceDepthStatements(boolean defer) throws RecognitionException {
        EugeneParser.deviceDepthStatements_return retval = new EugeneParser.deviceDepthStatements_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token deviceToken=null;
        Token char_literal254=null;
        Token string_literal255=null;
        Token char_literal256=null;
        Token char_literal257=null;
        Token string_literal258=null;
        Token char_literal259=null;
        Token char_literal260=null;
        EugeneParser.expression_return depthToken =null;


        Object deviceToken_tree=null;
        Object char_literal254_tree=null;
        Object string_literal255_tree=null;
        Object char_literal256_tree=null;
        Object char_literal257_tree=null;
        Object string_literal258_tree=null;
        Object char_literal259_tree=null;
        Object char_literal260_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2526:2: (deviceToken= ID '.' ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2526:4: deviceToken= ID '.' ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' )
            {
            root_0 = (Object)adaptor.nil();


            deviceToken=(Token)match(input,ID,FOLLOW_ID_in_deviceDepthStatements4769); 
            deviceToken_tree = 
            (Object)adaptor.create(deviceToken)
            ;
            adaptor.addChild(root_0, deviceToken_tree);


            char_literal254=(Token)match(input,26,FOLLOW_26_in_deviceDepthStatements4771); 
            char_literal254_tree = 
            (Object)adaptor.create(char_literal254)
            ;
            adaptor.addChild(root_0, char_literal254_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2527:4: ( 'depth' '(' depthToken= expression[defer] ')' | 'maxDepth' '(' ')' )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==83) ) {
                alt88=1;
            }
            else if ( (LA88_0==97) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;

            }
            switch (alt88) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2527:5: 'depth' '(' depthToken= expression[defer] ')'
                    {
                    string_literal255=(Token)match(input,83,FOLLOW_83_in_deviceDepthStatements4778); 
                    string_literal255_tree = 
                    (Object)adaptor.create(string_literal255)
                    ;
                    adaptor.addChild(root_0, string_literal255_tree);


                    char_literal256=(Token)match(input,20,FOLLOW_20_in_deviceDepthStatements4780); 
                    char_literal256_tree = 
                    (Object)adaptor.create(char_literal256)
                    ;
                    adaptor.addChild(root_0, char_literal256_tree);


                    pushFollow(FOLLOW_expression_in_deviceDepthStatements4784);
                    depthToken=expression(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, depthToken.getTree());

                    char_literal257=(Token)match(input,21,FOLLOW_21_in_deviceDepthStatements4787); 
                    char_literal257_tree = 
                    (Object)adaptor.create(char_literal257)
                    ;
                    adaptor.addChild(root_0, char_literal257_tree);



                    if(!defer) {
                        retval.objElement = interp.getDeviceDepth((deviceToken!=null?deviceToken.getText():null), (depthToken!=null?depthToken.objElement:null));    
                    }	
                    	

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2532:5: 'maxDepth' '(' ')'
                    {
                    string_literal258=(Token)match(input,97,FOLLOW_97_in_deviceDepthStatements4795); 
                    string_literal258_tree = 
                    (Object)adaptor.create(string_literal258)
                    ;
                    adaptor.addChild(root_0, string_literal258_tree);


                    char_literal259=(Token)match(input,20,FOLLOW_20_in_deviceDepthStatements4797); 
                    char_literal259_tree = 
                    (Object)adaptor.create(char_literal259)
                    ;
                    adaptor.addChild(root_0, char_literal259_tree);


                    char_literal260=(Token)match(input,21,FOLLOW_21_in_deviceDepthStatements4799); 
                    char_literal260_tree = 
                    (Object)adaptor.create(char_literal260)
                    ;
                    adaptor.addChild(root_0, char_literal260_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2544:1: add[boolean defer] : componentToken= ID ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' ) ;
    public final EugeneParser.add_return add(boolean defer) throws RecognitionException {
        EugeneParser.add_return retval = new EugeneParser.add_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token componentToken=null;
        Token propertyToken=null;
        Token string_literal261=null;
        Token char_literal262=null;
        Token char_literal263=null;
        Token string_literal264=null;
        Token char_literal265=null;
        Token char_literal266=null;
        Token string_literal267=null;
        Token char_literal268=null;
        Token char_literal269=null;
        EugeneParser.listOfExpressions_return lstAdd =null;

        EugeneParser.listOfIDs_return lstToken =null;


        Object componentToken_tree=null;
        Object propertyToken_tree=null;
        Object string_literal261_tree=null;
        Object char_literal262_tree=null;
        Object char_literal263_tree=null;
        Object string_literal264_tree=null;
        Object char_literal265_tree=null;
        Object char_literal266_tree=null;
        Object string_literal267_tree=null;
        Object char_literal268_tree=null;
        Object char_literal269_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2545:2: (componentToken= ID ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2545:4: componentToken= ID ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' )
            {
            root_0 = (Object)adaptor.nil();


            componentToken=(Token)match(input,ID,FOLLOW_ID_in_add4823); 
            componentToken_tree = 
            (Object)adaptor.create(componentToken)
            ;
            adaptor.addChild(root_0, componentToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2545:22: ( '.add' '(' lstAdd= listOfExpressions[defer] ')' | '.addProperty' '(' propertyToken= ID ')' | '.addProperties' '(' lstToken= listOfIDs[defer] ')' )
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2546:4: '.add' '(' lstAdd= listOfExpressions[defer] ')'
                    {
                    string_literal261=(Token)match(input,27,FOLLOW_27_in_add4830); 
                    string_literal261_tree = 
                    (Object)adaptor.create(string_literal261)
                    ;
                    adaptor.addChild(root_0, string_literal261_tree);


                    char_literal262=(Token)match(input,20,FOLLOW_20_in_add4832); 
                    char_literal262_tree = 
                    (Object)adaptor.create(char_literal262)
                    ;
                    adaptor.addChild(root_0, char_literal262_tree);


                    pushFollow(FOLLOW_listOfExpressions_in_add4836);
                    lstAdd=listOfExpressions(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstAdd.getTree());

                    char_literal263=(Token)match(input,21,FOLLOW_21_in_add4839); 
                    char_literal263_tree = 
                    (Object)adaptor.create(char_literal263)
                    ;
                    adaptor.addChild(root_0, char_literal263_tree);



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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2585:4: '.addProperty' '(' propertyToken= ID ')'
                    {
                    string_literal264=(Token)match(input,29,FOLLOW_29_in_add4847); 
                    string_literal264_tree = 
                    (Object)adaptor.create(string_literal264)
                    ;
                    adaptor.addChild(root_0, string_literal264_tree);


                    char_literal265=(Token)match(input,20,FOLLOW_20_in_add4849); 
                    char_literal265_tree = 
                    (Object)adaptor.create(char_literal265)
                    ;
                    adaptor.addChild(root_0, char_literal265_tree);


                    propertyToken=(Token)match(input,ID,FOLLOW_ID_in_add4853); 
                    propertyToken_tree = 
                    (Object)adaptor.create(propertyToken)
                    ;
                    adaptor.addChild(root_0, propertyToken_tree);


                    char_literal266=(Token)match(input,21,FOLLOW_21_in_add4855); 
                    char_literal266_tree = 
                    (Object)adaptor.create(char_literal266)
                    ;
                    adaptor.addChild(root_0, char_literal266_tree);



                    if(!defer) {
                        interp.addProperty((componentToken!=null?componentToken.getText():null), (propertyToken!=null?propertyToken.getText():null));    
                    }	
                    	

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2590:4: '.addProperties' '(' lstToken= listOfIDs[defer] ')'
                    {
                    string_literal267=(Token)match(input,28,FOLLOW_28_in_add4862); 
                    string_literal267_tree = 
                    (Object)adaptor.create(string_literal267)
                    ;
                    adaptor.addChild(root_0, string_literal267_tree);


                    char_literal268=(Token)match(input,20,FOLLOW_20_in_add4864); 
                    char_literal268_tree = 
                    (Object)adaptor.create(char_literal268)
                    ;
                    adaptor.addChild(root_0, char_literal268_tree);


                    pushFollow(FOLLOW_listOfIDs_in_add4868);
                    lstToken=listOfIDs(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, lstToken.getTree());

                    char_literal269=(Token)match(input,21,FOLLOW_21_in_add4871); 
                    char_literal269_tree = 
                    (Object)adaptor.create(char_literal269)
                    ;
                    adaptor.addChild(root_0, char_literal269_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2603:1: toSequence[boolean defer] returns [String sequence] : idToken= ID '.' 'toSequence' '(' ')' ;
    public final EugeneParser.toSequence_return toSequence(boolean defer) throws RecognitionException {
        EugeneParser.toSequence_return retval = new EugeneParser.toSequence_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal270=null;
        Token string_literal271=null;
        Token char_literal272=null;
        Token char_literal273=null;

        Object idToken_tree=null;
        Object char_literal270_tree=null;
        Object string_literal271_tree=null;
        Object char_literal272_tree=null;
        Object char_literal273_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2604:2: (idToken= ID '.' 'toSequence' '(' ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2604:4: idToken= ID '.' 'toSequence' '(' ')'
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_toSequence4902); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal270=(Token)match(input,26,FOLLOW_26_in_toSequence4904); 
            char_literal270_tree = 
            (Object)adaptor.create(char_literal270)
            ;
            adaptor.addChild(root_0, char_literal270_tree);


            string_literal271=(Token)match(input,109,FOLLOW_109_in_toSequence4906); 
            string_literal271_tree = 
            (Object)adaptor.create(string_literal271)
            ;
            adaptor.addChild(root_0, string_literal271_tree);


            char_literal272=(Token)match(input,20,FOLLOW_20_in_toSequence4908); 
            char_literal272_tree = 
            (Object)adaptor.create(char_literal272)
            ;
            adaptor.addChild(root_0, char_literal272_tree);


            char_literal273=(Token)match(input,21,FOLLOW_21_in_toSequence4910); 
            char_literal273_tree = 
            (Object)adaptor.create(char_literal273)
            ;
            adaptor.addChild(root_0, char_literal273_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2621:1: get[boolean defer] returns [NamedElement objElement] : idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')' ;
    public final EugeneParser.get_return get(boolean defer) throws RecognitionException {
        EugeneParser.get_return retval = new EugeneParser.get_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token idxToken=null;
        Token varToken=null;
        Token strToken=null;
        Token char_literal274=null;
        Token string_literal275=null;
        Token char_literal276=null;
        Token char_literal277=null;

        Object idToken_tree=null;
        Object idxToken_tree=null;
        Object varToken_tree=null;
        Object strToken_tree=null;
        Object char_literal274_tree=null;
        Object string_literal275_tree=null;
        Object char_literal276_tree=null;
        Object char_literal277_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2622:2: (idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2622:4: idToken= ID '.' 'get' '(' (idxToken= INT |varToken= ID |strToken= STRING ) ')'
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_get4936); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal274=(Token)match(input,26,FOLLOW_26_in_get4938); 
            char_literal274_tree = 
            (Object)adaptor.create(char_literal274)
            ;
            adaptor.addChild(root_0, char_literal274_tree);


            string_literal275=(Token)match(input,91,FOLLOW_91_in_get4940); 
            string_literal275_tree = 
            (Object)adaptor.create(string_literal275)
            ;
            adaptor.addChild(root_0, string_literal275_tree);


            char_literal276=(Token)match(input,20,FOLLOW_20_in_get4942); 
            char_literal276_tree = 
            (Object)adaptor.create(char_literal276)
            ;
            adaptor.addChild(root_0, char_literal276_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2622:29: (idxToken= INT |varToken= ID |strToken= STRING )
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2622:30: idxToken= INT
                    {
                    idxToken=(Token)match(input,INT,FOLLOW_INT_in_get4947); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2628:6: varToken= ID
                    {
                    varToken=(Token)match(input,ID,FOLLOW_ID_in_get4955); 
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2634:6: strToken= STRING
                    {
                    strToken=(Token)match(input,STRING,FOLLOW_STRING_in_get4963); 
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


            char_literal277=(Token)match(input,21,FOLLOW_21_in_get4968); 
            char_literal277_tree = 
            (Object)adaptor.create(char_literal277)
            ;
            adaptor.addChild(root_0, char_literal277_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2688:1: size[boolean defer] returns [double nSize] : idToken= ID '.' 'size' '(' ')' -> ^( '.' 'size' ) ;
    public final EugeneParser.size_return size(boolean defer) throws RecognitionException {
        EugeneParser.size_return retval = new EugeneParser.size_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal278=null;
        Token string_literal279=null;
        Token char_literal280=null;
        Token char_literal281=null;

        Object idToken_tree=null;
        Object char_literal278_tree=null;
        Object string_literal279_tree=null;
        Object char_literal280_tree=null;
        Object char_literal281_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_107=new RewriteRuleTokenStream(adaptor,"token 107");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2689:2: (idToken= ID '.' 'size' '(' ')' -> ^( '.' 'size' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2689:4: idToken= ID '.' 'size' '(' ')'
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_size5001);  
            stream_ID.add(idToken);


            char_literal278=(Token)match(input,26,FOLLOW_26_in_size5003);  
            stream_26.add(char_literal278);


            string_literal279=(Token)match(input,107,FOLLOW_107_in_size5005);  
            stream_107.add(string_literal279);


            char_literal280=(Token)match(input,20,FOLLOW_20_in_size5007);  
            stream_20.add(char_literal280);


            char_literal281=(Token)match(input,21,FOLLOW_21_in_size5009);  
            stream_21.add(char_literal281);



            if(!defer) {
                retval.nSize = interp.sizeOf((idToken!=null?idToken.getText():null));
            }	
            	

            // AST REWRITE
            // elements: 107, 26
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 2693:4: -> ^( '.' 'size' )
            {
                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2693:7: ^( '.' 'size' )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_26.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                stream_107.nextNode()
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2702:1: remove[boolean defer] : idToken= ID '.' 'remove' '(' idxToken= expression[defer] ')' -> ^( '.' 'remove' ) ;
    public final EugeneParser.remove_return remove(boolean defer) throws RecognitionException {
        EugeneParser.remove_return retval = new EugeneParser.remove_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal282=null;
        Token string_literal283=null;
        Token char_literal284=null;
        Token char_literal285=null;
        EugeneParser.expression_return idxToken =null;


        Object idToken_tree=null;
        Object char_literal282_tree=null;
        Object string_literal283_tree=null;
        Object char_literal284_tree=null;
        Object char_literal285_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2703:2: (idToken= ID '.' 'remove' '(' idxToken= expression[defer] ')' -> ^( '.' 'remove' ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2703:4: idToken= ID '.' 'remove' '(' idxToken= expression[defer] ')'
            {
            idToken=(Token)match(input,ID,FOLLOW_ID_in_remove5039);  
            stream_ID.add(idToken);


            char_literal282=(Token)match(input,26,FOLLOW_26_in_remove5041);  
            stream_26.add(char_literal282);


            string_literal283=(Token)match(input,104,FOLLOW_104_in_remove5043);  
            stream_104.add(string_literal283);


            char_literal284=(Token)match(input,20,FOLLOW_20_in_remove5045);  
            stream_20.add(char_literal284);


            pushFollow(FOLLOW_expression_in_remove5049);
            idxToken=expression(defer);

            state._fsp--;

            stream_expression.add(idxToken.getTree());

            char_literal285=(Token)match(input,21,FOLLOW_21_in_remove5052);  
            stream_21.add(char_literal285);



            if(!defer) {
                interp.remove((idToken!=null?idToken.getText():null), (idxToken!=null?idxToken.objElement:null));
            }	
            	

            // AST REWRITE
            // elements: 26, 104
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 2707:4: -> ^( '.' 'remove' )
            {
                // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2707:7: ^( '.' 'remove' )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                stream_26.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                stream_104.nextNode()
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2770:1: listOfRules[boolean defer] returns [ArrayList<Rule> lstRules] : idToken= ID ( ',' idToken= ID )* ;
    public final EugeneParser.listOfRules_return listOfRules(boolean defer) throws RecognitionException {
        EugeneParser.listOfRules_return retval = new EugeneParser.listOfRules_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token idToken=null;
        Token char_literal286=null;

        Object idToken_tree=null;
        Object char_literal286_tree=null;


        retval.lstRules = new ArrayList<Rule>();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2775:2: (idToken= ID ( ',' idToken= ID )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2775:4: idToken= ID ( ',' idToken= ID )*
            {
            root_0 = (Object)adaptor.nil();


            idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfRules5098); 
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
            	

            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2790:4: ( ',' idToken= ID )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==24) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2790:5: ',' idToken= ID
            	    {
            	    char_literal286=(Token)match(input,24,FOLLOW_24_in_listOfRules5103); 
            	    char_literal286_tree = 
            	    (Object)adaptor.create(char_literal286)
            	    ;
            	    adaptor.addChild(root_0, char_literal286_tree);


            	    idToken=(Token)match(input,ID,FOLLOW_ID_in_listOfRules5107); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2811:1: combinatorialFunction[boolean defer] returns [DeviceArray objDeviceArray] : functionToken= ( 'permute' | 'product' ) '(' deviceToken= ID ( ',' rulesToken= ( 'strict' | 'flexible' ) )? ( ',' (capToken= expression[defer] )? )? ( ',' (depthToken= expression[defer] )? )? ')' ;
    public final EugeneParser.combinatorialFunction_return combinatorialFunction(boolean defer) throws RecognitionException {
        EugeneParser.combinatorialFunction_return retval = new EugeneParser.combinatorialFunction_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token functionToken=null;
        Token deviceToken=null;
        Token rulesToken=null;
        Token char_literal287=null;
        Token char_literal288=null;
        Token char_literal289=null;
        Token char_literal290=null;
        Token char_literal291=null;
        EugeneParser.expression_return capToken =null;

        EugeneParser.expression_return depthToken =null;


        Object functionToken_tree=null;
        Object deviceToken_tree=null;
        Object rulesToken_tree=null;
        Object char_literal287_tree=null;
        Object char_literal288_tree=null;
        Object char_literal289_tree=null;
        Object char_literal290_tree=null;
        Object char_literal291_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2812:6: (functionToken= ( 'permute' | 'product' ) '(' deviceToken= ID ( ',' rulesToken= ( 'strict' | 'flexible' ) )? ( ',' (capToken= expression[defer] )? )? ( ',' (depthToken= expression[defer] )? )? ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2812:11: functionToken= ( 'permute' | 'product' ) '(' deviceToken= ID ( ',' rulesToken= ( 'strict' | 'flexible' ) )? ( ',' (capToken= expression[defer] )? )? ( ',' (depthToken= expression[defer] )? )? ')'
            {
            root_0 = (Object)adaptor.nil();


            functionToken=(Token)input.LT(1);

            if ( input.LA(1)==99||input.LA(1)==103 ) {
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


            char_literal287=(Token)match(input,20,FOLLOW_20_in_combinatorialFunction5146); 
            char_literal287_tree = 
            (Object)adaptor.create(char_literal287)
            ;
            adaptor.addChild(root_0, char_literal287_tree);


            deviceToken=(Token)match(input,ID,FOLLOW_ID_in_combinatorialFunction5158); 
            deviceToken_tree = 
            (Object)adaptor.create(deviceToken)
            ;
            adaptor.addChild(root_0, deviceToken_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2814:8: ( ',' rulesToken= ( 'strict' | 'flexible' ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==24) ) {
                int LA92_1 = input.LA(2);

                if ( (LA92_1==88||LA92_1==108) ) {
                    alt92=1;
                }
            }
            switch (alt92) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2814:9: ',' rulesToken= ( 'strict' | 'flexible' )
                    {
                    char_literal288=(Token)match(input,24,FOLLOW_24_in_combinatorialFunction5184); 
                    char_literal288_tree = 
                    (Object)adaptor.create(char_literal288)
                    ;
                    adaptor.addChild(root_0, char_literal288_tree);


                    rulesToken=(Token)input.LT(1);

                    if ( input.LA(1)==88||input.LA(1)==108 ) {
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


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:8: ( ',' (capToken= expression[defer] )? )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==24) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:9: ',' (capToken= expression[defer] )?
                    {
                    char_literal289=(Token)match(input,24,FOLLOW_24_in_combinatorialFunction5213); 
                    char_literal289_tree = 
                    (Object)adaptor.create(char_literal289)
                    ;
                    adaptor.addChild(root_0, char_literal289_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:13: (capToken= expression[defer] )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==FLOAT||LA93_0==ID||LA93_0==INT||LA93_0==STRING||LA93_0==18||LA93_0==20||LA93_0==25||(LA93_0 >= 33 && LA93_0 <= 34)||(LA93_0 >= 36 && LA93_0 <= 39)||(LA93_0 >= 42 && LA93_0 <= 44)||LA93_0==46||(LA93_0 >= 49 && LA93_0 <= 52)||LA93_0==54||(LA93_0 >= 57 && LA93_0 <= 64)||LA93_0==68||LA93_0==72||(LA93_0 >= 75 && LA93_0 <= 77)||LA93_0==79||LA93_0==87||LA93_0==110) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2815:14: capToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_combinatorialFunction5218);
                            capToken=expression(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, capToken.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2816:8: ( ',' (depthToken= expression[defer] )? )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==24) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2816:9: ',' (depthToken= expression[defer] )?
                    {
                    char_literal290=(Token)match(input,24,FOLLOW_24_in_combinatorialFunction5235); 
                    char_literal290_tree = 
                    (Object)adaptor.create(char_literal290)
                    ;
                    adaptor.addChild(root_0, char_literal290_tree);


                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2816:13: (depthToken= expression[defer] )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==FLOAT||LA95_0==ID||LA95_0==INT||LA95_0==STRING||LA95_0==18||LA95_0==20||LA95_0==25||(LA95_0 >= 33 && LA95_0 <= 34)||(LA95_0 >= 36 && LA95_0 <= 39)||(LA95_0 >= 42 && LA95_0 <= 44)||LA95_0==46||(LA95_0 >= 49 && LA95_0 <= 52)||LA95_0==54||(LA95_0 >= 57 && LA95_0 <= 64)||LA95_0==68||LA95_0==72||(LA95_0 >= 75 && LA95_0 <= 77)||LA95_0==79||LA95_0==87||LA95_0==110) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2816:14: depthToken= expression[defer]
                            {
                            pushFollow(FOLLOW_expression_in_combinatorialFunction5240);
                            depthToken=expression(defer);

                            state._fsp--;

                            adaptor.addChild(root_0, depthToken.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            char_literal291=(Token)match(input,21,FOLLOW_21_in_combinatorialFunction5247); 
            char_literal291_tree = 
            (Object)adaptor.create(char_literal291)
            ;
            adaptor.addChild(root_0, char_literal291_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2834:1: getObject[NamedElement objElement] : ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )* ;
    public final EugeneParser.getObject_return getObject(NamedElement objElement) throws RecognitionException {
        EugeneParser.getObject_return retval = new EugeneParser.getObject_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token elementToken=null;
        Token char_literal292=null;
        Token char_literal293=null;
        Token char_literal294=null;
        EugeneParser.expression_return exprToken =null;


        Object elementToken_tree=null;
        Object char_literal292_tree=null;
        Object char_literal293_tree=null;
        Object char_literal294_tree=null;

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2835:2: ( ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )* )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2835:4: ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )*
            {
            root_0 = (Object)adaptor.nil();


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2835:4: ( ( '.' elementToken= ID ) | ( '[' exprToken= expression[true] ']' ) )*
            loop97:
            do {
                int alt97=3;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==26) ) {
                    alt97=1;
                }
                else if ( (LA97_0==79) ) {
                    alt97=2;
                }


                switch (alt97) {
            	case 1 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2835:5: ( '.' elementToken= ID )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2835:5: ( '.' elementToken= ID )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2835:6: '.' elementToken= ID
            	    {
            	    char_literal292=(Token)match(input,26,FOLLOW_26_in_getObject5279); 
            	    char_literal292_tree = 
            	    (Object)adaptor.create(char_literal292)
            	    ;
            	    adaptor.addChild(root_0, char_literal292_tree);


            	    elementToken=(Token)match(input,ID,FOLLOW_ID_in_getObject5283); 
            	    elementToken_tree = 
            	    (Object)adaptor.create(elementToken)
            	    ;
            	    adaptor.addChild(root_0, elementToken_tree);


            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2835:29: ( '[' exprToken= expression[true] ']' )
            	    {
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2835:29: ( '[' exprToken= expression[true] ']' )
            	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2835:30: '[' exprToken= expression[true] ']'
            	    {
            	    char_literal293=(Token)match(input,79,FOLLOW_79_in_getObject5289); 
            	    char_literal293_tree = 
            	    (Object)adaptor.create(char_literal293)
            	    ;
            	    adaptor.addChild(root_0, char_literal293_tree);


            	    pushFollow(FOLLOW_expression_in_getObject5293);
            	    exprToken=expression(true);

            	    state._fsp--;

            	    adaptor.addChild(root_0, exprToken.getTree());

            	    char_literal294=(Token)match(input,80,FOLLOW_80_in_getObject5296); 
            	    char_literal294_tree = 
            	    (Object)adaptor.create(char_literal294)
            	    ;
            	    adaptor.addChild(root_0, char_literal294_tree);


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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2873:1: printStatement[boolean defer] : (| 'println' '(' ')' | 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' | 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' );
    public final EugeneParser.printStatement_return printStatement(boolean defer) throws RecognitionException {
        EugeneParser.printStatement_return retval = new EugeneParser.printStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal295=null;
        Token char_literal296=null;
        Token char_literal297=null;
        Token string_literal298=null;
        Token char_literal299=null;
        Token char_literal300=null;
        Token char_literal301=null;
        Token string_literal302=null;
        Token char_literal303=null;
        Token char_literal304=null;
        Token char_literal305=null;
        EugeneParser.whatToPrint_return printToken1 =null;

        EugeneParser.whatToPrint_return printToken2 =null;


        Object string_literal295_tree=null;
        Object char_literal296_tree=null;
        Object char_literal297_tree=null;
        Object string_literal298_tree=null;
        Object char_literal299_tree=null;
        Object char_literal300_tree=null;
        Object char_literal301_tree=null;
        Object string_literal302_tree=null;
        Object char_literal303_tree=null;
        Object char_literal304_tree=null;
        Object char_literal305_tree=null;


        System.err.flush();
        System.out.flush();

        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2881:2: (| 'println' '(' ')' | 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' | 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')' )
            int alt100=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt100=1;
                }
                break;
            case 102:
                {
                int LA100_2 = input.LA(2);

                if ( (LA100_2==20) ) {
                    int LA100_4 = input.LA(3);

                    if ( (LA100_4==21) ) {
                        alt100=2;
                    }
                    else if ( (LA100_4==FLOAT||LA100_4==ID||LA100_4==INT||LA100_4==STRING||LA100_4==18||LA100_4==20||LA100_4==25||(LA100_4 >= 33 && LA100_4 <= 34)||(LA100_4 >= 36 && LA100_4 <= 39)||(LA100_4 >= 42 && LA100_4 <= 44)||LA100_4==46||(LA100_4 >= 49 && LA100_4 <= 54)||(LA100_4 >= 57 && LA100_4 <= 64)||LA100_4==68||LA100_4==72||(LA100_4 >= 74 && LA100_4 <= 77)||LA100_4==79||LA100_4==87||LA100_4==99||LA100_4==103||LA100_4==110) ) {
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
            case 101:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2882:9: 
                    {
                    root_0 = (Object)adaptor.nil();


                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2882:11: 'println' '(' ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal295=(Token)match(input,102,FOLLOW_102_in_printStatement5339); 
                    string_literal295_tree = 
                    (Object)adaptor.create(string_literal295)
                    ;
                    adaptor.addChild(root_0, string_literal295_tree);


                    char_literal296=(Token)match(input,20,FOLLOW_20_in_printStatement5341); 
                    char_literal296_tree = 
                    (Object)adaptor.create(char_literal296)
                    ;
                    adaptor.addChild(root_0, char_literal296_tree);


                    char_literal297=(Token)match(input,21,FOLLOW_21_in_printStatement5343); 
                    char_literal297_tree = 
                    (Object)adaptor.create(char_literal297)
                    ;
                    adaptor.addChild(root_0, char_literal297_tree);



                    if(!defer) {
                            System.out.println();
                    }
                            

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2887:11: 'print' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal298=(Token)match(input,101,FOLLOW_101_in_printStatement5357); 
                    string_literal298_tree = 
                    (Object)adaptor.create(string_literal298)
                    ;
                    adaptor.addChild(root_0, string_literal298_tree);


                    char_literal299=(Token)match(input,20,FOLLOW_20_in_printStatement5359); 
                    char_literal299_tree = 
                    (Object)adaptor.create(char_literal299)
                    ;
                    adaptor.addChild(root_0, char_literal299_tree);


                    pushFollow(FOLLOW_whatToPrint_in_printStatement5363);
                    printToken1=whatToPrint(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printToken1.getTree());


                    if(!defer) {        
                        System.out.print((printToken1!=null?printToken1.s:null));
                    }
                            

                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2891:11: ( ',' printToken2= whatToPrint[defer] )*
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==24) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2891:12: ',' printToken2= whatToPrint[defer]
                    	    {
                    	    char_literal300=(Token)match(input,24,FOLLOW_24_in_printStatement5369); 
                    	    char_literal300_tree = 
                    	    (Object)adaptor.create(char_literal300)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal300_tree);


                    	    pushFollow(FOLLOW_whatToPrint_in_printStatement5373);
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


                    char_literal301=(Token)match(input,21,FOLLOW_21_in_printStatement5380); 
                    char_literal301_tree = 
                    (Object)adaptor.create(char_literal301)
                    ;
                    adaptor.addChild(root_0, char_literal301_tree);


                    }
                    break;
                case 4 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2896:11: 'println' '(' printToken1= whatToPrint[defer] ( ',' printToken2= whatToPrint[defer] )* ')'
                    {
                    root_0 = (Object)adaptor.nil();


                    string_literal302=(Token)match(input,102,FOLLOW_102_in_printStatement5392); 
                    string_literal302_tree = 
                    (Object)adaptor.create(string_literal302)
                    ;
                    adaptor.addChild(root_0, string_literal302_tree);


                    char_literal303=(Token)match(input,20,FOLLOW_20_in_printStatement5394); 
                    char_literal303_tree = 
                    (Object)adaptor.create(char_literal303)
                    ;
                    adaptor.addChild(root_0, char_literal303_tree);


                    pushFollow(FOLLOW_whatToPrint_in_printStatement5398);
                    printToken1=whatToPrint(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, printToken1.getTree());


                    if(!defer) {        
                        System.out.print((printToken1!=null?printToken1.s:null));
                    }
                            

                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2900:11: ( ',' printToken2= whatToPrint[defer] )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==24) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2900:12: ',' printToken2= whatToPrint[defer]
                    	    {
                    	    char_literal304=(Token)match(input,24,FOLLOW_24_in_printStatement5404); 
                    	    char_literal304_tree = 
                    	    (Object)adaptor.create(char_literal304)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal304_tree);


                    	    pushFollow(FOLLOW_whatToPrint_in_printStatement5408);
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


                    char_literal305=(Token)match(input,21,FOLLOW_21_in_printStatement5415); 
                    char_literal305_tree = 
                    (Object)adaptor.create(char_literal305)
                    ;
                    adaptor.addChild(root_0, char_literal305_tree);



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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2911:1: whatToPrint[boolean defer] returns [String s] : (valueToken= expression[defer] |wrapperToken= wrappedStatement[defer] );
    public final EugeneParser.whatToPrint_return whatToPrint(boolean defer) throws RecognitionException {
        EugeneParser.whatToPrint_return retval = new EugeneParser.whatToPrint_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.expression_return valueToken =null;

        EugeneParser.wrappedStatement_return wrapperToken =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2912:2: (valueToken= expression[defer] |wrapperToken= wrappedStatement[defer] )
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
            case 54:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 68:
            case 72:
            case 75:
            case 76:
            case 77:
            case 79:
            case 87:
            case 110:
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
                    case 91:
                        {
                        int LA101_5 = input.LA(4);

                        if ( (LA101_5==20) ) {
                            switch ( input.LA(5) ) {
                            case INT:
                                {
                                int LA101_11 = input.LA(6);

                                if ( ((LA101_11 >= 18 && LA101_11 <= 19)||(LA101_11 >= 21 && LA101_11 <= 23)||LA101_11==25||LA101_11==30||(LA101_11 >= 33 && LA101_11 <= 34)||(LA101_11 >= 36 && LA101_11 <= 40)||(LA101_11 >= 42 && LA101_11 <= 44)||LA101_11==46||(LA101_11 >= 49 && LA101_11 <= 50)||(LA101_11 >= 54 && LA101_11 <= 55)||(LA101_11 >= 57 && LA101_11 <= 60)||(LA101_11 >= 62 && LA101_11 <= 64)||(LA101_11 >= 67 && LA101_11 <= 68)||LA101_11==72||(LA101_11 >= 75 && LA101_11 <= 78)||LA101_11==81||LA101_11==94||LA101_11==114) ) {
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

                                if ( ((LA101_12 >= 18 && LA101_12 <= 19)||(LA101_12 >= 21 && LA101_12 <= 23)||(LA101_12 >= 25 && LA101_12 <= 26)||LA101_12==30||(LA101_12 >= 33 && LA101_12 <= 34)||(LA101_12 >= 36 && LA101_12 <= 40)||(LA101_12 >= 42 && LA101_12 <= 44)||LA101_12==46||(LA101_12 >= 49 && LA101_12 <= 50)||(LA101_12 >= 54 && LA101_12 <= 55)||(LA101_12 >= 57 && LA101_12 <= 60)||(LA101_12 >= 62 && LA101_12 <= 64)||(LA101_12 >= 67 && LA101_12 <= 68)||LA101_12==72||(LA101_12 >= 75 && LA101_12 <= 79)||LA101_12==81||LA101_12==94||LA101_12==114) ) {
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

                                if ( ((LA101_13 >= 18 && LA101_13 <= 19)||(LA101_13 >= 21 && LA101_13 <= 23)||LA101_13==25||LA101_13==30||(LA101_13 >= 33 && LA101_13 <= 34)||(LA101_13 >= 36 && LA101_13 <= 40)||(LA101_13 >= 42 && LA101_13 <= 44)||LA101_13==46||(LA101_13 >= 49 && LA101_13 <= 50)||(LA101_13 >= 54 && LA101_13 <= 55)||(LA101_13 >= 57 && LA101_13 <= 60)||(LA101_13 >= 62 && LA101_13 <= 64)||(LA101_13 >= 67 && LA101_13 <= 68)||LA101_13==72||(LA101_13 >= 75 && LA101_13 <= 78)||LA101_13==81||LA101_13==94||LA101_13==114) ) {
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
                            case 54:
                            case 57:
                            case 58:
                            case 59:
                            case 60:
                            case 61:
                            case 62:
                            case 63:
                            case 64:
                            case 68:
                            case 72:
                            case 75:
                            case 76:
                            case 77:
                            case 79:
                            case 87:
                            case 110:
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
                    case 107:
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
                        else if ( ((LA101_6 >= 18 && LA101_6 <= 19)||(LA101_6 >= 21 && LA101_6 <= 26)||LA101_6==30||(LA101_6 >= 33 && LA101_6 <= 34)||(LA101_6 >= 36 && LA101_6 <= 40)||(LA101_6 >= 42 && LA101_6 <= 44)||LA101_6==46||(LA101_6 >= 49 && LA101_6 <= 50)||(LA101_6 >= 54 && LA101_6 <= 55)||(LA101_6 >= 57 && LA101_6 <= 60)||(LA101_6 >= 62 && LA101_6 <= 64)||(LA101_6 >= 67 && LA101_6 <= 68)||LA101_6==72||(LA101_6 >= 75 && LA101_6 <= 79)||LA101_6==81||LA101_6==94||LA101_6==114) ) {
                            alt101=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 101, 6, input);

                            throw nvae;

                        }
                        }
                        break;
                    case 83:
                    case 97:
                    case 104:
                        {
                        alt101=2;
                        }
                        break;
                    case 109:
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
                        else if ( ((LA101_7 >= 18 && LA101_7 <= 19)||(LA101_7 >= 21 && LA101_7 <= 26)||LA101_7==30||(LA101_7 >= 33 && LA101_7 <= 34)||(LA101_7 >= 36 && LA101_7 <= 40)||(LA101_7 >= 42 && LA101_7 <= 44)||LA101_7==46||(LA101_7 >= 49 && LA101_7 <= 50)||(LA101_7 >= 54 && LA101_7 <= 55)||(LA101_7 >= 57 && LA101_7 <= 60)||(LA101_7 >= 62 && LA101_7 <= 64)||(LA101_7 >= 67 && LA101_7 <= 68)||LA101_7==72||(LA101_7 >= 75 && LA101_7 <= 79)||LA101_7==81||LA101_7==94||LA101_7==114) ) {
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
                    case 95:
                    case 96:
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
                case 54:
                case 55:
                case 57:
                case 58:
                case 59:
                case 60:
                case 62:
                case 63:
                case 64:
                case 67:
                case 68:
                case 72:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 81:
                case 94:
                case 114:
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
            case 53:
            case 74:
            case 99:
            case 103:
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2912:4: valueToken= expression[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_expression_in_whatToPrint5436);
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
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2921:4: wrapperToken= wrappedStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_wrappedStatement_in_whatToPrint5446);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2932:1: dataExtraction[boolean defer] : ( sbolStatement[defer] | genbankStatement[defer] | pigeonStatement[defer] );
    public final EugeneParser.dataExtraction_return dataExtraction(boolean defer) throws RecognitionException {
        EugeneParser.dataExtraction_return retval = new EugeneParser.dataExtraction_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        EugeneParser.sbolStatement_return sbolStatement306 =null;

        EugeneParser.genbankStatement_return genbankStatement307 =null;

        EugeneParser.pigeonStatement_return pigeonStatement308 =null;



        try {
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2933:2: ( sbolStatement[defer] | genbankStatement[defer] | pigeonStatement[defer] )
            int alt102=3;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt102=1;
                }
                break;
            case 53:
                {
                alt102=2;
                }
                break;
            case 100:
                {
                alt102=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }

            switch (alt102) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2933:4: sbolStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_sbolStatement_in_dataExtraction5464);
                    sbolStatement306=sbolStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolStatement306.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2934:4: genbankStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_genbankStatement_in_dataExtraction5470);
                    genbankStatement307=genbankStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, genbankStatement307.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2935:4: pigeonStatement[defer]
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_pigeonStatement_in_dataExtraction5476);
                    pigeonStatement308=pigeonStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, pigeonStatement308.getTree());

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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2939:1: sbolStatement[boolean defer] returns [NamedElement objElement] : 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] ) ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2940:2: ( 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2940:4: 'SBOL' '.' ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] )
            {
            root_0 = (Object)adaptor.nil();


            string_literal309=(Token)match(input,74,FOLLOW_74_in_sbolStatement5496); 
            string_literal309_tree = 
            (Object)adaptor.create(string_literal309)
            ;
            adaptor.addChild(root_0, string_literal309_tree);


            char_literal310=(Token)match(input,26,FOLLOW_26_in_sbolStatement5498); 
            char_literal310_tree = 
            (Object)adaptor.create(char_literal310)
            ;
            adaptor.addChild(root_0, char_literal310_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2940:15: ( sbolExportStatement[defer] |importToken= sbolImportStatement[defer] )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==86) ) {
                alt103=1;
            }
            else if ( (LA103_0==93) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }
            switch (alt103) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2940:16: sbolExportStatement[defer]
                    {
                    pushFollow(FOLLOW_sbolExportStatement_in_sbolStatement5501);
                    sbolExportStatement311=sbolExportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, sbolExportStatement311.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2940:45: importToken= sbolImportStatement[defer]
                    {
                    pushFollow(FOLLOW_sbolImportStatement_in_sbolStatement5508);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2947:1: sbolExportStatement[boolean defer] : 'export' '(' idToken= ID ',' filenameToken= STRING ')' ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2948:2: ( 'export' '(' idToken= ID ',' filenameToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2948:4: 'export' '(' idToken= ID ',' filenameToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal312=(Token)match(input,86,FOLLOW_86_in_sbolExportStatement5525); 
            string_literal312_tree = 
            (Object)adaptor.create(string_literal312)
            ;
            adaptor.addChild(root_0, string_literal312_tree);


            char_literal313=(Token)match(input,20,FOLLOW_20_in_sbolExportStatement5527); 
            char_literal313_tree = 
            (Object)adaptor.create(char_literal313)
            ;
            adaptor.addChild(root_0, char_literal313_tree);


            idToken=(Token)match(input,ID,FOLLOW_ID_in_sbolExportStatement5531); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal314=(Token)match(input,24,FOLLOW_24_in_sbolExportStatement5533); 
            char_literal314_tree = 
            (Object)adaptor.create(char_literal314)
            ;
            adaptor.addChild(root_0, char_literal314_tree);


            filenameToken=(Token)match(input,STRING,FOLLOW_STRING_in_sbolExportStatement5537); 
            filenameToken_tree = 
            (Object)adaptor.create(filenameToken)
            ;
            adaptor.addChild(root_0, filenameToken_tree);


            char_literal315=(Token)match(input,21,FOLLOW_21_in_sbolExportStatement5539); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2962:1: sbolImportStatement[boolean defer] returns [NamedElement objElement] : 'import' '(' fileToken= STRING ')' ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2964:2: ( 'import' '(' fileToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2964:4: 'import' '(' fileToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal316=(Token)match(input,93,FOLLOW_93_in_sbolImportStatement5568); 
            string_literal316_tree = 
            (Object)adaptor.create(string_literal316)
            ;
            adaptor.addChild(root_0, string_literal316_tree);


            char_literal317=(Token)match(input,20,FOLLOW_20_in_sbolImportStatement5570); 
            char_literal317_tree = 
            (Object)adaptor.create(char_literal317)
            ;
            adaptor.addChild(root_0, char_literal317_tree);


            fileToken=(Token)match(input,STRING,FOLLOW_STRING_in_sbolImportStatement5574); 
            fileToken_tree = 
            (Object)adaptor.create(fileToken)
            ;
            adaptor.addChild(root_0, fileToken_tree);


            char_literal318=(Token)match(input,21,FOLLOW_21_in_sbolImportStatement5576); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2976:1: genbankStatement[boolean defer] returns [NamedElement objElement] : 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] ) ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2977:2: ( 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] ) )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2977:4: 'Genbank' '.' (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] )
            {
            root_0 = (Object)adaptor.nil();


            string_literal319=(Token)match(input,53,FOLLOW_53_in_genbankStatement5602); 
            string_literal319_tree = 
            (Object)adaptor.create(string_literal319)
            ;
            adaptor.addChild(root_0, string_literal319_tree);


            char_literal320=(Token)match(input,26,FOLLOW_26_in_genbankStatement5604); 
            char_literal320_tree = 
            (Object)adaptor.create(char_literal320)
            ;
            adaptor.addChild(root_0, char_literal320_tree);


            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2977:18: (importToken= genbankImportStatement[defer] | genbankExportStatement[defer] )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==93) ) {
                alt104=1;
            }
            else if ( (LA104_0==86) ) {
                alt104=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;

            }
            switch (alt104) {
                case 1 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2977:19: importToken= genbankImportStatement[defer]
                    {
                    pushFollow(FOLLOW_genbankImportStatement_in_genbankStatement5609);
                    importToken=genbankImportStatement(defer);

                    state._fsp--;

                    adaptor.addChild(root_0, importToken.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2977:63: genbankExportStatement[defer]
                    {
                    pushFollow(FOLLOW_genbankExportStatement_in_genbankStatement5614);
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2984:1: genbankExportStatement[boolean defer] returns [NamedElement objElement] : 'export' '(' ')' ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2985:2: ( 'export' '(' ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2985:4: 'export' '(' ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal322=(Token)match(input,86,FOLLOW_86_in_genbankExportStatement5637); 
            string_literal322_tree = 
            (Object)adaptor.create(string_literal322)
            ;
            adaptor.addChild(root_0, string_literal322_tree);


            char_literal323=(Token)match(input,20,FOLLOW_20_in_genbankExportStatement5639); 
            char_literal323_tree = 
            (Object)adaptor.create(char_literal323)
            ;
            adaptor.addChild(root_0, char_literal323_tree);


            char_literal324=(Token)match(input,21,FOLLOW_21_in_genbankExportStatement5641); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2988:1: genbankImportStatement[boolean defer] returns [NamedElement objElement] : 'import' '(' typeToken= ID ',' partToken= STRING ')' ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2989:2: ( 'import' '(' typeToken= ID ',' partToken= STRING ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:2989:4: 'import' '(' typeToken= ID ',' partToken= STRING ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal325=(Token)match(input,93,FOLLOW_93_in_genbankImportStatement5658); 
            string_literal325_tree = 
            (Object)adaptor.create(string_literal325)
            ;
            adaptor.addChild(root_0, string_literal325_tree);


            char_literal326=(Token)match(input,20,FOLLOW_20_in_genbankImportStatement5660); 
            char_literal326_tree = 
            (Object)adaptor.create(char_literal326)
            ;
            adaptor.addChild(root_0, char_literal326_tree);


            typeToken=(Token)match(input,ID,FOLLOW_ID_in_genbankImportStatement5664); 
            typeToken_tree = 
            (Object)adaptor.create(typeToken)
            ;
            adaptor.addChild(root_0, typeToken_tree);


            char_literal327=(Token)match(input,24,FOLLOW_24_in_genbankImportStatement5666); 
            char_literal327_tree = 
            (Object)adaptor.create(char_literal327)
            ;
            adaptor.addChild(root_0, char_literal327_tree);


            partToken=(Token)match(input,STRING,FOLLOW_STRING_in_genbankImportStatement5670); 
            partToken_tree = 
            (Object)adaptor.create(partToken)
            ;
            adaptor.addChild(root_0, partToken_tree);


            char_literal328=(Token)match(input,21,FOLLOW_21_in_genbankImportStatement5672); 
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
    // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3014:1: pigeonStatement[boolean defer] : 'pigeon' '(' idToken= ID ')' ;
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
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3015:2: ( 'pigeon' '(' idToken= ID ')' )
            // /Users/ernstl/PostDoc/BU/Eugene/v2.0/workspace/eugene-playground/grammar/Eugene.g:3015:4: 'pigeon' '(' idToken= ID ')'
            {
            root_0 = (Object)adaptor.nil();


            string_literal329=(Token)match(input,100,FOLLOW_100_in_pigeonStatement5688); 
            string_literal329_tree = 
            (Object)adaptor.create(string_literal329)
            ;
            adaptor.addChild(root_0, string_literal329_tree);


            char_literal330=(Token)match(input,20,FOLLOW_20_in_pigeonStatement5690); 
            char_literal330_tree = 
            (Object)adaptor.create(char_literal330)
            ;
            adaptor.addChild(root_0, char_literal330_tree);


            idToken=(Token)match(input,ID,FOLLOW_ID_in_pigeonStatement5694); 
            idToken_tree = 
            (Object)adaptor.create(idToken)
            ;
            adaptor.addChild(root_0, idToken_tree);


            char_literal331=(Token)match(input,21,FOLLOW_21_in_pigeonStatement5696); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_eugeneStatement_in_prog56 = new BitSet(new long[]{0x0121A20100001800L,0x000186FC361406E2L});
    public static final BitSet FOLLOW_EOF_in_prog59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_eugeneStatement70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_eugeneStatement78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_statement117 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importStatement_in_statement124 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataExtraction_in_statement132 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarationStatement_in_statement142 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computationalStatement_in_statement152 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_printStatement_in_statement160 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertStatement_in_statement174 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_noteStatement_in_statement184 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wrappedStatement_in_statement194 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loopStatement_in_statement208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statement216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saveStatement_in_statement224 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_statement227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_computationalStatement240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_computationalStatement248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectAssignmentStatement_in_computationalStatement258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_assignment283 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_assignment287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_assignment296 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_functionCall_in_assignment300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_assignment315 = new BitSet(new long[]{0x0020000000000800L,0x0000008800000400L});
    public static final BitSet FOLLOW_wrappedStatement_in_assignment319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_assignment334 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_assignment336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_assignment350 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_assignment352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_importStatement370 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_importStatement374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filename_in_listOfFilenames393 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfFilenames397 = new BitSet(new long[]{0xFFFFFFFEFFEFFFF0L,0x000FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_listOfFilenames_in_listOfFilenames399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_filename421 = new BitSet(new long[]{0xFFFFFFFEFEEFFFF2L,0x000FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_collectionDeclaration_in_declarationStatement455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_declarationStatement461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_declarationStatement467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_declarationStatement473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_declarationStatement479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayDeclaration_in_declarationStatement485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_declarationStatement491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_imageDeclaration_in_declarationStatement497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceTypeDeclaration_in_declarationStatement503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationDeclaration_in_declarationStatement510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_collectionDeclaration533 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_collectionDeclaration537 = new BitSet(new long[]{0x0000000802900002L});
    public static final BitSet FOLLOW_collectionDefinition_in_collectionDeclaration547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_collectionDeclaration560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_collectionDefinition608 = new BitSet(new long[]{0x0000800000000800L,0x00000000000000E0L});
    public static final BitSet FOLLOW_listOfCollectionComponents_in_collectionDefinition615 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_collectionDefinition621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_collectionDefinition628 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_INCLUDE_in_collectionDefinition632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionElement_in_listOfCollectionComponents678 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfCollectionComponents684 = new BitSet(new long[]{0x0000800000000800L,0x00000000000000E0L});
    public static final BitSet FOLLOW_listOfCollectionComponents_in_listOfCollectionComponents688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_collectionElement726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_collectionElement734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_collectionElement751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_collectionElement761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_collectionElement778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_propertyDeclaration801 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_dynamicNaming_in_propertyDeclaration805 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_propertyDeclaration808 = new BitSet(new long[]{0x0000000000000000L,0x0000800400040000L});
    public static final BitSet FOLLOW_propertyType_in_propertyDeclaration812 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_propertyDeclaration814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_propertyType833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_propertyType838 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_propertyType840 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_propertyType842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_propertyType847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_propertyType852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_propertyType854 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_propertyType856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_propertyType861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyType_in_variableDeclaration885 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfVariables_in_variableDeclaration889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfVariables917 = new BitSet(new long[]{0x0000000803800002L});
    public static final BitSet FOLLOW_assignment_in_listOfVariables929 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfVariables938 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfVariables_in_listOfVariables942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_partTypeDeclaration975 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_partTypeDeclaration984 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_partTypeDeclaration987 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_listOfIDs_in_partTypeDeclaration992 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_partTypeDeclaration997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_partTypeDeclaration1013 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_partTypeDeclaration1021 = new BitSet(new long[]{0x0000000802800000L});
    public static final BitSet FOLLOW_assignment_in_partTypeDeclaration1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfIDs1059 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfIDs1065 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_listOfIDs1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_deviceDeclaration1100 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_deviceDeclaration1104 = new BitSet(new long[]{0x0000000802900002L});
    public static final BitSet FOLLOW_20_in_deviceDeclaration1110 = new BitSet(new long[]{0x0000800002B0AA00L,0x00004000008080E0L});
    public static final BitSet FOLLOW_deviceComponents_in_deviceDeclaration1115 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceDeclaration1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_deviceDeclaration1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_deviceComponents1184 = new BitSet(new long[]{0x000080000210AA00L,0x00004000008080E0L});
    public static final BitSet FOLLOW_expressionValue_in_deviceComponents1198 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_partTypeDeclaration_in_deviceComponents1209 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_instantiationStatement_in_deviceComponents1219 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_propertyDeclaration_in_deviceComponents1229 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_deviceDeclaration_in_deviceComponents1239 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_deviceComponents1249 = new BitSet(new long[]{0x000080000290AA00L,0x00004000008080E0L});
    public static final BitSet FOLLOW_deviceComponents_in_deviceComponents1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_deviceTypeDeclaration1279 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_deviceTypeDeclaration1283 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceTypeDeclaration1285 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_deviceTypeDeclaration1289 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceTypeDeclaration1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayType_in_arrayDeclaration1327 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_arrayDeclaration1331 = new BitSet(new long[]{0x0000000802800002L});
    public static final BitSet FOLLOW_assignment_in_arrayDeclaration1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_arrayType1360 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1362 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_arrayType1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_arrayType1369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1371 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_arrayType1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_arrayType1378 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1380 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_arrayType1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_arrayType1387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1389 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_arrayType1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_arrayType1396 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1398 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_arrayType1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arrayType1405 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_arrayType1407 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_arrayType1409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleDeclaration1425 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_ruleDeclaration1429 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleDeclaration1431 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B915L});
    public static final BitSet FOLLOW_onDevice_in_ruleDeclaration1441 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_ruleDeclaration1452 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclaration1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_onDevice1495 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_onDevice1499 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_onDevice1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_folExpression1545 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_folExpression1550 = new BitSet(new long[]{0x0008000080000000L});
    public static final BitSet FOLLOW_51_in_folExpression1555 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_folExpression1560 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_folExpression1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_folExpression1572 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_folExpression1577 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_folExpression1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_imageDeclaration1606 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_imageDeclaration1608 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_imageDeclaration1612 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_imageDeclaration1614 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_imageDeclaration1618 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_imageDeclaration1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_relationDeclaration1638 = new BitSet(new long[]{0x0440480000000000L,0x0000000000000110L});
    public static final BitSet FOLLOW_pairingType_in_relationDeclaration1642 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_relationDeclaration1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_assertStatement1711 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_assertStatement1713 = new BitSet(new long[]{0x0000000000200800L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_assertStatement1716 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_assertStatement1720 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_assertStatement1723 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_listOfIDs_in_assertStatement1729 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_assertStatement1733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_noteStatement1766 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_noteStatement1768 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B915L});
    public static final BitSet FOLLOW_onDevice_in_noteStatement1776 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_noteStatement1787 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_noteStatement1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_instantiationStatement1829 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_instanceDefinitionStatement_in_instantiationStatement1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_partInstantiation_in_instanceDefinitionStatement1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceInstantiation_in_instanceDefinitionStatement1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_dynamicNaming1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DYNAMIC_NAME_in_dynamicNaming1909 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_dynamicNaming1913 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_DYNAMIC_NAME_in_dynamicNaming1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dynamicNaming_in_partInstantiation1946 = new BitSet(new long[]{0x0000000802900002L});
    public static final BitSet FOLLOW_20_in_partInstantiation1951 = new BitSet(new long[]{0xFE5E5CF60634AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_listOfDotValues_in_partInstantiation1956 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_listOfValues_in_partInstantiation1963 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_partInstantiation1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_partInstantiation1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_deviceInstantiation2013 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_deviceInstantiation2016 = new BitSet(new long[]{0x0000000000200800L});
    public static final BitSet FOLLOW_listOfIDs_in_deviceInstantiation2021 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceInstantiation2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_listOfDotValues2064 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfDotValues2068 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_listOfDotValues2070 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_listOfDotValues2074 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_listOfDotValues2077 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfDotValues2083 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_listOfDotValues_in_listOfDotValues2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfValues2128 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfValues2134 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_listOfValues_in_listOfValues2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfExpressions2170 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfExpressions2177 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_listOfExpressions_in_listOfExpressions2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notExpression_in_expression2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_notExpression2252 = new BitSet(new long[]{0xDE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_orExpression_in_notExpression2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpression_in_notExpression2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpression_in_orExpression2310 = new BitSet(new long[]{0x0000000000000002L,0x0004000000000008L});
    public static final BitSet FOLLOW_67_in_orExpression2326 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_114_in_orExpression2328 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_notExpression_in_orExpression2333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xorExpression_in_andExpression2382 = new BitSet(new long[]{0x0000010000080002L});
    public static final BitSet FOLLOW_40_in_andExpression2398 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_19_in_andExpression2400 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_notExpression_in_andExpression2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparativeExpression_in_xorExpression2455 = new BitSet(new long[]{0x0000000000000002L,0x0000000000024000L});
    public static final BitSet FOLLOW_78_in_xorExpression2471 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_81_in_xorExpression2473 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_notExpression_in_xorExpression2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationalOperator_in_operator2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_operator2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pairingType_in_operator2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOperator2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOperator2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleOperator2576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOperator2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleOperator2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleOperator2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleOperator2604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleOperator2611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOperator2618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleOperator2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleOperator2632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleOperator2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relationalOperator2657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relationalOperator2670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_relationalOperator2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_relationalOperator2691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_relationalOperator2698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_relationalOperator2706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_folExpression_in_comparativeExpression2733 = new BitSet(new long[]{0xDE465CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_addExpression_in_comparativeExpression2758 = new BitSet(new long[]{0xDEC65CF600040002L,0x0000000040003911L});
    public static final BitSet FOLLOW_operator_in_comparativeExpression2778 = new BitSet(new long[]{0xDE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_comparativeExpression_in_comparativeExpression2782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_comparativeExpression2805 = new BitSet(new long[]{0x0000A00000000800L,0x00008004000400A0L});
    public static final BitSet FOLLOW_94_in_comparativeExpression2807 = new BitSet(new long[]{0x0000A00000000800L,0x00008004000400A0L});
    public static final BitSet FOLLOW_type_in_comparativeExpression2812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_in_comparativeExpression2836 = new BitSet(new long[]{0x000000000210AA00L,0x0000400000808000L});
    public static final BitSet FOLLOW_addExpression_in_comparativeExpression2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subtractExpression_in_addExpression2889 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_addExpression2905 = new BitSet(new long[]{0x000000000210AA00L,0x0000400000808000L});
    public static final BitSet FOLLOW_addExpression_in_addExpression2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_subtractExpression2957 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_subtractExpression2972 = new BitSet(new long[]{0x000000000210AA00L,0x0000400000808000L});
    public static final BitSet FOLLOW_subtractExpression_in_subtractExpression2976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionValue_in_multiplicativeExpression3027 = new BitSet(new long[]{0x0000000040400002L});
    public static final BitSet FOLLOW_22_in_multiplicativeExpression3055 = new BitSet(new long[]{0x000000000210AA00L,0x0000400000808000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_multiplicativeExpression3059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_multiplicativeExpression3084 = new BitSet(new long[]{0x000000000210AA00L,0x0000400000808000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_multiplicativeExpression3088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_expressionValue3132 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_set_in_expressionValue3138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_expressionValue3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_expressionValue3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectAccessStatement_in_expressionValue3186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_expressionValue3200 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_expressionValue3204 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_expressionValue3207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_expressionValue3231 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_listOfExpressions_in_expressionValue3235 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_expressionValue3238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_objectAccessStatement3276 = new BitSet(new long[]{0x0000000004000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_objectAccess_in_objectAccessStatement3292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayAccess_in_objectAccess3327 = new BitSet(new long[]{0x0000000004000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_access_in_objectAccess3345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotAccess_in_objectAccess3375 = new BitSet(new long[]{0x0000000004000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_access_in_objectAccess3395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectAccess_in_access3436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_arrayAccess3460 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_arrayAccess3464 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_arrayAccess3467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3505 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_dotAccess3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3529 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_dotAccess3531 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_dotAccess3534 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3555 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_dotAccess3559 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_dotAccess3561 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_dotAccess3565 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3588 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_dotAccess3592 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_dotAccess3595 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3616 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_dotAccess3620 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_dotAccess3623 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_dotAccess3644 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_dotAccess3646 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_dotAccess3648 = new BitSet(new long[]{0xFE5E5CF60234AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_dotAccess3653 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_dotAccess3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_objectAssignmentStatement3712 = new BitSet(new long[]{0x0000000806800000L,0x0000000000008000L});
    public static final BitSet FOLLOW_26_in_objectAssignmentStatement3730 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_objectAssignmentStatement3734 = new BitSet(new long[]{0x0000000806800000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_objectAssignmentStatement3756 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_objectAssignmentStatement3762 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_objectAssignmentStatement3765 = new BitSet(new long[]{0x0000000806800000L,0x0000000000008000L});
    public static final BitSet FOLLOW_assignment_in_objectAssignmentStatement3795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_listOfStatements3829 = new BitSet(new long[]{0x0121A20100001802L,0x000186FC321406E2L});
    public static final BitSet FOLLOW_105_in_returnStatement3859 = new BitSet(new long[]{0xFE7E5CF70214AA00L,0x000040880080BD11L});
    public static final BitSet FOLLOW_expression_in_returnStatement3869 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_functionCall_in_returnStatement3879 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_wrappedStatement_in_returnStatement3889 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_returnStatement3896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_saveStatement3913 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_saveStatement3915 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_listOfSaveObjects_in_saveStatement3917 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_saveStatement3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfSaveObjects3936 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_listOfSaveObjects3938 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_listOfSaveObjects3944 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfSaveObjects3950 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_listOfSaveObjects_in_listOfSaveObjects3952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ifStatement3992 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ifStatement3994 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B915L});
    public static final BitSet FOLLOW_ifCondition_in_ifStatement3998 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifStatement4001 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_ifStatement4003 = new BitSet(new long[]{0x0121A20100001800L,0x000186FC321406E2L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement4007 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_ifStatement4010 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_ifStatement4031 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_ifStatement4033 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ifStatement4035 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B915L});
    public static final BitSet FOLLOW_ifCondition_in_ifStatement4039 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ifStatement4042 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_ifStatement4044 = new BitSet(new long[]{0x0121A20100001800L,0x000186FC321406E2L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement4048 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_ifStatement4051 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_ifStatement4060 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_ifStatement4062 = new BitSet(new long[]{0x0121A20100001800L,0x000186FC321406E2L});
    public static final BitSet FOLLOW_listOfStatements_in_ifStatement4066 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_ifStatement4069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_onDevice_in_ifCondition4108 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_ifCondition4115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_loopStatement4155 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_loopStatement4157 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x0000C0040084B911L});
    public static final BitSet FOLLOW_forInit_in_loopStatement4161 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_loopStatement4164 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_loopStatement4175 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_loopStatement4178 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_computationalStatement_in_loopStatement4189 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement4192 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_loopStatement4194 = new BitSet(new long[]{0x0121A20100001800L,0x000186FC321406E2L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement4206 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_loopStatement4209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_loopStatement4216 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_loopStatement4218 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_loopStatement4222 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement4225 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_loopStatement4227 = new BitSet(new long[]{0x0121A20100001800L,0x000186FC321406E2L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement4231 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_loopStatement4234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_loopStatement4241 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_loopStatement4243 = new BitSet(new long[]{0x0121A20100001800L,0x000186FC321406E2L});
    public static final BitSet FOLLOW_listOfStatements_in_loopStatement4247 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_loopStatement4250 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_loopStatement4252 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_loopStatement4254 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_loopStatement4258 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loopStatement4261 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_loopStatement4262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_forInit4290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listOfExpressions_in_forInit4300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_functionDeclaration4325 = new BitSet(new long[]{0x0000A00000000800L,0x00008004000400A0L});
    public static final BitSet FOLLOW_type_in_functionDeclaration4330 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_functionDeclaration4336 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_functionDeclaration4340 = new BitSet(new long[]{0x0000A00000200800L,0x00008004000400A0L});
    public static final BitSet FOLLOW_listOfFunctionParamenters_in_functionDeclaration4345 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionDeclaration4349 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_functionDeclaration4351 = new BitSet(new long[]{0x0121A20100001800L,0x000186FC321406E2L});
    public static final BitSet FOLLOW_listOfStatements_in_functionDeclaration4359 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_functionDeclaration4364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_type4387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_type4394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4396 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_type4398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_type4405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_type4412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4414 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_type4416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_type4423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_type4432 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4434 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_type4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_type4445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_type4452 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4454 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_type4456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_type4463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_type4470 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4472 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_type4474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_type4481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_type4488 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_type4490 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_type4492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_type4499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_type4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_listOfFunctionParamenters4530 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfFunctionParamenters4534 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfFunctionParamenters4539 = new BitSet(new long[]{0x0000A00000000800L,0x00008004000400A0L});
    public static final BitSet FOLLOW_listOfFunctionParamenters_in_listOfFunctionParamenters4543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_functionCall4568 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_functionCall4570 = new BitSet(new long[]{0xFE5E5CF60234AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_listOfParameterValues_in_functionCall4575 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_functionCall4580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_listOfParameterValues4612 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfParameterValues4619 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_listOfParameterValues_in_listOfParameterValues4623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_in_wrappedStatement4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_combinatorialFunction_in_wrappedStatement4663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_get_in_wrappedStatement4673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_size_in_wrappedStatement4683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remove_in_wrappedStatement4693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_toSequence_in_wrappedStatement4702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolStatement_in_wrappedStatement4712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankStatement_in_wrappedStatement4722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deviceDepthStatements_in_wrappedStatement4738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_deviceDepthStatements4769 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_deviceDepthStatements4771 = new BitSet(new long[]{0x0000000000000000L,0x0000000200080000L});
    public static final BitSet FOLLOW_83_in_deviceDepthStatements4778 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceDepthStatements4780 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_deviceDepthStatements4784 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceDepthStatements4787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_deviceDepthStatements4795 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_deviceDepthStatements4797 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_deviceDepthStatements4799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_add4823 = new BitSet(new long[]{0x0000000038000000L});
    public static final BitSet FOLLOW_27_in_add4830 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_add4832 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_listOfExpressions_in_add4836 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_add4839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_add4847 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_add4849 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_add4853 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_add4855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_add4862 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_add4864 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_listOfIDs_in_add4868 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_add4871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_toSequence4902 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_toSequence4904 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_toSequence4906 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_toSequence4908 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_toSequence4910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_get4936 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_get4938 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_get4940 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_get4942 = new BitSet(new long[]{0x000000000000A800L});
    public static final BitSet FOLLOW_INT_in_get4947 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_get4955 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_STRING_in_get4963 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_get4968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_size5001 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_size5003 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_size5005 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_size5007 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_size5009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_remove5039 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_remove5041 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_remove5043 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_remove5045 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_remove5049 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_remove5052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_listOfRules5098 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_listOfRules5103 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_listOfRules5107 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_set_in_combinatorialFunction5140 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_combinatorialFunction5146 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_combinatorialFunction5158 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_combinatorialFunction5184 = new BitSet(new long[]{0x0000000000000000L,0x0000100001000000L});
    public static final BitSet FOLLOW_set_in_combinatorialFunction5188 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_combinatorialFunction5213 = new BitSet(new long[]{0xFE5E5CF60334AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_combinatorialFunction5218 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_combinatorialFunction5235 = new BitSet(new long[]{0xFE5E5CF60234AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_combinatorialFunction5240 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_combinatorialFunction5247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_getObject5279 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_getObject5283 = new BitSet(new long[]{0x0000000004000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_getObject5289 = new BitSet(new long[]{0xFE5E5CF60214AA00L,0x000040000080B911L});
    public static final BitSet FOLLOW_expression_in_getObject5293 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_getObject5296 = new BitSet(new long[]{0x0000000004000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_102_in_printStatement5339 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_printStatement5341 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_printStatement5343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_printStatement5357 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_printStatement5359 = new BitSet(new long[]{0xFE7E5CF60214AA00L,0x000040880080BD11L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5363 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_printStatement5369 = new BitSet(new long[]{0xFE7E5CF60214AA00L,0x000040880080BD11L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5373 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_21_in_printStatement5380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_printStatement5392 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_printStatement5394 = new BitSet(new long[]{0xFE7E5CF60214AA00L,0x000040880080BD11L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5398 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_24_in_printStatement5404 = new BitSet(new long[]{0xFE7E5CF60214AA00L,0x000040880080BD11L});
    public static final BitSet FOLLOW_whatToPrint_in_printStatement5408 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_21_in_printStatement5415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_whatToPrint5436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wrappedStatement_in_whatToPrint5446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolStatement_in_dataExtraction5464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankStatement_in_dataExtraction5470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pigeonStatement_in_dataExtraction5476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_sbolStatement5496 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sbolStatement5498 = new BitSet(new long[]{0x0000000000000000L,0x0000000020400000L});
    public static final BitSet FOLLOW_sbolExportStatement_in_sbolStatement5501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sbolImportStatement_in_sbolStatement5508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_sbolExportStatement5525 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_sbolExportStatement5527 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_sbolExportStatement5531 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_sbolExportStatement5533 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_sbolExportStatement5537 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_sbolExportStatement5539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_sbolImportStatement5568 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_sbolImportStatement5570 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_sbolImportStatement5574 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_sbolImportStatement5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_genbankStatement5602 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_genbankStatement5604 = new BitSet(new long[]{0x0000000000000000L,0x0000000020400000L});
    public static final BitSet FOLLOW_genbankImportStatement_in_genbankStatement5609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_genbankExportStatement_in_genbankStatement5614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_genbankExportStatement5637 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_genbankExportStatement5639 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_genbankExportStatement5641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_genbankImportStatement5658 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_genbankImportStatement5660 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_genbankImportStatement5664 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_genbankImportStatement5666 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_genbankImportStatement5670 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_genbankImportStatement5672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_pigeonStatement5688 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_pigeonStatement5690 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_pigeonStatement5694 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_pigeonStatement5696 = new BitSet(new long[]{0x0000000000000002L});

}