package com.project.integrator.unisa.integrativeProject_Containerized_systems.controllers;

import com.project.integrator.unisa.integrativeProject_Containerized_systems.entities.Funcionario;
import com.project.integrator.unisa.integrativeProject_Containerized_systems.enums.UF;
import com.project.integrator.unisa.integrativeProject_Containerized_systems.repository.CargoRepository;
import com.project.integrator.unisa.integrativeProject_Containerized_systems.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("funcionario/home");
        modelAndView.addObject("funcionario", funcionarioRepository.findAll());
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView detalhes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("funcionario/detalhes");
        modelAndView.addObject("funcionario", funcionarioRepository.getById(id)); //pesquisar alternativas para o getOne
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("funcionario/formulario");

        modelAndView.addObject("funcionario", new Funcionario());
        modelAndView.addObject("cargos", cargoRepository.findAll());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "{id}/editar"})
    public String salvar(Funcionario funcionario){
        funcionarioRepository.save(funcionario);

        return "redirect:/funcionario";
    }

    @GetMapping("{id}/excluir")
    public String excluir(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);

        return "redirect:/funcionario";
    }
}
