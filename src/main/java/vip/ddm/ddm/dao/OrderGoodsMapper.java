package vip.ddm.ddm.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import vip.ddm.ddm.model.OrderGoods;

import java.util.List;

public interface OrderGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbg.generated
     */
    int insert(OrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbg.generated
     */
    int insertSelective(OrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbg.generated
     */
    OrderGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OrderGoods record);

    @Select("select * from order_goods where order_id = #{orderId}")
    List<OrderGoods> selectByOrderId(@Param("orderId") String orderId);
}