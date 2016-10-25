package com.stringTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class DateTimeRandomToString {

	/**
	 
	 
	 dt = datetime.now()
microsec = dt.microsecond
curDateTime = dt.strftime("%Y%m%d%H%M") + str((dt.second*1000000) + microsec)

imagePool = "/usr/g/sdc_image_pool/reserved"
FILE_SEPARATOR = "/"
rsrvType = "T"
requestId = "dms"
allocatedSpace = 1130905

folderPath = imagePool  + FILE_SEPARATOR + rsrvType + FILE_SEPARATOR + requestId + FILE_SEPARATOR

allocPath = str(curDateTime).strip() + str(random.randint(1, 1000)) + "." + str(int(allocatedSpace))

fullPath = folderPath + str(allocPath)
	 * @param args
	 */
	
	public static String buildMockImagePath(){
		String fullPath = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		
		Calendar date = Calendar.getInstance();
		int second = date.get(Calendar.SECOND);
		int millisecond = date.get(Calendar.MILLISECOND);
		
		String curDateTime =  sdf.format(date.getTime()).trim() + Integer.toString(second * 1000000 + millisecond);
		
		String rand = Integer.toString(new Random().nextInt(1000));
		
		String FILE_SEPARATOR = "/";
		
		return fullPath;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeRandomToString dt = new DateTimeRandomToString();
		DateTimeRandomToString.buildMockImagePath();
	}

}
