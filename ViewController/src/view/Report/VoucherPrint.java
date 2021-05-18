package view.Report;

import javax.faces.event.ActionEvent;

import view.DatabaseConnection.DatabaseConnection;

public class VoucherPrint {
    public VoucherPrint() {
    }
    DatabaseConnection dbconnect = new DatabaseConnection();
    OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);
    
    public void getDOReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendDOID = (Number) actionEvent.getComponent().getAttributes().get("sendDOID");
        reportBean.setReportParameter("P_DOMID", sendDOID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Demand_Order_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void GetPOReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendPOID = (Number) actionEvent.getComponent().getAttributes().get("sendPOID");
        reportBean.setReportParameter("P_POMID", sendPOID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Purchase_Order_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getIGPReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendIGPID = (Number) actionEvent.getComponent().getAttributes().get("sendIGPID");
        reportBean.setReportParameter("P_IGPMID", sendIGPID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Inward_Gate_Pass_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getQCRReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendQCRID = (Number) actionEvent.getComponent().getAttributes().get("sendQCRID");
        reportBean.setReportParameter("P_QCRID", sendQCRID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Quality_Inspection_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getGRNReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendGRNID = (Number) actionEvent.getComponent().getAttributes().get("sendGRNID");
        reportBean.setReportParameter("P_GRNMID", sendGRNID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Good_Receipt_Notes_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }
    

    public void GetCPReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendCPID = (Number) actionEvent.getComponent().getAttributes().get("sendCPID");
        reportBean.setReportParameter("P_CPID", sendCPID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Cash_Purchse_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getDNReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendDNID = (Number) actionEvent.getComponent().getAttributes().get("sendDNID");
        reportBean.setReportParameter("P_DNMID", sendDNID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Debit_Notes_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getGINReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendGINID = (Number) actionEvent.getComponent().getAttributes().get("sendGINID");
        reportBean.setReportParameter("P_GINMID", sendGINID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Good_Issue_Notes_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getITNReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendITNMID = (Number) actionEvent.getComponent().getAttributes().get("sendITNMID");
        reportBean.setReportParameter("P_ITNMID", sendITNMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Inter_Transfer__Notes_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getCOAReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Chart_of_Account_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void get_BOQ_Report(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendBOQID = (Number) actionEvent.getComponent().getAttributes().get("sendBOQID");
        reportBean.setReportParameter("P_Boq_M_id", sendBOQID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Batch_Order_Quantity_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void get_FGT_Report(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendFGTID = (Number) actionEvent.getComponent().getAttributes().get("sendFGTID");
        reportBean.setReportParameter("P_Fgt_M_id", sendFGTID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Finish_Goods_Transfer_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void get_KM_Report(ActionEvent actionEvent) {
        // Add event code here...

        String url = "";
        Number sendKMMID = (Number) actionEvent.getComponent().getAttributes().get("sendKMMID");
        reportBean.setReportParameter("P_Kichen_Menu_M_id", sendKMMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Kichen_Menu_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void get_PFG_Report(ActionEvent actionEvent) {
        // Add event code here...

        String url = "";
        Number sendPFGMID = (Number) actionEvent.getComponent().getAttributes().get("sendPFGMID");
        reportBean.setReportParameter("P_Pro_Fg_M_id", sendPFGMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Production_Finish_Goods_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void get_PI_Report(ActionEvent actionEvent) {
        // Add event code here...

        String url = "";
        Number sendPIMID = (Number) actionEvent.getComponent().getAttributes().get("sendPIMID");
        reportBean.setReportParameter("P_Pro_Iss_M_id", sendPIMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Production_Issuance_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void get_PO_Report(ActionEvent actionEvent) {
        // Add event code here...

        String url = "";
        Number sendPORMID = (Number) actionEvent.getComponent().getAttributes().get("sendPORMID");
        reportBean.setReportParameter("P_Por_M_id", sendPORMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Production_Order_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getBPVReport(ActionEvent actionEvent) {
        // Add event code here...

        String url = "";
        Number sendBPVMID = (Number) actionEvent.getComponent().getAttributes().get("sendBPVMID");
        reportBean.setReportParameter("P_BPV_M_id", sendBPVMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Bank_Payment_GL_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getBRVReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendBRVMID = (Number) actionEvent.getComponent().getAttributes().get("sendBRVMID");
        reportBean.setReportParameter("P_BRV_M_id", sendBRVMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Bank_Reciept_GL_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getCPVReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendCPVMID = (Number) actionEvent.getComponent().getAttributes().get("sendCPVMID");
        reportBean.setReportParameter("P_CPV_M_id", sendCPVMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Cash_Payment_GL_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getCRVReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendCRVMID = (Number) actionEvent.getComponent().getAttributes().get("sendCRVMID");
        reportBean.setReportParameter("P_CRV_M_id", sendCRVMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Cash_Reciept_GL_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getJVReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendJVMID = (Number) actionEvent.getComponent().getAttributes().get("sendJVMID");
        reportBean.setReportParameter("P_JV_M_id", sendJVMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Journal_Voucher_GL_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getOBReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/OB_INV_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getDEPTReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Department_INV_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getUOMReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/UOM_INV_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getBankSetupReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Bank_Setup_BnkCsh_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getCashSetupReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Cash_Setup_BnkCsh_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getProjectReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Project_Setup_GL_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getCOAGLReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Chart_of_Account_GL_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getSupplReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendSUPPID = (Number) actionEvent.getComponent().getAttributes().get("sendSUPPID");
        reportBean.setReportParameter("P_PBL_SUPP_id", sendSUPPID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Supplier_Setup_Payable_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getPBPReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendPBPMID = (Number) actionEvent.getComponent().getAttributes().get("sendPBPMID");
        reportBean.setReportParameter("P_PBP_M_id", sendPBPMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Bank_Payment_Payable_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getPCPReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendPCPMID = (Number) actionEvent.getComponent().getAttributes().get("sendPCPMID");
        reportBean.setReportParameter("P_PCP_M_id", sendPCPMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Cash_Payment_Payable_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getAdvLoanReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendADVLOANID = (Number) actionEvent.getComponent().getAttributes().get("sendADVLOANID");
        reportBean.setReportParameter("P_ADVLOAN_id", sendADVLOANID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Adv_Loan_Payroll_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getAllowanceSetupReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Allowance_Setup_Payroll_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
        
    }

    public void getAttendanceReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendATTID = (Number) actionEvent.getComponent().getAttributes().get("sendATTID");
        reportBean.setReportParameter("P_ATTMID", sendATTID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Attendance_Payroll_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getDesignationReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Designation_Payroll_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getEmpSetReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Employee_Setup_Payroll_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getGradePayRoleReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Grade_Payroll_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getLeaveReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Leave_Structure_Payroll_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getPromotionReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendPROMOTID = (Number) actionEvent.getComponent().getAttributes().get("sendPROMOTID");
        reportBean.setReportParameter("P_PROMOTIONID", sendPROMOTID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Promotion_Payroll_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getSalGenReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendSALMID = (Number) actionEvent.getComponent().getAttributes().get("sendSALMID");
        reportBean.setReportParameter("P_SALARYMID", sendSALMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Salary_Generation_Payroll_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
        
    }

    public void getTransferReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendTRANSID = (Number) actionEvent.getComponent().getAttributes().get("sendTRANSID");
        reportBean.setReportParameter("P_TRANSFERID", sendTRANSID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Transfer_Payroll_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getDonCrReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendDONCRID = (Number) actionEvent.getComponent().getAttributes().get("sendDONCRID");
        reportBean.setReportParameter("P_DON_CR_id", sendDONCRID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Donation_Receipt_Donation_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getDonTypeReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Don_Type_Donation_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getDonInKindReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        Number sendDonInKindMID = (Number) actionEvent.getComponent().getAttributes().get("sendDonInKindMID");
        reportBean.setReportParameter("P_DON_KIND_M_id", sendDonInKindMID.toString());
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Donation_In_Kind_Donation_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }

    public void getDonSetReport(ActionEvent actionEvent) {
        // Add event code here...
        String url = "";
        
        reportBean.setReportURLName("userid=lihs/lihsir@orcl&domain=classicdomain&report=C:/LIHS_Reports/Donor_Setup_Donationl_Detail&");
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
    }
}
