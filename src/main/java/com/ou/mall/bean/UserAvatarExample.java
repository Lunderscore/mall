package com.ou.mall.bean;

import java.util.ArrayList;
import java.util.List;

public class UserAvatarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAvatarExample() {
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

        public Criteria andAvatarIdIsNull() {
            addCriterion("avatar_id is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIdIsNotNull() {
            addCriterion("avatar_id is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarIdEqualTo(Integer value) {
            addCriterion("avatar_id =", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdNotEqualTo(Integer value) {
            addCriterion("avatar_id <>", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdGreaterThan(Integer value) {
            addCriterion("avatar_id >", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("avatar_id >=", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdLessThan(Integer value) {
            addCriterion("avatar_id <", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdLessThanOrEqualTo(Integer value) {
            addCriterion("avatar_id <=", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdIn(List<Integer> values) {
            addCriterion("avatar_id in", values, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdNotIn(List<Integer> values) {
            addCriterion("avatar_id not in", values, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdBetween(Integer value1, Integer value2) {
            addCriterion("avatar_id between", value1, value2, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("avatar_id not between", value1, value2, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarUriIsNull() {
            addCriterion("avatar_uri is null");
            return (Criteria) this;
        }

        public Criteria andAvatarUriIsNotNull() {
            addCriterion("avatar_uri is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarUriEqualTo(String value) {
            addCriterion("avatar_uri =", value, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriNotEqualTo(String value) {
            addCriterion("avatar_uri <>", value, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriGreaterThan(String value) {
            addCriterion("avatar_uri >", value, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_uri >=", value, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriLessThan(String value) {
            addCriterion("avatar_uri <", value, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriLessThanOrEqualTo(String value) {
            addCriterion("avatar_uri <=", value, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriLike(String value) {
            addCriterion("avatar_uri like", value, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriNotLike(String value) {
            addCriterion("avatar_uri not like", value, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriIn(List<String> values) {
            addCriterion("avatar_uri in", values, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriNotIn(List<String> values) {
            addCriterion("avatar_uri not in", values, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriBetween(String value1, String value2) {
            addCriterion("avatar_uri between", value1, value2, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUriNotBetween(String value1, String value2) {
            addCriterion("avatar_uri not between", value1, value2, "avatarUri");
            return (Criteria) this;
        }

        public Criteria andAvatarUidIsNull() {
            addCriterion("avatar_uid is null");
            return (Criteria) this;
        }

        public Criteria andAvatarUidIsNotNull() {
            addCriterion("avatar_uid is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarUidEqualTo(Integer value) {
            addCriterion("avatar_uid =", value, "avatarUid");
            return (Criteria) this;
        }

        public Criteria andAvatarUidNotEqualTo(Integer value) {
            addCriterion("avatar_uid <>", value, "avatarUid");
            return (Criteria) this;
        }

        public Criteria andAvatarUidGreaterThan(Integer value) {
            addCriterion("avatar_uid >", value, "avatarUid");
            return (Criteria) this;
        }

        public Criteria andAvatarUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("avatar_uid >=", value, "avatarUid");
            return (Criteria) this;
        }

        public Criteria andAvatarUidLessThan(Integer value) {
            addCriterion("avatar_uid <", value, "avatarUid");
            return (Criteria) this;
        }

        public Criteria andAvatarUidLessThanOrEqualTo(Integer value) {
            addCriterion("avatar_uid <=", value, "avatarUid");
            return (Criteria) this;
        }

        public Criteria andAvatarUidIn(List<Integer> values) {
            addCriterion("avatar_uid in", values, "avatarUid");
            return (Criteria) this;
        }

        public Criteria andAvatarUidNotIn(List<Integer> values) {
            addCriterion("avatar_uid not in", values, "avatarUid");
            return (Criteria) this;
        }

        public Criteria andAvatarUidBetween(Integer value1, Integer value2) {
            addCriterion("avatar_uid between", value1, value2, "avatarUid");
            return (Criteria) this;
        }

        public Criteria andAvatarUidNotBetween(Integer value1, Integer value2) {
            addCriterion("avatar_uid not between", value1, value2, "avatarUid");
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