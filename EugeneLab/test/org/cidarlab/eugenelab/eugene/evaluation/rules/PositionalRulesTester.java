package org.cidarlab.eugenelab.eugene.evaluation.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

import org.cidarlab.eugene.algorithm.Product;
import org.cidarlab.eugene.builder.EugeneBuilder;
import org.cidarlab.eugene.cache.SymbolTables;
import org.cidarlab.eugene.dom.components.Component;
import org.cidarlab.eugene.dom.components.Device;
import org.cidarlab.eugene.dom.components.types.PartType;
import org.cidarlab.eugene.dom.rules.Rule;
import org.cidarlab.eugene.exception.EugeneException;
import org.cidarlab.eugene.rules.tree.predicate.Contains;
import org.cidarlab.eugene.rules.tree.predicate.Exactly;
import org.cidarlab.eugene.rules.tree.predicate.Predicate;
import org.cidarlab.eugene.dom.arrays.*;
import org.cidarlab.eugene.rules.tree.predicate.LogicalNot;
import org.cidarlab.eugene.rules.tree.predicate.MoreThan;

public class PositionalRulesTester {

        private static final int MAX_N = 7;
        
        private PartType partType;
        
        public PositionalRulesTester() {

                /*
                 * Turn off Eugene logging
                 */
                LogManager.getLogManager().reset();
                
                /*
                 * create a part type
                 */
                partType = EugeneBuilder.buildPartType("part-type", null);

        }
        
        public boolean testExactly() 
                        throws EugeneException {
                
                
                boolean bCorrect = true;
                for(int n=1; n<=MAX_N && bCorrect; n++) {

                        /*
                         * x == 0
                         */
//                        System.out.println("*** n: "+n+", k: "+k+", x: "+0+" ***");
//                        System.out.println((long)Math.pow(k, n));
                        
                        /*
                         * currently keeping k constant
                         */
                        
                        /*
                         * x ... appearance of part part-1
                         */                        
                        for(int x=1; x<=n; x++) {

                                /*
                                 * TODO: Ernst needs to improve the symbol tables start-up and clean-up
                                 */
                                SymbolTables.init();
                                
                                /*
                                 * currently, k needs to be <= n
                                 * TODO: we need to scale k too ...
                                 * 
                                 */
                                int k = n;                
                                createParts(k);
                                Device d = createDevice(n);
                                
                                System.out.println("*** n: "+n+", k: "+k+", x: "+x+" ***");
                                /*
                                 * impose constraints
                                 */
                                createExactlyRule(d, "part-1", x);
                                //System.out.println("part-1 EXACTLY "+x);

                                
                                long NR_OF_GENERATED_DEVICES = ((GeneratedDeviceArray)Product.product(d.getName(), -1)).size();
                                long NR_OF_DEVICES = calculateExactly(n, k, x);        
                                
                                if(NR_OF_GENERATED_DEVICES != NR_OF_DEVICES) {
                                        bCorrect = false;
                                        break;
                                }
                                
                                SymbolTables.cleanUp();
                        }
                }
                
                return bCorrect;
        }
        
        public boolean testMoreThan() throws EugeneException {
            boolean bCorrect = true;
                for(int n=1; n<=MAX_N && bCorrect; n++) {

                        /*
                         * x == 0
                         */
//                        System.out.println("*** n: "+n+", k: "+k+", x: "+0+" ***");
//                        System.out.println((long)Math.pow(k, n));
                        
                        /*
                         * currently keeping k constant
                         */
                        
                        /*
                         * x ... appearance of part part-1
                         */                        
                        for(int x=1; x<=n; x++) {

                                /*
                                 * TODO: Ernst needs to improve the symbol tables start-up and clean-up
                                 */
                                SymbolTables.init();
                                
                                /*
                                 * currently, k needs to be <= n
                                 * TODO: we need to scale k too ...
                                 * 
                                 */
                                int k = n;                
                                createParts(k);
                                Device d = createDevice(n);
                                
                                System.out.println("*** n: "+n+", k: "+k+", x: "+x+" ***");
                                /*
                                 * impose constraints
                                 */
                                createMoreThanRule(d, "part-1", x);
                                //System.out.println("part-1 EXACTLY "+x);

                                System.out.println(d);
                                System.out.println((GeneratedDeviceArray)Product.product(d.getName(), -1));
                                long NR_OF_GENERATED_DEVICES = ((GeneratedDeviceArray)Product.product(d.getName(), -1)).size();
                                long NR_OF_DEVICES = calculateMoreThan(n, k, x);        
                                
                                if(NR_OF_GENERATED_DEVICES != NR_OF_DEVICES) {
                                        bCorrect = false;
                                        break;
                                }
                                
                                SymbolTables.cleanUp();
                        }
                }
                
                return bCorrect;
        }
        
