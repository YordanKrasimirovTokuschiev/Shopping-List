package com.example.shoppinglistapplication.web;

import com.example.shoppinglistapplication.models.entities.CategoryName;
import com.example.shoppinglistapplication.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drinks", productService.findAllProductsByCategoryNAme(CategoryName.DRINK));
        model.addAttribute("foods", productService.findAllProductsByCategoryNAme(CategoryName.FOOD));
        model.addAttribute("households", productService.findAllProductsByCategoryNAme(CategoryName.HOUSEHOLD));
        model.addAttribute("others", productService.findAllProductsByCategoryNAme(CategoryName.OTHER));

        return "home";
    }
    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();

        return "redirect:/";
    }
}
