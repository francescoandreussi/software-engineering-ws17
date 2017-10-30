import TinyTestJ.Test;
import static TinyTestJ.Assert.*;

public class TestSuite {
  @Test public static void DETest1(){
    UnitConverter test = new DollarToEuroConverter();
    double result = test.convert(10000);
    assertEquals(8500,result,0.001);
  }
  @Test public static void DETest2(){
    UnitConverter test = new DollarToEuroConverter();
    double result = test.convert(-1);
    assertEquals(-0.85,result,0.001);
  }
  @Test public static void DETest3(){
    UnitConverter test = new DollarToEuroConverter();
    double result = test.convert(-Double.MIN_VALUE);
    assertEquals(-Double.MIN_VALUE,result,0.000);
  }
  @Test public static void PFTest1(){
    UnitConverter test = new BritishPoundToSwissFrancConverter();
    double result = test.convert(450.5678);
    assertEquals(584.3864365999999,result,0.001);
  }
  @Test public static void PFTest2(){
    UnitConverter test = new BritishPoundToSwissFrancConverter();
    double result = test.convert(Double.NEGATIVE_INFINITY);
    assertEquals(Double.NEGATIVE_INFINITY,result,0.0);
  }
  @Test public static void PFTest3(){
    UnitConverter test = new BritishPoundToSwissFrancConverter();
    double result = test.convert(Double.MAX_VALUE);
    assertEquals(Double.POSITIVE_INFINITY,result,0.000);
  }
  @Test public static void APTest1(){
    UnitConverter test = new AtmToPascalConverter();
    double result = test.convert(6.33333333333333);
    assertEquals(641724.9999999997,result,0.001);
  }
  @Test public static void APTest2(){
    UnitConverter test = new AtmToPascalConverter();
    double result = test.convert(-900000);
    assertEquals(-9.11925E10,result,0.001);
  }
  @Test public static void APTest3(){
    UnitConverter test = new BarToKgPerSqMtConverter();
    double result = test.convert(Double.NaN);
    assertEquals(Double.NaN,result,0.000);
  }
  @Test public static void BKpSMTest1(){
    UnitConverter test = new BarToKgPerSqMtConverter();
    double result = test.convert(2.67);
    assertEquals(27226.42254,result,0.001);
  }
  @Test public static void BKpSMTest2(){
    UnitConverter test = new BarToKgPerSqMtConverter();
    double result = test.convert(99999999999999999999999999999999.0);
    assertEquals(1.0197162E36,result,0.001);
  }
  @Test public static void BKpSMTest3(){
    UnitConverter test = new BarToKgPerSqMtConverter();
    double result = test.convert(Double.POSITIVE_INFINITY);
    assertEquals(Double.POSITIVE_INFINITY,result,0.000);
  }
  @Test public static void KPTest1(){
    UnitConverter test = new KiloToPoundConverter();
    double result = test.convert(Double.MAX_VALUE);
    assertEquals(Double.POSITIVE_INFINITY,result,0.001);
  }
  @Test public static void KPTest2(){
    UnitConverter test = new KiloToPoundConverter();
    double result = test.convert(500);
    assertEquals(1102.5,result,0.001);
  }
  @Test public static void KPTest3(){
    UnitConverter test = new KiloToPoundConverter();
    double result = test.convert(Double.NaN);
    assertEquals(Double.NaN,result,0.001);
  }
  @Test public static void OGTest1(){
    UnitConverter test = new OunceToGramConverter();
    double result = test.convert(-(-(45.8262901)));
    assertEquals(1299.1294980449,result,0.001);
  }
  @Test public static void OGTest2(){
    UnitConverter test = new OunceToGramConverter();
    double result = test.convert(765317635876847368726874.86587263598178298);
    assertEquals(2.1695989659472745E25,result,0.001);
  }
  @Test public static void OGTest3(){
    UnitConverter test = new OunceToGramConverter();
    double result = test.convert(Double.MAX_EXPONENT);
    assertEquals(29001.027000000002,result,0.001);
  }
}
