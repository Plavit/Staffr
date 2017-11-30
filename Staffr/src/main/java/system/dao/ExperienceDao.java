package system.dao;

import system.business.Experience;

public class ExperienceDao extends BaseDao<Experience>{
    protected ExperienceDao(Class<Experience> type) {
        super(Experience.class);
    }
}
