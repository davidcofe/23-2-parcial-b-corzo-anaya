package co.edu.unisabana.parcialarquitectura.unit;

import co.edu.unisabana.parcialarquitectura.controller.dto.CheckpointDTO;
import co.edu.unisabana.parcialarquitectura.repository.CheckpointPort;
import co.edu.unisabana.parcialarquitectura.service.CheckpointService;
import co.edu.unisabana.parcialarquitectura.service.model.Checkout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CheckpointServiceTest {

    @Mock
    CheckpointPort checkpointPort;

    @InjectMocks
    CheckpointService checkpointService;

    @Test public void checkoutTest(){
        CheckpointDTO dto = new CheckpointDTO("TestFacility", "TestDriver", 1);
        Mockito.when(checkpointPort.findLastCheckin(dto.driver, dto.facility)).thenReturn(null);
        Checkout checkout = new Checkout(dto.facility, dto.driver, dto.dayOfMonth);

        checkpointService.checkout(dto);
        checkpointPort.findLastCheckin(dto.driver, dto.facility);
        Mockito.verify(checkpointPort).findLastCheckin(dto.driver, dto.facility);
        Mockito.verify(checkpointPort).saveCheckout(checkout);
    }
}
