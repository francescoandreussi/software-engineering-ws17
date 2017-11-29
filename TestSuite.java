import TinyTestJ.Test;
import static TinyTestJ.Assert.*;

public class TestSuite {
  @Test public static void DETest1(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("DollarToEuro");
    double result = test.convert(10000);
    assertEquals(8500,result,0.001);
  }
  @Test public static void DETest2(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("DollarToEuro"));
    double result = test.convert(-1);
    assertEquals(-0.85,result,0.001);
  }
  @Test public static void DETest3(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("DollarToEuro");
    double result = test.convert(-Double.MIN_VALUE);
    assertEquals(-Double.MIN_VALUE,result,0.000);
  }
  @Test public static void PFTest1(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("BritishPoundToSwissFranc");
    double result = test.convert(450.5678);
    assertEquals(584.3864365999999,result,0.001);
  }
  @Test public static void PFTest2(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("BritishPoundToSwissFranc");
    double result = test.convert(Double.NEGATIVE_INFINITY);
    assertEquals(Double.NEGATIVE_INFINITY,result,0.0);
  }
  @Test public static void PFTest3(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("BritishPoundToSwissFranc");
    double result = test.convert(Double.MAX_VALUE);
    assertEquals(Double.POSITIVE_INFINITY,result,0.000);
  }
  @Test public static void APTest1(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("AtmosphereToPascal");
    double result = test.convert(6.33333333333333);
    assertEquals(641724.9999999997,result,0.001);
  }
  @Test public static void APTest2(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("AtmosphereToPascal");
    double result = test.convert(-900000);
    assertEquals(-9.11925E10,result,0.001);
  }
  @Test public static void APTest3(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("AtmosphereToPascal");
    double result = test.convert(Double.NaN);
    assertEquals(Double.NaN,result,0.000);
  }
  @Test public static void BKpSMTest1(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("BarToKilogramPerSquaredMeter");
    double result = test.convert(2.67);
    assertEquals(27226.42254,result,0.001);
  }
  @Test public static void BKpSMTest2(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("BarToKilogramPerSquaredMeter");
    double result = test.convert(99999999999999999999999999999999.0);
    assertEquals(1.0197162E36,result,0.001);
  }
  @Test public static void BKpSMTest3(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("BarToKilogramPerSquaredMeter");
    double result = test.convert(Double.POSITIVE_INFINITY);
    assertEquals(Double.POSITIVE_INFINITY,result,0.000);
  }
  @Test public static void KPTest1(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("KilogramToPound");
    double result = test.convert(Double.MAX_VALUE);
    assertEquals(Double.POSITIVE_INFINITY,result,0.001);
  }
  @Test public static void KPTest2(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test =factory.create("KilogramToPound");
    double result = test.convert(500);
    assertEquals(1102.5,result,0.001);
  }
  @Test public static void KPTest3(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("KilogramToPound");
    double result = test.convert(Double.NaN);
    assertEquals(Double.NaN,result,0.001);
  }
  @Test public static void OGTest1(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("OunceToGram");
    double result = test.convert(-(-(45.8262901)));
    assertEquals(1299.1294980449,result,0.001);
  }
  @Test public static void OGTest2(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("OunceToGram");
    double result = test.convert(765317635876847368726874.86587263598178298);
    assertEquals(2.1695989659472745E25,result,0.001);
  }
  @Test public static void OGTest3(){
    ConverterFactory factory = ConverterFactory.instance();
    UnitConverter test = factory.create("OunceToGram");
    double result = test.convert(Double.MAX_EXPONENT);
    assertEquals(29001.027000000002,result,0.001);
  }
  @Test public static void ExceptionTest1(){
    String result;
    try{
      ConverterFactory factory = ConverterFactory.instance();
      UnitConverter test = factory.create("NonCompliantString");
    } catch(BadConversionStringException e){
      result = e;
    }
    assertEquals("The first argument is not a valid conversion string!", result);
  }
  @Test public static void ExceptionTest2(){
    String result;
    try{
      ConverterFactory factory = ConverterFactory.instance();
      UnitConverter test = factory.create("");
    } catch(BadConversionStringException e){
      result = e;
    }
    assertEquals("The first argument is not a valid conversion string!", result);
  }
  @Test public static void ExceptionTest3(){
    String result;
    try{
      ConverterFactory factory = ConverterFactory.instance();
      UnitConverter test = factory.create("OunceToGram25.96");
    } catch(BadConversionStringException e){
      result = e;
    }
    assertEquals("The first argument is not a valid conversion string!", result);
  }
  @Test public static void NumOfInstTest(){
    ConverterFactory factory = ConverterFactory.instance();
    int result = factory.getNumberOfInstances();
    assertEquals(1, result, 0);
  }
}
