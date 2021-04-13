package com.loi.loanproposal.api.controller;

import java.util.List;

import com.loi.loanproposal.model.LabelValuePair;
import com.loi.loanproposal.db.entity.Department;
import com.loi.loanproposal.db.entity.Education;
import com.loi.loanproposal.db.entity.Experience;
import com.loi.loanproposal.db.entity.Location;
import com.loi.loanproposal.db.entity.Skill;
import com.loi.loanproposal.api.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Loi Nguyen
 *
 */
@RestController
public class MasterDataController {

    @Autowired
    MasterDataService lookupService;

    @RequestMapping("/appRest/skills")
    public LabelValuePair[] fetchAllSkills() {
        List<Skill> skills = lookupService.fetchAllSkills();
        LabelValuePair[] results = new LabelValuePair[skills.size()];
        for (int i = 0; i< skills.size(); i++) {
            results[i] = new LabelValuePair(skills.get(i).getCode(), skills.get(i).getName());
        }
        return results;
    }

    @RequestMapping("/appRest/educations")
    public LabelValuePair[] fetchAllEducations() {
        List<Education> educations = lookupService.fetchAllEducations();
        LabelValuePair[] results = new LabelValuePair[educations.size()];
        for (int i = 0; i< educations.size(); i++) {
            results[i] = new LabelValuePair(educations.get(i).getCode(), educations.get(i).getName());
        }
        return results;
    }

    @RequestMapping("/appRest/experience")
    public LabelValuePair[] fetchAllExperience() {
        List<Experience> experience = lookupService.fetchAllExperience();
        LabelValuePair[] results = new LabelValuePair[experience.size()];
        for (int i = 0; i< experience.size(); i++) {
            results[i] = new LabelValuePair(experience.get(i).getCode(), experience.get(i).getName());
        }
        return results;
    }

    @RequestMapping("/appRest/departments")
    public LabelValuePair[] fetchAllDepartments() {
        List<Department> depts = lookupService.fetchAllDepartments();
        LabelValuePair[] results = new LabelValuePair[depts.size()];
        for (int i = 0; i< depts.size(); i++) {
            results[i] = new LabelValuePair(depts.get(i).getCode(), depts.get(i).getName());
        }
        return results;
    }

    @RequestMapping("/appRest/locations")
    public LabelValuePair[] fetchAllLocations() {
        List<Location> locs = lookupService.fetchAllLocations();
        LabelValuePair[] results = new LabelValuePair[locs.size()];
        for (int i = 0; i< locs.size(); i++) {
            results[i] = new LabelValuePair(locs.get(i).getCode(), locs.get(i).getName());
        }
        return results;
    }
}