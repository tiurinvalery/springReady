package service;

import com.yopselmopsel.service.model.Client;
import com.yopselmopsel.service.model.Good;
import com.yopselmopsel.service.model.Order;
import com.yopselmopsel.service.model.PartOrder;
import com.yopselmopsel.service.repo.ClientRepository;
import com.yopselmopsel.service.repo.OrderRepository;
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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml"})
public class OrderServiceTest extends Assert {
    private static Logger logger = LoggerFactory.getLogger(OrderServiceTest.class);
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private PartOrderService partOrderService;

    @Before
    public void initMockCompany() {
        logger.info("init");
    }

    @Test
    public void checkCRUDGoodService() throws Exception {
        logger.info("test");
    }

    @Test
    public void checkOrderCreate() throws Exception {
        Order order = new Order();
        order.setPrice(20L);

        Client client = new Client();
        client.setName("clientName");
        Set<Order> clientOrderSet = new HashSet<>();
        clientOrderSet.add(order);
        order.setClient(client);

        PartOrder partOrder = new PartOrder();
        partOrder.setNumber(2);
        partOrder.setOrder(order);

        Good good = new Good();
        good.setName("goodName");
        good.setNumber(10);
        good.setPrice(10L);
        good.setOrderSet(null);

        partOrder.setGood(good);
        partOrder.setTotalPrice(good.getPrice()*partOrder.getNumber());

        Set<PartOrder> partOrders = new HashSet<>();
        partOrders.add(partOrder);
        order.setOrders(partOrders);

        goodService.createGood(good);
        clientService.createClient(client);
        orderService.createOrder(order);
        partOrderService.createPartOrder(partOrder);

        Order test = orderService.findOrderByPriceAndClient(order.getPrice(),order.getClient());
        assertTrue(test!=null);

    }

    @Test
    public void checkOrdersCreate() throws Exception {
        Order order1 = new Order();
        Order order2 = new Order();

        order2.setPrice(16L);
        order1.setPrice(20L);

        Client client1 = new Client();
        Client client2 = new Client();
        client1.setName("clientName");
        client2.setName("clientSecondName");
        Set<Order> clientOrderSet = new HashSet<>();
        Set<Order> orderSet = new HashSet<>();
        clientOrderSet.add(order1);
        orderSet.add(order2);
        order1.setClient(client1);
        order2.setClient(client2);

        PartOrder partOrder1 = new PartOrder();
        PartOrder partOrder2 = new PartOrder();
        partOrder1.setNumber(2);
        partOrder1.setOrder(order1);
        partOrder2.setNumber(5);
        partOrder2.setOrder(order2);

        Good good1 = new Good();
        Good good2 = new Good();
        good1.setName("goodName");
        good1.setNumber(10);
        good1.setPrice(10L);
        good1.setOrderSet(null);

        good2.setName("newName");
        good2.setNumber(190);
        good2.setOrderSet(null);
        good2.setPrice(230L);

        partOrder1.setGood(good1);
        partOrder1.setTotalPrice(good1.getPrice()*partOrder1.getNumber());

        partOrder2.setGood(good2);
        partOrder2.setTotalPrice(good2.getPrice() * partOrder2.getNumber());

        Set<PartOrder> partOrders1 = new HashSet<>();
        partOrders1.add(partOrder1);
        order1.setOrders(partOrders1);

        Set<PartOrder> partOrders2 = new HashSet<>();
        partOrders2.add(partOrder2);
        order2.setOrders(partOrders2);

        List<Order> listForCreate = new LinkedList<>();
        listForCreate.add(order1);
        listForCreate.add(order2);
        goodService.createGood(good1);
        goodService.createGood(good2);
        clientService.createClient(client1);
        clientService.createClient(client2);
        orderService.createOrders(listForCreate);
        partOrderService.createPartOrder(partOrder1);
        partOrderService.createPartOrder(partOrder2);

        Order test1 = orderService.findOrderByPriceAndClient(order1.getPrice(),order1.getClient());
        Order test2 = orderService.findOrderByPriceAndClient(order2.getPrice(),order2.getClient());
        assertTrue(test1!=null&& test2 !=null);
    }
    @Test
    public void checkOrderUpdate() throws Exception {
        Order order = new Order();
        order.setPrice(20L);

        Client client = new Client();
        client.setName("clientName");
        Set<Order> clientOrderSet = new HashSet<>();
        clientOrderSet.add(order);
        order.setClient(client);

        PartOrder partOrder = new PartOrder();
        partOrder.setNumber(2);
        partOrder.setOrder(order);

        Good good = new Good();
        good.setName("goodName");
        good.setNumber(10);
        good.setPrice(10L);
        good.setOrderSet(null);

        partOrder.setGood(good);
        partOrder.setTotalPrice(good.getPrice()*partOrder.getNumber());

        Set<PartOrder> partOrders = new HashSet<>();
        partOrders.add(partOrder);
        order.setOrders(partOrders);

        goodService.createGood(good);
        clientService.createClient(client);
        orderService.createOrder(order);
        partOrderService.createPartOrder(partOrder);

         order.setPrice(18L);
         orderService.updateOrder(order);
         Order test = orderService.findOrderByPriceAndClient(order.getPrice(),order.getClient());
         assertTrue(test.getPrice().equals(order.getPrice()));
         }

