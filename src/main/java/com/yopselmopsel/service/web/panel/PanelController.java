package com.yopselmopsel.service.web.panel;

import com.yopselmopsel.service.model.Client;
import com.yopselmopsel.service.model.Order;
import com.yopselmopsel.service.service.ClientService;
import com.yopselmopsel.service.service.GoodService;
import com.yopselmopsel.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PanelController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    /*   Admin page Controllers */

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }







    @RequestMapping(value = "/createaccount", method = RequestMethod.GET)
    public String createAccount(Model model) {
        return "create_account";
    }



    @RequestMapping(value = "/panel/client", method = RequestMethod.GET)
    public String loginPage(Model model) {
        Client client1 = new Client("masha", null);
        Client client2 = new Client("vasya", null);

        clientService.createClient(client1);
        clientService.createClient(client2);
        return "client1";
    }


    @RequestMapping(value = "/panel/order", method = RequestMethod.GET)
    public String orderPage(Model model) {
        return "neworder1";
    }

    @RequestMapping(value = "/panel/good", method = RequestMethod.GET)
    public String goodPage(Model model) {
        return "good";
    }

    @RequestMapping(value = "/panel/order/details/{id}", method = RequestMethod.GET)
    public String orderDetailsPage(@PathVariable Long id, Model model){
        model.addAttribute("clientName",orderService.findOrderById(id).getClient().getName());
        model.addAttribute("orderId",id);
        model.addAttribute("totalPrice",orderService.findOrderById(id).getPrice());
        return "newordercards";
    }
    @RequestMapping(value = "/panel/good/details/{name}",method = RequestMethod.GET)
    public String goodsDetailsPage(@PathVariable String name, Model model) {
        model.addAttribute("goodsName", name);
        model.addAttribute("goodsPrice",goodService.findGoodByName(name).getPrice());
        model.addAttribute("goodsNumber",goodService.findGoodByName(name).getNumber());
        return "goodscard";
    }
}


