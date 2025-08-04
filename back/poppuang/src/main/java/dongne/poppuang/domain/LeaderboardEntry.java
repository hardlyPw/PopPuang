package dongne.poppuang.domain;

import lombok.Getter;

@Getter
public class LeaderboardEntry {
    private String major;
    private int clicks;

    public LeaderboardEntry(String major, int clicks) {
        this.major = major;
        this.clicks = clicks;
    }

    public void addClick() { this.clicks++; }
}
