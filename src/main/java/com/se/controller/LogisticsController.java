package com.se.controller;

import com.se.domain.Cars;
import com.se.domain.Logistics;
import com.se.domain.Paths;
import com.se.domain.Users;
import com.se.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baoweiwei
 * @date 2021/11/8 - 15:52
 */
@Controller
@RequestMapping("/logistics")
@ResponseBody
public class LogisticsController {

    @Autowired
    private LogisticsService ls;
    @Autowired
    private CarsService cs;
    @Autowired
    private PathsService ps;
    @Autowired
    private OrdersService os;
    @Autowired
    private UsersService us;

    /**
     * 查询所有订单信息
     * 只能查看订单状态为"用户创建"的订单
     *
     * @return
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public List<Logistics> queryAll(String username,String ord_state) {
        List<Users> lu = us.login(username);
        String role = lu.get(0).getRoles().getRole();
        int user_id = lu.get(0).getId();
        if (role.equals("管理员")) {
            return ls.queryAll(ord_state);
        } else {
            return ls.queryAllByUser(user_id,ord_state);
        }
    }

    /**
     * 通过前台传过来的物流id来查询详细信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryLogisticsById", method = RequestMethod.POST)
    public List<Logistics> queryLogisticsById(String id) {
        return ls.queryLogisticsById(Integer.parseInt(id));
    }

    /**
     * 通过传过来的数据来修改车牌号，路线名和订单状态
     *
     * @param id
     * @param car_num
     * @param path
     * @param ord_state
     * @return
     */
    @RequestMapping(value = "/modifyLogistics", method = RequestMethod.POST)
    public List modifyLogistics(int id, String car_num, String path, String ord_state) {
        List list = new ArrayList();
        List<Cars> lc = cs.judgeCarNumExist(car_num);
        int car_id = lc.get(0).getId();
        List<Paths> lp = ps.judgePathsExist(path);
        int path_id = lp.get(0).getId();
        int res1 = ls.modifyLogistics(id, car_id, path_id);
        List<Logistics> ll = ls.queryLogisticsById(id);
        //获取id所对应订单的订单号
        String ord_id = ll.get(0).getOrders().getId();
        int res2 = os.modifyOrdersByOrdState(ord_state, ord_id);
        if (res1 > 0 && res2 > 0) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }

    /**
     * 通过ord_id筛选物流信息
     *
     * @param ord_id
     * @return
     */
    @RequestMapping(value = "/searchLogisticsByOrdId", method = RequestMethod.POST)
    public List<Logistics> searchLogisticsByOrdId(String ord_id) {
        return ls.searchLogisticsByOrdId(ord_id);
    }

    /**
     * 通过订单状态来筛选物流
     *
     * @param ord_state
     * @return
     */
    @RequestMapping(value = "/queryLogisticsByOrdState", method = RequestMethod.POST)
    public List<Logistics> queryLogisticsByOrdState(String ord_state) {
        //先根据ord_state获取所有的订单id
        if (ord_state.equals("all")) {
            return ls.queryAll("用户创建");
        } else {
            return ls.queryLogisticsByOrdState(ord_state);
        }
    }

    /**
     * 根据车牌号和路线名，新建物流信息
     * 在新建物流的同时将订单状态修改为运送中，
     *
     * @param ord_id
     * @param car_num
     * @param path
     * @return
     */
    @RequestMapping(value = "/addLogistics", method = RequestMethod.POST)
    public List addLogistics(String ord_id, String car_num, String path) {
        //修改订单表中对应订单的订单状态为运送中
        String ord_state = "运送中";
        int res1 = os.modifyOrdersByOrdState(ord_state,ord_id);
        List list = new ArrayList();
        List<Cars> lc = cs.judgeCarNumExist(car_num);
        int car_id = lc.get(0).getId();
        List<Paths> lp = ps.judgePathsExist(path);
        int path_id = lp.get(0).getId();
        int res2 = ls.addLogistics(ord_id, car_id, path_id);
        if (res2 > 0) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }

    /**
     * 通过car_id来查询车辆是否被物流占用
     *
     * @param car_id
     * @return
     */
    @RequestMapping(value = "/queryCarExist", method = RequestMethod.POST)
    public List<Logistics> queryCarExist(int car_id) {
        return ls.queryCarExist(car_id);
    }
}
