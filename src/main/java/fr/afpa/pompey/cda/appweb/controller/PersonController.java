package fr.afpa.pompey.cda.appweb.controller;

import fr.afpa.pompey.cda.appweb.entity.Person;
import fr.afpa.pompey.cda.appweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {


    @Autowired
    private PersonService service;

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        Iterable<Person> persons = service.getPersons();
        model.addAttribute("listPersons", persons);
        return "home";
    }

    @GetMapping(value = {"/createperson"})
    public String createPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "createperson";
    }

    @GetMapping(value = {"/updateperson/{id}"})
    public String updatePerson(@PathVariable("id") final Integer id, Model model) {
        Person person = service.getPerson(id);
        model.addAttribute("person", person);
        return "updateperson";
    }

    @GetMapping(value = {"/deleteperson/{id}"})
    public ModelAndView deletePerson(@PathVariable("id") final Integer id) {
        service.deletePerson(id);
// redirection vers la page home
        return new ModelAndView("redirect:/");
    }

    @PostMapping(value = {"/saveperson"})
    public ModelAndView savePerson(@ModelAttribute Person person) {
        service.savePerson(person);
// redirection vers la page home
        return new ModelAndView("redirect:/");


    }
}