package tsg.net.vn.hrmweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tsg.net.vn.hrmweb.model.Position;


@Repository
public interface PositionRepositoty extends JpaRepository<Position, Long>{
	@Query(value="select * from position", nativeQuery = true)
	List<Position> getAllPosition();
}
