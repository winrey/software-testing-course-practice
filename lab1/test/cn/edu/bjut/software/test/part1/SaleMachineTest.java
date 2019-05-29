package cn.edu.bjut.software.test.part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SaleMachineTest {

    @Test
    public void testOperation1() {
        SaleMachine saleMachine = new SaleMachine();
        String expect = "Input Information\nType: Beer;  Money: 5 Cents;  Change: 0\n\nCurrent State\nBeer:5\nOrange Juice:6\n5 Cents:7\n1 Dollar:6";
        assertEquals(expect, saleMachine.operation("Beer", "5C"));
    }

    @Test
    public void testOperation2() {
        SaleMachine saleMachine = new SaleMachine();
        String expect = "Input Information\nType: OrangeJuice;   Money: 5 Cents;   Change: 0\n\nCurrent State\nBeer:6\nOrange Juice:5\n5 Cents:7\n1 Dollar:6";
        assertEquals(expect, saleMachine.operation("OrangeJuice", "5C"));
    }

    @Test
    public void testOperation3() {
        SaleMachine saleMachine = new SaleMachine();
        String expect = "Input Information\nType: Beer;   Money: 1 Dollar;   Change: 5 Cents\n\nCurrent State\nBeer:5\nOrange Juice:6\n5 Cents:5\n1 Dollar:7";
        assertEquals(expect, saleMachine.operation("Beer", "1D"));
    }

    @Test
    public void testOperation4() {
        SaleMachine saleMachine = new SaleMachine();
        String expect = "Input Information\nType: OrangeJuice;  Money: 1 Dollar;  Change: 5 Cents\n\nCurrent State\nBeer:6\nOrange Juice:5\n5 Cents:5\n1 Dollar:7";
        assertEquals(expect, saleMachine.operation("OrangeJuice", "1D"));
    }

    @Test
    public void testOperation5() {
        SaleMachine saleMachine = new SaleMachine(0, 6, 6, 6);
        String expect = "Failure Information\nChange Shortage";
        assertEquals(expect, saleMachine.operation("Beer", "1D"));
    }

    @Test
    public void testOperation6() {
        SaleMachine saleMachine = new SaleMachine(0, 6, 6, 6);
        String expect = "Failure Information\nChange Shortage";
        assertEquals(expect, saleMachine.operation("OrangeJuice", "1D"));
    }

    @Test
    public void testOperation7() {
        SaleMachine saleMachine = new SaleMachine(6, 6, 0, 6);
        String expect = "Failure Information\nBeer Shortage";
        assertEquals(expect, saleMachine.operation("Beer", "1D"));
    }

    @Test
    public void testOperation8() {
        SaleMachine saleMachine = new SaleMachine(6, 6, 6, 0);
        String expect = "Failure Information\nOrangeJuice Shortage";
        assertEquals(expect, saleMachine.operation("OrangeJuice", "5C"));
    }

    @Test
    public void testOperation9() {
        SaleMachine saleMachine = new SaleMachine();
        String expect = "Failure Information\nMoney Error";
        assertEquals(expect, saleMachine.operation("Beer", "4C"));
    }

    @Test
    public void testOperation10() {
        SaleMachine saleMachine = new SaleMachine();
        String expect = "Failure Information\nType Error";
        assertEquals(expect, saleMachine.operation("Coca-Cola", "1D"));
    }

    @Test
    public void testOperation11() {
        SaleMachine saleMachine = new SaleMachine(6, 6, 0, 6);
        String expect = "Failure Information\nBeer Shortage";
        assertEquals(expect, saleMachine.operation("Beer", "5C"));
    }

    @Test
    public void testOperation12() {
        SaleMachine saleMachine = new SaleMachine();
        String expect = "Failure Information\nType Error";
        assertEquals(expect, saleMachine.operation("Coca-Cola", "5C"));
    }

    @Test
    public void testOperation13() {
        SaleMachine saleMachine = new SaleMachine(6, 6, 6, 0);
        String expect = "Failure Information\nOrangeJuice Shortage";
        assertEquals(expect, saleMachine.operation("OrangeJuice", "1D"));
    }
}

