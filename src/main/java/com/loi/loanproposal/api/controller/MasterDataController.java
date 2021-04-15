package com.loi.loanproposal.api.controller;

import com.loi.loanproposal.api.service.MasterDataService;
import com.loi.loanproposal.model.LabelValuePair;
import one.util.streamex.StreamEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Loi Nguyen
 */
@RestController
@RequestMapping("/api/master-data")
public class MasterDataController {

    @Autowired
    MasterDataService dataService;

    @GetMapping("/customer-types")
    public LabelValuePair[] fetchCustomerTypes() {
        return StreamEx.of(dataService.getCustomerTypes())
                       .map(customerType -> new LabelValuePair(customerType.name(),
                                                               customerType.getDatabaseValue().toString()))
                       .toArray(LabelValuePair.class);
    }

    @GetMapping("/loan-types")
    public LabelValuePair[] fetchLoanTypes() {
        return StreamEx.of(dataService.getLoanTypes())
                       .map(customerType -> new LabelValuePair(customerType.name(),
                                                               customerType.getDatabaseValue().toString()))
                       .toArray(LabelValuePair.class);
    }

//    @RequestMapping("/appRest/educations")
//    public LabelValuePair[] fetchAllEducations() {
//        List<Education> educations = dataService.fetchAllEducations();
//        LabelValuePair[] results = new LabelValuePair[educations.size()];
//        for (int i = 0; i< educations.size(); i++) {
//            results[i] = new LabelValuePair(educations.get(i).getCode(), educations.get(i).getName());
//        }
//        return results;
//    }
//
//    @RequestMapping("/appRest/experience")
//    public LabelValuePair[] fetchAllExperience() {
//        List<Experience> experience = dataService.fetchAllExperience();
//        LabelValuePair[] results = new LabelValuePair[experience.size()];
//        for (int i = 0; i< experience.size(); i++) {
//            results[i] = new LabelValuePair(experience.get(i).getCode(), experience.get(i).getName());
//        }
//        return results;
//    }
//
//    @RequestMapping("/appRest/departments")
//    public LabelValuePair[] fetchAllDepartments() {
//        List<Department> depts = dataService.fetchAllDepartments();
//        LabelValuePair[] results = new LabelValuePair[depts.size()];
//        for (int i = 0; i< depts.size(); i++) {
//            results[i] = new LabelValuePair(depts.get(i).getCode(), depts.get(i).getName());
//        }
//        return results;
//    }
//
//    @RequestMapping("/appRest/locations")
//    public LabelValuePair[] fetchAllLocations() {
//        List<Location> locs = dataService.fetchAllLocations();
//        LabelValuePair[] results = new LabelValuePair[locs.size()];
//        for (int i = 0; i< locs.size(); i++) {
//            results[i] = new LabelValuePair(locs.get(i).getCode(), locs.get(i).getName());
//        }
//        return results;
//    }
}