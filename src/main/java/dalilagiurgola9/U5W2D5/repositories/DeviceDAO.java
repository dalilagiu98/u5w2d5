package dalilagiurgola9.U5W2D5.repositories;

import dalilagiurgola9.U5W2D5.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDAO extends JpaRepository<Device, Long> {
}
