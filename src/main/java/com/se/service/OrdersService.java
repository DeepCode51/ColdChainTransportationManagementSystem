package com.se.service;

import com.se.domain.Orders;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:46
 */
public interface OrdersService {
    int modifyOrdersByOrdState(String ord_state, String ord_id);

    List<Orders> queryOrders();

    List<Orders> queryOrdState();

    Orders queryOrdersById(String id);

    List<Orders> queryOrdersType();

    List<Orders> queryOrdersByType(String type);

    List<Orders> queryOrdersByTime(String startTimeStr, String endTimeStr);

    List<Orders> queryOrdersByUser(int id);

    int addOrdersByUser(Orders orders);

    int delOrdersById(String id);
}
