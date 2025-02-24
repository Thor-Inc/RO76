package pl.sda.ro76.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.ro76.model.Order;
import pl.sda.ro76.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("/create")
    public String showOrderForm(final ModelMap modelMap) {
        modelMap.addAttribute("orderForm", new Order());
        return "order";
    }

    @PostMapping("/create")
    public String handleNewOrder(@Valid @ModelAttribute("orderForm") final Order order, final Errors errors) {
        // handle new Order here
        if (errors.hasErrors()) {
            return "order";
        }
        orderService.addOrder(order);
        return "redirect:/orders/create";
    }


    @GetMapping("/orderlist")
    public String getAllOrders(ModelMap orderMap) {
        orderMap.addAttribute("orders", orderService.getAllOrders());
        return "orderlist";
    }

}
