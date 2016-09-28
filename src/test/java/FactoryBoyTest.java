import me.carlosribeiro.factory_boy.BaseFactory;
import me.carlosribeiro.factory_boy.FactoryBoy;
import me.carlosribeiro.factory_boy.FactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

class SampleClass {
  private String name;
  private Integer age;
  private BigDecimal value;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }
}

class SampleClassFactory implements BaseFactory {

  @Override
  public FactoryBuilder buildFactory(FactoryBuilder builder) {
    return builder.forClass(SampleClass.class)
        .withAttribute("name", "Sample Name")
        .withAttribute("age", 20)
        .withAttribute("value", new BigDecimal("80.9768"));
  }
}

@RunWith(JUnit4.class)
public class FactoryBoyTest {
  @Test
  public void createWithDefaultValues() {
    SampleClass model = FactoryBoy.create(new SampleClass(), new SampleClassFactory());
    
    assertEquals("Sample Name", model.getName());
    assertEquals(new Integer(20), model.getAge());
    assertEquals(new BigDecimal("80.9768"), model.getValue());
  }
  
  @Test
  public void createAListWithDefaultValues() {
    List<SampleClass> list = FactoryBoy.createList(new SampleClass(), new SampleClassFactory(), 5);
    assertEquals(5, list.size());
    
    list.forEach(index -> {
      assertEquals("Sample Name", index.getName());
      assertEquals(new Integer(20), index.getAge());
      assertEquals(new BigDecimal("80.9768"), index.getValue());
    });
  }
}