package com.koptev.abstractions;

import com.koptev.instances.Otzyvru_comRules;
import com.koptev.models.ParseSettingsPack;

public interface WebsiteConfiguration {
    static ParseSettingsPack getSettingsPack(String address) {
        String domain = CleanAddress(address).split("/")[0];
        switch (domain) {
            case "otzyvru.com":
                if (Otzyvru_comRules.getFormatter().check(address)) {
                    return Otzyvru_comRules.getInstance().getSettingsPack();
                }
                break;
            default:
                return null;
        }
        return null;
    }

    static String CleanAddress(String address) {
        String tAddress = address;
        if (address.charAt(address.length() - 1) == '/') {
            tAddress = address.substring(0, address.length() - 1);
        }
        return tAddress
                .replace("http://", "")
                .replace("https://", "")
                .replace("www.", "");
    }
}
