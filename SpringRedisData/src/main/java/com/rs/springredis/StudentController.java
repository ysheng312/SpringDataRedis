package com.rs.springredis;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rs.springredis.data.Student;
import com.rs.springredis.data.StudentRepository;
import com.rs.springredis.util.DataTable;

@Controller
public class StudentController {
	static private String currentKey = null;
	
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    	Map<String, Student> studDB = StudentRepository.loadStudent();
    	Student student = studDB.get(DataTable.rdKeys[DataTable.index]);
    	currentKey = DataTable.rdKeys[DataTable.index];
        model.addAttribute("student", student);
        return "greeting";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Student student, Model model) {
        model.addAttribute("student", student);
    	StudentRepository.writeStudent(currentKey, student);
        return "greeting";
    }

}