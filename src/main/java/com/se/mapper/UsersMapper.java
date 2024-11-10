package com.se.mapper;

import com.se.domain.Roles;
import com.se.domain.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:40
 */
public interface UsersMapper {
    /**
     * @param username
     * @return
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "address", property = "address"),
            @Result(property = "roles",
                    column = "role_id",
                    javaType = Roles.class,
                    one = @One(select = "com.se.mapper.RolesMapper.getRolesById")
            )
    })
    List<Users> login(String username);

    /**
     * 根据用户表中的id值来查询对应的用户信息
     *
     * @param id
     * @return
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "address", property = "address"),
            @Result(property = "roles",
                    column = "role_id",
                    javaType = Roles.class,
                    one = @One(select = "com.se.mapper.RolesMapper.getRolesById")
            )
    })
    Users queryUsersById(int id);

    /**
     * 用户注册
     *
     * @param users
     * @return
     */
    @Insert("insert into users values(null,#{username},#{password},#{phone},#{address},#{roles.id})")
    int Enroll(Users users);


    /**
     * 判断用户名是否存在
     *
     * @param username
     * @return
     */
    @Select("select * from users where username = #{username}")
    Users sleUsername(String username);


    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select u.*,r.role from users u inner join roles r on u.role_id = r.id  ")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "address", property = "address"),
            @Result(column = "role_id", property = "roles.id"),
            @Result(column = "role", property = "roles.role")
    })
    List<Users> getAllUsers();


    /**
     * 查询所有用户
     *
     * @param username
     * @return
     */
    @Select("select u.*,r.role from users u inner join roles r on u.role_id = r.id where username = #{username}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "address", property = "address"),
            @Result(column = "role_id", property = "roles.id"),
            @Result(column = "role", property = "roles.role")
    })
    List<Users> getAllUsersByUsername(String username);

    /**
     * 修改用户信息
     *
     * @param users
     * @return
     */
    @Update("update users set username = #{username},password = #{password},phone = #{phone},address = #{address},role_id= #{roles.id} where id = #{id}")
    int updateUser(Users users);


    /**
     * 根据id或者用户名删除用户
     *
     * @param id
     * @return
     */
    @Delete("delete from users where id = #{id} or username = #{username}")
    int delUser(@Param("id") int id, @Param("username") String username);

    /**
     * 根据用户名模糊查询
     *
     * @param username
     * @return
     */
    @Select("select u.*,r.role from users u inner join roles r on u.role_id = r.id where username like #{username}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "address", property = "address"),
            @Result(column = "role_id", property = "roles.id"),
            @Result(column = "role", property = "roles.role")
    })
    List<Users> getSelUsersByUsername(@Param("username") String username);


    /**
     * 筛选
     *
     * @param username
     * @param role_id
     * @return
     */
    @Select("select u.*,r.role from users u inner join roles r on u.role_id = r.id where username like #{username} and role_id = #{role_id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "address", property = "address"),
            @Result(column = "role_id", property = "roles.id"),
            @Result(column = "role", property = "roles.role")
    })
    List<Users> getSelUsersByUser(@Param("username") String username, @Param("role_id") int role_id);

    /**
     * 根据用户名删除用户
     *
     * @param username
     * @return
     */
    @Delete("delete from users where username = #{username}")
    int delUserByUsername(String username);
}
