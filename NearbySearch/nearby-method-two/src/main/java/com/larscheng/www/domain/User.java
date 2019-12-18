package com.larscheng.www.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 描述: 用户
 *
 * @author larscheng
 * @date 2019/12/9 19:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 名称
     */
    private String name;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 距离
     */
    private Double distance;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
