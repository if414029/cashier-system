package persistance.gateway.paymentType;

import persistance.entity.Item;
import persistance.entity.PaymentType;

import java.util.List;

public class PaymentTypeJPAGateway implements PaymentTypeGateway{
    @Override
    public List<PaymentType> findAll() {
        return null;
    }

    @Override
    public PaymentType findPaymentTypeByCode(String paymentTypeCode) {
        return null;
    }

    @Override
    public void createPaymentType(PaymentType paymentType) {

    }
}
