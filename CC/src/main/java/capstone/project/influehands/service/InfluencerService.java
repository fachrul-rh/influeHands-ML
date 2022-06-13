package capstone.project.influehands.service;

import capstone.project.influehands.model.InfluencerInstagramModel;
import capstone.project.influehands.model.InfluencerTiktokModel;

import java.util.List;

public interface InfluencerService {
    List<InfluencerInstagramModel> viewallInfluencerIG();
    List<InfluencerTiktokModel> viewallInfluencerTiktok();
    InfluencerInstagramModel getInfluIgByUsername(String username);
    InfluencerTiktokModel getInfluTiktokByUsername(String username);
}
