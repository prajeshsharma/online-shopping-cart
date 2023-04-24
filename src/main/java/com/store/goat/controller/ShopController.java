package com.store.goat.controller;

import com.store.goat.dao.*;
import com.store.goat.model.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

import com.store.goat.utils.SessionUtil;
@Controller
public class ShopController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderitemRepository orderitemRepository;
    @GetMapping("/shop")
    public String shop(ProductModel productModel, Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop/products";
    }
    @PostMapping("/shop/add")
    public String shopAdd(ProductModel productModel, Model model, HttpSession session) {
        CartModel cart = SessionUtil.getCart(session);
        productModel.setQuantity(1);
        for (int i = 0; i < cart.getItems().size(); i++) {
            ProductModel p = cart.getItems().get(i);
            if (p.getProductId().equals(productModel.getProductId())) {
                p.setQuantity(p.getQuantity() + 1);
                model.addAttribute("cart", cart);
                return "shop/cart";
            }
        }
        cart.add(productModel);
        model.addAttribute("cart", cart);
        return "shop/cart";
    }
    @GetMapping("/shop/shipping")
    public String shippingForm(ShippingModel shippingModel, HttpSession session) {
        if (SessionUtil.getLoggedInUser(session) == null) {
            System.out.println("not logged in");
            return "redirect:/login";
        }
        System.out.println("logged in");
        return "shop/shipping";
    }
    @PostMapping("/shop/shipping")
    public String shippingFormSubmit(@Valid ShippingModel shippingModel, BindingResult errors, HttpSession session) {
        if (errors.hasErrors())
            return "shop/shipping";
        session.setAttribute("shippingModel", shippingModel);
        return "redirect:/shop/payment";
    }

    @GetMapping("/shop/payment")
    public String paymentForm(PaymentModel paymentModel) {
        return "shop/payment";
    }

    @PostMapping("/shop/payment")
    public String paymentFormSubmit(@Valid PaymentModel paymentModel, BindingResult errors, HttpSession session) {
        if (errors.hasErrors()) return "shop/payment";
        session.setAttribute("paymentModel", paymentModel);
        return "redirect:/shop/confirm";
    }

    @GetMapping("/shop/confirm")
    public String confirm(Model model, HttpSession session) {
        CartModel cart = SessionUtil.getCart(session);
        model.addAttribute("cart", cart);
        model.addAttribute("shippingModel", session.getAttribute("shippingModel"));
        model.addAttribute("paymentModel", session.getAttribute("paymentModel"));
        return "shop/confirm";
    }

    @GetMapping("/shop/submit")
    public String submit(HttpSession session) {
        // insert data in table
        CartModel cart = SessionUtil.getCart(session);
        ShippingModel shippingModel = (ShippingModel) session.getAttribute("shippingModel");
        ProductModel productModel = (ProductModel) session.getAttribute("productModel");
        PaymentModel paymentModel = (PaymentModel) session.getAttribute("paymentModel");
        // insert in order table
        Orders orders = new Orders();
        orders.setUser_id(2);
        orders.setOrder_date(new Date());
        orders.setIs_shipped(false);
        orders.setOrder_status("confirmed");
        orders.setAddress(shippingModel.getAddress());
        orders.setCity(shippingModel.getCity());
        orders.setState(shippingModel.getState());
        orders.setZipcode(shippingModel.getZipcode());
        orders.setSubtotal(cart.getSubtotal());
        orders.setTotal(cart.getTotal());
        orders = ordersRepository.save(orders);
        // insert in payment table
        Payment payment = new Payment();
        payment.setOrder_id(orders.getOrder_id());
        payment.setCard_name(paymentModel.getCardName());
        payment.setCard_number(paymentModel.getCardNumber());
        payment.setMonth(paymentModel.getMonth());
        payment.setYear(paymentModel.getYear());
        payment.setCvv(paymentModel.getCvv());
        payment = paymentRepository.save(payment);
        // insert in orderitem table
        Orderitem orderitem;
        for (int i = 0; i < cart.getItems().size(); i++) {
            orderitem = new Orderitem();
            orderitem.setOrder_id(orders.getOrder_id());
            orderitem.setProduct_id(cart.getItems().get(i).getProductId());
            orderitem.setQuantity(cart.getItems().get(i).getQuantity());
            orderitem = orderitemRepository.save(orderitem);
        }
        return "shop/thankyou";
    }
    @GetMapping("/shop/thankyou")
    public String thankyou() {
        return "shop/thankyou";
    }
}
