package ru.evteev.blog.service;

import java.util.EnumMap;
import java.util.Map;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.evteev.blog.model.dto.api.response.GlobalSettingsDTO;
import ru.evteev.blog.model.enums.GlobalSetting;
import ru.evteev.blog.repository.GlobalSettingsRepository;

@Data
@Service
public class GlobalSettingsServiceImpl implements GlobalSettingsService {

    private final GlobalSettingsRepository globalSettingsRepository;

    public GlobalSettingsDTO getGlobalSettings() {
        GlobalSettingsDTO dto = new GlobalSettingsDTO();

        Map<GlobalSetting, Boolean> settings = new EnumMap<>(GlobalSetting.class);
        globalSettingsRepository.findAll().forEach(s -> settings.put(
            GlobalSetting.valueOf(s.getCode()),
            Boolean.parseBoolean(s.getValue())));

        dto.setMultiuserMode(
            settings.get(GlobalSetting.MULTIUSER_MODE));
        dto.setPostPremoderation(
            settings.get(GlobalSetting.POST_PREMODERATION));
        dto.setStatisticsIsPublic(
            settings.get(GlobalSetting.STATISTICS_IS_PUBLIC));

        return dto;
    }
}
