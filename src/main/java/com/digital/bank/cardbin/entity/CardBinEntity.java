package com.digital.bank.cardbin.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * @author ushaheu
 * @date 8/27/20 11:14 AM
 * @project card-bin-verification
 */
@RedisHash(value = "utils_hash")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CardBinEntity {

    @Id
    private Long cardBin;
    private int hitCount;
    private String scheme;
    private String type;
    private String bank;
}
