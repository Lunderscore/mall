package com.ou.mall.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductCommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("comment_content in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeIsNull() {
            addCriterion("comment_date_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeIsNotNull() {
            addCriterion("comment_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeEqualTo(Date value) {
            addCriterion("comment_date_time =", value, "commentDateTime");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeNotEqualTo(Date value) {
            addCriterion("comment_date_time <>", value, "commentDateTime");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeGreaterThan(Date value) {
            addCriterion("comment_date_time >", value, "commentDateTime");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_date_time >=", value, "commentDateTime");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeLessThan(Date value) {
            addCriterion("comment_date_time <", value, "commentDateTime");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_date_time <=", value, "commentDateTime");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeIn(List<Date> values) {
            addCriterion("comment_date_time in", values, "commentDateTime");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeNotIn(List<Date> values) {
            addCriterion("comment_date_time not in", values, "commentDateTime");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeBetween(Date value1, Date value2) {
            addCriterion("comment_date_time between", value1, value2, "commentDateTime");
            return (Criteria) this;
        }

        public Criteria andCommentDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_date_time not between", value1, value2, "commentDateTime");
            return (Criteria) this;
        }

        public Criteria andCommentUidIsNull() {
            addCriterion("comment_uid is null");
            return (Criteria) this;
        }

        public Criteria andCommentUidIsNotNull() {
            addCriterion("comment_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUidEqualTo(Integer value) {
            addCriterion("comment_uid =", value, "commentUid");
            return (Criteria) this;
        }

        public Criteria andCommentUidNotEqualTo(Integer value) {
            addCriterion("comment_uid <>", value, "commentUid");
            return (Criteria) this;
        }

        public Criteria andCommentUidGreaterThan(Integer value) {
            addCriterion("comment_uid >", value, "commentUid");
            return (Criteria) this;
        }

        public Criteria andCommentUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_uid >=", value, "commentUid");
            return (Criteria) this;
        }

        public Criteria andCommentUidLessThan(Integer value) {
            addCriterion("comment_uid <", value, "commentUid");
            return (Criteria) this;
        }

        public Criteria andCommentUidLessThanOrEqualTo(Integer value) {
            addCriterion("comment_uid <=", value, "commentUid");
            return (Criteria) this;
        }

        public Criteria andCommentUidIn(List<Integer> values) {
            addCriterion("comment_uid in", values, "commentUid");
            return (Criteria) this;
        }

        public Criteria andCommentUidNotIn(List<Integer> values) {
            addCriterion("comment_uid not in", values, "commentUid");
            return (Criteria) this;
        }

        public Criteria andCommentUidBetween(Integer value1, Integer value2) {
            addCriterion("comment_uid between", value1, value2, "commentUid");
            return (Criteria) this;
        }

        public Criteria andCommentUidNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_uid not between", value1, value2, "commentUid");
            return (Criteria) this;
        }

        public Criteria andCommentPidIsNull() {
            addCriterion("comment_pid is null");
            return (Criteria) this;
        }

        public Criteria andCommentPidIsNotNull() {
            addCriterion("comment_pid is not null");
            return (Criteria) this;
        }

        public Criteria andCommentPidEqualTo(Integer value) {
            addCriterion("comment_pid =", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidNotEqualTo(Integer value) {
            addCriterion("comment_pid <>", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidGreaterThan(Integer value) {
            addCriterion("comment_pid >", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_pid >=", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidLessThan(Integer value) {
            addCriterion("comment_pid <", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidLessThanOrEqualTo(Integer value) {
            addCriterion("comment_pid <=", value, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidIn(List<Integer> values) {
            addCriterion("comment_pid in", values, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidNotIn(List<Integer> values) {
            addCriterion("comment_pid not in", values, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidBetween(Integer value1, Integer value2) {
            addCriterion("comment_pid between", value1, value2, "commentPid");
            return (Criteria) this;
        }

        public Criteria andCommentPidNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_pid not between", value1, value2, "commentPid");
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