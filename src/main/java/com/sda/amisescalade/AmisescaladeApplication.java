package com.sda.amisescalade;

import com.sda.amisescalade.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmisescaladeApplication {

    @Autowired
private ClimbUserDAO climbUserDAO;
    @Autowired
private TopoDAO topoDAO;
    @Autowired
private SpotDAO spotDAO;
    @Autowired
private SectorDAO sectorDAO;
    @Autowired
private RoadDAO roadDAO;
    @Autowired
private LenghtDAO lenghtDAO;
    @Autowired
private ScoringDAO scoringDAO;
    @Autowired
private CommentDAO commentDAO;


    public static void main(String[] args) {
        SpringApplication.run(AmisescaladeApplication.class, args);
    }

}
