package com.se.mapper;

import com.se.domain.Cars;
import com.se.domain.Logistics;
import com.se.domain.Orders;
import com.se.domain.Paths;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:53
 */
public interface LogisticsMapper {

    @Select("select * from logistics where ord_id in(select id from orders where ord_state <> #{ord_state})")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ord_id",
                    property = "orders",
                    javaType = Orders.class,
                    one = @One(select = "com.se.mapper.OrdersMapper.queryOrdersById")
            ),
            @Result(column = "car_id",
                    property = "cars",
                    javaType = Cars.class,
                    one = @One(select = "com.se.mapper.CarsMapper.queryCarsById")
            ),
            @Result(column = "path_id",
                    property = "paths",
                    javaType = Paths.class,
                    one = @One(select = "com.se.mapper.PathsMapper.queryPathsById")
            )
    })
    List<Logistics> queryAll(String ord_state);


    @Select("select * from logistics where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ord_id",
                    property = "orders",
                    javaType = Orders.class,
                    one = @One(select = "com.se.mapper.OrdersMapper.queryOrdersById")
            ),
            @Result(column = "car_id",
                    property = "cars",
                    javaType = Cars.class,
                    one = @One(select = "com.se.mapper.CarsMapper.queryCarsById")
            ),
            @Result(column = "path_id",
                    property = "paths",
                    javaType = Paths.class,
                    one = @One(select = "com.se.mapper.PathsMapper.queryPathsById")
            )
    })
    List<Logistics> queryLogisticsById(int id);

    @Update("update logistics set car_id = #{car_id},path_id = #{path_id} where id = #{id}")
    int modifyLogistics(@Param("id") int id, @Param("car_id") int car_id, @Param("path_id") int path_id);

    @Select("select * from logistics where ord_id like concat('%',#{ord_id},'%')")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ord_id",
                    property = "orders",
                    javaType = Orders.class,
                    one = @One(select = "com.se.mapper.OrdersMapper.queryOrdersById")
            ),
            @Result(column = "car_id",
                    property = "cars",
                    javaType = Cars.class,
                    one = @One(select = "com.se.mapper.CarsMapper.queryCarsById")
            ),
            @Result(column = "path_id",
                    property = "paths",
                    javaType = Paths.class,
                    one = @One(select = "com.se.mapper.PathsMapper.queryPathsById")
            )
    })
    List<Logistics> searchLogisticsByOrdId(String ord_id);

    @Select("select * from logistics where ord_id in(select id from orders where ord_state = #{ord_state})")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ord_id",
                    property = "orders",
                    javaType = Orders.class,
                    one = @One(select = "com.se.mapper.OrdersMapper.queryOrdersById")
            ),
            @Result(column = "car_id",
                    property = "cars",
                    javaType = Cars.class,
                    one = @One(select = "com.se.mapper.CarsMapper.queryCarsById")
            ),
            @Result(column = "path_id",
                    property = "paths",
                    javaType = Paths.class,
                    one = @One(select = "com.se.mapper.PathsMapper.queryPathsById")
            )
    })
    List<Logistics> queryLogisticsByOrdState(String ord_state);

    @Insert("insert into logistics values(null,#{ord_id},#{car_id},#{path_id})")
    int addLogistics(@Param("ord_id") String ord_id, @Param("car_id") int car_id, @Param("path_id") int path_id);

    @Select("select * from logistics where car_id = #{car_id}")
    List<Logistics> queryCarExist(int car_id);

    @Select("select * from logistics where ord_id in(select id from orders where user_id = #{user_id} and ord_state <> #{ord_state})")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ord_id",
                    property = "orders",
                    javaType = Orders.class,
                    one = @One(select = "com.se.mapper.OrdersMapper.queryOrdersById")
            ),
            @Result(column = "car_id",
                    property = "cars",
                    javaType = Cars.class,
                    one = @One(select = "com.se.mapper.CarsMapper.queryCarsById")
            ),
            @Result(column = "path_id",
                    property = "paths",
                    javaType = Paths.class,
                    one = @One(select = "com.se.mapper.PathsMapper.queryPathsById")
            )
    })
    List<Logistics> queryAllByUser(@Param("user_id") int user_id, @Param("ord_state") String ord_state);

    @Select("select * from logistics where ord_id in(select id from orders where ord_state = #{ord_state}) ")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ord_id",
                    property = "orders",
                    javaType = Orders.class,
                    one = @One(select = "com.se.mapper.OrdersMapper.queryOrdersById")
            ),
            @Result(column = "car_id",
                    property = "cars",
                    javaType = Cars.class,
                    one = @One(select = "com.se.mapper.CarsMapper.queryCarsById")
            ),
            @Result(column = "path_id",
                    property = "paths",
                    javaType = Paths.class,
                    one = @One(select = "com.se.mapper.PathsMapper.queryPathsById")
            )
    })
    List<Logistics> queryAllBills(String ord_state);

    @Select("select * from logistics where ord_id in(select id from orders where ord_state = #{ord_state} and ord_id like concat('%',#{ord_id},'%'))")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ord_id",
                    property = "orders",
                    javaType = Orders.class,
                    one = @One(select = "com.se.mapper.OrdersMapper.queryOrdersById")
            ),
            @Result(column = "car_id",
                    property = "cars",
                    javaType = Cars.class,
                    one = @One(select = "com.se.mapper.CarsMapper.queryCarsById")
            ),
            @Result(column = "path_id",
                    property = "paths",
                    javaType = Paths.class,
                    one = @One(select = "com.se.mapper.PathsMapper.queryPathsById")
            )
    })
    List<Logistics> queryBillsByOrdId(@Param("ord_id") String ord_id, @Param("ord_state") String ord_state);

    @Select("select * from logistics where " +
            "ord_id in(select id from orders where (UNIX_TIMESTAMP(time) between #{start_timeTimeStamp} and #{end_timeTimeStamp}) " +
            "and ord_state = #{ord_state})")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ord_id",
                    property = "orders",
                    javaType = Orders.class,
                    one = @One(select = "com.se.mapper.OrdersMapper.queryOrdersById")
            ),
            @Result(column = "car_id",
                    property = "cars",
                    javaType = Cars.class,
                    one = @One(select = "com.se.mapper.CarsMapper.queryCarsById")
            ),
            @Result(column = "path_id",
                    property = "paths",
                    javaType = Paths.class,
                    one = @One(select = "com.se.mapper.PathsMapper.queryPathsById")
            )
    })
    List<Logistics> queryBillsByTime(@Param("start_timeTimeStamp") String start_timeTimeStamp, @Param("end_timeTimeStamp") String end_timeTimeStamp, @Param("ord_state") String ord_state);
}
