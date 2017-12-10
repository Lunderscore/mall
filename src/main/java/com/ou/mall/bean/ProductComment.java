package com.ou.mall.bean;

import java.util.Date;

public class ProductComment {
    private Integer commentId;

    private String commentContent;

    private Date commentDateTime;

    private Integer commentUid;

    private Integer commentPid;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentDateTime() {
        return commentDateTime;
    }

    public void setCommentDateTime(Date commentDateTime) {
        this.commentDateTime = commentDateTime;
    }

    public Integer getCommentUid() {
        return commentUid;
    }

    public void setCommentUid(Integer commentUid) {
        this.commentUid = commentUid;
    }

    public Integer getCommentPid() {
        return commentPid;
    }

    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }
}