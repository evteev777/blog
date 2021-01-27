package ru.evteev.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evteev.blog.model.entity.GlobalSetting;

@Repository
public interface GlobalSettingsRepository extends CrudRepository<GlobalSetting, Integer> {

    GlobalSetting findGlobalSettingByCode(String code);
}
