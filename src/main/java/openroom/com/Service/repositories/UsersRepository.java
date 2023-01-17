package openroom.com.Service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import openroom.com.Service.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    
}
