package vip.ddm.ddm.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import vip.ddm.ddm.model.Store;

import java.util.List;

public interface StoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store
     *
     * @mbg.generated
     */
    int insert(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store
     *
     * @mbg.generated
     */
    int insertSelective(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store
     *
     * @mbg.generated
     */
    Store selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Store record);

    @Select("select * from store")
    List<Store> list();

    @Select("select * from store where username = #{name}")
    List<Store> findByName(@Param("name") String name);

    List<Store> findByParent(@Param("parentId") Integer parentId,@Param("type")Integer type);
}