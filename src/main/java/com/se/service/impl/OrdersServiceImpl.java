package com.se.service.impl;

import com.se.domain.Orders;
import com.se.mapper.OrdersMapper;
import com.se.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:46
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper om;

    @Override
    public int modifyOrdersByOrdState(String ord_state, String ord_id) {
        return om.modifyOrdersByOrdState(ord_state, ord_id);
    }

    @Override
    public List<Orders> queryOrders() {
        return om.queryOrders();
    }

    @Override
    public List<Orders> queryOrdState() {
        return om.queryOrdState();
    }

    @Override
    public Orders queryOrdersById(String id) {
        return om.queryOrdersById(id);
    }

    @Override
    public List<Orders> queryOrdersType() {
        return om.queryOrdersType();
    }

    @Override
    public List<Orders> queryOrdersByType(String type) {
        return om.queryOrdersByType(type);
    }

    @Override
    public List<Orders> queryOrdersByTime(String startTimeStr, String endTimeStr) {
        return om.queryOrdersByTime(startTimeStr, endTimeStr);
    }

    @Override
    public List<Orders> queryOrdersByUser(int id) {
        return om.queryOrdersByUser(id);
    }

    @Override
    public int addOrdersByUser(Orders orders) {
        return om.addOrdersByUser(orders);
    }

    @Override
    public int delOrdersById(String id) {
        return om.delOrdersById(id);
    }

}
