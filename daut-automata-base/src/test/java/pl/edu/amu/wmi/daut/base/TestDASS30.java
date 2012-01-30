package pl.edu.amu.wmi.daut.base;

import junit.framework.TestCase;

/**
* Test metody accepts klasy DeterministicAutomaton akceptuj¹cy s³owa 
* z dowoln¹ liczb¹ "1" oraz liczb¹ "0" podzieln¹ przez "3"
*/
public class TestDeterministicAutomaton {

	public final void testAutomatonAcceptingThreeZeros() {
        	DeterministicAutomatonSpecification sp = new NaiveDeterministicAutomatonSpecification();
        	State q0 = sp.addState();
        	State q1 = sp.addState();
        	State q2 = sp.addState();
			State q3 = sp.addState();
        
        
        	sp.addLoop(q0, new CharTransitionLabel('1'));
        	sp.addTransition(q0, q1, new CharTransitionLabel('0'));
        	sp.addTransition(q1, q2, new CharTransitionLabel('0'));
        	sp.addTransition(q2, q3, new CharTransitionLabel('0'));
			sp.addTransition(q3, q1, new CharTransitionLabel('0'));
        	sp.addLoop(q1, new CharTransitionLabel('1'));
        	sp.addLoop(q2, new CharTransitionLabel('1'));
			sp.addLoop(q3, new CharTransitionLabel('1'));
			
        
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