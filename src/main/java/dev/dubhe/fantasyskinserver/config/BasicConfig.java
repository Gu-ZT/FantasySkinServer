package dev.dubhe.fantasyskinserver.config;

public class BasicConfig {
    public DataBaseConfig database = new DataBaseConfig();
    public HashAlgorithm hash = HashAlgorithm.MD5_SLAT;

    public static class DataBaseConfig {
        public String host = "localhost";
        public int port = 3306;
        public String username = "";
        public String password = "";
        public String basename = "fantasy_skin";
    }

    public enum HashAlgorithm {
        MD5,
        MD5_SLAT,
        SHA,
        MAC
    }
}
