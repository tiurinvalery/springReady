package service;

import com.yopselmopsel.service.model.Good;
import com.yopselmopsel.service.repo.GoodRepository;
import com.yopselmopsel.service.service.GoodService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml"})
public class GoodServiceTest extends Assert {

    private static Logger logger = LoggerFactory.getLogger(GoodServiceTest.class);

    @Autowired
    GoodService goodService;

    @Before
    public void initMockCompany() {
        logger.info("init");
    }

    @Test
    public void checkCRUDGoodService() throws Exception {
        logger.info("test");
    }

    @Test
    public void checkGoodCreate() throws Exception {
        Good good = new Good();
        good.setName("1");
        good.setPrice(1L);
        good.setNumber(2);
        good.setOrderSet(null);
        goodService.createGood(good);
        Good testGood = goodService.findGoodByName(good.getName());
        assertTrue(testGood!=null);
    }

    @Test
    public void checkGoodsCreate() throws Exception {
        Good good1 = new Good();
        good1.setName("1");
        good1.setNumber(1);
        good1.setPrice(1L);
        good1.setOrderSet(null);


        Good good2 = new Good();
        good2.setPrice(2L);
        good2.setName("2");
        good2.setNumber(2);
        good2.setOrderSet(null);

        List<Good> createList = new ArrayList<>();
        createList.add(good1);
        createList.add(good2);
        goodService.createGoods(createList);

        Good test1 = goodService.findGoodByName(good1.getName());
        Good test2 = goodService.findGoodByName(good2.getName());

        assertTrue(test1.getName().equals(good1.getName())&&test2.getName().equals(good2.getName()));


        }


    @Test
    public void checkGoodUpdate(){
        Good good = new Good();
        good.setNumber(1);
        good.setName("1");
        good.setOrderSet(null);
        good.setPrice(1000L);
        goodService.updateGood(good);
        good.setNumber(2);
        goodService.updateGood(good);
        Good test = goodService.findGoodByName(good.getName());
        assertTrue(test.getNumber() == good.getNumber());
    }
    @Test
    public void checkGoodsUpdate() throws Exception {
        Good good1 = new Good();
        good1.setName("1");
        good1.setNumber(1);
        good1.setPrice(1L);
        good1.setOrderSet(null);


        Good good2 = new Good();
        good2.setPrice(2L);
        good2.setName("2");
        good2.setNumber(2);
        good2.setOrderSet(null);

        List<Good> createList = new ArrayList<>();
        createList.add(good1);
        createList.add(good2);
        goodService.createGoods(createList);

        good1.setNumber(6);
        good1.setName("name_1");
        good2.setNumber(8);
        good2.setName("naMe_2");
        List<Good> updateList = new ArrayList<>();
        updateList.add(good1);
        updateList.add(good2);
        goodService.updateGoods(updateList);

        Good test1 = goodService.findGoodByName(good1.getName());
        Good test2 = goodService.findGoodByName(good2.getName());
        assertTrue(test1.getName().equals(good1.getName())&&test2.getName().equals(good2.getName()) && test1.getNumber() == good1.getNumber() && test2.getNumber() == good2.getNumber());


    }

    @Test
    public void checkDeleteGood() throws Exception {
        Good good = new Good();
        good.setName("1");
        good.setPrice(1L);
        good.setNumber(2);
        good.setOrderSet(null);
        goodService.createGood(good);
        goodService.deleteGood(good);
        Good testGood = goodService.findGoodByName(good.getName());
        assertTrue(null==testGood);

    }

    @Test
    public void checkDeleteGoods() throws Exception {
        Good good1 = new Good();
        good1.setName("1");
        good1.setNumber(1);
        good1.setPrice(1L);
        good1.setOrderSet(null);


        Good good2 = new Good();
        good2.setPrice(2L);
        good2.setName("2");
        good2.setNumber(2);
        good2.setOrderSet(null);

        List<Good> createList = new ArrayList<>();
        createList.add(good1);
        createList.add(good2);
        goodService.createGoods(createList);
        List<Good> deleteGoodsList = new ArrayList<>();
        deleteGoodsList.add(good1);
        deleteGoodsList.add(good2);
        goodService.deleteGoods(deleteGoodsList);
        Good test1 = goodService.findGoodByName(good1.getName());
        Good test2 = goodService.findGoodByName(good2.getName());
        assertTrue(null==test1 && null == test2);
        }

        @Test
        public void checkFindGoodByName(){
            Good execute = new Good();
            execute.setName("name");
            execute.setNumber(1);
            execute.setPrice(2L);
            execute.setOrderSet(null);
            goodService.createGood(execute);

            Good test = goodService.findGoodByName(execute.getName());
            assertTrue(execute.getName().equals(test.getName()));
        }
}
