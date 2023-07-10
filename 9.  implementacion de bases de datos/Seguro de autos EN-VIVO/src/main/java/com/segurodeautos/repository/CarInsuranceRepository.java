package com.segurodeautos.repository;

import com.segurodeautos.dto.response.LicenseBrandDTO;
import com.segurodeautos.dto.response.LicenseBrandModelDTO;
import com.segurodeautos.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface CarInsuranceRepository extends JpaRepository<Car,Long> {

    @Query("select c.licensePlate from Car c")
    List<String> getAllLicensesPlate();

    @Query("select c.licensePlate, c.carBrand from Car c order by c.manufactureYear asc")
    List<Object> getAllLicensePlatAndBrandOrderByYear();

    @Query("select c.licensePlate from Car c where c.numWheels = 4 " +
            "and year(c.manufactureYear) >= :year")
    List<String> getAllLicensePlateWhere4WheelsAnThisYear(@Param("year") int year);

    @Query("SELECT c.licensePlate, c.carBrand, c.model FROM Car c INNER JOIN c.accidents AS a WHERE a.economicLost >= 10000")
    List<Object> getLicenseAndBrandAndModelAccidentGreater10000();

    @Query("SELECT SUM(a.economicLost) FROM Car c INNER JOIN c.accidents AS a WHERE" +
            " a.economicLost >= 10000")
    Object getLicenseAndBrandAndModelAccidentGreater10000Sum();
}
