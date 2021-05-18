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

public class DateWiseReport {
    private RichInputDate fromDateParam;
    private RichInputDate toDateParam;
    private RichSelectOneChoice format_type;
    private RichSelectOneChoice report_type;
    private RichSelectOneChoice projectId_Param;
    private RichSelectOneChoice departmentid_Param;
    private RichSelectOneChoice itemL4id_Param;

    public DateWiseReport() {
    }

    private static String selectedReportType = "";
    private static String gotFormat = "";
    private static BigDecimal gotProjectid;
    private static BigDecimal gotDepartmentid;
    private static BigDecimal gotItemL4id;

    public String gen_Report() {
        // Add event code here...
        selectedReportType = (String)this.getReport_type().getValue();
        gotFormat = (String)this.getFormat_type().getValue();
        gotProjectid = (BigDecimal) this.getProjectId_Param().getValue();
        gotDepartmentid = (BigDecimal) this.getDepartmentid_Param().getValue();
        gotItemL4id = (BigDecimal) this.getItemL4id_Param().getValue();
        
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);
        String url = "";
        
        if(getFromDate() != ""){
            reportBean.setReportParameter("P_Fdated", getFromDate());
        }
        
        if(getToDate() != ""){
            reportBean.setReportParameter("P_Tdated", getToDate());
        }
        if (gotProjectid != null) {
            reportBean.setReportParameter("P_Project_ID", gotProjectid.toString());
        }
        if (gotDepartmentid != null) {
            reportBean.setReportParameter("P_Department_ID", gotDepartmentid.toString());
        }
        if (gotItemL4id != null) {
            reportBean.setReportParameter("P_item_L4_id", gotItemL4id.toString());
        }
        
        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else {
            
                switch (selectedReportType) {
                
                case "cashPurchase":
                    reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Cash_Purchase_Date_Wise&");
                    break;
                
                case "debitNotes":
                    reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Debit_Notes_Date_Wise&");
                    break;
                
                case "demandOrder":
                    reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Demand_Order_Date_Wise&");
                    break;
                
                case "goodsIssue":
                    reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Good_Issue_Notes_Date_Wise&");
                    break;
                
                case "goodsReceipt":
                    reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Good_Receipt_Notes_Date_Wise&");
                    break;
                
                case "interTransfer":
                    reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Inter_Transfer_Notes_Date_Wise&");
                    break;
                
                case "inwardGatePass":
                    reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Inward_Gate_Pass_Date_Wise&");
                    break;
                
                case "purchaseOrder":
                    reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Purchase_Order_Date_Wise&");
                    break;
                
                case "qualityInspection":
                    reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Quality_Inspection_Date_Wise&");
                    break;

                default:
                    showMessage("Please Select Report Type");
                    break;

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

    public void setProjectId_Param(RichSelectOneChoice projectId_Param) {
        this.projectId_Param = projectId_Param;
    }

    public RichSelectOneChoice getProjectId_Param() {
        return projectId_Param;
    }

    public void setDepartmentid_Param(RichSelectOneChoice departmentid_Param) {
        this.departmentid_Param = departmentid_Param;
    }

    public RichSelectOneChoice getDepartmentid_Param() {
        return departmentid_Param;
    }

    public void setItemL4id_Param(RichSelectOneChoice itemL4id_Param) {
        this.itemL4id_Param = itemL4id_Param;
    }

    public RichSelectOneChoice getItemL4id_Param() {
        return itemL4id_Param;
    }
}
