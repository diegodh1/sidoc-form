package co.integrapps.services.adapters.persistence;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class CientificNotationDoubleMapper extends JsonSerializer<Double> {
    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        BigDecimal d = new BigDecimal(value);
        gen.writeNumber(d.toPlainString());
    }
}
