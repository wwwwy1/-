package cn.Ideal.demo.dao;

import cn.Ideal.demo.entity.Mrandom;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class MrandomSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mrandom
     *
     * @mbggenerated Fri Apr 26 20:07:20 GMT+08:00 2019
     */
    public String insertSelective(Mrandom record) {
        BEGIN();
        INSERT_INTO("mrandom");
        
        if (record.getRid() != null) {
            VALUES("rid", "#{rid,jdbcType=INTEGER}");
        }
        
        if (record.getRcontent() != null) {
            VALUES("rcontent", "#{rcontent,jdbcType=VARCHAR}");
        }
        
        if (record.getRan1() != null) {
            VALUES("ran1", "#{ran1,jdbcType=VARCHAR}");
        }
        
        if (record.getRan2() != null) {
            VALUES("ran2", "#{ran2,jdbcType=VARCHAR}");
        }
        
        if (record.getRan3() != null) {
            VALUES("ran3", "#{ran3,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mrandom
     *
     * @mbggenerated Fri Apr 26 20:07:20 GMT+08:00 2019
     */
    public String updateByPrimaryKeySelective(Mrandom record) {
        BEGIN();
        UPDATE("mrandom");
        
        if (record.getRcontent() != null) {
            SET("rcontent = #{rcontent,jdbcType=VARCHAR}");
        }
        
        if (record.getRan1() != null) {
            SET("ran1 = #{ran1,jdbcType=VARCHAR}");
        }
        
        if (record.getRan2() != null) {
            SET("ran2 = #{ran2,jdbcType=VARCHAR}");
        }
        
        if (record.getRan3() != null) {
            SET("ran3 = #{ran3,jdbcType=VARCHAR}");
        }
        
        WHERE("rid = #{rid,jdbcType=INTEGER}");
        
        return SQL();
    }
}