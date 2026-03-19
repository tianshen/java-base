package voox;

import lombok.Data;

import java.io.Serializable;

@Data
public class VooxCompleteParam implements Serializable {

    /**
         * xme用户id
     */
    private String xmeUid;
    
    /**
     * voox的唯一标识
     */
    private String vooxUid;

    /**
     * token 
     */
    private String token;

    /**
     * 时间戳
     */
    private Long timestamp;
}