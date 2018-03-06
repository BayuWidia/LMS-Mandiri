package com.mandiri.util;

import java.util.UUID;

public class GenerateUUID {
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        
        return randomUUIDString;
	}
}
