package com.se.controller;

import com.se.domain.Bills;
import com.se.domain.Logistics;
import com.se.service.BillsService;
import com.se.service.LogisticsService;
import com.se.util.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * @author baoweiwei
 * @date 2021/11/8 - 15:50
 */
@Controller
@RequestMapping("/bills")
@ResponseBody
public class BillsController {
    @Autowired
    private LogisticsService ls;
    @Autowired
    private BillsService bs;

    /**
     * 查询订单状态为 "已完成" 状态的所有订单信息
     *
     * @param ord_state
     * @return
     */
    @RequestMapping(value = "/queryAllBills", method = RequestMethod.POST)
    public List<Logistics> queryAllBills(String ord_state) {
        return ls.queryAllBills(ord_state);
    }

    /**
     * 通过订单id查询订单状态为已完成的订单信息
     * @param ord_id
     * @param ord_state
     * @return
     */
    @RequestMapping(value = "/queryBillsByOrdId", method = RequestMethod.POST)
    public List<Logistics> queryBillsByOrdId(String ord_id,String ord_state){
        return ls.queryBillsByOrdId(ord_id,ord_state);
    }

    /**
     * 通过时间字符串转为时间戳和数据库中的时间作比较，查询出符合条件的已完成订单
     * @param start_time
     * @param end_time
     * @param ord_state
     * @return
     */
    @RequestMapping(value = "/queryBillsByTime",method = RequestMethod.POST)
    public List<Logistics> queryBillsByTime(String start_time,String end_time,String ord_state){
        //键标准日期格式的字符串转为时间戳
        String start_timeTimeStamp = DataFormat.dataTimeStamp(start_time,"yyyy-MM-dd HH:mm:ss");
        String end_timeTimeStamp = DataFormat.dataTimeStamp(end_time,"yyyy-MM-dd HH:mm:ss");
        return ls.queryBillsByTime(start_timeTimeStamp,end_timeTimeStamp,ord_state);
    }

    /**
     * 利用多表联查，查询出对应的字段，封装到Bill中
     * @return
     */
    @RequestMapping(value = "/queryBillsInfo",method = RequestMethod.POST)
    public List<Bills> queryBillsInfo(){
        return bs.queryBillsInfo();
    }
}
