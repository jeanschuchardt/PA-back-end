package com.example.pa_backend.repository;

import com.example.pa_backend.entity.TherapyConfiguration;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TherapyConfigurationRepository extends BaseRepository<TherapyConfiguration> {

    Optional<TherapyConfiguration> findByTherapyIdAndTherapistIdAndTherapistAddressId(int therapyId,
                                                                                            int therapistId,
                                                                                            int therapistAddressId);

}
