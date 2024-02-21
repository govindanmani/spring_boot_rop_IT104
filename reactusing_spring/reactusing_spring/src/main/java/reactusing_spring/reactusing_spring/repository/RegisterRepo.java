package reactusing_spring.reactusing_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reactusing_spring.reactusing_spring.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register,String>{

    
} 
