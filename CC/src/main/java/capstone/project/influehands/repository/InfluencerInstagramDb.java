package capstone.project.influehands.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import capstone.project.influehands.model.InfluencerInstagramModel;


@Repository
public interface InfluencerInstagramDb extends JpaRepository<InfluencerInstagramModel,Long>{
 
   Optional<InfluencerInstagramModel> findById(Long id);
   InfluencerInstagramModel findByUsername(String username);
     

}
