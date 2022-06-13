package capstone.project.influehands.repository;

import capstone.project.influehands.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDb extends JpaRepository<UserModel,Long>{
    UserModel findByUsername(String username);
   
}
