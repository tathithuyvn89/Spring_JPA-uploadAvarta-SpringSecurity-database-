package thuy.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thuy.codegym.models.Classes;
import thuy.codegym.models.Student;
import thuy.codegym.service.classes.ClassService;
import thuy.codegym.service.student.StudentService;

import java.util.List;

@RestController
@RequestMapping("/classes")
  public class ClassesController {
    @Autowired
    private ClassService classesService;
    @Autowired
    private StudentService studentService;
    @GetMapping("/{id}/students")
    public ModelAndView showStudentByClassId(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("/classes/list");
        Classes classes= classesService.findById(id);
        List<Student> students= studentService.getAllByClasses(classes);
        modelAndView.addObject("students",students);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView getCreatePage(Model model){
        ModelAndView modelAndView= new ModelAndView("classes/newclass");
        model.addAttribute("classes",new Classes());
        return modelAndView;
    }

    @PostMapping(value = "/createClasses",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Classes createClasses(@RequestBody Classes classes){
        classesService.save(classes);
        return classes;
    }
    @PostMapping("/create")
    public ResponseEntity<Classes> create(@RequestBody Classes classes){
        classesService.save(classes);
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Classes> edit(@RequestBody Classes classes, @PathVariable Long id){
       Classes classFind= classesService.findById(id);
       if(classFind!=null){
           classes.setId(id);
           classesService.save(classes);
           return new ResponseEntity<>(classes,HttpStatus.OK);

       }
        return new ResponseEntity<>(classes,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Classes> delete(@PathVariable Long id){
        Classes classesFind= classesService.findById(id);
        if (classesFind!=null){
            classesService.remove(id);
            return new ResponseEntity<>(classesFind,HttpStatus.OK);
        }
        return new ResponseEntity<>(classesFind,HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Classes> allClasses(){
        return classesService.findAll();

    }







  }