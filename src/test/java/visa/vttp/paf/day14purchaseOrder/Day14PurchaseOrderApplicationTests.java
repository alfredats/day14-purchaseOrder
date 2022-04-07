package visa.vttp.paf.day14purchaseOrder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import visa.vttp.paf.day14purchaseOrder.repo.KwikmartRepo;


@SpringBootTest
class Day14PurchaseOrderApplicationTests {

	@Autowired
	private KwikmartRepo kRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void hasSKU_noSuchSKU() {
		assertFalse(kRepo.hasSKU(9999));
	}

	@Test 
	void hasSKU_skuExists() {
		assertTrue(kRepo.hasSKU(2));
	}

}
