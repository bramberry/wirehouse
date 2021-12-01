package by.itrex.wirehouse.repository.impl;

import by.itrex.wirehouse.dto.DistanceUnit;
import by.itrex.wirehouse.repository.DistanceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DistanceRepositoryImpl implements DistanceRepository {

  private static List<DistanceUnit> distances = new ArrayList<>();

  @Override
  public void save(DistanceUnit distanceUnit) {
    distances.add(distanceUnit);
  }

  @Override
  public DistanceUnit getById(Long customerId, Long warehouseId) {
    return distances.stream()
        .filter(distanceUnit ->
            distanceUnit.getCustomerId().equals(customerId)
                && distanceUnit.getWarehouseId().equals(warehouseId))
        .findFirst()
        .orElseThrow();
  }

  @Override
  public List<DistanceUnit> getAll() {
    return distances;
  }
}
