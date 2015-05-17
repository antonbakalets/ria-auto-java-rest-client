package com.ria.auto.api.types;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CriteriaBuilderTest {

    @Test
    public void emptyTest() {
        CriteriaBuilder builder = new CriteriaBuilder();
        assertEquals("", builder.toString());
    }

    @Test
    public void nullParamTest() {
        CriteriaBuilder builder = new CriteriaBuilder();
        builder.setCategory(null).setBodyStyle(null);
        assertEquals("", builder.toString());
    }

    @Test
    public void longParamTest() {
        CriteriaBuilder builder = new CriteriaBuilder();
        builder.setCategory(0L).setBodyStyle(1L).setBrand(-1L);
        assertEquals("?main_category=0&body_id=1&marka_id=-1", builder.toString());
    }

    @Test
    public void booleanParamTest() {
        CriteriaBuilder builder = new CriteriaBuilder();
        builder.setConfiscated(true).setCredit(false).setNotOnTrack(true).setCustom(false);
        assertEquals("?custom=0&under_credit=0&confiscated_car=1&onRepairParts=1", builder.toString());
    }

    @Test
    public void nullRangeParamTest() {
        CriteriaBuilder builder = new CriteriaBuilder();
        builder.setYears((Long) null).setMileage((Long) null).setOptions((Long) null);
        assertEquals("", builder.toString());

        builder = new CriteriaBuilder();
        builder.setYears(null, null).setMileage(null, null).setOptions(null, null);
        assertEquals("", builder.toString());
    }

    @Test
    public void rangeParam1Test() {
        CriteriaBuilder builder = new CriteriaBuilder();
        builder.setYears(1234L).setMileage(100000L).setOptions(1L);
        assertEquals("?yers=1234&options=1&raceInt=100000", builder.toString());
    }

    @Test
    public void rangeParam2Test() {
        CriteriaBuilder builder = new CriteriaBuilder();
        builder.setYears(1234L, 1999L).setMileage(10L, 1000L, 20L).setOptions(1L, 2L);
        assertEquals("?yers=1234&yers=1999&options=1&options=2&raceInt=10&raceInt=1000&raceInt=20", builder.toString());
    }
}