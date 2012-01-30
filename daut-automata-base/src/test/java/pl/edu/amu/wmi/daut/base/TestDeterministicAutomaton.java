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
        
        
        	test.addLoop(q0, new CharTransitionLabel('1'));
        	test.addTransition(q0, q1, new CharTransitionLabel('0'));
        	test.addTransition(q1, q2, new CharTransitionLabel('0'));
        	test.addTransition(q2, q0, new CharTransitionLabel('0'));
                
        	test.addLoop(q1, new CharTransitionLabel('1'));
        	test.addLoop(q2, new CharTransitionLabel('1'));
                
			
        
        	test.markAsInitial(q0);
        	test.markAsFinal(q0);
                
/**
 * at -> automaton test
 */

		final AutomatonByRecursion at = new AutomatonByRecursion(test);
        	assertTrue(automaton.accepts("111"));
                assertTrue(automaton.accepts("000"));
        	assertTrue(automaton.accepts("1000"));
        	assertTrue(automaton.accepts("0001"));
        	assertTrue(automaton.accepts("0100"));
        	assertTrue(automaton.accepts("010101"));
		assertTrue(automaton.accepts("1010010001"));
        	assertFalse(automaton.accepts("001201"));
        	assertFalse(automaton.accepts("0000"));
        	assertFalse(automaton.accepts("00010101010"));
        	assertFalse(automaton.accepts(""));
        	assertFalse(automaton.accepts("bdaasrweewrgsdf"));
        	assertFalse(automaton.accepts("&%*$&##@!"));
        
    	}
}