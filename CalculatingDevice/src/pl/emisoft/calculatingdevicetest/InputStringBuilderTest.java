package pl.emisoft.calculatingdevicetest;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.emisoft.calculatingdevice.InputStringBuilder;

public class InputStringBuilderTest {
	
	@Test
	public void appendingDigitShouldAddSpecifiedCharToString() {
		InputStringBuilder testedBuilder = new InputStringBuilder(10); 
		
		assertTrue("4".equals(testedBuilder.appendToString('4')));
		assertTrue("40".equals(testedBuilder.appendToString('0')));
	}

	@Test
	public void appendingFirstDotShouldAddDotCharToString() {
		InputStringBuilder testedBuilder = new InputStringBuilder(10); 
		
		assertTrue(".".equals(testedBuilder.appendToString('.')));
		
		testedBuilder.clearString(); 
		testedBuilder.appendToString('4');
		assertTrue("4.".equals(testedBuilder.appendToString('.')));
	}
	
	@Test
	public void appendingSecondDotShouldNotChangeTheString() {
		InputStringBuilder testedBuilder = new InputStringBuilder(10); 
		
		testedBuilder.appendToString('4');
		testedBuilder.appendToString('.');
		testedBuilder.appendToString('5');
		assertTrue("4.5".equals(testedBuilder.appendToString('.')));
	}
	
	@Test
	public void appendingDigitOverTheLimitShouldNotChangeTheString() {
		InputStringBuilder testedBuilder = new InputStringBuilder(4);
		
		for (int i=0; i<4; i++) testedBuilder.appendToString('3');
		assertEquals("3333", testedBuilder.appendToString('4'));
	}
	
	@Test
	public void clearingTheStringShouldMakeTheStringEmpty() {
		InputStringBuilder testedBuilder = new InputStringBuilder(10);
		
		testedBuilder.appendToString('4');
		testedBuilder.appendToString('.');
		testedBuilder.appendToString('5');
		testedBuilder.clearString();
		assertEquals(testedBuilder.getInputString(), "");
	}
}
