package com.usecase.shop.service;

import com.usecase.shop.entities.Order;
import com.usecase.shop.entities.OrderDetail;
import com.usecase.shop.entities.Product;
import com.usecase.shop.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    public void saveOrderFromCart(CartInfo cartInfo) {

        int orderNum = orderService.findAll().size() + 1;
        Order order = new Order();

        order.setId(UUID.randomUUID().toString());
        order.setOrderNum(orderNum);
        order.setOrderDate(new Date(System.currentTimeMillis()));
        order.setAmount(cartInfo.getAmountTotal());

        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        order.setCustomerName(customerInfo.getName());
        order.setCustomerEmail(customerInfo.getEmail());
        order.setCustomerPhone(customerInfo.getPhone());
        order.setCustomerAddress(customerInfo.getAddress());

        orderService.addOrder(order);

        List<CartLineInfo> lines = cartInfo.getCartLines();

        for (CartLineInfo line : lines) {
            OrderDetail detail = new OrderDetail();
            detail.setId(UUID.randomUUID().toString());
            detail.setOrder(order);
            detail.setAmount(line.getAmount());
            detail.setPrice(line.getProductInfo().getPrice());
            detail.setQuanity(line.getQuantity());

            String code = line.getProductInfo().getCode();
            Product product = productService.findProductByCode(code);
            detail.setProduct(product);

            orderDetailService.addOrderDetail(detail);
        }

        cartInfo.setOrderNum(orderNum);
    }


    public Page<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
                                           String likeName) {

        Sort sort =  Sort.by("createDate").ascending();
        Pageable pageable = PageRequest.of(page, maxNavigationPage, sort);
        Page<Product> productPage = productService.findAll(pageable);

        List<ProductInfo> productInfoList = productPage.stream().map(ProductInfo::new).collect(Collectors.toList());
        Page<ProductInfo> listInfoPage = new PageImpl<>(new ArrayList<>(), pageable, 0);

        if(productInfoList.size() > 0) {
            listInfoPage = new PageImpl<>(productInfoList, pageable, productInfoList.size());
        }

        return listInfoPage;
    }

    public Page<OrderInfo> listOrderInfo(int page, int max_result, int maxNavigationPage) {
        Sort sort =  Sort.by("orderDate").ascending();
        Pageable pageable = PageRequest.of(page, maxNavigationPage, sort);
        Page<Order> orderPage = orderService.findAll(pageable);

        List<OrderInfo> orderInfoList = orderPage.stream().map(OrderInfo::new).collect(Collectors.toList());
        Page<OrderInfo> orderInfoPage = new PageImpl<>(new ArrayList<>(), pageable, 0);

        if(orderInfoList.size() > 0) {
            orderInfoPage = new PageImpl<>(orderInfoList, pageable, orderInfoList.size());
        }

        return orderInfoPage;
    }

    public OrderInfo getOrderInfo(String orderId) {
        return orderService.findOrderInfoById(orderId);
    }

    public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
        return findOrderDetailInfosById(orderId);
    }

    public List<OrderDetailInfo> findOrderDetailInfosById(String orderId) {
        List<OrderDetailInfo> orderDetailInfo =new ArrayList<>();

        Order order = orderService.findOrderById(orderId);

        Optional<List<OrderDetail>> orderDetail = orderDetailService.findOrderDetailInfoByOrder(order);

        if(orderDetail.isPresent()) {
            orderDetailInfo = orderDetail.get().stream().map(OrderDetailInfo::new).collect(Collectors.toList());
        }

        return orderDetailInfo;
    }
}
