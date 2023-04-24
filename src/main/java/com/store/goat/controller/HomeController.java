package com.store.goat.controller;

import com.store.goat.dao.User;
import com.store.goat.dao.UserRepository;
import com.store.goat.model.CartModel;
import com.store.goat.model.LoginModel;
import com.store.goat.model.UserModel;
import com.store.goat.utils.SessionUtil;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/signup")
    public String signupForm(UserModel userModel) {
        return "signup";
    }
    @PostMapping("/signup")
    public String signupSubmit(@Valid UserModel userModel, BindingResult errors) {
        if (errors.hasErrors()) return "signup";
        String password = userModel.getPassword();
        String password1 = userModel.getPassword1();
        if (!password.equals(password1)) {
            errors.rejectValue("password1", "password.not.match", "Passwords must be the same");
            return "signup";
        }
        String email = userModel.getEmail();
        List<User> u = userRepository.findByEmail(email);
        if (u != null && u.size() > 0) {
            errors.rejectValue("email", "email.exists", "This email belongs to an existing user");
            return "signup";
        }
        User user = new User();
        user.setName(userModel.getName());
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "placeholder";
    }
    @GetMapping("/login")
    public String loginForm(Model model, LoginModel loginModel) {
        return "login";
    }
    @PostMapping("/login")
    public String loginFormSubmit(@Valid LoginModel loginModel, BindingResult errors, HttpSession session) {
        if (errors.hasErrors()) return "login";
        List<User> u = userRepository.findByEmailAndPassword(loginModel.getEmail(), loginModel.getPassword());
        if (u != null && u.size() > 0) {
            User user = u.get(0);
            SessionUtil.setLoggedInUser(session, user);
            return "placeholder";
        }
        return "login";
    }
    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        SessionUtil.logOut(session);
        return "redirect:/";
    }
    @GetMapping("/")
    public String home() {
        return "home";
    }

}
