package com.ou.mall.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserOrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Integer value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Integer value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Integer value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Integer value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Integer> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Integer> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeIsNull() {
            addCriterion("order_date_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeIsNotNull() {
            addCriterion("order_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeEqualTo(Date value) {
            addCriterion("order_date_time =", value, "orderDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeNotEqualTo(Date value) {
            addCriterion("order_date_time <>", value, "orderDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeGreaterThan(Date value) {
            addCriterion("order_date_time >", value, "orderDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_date_time >=", value, "orderDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeLessThan(Date value) {
            addCriterion("order_date_time <", value, "orderDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_date_time <=", value, "orderDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeIn(List<Date> values) {
            addCriterion("order_date_time in", values, "orderDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeNotIn(List<Date> values) {
            addCriterion("order_date_time not in", values, "orderDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeBetween(Date value1, Date value2) {
            addCriterion("order_date_time between", value1, value2, "orderDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_date_time not between", value1, value2, "orderDateTime");
            return (Criteria) this;
        }

        public Criteria andOrderPidIsNull() {
            addCriterion("order_pid is null");
            return (Criteria) this;
        }

        public Criteria andOrderPidIsNotNull() {
            addCriterion("order_pid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPidEqualTo(Integer value) {
            addCriterion("order_pid =", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidNotEqualTo(Integer value) {
            addCriterion("order_pid <>", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidGreaterThan(Integer value) {
            addCriterion("order_pid >", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_pid >=", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidLessThan(Integer value) {
            addCriterion("order_pid <", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidLessThanOrEqualTo(Integer value) {
            addCriterion("order_pid <=", value, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidIn(List<Integer> values) {
            addCriterion("order_pid in", values, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidNotIn(List<Integer> values) {
            addCriterion("order_pid not in", values, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidBetween(Integer value1, Integer value2) {
            addCriterion("order_pid between", value1, value2, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderPidNotBetween(Integer value1, Integer value2) {
            addCriterion("order_pid not between", value1, value2, "orderPid");
            return (Criteria) this;
        }

        public Criteria andOrderUidIsNull() {
            addCriterion("order_uid is null");
            return (Criteria) this;
        }

        public Criteria andOrderUidIsNotNull() {
            addCriterion("order_uid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUidEqualTo(Integer value) {
            addCriterion("order_uid =", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidNotEqualTo(Integer value) {
            addCriterion("order_uid <>", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidGreaterThan(Integer value) {
            addCriterion("order_uid >", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_uid >=", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidLessThan(Integer value) {
            addCriterion("order_uid <", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidLessThanOrEqualTo(Integer value) {
            addCriterion("order_uid <=", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidIn(List<Integer> values) {
            addCriterion("order_uid in", values, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidNotIn(List<Integer> values) {
            addCriterion("order_uid not in", values, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidBetween(Integer value1, Integer value2) {
            addCriterion("order_uid between", value1, value2, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidNotBetween(Integer value1, Integer value2) {
            addCriterion("order_uid not between", value1, value2, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameIsNull() {
            addCriterion("order_person_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameIsNotNull() {
            addCriterion("order_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameEqualTo(String value) {
            addCriterion("order_person_name =", value, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameNotEqualTo(String value) {
            addCriterion("order_person_name <>", value, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameGreaterThan(String value) {
            addCriterion("order_person_name >", value, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_person_name >=", value, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameLessThan(String value) {
            addCriterion("order_person_name <", value, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameLessThanOrEqualTo(String value) {
            addCriterion("order_person_name <=", value, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameLike(String value) {
            addCriterion("order_person_name like", value, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameNotLike(String value) {
            addCriterion("order_person_name not like", value, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameIn(List<String> values) {
            addCriterion("order_person_name in", values, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameNotIn(List<String> values) {
            addCriterion("order_person_name not in", values, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameBetween(String value1, String value2) {
            addCriterion("order_person_name between", value1, value2, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPersonNameNotBetween(String value1, String value2) {
            addCriterion("order_person_name not between", value1, value2, "orderPersonName");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneIsNull() {
            addCriterion("order_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneIsNotNull() {
            addCriterion("order_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneEqualTo(String value) {
            addCriterion("order_phone =", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneNotEqualTo(String value) {
            addCriterion("order_phone <>", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneGreaterThan(String value) {
            addCriterion("order_phone >", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_phone >=", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneLessThan(String value) {
            addCriterion("order_phone <", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneLessThanOrEqualTo(String value) {
            addCriterion("order_phone <=", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneLike(String value) {
            addCriterion("order_phone like", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneNotLike(String value) {
            addCriterion("order_phone not like", value, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneIn(List<String> values) {
            addCriterion("order_phone in", values, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneNotIn(List<String> values) {
            addCriterion("order_phone not in", values, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneBetween(String value1, String value2) {
            addCriterion("order_phone between", value1, value2, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderPhoneNotBetween(String value1, String value2) {
            addCriterion("order_phone not between", value1, value2, "orderPhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIsNull() {
            addCriterion("order_address is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIsNotNull() {
            addCriterion("order_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddressEqualTo(String value) {
            addCriterion("order_address =", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotEqualTo(String value) {
            addCriterion("order_address <>", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressGreaterThan(String value) {
            addCriterion("order_address >", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("order_address >=", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLessThan(String value) {
            addCriterion("order_address <", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLessThanOrEqualTo(String value) {
            addCriterion("order_address <=", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressLike(String value) {
            addCriterion("order_address like", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotLike(String value) {
            addCriterion("order_address not like", value, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressIn(List<String> values) {
            addCriterion("order_address in", values, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotIn(List<String> values) {
            addCriterion("order_address not in", values, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressBetween(String value1, String value2) {
            addCriterion("order_address between", value1, value2, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddressNotBetween(String value1, String value2) {
            addCriterion("order_address not between", value1, value2, "orderAddress");
            return (Criteria) this;
        }

        public Criteria andOrderMessageIsNull() {
            addCriterion("order_message is null");
            return (Criteria) this;
        }

        public Criteria andOrderMessageIsNotNull() {
            addCriterion("order_message is not null");
            return (Criteria) this;
        }

        public Criteria andOrderMessageEqualTo(String value) {
            addCriterion("order_message =", value, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageNotEqualTo(String value) {
            addCriterion("order_message <>", value, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageGreaterThan(String value) {
            addCriterion("order_message >", value, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageGreaterThanOrEqualTo(String value) {
            addCriterion("order_message >=", value, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageLessThan(String value) {
            addCriterion("order_message <", value, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageLessThanOrEqualTo(String value) {
            addCriterion("order_message <=", value, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageLike(String value) {
            addCriterion("order_message like", value, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageNotLike(String value) {
            addCriterion("order_message not like", value, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageIn(List<String> values) {
            addCriterion("order_message in", values, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageNotIn(List<String> values) {
            addCriterion("order_message not in", values, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageBetween(String value1, String value2) {
            addCriterion("order_message between", value1, value2, "orderMessage");
            return (Criteria) this;
        }

        public Criteria andOrderMessageNotBetween(String value1, String value2) {
            addCriterion("order_message not between", value1, value2, "orderMessage");
            return (Criteria) this;
        }
        
//        andProductTitleLike
        public Criteria andProductTitleLike(String value) {
            addCriterion("product_title like", "%"+value+"%", "productTitle");
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