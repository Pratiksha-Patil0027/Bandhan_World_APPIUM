package core;

import executors.claimpoints.ClaimPointsExecutor;
import executors.login.CompanyLoginExecutor;


public class ModuleDispatcher {

    public static KeywordExecutor getExecutor(String module) {

        if (module == null || module.isEmpty()) {
            throw new RuntimeException("MODULE column is empty in Excel");
        }

        switch (module.toUpperCase()) {

            case "COMPANYLOGIN":
                return new CompanyLoginExecutor();

                case "CLAIMPOINTS":
                return new ClaimPointsExecutor();

            

           

            default:
                throw new RuntimeException("Invalid MODULE: " + module);
        }
    }
}
