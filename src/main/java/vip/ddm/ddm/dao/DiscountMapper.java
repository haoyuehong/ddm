package vip.ddm.ddm.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import vip.ddm.ddm.model.Discount;
import vip.ddm.ddm.vo.DiscountVo;

import java.util.List;

public interface DiscountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discount
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discount
     *
     * @mbg.generated
     */
    int insert(Discount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discount
     *
     * @mbg.generated
     */
    int insertSelective(Discount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discount
     *
     * @mbg.generated
     */
    Discount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discount
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Discount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discount
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Discount record);

    List<DiscountVo> findList(@Param("discount") Discount discount);

    @Select("select * from discount where goods_id = #{goodsId} and status = 0")
    Discount findByGoodsId(@Param("goodsId")Integer goodsId);
}