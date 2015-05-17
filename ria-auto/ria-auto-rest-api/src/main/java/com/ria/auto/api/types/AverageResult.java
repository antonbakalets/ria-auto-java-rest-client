package com.ria.auto.api.types;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class AverageResult {

    private Long total;
    private BigDecimal arithmeticMean;
    private BigDecimal interQuartileMean;
    private Map<BigDecimal, BigDecimal> percentiles;
    private List<BigDecimal> prices;
    private List<String> classifieds;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public BigDecimal getArithmeticMean() {
        return arithmeticMean;
    }

    public void setArithmeticMean(BigDecimal arithmeticMean) {
        this.arithmeticMean = arithmeticMean;
    }

    public BigDecimal getInterQuartileMean() {
        return interQuartileMean;
    }

    public void setInterQuartileMean(BigDecimal interQuartileMean) {
        this.interQuartileMean = interQuartileMean;
    }

    public Map<BigDecimal, BigDecimal> getPercentiles() {
        return percentiles;
    }

    public void setPercentiles(Map<BigDecimal, BigDecimal> percentiles) {
        this.percentiles = percentiles;
    }

    public List<BigDecimal> getPrices() {
        return prices;
    }

    public void setPrices(List<BigDecimal> prices) {
        this.prices = prices;
    }

    public List<String> getClassifieds() {
        return classifieds;
    }

    public void setClassifieds(List<String> classifieds) {
        this.classifieds = classifieds;
    }
}
