package com.mb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		GarageSystem garageSystem = new GarageSystem();
		garageSystem.garageSystemMenu();
		LOGGER.info("SO LONG!");
		
	}

}
