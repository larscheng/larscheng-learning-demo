package com.larscheng.www.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.larscheng.www.dao.SelectSubjectMapper;
import com.larscheng.www.domain.SelectSubject;
import com.larscheng.www.service.SelectSubjectService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author larscheng
 * @since 2019-12-06
 */
@Service
public class SelectSubjectServiceImpl extends ServiceImpl<SelectSubjectMapper, SelectSubject> implements SelectSubjectService {

    @Override
    public String addTest() {

        SelectSubject subject1 = new SelectSubject().setGmtCreate(new Date(1582619235742L)).setId(1);

        this.updateById(subject1);
        return subject1.getGmtCreate().toString();
    }


    private Date getDate(Date date) {
//        SelectSubject subject2 = new SelectSubject().setGmtCreate(getDate(new Date(1582619235742L))).setId(1);
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        // 将毫秒域清零
        cal1.set(Calendar.MILLISECOND, 0);
        return cal1.getTime();
    }

}
