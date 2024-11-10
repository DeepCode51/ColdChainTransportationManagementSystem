package com.se.service;

import com.se.domain.Cars;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:47
 */
public interface CarsService {
    List<Cars> queryCars();

    List<Cars> judgeCarNumExist(String car_num);

    Cars queryCarsById(int id);

    int modifyCarsById(Cars cars);

    List<Cars> queryCarsByCar_num(String car_num);

    List<Cars> queryCarState();

    List<Cars> queryCarsByCarState(String car_state);

    int deleteCars(int id);

    int addCars(Cars cars);
}