        public boolean testNotMoreThan() throws EugeneException {
            boolean bCorrect = true;
                for(int n=1; n<=MAX_N && bCorrect; n++) {

                        /*
                         * x == 0
                         */
//                        System.out.println("*** n: "+n+", k: "+k+", x: "+0+" ***");
//                        System.out.println((long)Math.pow(k, n));
                        
                        /*
                         * currently keeping k constant
                         */
                        
                        /*
                         * x ... appearance of part part-1
                         */                        
                        for(int x=1; x<=n; x++) {

                                /*
                                 * TODO: Ernst needs to improve the symbol tables start-up and clean-up
                                 */
                                SymbolTables.init();
                                
                                /*
                                 * currently, k needs to be <= n
                                 * TODO: we need to scale k too ...
                                 * 
                                 */
                                int k = n;                
                                createParts(k);
                                Device d = createDevice(n);
                                
                                System.out.println("*** n: "+n+", k: "+k+", x: "+x+" ***");
                                /*
                                 * impose constraints
                                 */
                                createNotMoreThanRule(d, "part-1", x);
                                //System.out.println("part-1 EXACTLY "+x);

                                //System.out.println(d);
                                //System.out.println((GeneratedDeviceArray)Product.product(d.getName(), -1));
                                long NR_OF_GENERATED_DEVICES = ((GeneratedDeviceArray)Product.product(d.getName(), -1)).size();
                                long NR_OF_DEVICES = calculateNotMoreThan(n, k, x);        
                                
                                if(NR_OF_GENERATED_DEVICES != NR_OF_DEVICES) {
                                        bCorrect = false;
                                        break;
                                }
                                
                                SymbolTables.cleanUp();
                        }
                }
                
                return bCorrect;
        }
        
        public boolean testContains() throws EugeneException {
            boolean bCorrect = true;
                for(int n=1; n<=MAX_N && bCorrect; n++) {

                        /*
                         * x == 0
                         */
//                        System.out.println("*** n: "+n+", k: "+k+", x: "+0+" ***");
//                        System.out.println((long)Math.pow(k, n));
                        
                        /*
                         * currently keeping k constant
                         */
                        
                        /*
                         * x ... appearance of part part-1
                         */                        
                        for(int k=1; k<=n; k++) {

                                /*
                                 * TODO: Ernst needs to improve the symbol tables start-up and clean-up
                                 */
                                SymbolTables.init();
                                
                                /*
                                 * currently, k needs to be <= n
                                 * TODO: we need to scale k too ...
                                 * 
                                 */
                
                                createParts(k);
                                Device d = createDevice(n);
                                
                                System.out.println("*** n: "+n+", k: "+k+" ***");
                                /*
                                 * impose constraints
                                 */
                                createContainsRule(d, "part-1");
                                //System.out.println("part-1 EXACTLY "+x);

                                
                                long NR_OF_GENERATED_DEVICES = ((GeneratedDeviceArray)Product.product(d.getName(), -1)).size();
                                long NR_OF_DEVICES = calculateContains(n, k);        
                                
                                if(NR_OF_GENERATED_DEVICES != NR_OF_DEVICES) {
                                        bCorrect = false;
                                        break;
                                }
                                System.out.println(NR_OF_GENERATED_DEVICES);
                                
                                SymbolTables.cleanUp();
                        }
                }
                
                return bCorrect;
        }
        
