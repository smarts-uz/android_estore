package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.PolicyContent;

public interface PolicyInteractor {
    interface CallBack {

        void onPolicyLoaded(PolicyContent policyContent);

        void onPolicyLoadError();
    }
}
