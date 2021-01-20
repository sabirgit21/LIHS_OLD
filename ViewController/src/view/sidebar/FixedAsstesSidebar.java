package view.sidebar;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;

public class FixedAsstesSidebar implements Serializable {
    private String taskFlowId =
        "/WEB-INF/Task_Flows/Modules/Fixed_Assets/Fixed_Assets_TaskFlow.xml#Fixed_Assets_TaskFlow";

    public FixedAsstesSidebar() {
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
        link.append("/WEB-INF/Task_Flows/Modules/Fixed_Assets/");
        link.append(action);
        link.append(".xml#");
        link.append(action);
        setDynamicTaskFlowId(link.toString());
    }
}
