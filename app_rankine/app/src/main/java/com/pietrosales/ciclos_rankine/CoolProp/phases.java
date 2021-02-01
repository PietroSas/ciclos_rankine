/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pietrosales.ciclos_rankine.CoolProp;

public final class phases {
  public final static phases iphase_liquid = new phases("iphase_liquid");
  public final static phases iphase_supercritical = new phases("iphase_supercritical");
  public final static phases iphase_supercritical_gas = new phases("iphase_supercritical_gas");
  public final static phases iphase_supercritical_liquid = new phases("iphase_supercritical_liquid");
  public final static phases iphase_critical_point = new phases("iphase_critical_point");
  public final static phases iphase_gas = new phases("iphase_gas");
  public final static phases iphase_twophase = new phases("iphase_twophase");
  public final static phases iphase_unknown = new phases("iphase_unknown");
  public final static phases iphase_not_imposed = new phases("iphase_not_imposed");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static phases swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + phases.class + " with value " + swigValue);
  }

  private phases(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private phases(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private phases(String swigName, phases swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static phases[] swigValues = { iphase_liquid, iphase_supercritical, iphase_supercritical_gas, iphase_supercritical_liquid, iphase_critical_point, iphase_gas, iphase_twophase, iphase_unknown, iphase_not_imposed };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

