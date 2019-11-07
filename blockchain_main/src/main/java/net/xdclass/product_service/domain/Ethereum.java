package net.xdclass.product_service.domain;

import java.io.Serializable;

public class Ethereum implements Serializable {

    private int blockNumber;

    private String timeStamp;

    private String blockMiner;

    private String blockReward;

    private String uncleReward;

    public Ethereum() {
    }

    public Ethereum(int blockNumber, String timeStamp, String blockMiner, String blockReward, String uncleReward) {
        this.blockNumber = blockNumber;
        this.timeStamp = timeStamp;
        this.blockMiner = blockMiner;
        this.blockReward = blockReward;
        this.uncleReward = uncleReward;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getBlockMiner() {
        return blockMiner;
    }

    public void setBlockMiner(String blockMiner) {
        this.blockMiner = blockMiner;
    }

    public String getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(String blockReward) {
        this.blockReward = blockReward;
    }

    public String getUncleReward() {
        return uncleReward;
    }

    public void setUncleReward(String uncleReward) {
        this.uncleReward = uncleReward;
    }

    @Override
    public String toString() {
        return "Ethereum{" +
                "blockNumber='" + blockNumber + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", blockMiner='" + blockMiner + '\'' +
                ", blockReward='" + blockReward + '\'' +
                ", uncleReward='" + uncleReward + '\'' +
                '}';
    }
}
