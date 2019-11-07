package net.xdclass.product_service.domain;

public class Bitcoin {

    private int height;

    private String timestamp;

    private String hash;

    private String size;

    private String tx_count;

    private String confirmations;

    public Bitcoin() {
    }

    public Bitcoin(int height, String timestamp, String hash, String size, String tx_count, String confirmations) {
        this.height = height;
        this.timestamp = timestamp;
        this.hash = hash;
        this.size = size;
        this.tx_count = tx_count;
        this.confirmations = confirmations;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTx_count() {
        return tx_count;
    }

    public void setTx_count(String tx_count) {
        this.tx_count = tx_count;
    }

    public String getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(String confirmations) {
        this.confirmations = confirmations;
    }

    @Override
    public String toString() {
        return "Bitcoin{" +
                "height=" + height +
                ", timestamp='" + timestamp + '\'' +
                ", hash='" + hash + '\'' +
                ", size='" + size + '\'' +
                ", tx_count='" + tx_count + '\'' +
                ", confirmations='" + confirmations + '\'' +
                '}';
    }
}
