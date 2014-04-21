package com.grp6.gestage.fonction;

import java.text.SimpleDateFormat;

/**
 * Class Config - Permet de récupérer l'URL et les SimpleDateFormat
 * 
 * @author windows
 *
 */
public class Config {
	
	//	protected static String URL = "http://82.238.248.77/gestage/";
	//	protected static String URL2 = "http://192.168.1.26/s3aechange/api/";
	

//	protected static String URL = "http://192.168.1.26/gestage/";
	//protected static String URL = "http://192.168.1.32/sites/gestageApiPhp/";

	protected static String URL = "http://192.168.1.33/sites/gestageApiPhp/";

	protected static  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	protected static  SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
}
