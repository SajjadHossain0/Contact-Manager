package com.contact.manager.controller;

import com.contact.manager.dao.UserRepository;
import com.contact.manager.entities.User;
import com.contact.manager.helper.Message;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("title", "Home - Contact Manager");

        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {

        model.addAttribute("title", "About - Contact Manager");

        return "about";
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("title", "Login - Contact Manager");

        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {

        model.addAttribute("title", "Signup - Contact Manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/do_register")
    public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result, @RequestParam(value = "agreement", defaultValue = "false") boolean agreement,
                               Model model,
                               HttpSession session) {
        try {
            if (!agreement) {
				throw  new Exception("you do not checked terms and conditions");

			}
            if (result.hasErrors()){
                model.addAttribute("user",user);
                return "signup";
            }

            user.setUser_role("ROLE_USER");
            user.setUser_active(true);
            user.setUser_image_url("default.png");

            this.userRepository.save(user);

            model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully registered !!","alert-success"));


		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Something went wrong !!","alert-danger"));
        }

        return "redirect:/signup";
    }

}
