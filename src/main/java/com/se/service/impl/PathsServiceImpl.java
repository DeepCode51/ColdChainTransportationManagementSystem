package com.se.service.impl;

import com.se.domain.Paths;
import com.se.mapper.PathsMapper;
import com.se.service.PathsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:49
 */
@Service
public class PathsServiceImpl implements PathsService {

    @Autowired
    private PathsMapper pm;

    @Override
    public List<Paths> queryPaths() {
        return pm.queryPaths();
    }

    @Override
    public List<Paths> judgePathsExist(String path) {
        return pm.judgePathsExist(path);
    }

    @Override
    public int addPaths(Paths paths) {
        return pm.addPaths(paths);
    }

    @Override
    public List<Paths> searchPathsBypath(String path) {
        return pm.searchPathsBypath(path);
    }

    @Override
    public List<Paths> searchPathsByMsg(String searchMsg) {
        return pm.searchPathsByMsg(searchMsg);
    }

    @Override
    public Paths queryPathsById(int id) {
        return pm.queryPathsById(id);
    }

    @Override
    public int modifyPaths(Paths paths) {
        return pm.modifyPaths(paths);
    }
}
