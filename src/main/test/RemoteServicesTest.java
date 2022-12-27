import com.x674.currencygif.CurrencygifApplication;
import com.x674.currencygif.currency.CurrencyClient;
import com.x674.currencygif.currency.model.Currency;
import com.x674.currencygif.gif.GIFClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CurrencygifApplication.class)
@AutoConfigureMockMvc
public class RemoteServicesTest {
    @MockBean
    CurrencyClient currencyClient;
    @MockBean
    GIFClient gifClient;

    @Value("${application.api.currency.AppID}")
    private String exchangeAppID;
    @Value("${application.api.giphy.AppID}")
    private String giphyAppID;

    @Test
    void GetCurrencyTest() {
        when(currencyClient.GetCurrencyByDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE), exchangeAppID, "RUB")).thenReturn(new Currency());
        //Currency currentCurrency = currencyClient.GetCurrencyByDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE), exchangeAppID, "RUB");


    }
}
