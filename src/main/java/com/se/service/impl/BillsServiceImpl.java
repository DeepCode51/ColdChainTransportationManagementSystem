package com.se.service.impl;

import com.se.domain.Bills;
import com.se.mapper.BillsMapper;
import com.se.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baoweiwei
 * @data 2021/11/8 - 15:51
 */
@Service
public class BillsServiceImpl implements BillsService {

    @Autowired
    private BillsMapper bm;

    @Override
    public List<Bills> queryBillsInfo() {
        return bm.queryBillsInfo();
    }


}
