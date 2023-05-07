package com.Geekster.EmployeAdress.Controller;

import com.Geekster.EmployeAdress.Service.EmployService;
import com.Geekster.EmployeAdress.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employ")
public class EmployController {
    @Autowired
    EmployService employService;

   @PostMapping(value = "/add")
    public String addemployee(@RequestBody List<Employee> employlist){
       return employService.addemploye(employlist);
   }
   @GetMapping(value = "/list")
    public List<Employee> fetchemploylist(){
       return employService.fetchemploylist();
   }
   @GetMapping(value = "/employee/{employId}")
    public Employee fetchemploybyid(@PathVariable Long employId){
       return employService.fetchemploybyid(employId);
   }
   @PutMapping("/update/{employId}/firstName/{firstName}")
    public void updatebyid(@PathVariable String firstName,@PathVariable Long employId){
        employService.updatebyid(firstName,employId);
   }
   @DeleteMapping("/delete/{employId}")
    public void deletebyid(@PathVariable Long employId){
       employService.deletebyid(employId);
   }

}
