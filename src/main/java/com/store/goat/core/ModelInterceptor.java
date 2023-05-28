package com.store.goat.core;

import com.store.goat.dao.User;
import com.store.goat.utils.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Component
public class ModelInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) return;
        Map<String, Object> model = modelAndView.getModel();
        HttpSession session = request.getSession();
        User u = SessionUtil.getLoggedInUser(session);
        if (u != null) model.put("user", u);
        model.put("cart", SessionUtil.getCart(session));
    }
}
