package BuyDirect.Utilities;

import TestComponents.TestUtils;

public class TestHelper extends TestUtils {

	
	public static String welcomebody_Query ="SELECT  REPLACE(REPLACE(REPLACE(Welcome_Message,'<PartnerName>',Tender_Name_Body), '<PartnerPhone>', Partner_Contact_Number),'|', '') AS WelcomeMessage \r\n"
			+ "			FROM [dbo].[Partner_BuyDirect_Settings] PBS INNER JOIN [dbo].[Partner_Profile] PP \r\n"
			+ "			ON PBS.Partner_ID = PP.Partner_ID WHERE PBS.Partner_ID ="+partner+"";
	
	
	
	public static String partner_Prop_Query=
			  "SELECT product_name,Partner_contact_number " +
			  "from partner_profile pf inner join  partner_buydirect_settings pbs on pf.partner_id=pbs.partner_id where pbs.Partner_ID="
			 +partner+"";
	
	public static String partnerName_Query=
			"select Tender_Name_header from partner_buydirect_settings WHERE partner_id=" +partner+"";
	
	public static String plasticBody_Query ="SELECT SUBSTRING(plastics_page_body, 1, CHARINDEX('|', plastics_page_body) - 1) AS plasticBodyMain, \r\n"
			+ "SUBSTRING(plastics_page_body, CHARINDEX('|', plastics_page_body) + 1, LEN(plastics_page_body)) AS plasticBodySub\r\n"
			+ "FROM  [dbo].[Partner_BuyDirect_Settings] \r\n"
			+ "WHERE \r\n"
			+ "    partner_id ="+partner+"";
	
	public static String plasticBody_Query_without_pipe ="SELECT Plastics_Page_Body from "
			+ "Partner_BuyDirect_Settings where Partner_Id="+partner+"";
	
	public static String loginParam_Query="select consumer_email , consumer_cdf_id  from "
			+ "Consumer as Co  inner join consumer_cdf cdf on Co.consumer_id=cdf.consumer_id and "
			+ "cdf.Partner_CDF_Definition_ID=9";
	
	public static String plastic_Subtitle_query = "select Plastics_Page_Subtitle from Partner_BuyDirect_Settings where partner_ID="+partner+"";
	
	public static String dLFlag_Query="select IsDLrequired from partner_buydirect_settings where Partner_ID ="+partner+"";
}
