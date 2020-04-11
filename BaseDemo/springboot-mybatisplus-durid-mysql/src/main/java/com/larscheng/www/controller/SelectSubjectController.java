package com.larscheng.www.controller;


import com.larscheng.www.service.SelectSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author larscheng
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/selectSubject")
public class SelectSubjectController {

    @Autowired
    private SelectSubjectService selectSubjectService;

    @RequestMapping(value = "/app/v2/vehicle/deal", method = RequestMethod.GET)
    public String testAdd() {
        return selectSubjectService.addTest();
    }
}

