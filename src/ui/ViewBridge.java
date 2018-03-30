package ui;

import facade.FacadeManager;

public interface ViewBridge {

    /**
     * Allows to get facade manager
     * @param fm
     */
    void setData(FacadeManager fm, String ...p);
}
