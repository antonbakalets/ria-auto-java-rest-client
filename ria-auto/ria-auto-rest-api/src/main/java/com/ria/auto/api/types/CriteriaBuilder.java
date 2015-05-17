package com.ria.auto.api.types;

import java.util.*;

public class CriteriaBuilder {

    private static final long ONE = 1L;
    private static final long ZERO = 0L;

    private Map<AverageParam, Long> paramValues;
    private Map<AverageRangeParam, List<Long>> rangeParamValues;

    public CriteriaBuilder() {
        paramValues = new EnumMap<AverageParam, Long>(AverageParam.class);
        rangeParamValues = new EnumMap<AverageRangeParam, List<Long>>(AverageRangeParam.class);
    }

    public CriteriaBuilder setCategory(Long value) {
        paramValues.put(AverageParam.CATEGORY, value);
        return this;
    }

    public CriteriaBuilder setBodyStyle(Long value) {
        paramValues.put(AverageParam.BODYSTYLE, value);
        return this;
    }

    public CriteriaBuilder setBrand(Long value) {
        paramValues.put(AverageParam.BRAND, value);
        return this;
    }

    public CriteriaBuilder setModel(Long value) {
        paramValues.put(AverageParam.MODEL, value);
        return this;
    }

    public CriteriaBuilder setYears(Long... values) {
        if (values != null) {
            rangeParamValues.put(AverageRangeParam.YEARS, Arrays.asList(values));
        }
        return this;
    }

    public CriteriaBuilder setGearBox(Long value) {
        paramValues.put(AverageParam.GEARBOX, value);
        return this;
    }

    public CriteriaBuilder setFuelType(Long value) {
        paramValues.put(AverageParam.FUELTYPE, value);
        return this;
    }

    public CriteriaBuilder setPowertrain(Long value) {
        paramValues.put(AverageParam.POWERTRAIN, value);
        return this;
    }

    // TODO public Criteria setEngineVolume(Long value)

    public CriteriaBuilder setOptions(Long... values) {
        if (values != null) {
            rangeParamValues.put(AverageRangeParam.OPTIONS, Arrays.asList(values));
        }
        return this;
    }

    public CriteriaBuilder setMileage(Long... values) {
        if (values != null) {
            rangeParamValues.put(AverageRangeParam.MILEAGE, Arrays.asList(values));
        }
        return this;
    }

    public CriteriaBuilder setDoorsNumber(Long value) {
        paramValues.put(AverageParam.DOORSNUMBER, value);
        return this;
    }

    public CriteriaBuilder setRegion(Long value) {
        paramValues.put(AverageParam.REGION, value);
        return this;
    }

    public CriteriaBuilder setCity(Long value) {
        paramValues.put(AverageParam.CITY, value);
        return this;
    }

    public CriteriaBuilder setCarrying(Long value) {
        paramValues.put(AverageParam.CARRYING, value);
        return this;
    }

    public CriteriaBuilder setSeatsNumber(Long value) {
        paramValues.put(AverageParam.SEATSNUMBER, value);
        return this;
    }

    public CriteriaBuilder setColour(Long value) {
        paramValues.put(AverageParam.COLOUR, value);
        return this;
    }

    public CriteriaBuilder setCustom(Boolean value) {
        paramValues.put(AverageParam.CUSTOM, value ? ONE : ZERO);
        return this;
    }

    public CriteriaBuilder setDamaged(Boolean value) {
        paramValues.put(AverageParam.DAMAGED, value ? ONE : ZERO);
        return this;
    }

    public CriteriaBuilder setCredit(Boolean value) {
        paramValues.put(AverageParam.CREDIT, value ? ONE : ZERO);
        return this;
    }

    public CriteriaBuilder setConfiscated(Boolean value) {
        paramValues.put(AverageParam.CONFISCATED, value ? ONE : ZERO);
        return this;
    }

    public CriteriaBuilder setNotOnTrack(Boolean value) {
        paramValues.put(AverageParam.NOTONTRACK, value ? ONE : ZERO);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<AverageParam, Long> entry : paramValues.entrySet()) {
            append(builder, entry.getKey().getParameter(), entry.getValue());
        }
        for (Map.Entry<AverageRangeParam, List<Long>> entry : rangeParamValues.entrySet()) {
            for (Long value : entry.getValue()) {
                append(builder, entry.getKey().getParameter(), value);
            }
        }
        return builder.toString();
    }

    private void append(StringBuilder builder, String key, Long value) {
        if (value != null) {
            String concatSymbol = builder.length() == 0 ? "?" : "&";
            builder.append(concatSymbol);
            builder.append(key);
            builder.append("=");
            builder.append(value);
        }
    }
}
