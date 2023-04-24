package com.store.goat.utils;

import com.store.goat.dao.User;
import com.store.goat.model.CartModel;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;

public class SessionUtil {
    public static String CART = "CART";

    public static User getLoggedInUser(HttpSession session) {
        return (User) session.getAttribute("USER");
    }

    public static void setLoggedInUser(HttpSession session, User user) {
        session.setAttribute("USER", user);
    }

    public static CartModel getCart(HttpSession session) {
        CartModel cart = (CartModel) session.getAttribute(CART);
        if (cart == null) {
            cart = new CartModel();
            cart.setItems(new ArrayList<>());
            session.setAttribute(CART, cart);
        }
        return cart;
    }

    public static void logOut(HttpSession session) {
        session.removeAttribute("USER");
    }

    public static void setCart(CartModel cart, HttpSession session) {
        session.setAttribute(CART, cart);
    }


}
