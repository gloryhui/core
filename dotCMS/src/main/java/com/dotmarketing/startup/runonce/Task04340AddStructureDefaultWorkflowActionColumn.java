package com.dotmarketing.startup.runonce;

import com.dotmarketing.startup.AbstractJDBCStartupTask;
import java.util.List;

/**
 * This Task add the default_workflow_action column in the Structure tables
 */
public class Task04340AddStructureDefaultWorkflowActionColumn extends AbstractJDBCStartupTask {


    @Override
    public String getPostgresScript() {
        return "alter table structure add default_workflow_action varchar(36);"+
                "alter table structure add constraint fk_action_inode foreign key ( default_workflow_action ) references workflow_action(id);";
    }

    @Override
    public String getMySQLScript() {
        return "alter table structure add default_workflow_action varchar(36)"+
                "alter table structure add constraint fk_action_inode foreign key (default_workflow_action) references workflow_action(id);";
    }

    @Override
    public String getOracleScript() {
        return "alter table structure add default_workflow_action varchar2(36)"+
                "alter table structure add constraint fk_action_inode foreign key (default_workflow_action) references workflow_action(id);";
    }

    @Override
    public String getMSSQLScript() {
        return "alter table structure add default_workflow_action NVARCHAR(36) null"+
                "alter table structure add constraint fk_action_inode foreign key (default_workflow_action) references workflow_action(id);";
    }

    @Override
    public String getH2Script() {
        return "alter table structure add default_workflow_action varchar(36)"+
                "alter table structure add constraint fk_action_inode foreign key (default_workflow_action) references workflow_action(id);";
    }

    @Override
    protected List<String> getTablesToDropConstraints() {
        return null;
    }

    @Override
    public boolean forceRun() {
        return Boolean.TRUE;
    }
}
