package yongbeom.utils.airquickutils.model;

/**
 * AirWebViewOption
 *
 * Created by leeyongbeom on 2017. 9. 15..
 */

public class AirWebViewOption {
    String url = null;
    String title = null;
    boolean showActionbar = true;
    boolean showUrl = false;
    boolean showShare = false;

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

    public boolean isShowActionbar() {
        return showActionbar;
    }

    public void setShowActionbar(boolean showActionbar) {
        this.showActionbar = showActionbar;
    }

    public boolean isShowUrl() {
        return showUrl;
    }

    public void setShowUrl(boolean showUrl) {
        this.showUrl = showUrl;
    }

    public boolean isShowShare() {
        return showShare;
    }

    public void setShowShare(boolean showShare) {
        this.showShare = showShare;
    }
}
