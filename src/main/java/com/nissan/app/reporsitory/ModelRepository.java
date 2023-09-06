/**
 * 
 */
package com.nissan.app.reporsitory;

/**
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nissan.app.model.VehicleModel;

@Repository
public interface ModelRepository extends JpaRepository<VehicleModel, Long> {

}