         @Test
         public void checkOrdersUpdate() throws Exception {
             Order order1 = new Order();
             Order order2 = new Order();

             order2.setPrice(16L);
             order1.setPrice(20L);

             Client client1 = new Client();
             Client client2 = new Client();
             client1.setName("clientName");
             client2.setName("clientSecondName");
             Set<Order> clientOrderSet = new HashSet<>();
             Set<Order> orderSet = new HashSet<>();
             clientOrderSet.add(order1);
             orderSet.add(order2);
             order1.setClient(client1);
             order2.setClient(client2);

             PartOrder partOrder1 = new PartOrder();
             PartOrder partOrder2 = new PartOrder();
             partOrder1.setNumber(2);
             partOrder1.setOrder(order1);
             partOrder2.setNumber(5);
             partOrder2.setOrder(order2);

             Good good1 = new Good();
             Good good2 = new Good();
             good1.setName("goodName");
             good1.setNumber(10);
             good1.setPrice(10L);
             good1.setOrderSet(null);

             good2.setName("newName");
             good2.setNumber(190);
             good2.setOrderSet(null);
             good2.setPrice(230L);

             partOrder1.setGood(good1);
             partOrder1.setTotalPrice(good1.getPrice()*partOrder1.getNumber());

             partOrder2.setGood(good2);
             partOrder2.setTotalPrice(good2.getPrice() * partOrder2.getNumber());

             Set<PartOrder> partOrders1 = new HashSet<>();
             partOrders1.add(partOrder1);
             order1.setOrders(partOrders1);

             Set<PartOrder> partOrders2 = new HashSet<>();
             partOrders2.add(partOrder2);
             order2.setOrders(partOrders2);

             List<Order> listForCreate = new LinkedList<>();
             listForCreate.add(order1);
             listForCreate.add(order2);
             goodService.createGood(good1);
             goodService.createGood(good2);
             clientService.createClient(client1);
             clientService.createClient(client2);
             orderService.createOrders(listForCreate);
             partOrderService.createPartOrder(partOrder1);
             partOrderService.createPartOrder(partOrder2);

             order1.setPrice(197L);
             order2.setPrice(23L);

             List<Order> updateList = new LinkedList<>();
             updateList.add(order1);
             updateList.add(order2);

             orderService.updateOrders(updateList);

             Order test1 = orderService.findOrderByPriceAndClient(order1.getPrice(),order1.getClient());
             Order test2 = orderService.findOrderByPriceAndClient(order2.getPrice(),order2.getClient());

             assertTrue(order1.getPrice().equals(test1.getPrice())&&order2.getPrice().equals(test2.getPrice()));
         }

        @Test
        public void checkOrderDelete() throws Exception {
           Order order = new Order();

           Client client = new Client();
           client.setName("clientOrderTest");
           Set<Order> orderSet = new HashSet<>();
           orderSet.add(order);
           client.setOrderSet(orderSet);

           Good good = new Good();
           good.setName("goodForOrderTest");
           good.setNumber(234);
           good.setOrderSet(null);
           good.setPrice(12345L);

           PartOrder partOrder = new PartOrder();
           partOrder.setOrder(order);
           partOrder.setGood(good);
           partOrder.setNumber(3);
           partOrder.setTotalPrice(partOrder.getGood().getPrice()*partOrder.getNumber());

           Set<PartOrder> partOrders = new HashSet<>();
           partOrders.add(partOrder);

           order.setPrice(orderService.getResultPrice(partOrders));
           order.setClient(client);
           order.setOrders(partOrders);

            goodService.createGood(good);
            clientService.createClient(client);
            orderService.createOrder(order);
            partOrderService.createPartOrder(partOrder);


            orderService.deleteOrder(order);

            Order test = orderService.findOrderByPriceAndClient(order.getPrice(),order.getClient());
            assertTrue(null==test);
        }



}
