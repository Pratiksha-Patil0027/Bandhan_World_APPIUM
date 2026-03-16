package core;

import executors.callme.CallMeExecutor;
import executors.claimpoints.ClaimPointsExecutor;
import executors.login.CompanyLoginExecutor;
import executors.profile.ProfileExecutor;
import executors.redemptions.RedemptionsExecutor;

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

            case "04_REDEMPTIONS":
                return new RedemptionsExecutor();

            case "05_CALLME":
                return new CallMeExecutor();

                case "06_REWARDCATALOGUE":
                return new RedemptionsExecutor();

            default:
                throw new RuntimeException("Invalid MODULE: " + module);
        }
    }
}
