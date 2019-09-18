package guru.springframework.spring5restweb.api.vi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private Long id;
    @ApiModelProperty(value = "This is customer's first name", required = true)
    private String firstName;
    private String lastName;

    @JsonProperty("customer_url")
    private String customerUrl;

}
