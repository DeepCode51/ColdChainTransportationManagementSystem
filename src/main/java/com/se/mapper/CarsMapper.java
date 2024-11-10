package com.se.mapper;

import com.se.domain.Cars;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:47
 */
public interface CarsMapper {

    @Select("select * from cars where id = #{id}")
    Cars queryCarsById(int id);

    @Select("select * from cars")
    List<Cars> queryCars();

    @Select("select * from cars where car_num = #{car_num}")
    List<Cars> judgeCarNumExist(String car_num);

    @Update("update cars set car_num = #{cars.car_num},max_weight = #{cars.max_weight} where id = #{cars.id}")
    int modifyCarsById(@Param("cars") Cars cars);

    @Select("select * from cars where car_num like concat('%',#{car_num},'%')")
    List<Cars> queryCarsByCar_num(String car_num);

    @Select("select distinct car_state from cars")
    List<Cars> queryCarState();

    @Select("select * from cars where car_state = #{car_state}")
    List<Cars> queryCarsByCarState(String car_state);

    @Delete("delete from cars where id = #{id}")
    int deleteCars(int id);

    @Insert("insert into cars values(null,#{cars.car_num},#{cars.max_weight},#{cars.car_state})")
    int addCars(@Param("cars") Cars cars);
}
