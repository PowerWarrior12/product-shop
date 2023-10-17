package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.common.TestDataGenerator;
import org.example.dto.order.FullOrderDto;
import org.example.dto.product.CreateProductDto;
import org.example.dto.product.FullProductDto;
import org.example.enums.Role;
import org.example.exceptions.GenerateJwtTokenException;
import org.example.security.JwtProvider;
import org.example.testConfiguration.TestConfiguration;
import org.example.services.OrderService;
import org.example.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import static org.example.common.TestDataGenerator.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@ContextConfiguration(classes = TestConfiguration.class)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private OrderService orderService;
    @MockBean
    private ProductService productService;
    @Autowired
    private JwtProvider jwtProvider;
    @Value("${jwt.header}")
    String jwtHeader;
    private static final Collection<FullOrderDto> fullOrders = TestDataGenerator.generateFullOrders();
    private String jwtToken;

    @BeforeEach
    void setUp() throws GenerateJwtTokenException {
        jwtToken = jwtProvider.generateToken(new UsernamePasswordAuthenticationToken("test@mail.ru", "1234567", List.of(
                new SimpleGrantedAuthority(Role.ROLE_ADMIN.name())
        )));
    }

    @Test
    @DisplayName("[200] GET /admin/orders - get all orders")
    void getAllOrders() throws Exception {
        when(orderService.loadAllOrders()).thenReturn(fullOrders);
        mockMvc.perform(get("/admin/orders")
                        .header(jwtHeader, jwtToken)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*].order_code").value(TEST_UUID.toString()))
                .andExpect(jsonPath("$.[*].date").value(TEST_DATE.toString()))
                .andExpect(jsonPath("$.[*].items[*].product_name").value(TEST_PRODUCT_NAME))
                .andExpect(jsonPath("$.[*].items[*].count").value(TEST_PRODUCT_COUNT))
                .andExpect(jsonPath("$.[*].user_login").value(TEST_EMAIL));
    }

    @Test
    @DisplayName("[200] GET /admin/products/add - create product")
    void createProduct() throws Exception {
        CreateProductDto createProductDto = TestDataGenerator.generateCreateProductDto();
        FullProductDto productDto = TestDataGenerator.generateFullProductDto("http://localhost:8080");

        when(productService.createProduct(any(CreateProductDto.class), any(MultipartFile.class))).thenReturn(productDto);

        File file = ResourceUtils.getFile("classpath:picture.png");
        FileInputStream inputStream = new FileInputStream(file);
        MockMultipartFile pictureFile = new MockMultipartFile(
                "picture",
                String.format("%s.%s", TEST_FILE_NAME, TEST_FILE_EXTENSION),
                MediaType.MULTIPART_FORM_DATA_VALUE, inputStream);
        MockMultipartFile jsonFile = new MockMultipartFile("product", "", MediaType.APPLICATION_JSON_VALUE, mapper.writeValueAsString(createProductDto).getBytes());
        mockMvc.perform(multipart("/admin/products/add")
                        .file(pictureFile)
                        .file(jsonFile)
                        .header(jwtHeader, jwtToken)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.product_name").value(TEST_PRODUCT_NAME))
                .andExpect(jsonPath("$.for_adults").value(TEST_FOR_ADULTS))
                .andExpect(jsonPath("$.is_stock").value(TEST_IS_STOCK))
                .andExpect(jsonPath("$.price").value(TEST_PRICE))
                .andExpect(jsonPath("$.picture").value(productDto.getPictureHref()))
                .andExpect(jsonPath("$.category_name").value(TEST_CATEGORY_NAME))
                .andExpect(jsonPath("$.brand_name").value(TEST_BRAND_NAME))
                .andExpect(jsonPath("$.producer_name").value(TEST_PRODUCER_NAME))
                .andExpect(jsonPath("$.calories").value(TEST_CALORIES))
                .andExpect(jsonPath("$.proteins").value(TEST_PROTEINS))
                .andExpect(jsonPath("$.fats").value(TEST_FATS))
                .andExpect(jsonPath("$.description").value(TEST_DESCRIPTION))
                .andExpect(jsonPath("$.carbohydrates").value(TEST_CARBOHYDRATES))
                .andExpect(jsonPath("$.offer.new_price").value(TEST_PRICE));
    }
}