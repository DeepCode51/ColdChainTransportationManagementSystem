package com.se.service.impl;

import com.se.domain.Cars;
import com.se.mapper.CarsMapper;
import com.se.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:47
 */
@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsMapper cm;

    @Override
    public List<Cars> queryCars() {
        return cm.queryCars();
    }

    @Override
    public List<Cars> judgeCarNumExist(String car_num) {
        return cm.judgeCarNumExist(car_num);
    }

    @Override
    public Cars queryCarsById(int id) {
        return cm.queryCarsById(id);
    }

    @Override
    public int modifyCarsById(Cars cars) {
        return cm.modifyCarsById(cars);
    }

    @Override
    public List<Cars> queryCarsByCar_num(String car_num) {
        return cm.queryCarsByCar_num(car_num);
    }

    @Override
    public List<Cars> queryCarState() {
        return cm.queryCarState();
    }

    @Override
    public List<Cars> queryCarsByCarState(String car_state) {
        return cm.queryCarsByCarState(car_state);
    }

    @Override
    public int deleteCars(int id) {
        return cm.deleteCars(id);
    }

    @Override
    public int addCars(Cars cars) {
        return cm.addCars(cars);
    }
}
