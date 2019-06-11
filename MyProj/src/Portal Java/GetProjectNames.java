import java.util.LinkedList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.DataFormatter;

public class GetProjectNames {

	public String[] getProjectNames(HSSFSheet sheet){
		
		DataFormatter dataform = new DataFormatter();
		int totalRow = sheet.getLastRowNum();
		int projects = totalRow/17;
		
		LinkedList<String> projList = new LinkedList<>();
		int j=0;
		try{
			int i=1;
		String projNameWhile = dataform.formatCellValue(sheet.getRow(i).getCell(0));
		while(!(null==projNameWhile||projNameWhile.isEmpty()||projNameWhile.equals(""))){
			projList.add(projNameWhile);
			i=i+17;
			try{
			projNameWhile = dataform.formatCellValue(sheet.getRow(i).getCell(0));
			}catch(NullPointerException e){
				break;
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		String[] projectNames = new String[projList.size()];
		for(int i=0;i<projList.size();i++){
			projectNames[i]=projList.get(i);
			
		}
		return projectNames;
		
	}
}
