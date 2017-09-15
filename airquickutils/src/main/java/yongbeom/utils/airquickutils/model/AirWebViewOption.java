package yongbeom.utils.airquickutils.model;

/**
 * AirWebViewOption
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */

public class AirWebViewOption {
    String url = null;
    String title = null;
    boolean is_actionbar = true;
    boolean is_url = false;
    boolean is_share = false;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean is_actionbar() {
        return is_actionbar;
    }

    public void setIs_actionbar(boolean is_actionbar) {
        this.is_actionbar = is_actionbar;
    }

    public boolean is_url() {
        return is_url;
    }

    public void setIs_url(boolean is_url) {
        this.is_url = is_url;
    }

    public boolean is_share() {
        return is_share;
    }

    public void setIs_share(boolean is_share) {
        this.is_share = is_share;
    }
}
