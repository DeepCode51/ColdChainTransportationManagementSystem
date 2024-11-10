package com.se.mapper;

import com.se.domain.Bills;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:51
 */
public interface BillsMapper {

    @Select("select DATE_FORMAT(time,'%Y-%m-%d') as date,sum(o.ord_money) as income,sum(p.path_money) as expend\n" +
            "from logistics l inner join orders o on l.ord_id = o.id inner join paths p on l.path_id = p.id\n" +
            "where ord_state = '订单完成'\n" +
            "group by DATE_FORMAT(time,'%Y-%m-%d');")
    List<Bills> queryBillsInfo();
}
