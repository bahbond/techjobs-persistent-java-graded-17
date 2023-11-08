package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/")
    public String index(Model model) {
      //  model.addAttribute("Title", "Skills");
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("/add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("/add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill, Errors error, Model model) {
        if (error.hasErrors()) {
            model.addAttribute("skills", newSkill);
            return "skills/add";
        }
        skillRepository.save(newSkill);
        model.addAttribute("skills", newSkill);
          model.addAttribute("skills", skillRepository.findAll());
        return "redirect:";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {
        Optional optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("skills", skill);
            model.addAttribute("skills", skillRepository.findAll());

            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}