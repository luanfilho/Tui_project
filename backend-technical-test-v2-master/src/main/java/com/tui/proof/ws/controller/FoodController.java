package com.tui.proof.ws.controller;

import com.tui.proof.model.Address;
import com.tui.proof.model.Client;
import com.tui.proof.model.OrderPilote;
import com.tui.proof.model.StatusOrder;
import com.tui.proof.service.FoodService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PreAuthorize("hasAuthority('SEARCH')")
    @RequestMapping(value = "/list-orders", method = RequestMethod.GET)
    public String listAllTodos(ModelMap model){

        List<OrderPilote> orders = foodService.getAllOrders();
        foodService.updateStatusPreparing(orders);
        model.addAttribute("orders", orders);

        return "listOrders";
    }

    @PreAuthorize("hasAuthority('SEARCH')")
    @RequestMapping(value = "/list-orders", method = RequestMethod.POST)
    public String search(Model model, String keyword) {
        List<OrderPilote> orders = null;
        if (keyword!=null && !keyword.isEmpty()) {
            orders = foodService.getOrdersByKeyword(keyword);
            model.addAttribute("orders", orders);
        }else {
            orders = foodService.getAllOrders();
            model.addAttribute("orders", orders);
        }

        foodService.updateStatusPreparing(orders);

        return "listOrders";
    }

    @RequestMapping(value = "add-order", method = RequestMethod.GET)
    public String showNewOrderPage(ModelMap model){
        OrderPilote order = new OrderPilote(0, new Address(), 0, 0, new Client(), StatusOrder.Pending);
        model.put("order", order);
        return "order";
    }

    @RequestMapping(value = "add-order", method = RequestMethod.POST)
    public String addNewOrder(ModelMap model, @Valid OrderPilote order, BindingResult result){
        if(result.hasErrors()){
            return "order";
        }

        order.setCreationDateTime(LocalDateTime.now());
        foodService.save(order);

        return "redirect:list-orders";
    }

    @RequestMapping(value = "update-order", method = RequestMethod.GET)
    public String ShowUpdateOrder(@RequestParam int id, ModelMap model, RedirectAttributes redirAttrs){
        OrderPilote order = foodService.findById(id);

        if(foodService.updateStatusPreparing(order)){
            redirAttrs.addFlashAttribute("message", "preparing");
            return "redirect:list-orders";
        }

        model.put("order", order);
        return "order";
    }

    @RequestMapping(value = "update-order", method = RequestMethod.POST)
    public String updateOrder(ModelMap model, @Valid OrderPilote order, BindingResult result, RedirectAttributes redirAttrs){

        if(result.hasErrors()){
            return "order";
        }

        if(foodService.updateStatusPreparing(order)){
            redirAttrs.addFlashAttribute("message", "preparing");
            return "redirect:list-orders";
        }

        foodService.save(order);
        return "redirect:list-orders";
    }

}
