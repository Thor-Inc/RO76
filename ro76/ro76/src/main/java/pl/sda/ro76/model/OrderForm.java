package pl.sda.ro76.model;


import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {
    private String productName;

    @Min(value = 5, message = "amount has to be at least 5")
    private Integer amount;
}
