package com.larscheng.www.jsontest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 描述:
 *
 * @author larscheng
 * @date 2019/11/19 19:39
 */

@Data
@AllArgsConstructor
public class Course {
    private String name;
    private String desc;
}
