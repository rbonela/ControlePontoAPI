package dio.api.accesscontrol.controller;

import dio.api.accesscontrol.model.Company;
import dio.api.accesscontrol.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public Company createCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }

    @GetMapping
    public List<Company> getCompanyList(){
        return companyService.findAll();
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyByID(@PathVariable("companyId") Long companyId) throws Exception {
        return ResponseEntity.ok(companyService.getById(companyId).orElseThrow(() -> new NoSuchElementException("Error: id not found")));
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity deleteCompanyByID(@PathVariable("companyId") Long companyId) throws Exception {
        try {
            companyService.deleteCompany(companyId);
            return ResponseEntity.ok("Element with id " + companyId + " successfully deleted");
        }catch (Exception e){
            return new ResponseEntity<>("Error: id not found", HttpStatus.BAD_REQUEST);
        }

    }

}
