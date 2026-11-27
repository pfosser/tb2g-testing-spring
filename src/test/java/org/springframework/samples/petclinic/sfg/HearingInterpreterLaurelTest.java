package org.springframework.samples.petclinic.sfg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = { BaseConfig.class, LaurelConfig.class })
class HearingInterpreterLaurelTest {

	@Autowired
	HearingInterpreter hearingInterpreter;

	@Test
	void testWhatIheard() {
		String word = hearingInterpreter.whatIHeard();

		assertEquals("Laurel", word);
	}

}
