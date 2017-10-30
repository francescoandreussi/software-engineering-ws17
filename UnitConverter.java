/** This is the Superclass of every Converter class, it defines the methods to be implemented
*   convert method: it actually performs the conversion,
*                   it handle overflows returning Infinity or -Infinity,
*                   it handle underflows retutning 0.0,
*                   if inValue is NaN it returns NaN.
*	This is valid for every implementation of convert in the subclasses of UnitConverter
*/


public abstract class UnitConverter
{
  public UnitConverter() { }
  public abstract double convert(double inValue);
  public abstract String toString();
  public abstract void print();
};

