package com.ria.auto.api.types;

public enum AverageParam {

    CATEGORY("main_category"),
    BODYSTYLE("body_id"),
    BRAND("marka_id"),
    MODEL("model_id"),
    GEARBOX("gear_id"),
    FUELTYPE("fuel_id"),
    POWERTRAIN("drive_id"),
    DOORSNUMBER("door"),
    REGION("state_id"),
    CITY("city_id"),
    CARRYING("carrying"),
    SEATSNUMBER("seats"),
    COLOUR("color_id"),
    CUSTOM("custom"),
    DAMAGED("damage"),
    CREDIT("under_credit"),
    CONFISCATED("confiscated_car"),
    NOTONTRACK("onRepairParts");

    private String parameter;

    AverageParam(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
