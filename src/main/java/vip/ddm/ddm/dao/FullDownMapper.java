package vip.ddm.ddm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import vip.ddm.ddm.model.FullDown;
import vip.ddm.ddm.vo.FullDownVo;

import java.util.List;

public interface FullDownMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table full_down
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table full_down
     *
     * @mbg.generated
     */
    int insert(FullDown record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table full_down
     *
     * @mbg.generated
     */
    int insertSelective(FullDown record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table full_down
     *
     * @mbg.generated
     */
    FullDown selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table full_down
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(FullDown record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table full_down
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(FullDown record);

    List<FullDownVo> findList(@Param("fullDown") FullDown fullDown,@Param("storeIds") List<Integer> storeIds);

    @Select("select * from full_down where id = #{fullDownId} and status = #{status}")
    FullDown findByIdAndStatus(@Param("fullDownId") Integer fullDownId, @Param("status") Integer status);
}