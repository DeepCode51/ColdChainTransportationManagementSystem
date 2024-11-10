package com.se.mapper;

import com.se.domain.Paths;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:48
 */
public interface PathsMapper {

    @Select("select * from paths where id = #{id}")
    Paths queryPathsById(int id);

    @Select("select * from paths")
    List<Paths> queryPaths();

    @Select("select * from paths where path = #{path}")
    List<Paths> judgePathsExist(String path);

    @Insert("insert into paths values(null,#{paths.path},#{paths.path_start},#{paths.path_end},#{paths.path_way},#{paths.path_money})")
    int addPaths(@Param("paths") Paths paths);

    @Select("select * from paths where path like concat('%',#{path},'%')")
    List<Paths> searchPathsBypath(String path);

    @Select("select * from paths where path_start like concat('%',#{searchMsg},'%') or" +
            " path_end like concat('%',#{searchMsg},'%') or path_way like concat('%',#{searchMsg},'%')")
    List<Paths> searchPathsByMsg(@Param("searchMsg") String searchMsg);

    @Update("update paths set path = #{paths.path},path_start = #{paths.path_start},path_end = #{paths.path_end}," +
            "path_way = #{paths.path_way},path_money = #{paths.path_money} where id = #{paths.id}")
    int modifyPaths(@Param("paths") Paths paths);
}
