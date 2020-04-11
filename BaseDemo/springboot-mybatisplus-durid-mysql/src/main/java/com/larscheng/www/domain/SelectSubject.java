package com.larscheng.www.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author larscheng
 * @since 2019-12-06
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SelectSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 题目id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题目名称
     */
    private String subName;

    /**
     * 发布教师id
     */
    private Integer teaId;

    /**
     * 题目类型，1应用型，2理论性
     */
    private Integer subType;

    /**
     * 题目文件路径
     */
    private String subFile;

    /**
     * 题目内容
     */
    private String subContent;

    /**
     * 题目选题状态 0未选 1审核中 2已选
     */
    private Integer subSelectStatus;

    /**
     * 审核状态 0未处理，1审核不通过，2审核通过
     */
    private Integer admAuditState;

    /**
     * 审核意见
     */
    private String admAuditContent;

    /**
     * 审核人id
     */
    private Integer admAuditId;

    /**
     * 指导老师评分
     */
    private Double tutorScore;

    /**
     * 评阅老师评分
     */
    private Double judgeScore;

    /**
     * 答辩得分
     */
    private Double defenceScore;

    /**
     * 最终总得分
     */
    private Double finalTotalScore;

    /**
     * 题目面向系别
     */
    private Integer forDepId;

    /**
     * 题目年份
     */
    private String subYear;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModify;

    /**
     * 用户骑行卡id
     */
    private Integer userCardId;


}
