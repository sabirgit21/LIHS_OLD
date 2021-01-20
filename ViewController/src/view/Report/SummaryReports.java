package view.Report;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import view.DatabaseConnection.DatabaseConnection;

public class SummaryReports {
    private RichSelectOneChoice format_type;
    private RichSelectOneChoice report_type;
    private RichInputDate fromDateParam;
    private RichInputDate toDateParam;
    private RichSelectOneChoice projidparam;
    private RichSelectOneChoice itemreport_type;
    private RichSelectOneChoice centerreport_type;
    private RichSelectOneChoice dayreport_type;

    public SummaryReports() {
        
    }
    
    private static String selectedReportType = "";
    private static String selectedItemReportType = "";
    private static String selectedCenterReportType = "";
    private static String selectedDayReportType = "";
    private static String gotFormat = "";
    private static BigDecimal  gotprojectId;

    public String gen_Report() {
        // Add event code here...
        selectedReportType = (String)this.getReport_type().getValue();
        selectedItemReportType =(String)this.getItemreport_type().getValue();
        selectedCenterReportType =(String)this.getCenterreport_type().getValue();
        selectedDayReportType=(String)this.getDayreport_type().getValue();
            
            
        gotFormat = (String)this.getFormat_type().getValue();
        gotprojectId = (BigDecimal)this.getProjidparam().getValue();
        
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);
        String url = "";
        
        if(getFromDate() != ""){
            reportBean.setReportParameter("P_Fdated", getFromDate());
        }
        
        if(getToDate() != ""){
            reportBean.setReportParameter("P_Tdated", getToDate());
        }
        if(gotprojectId != null){
            reportBean.setReportParameter("P_Project_id", gotprojectId.toString());
        } 


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
                
                case "summaryITN":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_ITN_Item_Project&");
                    break;
                
                case "summaryIRN":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_IRN_Item_Project&");
                    break;
                
                case "summaryGIR":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_GIR_Item_Project&");
                    break;
                
                case "summaryGIN":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_GIN_Item_Project&");
                    break;
                
                case "summaryDN":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_DN_Item_Project&");
                    break;
                
                case "summaryCP":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_Cash_Purch_Item_Project&");
                    break;
                
                case "summaryGRN":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_GRN_Item_Project&");
                    break;
                
                case "summaryOB":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_OB_Item_Project&");
                    break;
                
               case "summaryPROIss":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_PRO_Iss_Item_Project&");
                        break;
                    
               case "summaryFGTRN":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_FG_TRN_Item_Project&");
                        break;
                        
                    case "summaryFGTRNDay":
                            reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_FG_TRN_Day_Project&");
                            break;

                default:
                    showMessage("Please Select Report Type");
                    break;

                }
            }
            
                if(selectedItemReportType == null || selectedItemReportType == ""){
                    System.out.println("Item wise not selected");
                }
                else{
                switch (selectedItemReportType) {
                
                    case "summaryITNL4":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_ITN_L4_Item_Project&");
                        break;
                    
                    case "summaryIRNL4":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_IRN_L4_Item_Project&");
                        break;
                    
                    case "summaryGIRL4":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_GIR_L4_Item_Project&");
                        break;
                    
                    case "summaryGINL4":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_GIN_L4_Item_Project&");
                        break;
                    
                    case "summaryDNL4":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_DN_L4_Item_Project&");
                        break;
                    
                    case "summaryCPL4":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_Cash_Purch_L4_Item_Project&");
                        break;
                    
                    case "summaryGRNL4":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_GRN_L4_Item_Project&");
                        break;
                    
                    case "summaryOBL4":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_OB_L4_Item_Project&");
                        break;
                    
                    case "summaryPROIssL4":
                            reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_PRO_Iss_L4_Item_Project&");
                            break;
                        
                    case "summaryFGTRNL4":
                            reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_FG_TRN_L4_Item_Project&");
                            break;

                default:
                    showMessage("Please Select Report Type");
                    break;

                }
                }
            
                if(selectedCenterReportType == null || selectedCenterReportType == ""){
                    System.out.println("center sub center wise not selected");
                }
                else{
                switch (selectedCenterReportType) {
                
                    case "summaryPROIssCenter":
                            reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_PRO_Iss_Center_Project&");
                            break;
                        
                    case "summaryFGTRNCenter":
                            reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_FG_TRN_Center_Project&");
                            break;
                    case "summaryFGTRNSubCenter":
                            reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_FG_TRN_Sub_Center_Project&");
                            break;

                default:
                    showMessage("Please Select Report Type");
                    break;

                }
                }
            
            
                if(selectedDayReportType == null || selectedDayReportType == ""){
                    System.out.println("day wise not selected");
                }
                else{
                switch (selectedDayReportType) {
                
                    case "summaryITNDay":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_ITN_Day_Project&");
                        break;
                    
                    case "summaryIRNDay":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_IRN_Day_Project&");
                        break;
                    
                    case "summaryGIRDay":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_GIR_Day_Project&");
                        break;
                    
                    case "summaryGINDay":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_GIN_Day_Project&");
                        break;
                    
                    case "summaryDNDay":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_DN_Day_Project&");
                        break;
                    
                    case "summaryCPDay":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_Cash_Purch_Day_Project&");
                        break;
                    
                    case "summaryGRNDay":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_GRN_Day_Project&");
                        break;
                    
                    case "summaryOBDay":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_OB_Day_Project&");
                        break;
                    
                    case "summaryPROIssDay":
                            reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_PRO_Iss_Day_Project&");
                            break;
                        
                    case "summaryFGTRNDay":
                            reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Summary_FG_TRN_Day_Project&");
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
    
    private String getFromDate() {
        if(fromDateParam.getValue() != null && fromDateParam.getValue() != "") {
            try {
                DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                Date parsedDate = sdf.parse(fromDateParam.getValue().toString());
                SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
                return (print.format(parsedDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
    
    private String getToDate() {
        if(toDateParam.getValue() != null && toDateParam.getValue() != "") {
            try {
                DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                Date parsedDate = sdf.parse(toDateParam.getValue().toString());
                SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
                return (print.format(parsedDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
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

    public void setFromDateParam(RichInputDate fromDateParam) {
        this.fromDateParam = fromDateParam;
    }

    public RichInputDate getFromDateParam() {
        return fromDateParam;
    }

    public void setToDateParam(RichInputDate toDateParam) {
        this.toDateParam = toDateParam;
    }

    public RichInputDate getToDateParam() {
        return toDateParam;
    }

    public void setProjidparam(RichSelectOneChoice projidparam) {
        this.projidparam = projidparam;
    }

    public RichSelectOneChoice getProjidparam() {
        return projidparam;
    }

    public void setItemreport_type(RichSelectOneChoice itemreport_type) {
        this.itemreport_type = itemreport_type;
    }

    public RichSelectOneChoice getItemreport_type() {
        return itemreport_type;
    }

    public void setCenterreport_type(RichSelectOneChoice centerreport_type) {
        this.centerreport_type = centerreport_type;
    }

    public RichSelectOneChoice getCenterreport_type() {
        return centerreport_type;
    }

    public void setDayreport_type(RichSelectOneChoice dayreport_type) {
        this.dayreport_type = dayreport_type;
    }

    public RichSelectOneChoice getDayreport_type() {
        return dayreport_type;
    }
}
