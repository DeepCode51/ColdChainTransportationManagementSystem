package com.se.service;

import com.se.domain.Logistics;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:53
 */
public interface LogisticsService {
    List<Logistics> queryAll(String ord_state);

    List<Logistics> queryLogisticsById(int id);

    int modifyLogistics(int id, int car_id, int path_id);

    List<Logistics> searchLogisticsByOrdId(String ord_id);

    List<Logistics> queryLogisticsByOrdState(String ord_state);

    int addLogistics(String ord_id, int car_id, int path_id);

    List<Logistics> queryCarExist(int car_id);

    List<Logistics> queryAllByUser(int user_id,String ord_state);

    List<Logistics> queryAllBills(String ord_state);

    List<Logistics> queryBillsByOrdId(String ord_id, String ord_state);

    List<Logistics> queryBillsByTime(String start_timeTimeStamp, String end_timeTimeStamp, String ord_state);
}
