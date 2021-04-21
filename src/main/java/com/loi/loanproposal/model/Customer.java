package com.loi.loanproposal.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Loi Nguyen
 *
 */
@Component("customer")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
    private String code;
    private String name;
    private String phoneNumber;
    private String address;
    private CustomerType type;

    @Override
    public int hashCode() {
        return Objects.hash(this.code);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof Customer))
            return false;

        Customer that = (Customer) other;
        return Objects.equals(that.code, this.code);
    }
}
