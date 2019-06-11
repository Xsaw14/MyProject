import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.DataFormatter;

public class GetMetricValue {

	public String getMetricsValue(HSSFSheet sheet, int index, String projectName, String projectnames[],
			int metricCount) {

		String[] metricValue = new String[metricCount];
		String queryVal = new String();
		StringBuffer sb = new StringBuffer();
		try {
			DataFormatter dataform = new DataFormatter();
			int totalRow = sheet.getPhysicalNumberOfRows();
			boolean flag = false;
			for (int i = 1; i < totalRow; i += 17) {
				String projName = dataform.formatCellValue(sheet.getRow(i).getCell(0));
				for (int j = 0; j < projectnames.length; j++) {
					if (projectName.equals(projName)) {
						flag = true;
					}

				}

				if (flag) {
					int l=0;
					for (int j = i + 2; j < i + 13; j++) {
						try{
						if (!((null == dataform.formatCellValue(sheet.getRow(j + 1).getCell(0))|| dataform.formatCellValue(sheet.getRow(j + 1).getCell(0)).isEmpty())
								&& (null == dataform.formatCellValue(sheet.getRow(j).getCell(0))|| dataform.formatCellValue(sheet.getRow(j).getCell(0)).isEmpty()))) {
							String metricValues = dataform.formatCellValue(sheet.getRow(j).getCell(index - 1));
//							System.out.println("Metric value inside method '"+ metricValues +"'");
							if(metricValues.replaceAll("[%]", "").trim().contains("No Release")||metricValues.isEmpty()){
								metricValue[l++]="NA";
								sb.append('\'').append("NA").append('\'').append(',');
							}else{
							metricValue[l++]=metricValues.replaceAll("[%]", "").trim();
							sb.append('\'').append(metricValues.replaceAll("[%]", "").trim()).append('\'').append(',');
							}
						} else {
							break;
						}
						}catch(NullPointerException e){
							break;
						}
					}
					if (flag) {
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		queryVal = sb.toString();
		return queryVal;
	}
}
