package com.se.controller;

import com.se.domain.Paths;
import com.se.service.PathsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:48
 */
@Controller
@RequestMapping("/paths")
@ResponseBody
public class PathsController {

    @Autowired
    private PathsService ps;

    /**
     * 查询所有的线路信息
     *
     * @return
     */
    @RequestMapping(value = "/queryPaths", method = RequestMethod.POST)
    public List<Paths> queryPaths() {
        return ps.queryPaths();
    }

    /**
     * 根据路线名判断路线是否存在
     *
     * @param path
     * @return
     */
    @RequestMapping(value = "/judgePathsExist", method = RequestMethod.POST)
    public List judgePathsExist(String path) {
        List list = new ArrayList();
        List<Paths> lp = ps.judgePathsExist(path);
        if (!lp.isEmpty()) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }

    /**
     * 添加路线信息
     *
     * @param paths
     * @return
     */
    @RequestMapping(value = "/addPaths", method = RequestMethod.POST)
    public List addPaths(Paths paths) {
        List list = new ArrayList();
        int res = ps.addPaths(paths);
        if (res > 0) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }

    /**
     * 通过路线名模糊查询路线信息
     *
     * @param path
     * @return
     */
    @RequestMapping(value = "/searchPathsBypath", method = RequestMethod.POST)
    public List<Paths> searchPathsBypath(String path) {
        return ps.searchPathsBypath(path);
    }

    /**
     * 模糊查询起始地，终止地，途径地
     *
     * @param searchMsg
     * @return
     */
    @RequestMapping(value = "/searchPathsByMsg", method = RequestMethod.POST)
    public List<Paths> searchPathsByMsg(String searchMsg) {
        return ps.searchPathsByMsg(searchMsg);
    }

    /**
     * 根据id查询对应的路线信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryPathsById", method = RequestMethod.POST)
    public Paths queryPathsById(int id) {
        return ps.queryPathsById(id);
    }

    /**
     * 修改线路信息
     *
     * @param paths
     * @return
     */
    @RequestMapping(value = "/modifyPaths", method = RequestMethod.POST)
    public List modifyPaths(Paths paths) {
        List list = new ArrayList();
        int res = ps.modifyPaths(paths);
        if (res > 0) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }
}
