package com.usecase.shop.controller;

import com.usecase.shop.entities.Product;
import com.usecase.shop.form.ProductForm;
import com.usecase.shop.model.OrderDetailInfo;
import com.usecase.shop.model.OrderInfo;
import com.usecase.shop.service.OrderService;
import com.usecase.shop.service.ProductService;
import com.usecase.shop.service.ShopService;
import com.usecase.shop.validator.ProductFormValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ProductFormValidator productFormValidator;

    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        if (target.getClass() == ProductForm.class) {
            dataBinder.setValidator(productFormValidator);
        }
    }

    // GET: Show Login Page
    @RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
    public String showPage() {
        return "login";
    }

    // GET: Show Logout Page
    @RequestMapping(value = { "/admin/logout" }, method = RequestMethod.GET)
    public String showLogout() {
        return "logout";
    }

    // GET: Show Login Page
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String showIndex(Model model, Authentication authentication) {
            if (authentication != null && authentication.isAuthenticated()) {
                model.addAttribute("username", authentication.getName());  // or access authorities/roles if needed
            } else {
                model.addAttribute("username", "Guest");
            }
        return "index";
    }

    @RequestMapping(value = { "/admin/accountInfo" }, method = RequestMethod.GET)
    public String accountInfo(Model model) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.isEnabled());

        model.addAttribute("userDetails", userDetails);
        return "accountInfo";
    }

    /*    @RequestMapping(value = { "/orderList" }, method = RequestMethod.GET)*/
    @RequestMapping(value = { "/admin/orderList" }, method = RequestMethod.GET)
    public String orderList(Model model, //
                            @RequestParam(value = "page", defaultValue = "0") String pageStr) {
        int page = 1;
        try {
            page = Integer.parseInt(pageStr);
        } catch (Exception e) {
        }
        final int MAX_RESULT = 5;
        final int MAX_NAVIGATION_PAGE = 10;

        Page<OrderInfo> paginationResult = shopService.listOrderInfo(page, MAX_RESULT, MAX_NAVIGATION_PAGE);

        model.addAttribute("paginationResult", paginationResult);
        model.addAttribute("paginationCount", paginationResult.getTotalPages());
        return "orderList";
    }

    // GET: Show product.
/*    @RequestMapping(value = { "/product" }, method = RequestMethod.GET)*/
    @RequestMapping(value = { "/admin/product" }, method = RequestMethod.GET)
    public String product(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
        ProductForm productForm = null;

        if (code != null && code.length() > 0) {
            Product product = productService.findProductByCode(code);
            if (product != null) {
                productForm = new ProductForm(product);
            }
        }
        if (productForm == null) {
            productForm = new ProductForm();
            productForm.setNewProduct(true);
        }
        model.addAttribute("productForm", productForm);
        return "product";
    }

    // POST: Save product
/*    @RequestMapping(value = { "/product" }, method = RequestMethod.POST)*/
    @RequestMapping(value = { "/admin/product" }, method = RequestMethod.POST)
    public String productSave(Model model, //
                              @ModelAttribute("productForm") @Validated ProductForm productForm, //
                              BindingResult result, //
                              final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "product";
        }
        try {
            productService.addProduct(productForm);
        } catch (Exception e) {
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            String message = rootCause.getMessage();
            model.addAttribute("errorMessage", message);
            // Show product form.
            return "product";
        }

/*        return "redirect:/admin/productList";*/
        return "redirect:/productList";
    }

    /*@RequestMapping(value = { "/order" }, method = RequestMethod.GET)*/
    @RequestMapping(value = { "/admin/order" }, method = RequestMethod.GET)
    public String orderView(Model model, @RequestParam("orderId") String orderId) {
        OrderInfo orderInfo = null;
        if (orderId != null) {
            orderInfo = shopService.getOrderInfo(orderId);
        }
        if (orderInfo == null) {
/*            return "redirect:/admin/orderList";*/
            return "redirect:/orderList";
        }
        List<OrderDetailInfo> details = shopService.listOrderDetailInfos(orderId);
        orderInfo.setDetails(details);

        model.addAttribute("orderInfo", orderInfo);

        return "order";
    }

}