package com.xzw.controller.Test;

import com.xzw.model.Test;
import com.xzw.service.Test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 谢志伟
 * @Description:
 * @Data: Created in 2018/8/31 17:27
 * @ModifiedBy:
 */
@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping("getList")
    @ResponseBody
    public List<Test> getList() {
        return testService.getList();
    }
}
