/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pietrosales.ciclos_rankine.CoolProp;

public class VectorOfStringVector {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected VectorOfStringVector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(VectorOfStringVector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        CoolPropJNI.delete_VectorOfStringVector(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public VectorOfStringVector() {
    this(CoolPropJNI.new_VectorOfStringVector__SWIG_0(), true);
  }

  public VectorOfStringVector(long n) {
    this(CoolPropJNI.new_VectorOfStringVector__SWIG_1(n), true);
  }

  public long size() {
    return CoolPropJNI.VectorOfStringVector_size(swigCPtr, this);
  }

  public long capacity() {
    return CoolPropJNI.VectorOfStringVector_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    CoolPropJNI.VectorOfStringVector_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return CoolPropJNI.VectorOfStringVector_isEmpty(swigCPtr, this);
  }

  public void clear() {
    CoolPropJNI.VectorOfStringVector_clear(swigCPtr, this);
  }

  public void add(StringVector x) {
    CoolPropJNI.VectorOfStringVector_add(swigCPtr, this, StringVector.getCPtr(x), x);
  }

  public StringVector get(int i) {
    return new StringVector(CoolPropJNI.VectorOfStringVector_get(swigCPtr, this, i), false);
  }

  public void set(int i, StringVector val) {
    CoolPropJNI.VectorOfStringVector_set(swigCPtr, this, i, StringVector.getCPtr(val), val);
  }

}
