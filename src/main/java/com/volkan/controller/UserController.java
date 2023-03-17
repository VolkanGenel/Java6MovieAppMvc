package com.volkan.controller;

import com.volkan.dto.request.UserLoginRequestDto;
import com.volkan.dto.request.UserRegisterRequestDto;
import com.volkan.dto.response.LoginResponseDto;
import com.volkan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage(String email){
        System.out.println("email==>"+email);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("email",email);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public  ModelAndView login(UserLoginRequestDto dto){
        ModelAndView modelAndView=new ModelAndView();
        try {
            LoginResponseDto responseDto=userService.doLogin(dto);
            // modelAndView.addObject("result",responseDto.getName()+"--"+"Giriş Başarılı");
            modelAndView.addObject("userId",responseDto.getId());
            modelAndView.setViewName("redirect:/movie/findall"); //movie/findall?userId=1
        }catch (Exception e){
            e.printStackTrace();
            modelAndView.addObject("result",e.getMessage());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register");
        return  modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterRequestDto dto){
        ModelAndView modelAndView=new ModelAndView();
        try {
            userService.register2(dto);
            modelAndView.addObject("email",dto.getEmail());
            modelAndView.setViewName("redirect:login");
        }catch (Exception e){
            modelAndView.addObject("error",e.getMessage());
            modelAndView.setViewName("register");
        }



        return modelAndView;
    }
}
