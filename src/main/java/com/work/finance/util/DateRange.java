package com.work.finance.util;
import com.work.finance.common.Enums;

import java.util.Date;

import static com.work.finance.util.DateUtil.NUM_DATE_FORMAT;
import static com.work.finance.util.DateUtil.dateToString;

/**
 * <p>
 *   日期计算辅助类
 * </p>
 *
 * @author wei
 * @create 2018/5/16 10:16
 */
public class DateRange {

    //开始日期
    private Date start;

    //结束日期
    private Date end;

    //开始日期字符串
    private String startDate;

    //结束日期字符串
    private String endDate;

    //上期开始日期
    private String prevStartDate;

    //上期结束日期
    private String prevEndDate;

    public DateRange(){}

    public DateRange(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPrevStartDate() {
        return prevStartDate;
    }

    public void setPrevStartDate(String prevStartDate) {
        this.prevStartDate = prevStartDate;
    }

    public String getPrevEndDate() {
        return prevEndDate;
    }

    public void setPrevEndDate(String prevEndDate) {
        this.prevEndDate = prevEndDate;
    }

    /**
     * 计算起至日期
     * @param cycle 统计周期
     * @param startDay 开始日期
     * @param endDay 结束日期
     * @return DateRange 日期格式:yyyyMMdd
     */
    public static DateRange caculateDateRange(String cycle, Date startDay,Date endDay){
        //本期起至日期
        String startDate = null;
        String endDate = null;
        //上期起至日期
        String prevStartDate = null;
        String prevEndDate = null;

        Integer code = Enums.Cycle.getCode(cycle);
        if(null!=code){
            Date start = startDay==null?new Date():startDay;
            switch (code){
                case 1:
                    startDate = dateToString(start, NUM_DATE_FORMAT);
                    endDate = dateToString(start, NUM_DATE_FORMAT);
                    prevStartDate = DateUtil.getDayBefore(start,NUM_DATE_FORMAT);
                    prevEndDate = DateUtil.getDayBefore(start,NUM_DATE_FORMAT);
                    break;
                case 2:
                    startDate = dateToString(DateUtil.getFirstDayOfWeek(start), NUM_DATE_FORMAT);
                    endDate = dateToString(DateUtil.getLastDayOfWeek(start), NUM_DATE_FORMAT);
                    prevStartDate = dateToString(DateUtil.getLastWeek(start).getStart(),NUM_DATE_FORMAT);
                    prevEndDate = dateToString(DateUtil.getLastWeek(start).getEnd(),NUM_DATE_FORMAT);
                    break;
                case 3:
                    startDate = dateToString(DateUtil.getFirstDayOfMonth(start), NUM_DATE_FORMAT);
                    endDate = dateToString(DateUtil.getLastDayOfMonth(start), NUM_DATE_FORMAT);
                    prevStartDate = dateToString(DateUtil.getLastMonthRange(start).getStart(),NUM_DATE_FORMAT);
                    prevEndDate = dateToString(DateUtil.getLastMonthRange(start).getEnd(),NUM_DATE_FORMAT);
                    break;
                case 4:
                    startDate = dateToString(DateUtil.getFirstDayOfQuarter(start), NUM_DATE_FORMAT);
                    endDate = dateToString(DateUtil.getLastDayOfQuarter(start), NUM_DATE_FORMAT);
                    break;
                case 5:
                    startDate = dateToString(DateUtil.getYearFirst(start), NUM_DATE_FORMAT);
                    endDate = dateToString(DateUtil.getYearOver(start), NUM_DATE_FORMAT);
                    break;
                default:
                    throw new RuntimeException(cycle+"not undefined");
            }
        }else{
            startDate = dateToString(startDay, NUM_DATE_FORMAT);
            endDate =  dateToString(endDay,NUM_DATE_FORMAT);
        }
        DateRange range = new DateRange();
        range.setStartDate(startDate);
        range.setEndDate(endDate);
        range.setPrevStartDate(prevStartDate);
        range.setPrevEndDate(prevEndDate);
        return  range;
    }
}