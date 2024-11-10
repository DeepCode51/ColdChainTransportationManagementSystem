package com.se.mapper;

import com.se.domain.Roles;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 21:38
 */
public interface RolesMapper {
    /**
     * 根据id查询角色信息
     *
     * @param id
     * @return
     */
    @Select("select * from roles where id = #{id}")
    List<Roles> getRolesById(int id);
}
