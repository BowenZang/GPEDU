package org.example;

import static org.junit.Assert.assertTrue;

import org.example.visitor.BusinessReport;
import org.example.visitor.CEOVisitor;
import org.example.visitor.CTOVisitor;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void visitorTest() {
        BusinessReport report = new BusinessReport();
        System.out.println("============CEO============");
        report.showReport(new CEOVisitor());
        System.out.println("============CTO============");
        report.showReport(new CTOVisitor());
    }
}
