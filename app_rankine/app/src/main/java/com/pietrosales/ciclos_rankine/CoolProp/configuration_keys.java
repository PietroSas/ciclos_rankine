/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.pietrosales.ciclos_rankine.CoolProp;

public final class configuration_keys {
  public final static configuration_keys NORMALIZE_GAS_CONSTANTS = new configuration_keys("NORMALIZE_GAS_CONSTANTS");
  public final static configuration_keys CRITICAL_WITHIN_1UK = new configuration_keys("CRITICAL_WITHIN_1UK");
  public final static configuration_keys CRITICAL_SPLINES_ENABLED = new configuration_keys("CRITICAL_SPLINES_ENABLED");
  public final static configuration_keys SAVE_RAW_TABLES = new configuration_keys("SAVE_RAW_TABLES");
  public final static configuration_keys ALTERNATIVE_TABLES_DIRECTORY = new configuration_keys("ALTERNATIVE_TABLES_DIRECTORY");
  public final static configuration_keys ALTERNATIVE_REFPROP_PATH = new configuration_keys("ALTERNATIVE_REFPROP_PATH");
  public final static configuration_keys ALTERNATIVE_REFPROP_HMX_BNC_PATH = new configuration_keys("ALTERNATIVE_REFPROP_HMX_BNC_PATH");
  public final static configuration_keys ALTERNATIVE_REFPROP_LIBRARY_PATH = new configuration_keys("ALTERNATIVE_REFPROP_LIBRARY_PATH");
  public final static configuration_keys REFPROP_DONT_ESTIMATE_INTERACTION_PARAMETERS = new configuration_keys("REFPROP_DONT_ESTIMATE_INTERACTION_PARAMETERS");
  public final static configuration_keys REFPROP_IGNORE_ERROR_ESTIMATED_INTERACTION_PARAMETERS = new configuration_keys("REFPROP_IGNORE_ERROR_ESTIMATED_INTERACTION_PARAMETERS");
  public final static configuration_keys REFPROP_USE_GERG = new configuration_keys("REFPROP_USE_GERG");
  public final static configuration_keys REFPROP_USE_PENGROBINSON = new configuration_keys("REFPROP_USE_PENGROBINSON");
  public final static configuration_keys MAXIMUM_TABLE_DIRECTORY_SIZE_IN_GB = new configuration_keys("MAXIMUM_TABLE_DIRECTORY_SIZE_IN_GB");
  public final static configuration_keys DONT_CHECK_PROPERTY_LIMITS = new configuration_keys("DONT_CHECK_PROPERTY_LIMITS");
  public final static configuration_keys HENRYS_LAW_TO_GENERATE_VLE_GUESSES = new configuration_keys("HENRYS_LAW_TO_GENERATE_VLE_GUESSES");
  public final static configuration_keys PHASE_ENVELOPE_STARTING_PRESSURE_PA = new configuration_keys("PHASE_ENVELOPE_STARTING_PRESSURE_PA");
  public final static configuration_keys R_U_CODATA = new configuration_keys("R_U_CODATA");
  public final static configuration_keys VTPR_UNIFAC_PATH = new configuration_keys("VTPR_UNIFAC_PATH");
  public final static configuration_keys SPINODAL_MINIMUM_DELTA = new configuration_keys("SPINODAL_MINIMUM_DELTA");
  public final static configuration_keys OVERWRITE_FLUIDS = new configuration_keys("OVERWRITE_FLUIDS");
  public final static configuration_keys OVERWRITE_DEPARTURE_FUNCTION = new configuration_keys("OVERWRITE_DEPARTURE_FUNCTION");
  public final static configuration_keys OVERWRITE_BINARY_INTERACTION = new configuration_keys("OVERWRITE_BINARY_INTERACTION");
  public final static configuration_keys USE_GUESSES_IN_PROPSSI = new configuration_keys("USE_GUESSES_IN_PROPSSI");
  public final static configuration_keys ASSUME_CRITICAL_POINT_STABLE = new configuration_keys("ASSUME_CRITICAL_POINT_STABLE");
  public final static configuration_keys VTPR_ALWAYS_RELOAD_LIBRARY = new configuration_keys("VTPR_ALWAYS_RELOAD_LIBRARY");
  public final static configuration_keys FLOAT_PUNCTUATION = new configuration_keys("FLOAT_PUNCTUATION");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static configuration_keys swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + configuration_keys.class + " with value " + swigValue);
  }

  private configuration_keys(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private configuration_keys(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private configuration_keys(String swigName, configuration_keys swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static configuration_keys[] swigValues = { NORMALIZE_GAS_CONSTANTS, CRITICAL_WITHIN_1UK, CRITICAL_SPLINES_ENABLED, SAVE_RAW_TABLES, ALTERNATIVE_TABLES_DIRECTORY, ALTERNATIVE_REFPROP_PATH, ALTERNATIVE_REFPROP_HMX_BNC_PATH, ALTERNATIVE_REFPROP_LIBRARY_PATH, REFPROP_DONT_ESTIMATE_INTERACTION_PARAMETERS, REFPROP_IGNORE_ERROR_ESTIMATED_INTERACTION_PARAMETERS, REFPROP_USE_GERG, REFPROP_USE_PENGROBINSON, MAXIMUM_TABLE_DIRECTORY_SIZE_IN_GB, DONT_CHECK_PROPERTY_LIMITS, HENRYS_LAW_TO_GENERATE_VLE_GUESSES, PHASE_ENVELOPE_STARTING_PRESSURE_PA, R_U_CODATA, VTPR_UNIFAC_PATH, SPINODAL_MINIMUM_DELTA, OVERWRITE_FLUIDS, OVERWRITE_DEPARTURE_FUNCTION, OVERWRITE_BINARY_INTERACTION, USE_GUESSES_IN_PROPSSI, ASSUME_CRITICAL_POINT_STABLE, VTPR_ALWAYS_RELOAD_LIBRARY, FLOAT_PUNCTUATION };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

