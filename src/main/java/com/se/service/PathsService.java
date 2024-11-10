package com.se.service;

import com.se.domain.Paths;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:49
 */
public interface PathsService {
    List<Paths> queryPaths();

    List<Paths> judgePathsExist(String path);

    int addPaths(Paths paths);

    List<Paths> searchPathsBypath(String path);

    List<Paths> searchPathsByMsg(String searchMsg);

    Paths queryPathsById(int id);

    public abstract int modifyPaths(Paths paths);
}
