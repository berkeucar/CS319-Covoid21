package com.covoid21.panman.manager;

import com.covoid21.panman.database.service.*;
import com.covoid21.panman.entity.VaccinationEntry;
import com.covoid21.panman.entity.VaccinationType;
import com.covoid21.panman.entity.user.AdministrationPersonnel;
import com.covoid21.panman.entity.user.HealthcarePersonnel;
import com.covoid21.panman.entity.user.Instructor;
import com.covoid21.panman.entity.user.Student;

import javax.persistence.EntityNotFoundException;
import java.time.LocalTime;
import java.util.List;

public class UserManager {
    private Long currentUser;
    private StudentService student;
    private InstructorService instructor;
    private HealthcarePersonnelService healthcare;
    private AdministrationPersonnelService administration;
    private PolicyService policyService;

    public void userSettingsScreen() {

    }

    public void openProfile() {

    }

    public void changePassword(String oldPassword, String newPassword, String passwordNew2) {
        if (newPassword.equals(passwordNew2)) {
            if (student.findById(currentUser) != null) {
                Student entity = student.findById(currentUser);
                if (oldPassword.equals(entity.getPassword())){
                    entity.setPassword(newPassword);
                    try {
                        student.update(entity);
                    } catch (EntityNotFoundException e) {
                        System.out.println("Error in registration request.");
                        student.save(entity);
                }

            } else if (instructor.findById(currentUser) != null) {
                Instructor entity2 = instructor.findById(currentUser);
                if (oldPassword.equals(entity2.getPassword())){
                    entity2.setPassword(newPassword);
                    instructor.update(entity2);
                }try {
                    instructor.update(entity2);
                } catch (EntityNotFoundException e) {
                    System.out.println("Error in registration request.");
                    instructor.save(entity2);
                }
            } else if (healthcare.findById(currentUser) != null) {
                HealthcarePersonnel entity3 = healthcare.findById(currentUser);

                if (oldPassword.equals(entity3.getPassword())){
                        entity3.setPassword(newPassword);
                        healthcare.update(entity3);
                }try {
                    healthcare.update(entity3);
                } catch (EntityNotFoundException e) {
                        System.out.println("Error in registration request.");
                        healthcare.save(entity3);
                    }
            } else if (administration.findById(currentUser) != null) {
                AdministrationPersonnel entity4 = administration.findById(currentUser);
                try {
                    administration.update(entity4);
                } catch (EntityNotFoundException e) {
                    System.out.println("Error in registration request.");
                    administration.save(entity4);
                }
            } else {
                System.out.println("Error in registration request.");
            }
        }
    }
    }

    public void changeReminderTime(LocalTime reminderTime) {
        /*if (student.findById(currentUser) != null){
            Student entity = student.findById(currentUser);

            entity.s;
            try {
                student.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                student.save(entity);
            }
        }
        else if (instructor.findById(currentUser) != null){
            Instructor entity = instructor.findById(currentUser);

            entity.setEmail(newEmail);
            try {
                instructor.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                instructor.save(entity);
            }
        }
        else if (healthcare.findById(currentUser) != null) {
            HealthcarePersonnel entity = healthcare.findById(currentUser);

            entity.setEmail(newEmail);
            try {
                healthcare.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                healthcare.save(entity);
            }
        }
        else if (administration.findById(currentUser) != null){
            AdministrationPersonnel entity = administration.findById(currentUser);


            try {
                administration.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                administration.save(entity);
            }
        }*/
    }

    public void changeEmail(String oldEmail, String newEmail, String newEmail2) {
        if (!newEmail.equals(newEmail2))
            return;
        if (student.findById(currentUser) != null){
            Student entity = student.findById(currentUser);
            if (!entity.getEmail().equals(oldEmail))
                return;
            entity.setEmail(newEmail);
            try {
                student.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                student.save(entity);
            }
        }
        else if (instructor.findById(currentUser) != null){
            Instructor entity = instructor.findById(currentUser);
            if (!entity.getEmail().equals(oldEmail))
                return;
            entity.setEmail(newEmail);
            try {
                instructor.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                instructor.save(entity);
            }
        }
        else if (healthcare.findById(currentUser) != null) {
            HealthcarePersonnel entity = healthcare.findById(currentUser);
            if (!entity.getEmail().equals(oldEmail))
                return;
            entity.setEmail(newEmail);
            try {
                healthcare.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                healthcare.save(entity);
            }
        }
        else if (administration.findById(currentUser) != null){
            AdministrationPersonnel entity = administration.findById(currentUser);
            if (!entity.getEmail().equals(oldEmail))
                return;
            entity.setEmail(newEmail);
            try {
                administration.update(entity);
            } catch (EntityNotFoundException e) {
                System.out.println("Error in registration request.");
                administration.save(entity);
            }
        }
    }

