package br.com.fiap.solaris.controller;

import br.com.fiap.solaris.model.dto.RequisicaoNovoPedido;
import br.com.fiap.solaris.model.entity.Item;
import br.com.fiap.solaris.model.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public ModelAndView formulario(RequisicaoNovoPedido requisicao){
        ModelAndView mv = new ModelAndView("pedido/formulario");
        return mv;
    }

    @PostMapping("/novo")
    public ModelAndView novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result){
        ModelAndView mv;
        if(result.hasErrors()){
            mv = new ModelAndView("pedido/formulario");
            return mv;
        }
        Item item = new Item(requisicao);
        pedidoRepository.save(item);
        mv = new ModelAndView("redirect:/home");
        return mv;
    }
}
