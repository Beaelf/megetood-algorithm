package com.megetood.test;

import java.util.Date;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/16 9:46
 */
public class Stu extends Base{
    private Date startDate;
    public Stu() {
        this.getStartDate();
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
