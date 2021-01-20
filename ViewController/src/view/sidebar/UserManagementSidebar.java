package view.sidebar;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;

public class UserManagementSidebar implements Serializable {
    private String taskFlowId =
        "/WEB-INF/Task_Flows/Modules/User_Management/User_Management_TaskFlow.xml#User_Management_TaskFlow";

    public UserManagementSidebar() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }
    
    public void fragmentCall(ActionEvent actionEvent) {
        // Add event code here...
        String action = (String)actionEvent.getComponent().getAttributes().get("link");
        StringBuilder link = new StringBuilder();
        link.append("/WEB-INF/Task_Flows/Modules/User_Management/");
        link.append(action);
        link.append(".xml#");
        link.append(action);
        setDynamicTaskFlowId(link.toString());
    }
}
