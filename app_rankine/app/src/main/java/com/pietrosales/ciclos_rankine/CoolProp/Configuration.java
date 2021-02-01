/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pietrosales.ciclos_rankine.CoolProp;

public class Configuration {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Configuration(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Configuration obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        CoolPropJNI.delete_Configuration(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Configuration() {
    this(CoolPropJNI.new_Configuration(), true);
  }

  public ConfigurationItem get_item(configuration_keys key) {
    return new ConfigurationItem(CoolPropJNI.Configuration_get_item(swigCPtr, this, key.swigValue()), false);
  }

  public void add_item(ConfigurationItem item) {
    CoolPropJNI.Configuration_add_item(swigCPtr, this, ConfigurationItem.getCPtr(item), item);
  }

  public SWIGTYPE_p_std__mapT_configuration_keys_CoolProp__ConfigurationItem_t get_items() {
    return new SWIGTYPE_p_std__mapT_configuration_keys_CoolProp__ConfigurationItem_t(CoolPropJNI.Configuration_get_items(swigCPtr, this), false);
  }

  public void set_defaults() {
    CoolPropJNI.Configuration_set_defaults(swigCPtr, this);
  }

}
