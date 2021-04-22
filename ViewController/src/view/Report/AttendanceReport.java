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

public class AttendanceReport {
    private RichSelectOneChoice report_type;
    private RichSelectOneChoice format_type;
    private RichInputDate fromDateParam;
    private RichInputDate toDateParam;
    private RichSelectOneChoice projectIdParam;
    private RichSelectOneChoice departmentidParam;
    private RichSelectOneChoice empidParam;


    public AttendanceReport() {
    }

    private static String selectedReportType = "";
    private static String gotFormat = "";
    private static BigDecimal  gotprojectId;
    private static BigDecimal  gotDepartmentid;
    private static BigDecimal  gotempid;

    public String gen_Report() {
        // Add event code here...
        selectedReportType = (String)this.getReport_type().getValue();
        gotFormat = (String)this.getFormat_type().getValue();
        gotprojectId = (BigDecimal)this.getProjectIdParam().getValue();
        gotDepartmentid = (BigDecimal)this.getDepartmentidParam().getValue();
        gotempid = (BigDecimal)this.getEmpidParam().getValue();
        
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
        if(gotDepartmentid != null){
            reportBean.setReportParameter("P_Department_id", gotDepartmentid.toString());
        } 
        if(gotempid != null){
            reportBean.setReportParameter("P_Empid", gotempid.toString());
        } 
        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else {
              
                switch (selectedReportType) {
                
                case "attDay":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Attendance_Day_wise&");
                    break;
                
                case "attMonth":
                    reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Attendance_Month_wise&");
                    break;
                
                    case "EmployeeBioData":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Employee_Bio_Detail&");
                        break;
                
                    case "EmpAtt":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Attendance_Employee_Wise&");
                        break;
                
                    case "PayAtt":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Attendance_Payroll_Detail&");
                        break;
                
                    case "EmpAttSum":
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Employees_Attendance_Summary_Report&");
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
    public void setReport_type(RichSelectOneChoice report_type) {
        this.report_type = report_type;
    }

    public RichSelectOneChoice getReport_type() {
        return report_type;
    }

    public void setFormat_type(RichSelectOneChoice format_type) {
        this.format_type = format_type;
    }

    public RichSelectOneChoice getFormat_type() {
        return format_type;
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

    public void setProjectIdParam(RichSelectOneChoice projectIdParam) {
        this.projectIdParam = projectIdParam;
    }

    public RichSelectOneChoice getProjectIdParam() {
        return projectIdParam;
    }

    public void setDepartmentidParam(RichSelectOneChoice departmentidParam) {
        this.departmentidParam = departmentidParam;
    }

    public RichSelectOneChoice getDepartmentidParam() {
        return departmentidParam;
    }

    public void setEmpidParam(RichSelectOneChoice empidParam) {
        this.empidParam = empidParam;
    }

    public RichSelectOneChoice getEmpidParam() {
        return empidParam;
    }
}
