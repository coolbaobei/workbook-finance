package com.work.finance.common;
/**
 * <p>
 * 系统枚举
 * </p>
 *
 * @author wei
 * @create 2018/5/18 13:56
 */
public interface Enums {

    /**
     * 统计周期类型
     */
    enum Cycle {

        DAY(1,"day"), WEEK(2,"week"), MONTH(3,"month"),QUATER(4,"quater"),YEAR(5,"year");

        private Integer code;
        private String key;

        Cycle(Integer code,String key){
            this.code =code;
            this.key = key;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getKey() {
            return key;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public static Integer getCode(String key){
            for(Cycle s:Cycle.values()){
                if(s.getKey().equals(key) ){
                    return s.getCode();
                }
            }
            return null;
        }
    }

    /**
     *  账期类型
     */
    enum Acct {

        CUR(0,"本期"), PRE(1,"上期");
        private Integer code;
        private String key;
        Acct(Integer code,String key){
            this.code =code;
            this.key = key;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getKey() {
            return key;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public static Integer getCode(String key){
            for(Acct s:Acct.values()){
                if(s.getKey().equals(key) ){
                    return s.getCode();
                }
            }
            return null;
        }
    }
}
