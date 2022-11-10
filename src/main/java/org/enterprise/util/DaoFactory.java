package org.enterprise.util;

import org.enterprise.persistence.GenericDao;

/**
 * Created by eburzlaff.
 */
public class DaoFactory {

    // Empty constructor is private - static class
    private DaoFactory() {

    }

    public static GenericDao createDao(Class type) {
        return new GenericDao(type);

    }
}
