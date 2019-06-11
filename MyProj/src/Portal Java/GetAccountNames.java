import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GetAccountNames {

	public String[] getAccountNames(HSSFWorkbook workBook){
		String[] accountnames = new String[workBook.getNumberOfSheets()-1];
		int j=0;
		try{
		for(int i=0;i<workBook.getNumberOfSheets();i++){
			if(j>workBook.getNumberOfSheets()-2){
				throw new Exception();
			}
			if(!((workBook.getSheetName(i).equals("Requirements"))||(workBook.getSheetName(i).equals("DB_Names")))){
			accountnames[j] = workBook.getSheetName(i);
			j++;
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return accountnames;
	}
}
