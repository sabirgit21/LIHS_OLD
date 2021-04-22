package view.Report;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

public class PayrollReports {
    private RichSelectOneChoice report_type;
    private RichSelectOneChoice format_type;
    private RichInputDate fromDateParam;
    private RichInputDate toDateParam;
    private RichSelectOneChoice projectIdParam;
    private RichSelectOneChoice departmentidParam;
    private RichSelectOneChoice empidParam;

    public PayrollReports() {
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

    public String gen_Report() {
        // Add event code here...
        return null;
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
