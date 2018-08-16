package vip.ddm.ddm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.ddm.ddm.dao.GoodsGroupMapper;
import vip.ddm.ddm.model.GoodsGroup;
import vip.ddm.ddm.service.GoodsGroupService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DdmApplicationTests {
    @Autowired
    private GoodsGroupService goodsGroupService;

    @Test
    public void contextLoads() {
        GoodsGroup goodsGroup = new GoodsGroup();
        goodsGroup.setId(1);
        goodsGroup.setGroupName("水果");
        goodsGroupService.save(goodsGroup);
    }

}
