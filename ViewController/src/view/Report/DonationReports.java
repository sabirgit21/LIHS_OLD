package view.Report;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import view.DatabaseConnection.DatabaseConnection;

public class DonationReports {
    private RichSelectOneChoice format_type;
    private RichSelectOneChoice report_type;

    public DonationReports() {
    }
    
    private static String gotFormat = "";
    private static String selectedReportType = "";

    public String gen_Report() {
        // Add event code here...
        selectedReportType = (String)this.getReport_type().getValue();
       gotFormat = (String)this.getFormat_type().getValue();
        
        
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);
        String url = "";
        
        


        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else  {
            
        //                if(selectedReportType != null || selectedReportType != ""){
        //                }
        //                if(selectedItemReportType != null || selectedItemReportType != ""){
        //                }
        //                if(selectedCenterReportType != null || selectedCenterReportType != ""){
        //                }
        //                if(selectedDayReportType != null || selectedDayReportType != ""){
        //                }
               
              
            
            if(selectedReportType == null || selectedReportType == ""){
                System.out.println("Category wise not selected");
            }
            else{
                switch (selectedReportType) {
                
                case "donationInkindDetail":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Donation_In_Kind_Donation_Report_Detail&");
                    break;
                
                case "donationReceiptDetail":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Donation_Receipt_Donation_Report_Detail&");
                    break;
                
                case "donorSetupDetail":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Donor_Setup_Donationl_Report_Detail&");
                    break;
                


                default:
                    showMessage("Please Select Report Type");
                    break;

                }
            }
            

              

            
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            gotFormat); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            reportBean.setReportParameter("paramform", "no");

            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            }
            
            return null;
        
    }
    
    public String showMessage(String msgs) {
        String messageText = msgs;
        FacesMessage fm = new FacesMessage(messageText);
        /**
             * set the type of the message.
             * Valid types: error, fatal,info,warning
             */
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
        return null;
    }
    
    
    

    public void setFormat_type(RichSelectOneChoice format_type) {
        this.format_type = format_type;
    }

    public RichSelectOneChoice getFormat_type() {
        return format_type;
    }

    public void setReport_type(RichSelectOneChoice report_type) {
        this.report_type = report_type;
    }

    public RichSelectOneChoice getReport_type() {
        return report_type;
    }
}
