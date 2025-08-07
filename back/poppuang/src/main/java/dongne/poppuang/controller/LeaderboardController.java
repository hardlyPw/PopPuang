package dongne.poppuang.controller;

import dongne.poppuang.domain.LeaderboardEntry;
import dongne.poppuang.service.LeaderboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaderboardController {
    private final LeaderboardService leaderboardService;
    public LeaderboardController(LeaderboardService leaderboardService) { this.leaderboardService = leaderboardService; }

    @GetMapping("/leaderboard")
    public List<LeaderboardEntry> getLeaderboard() {
        return leaderboardService.getSampleData();
    }
}
