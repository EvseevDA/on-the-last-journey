package ru.onthelastjourney.backend.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.FuneralAffilation;

@Repository
public interface FuneralAffilationRepository extends JpaRepository<FuneralAffilation, Long> {

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(
            value = "DELETE FROM funeralservice.funeral_affilations WHERE id = :id",
            nativeQuery = true
    )
    void deleteById(@NonNull @Param("id") Long id);

}
