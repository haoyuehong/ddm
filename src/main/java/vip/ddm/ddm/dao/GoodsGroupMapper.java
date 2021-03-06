package vip.ddm.ddm.dao;

import org.apache.ibatis.annotations.Param;
import vip.ddm.ddm.model.GoodsGroup;
import vip.ddm.ddm.vo.GroupVo;

import java.util.List;

public interface GoodsGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_group
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_group
     *
     * @mbg.generated
     */
    int insert(GoodsGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_group
     *
     * @mbg.generated
     */
    int insertSelective(GoodsGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_group
     *
     * @mbg.generated
     */
    GoodsGroup selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_group
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(GoodsGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_group
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(GoodsGroup record);

    List<GroupVo> selectByName(@Param("goodsGroup") GoodsGroup goodsGroup,@Param("storeIds")List<Integer> storeIds);

}