        private void createExactlyRule(Device d, String partName, int x) 
                        throws EugeneException {
                
                Predicate exactly = new Exactly(SymbolTables.getId(partName), x);
                
                // now, let's assign the CONTAINS predicate 
                // to a rule
                
                Rule rule = new Rule(partName+"-EXACTLY-"+x, d, exactly);
                SymbolTables.put(rule);
        }
        
        private void createMoreThanRule(Device d, String partName, int x) throws EugeneException {
            
            Predicate moreThan = new MoreThan(SymbolTables.getId(partName), x);
            Rule rule = new Rule(partName+"-MORETHAN-"+x, d, moreThan);
            SymbolTables.put(rule);
        }
        
        private void createNotMoreThanRule(Device d, String partName, int x) throws EugeneException {
             Predicate notMoreThan = new LogicalNot(new MoreThan(SymbolTables.getId(partName), x));
             Rule rule = new Rule(partName+"-NOTMORETHAN-"+x, d, notMoreThan);
             SymbolTables.put(rule);
        }
        
        private void createContainsRule(Device d, String partName) throws EugeneException {
            
            Predicate contains = new Contains(SymbolTables.getId(partName));
            Rule rule = new Rule("CONTAINS-"+partName, d, contains);
            SymbolTables.put(rule);
            
        }
        
        private void createParts(int k) 
                        throws EugeneException {
                /*
                 * store k parts into the database
                 */
                for(int i=1; i<=k; i++) {
                        SymbolTables.put(
                                        EugeneBuilder.buildPart("part-"+i, null, this.partType));
                }
        }
        
        private Device createDevice(int n) 
                        throws EugeneException {
                List<Component> lst = new ArrayList<Component>(n);
                char[] directions = new char[n];
                for(int i=1; i<=n; i++) {
                        lst.add(this.partType);
                        directions[i-1] = '+';
                }
                
                Device d = EugeneBuilder.buildDevice("device-"+n, lst, directions);
                SymbolTables.put(d);
                return d;
        }
        
        private long calculateExactly(int n, int k, int x) {
                /*
                 * n            n-x
                 *     *  (k-1)
                 * x
                 */

                return (long)(choose(n, x) * Math.pow(k-1, n-x));
                
        }
        
        private long calculateNotMoreThan(int n, int k, int x) {
            long total = 0;
            for(int i = 0; i <= x; i++) {
                total += calculateExactly(n, k, i);
            }
            return total;
        }
        
        private long calculateMoreThan(int n, int k, int x) {
            long total = 0;
            for( int i = x + 1; i <= n; i++) {
                total += calculateExactly(n, k, i);
            }
            return total;
        }
        
        private long calculateTotal(int n, int k) {
            return (long)Math.pow(k, n);
        }
        
        private long calculateContains(int n, int k) {
            return calculateTotal(n, k) - calculateNotContains(n, k);
        }
        
        private long calculateNotContains(int n, int k) {
            return (long)(Math.pow(k-1, n));
        }
        
        private long choose(int n, int k) {
                return         fact(n) / (fact(k)*fact(n-k));

        }
        private long fact(int n) {
                if(n>=2) {
                        return n * fact(n-1);
                }
                return 1;
        }
        
        public static void main(String[] args) {
                PositionalRulesTester prt = new PositionalRulesTester();
                
                try {
                        /*if(prt.testExactly()) {
                                System.out.println("EXACTLY rule works...");
                        } else {
                                System.err.println("EXACTLY rule does NOT work...");
                        }*/
                        /*if(prt.testContains()) {
                            System.out.println("CONTAINS rule works...");
                        } else {
                            System.out.println("CONTAINS rule does NOT work...");
                        }*/
                        
                        /*if(prt.testMoreThan()) {
                            System.out.println("MORETHAN rule works...");
                        } else {
                            System.out.println("MORETHAN rule does NOT work...");
                        }*/
                        
                        if(prt.testNotMoreThan()) {
                            System.out.println("NOTMORETHAN rule works...");
                        } else {
                            System.out.println("NOTMORETHAN rule does NOT work...");
                        }
                } catch(Exception e) {
                        e.printStackTrace();
                }
                
                
        }

}
