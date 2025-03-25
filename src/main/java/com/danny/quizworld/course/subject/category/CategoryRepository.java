package com.danny.quizworld.course.subject.category;

import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
