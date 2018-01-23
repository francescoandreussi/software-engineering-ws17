import TinyTestJ.Test;
import static TinyTestJ.Assert.*;

public class TestSuite {
  @Test public static void DETest1(){
    try{
      UnitConverter test = ConverterFactory.create("DollarToEuro");
      double result = test.convert(10000);
      assertEquals(8500,result,0.001);
    }
    catch(BadConversionStringException e){
      fail();
    }
  }
  @Test public static void DETest2(){
    try{
      UnitConverter test = ConverterFactory.create("DollarToEuro");
      double result = test.convert(-1);
      assertEquals(-0.85,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void DETest3(){
    try{
      UnitConverter test = ConverterFactory.create("DollarToEuro");
      double result = test.convert(-Double.MIN_VALUE);
      assertEquals(0,result,0.000);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void PFTest1(){
    try{
      UnitConverter test = ConverterFactory.create("BritishPoundToSwissFranc");
      double result = test.convert(450.5678);
      assertEquals(584.39,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void PFTest2(){
    try{
      UnitConverter test = ConverterFactory.create("BritishPoundToSwissFranc");
      double result = test.convert(Double.NEGATIVE_INFINITY);
      assertEquals(Double.NEGATIVE_INFINITY,result,0.0);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void PFTest3(){
    try{
      UnitConverter test = ConverterFactory.create("BritishPoundToSwissFranc");
      double result = test.convert(Double.MAX_VALUE);
      assertEquals(Double.POSITIVE_INFINITY,result,0.000);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void APTest1(){
    try{
      UnitConverter test = ConverterFactory.create("AtmosphereToPascal");
      double result = test.convert(6.33333333333333);
      assertEquals(641724.9999999997,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void APTest2(){
    try{
      UnitConverter test = ConverterFactory.create("AtmosphereToPascal");
      double result = test.convert(-900000);
      assertEquals(-9.11925E10,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void APTest3(){
    try{
      UnitConverter test = ConverterFactory.create("AtmosphereToPascal");
      double result = test.convert(Double.NaN);
     assertEquals(Double.NaN,result,0.000);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void BKpSMTest1(){
    try{
      UnitConverter test = ConverterFactory.create("BarToKilogramPerSquaredMeter");
      double result = test.convert(2.67);
      assertEquals(27226.42254,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void BKpSMTest2(){
    try{
      UnitConverter test = ConverterFactory.create("BarToKilogramPerSquaredMeter");
      double result = test.convert(99999999999999999999999999999999.0);
      assertEquals(1.0197162E36,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void BKpSMTest3(){
    try{
     UnitConverter test = ConverterFactory.create("BarToKilogramPerSquaredMeter");
     double result = test.convert(Double.POSITIVE_INFINITY);
     assertEquals(Double.POSITIVE_INFINITY,result,0.000);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void KPTest1(){
    try{
     UnitConverter test = ConverterFactory.create("KilogramToPound");
     double result = test.convert(Double.MAX_VALUE);
     assertEquals(Double.POSITIVE_INFINITY,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void KPTest2(){
    try{
      UnitConverter test =ConverterFactory.create("KilogramToPound");
      double result = test.convert(500);
      assertEquals(1102.5,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void KPTest3(){
    try{
      UnitConverter test = ConverterFactory.create("KilogramToPound");
      double result = test.convert(Double.NaN);
      assertEquals(Double.NaN,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void OGTest1(){
    try{
      UnitConverter test = ConverterFactory.create("OunceToGram");
      double result = test.convert(-(-(45.8262901)));
      assertEquals(1299.1294980449,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void OGTest2(){
    try{
      UnitConverter test = ConverterFactory.create("OunceToGram");
      double result = test.convert(765317635876847368726874.86587263598178298);
      assertEquals(2.1695989659472745E25,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void OGTest3(){
    try{
      UnitConverter test = ConverterFactory.create("OunceToGram");
      double result = test.convert(Double.MAX_EXPONENT);
      assertEquals(29001.027000000002,result,0.001);
    }
    catch (BadConversionStringException e) {
      fail();
    }
  }
  @Test public static void ExceptionTest1(){
    String expected = "The string NonCompliantString is invalid!";
    String actual = "";
    try{
      UnitConverter test = ConverterFactory.create("NonCompliantString");
    } catch(BadConversionStringException e){
      actual = e.getMessage();
    }
    if (! actual.equals(expected)){
      fail("expected: String<" + expected + "> but was String<" + actual + ">");
    }
  }
  @Test public static void ExceptionTest2(){
    String expected = "The string  is invalid!";
    String actual = "";
    try{
      UnitConverter test = ConverterFactory.create("");
    } catch(BadConversionStringException e){
      actual = e.getMessage();
    }
    if (! actual.equals(expected)) {
      fail("expected: String<" + expected + "> but was String<" + actual + ">");
    }
  }
  @Test public static void ExceptionTest3(){
    String expected = "The string OunceToGram25.96 is invalid!";
    String actual = "";
    try{
      UnitConverter test = ConverterFactory.create("OunceToGram25.96");
    } catch(BadConversionStringException e){
      actual = e.getMessage();
    }
    if (! actual.equals(expected)) {
      fail("expected: String<" + expected + "> but was String<" + actual + ">");
    }
  }
  @Test public static void chaining1() {
    try{
      UnitConverter test = new EuroToBritishPoundConverter(new DollarToEuroConverter());
      double result = test.convert(1);
      //test.convertAndPrint(1, false);
      assertEquals(0.7395, result, 0.001);
    } catch(BadChainingException e){
      fail();
    }
  }
  @Test public static void chaining2() {
    try{
      UnitConverter test = new BritishPoundToSwissFrancConverter(new EuroToBritishPoundConverter(new DollarToEuroConverter()));
      double result = test.convert(1);
      //test.convertAndPrint(1, false);
      assertEquals(0.96, result, 0.001);
    } catch (BadChainingException e) {
      fail();
    }
  }
  @Test public static void chaining3() {
    try{
      UnitConverter test = new BarToKgPerSqMtConverter(new PascalToBarConverter(new AtmToPascalConverter()));
      double result = test.convert(1);
      //test.convertAndPrint(1, false);
      assertEquals(10332.274, result, 0.001);
    } catch (BadChainingException e) {
      fail();
    }
    catch(NullPointerException e){
      System.out.println(e.toString());
    }
  }
  @Test public static void chaining4() {
    try{
      UnitConverter test = new OunceToGramConverter(new PoundToOunceConverter(new KiloToPoundConverter()));
      double result = test.convert(1);
      //test.convertAndPrint(1, false);
      assertEquals(1000.153, result, 0.001);
    } catch (BadChainingException e) {
      fail();
    }
  }
  @Test public static void chainingExcpetion1() {
    String expected = "class KiloToPoundConverter must be chained to class PoundToOunceConverter and not to class OunceToGramConverter";
    String actual = "";
    try{
      UnitConverter test = new KiloToPoundConverter(new OunceToGramConverter());
      double result = test.convert(1);
      //test.convertAndPrint(1, false);
      assertEquals(1000.153, result, 0.001);
    } catch (BadChainingException e) {
      actual = e.getMessage();
    }
    if (!actual.equals(expected)) {
      fail("expected: String<" + expected + "> but was String<" + actual + ">");
    }
  }
  @Test public static void chainingExcpetion2() {
    String expected = "class DollarToEuroConverter must be chained to class EuroToBritishPoundConverter and not to class KiloToPoundConverter";
    String actual = "";
    try{
      UnitConverter test = new DollarToEuroConverter(new KiloToPoundConverter());
      double result = test.convert(1);
      //test.convertAndPrint(1, false);
      assertEquals(1000.153, result, 0.001);
    } catch (BadChainingException e) {
      actual = e.getMessage();
    }
    if (!actual.equals(expected)) {
      fail("expected: String<" + expected + "> but was String<" + actual + ">");
    }
  }
  @Test public static void Inversion1() {
    try{
      UnitConverter test = new Inversion(new DollarToEuroConverter());
      double result = test.convert(1);
      //test.convertAndPrint(1, true);
      assertEquals(1.18, result, 0.001);
    } catch (BadChainingException e){
      fail();
    }
  }
  @Test public static void Inversion2() {
    try{
      UnitConverter test = new Inversion(new BarToKgPerSqMtConverter(new PascalToBarConverter()));
      double result = test.convert(1);
      //test.convertAndPrint(1, true);
      assertEquals(9.807, result, 0.001);
    } catch (BadChainingException e) {
      fail();
    }
  }
  @Test public static void Inversion3() {
    try{
      UnitConverter test = new Inversion(new OunceToGramConverter(new PoundToOunceConverter(new KiloToPoundConverter())));
      double result = test.convert(100);
      //test.convertAndPrint(100, true);
      assertEquals(0.1, result, 0.001);
    } catch (BadChainingException e) {
      fail();
    }
  }
  @Test public static void NumOfInstTest(){
    ConverterFactory factory1 = ConverterFactory.instance();
    ConverterFactory factory2 = ConverterFactory.instance();
    ConverterFactory factory3 = ConverterFactory.instance();
    ConverterFactory factory4 = ConverterFactory.instance();
    ConverterFactory factory5 = ConverterFactory.instance();
    ConverterFactory factory6 = ConverterFactory.instance();
    int result = ConverterFactory.getNumberOfInstances();
    assertEquals(1, result, 0);
  }
}
