import org.luaj.vm2_v3_0_1.LuaTable;
import org.luaj.vm2_v3_0_1.LuaValue;
import org.luaj.vm2_v3_0_1.lib.TwoArgFunction;
import org.luaj.vm2_v3_0_1.lib.ZeroArgFunction;

import com.theincgi.advancedMacros.publicInterfaces.LuaPlugin;


//Loader function, must also implement LuaPlugin
public class HelloWorld extends TwoArgFunction implements LuaPlugin{
	
	//This is what you will use with 'require' to load your library
	@Override
	public String getLibraryName() {
		return "helloWorld";
	}
	
	//No arg constructor is implied
	//if you add other contructors include a no arg one as well
	
	@Override 
	public LuaValue call(LuaValue name, LuaValue env) {
		LuaTable lib = new LuaTable();
		lib.set("test", new Test());
		return lib;
	}
	
	
	public static class Test extends ZeroArgFunction {
		@Override
		public LuaValue call() {
			System.out.println("*******************");
			System.out.println("*** Hello world ***");
			System.out.println("*******************");
			return NONE;
		}
	}
	
}
