import me.carlosribeiro.factory_boy.BaseFactory;
import me.carlosribeiro.factory_boy.FactoryBoy;
import me.carlosribeiro.factory_boy.FactoryBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

class SampleClass {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class SampleClassFactory extends BaseFactory {

    @Override
    public FactoryBuilder buildFactory(FactoryBuilder builder) {
        return builder.forClass(SampleClass.class)
                       .withAttribute("name", "Sample Name");
    }
}

public class FactoryBoyTest {
    @Test
    public void createWithDefaultValues() {
        SampleClass model = FactoryBoy.create(new SampleClass(), new SampleClassFactory());
        assertEquals("Sample Name", model.getName());
    }
}