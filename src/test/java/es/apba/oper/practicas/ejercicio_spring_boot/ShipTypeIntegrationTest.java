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
public class ShipTypeIntegrationTest {

    private final String JSON = "{\"shipTypeCode\":\"cargoship\", \"description\":\"Cargo Ship\", \"version\":1}";

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void postShipTypeTest() throws Exception {
        mockMvc.perform(post("/shipTypes").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.description").value("Cargo Ship"));
    }

    @Test
    public void getShipTypeTest() throws Exception {
        mockMvc.perform(get("/shipTypes/bigferry"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Big Ferry"));
    }

    @Test
    public void updateShipTypeTest() throws Exception {
        mockMvc.perform(put("/shipTypes/normalferry").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content("{\"shipTypeCode\":\"normalferry\", \"description\":\"Normal Ferry\", \"version\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.description").value("Normal Ferry"));
    }

    @Test
    public void deleteShipTypeTest() throws Exception {
        mockMvc.perform(delete("/shipTypes/smallferry"))
                .andExpect(status().isNoContent());
    }
}
