package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

	List<Question>findByCategory(String category);

	@Query(value="select q.id from question q where q.category=:category order by rand() limit :numq",nativeQuery=true)
	List<Integer> findRandomQuestionByCategory(String category, int numq);
}
