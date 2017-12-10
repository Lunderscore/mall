package com.ou.mall.bean;

import java.util.ArrayList;
import java.util.List;

public class ProductImgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductImgExample() {
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

        public Criteria andImgIdIsNull() {
            addCriterion("img_id is null");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNotNull() {
            addCriterion("img_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgIdEqualTo(Integer value) {
            addCriterion("img_id =", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotEqualTo(Integer value) {
            addCriterion("img_id <>", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThan(Integer value) {
            addCriterion("img_id >", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("img_id >=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThan(Integer value) {
            addCriterion("img_id <", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThanOrEqualTo(Integer value) {
            addCriterion("img_id <=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdIn(List<Integer> values) {
            addCriterion("img_id in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotIn(List<Integer> values) {
            addCriterion("img_id not in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdBetween(Integer value1, Integer value2) {
            addCriterion("img_id between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("img_id not between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgImg2IsNull() {
            addCriterion("img_img2 is null");
            return (Criteria) this;
        }

        public Criteria andImgImg2IsNotNull() {
            addCriterion("img_img2 is not null");
            return (Criteria) this;
        }

        public Criteria andImgImg2EqualTo(String value) {
            addCriterion("img_img2 =", value, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2NotEqualTo(String value) {
            addCriterion("img_img2 <>", value, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2GreaterThan(String value) {
            addCriterion("img_img2 >", value, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2GreaterThanOrEqualTo(String value) {
            addCriterion("img_img2 >=", value, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2LessThan(String value) {
            addCriterion("img_img2 <", value, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2LessThanOrEqualTo(String value) {
            addCriterion("img_img2 <=", value, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2Like(String value) {
            addCriterion("img_img2 like", value, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2NotLike(String value) {
            addCriterion("img_img2 not like", value, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2In(List<String> values) {
            addCriterion("img_img2 in", values, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2NotIn(List<String> values) {
            addCriterion("img_img2 not in", values, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2Between(String value1, String value2) {
            addCriterion("img_img2 between", value1, value2, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg2NotBetween(String value1, String value2) {
            addCriterion("img_img2 not between", value1, value2, "imgImg2");
            return (Criteria) this;
        }

        public Criteria andImgImg3IsNull() {
            addCriterion("img_img3 is null");
            return (Criteria) this;
        }

        public Criteria andImgImg3IsNotNull() {
            addCriterion("img_img3 is not null");
            return (Criteria) this;
        }

        public Criteria andImgImg3EqualTo(String value) {
            addCriterion("img_img3 =", value, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3NotEqualTo(String value) {
            addCriterion("img_img3 <>", value, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3GreaterThan(String value) {
            addCriterion("img_img3 >", value, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3GreaterThanOrEqualTo(String value) {
            addCriterion("img_img3 >=", value, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3LessThan(String value) {
            addCriterion("img_img3 <", value, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3LessThanOrEqualTo(String value) {
            addCriterion("img_img3 <=", value, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3Like(String value) {
            addCriterion("img_img3 like", value, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3NotLike(String value) {
            addCriterion("img_img3 not like", value, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3In(List<String> values) {
            addCriterion("img_img3 in", values, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3NotIn(List<String> values) {
            addCriterion("img_img3 not in", values, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3Between(String value1, String value2) {
            addCriterion("img_img3 between", value1, value2, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgImg3NotBetween(String value1, String value2) {
            addCriterion("img_img3 not between", value1, value2, "imgImg3");
            return (Criteria) this;
        }

        public Criteria andImgPidIsNull() {
            addCriterion("img_pid is null");
            return (Criteria) this;
        }

        public Criteria andImgPidIsNotNull() {
            addCriterion("img_pid is not null");
            return (Criteria) this;
        }

        public Criteria andImgPidEqualTo(Integer value) {
            addCriterion("img_pid =", value, "imgPid");
            return (Criteria) this;
        }

        public Criteria andImgPidNotEqualTo(Integer value) {
            addCriterion("img_pid <>", value, "imgPid");
            return (Criteria) this;
        }

        public Criteria andImgPidGreaterThan(Integer value) {
            addCriterion("img_pid >", value, "imgPid");
            return (Criteria) this;
        }

        public Criteria andImgPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("img_pid >=", value, "imgPid");
            return (Criteria) this;
        }

        public Criteria andImgPidLessThan(Integer value) {
            addCriterion("img_pid <", value, "imgPid");
            return (Criteria) this;
        }

        public Criteria andImgPidLessThanOrEqualTo(Integer value) {
            addCriterion("img_pid <=", value, "imgPid");
            return (Criteria) this;
        }

        public Criteria andImgPidIn(List<Integer> values) {
            addCriterion("img_pid in", values, "imgPid");
            return (Criteria) this;
        }

        public Criteria andImgPidNotIn(List<Integer> values) {
            addCriterion("img_pid not in", values, "imgPid");
            return (Criteria) this;
        }

        public Criteria andImgPidBetween(Integer value1, Integer value2) {
            addCriterion("img_pid between", value1, value2, "imgPid");
            return (Criteria) this;
        }

        public Criteria andImgPidNotBetween(Integer value1, Integer value2) {
            addCriterion("img_pid not between", value1, value2, "imgPid");
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