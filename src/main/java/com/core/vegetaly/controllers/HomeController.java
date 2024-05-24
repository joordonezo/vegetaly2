package com.core.vegetaly.controllers;

import com.core.vegetaly.domain.Individuo;
import com.core.vegetaly.respositories.IndividuoRepository;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class HomeController {

    @Value("${home.title}")
    private String properties;

    @Autowired
    private IndividuoRepository individuoRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Individuo> individuos = individuoRepository.findAll();
        model.addAttribute("title", "Vegetaly");
        model.addAttribute("message", properties);
        model.addAttribute("individuo", individuos.get(0));
        model.addAttribute("individuos", individuos);
        log.info("Returning home view");
        return "home";
    }
    @GetMapping("/add")
    public String add(Individuo individuo){
        return "add";
    }

    @PostMapping("/save")
    public String save(@Valid Individuo individuo, Errors errors){
        if(errors.hasErrors()){
            return "add";
        }
        individuoRepository.save(individuo);
      return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Individuo individuo, Model model){
        Optional<Individuo> individuob = Optional.of(individuoRepository.findById(individuo.getId()).get());
        model.addAttribute("individuo", individuob);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Valid Individuo individuo, Errors errors){
        if(errors.hasErrors()){
            return "edit";
        }
        individuoRepository.save(individuo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Individuo individuo){
        individuoRepository.deleteById(individuo.getId());
        return "redirect:/";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "ok ok login";
    }
}
