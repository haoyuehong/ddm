package vip.ddm.ddm.dao;

import vip.ddm.ddm.model.CouponGoods;

public interface CouponGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_goods
     *
     * @mbg.generated
     */
    int insert(CouponGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_goods
     *
     * @mbg.generated
     */
    int insertSelective(CouponGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_goods
     *
     * @mbg.generated
     */
    CouponGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CouponGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CouponGoods record);
}