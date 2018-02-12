package service;

import com.yopselmopsel.service.model.Client;
import com.yopselmopsel.service.model.Good;
import com.yopselmopsel.service.model.Order;
import com.yopselmopsel.service.model.PartOrder;
import com.yopselmopsel.service.service.ClientService;
import com.yopselmopsel.service.service.GoodService;
import com.yopselmopsel.service.service.OrderService;
import com.yopselmopsel.service.service.PartOrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml"})
public class PartOrderServiceTest extends Assert {
    private static Logger logger = LoggerFactory.getLogger(PartOrderServiceTest.class);

    @Autowired
    private PartOrderService partOrderService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;

    @Before
    public void initMockCompany() {
        logger.info("init");
    }

    @Test
    public void checkCRUDGoodService() throws Exception {
        logger.info("test");
    }

    @Test
    public void checkPartOrderCreate() {
        Good good = new Good();
        good.setPrice(10L);
        good.setOrderSet(null);
        good.setName("PartOrderGoods");
        good.setNumber(289);

        Client client = new Client();
        client.setName("PartOrdersClient");

        Order order = new Order();
        order.setClient(client);
        Set<Order> clientsOrderSet = new HashSet<>();
        clientsOrderSet.add(order);
        client.setOrderSet(clientsOrderSet);

        PartOrder partOrder = new PartOrder();
        partOrder.setGood(good);
        partOrder.setNumber(13);
        partOrder.setTotalPrice(partOrder.getGood().getPrice()*partOrder.getNumber());
        partOrder.setOrder(order);
        Set<PartOrder> partOrderSet = new HashSet<>();
        partOrderSet.add(partOrder);
        order.setOrders(partOrderSet);
        order.setPrice(orderService.getResultPrice(partOrderSet));



        goodService.createGood(good);
        clientService.createClient(client);
        orderService.createOrder(order);
        partOrderService.createPartOrder(partOrder);

        PartOrder test = partOrderService.findPartOrderByNumberAndGoodAndOrder(partOrder.getNumber(),partOrder.getGood(),partOrder.getOrder());
        assertTrue(test!=null);
        }

        @Test
        public void checkOrderPartsCreate() {
            Good good1 = new Good();
            Good good2 = new Good();

            good1.setPrice(10L);
            good1.setOrderSet(null);
            good1.setName("PartOrderGoods");
            good1.setNumber(289);

            good2.setPrice(213L);
            good2.setNumber(212);
            good2.setOrderSet(null);
            good2.setName("SevondPartOrderProduct");

            Client client1 = new Client();
            Client client2 = new Client();

            client1.setName("PartOrdersClient");
            client2.setName("SecondPartOrderClient");

            Order order1 = new Order();
            Order order2 = new Order();

            order1.setClient(client1);
            order2.setClient(client2);

            Set<Order> clientsOrderSet1 = new HashSet<>();
            Set<Order> clientsOrderSet2 = new HashSet<>();

            clientsOrderSet1.add(order1);
            client1.setOrderSet(clientsOrderSet1);

            clientsOrderSet2.add(order2);
            client2.setOrderSet(clientsOrderSet2);

            PartOrder partOrder1 = new PartOrder();
            PartOrder partOrder2 = new PartOrder();

            partOrder1.setGood(good1);
            partOrder1.setNumber(13);
            partOrder1.setTotalPrice(partOrder1.getGood().getPrice()*partOrder1.getNumber());
            partOrder1.setOrder(order1);
            partOrder2.setGood(good2);
            partOrder2.setNumber(145);
            partOrder2.setTotalPrice(partOrder2.getGood().getPrice()*partOrder2.getNumber());
            partOrder2.setOrder(order2);

            Set<PartOrder> partOrderSet1 = new HashSet<>();
            Set<PartOrder> partOrderSet2 = new HashSet<>();

            partOrderSet1.add(partOrder1);
            partOrderSet2.add(partOrder2);

            order1.setOrders(partOrderSet1);
            order1.setPrice(orderService.getResultPrice(partOrderSet1));
            order2.setOrders(partOrderSet2);
            order2.setPrice(orderService.getResultPrice(partOrderSet2));

           List<PartOrder> partOrders = new ArrayList<>();
           partOrders.add(partOrder1);
           partOrders.add(partOrder2);

            goodService.createGood(good1);
            goodService.createGood(good2);
            clientService.createClient(client1);
            clientService.createClient(client2);
            orderService.createOrder(order1);
            orderService.createOrder(order2);
            partOrderService.createPartOrders(partOrders);

            PartOrder test1 = partOrderService.findPartOrderByNumberAndGoodAndOrder(partOrder1.getNumber(),partOrder1.getGood(),partOrder1.getOrder());
            PartOrder test2 = partOrderService.findPartOrderByNumberAndGoodAndOrder(partOrder2.getNumber(),partOrder2.getGood(),partOrder2.getOrder());

            assertTrue(test1.getNumber()==partOrder1.getNumber()&&test1.getTotalPrice().equals(partOrder1.getTotalPrice())&&test2.getNumber()==partOrder2.getNumber()&&test2.getTotalPrice().equals(partOrder2.getTotalPrice()));
        }

