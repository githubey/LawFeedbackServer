package com.codefair.lawfeedback.controller.user;

import com.codefair.lawfeedback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/law_maker")
    public String createLawMakerUser(@RequestBody UserLawMakerTO userLawMakerTO) {
        userService.createLawMakerUser(userLawMakerTO);
        return "{}";
    }

    @PostMapping(value = "/normal")
    public String createNormalUser(@RequestBody UserNormalTO userNormalTO) {
        userService.createNormalUser(userNormalTO);
        return "{}";
    }
}