    public boolean isFullyVaccinated() {
        if (student.findById(currentUser) != null) {
            Student entity = student.findById(currentUser);
            List vaccines = (List) entity.getVaccinationsEntries();
            int accepted = 0;
            for (int i = 0; i < vaccines.size(); i++){
                VaccinationType type = ((VaccinationEntry)vaccines.get(i)).getVaccinationType();
                for (int j = 0; j < policyService.findByTitle("Accepted Vaccines").getAcceptedVaccines().size(); i++){
                    List polVac = (List) policyService.findByTitle("Accepted Vaccines").getAcceptedVaccines();
                    if (type == polVac.get(j)){
                        accepted++;
                        break;
                    }
                }
                if ((accepted) == Integer.parseInt(policyService.findByTitle("Vaccination Count").getVaccinationInfo()))
                    return true;
                else
                    return false;
            }

        }
        else if (instructor.findById(currentUser) != null) {
            Instructor entity = instructor.findById(currentUser);
            List vaccines = (List) entity.getVaccinationsEntries();
            int accepted = 0;
            for (int i = 0; i < vaccines.size(); i++){
                VaccinationType type = ((VaccinationEntry)vaccines.get(i)).getVaccinationType();
                for (int j = 0; j < policyService.findByTitle("Accepted Vaccines").getAcceptedVaccines().size(); i++){
                    List polVac = (List) policyService.findByTitle("Accepted Vaccines").getAcceptedVaccines();
                    if (type == polVac.get(j)){
                        accepted++;
                        break;
                    }
                }

            }
            if ((accepted)==Integer.parseInt(policyService.findByTitle("Vaccination Count").getVaccinationInfo()))
                return true;
            else
                return false;

        }
        else if (healthcare.findById(currentUser) != null) {
            HealthcarePersonnel entity = healthcare.findById(currentUser);
            List vaccines = (List) entity.getVaccinationsEntries();
            int accepted = 0;
            for (int i = 0; i < vaccines.size(); i++){
                VaccinationType type = ((VaccinationEntry)vaccines.get(i)).getVaccinationType();
                for (int j = 0; j < policyService.findByTitle("Accepted Vaccines").getAcceptedVaccines().size(); i++){
                    List polVac = (List) policyService.findByTitle("Accepted Vaccines").getAcceptedVaccines();
                    if (type == polVac.get(j)){
                        accepted++;
                        break;
                    }
                }

            }
            if ((accepted)==Integer.parseInt(policyService.findByTitle("Vaccination Count").getVaccinationInfo()))
                return true;
            else
                return false;
        }
        else if (administration.findById(currentUser) != null) {
            AdministrationPersonnel entity = administration.findById(currentUser);
            List vaccines = (List) entity.getVaccinationsEntries();
            int accepted = 0;
            for (int i = 0; i < vaccines.size(); i++){
                VaccinationType type = ((VaccinationEntry)vaccines.get(i)).getVaccinationType();
                for (int j = 0; j < policyService.findByTitle("Accepted Vaccines").getAcceptedVaccines().size(); i++){
                    List polVac = (List) policyService.findByTitle("Accepted Vaccines").getAcceptedVaccines();
                    if (type == polVac.get(j)){
                        accepted++;
                        break;
                    }
                }

            }
            if ((accepted) == Integer.parseInt(policyService.findByTitle("Vaccination Count").getVaccinationInfo()))
                return true;
            else
                return false;
        }
        else {
            System.out.println("Error in registration request.");
        }
        return false;
    }
}
