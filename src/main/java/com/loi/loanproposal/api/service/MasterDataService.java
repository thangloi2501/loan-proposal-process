package com.loi.loanproposal.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.loi.loanproposal.db.repository.EducationRepository;
import com.loi.loanproposal.db.repository.ExperienceRepository;
import com.loi.loanproposal.db.entity.Department;
import com.loi.loanproposal.db.entity.Education;
import com.loi.loanproposal.db.entity.Experience;
import com.loi.loanproposal.db.entity.Location;
import com.loi.loanproposal.db.entity.Skill;
import com.loi.loanproposal.db.repository.DepartmentRepository;
import com.loi.loanproposal.db.repository.LocationRepository;
import com.loi.loanproposal.db.repository.SkillRepository;
import com.loi.loanproposal.enums.CustomerType;
import com.loi.loanproposal.enums.LoanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Loi Nguyen
 *
 */
@Component
public class MasterDataService {

    @Autowired 
    SkillRepository skillRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public List<CustomerType> getCustomerTypes(){
        return Arrays.asList(CustomerType.values());
    }

    public List<LoanType> getLoanTypes(){
        return Arrays.asList(LoanType.values());
    }
//
//    public List<Education> fetchAllEducations(){
//        List<Education> results = new ArrayList<Education>();
//        Iterator iterator = educationRepository.findAll().iterator();
//        while(iterator.hasNext()){
//            results.add((Education) iterator.next());
//        }
//        return results;
//    }
//
//    public List<Experience> fetchAllExperience(){
//        List<Experience> results = new ArrayList<Experience>();
//        Iterator iterator = experienceRepository.findAll().iterator();
//        while(iterator.hasNext()){
//            results.add((Experience) iterator.next());
//        }
//        return results;
//    }
//
//    public List<Department> fetchAllDepartments(){
//        List<Department> results = new ArrayList<Department>();
//        Iterator iterator = departmentRepository.findAll().iterator();
//        while(iterator.hasNext()){
//            results.add((Department) iterator.next());
//        }
//        return results;
//    }
//
//    public List<Location> fetchAllLocations(){
//        List<Location> results = new ArrayList<Location>();
//        Iterator iterator = locationRepository.findAll().iterator();
//        while(iterator.hasNext()){
//            results.add((Location) iterator.next());
//        }
//        return results;
//    }
}