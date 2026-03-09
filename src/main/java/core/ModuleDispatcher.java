package core;

import executors.claimpoints.ClaimPointsExecutor;
import executors.login.CompanyLoginExecutor;
import executors.profile.ProfileExecutor;


public class ModuleDispatcher {

    public static KeywordExecutor getExecutor(String module) {

        if (module == null || module.isEmpty()) {
            throw new RuntimeException("MODULE column is empty in Excel");
        }

        switch (module.toUpperCase()) {

            case "01_COMPANYLOGIN":
                return new CompanyLoginExecutor();

            case "02_CLAIMPOINTS":
                return new ClaimPointsExecutor();

            case "03_PROFILE":
                return new ProfileExecutor();

            

           

            default:
                throw new RuntimeException("Invalid MODULE: " + module);
        }
    }
}
