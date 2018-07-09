package summarizator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SummarizeController.class, Summarize.class})
@WebAppConfiguration
public class SummarizeControllerTest {

    @Mock
    private Summarize summarize;

    @Autowired
    private SummarizeController summarizeController;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testRestSummarizer() throws Exception {

        MockHttpServletResponse response = mvc.perform(
                get("/api/summarizer?intOne=3&intTwo=2").accept(MediaType.ALL))
                .andReturn().getResponse();
        System.out.println("RESPONSE "+response.getContentAsString());
        assertThat(response.getContentAsString()).isEqualTo("5");

    }
}
