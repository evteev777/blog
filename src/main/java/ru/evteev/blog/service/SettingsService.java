package ru.evteev.blog.service;

import org.springframework.stereotype.Service;
import ru.evteev.blog.api.response.SettingsResponse;

@Service
public class SettingsService {

    public SettingsResponse getGlobalSettings() {
        SettingsResponse settingsResponse = new SettingsResponse();
        settingsResponse.setMultiuserMode(true);
        settingsResponse.setPostPremoderation(true);
        settingsResponse.setStatisticsIsPublic(true);
        return settingsResponse;
    }
}
