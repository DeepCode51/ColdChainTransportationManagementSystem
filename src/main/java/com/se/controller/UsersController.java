package com.se.controller;

import com.se.domain.Roles;
import com.se.domain.Users;
import com.se.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:40
 */
@Controller
@ResponseBody
@RequestMapping("/users")

public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 用户登录模块，对传过来的数据进行封装，存入session，进行拦截判断是否是非法访问
     *
     * @param username
     * @param password
     * @param role
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public List login(String username, String password, String role, HttpSession session) {
        List list = new ArrayList();
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        Roles roles = new Roles();
        roles.setRole(role);
        users.setRoles(roles);
        List<Users> ul = usersService.login(username);
        if (!ul.isEmpty()) {
            if (ul.get(0).getPassword().equals(password) && ul.get(0).getRoles().getRole().equals(role)) {
                session.setAttribute("users", users);
                list.add("true");
            } else if (ul.get(0).getPassword().equals(password) && !ul.get(0).getRoles().getRole().equals(role)) {
                list.add("roleFalse");
            } else {
                list.add("passwordFalse");
            }
        } else {
            list.add("usernameFalse");
        }
        return list;
    }

    /**
     * 注册
     *
     * @param username
     * @param password
     * @param phone
     * @param address
     * @return
     */
    @RequestMapping(value = "/enroll", method = RequestMethod.POST)
    public List Enroll(String username, String password, String phone, String address, String role) {
        List list = new ArrayList();
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        users.setPhone(phone);
        users.setAddress(address);
        Roles roles = new Roles();
        roles.setRole(role);
        if ("用户".equals(role)) {
            roles.setId(2);
        } else if ("管理员".equals(role)) {
            roles.setId(1);
        }
        users.setRoles(roles);
        System.out.println("==================================================" + users);
        boolean enroll = usersService.Enroll(users);
        if (enroll) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }


    /**
     * 查询用户名是否存在
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/selUsername", method = RequestMethod.POST)
    public List selUsername(String username) {
        List list = new ArrayList();
        boolean enroll = usersService.selUsername(username);
        if (enroll) {
            list.add("true");
        } else {
            list.add("false");
        }
        System.out.println(list);
        return list;
    }


    /**
     * 查询所有用户
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.POST)
    public List getAllUsers(String username, String role) {
        List<Users> list = new ArrayList<Users>();
        if ("管理员".equals(role)) {
            list = usersService.getAllUsers();
        } else if ("用户".equals(role)) {
            list = usersService.getAllUsersByUsername(username);
        }
        return list;
    }


    /**
     * 根据用户名修改用户
     *
     * @param id
     * @param username
     * @param password
     * @param phone
     * @param address
     * @param role
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public List updateUser(int id, String username, String password, String phone, String address, String role) {
        List list = new ArrayList();
        Users users = new Users();
        users.setId(id);
        users.setUsername(username);
        users.setPassword(password);
        users.setPhone(phone);
        users.setAddress(address);
        Roles roles = new Roles();
        roles.setRole(role);
        if ("用户".equals(role)) {
            roles.setId(2);
        } else if ("管理员".equals(role)) {
            roles.setId(1);
        }
        users.setRoles(roles);
        System.out.println("==================================================" + users);
        boolean enroll = usersService.updateUser(users);
        ;
        if (enroll) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }


    /**
     * 根据id或者用户名删除用户
     *
     * @param id
     * @param username
     * @return
     */
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public List delUser(int id, String username) {
        System.out.println(id + "==" + username);
        List list = new ArrayList();
        boolean bool = usersService.delUser(id, username);
        ;
        if (bool) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }


    /**
     * 根据用户名模糊查询
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/selUserByUsername", method = RequestMethod.POST)
    public List selUserByUsername(String username) {
        return usersService.getSelUsersByUsername(username);
    }


    /**
     * 筛选
     *
     * @param username
     * @param role
     * @return
     */
    @RequestMapping(value = "/selUserByUsers", method = RequestMethod.POST)
    public List selUserByUsers(String username, String role) {
        List<Users> list = new ArrayList<Users>();
        int role_id = 0;
        System.out.println("==============================================" + role);
        if ("all".equals(role)) {
            return usersService.getSelUsersByUsername(username);
        } else {
            if ("用户".equals(role)) {
                role_id = 2;
            } else if ("管理员".equals(role)) {
                role_id = 1;
            }
            list = usersService.getSelUsersByUsers(username, role_id);
            return list;
        }
    }


    /**
     * 注销用户
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "delUserByUsername", method = RequestMethod.POST)
    public List delUserByUsername(String username) {
        System.out.println(username);
        boolean bool = usersService.delUserByUsername(username);
        List list = new ArrayList();
        if (bool) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }
}
