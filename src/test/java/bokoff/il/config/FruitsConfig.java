package bokoff.il.config;

import java.util.List;
import org.aeonbits.owner.Config;

public interface FruitsConfig extends Config {

  @Key("array")
  String [] getFruitsArray();

  @Key("list")
  List<String> getFruitsList();

  @Key("default")
  @DefaultValue("apple,banana")
  List<String> getFruitsListDefault();

  @Key("separator")
  @Separator(";")
  List<String> getFruitsListSeparartor();
}
