package capstone.project.influehands.repository;

import capstone.project.influehands.model.InfluencerTiktokModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface InfluencerTiktokDb extends JpaRepository<InfluencerTiktokModel,Long>{
    InfluencerTiktokModel findByUsername(String username);
    Optional <InfluencerTiktokModel> findById(Long id);
}
