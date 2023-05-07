package com.Geekster.EmployeAdress.Service;

import com.Geekster.EmployeAdress.Repository.iemployRepo;
import com.Geekster.EmployeAdress.models.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService {
    @Autowired
    iemployRepo employrepo;

    public String addemploye(List<Employee> employlist) {
      Iterable<Employee>list= employrepo.saveAll(employlist);
      if(list!=null){
          return "employee list added successfully...";
      }
      return "couldn't add employe list...!!!";
    }

    public List<Employee> fetchemploylist() {
        return employrepo.findAll();
    }

    public Employee fetchemploybyid(Long employId) {
        return employrepo.fetchemploybyid(employId);
    }
    @Transactional
    public void updatebyid(String firstName,Long employId) {
         employrepo.updatebyid(firstName,employId);
    }

@Transactional
    public void deletebyid(Long employId) {
        employrepo.deletebyid(employId);
    }
}
