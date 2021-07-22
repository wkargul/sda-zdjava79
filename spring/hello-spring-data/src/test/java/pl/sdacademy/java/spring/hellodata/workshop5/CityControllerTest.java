package pl.sdacademy.java.spring.hellodata.workshop5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CityController.class)
class CityControllerTest {

    @MockBean
    private CityService cityService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCity() throws Exception {

        //GIVEN
        final City city = new City();
        city.setId(5L);
        city.setName("Warszawa");

        when(cityService.getCity(5)).thenReturn(Optional.of(city));

        //WHEN
        ResultActions ra = mockMvc.perform(get("/cities/5"));

        //THEN

        //ra.andReturn().getResponse().getContentAsString()

        ra
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(5))
            .andExpect(jsonPath("$.name").value("Warszawa"));
    }
}
