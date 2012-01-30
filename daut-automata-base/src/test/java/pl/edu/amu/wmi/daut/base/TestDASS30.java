package pl.edu.amu.wmi.daut.base;

import junit.framework.TestCase;


/* Test metody accepts klasy DeterministicAutomaton akceptujący słowa 
* z dowolną liczbą "1" oraz liczbą "0" podzielną przez "3"
*/
public class TestDASS30 {

	public final void testAutomatonAcceptingThreeZeros() {
                DeterministicAutomaton sp = new NaiveDeterministicAutomaton();
        	State q0 = sp.addState();
        	State q1 = sp.addState();
        	State q2 = sp.addState();
        
        
        	sp.addLoop(q0, new CharTransitionLabel('1'));
        	sp.addTransition(q0, q1, new CharTransitionLabel('0'));
        	sp.addTransition(q1, q2, new CharTransitionLabel('0'));
        	sp.addTransition(q2, q0, new CharTransitionLabel('0'));
        	sp.addLoop(q1, new CharTransitionLabel('1'));
        	sp.addLoop(q2, new CharTransitionLabel('1'));
			
        
        	sp.markAsInitial(q0);
        	sp.markAsFinal(q3);

		AutomatonByRecursion automaton = new AutomatonByRecursion(spec);
        	assertTrue(automaton.accepts("000"));
        	assertTrue(automaton.accepts("1000"));
        	assertTrue(automaton.accepts("0001"));
        	assertTrue(automaton.accepts("0100"));
        	assertTrue(automaton.accepts("010101"));
		assertTrue(automaton.accepts("1010010001"));
        	assertFalse(automaton.accepts("001012"));
        	assertFalse(automaton.accepts("0000"));
        	assertFalse(automaton.accepts("00010101010"));
        	assertFalse(automaton.accepts(""));
        	assertFalse(automaton.accepts("bdaasrweewrgsdf"));
        	assertFalse(automaton.accepts("&%*$&##@!"));
        
    	}
}