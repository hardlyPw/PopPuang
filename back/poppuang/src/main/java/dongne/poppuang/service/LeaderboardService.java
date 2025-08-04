package com.tpopractice.myspringpractice.service;

import com.tpopractice.myspringpractice.domain.LeaderboardEntry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {
    LeaderboardEntry data1 = new LeaderboardEntry("소프트웨어학부", 99);
    LeaderboardEntry data2 = new LeaderboardEntry("AI학과", 10);

    public List<LeaderboardEntry> getSampleData() {
        return List.of(data1, data2);
    }

    public void addClick() {
        this.data1.addClick();
    }

}
