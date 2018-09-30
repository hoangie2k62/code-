package lab04;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class Lab04Test {
    
    public Lab04Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of max method, of class Lab04.
     */
    @Test
    public void testMax1() {
        System.out.println("max");
        int a = 1;
        int b = 2;
        int expResult = 2;
        int result = Lab04.max(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMax2() {
        System.out.println("max");
        int a = 1;
        int b = 3;
        int expResult = 3;
        int result = Lab04.max(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMax3() {
        System.out.println("max");
        int a = 5;
        int b = 2;
        int expResult = 5;
        int result = Lab04.max(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMax4() {
        System.out.println("max");
        int a = 10;
        int b = 12;
        int expResult = 12;
        int result = Lab04.max(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMax5() {
        System.out.println("max");
        int a = 21;
        int b = 32;
        int expResult = 32;
        int result = Lab04.max(a, b);
        assertEquals(expResult, result);
    }
    /**
     * Test of minArray method, of class Lab04.
     */
    @Test
    public void testMinArray1() {
        System.out.println("minArray");
        int size = 6;
        int[] a = new int[size];
        int expResult = a[2];
        int result = Lab04.minArray(a, size);
        assertEquals(expResult, result);
    }
    @Test
    public void testMinArray2() {
        System.out.println("minArray");
        int size = 4;
        int[] a = new int[size];
        int expResult = a[1];
        int result = Lab04.minArray(a, size);
        assertEquals(expResult, result);
    }
    @Test
    public void testMinArray3() {
        System.out.println("minArray");
        int size = 10;
        int[] a = new int[size];
        int expResult = a[4];
        int result = Lab04.minArray(a, size);
        assertEquals(expResult, result);
    }
    @Test
    public void testMinArray4() {
        System.out.println("minArray");
        int size = 7;
        int[] a = new int[size];
        int expResult = a[0];
        int result = Lab04.minArray(a, size);
        assertEquals(expResult, result);
    }
    @Test
    public void testMinArray() {
        System.out.println("minArray");
        int size = 5;
        int[] a = new int[size];
        int expResult = a[4];
        int result = Lab04.minArray(a, size);
        assertEquals(expResult, result);
    }
    /**
     * Test of BMI method, of class Lab04.
     */
    @Test
    public void testBMI1() {
        System.out.println("BMI");
        double weigh = 40;
        double high = 1.5;
        double expResult = 17.78;
        double result = Lab04.BMI(weigh, high);
        assertEquals(expResult, result, 00.00);
    }
    @Test
    public void testBMI2() {
        System.out.println("BMI");
        double weigh = 50;
        double high = 1.6;
        double expResult = 19.53;
        double result = Lab04.BMI(weigh, high);
        assertEquals(expResult, result, 00.00);
    }
    @Test
    public void testBMI3() {
        System.out.println("BMI");
        double weigh = 60;
        double high = 1.7;
        double expResult = 20.76;
        double result = Lab04.BMI(weigh, high);
        assertEquals(expResult, result, 00.00);
    }
    @Test
    public void testBMI4() {
        System.out.println("BMI");
        double weigh = 70;
        double high = 1.8;
        double expResult = 21.60;
        double result = Lab04.BMI(weigh, high);
        assertEquals(expResult, result, 00.00);
    }
    @Test
    public void testBMI5() {
        System.out.println("BMI");
        double weigh = 80;
        double high = 1.9;
        double expResult = 22.16;
        double result = Lab04.BMI(weigh, high);
        assertEquals(expResult, result, 00.00);
    }
}
