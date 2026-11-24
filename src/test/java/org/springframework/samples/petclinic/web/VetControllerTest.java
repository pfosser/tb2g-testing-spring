package org.springframework.samples.petclinic.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {
	
	@Mock
	ClinicService clinicService;
	
	@Mock
	Map<String, Object> model;
	
	@InjectMocks
	VetController controller;

	List<Vet> vetList;

	@BeforeEach
	void setUp() throws Exception {
		vetList.add(new Vet());
		
		given(clinicService.findVets()).willReturn(vetList);
	}

	@Test
	void testShowVetList() {
		// when
		String view = controller.showVetList(model);

		// then
		then(clinicService).should().findVets();
		then(model).should().put(anyString(), any());
		assertThat(view).isEqualToIgnoringCase("vets/VetList");
	}

	@Test
	void testShowResourcesVetList() {
		// when
		Vets vets = controller.showResourcesVetList();

		// then
		then(clinicService).should().findVets();
		assertThat(vets.getVetList()).hasSize(1);
	}

}
