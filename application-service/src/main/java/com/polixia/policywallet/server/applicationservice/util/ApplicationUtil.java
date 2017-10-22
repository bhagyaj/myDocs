package com.polixia.policywallet.server.applicationservice.util;

import java.util.UUID;

/**
 * Created by brupasinghe on 10/16/2017.
 */
public class ApplicationUtil {
    public static String getUniqueApplicationId() {
        return UUID.randomUUID().toString();
    }
}