        @Test
    public void checkUpdateOrder() throws Exception {
            Good good = new Good();
            good.setPrice(10L);
            good.setOrderSet(null);
            good.setName("PartOrderGoods");
            good.setNumber(289);

            Client client = new Client();
            client.setName("PartOrdersClient");

            Order order = new Order();
            order.setClient(client);
            Set<Order> clientsOrderSet = new HashSet<>();
            clientsOrderSet.add(order);
            client.setOrderSet(clientsOrderSet);

            PartOrder partOrder = new PartOrder();
            partOrder.setGood(good);
            partOrder.setNumber(13);
            partOrder.setTotalPrice(partOrder.getGood().getPrice()*partOrder.getNumber());
            partOrder.setOrder(order);
            Set<PartOrder> partOrderSet = new HashSet<>();
            partOrderSet.add(partOrder);
            order.setOrders(partOrderSet);
            order.setPrice(orderService.getResultPrice(partOrderSet));



            goodService.createGood(good);
            clientService.createClient(client);
            orderService.createOrder(order);
            partOrderService.createPartOrder(partOrder);

            partOrder.setNumber(3);
            partOrderService.updatePartOrder(partOrder);
            orderService.updateOrder(order);

            PartOrder test = partOrderService.findPartOrderByNumberAndGoodAndOrder(partOrder.getNumber(),partOrder.getGood(),partOrder.getOrder());
            assertTrue(test.getNumber()==partOrder.getNumber());
        }

        @Test
    public void checkDeletePartOrder() throws Exception {
            Good good = new Good();
            good.setPrice(18L);
            good.setOrderSet(null);
            good.setName("PartOrderGoods_Del");
            good.setNumber(2769);

            Client client = new Client();
            client.setName("PartOrdersClient_Del");

            Order order = new Order();
            order.setClient(client);
            Set<Order> clientsOrderSet = new HashSet<>();
            clientsOrderSet.add(order);
            client.setOrderSet(clientsOrderSet);

            PartOrder partOrder = new PartOrder();
            partOrder.setGood(good);
            partOrder.setNumber(187);
            partOrder.setTotalPrice(partOrder.getGood().getPrice()*partOrder.getNumber());
            partOrder.setOrder(order);
            Set<PartOrder> partOrderSet = new HashSet<>();
            partOrderSet.add(partOrder);
            order.setOrders(partOrderSet);
            order.setPrice(orderService.getResultPrice(partOrderSet));



            goodService.createGood(good);
            clientService.createClient(client);
            orderService.createOrder(order);
            partOrderService.createPartOrder(partOrder);


            partOrderService.deletePartOrder(partOrder);

            PartOrder test = partOrderService.findPartOrderByNumberAndGoodAndOrder(partOrder.getNumber(),partOrder.getGood(),partOrder.getOrder());
            assertTrue((!test.getGood().equals(partOrder.getGood())) && (!test.getOrder().equals(partOrder.getGood()))&&(test.getNumber()!=partOrder.getNumber()));
        }

        @Test
    public void checkPartOrdersDelete() throws Exception {
            Good good1 = new Good();
            Good good2 = new Good();

            good1.setPrice(46L);
            good1.setOrderSet(null);
            good1.setName("PartOrderGoods12");
            good1.setNumber(2232);

            good2.setPrice(21345L);
            good2.setNumber(2122);
            good2.setOrderSet(null);
            good2.setName("SevondPartOrderProduct123");

            Client client1 = new Client();
            Client client2 = new Client();

            client1.setName("PartOrdersClient12");
            client2.setName("SecondPartOrderClient123");

            Order order1 = new Order();
            Order order2 = new Order();

            order1.setClient(client1);
            order2.setClient(client2);

            Set<Order> clientsOrderSet1 = new HashSet<>();
            Set<Order> clientsOrderSet2 = new HashSet<>();

            clientsOrderSet1.add(order1);
            client1.setOrderSet(clientsOrderSet1);

            clientsOrderSet2.add(order2);
            client2.setOrderSet(clientsOrderSet2);

            PartOrder partOrder1 = new PartOrder();
            PartOrder partOrder2 = new PartOrder();

            partOrder1.setGood(good1);
            partOrder1.setNumber(13);
            partOrder1.setTotalPrice(partOrder1.getGood().getPrice()*partOrder1.getNumber());
            partOrder1.setOrder(order1);
            partOrder2.setGood(good2);
            partOrder2.setNumber(145);
            partOrder2.setTotalPrice(partOrder2.getGood().getPrice()*partOrder2.getNumber());
            partOrder2.setOrder(order2);

            Set<PartOrder> partOrderSet1 = new HashSet<>();
            Set<PartOrder> partOrderSet2 = new HashSet<>();

            partOrderSet1.add(partOrder1);
            partOrderSet2.add(partOrder2);

            order1.setOrders(partOrderSet1);
            order1.setPrice(orderService.getResultPrice(partOrderSet1));
            order2.setOrders(partOrderSet2);
            order2.setPrice(orderService.getResultPrice(partOrderSet2));

            List<PartOrder> partOrders = new ArrayList<>();
            partOrders.add(partOrder1);
            partOrders.add(partOrder2);

            goodService.createGood(good1);
            goodService.createGood(good2);
            clientService.createClient(client1);
            clientService.createClient(client2);
            orderService.createOrder(order1);
            orderService.createOrder(order2);
            partOrderService.createPartOrders(partOrders);

            List<PartOrder> partOrdersForDelete = new ArrayList<>();
            partOrdersForDelete.add(partOrder1);
            partOrdersForDelete.add(partOrder2);

            partOrderService.deletePartOrders(partOrdersForDelete);

            PartOrder test1 = partOrderService.findPartOrderByNumberAndGoodAndOrder(partOrder1.getNumber(),partOrder1.getGood(),partOrder1.getOrder());
            PartOrder test2 = partOrderService.findPartOrderByNumberAndGoodAndOrder(partOrder2.getNumber(),partOrder2.getGood(),partOrder2.getOrder());

            assertTrue(null==test1 && null == test2);
        }
}
