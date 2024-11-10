package com.se.service.impl;

import com.se.domain.Users;
import com.se.mapper.UsersMapper;
import com.se.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:42
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    public List<Users> login(String username) {
        return usersMapper.login(username);
    }

    @Override
    public boolean Enroll(Users users) {
        int bool = usersMapper.Enroll(users);
        if (bool > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean selUsername(String username) {
        Users users = usersMapper.sleUsername(username);
        if (users == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Users> getAllUsers() {
        return usersMapper.getAllUsers();
    }

    @Override
    public List<Users> getAllUsersByUsername(String username) {
        return usersMapper.getAllUsersByUsername(username);
    }

    @Override
    public boolean updateUser(Users users) {
        int bool = usersMapper.updateUser(users);
        if (bool > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delUser(int id, String username) {
        int bool = usersMapper.delUser(id, username);
        if (bool > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Users> getSelUsersByUsername(String username) {
        username = "%" + username + "%";
        return usersMapper.getSelUsersByUsername(username);
    }

    @Override
    public List<Users> getSelUsersByUsers(String username, int role_id) {
        username = "%" + username + "%";
        return usersMapper.getSelUsersByUser(username, role_id);
    }

    @Override
    public boolean delUserByUsername(String username) {
        int bool = usersMapper.delUserByUsername(username);
        if (bool > 0) {
            return true;
        } else {
            return false;
        }
    }

}
