package com.agencyplatform.springboot.domain.membership;

import lombok.*;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@Data
public class FeePK implements Serializable {
    private String classify_t;
    private String classify_m;
    private int term;

    @Builder
    public FeePK(String classify_t, String classify_m, int term) {
        this.classify_t = classify_t;
        this.classify_m = classify_m;
        this.term = term;
    }
}
