package openroom.com.Service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import openroom.com.Service.models.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity,Integer> {
    
}
