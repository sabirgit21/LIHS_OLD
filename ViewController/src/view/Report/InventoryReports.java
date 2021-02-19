package view.Report;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.input.RichSelectOneListbox;

import oracle.jbo.domain.Number;

import view.DatabaseConnection.DatabaseConnection;

public class InventoryReports {
    private RichSelectOneChoice format_type;
    private RichSelectOneChoice report_type;
    private RichInputDate fromDateParam;
    private RichInputDate toDateParam;
    private RichSelectOneChoice projectidparam;
    private RichSelectOneChoice departmentidparam;
    private RichSelectOneChoice itemL4idparam;

    public InventoryReports() {
    }
    private static String selectedReportType = "";
    private static String gotFormat = "";
    private static BigDecimal gotprojectId;
    private static BigDecimal gotDepartmentidId;
    private static BigDecimal gotitemL4id;

    public String gen_Report() {
        // Add event code here...
        selectedReportType = (String) this.getReport_type().getValue();
        gotFormat = (String) this.getFormat_type().getValue();
        gotprojectId = (BigDecimal) this.getProjectidparam().getValue();
        gotDepartmentidId = (BigDecimal) this.getDepartmentidparam().getValue();
        gotitemL4id = (BigDecimal) this.getItemL4idparam().getValue();

        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);
        String url = "";

        if (getFromDate() != "") {
            reportBean.setReportParameter("P_Fdated", getFromDate());
        }
        if (getToDate() != "") {
            reportBean.setReportParameter("P_Tdated", getToDate());
        }
        if (gotprojectId != null) {
            reportBean.setReportParameter("P_Project_id", gotprojectId.toString());
        }
        if (gotDepartmentidId != null) {
            reportBean.setReportParameter("P_Department_id", gotDepartmentidId.toString());
        }
        if (gotitemL4id != null) {
            reportBean.setReportParameter("P_item_L4_id", gotitemL4id.toString());
        }

        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else {

            switch (selectedReportType) {

            case "inventoryReport":
                reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Inventory_Reports&");
                break;

            case "currentStock":
                reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Current_Stock&");
                break;

            case "itemLedger":

                reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/Item_Ledger&");
                break;
            case "mGTdailyfeeding":

                reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/MGT_Daily_Feeding_1&");
                break;
            case "mGTdailyfeeding2":

                //working for procedure call//
                
                if (getFromDate() != "" & gotprojectId != null & gotitemL4id != null & gotDepartmentidId != null) {
                        
                        BigDecimal sendItemL4IDLgrfinal = gotitemL4id;
                        
                        String sendFDateFINAL = getFromDate();
                
                        String sendProjectIDCnvrt = gotprojectId.toString();
                        int sendProjectIDFinal = Integer.parseInt(sendProjectIDCnvrt);

                        String sendDeptIDCnvrt = gotDepartmentidId.toString();
                        int sendDeptIDFinal = Integer.parseInt(sendDeptIDCnvrt);

                        //calling procedure start//
                        Connection conn;
                        ResultSet rs;
                        CallableStatement cstmt = null;
                        try {
                            conn = DatabaseConnection.getConnection();
                            String SQL = "{call P_IL(?,?,?,?)}";
                            cstmt = conn.prepareCall(SQL);
                            
                            cstmt.setBigDecimal(1, sendItemL4IDLgrfinal);
                            cstmt.setString(2, sendFDateFINAL );
                            cstmt.setInt(3, sendProjectIDFinal);
                            cstmt.setInt(4, sendDeptIDFinal);
                            
                            rs = cstmt.executeQuery();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        
                        reportBean.setReportURLName("userid=lihs/lihs@orcl&domain=classicdomain&report=C:/LIHS_Reports/MGT_Daily_Feeding_2&");

                    }
                else{
                    showMessage("Please Select From Date, Project, Item & Department");
                }
                
                break;
                //calling procedure end//
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
        if (fromDateParam.getValue() != null && fromDateParam.getValue() != "") {
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
        if (toDateParam.getValue() != null && toDateParam.getValue() != "") {
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

    public void setProjectidparam(RichSelectOneChoice projectidparam) {
        this.projectidparam = projectidparam;
    }

    public RichSelectOneChoice getProjectidparam() {
        return projectidparam;
    }

    public void setDepartmentidparam(RichSelectOneChoice departmentidparam) {
        this.departmentidparam = departmentidparam;
    }

    public RichSelectOneChoice getDepartmentidparam() {
        return departmentidparam;
    }

    public void setItemL4idparam(RichSelectOneChoice itemL4idparam) {
        this.itemL4idparam = itemL4idparam;
    }

    public RichSelectOneChoice getItemL4idparam() {
        return itemL4idparam;
    }
}
