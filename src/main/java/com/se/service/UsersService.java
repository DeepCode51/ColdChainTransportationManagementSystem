package com.se.service;

import com.se.domain.Users;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:41
 */
public interface UsersService {
    List<Users> login(String username);

    /**
     * 用户注册
     *
     * @param users
     * @return
     */
    boolean Enroll(Users users);

    /**
     * 判断用户名是否存在
     *
     * @param username
     * @return
     */
    boolean selUsername(String username);

    /**
     * 查询所有信息
     *
     * @param
     * @return
     */
    List<Users> getAllUsers();


    /**
     * 根据用户名查询个人信息
     *
     * @param username
     * @return
     */
    List<Users> getAllUsersByUsername(String username);

    /**
     * 修改用户信息
     *
     * @param users
     * @return
     */
    boolean updateUser(Users users);

    /**
     * 根据id或者用户名删除账户
     *
     * @param id
     * @param username
     * @return
     */
    boolean delUser(int id, String username);

    /**
     * 根据用户名模糊查询
     *
     * @param username
     * @return
     */
    List<Users> getSelUsersByUsername(String username);

    /**
     * 筛选
     *
     * @param username
     * @param role_id
     * @return
     */
    List<Users> getSelUsersByUsers(String username, int role_id);


    /**
     * 根据用户名删除
     *
     * @param username
     * @return
     */
    boolean delUserByUsername(String username);
}
