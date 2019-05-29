package cn.edu.bjut.software.test.part2;

import static org.junit.Assert.*;

import cn.edu.bjut.software.test.part2.MetroSaleTicket;
import org.junit.Test;

public class MetroSaleTicketTest {

    @Test
    public void testOperation1() {
        MetroSaleTicket instance = new MetroSaleTicket();
        String result=instance.operation("TyoeA", "1yuan");
        String expect="Not enough money!";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation2() {
        MetroSaleTicket instance = new MetroSaleTicket();
        String result=instance.operation("TyoeB", "1yuan");
        String expect="Not enough money!";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation3() {
        MetroSaleTicket instance = new MetroSaleTicket();
        String result=instance.operation("TypeA", "5yuan");
        String expect="Input Information\n"+"Type:A;Money:2Yuan\n"+"Current State\n"+"1 Yuan:97";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation4() {
        MetroSaleTicket instance = new MetroSaleTicket();
        String result=instance.operation("TypeB", "5yuan");
        String expect="Input Information\n"+"Type:B;Money:4Yuan\n"+"Current State\n"+"1 Yuan:99";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation5() {
        MetroSaleTicket instance = new MetroSaleTicket();
        String result=instance.operation("TypeA", "10yuan");
        String expect="Input Information\n"+"Type:A;Money:2Yuan\n"+"Current State\n"+"1 Yuan:92";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation6() {
        MetroSaleTicket instance = new MetroSaleTicket();
        String result=instance.operation("TypeB", "10yuan");
        String expect="Input Information\n"+"Type:B;Money:4Yuan\n"+"Current State\n"+"1 Yuan:94";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation7() {
        MetroSaleTicket instance = new MetroSaleTicket(0);
        String result=instance.operation("TypeA", "5yuan");
        String expect="Not enough Change!";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation8() {
        MetroSaleTicket instance = new MetroSaleTicket(0);
        String result=instance.operation("TypeB", "5yuan");
        String expect="Not enough Change!";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation9() {
        MetroSaleTicket instance = new MetroSaleTicket(0);
        String result=instance.operation("TypeA", "10yuan");
        String expect="Not enough Change!";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation10() {
        MetroSaleTicket instance = new MetroSaleTicket(0);
        String result=instance.operation("TypeB", "10yuan");
        String expect="Not enough Change!";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation11() {
        MetroSaleTicket instance = new MetroSaleTicket();
        String result=instance.operation("TypeB", "3yuan");
        String expect="Failure Information\n"+"Money Error";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation12() {
        MetroSaleTicket instance = new MetroSaleTicket();
        String result=instance.operation("TypeC", "5yuan");
        String expect="Failure Information\n"+"Type Error";
        assertEquals(result,expect);
    }
    @Test
    public void testOperation13() {
        MetroSaleTicket instance = new MetroSaleTicket(0);
        instance.operation("TypeB", "1yuan");
        String result=instance.operation("TypeB", "1yuan");
        String expect="Not enough Money";
        assertEquals(result,expect);
    }
}
