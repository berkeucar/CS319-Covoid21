package com.covoid21.panman.database.service;

import com.covoid21.panman.database.repository.CourseRepository;
import com.covoid21.panman.entity.Course;

import com.covoid21.panman.entity.StudentCloseSeats;
import com.covoid21.panman.entity.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import com.covoid21.panman.entity.user.Instructor;
import java.util.List;

@Service
@Transactional
public class CourseService extends ServiceBase<Course> {
    private CourseRepository courseRepo;
    private StudentCloseSeatsService studentCloseSeatsService;
    //private StudentService studentService;

    @Autowired
    public CourseService(CourseRepository repo, StudentCloseSeatsService studentCloseSeatsService, StudentService studentService) {
        super(repo);
        this.courseRepo = repo;
        this.studentCloseSeatsService = studentCloseSeatsService;
        //this.studentService = studentService;
    }

    @Override
    @Transactional
    public Course save(Course entity) throws EntityExistsException {
        if (courseRepo.existsByCodeAndSection(entity.getCode(), entity.getSection())) {
            throw new EntityExistsException();
        }
        return courseRepo.save(entity);
    }

    @Override
    @Transactional
    public Course update(Course entity) throws EntityNotFoundException {
        if (!courseRepo.existsByCodeAndSection(entity.getCode(), entity.getSection())) {
            throw new EntityNotFoundException();
        }
        /*
        if (entity.getSeatingPlan() != null) {
            for (StudentCloseSeats seats : entity.getSeatingPlan()) {
                try {
                    studentCloseSeatsService.update(seats);
                } catch (EntityNotFoundException e) {
                    studentCloseSeatsService.save(seats);
                }
            }
        }
        */
        return courseRepo.save(entity);
    }

    public Course addNewStudent(Course course, Student s) {
        StudentCloseSeats seats = new StudentCloseSeats(course.getCode(), course.getSection(), s);
        course.getSeatingPlan().add(seats);
        //studentCloseSeatsService.save(seats);
        //addStudentCloseSeats(course, seats);
        //System.out.println("addStudentCloseSeats() over");
        //seats = studentCloseSeatsService.findByCodeAndSection(course.getCode(), course.getSection());
        /*
        try {
            studentCloseSeatsService.getStudentService().update(s);
            System.out.println("addNewStudent() saved student");
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
        */
        /*
        try {
            studentCloseSeatsService.save(seats);
            System.out.println("addNewStudent() saved seats");
        } catch (EntityExistsException e) {
            throw new EntityExistsException();
        }
        */
        //course = courseRepo.findByCodeAndSection(course.getCode(), course.getSection()).get();
        try {
            return update(course);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }
    /*
    public Course addNewStudent(Course course, int studentID) {
        return addNewStudent(course, studentCloseSeatsService.getStudentService().findByUniversityID(studentID));
    }
    */
    public Course addNeighbors(Course course, Student s1, Student s2) {
        studentCloseSeatsService.addStudent(course.getStudentCloseSeats(s1), s2);
        studentCloseSeatsService.addStudent(course.getStudentCloseSeats(s2), s1);
        try {
            studentCloseSeatsService.update(course.getStudentCloseSeats(s1));
            studentCloseSeatsService.update(course.getStudentCloseSeats(s2));
        } catch (EntityNotFoundException e) {
            System.out.println("addNeighbors() error");
        }

        try {
            return update(course);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    public Course addStudentCloseSeats(Course course, StudentCloseSeats seats) {
        System.out.println("addStudentCloseSeats()");
        course.getSeatingPlan().add(seats);

        try {
            return update(course);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }
    public Course findByID(Long id) {
        return repo.findByID(id);
    }

    public List<Course> findByCode(String code) {
        return repo.findByCode(code);
    }

    public Course findByCodeAndSection(String code, int section) {
        return repo.findByCodeAndSection(code, section);
    }

    public List<Course> findByInstructor(Instructor instructor) {
        return repo.findByInstructor(instructor);
    }
    /*
    public Course addNeighbors(Course course, int s1, int s2) {
        return addNeighbors(
                course,
                studentCloseSeatsService.getStudentService().findByUniversityID(s1),
                studentCloseSeatsService.getStudentService().findByUniversityID(s2)
        );
    }
     */
}
