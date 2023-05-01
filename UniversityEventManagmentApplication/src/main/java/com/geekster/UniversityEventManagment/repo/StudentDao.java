package com.geekster.UniversityEventManagment.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.geekster.UniversityEventManagment.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student,Long>{

}
