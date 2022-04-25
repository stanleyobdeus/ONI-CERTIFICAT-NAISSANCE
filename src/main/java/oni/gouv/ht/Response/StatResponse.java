package oni.gouv.ht.Response;

import lombok.Data;

@Data
public class StatResponse {
    private Long qtApp;
    private Long qtInst;
    private Long qtReq;
    private double qtPrice;

    public StatResponse(Long qtApp, Long qtInst, Long qtReq, double qtPrice) {
        this.qtApp = qtApp;
        this.qtInst = qtInst;
        this.qtReq = qtReq;
        this.qtPrice = qtPrice;
    }

    public StatResponse() {
    }
}
