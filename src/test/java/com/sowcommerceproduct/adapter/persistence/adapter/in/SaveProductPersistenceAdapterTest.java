package com.sowcommerceproduct.adapter.persistence.adapter.in;

import com.sowcommerceproduct.Helper;
import com.sowcommerceproduct.adapter.messaging.listener.SQSListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SaveProductPersistenceAdapterTest {

    @MockBean
    private SqsAsyncClient sqsAsyncClient;

    @MockBean
    private SQSListener sqsListener;

    @Autowired
    private SaveProductPersistenceAdapter saveProductPersistenceAdapter;

    @Test
    @DisplayName("When saving product then should return saved product")
    void whenSavingProductThenShouldReturnSavedProduct() {
        var product = Helper.buildProduct(null);
        product.getCategory().setId(null);

        var savedProduct = saveProductPersistenceAdapter.save(product);

        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo(product.getName());
        assertThat(savedProduct.getDescription()).isEqualTo(product.getDescription());
        assertThat(savedProduct.getPrice()).isEqualTo(product.getPrice());
        assertThat(savedProduct.getAmountInStock()).isEqualTo(product.getAmountInStock());
        assertThat(savedProduct.getCreatedDate()).isNotNull();
        assertThat(savedProduct.getUpdatedDate()).isNotNull();
        assertThat(savedProduct.getCategory()).isNotNull();
        assertThat(savedProduct.getCategory().getId()).isNotNull();
    }
}
