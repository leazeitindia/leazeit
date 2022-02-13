package in.leazeit.repository;

import in.leazeit.entity.OwnerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerDetailsRepository extends JpaRepository<OwnerDetails, String> {
}
