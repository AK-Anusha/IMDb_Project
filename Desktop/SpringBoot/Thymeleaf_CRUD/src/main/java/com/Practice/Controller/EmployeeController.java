package com.Practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Practice.Model.EmployeeModel;
import com.Practice.Service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

   // Step 1: Home page - Show all employees + empty form
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    //Step 2: Add new employee (uses same page)
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
    	EmployeeModel employee = new EmployeeModel();
        model.addAttribute("employee", employee);
     // ✅ Provide default pagination context (page 1, sort by firstName asc)
        return findPaginated(1, "firstName", "asc", model);

    }

    //Step 3: Save new or updated employee
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeModel employee) {
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    //Step 4: Edit employee (loads same page with pre-filled data)
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // get employee from the service
    	EmployeeModel employee = employeeService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "index";
    }

    //Step 5: Delete employee
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id) {

        // call delete employee method 
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }


    //step 6: Pagination and sorting
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
        @RequestParam("sortField") String sortField,
        @RequestParam("sortDir") String sortDir,
        Model model) {
        int pageSize = 5;

        Page < EmployeeModel > page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List < EmployeeModel > listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees", listEmployees);
        model.addAttribute("employee", new EmployeeModel()); // needed for form binding
        return "index";
    }
}
