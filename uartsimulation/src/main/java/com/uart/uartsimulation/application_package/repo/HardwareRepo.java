package com.uart.uartsimulation.application_package.repo;

import com.uart.uartsimulation.application_package.entity.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareRepo extends JpaRepository<Hardware, Long> {}
