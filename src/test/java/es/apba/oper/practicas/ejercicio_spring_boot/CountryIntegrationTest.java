package es.apba.oper.practicas.ejercicio_spring_boot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EjercicioSpringBootApplication.class})
@WebAppConfiguration
public class CountryIntegrationTest {

    private final String JSON = "{\"isoCode\":\"jp\", \"name\":\"japan\", \"version\":1}";

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void postCountryTest() throws Exception {
        mockMvc.perform(post("/countries").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.name").value("japan"));
    }

    @Test
    public void getCountryTest() throws Exception {
        mockMvc.perform(get("/countries/es"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Spain"));

    }

    @Test
    public void updateCountryTest() throws Exception {
        mockMvc.perform(put("/countries/us").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"isoCode\":\"us\", \"name\":\"United States\", \"version\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.name").value("United States"));
    }

    @Test
    public void deleteCountryTest() throws Exception {
        postCountryTest();

        mockMvc.perform(delete("/countries/uk"))
                .andExpect(status().isNoContent());
    }
}
