package core;

import executors.callme.CallMeExecutor;
import executors.catalogue.CatalogueExecutor;
import executors.claimpoints.ClaimPointsExecutor;
import executors.digitalbussinesscard.DigitalBusinessCardExecutor;
import executors.digitalbussinesscard.SendBusinessCardExecutor;
import executors.dreamgift.DreamGiftExecutor;
import executors.insurancekyc.InsuranceKYCExecutor;
import executors.login.CompanyLoginExecutor;
import executors.myhealthbenefits.MyHealthBenefitsExecutor;
import executors.mywebsite.MyWebSiteExecutor;
import executors.profile.ProfileExecutor;
import executors.querylist.QueryListExecutor;
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

                 case "07_DIGITALBUSINESSCARD":
                return new DigitalBusinessCardExecutor();

                case "08_SENDBUSINESSCARD":
                return new SendBusinessCardExecutor();

                case "09_MYWEBSITE":
                return new MyWebSiteExecutor();

                 case "10_MYHEALTHBENEFITS":
                return new MyHealthBenefitsExecutor();

                 case "11_INSURANCEKYC":
                return new InsuranceKYCExecutor();

                 case "12_CATALOGUE":
                return new CatalogueExecutor();

                  case "13_DREAMGIFT":
                return new DreamGiftExecutor();

                 case "14_QUERYLIST":
                return new QueryListExecutor();


                

            default:
                throw new RuntimeException("Invalid MODULE: " + module);
        }
    }
}
