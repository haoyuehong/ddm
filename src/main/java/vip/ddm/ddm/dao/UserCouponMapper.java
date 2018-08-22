package vip.ddm.ddm.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import vip.ddm.ddm.model.Coupon;
import vip.ddm.ddm.model.User;
import vip.ddm.ddm.model.UserCoupon;

import java.util.List;

public interface UserCouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coupon
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coupon
     *
     * @mbg.generated
     */
    int insert(UserCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coupon
     *
     * @mbg.generated
     */
    int insertSelective(UserCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coupon
     *
     * @mbg.generated
     */
    UserCoupon selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserCoupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserCoupon record);


    @Select("select * from user_coupon where coupon_id = #{couponId} and user_id = #{userId}")
    UserCoupon selectByUserIdAndCouponId(@Param("couponId") Integer couponId, @Param("userId")Integer userId);

    @Select("select c.* from user_coupon up, coupon c where up.coupon_id = c.id and up.user_id = #{userId} order by status ASC")
    List<Coupon> selectByUserId(@Param("userId")Integer userId);

    @Select("select u.* from user_coupon up, user u where up.coupon_id = u.id and up.coupon_id = #{couponId}")
    List<User> selectByCouponId(@Param("couponId")Integer couponId);
}