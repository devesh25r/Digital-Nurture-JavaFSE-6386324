package in.cognizant;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class InteractionVerificationTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }
}

