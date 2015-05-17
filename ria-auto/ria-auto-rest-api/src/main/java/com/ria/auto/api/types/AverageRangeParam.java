package com.ria.auto.api.types;

public enum AverageRangeParam {

    YEARS("yers"),
    OPTIONS("options"),
    MILEAGE("raceInt");

    private String parameter;

    AverageRangeParam(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
