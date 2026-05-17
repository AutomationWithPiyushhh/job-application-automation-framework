package dataproviders;

import config.ConfigReader;
import models.RecruiterData;
import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

import java.util.List;

public class EmailDataProvider {

	@DataProvider(name = "recruiterData")

	public Object[][] recruiterData() {

		List<RecruiterData> recruiters = ExcelUtils.getRecruiterData(

				ConfigReader.get("excel.path"));

		Object[][] data = new Object[recruiters.size()][1];

		for (int i = 0; i < recruiters.size(); i++) {

			data[i][0] = recruiters.get(i);
		}

		return data;
	}
}