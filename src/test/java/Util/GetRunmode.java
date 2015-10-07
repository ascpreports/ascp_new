package Util;

//import Util.Xls_Reader;
import Util.Xls_Reader_Vivek;

public class GetRunmode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create an object of the xls reader class.
		System.out.println(System.getProperty("user.dir"));
		Xls_Reader_Vivek xls = new Xls_Reader_Vivek(System.getProperty("user.dir") +"\\src\\test\\java\\data\\TestCases.xlsx");
		System.out.println(xls.path);
		for(int rowNum=2;rowNum<=xls.getRowCount("ypLocalAds");rowNum++){
			if(xls.getCellData("ypLocalAds","Runmode",rowNum).equals("Y")){
			System.out.println(xls.getCellData("ypLocalAds", "TCID", rowNum));
			}
		}
	}

}
