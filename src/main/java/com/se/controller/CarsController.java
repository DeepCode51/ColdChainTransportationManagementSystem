package com.se.controller;

import com.se.domain.Cars;
import com.se.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baoweiwei
 * @date 2021/11/8 - 15:46
 */
@Controller
@RequestMapping("/cars")
@ResponseBody
public class CarsController {

    @Autowired
    private CarsService cs;

    /**
     * 查询所有的车辆信息
     *
     * @return
     */
    @RequestMapping(value = "/queryCars", method = RequestMethod.POST)
    public List<Cars> queryCars() {
        return cs.queryCars();
    }

    /**
     * 根据车牌号判断该车辆是否存在
     *
     * @param car_num
     * @return
     */
    @RequestMapping(value = "/judgeCarNumExist", method = RequestMethod.POST)
    public List judgeCarNumExist(String car_num) {
        List list = new ArrayList();
        List<Cars> lc = cs.judgeCarNumExist(car_num);
        if (!lc.isEmpty()) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }

    /**
     * 根据id来查询对应的车辆信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryCarsById", method = RequestMethod.POST)
    public Cars queryCarsById(int id) {
        return cs.queryCarsById(id);
    }

    /**
     * 修改车辆信息
     *
     * @param cars
     * @return
     */
    @RequestMapping(value = "/modifyCarsById", method = RequestMethod.POST)
    public List modifyCarsById(Cars cars) {
        List list = new ArrayList();
        int res = cs.modifyCarsById(cars);
        if (res > 0) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }

    /**
     * 根据car_num模糊查询车辆信息
     *
     * @param car_num
     * @return
     */
    @RequestMapping(value = "/queryCarsByCar_num", method = RequestMethod.POST)
    public List<Cars> queryCarsByCar_num(String car_num) {
        return cs.queryCarsByCar_num(car_num);
    }

    /**
     * 查询所有的车辆状态，并去重
     *
     * @return
     */
    @RequestMapping(value = "/queryCarState", method = RequestMethod.POST)
    public List<Cars> queryCarState() {
        return cs.queryCarState();
    }

    /**
     * 根据车辆状态来查询对应的车辆信息
     *
     * @param car_state
     * @return
     */
    @RequestMapping(value = "/queryCarsByCarState", method = RequestMethod.POST)
    public List<Cars> queryCarsByCarState(String car_state) {
        if (car_state.equals("all")) {
            return cs.queryCars();
        } else {
            return cs.queryCarsByCarState(car_state);
        }
    }

    @RequestMapping(value = "/deleteCars", method = RequestMethod.POST)
    public List deleteCars(int id) {
        List list = new ArrayList();
        int res = cs.deleteCars(id);
        if (res > 0) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }

    @RequestMapping(value = "/addCars", method = RequestMethod.POST)
    public List addCars(Cars cars) {
        List list = new ArrayList();
        int res = cs.addCars(cars);
        if (res > 0) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }
}
