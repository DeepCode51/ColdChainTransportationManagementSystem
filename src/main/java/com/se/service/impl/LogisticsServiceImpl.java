package com.se.service.impl;

import com.se.domain.Logistics;
import com.se.mapper.LogisticsMapper;
import com.se.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:53
 */
@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Autowired
    private LogisticsMapper lm;

    @Override
    public List<Logistics> queryAll(String ord_state) {
        return lm.queryAll(ord_state);
    }

    @Override
    public List<Logistics> queryLogisticsById(int id) {
        return lm.queryLogisticsById(id);
    }

    @Override
    public int modifyLogistics(int id, int car_id, int path_id) {
        return lm.modifyLogistics(id, car_id, path_id);
    }

    @Override
    public List<Logistics> searchLogisticsByOrdId(String ord_id) {
        return lm.searchLogisticsByOrdId(ord_id);
    }

    @Override
    public List<Logistics> queryLogisticsByOrdState(String ord_state) {
        return lm.queryLogisticsByOrdState(ord_state);
    }

    @Override
    public int addLogistics(String ord_id, int car_id, int path_id) {
        return lm.addLogistics(ord_id, car_id, path_id);
    }

    @Override
    public List<Logistics> queryCarExist(int car_id) {
        return lm.queryCarExist(car_id);
    }

    @Override
    public List<Logistics> queryAllByUser(int user_id,String ord_state) {
        return lm.queryAllByUser(user_id,ord_state);
    }

    @Override
    public List<Logistics> queryAllBills(String ord_state) {
        return lm.queryAllBills(ord_state);
    }

    @Override
    public List<Logistics> queryBillsByOrdId(String ord_id, String ord_state) {
        return lm.queryBillsByOrdId(ord_id,ord_state);
    }

    @Override
    public List<Logistics> queryBillsByTime(String start_timeTimeStamp, String end_timeTimeStamp, String ord_state) {
        return lm.queryBillsByTime(start_timeTimeStamp,end_timeTimeStamp,ord_state);
    }
}
