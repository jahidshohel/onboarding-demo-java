package com.eng.onboarding.te.manager;

import com.eng.onboarding.te.domain.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ShopRepository extends CrudRepository<Shop, Long> {
}
