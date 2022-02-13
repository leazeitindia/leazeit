package in.leazeit.repository;

import in.leazeit.entity.PropertyAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyAssetsRepository extends JpaRepository<PropertyAssets, String> {
    List<PropertyAssets> findByPropertyId(String id);
}
