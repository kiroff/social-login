package org.kiroff.clients.social_login.controllers;

import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController
{
    @GetMapping("/")
    public String indexPage(Model model)
    {
        //Optional.ofNullable(principal).ifPresent(p -> model.addAttribute("name", principal.getName()));
        return "index";
    }
}
