package capstone.project.influehands.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.project.influehands.service.InfluencerService;
import capstone.project.influehands.service.InfluencerServiceImpl;
import capstone.project.influehands.model.InfluencerInstagramModel;
import capstone.project.influehands.model.InfluencerTiktokModel;

import java.util.*;


@RestController
@RequestMapping("/api/influencerTiktok")
public class InfluencerTiktok {
    @Autowired
    private InfluencerService influencerService;

    @GetMapping(value = "/")
    public List<InfluencerTiktokModel> listInfluencerTiktok(){
        List<InfluencerTiktokModel> listInfluTiktok = influencerService.viewallInfluencerTiktok();
        return listInfluTiktok;
    }

    @GetMapping(value = "/{username}")
    public InfluencerTiktokModel getInfluTiktokByUsername(@PathVariable String username){
        if(influencerService.getInfluTiktokByUsername(username) != null){
            return influencerService.getInfluTiktokByUsername(username);
        } else {
            return null;
        }
        
    }
}