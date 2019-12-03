package com.hejsr.daily.modules.user.mapper;

import com.hejsr.daily.modules.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    UserEntity selectByUsername(String username);
}