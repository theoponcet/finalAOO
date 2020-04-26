package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Document;
import main.Job;
import main.Printer;

class PrinterTest {
	
	private static Printer printer;
	private static Job aJob;
	private static Document document;
	
	@BeforeEach
	void setUp() {
		printer = new Printer();
		printer.setName("myPrinter");
		document = new Document();
		aJob = new Job(document);
		
	}
	
	@AfterEach
	void tearDown() {
		printer=null;
	}

	@Test
	void StartTest() {
		System.out.println("ca passe");
		assertTrue(printer.start(printer));
		System.out.println("ca passe2");

		printer.start(printer);
		System.out.println("ca passe3");
		
		assertTrue(printer.start(printer));
	}
	
	@Test
	void StopTest() {
		assertFalse(printer.stop());
		printer.start(printer);
		assertTrue(printer.stop());
		printer.stop();
		assertFalse(printer.stop());
	}
	
	@Test
	void PrintTest() {
		assertFalse(printer.print(aJob));
		printer.start(printer);
		assertTrue(printer.print(aJob));
		printer.print(aJob);
		assertFalse(printer.print(aJob));
		printer.setCurrentJob(null);
		assertTrue(printer.print(aJob));
	}
	
	@Test
	void PrintingCompletedTest() {
		assertFalse(printer.printingCompleted());
		printer.start(printer);
		assertFalse(printer.printingCompleted());
		printer.print(aJob);
		assertTrue(printer.printingCompleted());
		printer.printingCompleted();
		assertFalse(printer.printingCompleted());
	}
	
	@Test
	void isAvailableTest() {
		assertFalse(printer.isAvailable());
		printer.start(printer);
		assertTrue(printer.isAvailable());
		printer.print(aJob);
		assertFalse(printer.isAvailable());
		printer.printingCompleted();
		assertTrue(printer.isAvailable());
		
	}
	
	@Test
	void isPrintingTest() {
		assertFalse(printer.isPrinting());
		printer.start(printer);
		printer.print(aJob);
		assertTrue(printer.isPrinting());
		printer.printingCompleted();
		assertFalse(printer.isPrinting());
	}

}
