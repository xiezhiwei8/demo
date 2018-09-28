package com.xzw.service.Test;

import com.xzw.mapper.TestMapper;
import com.xzw.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 谢志伟
 * @Description:
 * @Data: Created in 2018/8/31 17:30
 * @ModifiedBy:
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;

    @Override
    public List<Test> getList() {
        return testMapper.getList();
    }
}
