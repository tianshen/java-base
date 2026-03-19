package voox;

import lombok.Data;

import java.io.Serializable;

@Data
public class VooxVerifyTokenParam implements Serializable {

    /**
     * token
     */
    private String token;

    /**
     * 时间戳
     */
    private Long timestamp;
}
