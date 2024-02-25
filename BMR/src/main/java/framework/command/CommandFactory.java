package framework.command;

import framework.context.RequestContext;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;
public class CommandFactory {
    public static AbstractCommand getCommand(RequestContext rc) {
        AbstractCommand command = null;
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("/Users/imseoghyeon/Desktop/Project1/BMR/src/properties/commands.properties"));
			String name = prop.getProperty(rc.getCommandPath());
            Class c = Class.forName(name);
            command = (AbstractCommand) c.newInstance();
        }catch (ClassNotFoundException |IOException e) {
			e.printStackTrace();
			command = null;
		} catch (InstantiationException e) {
			e.printStackTrace();
			command = null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			command = null;
		} finally {
			return command;
		}
    }
}
