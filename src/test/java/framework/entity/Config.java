package framework.entity;

public class Config {

    private String url;
    private String browser;
    private int timeout;

    public Config(String url, String browser, int timeout) {
        this.url = url;
        this.browser = browser;
        this.timeout = timeout;
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public int getTimeout() {
        return timeout;
    }
}
