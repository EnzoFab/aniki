package ui;

import facade.FacadeManager;

/**
 *
 */
public interface ViewBridge {

    /**
     * Allows to get facade manager
     * @param fm
     * @param p
     * We can also pass a group of object
     */
    void setData(FacadeManager fm, Object... p);
}
