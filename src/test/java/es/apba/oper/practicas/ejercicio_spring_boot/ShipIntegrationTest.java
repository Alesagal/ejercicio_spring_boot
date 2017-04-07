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
public class ShipIntegrationTest {

    private final String JSON = "{\"imoCode\":\"0000004\", \"name\":\"Emma\", \"grossTons\":10000, \"dateBuilt\":\"2015-05-04\", \"flag\":\"countries/es\", \"type\":\"shipTypes/containership\", \"version\":1}";

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void postShipTest() throws Exception {
        mockMvc.perform(post("/ships").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.imoCode").value(0000004))
                .andExpect(jsonPath("$.name").value("Emma"))
                .andExpect(jsonPath("$.grossTons").value(10000));

    }

    @Test
    public void getShipTest() throws Exception {
        mockMvc.perform(get("/ships/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imoCode").value(0000001))
                .andExpect(jsonPath("$.name").value("Eleonora"))
                .andExpect(jsonPath("$.grossTons").value(10000));
    }

    @Test
    public void updateShipTest() throws Exception {
        mockMvc.perform(put("/ships/2" ).accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"imoCode\":\"0000002\", \"name\":\"Elly\", \"grossTons\":10000, \"dateBuilt\":\"2015-05-04\", \"flag\":\"countries/ES\", \"type\":\"shipTypes/containership\", \"version\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.imoCode").value(0000002))
                .andExpect(jsonPath("$.name").value("Elly"))
                .andExpect(jsonPath("$.grossTons").value(10000));
    }

    @Test
    public void deleteShipTest() throws Exception {
        mockMvc.perform(delete("/ships/3"))
                .andExpect(status().isNoContent());
    }
}
