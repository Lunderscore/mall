package com.ou.mall.dao;

import com.ou.mall.bean.UserAvatar;
import com.ou.mall.bean.UserAvatarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAvatarMapper {
    long countByExample(UserAvatarExample example);

    int deleteByExample(UserAvatarExample example);

    int deleteByPrimaryKey(Integer avatarId);

    int insert(UserAvatar record);

    int insertSelective(UserAvatar record);

    List<UserAvatar> selectByExample(UserAvatarExample example);

    UserAvatar selectByPrimaryKey(Integer avatarId);

    int updateByExampleSelective(@Param("record") UserAvatar record, @Param("example") UserAvatarExample example);

    int updateByExample(@Param("record") UserAvatar record, @Param("example") UserAvatarExample example);

    int updateByPrimaryKeySelective(UserAvatar record);

    int updateByPrimaryKey(UserAvatar record);
}