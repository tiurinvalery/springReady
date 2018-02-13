package com.yopselmopsel.service.web.api;

import com.yopselmopsel.service.model.*;
import com.yopselmopsel.service.service.ClientService;
import com.yopselmopsel.service.service.GoodService;
import com.yopselmopsel.service.service.OrderService;
import com.yopselmopsel.service.service.PartOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;



@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);
    @Autowired
    ClientService clientService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private PartOrderService partOrderService;



    @RequestMapping(value = "/api/create", method = RequestMethod.POST)
    public List<Client> createClient(@RequestBody Client client) {
        clientService.createClient(new Client(client.getName(),client.getOrderSet()));

        return clientService.findAllClient();
    }

    @RequestMapping(value = "/api/delete/{id}", method = RequestMethod.POST)
    public List<Client> deleteClient(@PathVariable long id) {
        clientService.deleteClient(clientService.findClientById(id));

        return clientService.findAllClient();
    }

                        // ##### Good's Controllers ###### //

    @RequestMapping(value = "/api/good", method = RequestMethod.GET)
    public Good sendGoodToPage() {
        Good responseGood = new Good();
        responseGood.setName("name");
        responseGood.setNumber(14);
        responseGood.setPrice(123L);

        return responseGood;
    }

    @GetMapping(value = "/api/orders")
    public Response getAllOrders() {
        return new Response(orderService.findAllOrders());
    }

    @GetMapping(value = "/api/good/{id}/products/")
    public GoodsResponse getAllGoodsInOrder(@PathVariable Long id) {return new GoodsResponse(goodService.findAllGoodsInOrder(id),id);}

    @PostMapping(value = "/api/good/{id}/products/")
    public void addNewPartOrder(@PathVariable Long id, String newGoodsName, int newGoodsNumber){
        Good good = goodService.findGoodByName(newGoodsName);
        Order order = orderService.findOrderById(id);
        if(good.getNumber()<newGoodsNumber){
            newGoodsNumber = good.getNumber();
        }
        PartOrder partOrder = new PartOrder();
        partOrder.setNumber(newGoodsNumber);
        partOrder.setOrder(order);
        partOrder.setGood(good);
        partOrder.setTotalPrice(good.getPrice()*partOrder.getNumber());
        Set<PartOrder> partOrders = order.getOrders();
        partOrders.add(partOrder);
        order.setOrders(partOrders);
        orderService.updateOrder(order);
        partOrderService.createPartOrder(partOrder);
        }

       @RequestMapping(value = "/api/order/{orderId}/partOrder/{partId}",method = RequestMethod.DELETE)
       public void deletePartOrder(@PathVariable Long orderId,@PathVariable Long partId){
        Order order = orderService.findOrderById(orderId);
        logger.info("Find order");
        PartOrder partOrder = partOrderService.findPartOrderById(partId);
        logger.info("Find PartOrder");
        order.getOrders().remove(partOrder);
        logger.info("Remove part order from Set");
        orderService.updateOrder(order);
        logger.info("Update Order");
        partOrderService.deletePartOrder(partOrder);
        logger.info("Delete part order");
        logger.info("OK");
       }



    @RequestMapping(value = "/api/createorders", method = RequestMethod.GET)
    public void createFakeOrders() {
        Order order = new Order();
        Client client = new Client();
        client.setName("katya");
        Set<Order> orderSet = new HashSet<>();
        orderSet.add(order);
        client.setOrderSet(orderSet);
        order.setClient(client);

        Good good1 = new Good();
        good1.setNumber(12);
        good1.setPrice(135L);
        good1.setName("good1");
        good1.setOrderSet(null);

        Good good2 = new Good();
        good2.setName("good2");
        good2.setPrice(1265L);
        good2.setNumber(18);
        good2.setOrderSet(null);

        PartOrder partOrder1 = new PartOrder();
        partOrder1.setGood(good1);
        partOrder1.setNumber(2);
        partOrder1.setOrder(order);
        partOrder1.setTotalPrice(partOrder1.getGood().getPrice()*partOrder1.getNumber());

        PartOrder partOrder2 = new PartOrder();
        partOrder2.setGood(good2);
        partOrder2.setNumber(6);
        partOrder2.setOrder(order);
        partOrder2.setTotalPrice(partOrder2.getGood().getPrice()*partOrder2.getNumber());

        Set<PartOrder> partOrders = new HashSet<>();
        partOrders.add(partOrder1);
        partOrders.add(partOrder2);

        order.setOrders(partOrders);

        order.setPrice(orderService.getResultPrice(order.getOrders()));

        goodService.createGood(good1);
        goodService.createGood(good2);
        clientService.createClient(client);
        orderService.createOrder(order);
        partOrderService.createPartOrder(partOrder1);
        partOrderService.createPartOrder(partOrder2);


        Order secondOrder = new Order();
        Client secondClient = new Client();
        secondClient.setName("marina");
        Set<Order> secondOrderSet = new HashSet<>();
        secondOrderSet.add(secondOrder);
        secondClient.setOrderSet(secondOrderSet);
        secondOrder.setClient(secondClient);

        Good secondGood1 = new Good();
        secondGood1.setNumber(23);
        secondGood1.setPrice(844L);
        secondGood1.setName("secondGood1");
        secondGood1.setOrderSet(null);

        Good secondGood2 = new Good();
        secondGood2.setName("secondGood2");
        secondGood2.setPrice(11L);
        secondGood2.setNumber(188);
        secondGood2.setOrderSet(null);

        PartOrder secondPartOrder1 = new PartOrder();
        secondPartOrder1.setGood(secondGood1);
        secondPartOrder1.setNumber(3);
        secondPartOrder1.setOrder(secondOrder);
        secondPartOrder1.setTotalPrice(secondPartOrder1.getGood().getPrice()*secondPartOrder1.getNumber());

        PartOrder secondPartOrder2 = new PartOrder();
        secondPartOrder2.setGood(secondGood2);
        secondPartOrder2.setNumber(7);
        secondPartOrder2.setOrder(secondOrder);
        secondPartOrder2.setTotalPrice(secondPartOrder2.getGood().getPrice()*secondPartOrder2.getNumber());

        Set<PartOrder> secondPartOrders = new HashSet<>();
        secondPartOrders.add(secondPartOrder1);
        secondPartOrders.add(secondPartOrder2);

        secondOrder.setOrders(secondPartOrders);

        secondOrder.setPrice(orderService.getResultPrice(secondOrder.getOrders()));

        goodService.createGood(secondGood1);
        goodService.createGood(secondGood2);
        clientService.createClient(secondClient);
        orderService.createOrder(secondOrder);
        partOrderService.createPartOrder(secondPartOrder1);
        partOrderService.createPartOrder(secondPartOrder2);
    }

    @RequestMapping(value = "/api/order/details/{id}", method = RequestMethod.PUT)
    public void updateOrder(@PathVariable Long id, String newClientName, Long newTotalPrice) {
        Order order = orderService.findOrderById(id);
        if(newTotalPrice != null){
            order.setPrice(newTotalPrice);
        orderService.updateOrder(order); }
        if(newClientName != null) {
        Client client = clientService.findClientByName(order.getClient().getName());
        client.setName(newClientName);
        clientService.updateClient(client);
       }
    }
    class Response {
        class ResponsePart {
            Long id;
            int totalNumber;
            String clientName;
            Long price;

            ResponsePart(Long id, Long price, int totalNumber, String clientName) {
                this.id = id;
                this.price = price;
                this.totalNumber = totalNumber;
                this.clientName = clientName;

            }
        }

        List<ResponsePart> data;

        public Response(List<Order> orderList) {
            this.data = new ArrayList<>();
            orderList.forEach(order -> data.add(
                    new ResponsePart(order.getId(),orderService.getResultPrice(orderService.findOrderById(order.getId()).getOrders()), orderService.getTotalNumberOfGoods(orderService.findOrderById(order.getId()).getOrders()),order.getClient().getName())));
        }
    }
    class GoodsResponse {
        class ResponsePart {
            Long DT_RowId;
            String name;
            int number;
            Long price;
            Long partOrderId;



            ResponsePart(Long id,String name,int number,Long price, Long partOrderId) {
                this.DT_RowId =id;
                this.name = name;
                this.number = number;
                this.price = price;
                this.partOrderId = partOrderId;
                }



        }
        List<ResponsePart> data;
        public GoodsResponse(List<Good> goodList, Long orderId) {
            this.data = new ArrayList<>();
            Long counter = 1L;
            for(Good good: goodList) {
                data.add(new ResponsePart(counter,good.getName(),good.getNumber(),good.getPrice(),partOrderService.findPartOrderByNumberAndGoodAndOrder(good.getNumber(),good,orderService.findOrderById(orderId)).getId()));
                counter=counter+1L;
            }

        }



    }
}
