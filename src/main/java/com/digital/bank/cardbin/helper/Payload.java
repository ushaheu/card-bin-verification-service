package com.digital.bank.cardbin.helper;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author ushaheu
 * @date 8/27/20 1:55 AM
 * @project card-bin-verification
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
@JsonRootName("number")
public class Payload {

    private String scheme;
    private String type;
    private String bank;
    private Long cardBin;
}
