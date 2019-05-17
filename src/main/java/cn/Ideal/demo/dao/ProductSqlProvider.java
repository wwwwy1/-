package cn.Ideal.demo.dao;

import cn.Ideal.demo.entity.Product;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ProductSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Thu Apr 25 19:48:38 GMT+08:00 2019
     */
    public String insertSelective(Product record) {
        BEGIN();
        INSERT_INTO("product");
        
        if (record.getPid() != null) {
            VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getPname() != null) {
            VALUES("pname", "#{pname,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getPclass() != null) {
            VALUES("pclass", "#{pclass,jdbcType=VARCHAR}");
        }
        
        if (record.getPimg1() != null) {
            VALUES("pimg1", "#{pimg1,jdbcType=VARCHAR}");
        }
        
        if (record.getPimg2() != null) {
            VALUES("pimg2", "#{pimg2,jdbcType=VARCHAR}");
        }
        
        if (record.getPimg3() != null) {
            VALUES("pimg3", "#{pimg3,jdbcType=VARCHAR}");
        }
        
        if (record.getPimg4() != null) {
            VALUES("pimg4", "#{pimg4,jdbcType=VARCHAR}");
        }
        

        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Thu Apr 25 19:48:38 GMT+08:00 2019
     */
    public String updateByPrimaryKeySelective(Product record) {
        BEGIN();
        UPDATE("product");
        
        if (record.getPname() != null) {
            SET("pname = #{pname,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getPclass() != null) {
            SET("pclass = #{pclass,jdbcType=VARCHAR}");
        }
        
        if (record.getPimg1() != null) {
            SET("pimg1 = #{pimg1,jdbcType=VARCHAR}");
        }
        
        if (record.getPimg2() != null) {
            SET("pimg2 = #{pimg2,jdbcType=VARCHAR}");
        }
        
        if (record.getPimg3() != null) {
            SET("pimg3 = #{pimg3,jdbcType=VARCHAR}");
        }
        
        if (record.getPimg4() != null) {
            SET("pimg4 = #{pimg4,jdbcType=VARCHAR}");
        }
        

        
        WHERE("pid = #{pid,jdbcType=INTEGER}");
        
        return SQL();
    }
}