/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pietrosales.ciclos_rankine.CoolProp;

public class GuessesStructure {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected GuessesStructure(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GuessesStructure obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        CoolPropJNI.delete_GuessesStructure(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setT(double value) {
    CoolPropJNI.GuessesStructure_T_set(swigCPtr, this, value);
  }

  public double getT() {
    return CoolPropJNI.GuessesStructure_T_get(swigCPtr, this);
  }

  public void setP(double value) {
    CoolPropJNI.GuessesStructure_p_set(swigCPtr, this, value);
  }

  public double getP() {
    return CoolPropJNI.GuessesStructure_p_get(swigCPtr, this);
  }

  public void setRhomolar(double value) {
    CoolPropJNI.GuessesStructure_rhomolar_set(swigCPtr, this, value);
  }

  public double getRhomolar() {
    return CoolPropJNI.GuessesStructure_rhomolar_get(swigCPtr, this);
  }

  public void setHmolar(double value) {
    CoolPropJNI.GuessesStructure_hmolar_set(swigCPtr, this, value);
  }

  public double getHmolar() {
    return CoolPropJNI.GuessesStructure_hmolar_get(swigCPtr, this);
  }

  public void setSmolar(double value) {
    CoolPropJNI.GuessesStructure_smolar_set(swigCPtr, this, value);
  }

  public double getSmolar() {
    return CoolPropJNI.GuessesStructure_smolar_get(swigCPtr, this);
  }

  public void setRhomolar_liq(double value) {
    CoolPropJNI.GuessesStructure_rhomolar_liq_set(swigCPtr, this, value);
  }

  public double getRhomolar_liq() {
    return CoolPropJNI.GuessesStructure_rhomolar_liq_get(swigCPtr, this);
  }

  public void setRhomolar_vap(double value) {
    CoolPropJNI.GuessesStructure_rhomolar_vap_set(swigCPtr, this, value);
  }

  public double getRhomolar_vap() {
    return CoolPropJNI.GuessesStructure_rhomolar_vap_get(swigCPtr, this);
  }

  public void setX(DoubleVector value) {
    CoolPropJNI.GuessesStructure_x_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getX() {
    long cPtr = CoolPropJNI.GuessesStructure_x_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setY(DoubleVector value) {
    CoolPropJNI.GuessesStructure_y_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getY() {
    long cPtr = CoolPropJNI.GuessesStructure_y_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public GuessesStructure() {
    this(CoolPropJNI.new_GuessesStructure(), true);
  }

  public void clear() {
    CoolPropJNI.GuessesStructure_clear(swigCPtr, this);
  }

}
