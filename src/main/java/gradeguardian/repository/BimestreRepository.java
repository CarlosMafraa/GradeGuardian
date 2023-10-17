package gradeguardian.repository;

import gradeguardian.model.Bimestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BimestreRepository extends JpaRepository<Bimestre, Long> {
}
