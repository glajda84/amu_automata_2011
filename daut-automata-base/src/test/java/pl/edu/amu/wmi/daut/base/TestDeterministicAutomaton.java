package pl.edu.amu.wmi.daut.base;

import junit.framework.TestCase;


/** Test metody accepts klasy DeterministicAutomaton akceptujący słowa 
* z dowolną liczbą "1" oraz liczbą "0" podzielną przez "3"
*/
public class TestDeterministicAutomaton {

	public final void testAutomatonAcceptingThreeZeros() {
                final DeterministicAutomaton spec = new DeterministicAutomaton();
        	State q0 = spec.addState();
        	State q1 = spec.addState();
        	State q2 = spec.addState();
                State q3 = spec.addState();
        
        
        	spec.addLoop(q0, new CharTransitionLabel('1'));
        	spec.addTransition(q0, q1, new CharTransitionLabel('0'));
        	spec.addTransition(q1, q2, new CharTransitionLabel('0'));
        	spec.addTransition(q2, q3, new CharTransitionLabel('0'));
                spec.addTransition(q3, q1, new CharTransitionLabel('0'));
        	spec.addLoop(q1, new CharTransitionLabel('1'));
        	spec.addLoop(q2, new CharTransitionLabel('1'));
                spec.addLoop(q3, new CharTransitionLabel('1'));
			
        
        	spec.markAsInitial(q0);
        	spec.markAsFinal(q3);

		final DeterministicAutomaton automaton = new DeterministicAutomaton(spec);
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