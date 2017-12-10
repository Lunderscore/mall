package com.ou.mall.bean;

public class UserAvatar {
    private Integer avatarId;

    private String avatarUri;

    private Integer avatarUid;

    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri == null ? null : avatarUri.trim();
    }

    public Integer getAvatarUid() {
        return avatarUid;
    }

    public void setAvatarUid(Integer avatarUid) {
        this.avatarUid = avatarUid;
    }
}