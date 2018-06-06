import org.luaj.vm2_v3_0_1.LuaTable;
import org.luaj.vm2_v3_0_1.LuaValue;
import org.luaj.vm2_v3_0_1.lib.TwoArgFunction;
import org.luaj.vm2_v3_0_1.lib.ZeroArgFunction;

import com.theincgi.advancedMacros.publicInterfaces.LuaPlugin;

public class HelloWorld extends TwoArgFunction implements LuaPlugin{
	@Override
	public String getLibraryName() {
		return "helloWorld";
	}
	
	public HelloWorld() {
	}
	
	@Override
	public LuaValue call(LuaValue arg1, LuaValue arg2) {
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
