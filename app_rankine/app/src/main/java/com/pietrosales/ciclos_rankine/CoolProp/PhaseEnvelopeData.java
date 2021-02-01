/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pietrosales.ciclos_rankine.CoolProp;

public class PhaseEnvelopeData {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected PhaseEnvelopeData(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PhaseEnvelopeData obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        CoolPropJNI.delete_PhaseEnvelopeData(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTypeI(boolean value) {
    CoolPropJNI.PhaseEnvelopeData_TypeI_set(swigCPtr, this, value);
  }

  public boolean getTypeI() {
    return CoolPropJNI.PhaseEnvelopeData_TypeI_get(swigCPtr, this);
  }

  public void setBuilt(boolean value) {
    CoolPropJNI.PhaseEnvelopeData_built_set(swigCPtr, this, value);
  }

  public boolean getBuilt() {
    return CoolPropJNI.PhaseEnvelopeData_built_get(swigCPtr, this);
  }

  public void setITsat_max(long value) {
    CoolPropJNI.PhaseEnvelopeData_iTsat_max_set(swigCPtr, this, value);
  }

  public long getITsat_max() {
    return CoolPropJNI.PhaseEnvelopeData_iTsat_max_get(swigCPtr, this);
  }

  public void setIpsat_max(long value) {
    CoolPropJNI.PhaseEnvelopeData_ipsat_max_set(swigCPtr, this, value);
  }

  public long getIpsat_max() {
    return CoolPropJNI.PhaseEnvelopeData_ipsat_max_get(swigCPtr, this);
  }

  public void setIcrit(long value) {
    CoolPropJNI.PhaseEnvelopeData_icrit_set(swigCPtr, this, value);
  }

  public long getIcrit() {
    return CoolPropJNI.PhaseEnvelopeData_icrit_get(swigCPtr, this);
  }

  public void setT(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_T_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getT() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_T_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setP(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_p_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getP() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_p_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setLnT(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_lnT_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getLnT() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_lnT_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setLnp(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_lnp_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getLnp() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_lnp_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setRhomolar_liq(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_rhomolar_liq_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getRhomolar_liq() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_rhomolar_liq_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setRhomolar_vap(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_rhomolar_vap_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getRhomolar_vap() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_rhomolar_vap_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setLnrhomolar_liq(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_lnrhomolar_liq_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getLnrhomolar_liq() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_lnrhomolar_liq_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setLnrhomolar_vap(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_lnrhomolar_vap_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getLnrhomolar_vap() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_lnrhomolar_vap_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setHmolar_liq(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_hmolar_liq_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getHmolar_liq() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_hmolar_liq_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setHmolar_vap(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_hmolar_vap_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getHmolar_vap() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_hmolar_vap_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setSmolar_liq(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_smolar_liq_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getSmolar_liq() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_smolar_liq_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setSmolar_vap(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_smolar_vap_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getSmolar_vap() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_smolar_vap_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setQ(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_Q_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getQ() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_Q_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setCpmolar_liq(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_cpmolar_liq_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getCpmolar_liq() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_cpmolar_liq_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setCpmolar_vap(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_cpmolar_vap_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getCpmolar_vap() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_cpmolar_vap_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setCvmolar_liq(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_cvmolar_liq_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getCvmolar_liq() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_cvmolar_liq_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setCvmolar_vap(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_cvmolar_vap_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getCvmolar_vap() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_cvmolar_vap_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setViscosity_liq(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_viscosity_liq_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getViscosity_liq() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_viscosity_liq_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setViscosity_vap(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_viscosity_vap_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getViscosity_vap() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_viscosity_vap_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setConductivity_liq(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_conductivity_liq_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getConductivity_liq() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_conductivity_liq_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setConductivity_vap(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_conductivity_vap_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getConductivity_vap() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_conductivity_vap_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setSpeed_sound_vap(DoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_speed_sound_vap_set(swigCPtr, this, DoubleVector.getCPtr(value), value);
  }

  public DoubleVector getSpeed_sound_vap() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_speed_sound_vap_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DoubleVector(cPtr, false);
  }

  public void setK(VectorOfDoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_K_set(swigCPtr, this, VectorOfDoubleVector.getCPtr(value), value);
  }

  public VectorOfDoubleVector getK() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_K_get(swigCPtr, this);
    return (cPtr == 0) ? null : new VectorOfDoubleVector(cPtr, false);
  }

  public void setLnK(VectorOfDoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_lnK_set(swigCPtr, this, VectorOfDoubleVector.getCPtr(value), value);
  }

  public VectorOfDoubleVector getLnK() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_lnK_get(swigCPtr, this);
    return (cPtr == 0) ? null : new VectorOfDoubleVector(cPtr, false);
  }

  public void setX(VectorOfDoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_x_set(swigCPtr, this, VectorOfDoubleVector.getCPtr(value), value);
  }

  public VectorOfDoubleVector getX() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_x_get(swigCPtr, this);
    return (cPtr == 0) ? null : new VectorOfDoubleVector(cPtr, false);
  }

  public void setY(VectorOfDoubleVector value) {
    CoolPropJNI.PhaseEnvelopeData_y_set(swigCPtr, this, VectorOfDoubleVector.getCPtr(value), value);
  }

  public VectorOfDoubleVector getY() {
    long cPtr = CoolPropJNI.PhaseEnvelopeData_y_get(swigCPtr, this);
    return (cPtr == 0) ? null : new VectorOfDoubleVector(cPtr, false);
  }

  public PhaseEnvelopeData() {
    this(CoolPropJNI.new_PhaseEnvelopeData(), true);
  }

  public void resize(long N) {
    CoolPropJNI.PhaseEnvelopeData_resize(swigCPtr, this, N);
  }

  public void clear() {
    CoolPropJNI.PhaseEnvelopeData_clear(swigCPtr, this);
  }

  public void insert_variables(double T, double p, double rhomolar_liq, double rhomolar_vap, double hmolar_liq, double hmolar_vap, double smolar_liq, double smolar_vap, SWIGTYPE_p_std__vectorT_CoolPropDbl_t x, SWIGTYPE_p_std__vectorT_CoolPropDbl_t y, long i) {
    CoolPropJNI.PhaseEnvelopeData_insert_variables(swigCPtr, this, T, p, rhomolar_liq, rhomolar_vap, hmolar_liq, hmolar_vap, smolar_liq, smolar_vap, SWIGTYPE_p_std__vectorT_CoolPropDbl_t.getCPtr(x), SWIGTYPE_p_std__vectorT_CoolPropDbl_t.getCPtr(y), i);
  }

  public void store_variables(double T, double p, double rhomolar_liq, double rhomolar_vap, double hmolar_liq, double hmolar_vap, double smolar_liq, double smolar_vap, SWIGTYPE_p_std__vectorT_CoolPropDbl_t x, SWIGTYPE_p_std__vectorT_CoolPropDbl_t y) {
    CoolPropJNI.PhaseEnvelopeData_store_variables(swigCPtr, this, T, p, rhomolar_liq, rhomolar_vap, hmolar_liq, hmolar_vap, smolar_liq, smolar_vap, SWIGTYPE_p_std__vectorT_CoolPropDbl_t.getCPtr(x), SWIGTYPE_p_std__vectorT_CoolPropDbl_t.getCPtr(y));
  }

}
