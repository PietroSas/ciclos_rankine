/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pietrosales.ciclos_rankine.CoolProp;

public final class input_pairs {
  public final static input_pairs INPUT_PAIR_INVALID = new input_pairs("INPUT_PAIR_INVALID", CoolPropJNI.INPUT_PAIR_INVALID_get());
  public final static input_pairs QT_INPUTS = new input_pairs("QT_INPUTS");
  public final static input_pairs PQ_INPUTS = new input_pairs("PQ_INPUTS");
  public final static input_pairs QSmolar_INPUTS = new input_pairs("QSmolar_INPUTS");
  public final static input_pairs QSmass_INPUTS = new input_pairs("QSmass_INPUTS");
  public final static input_pairs HmolarQ_INPUTS = new input_pairs("HmolarQ_INPUTS");
  public final static input_pairs HmassQ_INPUTS = new input_pairs("HmassQ_INPUTS");
  public final static input_pairs DmolarQ_INPUTS = new input_pairs("DmolarQ_INPUTS");
  public final static input_pairs DmassQ_INPUTS = new input_pairs("DmassQ_INPUTS");
  public final static input_pairs PT_INPUTS = new input_pairs("PT_INPUTS");
  public final static input_pairs DmassT_INPUTS = new input_pairs("DmassT_INPUTS");
  public final static input_pairs DmolarT_INPUTS = new input_pairs("DmolarT_INPUTS");
  public final static input_pairs HmolarT_INPUTS = new input_pairs("HmolarT_INPUTS");
  public final static input_pairs HmassT_INPUTS = new input_pairs("HmassT_INPUTS");
  public final static input_pairs SmolarT_INPUTS = new input_pairs("SmolarT_INPUTS");
  public final static input_pairs SmassT_INPUTS = new input_pairs("SmassT_INPUTS");
  public final static input_pairs TUmolar_INPUTS = new input_pairs("TUmolar_INPUTS");
  public final static input_pairs TUmass_INPUTS = new input_pairs("TUmass_INPUTS");
  public final static input_pairs DmassP_INPUTS = new input_pairs("DmassP_INPUTS");
  public final static input_pairs DmolarP_INPUTS = new input_pairs("DmolarP_INPUTS");
  public final static input_pairs HmassP_INPUTS = new input_pairs("HmassP_INPUTS");
  public final static input_pairs HmolarP_INPUTS = new input_pairs("HmolarP_INPUTS");
  public final static input_pairs PSmass_INPUTS = new input_pairs("PSmass_INPUTS");
  public final static input_pairs PSmolar_INPUTS = new input_pairs("PSmolar_INPUTS");
  public final static input_pairs PUmass_INPUTS = new input_pairs("PUmass_INPUTS");
  public final static input_pairs PUmolar_INPUTS = new input_pairs("PUmolar_INPUTS");
  public final static input_pairs HmassSmass_INPUTS = new input_pairs("HmassSmass_INPUTS");
  public final static input_pairs HmolarSmolar_INPUTS = new input_pairs("HmolarSmolar_INPUTS");
  public final static input_pairs SmassUmass_INPUTS = new input_pairs("SmassUmass_INPUTS");
  public final static input_pairs SmolarUmolar_INPUTS = new input_pairs("SmolarUmolar_INPUTS");
  public final static input_pairs DmassHmass_INPUTS = new input_pairs("DmassHmass_INPUTS");
  public final static input_pairs DmolarHmolar_INPUTS = new input_pairs("DmolarHmolar_INPUTS");
  public final static input_pairs DmassSmass_INPUTS = new input_pairs("DmassSmass_INPUTS");
  public final static input_pairs DmolarSmolar_INPUTS = new input_pairs("DmolarSmolar_INPUTS");
  public final static input_pairs DmassUmass_INPUTS = new input_pairs("DmassUmass_INPUTS");
  public final static input_pairs DmolarUmolar_INPUTS = new input_pairs("DmolarUmolar_INPUTS");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static input_pairs swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + input_pairs.class + " with value " + swigValue);
  }

  private input_pairs(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private input_pairs(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private input_pairs(String swigName, input_pairs swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static input_pairs[] swigValues = { INPUT_PAIR_INVALID, QT_INPUTS, PQ_INPUTS, QSmolar_INPUTS, QSmass_INPUTS, HmolarQ_INPUTS, HmassQ_INPUTS, DmolarQ_INPUTS, DmassQ_INPUTS, PT_INPUTS, DmassT_INPUTS, DmolarT_INPUTS, HmolarT_INPUTS, HmassT_INPUTS, SmolarT_INPUTS, SmassT_INPUTS, TUmolar_INPUTS, TUmass_INPUTS, DmassP_INPUTS, DmolarP_INPUTS, HmassP_INPUTS, HmolarP_INPUTS, PSmass_INPUTS, PSmolar_INPUTS, PUmass_INPUTS, PUmolar_INPUTS, HmassSmass_INPUTS, HmolarSmolar_INPUTS, SmassUmass_INPUTS, SmolarUmolar_INPUTS, DmassHmass_INPUTS, DmolarHmolar_INPUTS, DmassSmass_INPUTS, DmolarSmolar_INPUTS, DmassUmass_INPUTS, DmolarUmolar_INPUTS };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

