package com.hotel.luck.bean;

import java.util.ArrayList;
import java.util.List;

public class sensorUsingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public sensorUsingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSensorusingIdIsNull() {
            addCriterion("sensorUsing_id is null");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdIsNotNull() {
            addCriterion("sensorUsing_id is not null");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdEqualTo(Integer value) {
            addCriterion("sensorUsing_id =", value, "sensorusingId");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdNotEqualTo(Integer value) {
            addCriterion("sensorUsing_id <>", value, "sensorusingId");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdGreaterThan(Integer value) {
            addCriterion("sensorUsing_id >", value, "sensorusingId");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sensorUsing_id >=", value, "sensorusingId");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdLessThan(Integer value) {
            addCriterion("sensorUsing_id <", value, "sensorusingId");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdLessThanOrEqualTo(Integer value) {
            addCriterion("sensorUsing_id <=", value, "sensorusingId");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdIn(List<Integer> values) {
            addCriterion("sensorUsing_id in", values, "sensorusingId");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdNotIn(List<Integer> values) {
            addCriterion("sensorUsing_id not in", values, "sensorusingId");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdBetween(Integer value1, Integer value2) {
            addCriterion("sensorUsing_id between", value1, value2, "sensorusingId");
            return (Criteria) this;
        }

        public Criteria andSensorusingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sensorUsing_id not between", value1, value2, "sensorusingId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Integer value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Integer value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Integer value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Integer value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Integer> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Integer> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andTempIsNull() {
            addCriterion("temp is null");
            return (Criteria) this;
        }

        public Criteria andTempIsNotNull() {
            addCriterion("temp is not null");
            return (Criteria) this;
        }

        public Criteria andTempEqualTo(String value) {
            addCriterion("temp =", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotEqualTo(String value) {
            addCriterion("temp <>", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempGreaterThan(String value) {
            addCriterion("temp >", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempGreaterThanOrEqualTo(String value) {
            addCriterion("temp >=", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLessThan(String value) {
            addCriterion("temp <", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLessThanOrEqualTo(String value) {
            addCriterion("temp <=", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLike(String value) {
            addCriterion("temp like", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotLike(String value) {
            addCriterion("temp not like", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempIn(List<String> values) {
            addCriterion("temp in", values, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotIn(List<String> values) {
            addCriterion("temp not in", values, "temp");
            return (Criteria) this;
        }

        public Criteria andTempBetween(String value1, String value2) {
            addCriterion("temp between", value1, value2, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotBetween(String value1, String value2) {
            addCriterion("temp not between", value1, value2, "temp");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNull() {
            addCriterion("humidity is null");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNotNull() {
            addCriterion("humidity is not null");
            return (Criteria) this;
        }

        public Criteria andHumidityEqualTo(String value) {
            addCriterion("humidity =", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotEqualTo(String value) {
            addCriterion("humidity <>", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThan(String value) {
            addCriterion("humidity >", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThanOrEqualTo(String value) {
            addCriterion("humidity >=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThan(String value) {
            addCriterion("humidity <", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThanOrEqualTo(String value) {
            addCriterion("humidity <=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLike(String value) {
            addCriterion("humidity like", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotLike(String value) {
            addCriterion("humidity not like", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityIn(List<String> values) {
            addCriterion("humidity in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotIn(List<String> values) {
            addCriterion("humidity not in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityBetween(String value1, String value2) {
            addCriterion("humidity between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotBetween(String value1, String value2) {
            addCriterion("humidity not between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andFireIsNull() {
            addCriterion("fire is null");
            return (Criteria) this;
        }

        public Criteria andFireIsNotNull() {
            addCriterion("fire is not null");
            return (Criteria) this;
        }

        public Criteria andFireEqualTo(String value) {
            addCriterion("fire =", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireNotEqualTo(String value) {
            addCriterion("fire <>", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireGreaterThan(String value) {
            addCriterion("fire >", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireGreaterThanOrEqualTo(String value) {
            addCriterion("fire >=", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireLessThan(String value) {
            addCriterion("fire <", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireLessThanOrEqualTo(String value) {
            addCriterion("fire <=", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireLike(String value) {
            addCriterion("fire like", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireNotLike(String value) {
            addCriterion("fire not like", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireIn(List<String> values) {
            addCriterion("fire in", values, "fire");
            return (Criteria) this;
        }

        public Criteria andFireNotIn(List<String> values) {
            addCriterion("fire not in", values, "fire");
            return (Criteria) this;
        }

        public Criteria andFireBetween(String value1, String value2) {
            addCriterion("fire between", value1, value2, "fire");
            return (Criteria) this;
        }

        public Criteria andFireNotBetween(String value1, String value2) {
            addCriterion("fire not between", value1, value2, "fire");
            return (Criteria) this;
        }

        public Criteria andShineIsNull() {
            addCriterion("shine is null");
            return (Criteria) this;
        }

        public Criteria andShineIsNotNull() {
            addCriterion("shine is not null");
            return (Criteria) this;
        }

        public Criteria andShineEqualTo(String value) {
            addCriterion("shine =", value, "shine");
            return (Criteria) this;
        }

        public Criteria andShineNotEqualTo(String value) {
            addCriterion("shine <>", value, "shine");
            return (Criteria) this;
        }

        public Criteria andShineGreaterThan(String value) {
            addCriterion("shine >", value, "shine");
            return (Criteria) this;
        }

        public Criteria andShineGreaterThanOrEqualTo(String value) {
            addCriterion("shine >=", value, "shine");
            return (Criteria) this;
        }

        public Criteria andShineLessThan(String value) {
            addCriterion("shine <", value, "shine");
            return (Criteria) this;
        }

        public Criteria andShineLessThanOrEqualTo(String value) {
            addCriterion("shine <=", value, "shine");
            return (Criteria) this;
        }

        public Criteria andShineLike(String value) {
            addCriterion("shine like", value, "shine");
            return (Criteria) this;
        }

        public Criteria andShineNotLike(String value) {
            addCriterion("shine not like", value, "shine");
            return (Criteria) this;
        }

        public Criteria andShineIn(List<String> values) {
            addCriterion("shine in", values, "shine");
            return (Criteria) this;
        }

        public Criteria andShineNotIn(List<String> values) {
            addCriterion("shine not in", values, "shine");
            return (Criteria) this;
        }

        public Criteria andShineBetween(String value1, String value2) {
            addCriterion("shine between", value1, value2, "shine");
            return (Criteria) this;
        }

        public Criteria andShineNotBetween(String value1, String value2) {
            addCriterion("shine not between", value1, value2, "shine");
            return (Criteria) this;
        }

        public Criteria andTvocIsNull() {
            addCriterion("TVOC is null");
            return (Criteria) this;
        }

        public Criteria andTvocIsNotNull() {
            addCriterion("TVOC is not null");
            return (Criteria) this;
        }

        public Criteria andTvocEqualTo(String value) {
            addCriterion("TVOC =", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocNotEqualTo(String value) {
            addCriterion("TVOC <>", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocGreaterThan(String value) {
            addCriterion("TVOC >", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocGreaterThanOrEqualTo(String value) {
            addCriterion("TVOC >=", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocLessThan(String value) {
            addCriterion("TVOC <", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocLessThanOrEqualTo(String value) {
            addCriterion("TVOC <=", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocLike(String value) {
            addCriterion("TVOC like", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocNotLike(String value) {
            addCriterion("TVOC not like", value, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocIn(List<String> values) {
            addCriterion("TVOC in", values, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocNotIn(List<String> values) {
            addCriterion("TVOC not in", values, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocBetween(String value1, String value2) {
            addCriterion("TVOC between", value1, value2, "tvoc");
            return (Criteria) this;
        }

        public Criteria andTvocNotBetween(String value1, String value2) {
            addCriterion("TVOC not between", value1, value2, "tvoc");
            return (Criteria) this;
        }

        public Criteria andCo2IsNull() {
            addCriterion("CO2 is null");
            return (Criteria) this;
        }

        public Criteria andCo2IsNotNull() {
            addCriterion("CO2 is not null");
            return (Criteria) this;
        }

        public Criteria andCo2EqualTo(String value) {
            addCriterion("CO2 =", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2NotEqualTo(String value) {
            addCriterion("CO2 <>", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2GreaterThan(String value) {
            addCriterion("CO2 >", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2GreaterThanOrEqualTo(String value) {
            addCriterion("CO2 >=", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2LessThan(String value) {
            addCriterion("CO2 <", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2LessThanOrEqualTo(String value) {
            addCriterion("CO2 <=", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2Like(String value) {
            addCriterion("CO2 like", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2NotLike(String value) {
            addCriterion("CO2 not like", value, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2In(List<String> values) {
            addCriterion("CO2 in", values, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2NotIn(List<String> values) {
            addCriterion("CO2 not in", values, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2Between(String value1, String value2) {
            addCriterion("CO2 between", value1, value2, "co2");
            return (Criteria) this;
        }

        public Criteria andCo2NotBetween(String value1, String value2) {
            addCriterion("CO2 not between", value1, value2, "co2");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("point is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("point is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(String value) {
            addCriterion("point =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(String value) {
            addCriterion("point <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(String value) {
            addCriterion("point >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(String value) {
            addCriterion("point >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(String value) {
            addCriterion("point <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(String value) {
            addCriterion("point <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLike(String value) {
            addCriterion("point like", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotLike(String value) {
            addCriterion("point not like", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<String> values) {
            addCriterion("point in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<String> values) {
            addCriterion("point not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(String value1, String value2) {
            addCriterion("point between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(String value1, String value2) {
            addCriterion("point not between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}