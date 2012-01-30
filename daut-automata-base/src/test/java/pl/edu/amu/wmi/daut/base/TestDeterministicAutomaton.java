package pl.edu.amu.wmi.daut.base;

import junit.framework.TestCase;


/** Test metody accepts klasy DeterministicAutomaton akceptujący słowa 
 * z dowolną liczbą "1" oraz liczbą "0" podzielną przez "3"
 * 
 *  @author Aleksandra
 */
public class TestDeterministicAutomaton extends TestCase {
/**
 *  test -> simple test
 */
	public final void testAutomatonAcceptingThreeZeros() {
                final DeterministicAutomatonSpecification test = new NaiveDeterministicAutomatonSpecification();
        	State q0 = test.addState();
        	State q1 = test.addState();
        	State q2 = test.addState();
                State q3 = test.addState();
        
        
        	test.addLoop(q0, new CharTransitionLabel('1'));
        	test.addTransition(q0, q1, new CharTransitionLabel('0'));
        	test.addTransition(q1, q2, new CharTransitionLabel('0'));
        	test.addTransition(q2, q0, new CharTransitionLabel('0'));
                test.addTransition(q3, q1, new CharTransitionLabel('0'));
        	test.addLoop(q1, new CharTransitionLabel('1'));
        	test.addLoop(q2, new CharTransitionLabel('1'));
                test.addLoop(q3, new CharTransitionLabel('1'));
                
			
        
        	test.markAsInitial(q0);
        	test.markAsFinal(q3);
                
/**
 * at -> automaton test
 */

		final AutomatonByRecursion at = new AutomatonByRecursion(test);
                assertTrue(at.accepts("000"));
        	assertTrue(at.accepts("1000"));
        	assertTrue(at.accepts("0001"));
        	assertTrue(at.accepts("0100"));
        	assertTrue(at.accepts("010101"));
		assertTrue(at.accepts("1010010001"));
        	assertFalse(at.accepts("001201"));
        	assertFalse(at.accepts("0000"));
        	assertFalse(at.accepts("00010101010"));
        	assertFalse(at.accepts(""));
        	assertFalse(at.accepts("bdaasrweewrgsdf"));
        	assertFalse(at.accepts("&%*$&##@!"));
        
    	}
}