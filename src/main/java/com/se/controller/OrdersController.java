package com.se.controller;

import com.se.domain.Orders;
import com.se.domain.Users;
import com.se.service.OrdersService;
import com.se.service.UsersService;
import com.se.util.DataFormat;
import com.se.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:44
 */
@Controller
@RequestMapping("/orders")
@ResponseBody
public class OrdersController {

    @Autowired
    private OrdersService os;
    @Autowired
    private UsersService us;

    /**
     * 查询所有订单信息
     * 并且只查询订单状态为"用户创建"的订单信息
     *
     * @return
     */
    @RequestMapping(value = "/queryOrders", method = RequestMethod.POST)
    public List<Orders> queryOrders(String role, String username) {
        if (role.equals("管理员")) {
            return os.queryOrders();
        } else {
            //根据普通用户名查询个人信息id
            int id = us.login(username).get(0).getId();
            return os.queryOrdersByUser(id);
        }
    }

    /**
     * 查询所有的订单状态并去重
     *
     * @return
     */
    @RequestMapping(value = "/queryOrdState", method = RequestMethod.POST)
    public List<Orders> queryOrdState() {
        return os.queryOrdState();
    }

    /**
     * 根据订单号id查询订单信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryOrdersById", method = RequestMethod.POST)
    public Orders queryOrdersById(String id) {
        return os.queryOrdersById(id);
    }

    /**
     * 查询所有的订单货物类型
     *
     * @return
     */
    @RequestMapping(value = "/queryOrdersType", method = RequestMethod.POST)
    public List<Orders> queryOrdersType() {
        return os.queryOrdersType();
    }

    /**
     * 根据货物类型查询订单信息
     *
     * @param type
     * @return
     */
    @RequestMapping(value = "/queryOrdersByType", method = RequestMethod.POST)
    public List<Orders> queryOrdersByType(String type) {
        if (type.equals("all")) {
            return os.queryOrders();
        } else {
            return os.queryOrdersByType(type);
        }
    }

    /**
     * 通过时间来筛选对应范围的订单
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value = "/queryOrdersByTime", method = RequestMethod.POST)
    public List<Orders> queryOrdersByTime(String startTime, String endTime) {
        //将标准格式的时间字符串转为时间戳，传到mapper中之后，SQL语句比较的就是时间戳
        String startTimeStr = DataFormat.dataTimeStamp(startTime, "yyyy-MM-dd HH:mm:ss");
        String endTimeStr = DataFormat.dataTimeStamp(endTime, "yyyy-MM-dd HH:mm:ss");
        return os.queryOrdersByTime(startTimeStr, endTimeStr);
    }

    /**
     * 用户创建订单
     *
     * @param orders
     * @param username
     * @return
     */
    @RequestMapping(value = "/addOrdersByUser", method = RequestMethod.POST)
    public List addOrdersByUser(Orders orders, String username) {
        List list = new ArrayList();
        String currentTimeStamp = DataFormat.getTimeStamp();
        String dateStr = DataFormat.timeStampDate(currentTimeStamp, "yyyy-MM-dd HH:mm:ss");
        String id = UUIDGenerator.getUUId(5);
        orders.setId(id);
        int user_id = us.login(username).get(0).getId();
        Users users = new Users();
        users.setId(user_id);
        orders.setUsers(users);
        orders.setTime(dateStr);
        orders.setOrd_state("用户创建");
        int res = os.addOrdersByUser(orders);
        if (res > 0) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }

    /**
     * 用户删除订单
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delOrdersById", method = RequestMethod.POST)
    public List delOrdersById(String id) {
        List list = new ArrayList();
        int res = os.delOrdersById(id);
        if (res > 0) {
            list.add("true");
        } else {
            list.add("false");
        }
        return list;
    }
}
