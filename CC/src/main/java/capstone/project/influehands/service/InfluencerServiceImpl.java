package capstone.project.influehands.service;

import capstone.project.influehands.model.InfluencerInstagramModel;
import capstone.project.influehands.model.InfluencerTiktokModel;
import capstone.project.influehands.repository.InfluencerInstagramDb;
import capstone.project.influehands.repository.InfluencerTiktokDb;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InfluencerServiceImpl implements InfluencerService{
    @Autowired
    InfluencerInstagramDb influencerInstagramDb;

    @Autowired
    InfluencerTiktokDb influencerTiktokDb;

   public List<InfluencerInstagramModel> viewallInfluencerIG(){
        return influencerInstagramDb.findAll();
    }

    public List<InfluencerTiktokModel> viewallInfluencerTiktok(){
        return influencerTiktokDb.findAll();
    }

    public InfluencerInstagramModel getInfluIgByUsername(String username){
        return influencerInstagramDb.findByUsername(username);
    }


    public InfluencerTiktokModel getInfluTiktokByUsername(String username){
        return influencerTiktokDb.findByUsername(username);
    }
}
