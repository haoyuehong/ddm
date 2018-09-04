package vip.ddm.ddm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import vip.ddm.ddm.model.Goods;
import vip.ddm.ddm.vo.DateGoodsVo;
import vip.ddm.ddm.vo.GoodsVo;

import java.util.Date;
import java.util.List;

public interface GoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int insert(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int insertSelective(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    Goods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Goods record);

    List<GoodsVo> findByParam(@Param(value = "goods") Goods goods,@Param("startDate")Date startDate,@Param("endDate")Date endDate, @Param("storeIds")List<Integer> storeIds);

    @Select("select * from goods where group_id = #{groupId} and status != 0")
    List<Goods> findByGroupId(@Param(value = "groupId") Integer groupId);

    @Select("select * from goods g, goods_group gp where g.group_id = gp.id and g.date = #{date} and gp.store_id = #{storeId}")
    List<DateGoodsVo> selectByDate(@Param("date") Date date,@Param("storeId")Integer storeId);
}