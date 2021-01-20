package view.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.nav.RichLink;
import view.DatabaseConnection.DatabaseConnection;

public class Login {

    // generating static variables to use in different scopes
    private static String role_master_id;
    private static String user_master_id;
    private static String project_id;
    private static String sessUName;
    
    private RichInputText it1;
    private RichInputText it2;
    private RichLink l1;
    private RichButton b1;
    private RichPanelGroupLayout pgl2;
    private RichButton b2;


    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }
     

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }
    

    public void setL1(RichLink l1) {
        this.l1 = l1;
    }

    public RichLink getL1() {
        return l1;
    }

    ///////////////////////////////////////////

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
    // session value storing function
    public static void storeOnSession(String key, Object object) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        sessionState.put(key, object);
    }

    //user logging in
    public String login_action() {
        // Add event code here...
        String username = this.getIt1().getValue().toString();
        String password = this.getIt2().getValue().toString();

        sessUName = username;
        storeOnSession("sessUName", sessUName);
        System.out.println("value for session..............." + sessUName);

        System.out.println(".......................................................................");
        System.out.println(".......................................................................");
        System.out.println("Entered username is : " + username + "....and password is : " + password);
        System.out.println(".......................................................................");
        System.out.println(".......................................................................");


        Connection conn;

        try {
            conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rset =
                stmt.executeQuery("SELECT * FROM tbl_user_master where user_master_name = '" + username +
                                  "' and user_master_pwd = '" + password + "'");

            if (rset.next()) {
                //                conn.close();
                //getting data against column from table
                role_master_id = (rset.getString("role_master_id")).toString();
                user_master_id = (rset.getString("user_master_id")).toString();
//                project_id = (rset.getString("project_id"));
//                if (rset.wasNull()) {
//                    project_id = ""; // set it to empty string as you desire.
//                }
//                
                
                if(rset.getString("project_id") != null)
                {
                    project_id = rset.getString("project_id").toString();
                }
                else
                {
                    project_id = "";
                }
                
                
                //Storing value in session username from input text field and role_master_id from DB

                System.out.println(".........User Name stored in session is :..." + username + "...");
//                System.out.println(".........User Password stored in session is :..." + password + "...");
                System.out.println(".........User Role stored in session is :..." + role_master_id + "...");
                System.out.println(".........User Master ID stored in session is :..." + user_master_id + "...");
                System.out.println(".........Project ID stored in session is :..." + project_id + "...");

                storeOnSession("sessRMID", role_master_id);                
                storeOnSession("sessUMID", user_master_id);               
                storeOnSession("sessPrID", project_id);
                
                conn.close();
                return "/faces/Main_Pages/Dashboard.jsf?faces-redirect=true";
            } else {
                showMessage("Wrong Login Credentials");
                conn.close();
                System.out.println("........wrong login credentials........");
                //return "/faces/Main_Pages/Login.jsf?faces-redirect=true";
                return "false";

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return role_master_id;
    }

    //Logout > session cleared and session variable cleared
    public String logout_action() {
        System.out.println("logout called");
        sessUName = "";
        role_master_id = "";
        storeOnSession("sessUName", "");
        storeOnSession("sessUID", "");
        storeOnSession("sessPrID", "");
        storeOnSession("sessRID", "");
        //        return "good";
        return "/faces/Main_Pages/Login.jsf?faces-redirect=true";
    }
}
