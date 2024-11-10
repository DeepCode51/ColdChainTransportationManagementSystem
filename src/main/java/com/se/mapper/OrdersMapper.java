package com.se.mapper;

import com.se.domain.Orders;
import com.se.domain.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:45
 */
public interface OrdersMapper {

    /**
     * 这里的ord_id是单号，不是int类型的，是一个string类型
     *
     * @param ord_id
     * @return
     */
    @Select("select * from orders where id = #{ord_id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_id",
                    property = "users",
                    javaType = Users.class,
                    one = @One(select = "com.se.mapper.UsersMapper.queryUsersById")
            ),
            @Result(column = "consignee", property = "consignee"),
            @Result(column = "con_address", property = "con_address"),
            @Result(column = "con_phone", property = "con_phone"),
            @Result(column = "time", property = "time"),
            @Result(column = "type", property = "type"),
            @Result(column = "weight", property = "weight"),
            @Result(column = "ord_money", property = "ord_money"),
            @Result(column = "ord_state", property = "ord_state")
    })
    Orders queryOrdersById(String ord_id);

    @Update("update orders set ord_state = #{ord_state} where id = #{ord_id}")
    int modifyOrdersByOrdState(@Param("ord_state") String ord_state, @Param("ord_id") String ord_id);

    @Select("select * from orders where ord_state = '用户创建'")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_id",
                    property = "users",
                    javaType = Users.class,
                    one = @One(select = "com.se.mapper.UsersMapper.queryUsersById")
            ),
            @Result(column = "consignee", property = "consignee"),
            @Result(column = "con_address", property = "con_address"),
            @Result(column = "con_phone", property = "con_phone"),
            @Result(column = "time", property = "time"),
            @Result(column = "type", property = "type"),
            @Result(column = "weight", property = "weight"),
            @Result(column = "ord_money", property = "ord_money"),
            @Result(column = "ord_state", property = "ord_state")
    })
    List<Orders> queryOrders();

    @Select("select distinct ord_state from orders where ord_state <> '用户创建'")
    List<Orders> queryOrdState();

    @Select("select distinct type from orders where ord_state = '用户创建'")
    List<Orders> queryOrdersType();

    @Select("select * from orders where type = #{type} and ord_state = '用户创建'")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_id",
                    property = "users",
                    javaType = Users.class,
                    one = @One(select = "com.se.mapper.UsersMapper.queryUsersById")
            ),
            @Result(column = "consignee", property = "consignee"),
            @Result(column = "con_address", property = "con_address"),
            @Result(column = "con_phone", property = "con_phone"),
            @Result(column = "time", property = "time"),
            @Result(column = "type", property = "type"),
            @Result(column = "weight", property = "weight"),
            @Result(column = "ord_money", property = "ord_money"),
            @Result(column = "ord_state", property = "ord_state")
    })
    List<Orders> queryOrdersByType(String type);

    @Select("select * from orders where UNIX_TIMESTAMP(time) between #{startTimeStr} and #{endTimeStr} and ord_state = '用户创建'")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_id",
                    property = "users",
                    javaType = Users.class,
                    one = @One(select = "com.se.mapper.UsersMapper.queryUsersById")
            ),
            @Result(column = "consignee", property = "consignee"),
            @Result(column = "con_address", property = "con_address"),
            @Result(column = "con_phone", property = "con_phone"),
            @Result(column = "time", property = "time"),
            @Result(column = "type", property = "type"),
            @Result(column = "weight", property = "weight"),
            @Result(column = "ord_money", property = "ord_money"),
            @Result(column = "ord_state", property = "ord_state")
    })
    List<Orders> queryOrdersByTime(@Param("startTimeStr") String startTimeStr, @Param("endTimeStr") String endTimeStr);

    @Select("select * from orders where user_id = #{id} and ord_state = '用户创建'")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_id",
                    property = "users",
                    javaType = Users.class,
                    one = @One(select = "com.se.mapper.UsersMapper.queryUsersById")
            ),
            @Result(column = "consignee", property = "consignee"),
            @Result(column = "con_address", property = "con_address"),
            @Result(column = "con_phone", property = "con_phone"),
            @Result(column = "time", property = "time"),
            @Result(column = "type", property = "type"),
            @Result(column = "weight", property = "weight"),
            @Result(column = "ord_money", property = "ord_money"),
            @Result(column = "ord_state", property = "ord_state")
    })
    List<Orders> queryOrdersByUser(int id);

    @Insert("insert into orders values(#{orders.id},#{orders.users.id},#{orders.consignee},#{orders.con_address}," +
            "#{orders.con_phone},#{orders.time},#{orders.type},#{orders.weight},#{orders.ord_money},#{orders.ord_state})")
    int addOrdersByUser(@Param("orders") Orders orders);

    @Delete("delete from orders where id = #{id}")
    int delOrdersById(String id);
}
