package br.com.fiap.solaris.controller;

import br.com.fiap.solaris.model.entity.Item;
import br.com.fiap.solaris.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ModelAndView home(){
        List<Item> itens = pedidoRepository.findAll();
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("itens",itens);
        return mv;
    }
}
