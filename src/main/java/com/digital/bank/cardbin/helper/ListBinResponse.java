package com.digital.bank.cardbin.helper;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author ushaheu
 * @date 8/27/20 7:18 PM
 * @project card-bin-verification-service
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class ListBinResponse {

    private boolean success;
    private int start;
    private int limit;
    private int size;
    private Map<String, Integer> payload;
}
