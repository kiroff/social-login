package org.kiroff.clients.social_login.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HomePageController
{
    @GetMapping("/home")
    public String homePage(Model model, @AuthenticationPrincipal OidcUser principal)
    {
        Optional.ofNullable(principal).ifPresent(p -> model.addAttribute("name", principal.getClaims().get("name")));
        return "home";
    }
}
