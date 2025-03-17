package com.usecase.shop.utils;

import com.usecase.shop.model.CartInfo;
import com.usecase.shop.model.CustomerInfo;
import jakarta.servlet.http.HttpServletRequest;

public class Utils {

    // Products in the cart, stored in Session.
    public static CartInfo getCartInSession(HttpServletRequest request) {

        CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");


        if (cartInfo == null) {
            cartInfo = new CartInfo();
            CustomerInfo customerInfo = new CustomerInfo();
            cartInfo.setCustomerInfo(customerInfo);

            request.getSession().setAttribute("myCart", cartInfo);
        }

        return cartInfo;
    }

    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }

    public static void storeLastOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
        request.getSession().setAttribute("lastOrderedCart", cartInfo);
    }

    public static CartInfo getLastOrderedCartInSession(HttpServletRequest request) {
        return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
    }

}